package mctech.fluid;

import net.minecraft.tags.TagKey;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/fluid/j.class */
public class j implements IFluidHandler {
    IFluidHandler a;
    TagKey<Fluid> b;
    Fluid c;

    public j(IFluidHandler iFluidHandler, TagKey<Fluid> tagKey, Fluid fluid) {
        this.a = iFluidHandler;
        this.b = tagKey;
        this.c = fluid;
    }

    public int getTanks() {
        return this.a.getTanks();
    }

    public FluidStack getFluidInTank(int i) {
        return this.a.getFluidInTank(i);
    }

    public int getTankCapacity(int i) {
        return this.a.getTankCapacity(i);
    }

    public boolean isFluidValid(int i, FluidStack fluidStack) {
        return fluidStack.getFluid().is(this.b);
    }

    public int fill(FluidStack fluidStack, IFluidHandler.FluidAction fluidAction) {
        return this.a.fill(mctech.utils.c.b.a(fluidStack, this.b, this.c), fluidAction);
    }

    public FluidStack drain(FluidStack fluidStack, IFluidHandler.FluidAction fluidAction) {
        return this.a.drain(mctech.utils.c.b.a(fluidStack, this.b, this.c), fluidAction);
    }

    public FluidStack drain(int i, IFluidHandler.FluidAction fluidAction) {
        return this.a.drain(i, fluidAction);
    }
}
