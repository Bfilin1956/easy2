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

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/I.class */
public final class I extends Record implements Recipe<a> {
    private final mctech.u.c.b a;
    private final ItemStack b;
    private final int c;

    public I(mctech.u.c.b bVar, ItemStack itemStack, int i) {
        this.a = bVar;
        this.b = itemStack;
        this.c = i;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, I.class), I.class, "ingredient;resultStack;energy", "FIELD:Lmctech/u/I;->a:Lmctech/u/c/b;", "FIELD:Lmctech/u/I;->b:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/u/I;->c:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    public mctech.u.c.b c() {
        return this.a;
    }

    public ItemStack d() {
        return this.b;
    }

    public int e() {
        return this.c;
    }

    public int a() {
        if (this.a == null || this.a.a()) {
            return 0;
        }
        return this.a.d();
    }

    public int b() {
        return Math.max(0, this.c);
    }

    public boolean a(ItemStack itemStack) {
        return (this.a == null || this.a.a() || !this.a.c().test(itemStack)) ? false : true;
    }

    @NotNull
    public NonNullList<Ingredient> getIngredients() {
        return (this.a == null || this.a.a()) ? NonNullList.create() : NonNullList.of(Ingredient.of(), new Ingredient[]{this.a.c()});
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean matches(@NotNull a aVar, @NotNull Level level) {
        return a(aVar.a());
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
        return (RecipeSerializer) MCTechRecipes.REGISTERED_SERIALIZERS.get(mctech.i.i.MATRIX_CONVERTER.getSerializedName()).get();
    }

    @NotNull
    public RecipeType<?> getType() {
        return (RecipeType) MCTechRecipes.REGISTERED_RECIPES.get(mctech.i.i.MATRIX_CONVERTER.getSerializedName()).get();
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/I$a.class */
    public static final class a extends Record implements RecipeInput {
        private final ItemStack a;

        public a(ItemStack itemStack) {
            this.a = itemStack;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "inputItem", "FIELD:Lmctech/u/I$a;->a:Lnet/minecraft/world/item/ItemStack;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "inputItem", "FIELD:Lmctech/u/I$a;->a:Lnet/minecraft/world/item/ItemStack;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "inputItem", "FIELD:Lmctech/u/I$a;->a:Lnet/minecraft/world/item/ItemStack;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
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

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    @Override // java.lang.Record
    public boolean equals(Object obj) throws MatchException {
        if (!(obj instanceof I)) {
            return false;
        }
        I i = (I) obj;
        try {
            mctech.u.c.b bVarC = i.c();
            return this.c == i.e() && Objects.equals(this.b, i.d()) && Objects.equals(this.a, bVarC);
        } catch (Throwable th) {
            throw new MatchException(th.toString(), th);
        }
    }

    @Override // java.lang.Record
    public int hashCode() {
        return Objects.hash(this.a, this.b, Integer.valueOf(this.c));
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/I$b.class */
    public static class b implements RecipeSerializer<I> {
        public static final MapCodec<I> a = RecordCodecBuilder.mapCodec(instance -> {
            return instance.group(mctech.u.c.b.c.fieldOf("ingredient").forGetter((v0) -> {
                return v0.c();
            }), ItemStack.CODEC.fieldOf("result").forGetter((v0) -> {
                return v0.d();
            }), Codec.INT.fieldOf("energy").forGetter((v0) -> {
                return v0.e();
            })).apply(instance, (v1, v2, v3) -> {
                return new I(v1, v2, v3);
            });
        });
        public static final StreamCodec<RegistryFriendlyByteBuf, I> b = StreamCodec.composite(mctech.u.c.b.b, (v0) -> {
            return v0.c();
        }, ItemStack.STREAM_CODEC, (v0) -> {
            return v0.d();
        }, ByteBufCodecs.INT, (v0) -> {
            return v0.e();
        }, (v1, v2, v3) -> {
            return new I(v1, v2, v3);
        });

        @NotNull
        public MapCodec<I> codec() {
            return a;
        }

        @NotNull
        public StreamCodec<RegistryFriendlyByteBuf, I> streamCodec() {
            return b;
        }
    }
}
