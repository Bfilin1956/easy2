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
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: mctech.u.w, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/w.class */
public final class C0195w extends Record implements Recipe<a> {
    private final ResourceLocation a;
    private final List<b> b;

    public C0195w(ResourceLocation resourceLocation, List<b> list) {
        this.a = resourceLocation;
        this.b = list;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0195w.class), C0195w.class, "entity;resources", "FIELD:Lmctech/u/w;->a:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lmctech/u/w;->b:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0195w.class), C0195w.class, "entity;resources", "FIELD:Lmctech/u/w;->a:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lmctech/u/w;->b:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0195w.class, Object.class), C0195w.class, "entity;resources", "FIELD:Lmctech/u/w;->a:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lmctech/u/w;->b:Ljava/util/List;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public ResourceLocation b() {
        return this.a;
    }

    public List<b> c() {
        return this.b;
    }

    /* JADX INFO: renamed from: mctech.u.w$b */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/w$b.class */
    public static final class b extends Record {
        private final ItemStack c;
        private final int d;
        public static final Codec<b> a = RecordCodecBuilder.create(instance -> {
            return instance.group(BuiltInRegistries.ITEM.holderByNameCodec().fieldOf(mctech.g.a.a.b.a).forGetter(bVar -> {
                return bVar.c().getItemHolder();
            }), Codec.INT.optionalFieldOf("baseAmount", 1).forGetter((v0) -> {
                return v0.d();
            })).apply(instance, (holder, num) -> {
                return new b(new ItemStack(holder), num.intValue());
            });
        });
        public static final StreamCodec<RegistryFriendlyByteBuf, b> b = StreamCodec.composite(ItemStack.STREAM_CODEC, (v0) -> {
            return v0.c();
        }, ByteBufCodecs.VAR_INT, (v0) -> {
            return v0.d();
        }, (v1, v2) -> {
            return new b(v1, v2);
        });

        public b(ItemStack itemStack, int i) {
            this.c = itemStack;
            this.d = i;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, b.class), b.class, "item;baseAmount", "FIELD:Lmctech/u/w$b;->c:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/u/w$b;->d:I").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, b.class), b.class, "item;baseAmount", "FIELD:Lmctech/u/w$b;->c:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/u/w$b;->d:I").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, b.class, Object.class), b.class, "item;baseAmount", "FIELD:Lmctech/u/w$b;->c:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/u/w$b;->d:I").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        public ItemStack c() {
            return this.c;
        }

        public int d() {
            return this.d;
        }

        public boolean a() {
            return (this.c == null || this.c.isEmpty() || this.d <= 0) ? false : true;
        }

        public ItemStack b() {
            return this.c.copyWithCount(Math.max(1, this.d));
        }
    }

    @NotNull
    public NonNullList<Ingredient> getIngredients() {
        return NonNullList.create();
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean matches(@NotNull a aVar, @NotNull Level level) {
        return aVar.a(this);
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ItemStack assemble(@NotNull a aVar, HolderLookup.Provider provider) {
        return ItemStack.EMPTY;
    }

    @NotNull
    public ItemStack getResultItem(HolderLookup.Provider provider) {
        return ItemStack.EMPTY;
    }

    public boolean canCraftInDimensions(int i, int i2) {
        return true;
    }

    @NotNull
    public RecipeSerializer<?> getSerializer() {
        return (RecipeSerializer) MCTechRecipes.REGISTERED_SERIALIZERS.get("genetic_printer").get();
    }

    @NotNull
    public RecipeType<?> getType() {
        return (RecipeType) MCTechRecipes.REGISTERED_RECIPES.get("genetic_printer").get();
    }

    public boolean a() {
        return (this.a == null || this.b == null || this.b.isEmpty() || !this.b.stream().anyMatch((v0) -> {
            return v0.a();
        })) ? false : true;
    }

    /* JADX INFO: renamed from: mctech.u.w$a */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/w$a.class */
    public static final class a extends Record implements RecipeInput {
        private final ItemStack a;

        public a(ItemStack itemStack) {
            this.a = itemStack;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "dnaOrMaterialStack", "FIELD:Lmctech/u/w$a;->a:Lnet/minecraft/world/item/ItemStack;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "dnaOrMaterialStack", "FIELD:Lmctech/u/w$a;->a:Lnet/minecraft/world/item/ItemStack;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "dnaOrMaterialStack", "FIELD:Lmctech/u/w$a;->a:Lnet/minecraft/world/item/ItemStack;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
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

        public boolean a(C0195w c0195w) {
            if (this.a.isEmpty() || c0195w.b() == null) {
                return false;
            }
            return c0195w.b().equals(mctech.k.b.a(this.a));
        }
    }

    /* JADX INFO: renamed from: mctech.u.w$c */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/w$c.class */
    public static class c implements RecipeSerializer<C0195w> {
        public static final MapCodec<C0195w> a = RecordCodecBuilder.mapCodec(instance -> {
            return instance.group(ResourceLocation.CODEC.fieldOf("entity").forGetter((v0) -> {
                return v0.b();
            }), b.a.listOf().fieldOf("resources").forGetter((v0) -> {
                return v0.c();
            })).apply(instance, C0195w::new);
        });
        public static final StreamCodec<RegistryFriendlyByteBuf, C0195w> b = StreamCodec.composite(ResourceLocation.STREAM_CODEC, (v0) -> {
            return v0.b();
        }, b.b.apply(ByteBufCodecs.list()), (v0) -> {
            return v0.c();
        }, C0195w::new);

        @NotNull
        public MapCodec<C0195w> codec() {
            return a;
        }

        @NotNull
        public StreamCodec<RegistryFriendlyByteBuf, C0195w> streamCodec() {
            return b;
        }
    }
}
