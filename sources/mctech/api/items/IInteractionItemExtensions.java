package mctech.api.items;

import java.util.function.BiFunction;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.level.BlockEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/items/IInteractionItemExtensions.class */
public interface IInteractionItemExtensions {
    default boolean shouldPreventBlockDestroy(@NotNull Level level, @NotNull ItemStack itemStack, @NotNull BlockPos blockPos, @NotNull BlockState blockState, @NotNull Player player) {
        return false;
    }

    default void onItemEquippedToSlot(@NotNull Player player, @NotNull ItemStack itemStack, @NotNull EquipmentSlot equipmentSlot) {
    }

    default void onItemUnequippedFromSlot(@NotNull Player player, @NotNull ItemStack itemStack, @NotNull EquipmentSlot equipmentSlot) {
    }

    default boolean mayDestroyBlock(@NotNull Level level, @NotNull Player player, @NotNull BlockPos blockPos) {
        return mayDestroyBlock(level, player, blockPos, true);
    }

    default boolean mayDestroyBlock(@NotNull Level level, @NotNull Player player, @NotNull BlockPos blockPos, boolean z) {
        if (level.mayInteract(player, blockPos)) {
            return (z && NeoForge.EVENT_BUS.post(new BlockEvent.BreakEvent(level, blockPos, level.getBlockState(blockPos), player)).isCanceled()) ? false : true;
        }
        return false;
    }

    default void directInventoryTick(@NotNull ItemStack itemStack, @NotNull Level level, @NotNull Entity entity, int i) {
        if (EquipmentSlot.HEAD.getIndex(36) == i) {
            tickInventoryHead(itemStack, level, entity);
        }
        if (EquipmentSlot.CHEST.getIndex(36) == i) {
            tickInventoryChestplate(itemStack, level, entity);
        }
        if (EquipmentSlot.LEGS.getIndex(36) == i) {
            tickInventoryLegs(itemStack, level, entity);
        }
        if (EquipmentSlot.FEET.getIndex(36) == i) {
            tickInventoryFeet(itemStack, level, entity);
        }
    }

    default void tickInventoryHead(@NotNull ItemStack itemStack, @NotNull Level level, @NotNull Entity entity) {
    }

    default void tickInventoryChestplate(@NotNull ItemStack itemStack, @NotNull Level level, @NotNull Entity entity) {
    }

    default void tickInventoryLegs(@NotNull ItemStack itemStack, @NotNull Level level, @NotNull Entity entity) {
    }

    default void tickInventoryFeet(@NotNull ItemStack itemStack, @NotNull Level level, @NotNull Entity entity) {
    }

    default boolean shouldPreventFlyBreakingBlockSlowdown(@NotNull ItemStack itemStack, @NotNull Player player) {
        return false;
    }

    @Nullable
    default BiFunction<Float, ItemStack, Float> handleIncomingDamage(@NotNull Player player) {
        return null;
    }

    @Nullable
    default BiFunction<Float, ItemStack, Float> handleOutgoingDamage(@NotNull Player player, @NotNull LivingEntity livingEntity) {
        return null;
    }

    default void onBlockClicked(@NotNull Level level, @NotNull Player player, @NotNull BlockPos blockPos, @NotNull BlockState blockState) {
    }
}
