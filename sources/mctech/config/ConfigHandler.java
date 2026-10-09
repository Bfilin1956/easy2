package mctech.config;

import it.unimi.dsi.fastutil.chars.Char2ObjectMap;
import it.unimi.dsi.fastutil.chars.Char2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import mctech.api.ConfigType;
import mctech.api.IConfigProxy;
import mctech.api.ILogger;
import mctech.config.utils.AutomationType;
import mctech.config.utils.Helpers;
import mctech.config.utils.MultilinePolicy;
import mctech.config.utils.ParseExpection;
import mctech.config.utils.ParseResult;
import mctech.o.i;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/config/ConfigHandler.class */
public final class ConfigHandler {
    private Path cfgDir;
    private Path configFile;
    private boolean isLoaded;
    private boolean registered;
    private int wasSaving;
    private final String subFolder;
    private final Config config;
    private final EnumSet<AutomationType> setting;
    private final MultilinePolicy policy;
    public final ConfigType type;
    private final List<ConfigError> errors;
    private final IConfigProxy proxy;
    private final ILogger logger;
    private FileSystemWatcher owner;
    private List<Runnable> loadedListeners;
    private Char2ObjectMap<IConfigParser> parsers;

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/config/ConfigHandler$IConfigParser.class */
    @FunctionalInterface
    public interface IConfigParser {
        ParseResult<? extends ConfigEntry<?>> parse(String str, String str2, String[] strArr);
    }

    ConfigHandler(Config config, ConfigSettings configSettings) {
        this(configSettings.getSubFolder(), configSettings.getProxy(), configSettings.getLogger(), config, configSettings.getAutomationType(), configSettings.getMultilinePolicy(), configSettings.getType());
    }

    ConfigHandler(String str, IConfigProxy iConfigProxy, ILogger iLogger, Config config, EnumSet<AutomationType> enumSet, MultilinePolicy multilinePolicy, ConfigType configType) {
        this.wasSaving = 0;
        this.errors = new ObjectArrayList();
        this.loadedListeners = new ObjectArrayList();
        this.parsers = new Char2ObjectOpenHashMap();
        this.config = config;
        String strReplace = str.trim().replace("\\\\", "/").replace("\\", "/");
        this.subFolder = strReplace.endsWith("/") ? strReplace.substring(0, strReplace.length() - 1) : strReplace;
        this.logger = iLogger;
        this.policy = multilinePolicy;
        this.setting = enumSet;
        this.proxy = iConfigProxy;
        this.type = configType;
        this.parsers.put('I', ConfigEntry.IntValue::parse);
        this.parsers.put('D', ConfigEntry.DoubleValue::parse);
        this.parsers.put('B', ConfigEntry.BoolValue::parse);
        this.parsers.put('S', ConfigEntry.StringValue::parse);
        this.parsers.put('A', ConfigEntry.ArrayValue::parse);
        this.parsers.put('E', ConfigEntry.StringValue::parse);
        this.parsers.put('p', ConfigEntry.StringValue::parse);
        this.parsers.put('P', ConfigEntry.StringValue::parse);
    }

    ConfigHandler setOwner(FileSystemWatcher fileSystemWatcher) {
        this.owner = fileSystemWatcher;
        if (fileSystemWatcher != null) {
            fileSystemWatcher.onConfigCreated(this);
        }
        return this;
    }

    public void addTempParser(char c) {
        addParser(c, ConfigEntry.StringValue::parse);
    }

    public void addParser(char c, IConfigParser iConfigParser) {
        if ((c < 'A' || c > 'Z') && (c < 'a' || c > 'z')) {
            throw new IllegalArgumentException("Character must be [a-zA-Z]");
        }
        this.parsers.putIfAbsent(c, iConfigParser);
    }

    public IConfigProxy getProxy() {
        return this.proxy;
    }

    public ConfigType getConfigType() {
        return this.type;
    }

    public MultilinePolicy getMultilinePolicy() {
        return this.policy;
    }

    public Config getConfig() {
        return this.config;
    }

    public String getSubFolder() {
        return this.subFolder;
    }

    public Path createConfigFile(Path path) {
        return (this.subFolder.isEmpty() ? path : path.resolve(this.subFolder)).resolve(this.config.getName().concat(".cfg"));
    }

    public boolean isLoaded() {
        return this.isLoaded;
    }

    public boolean isRegistered() {
        return this.registered;
    }

