package mctech.items.e.a;

import it.unimi.dsi.fastutil.longs.LongArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import mctech.MCTech;
import mctech.api.items.electric.ElectricItem;
import mctech.api.items.electric.IElectricItem;
import mctech.blockentities.c.C0074u;
import mctech.init.MCTechDataComponent;
import mctech.items.base.o;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/e/a/a.class */
public class a extends mctech.items.base.e implements mctech.items.base.a.b {
    public a() {
        super(new o(), Tiers.NETHERITE.getSpeed());
        this.capacity = C0074u.e;
        this.tier = 3;
        this.transferLimit = 100;
    }

    @Override // mctech.items.base.MCTechElectricItem
    public int getEnergyCost(ItemStack itemStack) {
        return 100;
    }

    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        if (MCTech.KEYBOARD.d(player)) {
            ItemStack itemInHand = player.getItemInHand(interactionHand);
            int iClamp = Mth.clamp(((Integer) itemInHand.getOrDefault(MCTechDataComponent.RADIUS, 0)).intValue() + (player.isShiftKeyDown() ? -1 : 1), 0, 5);
            itemInHand.set(MCTechDataComponent.RADIUS, Integer.valueOf(iClamp));
            if (MCTech.PLATFORM.g()) {
                player.displayClientMessage(c("tooltip.item.mctech.adv_hoe.radius", Integer.valueOf(iClamp)), false);
            }
            itemInHand.remove(MCTechDataComponent.LAST_POS);
            return InteractionResultHolder.success(itemInHand);
        }
        return super.use(level, player, interactionHand);
    }

    public InteractionResult useOn(UseOnContext useOnContext) {
        LivingEntity player = useOnContext.getPlayer();
        ItemStack itemInHand = useOnContext.getItemInHand();
        Level level = useOnContext.getLevel();
        int i = 0;
        for (BlockPos blockPos : mctech.utils.a.f.a(a(itemInHand, (Player) player, useOnContext.getClickedPos(), useOnContext.getClickedFace()))) {
            BlockState toolModifiedState = level.getBlockState(blockPos).getToolModifiedState(useOnContext, ItemAbilities.HOE_TILL, false);
            if (toolModifiedState != null) {
                level.playSound(player, blockPos, SoundEvents.HOE_TILL, SoundSource.BLOCKS, 1.0f, 1.0f);
                i++;
                if (!level.isClientSide) {
                    level.setBlock(blockPos, toolModifiedState, 11);
                }
            }
        }
        if (i > 0) {
            itemInHand.remove(MCTechDataComponent.LAST_POS);
            ElectricItem.MANAGER.use(itemInHand, getEnergyCost(itemInHand) * i, player);
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }

    @Override // mctech.items.base.a.b
    public boolean a(ItemStack itemStack) {
        return true;
    }

    @Override // mctech.items.base.a.b
    public boolean b(ItemStack itemStack) {
        return true;
    }

    public boolean canPerformAction(ItemStack itemStack, ItemAbility itemAbility) {
        return ItemAbilities.DEFAULT_HOE_ACTIONS.contains(itemAbility);
    }

    @Override // mctech.items.base.a.b
    public Iterator<BlockPos> a(final ItemStack itemStack, Player player, BlockPos blockPos, Direction direction) {
        if (blockPos.asLong() != ((Long) itemStack.getOrDefault(MCTechDataComponent.LAST_POS, 0L)).longValue()) {
            boolean z = true;
            int charge = ElectricItem.MANAGER.getCharge(itemStack) / getEnergyCost(itemStack);
            if (charge > 0) {
                UseOnContext useOnContext = new UseOnContext(player, player.getMainHandItem() == itemStack ? InteractionHand.MAIN_HAND : InteractionHand.OFF_HAND, BlockHitResult.miss(Vec3.ZERO, direction, blockPos));
                if (player.level().getBlockState(blockPos).getToolModifiedState(useOnContext, ItemAbilities.HOE_TILL, true) != null && player.level().isEmptyBlock(blockPos.above())) {
                    LongArrayList longArrayList = new LongArrayList();
                    longArrayList.add(blockPos.asLong());
                    int iIntValue = ((Integer) itemStack.getOrDefault(MCTechDataComponent.RADIUS, 0)).intValue();
                    if (iIntValue > 0) {
                        for (BlockPos blockPos2 : mctech.utils.math.geometry.a.a(blockPos, true).a(Direction.Axis.Y, iIntValue)) {
                            if (!blockPos2.equals(blockPos) && player.level().getBlockState(blockPos2).getToolModifiedState(useOnContext, ItemAbilities.HOE_TILL, true) != null && player.level().isEmptyBlock(blockPos2.above())) {
                                longArrayList.add(blockPos2.asLong());
                                if (longArrayList.size() >= charge) {
                                    break;
                                }
                            }
                        }
                    }
                    itemStack.set(MCTechDataComponent.POSITIONS, longArrayList);
                    z = false;
                }
            }
            if (z) {
                itemStack.remove(MCTechDataComponent.POSITIONS);
            }
            itemStack.set(MCTechDataComponent.LAST_POS, Long.valueOf(blockPos.asLong()));
        }
        return new Iterator<BlockPos>(this) { // from class: mctech.items.e.a.a.1
            List<Long> a;
            Long[] b;
            int c = 0;
            BlockPos.MutableBlockPos d = new BlockPos.MutableBlockPos();

            {
                this.a = (List) itemStack.getOrDefault(MCTechDataComponent.POSITIONS, Collections.emptyList());
                this.b = (Long[]) this.a.toArray(new Long[this.a.size()]);
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.c < this.b.length;
            }

            @Override // java.util.Iterator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public BlockPos next() {
                BlockPos.MutableBlockPos mutableBlockPos = this.d;
                Long[] lArr = this.b;
                int i = this.c;
                this.c = i + 1;
                return mutableBlockPos.set(lArr[i].longValue());
            }
        };
    }

    @Override // mctech.api.items.electric.IElectricItem
    public IElectricItem.ElectricType getElectricType(ItemStack itemStack) {
        return IElectricItem.ElectricType.TOOL;
    }
}
