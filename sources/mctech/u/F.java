package mctech.u;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import mctech.init.MCTechCodecs;
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

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/F.class */
public final class F extends Record implements Recipe<a> {
    private final Ingredient a;
    private final ItemStack b;
    private final float c;

    public F(Ingredient ingredient, ItemStack itemStack, float f) {
        this.a = ingredient;
        this.b = itemStack;
        this.c = f;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, F.class), F.class, "input;output;chance", "FIELD:Lmctech/u/F;->a:Lnet/minecraft/world/item/crafting/Ingredient;", "FIELD:Lmctech/u/F;->b:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/u/F;->c:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, F.class), F.class, "input;output;chance", "FIELD:Lmctech/u/F;->a:Lnet/minecraft/world/item/crafting/Ingredient;", "FIELD:Lmctech/u/F;->b:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/u/F;->c:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, F.class, Object.class), F.class, "input;output;chance", "FIELD:Lmctech/u/F;->a:Lnet/minecraft/world/item/crafting/Ingredient;", "FIELD:Lmctech/u/F;->b:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/u/F;->c:F").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public Ingredient a() {
        return this.a;
    }

    public ItemStack b() {
        return this.b;
    }

    public float c() {
        return this.c;
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean matches(@NotNull a aVar, @NotNull Level level) {
        return this.a.test(aVar.a());
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ItemStack assemble(@NotNull a aVar, HolderLookup.Provider provider) {
        if (aVar.b.getRandom().nextFloat() < this.c) {
            return this.b.copy();
        }
        return ItemStack.EMPTY;
    }

    @NotNull
    public NonNullList<Ingredient> getIngredients() {
        return NonNullList.of(Ingredient.EMPTY, new Ingredient[]{this.a});
    }

    public boolean canCraftInDimensions(int i, int i2) {
        return i * i2 >= 1;
    }

    @NotNull
    public ItemStack getResultItem(HolderLookup.Provider provider) {
        return this.b;
    }

    @NotNull
    public RecipeSerializer<?> getSerializer() {
        return MCTechRecipes.serializer("macerator_bonus_item");
    }

    @NotNull
    public RecipeType<?> getType() {
        return MCTechRecipes.type("macerator_bonus_item");
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/F$a.class */
    public static final class a extends Record implements RecipeInput {
        private final ItemStack a;
        private final Level b;

        public a(ItemStack itemStack, Level level) {
            this.a = itemStack;
            this.b = level;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "item;level", "FIELD:Lmctech/u/F$a;->a:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/u/F$a;->b:Lnet/minecraft/world/level/Level;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "item;level", "FIELD:Lmctech/u/F$a;->a:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/u/F$a;->b:Lnet/minecraft/world/level/Level;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "item;level", "FIELD:Lmctech/u/F$a;->a:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/u/F$a;->b:Lnet/minecraft/world/level/Level;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        public ItemStack a() {
            return this.a;
        }

        public Level b() {
            return this.b;
        }

        @NotNull
        public ItemStack getItem(int i) {
            if (i != 0) {
                throw new IllegalArgumentException("No item for index " + i);
            }
            return this.a;
        }

        public int size() {
            return 1;
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/F$b.class */
    public static class b implements RecipeSerializer<F> {
        public static final MapCodec<F> a = RecordCodecBuilder.mapCodec(instance -> {
            return instance.group(Ingredient.CODEC.fieldOf("inputs").forGetter((v0) -> {
                return v0.a();
            }), ItemStack.CODEC.fieldOf("output").forGetter((v0) -> {
                return v0.b();
            }), MCTechCodecs.CHANCE.fieldOf("chance").forGetter((v0) -> {
                return v0.c();
            })).apply(instance, (v1, v2, v3) -> {
                return new F(v1, v2, v3);
            });
        });
        public static final StreamCodec<RegistryFriendlyByteBuf, F> b = StreamCodec.composite(Ingredient.CONTENTS_STREAM_CODEC, (v0) -> {
            return v0.a();
        }, ItemStack.STREAM_CODEC, (v0) -> {
            return v0.b();
        }, ByteBufCodecs.FLOAT, (v0) -> {
            return v0.c();
        }, (v1, v2, v3) -> {
            return new F(v1, v2, v3);
        });

        @NotNull
        public MapCodec<F> codec() {
            return a;
        }

        @NotNull
        public StreamCodec<RegistryFriendlyByteBuf, F> streamCodec() {
            return b;
        }
    }
}
