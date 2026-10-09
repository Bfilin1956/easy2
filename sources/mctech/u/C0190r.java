package mctech.u;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.ArrayList;
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

/* JADX INFO: renamed from: mctech.u.r, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/r.class */
public final class C0190r extends Record implements Recipe<a> {
    private final mctech.u.c.b a;
    private final mctech.u.c.b b;
    private final mctech.u.c.b c;
    private final ItemStack d;
    private final ItemStack e;

    public C0190r(mctech.u.c.b bVar, mctech.u.c.b bVar2, mctech.u.c.b bVar3, ItemStack itemStack, ItemStack itemStack2) {
        this.a = bVar;
        this.b = bVar2;
        this.c = bVar3;
        this.d = itemStack;
        this.e = itemStack2;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0190r.class), C0190r.class, "firstItem;secondItem;thirdItem;catalyst;resultStack", "FIELD:Lmctech/u/r;->a:Lmctech/u/c/b;", "FIELD:Lmctech/u/r;->b:Lmctech/u/c/b;", "FIELD:Lmctech/u/r;->c:Lmctech/u/c/b;", "FIELD:Lmctech/u/r;->d:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/u/r;->e:Lnet/minecraft/world/item/ItemStack;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0190r.class), C0190r.class, "firstItem;secondItem;thirdItem;catalyst;resultStack", "FIELD:Lmctech/u/r;->a:Lmctech/u/c/b;", "FIELD:Lmctech/u/r;->b:Lmctech/u/c/b;", "FIELD:Lmctech/u/r;->c:Lmctech/u/c/b;", "FIELD:Lmctech/u/r;->d:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/u/r;->e:Lnet/minecraft/world/item/ItemStack;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0190r.class, Object.class), C0190r.class, "firstItem;secondItem;thirdItem;catalyst;resultStack", "FIELD:Lmctech/u/r;->a:Lmctech/u/c/b;", "FIELD:Lmctech/u/r;->b:Lmctech/u/c/b;", "FIELD:Lmctech/u/r;->c:Lmctech/u/c/b;", "FIELD:Lmctech/u/r;->d:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/u/r;->e:Lnet/minecraft/world/item/ItemStack;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public mctech.u.c.b b() {
        return this.a;
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

    public ItemStack f() {
        return this.e;
    }

    @NotNull
    public NonNullList<Ingredient> getIngredients() {
        return NonNullList.copyOf(a().stream().map((v0) -> {
            return v0.c();
        }).toList());
    }

    public List<mctech.u.c.b> a() {
        ArrayList arrayList = new ArrayList();
        if (!this.a.a()) {
            arrayList.add(this.a);
        }
        if (!this.b.a()) {
            arrayList.add(this.b);
        }
        if (!this.c.a()) {
            arrayList.add(this.c);
        }
        if (arrayList.isEmpty()) {
            throw new IllegalStateException("Empty ingredients list");
        }
        return arrayList;
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
        return this.e;
    }

    public boolean canCraftInDimensions(int i, int i2) {
        return true;
    }

    @NotNull
    public RecipeSerializer<?> getSerializer() {
        return (RecipeSerializer) MCTechRecipes.REGISTERED_SERIALIZERS.get("electronic_plant").get();
    }

    @NotNull
    public RecipeType<?> getType() {
        return (RecipeType) MCTechRecipes.REGISTERED_RECIPES.get("electronic_plant").get();
    }

    /* JADX INFO: renamed from: mctech.u.r$a */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/r$a.class */
    public static final class a extends Record implements RecipeInput {
        private final ItemStack a;
        private final ItemStack b;
        private final ItemStack c;
        private final ItemStack d;

        public a(ItemStack itemStack, ItemStack itemStack2, ItemStack itemStack3, ItemStack itemStack4) {
            this.a = itemStack;
            this.b = itemStack2;
            this.c = itemStack3;
            this.d = itemStack4;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "firstItem;secondItem;thirdItem;catalyst", "FIELD:Lmctech/u/r$a;->a:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/u/r$a;->b:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/u/r$a;->c:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/u/r$a;->d:Lnet/minecraft/world/item/ItemStack;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "firstItem;secondItem;thirdItem;catalyst", "FIELD:Lmctech/u/r$a;->a:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/u/r$a;->b:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/u/r$a;->c:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/u/r$a;->d:Lnet/minecraft/world/item/ItemStack;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "firstItem;secondItem;thirdItem;catalyst", "FIELD:Lmctech/u/r$a;->a:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/u/r$a;->b:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/u/r$a;->c:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/u/r$a;->d:Lnet/minecraft/world/item/ItemStack;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        public ItemStack a() {
            return this.a;
        }

        public ItemStack b() {
            return this.b;
        }

        public ItemStack c() {
            return this.c;
        }

        public ItemStack d() {
            return this.d;
        }

        @NotNull
        public ItemStack getItem(int i) {
            switch (i) {
                case 0:
                    return this.a;
                case 1:
                    return this.b;
                case 2:
                    return this.c;
                case 3:
                    return this.d;
                default:
                    return ItemStack.EMPTY;
            }
        }

        private List<ItemStack> e() {
            ArrayList arrayList = new ArrayList();
            if (!this.a.isEmpty()) {
                arrayList.add(this.a);
            }
            if (!this.b.isEmpty()) {
                arrayList.add(this.b);
            }
            if (!this.c.isEmpty()) {
                arrayList.add(this.c);
            }
            return arrayList;
        }

        public int size() {
            return 4;
        }

        public boolean a(C0190r c0190r) {
            if (!((c0190r.d.isEmpty() && this.d.isEmpty()) || ItemStack.isSameItemSameComponents(c0190r.d, this.d))) {
                return false;
            }
            List<ItemStack> listE = e();
            ArrayList arrayList = new ArrayList(c0190r.a());
            if (listE.size() != arrayList.size()) {
                return false;
            }
            for (ItemStack itemStack : listE) {
                arrayList.removeIf(bVar -> {
                    return bVar.a(itemStack);
                });
            }
            return arrayList.isEmpty();
        }
    }

    /* JADX INFO: renamed from: mctech.u.r$b */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/r$b.class */
    public static class b implements RecipeSerializer<C0190r> {
        public static final MapCodec<C0190r> a = RecordCodecBuilder.mapCodec(instance -> {
            return instance.group(mctech.u.c.b.c.fieldOf("firstItem").forGetter((v0) -> {
                return v0.b();
            }), mctech.u.c.b.c.fieldOf("secondItem").forGetter((v0) -> {
                return v0.c();
            }), mctech.u.c.b.c.fieldOf("thirdItem").forGetter((v0) -> {
                return v0.d();
            }), ItemStack.OPTIONAL_CODEC.fieldOf("catalyst").forGetter((v0) -> {
                return v0.e();
            }), ItemStack.CODEC.fieldOf("result").forGetter((v0) -> {
                return v0.f();
            })).apply(instance, C0190r::new);
        });
        public static final StreamCodec<RegistryFriendlyByteBuf, C0190r> b = StreamCodec.composite(mctech.u.c.b.b, (v0) -> {
            return v0.b();
        }, mctech.u.c.b.b, (v0) -> {
            return v0.c();
        }, mctech.u.c.b.b, (v0) -> {
            return v0.d();
        }, ItemStack.OPTIONAL_STREAM_CODEC, (v0) -> {
            return v0.e();
        }, ItemStack.STREAM_CODEC, (v0) -> {
            return v0.f();
        }, C0190r::new);

        @NotNull
        public MapCodec<C0190r> codec() {
            return a;
        }

        @NotNull
        public StreamCodec<RegistryFriendlyByteBuf, C0190r> streamCodec() {
            return b;
        }
    }
}
