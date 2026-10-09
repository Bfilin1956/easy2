package mctech.items.e.a;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import mctech.MCTech;
import mctech.api.items.electric.ElectricItem;
import mctech.api.util.DirectionList;
import mctech.init.MCTechDataComponent;
import mctech.init.MCTechItems;
import mctech.items.e.k;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/e/a/b.class */
public class b extends e implements mctech.items.base.a.b {
    @Override // mctech.items.base.a.b
    public boolean b(ItemStack itemStack) {
        return ElectricItem.MANAGER.canUse(itemStack, this.a * Math.max(1, ((List) itemStack.getOrDefault(MCTechDataComponent.POSITIONS, Collections.emptyList())).size()));
    }

    @Override // mctech.items.base.a.b
    public boolean a(ItemStack itemStack) {
        return true;
    }

    @Override // mctech.items.e.a.e, mctech.items.e.k
    public InteractionResult useOn(UseOnContext useOnContext) {
        Level level = useOnContext.getLevel();
        BlockPos clickedPos = useOnContext.getClickedPos();
        LivingEntity player = useOnContext.getPlayer();
        ItemStack itemInHand = player.getItemInHand(useOnContext.getHand());
        BlockState blockState = player.level().getBlockState(clickedPos);
        Comparable clickedFace = useOnContext.getClickedFace();
        if (!(blockState.getBlock() instanceof mctech.blocks.e.h) || !((Boolean) blockState.getValue(mctech.blocks.e.h.d)).booleanValue() || blockState.getValue(mctech.blocks.e.h.a) != clickedFace) {
            return InteractionResult.PASS;
        }
        if (!b(itemInHand)) {
            return InteractionResult.PASS;
        }
        if (MCTech.PLATFORM.g()) {
            int i = 0;
            ObjectArrayList objectArrayList = new ObjectArrayList();
            for (BlockPos blockPos : mctech.utils.a.f.a(a(itemInHand, (Player) player, clickedPos, (Direction) clickedFace))) {
                k.a(level.getBlockState(blockPos), level, blockPos, clickedFace, itemInHand, objectArrayList);
                objectArrayList.add(new ItemStack((ItemLike) MCTechItems.STICKY_RESIN.get(), k.a(itemInHand, 5, 10)));
                i++;
                level.removeBlock(blockPos, false);
            }
            ElectricItem.MANAGER.use(itemInHand, this.a * i, player);
            Iterator it = objectArrayList.iterator();
            while (it.hasNext()) {
                mctech.utils.c.h.a((Player) player, (ItemStack) it.next());
            }
        }
        return InteractionResult.SUCCESS;
    }

    @Override // mctech.items.base.a.b
    public Iterator<BlockPos> a(final ItemStack itemStack, Player player, BlockPos blockPos, Direction direction) {
        BlockState blockState = player.level().getBlockState(blockPos);
        if ((blockState.getBlock() instanceof mctech.blocks.e.h) && ((Boolean) blockState.getValue(mctech.blocks.e.h.d)).booleanValue() && blockState.getValue(mctech.blocks.e.h.a) == direction) {
            if (((Long) itemStack.get(MCTechDataComponent.LAST_POS)).longValue() != blockPos.asLong()) {
                int charge = ElectricItem.MANAGER.getCharge(itemStack) / this.a;
                ObjectList<BlockPos> objectListB = mctech.utils.c.a.b(player.level(), blockPos, 20, a.a, 0, DirectionList.ALL, 20).b();
                Long[] lArr = new Long[Math.min(charge, objectListB.size())];
                int size = objectListB.size();
                for (int i = 0; i < size; i++) {
                    lArr[i] = Long.valueOf(((BlockPos) objectListB.get(i)).asLong());
                }
                itemStack.set(MCTechDataComponent.LAST_POS, Long.valueOf(blockPos.asLong()));
                itemStack.set(MCTechDataComponent.POSITIONS, Arrays.asList(lArr));
            }
            return new Iterator<BlockPos>(this) { // from class: mctech.items.e.a.b.1
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
                    Long[] lArr2 = this.b;
                    int i2 = this.c;
                    this.c = i2 + 1;
                    return mutableBlockPos.set(lArr2[i2].longValue());
                }
            };
        }
        if (itemStack.has(MCTechDataComponent.POSITIONS)) {
            itemStack.remove(MCTechDataComponent.POSITIONS);
            itemStack.remove(MCTechDataComponent.LAST_POS);
        }
        return Collections.emptyIterator();
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/e/a/b$a.class */
    public static class a implements mctech.utils.c.a.InterfaceC0043a {
        public static final mctech.utils.c.a.InterfaceC0043a a = new a();

        @Override // mctech.utils.c.a.InterfaceC0043a
        public boolean isValid(BlockState blockState) {
            return blockState.getBlock() instanceof mctech.blocks.e.h;
        }
    }
}
