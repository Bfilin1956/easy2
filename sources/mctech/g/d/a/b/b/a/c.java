package mctech.g.d.a.b.b.a;

import java.util.function.Supplier;
import mctech.g.b.a.a.e;
import mctech.init.MCTechDataComponent;
import net.minecraft.core.NonNullList;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ClickType;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/a/b/b/a/c.class */
public class c extends mctech.g.d.a.b.a<a> {
    public static final int c = 2;

    @Nullable
    private final NonNullList<ItemStack> d;
    private final mctech.g.b.a.a.b e;
    private final e<mctech.g.d.a.b.b> f;

    public c(@Nullable MenuType<?> menuType, int i, Inventory inventory, mctech.g.d.a.b.a.InterfaceC0013a interfaceC0013a) {
        super(menuType, i, inventory, interfaceC0013a);
        this.d = null;
        this.e = (mctech.g.b.a.a.b) a(mctech.g.b.a.a.b.a((Supplier<Boolean>) () -> {
            return Boolean.valueOf(d().b());
        }));
        this.f = (e) b(e.a(mctech.g.d.a.b.b.class, () -> {
            return ((a) e().getOrDefault(MCTechDataComponent.LIMITED_ITEM_FILTER, a.b)).c();
        }, bVar -> {
            b(itemStack -> {
                a aVar = (a) itemStack.getOrDefault(MCTechDataComponent.LIMITED_ITEM_FILTER, a.b);
                itemStack.set(MCTechDataComponent.LIMITED_ITEM_FILTER, new a(aVar.a(), aVar.b(), bVar));
                return itemStack;
            });
        }));
        for (int i2 = 0; i2 < 18; i2++) {
            int i3 = i2;
            addSlot(new d(() -> {
                return a(i3);
            }, itemStack -> {
                a(i3, itemStack);
            }, i2, 24 + ((i2 % 5) * 18), 25 + (20 * (i2 / 5))));
        }
        a(24, 117);
    }

    public c(@Nullable MenuType<?> menuType, int i, Inventory inventory) {
        super(menuType, i, inventory);
        this.d = NonNullList.withSize(18, ItemStack.EMPTY);
        this.e = (mctech.g.b.a.a.b) a(mctech.g.b.a.a.b.a());
        this.f = (e) b(e.a(mctech.g.d.a.b.b.class));
        for (int i2 = 0; i2 < 18; i2++) {
            int i3 = i2;
            addSlot(new d(() -> {
                return (ItemStack) this.d.get(i3);
            }, itemStack -> {
                this.d.set(i3, itemStack);
            }, i2, 24 + ((i2 % 9) * 18), 25 + (18 * (i2 / 9))));
        }
        a(24, 99);
    }

    @Override // mctech.g.d.a.b.a
    protected DataComponentType<a> b() {
        return MCTechDataComponent.LIMITED_ITEM_FILTER;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mctech.g.d.a.b.a
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public a c() {
        return a.b;
    }

    public boolean g() {
        return this.e.b();
    }

    public mctech.g.d.a.b.b h() {
        return (mctech.g.d.a.b.b) this.f.a();
    }

    public void a(mctech.g.d.a.b.b bVar) {
        if (this.f != null) {
            this.f.a(bVar);
            c(this.f);
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
            NonNullList nonNullListWithSize = NonNullList.withSize(18, ItemStack.EMPTY);
            int i2 = 0;
            while (i2 < nonNullListWithSize.size()) {
                nonNullListWithSize.set(i2, i2 < aVar.a().size() ? (ItemStack) aVar.a().get(i2) : ItemStack.EMPTY);
                i2++;
            }
            nonNullListWithSize.set(i, itemStack);
            return new a((NonNullList<ItemStack>) nonNullListWithSize, aVar.b(), aVar.c());
        });
    }

    @Override // mctech.g.d.a.b.a
    public void doClick(int i, int i2, @NotNull ClickType clickType, @NotNull Player player) {
        if (i >= 0 && i < this.slots.size()) {
            Slot slot = getSlot(i);
            if (slot instanceof d) {
                d dVar = (d) slot;
                if (clickType != ClickType.PICKUP && clickType != ClickType.QUICK_MOVE) {
                    return;
                }
                if (!dVar.c()) {
                    ItemStack carried = getCarried();
                    ItemStack itemStackB = dVar.b();
                    if (!carried.isEmpty() && ItemStack.isSameItem(carried, itemStackB)) {
                        dVar.a(itemStackB.copyWithCount(itemStackB.getCount() + carried.getCount()));
                        return;
                    }
                }
            }
        }
        super.doClick(i, i2, clickType, player);
    }

    @Override // mctech.g.d.a.b.a
    public boolean clickMenuButton(@NotNull Player player, int i) {
        if (i == 2) {
            a(aVar -> {
                return new a(aVar.a(), !aVar.b(), aVar.c());
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
