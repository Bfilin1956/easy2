package mctech.api.features.redstone;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/features/redstone/IRedstoneListener.class */
public interface IRedstoneListener {
    boolean canConnectToRedstone(Direction direction);

    default boolean allowWeakSignal(Direction direction) {
        BlockEntity blockEntity = (BlockEntity) this;
        return blockEntity.getBlockState().isRedstoneConductor(blockEntity.getLevel(), blockEntity.getBlockPos());
    }
}
