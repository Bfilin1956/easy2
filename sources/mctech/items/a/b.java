package mctech.items.a;

import java.util.function.Supplier;
import mctech.items.base.g;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/a/b.class */
public class b extends g {
    public b(Block block, Supplier<Block> supplier) {
        super(block);
    }

    @NotNull
    public InteractionResult place(BlockPlaceContext blockPlaceContext) {
        if (!blockPlaceContext.canPlace()) {
            return InteractionResult.FAIL;
        }
        BlockPlaceContext blockPlaceContextUpdatePlacementContext = updatePlacementContext(blockPlaceContext);
        if (blockPlaceContextUpdatePlacementContext == null) {
            return InteractionResult.FAIL;
        }
        BlockState placementState = getPlacementState(blockPlaceContextUpdatePlacementContext);
        if (placementState == null || !placeBlock(blockPlaceContextUpdatePlacementContext, placementState)) {
            return InteractionResult.FAIL;
        }
        BlockPos clickedPos = blockPlaceContextUpdatePlacementContext.getClickedPos();
        Level level = blockPlaceContextUpdatePlacementContext.getLevel();
        ServerPlayer player = blockPlaceContextUpdatePlacementContext.getPlayer();
        ItemStack itemInHand = blockPlaceContextUpdatePlacementContext.getItemInHand();
        BlockState blockState = level.getBlockState(clickedPos);
        if (blockState.is(placementState.getBlock())) {
            updateCustomBlockEntityTag(clickedPos, level, player, itemInHand, blockState);
            blockState.getBlock().setPlacedBy(level, clickedPos, blockState, player, itemInHand);
            if (player instanceof ServerPlayer) {
                CriteriaTriggers.PLACED_BLOCK.trigger(player, clickedPos, itemInHand);
            }
        }
        level.gameEvent(GameEvent.BLOCK_PLACE, clickedPos, GameEvent.Context.of(player, blockState));
        SoundType soundType = blockState.getSoundType(level, clickedPos, blockPlaceContext.getPlayer());
        if (player != null) {
            level.playSound(player, clickedPos, getPlaceSound(blockState, level, clickedPos, player), SoundSource.BLOCKS, (soundType.getVolume() + 1.0f) / 2.0f, soundType.getPitch() * 0.8f);
            if (!player.getAbilities().instabuild) {
                itemInHand.shrink(1);
            }
        }
        return InteractionResult.sidedSuccess(level.isClientSide);
    }
}
