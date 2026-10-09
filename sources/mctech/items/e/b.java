package mctech.items.e;

import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nonnull;
import mctech.api.items.IHudDisplayable;
import mctech.api.items.electric.IElectricItem;
import mctech.init.MCTechDataComponent;
import mctech.init.MCTechModules;
import mctech.items.EnumC0125a;
import mctech.items.base.MCTechElectricItem;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/e/b.class */
public class b extends a implements IHudDisplayable, IElectricItem, mctech.items.base.k {
    @Override // mctech.items.base.k
    @Nonnull
    public /* synthetic */ mctech.items.base.l a() {
        return super.b();
    }

    public b(@Nonnull EnumC0125a enumC0125a) {
        super(enumC0125a, ArmorItem.Type.CHESTPLATE);
    }

    @Override // mctech.items.base.k
    public boolean a(@NotNull Player player, @NotNull ItemStack itemStack) {
        return a(player, EquipmentSlot.HEAD) && a(player, EquipmentSlot.LEGS) && a(player, EquipmentSlot.FEET);
    }

    private boolean a(@Nonnull Player player, @Nonnull EquipmentSlot equipmentSlot) {
        a item = player.getItemBySlot(equipmentSlot).getItem();
        return (item instanceof a) && item.b == this.b;
    }

    public boolean canElytraFly(ItemStack itemStack, LivingEntity livingEntity) {
        if (livingEntity instanceof Player) {
            AtomicBoolean atomicBoolean = new AtomicBoolean();
            mctech.modules.f.a(MCTechModules.ELYTRA, itemStack, EnumC0125a.class, (Player) livingEntity, energyCost -> {
                atomicBoolean.set(true);
            });
            return atomicBoolean.get();
        }
        return false;
    }

    public boolean elytraFlightTick(ItemStack itemStack, LivingEntity livingEntity, int i) {
        return canElytraFly(itemStack, livingEntity);
    }

    public void inventoryTick(ItemStack itemStack, Level level, Entity entity, int i, boolean z) {
        if (entity instanceof Player) {
            Player player = (Player) entity;
            if (i == 38) {
                a(itemStack, level, player);
            }
        }
    }

    public void a(ItemStack itemStack, Level level, Player player) {
        boolean z = !mctech.t.a.a(player);
        if (z) {
            mctech.modules.f.a(MCTechModules.JETPACK, itemStack, EnumC0125a.class, player, (energyCost, enumC0125a) -> {
                ItemStack stackInSlot = new mctech.e.a(itemStack, enumC0125a).b().getStackInSlot(0);
                mctech.items.g.b.h item = stackInSlot.getItem();
                if (item instanceof mctech.items.g.b.h) {
                    item.a(stackInSlot, level, player);
                }
            });
        }
        if (player.isSprinting() && z) {
            mctech.modules.f.b(MCTechModules.MOVEMENT_SPEED, itemStack, EnumC0125a.class, player, (multiplier, enumC0125a2) -> {
                float fMultiplier;
                if (player.isInWater()) {
                    fMultiplier = 0.1f;
                } else {
                    fMultiplier = ((player.onGround() || player.isFallFlying()) ? 0.22f : 0.025f) * multiplier.multiplier();
                }
                player.moveRelative(fMultiplier, new Vec3(0.0d, 0.0d, 1.0d));
            });
        }
        mctech.modules.f.b(MCTechModules.JUMP_BOOST, itemStack, EnumC0125a.class, player, (amplifierFloat, enumC0125a3) -> {
            mctech.s.d dVarA = mctech.s.d.a(player);
            if (dVarA.k < 1.0f && player.onGround()) {
                dVarA.k = 1.0f;
            }
            if (!z) {
                dVarA.k = 1.0f;
                return;
            }
            if (player.getDeltaMovement().y() >= 0.0d && dVarA.k > 0.0f && !player.isInWater()) {
                if (dVarA.s) {
                    double d = dVarA.k == 1.0f ? 1.75d : 1.0d;
                    player.setDeltaMovement(player.getDeltaMovement().multiply(d, 1.0d, d).add(0.0d, ((double) dVarA.k) * 0.035d * ((double) amplifierFloat.amplifier()), 0.0d));
                    dVarA.k *= 0.75f;
                } else if (dVarA.k < 1.0f) {
                    dVarA.k = 0.0f;
                }
            }
        });
    }

    @Override // mctech.api.items.IHudDisplayable
    public float getDurabilityPercent(ItemStack itemStack) {
        return mctech.e.a.c(itemStack) / mctech.e.a.d(itemStack);
    }

    @Override // mctech.api.items.IHudDisplayable
    public int getDurabilityBarColor(ItemStack itemStack) {
        return getBarColor(itemStack);
    }

    public int getBarWidth(@Nonnull ItemStack itemStack) {
        return (int) Math.round((((double) mctech.e.a.c(itemStack)) / ((double) mctech.e.a.d(itemStack))) * 13.0d);
    }

    public int getBarColor(@Nonnull ItemStack itemStack) {
        return MCTechElectricItem.getRGBDurability(itemStack);
    }

    public boolean isBarVisible(@Nonnull ItemStack itemStack) {
        return true;
    }

    @Override // mctech.api.items.electric.IElectricItem
    public boolean canProvideEnergy(ItemStack itemStack) {
        return false;
    }

    @Override // mctech.api.items.electric.IElectricItem
    public int getCapacity(ItemStack itemStack) {
        return mctech.e.a.d(itemStack);
    }

    @Override // mctech.api.items.electric.IElectricItem
    public IElectricItem.ElectricType getElectricType(ItemStack itemStack) {
        return IElectricItem.ElectricType.ARMOR;
    }

    @Override // mctech.api.items.electric.IElectricItem
    public int getCharge(ItemStack itemStack) {
        return ((Integer) itemStack.getOrDefault(MCTechDataComponent.CHARGE, 0)).intValue();
    }

    @Override // mctech.api.items.electric.IElectricItem
    public int getTier(ItemStack itemStack) {
        return 0;
    }

    @Override // mctech.api.items.electric.IElectricItem
    public int getTransferLimit(ItemStack itemStack) {
        return 0;
    }
}
