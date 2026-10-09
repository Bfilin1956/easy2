package mctech.blocks.base;

import mctech.blockentities.q;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blocks/base/b.class */
public interface b<T extends q> extends EntityBlock {
    void a(Level level, BlockPos blockPos, BlockState blockState, T t);

    BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState);
}
