package mctech.api.gui;

import java.nio.file.Path;
import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Predicate;
import mctech.api.ConfigType;
import mctech.api.IConfigProxy;
import mctech.config.impl.PerWorldProxy;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.level.storage.LevelSummary;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/gui/IModConfig.class */
public interface IModConfig {

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/gui/IModConfig$IConfigTarget.class */
    public interface IConfigTarget extends IConfigProxy.IPotentialTarget {
        Path getConfigFile();
    }

    String getFileName();

    String getConfigName();

    String getModId();

    boolean isDynamicConfig();

    ConfigType getConfigType();

    IConfigNode getRootNode();

    boolean isDefault();

    void restoreDefault();

    List<IConfigTarget> getPotentialFiles();

    IModConfig loadFromFile(Path path);

    IModConfig loadFromNetworking(UUID uuid, Consumer<Predicate<FriendlyByteBuf>> consumer);

    void save();

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/gui/IModConfig$SimpleConfigTarget.class */
    public static class SimpleConfigTarget implements IConfigTarget {
        Path folder;
        Path file;
        String name;

        public SimpleConfigTarget(IConfigProxy.IPotentialTarget iPotentialTarget, Path path) {
            this(iPotentialTarget.getFolder(), path, iPotentialTarget.getName());
        }

        public SimpleConfigTarget(Path path, Path path2, String str) {
            this.folder = path;
            this.file = path2;
            this.name = str;
        }

        @Override // mctech.api.IConfigProxy.IPotentialTarget
        public Path getFolder() {
            return this.folder;
        }

        @Override // mctech.api.IConfigProxy.IPotentialTarget
        public String getName() {
            return this.name;
        }

        @Override // mctech.api.gui.IModConfig.IConfigTarget
        public Path getConfigFile() {
            return this.file;
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/gui/IModConfig$WorldConfigTarget.class */
    public static class WorldConfigTarget implements IConfigTarget {
        LevelSummary summary;
        Path folder;
        Path file;
        String name;

        public WorldConfigTarget(PerWorldProxy.WorldTarget worldTarget, Path path) {
            this(worldTarget.getSummary(), worldTarget.getFolder(), path, worldTarget.getName());
        }

        public WorldConfigTarget(LevelSummary levelSummary, Path path, Path path2, String str) {
            this.summary = levelSummary;
            this.folder = path;
            this.file = path2;
            this.name = str;
        }

        @Override // mctech.api.IConfigProxy.IPotentialTarget
        public Path getFolder() {
            return this.folder;
        }

        @Override // mctech.api.IConfigProxy.IPotentialTarget
        public String getName() {
            return this.name;
        }

        @Override // mctech.api.gui.IModConfig.IConfigTarget
        public Path getConfigFile() {
            return this.file;
        }

        public LevelSummary getSummary() {
            return this.summary;
        }
    }
}
