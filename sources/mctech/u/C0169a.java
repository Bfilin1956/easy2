package mctech.u;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
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

/* JADX INFO: renamed from: mctech.u.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/a.class */
public final class C0169a extends Record implements Recipe<C0040a> {
    private final Ingredient a;
    private final ItemStack b;
    private final int c;
    private final int d;

    public C0169a(Ingredient ingredient, ItemStack itemStack, int i, int i2) {
        this.a = ingredient;
        this.b = itemStack;
        this.c = i;
        this.d = i2;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0169a.class), C0169a.class, "input;output;energy;moduleLevel", "FIELD:Lmctech/u/a;->a:Lnet/minecraft/world/item/crafting/Ingredient;", "FIELD:Lmctech/u/a;->b:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/u/a;->c:I", "FIELD:Lmctech/u/a;->d:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0169a.class), C0169a.class, "input;output;energy;moduleLevel", "FIELD:Lmctech/u/a;->a:Lnet/minecraft/world/item/crafting/Ingredient;", "FIELD:Lmctech/u/a;->b:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/u/a;->c:I", "FIELD:Lmctech/u/a;->d:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0169a.class, Object.class), C0169a.class, "input;output;energy;moduleLevel", "FIELD:Lmctech/u/a;->a:Lnet/minecraft/world/item/crafting/Ingredient;", "FIELD:Lmctech/u/a;->b:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/u/a;->c:I", "FIELD:Lmctech/u/a;->d:I").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public Ingredient a() {
        return this.a;
    }

    public ItemStack b() {
        return this.b;
    }

    public int c() {
        return this.c;
    }

    public int d() {
        return this.d;
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean matches(@NotNull C0040a c0040a, @NotNull Level level) {
        if (c0040a.c != this.d) {
            return false;
        }
        return this.a.test(c0040a.getItem(0));
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ItemStack assemble(@NotNull C0040a c0040a, HolderLookup.Provider provider) {
        return this.b.copy();
    }

    @NotNull
    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> nonNullListCreate = NonNullList.create();
        nonNullListCreate.add(this.a);
        return nonNullListCreate;
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
        return MCTechRecipes.serializer("adv_mass_fabricator");
    }

    @NotNull
    public RecipeType<?> getType() {
        return MCTechRecipes.type("adv_mass_fabricator");
    }

    /* JADX INFO: renamed from: mctech.u.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/a$a.class */
    public static final class C0040a extends Record implements RecipeInput {
        private final ItemStack a;
        private final int b;
        private final int c;

        public C0040a(ItemStack itemStack, int i, int i2) {
            this.a = itemStack;
            this.b = i;
            this.c = i2;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0040a.class), C0040a.class, "stack;energy;moduleLevel", "FIELD:Lmctech/u/a$a;->a:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/u/a$a;->b:I", "FIELD:Lmctech/u/a$a;->c:I").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0040a.class), C0040a.class, "stack;energy;moduleLevel", "FIELD:Lmctech/u/a$a;->a:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/u/a$a;->b:I", "FIELD:Lmctech/u/a$a;->c:I").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0040a.class, Object.class), C0040a.class, "stack;energy;moduleLevel", "FIELD:Lmctech/u/a$a;->a:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/u/a$a;->b:I", "FIELD:Lmctech/u/a$a;->c:I").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        public ItemStack a() {
            return this.a;
        }

        public int b() {
            return this.b;
        }

        public int c() {
            return this.c;
        }

        public C0040a(ItemStack itemStack, int i) {
            this(itemStack, 0, i);
        }

        @NotNull
        public ItemStack getItem(int i) {
            return i == 0 ? this.a : ItemStack.EMPTY;
        }

        public int size() {
            return 1;
        }
    }

    /* JADX INFO: renamed from: mctech.u.a$b */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/a$b.class */
    public static class b implements RecipeSerializer<C0169a> {
        public static final MapCodec<C0169a> a = RecordCodecBuilder.mapCodec(instance -> {
            return instance.group(Ingredient.CODEC.fieldOf("input").forGetter((v0) -> {
                return v0.a();
            }), ItemStack.CODEC.fieldOf("output").forGetter((v0) -> {
                return v0.b();
            }), Codec.intRange(1, Integer.MAX_VALUE).fieldOf("energy").forGetter((v0) -> {
                return v0.c();
            }), Codec.intRange(0, 2).fieldOf("moduleLevel").forGetter((v0) -> {
                return v0.d();
            })).apply(instance, (v1, v2, v3, v4) -> {
                return new C0169a(v1, v2, v3, v4);
            });
        });
        public static final StreamCodec<RegistryFriendlyByteBuf, C0169a> b = StreamCodec.composite(Ingredient.CONTENTS_STREAM_CODEC, (v0) -> {
            return v0.a();
        }, ItemStack.STREAM_CODEC, (v0) -> {
            return v0.b();
        }, ByteBufCodecs.VAR_INT, (v0) -> {
            return v0.c();
        }, ByteBufCodecs.VAR_INT, (v0) -> {
            return v0.d();
        }, (v1, v2, v3, v4) -> {
            return new C0169a(v1, v2, v3, v4);
        });

        @NotNull
        public MapCodec<C0169a> codec() {
            return a;
        }

        @NotNull
        public StreamCodec<RegistryFriendlyByteBuf, C0169a> streamCodec() {
            return b;
        }
    }
}
