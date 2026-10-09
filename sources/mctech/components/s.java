package mctech.components;

import com.mojang.blaze3d.vertex.PoseStack;
import java.util.Set;
import mctech.blockentities.c.C0076w;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/s.class */
public class s extends mctech.m.d.a.a {
    private final C0076w a;

    public s(C0076w c0076w, mctech.utils.math.geometry.b bVar) {
        super(bVar);
        this.a = c0076w;
    }

    @Override // mctech.m.d.a.a
    protected void a(Set<mctech.m.d.a.a.EnumC0027a> set) {
        set.add(mctech.m.d.a.a.EnumC0027a.DRAW_FOREGROUND);
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(GuiGraphics guiGraphics, int i, int i2) {
        C0076w.a aVarA = this.a.a();
        if (aVarA == null) {
            return;
        }
        Font fontJ = this.q.j();
        MutableComponent mutableComponentWithStyle = Component.literal("Шанс: " + ((int) (aVarA.e * 100.0f)) + "%").withStyle(ChatFormatting.WHITE);
        float fA = this.o.a() + (this.o.d() * 0.5f);
        float fWidth = fA - ((fontJ.width(mutableComponentWithStyle) * 0.5f) * 1.0f);
        float fB = this.o.b() + 10;
        PoseStack poseStackPose = guiGraphics.pose();
        poseStackPose.pushPose();
        poseStackPose.translate(fWidth, fB, 0.0d);
        poseStackPose.scale(1.0f, 1.0f, 1.0f);
        poseStackPose.translate(-fWidth, -fB, 0.0d);
        guiGraphics.drawString(Minecraft.getInstance().font, mutableComponentWithStyle.getVisualOrderText(), fWidth, fB, -1, true);
        poseStackPose.popPose();
        MutableComponent mutableComponentWithStyle2 = Component.literal("стоимость: " + aVarA.d.a + "EU").withStyle(ChatFormatting.WHITE);
        float fWidth2 = fA - ((fontJ.width(mutableComponentWithStyle2) * 0.5f) * 0.5f);
        float f = fB + 9.0f;
        poseStackPose.pushPose();
        poseStackPose.translate(fWidth2, f, 0.0d);
        poseStackPose.scale(0.5f, 0.5f, 0.5f);
        poseStackPose.translate(-fWidth2, -f, 0.0d);
        guiGraphics.drawString(Minecraft.getInstance().font, mutableComponentWithStyle2.getVisualOrderText(), fWidth2, f, -1, true);
        poseStackPose.popPose();
    }
}
