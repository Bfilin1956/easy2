package mctech.api.features;

import net.minecraft.core.Direction;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/features/IWrenchRemovable.class */
public interface IWrenchRemovable extends IWrenchableTile {
    @Override // mctech.api.features.IWrenchableTile
    default boolean canSetFacing(Direction direction) {
        return false;
    }
}
