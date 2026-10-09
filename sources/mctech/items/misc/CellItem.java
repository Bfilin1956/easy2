package mctech.items.misc;

import java.util.function.Predicate;
import mctech.init.MCTechFluids;
import mctech.items.base.i;
import mctech.items.base.o;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BucketPickup;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.level.BlockEvent;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/misc/CellItem.class */
public class CellItem extends i {
    private final Fluid fluid;

    public CellItem(Fluid fluid) {
        super(fluid == Fluids.EMPTY ? null : new o().a((Item) MCTechFluids.CELL_EMPTY.get()));
        this.fluid = fluid;
    }

    public Fluid getFluid() {
        return this.fluid;
    }

    static InteractionResult fillCell(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, ItemStack itemStack, Item item, Predicate<BlockState> predicate, SoundEvent soundEvent) {
        if (!predicate.test(blockState)) {
            return InteractionResult.PASS;
        }
        if (NeoForge.EVENT_BUS.post(new BlockEvent.BreakEvent(level, blockPos, level.getBlockState(blockPos), player)).isCanceled()) {
            return InteractionResult.FAIL;
        }
        if (!level.isClientSide) {
            Item item2 = itemStack.getItem();
            player.setItemInHand(interactionHand, ItemUtils.createFilledResult(itemStack, player, new ItemStack(item)));
            player.awardStat(Stats.USE_CAULDRON);
            player.awardStat(Stats.ITEM_USED.get(item2));
            level.setBlockAndUpdate(blockPos, Blocks.CAULDRON.defaultBlockState());
            level.playSound((Player) null, blockPos, soundEvent, SoundSource.BLOCKS, 1.0f, 2.0f);
            level.gameEvent((Entity) null, GameEvent.FLUID_PICKUP, blockPos);
        }
        return InteractionResult.sidedSuccess(level.isClientSide);
    }

    private boolean mayInteract(Level level, Player player, BlockPos blockPos) {
        return level.mayInteract(player, blockPos) && !NeoForge.EVENT_BUS.post(new BlockEvent.BreakEvent(level, blockPos, level.getBlockState(blockPos), player)).isCanceled();
    }

    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        ItemStack itemInHand = player.getItemInHand(interactionHand);
        BlockHitResult playerPOVHitResult = getPlayerPOVHitResult(level, player, ClipContext.Fluid.SOURCE_ONLY);
        if (playerPOVHitResult.getType() == HitResult.Type.MISS) {
            return InteractionResultHolder.pass(itemInHand);
        }
        BlockPos blockPos = playerPOVHitResult.getBlockPos();
        if (!mayInteract(level, player, blockPos) || !player.mayUseItemAt(blockPos.relative(playerPOVHitResult.getDirection()), playerPOVHitResult.getDirection(), itemInHand)) {
            return InteractionResultHolder.pass(itemInHand);
        }
        BlockState blockState = level.getBlockState(blockPos);
        FluidState fluidState = blockState.getFluidState();
        ItemStack drop = getDrop(fluidState.getType());
        if (!drop.isEmpty()) {
            BucketPickup block = blockState.getBlock();
            if (block instanceof BucketPickup) {
                BucketPickup bucketPickup = block;
                if (!player.addItem(drop)) {
                    return InteractionResultHolder.pass(itemInHand);
                }
                bucketPickup.pickupBlock(player, level, blockPos, blockState);
                itemInHand.shrink(1);
                player.playSound(fluidState.getType() == Fluids.WATER ? SoundEvents.BUCKET_FILL : SoundEvents.BUCKET_FILL_LAVA, 1.0f, 2.0f);
                return InteractionResultHolder.success(itemInHand);
            }
        } else {
            BlockPos blockPosRelative = blockPos.relative(playerPOVHitResult.getDirection());
            if (!mayInteract(level, player, blockPosRelative) || !player.mayUseItemAt(blockPosRelative.relative(playerPOVHitResult.getDirection()), playerPOVHitResult.getDirection(), itemInHand)) {
                return InteractionResultHolder.pass(itemInHand);
            }
            if (this.fluid == Fluids.WATER) {
                if (!player.addItem(new ItemStack((ItemLike) MCTechFluids.CELL_EMPTY.get()))) {
                    return InteractionResultHolder.pass(itemInHand);
                }
                level.setBlock(blockPosRelative, Fluids.WATER.defaultFluidState().createLegacyBlock(), 3);
                itemInHand.shrink(1);
            } else if (this.fluid == Fluids.LAVA) {
                if (!player.addItem(new ItemStack((ItemLike) MCTechFluids.CELL_EMPTY.get()))) {
                    return InteractionResultHolder.pass(itemInHand);
                }
                level.setBlock(blockPosRelative, Fluids.LAVA.defaultFluidState().createLegacyBlock(), 3);
                itemInHand.shrink(1);
            }
        }
        return InteractionResultHolder.pass(itemInHand);
    }

    private ItemStack getDrop(Fluid fluid) {
        if (fluid.isSame(Fluids.WATER)) {
            return new ItemStack((ItemLike) MCTechFluids.CELL_WATER.get());
        }
        if (fluid == Fluids.LAVA) {
            return new ItemStack((ItemLike) MCTechFluids.CELL_LAVA.get());
        }
        return ItemStack.EMPTY;
    }
}
