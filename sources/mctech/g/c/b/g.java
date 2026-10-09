package mctech.g.c.b;

import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.Direction;
import net.minecraft.util.FastColor;
import net.neoforged.neoforge.client.model.pipeline.QuadBakingVertexConsumer;
import org.joml.Vector3f;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/c/b/g.class */
public class g {

    /* JADX INFO: renamed from: mctech.g.c.b.g$1, reason: invalid class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/c/b/g$1.class */
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
                a[Direction.WEST.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                a[Direction.EAST.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    public static Vector3f[] a(Direction direction, float f, float f2, float f3) throws MatchException {
        switch (AnonymousClass1.a[direction.ordinal()]) {
            case 1:
                return new Vector3f[]{new Vector3f(f, 1.0f - f3, f), new Vector3f(f2, 1.0f - f3, f), new Vector3f(f2, 1.0f - f3, f2), new Vector3f(f, 1.0f - f3, f2)};
            case 2:
                return new Vector3f[]{new Vector3f(f, f3, f), new Vector3f(f, f3, f2), new Vector3f(f2, f3, f2), new Vector3f(f2, f3, f)};
            case 3:
                return new Vector3f[]{new Vector3f(f2, f2, 1.0f - f3), new Vector3f(f2, f, 1.0f - f3), new Vector3f(f, f, 1.0f - f3), new Vector3f(f, f2, 1.0f - f3)};
            case 4:
                return new Vector3f[]{new Vector3f(f, f2, f3), new Vector3f(f, f, f3), new Vector3f(f2, f, f3), new Vector3f(f2, f2, f3)};
            case 5:
                return new Vector3f[]{new Vector3f(1.0f - f3, f2, f), new Vector3f(1.0f - f3, f, f), new Vector3f(1.0f - f3, f, f2), new Vector3f(1.0f - f3, f2, f2)};
            case 6:
                return new Vector3f[]{new Vector3f(f3, f2, f2), new Vector3f(f3, f, f2), new Vector3f(f3, f, f), new Vector3f(f3, f2, f)};
            default:
                throw new MatchException((String) null, (Throwable) null);
        }
    }

    public static BakedQuad a(Vector3f[] vector3fArr, TextureAtlasSprite textureAtlasSprite) {
        return a(vector3fArr[0], vector3fArr[1], vector3fArr[2], vector3fArr[3], textureAtlasSprite);
    }

    public static BakedQuad a(Vector3f vector3f, Vector3f vector3f2, Vector3f vector3f3, Vector3f vector3f4, TextureAtlasSprite textureAtlasSprite) {
        return a(vector3f, vector3f2, vector3f3, vector3f4, textureAtlasSprite, 16777215, 1.0f);
    }

    public static BakedQuad a(Vector3f[] vector3fArr, TextureAtlasSprite textureAtlasSprite, int i) {
        return a(vector3fArr[0], vector3fArr[1], vector3fArr[2], vector3fArr[3], textureAtlasSprite, i, 1.0f);
    }

    public static BakedQuad a(Vector3f[] vector3fArr, TextureAtlasSprite textureAtlasSprite, int i, float f) {
        return a(vector3fArr[0], vector3fArr[1], vector3fArr[2], vector3fArr[3], textureAtlasSprite, i, f);
    }

    public static BakedQuad a(Vector3f vector3f, Vector3f vector3f2, Vector3f vector3f3, Vector3f vector3f4, TextureAtlasSprite textureAtlasSprite, int i, float f) {
        Vector3f vector3fNormalize = new Vector3f(vector3f3).sub(vector3f2).cross(new Vector3f(vector3f).sub(vector3f2)).normalize();
        float f2 = vector3fNormalize.x;
        float f3 = vector3fNormalize.y;
        float f4 = vector3fNormalize.z;
        float fWidth = textureAtlasSprite.contents().width() / 16.0f;
        float fHeight = textureAtlasSprite.contents().height() / 16.0f;
        float fRed = FastColor.ARGB32.red(i) / 255.0f;
        float fGreen = FastColor.ARGB32.green(i) / 255.0f;
        float fBlue = FastColor.ARGB32.blue(i) / 255.0f;
        QuadBakingVertexConsumer quadBakingVertexConsumer = new QuadBakingVertexConsumer();
        quadBakingVertexConsumer.setSprite(textureAtlasSprite);
        quadBakingVertexConsumer.setDirection(Direction.getNearest(vector3fNormalize.x, vector3fNormalize.y, vector3fNormalize.z));
        quadBakingVertexConsumer.addVertex(vector3f.x, vector3f.y, vector3f.z).setNormal(f2, f3, f4).setUv(textureAtlasSprite.getU(0.0f), textureAtlasSprite.getV(0.0f)).setColor(fRed, fGreen, fBlue, f);
        quadBakingVertexConsumer.addVertex(vector3f2.x, vector3f2.y, vector3f2.z).setNormal(f2, f3, f4).setUv(textureAtlasSprite.getU(0.0f), textureAtlasSprite.getV(fHeight)).setColor(fRed, fGreen, fBlue, f);
        quadBakingVertexConsumer.addVertex(vector3f3.x, vector3f3.y, vector3f3.z).setNormal(f2, f3, f4).setUv(textureAtlasSprite.getU(fWidth), textureAtlasSprite.getV(fHeight)).setColor(fRed, fGreen, fBlue, f);
        quadBakingVertexConsumer.addVertex(vector3f4.x, vector3f4.y, vector3f4.z).setNormal(f2, f3, f4).setUv(textureAtlasSprite.getU(fWidth), textureAtlasSprite.getV(0.0f)).setColor(fRed, fGreen, fBlue, f);
        return quadBakingVertexConsumer.bakeQuad();
    }
}
