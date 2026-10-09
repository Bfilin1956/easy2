package mctech.g.d.a.a;

import com.mojang.datafixers.util.Pair;
import java.util.Objects;
import java.util.Optional;
import mctech.g.a.c.f;
import mctech.g.a.d;
import mctech.g.a.e.e;
import mctech.g.b.a.m;
import mctech.g.b.a.r;
import mctech.g.b.a.u;
import mctech.init.MCTechConduitTypes;
import mctech.init.MCTechDataComponent;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.EntityCollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.fml.loading.FMLLoader;
import net.neoforged.neoforge.network.PacketDistributor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/a/a/a.class */
public class a extends Block implements EntityBlock, SimpleWaterloggedBlock {
    private static final BooleanProperty a = BlockStateProperties.WATERLOGGED;

    public a(BlockBehaviour.Properties properties) {
        super(properties);
        registerDefaultState((BlockState) getStateDefinition().any().setValue(a, false));
    }

    @Nullable
    public BlockEntity newBlockEntity(@NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        return new b(blockPos, blockState);
    }

    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(@NotNull Level level, @NotNull BlockState blockState, @NotNull BlockEntityType<T> blockEntityType) {
        return (level2, blockPos, blockState2, blockEntity) -> {
            if (blockEntity instanceof b) {
                b bVar = (b) blockEntity;
                if (level.isClientSide) {
                    bVar.o();
                } else {
                    bVar.i();
                }
                bVar.p();
            }
        };
    }

