package mctech.g.b.a.a;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import mctech.MCTech;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/b/a/a/k.class */
public final class k extends Record implements CustomPacketPayload {
    private final int c;
    private final short d;
    private final mctech.g.b.a.a.a.l e;
    public static final CustomPacketPayload.Type<k> a = new CustomPacketPayload.Type<>(MCTech.loc("set_slot_data"));
    public static final StreamCodec<RegistryFriendlyByteBuf, k> b = StreamCodec.composite(ByteBufCodecs.INT, (v0) -> {
        return v0.a();
    }, ByteBufCodecs.SHORT, (v0) -> {
        return v0.b();
    }, mctech.g.b.a.a.a.l.b, (v0) -> {
        return v0.c();
    }, (v1, v2, v3) -> {
        return new k(v1, v2, v3);
    });

    public k(int i, short s, mctech.g.b.a.a.a.l lVar) {
        this.c = i;
        this.d = s;
        this.e = lVar;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, k.class), k.class, "containerId;index;payload", "FIELD:Lmctech/g/b/a/a/k;->c:I", "FIELD:Lmctech/g/b/a/a/k;->d:S", "FIELD:Lmctech/g/b/a/a/k;->e:Lmctech/g/b/a/a/a/l;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, k.class), k.class, "containerId;index;payload", "FIELD:Lmctech/g/b/a/a/k;->c:I", "FIELD:Lmctech/g/b/a/a/k;->d:S", "FIELD:Lmctech/g/b/a/a/k;->e:Lmctech/g/b/a/a/a/l;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, k.class, Object.class), k.class, "containerId;index;payload", "FIELD:Lmctech/g/b/a/a/k;->c:I", "FIELD:Lmctech/g/b/a/a/k;->d:S", "FIELD:Lmctech/g/b/a/a/k;->e:Lmctech/g/b/a/a/a/l;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public int a() {
        return this.c;
    }

    public short b() {
        return this.d;
    }

    public mctech.g.b.a.a.a.l c() {
        return this.e;
    }

    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return a;
    }
}
