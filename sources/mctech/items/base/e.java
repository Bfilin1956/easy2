package mctech.items.base;

import mctech.api.items.electric.ElectricItem;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/base/e.class */
public abstract class e extends MCTechElectricItem {
    protected float a;

    public e(o oVar, float f) {
        super(oVar);
        this.a = f;
    }

    public e(@NotNull Item.Properties properties, float f) {
        super(properties);
        this.a = f;
    }

    public float getDestroySpeed(@NotNull ItemStack itemStack, @NotNull BlockState blockState) {
        if (!ElectricItem.MANAGER.canUse(itemStack, getEnergyCost(itemStack))) {
            return 1.0f;
        }
        if (isCorrectToolForDrops(itemStack, blockState)) {
            return this.a;
        }
        return super.getDestroySpeed(itemStack, blockState);
    }

    public boolean hurtEnemy(@NotNull ItemStack itemStack, @NotNull LivingEntity livingEntity, @NotNull LivingEntity livingEntity2) {
        return true;
    }

    public boolean mineBlock(@NotNull ItemStack itemStack, @NotNull Level level, BlockState blockState, @NotNull BlockPos blockPos, @NotNull LivingEntity livingEntity) {
        if (blockState.getDestroySpeed(level, blockPos) != 0.0f) {
            ElectricItem.MANAGER.use(itemStack, getEnergyCost(itemStack), livingEntity);
            return true;
        }
        return true;
    }

    public boolean isEnchantable(@NotNull ItemStack itemStack) {
        return false;
    }
}
