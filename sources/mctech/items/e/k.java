package mctech.items.e;

import java.util.List;
import javax.annotation.Nullable;
import mctech.MCTech;
import mctech.init.MCTechItems;
import mctech.items.base.o;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/e/k.class */
public class k extends mctech.items.base.i {
    public k() {
        this(null);
    }

    protected k(@Nullable o oVar) {
        super((oVar == null ? new o() : oVar).c(16));
    }

    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        return InteractionResultHolder.success(player.getItemInHand(interactionHand));
    }

    public InteractionResult useOn(UseOnContext useOnContext) {
        BlockState blockState = useOnContext.getLevel().getBlockState(useOnContext.getClickedPos());
        if (blockState.getBlock() instanceof mctech.blocks.e.h) {
            boolean zG = MCTech.PLATFORM.g();
            if (zG && a(blockState, useOnContext.getLevel(), useOnContext.getClickedPos(), useOnContext.getClickedFace(), useOnContext.getItemInHand(), null)) {
                useOnContext.getItemInHand().hurtAndBreak(1, useOnContext.getPlayer(), useOnContext.getHand() == InteractionHand.MAIN_HAND ? EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND);
                return InteractionResult.SUCCESS;
            }
            if (!zG && ((Boolean) blockState.getValue(mctech.blocks.e.h.d)).booleanValue() && blockState.getValue(mctech.blocks.e.h.a) == useOnContext.getClickedFace()) {
                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.PASS;
    }

    public static boolean a(BlockState blockState, Level level, BlockPos blockPos, Direction direction, ItemStack itemStack, List<ItemStack> list) {
        if (!((Boolean) blockState.getValue(mctech.blocks.e.h.d)).booleanValue() || blockState.getValue(mctech.blocks.e.h.a) != direction) {
            return false;
        }
        if (((Boolean) blockState.getValue(mctech.blocks.e.h.e)).booleanValue()) {
            level.setBlockAndUpdate(blockPos, (BlockState) blockState.setValue(mctech.blocks.e.h.e, false));
            ItemStack itemStack2 = new ItemStack((ItemLike) MCTechItems.STICKY_RESIN.get(), a(itemStack, 1, 3));
            if (list != null) {
                list.add(itemStack2);
                return true;
            }
            Block.popResourceFromFace(level, blockPos.relative(direction), direction.getOpposite(), itemStack2);
            return true;
        }
        if (level.random.nextInt(5) == 0) {
            level.setBlockAndUpdate(blockPos, (BlockState) blockState.setValue(mctech.blocks.e.h.d, false));
        }
        if (level.random.nextInt(5) == 0) {
            ItemStack itemStack3 = new ItemStack((ItemLike) MCTechItems.STICKY_RESIN.get(), a(itemStack, 1, 3));
            if (list != null) {
                list.add(itemStack3);
                return true;
            }
            Block.popResourceFromFace(level, blockPos.relative(direction), direction.getOpposite(), itemStack3);
            return true;
        }
        return true;
    }

    public static int a(ItemStack itemStack, int i, int i2) {
        return mctech.items.base.i.RANDOM.nextInt(i2) + i;
    }

    public static boolean a(UseOnContext useOnContext, List<ItemStack> list) {
        return a(useOnContext.getLevel().getBlockState(useOnContext.getClickedPos()), useOnContext.getLevel(), useOnContext.getClickedPos(), useOnContext.getClickedFace(), useOnContext.getItemInHand(), list);
    }
}
