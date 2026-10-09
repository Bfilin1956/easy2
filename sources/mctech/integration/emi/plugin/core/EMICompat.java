package mctech.integration.emi.plugin.core;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.fml.ModList;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/integration/emi/plugin/core/EMICompat.class */
public class EMICompat {
    private static final boolean IS_LOADED = ModList.get().isLoaded("emi");

    public static boolean openRecipeCategory(BlockEntity blockEntity, int i) {
        if (!IS_LOADED) {
            return false;
        }
        return EMIPlugin.openLinkedCategory(blockEntity, i);
    }

    public static boolean isRegistered(BlockEntity blockEntity) {
        if (!IS_LOADED) {
            return false;
        }
        return EMIPlugin.hasLinkedCategory(blockEntity);
    }
}
