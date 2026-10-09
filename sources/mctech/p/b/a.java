package mctech.p.b;

import com.mojang.serialization.MapCodec;
import java.util.function.Supplier;
import mctech.MCTech;
import net.mcskill.msregistry.registry.holder.LBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.neoforged.neoforge.capabilities.BlockCapability;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/p/b/a.class */
public class a<BE extends BlockEntity, TBE extends BlockEntity> extends BaseEntityBlock {
    private final LBlockEntity<BE> c;
    private final LBlockEntity<TBE> d;
    private static final MapCodec<a<?, ?>> b = MapCodec.unit((Supplier) null);
    public static final BooleanProperty a = BooleanProperty.create("is_master");

    /* JADX INFO: renamed from: mctech.p.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/p/b/a$a.class */
    public interface InterfaceC0032a<Cap, Context, BE extends BlockEntity> {
        Cap provide(BE be, Context context);
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/p/b/a$b.class */
    public interface b {
        void a(@NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull mctech.p.b.b bVar);

        void a(@NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos);
    }

    public a(BlockBehaviour.Properties properties, LBlockEntity<BE> lBlockEntity, LBlockEntity<TBE> lBlockEntity2) {
        super(properties.isViewBlocking((blockState, blockGetter, blockPos) -> {
            return false;
        }).isSuffocating((blockState2, blockGetter2, blockPos2) -> {
            return false;
        }).noOcclusion());
        this.c = lBlockEntity;
        this.d = lBlockEntity2;
        registerDefaultState((BlockState) this.stateDefinition.any().setValue(a, false));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{a});
    }

    public boolean a(BlockState blockState) {
        if (blockState.is(this) && blockState.hasProperty(a)) {
            return ((Boolean) blockState.getValue(a)).booleanValue();
        }
        return false;
    }

    @Nullable
    public BlockPos a(BlockGetter blockGetter, BlockPos blockPos) {
        BlockPos blockPosE;
        if (blockGetter == null) {
            return null;
        }
        BlockEntity blockEntity = blockGetter.getBlockEntity(blockPos);
        if ((blockEntity instanceof mctech.p.b.b) && (blockPosE = ((mctech.p.b.b) blockEntity).e()) != null) {
            return blockPosE;
        }
        BlockState blockState = blockGetter.getBlockState(blockPos);
        if (!blockState.isAir() && a(blockState)) {
            return blockPos;
        }
        return null;
    }

    protected boolean canSurvive(@NotNull BlockState blockState, @NotNull LevelReader levelReader, @NotNull BlockPos blockPos) {
        if (!a(blockState)) {
            BlockPos blockPosA = a((BlockGetter) levelReader, blockPos);
            return blockPosA != null && levelReader.getBlockState(blockPosA).getBlock() == this;
        }
        AABB aabbA = a(levelReader, blockPos);
        if (aabbA == null) {
            return false;
        }
        return a(blockState, levelReader, blockPos, aabbA, false);
    }

    public boolean a(@NotNull BlockState blockState, @NotNull LevelReader levelReader, @NotNull BlockPos blockPos, AABB aabb, boolean z) {
        if (a(blockState)) {
            boolean z2 = true;
            for (BlockPos blockPos2 : BlockPos.betweenClosed(blockPos.offset((int) Math.floor(aabb.minX), (int) Math.floor(aabb.minY), (int) Math.floor(aabb.minZ)), blockPos.offset(((int) Math.ceil(aabb.maxX)) - 1, ((int) Math.ceil(aabb.maxY)) - 1, ((int) Math.ceil(aabb.maxZ)) - 1))) {
                if (!blockPos2.equals(blockPos)) {
                    BlockState blockState2 = levelReader.getBlockState(blockPos2);
                    if (!(blockState2.getBlock() instanceof a) || !z) {
                        if (!blockState2.is(Blocks.SNOW) && (!blockState2.canBeReplaced() || !blockState2.isAir())) {
                            z2 = false;
                            break;
                        }
                    }
                }
            }
            return z2;
        }
        return super.canSurvive(blockState, levelReader, blockPos);
    }

    public void onBlockExploded(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, @NotNull Explosion explosion) {
        BlockPos blockPosA = a((BlockGetter) level, blockPos);
        if (blockPosA != null) {
            BlockEntity blockEntity = level.getBlockEntity(blockPosA);
            if (blockEntity instanceof mctech.p.b.b) {
                mctech.p.b.b bVar = (mctech.p.b.b) blockEntity;
                if (bVar.i()) {
                    bVar.a(blockPos, false);
                    wasExploded(level, blockPos, explosion);
                    return;
                }
            }
        }
        super.onBlockExploded(blockState, level, blockPos, explosion);
    }

    public boolean onDestroyedByPlayer(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, @NotNull Player player, boolean z, @NotNull FluidState fluidState) {
        BlockPos blockPosA = a((BlockGetter) level, blockPos);
        if (blockPosA != null) {
            BlockEntity blockEntity = level.getBlockEntity(blockPosA);
            if (blockEntity instanceof mctech.p.b.b) {
                mctech.p.b.b bVar = (mctech.p.b.b) blockEntity;
                if (bVar.i()) {
                    bVar.a(blockPos, !player.isCreative());
                    return false;
                }
            }
        }
        return super.onDestroyedByPlayer(blockState, level, blockPos, player, z, fluidState);
    }

