package mctech.g.b.a;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import mctech.MCTech;
import net.minecraft.core.BlockPos;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/b/a/r.class */
public final class r extends Record implements CustomPacketPayload {
    private final BlockPos c;
    public static final CustomPacketPayload.Type<r> a = new CustomPacketPayload.Type<>(MCTech.loc("destroy_bundle"));
    public static final StreamCodec<RegistryFriendlyByteBuf, r> b = StreamCodec.composite(BlockPos.STREAM_CODEC, (v0) -> {
        return v0.a();
    }, r::new);

    public r(BlockPos blockPos) {
        this.c = blockPos;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, r.class), r.class, "pos", "FIELD:Lmctech/g/b/a/r;->c:Lnet/minecraft/core/BlockPos;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, r.class), r.class, "pos", "FIELD:Lmctech/g/b/a/r;->c:Lnet/minecraft/core/BlockPos;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, r.class, Object.class), r.class, "pos", "FIELD:Lmctech/g/b/a/r;->c:Lnet/minecraft/core/BlockPos;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public BlockPos a() {
        return this.c;
    }

    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return a;
    }
}
