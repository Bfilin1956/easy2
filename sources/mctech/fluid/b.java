package mctech.fluid;

import java.util.function.Predicate;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import net.neoforged.neoforge.fluids.capability.templates.FluidTank;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/fluid/b.class */
public class b extends g {
    public static Predicate<FluidStack> a = fluidStack -> {
        return false;
    };

    public b(int i) {
        super(i, a);
    }

    public int a(FluidStack fluidStack, IFluidHandler.FluidAction fluidAction) {
        if (fluidStack.isEmpty()) {
            return 0;
        }
        if (fluidAction.simulate()) {
            if (this.fluid.isEmpty()) {
                return Math.min(this.capacity, fluidStack.getAmount());
            }
            if (!FluidStack.isSameFluidSameComponents(this.fluid, fluidStack)) {
                return 0;
            }
            return Math.min(this.capacity - this.fluid.getAmount(), fluidStack.getAmount());
        }
        if (this.fluid.isEmpty()) {
            this.fluid = new FluidStack(fluidStack.getFluid(), Math.min(this.capacity, fluidStack.getAmount()));
            onContentsChanged();
            return this.fluid.getAmount();
        }
        if (!FluidStack.isSameFluidSameComponents(this.fluid, fluidStack)) {
            return 0;
        }
        int amount = this.capacity - this.fluid.getAmount();
        if (fluidStack.getAmount() < amount) {
            this.fluid.grow(fluidStack.getAmount());
            amount = fluidStack.getAmount();
        } else {
            this.fluid.setAmount(this.capacity);
        }
        if (amount > 0) {
            onContentsChanged();
        }
        return amount;
    }

    public FluidTank setValidator(Predicate<FluidStack> predicate) {
        return this;
    }
}
