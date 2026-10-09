package mctech.m.d.a;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import mctech.components.a.C0101n;
import mctech.utils.math.geometry.Vec2i;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/d/a/b.class */
public class b {

    @NotNull
    private final mctech.utils.math.geometry.b a;

    @NotNull
    private final a b;

    @NotNull
    private final ResourceLocation c;

    @NotNull
    private final Vec2i d;

    public b(@NotNull mctech.utils.math.geometry.b bVar, @NotNull a aVar) {
        this(bVar, aVar, C0101n.a);
    }

    public b(@NotNull mctech.utils.math.geometry.b bVar, @NotNull a aVar, @NotNull C0101n c0101n) {
        this(bVar, aVar, c0101n.a(), new Vec2i(c0101n.b(), c0101n.c()));
    }

    public b(@NotNull mctech.utils.math.geometry.b bVar, @NotNull a aVar, @NotNull ResourceLocation resourceLocation, @NotNull Vec2i vec2i) {
        this.a = bVar;
        this.b = aVar;
        this.c = resourceLocation;
        this.d = vec2i;
    }

    public b a(@NotNull GuiGraphics guiGraphics) {
        int iA = this.a.a();
        int iB = this.a.b();
        int iD = this.a.d();
        int iC = this.a.c();
        int i = this.b.a;
        int i2 = this.b.b;
        int x = this.d.getX();
        int y = this.d.getY();
        int x2 = this.b.c.getX();
        int y2 = this.b.c.getY();
        guiGraphics.blit(this.c, iA, iB, i, i, x2, y2, i, i, x, y);
        guiGraphics.blit(this.c, (iA + iD) - i, iB, i, i, (x2 + this.b.a()) - i, y2, i, i, x, y);
        guiGraphics.blit(this.c, iA, (iB + iC) - i, i, i, x2, (y2 + this.b.a()) - i, i, i, x, y);
        guiGraphics.blit(this.c, (iA + iD) - i, (iB + iC) - i, i, i, (x2 + this.b.a()) - i, (y2 + this.b.a()) - i, i, i, x, y);
        guiGraphics.blit(this.c, iA + i, iB, iD - (i * 2), i2, x2 + i, y2, i2, i2, x, y);
        guiGraphics.blit(this.c, iA + i, (iB + iC) - i2, iD - (i * 2), i2, x2 + i, (y2 + this.b.a()) - i2, i2, i2, x, y);
        guiGraphics.blit(this.c, iA, iB + i, i2, iC - (i * 2), x2, y2 + i, i2, i2, x, y);
        guiGraphics.blit(this.c, (iA + iD) - i2, iB + i, i2, iC - (i * 2), (x2 + this.b.a()) - i2, y2 + i, i2, i2, x, y);
        guiGraphics.blit(this.c, iA + i2, iB + i2, iD - (i2 * 2), iC - (i2 * 2), x2 + i2, y2 + i2, i2, i2, x, y);
        return this;
    }

    public void a(GuiGraphics guiGraphics, mctech.utils.math.geometry.b bVar, Vec2i vec2i) {
        int iA = this.a.a();
        int iB = this.a.b();
        int i = this.b.b;
        guiGraphics.blit(this.c, iA + i, iB + i, bVar.a() - (i * 2), bVar.b() - (i * 2), vec2i.getX(), vec2i.getY(), bVar.d(), bVar.c(), this.d.getX(), this.d.getY());
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/d/a/b$a.class */
    public static final class a extends Record {
        private final int a;
        private final int b;
        private final Vec2i c;

        public a(int i, int i2, Vec2i vec2i) {
            this.a = i;
            this.b = i2;
            this.c = vec2i;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "cornerSize;sideSize;offset", "FIELD:Lmctech/m/d/a/b$a;->a:I", "FIELD:Lmctech/m/d/a/b$a;->b:I", "FIELD:Lmctech/m/d/a/b$a;->c:Lmctech/utils/math/geometry/Vec2i;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "cornerSize;sideSize;offset", "FIELD:Lmctech/m/d/a/b$a;->a:I", "FIELD:Lmctech/m/d/a/b$a;->b:I", "FIELD:Lmctech/m/d/a/b$a;->c:Lmctech/utils/math/geometry/Vec2i;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "cornerSize;sideSize;offset", "FIELD:Lmctech/m/d/a/b$a;->a:I", "FIELD:Lmctech/m/d/a/b$a;->b:I", "FIELD:Lmctech/m/d/a/b$a;->c:Lmctech/utils/math/geometry/Vec2i;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        public int b() {
            return this.a;
        }

        public int c() {
            return this.b;
        }

        public Vec2i d() {
            return this.c;
        }

        public int a() {
            return this.a * 2;
        }
    }
}
