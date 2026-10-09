package mctech.y;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.List;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.neoforged.neoforge.network.codec.NeoForgeStreamCodecs;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/y/f.class */
public final class f extends Record {
    private final c b;
    private final int c;
    private final List<a> d;
    public static final StreamCodec<RegistryFriendlyByteBuf, f> a = StreamCodec.composite(NeoForgeStreamCodecs.enumCodec(c.class), (v0) -> {
        return v0.a();
    }, ByteBufCodecs.INT, (v0) -> {
        return v0.b();
    }, a.b.apply(ByteBufCodecs.list()), (v0) -> {
        return v0.c();
    }, (v1, v2, v3) -> {
        return new f(v1, v2, v3);
    });

    public f(c cVar, int i, List<a> list) {
        this.b = cVar;
        this.c = i;
        this.d = list;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, f.class), f.class, "renderMode;scanRadius;blockAppearanceList", "FIELD:Lmctech/y/f;->b:Lmctech/y/c;", "FIELD:Lmctech/y/f;->c:I", "FIELD:Lmctech/y/f;->d:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, f.class), f.class, "renderMode;scanRadius;blockAppearanceList", "FIELD:Lmctech/y/f;->b:Lmctech/y/c;", "FIELD:Lmctech/y/f;->c:I", "FIELD:Lmctech/y/f;->d:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, f.class, Object.class), f.class, "renderMode;scanRadius;blockAppearanceList", "FIELD:Lmctech/y/f;->b:Lmctech/y/c;", "FIELD:Lmctech/y/f;->c:I", "FIELD:Lmctech/y/f;->d:Ljava/util/List;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public c a() {
        return this.b;
    }

    public int b() {
        return this.c;
    }

    public List<a> c() {
        return this.d;
    }
}
