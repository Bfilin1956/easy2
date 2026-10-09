package mctech.components.a;

import java.util.Set;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: renamed from: mctech.components.a.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/a/k.class */
public class C0098k extends mctech.m.d.a.a {
    private final ResourceLocation a;
    private final int b;
    private final int c;
    private final int d;
    private final int e;
    private final float f;
    private final boolean g;
    private final a h;
    private final long i;

    public C0098k(ResourceLocation resourceLocation, int i, int i2, int i3, float f, boolean z, a aVar, int i4, int i5, int i6, int i7) {
        super(new mctech.utils.math.geometry.b(i4, i5, i6, i7));
        this.a = resourceLocation;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.f = 1000.0f / f;
        this.g = z;
        this.h = aVar;
        this.e = aVar == a.HORIZONTAL ? i3 : 1;
        this.i = System.currentTimeMillis();
    }

    @Override // mctech.m.d.a.a
    protected void a(Set<mctech.m.d.a.a.EnumC0027a> set) {
        set.add(mctech.m.d.a.a.EnumC0027a.DRAW_BACKGROUND);
    }

    public int a() {
        int iCurrentTimeMillis = (int) ((System.currentTimeMillis() - this.i) / this.f);
        return this.g ? iCurrentTimeMillis % this.d : Math.min(iCurrentTimeMillis, this.d - 1);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(GuiGraphics guiGraphics, int i, int i2, float f) throws MatchException {
        guiGraphics.pose().pushPose();
        int iA = a();
        guiGraphics.blit(this.a, this.q.getGuiLeft() + this.o.a(), this.q.getGuiTop() + this.o.b(), this.o.d(), this.o.c(), this.h.a(iA, this.b, this.c, this.e), this.h.b(iA, this.b, this.c, this.e), this.b, this.c, this.b * this.e, this.c * (this.h == a.VERTICAL ? this.d : 1));
        guiGraphics.pose().popPose();
    }

    /* JADX INFO: renamed from: mctech.components.a.k$a */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/a/k$a.class */
    public enum a {
        HORIZONTAL,
        VERTICAL;

        /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
        public int a(int i, int i2, int i3, int i4) throws MatchException {
            switch (this) {
                case HORIZONTAL:
                    return i * i2;
                case VERTICAL:
                    return (i % i4) * i2;
                default:
                    throw new MatchException((String) null, (Throwable) null);
            }
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
        public int b(int i, int i2, int i3, int i4) throws MatchException {
            switch (this) {
                case HORIZONTAL:
                    return (i / i4) * i3;
                case VERTICAL:
                    return i * i3;
                default:
                    throw new MatchException((String) null, (Throwable) null);
            }
        }
    }
}
