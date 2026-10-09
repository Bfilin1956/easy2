package mctech.u;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import mctech.init.MCTechRecipes;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: mctech.u.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/o.class */
public final class C0187o extends Record implements Recipe<a> {
    private final mctech.u.c.b a;
    private final ItemStack b;
    private final ItemStack c;

    public C0187o(mctech.u.c.b bVar, ItemStack itemStack, ItemStack itemStack2) {
        this.a = bVar;
        this.b = itemStack;
        this.c = itemStack2;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0187o.class), C0187o.class, "ingredient;catalyst;resultStack", "FIELD:Lmctech/u/o;->a:Lmctech/u/c/b;", "FIELD:Lmctech/u/o;->b:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/u/o;->c:Lnet/minecraft/world/item/ItemStack;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0187o.class), C0187o.class, "ingredient;catalyst;resultStack", "FIELD:Lmctech/u/o;->a:Lmctech/u/c/b;", "FIELD:Lmctech/u/o;->b:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/u/o;->c:Lnet/minecraft/world/item/ItemStack;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0187o.class, Object.class), C0187o.class, "ingredient;catalyst;resultStack", "FIELD:Lmctech/u/o;->a:Lmctech/u/c/b;", "FIELD:Lmctech/u/o;->b:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/u/o;->c:Lnet/minecraft/world/item/ItemStack;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public mctech.u.c.b a() {
        return this.a;
    }

    public ItemStack b() {
        return this.b;
    }

    public ItemStack c() {
        return this.c;
    }

    @NotNull
    public NonNullList<Ingredient> getIngredients() {
        return NonNullList.withSize(1, this.a.c());
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean matches(@NotNull a aVar, @NotNull Level level) {
        return aVar.a(this);
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ItemStack assemble(@NotNull a aVar, HolderLookup.Provider provider) {
        return getResultItem(provider).copy();
    }

    @NotNull
    public ItemStack getResultItem(HolderLookup.Provider provider) {
        return this.c;
    }

    public boolean canCraftInDimensions(int i, int i2) {
        return true;
    }

    @NotNull
    public RecipeSerializer<?> getSerializer() {
        return (RecipeSerializer) MCTechRecipes.REGISTERED_SERIALIZERS.get("crystal_synth").get();
    }

    @NotNull
    public RecipeType<?> getType() {
        return (RecipeType) MCTechRecipes.REGISTERED_RECIPES.get("crystal_synth").get();
    }

    /* JADX INFO: renamed from: mctech.u.o$a */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/o$a.class */
    public static final class a extends Record implements RecipeInput {
        private final ItemStack a;
        private final ItemStack b;

        public a(ItemStack itemStack, ItemStack itemStack2) {
            this.a = itemStack;
            this.b = itemStack2;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "inputItem;catalyst", "FIELD:Lmctech/u/o$a;->a:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/u/o$a;->b:Lnet/minecraft/world/item/ItemStack;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "inputItem;catalyst", "FIELD:Lmctech/u/o$a;->a:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/u/o$a;->b:Lnet/minecraft/world/item/ItemStack;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "inputItem;catalyst", "FIELD:Lmctech/u/o$a;->a:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/u/o$a;->b:Lnet/minecraft/world/item/ItemStack;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        public ItemStack a() {
            return this.a;
        }

        public ItemStack b() {
            return this.b;
        }

        @NotNull
        public ItemStack getItem(int i) {
            switch (i) {
                case 0:
                    return this.a;
                case 1:
                    return this.b;
                default:
                    return ItemStack.EMPTY;
            }
        }

        public int size() {
            return 2;
        }

        public boolean a(C0187o c0187o) {
            if (a().isEmpty()) {
                return false;
            }
            return (c0187o.a.a(this.a) && this.a.getCount() >= c0187o.a.d()) && ItemStack.isSameItemSameComponents(c0187o.b, this.b);
        }
    }

    /* JADX INFO: renamed from: mctech.u.o$b */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/o$b.class */
    public static class b implements RecipeSerializer<C0187o> {
        public static final MapCodec<C0187o> a = RecordCodecBuilder.mapCodec(instance -> {
            return instance.group(mctech.u.c.b.c.fieldOf("ingredient").forGetter((v0) -> {
                return v0.a();
            }), ItemStack.CODEC.fieldOf("catalyst").forGetter((v0) -> {
                return v0.b();
            }), ItemStack.CODEC.fieldOf("result").forGetter((v0) -> {
                return v0.c();
            })).apply(instance, C0187o::new);
        });
        public static final StreamCodec<RegistryFriendlyByteBuf, C0187o> b = StreamCodec.composite(mctech.u.c.b.b, (v0) -> {
            return v0.a();
        }, ItemStack.STREAM_CODEC, (v0) -> {
            return v0.b();
        }, ItemStack.STREAM_CODEC, (v0) -> {
            return v0.c();
        }, C0187o::new);

        @NotNull
        public MapCodec<C0187o> codec() {
            return a;
        }

        @NotNull
        public StreamCodec<RegistryFriendlyByteBuf, C0187o> streamCodec() {
            return b;
        }
    }
}
