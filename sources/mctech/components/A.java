package mctech.components;

import com.mojang.blaze3d.vertex.PoseStack;
import java.util.Set;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/A.class */
public class A extends mctech.m.d.a.a {
    mctech.blockentities.c a;

    public A(mctech.blockentities.c cVar) {
        super(mctech.utils.math.geometry.b.a);
        this.a = cVar;
    }

    @Override // mctech.m.d.a.a
    protected void a(Set<mctech.m.d.a.a.EnumC0027a> set) {
        set.add(mctech.m.d.a.a.EnumC0027a.DRAW_BACKGROUND);
        set.add(mctech.m.d.a.a.EnumC0027a.DRAW_FOREGROUND);
    }

    @Override // mctech.m.d.a.a
    public void a(GuiGraphics guiGraphics, int i, int i2) {
        int maxEU = this.a.getMaxEU();
        PoseStack poseStackPose = guiGraphics.pose();
        this.q.a(guiGraphics, (Component) c("misc.mctech.eu", mctech.utils.c.c.c.format(Math.min(maxEU, this.a.getStoredEU()))), 48, 16, mctech.m.d.b.a);
        this.q.a(guiGraphics, (Component) e("/").append(c("misc.mctech.eu", mctech.utils.c.c.c.format(maxEU))), 48, 25, mctech.m.d.b.a);
        poseStackPose.pushPose();
        poseStackPose.translate(48.0d, 38.0d, 0.0d);
        poseStackPose.scale(0.5f, 0.5f, 1.0f);
        this.q.a(guiGraphics, (Component) c("gui.mctech.charge_pad.out", mctech.utils.c.c.c.format(this.a.f)), 0, -8, mctech.m.d.b.a);
        this.q.a(guiGraphics, (Component) c("gui.mctech.charge_pad.tier", Integer.valueOf(this.a.d)), 0, 2, mctech.m.d.b.a);
        poseStackPose.popPose();
    }

    @Override // mctech.m.d.a.a
    public void a(GuiGraphics guiGraphics, int i, int i2, float f) {
        int guiLeft = this.q.getGuiLeft();
        int guiTop = this.q.getGuiTop();
        if (this.a.o == 1) {
            this.q.b(guiGraphics, guiLeft + 151, guiTop + 28, 188.0f, 0.0f, 18.0f, 18.0f);
            this.q.b(guiGraphics, guiLeft + 151, guiTop + 57, 188.0f, 0.0f, 18.0f, 18.0f);
        }
        int slotCount = this.a.m.getSlotCount() - (this.a.o > 1 ? 3 : 1);
        if (slotCount < 3) {
            this.q.b(guiGraphics, guiLeft + 107, guiTop + 57, 188.0f, 0.0f, 18.0f, 18.0f);
            if (slotCount < 2) {
                this.q.b(guiGraphics, guiLeft + 87, guiTop + 57, 188.0f, 0.0f, 18.0f, 18.0f);
            }
        }
    }
}
