package mctech.fluid;

import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.ints.IntList;
import java.util.List;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/fluid/a.class */
public class a implements IFluidHandler {
    IFluidHandler[] a;
    IntList b;
    IntList c;

    public a(List<IFluidHandler> list) {
        this((IFluidHandler[]) list.toArray(new IFluidHandler[list.size()]));
    }

    public a(IFluidHandler... iFluidHandlerArr) {
        this.b = new IntArrayList();
        this.c = new IntArrayList();
        this.a = iFluidHandlerArr;
        for (int i = 0; i < iFluidHandlerArr.length; i++) {
            int tanks = iFluidHandlerArr[i].getTanks();
            for (int i2 = 0; i2 < tanks; i2++) {
                this.c.add(i);
                this.b.add(i2);
            }
        }
    }

    public int getTanks() {
        return this.c.size();
    }

    public FluidStack getFluidInTank(int i) {
        return this.a[this.c.getInt(i)].getFluidInTank(this.b.getInt(i));
    }

    public int getTankCapacity(int i) {
        return this.a[this.c.getInt(i)].getTankCapacity(this.b.getInt(i));
    }

    public boolean isFluidValid(int i, FluidStack fluidStack) {
        return this.a[this.c.getInt(i)].isFluidValid(this.b.getInt(i), fluidStack);
    }

    public int fill(FluidStack fluidStack, IFluidHandler.FluidAction fluidAction) {
        int iFill = 0;
        for (int i = 0; i < this.a.length; i++) {
            iFill += this.a[i].fill(new FluidStack(fluidStack.getFluid(), fluidStack.getAmount() - iFill), fluidAction);
            if (iFill >= fluidStack.getAmount()) {
                return iFill;
            }
        }
        return iFill;
    }

    public FluidStack drain(FluidStack fluidStack, IFluidHandler.FluidAction fluidAction) {
        int amount = 0;
        for (int i = 0; i < this.a.length; i++) {
            amount += this.a[i].drain(new FluidStack(fluidStack.getFluid(), fluidStack.getAmount() - amount), fluidAction).getAmount();
            if (amount >= fluidStack.getAmount()) {
                return new FluidStack(fluidStack.getFluid(), amount);
            }
        }
        return amount == 0 ? FluidStack.EMPTY : new FluidStack(fluidStack.getFluid(), amount);
    }

    public FluidStack drain(int i, IFluidHandler.FluidAction fluidAction) {
        FluidStack fluidStackDrain = FluidStack.EMPTY;
        for (int i2 = 0; i2 < this.a.length; i2++) {
            if (fluidStackDrain.isEmpty()) {
                fluidStackDrain = this.a[i2].drain(i, fluidAction);
            } else {
                fluidStackDrain.grow(this.a[i2].drain(new FluidStack(fluidStackDrain.getFluid(), i - fluidStackDrain.getAmount()), fluidAction).getAmount());
            }
            if (fluidStackDrain.getAmount() >= i) {
                return fluidStackDrain;
            }
        }
        return fluidStackDrain;
    }
}
