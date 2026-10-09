package mctech.config.impl;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Predicate;
import mctech.api.ConfigType;
import mctech.api.IConfigProxy;
import mctech.api.gui.IConfigNode;
import mctech.api.gui.IModConfig;
import mctech.config.Config;
import mctech.config.ConfigHandler;
import net.minecraft.network.FriendlyByteBuf;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/config/impl/ModConfig.class */
public class ModConfig implements IModConfig {
    String modId;
    ConfigHandler handler;
    Config config;
    Path path;

    public ModConfig(String str, ConfigHandler configHandler) {
        this(str, configHandler, configHandler.getConfig(), configHandler.getConfigFile());
    }

    public ModConfig(String str, ConfigHandler configHandler, Config config, Path path) {
        this.modId = str;
        this.handler = configHandler;
        this.config = config;
        this.path = path;
    }

    @Override // mctech.api.gui.IModConfig
    public IModConfig loadFromFile(Path path) {
        if (Files.notExists(path, new LinkOption[0])) {
            return null;
        }
        try {
            ConfigHandler.load(this.handler, this.config.copy(), Files.readAllLines(path), false);
            return new ModConfig(this.modId, this.handler, this.config, path);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // mctech.api.gui.IModConfig
    public IModConfig loadFromNetworking(UUID uuid, Consumer<Predicate<FriendlyByteBuf>> consumer) {
        NetworkModConfig networkModConfig = new NetworkModConfig(this.modId, this.handler, this.config.copy());
        consumer.accept(networkModConfig);
        return networkModConfig;
    }

    @Override // mctech.api.gui.IModConfig
    public String getFileName() {
        return this.handler.getConfig().getName().concat(".cfg");
    }

    @Override // mctech.api.gui.IModConfig
    public String getConfigName() {
        return this.handler.getSubFolder().isEmpty() ? this.handler.getConfig().getName() : this.handler.getConfigIdentifer();
    }

    @Override // mctech.api.gui.IModConfig
    public String getModId() {
        return this.modId;
    }

    @Override // mctech.api.gui.IModConfig
    public boolean isDynamicConfig() {
        return this.handler.getProxy().isDynamicProxy();
    }

    @Override // mctech.api.gui.IModConfig
    public List<IModConfig.IConfigTarget> getPotentialFiles() {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        for (IConfigProxy.IPotentialTarget iPotentialTarget : this.handler.getProxy().getPotentialConfigs()) {
            Path pathCreateConfigFile = this.handler.createConfigFile(iPotentialTarget.getFolder());
            if (!Files.notExists(pathCreateConfigFile, new LinkOption[0])) {
                if (iPotentialTarget instanceof PerWorldProxy.WorldTarget) {
                    objectArrayList.add(new IModConfig.WorldConfigTarget((PerWorldProxy.WorldTarget) iPotentialTarget, pathCreateConfigFile));
                } else {
                    objectArrayList.add(new IModConfig.SimpleConfigTarget(iPotentialTarget, pathCreateConfigFile));
                }
            }
        }
        return objectArrayList;
    }

    @Override // mctech.api.gui.IModConfig
    public ConfigType getConfigType() {
        return this.handler.getConfigType();
    }

    @Override // mctech.api.gui.IModConfig
    public IConfigNode getRootNode() {
        return new ConfigRoot(this.config);
    }

    @Override // mctech.api.gui.IModConfig
    public boolean isDefault() {
        return this.config.isDefault();
    }

    @Override // mctech.api.gui.IModConfig
    public void restoreDefault() {
        this.config.resetDefault();
    }

    @Override // mctech.api.gui.IModConfig
    public void save() {
        if (this.config == this.handler.getConfig()) {
            this.handler.save();
            this.handler.onSynced();
            return;
        }
        try {
            BufferedWriter bufferedWriterNewBufferedWriter = Files.newBufferedWriter(this.path, new OpenOption[0]);
            try {
                bufferedWriterNewBufferedWriter.write(this.config.serialize(this.handler.getMultilinePolicy()));
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

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/config/impl/ModConfig$NetworkModConfig.class */
    private static class NetworkModConfig extends ModConfig implements Predicate<FriendlyByteBuf> {
        public NetworkModConfig(String str, ConfigHandler configHandler, Config config) {
            super(str, configHandler, config, null);
        }

        @Override // java.util.function.Predicate
        public boolean test(FriendlyByteBuf friendlyByteBuf) {
            try {
                ConfigHandler.load(this.handler, this.config, ObjectArrayList.wrap(friendlyByteBuf.readUtf(262144).split("\n")), false);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }

        @Override // mctech.config.impl.ModConfig, mctech.api.gui.IModConfig
        public void save() {
        }
    }
}
