package mctech.g.d.a.d.a;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.List;
import mctech.g.a.c.g;
import mctech.g.a.c.h;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.DyeColor;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/a/d/a/b.class */
public final class b extends Record implements g, h {
    private final boolean g;
    private final boolean h;
    private final mctech.g.a.f.a i;
    private final DyeColor j;
    private final int k;
    public static final b c = new b(true, true, mctech.g.a.f.a.ALWAYS_ACTIVE, DyeColor.RED, 0);
    public static final MapCodec<b> d = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Codec.BOOL.fieldOf("is_insert").forGetter((v0) -> {
            return v0.e();
        }), Codec.BOOL.fieldOf("is_extract").forGetter((v0) -> {
            return v0.f();
        }), mctech.g.a.f.a.e.fieldOf("extract_redstone_control").forGetter((v0) -> {
            return v0.i();
        }), DyeColor.CODEC.fieldOf("extract_redstone_channel").forGetter((v0) -> {
            return v0.j();
        }), Codec.INT.optionalFieldOf("priority", 0).forGetter((v0) -> {
            return v0.k();
        })).apply(instance, (v1, v2, v3, v4, v5) -> {
            return new b(v1, v2, v3, v4, v5);
        });
    });
    public static final StreamCodec<ByteBuf, b> e = StreamCodec.composite(ByteBufCodecs.BOOL, (v0) -> {
        return v0.e();
    }, ByteBufCodecs.BOOL, (v0) -> {
        return v0.f();
    }, mctech.g.a.f.a.g, (v0) -> {
        return v0.i();
    }, DyeColor.STREAM_CODEC, (v0) -> {
        return v0.j();
    }, ByteBufCodecs.INT, (v0) -> {
        return v0.k();
    }, (v1, v2, v3, v4, v5) -> {
        return new b(v1, v2, v3, v4, v5);
    });
    public static final mctech.g.a.c.e<b> f = new mctech.g.a.c.e<>(d, e.cast(), () -> {
        return c;
    });

    public b(boolean z, boolean z2, mctech.g.a.f.a aVar, DyeColor dyeColor, int i) {
        this.g = z;
        this.h = z2;
        this.i = aVar;
        this.j = dyeColor;
        this.k = i;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, b.class), b.class, "isInsert;isExtract;extractRedstoneControl;extractRedstoneChannel;priority", "FIELD:Lmctech/g/d/a/d/a/b;->g:Z", "FIELD:Lmctech/g/d/a/d/a/b;->h:Z", "FIELD:Lmctech/g/d/a/d/a/b;->i:Lmctech/g/a/f/a;", "FIELD:Lmctech/g/d/a/d/a/b;->j:Lnet/minecraft/world/item/DyeColor;", "FIELD:Lmctech/g/d/a/d/a/b;->k:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, b.class), b.class, "isInsert;isExtract;extractRedstoneControl;extractRedstoneChannel;priority", "FIELD:Lmctech/g/d/a/d/a/b;->g:Z", "FIELD:Lmctech/g/d/a/d/a/b;->h:Z", "FIELD:Lmctech/g/d/a/d/a/b;->i:Lmctech/g/a/f/a;", "FIELD:Lmctech/g/d/a/d/a/b;->j:Lnet/minecraft/world/item/DyeColor;", "FIELD:Lmctech/g/d/a/d/a/b;->k:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, b.class, Object.class), b.class, "isInsert;isExtract;extractRedstoneControl;extractRedstoneChannel;priority", "FIELD:Lmctech/g/d/a/d/a/b;->g:Z", "FIELD:Lmctech/g/d/a/d/a/b;->h:Z", "FIELD:Lmctech/g/d/a/d/a/b;->i:Lmctech/g/a/f/a;", "FIELD:Lmctech/g/d/a/d/a/b;->j:Lnet/minecraft/world/item/DyeColor;", "FIELD:Lmctech/g/d/a/d/a/b;->k:I").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @Override // mctech.g.a.c.g
    public boolean e() {
        return this.g;
    }

    @Override // mctech.g.a.c.g
    public boolean f() {
        return this.h;
    }

    public mctech.g.a.f.a i() {
        return this.i;
    }

    public DyeColor j() {
        return this.j;
    }

    public int k() {
        return this.k;
    }

    @Override // mctech.g.a.c.c
    public mctech.g.a.c.c c() {
        return new b(c.g, c.h, this.i, this.j, this.k);
    }

    @Override // mctech.g.a.c.c
    public mctech.g.a.c.c d() {
        return new b(false, false, this.i, this.j, this.k);
    }

    @Override // mctech.g.a.c.g
    public DyeColor g() {
        return DyeColor.RED;
    }

    @Override // mctech.g.a.c.g
    public DyeColor h() {
        return DyeColor.RED;
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
        if (this.i.a()) {
            return this.i.a(bVar.hasRedstoneSignal(this.j));
        }
        return this.i == mctech.g.a.f.a.ALWAYS_ACTIVE;
    }

    @Override // mctech.g.a.c.h
    public List<DyeColor> b() {
        if (this.i.a()) {
            return List.of(this.j);
        }
        return List.of();
    }

    public b a(boolean z) {
        return new b(z, this.h, this.i, this.j, this.k);
    }

    public b b(boolean z) {
        return new b(this.g, z, this.i, this.j, this.k);
    }

    public b a(mctech.g.a.f.a aVar) {
        return new b(this.g, this.h, aVar, this.j, this.k);
    }

    public b a(DyeColor dyeColor) {
        return new b(this.g, this.h, this.i, dyeColor, this.k);
    }

    public b a(int i) {
        return new b(this.g, this.h, this.i, this.j, i);
    }

    @Override // mctech.g.a.c.c
    public mctech.g.a.c.e<?> a() {
        return f;
    }
}
