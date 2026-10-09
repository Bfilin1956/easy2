package mctech.config.impl;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import mctech.api.ConfigType;
import mctech.api.IConfigProxy;
import mctech.api.SimpleConfigProxy;
import mctech.config.ConfigSettings;
import net.minecraft.client.Minecraft;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.level.storage.LevelResource;
import net.minecraft.world.level.storage.LevelStorageSource;
import net.minecraft.world.level.storage.LevelSummary;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.fml.loading.FMLPaths;
import net.neoforged.neoforge.server.ServerLifecycleHooks;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/config/impl/PerWorldProxy.class */
public final class PerWorldProxy implements IConfigProxy {
    public static final LevelResource SERVERCONFIG = new LevelResource("serverconfig");
    public static final IConfigProxy INSTANCE = new PerWorldProxy(FMLPaths.GAMEDIR.get().resolve("multiplayerconfigs"), FMLPaths.GAMEDIR.get().resolve("defaultconfigs"), FMLPaths.GAMEDIR.get().resolve("saves"));
    Path baseClientPath;
    Path baseServerPath;
    Path saveFolders;

    private PerWorldProxy(Path path, Path path2, Path path3) {
        this.baseClientPath = path;
        this.baseServerPath = path2;
        this.saveFolders = path3;
    }

    public static boolean isProxy(IConfigProxy iConfigProxy) {
        return iConfigProxy instanceof PerWorldProxy;
    }

    public static ConfigSettings perWorld() {
        return ConfigSettings.withFolderProxy(INSTANCE).withType(ConfigType.SERVER);
    }

    @Override // mctech.api.IConfigProxy
    public List<Path> getBasePaths() {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        MinecraftServer currentServer = ServerLifecycleHooks.getCurrentServer();
        if (currentServer != null) {
            objectArrayList.add(currentServer.getWorldPath(SERVERCONFIG));
        } else if (FMLEnvironment.dist.isClient()) {
            objectArrayList.add(this.baseClientPath);
        }
        objectArrayList.add(this.baseServerPath);
        return objectArrayList;
    }

    @Override // mctech.api.IConfigProxy
    public List<? extends IConfigProxy.IPotentialTarget> getPotentialConfigs() {
        if (FMLEnvironment.dist.isClient()) {
            return getLevels();
        }
        return Collections.singletonList(new SimpleConfigProxy.SimpleTarget(ServerLifecycleHooks.getCurrentServer().getWorldPath(SERVERCONFIG), "server"));
    }

    @OnlyIn(Dist.CLIENT)
    private List<WorldTarget> getLevels() {
        LevelStorageSource levelSource = Minecraft.getInstance().getLevelSource();
        ObjectArrayList objectArrayList = new ObjectArrayList();
        for (LevelSummary levelSummary : (List) levelSource.loadLevelSummaries(levelSource.findLevelCandidates()).join()) {
            try {
                LevelStorageSource.LevelStorageAccess levelStorageAccessCreateAccess = Minecraft.getInstance().getLevelSource().createAccess(levelSummary.getLevelId());
                try {
                    Path levelPath = levelStorageAccessCreateAccess.getLevelPath(SERVERCONFIG);
                    if (Files.exists(levelPath, new LinkOption[0])) {
                        objectArrayList.add(new WorldTarget(levelSummary, levelStorageAccessCreateAccess.getLevelPath(LevelResource.ROOT), levelPath));
                    }
                    if (levelStorageAccessCreateAccess != null) {
                        levelStorageAccessCreateAccess.close();
                    }
                } catch (Throwable th) {
                    if (levelStorageAccessCreateAccess != null) {
                        try {
                            levelStorageAccessCreateAccess.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return objectArrayList;
    }

    @Override // mctech.api.IConfigProxy
    public boolean isDynamicProxy() {
        return true;
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/config/impl/PerWorldProxy$WorldTarget.class */
    public static class WorldTarget implements IConfigProxy.IPotentialTarget {
        LevelSummary summary;
        Path worldFile;
        Path folder;

        public WorldTarget(LevelSummary levelSummary, Path path, Path path2) {
            this.summary = levelSummary;
            this.worldFile = path;
            this.folder = path2;
        }

        @Override // mctech.api.IConfigProxy.IPotentialTarget
        public Path getFolder() {
            return this.folder;
        }

        @Override // mctech.api.IConfigProxy.IPotentialTarget
        public String getName() {
            return this.summary.getLevelName();
        }

        public Path getWorldFile() {
            return this.worldFile;
        }

        public LevelSummary getSummary() {
            return this.summary;
        }
    }
}
