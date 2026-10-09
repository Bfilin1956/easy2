package mctech.items.e;

import java.util.Iterator;
import javax.annotation.Nullable;
import mctech.api.blocks.IWrenchable;
import mctech.api.blocks.WrenchHelper;
import mctech.api.items.readers.IWrenchTool;
import mctech.blocks.c.G;
import mctech.items.base.o;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/e/m.class */
public class m extends mctech.items.base.i implements IWrenchTool {
    public m() {
        this(null);
    }

    protected m(@Nullable o oVar) {
        super((oVar == null ? new o() : oVar).c(160));
    }

    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        return InteractionResultHolder.success(player.getItemInHand(interactionHand));
    }

    public InteractionResult onItemUseFirst(ItemStack itemStack, UseOnContext useOnContext) {
        Direction facingFromIndex;
        if (!a(itemStack, 1)) {
            return InteractionResult.PASS;
        }
        ServerLevel level = useOnContext.getLevel();
        BlockPos clickedPos = useOnContext.getClickedPos();
        Player player = useOnContext.getPlayer();
        BlockState blockState = level.getBlockState(clickedPos);
        IWrenchable wrenchable = IWrenchable.WrenchRegistry.INSTANCE.getWrenchable(blockState);
        if (blockState.hasProperty(G.d) && ((Boolean) blockState.getOptionalValue(G.d).orElse(false)).booleanValue()) {
            return InteractionResult.PASS;
        }
        if (wrenchable == null) {
            return InteractionResult.PASS;
        }
        Direction facing = wrenchable.getFacing(blockState, level, clickedPos);
        if (facing != null && (facingFromIndex = WrenchHelper.getFacingFromIndex(useOnContext.getClickedFace(), WrenchHelper.getDirectionIndex(useOnContext), player)) != facing && wrenchable.setFacing(blockState, level, clickedPos, useOnContext.getPlayer(), facingFromIndex)) {
            a(itemStack, 1, player, useOnContext.getHand());
            a(player);
            return InteractionResult.SUCCESS;
        }
        if (a(itemStack, 5) && wrenchable.doSpecialAction(blockState, level, clickedPos, useOnContext.getClickedFace(), player, useOnContext.getClickLocation().subtract(Vec3.atLowerCornerOf(clickedPos)))) {
            a(itemStack, 5, useOnContext.getPlayer(), useOnContext.getHand());
            a(player);
            return InteractionResult.SUCCESS;
        }
        if (!a(itemStack, a(itemStack) ? 100 : 10) || !wrenchable.canRemoveBlock(blockState, level, clickedPos, player)) {
            return InteractionResult.PASS;
        }
        if (((Level) level).isClientSide) {
            return InteractionResult.SUCCESS;
        }
        boolean z = ((Level) level).random.nextDouble() <= wrenchable.getDropRate(blockState, level, clickedPos, player) * a(itemStack, c(itemStack));
        a(itemStack, 10, player, useOnContext.getHand());
        a(player);
        if (!z && a(itemStack)) {
            z = true;
            a(player, itemStack);
            if (b(itemStack)) {
                damageItem(itemStack, 200, player, item -> {
                });
            }
        }
        Iterator<ItemStack> it = (z ? wrenchable.getDrops(blockState, level, clickedPos, player) : Block.getDrops(blockState, level, clickedPos, level.getBlockEntity(clickedPos), player, itemStack)).iterator();
        while (it.hasNext()) {
            Block.popResource(level, clickedPos, it.next());
        }
        level.removeBlock(clickedPos, false);
        return InteractionResult.SUCCESS;
    }

    public void a(Player player) {
    }

    public boolean a(ItemStack itemStack) {
        return false;
    }

    public boolean a(ItemStack itemStack, int i) {
        return true;
    }

    public void a(ItemStack itemStack, int i, Player player, InteractionHand interactionHand) {
        itemStack.hurtAndBreak(i, player, Player.getSlotForHand(interactionHand));
    }

    public void a(Player player, ItemStack itemStack) {
    }

    public boolean b(ItemStack itemStack) {
        return true;
    }

    public double c(ItemStack itemStack) {
        return 1.0d;
    }

    public double a(ItemStack itemStack, double d) {
        return 1.0d;
    }

    @Override // mctech.api.items.readers.IWrenchTool
    public double getActualLoss(ItemStack itemStack, double d) {
        double dA = d * a(itemStack, c(itemStack));
        if (dA < 1.0d && a(itemStack) && a(itemStack, 100)) {
            return 1.0d;
        }
        return dA;
    }
}
