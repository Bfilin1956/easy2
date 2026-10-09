package mctech.v.g;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import mctech.init.MCTechParticles;
import net.minecraft.core.Holder;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.damagesource.DamageType;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/g/c.class */
public final class c extends Record implements ParticleOptions {
    private final int c;
    private final float d;
    private final float e;
    private final boolean f;
    private final Holder<DamageType> g;
    public static final MapCodec<c> a = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Codec.INT.fieldOf("entityId").forGetter((v0) -> {
            return v0.a();
        }), Codec.FLOAT.fieldOf("damage").forGetter((v0) -> {
            return v0.b();
        }), Codec.FLOAT.fieldOf("maximumDamage").forGetter((v0) -> {
            return v0.c();
        }), Codec.BOOL.fieldOf("crit").forGetter((v0) -> {
            return v0.d();
        }), DamageType.CODEC.fieldOf("type").forGetter((v0) -> {
            return v0.e();
        })).apply(instance, (v1, v2, v3, v4, v5) -> {
            return new c(v1, v2, v3, v4, v5);
        });
    });
    public static final StreamCodec<RegistryFriendlyByteBuf, c> b = StreamCodec.composite(ByteBufCodecs.INT, (v0) -> {
        return v0.a();
    }, ByteBufCodecs.FLOAT, (v0) -> {
        return v0.b();
    }, ByteBufCodecs.FLOAT, (v0) -> {
        return v0.c();
    }, ByteBufCodecs.BOOL, (v0) -> {
        return v0.d();
    }, DamageType.STREAM_CODEC, (v0) -> {
        return v0.e();
    }, (v1, v2, v3, v4, v5) -> {
        return new c(v1, v2, v3, v4, v5);
    });

    public c(int i, float f, float f2, boolean z, Holder<DamageType> holder) {
        this.c = i;
        this.d = f;
        this.e = f2;
        this.f = z;
        this.g = holder;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, c.class), c.class, "entityId;damage;maximumDamage;crit;damageType", "FIELD:Lmctech/v/g/c;->c:I", "FIELD:Lmctech/v/g/c;->d:F", "FIELD:Lmctech/v/g/c;->e:F", "FIELD:Lmctech/v/g/c;->f:Z", "FIELD:Lmctech/v/g/c;->g:Lnet/minecraft/core/Holder;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, c.class), c.class, "entityId;damage;maximumDamage;crit;damageType", "FIELD:Lmctech/v/g/c;->c:I", "FIELD:Lmctech/v/g/c;->d:F", "FIELD:Lmctech/v/g/c;->e:F", "FIELD:Lmctech/v/g/c;->f:Z", "FIELD:Lmctech/v/g/c;->g:Lnet/minecraft/core/Holder;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, c.class, Object.class), c.class, "entityId;damage;maximumDamage;crit;damageType", "FIELD:Lmctech/v/g/c;->c:I", "FIELD:Lmctech/v/g/c;->d:F", "FIELD:Lmctech/v/g/c;->e:F", "FIELD:Lmctech/v/g/c;->f:Z", "FIELD:Lmctech/v/g/c;->g:Lnet/minecraft/core/Holder;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public int a() {
        return this.c;
    }

    public float b() {
        return this.d;
    }

    public float c() {
        return this.e;
    }

    public boolean d() {
        return this.f;
    }

    public Holder<DamageType> e() {
        return this.g;
    }

    @NotNull
    public ParticleType<?> getType() {
        return (ParticleType) MCTechParticles.DAMAGE_PARTICLE.get();
    }
}
