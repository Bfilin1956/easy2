package mctech.g.d.a.b.b;

import java.util.function.Supplier;
import mctech.init.MCTechDataComponent;
import net.minecraft.core.NonNullList;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/a/b/b/c.class */
public class c extends mctech.g.d.a.b.a<a> {
    public static final int c = 1;
    public static final int d = 2;
    public final b.a e;

    @Nullable
    private final NonNullList<ItemStack> f;
    private final mctech.g.b.a.a.b g;
    private final mctech.g.b.a.a.b h;

    @Nullable
    private final mctech.g.b.a.a.e<mctech.g.d.a.b.b> i;

    public c(@Nullable MenuType<?> menuType, b.a aVar, int i, Inventory inventory, mctech.g.d.a.b.a.InterfaceC0013a interfaceC0013a) {
        super(menuType, i, inventory, interfaceC0013a);
        this.e = aVar;
        this.f = null;
        this.g = (mctech.g.b.a.a.b) a(mctech.g.b.a.a.b.a((Supplier<Boolean>) () -> {
            return Boolean.valueOf(d().b());
        }));
        this.h = (mctech.g.b.a.a.b) a(mctech.g.b.a.a.b.a((Supplier<Boolean>) () -> {
            return Boolean.valueOf(d().c());
        }));
        if (this.e.d()) {
            this.i = (mctech.g.b.a.a.e) b(mctech.g.b.a.a.e.a(mctech.g.d.a.b.b.class, () -> {
                return ((a) e().getOrDefault(MCTechDataComponent.ITEM_FILTER, a.a)).d();
            }, bVar -> {
                b(itemStack -> {
                    a aVar2 = (a) itemStack.getOrDefault(MCTechDataComponent.ITEM_FILTER, a.a);
                    itemStack.set(MCTechDataComponent.ITEM_FILTER, new a(aVar2.a(), aVar2.b(), aVar2.c(), bVar));
                    return itemStack;
                });
            }));
        } else {
            this.i = null;
        }
        for (int i2 = 0; i2 < this.e.b(); i2++) {
            int i3 = i2;
            addSlot(new d(() -> {
                return a(i3);
            }, itemStack -> {
                a(i3, itemStack);
            }, i2, 24 + ((i2 % 5) * 18), 25 + (20 * (i2 / 5))));
        }
        a(24, 81 + (aVar.a() * 18));
    }

    public c(@Nullable MenuType<?> menuType, b.a aVar, int i, Inventory inventory) {
        super(menuType, i, inventory);
        this.e = aVar;
        this.f = NonNullList.withSize(this.e.b(), ItemStack.EMPTY);
        this.g = (mctech.g.b.a.a.b) a(mctech.g.b.a.a.b.a());
        this.h = (mctech.g.b.a.a.b) a(mctech.g.b.a.a.b.a());
        if (this.e.d()) {
            this.i = (mctech.g.b.a.a.e) b(mctech.g.b.a.a.e.a(mctech.g.d.a.b.b.class));
        } else {
            this.i = null;
        }
        for (int i2 = 0; i2 < this.e.b(); i2++) {
            int i3 = i2;
            addSlot(new d(() -> {
                return (ItemStack) this.f.get(i3);
            }, itemStack -> {
                this.f.set(i3, itemStack);
            }, i2, 24 + ((i2 % 9) * 18), 25 + (18 * (i2 / 9))));
        }
        a(24, 63 + (aVar.a() * 18));
    }

    @Override // mctech.g.d.a.b.a
    protected DataComponentType<a> b() {
        return MCTechDataComponent.ITEM_FILTER;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mctech.g.d.a.b.a
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public a c() {
        return a.a;
    }

    public boolean g() {
        return this.g.b();
    }

    public boolean h() {
        return this.h.b();
    }

    public mctech.g.d.a.b.b i() {
        if (this.i == null) {
            return mctech.g.d.a.b.b.IGNORE;
        }
        return (mctech.g.d.a.b.b) this.i.a();
    }

    public void a(mctech.g.d.a.b.b bVar) {
        if (this.i != null) {
            this.i.a(bVar);
            c(this.i);
        }
    }

    private ItemStack a(int i) {
        a aVarD = d();
        if (i >= aVarD.a().size()) {
            return ItemStack.EMPTY;
        }
        return (ItemStack) aVarD.a().get(i);
    }

    private void a(int i, ItemStack itemStack) {
        a(aVar -> {
            NonNullList nonNullListWithSize = NonNullList.withSize(this.e.b(), ItemStack.EMPTY);
            int i2 = 0;
            while (i2 < nonNullListWithSize.size()) {
                nonNullListWithSize.set(i2, i2 < aVar.a().size() ? (ItemStack) aVar.a().get(i2) : ItemStack.EMPTY);
                i2++;
            }
            nonNullListWithSize.set(i, itemStack);
            return new a((NonNullList<ItemStack>) nonNullListWithSize, aVar.b(), aVar.c(), aVar.d());
        });
    }

    @Override // mctech.g.d.a.b.a
    public boolean clickMenuButton(@NotNull Player player, int i) {
        if (i == 1) {
            a(aVar -> {
                return new a(aVar.a(), !aVar.b(), aVar.c(), aVar.d());
            });
            return true;
        }
        if (i == 2 && this.e.c()) {
            a(aVar2 -> {
                return new a(aVar2.a(), aVar2.b(), !aVar2.c(), aVar2.d());
            });
            return true;
        }
        return super.clickMenuButton(player, i);
    }

    @NotNull
    public ItemStack quickMoveStack(@NotNull Player player, int i) {
        return ItemStack.EMPTY;
    }
}
