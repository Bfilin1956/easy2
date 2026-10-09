package mctech.g.b.a.a.a;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/b/a/a/a/e.class */
public final class e extends Record implements l {
    private final int c;
    public static final StreamCodec<RegistryFriendlyByteBuf, e> a = ByteBufCodecs.INT.map((v1) -> {
        return new e(v1);
    }, (v0) -> {
        return v0.b();
    }).cast();

    public e(int i) {
        this.c = i;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, e.class), e.class, "value", "FIELD:Lmctech/g/b/a/a/a/e;->c:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, e.class), e.class, "value", "FIELD:Lmctech/g/b/a/a/a/e;->c:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, e.class, Object.class), e.class, "value", "FIELD:Lmctech/g/b/a/a/a/e;->c:I").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public int b() {
        return this.c;
    }

    @Override // mctech.g.b.a.a.a.l
    public m a() {
        return m.INT;
    }
}
