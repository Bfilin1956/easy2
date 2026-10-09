package mctech.u;

import appeng.core.definitions.AEItems;
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
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: mctech.u.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/n.class */
public final class C0186n extends Record implements Recipe<SingleRecipeInput> {
    private final Ingredient a;
    private final int b;
    private final int c;

    public C0186n(Ingredient ingredient, int i, int i2) {
        this.a = ingredient;
        this.b = i;
        this.c = i2;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0186n.class), C0186n.class, "input;tickDuration;crystalCount", "FIELD:Lmctech/u/n;->a:Lnet/minecraft/world/item/crafting/Ingredient;", "FIELD:Lmctech/u/n;->b:I", "FIELD:Lmctech/u/n;->c:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0186n.class), C0186n.class, "input;tickDuration;crystalCount", "FIELD:Lmctech/u/n;->a:Lnet/minecraft/world/item/crafting/Ingredient;", "FIELD:Lmctech/u/n;->b:I", "FIELD:Lmctech/u/n;->c:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0186n.class, Object.class), C0186n.class, "input;tickDuration;crystalCount", "FIELD:Lmctech/u/n;->a:Lnet/minecraft/world/item/crafting/Ingredient;", "FIELD:Lmctech/u/n;->b:I", "FIELD:Lmctech/u/n;->c:I").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public Ingredient a() {
        return this.a;
    }

    public int b() {
        return this.b;
    }

    public int c() {
        return this.c;
    }

    @NotNull
    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> nonNullListCreate = NonNullList.create();
        nonNullListCreate.add(this.a);
        return nonNullListCreate;
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean matches(@NotNull SingleRecipeInput singleRecipeInput, @NotNull Level level) {
        return this.a.test(singleRecipeInput.getItem(0));
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ItemStack assemble(@NotNull SingleRecipeInput singleRecipeInput, HolderLookup.Provider provider) {
        return AEItems.CERTUS_QUARTZ_CRYSTAL.stack();
    }

    public boolean canCraftInDimensions(int i, int i2) {
        return i * i2 >= 1;
    }

    @NotNull
    public ItemStack getResultItem(HolderLookup.Provider provider) {
        return AEItems.CERTUS_QUARTZ_CRYSTAL.stack();
    }

    @NotNull
    public RecipeSerializer<?> getSerializer() {
        return MCTechRecipes.serializer("crystal_growth_chamber");
    }

    @NotNull
    public RecipeType<?> getType() {
        return MCTechRecipes.type("crystal_growth_chamber");
    }

    /* JADX INFO: renamed from: mctech.u.n$a */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/n$a.class */
    public static class a implements RecipeSerializer<C0186n> {
        public static final MapCodec<C0186n> a = RecordCodecBuilder.mapCodec(instance -> {
            return instance.group(Ingredient.CODEC.fieldOf("input").forGetter((v0) -> {
                return v0.a();
            }), MCTechCodecs.FROM_ONE.fieldOf("tickDuration").forGetter((v0) -> {
                return v0.b();
            }), MCTechCodecs.FROM_ONE.fieldOf("crystalCount").forGetter((v0) -> {
                return v0.c();
            })).apply(instance, (v1, v2, v3) -> {
                return new C0186n(v1, v2, v3);
            });
        });
        public static final StreamCodec<RegistryFriendlyByteBuf, C0186n> b = StreamCodec.composite(Ingredient.CONTENTS_STREAM_CODEC, (v0) -> {
            return v0.a();
        }, ByteBufCodecs.VAR_INT, (v0) -> {
            return v0.b();
        }, ByteBufCodecs.VAR_INT, (v0) -> {
            return v0.c();
        }, (v1, v2, v3) -> {
            return new C0186n(v1, v2, v3);
        });

        @NotNull
        public MapCodec<C0186n> codec() {
            return a;
        }

        @NotNull
        public StreamCodec<RegistryFriendlyByteBuf, C0186n> streamCodec() {
            return b;
        }
    }
}
