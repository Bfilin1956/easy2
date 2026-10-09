package mctech.components;

import java.util.Set;
import mctech.integration.jade.DecimalFormats;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/C.class */
public class C extends mctech.m.d.a.a {
    private final mctech.blockentities.b.e a;

    public C(mctech.blockentities.b.e eVar) {
        super(mctech.utils.math.geometry.b.a);
        this.a = eVar;
    }

    @Override // mctech.m.d.a.a
    protected void a(Set<mctech.m.d.a.a.EnumC0027a> set) {
        set.add(mctech.m.d.a.a.EnumC0027a.DRAW_FOREGROUND);
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(GuiGraphics guiGraphics, int i, int i2) {
        int i3 = 43 + 9;
        this.q.a(guiGraphics, (Component) e(String.format("Энергия: %s/%s EU", DecimalFormats.formatNumber(this.a.getStoredEU(), 4), DecimalFormats.formatNumber(this.a.getMaxEU(), 4))), 30, i3, -255909);
        int i4 = i3 + 9;
        this.q.a(guiGraphics, (Component) e(String.format("Выход: %s EU/t", mctech.utils.c.c.c.format(this.a.getMaxEnergyOutput()))), 30, i4, -9172860);
        int i5 = i4 + 9;
        this.q.a(guiGraphics, (Component) e(String.format("Выходные пакеты: %s", Integer.valueOf(this.a.getPacketCount()))), 30, i5, -36773);
        this.q.a(guiGraphics, (Component) e(String.format("Прогресс: %s/%s", mctech.utils.c.c.c.format(this.a.c()), mctech.utils.c.c.c.format(this.a.d()))), 30, i5 + 9, -9584);
    }
}
