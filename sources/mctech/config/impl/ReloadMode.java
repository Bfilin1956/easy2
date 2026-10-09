package mctech.config.impl;

import mctech.api.IReloadMode;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/config/impl/ReloadMode.class */
public enum ReloadMode implements IReloadMode {
    WORLD("Config Synced Please Rejoin the World"),
    GAME("Config Syncedd Please Restart the Game");

    String message;

    ReloadMode(String str) {
        this.message = str;
    }

    public String getMessage() {
        return this.message;
    }

    public static ReloadMode or(ReloadMode reloadMode, IReloadMode iReloadMode) {
        return getByIndex(Math.max(getModeIndex(reloadMode), getModeIndex(iReloadMode instanceof ReloadMode ? (ReloadMode) iReloadMode : null)));
    }

    private static int getModeIndex(ReloadMode reloadMode) {
        if (reloadMode == null) {
            return -1;
        }
        return reloadMode.ordinal();
    }

    private static ReloadMode getByIndex(int i) {
        if (i == 0) {
            return WORLD;
        }
        if (i == 1) {
            return GAME;
        }
        return null;
    }
}
