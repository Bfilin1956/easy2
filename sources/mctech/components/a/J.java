package mctech.components.a;

import java.util.Set;
import mctech.init.MCTechLang;
import mctech.utils.math.geometry.Vec2i;
import net.minecraft.network.chat.Component;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/a/J.class */
public class J extends R<J> {
    private boolean a;
    private final mctech.components.b.x b;

    public J(mctech.blockentities.p pVar) {
        super(C0101n.a, 1, 17, 10, 10, new Vec2i(150, 20), new Vec2i(150, 20));
        this.b = new mctech.components.b.x(pVar, new Vec2i(5, 15));
        b((Component) MCTechLang.GUI_MCTECH_BASE_TELEPORTER_SETTINGS.get());
    }

    @Override // mctech.components.a.R, mctech.m.d.a.a
    protected void a(Set<mctech.m.d.a.a.EnumC0027a> set) {
        super.a(set);
        set.add(mctech.m.d.a.a.EnumC0027a.GUI_INIT);
        set.add(mctech.m.d.a.a.EnumC0027a.GUI_TICK);
        set.add(mctech.m.d.a.a.EnumC0027a.KEY_INPUT);
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
        this.b.c(this.q);
        this.a = false;
    }

    public boolean h() {
        return this.a;
    }
}
