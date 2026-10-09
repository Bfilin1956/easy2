package mctech.g.c;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.Direction;
import net.neoforged.neoforge.client.model.IQuadTransformer;
import org.joml.Vector3f;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/c/g.class */
public class g {
    public static void a(Direction direction, PoseStack.Pose pose, VertexConsumer vertexConsumer, TextureAtlasSprite textureAtlasSprite, float f, float f2, float f3, float f4, float f5, int i) {
        a(direction, pose, vertexConsumer, textureAtlasSprite, f, f2, f3, f4, f5, i, 15728880);
    }

    /* JADX INFO: renamed from: mctech.g.c.g$1, reason: invalid class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/c/g$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[Direction.values().length];

        static {
            try {
                a[Direction.DOWN.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[Direction.UP.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[Direction.NORTH.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[Direction.SOUTH.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                a[Direction.EAST.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                a[Direction.WEST.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    public static void a(Direction direction, PoseStack.Pose pose, VertexConsumer vertexConsumer, TextureAtlasSprite textureAtlasSprite, float f, float f2, float f3, float f4, float f5, int i, int i2) {
        switch (AnonymousClass1.a[direction.ordinal()]) {
            case 1:
                a(pose, vertexConsumer, textureAtlasSprite, i, i2, f, f + f4, 1.0f - f3, 1.0f - f3, f2, f2, f2 + f5, f2 + f5, f, f + f4, f2, f2 + f5, 0.0f, -1.0f, 0.0f);
                return;
            case 2:
                a(pose, vertexConsumer, textureAtlasSprite, i, i2, f, f + f4, f3, f3, f2 + f5, f2 + f5, f2, f2, f, f + f4, f2, f2 + f5, 0.0f, 1.0f, 0.0f);
                return;
            case 3:
                a(pose, vertexConsumer, textureAtlasSprite, i, i2, f, f + f4, f2 + f5, f2, f3, f3, f3, f3, f, f + f4, f2, f2 + f5, 0.0f, 0.0f, -1.0f);
                return;
            case 4:
                a(pose, vertexConsumer, textureAtlasSprite, i, i2, f, f + f4, f2, f2 + f5, 1.0f - f3, 1.0f - f3, 1.0f - f3, 1.0f - f3, f + f4, f, f2 + f5, f2, 0.0f, 0.0f, 1.0f);
                return;
            case 5:
                a(pose, vertexConsumer, textureAtlasSprite, i, i2, 1.0f - f3, 1.0f - f3, f2 + f5, f2, f, f + f4, f + f4, f, f, f + f4, f2, f2 + f5, 1.0f, 0.0f, 0.0f);
                return;
            case 6:
                a(pose, vertexConsumer, textureAtlasSprite, i, i2, f3, f3, f2, f2 + f5, f, f + f4, f + f4, f, f + f4, f, f2 + f5, f2, -1.0f, 0.0f, 0.0f);
                return;
            default:
                throw new IllegalStateException("Unexpected value: " + String.valueOf(direction));
        }
    }

    private static void a(PoseStack.Pose pose, VertexConsumer vertexConsumer, TextureAtlasSprite textureAtlasSprite, int i, int i2, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15) {
        float fWidth = (f9 * textureAtlasSprite.contents().width()) / 16.0f;
        float fWidth2 = (f10 * textureAtlasSprite.contents().width()) / 16.0f;
        float fHeight = (f11 * textureAtlasSprite.contents().height()) / 16.0f;
        float fHeight2 = (f12 * textureAtlasSprite.contents().height()) / 16.0f;
        vertexConsumer.addVertex(pose, f, f3, f5).setColor(i).setUv(textureAtlasSprite.getU(fWidth), textureAtlasSprite.getV(fHeight)).setOverlay(OverlayTexture.NO_OVERLAY).setLight(i2).setNormal(pose, f13, f14, f15);
        vertexConsumer.addVertex(pose, f2, f3, f6).setColor(i).setUv(textureAtlasSprite.getU(fWidth2), textureAtlasSprite.getV(fHeight)).setOverlay(OverlayTexture.NO_OVERLAY).setLight(i2).setNormal(pose, f13, f14, f15);
        vertexConsumer.addVertex(pose, f2, f4, f7).setColor(i).setUv(textureAtlasSprite.getU(fWidth2), textureAtlasSprite.getV(fHeight2)).setOverlay(OverlayTexture.NO_OVERLAY).setLight(i2).setNormal(pose, f13, f14, f15);
        vertexConsumer.addVertex(pose, f, f4, f8).setColor(i).setUv(textureAtlasSprite.getU(fWidth), textureAtlasSprite.getV(fHeight2)).setOverlay(OverlayTexture.NO_OVERLAY).setLight(i2).setNormal(pose, f13, f14, f15);
    }

    public static float[] a(int[] iArr, int i, int i2, int i3) {
        float[] fArr = new float[i3];
        int i4 = (i * IQuadTransformer.STRIDE) + i2;
        for (int i5 = 0; i5 < i3; i5++) {
            fArr[i5] = Float.intBitsToFloat(iArr[i4 + i5]);
        }
        return fArr;
    }

    public static Vector3f a(int[] iArr, int i) {
        int i2 = iArr[(i * IQuadTransformer.STRIDE) + IQuadTransformer.NORMAL];
        return new Vector3f((i2 & 255) / 127.0f, ((i2 & 65280) >> 8) / 127.0f, ((i2 & 16711680) >> 16) / 127.0f);
    }

    public static int[] a(float f, float f2) {
        return new int[]{Float.floatToRawIntBits(f), Float.floatToRawIntBits(f2)};
    }

    private static int[] b(int[] iArr, int i) {
        int i2 = iArr[(IQuadTransformer.STRIDE * i) + IQuadTransformer.COLOR];
        return new int[]{(i2 >> 24) & 255, (i2 >> 16) & 255, (i2 >> 8) & 255, i2 & 255};
    }

    private static int[] a(int[] iArr, int[] iArr2) {
        return new int[]{(iArr[0] * iArr2[0]) / 255, (iArr[1] * iArr2[1]) / 255, (iArr[2] * iArr2[2]) / 255, (iArr[3] * iArr2[3]) / 255};
    }

    public static void a(int[] iArr, int i, int i2) {
        a(iArr, i, a(b(iArr, i), new int[]{255 | ((i2 >> 24) & 255), i2 & 255, (i2 >> 8) & 255, (i2 >> 16) & 255}));
    }

    public static void a(int[] iArr, int i, int[] iArr2) {
        iArr[(i * IQuadTransformer.STRIDE) + IQuadTransformer.COLOR] = (iArr2[0] << 24) | (iArr2[1] << 16) | (iArr2[2] << 8) | iArr2[3];
    }

    public static void b(int[] iArr, int i, int i2) {
        int[] iArr2 = {255 | ((i2 >> 24) & 255), i2 & 255, (i2 >> 8) & 255, (i2 >> 16) & 255};
        iArr[(i * IQuadTransformer.STRIDE) + IQuadTransformer.COLOR] = (iArr2[0] << 24) | (iArr2[1] << 16) | (iArr2[2] << 8) | iArr2[3];
    }
}
