package mctech.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import net.neoforged.neoforge.fluids.capability.templates.FluidTank;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/v.class */
public class v implements IFluidHandler {
    private final List<FluidTank> a = new ArrayList();

    public v(FluidTank... fluidTankArr) {
        this.a.addAll(Arrays.stream(fluidTankArr).filter((v0) -> {
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
        for (FluidTank fluidTank : this.a) {
            if (fluidTank != null && (iFill = fluidTank.fill(fluidStack, fluidAction)) > 0) {
                return iFill;
            }
        }
        return 0;
    }

    @NotNull
    public FluidStack drain(@NotNull FluidStack fluidStack, @NotNull IFluidHandler.FluidAction fluidAction) {
        for (FluidTank fluidTank : this.a) {
            if (fluidTank != null) {
                FluidStack fluidStackDrain = fluidTank.drain(fluidStack, fluidAction);
                if (!fluidStackDrain.isEmpty()) {
                    return fluidStackDrain;
                }
            }
        }
        return FluidStack.EMPTY;
    }

    @NotNull
    public FluidStack drain(int i, @NotNull IFluidHandler.FluidAction fluidAction) {
        for (FluidTank fluidTank : this.a) {
            if (fluidTank != null) {
                FluidStack fluidStackDrain = fluidTank.drain(i, fluidAction);
                if (!fluidStackDrain.isEmpty()) {
                    return fluidStackDrain;
                }
            }
        }
        return FluidStack.EMPTY;
    }
}
