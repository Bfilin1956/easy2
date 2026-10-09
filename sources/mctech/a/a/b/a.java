package mctech.a.a.b;

import appeng.api.orientation.IOrientationStrategy;
import appeng.api.orientation.OrientationStrategies;
import appeng.block.AEBaseEntityBlock;
import appeng.menu.MenuOpener;
import appeng.menu.locator.MenuLocators;
import appeng.util.InteractionUtil;
import com.glodblock.github.extendedae.common.EAESingletons;
import com.glodblock.github.extendedae.common.me.wireless.WirelessFail;
import com.glodblock.github.extendedae.common.tileentities.TileWirelessConnector;
import com.glodblock.github.extendedae.common.tileentities.TileWirelessHub;
import com.glodblock.github.extendedae.config.EAEConfig;
import it.unimi.dsi.fastutil.Pair;
import net.minecraft.core.BlockPos;
import net.minecraft.core.GlobalPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/a/a/b/a.class */
public class a extends AEBaseEntityBlock<mctech.a.a.a.a> {
    public static final BooleanProperty a = BooleanProperty.create("connected");
    public static final IntegerProperty b = IntegerProperty.create("color", 0, 16);
    private final int c;

    public a(BlockBehaviour.Properties properties, int i) {
        super(properties);
        this.c = i;
        registerDefaultState((BlockState) ((BlockState) defaultBlockState().setValue(a, false)).setValue(b, 16));
    }

    public a(int i) {
        this(metalProps(), i);
    }

    public int a() {
        return this.c;
    }

    protected void createBlockStateDefinition(@NotNull StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(new Property[]{a});
        builder.add(new Property[]{b});
    }

