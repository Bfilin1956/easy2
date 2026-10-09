package mctech.g.b.a.a.a;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/b/a/a/a/n.class */
public final class n extends Record implements l {
    private final String c;
    public static final StreamCodec<RegistryFriendlyByteBuf, n> a = ByteBufCodecs.STRING_UTF8.map(n::new, (v0) -> {
        return v0.b();
    }).cast();

    public n(String str) {
        this.c = str;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, n.class), n.class, "value", "FIELD:Lmctech/g/b/a/a/a/n;->c:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, n.class), n.class, "value", "FIELD:Lmctech/g/b/a/a/a/n;->c:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, n.class, Object.class), n.class, "value", "FIELD:Lmctech/g/b/a/a/a/n;->c:Ljava/lang/String;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public String b() {
        return this.c;
    }

    @Override // mctech.g.b.a.a.a.l
    public m a() {
        return m.STRING;
    }
}
