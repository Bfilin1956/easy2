package mctech.blocks.f;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import mctech.blocks.base.e;
import mctech.items.base.f;
import mctech.items.base.g;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blocks/f/a.class */
public class a extends e implements mctech.blocks.base.b<mctech.blockentities.c> {
    public static final MapCodec<a> a = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(propertiesCodec()).apply(instance, a::new);
    });
    public static final BooleanProperty b = mctech.blocks.b.ACTIVE;
    public static final VoxelShape c = Block.box(0.0d, 0.0d, 0.0d, 16.0d, 3.0d, 16.0d);
    public static final AABB d = new AABB(0.0d, 0.0d, 0.0d, 16.0d, 3.0d, 16.0d);
    public static final BlockBehaviour.Properties e = BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(1.5f).requiresCorrectToolForDrops();

    public a() {
        this(e);
    }

    public a(BlockBehaviour.Properties properties) {
        super(properties);
        registerDefaultState((BlockState) defaultBlockState().setValue(b, false));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{b});
    }

    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return c;
    }

    @Override // mctech.blocks.base.b
    public void a(Level level, BlockPos blockPos, BlockState blockState, mctech.blockentities.c cVar) {
        cVar.setState((BlockState) blockState.setValue(b, Boolean.valueOf(cVar.isActive())));
    }

    @Override // mctech.blocks.base.e
    public void animateTick(BlockState blockState, Level level, BlockPos blockPos, RandomSource randomSource) {
        if (((Boolean) blockState.getValue(b)).booleanValue()) {
            BlockEntity blockEntity = level.getBlockEntity(blockPos);
            if (blockEntity instanceof mctech.blockentities.c) {
                ((mctech.blockentities.c) blockEntity).d(randomSource);
            }
        }
    }

    public void fallOn(Level level, BlockState blockState, BlockPos blockPos, Entity entity, float f) {
        if (level.isClientSide || !(entity instanceof LivingEntity)) {
        }
    }

    @Override // mctech.blocks.base.e
    public RenderShape getRenderShape(BlockState blockState) {
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }

    protected MapCodec<? extends BaseEntityBlock> codec() {
        return a;
    }

    @Override // mctech.blocks.base.a
    public g createItem() {
        return new f(this);
    }
}
