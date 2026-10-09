package mctech.utils;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.Direction;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/z.class */
@OnlyIn(Dist.CLIENT)
public class z {
    private static final float a = 16.0f;
    private final float b;
    private final float c;
    private final float d;
    private final float e;
    private final float f;
    private final float g;

    public z(float f, float f2, float f3, float f4, float f5, float f6) {
        this.b = f / 16.0f;
        this.c = f2 / 16.0f;
        this.d = f3 / 16.0f;
        this.e = f4 / 16.0f;
        this.f = f5 / 16.0f;
        this.g = f6 / 16.0f;
    }

    public void a(@NotNull PoseStack poseStack, @NotNull VertexConsumer vertexConsumer, @NotNull TextureAtlasSprite textureAtlasSprite, int i, int i2) {
        poseStack.pushPose();
        poseStack.translate(this.b, this.c, this.d);
        PoseStack.Pose poseLast = poseStack.last();
        A.a(Direction.UP, poseLast, vertexConsumer, textureAtlasSprite, 0.0f, 0.0f, this.f, this.e, this.g, i, i2);
        A.a(Direction.DOWN, poseLast, vertexConsumer, textureAtlasSprite, 0.0f, 0.0f, 1.0f, this.e, this.g, i, i2);
        A.a(Direction.SOUTH, poseLast, vertexConsumer, textureAtlasSprite, 0.0f, 0.0f, 1.0f - this.g, this.e, this.f, i, i2);
        A.a(Direction.NORTH, poseLast, vertexConsumer, textureAtlasSprite, 0.0f, 0.0f, 0.0f, this.e, this.f, i, i2);
        A.a(Direction.EAST, poseLast, vertexConsumer, textureAtlasSprite, 0.0f, 0.0f, 1.0f - this.e, this.g, this.f, i, i2);
        A.a(Direction.WEST, poseLast, vertexConsumer, textureAtlasSprite, 0.0f, 0.0f, 0.0f, this.g, this.f, i, i2);
        poseStack.popPose();
    }
}
