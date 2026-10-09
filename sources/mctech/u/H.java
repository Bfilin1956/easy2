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
import net.neoforged.neoforge.fluids.FluidStack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/H.class */
public final class H extends Record implements Recipe<a> {
    private final mctech.u.c.b a;
    private final ItemStack b;
    private final int c;
    private final int d;
    private final FluidStack e;

    public H(mctech.u.c.b bVar, ItemStack itemStack, int i, int i2, FluidStack fluidStack) {
        this.a = bVar;
        this.b = itemStack;
        this.c = i;
        this.d = i2;
        this.e = fluidStack;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, H.class), H.class, "ingredient;resultStack;requiredEnergy;moduleLevel;resultFluid", "FIELD:Lmctech/u/H;->a:Lmctech/u/c/b;", "FIELD:Lmctech/u/H;->b:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/u/H;->c:I", "FIELD:Lmctech/u/H;->d:I", "FIELD:Lmctech/u/H;->e:Lnet/neoforged/neoforge/fluids/FluidStack;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, H.class), H.class, "ingredient;resultStack;requiredEnergy;moduleLevel;resultFluid", "FIELD:Lmctech/u/H;->a:Lmctech/u/c/b;", "FIELD:Lmctech/u/H;->b:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/u/H;->c:I", "FIELD:Lmctech/u/H;->d:I", "FIELD:Lmctech/u/H;->e:Lnet/neoforged/neoforge/fluids/FluidStack;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, H.class, Object.class), H.class, "ingredient;resultStack;requiredEnergy;moduleLevel;resultFluid", "FIELD:Lmctech/u/H;->a:Lmctech/u/c/b;", "FIELD:Lmctech/u/H;->b:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/u/H;->c:I", "FIELD:Lmctech/u/H;->d:I", "FIELD:Lmctech/u/H;->e:Lnet/neoforged/neoforge/fluids/FluidStack;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public mctech.u.c.b a() {
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

    public FluidStack e() {
        return this.e;
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
        return this.b;
    }

    public boolean canCraftInDimensions(int i, int i2) {
        return true;
    }

    @NotNull
    public RecipeSerializer<?> getSerializer() {
        return (RecipeSerializer) MCTechRecipes.REGISTERED_SERIALIZERS.get("mass_fabricator").get();
    }

    @NotNull
    public RecipeType<?> getType() {
        return (RecipeType) MCTechRecipes.REGISTERED_RECIPES.get("mass_fabricator").get();
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/H$a.class */
    public static final class a extends Record implements RecipeInput {
        private final ItemStack a;
        private final int b;
        private final boolean c;

        public a(ItemStack itemStack, int i, boolean z) {
            this.a = itemStack;
            this.b = i;
            this.c = z;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "inputItem;moduleLevel;canStoreFluid", "FIELD:Lmctech/u/H$a;->a:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/u/H$a;->b:I", "FIELD:Lmctech/u/H$a;->c:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "inputItem;moduleLevel;canStoreFluid", "FIELD:Lmctech/u/H$a;->a:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/u/H$a;->b:I", "FIELD:Lmctech/u/H$a;->c:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "inputItem;moduleLevel;canStoreFluid", "FIELD:Lmctech/u/H$a;->a:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/u/H$a;->b:I", "FIELD:Lmctech/u/H$a;->c:Z").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        public ItemStack a() {
            return this.a;
        }

        public int b() {
            return this.b;
        }

        public boolean c() {
            return this.c;
        }

        @NotNull
        public ItemStack getItem(int i) {
            return this.a;
        }

        public int size() {
            return 1;
        }

        public boolean a(H h) {
            if (a().isEmpty()) {
                return false;
            }
            boolean z = h.a.a(this.a) && this.a.getCount() >= h.a.d();
            if (!h.e().isEmpty()) {
                return z && h.d == this.b && this.c;
            }
            return z && h.d == this.b;
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/H$b.class */
    public static class b implements RecipeSerializer<H> {
        public static final MapCodec<H> a = RecordCodecBuilder.mapCodec(instance -> {
            return instance.group(mctech.u.c.b.c.fieldOf("ingredient").forGetter((v0) -> {
                return v0.a();
            }), ItemStack.CODEC.fieldOf("result").forGetter((v0) -> {
                return v0.b();
            }), Codec.INT.fieldOf("requiredEnergy").forGetter((v0) -> {
                return v0.c();
            }), Codec.INT.fieldOf("moduleLevel").forGetter((v0) -> {
                return v0.d();
            }), FluidStack.OPTIONAL_CODEC.optionalFieldOf("resultFluid", FluidStack.EMPTY).forGetter((v0) -> {
                return v0.e();
            })).apply(instance, (v1, v2, v3, v4, v5) -> {
                return new H(v1, v2, v3, v4, v5);
            });
        });
        public static final StreamCodec<RegistryFriendlyByteBuf, H> b = StreamCodec.composite(mctech.u.c.b.b, (v0) -> {
            return v0.a();
        }, ItemStack.STREAM_CODEC, (v0) -> {
            return v0.b();
        }, ByteBufCodecs.INT, (v0) -> {
            return v0.c();
        }, ByteBufCodecs.INT, (v0) -> {
            return v0.d();
        }, FluidStack.OPTIONAL_STREAM_CODEC, (v0) -> {
            return v0.e();
        }, (v1, v2, v3, v4, v5) -> {
            return new H(v1, v2, v3, v4, v5);
        });

        @NotNull
        public MapCodec<H> codec() {
            return a;
        }

        @NotNull
        public StreamCodec<RegistryFriendlyByteBuf, H> streamCodec() {
            return b;
        }
    }
}
