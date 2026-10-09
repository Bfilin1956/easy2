package mctech.g.d.a.b.b;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.List;
import mctech.g.d.e.f;
import mctech.utils.c.h;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.items.IItemHandler;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/a/b/b/a.class */
public final class a extends Record implements mctech.g.a.e.c {
    private final NonNullList<ItemStack> d;
    private final boolean e;
    private final boolean f;
    private final mctech.g.d.a.b.b g;
    public static final a a = new a(0);
    public static final Codec<a> b = RecordCodecBuilder.create(instance -> {
        return instance.group(f.a(h.i, ItemStack.OPTIONAL_CODEC, ItemStack.EMPTY).fieldOf("items").forGetter((v0) -> {
            return v0.a();
        }), Codec.BOOL.optionalFieldOf("isInvert", false).forGetter((v0) -> {
            return v0.b();
        }), Codec.BOOL.optionalFieldOf("isNbt", false).forGetter((v0) -> {
            return v0.c();
        }), mctech.g.d.a.b.b.l.optionalFieldOf("damageMode", mctech.g.d.a.b.b.IGNORE).forGetter((v0) -> {
            return v0.d();
        })).apply(instance, (v1, v2, v3, v4) -> {
            return new a(v1, v2, v3, v4);
        });
    });
    public static final StreamCodec<RegistryFriendlyByteBuf, a> c = StreamCodec.composite(ItemStack.OPTIONAL_STREAM_CODEC.apply(ByteBufCodecs.list(h.i)), (v0) -> {
        return v0.a();
    }, ByteBufCodecs.BOOL, (v0) -> {
        return v0.b();
    }, ByteBufCodecs.BOOL, (v0) -> {
        return v0.c();
    }, mctech.g.d.a.b.b.n, (v0) -> {
        return v0.d();
    }, (v1, v2, v3, v4) -> {
        return new a(v1, v2, v3, v4);
    });

    public a(NonNullList<ItemStack> nonNullList, boolean z, boolean z2, mctech.g.d.a.b.b bVar) {
        this.d = nonNullList;
        this.e = z;
        this.f = z2;
        this.g = bVar;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "matches;isDenyList;shouldCompareComponents;damageFilterMode", "FIELD:Lmctech/g/d/a/b/b/a;->d:Lnet/minecraft/core/NonNullList;", "FIELD:Lmctech/g/d/a/b/b/a;->e:Z", "FIELD:Lmctech/g/d/a/b/b/a;->f:Z", "FIELD:Lmctech/g/d/a/b/b/a;->g:Lmctech/g/d/a/b/b;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "matches;isDenyList;shouldCompareComponents;damageFilterMode", "FIELD:Lmctech/g/d/a/b/b/a;->d:Lnet/minecraft/core/NonNullList;", "FIELD:Lmctech/g/d/a/b/b/a;->e:Z", "FIELD:Lmctech/g/d/a/b/b/a;->f:Z", "FIELD:Lmctech/g/d/a/b/b/a;->g:Lmctech/g/d/a/b/b;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "matches;isDenyList;shouldCompareComponents;damageFilterMode", "FIELD:Lmctech/g/d/a/b/b/a;->d:Lnet/minecraft/core/NonNullList;", "FIELD:Lmctech/g/d/a/b/b/a;->e:Z", "FIELD:Lmctech/g/d/a/b/b/a;->f:Z", "FIELD:Lmctech/g/d/a/b/b/a;->g:Lmctech/g/d/a/b/b;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public NonNullList<ItemStack> a() {
        return this.d;
    }

    public boolean b() {
        return this.e;
    }

    public boolean c() {
        return this.f;
    }

    public mctech.g.d.a.b.b d() {
        return this.g;
    }

    public a(int i) {
        this((NonNullList<ItemStack>) NonNullList.withSize(i, ItemStack.EMPTY), false, false, mctech.g.d.a.b.b.IGNORE);
    }

    public a(int i, boolean z, boolean z2, mctech.g.d.a.b.b bVar) {
        this((NonNullList<ItemStack>) NonNullList.withSize(i, ItemStack.EMPTY), z, z2, bVar);
    }

    public a(List<ItemStack> list, boolean z, boolean z2, mctech.g.d.a.b.b bVar) {
        this((NonNullList<ItemStack>) NonNullList.withSize(list.size(), ItemStack.EMPTY), z, z2, bVar);
        for (int i = 0; i < list.size(); i++) {
            this.d.set(i, list.get(i));
        }
    }

    @Override // mctech.g.a.e.c
    public ItemStack a(@Nullable IItemHandler iItemHandler, ItemStack itemStack) {
        if (!this.g.a(itemStack)) {
            return ItemStack.EMPTY;
        }
        for (ItemStack itemStack2 : this.d) {
            if (!itemStack2.isEmpty() && ItemStack.isSameItem(itemStack2, itemStack) && (!this.f || e.a(itemStack2, itemStack))) {
                return this.e ? ItemStack.EMPTY : itemStack;
            }
        }
        return this.e ? itemStack : ItemStack.EMPTY;
    }
}
