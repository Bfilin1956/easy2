package mctech.components;

import com.mojang.blaze3d.vertex.PoseStack;
import java.util.Set;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/z.class */
public class z extends mctech.m.d.a.a {
    public z(mctech.utils.math.geometry.b bVar) {
        super(bVar);
    }

    @Override // mctech.m.d.a.a
    protected void a(@NotNull Set<mctech.m.d.a.a.EnumC0027a> set) {
        set.add(mctech.m.d.a.a.EnumC0027a.DRAW_FOREGROUND);
    }

    @Override // mctech.m.d.a.a
    public void a(GuiGraphics guiGraphics, int i, int i2) {
        PoseStack poseStackPose = guiGraphics.pose();
        MutableComponent mutableComponentLiteral = Component.literal(String.valueOf(ChatFormatting.RED) + "Анти материя: " + String.valueOf(ChatFormatting.WHITE) + "50.000.000 EU");
        int iA = (this.o.a() + (this.o.d() / 2)) - (this.q.j().width(mutableComponentLiteral) / 4);
        int iB = this.o.b() + 8;
        poseStackPose.pushPose();
        poseStackPose.translate(iA, iB, 0.0f);
        poseStackPose.scale(0.5f, 0.5f, 0.0f);
        poseStackPose.translate(-iA, -iB, 0.0f);
        guiGraphics.drawString(this.q.j(), mutableComponentLiteral, iA, iB, 16777215);
        poseStackPose.popPose();
        MutableComponent mutableComponentLiteral2 = Component.literal(String.valueOf(ChatFormatting.DARK_PURPLE) + "Материя: " + String.valueOf(ChatFormatting.WHITE) + "7.000.000 EU");
        int iA2 = (this.o.a() + (this.o.d() / 2)) - (this.q.j().width(mutableComponentLiteral2) / 4);
        int i3 = iB + 7;
        poseStackPose.pushPose();
        poseStackPose.translate(iA2, i3, 0.0f);
        poseStackPose.scale(0.5f, 0.5f, 0.0f);
        poseStackPose.translate(-iA2, -i3, 0.0f);
        guiGraphics.drawString(this.q.j(), mutableComponentLiteral2, iA2, i3, 16777215);
        poseStackPose.popPose();
    }
}
