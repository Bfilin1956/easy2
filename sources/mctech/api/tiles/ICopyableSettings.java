package mctech.api.tiles;

import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/tiles/ICopyableSettings.class */
public interface ICopyableSettings {
    void saveSettings(CompoundTag compoundTag, HolderLookup.Provider provider);

    void loadSettings(CompoundTag compoundTag, HolderLookup.Provider provider);
}
