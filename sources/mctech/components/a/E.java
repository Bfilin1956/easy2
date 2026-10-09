package mctech.components.a;

import java.util.Set;
import mctech.api.util.ILocation;
import mctech.init.MCTechLang;
import mctech.utils.math.geometry.Vec2i;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.world.inventory.Slot;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/a/E.class */
public class E extends R<E> {
    private boolean a;
    private final mctech.components.b.p b;

    public E(ILocation iLocation) {
        super(C0101n.f, 1, 31, 10, 10, new Vec2i(10, 0), new Vec2i(10, 0));
        this.b = new mctech.components.b.p(this, iLocation, new Vec2i(-1, 0)).a(C0101n.f.a());
        b((Component) MCTechLang.QUANTITY_SETTINGS);
    }

    public E(ILocation iLocation, int i, int i2) {
        super(C0101n.f, 0, 17, 10, 10, new Vec2i(i, i2), new Vec2i(i, i2));
        this.b = new mctech.components.b.p(this, iLocation, new Vec2i(-1, 0)).a(C0101n.g.a());
        b((Component) MCTechLang.QUANTITY_SETTINGS);
    }

    @Override // mctech.components.a.R, mctech.m.d.a.a
    protected void a(Set<mctech.m.d.a.a.EnumC0027a> set) {
        super.a(set);
        set.add(mctech.m.d.a.a.EnumC0027a.GUI_INIT);
        set.add(mctech.m.d.a.a.EnumC0027a.GUI_TICK);
        set.add(mctech.m.d.a.a.EnumC0027a.KEY_INPUT);
        set.add(mctech.m.d.a.a.EnumC0027a.DRAW_FOREGROUND);
    }

    @Override // mctech.m.d.a.a
    public void a(GuiGraphics guiGraphics, int i, int i2) {
        super.a(guiGraphics, i, i2);
        if (!this.a) {
            this.b.b(guiGraphics, i, i2);
        }
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(mctech.m.d.b bVar) {
        super.a(bVar);
        if (bVar instanceof mctech.m.d.a) {
            ((mctech.m.d.a) bVar).a(this.b);
        }
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public boolean b_(int i) {
        if (this.a && i == 256) {
            this.a = false;
            this.b.c(this.q);
            return true;
        }
        return super.b_(i);
    }

    @Override // mctech.components.a.R
    @OnlyIn(Dist.CLIENT)
    public void Z_() {
        super.Z_();
        this.q.b();
        if (this.a) {
            g();
        } else {
            f();
        }
    }

    public void f() {
        if (this.a) {
            return;
        }
        this.b.a_(true);
        this.b.b(this.q);
        this.a = true;
    }

    public void g() {
        h();
        this.b.c(this.q);
        this.a = false;
    }

    public void a(Slot slot) {
        f();
        if (this.a && (slot instanceof mctech.a.b.c.a)) {
            this.b.a((mctech.a.b.c.a<?>) slot);
        }
    }

    public void a(mctech.a.b.c.a<?> aVar) {
        f();
        if (this.a) {
            this.b.a(aVar);
        }
    }

    public void h() {
        this.b.a((mctech.a.b.c.a<?>) null);
    }
}
