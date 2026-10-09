package mctech.components;

import java.util.Set;
import net.minecraft.client.gui.GuiGraphics;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: renamed from: mctech.components.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/h.class */
public class C0114h extends mctech.m.d.a.a {
    private final mctech.m.a.g a;
    private final int b;

    public C0114h(int i, int i2, mctech.m.a.g gVar, int i3) {
        super(new mctech.utils.math.geometry.b(i, i2, 34, 18));
        this.a = gVar;
        this.b = i3;
    }

    @Override // mctech.m.d.a.a
    protected void a(Set<mctech.m.d.a.a.EnumC0027a> set) {
        set.add(mctech.m.d.a.a.EnumC0027a.DRAW_BACKGROUND);
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(GuiGraphics guiGraphics, int i, int i2, float f) {
        if (!this.a.getStackInSlot(this.b).isEmpty()) {
            this.q.b(guiGraphics, this.q.getGuiLeft() + this.o.a(), this.q.getGuiTop() + this.o.b(), 214.0f, 14.0f, this.o.d(), this.o.c());
        }
    }
}
