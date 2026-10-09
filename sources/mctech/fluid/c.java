package mctech.fluid;

import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/fluid/c.class */
public interface c {
    int a(@NotNull FluidStack fluidStack, @NotNull IFluidHandler.FluidAction fluidAction);

    FluidStack a(int i, IFluidHandler.FluidAction fluidAction);
}
