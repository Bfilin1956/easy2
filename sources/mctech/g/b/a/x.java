package mctech.g.b.a;

import io.netty.buffer.ByteBuf;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import mctech.MCTech;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/b/a/x.class */
public final class x extends Record implements CustomPacketPayload {
    private final int c;
    private final int d;
    public static final CustomPacketPayload.Type<x> a = new CustomPacketPayload.Type<>(MCTech.loc("timer_filter_packet"));
    public static final StreamCodec<ByteBuf, x> b = StreamCodec.composite(ByteBufCodecs.VAR_INT, (v0) -> {
        return v0.a();
    }, ByteBufCodecs.VAR_INT, (v0) -> {
        return v0.b();
    }, (v1, v2) -> {
        return new x(v1, v2);
    });

    public x(int i, int i2) {
        this.c = i;
        this.d = i2;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, x.class), x.class, "ticks;maxTicks", "FIELD:Lmctech/g/b/a/x;->c:I", "FIELD:Lmctech/g/b/a/x;->d:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, x.class), x.class, "ticks;maxTicks", "FIELD:Lmctech/g/b/a/x;->c:I", "FIELD:Lmctech/g/b/a/x;->d:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, x.class, Object.class), x.class, "ticks;maxTicks", "FIELD:Lmctech/g/b/a/x;->c:I", "FIELD:Lmctech/g/b/a/x;->d:I").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public int a() {
        return this.c;
    }

    public int b() {
        return this.d;
    }

    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return a;
    }
}
