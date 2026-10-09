package mctech.m.b;

import java.util.Objects;
import java.util.function.Supplier;
import mctech.blockentities.c.C0074u;
import mctech.components.ContainerComponent;
import mctech.components.a.C0097j;
import mctech.components.a.C0099l;
import mctech.components.a.C0101n;
import mctech.init.MCTechLang;
import mctech.utils.math.geometry.Vec2i;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ClickType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: renamed from: mctech.m.b.al, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/al.class */
public class C0139al extends ContainerComponent<mctech.blockentities.m> implements mctech.o.g {
    public int a;
    public b b;
    private mctech.components.a.R<?> c;
    private mctech.components.a.R<?> d;

    public C0139al(final mctech.blockentities.m mVar, Player player, int i) {
        super(mVar, player, i);
        this.addedPreviewer = true;
        this.a = mVar.getWidth();
        int i2 = 123 - (9 * this.a);
        this.b = b.DEFAULT;
        switch (this.a) {
            case C0074u.j /* 10 */:
                this.b = b.X_10;
                i2 += 9;
                break;
            case 11:
                this.b = b.X_11;
                i2 += 18;
                break;
        }
        int i3 = mVar.k + 6;
        for (int i4 = 0; i4 < i3 * 6; i4++) {
            int i5 = i4 % i3;
            if (i5 < this.a) {
                Objects.requireNonNull(mVar);
                addSlot(new a(mVar, i4, i2 + (18 * i5), 29 + (18 * (i4 / i3)), mVar::a, mVar.l));
            }
        }
        for (int i6 = 0; i6 < 2; i6++) {
            addSlot(new mctech.m.g.s(mVar, (mVar.inventorySize - 2) + i6, this.b.h, this.b.i + (i6 * 19)));
        }
        addPlayerInventoryAt(player.getInventory(), this.b.d, this.b.e);
        getComponents().clear();
        Vec2i vec2i = new Vec2i(100 + (10 * mVar.k), 20);
        addComponent(new mctech.components.a.I<Object>(this, C0101n.a, 1, 32, 10, 10, vec2i, vec2i, vec2i, () -> {
            return mVar.q;
        }) { // from class: mctech.m.b.al.1
            @Override // mctech.components.a.R
            public boolean q() {
                return super.q() || mVar.q;
            }
        }.a((mctech.components.a.P.a) i7 -> {
            this.c.a_(!mVar.q);
            this.d.a_(!mVar.q);
            mVar.sendToServer(10000, !mVar.q ? 1 : 0);
        }).b((Component) MCTechLang.GUI_MCTECH_REACTOR_OPTIONS.get()));
        this.c = new mctech.components.a.R(C0101n.a, 24, 29, 10, 10, new Vec2i(50, 0), new Vec2i(50, 0)).a(r -> {
            mVar.sendToServer(11000, 1);
        }).b((Component) MCTechLang.GUI_MCTECH_REACTOR_AUTO_FILTER.get());
        this.c.a_(mVar.q);
        addComponent(this.c);
        this.d = new mctech.components.a.R(C0101n.a, 24, 29 + 14, 10, 10, new Vec2i(70, 0), new Vec2i(70, 0)).a(r2 -> {
            mVar.sendToServer(11000, 0);
        }).b((Component) MCTechLang.GUI_MCTECH_REACTOR_CLEAR_FILTER.get());
        this.d.a_(mVar.q);
        addComponent(this.d);
        addComponent(new C0097j(this, () -> {
            return mVar.k;
        }));
        addComponent(new mctech.components.b.o(this.b.f, this.b.g, 160, 10, null, 0, 244).a(() -> {
            return Float.valueOf(mVar.getHeat());
        }, () -> {
            return Float.valueOf(mVar.getMaxHeat());
        }).a(C0101n.b.a()).b(() -> {
            return "gui.mctech.reactor.heat_amount";
        }));
        addComponent(new mctech.components.D(mVar, this.a));
        addComponent(new C0099l(20, 75, mVar.c, () -> {
            return 4;
        }).b(() -> {
            return Boolean.valueOf(mVar.o);
        }));
        addComponent(new C0099l(this.b.h - 28, 18, mVar.d, () -> {
            return 4;
        }).b(() -> {
            return Boolean.valueOf(mVar.p);
        }));
        addComponent(new C0099l(this.b.h - 28, 80, mVar.e, () -> {
            return 4;
        }).b(() -> {
            return Boolean.valueOf(mVar.p);
        }));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // mctech.components.ContainerComponent, mctech.m.b.S
    public int getInventorySize() {
        return ((mctech.blockentities.m) getHolder()).getWidth() * 6;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // mctech.components.ContainerComponent
    public ResourceLocation getTexture() {
        String str = String.format("%sx%s", Integer.valueOf(((mctech.blockentities.m) getHolder()).getHeight()), Integer.valueOf(((mctech.blockentities.m) getHolder()).getWidth()));
        return mctech.m.a.a(this, ((mctech.blockentities.m) getHolder()).machineTier(), (Supplier<String>) () -> {
            return String.format("reactor_%s", str);
        });
    }

    public void doClick(int i, int i2, ClickType clickType, Player player) {
        if (((mctech.blockentities.m) this.gui).q) {
            if (clickType == ClickType.PICKUP && i >= 0 && i < this.slots.size()) {
                Slot slot = getSlot(i);
                if (!(slot instanceof a)) {
                    super.doClick(i, i2, clickType, player);
                    return;
                } else {
                    ((a) slot).a(getCarried());
                    return;
                }
            }
            return;
        }
        super.doClick(i, i2, clickType, player);
    }

    /* JADX INFO: renamed from: mctech.m.b.al$a */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/al$a.class */
    public static class a extends mctech.m.g.g {
        mctech.m.a.g a;

        public a(mctech.m.a.g gVar, int i, int i2, int i3, mctech.m.c.g gVar2, mctech.m.a.g gVar3) {
            super(gVar, i, i2, i3, gVar2);
            this.a = gVar3;
        }

        @Override // mctech.m.g.g
        public boolean mayPlace(ItemStack itemStack) {
            if (!super.mayPlace(itemStack)) {
                return false;
            }
            ItemStack stackInSlot = this.a.getStackInSlot(this.g);
            return stackInSlot.isEmpty() || stackInSlot.is(itemStack.getItem());
        }

        public ItemStack a() {
            return this.a.getStackInSlot(this.g);
        }

        @Override // mctech.m.g.g, mctech.m.g.n
        public void a(ItemStack itemStack) {
            this.a.setStackInSlot(this.g, itemStack);
        }
    }

    @Override // mctech.components.ContainerComponent
    @OnlyIn(Dist.CLIENT)
    public void onGuiLoaded(mctech.m.d.b bVar) {
        bVar.c(1);
        bVar.c(2);
        bVar.e(this.b.j);
        bVar.f(this.b.k);
    }

    @Override // mctech.o.g
    public int a() {
        return this.b.l;
    }

    @Override // mctech.o.g
    public int b() {
        return this.b.m;
    }

    @Override // mctech.components.ContainerComponent
    public Vec2i getFilterGuiSize() {
        return new Vec2i(122, 132);
    }

    @Override // mctech.components.ContainerComponent
    public Vec2i getFilterScrollOffset() {
        return new Vec2i(-2, -2);
    }

    @Override // mctech.components.ContainerComponent
    public Vec2i getFilterItemsOffset() {
        return new Vec2i(3, -2);
    }

    @Override // mctech.components.ContainerComponent
    public Vec2i getInfoGuiSize() {
        return new Vec2i(198, 51);
    }

    /* JADX INFO: renamed from: mctech.m.b.al$b */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/al$b.class */
    public enum b {
        DEFAULT(42, 170, 42, 143, 234, 19, mctech.utils.c.h.i, 255, mctech.utils.c.h.i, mctech.utils.c.h.i),
        X_10(51, 170, 51, 143, 252, 19, 270, 255, mctech.q.c.c, mctech.utils.c.h.i),
        X_11(60, 170, 60, 143, 270, 19, 288, 255, mctech.q.c.c, mctech.utils.c.h.i);

        int d;
        int e;
        int f;
        int g;
        int h;
        int i;
        int j;
        int k;
        int l;
        int m;

        b(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
            this.d = i;
            this.e = i2;
            this.f = i3;
            this.g = i4;
            this.h = i5;
            this.i = i6;
            this.j = i7;
            this.k = i8;
            this.l = i9;
            this.m = i10;
        }
    }
}
