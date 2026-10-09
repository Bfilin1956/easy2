package mctech.api.features.redstone;

import net.minecraft.core.Direction;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/features/redstone/IRedstoneProvider.class */
public interface IRedstoneProvider {
    int getCommonSignalStrength(Direction direction);

    default int getStrongSignalStrength(Direction direction) {
        return getCommonSignalStrength(direction);
    }

    default int getWeakSignalStrength(Direction direction) {
        return getCommonSignalStrength(direction);
    }
}