    @NotNull
    public InteractionResult useWithoutItem(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, @NotNull Player player, @NotNull BlockHitResult blockHitResult) {
        if (!a(blockState)) {
            BlockPos blockPosA = a((BlockGetter) level, blockPos);
            if (blockPosA != null && !blockPosA.equals(blockPos)) {
                return level.getBlockState(blockPosA).useWithoutItem(level, player, new BlockHitResult(blockHitResult.getLocation(), blockHitResult.getDirection(), blockPosA, blockHitResult.isInside()));
            }
            return InteractionResult.sidedSuccess(level.isClientSide);
        }
        return a(blockState, level, blockPos, player, blockHitResult);
    }

    protected InteractionResult a(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, @NotNull Player player, @NotNull BlockHitResult blockHitResult) {
        return InteractionResult.PASS;
    }

    @NotNull
    public ItemInteractionResult useItemOn(@NotNull ItemStack itemStack, @NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, @NotNull Player player, @NotNull InteractionHand interactionHand, @NotNull BlockHitResult blockHitResult) {
        if (!a(blockState)) {
            BlockPos blockPosA = a((BlockGetter) level, blockPos);
            if (blockPosA != null && !blockPosA.equals(blockPos)) {
                return level.getBlockState(blockPosA).useItemOn(itemStack, level, player, interactionHand, new BlockHitResult(blockHitResult.getLocation(), blockHitResult.getDirection(), blockPosA, blockHitResult.isInside()));
            }
            return ItemInteractionResult.sidedSuccess(level.isClientSide);
        }
        return a(itemStack, blockState, level, blockPos, player, interactionHand, blockHitResult);
    }

    protected ItemInteractionResult a(@NotNull ItemStack itemStack, @NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, @NotNull Player player, @NotNull InteractionHand interactionHand, @NotNull BlockHitResult blockHitResult) {
        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    @Nullable
    public BlockEntity newBlockEntity(@NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        if (a(blockState)) {
            return ((BlockEntityType) this.c.get()).create(blockPos, blockState);
        }
        return ((BlockEntityType) this.d.get()).create(blockPos, blockState);
    }

    @Nullable
    public PushReaction getPistonPushReaction(@NotNull BlockState blockState) {
        return PushReaction.BLOCK;
    }

    @NotNull
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return b;
    }

    public static <T, C, BE extends BlockEntity> void a(RegisterCapabilitiesEvent registerCapabilitiesEvent, BlockCapability<T, C> blockCapability, InterfaceC0032a<T, C, BE> interfaceC0032a, DeferredBlock<? extends Block> deferredBlock) {
        MCTech.LOGGER.info("Registering delegated capability {} for {}", blockCapability.getClass().getSimpleName(), deferredBlock.getKey());
        registerCapabilitiesEvent.registerBlock(blockCapability, (level, blockPos, blockState, blockEntity, obj) -> {
            BlockPos blockPosE;
            BlockEntity blockEntity;
            if ((blockEntity instanceof mctech.p.b.b) && (blockPosE = ((mctech.p.b.b) blockEntity).e()) != null && level.isLoaded(blockPosE) && (blockEntity = level.getBlockEntity(blockPosE)) != null) {
                try {
                    return interfaceC0032a.provide(blockEntity, obj);
                } catch (ClassCastException e) {
                    return null;
                }
            }
            return null;
        }, new Block[]{(Block) deferredBlock.get()});
    }

    @Nullable
    public AABB a(LevelReader levelReader, BlockPos blockPos) {
        Vec3i vec3iG;
        BlockPos blockPosA = a((BlockGetter) levelReader, blockPos);
        if (blockPosA == null) {
            return null;
        }
        BlockEntity blockEntity = levelReader.getBlockEntity(blockPosA);
        if (!(blockEntity instanceof mctech.p.b.b) || (vec3iG = ((mctech.p.b.b) blockEntity).g()) == null) {
            return null;
        }
        return new AABB(blockPosA.getX(), blockPosA.getY(), blockPosA.getZ(), blockPosA.getX() + vec3iG.getX(), blockPosA.getY() + vec3iG.getY(), blockPosA.getZ() + vec3iG.getZ());
    }

    public boolean b(BlockGetter blockGetter, BlockPos blockPos) {
        BlockPos blockPosA = a(blockGetter, blockPos);
        if (blockPosA == null) {
            return false;
        }
        BlockEntity blockEntity = blockGetter.getBlockEntity(blockPosA);
        return (blockEntity instanceof mctech.p.b.b) && ((mctech.p.b.b) blockEntity).i();
    }

    public void a(BlockGetter blockGetter, BlockPos blockPos, b bVar) {
        a(blockGetter, blockPos, true, bVar);
    }

    public void a(BlockGetter blockGetter, BlockPos blockPos, boolean z, b bVar) {
        BlockPos blockPosA = a(blockGetter, blockPos);
        if (blockPosA == null) {
            bVar.a(blockGetter, blockPos);
            return;
        }
        BlockEntity blockEntity = blockGetter.getBlockEntity(blockPosA);
        if (blockEntity instanceof mctech.p.b.b) {
            mctech.p.b.b bVar2 = (mctech.p.b.b) blockEntity;
            if (z && bVar2.i()) {
                bVar.a(blockGetter, blockPosA, bVar2);
                return;
            } else {
                if (!z) {
                    bVar.a(blockGetter, blockPosA, bVar2);
                    return;
                }
                return;
            }
        }
        bVar.a(blockGetter, blockPos);
    }
}
