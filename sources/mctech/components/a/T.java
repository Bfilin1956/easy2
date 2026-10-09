package mctech.components.a;

import java.util.Set;
import mctech.blockentities.c.ag;
import mctech.m.b.aK;
import net.minecraft.client.gui.GuiGraphics;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/a/T.class */
public class T extends mctech.m.d.a.a {
    private aK a;

    public T(aK aKVar, mctech.utils.math.geometry.b bVar) {
        super(bVar);
        this.a = aKVar;
    }

    @Override // mctech.m.d.a.a
    protected void a(Set<mctech.m.d.a.a.EnumC0027a> set) {
        set.add(mctech.m.d.a.a.EnumC0027a.DRAW_BACKGROUND_PRE);
        set.add(mctech.m.d.a.a.EnumC0027a.GUI_TICK);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // mctech.m.d.a.a
    public void b(GuiGraphics guiGraphics, int i, int i2, float f) {
        if (((ag) this.a.getHolder()).g) {
            guiGraphics.blit(aK.c[6], this.q.getGuiLeft() + this.o.a(), this.q.getGuiTop() + this.o.b(), 0, 0.0f, 0.0f, 176, 92, 176, 92);
        } else if (this.a.m != -1 && aK.c[this.a.m] != null) {
            guiGraphics.blit(aK.c[this.a.m], this.q.getGuiLeft() + this.o.a(), this.q.getGuiTop() + this.o.b(), 0, 0.0f, 0.0f, 176, 92, 176, 92);
        }
    }

    @Override // mctech.m.d.a.a
    public void b(mctech.m.d.b bVar) {
        if (this.a.m != -1 && this.a.n < System.currentTimeMillis()) {
            this.a.m = -1;
        }
    }
}
