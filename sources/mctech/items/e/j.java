package mctech.items.e;

import java.util.Optional;
import javax.annotation.Nullable;
import mctech.MCTech;
import mctech.api.features.IClickable;
import mctech.api.items.readers.IEUReader;
import mctech.api.items.readers.IThermometer;
import mctech.init.MCTechDataComponent;
import mctech.items.base.o;
import mctech.m.c.r;
import mctech.m.f.q;
import mctech.utils.math.geometry.Vec2i;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.SlotAccess;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.inventory.tooltip.TooltipComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/e/j.class */
public class j extends mctech.items.base.i implements IEUReader, IThermometer, mctech.items.base.a.c, mctech.m.a.f {
    public static final String a = "flags";
    a b;

    public j(a aVar) {
        super(new o().a(1));
        this.b = aVar;
    }

    @Override // mctech.items.base.i, mctech.utils.e.a
    @OnlyIn(Dist.CLIENT)
    public void addToolTip(ItemStack itemStack, Player player, TooltipFlag tooltipFlag, mctech.utils.e.d dVar) {
        dVar.b(a(mctech.s.a.RIGHT_CLICK, "tooltip.mctech.open_item_inventory", new Object[0]));
    }

    public Optional<TooltipComponent> getTooltipImage(ItemStack itemStack) {
        return Optional.empty();
    }

    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        ItemStack itemInHand = player.getItemInHand(interactionHand);
        if (MCTech.PLATFORM.g()) {
            if (player.isShiftKeyDown() && e(itemInHand)) {
                player.startUsingItem(interactionHand);
                return InteractionResultHolder.success(itemInHand);
            }
            MCTech.PLATFORM.a(player, interactionHand, Direction.NORTH, a(player, interactionHand, itemInHand));
        }
        return InteractionResultHolder.success(itemInHand);
    }

    public ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity livingEntity) {
        if (livingEntity instanceof Player) {
            Player player = (Player) livingEntity;
            mctech.m.h.a aVarA = mctech.m.h.b.a(new b(this.b, itemStack, level.registryAccess()));
            ItemStack itemStackA = aVarA.a(r.l, null, 1, false);
            if (!itemStackA.isEmpty()) {
                ItemStack itemStackOnEaten = itemStackA.getItem().onEaten(itemStackA, level, player);
                if (!itemStackOnEaten.isEmpty()) {
                    itemStackOnEaten.shrink(aVarA.a(itemStackOnEaten, null, false));
                    mctech.utils.c.h.a(player, itemStackOnEaten);
                }
            }
        }
        return itemStack;
    }

    public boolean a(ItemStack itemStack, ItemStack itemStack2, Slot slot, IClickable.ClickAction clickAction, Player player, SlotAccess slotAccess) {
        if (clickAction == IClickable.ClickAction.RIGHT_CLICK && slot.allowModification(player) && !itemStack2.isEmpty() && itemStack.getCount() <= 1 && this.b.h().matches(itemStack2)) {
            itemStack2.shrink(mctech.m.h.b.a(new b(this.b, itemStack, player.registryAccess())).a(itemStack2, null, false));
            return true;
        }
        return false;
    }

    public boolean a(ItemStack itemStack, Slot slot, IClickable.ClickAction clickAction, Player player) {
        return clickAction == IClickable.ClickAction.RIGHT_CLICK && slot.hasItem();
    }

    public UseAnim getUseAnimation(ItemStack itemStack) {
        return UseAnim.EAT;
    }

    public int d(ItemStack itemStack) {
        return 20;
    }

    @Override // mctech.m.a.e
    public mctech.m.a.i a(Player player, InteractionHand interactionHand, ItemStack itemStack) {
        return q.a(player, this, itemStack, null, this.b).a(itemStack);
    }

    @Override // mctech.m.a.f
    public mctech.m.a.i a(Player player, ItemStack itemStack, Slot slot) {
        return q.a(player, this, itemStack, slot, this.b).a(itemStack);
    }

    public int a(ItemStack itemStack, @Nullable LivingEntity livingEntity) {
        return f(itemStack) ? 1 : 0;
    }

    @Override // mctech.api.items.readers.IThermometer
    public boolean isThermometer(ItemStack itemStack) {
        return itemStack.has(MCTechDataComponent.FLAGS) && (((Integer) itemStack.get(MCTechDataComponent.FLAGS)).intValue() & 2) != 0;
    }

    @Override // mctech.api.items.readers.IEUReader
    public boolean isEUReader(ItemStack itemStack) {
        return itemStack.has(MCTechDataComponent.FLAGS) && (((Integer) itemStack.get(MCTechDataComponent.FLAGS)).intValue() & 1) != 0;
    }

    public boolean e(ItemStack itemStack) {
        return itemStack.has(MCTechDataComponent.FLAGS) && (((Integer) itemStack.get(MCTechDataComponent.FLAGS)).intValue() & 8) != 0;
    }

    @Override // mctech.items.base.a.c
    public boolean a(ItemStack itemStack) {
        return this.b.d();
    }

    @Override // mctech.items.base.a.c
    public int b(ItemStack itemStack) {
        return ((Integer) itemStack.getOrDefault(MCTechDataComponent.SELECTED, 0)).intValue();
    }

    @Override // mctech.items.base.a.c
    public void a(ItemStack itemStack, int i) {
        itemStack.set(MCTechDataComponent.SELECTED, Integer.valueOf(i));
    }

    @Override // mctech.items.base.a.c
    public int c(ItemStack itemStack) {
        return this.b.b();
    }

    @Override // mctech.items.base.a.c
    public boolean a(ItemStack itemStack, ItemStack itemStack2) {
        return this.b.h().matches(itemStack2);
    }

    @Override // mctech.items.base.a.c
    public mctech.items.base.a.c.a[] a(ItemStack itemStack, boolean z, HolderLookup.Provider provider) {
        int iC = c(itemStack);
        NonNullList nonNullListWithSize = NonNullList.withSize(iC, ItemStack.EMPTY);
        ContainerHelper.loadAllItems(mctech.utils.c.h.a(itemStack), nonNullListWithSize, provider);
        int iB = b(itemStack);
        int i = iB == 0 ? iC - 1 : iB;
        int i2 = (iB + 1) % iC;
        if (z && mctech.utils.c.h.a(itemStack).getList("Items", 10).size() > 0) {
            while (((ItemStack) nonNullListWithSize.get(i)).isEmpty()) {
                i--;
                if (i < 0) {
                    i = iC - 1;
                }
            }
            while (((ItemStack) nonNullListWithSize.get(i2)).isEmpty()) {
                i2 = (i2 + 1) % iC;
            }
        }
        return new mctech.items.base.a.c.a[]{new mctech.items.base.a.c.a(i, (ItemStack) nonNullListWithSize.get(i)), new mctech.items.base.a.c.a(i2, (ItemStack) nonNullListWithSize.get(i2))};
    }

    @Override // mctech.items.base.a.c
    public boolean a(ItemStack itemStack, int i, int i2, ItemStack itemStack2, HolderLookup.Provider provider) {
        int iC = c(itemStack);
        if (i2 < 0 || i2 >= iC || i < 0 || i >= iC) {
            return false;
        }
        NonNullList nonNullListWithSize = NonNullList.withSize(iC, ItemStack.EMPTY);
        CompoundTag compoundTagA = mctech.utils.c.h.a(itemStack);
        ContainerHelper.loadAllItems(compoundTagA, nonNullListWithSize, provider);
        nonNullListWithSize.set(i, ItemStack.EMPTY);
        if (((ItemStack) nonNullListWithSize.get(i2)).isEmpty()) {
            nonNullListWithSize.set(i2, itemStack2);
        } else {
            nonNullListWithSize.set(i, itemStack2);
        }
        ContainerHelper.saveAllItems(compoundTagA, nonNullListWithSize, provider);
        return true;
    }

    public boolean f(ItemStack itemStack) {
        return mctech.utils.c.h.a(itemStack).getBoolean("open");
    }

    private static mctech.m.h.a a(Player player, ItemStack itemStack) {
        Inventory inventory = player.getInventory();
        int selectionSize = Inventory.getSelectionSize();
        for (int i = 0; i < selectionSize; i++) {
            ItemStack itemStack2 = (ItemStack) inventory.items.get(i);
            Item item = itemStack2.getItem();
            if (item instanceof j) {
                j jVar = (j) item;
                if (!jVar.f(itemStack2) && jVar.e(itemStack2)) {
                    return mctech.m.h.b.a(new b(jVar.b, itemStack2, player.registryAccess()));
                }
            }
        }
        return null;
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/e/j$b.class */
    private static class b implements mctech.m.a.g {
        ItemStack a;
        NonNullList<ItemStack> b;
        HolderLookup.Provider c;

        public b(a aVar, ItemStack itemStack, HolderLookup.Provider provider) {
            this.a = itemStack;
            this.b = NonNullList.withSize(aVar.b(), ItemStack.EMPTY);
            this.c = provider;
            ContainerHelper.loadAllItems(mctech.utils.c.h.a(itemStack), this.b, provider);
        }

        public void a() {
            if (MCTech.PLATFORM.h()) {
                return;
            }
            CompoundTag compoundTagA = mctech.utils.c.h.a(this.a);
            ContainerHelper.saveAllItems(compoundTagA, this.b, this.c);
            mctech.utils.c.e.c(compoundTagA, j.a, mctech.utils.c.h.a(this.b, r.p, r.q, r.l), 0);
        }

        @Override // mctech.m.a.g
        public int getSlotCount() {
            return this.b.size();
        }

        @Override // mctech.m.a.g
        public ItemStack getStackInSlot(int i) {
            return (ItemStack) this.b.get(i);
        }

        @Override // mctech.m.a.g
        public void setStackInSlot(int i, ItemStack itemStack) {
            this.b.set(i, itemStack);
            a();
        }

        @Override // mctech.m.a.g
        public int getMaxStackSize(int i) {
            return 64;
        }

        @Override // mctech.m.a.g
        public boolean canInsert(int i, ItemStack itemStack) {
            return true;
        }

        @Override // mctech.m.a.g
        public boolean canExtract(int i, ItemStack itemStack) {
            return true;
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/e/j$a.class */
    public static class a {
        String a;
        int b;
        int c;
        boolean d;
        Vec2i e;
        int f;
        ResourceLocation g;
        mctech.m.c.g h;

        public a(String str, int i, int i2, boolean z, Vec2i vec2i, int i3, ResourceLocation resourceLocation, mctech.m.c.g gVar) {
            this.a = str;
            this.b = i;
            this.c = i2;
            this.d = z;
            this.e = vec2i;
            this.f = i3;
            this.g = resourceLocation;
            this.h = gVar;
        }

        public String a() {
            return this.a;
        }

        public int b() {
            return this.b;
        }

        public int c() {
            return this.c;
        }

        public boolean d() {
            return this.d;
        }

        public Vec2i e() {
            return this.e;
        }

        public int f() {
            return this.f;
        }

        public ResourceLocation g() {
            return this.g;
        }

        public mctech.m.c.g h() {
            return this.h;
        }
    }
}
