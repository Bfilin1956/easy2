package mctech.utils;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.FluidUtil;
import net.neoforged.neoforge.fluids.capability.IFluidHandlerItem;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/o.class */
public class o implements mctech.m.c.g {
    private final mctech.fluid.g a;
    private final Fluid b;
    private boolean c;

    public o(mctech.fluid.g gVar, Fluid fluid) {
        this.a = gVar;
        this.b = fluid;
    }

    public o(mctech.fluid.g gVar) {
        this.a = gVar;
        this.b = Fluids.EMPTY;
    }

    public o a(boolean z) {
        this.c = z;
        return this;
    }

    @Override // mctech.m.c.g
    public boolean matches(ItemStack itemStack) {
        if (((IFluidHandlerItem) Capabilities.FluidHandler.ITEM.getCapability(itemStack, (Object) null)) == null) {
            return false;
        }
        FluidStack fluidStack = (FluidStack) FluidUtil.getFluidContained(itemStack).orElse(FluidStack.EMPTY);
        boolean z = !this.b.isSame(Fluids.EMPTY);
        boolean zIsEmpty = this.a.isEmpty();
        boolean zIs = this.a.getFluid().is(fluidStack.getFluid());
        boolean zIs2 = fluidStack.is(this.b);
        if (zIs || zIs2) {
            return true;
        }
        if (this.c && fluidStack.is(Fluids.EMPTY)) {
            return true;
        }
        return zIsEmpty && !z;
    }
}
