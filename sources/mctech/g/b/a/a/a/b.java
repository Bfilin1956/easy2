package mctech.g.b.a.a.a;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/b/a/a/a/b.class */
public final class b extends Record implements l {
    private final boolean c;
    public static final StreamCodec<RegistryFriendlyByteBuf, b> a = ByteBufCodecs.BOOL.map((v1) -> {
        return new b(v1);
    }, (v0) -> {
        return v0.b();
    }).cast();

    public b(boolean z) {
        this.c = z;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, b.class), b.class, "value", "FIELD:Lmctech/g/b/a/a/a/b;->c:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, b.class), b.class, "value", "FIELD:Lmctech/g/b/a/a/a/b;->c:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, b.class, Object.class), b.class, "value", "FIELD:Lmctech/g/b/a/a/a/b;->c:Z").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public boolean b() {
        return this.c;
    }

    @Override // mctech.g.b.a.a.a.l
    public m a() {
        return m.BOOL;
    }
}
