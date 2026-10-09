package mctech.g.b.a.a;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.List;
import mctech.MCTech;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/b/a/a/c.class */
public final class c extends Record implements CustomPacketPayload {
    private final int c;
    private final List<a> d;
    public static final CustomPacketPayload.Type<c> a = new CustomPacketPayload.Type<>(MCTech.loc("sync_slot_data"));
    public static final StreamCodec<RegistryFriendlyByteBuf, c> b = StreamCodec.composite(ByteBufCodecs.INT, (v0) -> {
        return v0.a();
    }, a.a.apply(ByteBufCodecs.list()), (v0) -> {
        return v0.b();
    }, (v1, v2) -> {
        return new c(v1, v2);
    });

    public c(int i, List<a> list) {
        this.c = i;
        this.d = list;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, c.class), c.class, "containerId;payloads", "FIELD:Lmctech/g/b/a/a/c;->c:I", "FIELD:Lmctech/g/b/a/a/c;->d:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, c.class), c.class, "containerId;payloads", "FIELD:Lmctech/g/b/a/a/c;->c:I", "FIELD:Lmctech/g/b/a/a/c;->d:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, c.class, Object.class), c.class, "containerId;payloads", "FIELD:Lmctech/g/b/a/a/c;->c:I", "FIELD:Lmctech/g/b/a/a/c;->d:Ljava/util/List;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public int a() {
        return this.c;
    }

    public List<a> b() {
        return this.d;
    }

    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return a;
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/b/a/a/c$a.class */
    public static final class a extends Record {
        private final short b;
        private final mctech.g.b.a.a.a.l c;
        public static final StreamCodec<RegistryFriendlyByteBuf, a> a = StreamCodec.composite(ByteBufCodecs.SHORT, (v0) -> {
            return v0.a();
        }, mctech.g.b.a.a.a.l.b, (v0) -> {
            return v0.b();
        }, (v1, v2) -> {
            return new a(v1, v2);
        });

        public a(short s, mctech.g.b.a.a.a.l lVar) {
            this.b = s;
            this.c = lVar;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "index;payload", "FIELD:Lmctech/g/b/a/a/c$a;->b:S", "FIELD:Lmctech/g/b/a/a/c$a;->c:Lmctech/g/b/a/a/a/l;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "index;payload", "FIELD:Lmctech/g/b/a/a/c$a;->b:S", "FIELD:Lmctech/g/b/a/a/c$a;->c:Lmctech/g/b/a/a/a/l;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "index;payload", "FIELD:Lmctech/g/b/a/a/c$a;->b:S", "FIELD:Lmctech/g/b/a/a/c$a;->c:Lmctech/g/b/a/a/a/l;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        public short a() {
            return this.b;
        }

        public mctech.g.b.a.a.a.l b() {
            return this.c;
        }
    }
}
