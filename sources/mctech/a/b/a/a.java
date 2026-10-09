package mctech.a.b.a;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.SwitchBootstraps;
import mctech.api.network.tile.INetworkFluidTankFillListener;
import mctech.fluid.c;
import mctech.fluid.d;
import mctech.m.a.g;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/a/b/a/a.class */
public interface a {
    default boolean a() {
        return true;
    }

    default ItemStack a(int i, ItemStack itemStack) {
        int iMin;
        if (this instanceof g) {
            g gVar = (g) this;
            if (itemStack.isEmpty() || !gVar.canInsert(i, itemStack)) {
                return itemStack;
            }
            if (i < 0 || i >= gVar.getSlotCount()) {
                return itemStack;
            }
            ItemStack stackInSlot = gVar.getStackInSlot(i);
            if (stackInSlot.isEmpty()) {
                gVar.setStackInSlot(i, itemStack.copy());
                return ItemStack.EMPTY;
            }
            if (a(itemStack, stackInSlot) && (iMin = Math.min(stackInSlot.getMaxStackSize(), itemStack.getMaxStackSize()) - stackInSlot.getCount()) > 0) {
                int iMin2 = Math.min(iMin, itemStack.getCount());
                stackInSlot.grow(iMin2);
                gVar.setStackInSlot(i, stackInSlot);
                if (iMin2 == itemStack.getCount()) {
                    return ItemStack.EMPTY;
                }
                return itemStack.copyWithCount(itemStack.getCount() - iMin2);
            }
        }
        return itemStack;
    }

    default FluidStack a(int i, FluidStack fluidStack) {
        int iFill;
        if (fluidStack.isEmpty()) {
            return FluidStack.EMPTY;
        }
        if (this instanceof INetworkFluidTankFillListener) {
            try {
                IFluidHandler fluidHandler = ((INetworkFluidTankFillListener) this).getFluidHandler(i);
                switch ((int) SwitchBootstraps.typeSwitch(MethodHandles.lookup(), "typeSwitch", MethodType.methodType(Integer.TYPE, Object.class, Integer.TYPE), c.class, d.class, mctech.fluid.b.class).dynamicInvoker().invoke(fluidHandler, 0) /* invoke-custom */) {
                    case mctech.utils.math.a.b /* -1 */:
                        iFill = 0;
                        break;
                    case 0:
                        iFill = ((c) fluidHandler).a(fluidStack, IFluidHandler.FluidAction.EXECUTE);
                        break;
                    case 1:
                        iFill = ((d) fluidHandler).fill(fluidStack, IFluidHandler.FluidAction.EXECUTE);
                        break;
                    case 2:
                        iFill = ((mctech.fluid.b) fluidHandler).fill(fluidStack, IFluidHandler.FluidAction.EXECUTE);
                        break;
                    default:
                        iFill = fluidHandler.fill(fluidStack, IFluidHandler.FluidAction.EXECUTE);
                        break;
                }
                int i2 = iFill;
                if (i2 == fluidStack.getAmount()) {
                    return FluidStack.EMPTY;
                }
                if (i2 > 0) {
                    return fluidStack.copyWithAmount(fluidStack.getAmount() - i2);
                }
            } catch (Exception e) {
                return fluidStack;
            }
        }
        return fluidStack;
    }

    static boolean a(ItemStack itemStack, ItemStack itemStack2) {
        if (!ItemStack.isSameItem(itemStack, itemStack2)) {
            return false;
        }
        if (itemStack.isDamageableItem()) {
            ItemStack itemStackCopy = itemStack.copy();
            ItemStack itemStackCopy2 = itemStack2.copy();
            itemStackCopy.setDamageValue(0);
            itemStackCopy2.setDamageValue(0);
            return ItemStack.isSameItemSameComponents(itemStackCopy, itemStackCopy2);
        }
        return ItemStack.isSameItemSameComponents(itemStack, itemStack2);
    }
}
