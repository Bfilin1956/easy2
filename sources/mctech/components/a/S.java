package mctech.components.a;

import java.util.Set;
import mctech.components.a.S;
import mctech.utils.math.geometry.Vec2i;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/a/S.class */
public class S<SC extends S<SC>> extends mctech.m.d.a.a {
    private final ResourceLocation a;
    private Vec2i b;
    private Vec2i c;
    private Vec2i d;
    private Vec2i e;
    private Vec2i f;
    private int g;
    private double h;
    private int i;
    private int j;
    private int k;
    private boolean l;
    private boolean m;
    private d n;
    private c<SC> s;
    private b<SC> t;
    private a<SC> u;

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/a/S$a.class */
    public interface a<SC extends S<SC>> {
        void a(SC sc);
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/a/S$b.class */
    public interface b<SC extends S<SC>> {
        void a(SC sc);
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/a/S$c.class */
    public interface c<SC extends S<SC>> {
        void onValueChanged(SC sc);
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/a/S$d.class */
    public enum d {
        VERTICAL,
        HORIZONTAL
    }

    public S(@NotNull ResourceLocation resourceLocation, mctech.utils.math.geometry.b bVar) {
        this(resourceLocation, bVar, Vec2i.ZERO, new Vec2i(8, 20), Vec2i.ZERO, Vec2i.ZERO, Vec2i.ZERO);
    }

    public S(@NotNull ResourceLocation resourceLocation, mctech.utils.math.geometry.b bVar, @NotNull Vec2i vec2i) {
        this(resourceLocation, bVar, vec2i, Vec2i.ZERO, Vec2i.ZERO, Vec2i.ZERO, Vec2i.ZERO);
    }

    public S(@NotNull ResourceLocation resourceLocation, mctech.utils.math.geometry.b bVar, @NotNull Vec2i vec2i, @NotNull Vec2i vec2i2, @NotNull Vec2i vec2i3, @NotNull Vec2i vec2i4, @NotNull Vec2i vec2i5) {
        super(bVar);
        this.a = resourceLocation;
        this.f = vec2i;
        this.b = vec2i2;
        this.d = vec2i3;
        this.c = vec2i4;
        this.e = vec2i5;
        this.k = 0;
        this.l = false;
        this.j = 1;
        this.m = true;
        this.n = d.VERTICAL;
    }

