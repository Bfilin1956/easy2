package mctech.api.features.redstone;

import mctech.blocks.base.a.a.c;
import net.minecraft.core.Direction;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/features/redstone/IComparable.class */
public interface IComparable extends IComparatorProvider {
    c getManager();

    default boolean isAllowingUI() {
        c manager = getManager();
        return manager != null && manager.a();
    }

    @Override // mctech.api.features.redstone.IComparatorProvider
    default int getSignalStrength(Direction direction) {
        c manager = getManager();
        if (manager == null) {
            return 0;
        }
        return manager.a(direction);
    }
}
