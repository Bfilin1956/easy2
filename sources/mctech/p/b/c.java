package mctech.p.b;

import com.mojang.serialization.MapCodec;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import mctech.MCTech;
import mctech.api.blocks.IWrenchable;
import mctech.api.features.IClickable;
import mctech.utils.C0199a;
import net.mcskill.msregistry.registry.holder.LBlock;
import net.mcskill.msregistry.registry.holder.LBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.neoforged.neoforge.capabilities.BlockCapability;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/p/b/c.class */
public class c extends BaseEntityBlock implements SimpleWaterloggedBlock {
    private final LBlockEntity<?> f;
    private final LBlockEntity<?> g;
    private static final MapCodec<c> d = MapCodec.unit((Supplier) null);
    private static final ThreadLocal<Boolean> e = ThreadLocal.withInitial(() -> {
        return false;
    });
    public static final BooleanProperty a = BooleanProperty.create("is_master");
    public static final DirectionProperty b = HorizontalDirectionalBlock.FACING;
    public static final BooleanProperty c = BlockStateProperties.WATERLOGGED;

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/p/b/c$a.class */
    public interface a<Cap, Context, BE extends BlockEntity> {
        Cap a(BE be, Context context);
    }

    public c(BlockBehaviour.Properties properties, LBlockEntity<?> lBlockEntity, LBlockEntity<?> lBlockEntity2) {
        super(properties.isViewBlocking((blockState, blockGetter, blockPos) -> {
            return false;
        }).isSuffocating((blockState2, blockGetter2, blockPos2) -> {
            return false;
        }));
        this.f = lBlockEntity;
        this.g = lBlockEntity2;
        registerDefaultState((BlockState) ((BlockState) ((BlockState) this.stateDefinition.any().setValue(a, false)).setValue(c, false)).setValue(b, Direction.NORTH));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{a}).add(new Property[]{b}).add(new Property[]{c});
    }

    @Nullable
    public BlockState getStateForPlacement(@NotNull BlockPlaceContext blockPlaceContext) {
        return (BlockState) ((BlockState) ((BlockState) defaultBlockState().setValue(b, blockPlaceContext.getHorizontalDirection().getOpposite())).setValue(c, Boolean.valueOf(blockPlaceContext.getLevel().getFluidState(blockPlaceContext.getClickedPos()).getType() == Fluids.WATER))).setValue(a, true);
    }

    @NotNull
    protected FluidState getFluidState(@NotNull BlockState blockState) {
        return ((Boolean) blockState.getValue(c)).booleanValue() ? Fluids.WATER.getSource(false) : super.getFluidState(blockState);
    }

    public boolean canPlaceLiquid(@Nullable Player player, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull BlockState blockState, @NotNull Fluid fluid) {
        return true;
    }

    public boolean placeLiquid(@NotNull LevelAccessor levelAccessor, @NotNull BlockPos blockPos, @NotNull BlockState blockState, @NotNull FluidState fluidState) {
        return false;
    }

    public AABB a(@Nullable BlockGetter blockGetter, @Nullable BlockPos blockPos, @NotNull BlockState blockState) {
        return new AABB(0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d);
    }

    public boolean a(BlockState blockState) {
        return !blockState.isAir() && ((Boolean) blockState.getOptionalValue(a).orElse(false)).booleanValue();
    }

    @Nullable
    public BlockPos a(BlockGetter blockGetter, BlockPos blockPos) {
        if (blockGetter == null) {
            return null;
        }
        if ((blockGetter instanceof Level) && !((Level) blockGetter).isLoaded(blockPos)) {
            return null;
        }
        BlockEntity blockEntity = blockGetter.getBlockEntity(blockPos);
        if (blockEntity instanceof d) {
            d dVar = (d) blockEntity;
            if (dVar.b()) {
                return dVar.a();
            }
        }
        BlockState blockState = blockGetter.getBlockState(blockPos);
        if (!blockState.isAir() && a(blockState)) {
            return blockPos;
        }
        return null;
    }

    protected boolean canSurvive(@NotNull BlockState blockState, @NotNull LevelReader levelReader, @NotNull BlockPos blockPos) {
        return a(blockState, levelReader, blockPos, a((BlockGetter) levelReader, blockPos, blockState), false);
    }

    public boolean a(@NotNull BlockState blockState, @NotNull LevelReader levelReader, @NotNull BlockPos blockPos, AABB aabb, boolean z) {
        if (a(blockState)) {
            AABB aabbA = C0199a.a(aabb, (Direction) blockState.getOptionalValue(b).orElse(Direction.NORTH));
            boolean z2 = true;
            for (BlockPos blockPos2 : BlockPos.betweenClosed(blockPos.offset((int) Math.floor(aabbA.minX), (int) Math.floor(aabbA.minY), (int) Math.floor(aabbA.minZ)), blockPos.offset((int) Math.ceil(aabbA.maxX), (int) Math.ceil(aabbA.maxY), (int) Math.ceil(aabbA.maxZ)))) {
                if (!blockPos2.equals(blockPos)) {
                    BlockState blockState2 = levelReader.getBlockState(blockPos2);
                    if (!(blockState2.getBlock() instanceof c) || !z) {
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

    private void a(@NotNull Level level, @NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        a((BlockGetter) level, blockPos, blockState, blockPos2 -> {
            if (level.isEmptyBlock(blockPos2) || level.getBlockState(blockPos2).canBeReplaced()) {
                level.setBlock(blockPos2, (BlockState) ((BlockState) defaultBlockState().setValue(a, false)).setValue(b, blockState.getValue(b)), 3);
                BlockEntity blockEntity = level.getBlockEntity(blockPos2);
                if (blockEntity instanceof d) {
                    ((d) blockEntity).a(blockPos);
                }
            }
        });
    }

    public void onPlace(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, @NotNull BlockState blockState2, boolean z) {
        super.onPlace(blockState, level, blockPos, blockState2, z);
        if (a(blockState) && blockState2.getBlock() != this) {
            a(level, blockPos, blockState);
        }
    }

    public void setPlacedBy(@NotNull Level level, @NotNull BlockPos blockPos, @NotNull BlockState blockState, @Nullable LivingEntity livingEntity, @NotNull ItemStack itemStack) {
        super.setPlacedBy(level, blockPos, blockState, livingEntity, itemStack);
        if (a(blockState)) {
            a(level, blockPos, blockState);
        }
    }

    public boolean onDestroyedByPlayer(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, @NotNull Player player, boolean z, @NotNull FluidState fluidState) {
        if (level.isClientSide) {
            return false;
        }
        BlockPos blockPosA = a((BlockGetter) level, blockPos);
        if (blockPosA == null) {
            return super.onDestroyedByPlayer(blockState, level, blockPos, player, z, fluidState);
        }
        BlockState blockState2 = level.getBlockState(blockPosA);
        BlockEntity blockEntity = level.getBlockEntity(blockPosA);
        if (!player.isCreative()) {
            a(level, blockPosA, blockState2, blockEntity, player, blockPos);
        }
        b(level, blockPosA, blockState2);
        return false;
    }

    private void a(@NotNull Level level, @NotNull BlockPos blockPos, @NotNull BlockState blockState, @Nullable BlockEntity blockEntity, @NotNull Player player, @NotNull BlockPos blockPos2) {
        List<ItemStack> listOf;
        IWrenchable block = blockState.getBlock();
        if (block instanceof IWrenchable) {
            listOf = block.getDrops(blockState, level, blockPos, player);
        } else if (level instanceof ServerLevel) {
            listOf = Block.getDrops(blockState, (ServerLevel) level, blockPos, blockEntity, player, player.getMainHandItem());
        } else {
            listOf = List.of(new ItemStack(blockState.getBlock()));
        }
        for (ItemStack itemStack : listOf) {
            if (!itemStack.isEmpty()) {
                Block.popResource(level, blockPos2, itemStack.copy());
            }
        }
    }

    private void b(@NotNull Level level, @NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        e.set(true);
        try {
            a((BlockGetter) level, blockPos, blockState, blockPos2 -> {
                BlockState blockState2 = level.getBlockState(blockPos2);
                if (blockState2.getBlock() == this && !a(blockState2)) {
                    level.removeBlock(blockPos2, false);
                }
            });
            if (level.getBlockState(blockPos).getBlock() == this) {
                level.removeBlock(blockPos, false);
            }
        } finally {
            e.set(Boolean.valueOf(false));
        }
    }

    public void onRemove(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, @NotNull BlockState blockState2, boolean z) {
        if (!e.get().booleanValue()) {
            if (a(blockState)) {
                a((BlockGetter) level, blockPos, blockState, blockPos2 -> {
                    BlockState blockState3 = level.getBlockState(blockPos2);
                    if (blockState3.getBlock() == this && !a(blockState3)) {
                        level.removeBlock(blockPos2, false);
                    }
                });
            } else {
                BlockPos blockPosA = a((BlockGetter) level, blockPos);
                if (blockPosA != null && !blockPosA.equals(blockPos)) {
                    level.removeBlock(blockPosA, false);
                }
            }
        }
        super.onRemove(blockState, level, blockPos, blockState2, z);
    }

    public void onNeighborChange(@NotNull BlockState blockState, @NotNull LevelReader levelReader, @NotNull BlockPos blockPos, @NotNull BlockPos blockPos2) {
        if (levelReader.getBlockState(blockPos2).getBlock() instanceof c) {
            return;
        }
        if (!a(blockState)) {
            BlockPos blockPosA = a((BlockGetter) levelReader, blockPos);
            if (blockPosA != null && !blockPosA.equals(blockPos)) {
                levelReader.getBlockState(blockPosA).onNeighborChange(levelReader, blockPosA, blockPos2);
                return;
            }
            return;
        }
        a(blockState, levelReader, blockPos, blockPos2);
    }

    protected void neighborChanged(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, @NotNull Block block, @NotNull BlockPos blockPos2, boolean z) {
        if (block instanceof c) {
            return;
        }
        if (!a(blockState)) {
            BlockPos blockPosA = a((BlockGetter) level, blockPos);
            if (blockPosA != null && !blockPosA.equals(blockPos)) {
                level.getBlockState(blockPosA).onNeighborChange(level, blockPosA, blockPos2);
                return;
            }
            return;
        }
        a(blockState, (LevelReader) level, blockPos, blockPos2);
    }

    public void a(@NotNull BlockState blockState, @NotNull LevelReader levelReader, @NotNull BlockPos blockPos, @NotNull BlockPos blockPos2) {
    }

    @NotNull
    public InteractionResult useWithoutItem(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, @NotNull Player player, @NotNull BlockHitResult blockHitResult) {
        if (!a(blockState)) {
            BlockPos blockPosA = a((BlockGetter) level, blockPos);
            if (blockPosA != null && !blockPosA.equals(blockPos)) {
                return level.getBlockState(blockPosA).useWithoutItem(level, player, new BlockHitResult(blockPosA.getCenter(), blockHitResult.getDirection(), blockPosA, blockHitResult.isInside()));
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
                return level.getBlockState(blockPosA).useItemOn(itemStack, level, player, interactionHand, new BlockHitResult(blockPosA.getCenter(), blockHitResult.getDirection(), blockPosA, blockHitResult.isInside()));
            }
            return ItemInteractionResult.sidedSuccess(level.isClientSide);
        }
        return a(itemStack, blockState, level, blockPos, player, interactionHand, blockHitResult);
    }

    protected ItemInteractionResult a(@NotNull ItemStack itemStack, @NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, @NotNull Player player, @NotNull InteractionHand interactionHand, @NotNull BlockHitResult blockHitResult) {
        mctech.m.a.d blockEntity = level.getBlockEntity(blockPos);
        if (blockEntity instanceof IClickable) {
            IClickable iClickable = (IClickable) blockEntity;
            if (iClickable.getRequiredActions().canDoRightClick() && iClickable.onRightClick(player, interactionHand, blockHitResult.getDirection(), blockHitResult)) {
                return ItemInteractionResult.SUCCESS;
            }
        }
        if (player.isShiftKeyDown()) {
            return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
        }
        if (blockEntity instanceof mctech.m.a.d) {
            mctech.m.a.d dVar = blockEntity;
            if ((MCTech.PLATFORM.h() && dVar.a(player, interactionHand, blockHitResult.getDirection())) || MCTech.PLATFORM.a(player, interactionHand, blockHitResult.getDirection(), dVar)) {
                return ItemInteractionResult.SUCCESS;
            }
        }
        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    protected void attack(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, @NotNull Player player) {
        BlockPos blockPosA = a((BlockGetter) level, blockPos);
        if (blockPosA != null) {
            IClickable blockEntity = level.getBlockEntity(blockPosA);
            if (blockEntity instanceof IClickable) {
                IClickable iClickable = blockEntity;
                if (iClickable.getRequiredActions().canDoLeftClick()) {
                    iClickable.onLeftClick(player, blockPosA);
                }
            }
        }
    }

    @Nullable
    public BlockEntity newBlockEntity(@NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        if (a(blockState)) {
            return ((BlockEntityType) this.f.get()).create(blockPos, blockState);
        }
        return ((BlockEntityType) this.g.get()).create(blockPos, blockState);
    }

    public void a(@NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull BlockState blockState, @NotNull Consumer<BlockPos> consumer) {
        a((Direction) blockState.getOptionalValue(b).orElse(Direction.NORTH), a(blockGetter, blockPos, blockState), blockPos, consumer);
    }

    public void a(@NotNull Direction direction, @NotNull AABB aabb, @NotNull BlockPos blockPos, @NotNull Consumer<BlockPos> consumer) {
        BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
        AABB aabbA = C0199a.a(aabb, direction);
        int iFloor = (int) Math.floor(aabbA.minX);
        int iFloor2 = (int) Math.floor(aabbA.minY);
        int iFloor3 = (int) Math.floor(aabbA.minZ);
        int iCeil = (int) Math.ceil(aabbA.maxX);
        int iCeil2 = (int) Math.ceil(aabbA.maxY);
        int iCeil3 = (int) Math.ceil(aabbA.maxZ);
        for (int i = iFloor; i < iCeil; i++) {
            for (int i2 = iFloor2; i2 < iCeil2; i2++) {
                for (int i3 = iFloor3; i3 < iCeil3; i3++) {
                    if (i != 0 || i2 != 0 || i3 != 0) {
                        mutableBlockPos.set(blockPos.getX() + i, blockPos.getY() + i2, blockPos.getZ() + i3);
                        consumer.accept(mutableBlockPos);
                    }
                }
            }
        }
    }

    @Nullable
    public PushReaction getPistonPushReaction(@NotNull BlockState blockState) {
        return PushReaction.BLOCK;
    }

    @NotNull
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return d;
    }

    public static <T, C, BE extends BlockEntity> void a(RegisterCapabilitiesEvent registerCapabilitiesEvent, BlockCapability<T, C> blockCapability, a<T, C, BE> aVar, LBlock<? extends Block> lBlock) {
        registerCapabilitiesEvent.registerBlock(blockCapability, (level, blockPos, blockState, blockEntity, obj) -> {
            BlockPos blockPosA;
            BlockEntity blockEntity;
            if ((blockEntity instanceof d) && (blockPosA = ((d) blockEntity).a()) != null && level.isLoaded(blockPosA) && (blockEntity = level.getBlockEntity(blockPosA)) != null) {
                try {
                    return aVar.a(blockEntity, obj);
                } catch (ClassCastException e2) {
                    return null;
                }
            }
            return null;
        }, new Block[]{(Block) lBlock.get()});
    }
}
