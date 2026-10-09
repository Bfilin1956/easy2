package mctech.g.b.a.a.a;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/b/a/a/a/h.class */
public final class h extends Record implements l {
    private final long c;
    public static final StreamCodec<RegistryFriendlyByteBuf, h> a = ByteBufCodecs.VAR_LONG.map((v1) -> {
        return new h(v1);
    }, (v0) -> {
        return v0.b();
    }).cast();

    public h(long j) {
        this.c = j;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, h.class), h.class, "value", "FIELD:Lmctech/g/b/a/a/a/h;->c:J").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, h.class), h.class, "value", "FIELD:Lmctech/g/b/a/a/a/h;->c:J").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, h.class, Object.class), h.class, "value", "FIELD:Lmctech/g/b/a/a/a/h;->c:J").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public long b() {
        return this.c;
    }

    @Override // mctech.g.b.a.a.a.l
    public m a() {
        return m.LONG;
    }
}
