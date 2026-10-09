package mctech.v.g;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.TextureSheetParticle;
import net.minecraft.core.particles.SimpleParticleType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/g/e.class */
public class e extends TextureSheetParticle {
    private final SpriteSet a;

    protected e(ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6, SpriteSet spriteSet) {
        super(clientLevel, d, d2, d3, d4, d5, d6);
        this.a = spriteSet;
        this.hasPhysics = true;
        this.lifetime = 8;
        this.gravity = 1.0f;
        this.friction = 0.8f;
        this.quadSize = 0.1f * ((this.random.nextFloat() * 0.5f) + 0.5f);
        this.rCol = 1.0f;
        this.gCol = 0.8f + (this.random.nextFloat() * 0.2f);
        this.bCol = 0.3f + (this.random.nextFloat() * 0.3f);
        this.xd = d4 + (((double) this.random.nextFloat()) * 0.1d * ((double) (this.random.nextBoolean() ? 1 : -1)));
        this.yd = d5 + (((double) this.random.nextFloat()) * 0.1d * ((double) (this.random.nextBoolean() ? 1 : -1)));
        this.zd = d6 + (((double) this.random.nextFloat()) * 0.1d * ((double) (this.random.nextBoolean() ? 1 : -1)));
        this.roll = 0.01f;
        setSpriteFromAge(spriteSet);
    }

    public void tick() {
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        int i = this.age;
        this.age = i + 1;
        if (i >= this.lifetime) {
            remove();
            return;
        }
        setSpriteFromAge(this.a);
        this.yd -= 0.04d * ((double) this.gravity);
        move(this.xd, this.yd, this.zd);
        if (this.onGround) {
            this.xd *= 0.7d;
            this.zd *= 0.7d;
            if (Math.abs(this.yd) > 0.01d) {
                this.yd *= -0.3d;
            } else {
                this.yd = 0.0d;
            }
            this.lifetime = Math.min(this.lifetime, this.age + 15);
        }
        this.xd *= (double) this.friction;
        this.yd *= (double) this.friction;
        this.zd *= (double) this.friction;
        this.alpha = 1.0f - (this.age / this.lifetime);
        this.quadSize *= 0.95f;
    }

    @NotNull
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_LIT;
    }

    public int getLightColor(float f) {
        return (((int) (15.0f * (1.0f - (((this.age + f) / this.lifetime) * 0.5f)))) << 20) | 240;
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/g/e$a.class */
    public static class a implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet a;

        public a(SpriteSet spriteSet) {
            this.a = spriteSet;
        }

        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Particle createParticle(@NotNull SimpleParticleType simpleParticleType, @NotNull ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6) {
            return new e(clientLevel, d, d2, d3, d4, d5, d6, this.a);
        }
    }
}
