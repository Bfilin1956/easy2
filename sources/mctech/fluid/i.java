package mctech.fluid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.IFluidTank;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/fluid/i.class */
public class i<Tank extends IFluidTank> implements IFluidHandler {
    private final List<Tank> a = new ArrayList();

    @SafeVarargs
    public i(Tank... tankArr) {
        this.a.addAll(Arrays.stream(tankArr).filter((v0) -> {
            return Objects.nonNull(v0);
        }).toList());
    }

    public int getTanks() {
        return this.a.size();
    }

    @NotNull
    public FluidStack getFluidInTank(int i) {
        return i >= getTanks() ? FluidStack.EMPTY : this.a.get(i).getFluid();
    }

    public int getTankCapacity(int i) {
        if (i >= getTanks()) {
            return 0;
        }
        return this.a.get(i).getCapacity();
    }

    public boolean isFluidValid(int i, @NotNull FluidStack fluidStack) {
        return i < getTanks() && this.a.get(i).isFluidValid(fluidStack);
    }

    public int fill(@NotNull FluidStack fluidStack, @NotNull IFluidHandler.FluidAction fluidAction) {
        int iFill;
        for (Tank tank : this.a) {
            if (tank != null && (iFill = tank.fill(fluidStack, fluidAction)) > 0) {
                return iFill;
            }
        }
        return 0;
    }

    @NotNull
    public FluidStack drain(@NotNull FluidStack fluidStack, @NotNull IFluidHandler.FluidAction fluidAction) {
        for (Tank tank : this.a) {
            if (tank != null) {
                FluidStack fluidStackDrain = tank.drain(fluidStack, fluidAction);
                if (!fluidStackDrain.isEmpty()) {
                    return fluidStackDrain;
                }
            }
        }
        return FluidStack.EMPTY;
    }

    @NotNull
    public FluidStack drain(int i, @NotNull IFluidHandler.FluidAction fluidAction) {
        for (Tank tank : this.a) {
            if (tank != null) {
                FluidStack fluidStackDrain = tank.drain(i, fluidAction);
                if (!fluidStackDrain.isEmpty()) {
                    return fluidStackDrain;
                }
            }
        }
        return FluidStack.EMPTY;
    }
}
