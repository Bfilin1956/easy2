package mctech.g.d.a.d.d;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import mctech.g.a.c.e;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/a/d/d/b.class */
public final class b extends Record implements mctech.g.a.c.c {
    private final boolean g;
    public static final b c = new b(true);
    public static final MapCodec<b> d = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Codec.BOOL.fieldOf("isConnected").forGetter((v0) -> {
            return v0.ac_();
        })).apply(instance, (v1) -> {
            return new b(v1);
        });
    });
    public static final StreamCodec<ByteBuf, b> e = ByteBufCodecs.BOOL.map((v1) -> {
        return new b(v1);
    }, (v0) -> {
        return v0.ac_();
    });
    public static final e<b> f = new e<>(d, e.cast(), () -> {
        return c;
    });

    public b(boolean z) {
        this.g = z;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, b.class), b.class, "isConnected", "FIELD:Lmctech/g/d/a/d/d/b;->g:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, b.class), b.class, "isConnected", "FIELD:Lmctech/g/d/a/d/d/b;->g:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, b.class, Object.class), b.class, "isConnected", "FIELD:Lmctech/g/d/a/d/d/b;->g:Z").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @Override // mctech.g.a.c.c
    public boolean ac_() {
        return this.g;
    }

    @Override // mctech.g.a.c.c
    public e<?> a() {
        return f;
    }

    @Override // mctech.g.a.c.c
    public mctech.g.a.c.c c() {
        return new b(true);
    }

    @Override // mctech.g.a.c.c
    public mctech.g.a.c.c d() {
        return new b(false);
    }
}
