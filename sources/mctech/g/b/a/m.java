package mctech.g.b.a;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import mctech.MCTech;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/b/a/m.class */
public final class m extends Record implements CustomPacketPayload {
    private final BlockPos c;
    private final Holder<mctech.g.a.a<?, ?>> d;
    public static final CustomPacketPayload.Type<m> a = new CustomPacketPayload.Type<>(MCTech.loc("break_conduit"));
    public static final StreamCodec<RegistryFriendlyByteBuf, m> b = StreamCodec.composite(BlockPos.STREAM_CODEC, (v0) -> {
        return v0.a();
    }, ByteBufCodecs.holderRegistry(mctech.g.a.l.a.f), (v0) -> {
        return v0.b();
    }, m::new);

    public m(BlockPos blockPos, Holder<mctech.g.a.a<?, ?>> holder) {
        this.c = blockPos;
        this.d = holder;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, m.class), m.class, "pos;conduit", "FIELD:Lmctech/g/b/a/m;->c:Lnet/minecraft/core/BlockPos;", "FIELD:Lmctech/g/b/a/m;->d:Lnet/minecraft/core/Holder;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, m.class), m.class, "pos;conduit", "FIELD:Lmctech/g/b/a/m;->c:Lnet/minecraft/core/BlockPos;", "FIELD:Lmctech/g/b/a/m;->d:Lnet/minecraft/core/Holder;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, m.class, Object.class), m.class, "pos;conduit", "FIELD:Lmctech/g/b/a/m;->c:Lnet/minecraft/core/BlockPos;", "FIELD:Lmctech/g/b/a/m;->d:Lnet/minecraft/core/Holder;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public BlockPos a() {
        return this.c;
    }

    public Holder<mctech.g.a.a<?, ?>> b() {
        return this.d;
    }

    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return a;
    }
}
