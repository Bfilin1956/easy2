package mctech.g.b.a;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import mctech.MCTech;
import net.minecraft.core.BlockPos;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/b/a/u.class */
public final class u extends Record implements CustomPacketPayload {
    private final BlockPos c;
    public static final CustomPacketPayload.Type<u> a = new CustomPacketPayload.Type<>(MCTech.loc("remove_facade"));
    public static final StreamCodec<RegistryFriendlyByteBuf, u> b = StreamCodec.composite(BlockPos.STREAM_CODEC, (v0) -> {
        return v0.a();
    }, u::new);

    public u(BlockPos blockPos) {
        this.c = blockPos;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, u.class), u.class, "pos", "FIELD:Lmctech/g/b/a/u;->c:Lnet/minecraft/core/BlockPos;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, u.class), u.class, "pos", "FIELD:Lmctech/g/b/a/u;->c:Lnet/minecraft/core/BlockPos;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, u.class, Object.class), u.class, "pos", "FIELD:Lmctech/g/b/a/u;->c:Lnet/minecraft/core/BlockPos;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public BlockPos a() {
        return this.c;
    }

    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return a;
    }
}
