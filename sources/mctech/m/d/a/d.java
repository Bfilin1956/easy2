package mctech.m.d.a;

import java.util.Set;
import mctech.components.a.C0101n;
import mctech.utils.c.h;
import net.minecraft.client.gui.GuiGraphics;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/d/a/d.class */
public class d extends mctech.m.d.a.a {
    private static final int a = 188;
    private static final int b = 95;
    private final a c;
    private final Runnable d;

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/d/a/d$a.class */
    @FunctionalInterface
    public interface a {
        boolean canDraw();
    }

    public d(a aVar, Runnable runnable) {
        super(new mctech.utils.math.geometry.b(0, -15, a, b));
        this.c = aVar;
        this.d = runnable;
    }

    @Override // mctech.m.d.a.a
    protected void a(Set<mctech.m.d.a.a.EnumC0027a> set) {
        set.add(mctech.m.d.a.a.EnumC0027a.DRAW_BACKGROUND);
        set.add(mctech.m.d.a.a.EnumC0027a.MOUSE_INPUT);
    }

    public boolean a() {
        return this.c != null && this.c.canDraw();
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(GuiGraphics guiGraphics, int i, int i2, float f) {
        if (a()) {
            guiGraphics.blit(C0101n.e.a(), this.q.getGuiLeft() + 29, this.q.getGuiTop() - 15, 10, 0.0f, 62.0f, a, b, h.i, h.i);
        }
    }

    @Override // mctech.m.d.a.a
    public boolean a(int i, int i2, int i3) {
        mctech.utils.math.geometry.b bVar = new mctech.utils.math.geometry.b(32, -11, 9, 9);
        if (a() && i3 == 0 && bVar.a(i, i2)) {
            this.d.run();
            return false;
        }
        return false;
    }
}
