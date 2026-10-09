package mctech.api.items;

import java.util.EnumSet;
import java.util.List;
import mctech.api.tiles.IMachine;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/items/IUpgradeItem.class */
public interface IUpgradeItem {

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/items/IUpgradeItem$Functions.class */
    public enum Functions {
        TICK,
        RECIPE
    }

    UpgradeType getType(ItemStack itemStack);

    EnumSet<Functions> getFunctions(ItemStack itemStack);

    void onInstall(ItemStack itemStack, IMachine iMachine);

    double getProcessingSpeedMultiplier(ItemStack itemStack, IMachine iMachine);

    int getExtraProcessingSpeed(ItemStack itemStack, IMachine iMachine);

    double getProcessingTimeMultiplier(ItemStack itemStack, IMachine iMachine);

    int getExtraProcessingTime(ItemStack itemStack, IMachine iMachine);

    double getEnergyDemandMultiplier(ItemStack itemStack, IMachine iMachine);

    int getExtraEnergyDemand(ItemStack itemStack, IMachine iMachine);

    double getEnergyStorageMultiplier(ItemStack itemStack, IMachine iMachine);

    int getExtraEnergyStorage(ItemStack itemStack, IMachine iMachine);

    int getExtraTier(ItemStack itemStack, IMachine iMachine);

    float getSoundMultiplier(ItemStack itemStack, IMachine iMachine);

    boolean useRedstoneInvertion(ItemStack itemStack, IMachine iMachine);

    void onTick(ItemStack itemStack, IMachine iMachine);

    void onMachineFinishedRecipePre(ItemStack itemStack, IMachine iMachine, Recipe<?> recipe, CompoundTag compoundTag);

    void onMachineFinishedRecipePost(ItemStack itemStack, IMachine iMachine, Recipe<?> recipe, List<?> list);

    void onMachineProcessed(ItemStack itemStack, IMachine iMachine);

    default int getOutputCount() {
        return 0;
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/items/IUpgradeItem$UpgradeType.class */
    public enum UpgradeType {
        RECIPE_MOD(new String[0]),
        MACHINE_MOD(new String[]{"EnergyStorage", "ExtraTier"}),
        PROCESSING_MOD(new String[0]),
        CUSTOM_MOD(new String[0]),
        SPEED_MOD(new String[0]),
        ENERGY_MOD(new String[0]),
        MASS_FABRICATOR_MOD(new String[0]),
        EXPAND_MOD(new String[0]),
        REDSTONE_MOD(new String[0]),
        SAWMILL_MOD(new String[0]),
        AUDIO_MOD(new String[0]),
        ADMIN_MOD(new String[0]),
        TRANSFORMER_MOD(new String[0]),
        SPEED_MOD_COMPOSITE(new String[0]),
        SPEED_MOD_NANO(new String[0]),
        SPEED_MOD_QUANT(new String[0]),
        SPEED_MOD_TITAN(new String[0]),
        SPEED_MOD_RUBIDIUM(new String[0]),
        COMPLEX_HANDLER_MOD(new String[0]),
        CHARGEPAD_MOD(new String[0]),
        REACTOR_COOLANT_MOD(new String[0]),
        REACTOR_ENRICHMENT_MOD(new String[0]),
        FARMING_RADIUS_MOD(new String[0]),
        FARMING_FERTILIZER_MOD(new String[0]);

        String[] names;

        UpgradeType(String[] strArr) {
            this.names = strArr;
        }
    }
}
