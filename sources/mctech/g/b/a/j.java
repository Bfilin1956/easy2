package mctech.g.b.a;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.ArrayList;
import java.util.List;
import mctech.MCTech;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/b/a/j.class */
public final class j extends Record implements CustomPacketPayload {
    private final List<i> c;
    public static final CustomPacketPayload.Type<j> a = new CustomPacketPayload.Type<>(MCTech.loc("emit_particles"));
    public static final StreamCodec<RegistryFriendlyByteBuf, j> b = i.b.apply(ByteBufCodecs.list()).map(j::new, (v0) -> {
        return v0.a();
    });

    public j(List<i> list) {
        this.c = list;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, j.class), j.class, "particles", "FIELD:Lmctech/g/b/a/j;->c:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, j.class), j.class, "particles", "FIELD:Lmctech/g/b/a/j;->c:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, j.class, Object.class), j.class, "particles", "FIELD:Lmctech/g/b/a/j;->c:Ljava/util/List;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public List<i> a() {
        return this.c;
    }

    public j() {
        this(new ArrayList());
    }

    public CustomPacketPayload.Type<j> type() {
        return a;
    }

    public void a(i iVar) {
        this.c.add(iVar);
    }

    public void a(ParticleOptions particleOptions, double d, double d2, double d3) {
        a(particleOptions, d, d2, d3, 0.0d, 0.0d, 0.0d);
    }

    public void a(ParticleOptions particleOptions, double d, double d2, double d3, double d4, double d5, double d6) {
        a(new i(particleOptions, d, d2, d3, d4, d5, d6));
    }

    public void a(BlockPos blockPos, ParticleOptions particleOptions) {
        a(new i(particleOptions, blockPos));
    }
}
