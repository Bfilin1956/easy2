package mctech.api.tiles;

import java.util.EnumSet;
import mctech.api.items.IUpgradeItem;
import mctech.api.util.ILocation;
import net.minecraft.core.Direction;
import net.neoforged.neoforge.items.IItemHandler;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/tiles/IMachine.class */
public interface IMachine extends IInputMachine, ILocation {
    int getAvailableEnergy();

    boolean isMachineWorking();

    void setRedstoneSensitive(boolean z);

    boolean isRedstoneSensitive();

    IItemHandler getConnectedInventory(Direction direction);

    EnumSet<IUpgradeItem.UpgradeType> getSupportedUpgradeTypes();

    default void setRedstoneInverted(boolean z) {
    }

    default boolean isRedstoneInverted() {
        return false;
    }

    default void handleMods() {
    }

    default void setTier(int i) {
    }

    default int getTier() {
        return 1;
    }

    default void setMaxInput(int i) {
    }

    default void setMaxEnergy(int i) {
    }
}
