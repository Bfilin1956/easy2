package mctech.items.base;

import java.util.ArrayList;
import java.util.Collection;
import mctech.api.energy.IEnergyCrystal;
import mctech.api.items.electric.ICustomElectricItem;
import mctech.api.items.electric.IElectricItemManager;
import mctech.init.MCTechDataComponent;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/base/h.class */
public class h extends i implements IEnergyCrystal, ICustomElectricItem {
    private final int a;
    private final int b;

    public h(mctech.h.a.b.a aVar) {
        super(new Item.Properties().component((DataComponentType) MCTechDataComponent.CRYSTAL_CHARGE.get(), 0).setNoRepair());
        this.a = Math.toIntExact(aVar.a);
        this.b = aVar.b;
    }

    @Override // mctech.api.energy.IEnergyCrystal
    public int getEnergyCapacity() {
        return this.a;
    }

    @Override // mctech.api.energy.IEnergyCrystal
    public int getTransferRate() {
        return this.b;
    }

    @Override // mctech.api.energy.IEnergyCrystal
    public int fillEnergy(ItemStack itemStack, int i, boolean z, boolean z2) {
        return 0;
    }

    @Override // mctech.api.energy.IEnergyCrystal
    public int drainEnergy(ItemStack itemStack, int i, boolean z, boolean z2) {
        return 0;
    }

    public boolean isBarVisible(@NotNull ItemStack itemStack) {
        return getCharge(itemStack) > 0;
    }

    public int getBarWidth(@NotNull ItemStack itemStack) {
        return (int) Math.round(((double) (getCharge(itemStack) / this.a)) * 13.0d);
    }

    public int getMaxStackSize(@NotNull ItemStack itemStack) {
        return getCharge(itemStack) > 0 ? 1 : 16;
    }

    public int getBarColor(@NotNull ItemStack itemStack) {
        return MCTechElectricItem.getRGBDurability(itemStack);
    }

    @Override // mctech.items.base.i, mctech.api.items.IItemVariant
    public Collection<ItemStack> getVariants() {
        ArrayList arrayList = new ArrayList();
        ItemStack itemStack = new ItemStack(this, 1);
        itemStack.set((DataComponentType) MCTechDataComponent.CRYSTAL_CHARGE.get(), 0);
        ItemStack itemStack2 = new ItemStack(this, 1);
        itemStack2.set((DataComponentType) MCTechDataComponent.CRYSTAL_CHARGE.get(), Integer.valueOf(getEnergyCapacity()));
        arrayList.add(itemStack);
        arrayList.add(itemStack2);
        return arrayList;
    }

    @Override // mctech.api.energy.IEnergyCrystal
    public int getCharge(ItemStack itemStack) {
        if (itemStack.getItem() instanceof IEnergyCrystal) {
            return ((Integer) itemStack.getOrDefault((DataComponentType) MCTechDataComponent.CRYSTAL_CHARGE.get(), 0)).intValue();
        }
        return 0;
    }

    @Override // mctech.api.items.electric.ICustomElectricItem
    public IElectricItemManager getManager(ItemStack itemStack) {
        if (itemStack.getItem() instanceof IEnergyCrystal) {
            return mctech.energy.b.a;
        }
        return null;
    }
}