    public Path getCfgDir() {
        return this.cfgDir;
    }

    public Path getConfigFile() {
        return this.configFile;
    }

    public String getConfigIdentifer() {
        return this.subFolder + "/" + this.config.getName();
    }

    public boolean hasErrors() {
        return this.errors.size() > 0;
    }

    public List<ConfigError> getErrors() {
        return this.errors;
    }

    public void register() {
        if (this.owner != null) {
            this.owner.registerConfigHandler(this);
            this.registered = true;
            if (!this.proxy.isDynamicProxy() && this.setting.contains(AutomationType.AUTO_LOAD)) {
                load();
            }
        }
    }

    public void load() {
        findConfigFile();
        if (this.owner != null) {
            if (this.setting.contains(AutomationType.AUTO_SYNC)) {
                this.owner.registerSyncHandler(this);
            }
            if (this.setting.contains(AutomationType.AUTO_RELOAD)) {
                this.owner.registerReloadHandler(this.configFile, this);
            }
        }
        if (loadInternally()) {
            save();
        }
        this.isLoaded = true;
    }

    public boolean reload() {
        if (!this.isLoaded) {
            return false;
        }
        if (this.wasSaving > 0) {
            this.wasSaving--;
            return false;
        }
        loadInternally();
        return true;
    }

    public void unload() {
        this.isLoaded = false;
        if (this.owner != null && this.setting.contains(AutomationType.AUTO_RELOAD)) {
            this.owner.unregisterReloadHandler(this.configFile);
        }
    }

    private void findConfigFile() {
        List<Path> basePaths = this.proxy.getBasePaths();
        if (basePaths.isEmpty()) {
            throw new IllegalStateException("Proxy has no Folders");
        }
        if (basePaths.size() == 1) {
            this.configFile = createConfigFile(basePaths.get(0));
            Path parent = this.configFile.getParent();
            this.cfgDir = parent;
            Helpers.ensureFolder(parent);
            return;
        }
        int size = basePaths.size() - 1;
        for (int i = size; i >= 0; i--) {
            Path pathCreateConfigFile = createConfigFile(basePaths.get(i));
            if (Files.notExists(pathCreateConfigFile, new LinkOption[0])) {
                if (i == size) {
                    save(pathCreateConfigFile);
                } else {
                    Helpers.copyFile(createConfigFile(basePaths.get(i + 1)), pathCreateConfigFile);
                }
            }
        }
        this.configFile = createConfigFile(basePaths.get(0));
        this.cfgDir = this.configFile.getParent();
    }

    public void addLoadedListener(Runnable runnable) {
        this.loadedListeners.add(runnable);
    }

    public void onSynced() {
        Iterator<Runnable> it = this.loadedListeners.iterator();
        while (it.hasNext()) {
            it.next().run();
        }
    }

    private int handleEntry(ConfigSection configSection, List<String> list, int i, String str, String[] strArr, boolean z) {
        if (configSection == null) {
            this.logger.error("config entry not in section: {}", str);
            return 0;
        }
        String[] strArrTrimArray = Helpers.trimArray(str.split("[:=]", 3));
        if (strArrTrimArray.length != 3) {
            this.logger.error("invalid config entry: {}", str);
            return 0;
        }
        int iFindString = 0;
        if (strArrTrimArray[2].length() > 0 && strArrTrimArray[2].charAt(0) == '<') {
            if (strArrTrimArray[2].endsWith(">")) {
                strArrTrimArray[2] = strArrTrimArray[2].substring(1, strArrTrimArray[2].length() - 1);
            } else {
                StringBuilder sb = new StringBuilder();
                iFindString = 0 + findString(strArrTrimArray[2], list, i, sb);
                strArrTrimArray[2] = sb.toString();
            }
        }
        try {
            ConfigEntry<?> entry = configSection.getEntry(strArrTrimArray[1]);
            if (entry == null) {
                IConfigParser iConfigParser = (IConfigParser) this.parsers.get(str.charAt(0));
                if (iConfigParser == null) {
                    this.logger.warn("config entry is not registered and no parser found: {}", str);
                    return iFindString;
                }
                ParseResult<? extends ConfigEntry<?>> parseResult = iConfigParser.parse(strArrTrimArray[1], strArrTrimArray[2], strArr);
                ConfigEntry<?> value = parseResult.getValue();
                configSection.addParsed(value);
                if (parseResult.hasError() && z) {
                    this.logger.warn("couldn't parse value: {}", parseResult.getValue());
                    this.errors.add(new ConfigError(this, value, parseResult.getError()));
                }
                return iFindString;
            }
            entry.parseComment(strArr);
            if (str.charAt(0) == entry.getPrefix()) {
                ParseResult<String> parseResultDeserializeValue = entry.deserializeValue(strArrTrimArray[2]);
                if (parseResultDeserializeValue.hasError() && z) {
                    this.logger.warn("couldn't parse value: {}", parseResultDeserializeValue.getValue());
                    this.errors.add(new ConfigError(this, entry, parseResultDeserializeValue.getError()));
                }
            } else {
                this.logger.warn("config entry has wrong type: {}", str);
            }
            return iFindString;
        } catch (Throwable th) {
            this.logger.error("Crash during parsing. THIS SHOULD NEVER HAPPEN!", th);
        }
    }

