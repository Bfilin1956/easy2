package mctech.g.d.a.d.f;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/a/d/f/e.class */
public final class e extends Record implements mctech.g.a.c.c {
    private final boolean g;
    public static final e c = new e(true);
    public static final MapCodec<e> d = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Codec.BOOL.fieldOf("isConnected").forGetter((v0) -> {
            return v0.ac_();
        })).apply(instance, (v1) -> {
            return new e(v1);
        });
    });
    public static final StreamCodec<ByteBuf, e> e = ByteBufCodecs.BOOL.map((v1) -> {
        return new e(v1);
    }, (v0) -> {
        return v0.ac_();
    });
    public static final mctech.g.a.c.e<e> f = new mctech.g.a.c.e<>(d, e.cast(), () -> {
        return c;
    });

    public e(boolean z) {
        this.g = z;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, e.class), e.class, "isConnected", "FIELD:Lmctech/g/d/a/d/f/e;->g:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, e.class), e.class, "isConnected", "FIELD:Lmctech/g/d/a/d/f/e;->g:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, e.class, Object.class), e.class, "isConnected", "FIELD:Lmctech/g/d/a/d/f/e;->g:Z").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @Override // mctech.g.a.c.c
    public boolean ac_() {
        return this.g;
    }

    @Override // mctech.g.a.c.c
    public mctech.g.a.c.e<?> a() {
        return f;
    }

    @Override // mctech.g.a.c.c
    public mctech.g.a.c.c c() {
        return new e(true);
    }

    @Override // mctech.g.a.c.c
    public mctech.g.a.c.c d() {
        return new e(false);
    }
}
