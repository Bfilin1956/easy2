package mctech.fluid;

import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import net.neoforged.neoforge.fluids.capability.templates.FluidTank;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/fluid/l.class */
public class l extends FluidTank {
    public l(IFluidHandler iFluidHandler) {
        super(iFluidHandler.getTankCapacity(0));
        setFluid(iFluidHandler.drain(Integer.MAX_VALUE, IFluidHandler.FluidAction.SIMULATE));
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/fluid/l$a.class */
    public static class a implements IFluidHandler {
        IFluidHandler a;

        public a(IFluidHandler iFluidHandler) {
            this.a = iFluidHandler;
        }

        public int getTanks() {
            return this.a.getTanks();
        }

        @NotNull
        public FluidStack getFluidInTank(int i) {
            return this.a.getFluidInTank(i);
        }

        public int getTankCapacity(int i) {
            return this.a.getTankCapacity(i);
        }

        public boolean isFluidValid(int i, @NotNull FluidStack fluidStack) {
            return this.a.isFluidValid(i, fluidStack);
        }

        public int fill(FluidStack fluidStack, IFluidHandler.FluidAction fluidAction) {
            return 0;
        }

        @NotNull
        public FluidStack drain(FluidStack fluidStack, IFluidHandler.FluidAction fluidAction) {
            return this.a.drain(fluidStack, fluidAction);
        }

        @NotNull
        public FluidStack drain(int i, IFluidHandler.FluidAction fluidAction) {
            return this.a.drain(i, fluidAction);
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/fluid/l$b.class */
    public static class b implements IFluidHandler {
        IFluidHandler a;

        public b(IFluidHandler iFluidHandler) {
            this.a = iFluidHandler;
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
            return this.a.isFluidValid(i, fluidStack);
        }

        public int fill(FluidStack fluidStack, IFluidHandler.FluidAction fluidAction) {
            return this.a.fill(fluidStack, IFluidHandler.FluidAction.SIMULATE);
        }

        public FluidStack drain(FluidStack fluidStack, IFluidHandler.FluidAction fluidAction) {
            return this.a.drain(fluidStack, IFluidHandler.FluidAction.SIMULATE);
        }

        public FluidStack drain(int i, IFluidHandler.FluidAction fluidAction) {
            return this.a.drain(i, IFluidHandler.FluidAction.SIMULATE);
        }
    }
}
