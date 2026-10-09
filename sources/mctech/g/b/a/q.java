package mctech.g.b.a;

import io.netty.buffer.ByteBuf;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import mctech.MCTech;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/b/a/q.class */
public final class q extends Record implements CustomPacketPayload {
    private final BlockPos c;
    private final Direction d;
    public static final CustomPacketPayload.Type<q> a = new CustomPacketPayload.Type<>(MCTech.loc("cycle_io_config"));
    public static final StreamCodec<ByteBuf, q> b = StreamCodec.composite(BlockPos.STREAM_CODEC, (v0) -> {
        return v0.a();
    }, Direction.STREAM_CODEC, (v0) -> {
        return v0.b();
    }, q::new);

    public q(BlockPos blockPos, Direction direction) {
        this.c = blockPos;
        this.d = direction;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, q.class), q.class, "pos;side", "FIELD:Lmctech/g/b/a/q;->c:Lnet/minecraft/core/BlockPos;", "FIELD:Lmctech/g/b/a/q;->d:Lnet/minecraft/core/Direction;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, q.class), q.class, "pos;side", "FIELD:Lmctech/g/b/a/q;->c:Lnet/minecraft/core/BlockPos;", "FIELD:Lmctech/g/b/a/q;->d:Lnet/minecraft/core/Direction;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, q.class, Object.class), q.class, "pos;side", "FIELD:Lmctech/g/b/a/q;->c:Lnet/minecraft/core/BlockPos;", "FIELD:Lmctech/g/b/a/q;->d:Lnet/minecraft/core/Direction;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public BlockPos a() {
        return this.c;
    }

    public Direction b() {
        return this.d;
    }

    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return a;
    }
}
