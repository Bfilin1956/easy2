package mctech.api.tiles;

import mctech.d.d;
import mctech.m.e.a;
import mctech.m.e.i;
import net.minecraft.core.Direction;
import net.neoforged.neoforge.fluids.IFluidTank;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/tiles/IFluidMachine.class */
public interface IFluidMachine {
    @Nullable
    IFluidHandler getConnectedTank(@Nullable Direction direction);

    @Nullable
    default <Cache extends d<IFluidHandler>> IFluidHandler provide(@Nullable Direction direction, @Nullable Cache cache, @NotNull i iVar, @NotNull IFluidHandler iFluidHandler) {
        if (direction == null) {
            return null;
        }
        IFluidHandler iFluidHandler2 = cache == null ? null : (IFluidHandler) cache.b(direction);
        if (iFluidHandler2 == null) {
            iFluidHandler2 = iFluidHandler;
        }
        if (iVar.d(direction) != a.DISABLED) {
            return iFluidHandler2;
        }
        return null;
    }

    @Nullable
    default <Cache extends d<IFluidHandler>> IFluidHandler provide(@Nullable Direction direction, @Nullable Cache cache, @NotNull i iVar, @NotNull IFluidTank... iFluidTankArr) {
        return provide(direction, cache, iVar, new mctech.fluid.i(iFluidTankArr));
    }

    @Nullable
    default <Cache extends d<IFluidHandler>> IFluidHandler provide(@Nullable Direction direction, @NotNull i iVar, @NotNull IFluidTank... iFluidTankArr) {
        return provide(direction, (d) null, iVar, iFluidTankArr);
    }

    @Nullable
    default <Cache extends d<IFluidHandler>> IFluidHandler provide(@Nullable Direction direction, @NotNull i iVar, @NotNull IFluidHandler iFluidHandler) {
        return provide(direction, (d) null, iVar, iFluidHandler);
    }
}
