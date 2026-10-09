package mctech.utils.c;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Ghast;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.entity.vehicle.Minecart;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.portal.DimensionTransition;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.fluids.FluidStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/c/i.class */
public class i {
    public static double a(Level level, BlockPos blockPos, Level level2, BlockPos blockPos2) {
        return Math.pow(Math.sqrt(blockPos.distSqr(blockPos2) * a(level, level2)) + 10.0d, !level.dimension().equals(level2.dimension()) ? 0.9d : 0.7d);
    }

    public static double a(Level level, Level level2) {
        double dA = a(level);
        double dA2 = a(level2);
        return Math.min(dA, dA2) / Math.max(dA, dA2);
    }

    private static double a(Level level) {
        if (level == null) {
            return 1.0d;
        }
        return level.dimensionType().coordinateScale();
    }

    public static void a(Entity entity, ServerLevel serverLevel, BlockPos blockPos, Direction direction) {
        entity.unRide();
        double x = blockPos.getX() + direction.getStepX() + 0.5f;
        double y = blockPos.getY() + direction.getStepY() + ((direction.getAxis() == Direction.Axis.Y && direction.getAxisDirection() == Direction.AxisDirection.NEGATIVE) ? -1 : 0);
        double z = blockPos.getZ() + direction.getStepZ() + 0.5f;
        if (entity.level().dimension() != serverLevel.dimension()) {
            entity.changeDimension(new DimensionTransition(serverLevel, new Vec3(x, y, z), entity.getDeltaMovement(), entity.getYRot(), entity.getXRot(), DimensionTransition.DO_NOTHING));
        } else {
            entity.teleportTo(x, y, z);
        }
    }

    public static void a(Entity entity, ServerLevel serverLevel, BlockPos blockPos) {
        entity.unRide();
        double x = blockPos.getX();
        double y = blockPos.getY();
        double z = blockPos.getZ();
        if (entity.level().dimension() != serverLevel.dimension()) {
            entity.changeDimension(new DimensionTransition(serverLevel, new Vec3(x, y, z), entity.getDeltaMovement(), entity.getYRot(), entity.getXRot(), DimensionTransition.DO_NOTHING));
        } else {
            entity.teleportTo(x, y, z);
        }
    }

    public static int a(FluidStack fluidStack) {
        return 1 + (fluidStack.getAmount() / 10);
    }

    public static int a(ItemStack itemStack) {
        return 100 * (itemStack.getCount() / itemStack.getMaxStackSize());
    }

    public static int a(Entity entity, boolean z) {
        int count = 0;
        if (entity instanceof ItemEntity) {
            ItemStack item = ((ItemEntity) entity).getItem();
            count = 0 + ((100 * item.getCount()) / item.getMaxStackSize());
        } else if ((entity instanceof Animal) || (entity instanceof Minecart) || (entity instanceof Boat)) {
            count = 0 + 100;
        } else if (entity instanceof Player) {
            count = 0 + 1000;
            if (z) {
                Inventory inventory = ((Player) entity).getInventory();
                int containerSize = inventory.getContainerSize();
                for (int i = 0; i < containerSize; i++) {
                    ItemStack item2 = inventory.getItem(i);
                    if (!item2.isEmpty()) {
                        count += 100 * (item2.getCount() / item2.getMaxStackSize());
                    }
                }
            }
        } else if (entity instanceof Ghast) {
            count = 0 + 2500;
        } else if ((entity instanceof EnderDragon) || (entity instanceof WitherBoss)) {
            count = 0 + 10000;
        } else if (entity instanceof PathfinderMob) {
            count = 0 + 500;
        }
        if (z && (entity instanceof LivingEntity) && !(entity instanceof Player)) {
            LivingEntity livingEntity = (LivingEntity) entity;
            for (EquipmentSlot equipmentSlot : EquipmentSlot.values()) {
                ItemStack itemBySlot = livingEntity.getItemBySlot(equipmentSlot);
                if (!itemBySlot.isEmpty()) {
                    count += 100 * (itemBySlot.getCount() / itemBySlot.getMaxStackSize());
                }
            }
        }
        return count;
    }
}
