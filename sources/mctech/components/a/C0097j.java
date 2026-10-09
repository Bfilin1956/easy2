package mctech.components.a;

import java.util.Set;
import mctech.components.ContainerComponent;
import mctech.m.a.d;
import mctech.utils.math.geometry.Vec2i;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: mctech.components.a.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/a/j.class */
public class C0097j<T extends mctech.m.a.d> extends M<C0097j<T>> {
    private boolean a;
    private final mctech.components.b.g b;

    public C0097j(ContainerComponent<T> containerComponent, @NotNull InterfaceC0102o interfaceC0102o) {
        this(containerComponent, 1, 44, interfaceC0102o);
    }

    public C0097j(ContainerComponent<T> containerComponent, int i, int i2, @NotNull InterfaceC0102o interfaceC0102o) {
        super(i, i2, C0101n.a.f, C0101n.a.g, interfaceC0102o);
        this.b = new mctech.components.b.g(containerComponent, new Vec2i(-1, 0), Vec2i.EMPTY);
    }

    @Override // mctech.components.a.R, mctech.m.d.a.a
    protected void a(Set<mctech.m.d.a.a.EnumC0027a> set) {
        super.a(set);
        set.add(mctech.m.d.a.a.EnumC0027a.GUI_INIT);
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
        }
        return super.b_(i);
    }

    @Override // mctech.components.a.R
    @OnlyIn(Dist.CLIENT)
    public void Z_() {
        super.Z_();
        this.q.b();
        if (this.a) {
            this.b.g();
            this.a = false;
        } else {
            this.b.a(!this.b.w());
            this.a = true;
        }
    }
}
