package mctech.g.b.a.a.a;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.List;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/b/a/a/a/g.class */
public final class g extends Record implements l {
    private final List<l> c;
    public static final StreamCodec<RegistryFriendlyByteBuf, g> a = l.b.apply(ByteBufCodecs.list()).map(g::new, (v0) -> {
        return v0.b();
    });

    public g(List<l> list) {
        this.c = list;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, g.class), g.class, "contents", "FIELD:Lmctech/g/b/a/a/a/g;->c:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, g.class), g.class, "contents", "FIELD:Lmctech/g/b/a/a/a/g;->c:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, g.class, Object.class), g.class, "contents", "FIELD:Lmctech/g/b/a/a/a/g;->c:Ljava/util/List;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public List<l> b() {
        return this.c;
    }

    @Override // mctech.g.b.a.a.a.l
    public m a() {
        return m.LIST;
    }
}
