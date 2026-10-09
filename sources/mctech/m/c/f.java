package mctech.m.c;

import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import java.util.Set;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.fluids.FluidActionResult;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.FluidUtil;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import net.neoforged.neoforge.fluids.capability.IFluidHandlerItem;
import net.neoforged.neoforge.fluids.capability.templates.FluidTank;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/c/f.class */
public class f implements g {
    public static final g a = itemStack -> {
        return (itemStack.getItem() == Items.MILK_BUCKET || ((IFluidHandlerItem) Capabilities.FluidHandler.ITEM.getCapability(itemStack, (Object) null)) == null || FluidUtil.getFluidContained(itemStack).isPresent()) ? false : true;
    };
    public static final g b = itemStack -> {
        return FluidUtil.getFluidContained(itemStack).isPresent();
    };
    Set<Fluid> c;

    public static g a(Fluid fluid) {
        return new a(fluid);
    }

    public f(Fluid... fluidArr) {
        this.c = new ObjectOpenHashSet(fluidArr);
    }

    @Override // mctech.m.c.g
    public boolean matches(ItemStack itemStack) {
        return this.c.contains(((FluidStack) FluidUtil.getFluidContained(itemStack).orElse(FluidStack.EMPTY)).getFluid());
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/c/f$c.class */
    public static class c implements g {
        IFluidHandler a;

        public c(IFluidHandler iFluidHandler) {
            this.a = new mctech.fluid.l.b(iFluidHandler);
        }

        @Override // mctech.m.c.g
        public boolean matches(ItemStack itemStack) {
            FluidActionResult fluidActionResultTryEmptyContainer = FluidUtil.tryEmptyContainer(itemStack, this.a, 1000, (Player) null, true);
            return fluidActionResultTryEmptyContainer.isSuccess() && !fluidActionResultTryEmptyContainer.getResult().isEmpty();
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/c/f$b.class */
    public static class b implements g {
        IFluidHandler a;

        public b(IFluidHandler iFluidHandler) {
            this.a = iFluidHandler;
        }

        @Override // mctech.m.c.g
        public boolean matches(ItemStack itemStack) {
            FluidActionResult fluidActionResultTryFillContainer = FluidUtil.tryFillContainer(itemStack, new mctech.fluid.l(this.a), 1000, (Player) null, true);
            return fluidActionResultTryFillContainer.isSuccess() && !fluidActionResultTryFillContainer.getResult().isEmpty();
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/c/f$a.class */
    public static class a implements g {
        FluidTank a = new FluidTank(1000);
        Fluid b;

        public a(Fluid fluid) {
            this.b = fluid;
            this.a.setFluid(new FluidStack(fluid, 1000));
        }

        @Override // mctech.m.c.g
        public boolean matches(ItemStack itemStack) {
            FluidActionResult fluidActionResultTryFillContainer = FluidUtil.tryFillContainer(itemStack, new mctech.fluid.l(this.a), 1000, (Player) null, true);
            return fluidActionResultTryFillContainer.isSuccess() && !fluidActionResultTryFillContainer.getResult().isEmpty();
        }
    }
}
