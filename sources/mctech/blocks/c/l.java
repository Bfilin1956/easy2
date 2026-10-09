package mctech.blocks.c;

import com.mojang.serialization.MapCodec;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import mctech.api.blocks.IWrenchable;
import mctech.blockentities.c.C0074u;
import mctech.init.MCTechCodecs;
import mctech.init.MCTechTiles;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blocks/c/l.class */
public class l extends mctech.p.b.c implements IWrenchable {
    private static final mctech.p.a.f d = new mctech.p.a.f(b());

    public l(BlockBehaviour.Properties properties) {
        super(properties, MCTechTiles.GLASS_FURNACE, MCTechTiles.GLASS_FURNACE_TEMPLATE);
    }

    @Override // mctech.p.b.c
    @Nullable
    public BlockState getStateForPlacement(@NotNull BlockPlaceContext blockPlaceContext) {
        FluidState fluidState = blockPlaceContext.getLevel().getFluidState(blockPlaceContext.getClickedPos());
        Direction horizontalDirection = blockPlaceContext.getHorizontalDirection();
        return (BlockState) ((BlockState) ((BlockState) defaultBlockState().setValue(b, (blockPlaceContext.getPlayer() == null || !blockPlaceContext.getPlayer().isShiftKeyDown()) ? horizontalDirection : horizontalDirection.getOpposite())).setValue(c, Boolean.valueOf(fluidState.getType() == Fluids.WATER))).setValue(a, true);
    }

    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(@NotNull Level level, @NotNull BlockState blockState, @NotNull BlockEntityType<T> blockEntityType) {
        return null;
    }