    public IOrientationStrategy getOrientationStrategy() {
        return OrientationStrategies.none();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public BlockState updateBlockStateFromBlockEntity(BlockState blockState, mctech.a.a.a.a aVar) {
        return (BlockState) ((BlockState) blockState.setValue(a, Boolean.valueOf(aVar.i()))).setValue(b, Integer.valueOf(aVar.getColor().ordinal()));
    }

    public void neighborChanged(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, @NotNull Block block, @NotNull BlockPos blockPos2, boolean z) {
        mctech.a.a.a.a blockEntity = getBlockEntity(level, blockPos);
        if (blockEntity != null) {
            blockEntity.f();
        }
    }

    public void onNeighborChange(@NotNull BlockState blockState, @NotNull LevelReader levelReader, @NotNull BlockPos blockPos, @NotNull BlockPos blockPos2) {
        mctech.a.a.a.a blockEntity;
        if ((levelReader instanceof Level) && (blockEntity = getBlockEntity((Level) levelReader, blockPos)) != null) {
            blockEntity.f();
        }
    }

    public void onRemove(BlockState blockState, Level level, BlockPos blockPos, BlockState blockState2, boolean z) {
        if (blockState2.getBlock() != blockState.getBlock()) {
            mctech.a.a.a.a blockEntity = getBlockEntity(level, blockPos);
            if (blockEntity != null) {
                blockEntity.j();
            }
            super.onRemove(blockState, level, blockPos, blockState2, z);
        }
    }

    @NotNull
    public InteractionResult useWithoutItem(BlockState blockState, Level level, BlockPos blockPos, Player player, BlockHitResult blockHitResult) {
        mctech.a.a.a.a aVar = (mctech.a.a.a.a) getBlockEntity(level, blockPos);
        if (aVar == null) {
            return InteractionResult.PASS;
        }
        if (!level.isClientSide()) {
            a(aVar, player);
        }
        return InteractionResult.sidedSuccess(level.isClientSide());
    }

    @NotNull
    public ItemInteractionResult useItemOn(ItemStack itemStack, BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
        ItemInteractionResult itemInteractionResultUseItemOn = super.useItemOn(itemStack, blockState, level, blockPos, player, interactionHand, blockHitResult);
        if (itemInteractionResultUseItemOn.result() != InteractionResult.PASS) {
            return itemInteractionResultUseItemOn;
        }
        if (InteractionUtil.isInAlternateUseMode(player)) {
            return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
        }
        mctech.a.a.a.a aVar = (mctech.a.a.a.a) getBlockEntity(level, blockPos);
        if (aVar == null) {
            return ItemInteractionResult.FAIL;
        }
        ItemInteractionResult itemInteractionResultA = a(aVar, itemStack, level, blockPos, blockHitResult, player);
        if (itemInteractionResultA != null) {
            return itemInteractionResultA;
        }
        if (!level.isClientSide()) {
            a(aVar, player);
        }
        return ItemInteractionResult.SUCCESS;
    }

    public void a(mctech.a.a.a.a aVar, Player player) {
        MenuOpener.open(mctech.a.a.e.a.a, player, MenuLocators.forBlockEntity(aVar));
    }

    @Nullable
    public ItemInteractionResult a(mctech.a.a.a.a aVar, ItemStack itemStack, Level level, BlockPos blockPos, BlockHitResult blockHitResult, Player player) {
        if (itemStack.getItem() != EAESingletons.WIRELESS_TOOL || !(level instanceof ServerLevel)) {
            return null;
        }
        ServerLevel serverLevel = (ServerLevel) level;
        Pair pair = (Pair) itemStack.get(EAESingletons.WIRELESS_LOCATOR);
        if (pair != null) {
            long jLongValue = ((Long) pair.left()).longValue();
            GlobalPos globalPos = (GlobalPos) pair.right();
            if (jLongValue != 0) {
                if (globalPos == null) {
                    player.displayClientMessage(WirelessFail.MISSING.getTranslation(), true);
                    return ItemInteractionResult.FAIL;
                }
                BlockPos blockPosPos = globalPos.pos();
                ResourceKey resourceKeyDimension = globalPos.dimension();
                ResourceKey resourceKeyDimension2 = level.dimension();
                if (blockPosPos.equals(blockPos) && resourceKeyDimension.equals(resourceKeyDimension2)) {
                    player.displayClientMessage(WirelessFail.SELF_REFERENCE.getTranslation(), true);
                    return ItemInteractionResult.FAIL;
                }
                if (!resourceKeyDimension.equals(resourceKeyDimension2)) {
                    player.displayClientMessage(WirelessFail.CROSS_DIMENSION.getTranslation(), true);
                    return ItemInteractionResult.FAIL;
                }
                if (Math.sqrt(blockPosPos.distSqr(blockPos)) > EAEConfig.wirelessMaxRange) {
                    player.displayClientMessage(WirelessFail.OUT_OF_RANGE.getTranslation(), true);
                    return ItemInteractionResult.FAIL;
                }
                ServerLevel level2 = serverLevel.getServer().getLevel(resourceKeyDimension);
                if (level2 == null) {
                    player.displayClientMessage(WirelessFail.MISSING.getTranslation(), true);
                    return ItemInteractionResult.FAIL;
                }
                mctech.a.a.a.a blockEntity = level2.getBlockEntity(blockPosPos);
                if (blockEntity instanceof mctech.a.a.a.a) {
                    blockEntity.a(jLongValue);
                    aVar.a(jLongValue);
                    itemStack.remove(EAESingletons.WIRELESS_LOCATOR);
                    player.displayClientMessage(Component.translatable("chat.wireless_connect", new Object[]{Integer.valueOf(blockPos.getX()), Integer.valueOf(blockPos.getY()), Integer.valueOf(blockPos.getZ())}), true);
                    return ItemInteractionResult.sidedSuccess(level.isClientSide);
                }
                if (blockEntity instanceof TileWirelessConnector) {
                    ((TileWirelessConnector) blockEntity).setFrequency(jLongValue);
                    aVar.a(jLongValue);
                    itemStack.remove(EAESingletons.WIRELESS_LOCATOR);
                    player.displayClientMessage(Component.translatable("chat.wireless_connect", new Object[]{Integer.valueOf(blockPos.getX()), Integer.valueOf(blockPos.getY()), Integer.valueOf(blockPos.getZ())}), true);
                    return ItemInteractionResult.sidedSuccess(level.isClientSide);
                }
                if (blockEntity instanceof TileWirelessHub) {
                    TileWirelessHub tileWirelessHub = (TileWirelessHub) blockEntity;
                    int iAllocatePort = tileWirelessHub.allocatePort();
                    if (iAllocatePort < 0) {
                        player.displayClientMessage(WirelessFail.OUT_OF_PORT.getTranslation(), true);
                        return ItemInteractionResult.FAIL;
                    }
                    tileWirelessHub.setFrequency(jLongValue, iAllocatePort);
                    aVar.a(jLongValue);
                    itemStack.remove(EAESingletons.WIRELESS_LOCATOR);
                    player.displayClientMessage(Component.translatable("chat.wireless_connect", new Object[]{Integer.valueOf(blockPos.getX()), Integer.valueOf(blockPos.getY()), Integer.valueOf(blockPos.getZ())}), true);
                    return ItemInteractionResult.sidedSuccess(level.isClientSide);
                }
                player.displayClientMessage(WirelessFail.MISSING.getTranslation(), true);
                return ItemInteractionResult.FAIL;
            }
        }
        itemStack.set(EAESingletons.WIRELESS_LOCATOR, Pair.of(Long.valueOf(aVar.g()), GlobalPos.of(level.dimension(), blockPos)));
        player.displayClientMessage(Component.translatable("chat.wireless_bind", new Object[]{Integer.valueOf(blockPos.getX()), Integer.valueOf(blockPos.getY()), Integer.valueOf(blockPos.getZ())}), true);
        return ItemInteractionResult.sidedSuccess(level.isClientSide);
    }
}
