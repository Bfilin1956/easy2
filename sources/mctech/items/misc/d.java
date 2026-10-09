package mctech.items.misc;

import mctech.items.base.i;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/misc/d.class */
public class d extends i {
    public d() {
        super(new Item.Properties());
    }

    @NotNull
    public InteractionResult useOn(UseOnContext useOnContext) {
        Player player = useOnContext.getPlayer();
        if (player == null) {
            return InteractionResult.FAIL;
        }
        Level level = useOnContext.getLevel();
        BlockPos clickedPos = useOnContext.getClickedPos();
        ItemStack itemInHand = player.getItemInHand(useOnContext.getHand());
        BlockState blockState = level.getBlockState(clickedPos);
        if (blockState.getBlock() == Blocks.PISTON && blockState.getValue(BlockStateProperties.FACING) == useOnContext.getClickedFace() && !((Boolean) blockState.getValue(BlockStateProperties.EXTENDED)).booleanValue()) {
            level.setBlockAndUpdate(clickedPos, (BlockState) Blocks.STICKY_PISTON.defaultBlockState().setValue(BlockStateProperties.FACING, blockState.getValue(BlockStateProperties.FACING)));
            if (!player.isCreative()) {
                itemInHand.shrink(1);
            }
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }
}
