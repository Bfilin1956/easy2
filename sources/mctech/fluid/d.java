package mctech.fluid;

import java.util.function.Predicate;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/fluid/d.class */
public class d extends g {
    public d(int i) {
        super(i);
    }

    public d(int i, Predicate<FluidStack> predicate) {
        super(i, predicate);
    }

    public FluidStack drain(FluidStack fluidStack, IFluidHandler.FluidAction fluidAction) {
        return FluidStack.EMPTY;
    }

    @Override // mctech.fluid.g
    public FluidStack drain(int i, IFluidHandler.FluidAction fluidAction) {
        return FluidStack.EMPTY;
    }

    public FluidStack a(int i, IFluidHandler.FluidAction fluidAction) {
        return FluidStack.EMPTY;
    }
}
