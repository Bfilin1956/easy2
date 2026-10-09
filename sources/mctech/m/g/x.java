package mctech.m.g;

import com.mojang.datafixers.util.Pair;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/g/x.class */
public class x extends Slot {
    public static final Container d = new SimpleContainer(0);
    protected Pair<ResourceLocation, ResourceLocation> e;
    protected mctech.m.a.g f;
    protected int g;
    protected boolean h;

    public x(mctech.m.a.g gVar, int i, int i2, int i3) {
        super(d, i, i2, i3);
        this.h = false;
        this.f = gVar;
        this.g = i;
    }

    public mctech.m.a.g f() {
        return this.f;
    }

    public ItemStack getItem() {
        return f().getStackInSlot(this.g);
    }

    public int getMaxStackSize() {
        return f().getMaxStackSize(this.g);
    }

    public void setChanged() {
        mctech.m.a.g gVarF = f();
        if (gVarF instanceof mctech.m.f.f) {
            ((mctech.m.f.f) gVarF).onNotify(gVarF, this.g);
        }
    }

    public ItemStack remove(int i) {
        ItemStack stackInSlot = f().getStackInSlot(this.g);
        if (stackInSlot.isEmpty()) {
            return ItemStack.EMPTY;
        }
        ItemStack itemStackSplit = stackInSlot.split(i);
        f().setStackInSlot(this.g, stackInSlot);
        return itemStackSplit;
    }

    public void set(ItemStack itemStack) {
        f().setStackInSlot(this.g, itemStack);
        int maxStackSize = this.f.getMaxStackSize(this.g);
        if (itemStack.getCount() > maxStackSize) {
            itemStack.setCount(maxStackSize);
        }
        if (this.h) {
            this.h = false;
            setChanged();
        }
    }

    public void c(ItemStack itemStack) {
        set(itemStack);
    }

    public void g() {
        this.h = true;
    }

    public boolean isSameInventory(Slot slot) {
        return (slot instanceof x) && ((x) slot).f() == f();
    }

    @OnlyIn(Dist.CLIENT)
    public Pair<ResourceLocation, ResourceLocation> getNoItemIcon() {
        return this.e;
    }

    public x a(ResourceLocation resourceLocation) {
        return setBackground(InventoryMenu.BLOCK_ATLAS, resourceLocation);
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public x setBackground(ResourceLocation resourceLocation, ResourceLocation resourceLocation2) {
        this.e = (resourceLocation == null || resourceLocation2 == null) ? null : Pair.of(resourceLocation, resourceLocation2);
        return this;
    }
}
