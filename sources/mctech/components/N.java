package mctech.components;

import java.util.Set;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/N.class */
public class N extends mctech.m.d.a.a {
    mctech.blockentities.b.j a;

    public N(mctech.blockentities.b.j jVar) {
        super(mctech.utils.math.geometry.b.a);
        this.a = jVar;
    }

    @Override // mctech.m.d.a.a
    protected void a(Set<mctech.m.d.a.a.EnumC0027a> set) {
        set.add(mctech.m.d.a.a.EnumC0027a.DRAW_FOREGROUND);
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(GuiGraphics guiGraphics, int i, int i2) {
        this.q.a(guiGraphics, (Component) Component.literal("Пассивная генерация: ").append(c("gui.mctech.thermal_generator.production", mctech.utils.D.a.format(this.a.m.a(2000.0f)))), 23, 25, -15747871);
    }
}
