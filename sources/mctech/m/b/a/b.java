package mctech.m.b.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.IntStream;
import mctech.blockentities.c.C0057d;
import mctech.m.b.C0148h;
import mctech.m.f.g;
import mctech.utils.c.h;
import mctech.utils.math.geometry.Vec2i;
import net.minecraft.core.NonNullList;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.StackedContents;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/a/b.class */
public class b extends g implements CraftingContainer {

    @NotNull
    private final C0057d b;

    @NotNull
    private final C0148h c;

    @NotNull
    private final Vec2i d;

    @NotNull
    private final Vec2i e;

    public b(@NotNull C0148h c0148h, @NotNull C0057d c0057d, @NotNull Vec2i vec2i, @NotNull Vec2i vec2i2) {
        super(c0057d);
        this.c = c0148h;
        this.b = c0057d;
        this.d = vec2i;
        this.e = vec2i2;
    }

    public int getWidth() {
        return this.e.getX();
    }

    public int getHeight() {
        return this.e.getY();
    }

    @NotNull
    public List<ItemStack> getItems() {
        ArrayList arrayList = new ArrayList();
        for (int x = this.d.getX(); x < this.d.getY() + 1; x++) {
            arrayList.add(getItem(x));
        }
        return arrayList;
    }

    public int getContainerSize() {
        return a();
    }

    public boolean isEmpty() {
        return h.a((NonNullList<ItemStack>) NonNullList.copyOf(getItems()));
    }

    @NotNull
    public ItemStack getItem(int i) {
        return this.b.getStackInSlot(i);
    }

    @NotNull
    public ItemStack removeItem(int i, int i2) {
        ItemStack itemStackA = a(i, i2, false);
        setChanged();
        return itemStackA;
    }

    @NotNull
    public ItemStack removeItemNoUpdate(int i) {
        return a(i, this.b.getMaxStackSize(i), false);
    }

    public void setItem(int i, @NotNull ItemStack itemStack) {
        this.b.setStackInSlot(i, itemStack);
    }

    public void setChanged() {
    }

    public boolean stillValid(@NotNull Player player) {
        return this.c.stillValid(player);
    }

    public void clearContent() {
        IntStream.range(this.d.getX(), this.d.getY()).forEach(i -> {
            setStackInSlot(i, ItemStack.EMPTY);
        });
    }

    public void fillStackedContents(@NotNull StackedContents stackedContents) {
        Iterator<ItemStack> it = getItems().iterator();
        while (it.hasNext()) {
            stackedContents.accountSimpleStack(it.next());
        }
    }

    public int a() {
        return getWidth() * getHeight();
    }

    public ItemStack a(int i, int i2, boolean z) {
        int x = i + this.d.getX();
        ItemStack item = getItem(x);
        if (item.isEmpty()) {
            return ItemStack.EMPTY;
        }
        if (i2 >= item.getCount()) {
            if (!z) {
                setItem(x, ItemStack.EMPTY);
                return item;
            }
            return item.copy();
        }
        ItemStack itemStackCopy = item.copy();
        itemStackCopy.setCount(i2);
        if (!z) {
            ItemStack itemStackCopy2 = item.copy();
            itemStackCopy2.shrink(i2);
            setItem(x, itemStackCopy2);
        }
        return itemStackCopy;
    }
}