    @Override // mctech.p.b.c
    @NotNull
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return MCTechCodecs.GLASS_FURNACE_BLOCK_CODEC;
    }

    @NotNull
    public RenderShape getRenderShape(@NotNull BlockState blockState) {
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }

    @Override // mctech.p.b.c
    public AABB a(@Nullable BlockGetter blockGetter, @Nullable BlockPos blockPos, @NotNull BlockState blockState) {
        return a();
    }

    @NotNull
    protected VoxelShape getVisualShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return getShape(blockState, blockGetter, blockPos, collisionContext);
    }

    @NotNull
    protected VoxelShape getCollisionShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return getShape(blockState, blockGetter, blockPos, collisionContext);
    }

    @NotNull
    protected VoxelShape getShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return a(blockState, blockGetter, blockPos);
    }

    @NotNull
    protected VoxelShape getOcclusionShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos) {
        return a(blockState, blockGetter, blockPos);
    }

    @NotNull
    protected VoxelShape getInteractionShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos) {
        return a(blockState, blockGetter, blockPos);
    }

    public boolean hasDynamicShape() {
        return true;
    }

    protected boolean useShapeForLightOcclusion(@NotNull BlockState blockState) {
        return true;
    }

    protected boolean isCollisionShapeFullBlock(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos) {
        return false;
    }

    @Override // mctech.api.blocks.IWrenchable
    public Direction getFacing(BlockState blockState, Level level, BlockPos blockPos) {
        return (Direction) blockState.getOptionalValue(b).orElse(Direction.NORTH);
    }

    @Override // mctech.api.blocks.IWrenchable
    public boolean canSetFacing(BlockState blockState, Level level, BlockPos blockPos, Player player, Direction direction) {
        return false;
    }

    @Override // mctech.api.blocks.IWrenchable
    public boolean setFacing(BlockState blockState, Level level, BlockPos blockPos, Player player, Direction direction) {
        return false;
    }

    @Override // mctech.api.blocks.IWrenchable
    public boolean doSpecialAction(BlockState blockState, Level level, BlockPos blockPos, Direction direction, Player player, Vec3 vec3) {
        return false;
    }

    @Override // mctech.api.blocks.IWrenchable
    @Nullable
    public AABB hasSpecialAction(BlockState blockState, Level level, BlockPos blockPos, Direction direction, Player player, Vec3 vec3) {
        return null;
    }

    @Override // mctech.p.b.c
    public void a(@NotNull BlockState blockState, @NotNull LevelReader levelReader, @NotNull BlockPos blockPos, @NotNull BlockPos blockPos2) {
        BlockEntity blockEntity = levelReader.getBlockEntity(blockPos);
        if (blockEntity instanceof C0074u) {
            ((C0074u) blockEntity).onBlockUpdate(blockState.getBlock(), blockPos2);
        }
    }

    public boolean canConnectRedstone(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @Nullable Direction direction) {
        if (a(blockState)) {
            return true;
        }
        if (direction == ((Direction) blockState.getOptionalValue(b).orElse(Direction.NORTH)).getOpposite() && b(blockGetter, blockPos, blockState)) {
            return true;
        }
        return super.canConnectRedstone(blockState, blockGetter, blockPos, direction);
    }

    @NotNull
    public VoxelShape getBlockSupportShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos) {
        if (b(blockGetter, blockPos, blockState)) {
            return a((Direction) blockState.getOptionalValue(b).orElse(Direction.NORTH));
        }
        return a(blockState, blockGetter, blockPos);
    }

    private boolean b(@NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        BlockPos blockPosA;
        if (a(blockState) || (blockPosA = a(blockGetter, blockPos)) == null || blockPosA.equals(blockPos)) {
            return false;
        }
        Direction direction = (Direction) blockState.getOptionalValue(b).orElse(Direction.NORTH);
        BlockPos blockPosRelative = blockPosA.relative(direction);
        return blockPosRelative.equals(blockPos) || blockPosRelative.relative(direction.getCounterClockWise()).equals(blockPos) || blockPosRelative.relative(Direction.UP).equals(blockPos);
    }

    /* JADX INFO: renamed from: mctech.blocks.c.l$1, reason: invalid class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blocks/c/l$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[Direction.values().length];

        static {
            try {
                a[Direction.SOUTH.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[Direction.WEST.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[Direction.EAST.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    @NotNull
    private static VoxelShape a(@NotNull Direction direction) {
        switch (AnonymousClass1.a[direction.ordinal()]) {
            case 1:
                return Shapes.box(0.0d, 0.0d, 0.9375d, 1.0d, 1.0d, 1.0d);
            case 2:
                return Shapes.box(0.0d, 0.0d, 0.0d, 0.0625d, 1.0d, 1.0d);
            case 3:
                return Shapes.box(0.9375d, 0.0d, 0.0d, 1.0d, 1.0d, 1.0d);
            default:
                return Shapes.box(0.0d, 0.0d, 0.0d, 1.0d, 1.0d, 0.0625d);
        }
    }

    @NotNull
    protected final BlockState rotate(@NotNull BlockState blockState, @NotNull Rotation rotation) {
        return blockState;
    }

    @NotNull
    protected final BlockState mirror(@NotNull BlockState blockState, @NotNull Mirror mirror) {
        return blockState;
    }

    @Override // mctech.api.blocks.IWrenchable
    public boolean canRemoveBlock(BlockState blockState, Level level, BlockPos blockPos, Player player) {
        C0074u c0074uB = b((BlockGetter) level, blockPos);
        return c0074uB != null && c0074uB.canRemoveBlock(player);
    }

    @Override // mctech.api.blocks.IWrenchable
    public double getDropRate(BlockState blockState, Level level, BlockPos blockPos, Player player) {
        C0074u c0074uB = b((BlockGetter) level, blockPos);
        if (c0074uB == null) {
            return 0.0d;
        }
        return c0074uB.getDropRate(player);
    }

    @Override // mctech.api.blocks.IWrenchable
    @NotNull
    public List<ItemStack> getDrops(BlockState blockState, Level level, BlockPos blockPos, Player player) {
        C0074u c0074uB = b((BlockGetter) level, blockPos);
        if (c0074uB == null) {
            return List.of();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ItemStack(this));
        arrayList.addAll(c0074uB.U_().toList());
        return arrayList;
    }

    @Nullable
    private C0074u b(BlockGetter blockGetter, BlockPos blockPos) {
        BlockPos blockPosA = a(blockGetter, blockPos);
        if (blockPosA == null) {
            return null;
        }
        BlockEntity blockEntity = blockGetter.getBlockEntity(blockPosA);
        if (blockEntity instanceof C0074u) {
            return (C0074u) blockEntity;
        }
        return null;
    }

    @NotNull
    private VoxelShape a(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos) {
        BlockPos blockPosA = a(blockGetter, blockPos);
        if (blockPosA == null) {
            return Shapes.block();
        }
        if (!(blockGetter.getBlockEntity(blockPosA) instanceof C0074u)) {
            return Shapes.block();
        }
        Direction value = blockState.getValue(b);
        BlockPos blockPosSubtract = blockPosA.subtract(new Vec3i(blockPos.getX(), blockPos.getY(), blockPos.getZ()));
        return d.a(value).move(blockPosSubtract.getX(), blockPosSubtract.getY(), blockPosSubtract.getZ());
    }

    public static AABB a() {
        return new AABB(-1.0d, 0.0d, -1.0d, 2.0d, 3.0d, 2.0d);
    }

    private static VoxelShape b() {
        return Shapes.join(Shapes.join(Shapes.join(Shapes.join(Shapes.join(Shapes.join(Shapes.empty(), Shapes.box(-1.0d, 0.0d, -1.0d, 2.0d, 0.875d, 2.0d), BooleanOp.OR), Shapes.box(-0.0625d, 0.8125d, -0.25d, 1.5625d, 2.375d, 1.375d), BooleanOp.OR), Shapes.box(0.0d, 0.875d, -1.0d, 1.0d, 2.0d, -0.3125d), BooleanOp.OR), Shapes.box(-1.0d, 0.0d, -0.9375d, 0.0d, 1.0d, -0.3125d), BooleanOp.OR), Shapes.box(-1.0d, 0.875d, 0.875d, -0.125d, 3.0d, 1.8125d), BooleanOp.OR), Shapes.box(-0.6875d, 1.3125d, -0.0625d, 0.5625d, 1.5625d, 0.875d), BooleanOp.OR);
    }
}
