package mctech.g.b.a;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.List;
import mctech.MCTech;
import net.minecraft.core.Holder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/b/a/c.class */
public final class c extends Record implements CustomPacketPayload {
    private final int c;
    private final List<Holder<mctech.g.a.a<?, ?>>> d;
    public static final CustomPacketPayload.Type<c> a = new CustomPacketPayload.Type<>(MCTech.loc("conduit_list"));
    public static final StreamCodec<RegistryFriendlyByteBuf, c> b = StreamCodec.composite(ByteBufCodecs.INT, (v0) -> {
        return v0.a();
    }, mctech.g.a.a.c.apply(ByteBufCodecs.list(9)), (v0) -> {
        return v0.b();
    }, (v1, v2) -> {
        return new c(v1, v2);
    });

    public c(int i, List<Holder<mctech.g.a.a<?, ?>>> list) {
        this.c = i;
        this.d = list;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, c.class), c.class, "containerId;conduits", "FIELD:Lmctech/g/b/a/c;->c:I", "FIELD:Lmctech/g/b/a/c;->d:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, c.class), c.class, "containerId;conduits", "FIELD:Lmctech/g/b/a/c;->c:I", "FIELD:Lmctech/g/b/a/c;->d:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, c.class, Object.class), c.class, "containerId;conduits", "FIELD:Lmctech/g/b/a/c;->c:I", "FIELD:Lmctech/g/b/a/c;->d:Ljava/util/List;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public int a() {
        return this.c;
    }

    public List<Holder<mctech.g.a.a<?, ?>>> b() {
        return this.d;
    }

    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return a;
    }
}
