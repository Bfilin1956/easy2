package mctech.v.g;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.core.Holder;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix4f;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/g/b.class */
public class b extends Particle {
    private final String a;
    private final boolean b;
    private final Holder<DamageType> c;
    private float d;
    private boolean e;
    private float f;
    private final float g;

    private b(ClientLevel clientLevel, Vec3 vec3, Vec3 vec4, c cVar) {
        super(clientLevel, vec3.x, vec3.y, vec3.z, vec4.x, vec4.y, vec4.z);
        float fB = cVar.b();
        this.b = cVar.d();
        this.c = cVar.e();
        this.lifetime = 30;
        this.gravity = 0.7f;
        this.hasPhysics = true;
        this.f = Math.min(fB / cVar.c(), 1.0f);
        this.d = 0.025f * (0.8f + (this.f * 0.7f));
        if (this.b) {
            this.d *= 1.3f;
        }
        int iA = mctech.utils.math.a.a(-4031488, 13048603, this.f);
        this.rCol = mctech.utils.math.a.f(iA);
        this.gCol = mctech.utils.math.a.g(iA);
        this.bCol = mctech.utils.math.a.h(iA);
        this.alpha = 1.0f;
        setSize(this.d * 2.0f, this.d * 2.0f);
        this.alpha = 1.0f;
        this.a = String.format(fB % 1.0f == 0.0f ? "%.0f" : "%.1f", Float.valueOf(fB));
        this.g = clientLevel.random.nextBoolean() ? 0.03f : -0.03f;
    }

    public void tick() {
        boolean z = this.onGround;
        if (!this.e && z) {
            this.yd *= -0.5d;
            this.xd *= 0.8d;
            this.zd *= 0.8d;
            this.roll = 0.0f;
            if (Math.abs(this.yd) < 0.05d) {
                this.yd = 0.0d;
            }
        }
        this.e = z;
        super.tick();
        this.alpha = 1.0f - (this.age / this.lifetime);
        if (this.roll <= 0.3d && !z) {
            this.roll += this.g;
        }
    }

    @NotNull
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.CUSTOM;
    }

    public void render(@NotNull VertexConsumer vertexConsumer, Camera camera, float f) {
        Vec3 position = camera.getPosition();
        float f2 = (float) ((this.xo + ((this.x - this.xo) * ((double) f))) - position.x);
        float f3 = (float) ((this.yo + ((this.y - this.yo) * ((double) f))) - position.y);
        float f4 = (float) ((this.zo + ((this.z - this.zo) * ((double) f))) - position.z);
        Minecraft minecraft = Minecraft.getInstance();
        Font font = minecraft.font;
        MultiBufferSource.BufferSource bufferSource = minecraft.renderBuffers().bufferSource();
        RenderSystem.disableCull();
        Matrix4f matrix4f = new Matrix4f();
        matrix4f.translation(f2, f3, f4).rotate(camera.rotation()).rotateZ(this.roll).rotate(3.1415927f, 0.0f, 1.0f, 0.0f);
        matrix4f.scale(-this.d, -this.d, this.d);
        a(font, bufferSource, matrix4f, this.a, (-font.width(this.a)) / 2.0f, 0.0f, mctech.utils.math.a.a(this.rCol, this.gCol, this.bCol, this.alpha));
        RenderSystem.enableCull();
        bufferSource.endBatch();
    }

    private void a(Font font, MultiBufferSource.BufferSource bufferSource, Matrix4f matrix4f, String str, float f, float f2, int i) {
        font.drawInBatch(str, f, f2, i, false, matrix4f, bufferSource, Font.DisplayMode.NORMAL, 0, 15728880);
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/g/b$a.class */
    public static class a implements ParticleProvider<c> {
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Particle createParticle(@NotNull c cVar, @NotNull ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6) {
            LivingEntity entity = clientLevel.getEntity(cVar.a());
            if (!(entity instanceof LivingEntity)) {
                return null;
            }
            LivingEntity livingEntity = entity;
            Vec3 vec3 = new Vec3(livingEntity.getX(), livingEntity.getY() + (((double) livingEntity.getBbHeight()) * 0.7d) + 0.4d, livingEntity.getZ());
            boolean zNextBoolean = clientLevel.random.nextBoolean();
            return new b(clientLevel, vec3, entity.getDeltaMovement().add(clientLevel.random.nextDouble() * ((double) (zNextBoolean ? -1 : 1)), clientLevel.random.nextDouble(), clientLevel.random.nextDouble() * ((double) (zNextBoolean ? -1 : 1))), cVar);
        }
    }
}
