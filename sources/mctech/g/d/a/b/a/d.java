package mctech.g.d.a.b.a;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.capability.IFluidHandlerItem;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/a/b/a/d.class */
public class d extends mctech.g.d.a.b.c<FluidStack> {
    public d(Supplier<FluidStack> supplier, Consumer<FluidStack> consumer, int i, int i2, int i3) {
        super(supplier, consumer, i, i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mctech.g.d.a.b.c
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public FluidStack a() {
        return FluidStack.EMPTY;
    }

    @Override // mctech.g.d.a.b.c
    public Optional<FluidStack> a(ItemStack itemStack) {
        IFluidHandlerItem iFluidHandlerItem = (IFluidHandlerItem) itemStack.getCapability(Capabilities.FluidHandler.ITEM);
        if (iFluidHandlerItem != null) {
            FluidStack fluidStackCopy = iFluidHandlerItem.getFluidInTank(0).copy();
            if (!fluidStackCopy.isEmpty()) {
                return Optional.of(fluidStackCopy);
            }
        }
        return Optional.empty();
    }
}
