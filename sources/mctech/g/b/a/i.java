package mctech.g.b.a;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import mctech.MCTech;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.codec.NeoForgeStreamCodecs;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/b/a/i.class */
public final class i extends Record implements CustomPacketPayload {
    private final ParticleOptions c;
    private final double d;
    private final double e;
    private final double f;
    private final double g;
    private final double h;
    private final double i;
    public static final CustomPacketPayload.Type<i> a = new CustomPacketPayload.Type<>(MCTech.loc("emit_particle"));
    public static final StreamCodec<RegistryFriendlyByteBuf, i> b = NeoForgeStreamCodecs.composite(ParticleTypes.STREAM_CODEC, (v0) -> {
        return v0.a();
    }, ByteBufCodecs.DOUBLE, (v0) -> {
        return v0.b();
    }, ByteBufCodecs.DOUBLE, (v0) -> {
        return v0.c();
    }, ByteBufCodecs.DOUBLE, (v0) -> {
        return v0.d();
    }, ByteBufCodecs.DOUBLE, (v0) -> {
        return v0.e();
    }, ByteBufCodecs.DOUBLE, (v0) -> {
        return v0.f();
    }, ByteBufCodecs.DOUBLE, (v0) -> {
        return v0.g();
    }, (v1, v2, v3, v4, v5, v6, v7) -> {
        return new i(v1, v2, v3, v4, v5, v6, v7);
    });

    public i(ParticleOptions particleOptions, double d, double d2, double d3, double d4, double d5, double d6) {
        this.c = particleOptions;
        this.d = d;
        this.e = d2;
        this.f = d3;
        this.g = d4;
        this.h = d5;
        this.i = d6;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, i.class), i.class, "particleOptions;x;y;z;xSpeed;ySpeed;zSpeed", "FIELD:Lmctech/g/b/a/i;->c:Lnet/minecraft/core/particles/ParticleOptions;", "FIELD:Lmctech/g/b/a/i;->d:D", "FIELD:Lmctech/g/b/a/i;->e:D", "FIELD:Lmctech/g/b/a/i;->f:D", "FIELD:Lmctech/g/b/a/i;->g:D", "FIELD:Lmctech/g/b/a/i;->h:D", "FIELD:Lmctech/g/b/a/i;->i:D").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, i.class), i.class, "particleOptions;x;y;z;xSpeed;ySpeed;zSpeed", "FIELD:Lmctech/g/b/a/i;->c:Lnet/minecraft/core/particles/ParticleOptions;", "FIELD:Lmctech/g/b/a/i;->d:D", "FIELD:Lmctech/g/b/a/i;->e:D", "FIELD:Lmctech/g/b/a/i;->f:D", "FIELD:Lmctech/g/b/a/i;->g:D", "FIELD:Lmctech/g/b/a/i;->h:D", "FIELD:Lmctech/g/b/a/i;->i:D").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, i.class, Object.class), i.class, "particleOptions;x;y;z;xSpeed;ySpeed;zSpeed", "FIELD:Lmctech/g/b/a/i;->c:Lnet/minecraft/core/particles/ParticleOptions;", "FIELD:Lmctech/g/b/a/i;->d:D", "FIELD:Lmctech/g/b/a/i;->e:D", "FIELD:Lmctech/g/b/a/i;->f:D", "FIELD:Lmctech/g/b/a/i;->g:D", "FIELD:Lmctech/g/b/a/i;->h:D", "FIELD:Lmctech/g/b/a/i;->i:D").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public ParticleOptions a() {
        return this.c;
    }

    public double b() {
        return this.d;
    }

    public double c() {
        return this.e;
    }

    public double d() {
        return this.f;
    }

    public double e() {
        return this.g;
    }

    public double f() {
        return this.h;
    }

    public double g() {
        return this.i;
    }

    public i(ParticleOptions particleOptions, BlockPos blockPos) {
        this(particleOptions, ((double) blockPos.getX()) + 0.5d, ((double) blockPos.getY()) + 0.5d, ((double) blockPos.getZ()) + 0.5d, 0.0d, 0.0d, 0.0d);
    }

    public i(ParticleOptions particleOptions, BlockPos blockPos, double d, double d2, double d3) {
        this(particleOptions, ((double) blockPos.getX()) + 0.5d, ((double) blockPos.getY()) + 0.5d, ((double) blockPos.getZ()) + 0.5d, d, d2, d3);
    }

    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return a;
    }
}
