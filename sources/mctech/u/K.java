package mctech.u;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.Objects;
import mctech.init.MCTechRecipes;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/K.class */
public final class K extends Record implements Recipe<a> {
    private final mctech.u.c.b a;
    private final ItemStack b;
    private final double c;

    public K(mctech.u.c.b bVar, ItemStack itemStack, double d) {
        this.a = bVar;
        this.b = itemStack;
        this.c = d;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, K.class), K.class, "ingredient;resultStack;requiredEnergy", "FIELD:Lmctech/u/K;->a:Lmctech/u/c/b;", "FIELD:Lmctech/u/K;->b:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/u/K;->c:D").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    public mctech.u.c.b a() {
        return this.a;
    }

    public ItemStack b() {
        return this.b;
    }

    public double c() {
        return this.c;
    }

    @NotNull
    public NonNullList<Ingredient> getIngredients() {
        return NonNullList.of(Ingredient.of(), new Ingredient[]{this.a.c()});
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean matches(@NotNull a aVar, @NotNull Level level) {
        return a().a(aVar.a());
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ItemStack assemble(@NotNull a aVar, HolderLookup.Provider provider) {
        return getResultItem(provider).copy();
    }

    @NotNull
    public ItemStack getResultItem(HolderLookup.Provider provider) {
        return this.b;
    }

    public boolean canCraftInDimensions(int i, int i2) {
        return true;
    }

    @NotNull
    public RecipeSerializer<?> getSerializer() {
        return (RecipeSerializer) MCTechRecipes.REGISTERED_SERIALIZERS.get(mctech.i.i.MOLECULAR_CONVERTER.getSerializedName()).get();
    }

    @NotNull
    public RecipeType<?> getType() {
        return (RecipeType) MCTechRecipes.REGISTERED_RECIPES.get(mctech.i.i.MOLECULAR_CONVERTER.getSerializedName()).get();
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/K$a.class */
    public static final class a extends Record implements RecipeInput {
        private final ItemStack a;

        public a(ItemStack itemStack) {
            this.a = itemStack;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "inputItem", "FIELD:Lmctech/u/K$a;->a:Lnet/minecraft/world/item/ItemStack;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "inputItem", "FIELD:Lmctech/u/K$a;->a:Lnet/minecraft/world/item/ItemStack;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "inputItem", "FIELD:Lmctech/u/K$a;->a:Lnet/minecraft/world/item/ItemStack;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        public ItemStack a() {
            return this.a;
        }

        @NotNull
        public ItemStack getItem(int i) {
            return this.a;
        }

        public int size() {
            return 1;
        }
    }

    @Override // java.lang.Record
    public boolean equals(Object obj) {
        if (!(obj instanceof K)) {
            return false;
        }
        K k = (K) obj;
        return Double.compare(this.c, k.c) == 0 && Objects.equals(this.b, k.b) && Objects.equals(this.a, k.a);
    }

    @Override // java.lang.Record
    public int hashCode() {
        return (31 * ((31 * Objects.hashCode(this.a)) + Objects.hashCode(this.b))) + Double.hashCode(this.c);
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/K$b.class */
    public static class b implements RecipeSerializer<K> {
        public static final MapCodec<K> a = RecordCodecBuilder.mapCodec(instance -> {
            return instance.group(mctech.u.c.b.c.fieldOf("ingredient").forGetter((v0) -> {
                return v0.a();
            }), ItemStack.CODEC.fieldOf("result").forGetter((v0) -> {
                return v0.b();
            }), Codec.DOUBLE.fieldOf("requiredEnergy").forGetter((v0) -> {
                return v0.c();
            })).apply(instance, (v1, v2, v3) -> {
                return new K(v1, v2, v3);
            });
        });
        public static final StreamCodec<RegistryFriendlyByteBuf, K> b = StreamCodec.composite(mctech.u.c.b.b, (v0) -> {
            return v0.a();
        }, ItemStack.STREAM_CODEC, (v0) -> {
            return v0.b();
        }, ByteBufCodecs.DOUBLE, (v0) -> {
            return v0.c();
        }, (v1, v2, v3) -> {
            return new K(v1, v2, v3);
        });

        @NotNull
        public MapCodec<K> codec() {
            return a;
        }

        @NotNull
        public StreamCodec<RegistryFriendlyByteBuf, K> streamCodec() {
            return b;
        }
    }
}
