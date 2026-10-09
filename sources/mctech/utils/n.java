package mctech.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.IFluidTank;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import net.neoforged.neoforge.fluids.capability.IFluidHandlerItem;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/n.class */
public final class n {
    @NotNull
    public static FluidStack a(@NotNull ItemStack itemStack) {
        if (itemStack.isEmpty()) {
            return FluidStack.EMPTY;
        }
        IFluidHandlerItem iFluidHandlerItem = (IFluidHandlerItem) itemStack.getCapability(Capabilities.FluidHandler.ITEM);
        if (iFluidHandlerItem == null) {
            return FluidStack.EMPTY;
        }
        int tanks = iFluidHandlerItem.getTanks();
        for (int i = 0; i < tanks; i++) {
            FluidStack fluidInTank = iFluidHandlerItem.getFluidInTank(i);
            if (!fluidInTank.isEmpty()) {
                return fluidInTank;
            }
        }
        return FluidStack.EMPTY;
    }

    private static void a(@NotNull ItemStack itemStack, @NotNull ItemStack itemStack2) {
        if ((!itemStack.isEmpty() || !itemStack2.isEmpty()) && itemStack.getCount() < itemStack.getMaxStackSize() && ItemStack.isSameItemSameComponents(itemStack, itemStack2)) {
            int iMin = Math.min(itemStack.getMaxStackSize() - itemStack.getCount(), itemStack2.getCount());
            itemStack.grow(iMin);
            itemStack2.shrink(iMin);
        }
    }

    private static a a(@NotNull ItemStack itemStack, b bVar) {
        if (itemStack.isEmpty() || itemStack.getMaxStackSize() < itemStack.getCount()) {
            return a.a;
        }
        FluidStack fluidStackA = a(itemStack);
        if (fluidStackA.isEmpty()) {
            return a.a;
        }
        ArrayList arrayList = new ArrayList();
        ItemStack itemStackCopy = itemStack.copy();
        do {
            ItemStack itemStackCopy2 = itemStack.copy();
            itemStackCopy2.setCount(1);
            ItemStack itemStackA = a(itemStackCopy2, fluidStackA, bVar);
            if (itemStackA.isEmpty()) {
                break;
            }
            itemStackCopy.shrink(1);
            if (arrayList.isEmpty()) {
                arrayList.add(itemStackA);
            } else {
                a((ItemStack) arrayList.getLast(), itemStackA);
                if (!itemStackA.isEmpty()) {
                    arrayList.add(itemStackA);
                }
            }
        } while (!itemStackCopy.isEmpty());
        if (!arrayList.isEmpty()) {
            return new a(itemStackCopy, arrayList);
        }
        return a.a;
    }

    public static a a(@NotNull ItemStack itemStack, IFluidTank iFluidTank) {
        return a(itemStack, b.a(iFluidTank));
    }

    public static a a(@NotNull ItemStack itemStack, IFluidHandler iFluidHandler) {
        return a(itemStack, b.a(iFluidHandler));
    }

    private static ItemStack a(ItemStack itemStack, FluidStack fluidStack, b bVar) {
        IFluidHandlerItem iFluidHandlerItem = (IFluidHandlerItem) itemStack.getCapability(Capabilities.FluidHandler.ITEM);
        if (iFluidHandlerItem == null) {
            return ItemStack.EMPTY;
        }
        FluidStack fluidStackDrain = iFluidHandlerItem.drain(fluidStack, IFluidHandler.FluidAction.SIMULATE);
        if (fluidStackDrain.isEmpty() || !FluidStack.isSameFluidSameComponents(fluidStackDrain, fluidStack) || fluidStackDrain.getAmount() < fluidStack.getAmount()) {
            return ItemStack.EMPTY;
        }
        int iFill = bVar.fill(fluidStack, IFluidHandler.FluidAction.SIMULATE);
        if (iFill != 0 && iFill <= fluidStackDrain.getAmount()) {
            FluidStack fluidStack2 = new FluidStack(fluidStack.getFluid(), iFill);
            iFluidHandlerItem.drain(fluidStack2, IFluidHandler.FluidAction.EXECUTE);
            bVar.fill(fluidStack2, IFluidHandler.FluidAction.EXECUTE);
            return iFluidHandlerItem.getContainer();
        }
        return ItemStack.EMPTY;
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/n$a.class */
    public static final class a {
        public static final a a = new a(false, ItemStack.EMPTY, List.of());
        public final boolean b;
        public final ItemStack c;
        public final List<ItemStack> d;

        private a(boolean z, ItemStack itemStack, List<ItemStack> list) {
            this.b = z;
            this.c = itemStack;
            this.d = list;
        }

        private a(ItemStack itemStack, List<ItemStack> list) {
            this(true, itemStack, list);
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/n$b.class */
    private interface b {
        int fill(FluidStack fluidStack, IFluidHandler.FluidAction fluidAction);

        @NotNull
        private static b a(@NotNull IFluidTank iFluidTank) {
            Objects.requireNonNull(iFluidTank);
            return iFluidTank::fill;
        }

        @NotNull
        private static b a(@NotNull IFluidHandler iFluidHandler) {
            Objects.requireNonNull(iFluidHandler);
            return iFluidHandler::fill;
        }
    }
}
