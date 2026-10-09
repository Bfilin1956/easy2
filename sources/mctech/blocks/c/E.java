package mctech.blocks.c;

import java.util.function.Supplier;
import mctech.api.blocks.IBlockDropProvider;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blocks/c/E.class */
public class E extends mctech.blocks.b {
    private final Supplier<? extends BlockEntityType<?>> c;

    public E(String str, Supplier<? extends BlockEntityType<?>> supplier) {
        this.c = supplier;
        setDropProvider(IBlockDropProvider.SELF);
    }

    @Override // mctech.blocks.base.e
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return this.c.get().create(blockPos, blockState);
    }
}
