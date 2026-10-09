package mctech.components.b;

import java.util.Set;
import java.util.function.IntConsumer;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/b/q.class */
public class q extends mctech.m.d.a.a {
    private ResourceLocation h;
    private mctech.utils.math.geometry.b i;
    private mctech.utils.math.geometry.b j;
    protected int a;
    protected double b;
    protected int c;
    protected int d;
    protected int e;
    protected boolean f;
    protected IntConsumer g;

    public q(mctech.utils.math.geometry.b bVar, mctech.utils.math.geometry.b bVar2) {
        this(bVar, bVar2, bVar2, 1);
    }

    public q(mctech.utils.math.geometry.b bVar, mctech.utils.math.geometry.b bVar2, int i) {
        this(bVar, bVar2, bVar2, i);
    }

    public q(mctech.utils.math.geometry.b bVar, mctech.utils.math.geometry.b bVar2, mctech.utils.math.geometry.b bVar3) {
        this(bVar, bVar2, bVar3, 1);
    }

    public q(mctech.utils.math.geometry.b bVar, mctech.utils.math.geometry.b bVar2, mctech.utils.math.geometry.b bVar3, int i) {
        super(bVar);
        this.h = null;
        this.e = 0;
        this.f = false;
        this.g = null;
        this.i = bVar2;
        this.j = bVar3;
        this.d = Math.max(1, i);
    }

    public q a(int i) {
        this.e = Math.max(0, i);
        return this;
    }

    public q a(IntConsumer intConsumer) {
        this.g = intConsumer;
        return this;
    }

    public q a(ResourceLocation resourceLocation) {
        this.h = resourceLocation;
        return this;
    }

    public q c(int i) {
        int iMax = Math.max(0, i);
        if (this.c != iMax) {
            this.c = iMax;
            int iA = a();
            int i2 = this.a;
            if (this.a > iA) {
                this.a = iA;
            }
            this.b = iA <= 0 ? 0.0d : ((double) this.a) / ((double) iA);
            if (this.a != i2 && this.g != null) {
                this.g.accept(b());
            }
        }
        return this;
    }

    public q d(int i) {
        int i2 = this.a;
        int iA = a();
        this.a = Mth.clamp(i / this.d, 0, iA);
        if (this.a != i2) {
            this.b = iA <= 0 ? 0.0d : ((double) this.a) / ((double) iA);
        }
        return this;
    }

    public int a() {
        return Math.max(0, (this.c / this.d) - this.e);
    }

    public int b() {
        return this.a * this.d;
    }

    public boolean e(int i) {
        return b() + i < a() + this.e;
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
        if (this.f) {
            a(this.o, i2);
        }
        if (this.h != null) {
            this.q.c(this.h);
        }
        mctech.utils.math.geometry.b bVarD = d();
        this.q.b(guiGraphics, this.q.getGuiLeft() + this.o.a(), this.q.getGuiTop() + this.o.b() + ((float) (((double) (this.o.c() - bVarD.c())) * this.b)), bVarD.a(), bVarD.b(), bVarD.d(), bVarD.c());
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public boolean a(int i, int i2, int i3) {
        a(this.o, i2);
        this.f = true;
        return false;
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public boolean d(int i, int i2, int i3) {
        this.f = false;
        return false;
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public boolean b(int i, int i2, int i3) {
        int i4 = this.a;
        int iA = a();
        this.b = iA <= 0 ? 0.0d : Mth.clamp(this.b - (((double) i3) * (1.0d / ((double) iA))), 0.0d, 1.0d);
        this.a = iA <= 0 ? 0 : (int) Mth.clamp(((double) iA) * this.b, 0.0d, iA);
        if (this.a != i4 && this.g != null) {
            this.g.accept(b());
            return true;
        }
        return true;
    }

    protected void a(mctech.utils.math.geometry.b bVar, int i) {
        int i2 = this.a;
        int iA = a();
        this.b = Mth.clamp((((double) i) - (((double) bVar.b()) + (((double) this.i.c()) * 0.5d))) / ((double) (bVar.c() - this.i.c())), 0.0d, 1.0d);
        this.a = (int) Mth.clamp(((double) iA) * this.b, 0.0d, iA);
        if (iA <= 0) {
            this.b = 0.0d;
        }
        if (this.a != i2 && this.g != null) {
            this.g.accept(b());
        }
    }

    private mctech.utils.math.geometry.b d() {
        return r() ? this.i : this.j;
    }
}
