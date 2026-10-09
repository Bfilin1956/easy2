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

/* JADX INFO: renamed from: mctech.u.v, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/v.class */
public final class C0194v extends Record implements Recipe<a> {
    private final mctech.u.c.b a;
    private final ItemStack b;
    private final int c;
    private final int d;

    public C0194v(mctech.u.c.b bVar, ItemStack itemStack, int i, int i2) {
        this.a = bVar;
        this.b = itemStack;
        this.c = i;
        this.d = i2;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0194v.class), C0194v.class, "ingredient;resultStack;requiredEnergy;requiredTime", "FIELD:Lmctech/u/v;->a:Lmctech/u/c/b;", "FIELD:Lmctech/u/v;->b:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/u/v;->c:I", "FIELD:Lmctech/u/v;->d:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0194v.class), C0194v.class, "ingredient;resultStack;requiredEnergy;requiredTime", "FIELD:Lmctech/u/v;->a:Lmctech/u/c/b;", "FIELD:Lmctech/u/v;->b:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/u/v;->c:I", "FIELD:Lmctech/u/v;->d:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0194v.class, Object.class), C0194v.class, "ingredient;resultStack;requiredEnergy;requiredTime", "FIELD:Lmctech/u/v;->a:Lmctech/u/c/b;", "FIELD:Lmctech/u/v;->b:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/u/v;->c:I", "FIELD:Lmctech/u/v;->d:I").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
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
        return (RecipeSerializer) MCTechRecipes.REGISTERED_SERIALIZERS.get("forming_machine").get();
    }

    @NotNull
    public RecipeType<?> getType() {
        return (RecipeType) MCTechRecipes.REGISTERED_RECIPES.get("forming_machine").get();
    }

    /* JADX INFO: renamed from: mctech.u.v$a */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/v$a.class */
    public static final class a extends Record implements RecipeInput {
        private final ItemStack a;

        public a(ItemStack itemStack) {
            this.a = itemStack;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "inputItem", "FIELD:Lmctech/u/v$a;->a:Lnet/minecraft/world/item/ItemStack;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "inputItem", "FIELD:Lmctech/u/v$a;->a:Lnet/minecraft/world/item/ItemStack;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "inputItem", "FIELD:Lmctech/u/v$a;->a:Lnet/minecraft/world/item/ItemStack;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
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

        public boolean a(C0194v c0194v) {
            return !a().isEmpty() && c0194v.a.a(this.a) && this.a.getCount() >= c0194v.a.d();
        }
    }

    /* JADX INFO: renamed from: mctech.u.v$b */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/v$b.class */
    public static class b implements RecipeSerializer<C0194v> {
        public static final MapCodec<C0194v> a = RecordCodecBuilder.mapCodec(instance -> {
            return instance.group(mctech.u.c.b.c.fieldOf("ingredient").forGetter((v0) -> {
                return v0.a();
            }), ItemStack.CODEC.fieldOf("result").forGetter((v0) -> {
                return v0.b();
            }), Codec.INT.fieldOf("energy").forGetter((v0) -> {
                return v0.c();
            }), Codec.INT.fieldOf("requiredTime").forGetter((v0) -> {
                return v0.d();
            })).apply(instance, (v1, v2, v3, v4) -> {
                return new C0194v(v1, v2, v3, v4);
            });
        });
        public static final StreamCodec<RegistryFriendlyByteBuf, C0194v> b = StreamCodec.composite(mctech.u.c.b.b, (v0) -> {
            return v0.a();
        }, ItemStack.STREAM_CODEC, (v0) -> {
            return v0.b();
        }, ByteBufCodecs.INT, (v0) -> {
            return v0.c();
        }, ByteBufCodecs.INT, (v0) -> {
            return v0.d();
        }, (v1, v2, v3, v4) -> {
            return new C0194v(v1, v2, v3, v4);
        });

        @NotNull
        public MapCodec<C0194v> codec() {
            return a;
        }

        @NotNull
        public StreamCodec<RegistryFriendlyByteBuf, C0194v> streamCodec() {
            return b;
        }
    }
}
