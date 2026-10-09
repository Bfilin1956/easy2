package mctech.m.f;

import mctech.MCTech;
import mctech.components.ContainerComponent;
import mctech.init.MCTechDataComponent;
import mctech.m.b.S;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/f/j.class */
public abstract class j implements mctech.m.a.i {
    protected final Player e;
    protected NonNullList<ItemStack> f = NonNullList.withSize(getSlotCount(), ItemStack.EMPTY);
    protected final int g;
    protected final ItemStack h;
    protected final Slot i;

    public abstract int getSlotCount();

    public j(Player player, mctech.m.a.e eVar, ItemStack itemStack, Slot slot) {
        this.e = player;
        this.h = itemStack.copy();
        this.i = slot;
        if (MCTech.PLATFORM.g()) {
            int iNextInt = player.level().getRandom().nextInt(mctech.q.c.b);
            this.g = iNextInt;
            eVar.a_(itemStack, iNextInt);
            return;
        }
        this.g = -1;
    }

    public int b() {
        return this.g;
    }

    @Override // mctech.m.a.d
    public boolean a(Player player, InteractionHand interactionHand, Direction direction) {
        return true;
    }

    @Override // mctech.m.a.d
    public boolean c(Player player) {
        return player.isAlive() && e(player);
    }

    private boolean e(Player player) {
        if (this.i != null) {
            return c(this.i.getItem());
        }
        Inventory inventory = player.getInventory();
        if (c(player.containerMenu.getCarried())) {
            return true;
        }
        for (int i = 0; i < inventory.getContainerSize(); i++) {
            if (c(inventory.getItem(i))) {
                return true;
            }
        }
        for (int i2 = 0; i2 < getSlotCount(); i2++) {
            if (c(getStackInSlot(i2))) {
                return true;
            }
        }
        return false;
    }

    protected ItemStack b(Player player) {
        if (this.i != null && c(this.i.getItem())) {
            return this.i.getItem();
        }
        Inventory inventory = player.getInventory();
        ItemStack carried = player.containerMenu.getCarried();
        if (c(carried)) {
            return carried;
        }
        for (int i = 0; i < inventory.getContainerSize(); i++) {
            if (c(inventory.getItem(i))) {
                return inventory.getItem(i);
            }
        }
        for (int i2 = 0; i2 < getSlotCount(); i2++) {
            if (c(getStackInSlot(i2))) {
                return getStackInSlot(i2);
            }
        }
        return a();
    }

    @Override // mctech.m.a.d
    @OnlyIn(Dist.CLIENT)
    public Screen a(Player player, InteractionHand interactionHand, Direction direction, S s) {
        return new mctech.m.d.a((ContainerComponent) s);
    }

    @Override // mctech.m.a.d
    public void a_(Player player) {
    }

    public void b(ItemStack itemStack) {
    }

    protected final boolean c(ItemStack itemStack) {
        return (itemStack.getItem() instanceof mctech.m.a.e) && itemStack.getItem().b_(itemStack) == this.g;
    }

    public ItemStack d(Player player) {
        Inventory inventory = player.getInventory();
        AbstractContainerMenu abstractContainerMenu = player.containerMenu;
        if (c(abstractContainerMenu.getCarried())) {
            ItemStack itemStackA = a();
            abstractContainerMenu.setCarried(itemStackA);
            return itemStackA;
        }
        for (int i = 0; i < inventory.getContainerSize(); i++) {
            if (c(inventory.getItem(i))) {
                ItemStack item = inventory.getItem(i);
                inventory.setItem(i, item);
                return item;
            }
        }
        return ItemStack.EMPTY;
    }

    @Override // mctech.m.a.g
    public ItemStack getStackInSlot(int i) {
        return (ItemStack) this.f.get(i);
    }

    @Override // mctech.m.a.g
    public void setStackInSlot(int i, ItemStack itemStack) {
        this.f.set(i, itemStack);
        if (itemStack.getCount() > getMaxStackSize(i)) {
            itemStack.setCount(getMaxStackSize(i));
        }
        c();
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

    @Override // mctech.m.a.i
    public ItemStack a() {
        return this.h;
    }

    protected void c() {
        if (this.i != null) {
            ItemStack item = this.i.getItem();
            if (c(item)) {
                b(a(item, true));
            }
            this.i.setChanged();
        }
    }

    @Override // mctech.m.a.i
    public mctech.m.a.i a(ItemStack itemStack) {
        a(a(itemStack, false));
        return this;
    }

    public void a(CompoundTag compoundTag) {
        if (this.e != null) {
            ContainerHelper.loadAllItems(compoundTag, this.f, this.e.registryAccess());
        }
    }

    public void b(CompoundTag compoundTag) {
        if (this.e != null) {
            ContainerHelper.saveAllItems(compoundTag, this.f, this.e.registryAccess());
        }
    }

    public CompoundTag a(ItemStack itemStack, boolean z) {
        if (itemStack.has(MCTechDataComponent.NBT_TAG)) {
            return (CompoundTag) itemStack.get(MCTechDataComponent.NBT_TAG);
        }
        CompoundTag compoundTag = new CompoundTag();
        if (z) {
            itemStack.set(MCTechDataComponent.NBT_TAG, compoundTag);
        }
        return compoundTag;
    }
}
