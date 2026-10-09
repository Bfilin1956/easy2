package mctech.items.g.b;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import javax.annotation.Nullable;
import mctech.api.items.IHudDisplayable;
import mctech.api.items.electric.ElectricItem;
import mctech.api.items.electric.IDamagelessElectricItem;
import mctech.api.items.electric.IElectricItem;
import mctech.api.network.buffer.INetworkDataBuffer;
import mctech.items.base.MCTechElectricItem;
import mctech.items.base.o;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.ItemLike;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/g/b/g.class */
public abstract class g extends h implements IHudDisplayable, IDamagelessElectricItem {
    public g(ArmorItem.Type type, @Nullable o oVar) {
        super(type, (oVar == null ? new o() : oVar).c(0).a(1));
    }

    @Override // mctech.items.g.b.h, mctech.items.g.b.f, mctech.utils.e.a
    @OnlyIn(Dist.CLIENT)
    public void addToolTip(ItemStack itemStack, Player player, TooltipFlag tooltipFlag, mctech.utils.e.d dVar) {
        super.addToolTip(itemStack, player, tooltipFlag, dVar);
        Objects.requireNonNull(dVar);
    }

    @Override // mctech.items.g.b.h
    public int a(ItemStack itemStack) {
        return getCapacity(itemStack);
    }

    @Override // mctech.items.g.b.h
    public int b(ItemStack itemStack) {
        return ElectricItem.MANAGER.getCharge(itemStack);
    }

    @Override // mctech.items.g.b.h
    public void a(Player player, ItemStack itemStack, int i) {
        if (itemStack.getItem() != this) {
            ElectricItem.MANAGER.discharge(itemStack, i, Integer.MAX_VALUE, true, false, false);
        } else if (!ElectricItem.MANAGER.use(itemStack, i, player)) {
            ElectricItem.MANAGER.discharge(itemStack, i, Integer.MAX_VALUE, true, false, false);
        }
    }

    @Override // mctech.items.g.b.e, mctech.api.items.IItemVariant
    public Collection<ItemStack> getVariants() {
        ArrayList arrayList = new ArrayList();
        MCTechElectricItem.addEmptyAndFullToGroup((ItemLike) this, (List<ItemStack>) arrayList);
        return arrayList;
    }

    @Override // mctech.items.g.b.h
    public int getBarWidth(ItemStack itemStack) {
        return MCTechElectricItem.getElectricWidth(itemStack);
    }

    @Override // mctech.items.g.b.h
    public int getBarColor(ItemStack itemStack) {
        return MCTechElectricItem.getRGBDurability(itemStack);
    }

    @Override // mctech.items.g.b.h
    public boolean isBarVisible(ItemStack itemStack) {
        return true;
    }

    public <T extends LivingEntity> int damageItem(ItemStack itemStack, int i, T t, Consumer<Item> consumer) {
        ElectricItem.MANAGER.discharge(itemStack, ElectricItem.applyEnchantmentEffect(itemStack, b(itemStack, h.a.NONE) * i), Integer.MAX_VALUE, true, false, false);
        return 0;
    }

    @Override // mctech.api.items.electric.IElectricItem
    public IElectricItem.ElectricType getElectricType(ItemStack itemStack) {
        return IElectricItem.ElectricType.ARMOR;
    }

    public boolean a(Player player, ItemStack itemStack, ItemStack itemStack2, String str, INetworkDataBuffer iNetworkDataBuffer, Dist dist) {
        return false;
    }
}
