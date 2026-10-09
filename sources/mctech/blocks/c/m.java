package mctech.blocks.c;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blocks/c/m.class */
public class m extends mctech.blocks.b {
    public static final MapCodec<mctech.blocks.b> c = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(propertiesCodec()).apply(instance, m::new);
    });
    private static final VoxelShape d = Shapes.join(Shapes.join(Shapes.join(Shapes.join(Shapes.join(Shapes.join(Shapes.join(Shapes.join(Shapes.empty(), Shapes.box(0.125d, 0.0d, 0.125d, 0.875d, 0.375d, 0.875d), BooleanOp.OR), Shapes.box(0.125d, 0.0d, 0.875d, 0.875d, 0.625d, 1.0d), BooleanOp.OR), Shapes.box(0.0d, 0.625d, 0.0d, 1.0d, 1.0d, 1.0d), BooleanOp.OR), Shapes.box(0.1875d, 0.375d, 0.1875d, 0.8125d, 0.625d, 0.8125d), BooleanOp.OR), Shapes.box(0.875d, 0.0d, 0.875d, 1.0d, 0.625d, 1.0d), BooleanOp.OR), Shapes.box(0.875d, 0.0d, 0.0d, 1.0d, 0.625d, 0.125d), BooleanOp.OR), Shapes.box(0.0d, 0.0d, 0.0d, 0.125d, 0.625d, 0.125d), BooleanOp.OR), Shapes.box(0.0d, 0.0d, 0.875d, 0.125d, 0.625d, 1.0d), BooleanOp.OR);

    public m() {
        this(BlockBehaviour.Properties.of().sound(SoundType.METAL).mapColor(MapColor.METAL).strength(5.0f, 25.0f).requiresCorrectToolForDrops().noOcclusion());
    }

    public m(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override // mctech.blocks.b
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return c;
    }

    protected VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return d;
    }

    @Override // mctech.blocks.base.e
    public RenderShape getRenderShape(BlockState blockState) {
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }

    @Override // mctech.blocks.base.blocks.BaseFacingBlock, mctech.blocks.base.a
    public mctech.items.base.g createItem() {
        return new mctech.items.base.f(this);
    }
}
