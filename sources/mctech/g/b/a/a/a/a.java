package mctech.g.b.a.a.a;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.core.BlockPos;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/b/a/a/a/a.class */
public final class a extends Record implements l {
    private final BlockPos c;
    public static final StreamCodec<RegistryFriendlyByteBuf, a> a = BlockPos.STREAM_CODEC.map(a::new, (v0) -> {
        return v0.b();
    }).cast();

    public a(BlockPos blockPos) {
        this.c = blockPos;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "value", "FIELD:Lmctech/g/b/a/a/a/a;->c:Lnet/minecraft/core/BlockPos;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "value", "FIELD:Lmctech/g/b/a/a/a/a;->c:Lnet/minecraft/core/BlockPos;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "value", "FIELD:Lmctech/g/b/a/a/a/a;->c:Lnet/minecraft/core/BlockPos;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public BlockPos b() {
        return this.c;
    }

    @Override // mctech.g.b.a.a.a.l
    public m a() {
        return m.BLOCK_POS;
    }
}
