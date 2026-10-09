package mctech.g.f;

import com.mojang.datafixers.util.Either;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.HashMap;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/f/f.class */
@Deprecated(since = "8.0.0")
public final class f extends Record implements e {
    private final boolean e;
    private final DyeColor f;
    private final boolean g;
    private final DyeColor h;
    private final mctech.g.a.f.a i;
    private final DyeColor j;
    private final ItemStack k;
    private final ItemStack l;
    private static final Codec<g> m = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.BOOL.fieldOf("is_insert").forGetter((v0) -> {
            return v0.a();
        }), DyeColor.CODEC.fieldOf("insert_channel").forGetter((v0) -> {
            return v0.b();
        }), Codec.BOOL.fieldOf("is_extract").forGetter((v0) -> {
            return v0.c();
        }), DyeColor.CODEC.fieldOf("extract_channel").forGetter((v0) -> {
            return v0.d();
        }), mctech.g.a.f.a.e.fieldOf("redstone_control").forGetter((v0) -> {
            return v0.e();
        }), DyeColor.CODEC.fieldOf("redstone_channel").forGetter((v0) -> {
            return v0.f();
        }), ItemStack.OPTIONAL_CODEC.fieldOf("filter_insert").forGetter((v0) -> {
            return v0.g();
        }), ItemStack.OPTIONAL_CODEC.fieldOf("filter_extract").forGetter((v0) -> {
            return v0.h();
        }), ItemStack.OPTIONAL_CODEC.fieldOf("upgrade_extract").forGetter((v0) -> {
            return v0.i();
        })).apply(instance, (v1, v2, v3, v4, v5, v6, v7, v8, v9) -> {
            return new g(v1, v2, v3, v4, v5, v6, v7, v8, v9);
        });
    });
    private static final Codec<f> n = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.BOOL.fieldOf("import").forGetter((v0) -> {
            return v0.c();
        }), DyeColor.CODEC.fieldOf("import_channel").forGetter((v0) -> {
            return v0.d();
        }), Codec.BOOL.fieldOf("export").forGetter((v0) -> {
            return v0.e();
        }), DyeColor.CODEC.fieldOf("export_channel").forGetter((v0) -> {
            return v0.f();
        }), mctech.g.a.f.a.e.fieldOf("redstone_settings").forGetter((v0) -> {
            return v0.g();
        }), DyeColor.CODEC.fieldOf("redstone_channel").forGetter((v0) -> {
            return v0.h();
        }), ItemStack.OPTIONAL_CODEC.fieldOf("import_filter").forGetter((v0) -> {
            return v0.i();
        }), ItemStack.OPTIONAL_CODEC.fieldOf("export_filter").forGetter((v0) -> {
            return v0.j();
        })).apply(instance, (v1, v2, v3, v4, v5, v6, v7, v8) -> {
            return new f(v1, v2, v3, v4, v5, v6, v7, v8);
        });
    });
    public static final Codec<f> c = Codec.either(m, n).xmap(either -> {
        return (f) either.map(f::a, fVar -> {
            return fVar;
        });
    }, (v0) -> {
        return Either.right(v0);
    });
    public static StreamCodec<RegistryFriendlyByteBuf, f> d = mctech.f.b.a(ByteBufCodecs.BOOL, (v0) -> {
        return v0.c();
    }, DyeColor.STREAM_CODEC, (v0) -> {
        return v0.d();
    }, ByteBufCodecs.BOOL, (v0) -> {
        return v0.e();
    }, DyeColor.STREAM_CODEC, (v0) -> {
        return v0.f();
    }, mctech.g.a.f.a.g, (v0) -> {
        return v0.g();
    }, DyeColor.STREAM_CODEC, (v0) -> {
        return v0.h();
    }, ItemStack.OPTIONAL_STREAM_CODEC, (v0) -> {
        return v0.i();
    }, ItemStack.OPTIONAL_STREAM_CODEC, (v0) -> {
        return v0.j();
    }, (v1, v2, v3, v4, v5, v6, v7, v8) -> {
        return new f(v1, v2, v3, v4, v5, v6, v7, v8);
    });

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, f.class), f.class, "isImport;importChannel;isExport;exportChannel;redstoneSettings;redstoneChannel;importFilter;exportFilter", "FIELD:Lmctech/g/f/f;->e:Z", "FIELD:Lmctech/g/f/f;->f:Lnet/minecraft/world/item/DyeColor;", "FIELD:Lmctech/g/f/f;->g:Z", "FIELD:Lmctech/g/f/f;->h:Lnet/minecraft/world/item/DyeColor;", "FIELD:Lmctech/g/f/f;->i:Lmctech/g/a/f/a;", "FIELD:Lmctech/g/f/f;->j:Lnet/minecraft/world/item/DyeColor;", "FIELD:Lmctech/g/f/f;->k:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/g/f/f;->l:Lnet/minecraft/world/item/ItemStack;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, f.class), f.class, "isImport;importChannel;isExport;exportChannel;redstoneSettings;redstoneChannel;importFilter;exportFilter", "FIELD:Lmctech/g/f/f;->e:Z", "FIELD:Lmctech/g/f/f;->f:Lnet/minecraft/world/item/DyeColor;", "FIELD:Lmctech/g/f/f;->g:Z", "FIELD:Lmctech/g/f/f;->h:Lnet/minecraft/world/item/DyeColor;", "FIELD:Lmctech/g/f/f;->i:Lmctech/g/a/f/a;", "FIELD:Lmctech/g/f/f;->j:Lnet/minecraft/world/item/DyeColor;", "FIELD:Lmctech/g/f/f;->k:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/g/f/f;->l:Lnet/minecraft/world/item/ItemStack;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, f.class, Object.class), f.class, "isImport;importChannel;isExport;exportChannel;redstoneSettings;redstoneChannel;importFilter;exportFilter", "FIELD:Lmctech/g/f/f;->e:Z", "FIELD:Lmctech/g/f/f;->f:Lnet/minecraft/world/item/DyeColor;", "FIELD:Lmctech/g/f/f;->g:Z", "FIELD:Lmctech/g/f/f;->h:Lnet/minecraft/world/item/DyeColor;", "FIELD:Lmctech/g/f/f;->i:Lmctech/g/a/f/a;", "FIELD:Lmctech/g/f/f;->j:Lnet/minecraft/world/item/DyeColor;", "FIELD:Lmctech/g/f/f;->k:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/g/f/f;->l:Lnet/minecraft/world/item/ItemStack;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public boolean c() {
        return this.e;
    }

    public DyeColor d() {
        return this.f;
    }

    public boolean e() {
        return this.g;
    }

    public DyeColor f() {
        return this.h;
    }

    public mctech.g.a.f.a g() {
        return this.i;
    }

    public DyeColor h() {
        return this.j;
    }

    public ItemStack i() {
        return this.k;
    }

    public ItemStack j() {
        return this.l;
    }

    public f(boolean z, DyeColor dyeColor, boolean z2, DyeColor dyeColor2, mctech.g.a.f.a aVar, DyeColor dyeColor3, ItemStack itemStack, ItemStack itemStack2) {
        this.e = z;
        this.f = dyeColor;
        this.g = z2;
        this.h = dyeColor2;
        this.i = aVar;
        this.j = dyeColor3;
        this.k = itemStack;
        this.l = itemStack2;
    }

    private static f a(g gVar) {
        return new f(gVar.a(), gVar.b(), gVar.c(), gVar.d(), gVar.e(), gVar.f(), gVar.g(), gVar.h());
    }

    public static f a(Level level, BlockPos blockPos, Direction direction, Holder<mctech.g.a.a<?, ?>> holder) {
        return new f(false, DyeColor.GREEN, true, DyeColor.GREEN, mctech.g.a.f.a.NEVER_ACTIVE, DyeColor.RED, ItemStack.EMPTY, ItemStack.EMPTY);
    }

    @Override // mctech.g.f.e
    public boolean a() {
        return true;
    }

    public ItemStack a(mctech.g.a.f fVar) {
        if (fVar == mctech.g.a.f.EXPORT) {
            return this.l;
        }
        if (fVar == mctech.g.a.f.IMPORT) {
            return this.k;
        }
        return ItemStack.EMPTY;
    }

    public f a(mctech.g.a.f fVar, ItemStack itemStack) {
        HashMap map = new HashMap();
        mctech.g.a.f[] fVarArrValues = mctech.g.a.f.values();
        int length = fVarArrValues.length;
        for (int i = 0; i < length; i++) {
            mctech.g.a.f fVar2 = fVarArrValues[i];
            map.put(fVar2, fVar2 == fVar ? itemStack : a(fVar2));
        }
        return new f(this.e, this.f, this.g, this.h, this.i, this.j, (ItemStack) map.get(mctech.g.a.f.IMPORT), (ItemStack) map.get(mctech.g.a.f.EXPORT));
    }

    public f a(boolean z, boolean z2) {
        return new f(!z ? z2 : this.e, this.f, z ? z2 : this.g, this.h, this.i, this.j, this.k, this.l);
    }

    public f a(boolean z) {
        return new f(this.e, this.f, z, this.h, this.i, this.j, this.k, this.l);
    }

    public f a(boolean z, DyeColor dyeColor) {
        return new f(this.e, this.f, z, dyeColor, this.i, this.j, this.k, this.l);
    }

    public f b(boolean z) {
        return new f(z, this.f, this.g, this.h, this.i, this.j, this.k, this.l);
    }

    public f b(boolean z, DyeColor dyeColor) {
        return new f(z, dyeColor, this.g, this.h, this.i, this.j, this.k, this.l);
    }

    public f c(boolean z, DyeColor dyeColor) {
        return new f(this.e, !z ? dyeColor : this.f, this.g, z ? dyeColor : this.h, this.i, this.j, this.k, this.l);
    }

    public f a(mctech.g.a.f.a aVar) {
        return new f(this.e, this.f, this.g, this.h, aVar, this.j, this.k, this.l);
    }

    public f a(DyeColor dyeColor) {
        return new f(this.e, this.f, this.g, this.h, this.i, dyeColor, this.k, this.l);
    }

    public boolean b() {
        return (this.e || this.g) ? false : true;
    }
}
