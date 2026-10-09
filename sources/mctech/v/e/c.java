package mctech.v.e;

import mctech.api.events.RetextureEvent;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/e/c.class */
@OnlyIn(Dist.CLIENT)
public class c {
    float[] a;
    int b;

    public c(float[] fArr, int i) {
        this.a = fArr;
        this.b = i;
    }

    public static c a(TextureAtlasSprite textureAtlasSprite) {
        return new c(new float[]{textureAtlasSprite.getU0(), textureAtlasSprite.getV0(), textureAtlasSprite.getU1(), textureAtlasSprite.getV1()}, 0);
    }

    public static c a(TextureAtlasSprite textureAtlasSprite, int i) {
        return new c(new float[]{textureAtlasSprite.getU0(), textureAtlasSprite.getV0(), textureAtlasSprite.getU1(), textureAtlasSprite.getV1()}, i);
    }

    public static c a(TextureAtlasSprite textureAtlasSprite, float f, float f2, int i) {
        return new c(new float[]{textureAtlasSprite.getU(f), textureAtlasSprite.getV(f2), textureAtlasSprite.getU(16.0f - f), textureAtlasSprite.getV(16.0f - f2)}, i);
    }

    public float a(int i) {
        if (this.a == null) {
            throw new NullPointerException("uvs");
        }
        int iD = d(i);
        return this.a[(iD == 0 || iD == 1) ? (char) 0 : (char) 2];
    }

    public float b(int i) {
        if (this.a == null) {
            throw new NullPointerException("uvs");
        }
        int iD = d(i);
        return this.a[(iD == 0 || iD == 3) ? (char) 1 : (char) 3];
    }

    public static float[] a(float[] fArr, RetextureEvent.Rotation rotation) {
        float[] fArr2 = new float[4];
        switch (rotation) {
            case ROTATION_180:
            case ROTATION_0:
                System.arraycopy(fArr, 0, fArr2, 0, 4);
                break;
            case ROTATION_270:
            case ROTATION_90:
                fArr2[0] = fArr[1];
                fArr2[1] = fArr[0];
                fArr2[2] = fArr[3];
                fArr2[3] = fArr[2];
                break;
        }
        return fArr2;
    }

    private int d(int i) {
        return (i + (this.b / 90)) % 4;
    }

    public int a() {
        return this.b;
    }

    public void c(int i) {
        this.b = (this.b + i) % 360;
    }
}
