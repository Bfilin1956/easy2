package mctech.blocks.b;

import com.mojang.serialization.MapCodec;
import javax.annotation.Nullable;
import mctech.init.MCTechCodecs;
import mctech.init.MCTechTiles;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.Property;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blocks/b/e.class */
public class e extends b {
    private final MachineTier c;

    public e(BlockBehaviour.Properties properties, MachineTier machineTier) {
        super(properties.sound(SoundType.METAL).strength(5.0f));
        this.c = machineTier;
        registerDefaultState((BlockState) this.stateDefinition.any().setValue(MachineTier.PROPERTY, machineTier));
    }

    @Override // mctech.blocks.base.blocks.BaseFacingBlock
    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        return (BlockState) ((BlockState) defaultBlockState().setValue(FACING, blockPlaceContext.getHorizontalDirection().getOpposite())).setValue(ACTIVE, false);
    }

    @Override // mctech.blocks.base.blocks.BaseActivityBlock, mctech.blocks.base.blocks.BaseFacingBlock
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder.add(new Property[]{MachineTier.PROPERTY}));
    }

    @Override // mctech.blocks.b.b
    @NotNull
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return MCTechCodecs.REACTOR;
    }

    @Override // mctech.blocks.base.e
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return ((BlockEntityType) MCTechTiles.NUCLEAR_REACTOR.get()).create(blockPos, blockState);
    }

    public MachineTier a() {
        return this.c;
    }
}
