package mctech.g.d.a.b.b.a;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.List;
import mctech.g.d.a.b.b.e;
import mctech.g.d.e.f;
import mctech.init.MCTechCodecs;
import mctech.utils.c.h;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.items.IItemHandler;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/a/b/b/a/a.class */
public final class a extends Record implements mctech.g.a.e.c {
    private final NonNullList<ItemStack> e;
    private final boolean f;
    private final mctech.g.d.a.b.b g;
    public static final int a = 18;
    public static final a b = new a(18);
    public static final Codec<a> c = RecordCodecBuilder.create(instance -> {
        return instance.group(f.a(h.i, MCTechCodecs.OPTIONAL_UNBOUNDED_ITEM_STACK, ItemStack.EMPTY).fieldOf("items").forGetter((v0) -> {
            return v0.a();
        }), Codec.BOOL.optionalFieldOf("isNbt", false).forGetter((v0) -> {
            return v0.b();
        }), mctech.g.d.a.b.b.l.optionalFieldOf("damageMode", mctech.g.d.a.b.b.IGNORE).forGetter((v0) -> {
            return v0.c();
        })).apply(instance, (v1, v2, v3) -> {
            return new a(v1, v2, v3);
        });
    });
    public static final StreamCodec<RegistryFriendlyByteBuf, a> d = StreamCodec.composite(ItemStack.OPTIONAL_STREAM_CODEC.apply(ByteBufCodecs.list(h.i)), (v0) -> {
        return v0.a();
    }, ByteBufCodecs.BOOL, (v0) -> {
        return v0.b();
    }, mctech.g.d.a.b.b.n, (v0) -> {
        return v0.c();
    }, (v1, v2, v3) -> {
        return new a(v1, v2, v3);
    });

    public a(NonNullList<ItemStack> nonNullList, boolean z, mctech.g.d.a.b.b bVar) {
        this.e = nonNullList;
        this.f = z;
        this.g = bVar;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "matches;shouldCompareComponents;damageFilterMode", "FIELD:Lmctech/g/d/a/b/b/a/a;->e:Lnet/minecraft/core/NonNullList;", "FIELD:Lmctech/g/d/a/b/b/a/a;->f:Z", "FIELD:Lmctech/g/d/a/b/b/a/a;->g:Lmctech/g/d/a/b/b;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "matches;shouldCompareComponents;damageFilterMode", "FIELD:Lmctech/g/d/a/b/b/a/a;->e:Lnet/minecraft/core/NonNullList;", "FIELD:Lmctech/g/d/a/b/b/a/a;->f:Z", "FIELD:Lmctech/g/d/a/b/b/a/a;->g:Lmctech/g/d/a/b/b;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "matches;shouldCompareComponents;damageFilterMode", "FIELD:Lmctech/g/d/a/b/b/a/a;->e:Lnet/minecraft/core/NonNullList;", "FIELD:Lmctech/g/d/a/b/b/a/a;->f:Z", "FIELD:Lmctech/g/d/a/b/b/a/a;->g:Lmctech/g/d/a/b/b;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public NonNullList<ItemStack> a() {
        return this.e;
    }

    public boolean b() {
        return this.f;
    }

    public mctech.g.d.a.b.b c() {
        return this.g;
    }

    public a(int i) {
        this((NonNullList<ItemStack>) NonNullList.withSize(i, ItemStack.EMPTY), false, mctech.g.d.a.b.b.IGNORE);
    }

    public a(List<ItemStack> list, boolean z, mctech.g.d.a.b.b bVar) {
        this((NonNullList<ItemStack>) NonNullList.withSize(list.size(), ItemStack.EMPTY), z, bVar);
        for (int i = 0; i < list.size(); i++) {
            this.e.set(i, list.get(i));
        }
    }

    @Override // mctech.g.a.e.c
    public ItemStack a(@Nullable IItemHandler iItemHandler, ItemStack itemStack) {
        if (!this.g.a(itemStack)) {
            return ItemStack.EMPTY;
        }
        for (ItemStack itemStack2 : this.e) {
            if (!itemStack2.isEmpty() && ItemStack.isSameItem(itemStack2, itemStack) && (!this.f || e.a(itemStack2, itemStack))) {
                if (iItemHandler == null) {
                    return itemStack;
                }
                int count = itemStack2.getCount();
                int count2 = 0;
                for (int i = 0; i < iItemHandler.getSlots(); i++) {
                    ItemStack stackInSlot = iItemHandler.getStackInSlot(i);
                    if (!stackInSlot.isEmpty() && ItemStack.isSameItem(itemStack2, stackInSlot) && (!this.f || e.a(itemStack2, stackInSlot))) {
                        count2 += stackInSlot.getCount();
                    }
                }
                int i2 = count - count2;
                if (i2 <= 0) {
                    return ItemStack.EMPTY;
                }
                return itemStack.copyWithCount(Math.min(itemStack.getCount(), i2));
            }
        }
        return ItemStack.EMPTY;
    }
}
