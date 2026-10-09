package mctech.components;

import com.mojang.blaze3d.vertex.PoseStack;
import java.util.Set;
import mctech.integration.jade.DecimalFormats;
import mctech.utils.C0200b;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;

/* JADX INFO: renamed from: mctech.components.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/l.class */
public class C0118l extends mctech.m.d.a.a {
    private static final int a = 13487565;
    private mctech.blockentities.b.a b;
    private boolean c;
    private long d;
    private int e;
    private int f;

    public C0118l(mctech.blockentities.b.a aVar) {
        super(mctech.utils.math.geometry.b.a);
        this.e = 0;
        this.f = 0;
        this.b = aVar;
    }

    public C0118l(mctech.blockentities.b.a aVar, int i, int i2) {
        super(mctech.utils.math.geometry.b.a);
        this.e = 0;
        this.f = 0;
        this.b = aVar;
        this.e = i;
        this.f = i2;
    }

    @Override // mctech.m.d.a.a
    protected void a(Set<mctech.m.d.a.a.EnumC0027a> set) {
        set.add(mctech.m.d.a.a.EnumC0027a.DRAW_FOREGROUND);
    }

    protected String a() {
        if (this.b.getMaxEnergyOutput() <= this.b.t) {
            this.d = -1L;
            return "§b" + DecimalFormats.formatNumber(this.b.getMaxEnergyOutput(), 4);
        }
        if (this.d < System.currentTimeMillis()) {
            this.c = !this.c;
            this.d = System.currentTimeMillis() + 1000;
        }
        return (this.c ? "§c" : "§4") + this.b.t;
    }

    @Override // mctech.m.d.a.a
    public void a(GuiGraphics guiGraphics, int i, int i2) {
        int iMax = Math.max(0, this.b.getStoredEU());
        int i3 = this.b.t;
        if (iMax > i3) {
            iMax = i3;
        }
        if (this.b.k() >= this.b.t) {
            iMax = i3;
        }
        Font font = this.q.getMinecraft().font;
        PoseStack poseStackPose = guiGraphics.pose();
        poseStackPose.pushPose();
        poseStackPose.scale(0.8f, 0.8f, 1.0f);
        guiGraphics.drawString(font, Component.translatable(C0200b.a, new Object[]{"§b" + (DecimalFormats.formatNumber(iMax, 4) + "/" + DecimalFormats.formatNumber(i3, 4))}), ((int) (80.0f / 0.8f)) + this.e, ((int) (14.0f / 0.8f)) + this.f, a);
        guiGraphics.drawString(font, Component.translatable(C0200b.b), ((int) (80.0f / 0.8f)) + this.e, ((int) (24.0f / 0.8f)) + this.f, a);
        guiGraphics.drawString(font, Component.literal(a() + " EU/t"), ((int) (133.0f / 0.8f)) + this.e, ((int) (24.0f / 0.8f)) + this.f, a);
        guiGraphics.drawString(font, Component.translatable(C0200b.c), ((int) (80.0f / 0.8f)) + this.e, ((int) (34.0f / 0.8f)) + this.f, a);
        guiGraphics.drawString(font, Component.literal("§b" + DecimalFormats.formatNumber(this.b.k(), 4) + " EU/t"), ((int) (127.0f / 0.8f)) + this.e, ((int) (34.0f / 0.8f)) + this.f, a);
        if (this.b.q) {
            guiGraphics.drawString(font, Component.translatable(C0200b.d), ((int) (80.0f / 0.8f)) + this.e, ((int) (44.0f / 0.8f)) + this.f, a);
        }
        poseStackPose.popPose();
    }
}
