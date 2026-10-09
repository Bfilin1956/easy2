package mctech.u.c;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import mctech.init.MCTechCodecs;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/c/b.class */
public final class b extends Record {
    private final Ingredient d;
    private final int e;
    public static final b a = new b(Ingredient.EMPTY, 0);
    public static final StreamCodec<RegistryFriendlyByteBuf, b> b = StreamCodec.composite(Ingredient.CONTENTS_STREAM_CODEC, (v0) -> {
        return v0.c();
    }, ByteBufCodecs.VAR_INT, (v0) -> {
        return v0.d();
    }, (v1, v2) -> {
        return new b(v1, v2);
    });
    public static final Codec<b> c = Codec.lazyInitialized(() -> {
        return RecordCodecBuilder.create(instance -> {
            return instance.group(Ingredient.CODEC.optionalFieldOf("ingredient", Ingredient.EMPTY).forGetter((v0) -> {
                return v0.c();
            }), MCTechCodecs.FROM_ZERO.fieldOf("count").forGetter((v0) -> {
                return v0.d();
            })).apply(instance, (v1, v2) -> {
                return new b(v1, v2);
            });
        });
    });

    public b(Ingredient ingredient, int i) {
        this.d = ingredient;
        this.e = i;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, b.class), b.class, "ingredient;count", "FIELD:Lmctech/u/c/b;->d:Lnet/minecraft/world/item/crafting/Ingredient;", "FIELD:Lmctech/u/c/b;->e:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, b.class), b.class, "ingredient;count", "FIELD:Lmctech/u/c/b;->d:Lnet/minecraft/world/item/crafting/Ingredient;", "FIELD:Lmctech/u/c/b;->e:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, b.class, Object.class), b.class, "ingredient;count", "FIELD:Lmctech/u/c/b;->d:Lnet/minecraft/world/item/crafting/Ingredient;", "FIELD:Lmctech/u/c/b;->e:I").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public Ingredient c() {
        return this.d;
    }

    public int d() {
        return this.e;
    }

    public boolean a(ItemStack itemStack) {
        return this.d.test(itemStack) && itemStack.getCount() >= this.e;
    }

    public boolean a() {
        return this.d.isEmpty();
    }

    public ItemStack b() {
        return this.d.getItems()[0];
    }

    public static b a(Ingredient ingredient, int i) {
        return new b(ingredient, i);
    }

    public static b b(ItemStack itemStack) {
        return a(Ingredient.of(new ItemStack[]{itemStack}), itemStack.getCount());
    }
}
