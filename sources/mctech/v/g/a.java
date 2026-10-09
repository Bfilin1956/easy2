package mctech.v.g;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SingleQuadParticle;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.resources.ResourceLocation;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/g/a.class */
public class a extends SingleQuadParticle {
    public static final ResourceLocation a = ResourceLocation.parse("textures/atlas/particles.png");
    TextureAtlasSprite b;

    public a(ClientLevel clientLevel, double d, double d2, double d3, int i, double[] dArr, float[] fArr) {
        super(clientLevel, d, d2, d3, dArr[0], dArr[1], dArr[2]);
        this.rCol = fArr[0];
        this.gCol = fArr[1];
        this.bCol = fArr[2];
        setSize(0.02f, 0.02f);
        this.quadSize *= (this.random.nextFloat() * 0.5f) + 0.5f;
        this.yd *= 0.2d;
        this.lifetime = (int) (((double) i) / ((Math.random() * 0.8d) + 0.2d));
        this.b = Minecraft.getInstance().getTextureManager().getTexture(a).getSprite(ResourceLocation.withDefaultNamespace("generic_2"));
    }

    public void tick() {
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        this.x += this.xd;
        this.y += this.yd;
        this.z += this.zd;
        this.xd *= 0.99d;
        this.yd *= 0.99d;
        this.zd *= 0.99d;
        int i = this.age;
        this.age = i + 1;
        if (i >= this.lifetime) {
            remove();
        }
    }

    protected float getU0() {
        return this.b.getU0();
    }

    protected float getU1() {
        return this.b.getU1();
    }

    protected float getV0() {
        return this.b.getV0();
    }

    protected float getV1() {
        return this.b.getV1();
    }

    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }
}
