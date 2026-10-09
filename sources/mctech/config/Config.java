package mctech.config;

import it.unimi.dsi.fastutil.objects.Object2ObjectLinkedOpenHashMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectMaps;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import mctech.config.utils.Helpers;
import mctech.config.utils.MultilinePolicy;
import mctech.config.utils.SyncType;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/config/Config.class */
public class Config {
    private String name;
    private Object2ObjectMap<String, ConfigSection> sections = new Object2ObjectLinkedOpenHashMap();

    public Config(String str) {
        if (Helpers.validateString(str)) {
            throw new IllegalArgumentException("Config name must not be null, empty or start/end with white spaces");
        }
        this.name = str;
    }

    public ConfigSection add(ConfigSection configSection) {
        if (configSection.getParent() != null) {
            throw new IllegalStateException("ConfigSection must not be added to multiple sections. Section: " + configSection.getName());
        }
        this.sections.putIfAbsent(configSection.getName(), configSection);
        return configSection;
    }

    public ConfigSection add(String str) {
        return ((ConfigSection) this.sections.computeIfAbsent(str, ConfigSection::new)).setUsed();
    }

    public ConfigSection getSection(String str) {
        return (ConfigSection) this.sections.get(str);
    }

    ConfigSection getSectionRecursive(String[] strArr) {
        if (strArr.length == 0) {
            return null;
        }
        ConfigSection subSection = (ConfigSection) this.sections.computeIfAbsent(strArr[0], ConfigSection::new);
        for (int i = 1; i < strArr.length && subSection != null; i++) {
            subSection = subSection.parseSubSection(strArr[i]);
        }
        return subSection;
    }

    public List<ConfigSection> getChildren() {
        return new ObjectArrayList(this.sections.values());
    }

    public Map<String, ConfigEntry<?>> getSyncedEntries(SyncType syncType) {
        if (syncType == SyncType.NONE) {
            return Collections.emptyMap();
        }
        Map<String, ConfigEntry<?>> object2ObjectLinkedOpenHashMap = new Object2ObjectLinkedOpenHashMap<>();
        ObjectIterator it = this.sections.values().iterator();
        while (it.hasNext()) {
            ((ConfigSection) it.next()).getSyncedEntries(object2ObjectLinkedOpenHashMap, syncType);
        }
        return object2ObjectLinkedOpenHashMap;
    }

    public String getName() {
        return this.name;
    }

    public Config copy() {
        Config config = new Config(this.name);
        ObjectIterator it = this.sections.values().iterator();
        while (it.hasNext()) {
            config.add(((ConfigSection) it.next()).copy());
        }
        return config;
    }

    public void resetDefault() {
        this.sections.values().forEach((v0) -> {
            v0.resetDefault();
        });
    }

    public boolean hasChanged() {
        ObjectIterator it = this.sections.values().iterator();
        while (it.hasNext()) {
            if (((ConfigSection) it.next()).hasChanged()) {
                return true;
            }
        }
        return false;
    }

    public boolean isDefault() {
        ObjectIterator it = this.sections.values().iterator();
        while (it.hasNext()) {
            if (!((ConfigSection) it.next()).isDefault()) {
                return false;
            }
        }
        return true;
    }

    public String serialize(MultilinePolicy multilinePolicy) {
        if (this.sections.size() == 0) {
            return "";
        }
        StringJoiner stringJoiner = new StringJoiner("\n\n");
        Object2ObjectMaps.fastForEach(this.sections, entry -> {
            String strSerialize = ((ConfigSection) entry.getValue()).serialize(multilinePolicy);
            if (strSerialize != null) {
                stringJoiner.add(strSerialize);
            }
        });
        return stringJoiner.toString();
    }
}