    private int findString(String str, List<String> list, int i, StringBuilder sb) {
        sb.append(str.substring(1));
        int i2 = 0;
        while (i + 1 < list.size()) {
            i++;
            i2++;
            String strTrim = list.get(i).trim();
            if (strTrim.endsWith(">")) {
                sb.append(strTrim.substring(0, strTrim.length() - 1));
                break;
            }
            if (strTrim.length() > 1 && strTrim.charAt(1) == ':' && this.parsers.containsKey(strTrim.charAt(0))) {
                i2--;
                break;
            }
            if (!strTrim.isEmpty()) {
                sb.append(strTrim);
            }
        }
        return i2;
    }

    private boolean loadInternally() {
        if (Files.notExists(this.configFile, new LinkOption[0])) {
            return true;
        }
        try {
            this.errors.clear();
            load(this, this.config, Files.readAllLines(this.configFile), true);
            Iterator<Runnable> it = this.loadedListeners.iterator();
            while (it.hasNext()) {
                it.next().run();
            }
            if (this.errors.size() > 0 && this.owner != null) {
                this.owner.onConfigErrored(this);
                return true;
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean load(ConfigHandler configHandler, Config config, List<String> list, boolean z) {
        ConfigSection sectionRecursive = null;
        ObjectArrayList objectArrayList = new ObjectArrayList();
        int iHandleEntry = 0;
        int size = list.size();
        while (iHandleEntry < size) {
            String strTrim = list.get(iHandleEntry).trim();
            if (strTrim.length() != 0) {
                switch (strTrim.charAt(0)) {
                    case i.d /* 35 */:
                        if (strTrim.charAt(1) != 8203) {
                            objectArrayList.add(strTrim.substring(1).trim());
                        }
                        break;
                    case '[':
                        sectionRecursive = config.getSectionRecursive(strTrim.substring(1, strTrim.length() - 1).split("\\."));
                        sectionRecursive.parseComment((String[]) objectArrayList.toArray(new String[objectArrayList.size()]));
                        objectArrayList.clear();
                        break;
                    default:
                        iHandleEntry += configHandler.handleEntry(sectionRecursive, list, iHandleEntry, strTrim, (String[]) objectArrayList.toArray(new String[objectArrayList.size()]), z);
                        objectArrayList.clear();
                        break;
                }
            }
            iHandleEntry++;
        }
        return true;
    }

    public void save() {
        save(this.configFile);
    }

    private void save(Path path) {
        this.wasSaving++;
        try {
            BufferedWriter bufferedWriterNewBufferedWriter = Files.newBufferedWriter(path, new OpenOption[0]);
            try {
                bufferedWriterNewBufferedWriter.write(this.config.serialize(this.policy));
                if (bufferedWriterNewBufferedWriter != null) {
                    bufferedWriterNewBufferedWriter.close();
                }
            } catch (Throwable th) {
                if (bufferedWriterNewBufferedWriter != null) {
                    try {
                        bufferedWriterNewBufferedWriter.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/config/ConfigHandler$ConfigError.class */
    public class ConfigError {
        ConfigEntry<?> entry;
        ParseExpection error;

        public ConfigError(ConfigHandler configHandler, ConfigEntry<?> configEntry, ParseExpection parseExpection) {
            this.entry = configEntry;
            this.error = parseExpection;
        }

        public ConfigEntry<?> getEntry() {
            return this.entry;
        }

        public ParseExpection getError() {
            return this.error;
        }
    }
}
