package mctech.components.a;

import java.util.Set;
import net.minecraft.client.gui.GuiGraphics;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/a/y.class */
public class y extends mctech.m.d.a.a {
    private final C0101n a;

    public y(int i, int i2) {
        this(i, i2, C0101n.a);
    }

    public y(int i, int i2, C0101n c0101n) {
        super(new mctech.utils.math.geometry.b(i, i2, C0101n.p.getX(), C0101n.p.getY()));
        this.a = c0101n;
    }

    @Override // mctech.m.d.a.a
    protected void a(Set<mctech.m.d.a.a.EnumC0027a> set) {
        set.add(mctech.m.d.a.a.EnumC0027a.DRAW_BACKGROUND);
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(GuiGraphics guiGraphics, int i, int i2, float f) {
        if (w()) {
            this.q.c(this.a.a());
            this.q.b(guiGraphics, this.q.getGuiLeft() + this.o.a(), this.q.getGuiTop() + this.o.b(), C0101n.a.r.getX(), C0101n.a.r.getY(), this.o.d(), this.o.c());
        }
    }
}
