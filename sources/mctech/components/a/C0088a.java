package mctech.components.a;

import java.util.Set;
import mctech.utils.math.geometry.Vec2i;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: renamed from: mctech.components.a.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/a/a.class */
public class C0088a extends mctech.m.d.a.a {
    private final ResourceLocation a;
    private final InterfaceC0005a b;
    private final Vec2i c;

    /* JADX INFO: renamed from: mctech.components.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/a/a$a.class */
    public interface InterfaceC0005a {
        boolean isActive();
    }

    public C0088a(int i, int i2, int i3, int i4, Vec2i vec2i, InterfaceC0005a interfaceC0005a, ResourceLocation resourceLocation) {
        super(new mctech.utils.math.geometry.b(i, i2, i3, i4));
        this.a = resourceLocation;
        this.b = interfaceC0005a;
        this.c = vec2i;
    }

    @Override // mctech.m.d.a.a
    protected void a(Set<mctech.m.d.a.a.EnumC0027a> set) {
        set.add(mctech.m.d.a.a.EnumC0027a.DRAW_BACKGROUND);
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(GuiGraphics guiGraphics, int i, int i2, float f) {
        if (!this.b.isActive()) {
            return;
        }
        this.q.c(this.a);
        this.q.b(guiGraphics, this.q.getGuiLeft() + this.o.a(), this.q.getGuiTop() + this.o.b(), this.c.getX(), this.c.getY(), this.o.d(), this.o.c());
        this.q.c();
    }
}
