package mctech.g.b.a.a.a;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/b/a/a/a/j.class */
public final class j extends Record implements l {
    private final l c;
    private final l d;
    public static final StreamCodec<RegistryFriendlyByteBuf, j> a = StreamCodec.composite(l.b, (v0) -> {
        return v0.b();
    }, l.b, (v0) -> {
        return v0.c();
    }, j::new);

    public j(l lVar, l lVar2) {
        this.c = lVar;
        this.d = lVar2;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, j.class), j.class, "left;right", "FIELD:Lmctech/g/b/a/a/a/j;->c:Lmctech/g/b/a/a/a/l;", "FIELD:Lmctech/g/b/a/a/a/j;->d:Lmctech/g/b/a/a/a/l;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, j.class), j.class, "left;right", "FIELD:Lmctech/g/b/a/a/a/j;->c:Lmctech/g/b/a/a/a/l;", "FIELD:Lmctech/g/b/a/a/a/j;->d:Lmctech/g/b/a/a/a/l;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, j.class, Object.class), j.class, "left;right", "FIELD:Lmctech/g/b/a/a/a/j;->c:Lmctech/g/b/a/a/a/l;", "FIELD:Lmctech/g/b/a/a/a/j;->d:Lmctech/g/b/a/a/a/l;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public l b() {
        return this.c;
    }

    public l c() {
        return this.d;
    }

    @Override // mctech.g.b.a.a.a.l
    public m a() {
        return m.PAIR;
    }
}
