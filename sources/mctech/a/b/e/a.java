package mctech.a.b.e;

import mctech.a.b.b.e;
import mctech.m.a.j;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.items.SlotItemHandler;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/a/b/e/a.class */
public class a extends SlotItemHandler implements mctech.a.b.c.a<ItemStack>, j {
    private boolean a;
    private int b;

    public a(mctech.m.f.c cVar, int i, int i2, int i3, int i4) {
        super(cVar.b(), i, i2, i3);
        this.b = i4;
    }

    public a(mctech.m.f.c cVar, int i, int i2, int i3) {
        this(cVar, i, i2, i3, -1);
    }

    public a a(boolean z) {
        this.a = z;
        return this;
    }

    public a b(int i) {
        this.b = i;
        return this;
    }

    public boolean m() {
        return this.a;
    }

    public boolean isActive() {
        return !this.a && super.isActive();
    }

    public boolean isHighlightable() {
        return !this.a && super.isHighlightable();
    }

    public boolean mayPlace(@NotNull ItemStack itemStack) {
        return !this.a && e.a.matches(itemStack);
    }

    public boolean mayPickup(@NotNull Player player) {
        return false;
    }

    public void set(@NotNull ItemStack itemStack) {
        super.set(itemStack);
    }

    public int getMaxStackSize() {
        return this.b <= 0 ? Math.min(64, getItem().getMaxStackSize()) : this.b;
    }

    public void onTake(@NotNull Player player, @NotNull ItemStack itemStack) {
    }

    @NotNull
    public ItemStack safeTake(int i, int i2, @NotNull Player player) {
        return ItemStack.EMPTY;
    }

    @NotNull
    public ItemStack safeInsert(@NotNull ItemStack itemStack, int i) {
        if (!itemStack.isEmpty() && mayPlace(itemStack)) {
            set(itemStack.copyWithCount(1));
        }
        return itemStack;
    }

    @NotNull
    public ItemStack remove(int i) {
        return ItemStack.EMPTY;
    }

    @Override // mctech.a.b.c.a
    public int a() {
        return this.index;
    }

    @Override // mctech.a.b.c.a
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public ItemStack b() {
        return getItem().copy();
    }

    @Override // mctech.a.b.c.a
    public int c() {
        return this.x;
    }

    @Override // mctech.a.b.c.a
    public int d() {
        return this.y;
    }

    @Override // mctech.a.b.c.a
    public int e() {
        return 16;
    }

    @Override // mctech.a.b.c.a
    public int f() {
        return 16;
    }

    @Override // mctech.a.b.c.a
    public void a(int i) {
        set(getItem().copyWithCount(i));
    }

    @Override // mctech.a.b.c.a
    public int g() {
        return getItem().getCount();
    }

    @Override // mctech.a.b.c.a
    public int h() {
        if (getItem().isDamageableItem()) {
            return 1;
        }
        return getMaxStackSize();
    }

    @Override // mctech.a.b.c.a
    public int i() {
        return 1;
    }

    @Override // mctech.a.b.c.a
    public boolean j() {
        return false;
    }

    @Override // mctech.a.b.c.a
    public String k() {
        return "";
    }

    @Override // mctech.a.b.c.a
    public boolean l() {
        return !m();
    }
}
