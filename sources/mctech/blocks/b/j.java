package mctech.blocks.b;

import com.mojang.serialization.MapCodec;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import mctech.api.blocks.IWrenchable;
import mctech.blockentities.b.l;
import mctech.init.MCTechBlocks;
import mctech.init.MCTechCodecs;
import mctech.init.MCTechTiles;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blocks/b/j.class */
public class j extends mctech.p.b.c implements IWrenchable {
    private static final mctech.p.a.f d = new mctech.p.a.f(b());

    public j(BlockBehaviour.Properties properties) {
        super(properties, MCTechTiles.WINDMILL_GENERATOR, MCTechTiles.WINDMILL_GENERATOR_TEMPLATE);
    }

    @Override // mctech.p.b.c
    @NotNull
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return MCTechCodecs.WINDMILL_GENERATOR_BLOCK_CODEC;
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

    @NotNull
    public List<ItemStack> getDrops(@NotNull BlockState blockState, LootParams.Builder builder) {
        if (!a(blockState)) {
            return List.of();
        }
        BlockEntity blockEntity = (BlockEntity) builder.getOptionalParameter(LootContextParams.BLOCK_ENTITY);
        if (!(blockEntity instanceof l)) {
            return List.of();
        }
        l lVar = (l) blockEntity;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ItemStack((ItemLike) MCTechBlocks.MACHINE_BLOCK.get()));
        arrayList.addAll(lVar.U_().toList());
        return arrayList;
    }

    @Override // mctech.p.b.c
    protected boolean canSurvive(@NotNull BlockState blockState, @NotNull LevelReader levelReader, @NotNull BlockPos blockPos) {
        return super.canSurvive(blockState, levelReader, blockPos) && BlockPos.betweenClosedStream(new AABB(blockPos).inflate(5.0d)).noneMatch(blockPos2 -> {
            return levelReader.getBlockState(blockPos2).is((Block) MCTechBlocks.WINDMILL.get());
        });
    }

    @Override // mctech.api.blocks.IWrenchable
    public Direction getFacing(BlockState blockState, Level level, BlockPos blockPos) {
        return (Direction) blockState.getOptionalValue(b).orElse(Direction.NORTH);
    }

    @Override // mctech.api.blocks.IWrenchable
    public boolean canSetFacing(BlockState blockState, Level level, BlockPos blockPos, Player player, Direction direction) {
        l lVarB = b((BlockGetter) level, blockPos);
        return lVarB != null && lVarB.canSetFacing(direction);
    }

    @Override // mctech.api.blocks.IWrenchable
    public boolean setFacing(BlockState blockState, Level level, BlockPos blockPos, Player player, Direction direction) {
        l lVarB = b((BlockGetter) level, blockPos);
        if (lVarB == null || !lVarB.canSetFacing(direction)) {
            return false;
        }
        BlockPos blockPos2 = lVarB.getBlockPos();
        BlockState blockState2 = level.getBlockState(blockPos2);
        level.setBlock(blockPos2, (BlockState) blockState2.setValue(b, direction), 3);
        a((BlockGetter) level, blockPos2, (BlockState) blockState2.setValue(b, direction), blockPos3 -> {
            BlockState blockState3 = level.getBlockState(blockPos3);
            if (blockState3.getBlock() == this && !a(blockState3)) {
                level.setBlock(blockPos3, (BlockState) blockState3.setValue(b, direction), 3);
            }
        });
        lVarB.setFacing(direction);
        return true;
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

    @Override // mctech.api.blocks.IWrenchable
    public boolean canRemoveBlock(BlockState blockState, Level level, BlockPos blockPos, Player player) {
        l lVarB = b((BlockGetter) level, blockPos);
        return lVarB != null && lVarB.canRemoveBlock(player);
    }

    @Override // mctech.api.blocks.IWrenchable
    public double getDropRate(BlockState blockState, Level level, BlockPos blockPos, Player player) {
        l lVarB = b((BlockGetter) level, blockPos);
        if (lVarB == null) {
            return 0.0d;
        }
        return lVarB.getDropRate(player);
    }

    @Override // mctech.api.blocks.IWrenchable
    @NotNull
    public List<ItemStack> getDrops(BlockState blockState, Level level, BlockPos blockPos, Player player) {
        l lVarB = b((BlockGetter) level, blockPos);
        if (lVarB == null) {
            return List.of();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ItemStack(this));
        arrayList.addAll(lVarB.U_().toList());
        return arrayList;
    }

    @Nullable
    private l b(BlockGetter blockGetter, BlockPos blockPos) {
        BlockPos blockPosA = a(blockGetter, blockPos);
        if (blockPosA == null) {
            return null;
        }
        BlockEntity blockEntity = blockGetter.getBlockEntity(blockPosA);
        if (blockEntity instanceof l) {
            return (l) blockEntity;
        }
        return null;
    }

    @NotNull
    private VoxelShape a(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos) {
        BlockPos blockPosA = a(blockGetter, blockPos);
        if (blockPosA == null) {
            return Shapes.block();
        }
        if (!(blockGetter.getBlockEntity(blockPosA) instanceof l)) {
            return Shapes.block();
        }
        Direction value = blockState.getValue(b);
        BlockPos blockPosSubtract = blockPosA.subtract(new Vec3i(blockPos.getX(), blockPos.getY(), blockPos.getZ()));
        return d.a(value).move(blockPosSubtract.getX(), blockPosSubtract.getY(), blockPosSubtract.getZ());
    }

    public static AABB a() {
        return new AABB(-1.0d, 0.0d, -1.0d, 2.0d, 7.0d, 2.0d);
    }

    private static VoxelShape b() {
        return Shapes.join(Shapes.join(Shapes.join(Shapes.join(Shapes.join(Shapes.join(Shapes.empty(), Shapes.box(-1.0d, 0.0d, -1.0d, 2.0d, 1.0d, 2.0d), BooleanOp.OR), Shapes.box(-0.125d, 1.0d, -0.125d, 1.125d, 1.5d, 1.125d), BooleanOp.OR), Shapes.box(0.0625d, 1.5d, 0.0625d, 0.9375d, 2.5d, 0.9375d), BooleanOp.OR), Shapes.box(0.125d, 2.5d, 0.125d, 0.875d, 4.0d, 0.875d), BooleanOp.OR), Shapes.box(0.1875d, 4.0d, 0.1875d, 0.8125d, 5.75d, 0.8125d), BooleanOp.OR), Shapes.box(0.0d, 5.75d, 0.0d, 1.0d, 7.0d, 1.875d), BooleanOp.OR);
    }
}
