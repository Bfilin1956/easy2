package mctech.g.d.a.d.g;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import mctech.g.a.c.e;
import mctech.g.a.c.g;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.DyeColor;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/a/d/g/b.class */
public final class b extends Record implements g {
    private final boolean g;
    private final DyeColor h;
    private final boolean i;
    private final DyeColor j;
    private final boolean k;
    public static final b c = new b(false, DyeColor.GREEN, true, DyeColor.RED, false);
    public static final MapCodec<b> d = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Codec.BOOL.fieldOf("is_insert").forGetter((v0) -> {
            return v0.e();
        }), DyeColor.CODEC.fieldOf("insert_channel").forGetter((v0) -> {
            return v0.g();
        }), Codec.BOOL.fieldOf("is_extract").forGetter((v0) -> {
            return v0.f();
        }), DyeColor.CODEC.fieldOf("extract_channel").forGetter((v0) -> {
            return v0.h();
        }), Codec.BOOL.fieldOf("is_strong_output_signal").forGetter((v0) -> {
            return v0.i();
        })).apply(instance, (v1, v2, v3, v4, v5) -> {
            return new b(v1, v2, v3, v4, v5);
        });
    });
    public static final StreamCodec<ByteBuf, b> e = StreamCodec.composite(ByteBufCodecs.BOOL, (v0) -> {
        return v0.e();
    }, DyeColor.STREAM_CODEC, (v0) -> {
        return v0.g();
    }, ByteBufCodecs.BOOL, (v0) -> {
        return v0.f();
    }, DyeColor.STREAM_CODEC, (v0) -> {
        return v0.h();
    }, ByteBufCodecs.BOOL, (v0) -> {
        return v0.i();
    }, (v1, v2, v3, v4, v5) -> {
        return new b(v1, v2, v3, v4, v5);
    });
    public static final e<b> f = new e<>(d, e.cast(), () -> {
        return c;
    });

    public b(boolean z, DyeColor dyeColor, boolean z2, DyeColor dyeColor2, boolean z3) {
        this.g = z;
        this.h = dyeColor;
        this.i = z2;
        this.j = dyeColor2;
        this.k = z3;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, b.class), b.class, "isInsert;insertChannel;isExtract;extractChannel;isStrongOutputSignal", "FIELD:Lmctech/g/d/a/d/g/b;->g:Z", "FIELD:Lmctech/g/d/a/d/g/b;->h:Lnet/minecraft/world/item/DyeColor;", "FIELD:Lmctech/g/d/a/d/g/b;->i:Z", "FIELD:Lmctech/g/d/a/d/g/b;->j:Lnet/minecraft/world/item/DyeColor;", "FIELD:Lmctech/g/d/a/d/g/b;->k:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, b.class), b.class, "isInsert;insertChannel;isExtract;extractChannel;isStrongOutputSignal", "FIELD:Lmctech/g/d/a/d/g/b;->g:Z", "FIELD:Lmctech/g/d/a/d/g/b;->h:Lnet/minecraft/world/item/DyeColor;", "FIELD:Lmctech/g/d/a/d/g/b;->i:Z", "FIELD:Lmctech/g/d/a/d/g/b;->j:Lnet/minecraft/world/item/DyeColor;", "FIELD:Lmctech/g/d/a/d/g/b;->k:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, b.class, Object.class), b.class, "isInsert;insertChannel;isExtract;extractChannel;isStrongOutputSignal", "FIELD:Lmctech/g/d/a/d/g/b;->g:Z", "FIELD:Lmctech/g/d/a/d/g/b;->h:Lnet/minecraft/world/item/DyeColor;", "FIELD:Lmctech/g/d/a/d/g/b;->i:Z", "FIELD:Lmctech/g/d/a/d/g/b;->j:Lnet/minecraft/world/item/DyeColor;", "FIELD:Lmctech/g/d/a/d/g/b;->k:Z").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @Override // mctech.g.a.c.g
    public boolean e() {
        return this.g;
    }

    @Override // mctech.g.a.c.g
    public DyeColor g() {
        return this.h;
    }

    @Override // mctech.g.a.c.g
    public boolean f() {
        return this.i;
    }

    @Override // mctech.g.a.c.g
    public DyeColor h() {
        return this.j;
    }

    public boolean i() {
        return this.k;
    }

    @Override // mctech.g.a.c.c
    public mctech.g.a.c.c c() {
        return new b(c.g, this.h, c.i, this.j, this.k);
    }

    @Override // mctech.g.a.c.c
    public mctech.g.a.c.c d() {
        return new b(false, this.h, false, this.j, this.k);
    }

    public b a(boolean z) {
        return new b(z, this.h, this.i, this.j, this.k);
    }

    public b a(DyeColor dyeColor) {
        return new b(this.g, dyeColor, this.i, this.j, this.k);
    }

    public b b(boolean z) {
        return new b(this.g, this.h, z, this.j, this.k);
    }

    public b b(DyeColor dyeColor) {
        return new b(this.g, this.h, this.i, dyeColor, this.k);
    }

    public b c(boolean z) {
        return new b(this.g, this.h, this.i, this.j, z);
    }

    @Override // mctech.g.a.c.c
    public e<b> a() {
        return f;
    }
}
