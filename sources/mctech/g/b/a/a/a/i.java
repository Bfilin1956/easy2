package mctech.g.b.a.a.a;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/b/a/a/a/i.class */
public final class i extends Record implements l {
    public static final StreamCodec<RegistryFriendlyByteBuf, i> a = StreamCodec.of((registryFriendlyByteBuf, iVar) -> {
    }, registryFriendlyByteBuf2 -> {
        return new i();
    });

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, i.class), i.class, "").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, i.class), i.class, "").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, i.class, Object.class), i.class, "").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @Override // mctech.g.b.a.a.a.l
    public m a() {
        return m.NULL;
    }
}