    @Override // mctech.m.d.a.a
    protected void a(Set<mctech.m.d.a.a.EnumC0027a> set) {
        set.add(mctech.m.d.a.a.EnumC0027a.DRAW_BACKGROUND);
        set.add(mctech.m.d.a.a.EnumC0027a.MOUSE_INPUT);
        set.add(mctech.m.d.a.a.EnumC0027a.MOUSE_SCROLL);
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(GuiGraphics guiGraphics, int i, int i2, float f) {
        this.q.c(this.a);
        if (e() && r()) {
            c(i, i2);
        }
        Vec2i vec2iI = i();
        Vec2i vec2iG = g();
        this.q.b(guiGraphics, vec2iG.getX(), vec2iG.getY(), vec2iI.getX(), vec2iI.getY(), this.f.getX(), this.f.getY());
        if (b(i, i2) && r() && !e()) {
            this.q.b(guiGraphics, vec2iG.getX(), vec2iG.getY(), this.c.getX(), this.c.getY(), this.f.getX(), this.f.getY());
        }
        this.q.c();
    }

    @OnlyIn(Dist.CLIENT)
    private boolean b(int i, int i2) {
        Vec2i vec2iSubtract = g().subtract(this.q.getGuiLeft(), this.q.getGuiTop());
        return i >= vec2iSubtract.getX() && i <= vec2iSubtract.getX() + this.f.getX() && i2 >= vec2iSubtract.getY() && i2 <= vec2iSubtract.getY() + this.f.getY();
    }

    private Vec2i g() {
        int guiLeft;
        int guiTop;
        int x = this.f.getX();
        int y = this.f.getY();
        if (this.n == d.VERTICAL) {
            guiLeft = this.q.getGuiLeft() + this.o.a() + ((this.o.d() - x) / 2);
            guiTop = this.q.getGuiTop() + this.o.b() + ((int) (((double) (this.o.c() - y)) * this.h));
        } else {
            guiLeft = this.q.getGuiLeft() + this.o.a() + ((int) (((double) (this.o.d() - x)) * this.h));
            guiTop = this.q.getGuiTop() + this.o.b() + ((this.o.c() - y) / 2);
        }
        return new Vec2i(guiLeft, guiTop);
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public boolean a(int i, int i2, int i3) {
        if (r() && i3 == 0 && b(i, i2)) {
            c(i, i2);
            this.l = true;
            if (this.t != null) {
                this.t.a(this);
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public boolean d(int i, int i2, int i3) {
        if (this.l) {
            this.l = false;
            if (this.u != null) {
                this.u.a(this);
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public boolean b(int i, int i2, int i3) {
        if (!r() || !a(i, i2)) {
            return false;
        }
        int i4 = this.g;
        int iA = a();
        if (iA > 0) {
            this.h = Mth.clamp(this.h - (((double) i3) * (1.0d / ((double) iA))), 0.0d, 1.0d);
            this.g = (int) Mth.clamp(((double) iA) * this.h, 0.0d, iA);
            if (this.g != i4) {
                h();
                return true;
            }
            return true;
        }
        return true;
    }

    @OnlyIn(Dist.CLIENT)
    private void c(int i, int i2) {
        int i3 = this.g;
        int iA = a();
        if (this.n == d.VERTICAL) {
            this.h = Mth.clamp((((double) i2) - (((double) this.o.b()) + (((double) this.f.getY()) * 0.5d))) / ((double) (this.o.c() - this.f.getY())), 0.0d, 1.0d);
        } else {
            this.h = Mth.clamp((((double) i) - (((double) this.o.a()) + (((double) this.f.getX()) * 0.5d))) / ((double) (this.o.d() - this.f.getX())), 0.0d, 1.0d);
        }
        this.g = iA > 0 ? (int) Mth.clamp(((double) iA) * this.h, 0.0d, iA) : 0;
        if (this.g != i3) {
            h();
        }
    }

    private void h() {
        if (this.s != null) {
            this.s.onValueChanged(this);
        }
    }

    private Vec2i i() {
        if (!r()) {
            return this.d;
        }
        if (this.l && !this.e.isZero()) {
            return this.e;
        }
        return this.b;
    }

    public SC a(int i) {
        this.k = Math.max(0, i);
        return this;
    }

    public SC c(int i) {
        int iMax = Math.max(0, i);
        if (this.i != iMax) {
            this.i = iMax;
            int iA = a();
            int i2 = this.g;
            if (this.g > iA) {
                this.g = iA;
            }
            this.h = iA <= 0 ? 0.0d : ((double) this.g) / ((double) iA);
            if (this.g != i2) {
                h();
            }
        }
        return this;
    }

    public SC d(int i) {
        int i2 = this.g;
        int iA = a();
        this.g = Mth.clamp(i / this.j, 0, iA);
        if (this.g != i2) {
            this.h = iA <= 0 ? 0.0d : ((double) this.g) / ((double) iA);
        }
        return this;
    }

    public SC e(int i) {
        this.j = Math.max(1, i);
        return this;
    }

    public SC a(@NotNull Vec2i vec2i) {
        this.f = vec2i;
        return this;
    }

    public SC a(boolean z) {
        this.m = z;
        return this;
    }

    public SC a(d dVar) {
        this.n = dVar;
        return this;
    }

    public SC b(@NotNull Vec2i vec2i) {
        this.b = vec2i;
        return this;
    }

    public SC c(@NotNull Vec2i vec2i) {
        this.c = vec2i;
        return this;
    }

    public SC d(@NotNull Vec2i vec2i) {
        this.d = vec2i;
        return this;
    }

    public SC e(@NotNull Vec2i vec2i) {
        this.e = vec2i;
        return this;
    }

    public SC a(c<SC> cVar) {
        this.s = cVar;
        return this;
    }

    public SC a(b<SC> bVar) {
        this.t = bVar;
        return this;
    }

    public SC a(a<SC> aVar) {
        this.u = aVar;
        return this;
    }

    public int a() {
        return Math.max(0, (this.i / this.j) - this.k);
    }

    public int b() {
        return this.g * this.j;
    }

    public double d() {
        return this.h;
    }

    public boolean e() {
        return this.l;
    }

    @Override // mctech.m.d.a.a
    public boolean r() {
        return this.m;
    }

    public boolean f(int i) {
        return b() + i < a() + this.k;
    }

    public Vec2i f() {
        return this.f;
    }
}
