package mctech.components;

import com.mojang.blaze3d.vertex.PoseStack;
import java.util.Set;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.apache.commons.lang3.time.DurationFormatUtils;

/* JADX INFO: renamed from: mctech.components.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/g.class */
public class C0113g extends mctech.m.d.a.a {
    private mctech.blockentities.d a;

    public C0113g(mctech.blockentities.d dVar) {
        super(mctech.utils.math.geometry.b.a);
        this.a = dVar;
    }

    @Override // mctech.m.d.a.a
    protected void a(Set<mctech.m.d.a.a.EnumC0027a> set) {
        set.add(mctech.m.d.a.a.EnumC0027a.DRAW_FOREGROUND);
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(GuiGraphics guiGraphics, int i, int i2) {
        this.q.a(guiGraphics, (Component) f("gui.mctech.battery_station.eu"), 180, 30, -1);
        this.q.a(guiGraphics, (Component) f("gui.mctech.battery_station.etc"), 180, 40, -1);
        float f = (this.a.getLongMaxEU() < 10000000 || this.a.getLongStoredEU() < 10000000) ? 1.0f : 0.5f;
        float f2 = 1.0f / f;
        PoseStack poseStackPose = guiGraphics.pose();
        poseStackPose.scale(f, f, f);
        this.q.c(guiGraphics, (Component) e(mctech.utils.c.c.c.format(this.a.getLongStoredEU())), (int) (110.0f * f2), (int) (30.0f * f2), 5635925);
        this.q.b(guiGraphics, (Component) e(" / "), (int) (118.0f * f2), (int) (30.0f * f2), 5635925);
        this.q.a(guiGraphics, (Component) e(mctech.utils.c.c.c.format(this.a.getLongMaxEU())), (int) (123.0f * f2), (int) (30.0f * f2), 5635925);
        poseStackPose.scale(f2, f2, f2);
        long longMaxEU = this.a.getLongMaxEU() - this.a.getLongStoredEU();
        this.q.a(guiGraphics, (Component) (longMaxEU >= 100000000 ? f("gui.mctech.battery_station.alot") : e(mctech.utils.c.c.c.format(longMaxEU)).append(f("gui.mctech.battery_station.eu"))), 65, 40, 5635925);
        if (longMaxEU <= 0) {
            this.q.c(guiGraphics, (Component) f("gui.mctech.battery_station.done"), 175, 40, 5635925);
            return;
        }
        long jMin = Math.min(this.a.a.c(), longMaxEU);
        if (jMin > 0) {
            this.q.c(guiGraphics, (Component) f(DurationFormatUtils.formatDuration(Math.max(0L, (longMaxEU / jMin) * 50), "HH:mm:ss")), 170, 40, 5635925);
        } else {
            this.q.c(guiGraphics, (Component) f("gui.mctech.battery_station.never"), 170, 40, 5635925);
        }
    }
}
