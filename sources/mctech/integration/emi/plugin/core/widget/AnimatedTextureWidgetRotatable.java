package mctech.integration.emi.plugin.core.widget;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.emi.emi.api.widget.AnimatedTextureWidget;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import org.joml.Matrix4f;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/integration/emi/plugin/core/widget/AnimatedTextureWidgetRotatable.class */
public class AnimatedTextureWidgetRotatable extends AnimatedTextureWidget {
    private float rotation;

    public AnimatedTextureWidgetRotatable(ResourceLocation resourceLocation, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, boolean z, boolean z2, boolean z3) {
        super(resourceLocation, i, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, z, z2, z3);
        this.rotation = 0.0f;
    }

    public AnimatedTextureWidgetRotatable(ResourceLocation resourceLocation, int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z, boolean z2, boolean z3) {
        super(resourceLocation, i, i2, i3, i4, i5, i6, i7, z, z2, z3);
        this.rotation = 0.0f;
    }

    public AnimatedTextureWidgetRotatable rotation(float f) {
        this.rotation = f;
        return this;
    }

    public void render(GuiGraphics guiGraphics, int i, int i2, float f) {
        PoseStack poseStackPose = guiGraphics.pose();
        poseStackPose.pushPose();
        poseStackPose.translate(((double) this.x) + (((double) this.width) / 2.0d), ((double) this.y) + (((double) this.height) / 2.0d), 0.0d);
        poseStackPose.mulPose(new Matrix4f().rotationZ((float) Math.toRadians(this.rotation)));
        poseStackPose.translate(-(((double) this.x) + (((double) this.width) / 2.0d)), -(((double) this.y) + (((double) this.height) / 2.0d)), 0.0d);
        super.render(guiGraphics, i, i2, f);
        poseStackPose.popPose();
    }
}
