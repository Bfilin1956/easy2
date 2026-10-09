package mctech.p.b.a;

import mctech.MCTech;
import mctech.api.features.IClickable;
import mctech.api.features.ICollideable;
import mctech.api.features.IParticleSpawner;
import mctech.init.MCTechProperties;
import net.mcskill.msregistry.registry.holder.LBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.Nameable;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/p/b/a/a.class */
public class a<BE extends BlockEntity, TBE extends BlockEntity> extends mctech.p.b.a<BE, TBE> {
    public static final BooleanProperty b = MCTechProperties.ACTIVE;

    public a(BlockBehaviour.Properties properties, LBlockEntity<BE> lBlockEntity, LBlockEntity<TBE> lBlockEntity2) {
        super(properties.isValidSpawn(Blocks::never), lBlockEntity, lBlockEntity2);
        registerDefaultState((BlockState) defaultBlockState().setValue(b, false));
    }

    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(@NotNull Level level, @NotNull BlockState blockState, @NotNull BlockEntityType<T> blockEntityType) {
        return null;
    }

    @Override // mctech.p.b.a
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

    protected void neighborChanged(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, @NotNull final Block block, @NotNull final BlockPos blockPos2, boolean z) {
        super.neighborChanged(blockState, level, blockPos, block, blockPos2, z);
        a((BlockGetter) level, blockPos, new mctech.p.b.a.b(this) { // from class: mctech.p.b.a.a.1
            @Override // mctech.p.b.a.b
            public void a(@NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos3, @NotNull mctech.p.b.b bVar) {
                if (bVar instanceof e) {
                    ((e) bVar).a(block, blockPos2);
                }
            }

            @Override // mctech.p.b.a.b
            public void a(@NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos3) {
            }
        });
    }

    protected void entityInside(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, @NotNull final Entity entity) {
        a((BlockGetter) level, blockPos, new mctech.p.b.a.b(this) { // from class: mctech.p.b.a.a.2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // mctech.p.b.a.b
            public void a(@NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos2, @NotNull mctech.p.b.b bVar) {
                if (bVar instanceof ICollideable) {
                    ((ICollideable) bVar).onEntityCollided(entity);
                }
            }

            @Override // mctech.p.b.a.b
            public void a(@NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos2) {
            }
        });
    }

    public void animateTick(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, @NotNull final RandomSource randomSource) {
        super.animateTick(blockState, level, blockPos, randomSource);
        a((BlockGetter) level, blockPos, new mctech.p.b.a.b(this) { // from class: mctech.p.b.a.a.3
            /* JADX WARN: Multi-variable type inference failed */
            @Override // mctech.p.b.a.b
            public void a(@NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos2, @NotNull mctech.p.b.b bVar) {
                if (bVar instanceof IParticleSpawner) {
                    ((IParticleSpawner) bVar).animationTick(randomSource);
                }
            }

            @Override // mctech.p.b.a.b
            public void a(@NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos2) {
            }
        });
    }

    @NotNull
    public ItemStack getCloneItemStack(@NotNull BlockState blockState, @NotNull HitResult hitResult, @NotNull LevelReader levelReader, @NotNull BlockPos blockPos, @NotNull Player player) {
        ItemStack cloneItemStack = super.getCloneItemStack(blockState, hitResult, levelReader, blockPos, player);
        Nameable blockEntity = levelReader.getBlockEntity(blockPos);
        if (blockEntity instanceof Nameable) {
            cloneItemStack.set(DataComponents.CUSTOM_NAME, blockEntity.getName());
        }
        return cloneItemStack;
    }

    @NotNull
    protected final BlockState rotate(@NotNull BlockState blockState, @NotNull Rotation rotation) {
        return blockState;
    }

    @NotNull
    protected final BlockState mirror(@NotNull BlockState blockState, @NotNull Mirror mirror) {
        return blockState;
    }

    @Override // mctech.p.b.a
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder.add(new Property[]{b}));
    }

    @Nullable
    public BlockState getStateForPlacement(@NotNull BlockPlaceContext blockPlaceContext) {
        return (BlockState) defaultBlockState().setValue(b, false);
    }
}
