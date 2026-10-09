package mctech.g.b.a;

import io.netty.buffer.ByteBuf;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import mctech.MCTech;
import net.minecraft.core.BlockPos;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/b/a/o.class */
public final class o extends Record implements CustomPacketPayload {
    private final BlockPos c;
    public static final CustomPacketPayload.Type<o> a = new CustomPacketPayload.Type<>(MCTech.loc("clear_locked_fluid"));
    public static final StreamCodec<ByteBuf, o> b = BlockPos.STREAM_CODEC.map(o::new, (v0) -> {
        return v0.a();
    });

    public o(BlockPos blockPos) {
        this.c = blockPos;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, o.class), o.class, "pos", "FIELD:Lmctech/g/b/a/o;->c:Lnet/minecraft/core/BlockPos;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, o.class), o.class, "pos", "FIELD:Lmctech/g/b/a/o;->c:Lnet/minecraft/core/BlockPos;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, o.class, Object.class), o.class, "pos", "FIELD:Lmctech/g/b/a/o;->c:Lnet/minecraft/core/BlockPos;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public BlockPos a() {
        return this.c;
    }

    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return a;
    }
}
