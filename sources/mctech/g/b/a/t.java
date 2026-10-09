package mctech.g.b.a;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import mctech.MCTech;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/b/a/t.class */
public final class t extends Record implements CustomPacketPayload {
    private final int c;
    private final int d;
    public static final CustomPacketPayload.Type<t> a = new CustomPacketPayload.Type<>(MCTech.loc("client_open_conduit_filter_menu"));
    public static final StreamCodec<RegistryFriendlyByteBuf, t> b = StreamCodec.composite(ByteBufCodecs.INT, (v0) -> {
        return v0.a();
    }, ByteBufCodecs.INT, (v0) -> {
        return v0.b();
    }, (v1, v2) -> {
        return new t(v1, v2);
    });

    public t(int i, int i2) {
        this.c = i;
        this.d = i2;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, t.class), t.class, "containerId;slot", "FIELD:Lmctech/g/b/a/t;->c:I", "FIELD:Lmctech/g/b/a/t;->d:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, t.class), t.class, "containerId;slot", "FIELD:Lmctech/g/b/a/t;->c:I", "FIELD:Lmctech/g/b/a/t;->d:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, t.class, Object.class), t.class, "containerId;slot", "FIELD:Lmctech/g/b/a/t;->c:I", "FIELD:Lmctech/g/b/a/t;->d:I").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
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
