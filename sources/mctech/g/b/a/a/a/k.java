package mctech.g.b.a.a.a;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/b/a/a/a/k.class */
public final class k extends Record implements l {
    private final ResourceLocation c;
    public static final StreamCodec<RegistryFriendlyByteBuf, k> a = ResourceLocation.STREAM_CODEC.map(k::new, (v0) -> {
        return v0.b();
    }).cast();

    public k(ResourceLocation resourceLocation) {
        this.c = resourceLocation;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, k.class), k.class, "value", "FIELD:Lmctech/g/b/a/a/a/k;->c:Lnet/minecraft/resources/ResourceLocation;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, k.class), k.class, "value", "FIELD:Lmctech/g/b/a/a/a/k;->c:Lnet/minecraft/resources/ResourceLocation;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, k.class, Object.class), k.class, "value", "FIELD:Lmctech/g/b/a/a/a/k;->c:Lnet/minecraft/resources/ResourceLocation;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public ResourceLocation b() {
        return this.c;
    }

    @Override // mctech.g.b.a.a.a.l
    public m a() {
        return m.RESOURCE_LOCATION;
    }
}
