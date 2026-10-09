package mctech.g.d.a.b.a;

import java.util.Objects;
import java.util.function.Supplier;
import mctech.g.b.a.a.g;
import mctech.init.MCTechDataComponent;
import net.minecraft.core.NonNullList;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.fluids.FluidStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/a/b/a/c.class */
public class c extends mctech.g.d.a.b.a<a> {
    public static final int c = 1;
    public static final int d = 2;
    public final b.a e;
    private final mctech.g.b.a.a.b f;
    private final mctech.g.b.a.a.b g;

    public c(@Nullable MenuType<?> menuType, b.a aVar, int i, Inventory inventory, mctech.g.d.a.b.a.InterfaceC0013a interfaceC0013a) {
        super(menuType, i, inventory, interfaceC0013a);
        this.e = aVar;
        this.f = (mctech.g.b.a.a.b) a(mctech.g.b.a.a.b.a((Supplier<Boolean>) () -> {
            return Boolean.valueOf(d().b());
        }));
        this.g = (mctech.g.b.a.a.b) a(mctech.g.b.a.a.b.a((Supplier<Boolean>) () -> {
            return Boolean.valueOf(d().c());
        }));
        for (int i2 = 0; i2 < this.e.b(); i2++) {
            int i3 = i2;
            a(g.a((Supplier<FluidStack>) () -> {
                return a(i3);
            }));
            addSlot(new d(() -> {
                return a(i3);
            }, fluidStack -> {
                a(i3, fluidStack);
            }, i2, 24 + ((i2 % 5) * 18), 25 + (20 * (i2 / 5))));
        }
        a(24, 81 + (aVar.a() * 18));
    }

    public c(@Nullable MenuType<?> menuType, b.a aVar, int i, Inventory inventory) {
        super(menuType, i, inventory);
        this.e = aVar;
        this.f = (mctech.g.b.a.a.b) a(mctech.g.b.a.a.b.a());
        this.g = (mctech.g.b.a.a.b) a(mctech.g.b.a.a.b.a());
        for (int i2 = 0; i2 < this.e.b(); i2++) {
            g gVar = (g) a(g.a());
            Objects.requireNonNull(gVar);
            Supplier supplier = gVar::b;
            Objects.requireNonNull(gVar);
            addSlot(new d(supplier, gVar::a, i2, 24 + ((i2 % 9) * 18), 25 + (18 * (i2 / 9))));
        }
        a(24, 63 + (aVar.a() * 18));
    }

    @Override // mctech.g.d.a.b.a
    protected DataComponentType<a> b() {
        return MCTechDataComponent.FLUID_FILTER;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mctech.g.d.a.b.a
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public a c() {
        return a.a;
    }

    public boolean g() {
        return this.f.b();
    }

    public boolean h() {
        return this.g.b();
    }

    private FluidStack a(int i) {
        a aVarD = d();
        if (i >= aVarD.a().size()) {
            return FluidStack.EMPTY;
        }
        return (FluidStack) aVarD.a().get(i);
    }

    private void a(int i, FluidStack fluidStack) {
        a(aVar -> {
            NonNullList nonNullListWithSize = NonNullList.withSize(this.e.b(), FluidStack.EMPTY);
            int i2 = 0;
            while (i2 < nonNullListWithSize.size()) {
                nonNullListWithSize.set(i2, i2 < aVar.a().size() ? (FluidStack) aVar.a().get(i2) : FluidStack.EMPTY);
                i2++;
            }
            nonNullListWithSize.set(i, fluidStack);
            return new a((NonNullList<FluidStack>) nonNullListWithSize, aVar.b(), aVar.c());
        });
    }

    @Override // mctech.g.d.a.b.a
    public boolean clickMenuButton(@NotNull Player player, int i) {
        if (i == 1) {
            a(aVar -> {
                return new a(aVar.a(), !aVar.b(), aVar.c());
            });
            return true;
        }
        if (i == 2 && this.e.c()) {
            a(aVar2 -> {
                return new a(aVar2.a(), aVar2.b(), !aVar2.c());
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