    @NotNull
    protected VoxelShape getShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        if (collisionContext instanceof EntityCollisionContext) {
            Player entity = ((EntityCollisionContext) collisionContext).getEntity();
            if (entity instanceof Player) {
                return a(blockGetter, blockPos, mctech.g.a.d.c.a(entity));
            }
        }
        return a(blockGetter, blockPos, true);
    }

    @NotNull
    protected VoxelShape getCollisionShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return a(blockGetter, blockPos, true);
    }

    private VoxelShape a(BlockGetter blockGetter, BlockPos blockPos, boolean z) {
        BlockEntity blockEntity = blockGetter.getBlockEntity(blockPos);
        if (blockEntity instanceof b) {
            b bVar = (b) blockEntity;
            if (bVar.e() && z) {
                return Shapes.block();
            }
            if (bVar.a().isEmpty()) {
                return Shapes.block();
            }
            return bVar.j().a();
        }
        return Shapes.empty();
    }

    @NotNull
    public ItemStack getCloneItemStack(@NotNull BlockState blockState, @NotNull HitResult hitResult, @NotNull LevelReader levelReader, @NotNull BlockPos blockPos, @NotNull Player player) {
        if (levelReader instanceof Level) {
            Level level = (Level) levelReader;
            if (((Boolean) blockState.getOptionalValue(BlockStateProperties.WATERLOGGED).orElse(false)).booleanValue()) {
                HitResult playerPOVHitResult = Item.getPlayerPOVHitResult(level, player, ClipContext.Fluid.NONE);
                if (playerPOVHitResult.getType() == HitResult.Type.MISS) {
                    return Items.AIR.getDefaultInstance();
                }
                if (playerPOVHitResult.getBlockPos().equals(blockPos)) {
                    hitResult = playerPOVHitResult;
                } else {
                    return levelReader.getBlockState(playerPOVHitResult.getBlockPos()).getCloneItemStack(playerPOVHitResult, levelReader, playerPOVHitResult.getBlockPos(), player);
                }
            }
        }
        BlockEntity blockEntity = levelReader.getBlockEntity(blockPos);
        if (blockEntity instanceof b) {
            b bVar = (b) blockEntity;
            if (bVar.e() && mctech.g.a.d.c.a(player)) {
                return bVar.f().asItem().getDefaultInstance();
            }
            Holder<mctech.g.a.a<?, ?>> holderB = bVar.j().b(blockPos, hitResult);
            if (holderB == null) {
                if (bVar.a().isEmpty()) {
                    return ItemStack.EMPTY;
                }
                holderB = (Holder) bVar.a().getFirst();
            }
            return mctech.g.a.b.a(holderB, 1);
        }
        return super.getCloneItemStack(blockState, hitResult, levelReader, blockPos, player);
    }

    @Nullable
    public PushReaction getPistonPushReaction(@NotNull BlockState blockState) {
        return PushReaction.BLOCK;
    }

    protected boolean canBeReplaced(@NotNull BlockState blockState, @NotNull BlockPlaceContext blockPlaceContext) {
        return false;
    }

    protected void neighborChanged(@NotNull BlockState blockState, Level level, @NotNull BlockPos blockPos, @NotNull Block block, @NotNull BlockPos blockPos2, boolean z) {
        BlockEntity blockEntity = level.getBlockEntity(blockPos);
        if (blockEntity instanceof b) {
            b bVar = (b) blockEntity;
            bVar.m();
            bVar.a(level, blockPos, blockPos2, true);
            level.invalidateCapabilities(blockPos);
        }
        super.neighborChanged(blockState, level, blockPos, block, blockPos2, z);
    }

    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        return (BlockState) defaultBlockState().setValue(a, Boolean.valueOf(blockPlaceContext.getLevel().getFluidState(blockPlaceContext.getClickedPos()).getType() == Fluids.WATER));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{a});
    }

    @NotNull
    public BlockState updateShape(BlockState blockState, @NotNull Direction direction, @NotNull BlockState blockState2, @NotNull LevelAccessor levelAccessor, @NotNull BlockPos blockPos, @NotNull BlockPos blockPos2) {
        if (((Boolean) blockState.getValue(a)).booleanValue()) {
            levelAccessor.scheduleTick(blockPos, Fluids.WATER, Fluids.WATER.getTickDelay(levelAccessor));
        }
        BlockEntity blockEntity = levelAccessor.getBlockEntity(blockPos);
        if (blockEntity instanceof b) {
            ((b) blockEntity).k();
        }
        return super.updateShape(blockState, direction, blockState2, levelAccessor, blockPos, blockPos2);
    }

    @NotNull
    public FluidState getFluidState(BlockState blockState) {
        return ((Boolean) blockState.getValue(a)).booleanValue() ? Fluids.WATER.getSource(false) : super.getFluidState(blockState);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    public void setPlacedBy(@NotNull Level level, @NotNull BlockPos blockPos, @NotNull BlockState blockState, @Nullable LivingEntity livingEntity, @NotNull ItemStack itemStack) throws MatchException {
        Player player = null;
        if (livingEntity instanceof Player) {
            player = (Player) livingEntity;
        }
        BlockEntity blockEntity = level.getBlockEntity(blockPos);
        if (blockEntity instanceof b) {
            b bVar = (b) blockEntity;
            Holder<mctech.g.a.a<?, ?>> holder = (Holder) itemStack.get(MCTechDataComponent.CONDUIT);
            if (holder != null) {
                Direction direction = bVar.d;
                bVar.d = null;
                bVar.a(holder, direction, player);
            } else {
                mctech.g.a.d.a aVar = (mctech.g.a.d.a) itemStack.getCapability(d.a);
                if (aVar != null && aVar.a()) {
                    bVar.a(itemStack);
                }
            }
        }
    }

    public boolean onDestroyedByPlayer(@NotNull BlockState blockState, Level level, @NotNull BlockPos blockPos, @NotNull Player player, boolean z, @NotNull FluidState fluidState) {
        BlockEntity blockEntity = level.getBlockEntity(blockPos);
        if (!(blockEntity instanceof b)) {
            return false;
        }
        b bVar = (b) blockEntity;
        if (!level.isClientSide()) {
            return false;
        }
        if (bVar.b() || ((bVar.a().size() == 1 && !bVar.e()) || (bVar.a().isEmpty() && bVar.e()))) {
            if (!bVar.a().isEmpty()) {
                mctech.g.c.a.a(blockPos, blockState, (mctech.g.a.a) ((Holder) bVar.a().getFirst()).value());
            }
            PacketDistributor.sendToServer(new r(blockPos), new CustomPacketPayload[0]);
            return super.onDestroyedByPlayer(blockState, level, blockPos, player, z, fluidState);
        }
        if (bVar.e() && mctech.g.a.d.c.a(player)) {
            int lightEmission = level.getLightEmission(blockPos);
            bVar.a(ItemStack.EMPTY);
            if (lightEmission != level.getLightEmission(blockPos)) {
                level.getLightEngine().checkBlock(blockPos);
            }
            PacketDistributor.sendToServer(new u(blockPos), new CustomPacketPayload[0]);
            return false;
        }
        Holder<mctech.g.a.a<?, ?>> holderB = null;
        BlockHitResult blockHitResultPick = player.pick(player.blockInteractionRange() + 5.0d, 0.0f, false);
        if (blockHitResultPick.getType() == HitResult.Type.BLOCK) {
            holderB = bVar.j().b(blockHitResultPick.getBlockPos(), blockHitResultPick);
        }
        if (holderB == null) {
            return false;
        }
        mctech.g.c.a.a(blockPos, blockState, (mctech.g.a.a) holderB.value());
        bVar.a(holderB, itemStack -> {
        });
        PacketDistributor.sendToServer(new m(blockPos, holderB), new CustomPacketPayload[0]);
        return false;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    @NotNull
    protected ItemInteractionResult useItemOn(@NotNull ItemStack itemStack, @NotNull BlockState blockState, Level level, @NotNull BlockPos blockPos, @NotNull Player player, @NotNull InteractionHand interactionHand, @NotNull BlockHitResult blockHitResult) throws MatchException {
        BlockEntity blockEntity = level.getBlockEntity(blockPos);
        if (blockEntity instanceof b) {
            b bVar = (b) blockEntity;
            ItemInteractionResult itemInteractionResultA = a(itemStack, level, blockPos, player, bVar);
            if (itemInteractionResultA != ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION) {
                return itemInteractionResultA;
            }
            ItemInteractionResult itemInteractionResultB = b(itemStack, level, blockPos, player, bVar);
            if (itemInteractionResultB != ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION) {
                return itemInteractionResultB;
            }
        }
        return super.useItemOn(itemStack, blockState, level, blockPos, player, interactionHand, blockHitResult);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    private ItemInteractionResult a(ItemStack itemStack, Level level, BlockPos blockPos, Player player, b bVar) throws MatchException {
        Holder<mctech.g.a.a<?, ?>> holder = (Holder) itemStack.get(MCTechDataComponent.CONDUIT);
        if (holder == null) {
            return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
        }
        if (!bVar.a(holder)) {
            return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
        }
        BlockHitResult blockHitResultPick = player.pick(player.blockInteractionRange() + 5.0d, 1.0f, false);
        Direction opposite = null;
        if (blockHitResultPick instanceof BlockHitResult) {
            opposite = blockHitResultPick.getDirection().getOpposite();
        }
        mctech.g.a.b.a aVarA = bVar.a(holder, opposite, player);
        if (aVarA instanceof mctech.g.a.b.a.c) {
            try {
                Holder<mctech.g.a.a<?, ?>> holderB = ((mctech.g.a.b.a.c) aVarA).b();
                if (!player.getAbilities().instabuild) {
                    itemStack.shrink(1);
                    player.getInventory().placeItemBackInInventory(mctech.g.a.b.a(holderB, 1));
                }
            } catch (Throwable th) {
                throw new MatchException(th.toString(), th);
            }
        } else if (aVarA instanceof mctech.g.a.b.a.b) {
            if (!player.getAbilities().instabuild) {
                itemStack.shrink(1);
            }
        } else {
            if (!FMLLoader.isProduction()) {
                throw new IllegalStateException("ConduitBundleAccessor#canAddConduit returned true, but addConduit returned BLOCKED");
            }
            return ItemInteractionResult.FAIL;
        }
        BlockState blockState = level.getBlockState(blockPos);
        SoundType soundType = blockState.getSoundType(level, blockPos, player);
        level.playSound(player, blockPos, soundType.getPlaceSound(), SoundSource.BLOCKS, (soundType.getVolume() + 1.0f) / 2.0f, soundType.getPitch() * 0.8f);
        level.gameEvent(GameEvent.BLOCK_PLACE, blockPos, GameEvent.Context.of(player, blockState));
        return ItemInteractionResult.sidedSuccess(level.isClientSide());
    }

    private ItemInteractionResult b(ItemStack itemStack, Level level, BlockPos blockPos, Player player, b bVar) {
        mctech.g.a.d.a aVar = (mctech.g.a.d.a) itemStack.getCapability(d.a);
        if (aVar == null || !aVar.a()) {
            return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
        }
        if (bVar.e()) {
            return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
        }
        int lightEmission = level.getLightEmission(blockPos);
        bVar.a(itemStack);
        if (!player.getAbilities().instabuild) {
            itemStack.shrink(1);
        }
        if (lightEmission != level.getLightEmission(blockPos)) {
            level.getLightEngine().checkBlock(blockPos);
        }
        BlockState blockState = level.getBlockState(blockPos);
        SoundType soundType = blockState.getSoundType(level, blockPos, player);
        level.playSound(player, blockPos, soundType.getPlaceSound(), SoundSource.BLOCKS, (soundType.getVolume() + 1.0f) / 2.0f, soundType.getPitch() * 0.8f);
        level.gameEvent(GameEvent.BLOCK_PLACE, blockPos, GameEvent.Context.of(player, blockState));
        return ItemInteractionResult.sidedSuccess(level.isClientSide());
    }

    @NotNull
    protected InteractionResult useWithoutItem(@NotNull BlockState blockState, Level level, @NotNull BlockPos blockPos, @NotNull Player player, @NotNull BlockHitResult blockHitResult) {
        BlockEntity blockEntity = level.getBlockEntity(blockPos);
        if (blockEntity instanceof b) {
            b bVar = (b) blockEntity;
            Pair<Direction, Holder<mctech.g.a.a<?, ?>>> pairC = bVar.j().c(blockPos, blockHitResult);
            if (pairC != null && bVar.e((Holder) pairC.getSecond(), (Direction) pairC.getFirst())) {
                if (player instanceof ServerPlayer) {
                    mctech.g.d.a.c.a.a((ServerPlayer) player, bVar, (Direction) pairC.getFirst(), (Holder<mctech.g.a.a<?, ?>>) pairC.getSecond());
                }
                return InteractionResult.sidedSuccess(level.isClientSide());
            }
        }
        return super.useWithoutItem(blockState, level, blockPos, player, blockHitResult);
    }

    public boolean canConnectRedstone(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @Nullable Direction direction) {
        b bVar;
        Holder<mctech.g.a.a<?, ?>> holderB;
        if (direction == null) {
            return false;
        }
        BlockEntity blockEntity = blockGetter.getBlockEntity(blockPos);
        if (!(blockEntity instanceof b) || (holderB = (bVar = (b) blockEntity).b(MCTechConduitTypes.REDSTONE.get())) == null || bVar.b(holderB, direction) != f.CONNECTED_BLOCK) {
            return false;
        }
        return ((mctech.g.d.a.d.g.b) bVar.a(holderB, direction, mctech.g.d.a.d.g.b.f)).a(mctech.g.a.c.b.a);
    }

    protected int getSignal(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull Direction direction) {
        return a(blockGetter, blockPos, direction, false);
    }

    protected int getDirectSignal(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull Direction direction) {
        return a(blockGetter, blockPos, direction, true);
    }

    private int a(BlockGetter blockGetter, BlockPos blockPos, Direction direction, boolean z) {
        Holder<mctech.g.a.a<?, ?>> holderB;
        mctech.g.d.a.c cVarB;
        mctech.g.d.a.b bVarL;
        mctech.g.d.a.d.g.c cVar;
        BlockEntity blockEntity = blockGetter.getBlockEntity(blockPos);
        if (blockEntity instanceof b) {
            b bVar = (b) blockEntity;
            if (((Level) Objects.requireNonNull(bVar.getLevel())).isClientSide() || (holderB = bVar.b(MCTechConduitTypes.REDSTONE.get())) == null || bVar.b(holderB, direction.getOpposite()) != f.CONNECTED_BLOCK) {
                return 0;
            }
            mctech.g.d.a.d.g.b bVar2 = (mctech.g.d.a.d.g.b) bVar.a(holderB, direction.getOpposite(), mctech.g.d.a.d.g.b.f);
            if (!bVar2.a(mctech.g.a.c.b.a)) {
                return 0;
            }
            if ((z && !bVar2.i()) || (bVarL = (cVarB = bVar.b(holderB)).l()) == null || (cVar = (mctech.g.d.a.d.g.c) bVarL.b(mctech.g.d.a.d.g.c.b)) == null) {
                return 0;
            }
            e eVar = (e) cVarB.d(direction).getStackInSlot(1).getCapability(d.d);
            if (eVar != null) {
                return eVar.a(cVar, bVar2.g());
            }
            return cVar.b(bVar2.g());
        }
        return 0;
    }

    private Optional<Block> a(BlockGetter blockGetter, BlockPos blockPos) {
        BlockEntity blockEntity = blockGetter.getBlockEntity(blockPos);
        if (blockEntity instanceof b) {
            b bVar = (b) blockEntity;
            if (bVar.e()) {
                return Optional.of(bVar.f());
            }
        }
        return Optional.empty();
    }

    @NotNull
    public BlockState getAppearance(@NotNull BlockState blockState, @NotNull BlockAndTintGetter blockAndTintGetter, @NotNull BlockPos blockPos, @NotNull Direction direction, @Nullable BlockState blockState2, @Nullable BlockPos blockPos2) {
        return (BlockState) a(blockAndTintGetter, blockPos).map((v0) -> {
            return v0.defaultBlockState();
        }).orElseGet(() -> {
            return super.getAppearance(blockState, blockAndTintGetter, blockPos, direction, blockState2, blockPos2);
        });
    }

    public int getLightEmission(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos) {
        return ((Integer) a(blockGetter, blockPos).map(block -> {
            return Integer.valueOf(block.getLightEmission(block.defaultBlockState(), blockGetter, blockPos));
        }).orElseGet(() -> {
            return Integer.valueOf(super.getLightEmission(blockState, blockGetter, blockPos));
        })).intValue();
    }

    public float getFriction(@NotNull BlockState blockState, @NotNull LevelReader levelReader, @NotNull BlockPos blockPos, @Nullable Entity entity) {
        return ((Float) a(levelReader, blockPos).map(block -> {
            return Float.valueOf(block.getFriction(block.defaultBlockState(), levelReader, blockPos, entity));
        }).orElseGet(() -> {
            return Float.valueOf(super.getFriction(blockState, levelReader, blockPos, entity));
        })).floatValue();
    }

    @NotNull
    public SoundType getSoundType(@NotNull BlockState blockState, @NotNull LevelReader levelReader, @NotNull BlockPos blockPos, @Nullable Entity entity) {
        Optional<Block> optionalA = a(levelReader, blockPos);
        if (optionalA.isPresent() && (!(entity instanceof Player) || mctech.g.a.d.c.a((Player) entity))) {
            return optionalA.get().getSoundType(optionalA.get().defaultBlockState(), levelReader, blockPos, entity);
        }
        return super.getSoundType(blockState, levelReader, blockPos, entity);
    }

    public boolean supportsExternalFaceHiding(@NotNull BlockState blockState) {
        return true;
    }
}
