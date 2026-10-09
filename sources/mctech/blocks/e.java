package mctech.blocks;

import javax.annotation.Nullable;
import mctech.blockentities.f.g;
import mctech.blockentities.p;
import net.mcskill.msregistry.registry.holder.LBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blocks/e.class */
public class e extends b {
    private LBlockEntity<?> c;
    private boolean d;

    public e(BlockBehaviour.Properties properties) {
        super(properties);
        registerDefaultState((BlockState) this.stateDefinition.any().setValue(FACING, Direction.UP));
    }

    @Override // mctech.blocks.base.e
    @NotNull
    public RenderShape getRenderShape(@NotNull BlockState blockState) {
        return this.d ? RenderShape.ENTITYBLOCK_ANIMATED : super.getRenderShape(blockState);
    }

    @Override // mctech.blocks.base.blocks.BaseFacingBlock
    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        return (BlockState) ((BlockState) defaultBlockState().setValue(FACING, Direction.UP)).setValue(ACTIVE, false);
    }

    public void setPlacedBy(@NotNull Level level, @NotNull BlockPos blockPos, @NotNull BlockState blockState, LivingEntity livingEntity, @NotNull ItemStack itemStack) {
        super.setPlacedBy(level, blockPos, blockState, livingEntity, itemStack);
        if (livingEntity instanceof Player) {
            Player player = (Player) livingEntity;
            BlockEntity blockEntity = level.getBlockEntity(blockPos);
            if (blockEntity instanceof p) {
                ((p) blockEntity).a(player);
            }
        }
    }

    public boolean onDestroyedByPlayer(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, @NotNull Player player, boolean z, @NotNull FluidState fluidState) {
        BlockEntity blockEntity = level.getBlockEntity(blockPos);
        if (blockEntity instanceof p) {
            ((p) blockEntity).f().ifPresent(eVar -> {
                g.a().b(eVar);
            });
        }
        return super.onDestroyedByPlayer(blockState, level, blockPos, player, z, fluidState);
    }

    public e a(LBlockEntity<?> lBlockEntity) {
        this.c = lBlockEntity;
        return this;
    }

    public e a(boolean z) {
        this.d = z;
        return this;
    }

    @Override // mctech.blocks.base.e
    @Nullable
    public BlockEntity newBlockEntity(@NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        return ((BlockEntityType) this.c.get()).create(blockPos, blockState);
    }
}
