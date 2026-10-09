package mctech.p.c;

import com.mojang.blaze3d.platform.Window;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.joml.Matrix4f;
import org.lwjgl.opengl.GL11;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/p/c/d.class */
@OnlyIn(Dist.CLIENT)
public class d extends g {
    private boolean i;

    public d(f fVar) {
        super(fVar);
        this.i = false;
    }

    public d a() {
        this.i = true;
        return this;
    }

    @Override // mctech.p.c.g
    public void a(GuiGraphics guiGraphics, int i, int i2, int i3, int i4, int i5, int i6) {
        int width;
        int height;
        int width2;
        int height2;
        int width3;
        int height3;
        Window window = Minecraft.getInstance().getWindow();
        Matrix4f matrix4fPose = guiGraphics.pose().last().pose();
        float fM30 = matrix4fPose.m30();
        float fM31 = matrix4fPose.m31();
        if (this.i) {
            width = (int) (((i + fM30) * window.getWidth()) / window.getGuiScaledWidth());
            height = (int) (((i2 + fM31) * window.getHeight()) / window.getGuiScaledHeight());
            width2 = (i3 * window.getWidth()) / window.getGuiScaledWidth();
            height2 = (i4 * window.getHeight()) / window.getGuiScaledHeight();
            width3 = (int) ((((i + fM30) + i5) * window.getWidth()) / window.getGuiScaledWidth());
            height3 = (int) ((((i2 + fM31) + i6) * window.getHeight()) / window.getGuiScaledHeight());
        } else {
            width = (i * window.getWidth()) / window.getGuiScaledWidth();
            height = (i2 * window.getHeight()) / window.getGuiScaledHeight();
            width2 = (i3 * window.getWidth()) / window.getGuiScaledWidth();
            height2 = (i4 * window.getHeight()) / window.getGuiScaledHeight();
            width3 = ((i + i5) * window.getWidth()) / window.getGuiScaledWidth();
            height3 = ((i2 + i6) * window.getHeight()) / window.getGuiScaledHeight();
        }
        int height4 = (window.getHeight() - height) - height2;
        int height5 = window.getHeight() - height3;
        GL11.glEnable(3089);
        GL11.glScissor(width, height4, width2, height2);
        super.a(guiGraphics, width, height4, width2, height2, width3 - width, height5 - height4);
        GL11.glDisable(3089);
    }
}
