package mctech.g.b.a;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import mctech.MCTech;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/b/a/y.class */
public final class y extends Record implements CustomPacketPayload {
    private final int c;
    private final mctech.g.a.c.c d;
    public static final CustomPacketPayload.Type<y> a = new CustomPacketPayload.Type<>(MCTech.loc("client_set_conduit_connection_config"));
    public static final StreamCodec<RegistryFriendlyByteBuf, y> b = StreamCodec.composite(ByteBufCodecs.INT, (v0) -> {
        return v0.a();
    }, mctech.g.a.c.c.b, (v0) -> {
        return v0.b();
    }, (v1, v2) -> {
        return new y(v1, v2);
    });

    public y(int i, mctech.g.a.c.c cVar) {
        this.c = i;
        this.d = cVar;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, y.class), y.class, "containerId;connectionConfig", "FIELD:Lmctech/g/b/a/y;->c:I", "FIELD:Lmctech/g/b/a/y;->d:Lmctech/g/a/c/c;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, y.class), y.class, "containerId;connectionConfig", "FIELD:Lmctech/g/b/a/y;->c:I", "FIELD:Lmctech/g/b/a/y;->d:Lmctech/g/a/c/c;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, y.class, Object.class), y.class, "containerId;connectionConfig", "FIELD:Lmctech/g/b/a/y;->c:I", "FIELD:Lmctech/g/b/a/y;->d:Lmctech/g/a/c/c;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public int a() {
        return this.c;
    }

    public mctech.g.a.c.c b() {
        return this.d;
    }

    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return a;
    }
}
