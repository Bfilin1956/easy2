package mctech.g.d.a.b;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Supplier;
import mctech.g.b.a.a.h;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ClickType;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.items.IItemHandlerModifiable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/a/b/a.class */
public abstract class a<T> extends mctech.g.b.b {
    public static final int b = 0;

    @Nullable
    private final InterfaceC0013a c;
    private final h d;

    /* JADX INFO: renamed from: mctech.g.d.a.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/a/b/a$a.class */
    public interface InterfaceC0013a {
        ItemStack a();

        void a(ItemStack itemStack);

        boolean a(Player player);

        boolean b();
    }

    protected abstract DataComponentType<T> b();

    protected abstract T c();

    protected a(@Nullable MenuType<?> menuType, int i, Inventory inventory, InterfaceC0013a interfaceC0013a) {
        super(menuType, i, inventory);
        this.c = interfaceC0013a;
        this.d = (h) a(h.a((Supplier<Integer>) this::f));
    }

    protected a(@Nullable MenuType<?> menuType, int i, Inventory inventory) {
        super(menuType, i, inventory);
        this.c = null;
        this.d = (h) a(h.a());
    }

    protected T d() {
        return (T) e().getOrDefault(b(), c());
    }

    protected void a(T t) {
        ItemStack itemStackCopy = e().copy();
        itemStackCopy.set(b(), t);
        a(itemStackCopy);
    }

    protected void a(Function<T, T> function) {
        a(function.apply(d()));
    }

    protected ItemStack e() {
        return ((InterfaceC0013a) Objects.requireNonNull(this.c)).a();
    }

    protected void a(ItemStack itemStack) {
        ((InterfaceC0013a) Objects.requireNonNull(this.c)).a(itemStack);
    }

    protected void b(Function<ItemStack, ItemStack> function) {
        a(function.apply(e()));
    }

    public boolean stillValid(Player player) {
        return player.level().isClientSide() || ((InterfaceC0013a) Objects.requireNonNull(this.c)).a(player);
    }

    @Override // mctech.g.b.b
    protected Slot a(Inventory inventory, final int i, int i2, int i3) {
        return new Slot(inventory, i, i2, i3) { // from class: mctech.g.d.a.b.a.1
            public boolean mayPickup(@NotNull Player player) {
                return i != a.this.d.b();
            }
        };
    }

    public boolean clickMenuButton(@NotNull Player player, int i) {
        if (i == 0) {
            if (this.c == null || !this.c.b()) {
                a().player.closeContainer();
                return true;
            }
            return true;
        }
        return super.clickMenuButton(player, i);
    }

    private int f() {
        if (this.c instanceof b) {
            return a().selected;
        }
        return -1;
    }

    public void doClick(int i, int i2, @NotNull ClickType clickType, @NotNull Player player) {
        if (i >= 0 && i < this.slots.size()) {
            Slot slot = getSlot(i);
            if (slot instanceof mctech.g.d.a.b.c) {
                mctech.g.d.a.b.c cVar = (mctech.g.d.a.b.c) slot;
                if (clickType != ClickType.PICKUP && clickType != ClickType.QUICK_MOVE) {
                    return;
                }
                if (!cVar.c()) {
                    cVar.d();
                    return;
                }
            }
        }
        super.doClick(i, i2, clickType, player);
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/a/b/a$b.class */
    public static final class b implements InterfaceC0013a {
        private final Player a;
        private ItemStack b;

        public b(Player player, ItemStack itemStack) {
            this.a = player;
            this.b = itemStack;
        }

        @Override // mctech.g.d.a.b.a.InterfaceC0013a
        public ItemStack a() {
            return this.b.copy();
        }

        @Override // mctech.g.d.a.b.a.InterfaceC0013a
        public void a(ItemStack itemStack) {
            this.a.setItemSlot(EquipmentSlot.MAINHAND, itemStack);
            this.b = itemStack;
        }

        @Override // mctech.g.d.a.b.a.InterfaceC0013a
        public boolean a(Player player) {
            return player.getMainHandItem().equals(this.b);
        }

        @Override // mctech.g.d.a.b.a.InterfaceC0013a
        public boolean b() {
            return false;
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/a/b/a$c.class */
    public static final class c implements InterfaceC0013a {
        private ItemStack a;
        private final IItemHandlerModifiable b;
        private final int c;

        @Nullable
        private final Runnable d;

        public c(ItemStack itemStack, IItemHandlerModifiable iItemHandlerModifiable, int i, @Nullable Runnable runnable) {
            this.a = itemStack;
            this.b = iItemHandlerModifiable;
            this.c = i;
            this.d = runnable;
        }

        @Override // mctech.g.d.a.b.a.InterfaceC0013a
        public ItemStack a() {
            return this.a.copy();
        }

        @Override // mctech.g.d.a.b.a.InterfaceC0013a
        public void a(ItemStack itemStack) {
            this.b.setStackInSlot(this.c, itemStack);
            this.a = itemStack;
        }

        @Override // mctech.g.d.a.b.a.InterfaceC0013a
        public boolean a(Player player) {
            return this.b.getStackInSlot(this.c).equals(this.a);
        }

        @Override // mctech.g.d.a.b.a.InterfaceC0013a
        public boolean b() {
            if (this.d != null) {
                this.d.run();
                return true;
            }
            return false;
        }
    }
}
