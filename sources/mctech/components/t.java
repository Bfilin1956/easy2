package mctech.components;

import com.mojang.blaze3d.vertex.PoseStack;
import java.util.Set;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/t.class */
public class t extends mctech.m.d.a.a {
    public t(mctech.utils.math.geometry.b bVar) {
        super(bVar);
    }

    @Override // mctech.m.d.a.a
    protected void a(@NotNull Set<mctech.m.d.a.a.EnumC0027a> set) {
        set.add(mctech.m.d.a.a.EnumC0027a.DRAW_FOREGROUND);
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(GuiGraphics guiGraphics, int i, int i2) {
        Font fontJ = this.q.j();
        MutableComponent mutableComponentWithStyle = Component.literal("Механизм повышает урон оружия").withStyle(ChatFormatting.RED);
        float fA = (this.o.a() + (this.o.d() * 0.5f)) - ((fontJ.width(mutableComponentWithStyle) * 0.5f) * 0.75f);
        float fB = this.o.b() + 12;
        PoseStack poseStackPose = guiGraphics.pose();
        poseStackPose.pushPose();
        poseStackPose.translate(fA, fB, 0.0d);
        poseStackPose.scale(0.75f, 0.75f, 0.75f);
        poseStackPose.translate(-fA, -fB, 0.0d);
        guiGraphics.drawString(Minecraft.getInstance().font, mutableComponentWithStyle.getVisualOrderText(), fA, fB, -1, true);
        poseStackPose.popPose();
        MutableComponent mutableComponentAppend = Component.literal("Электролизованная вода").withStyle(ChatFormatting.AQUA).append(Component.literal(" - помогает точить").withStyle(ChatFormatting.WHITE));
        float fA2 = this.o.a() + 2;
        float fB2 = (this.o.b() + this.o.c()) - 14;
        poseStackPose.pushPose();
        poseStackPose.translate(fA2, fB2, 0.0d);
        poseStackPose.scale(0.65f, 0.65f, 0.65f);
        poseStackPose.translate(-fA2, -fB2, 0.0d);
        guiGraphics.drawString(Minecraft.getInstance().font, mutableComponentAppend.getVisualOrderText(), fA2, fB2, -1, true);
        poseStackPose.popPose();
        MutableComponent mutableComponentAppend2 = Component.literal("Точильный камень").withStyle(ChatFormatting.DARK_PURPLE).append(Component.literal(" - регулирует удачу заточки").withStyle(ChatFormatting.WHITE));
        float f = fB2 + 7.0f;
        poseStackPose.pushPose();
        poseStackPose.translate(fA2, f, 0.0d);
        poseStackPose.scale(0.65f, 0.65f, 0.65f);
        poseStackPose.translate(-fA2, -f, 0.0d);
        guiGraphics.drawString(Minecraft.getInstance().font, mutableComponentAppend2.getVisualOrderText(), fA2, f, -1, true);
        poseStackPose.popPose();
    }
}
