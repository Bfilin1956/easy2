package mctech.items.g.a;

import mctech.MCTech;
import mctech.api.items.armor.ICustomArmor;
import mctech.api.util.MCTechDamageSource;
import mctech.init.MCTechFluids;
import mctech.init.MCTechMaterials;
import mctech.init.MCTechStats;
import mctech.items.base.o;
import mctech.items.g.b.f;
import mctech.m.c.g;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/g/a/b.class */
public class b extends f implements ICustomArmor {
    private static final ResourceLocation[] a = {ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "textures/models/armor/hazmat_1.png"), ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "textures/models/armor/hazmat_2.png")};
    private static final g b = itemStack -> {
        return itemStack.getItem() == MCTechFluids.CELL_AIR.get();
    };

    public b(ArmorItem.Type type) {
        super((Holder<ArmorMaterial>) MCTechMaterials.HAZMAT_ARMOR, type, new o().c(type.getDurability(5)));
    }

    @Override // mctech.items.g.b.f, mctech.utils.e.a
    @OnlyIn(Dist.CLIENT)
    public void addToolTip(ItemStack itemStack, Player player, TooltipFlag tooltipFlag, mctech.utils.e.d dVar) {
        dVar.c("tooltip.item.mctech.armor_hazmat.prevent_burn", new Object[0]);
        if (this.type == ArmorItem.Type.HELMET) {
            dVar.c("tooltip.item.mctech.armor_hazmat_helmet.provide_air", new Object[0]);
        }
    }

    public void a(ItemStack itemStack, Level level, Player player) {
        if (this.type == ArmorItem.Type.HELMET) {
            if (a((LivingEntity) player)) {
                if (player.isInLava() || level.getBlockStates(player.getBoundingBox().expandTowards(-0.10000000149011612d, -0.4000000059604645d, -0.10000000149011612d)).anyMatch(blockState -> {
                    return blockState.getTags().filter(tagKey -> {
                        return tagKey == BlockTags.FIRE;
                    }).count() > 0;
                })) {
                    player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 60, 1));
                }
                player.clearFire();
            }
            if (player.getAirSupply() <= 100 && player.getInventory().contains(new ItemStack((ItemLike) MCTechFluids.CELL_AIR.get()))) {
                mctech.m.h.a aVarA = mctech.m.h.b.a(player);
                if (!aVarA.a(b, Direction.DOWN, 1, false).isEmpty()) {
                    aVarA.a(new ItemStack((ItemLike) MCTechFluids.CELL_EMPTY.get()), Direction.DOWN, false);
                    player.awardStat((ResourceLocation) MCTechStats.AIR_CELLS_USED.get());
                    player.setAirSupply(player.getAirSupply() + 150);
                    player.containerMenu.broadcastChanges();
                }
            }
        }
    }

    public static boolean a(LivingEntity livingEntity) {
        if (!(livingEntity instanceof Player)) {
            return false;
        }
        Player player = (Player) livingEntity;
        for (EquipmentSlot equipmentSlot : EquipmentSlot.values()) {
            if (equipmentSlot.getType() != EquipmentSlot.Type.HAND) {
                ItemStack itemBySlot = player.getItemBySlot(equipmentSlot);
                if (itemBySlot.isEmpty() || !(itemBySlot.getItem() instanceof b)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean a(DamageSource damageSource, Level level) {
        return damageSource == level.damageSources().inFire() || damageSource == level.damageSources().inWall() || damageSource == level.damageSources().lava() || damageSource == level.damageSources().onFire() || damageSource.is(MCTechDamageSource.ELECTRICITY) || damageSource.is(MCTechDamageSource.RADIATION);
    }

    /* JADX INFO: renamed from: mctech.items.g.a.b$1, reason: invalid class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/g/a/b$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[ArmorItem.Type.values().length];

        static {
            try {
                a[ArmorItem.Type.HELMET.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[ArmorItem.Type.CHESTPLATE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[ArmorItem.Type.BOOTS.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[ArmorItem.Type.LEGGINGS.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public ResourceLocation getArmorTexture(ItemStack itemStack, Entity entity, EquipmentSlot equipmentSlot, ArmorMaterial.Layer layer, boolean z) {
        switch (AnonymousClass1.a[itemStack.getItem().getType().ordinal()]) {
            case 1:
            case 2:
            case 3:
                return a[0];
            case 4:
                return a[1];
            default:
                return super.getArmorTexture(itemStack, entity, equipmentSlot, layer, z);
        }
    }

    @Override // mctech.api.items.armor.ICustomArmor
    public ICustomArmor.AbsorptionProperties getProperties(LivingEntity livingEntity, ItemStack itemStack, DamageSource damageSource, double d, EquipmentSlot equipmentSlot) {
        Level level = livingEntity.level();
        if (equipmentSlot == EquipmentSlot.HEAD && a(damageSource, level) && a(livingEntity)) {
            if (damageSource == level.damageSources().inFire()) {
                livingEntity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 60, 1));
            }
            return new ICustomArmor.AbsorptionProperties(10, 1.0d, Integer.MAX_VALUE);
        }
        if (equipmentSlot == EquipmentSlot.FEET && damageSource == level.damageSources().fall()) {
            return new ICustomArmor.AbsorptionProperties(10, d < 8.0d ? 1.0d : 0.875d, ((itemStack.getMaxDamage() - itemStack.getDamageValue()) + 1) * 2);
        }
        return new ICustomArmor.AbsorptionProperties(0, 0.2d, ((itemStack.getMaxDamage() - itemStack.getDamageValue()) + 1) / 2);
    }

    @Override // mctech.api.items.armor.ICustomArmor
    public void damageArmor(LivingEntity livingEntity, ItemStack itemStack, DamageSource damageSource, int i, EquipmentSlot equipmentSlot, ICustomArmor.DamageType damageType) {
        Level level = livingEntity.level();
        if ((a(damageSource, level) && a(livingEntity)) || damageSource == level.damageSources().starve()) {
            return;
        }
        if (equipmentSlot != EquipmentSlot.FEET && damageSource == level.damageSources().fall()) {
            return;
        }
        int i2 = i * 2;
        if (equipmentSlot == EquipmentSlot.FEET && damageSource == level.damageSources().fall()) {
            i2 = (i + 1) / 2;
        }
        itemStack.hurtAndBreak(i2, livingEntity, equipmentSlot);
    }

    @Override // mctech.api.items.armor.ICustomArmor
    public boolean canBlockDamageSource(LivingEntity livingEntity, ItemStack itemStack, DamageSource damageSource, EquipmentSlot equipmentSlot) {
        Level level = livingEntity.level();
        return (equipmentSlot == EquipmentSlot.FEET && damageSource == level.damageSources().fall()) || (equipmentSlot == EquipmentSlot.HEAD && a(damageSource, level)) || !damageSource.is(DamageTypeTags.BYPASSES_ARMOR) || damageSource == level.damageSources().starve();
    }
}
