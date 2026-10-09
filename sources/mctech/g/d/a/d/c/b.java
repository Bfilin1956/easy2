package mctech.g.d.a.d.c;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.List;
import mctech.g.a.c.e;
import mctech.g.a.c.g;
import mctech.g.a.c.h;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.DyeColor;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/a/d/c/b.class */
public final class b extends Record implements g, h {
    private final boolean g;
    private final DyeColor h;
    private final boolean i;
    private final DyeColor j;
    private final mctech.g.a.f.a k;
    private final DyeColor l;
    private final int m;
    public static final b c = new b(false, DyeColor.GREEN, true, DyeColor.GREEN, mctech.g.a.f.a.NEVER_ACTIVE, DyeColor.RED, 0);
    public static final MapCodec<b> d = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Codec.BOOL.fieldOf("is_insert").forGetter((v0) -> {
            return v0.e();
        }), DyeColor.CODEC.fieldOf("insert_channel").forGetter((v0) -> {
            return v0.g();
        }), Codec.BOOL.fieldOf("is_extract").forGetter((v0) -> {
            return v0.f();
        }), DyeColor.CODEC.fieldOf("extract_channel").forGetter((v0) -> {
            return v0.h();
        }), mctech.g.a.f.a.e.fieldOf("extract_redstone_control").forGetter((v0) -> {
            return v0.i();
        }), DyeColor.CODEC.fieldOf("extract_redstone_channel").forGetter((v0) -> {
            return v0.j();
        }), Codec.INT.optionalFieldOf("insert_priority", 0).forGetter((v0) -> {
            return v0.k();
        })).apply(instance, (v1, v2, v3, v4, v5, v6, v7) -> {
            return new b(v1, v2, v3, v4, v5, v6, v7);
        });
    });
    public static final StreamCodec<ByteBuf, b> e = mctech.f.b.a(ByteBufCodecs.BOOL, (v0) -> {
        return v0.e();
    }, DyeColor.STREAM_CODEC, (v0) -> {
        return v0.g();
    }, ByteBufCodecs.BOOL, (v0) -> {
        return v0.f();
    }, DyeColor.STREAM_CODEC, (v0) -> {
        return v0.h();
    }, mctech.g.a.f.a.g, (v0) -> {
        return v0.i();
    }, DyeColor.STREAM_CODEC, (v0) -> {
        return v0.j();
    }, ByteBufCodecs.INT, (v0) -> {
        return v0.k();
    }, (v1, v2, v3, v4, v5, v6, v7) -> {
        return new b(v1, v2, v3, v4, v5, v6, v7);
    });
    public static final e<b> f = new e<>(d, e.cast(), () -> {
        return c;
    });

    public b(boolean z, DyeColor dyeColor, boolean z2, DyeColor dyeColor2, mctech.g.a.f.a aVar, DyeColor dyeColor3, int i) {
        this.g = z;
        this.h = dyeColor;
        this.i = z2;
        this.j = dyeColor2;
        this.k = aVar;
        this.l = dyeColor3;
        this.m = i;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, b.class), b.class, "isInsert;insertChannel;isExtract;extractChannel;extractRedstoneControl;extractRedstoneChannel;insertPriority", "FIELD:Lmctech/g/d/a/d/c/b;->g:Z", "FIELD:Lmctech/g/d/a/d/c/b;->h:Lnet/minecraft/world/item/DyeColor;", "FIELD:Lmctech/g/d/a/d/c/b;->i:Z", "FIELD:Lmctech/g/d/a/d/c/b;->j:Lnet/minecraft/world/item/DyeColor;", "FIELD:Lmctech/g/d/a/d/c/b;->k:Lmctech/g/a/f/a;", "FIELD:Lmctech/g/d/a/d/c/b;->l:Lnet/minecraft/world/item/DyeColor;", "FIELD:Lmctech/g/d/a/d/c/b;->m:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, b.class), b.class, "isInsert;insertChannel;isExtract;extractChannel;extractRedstoneControl;extractRedstoneChannel;insertPriority", "FIELD:Lmctech/g/d/a/d/c/b;->g:Z", "FIELD:Lmctech/g/d/a/d/c/b;->h:Lnet/minecraft/world/item/DyeColor;", "FIELD:Lmctech/g/d/a/d/c/b;->i:Z", "FIELD:Lmctech/g/d/a/d/c/b;->j:Lnet/minecraft/world/item/DyeColor;", "FIELD:Lmctech/g/d/a/d/c/b;->k:Lmctech/g/a/f/a;", "FIELD:Lmctech/g/d/a/d/c/b;->l:Lnet/minecraft/world/item/DyeColor;", "FIELD:Lmctech/g/d/a/d/c/b;->m:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, b.class, Object.class), b.class, "isInsert;insertChannel;isExtract;extractChannel;extractRedstoneControl;extractRedstoneChannel;insertPriority", "FIELD:Lmctech/g/d/a/d/c/b;->g:Z", "FIELD:Lmctech/g/d/a/d/c/b;->h:Lnet/minecraft/world/item/DyeColor;", "FIELD:Lmctech/g/d/a/d/c/b;->i:Z", "FIELD:Lmctech/g/d/a/d/c/b;->j:Lnet/minecraft/world/item/DyeColor;", "FIELD:Lmctech/g/d/a/d/c/b;->k:Lmctech/g/a/f/a;", "FIELD:Lmctech/g/d/a/d/c/b;->l:Lnet/minecraft/world/item/DyeColor;", "FIELD:Lmctech/g/d/a/d/c/b;->m:I").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
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

    public mctech.g.a.f.a i() {
        return this.k;
    }

    public DyeColor j() {
        return this.l;
    }

    public int k() {
        return this.m;
    }

    @Override // mctech.g.a.c.c
    public mctech.g.a.c.c c() {
        return new b(c.g, this.h, c.i, this.j, this.k, this.l, this.m);
    }

    @Override // mctech.g.a.c.c
    public mctech.g.a.c.c d() {
        return new b(false, this.h, false, this.j, this.k, this.l, this.m);
    }

    @Override // mctech.g.a.c.g
    public boolean a(mctech.g.a.c.b bVar) {
        return e();
    }

    @Override // mctech.g.a.c.g
    public boolean b(mctech.g.a.c.b bVar) {
        if (!f()) {
            return false;
        }
        if (this.k.a()) {
            return this.k.a(bVar.hasRedstoneSignal(this.l));
        }
        return this.k == mctech.g.a.f.a.ALWAYS_ACTIVE;
    }

    @Override // mctech.g.a.c.h
    public List<DyeColor> b() {
        if (this.k.a()) {
            return List.of(this.l);
        }
        return List.of();
    }

    public b a(boolean z) {
        return new b(z, this.h, this.i, this.j, this.k, this.l, this.m);
    }

    public b a(DyeColor dyeColor) {
        return new b(this.g, dyeColor, this.i, this.j, this.k, this.l, this.m);
    }

    public b b(boolean z) {
        return new b(this.g, this.h, z, this.j, this.k, this.l, this.m);
    }

    public b b(DyeColor dyeColor) {
        return new b(this.g, this.h, this.i, dyeColor, this.k, this.l, this.m);
    }

    public b a(mctech.g.a.f.a aVar) {
        return new b(this.g, this.h, this.i, this.j, aVar, this.l, this.m);
    }

    public b c(DyeColor dyeColor) {
        return new b(this.g, this.h, this.i, this.j, this.k, dyeColor, this.m);
    }

    public b a(int i) {
        return new b(this.g, this.h, this.i, this.j, this.k, this.l, Math.min(9999, Math.max(-9999, i)));
    }

    @Override // mctech.g.a.c.c
    public e<b> a() {
        return f;
    }
}
