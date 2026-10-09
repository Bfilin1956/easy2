package mctech.u;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.List;
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

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/Z.class */
public final class Z extends Record implements Recipe<a> {
    private final mctech.u.c.b b;
    private final mctech.u.c.b c;
    private final ItemStack d;
    public static final int a = 2;

    public Z(mctech.u.c.b bVar, mctech.u.c.b bVar2, ItemStack itemStack) {
        this.b = bVar;
        this.c = bVar2;
        this.d = itemStack;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, Z.class), Z.class, "firstInput;secondInput;output", "FIELD:Lmctech/u/Z;->b:Lmctech/u/c/b;", "FIELD:Lmctech/u/Z;->c:Lmctech/u/c/b;", "FIELD:Lmctech/u/Z;->d:Lnet/minecraft/world/item/ItemStack;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, Z.class), Z.class, "firstInput;secondInput;output", "FIELD:Lmctech/u/Z;->b:Lmctech/u/c/b;", "FIELD:Lmctech/u/Z;->c:Lmctech/u/c/b;", "FIELD:Lmctech/u/Z;->d:Lnet/minecraft/world/item/ItemStack;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, Z.class, Object.class), Z.class, "firstInput;secondInput;output", "FIELD:Lmctech/u/Z;->b:Lmctech/u/c/b;", "FIELD:Lmctech/u/Z;->c:Lmctech/u/c/b;", "FIELD:Lmctech/u/Z;->d:Lnet/minecraft/world/item/ItemStack;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public mctech.u.c.b c() {
        return this.b;
    }

    public mctech.u.c.b d() {
        return this.c;
    }

    public ItemStack e() {
        return this.d;
    }

    public NonNullList<mctech.u.c.b> a() {
        NonNullList<mctech.u.c.b> nonNullListWithSize = NonNullList.withSize(2, mctech.u.c.b.a);
        nonNullListWithSize.set(0, this.b);
        nonNullListWithSize.set(1, this.c);
        return nonNullListWithSize;
    }

    public int b() {
        return 0;
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean matches(@NotNull a aVar, @NotNull Level level) {
        return this.b.a(aVar.getItem(0)) && this.c.a(aVar.getItem(1));
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ItemStack assemble(@NotNull a aVar, HolderLookup.Provider provider) {
        return this.d.copy();
    }

    @NotNull
    public NonNullList<Ingredient> getIngredients() {
        return NonNullList.of(Ingredient.EMPTY, new Ingredient[]{this.b.c(), this.c.c()});
    }

    public boolean canCraftInDimensions(int i, int i2) {
        return i * i2 >= 2;
    }

    @NotNull
    public ItemStack getResultItem(HolderLookup.Provider provider) {
        return this.d;
    }

    @NotNull
    public RecipeSerializer<?> getSerializer() {
        return MCTechRecipes.serializer(mctech.i.i.TRANSFORMATION_ASSEMBLER.getSerializedName());
    }

    @NotNull
    public RecipeType<?> getType() {
        return MCTechRecipes.type(mctech.i.i.TRANSFORMATION_ASSEMBLER.getSerializedName());
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/Z$a.class */
    public static class a implements RecipeInput {

        @NotNull
        private final List<ItemStack> a;

        public a(@NotNull List<ItemStack> list) {
            this.a = list;
        }

        @NotNull
        public ItemStack getItem(int i) {
            return this.a.get(i);
        }

        public int size() {
            return this.a.size();
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/Z$b.class */
    public static class b implements RecipeSerializer<Z> {
        public static final MapCodec<Z> a = RecordCodecBuilder.mapCodec(instance -> {
            return instance.group(mctech.u.c.b.c.fieldOf("firstInput").forGetter((v0) -> {
                return v0.c();
            }), mctech.u.c.b.c.fieldOf("secondInput").forGetter((v0) -> {
                return v0.d();
            }), ItemStack.CODEC.fieldOf("output").forGetter((v0) -> {
                return v0.e();
            })).apply(instance, Z::new);
        });
        public static final StreamCodec<RegistryFriendlyByteBuf, Z> b = StreamCodec.composite(mctech.u.c.b.b, (v0) -> {
            return v0.c();
        }, mctech.u.c.b.b, (v0) -> {
            return v0.d();
        }, ItemStack.STREAM_CODEC, (v0) -> {
            return v0.e();
        }, Z::new);

        @NotNull
        public MapCodec<Z> codec() {
            return a;
        }

        @NotNull
        public StreamCodec<RegistryFriendlyByteBuf, Z> streamCodec() {
            return b;
        }
    }
}
