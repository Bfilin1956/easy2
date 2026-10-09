package mctech.components;

import java.util.Set;
import java.util.function.Consumer;
import mctech.blockentities.c.af;
import mctech.utils.math.geometry.Vec2i;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/Q.class */
public class Q extends mctech.m.d.a.a {
    af a;
    private Vec2i b;

    public Q(mctech.utils.math.geometry.b bVar, af afVar, Vec2i vec2i) {
        super(bVar);
        this.a = afVar;
        this.b = vec2i;
    }

    @Override // mctech.m.d.a.a
    protected void a(Set<mctech.m.d.a.a.EnumC0027a> set) {
        set.add(mctech.m.d.a.a.EnumC0027a.DRAW_BACKGROUND);
        set.add(mctech.m.d.a.a.EnumC0027a.GUI_INIT);
        set.add(mctech.m.d.a.a.EnumC0027a.GUI_TICK);
        set.add(mctech.m.d.a.a.EnumC0027a.TOOLTIP);
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(mctech.m.d.b bVar) {
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void b(mctech.m.d.b bVar) {
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(GuiGraphics guiGraphics, int i, int i2, float f) {
        if (this.a.c != null) {
            float fC = (v().c() * (this.a.c() / this.a.d())) - 1.0f;
            this.q.b(guiGraphics, this.o.a() + this.q.getGuiLeft() + 1, ((this.o.b() + this.q.getGuiTop()) + this.o.c()) - fC, this.o.d() - 1, fC, this.b.getX(), this.b.getY());
        }
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(GuiGraphics guiGraphics, int i, int i2, Consumer<Component> consumer) {
        if (v().a(i, i2) && this.a.c != null) {
            consumer.accept(e(mctech.utils.c.g.b(this.a.c.getPath())));
            consumer.accept(e(this.a.c() + " / 1000"));
        }
    }
}
