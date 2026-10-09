package mctech.components.b;

import java.util.Set;
import mctech.api.tiles.readers.ISpeedMachine;
import mctech.utils.D;
import mctech.utils.math.geometry.Vec2i;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/b/t.class */
public class t extends mctech.m.d.a.a {
    public static Vec2i a = new Vec2i(5, 36);
    ISpeedMachine b;
    Component c;
    Vec2i d;

    public t(ISpeedMachine iSpeedMachine, Component component) {
        this(iSpeedMachine, component, a);
    }

    public t(ISpeedMachine iSpeedMachine, Component component, Vec2i vec2i) {
        super(mctech.utils.math.geometry.b.a);
        this.b = iSpeedMachine;
        this.c = component;
        this.d = vec2i;
    }

    @Override // mctech.m.d.a.a
    protected void a(Set<mctech.m.d.a.a.EnumC0027a> set) {
        set.add(mctech.m.d.a.a.EnumC0027a.DRAW_FOREGROUND);
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(GuiGraphics guiGraphics, int i, int i2) {
        this.q.a(guiGraphics, this.c, this.d.getX(), this.d.getY(), -800511);
        this.q.a(guiGraphics, (Component) e(D.a.format((this.b.getSpeed() / this.b.getMaxSpeed()) * 100.0f)), this.d.getX(), this.d.getY() + 8, -800511);
    }
}
