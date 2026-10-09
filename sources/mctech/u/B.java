package mctech.u;

import com.mojang.serialization.Codec;
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

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/B.class */
public final class B extends Record implements Recipe<a> {
    private final NonNullList<mctech.u.c.b> b;
    private final ItemStack c;
    private final int d;
    private final int e;
    private final boolean f;
    public static final int a = 7;

    public B(NonNullList<mctech.u.c.b> nonNullList, ItemStack itemStack, int i, int i2, boolean z) {
        this.b = nonNullList;
        this.c = itemStack;
        this.d = i;
        this.e = i2;
        this.f = z;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, B.class), B.class, "inputs;output;energyCost;speed;migrateData", "FIELD:Lmctech/u/B;->b:Lnet/minecraft/core/NonNullList;", "FIELD:Lmctech/u/B;->c:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/u/B;->d:I", "FIELD:Lmctech/u/B;->e:I", "FIELD:Lmctech/u/B;->f:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, B.class), B.class, "inputs;output;energyCost;speed;migrateData", "FIELD:Lmctech/u/B;->b:Lnet/minecraft/core/NonNullList;", "FIELD:Lmctech/u/B;->c:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/u/B;->d:I", "FIELD:Lmctech/u/B;->e:I", "FIELD:Lmctech/u/B;->f:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, B.class, Object.class), B.class, "inputs;output;energyCost;speed;migrateData", "FIELD:Lmctech/u/B;->b:Lnet/minecraft/core/NonNullList;", "FIELD:Lmctech/u/B;->c:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/u/B;->d:I", "FIELD:Lmctech/u/B;->e:I", "FIELD:Lmctech/u/B;->f:Z").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public NonNullList<mctech.u.c.b> a() {
        return this.b;
    }

    public ItemStack b() {
        return this.c;
    }

    public int c() {
        return this.d;
    }

    public int d() {
        return this.e;
    }

    public boolean e() {
        return this.f;
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean matches(@NotNull a aVar, @NotNull Level level) {
        for (int i = 0; i < 7; i++) {
            mctech.u.c.b bVar = (mctech.u.c.b) this.b.get(i);
            ItemStack item = aVar.getItem(i);
            if (!bVar.a(item) || bVar.d() > item.getCount()) {
                return false;
            }
        }
        return true;
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ItemStack assemble(@NotNull a aVar, HolderLookup.Provider provider) {
        return this.c.copy();
    }

    @NotNull
    public NonNullList<Ingredient> getIngredients() {
        return NonNullList.copyOf(this.b.stream().map((v0) -> {
            return v0.c();
        }).toList());
    }

    public boolean canCraftInDimensions(int i, int i2) {
        return i * i2 >= 7;
    }

    @NotNull
    public ItemStack getResultItem(HolderLookup.Provider provider) {
        return this.c;
    }

    @NotNull
    public RecipeSerializer<?> getSerializer() {
        return MCTechRecipes.serializer("industrial_forge");
    }

    @NotNull
    public RecipeType<?> getType() {
        return MCTechRecipes.type("industrial_forge");
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/B$a.class */
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

    @NotNull
    private static B a(@NotNull NonNullList<mctech.u.c.b> nonNullList, ItemStack itemStack, int i, int i2, boolean z) {
        if (nonNullList.size() != 7) {
            throw new IllegalArgumentException("Incorrect number of input elements");
        }
        return new B(nonNullList, itemStack, i, i2, z);
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/B$b.class */
    public static class b implements RecipeSerializer<B> {
        public static final MapCodec<B> a = RecordCodecBuilder.mapCodec(instance -> {
            return instance.group(NonNullList.codecOf(mctech.u.c.b.c).fieldOf("inputs").forGetter((v0) -> {
                return v0.a();
            }), ItemStack.CODEC.fieldOf("output").forGetter((v0) -> {
                return v0.b();
            }), Codec.INT.fieldOf("energyCost").forGetter((v0) -> {
                return v0.c();
            }), Codec.INT.fieldOf("speed").forGetter((v0) -> {
                return v0.d();
            }), Codec.BOOL.fieldOf("migrateData").forGetter((v0) -> {
                return v0.e();
            })).apply(instance, (v0, v1, v2, v3, v4) -> {
                return B.a(v0, v1, v2, v3, v4);
            });
        });
        public static final StreamCodec<RegistryFriendlyByteBuf, B> b = StreamCodec.composite(ByteBufCodecs.collection(NonNullList::createWithCapacity, mctech.u.c.b.b), (v0) -> {
            return v0.a();
        }, ItemStack.STREAM_CODEC, (v0) -> {
            return v0.b();
        }, ByteBufCodecs.INT, (v0) -> {
            return v0.c();
        }, ByteBufCodecs.INT, (v0) -> {
            return v0.d();
        }, ByteBufCodecs.BOOL, (v0) -> {
            return v0.e();
        }, (v1, v2, v3, v4, v5) -> {
            return new B(v1, v2, v3, v4, v5);
        });

        @NotNull
        public MapCodec<B> codec() {
            return a;
        }

        @NotNull
        public StreamCodec<RegistryFriendlyByteBuf, B> streamCodec() {
            return b;
        }
    }
}
