package mctech.m.d.a;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import mctech.components.a.C0101n;
import mctech.utils.math.geometry.Vec2i;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/d/a/c.class */
public class c {

    @NotNull
    private final mctech.utils.math.geometry.b a;

    @NotNull
    private final a b;

    @NotNull
    private final ResourceLocation c;

    @NotNull
    private final Vec2i d;
    private boolean e;

    public c(@NotNull mctech.utils.math.geometry.b bVar, @NotNull a aVar) {
        this(bVar, aVar, C0101n.a);
    }

    public c(@NotNull mctech.utils.math.geometry.b bVar, @NotNull a aVar, @NotNull C0101n c0101n) {
        this(bVar, aVar, c0101n.a(), new Vec2i(c0101n.b(), c0101n.c()));
    }

    public c(@NotNull mctech.utils.math.geometry.b bVar, @NotNull a aVar, @NotNull ResourceLocation resourceLocation, @NotNull Vec2i vec2i) {
        this.a = bVar;
        this.b = aVar;
        this.c = resourceLocation;
        this.d = vec2i;
        this.e = false;
    }

    public c a(boolean z) {
        this.e = z;
        return this;
    }

    public c a(@NotNull GuiGraphics guiGraphics) {
        int iA = this.a.a();
        int iB = this.a.b();
        int iD = this.a.d();
        int iC = this.a.c();
        int iJ = this.b.j();
        int x = this.d.getX();
        int y = this.d.getY();
        Vec2i vec2iA = this.b.a();
        Vec2i vec2iB = this.b.b();
        Vec2i vec2iC = this.b.c();
        Vec2i vec2iD = this.b.d();
        Vec2i vec2iE = this.b.e();
        Vec2i vec2iF = this.b.f();
        Vec2i vec2iG = this.b.g();
        Vec2i vec2iH = this.b.h();
        Vec2i vec2iI = this.b.i();
        guiGraphics.blit(this.c, iA, iB, iJ, iJ, vec2iA.getX(), vec2iA.getY(), iJ, iJ, x, y);
        guiGraphics.blit(this.c, (iA + iD) - iJ, iB, iJ, iJ, vec2iB.getX(), vec2iB.getY(), iJ, iJ, x, y);
        guiGraphics.blit(this.c, iA, (iB + iC) - iJ, iJ, iJ, vec2iC.getX(), vec2iC.getY(), iJ, iJ, x, y);
        guiGraphics.blit(this.c, (iA + iD) - iJ, (iB + iC) - iJ, iJ, iJ, vec2iD.getX(), vec2iD.getY(), iJ, iJ, x, y);
        guiGraphics.blit(this.c, iA + iJ, iB, iD - (2 * iJ), iJ, vec2iE.getX(), vec2iE.getY(), iJ, iJ, x, y);
        guiGraphics.blit(this.c, iA + iJ, (iB + iC) - iJ, iD - (2 * iJ), iJ, vec2iH.getX(), vec2iH.getY(), iJ, iJ, x, y);
        guiGraphics.blit(this.c, iA, iB + iJ, iJ, iC - (2 * iJ), vec2iF.getX(), vec2iF.getY(), iJ, iJ, x, y);
        guiGraphics.blit(this.c, (iA + iD) - iJ, iB + iJ, iJ, iC - (2 * iJ), vec2iG.getX(), vec2iG.getY(), iJ, iJ, x, y);
        if (!this.e) {
            guiGraphics.blit(this.c, iA + iJ, iB + iJ, iD - (2 * iJ), iC - (2 * iJ), vec2iI.getX(), vec2iI.getY(), iJ, iJ, x, y);
        }
        return this;
    }

    public void a(GuiGraphics guiGraphics, mctech.utils.math.geometry.b bVar, Vec2i vec2i) {
        int iA = this.a.a();
        int iB = this.a.b();
        int iJ = this.b.j();
        guiGraphics.blit(this.c, iA + iJ, iB + iJ, bVar.a() - (iJ * 2), bVar.b() - (iJ * 2), vec2i.getX(), vec2i.getY(), bVar.d(), bVar.c(), this.d.getX(), this.d.getY());
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/d/a/c$a.class */
    public static final class a extends Record {
        private final int a;
        private final Vec2i b;

        public a(int i, Vec2i vec2i) {
            this.a = i;
            this.b = vec2i;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "size;offset", "FIELD:Lmctech/m/d/a/c$a;->a:I", "FIELD:Lmctech/m/d/a/c$a;->b:Lmctech/utils/math/geometry/Vec2i;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "size;offset", "FIELD:Lmctech/m/d/a/c$a;->a:I", "FIELD:Lmctech/m/d/a/c$a;->b:Lmctech/utils/math/geometry/Vec2i;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "size;offset", "FIELD:Lmctech/m/d/a/c$a;->a:I", "FIELD:Lmctech/m/d/a/c$a;->b:Lmctech/utils/math/geometry/Vec2i;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        public int j() {
            return this.a;
        }

        public Vec2i k() {
            return this.b;
        }

        public Vec2i a() {
            return this.b;
        }

        public Vec2i b() {
            return new Vec2i(a().getX() + (2 * this.a), a().getY());
        }

        public Vec2i c() {
            return new Vec2i(a().getX(), a().getY() + (2 * this.a));
        }

        public Vec2i d() {
            return new Vec2i(b().getX(), b().getY() + (2 * this.a));
        }

        public Vec2i e() {
            return new Vec2i(a().getX() + this.a, a().getY());
        }

        public Vec2i f() {
            return new Vec2i(a().getX(), a().getY() + this.a);
        }

        public Vec2i g() {
            return new Vec2i(b().getX(), b().getY() + this.a);
        }

        public Vec2i h() {
            return new Vec2i(c().getX() + this.a, c().getY());
        }

        public Vec2i i() {
            return new Vec2i(e().getX(), e().getY() + this.a);
        }
    }
}
