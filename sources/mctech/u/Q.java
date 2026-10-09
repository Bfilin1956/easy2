package mctech.u;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mctech.init.MCTechRecipes;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/Q.class */
public final class Q extends Record implements Recipe<b> {
    private final List<String> a;
    private final Map<Character, mctech.u.c.b> b;
    private final ItemStack c;
    private final int d;
    private final int e;

    public Q(List<String> list, Map<Character, mctech.u.c.b> map, ItemStack itemStack, int i, int i2) {
        this.a = list;
        this.b = map;
        this.c = itemStack;
        this.d = i;
        this.e = i2;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, Q.class), Q.class, "pattern;ingredients;resultStack;requiredEnergy;requiredTime", "FIELD:Lmctech/u/Q;->a:Ljava/util/List;", "FIELD:Lmctech/u/Q;->b:Ljava/util/Map;", "FIELD:Lmctech/u/Q;->c:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/u/Q;->d:I", "FIELD:Lmctech/u/Q;->e:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, Q.class), Q.class, "pattern;ingredients;resultStack;requiredEnergy;requiredTime", "FIELD:Lmctech/u/Q;->a:Ljava/util/List;", "FIELD:Lmctech/u/Q;->b:Ljava/util/Map;", "FIELD:Lmctech/u/Q;->c:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/u/Q;->d:I", "FIELD:Lmctech/u/Q;->e:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, Q.class, Object.class), Q.class, "pattern;ingredients;resultStack;requiredEnergy;requiredTime", "FIELD:Lmctech/u/Q;->a:Ljava/util/List;", "FIELD:Lmctech/u/Q;->b:Ljava/util/Map;", "FIELD:Lmctech/u/Q;->c:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/u/Q;->d:I", "FIELD:Lmctech/u/Q;->e:I").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public List<String> b() {
        return this.a;
    }

    public Map<Character, mctech.u.c.b> c() {
        return this.b;
    }

    public ItemStack d() {
        return this.c;
    }

    public int e() {
        return this.d;
    }

    public int f() {
        return this.e;
    }

    @NotNull
    public NonNullList<Ingredient> getIngredients() {
        return NonNullList.of(Ingredient.of(), new Ingredient[]{Ingredient.of((ItemStack[]) a().toArray(new ItemStack[0]))});
    }

    public List<ItemStack> a() {
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = this.a.iterator();
        while (it.hasNext()) {
            for (char c2 : it.next().toCharArray()) {
                if (c2 != ' ') {
                    arrayList.add(this.b.get(Character.valueOf(c2)).b());
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean matches(@NotNull b bVar, @NotNull Level level) {
        int iMin = Math.min(this.a.size(), 7);
        if (iMin == 0) {
            return false;
        }
        int iMax = 0;
        for (int i = 0; i < iMin; i++) {
            iMax = Math.max(iMax, Math.min(this.a.get(i).length(), 7));
        }
        if (iMax == 0 || bVar.size() < 49) {
            return false;
        }
        for (int i2 = 0; i2 <= 7 - iMin; i2++) {
            for (int i3 = 0; i3 <= 7 - iMax; i3++) {
                if (a(bVar, i3, i2, iMax, iMin)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean a(b bVar, int i, int i2, int i3, int i4) {
        int i5 = 0;
        while (i5 < 7) {
            int i6 = 0;
            while (i6 < 7) {
                ItemStack item = bVar.getItem((i5 * 7) + i6);
                if (!(i6 >= i && i6 < i + i3 && i5 >= i2 && i5 < i2 + i4)) {
                    if (!item.isEmpty()) {
                        return false;
                    }
                } else {
                    int i7 = i6 - i;
                    String str = this.a.get(i5 - i2);
                    char cCharAt = i7 < str.length() ? str.charAt(i7) : ' ';
                    if (cCharAt == ' ') {
                        if (!item.isEmpty()) {
                            return false;
                        }
                    } else {
                        mctech.u.c.b bVar2 = this.b.get(Character.valueOf(cCharAt));
                        if (bVar2 == null || bVar2.a() || !bVar2.a(item)) {
                            return false;
                        }
                    }
                }
                i6++;
            }
            i5++;
        }
        return true;
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ItemStack assemble(@NotNull b bVar, HolderLookup.Provider provider) {
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
        return (RecipeSerializer) MCTechRecipes.REGISTERED_SERIALIZERS.get(mctech.i.i.QUANTUM_WORKBENCH.getSerializedName()).get();
    }

    @NotNull
    public RecipeType<?> getType() {
        return (RecipeType) MCTechRecipes.REGISTERED_RECIPES.get(mctech.i.i.QUANTUM_WORKBENCH.getSerializedName()).get();
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/Q$b.class */
    public static final class b extends Record implements RecipeInput {
        private final List<ItemStack> a;

        public b(List<ItemStack> list) {
            this.a = list;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, b.class), b.class, "itemStacks", "FIELD:Lmctech/u/Q$b;->a:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, b.class), b.class, "itemStacks", "FIELD:Lmctech/u/Q$b;->a:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, b.class, Object.class), b.class, "itemStacks", "FIELD:Lmctech/u/Q$b;->a:Ljava/util/List;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        public List<ItemStack> a() {
            return this.a;
        }

        @NotNull
        public ItemStack getItem(int i) {
            return this.a.get(i);
        }

        public int size() {
            return this.a.size();
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/Q$c.class */
    public static class c implements RecipeSerializer<Q> {
        private static final Codec<Character> c = Codec.STRING.comapFlatMap(str -> {
            if (str.length() != 1) {
                return DataResult.error(() -> {
                    return "Invalid key entry: '" + str + "' is an invalid symbol (must be 1 character only).";
                });
            }
            return " ".equals(str) ? DataResult.error(() -> {
                return "Invalid key entry: ' ' is a reserved symbol.";
            }) : DataResult.success(Character.valueOf(str.charAt(0)));
        }, (v0) -> {
            return String.valueOf(v0);
        });
        private static final StreamCodec<RegistryFriendlyByteBuf, Character> d = StreamCodec.of((registryFriendlyByteBuf, ch) -> {
            registryFriendlyByteBuf.writeChar(ch.charValue());
        }, (v0) -> {
            return v0.readChar();
        });
        public static final MapCodec<Q> a = RecordCodecBuilder.mapCodec(instance -> {
            return instance.group(Codec.STRING.listOf().optionalFieldOf("pattern", new ArrayList()).forGetter((v0) -> {
                return v0.b();
            }), ExtraCodecs.strictUnboundedMap(c, mctech.u.c.b.c).fieldOf("ingredients").forGetter((v0) -> {
                return v0.c();
            }), ItemStack.CODEC.fieldOf("result").forGetter((v0) -> {
                return v0.d();
            }), Codec.INT.fieldOf("requiredEnergy").forGetter((v0) -> {
                return v0.e();
            }), Codec.INT.fieldOf("requiredTime").forGetter((v0) -> {
                return v0.f();
            })).apply(instance, (v1, v2, v3, v4, v5) -> {
                return new Q(v1, v2, v3, v4, v5);
            });
        });
        public static final StreamCodec<RegistryFriendlyByteBuf, Q> b = StreamCodec.composite(ByteBufCodecs.STRING_UTF8.apply(ByteBufCodecs.list()), (v0) -> {
            return v0.b();
        }, ByteBufCodecs.map(HashMap::new, d, mctech.u.c.b.b), (v0) -> {
            return v0.c();
        }, ItemStack.STREAM_CODEC, (v0) -> {
            return v0.d();
        }, ByteBufCodecs.INT, (v0) -> {
            return v0.e();
        }, ByteBufCodecs.INT, (v0) -> {
            return v0.f();
        }, (v1, v2, v3, v4, v5) -> {
            return new Q(v1, v2, v3, v4, v5);
        });

        @NotNull
        public MapCodec<Q> codec() {
            return a;
        }

        @NotNull
        public StreamCodec<RegistryFriendlyByteBuf, Q> streamCodec() {
            return b;
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/Q$a.class */
    public static class a {
        private final ItemStack a;
        private final List<String> b = Lists.newArrayList();
        private final Map<Character, mctech.u.c.b> c = Maps.newLinkedHashMap();
        private int d = 0;
        private int e = 0;

        public a(ItemStack itemStack) {
            this.a = itemStack;
        }

        public static a a(ItemLike itemLike) {
            return a(itemLike, 1);
        }

        public static a a(ItemLike itemLike, int i) {
            return new a(new ItemStack(itemLike, i));
        }

        public static a a(ItemStack itemStack) {
            return new a(itemStack);
        }

        public a a(char c, TagKey<Item> tagKey, int i) {
            return a(c, mctech.u.c.b.a(Ingredient.of(tagKey), i));
        }

        public a a(char c, ItemLike itemLike, int i) {
            return a(c, mctech.u.c.b.a(Ingredient.of(new ItemLike[]{itemLike}), i));
        }

        public a a(char c, Ingredient ingredient, int i) {
            return a(c, mctech.u.c.b.a(ingredient, i));
        }

        public a a(char c, mctech.u.c.b bVar) {
            if (this.c.containsKey(Character.valueOf(c))) {
                throw new IllegalArgumentException("Symbol '" + c + "' is already defined!");
            }
            if (c == ' ') {
                throw new IllegalArgumentException("Symbol ' ' (whitespace) is reserved and cannot be defined");
            }
            this.c.put(Character.valueOf(c), bVar);
            return this;
        }

        public a a(char c, ResourceLocation resourceLocation, int i) {
            return a(c, mctech.u.c.e.a(resourceLocation, i).toVanilla(), i);
        }

        public a a(char c, String str, int i) {
            return a(c, ResourceLocation.parse(String.format("kubejs:%s", str)), i);
        }

        public a a(String str) {
            if (!this.b.isEmpty() && str.length() != ((String) this.b.getFirst()).length()) {
                throw new IllegalArgumentException("Pattern must be the same width on every line!");
            }
            if (str.length() > 7) {
                throw new IllegalArgumentException("Pattern line too long, max width is 7!");
            }
            if (this.b.size() >= 7) {
                throw new IllegalArgumentException("Too many pattern rows, max height is 7!");
            }
            this.b.add(str);
            return this;
        }

        public a a(int i) {
            this.d = i;
            return this;
        }

        public a b(int i) {
            this.e = i;
            return this;
        }

        public Q a() {
            return new Q(this.b, this.c, this.a, this.d, this.e);
        }
    }
}
