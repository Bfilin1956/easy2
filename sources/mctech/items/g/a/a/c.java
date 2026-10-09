package mctech.items.g.a.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import mctech.MCTech;
import mctech.api.items.IHudDisplayable;
import mctech.api.items.electric.IDamagelessElectricItem;
import mctech.api.items.electric.IElectricItem;
import mctech.items.base.MCTechElectricItem;
import mctech.items.base.o;
import mctech.items.g.b.e;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/g/a/a/c.class */
public class c extends e implements IHudDisplayable, IDamagelessElectricItem {
    private static final ResourceLocation a = ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "textures/models/armor/nightvision_1.png");

    public c() {
        super(ArmorItem.Type.HELMET, new o().c(0));
    }

    @Override // mctech.api.items.electric.IElectricItem
    public boolean canProvideEnergy(ItemStack itemStack) {
        return false;
    }

    @Override // mctech.api.items.electric.IElectricItem
    public int getCapacity(ItemStack itemStack) {
        return 20000;
    }

    @Override // mctech.api.items.electric.IElectricItem
    public int getTier(ItemStack itemStack) {
        return 1;
    }

    @Override // mctech.api.items.electric.IElectricItem
    public int getTransferLimit(ItemStack itemStack) {
        return 200;
    }

    public <T extends LivingEntity> int damageItem(ItemStack itemStack, int i, @Nullable T t, Consumer<Item> consumer) {
        return 0;
    }

    @Override // mctech.items.g.b.e
    public Ingredient a() {
        return Ingredient.EMPTY;
    }

    public ResourceLocation getArmorTexture(ItemStack itemStack, Entity entity, EquipmentSlot equipmentSlot, ArmorMaterial.Layer layer, boolean z) {
        return a;
    }

    @Override // mctech.items.g.b.e, mctech.api.items.IItemVariant
    public Collection<ItemStack> getVariants() {
        ArrayList arrayList = new ArrayList();
        MCTechElectricItem.addEmptyAndFullToGroup((ItemLike) this, (List<ItemStack>) arrayList);
        return arrayList;
    }

    @Override // mctech.items.g.b.f, mctech.utils.e.a
    public void addToolTip(ItemStack itemStack, Player player, TooltipFlag tooltipFlag, mctech.utils.e.d dVar) {
        dVar.b(a(mctech.s.a.HUD_KEY, mctech.s.a.MODE_KEY, "tooltip.item.mctech.nightvision_goggles.hud_key", new Object[0]));
        dVar.c("tooltip.mctech.nightvision_seeinthedark", new Object[0]);
        Objects.requireNonNull(dVar);
    }

    public int getBarWidth(ItemStack itemStack) {
        return MCTechElectricItem.getElectricWidth(itemStack);
    }

    public int getBarColor(ItemStack itemStack) {
        return MCTechElectricItem.getRGBDurability(itemStack);
    }

    public boolean isBarVisible(ItemStack itemStack) {
        return true;
    }

    @Override // mctech.api.items.electric.IElectricItem
    public IElectricItem.ElectricType getElectricType(ItemStack itemStack) {
        return IElectricItem.ElectricType.ARMOR;
    }
}
