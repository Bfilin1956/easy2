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
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: mctech.u.x, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/x.class */
public final class C0196x extends Record implements Recipe<a> {
    private final Ingredient a;
    private final int b;
    private final c c;
    private final float d;
    private final boolean e;
    private final float f;
    private final float g;
    private final int h;
    private final int i;

    public C0196x(Ingredient ingredient, int i, c cVar, float f, boolean z, float f2, float f3, int i2, int i3) {
        this.a = ingredient;
        this.b = i;
        this.c = cVar;
        this.d = f;
        this.e = z;
        this.f = f2;
        this.g = f3;
        this.h = i2;
        this.i = i3;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0196x.class), C0196x.class, "catalyst;xpCost;target;successChance;penaltyOnFail;bonusDelta;penaltyDelta;durationTicks;energyCost", "FIELD:Lmctech/u/x;->a:Lnet/minecraft/world/item/crafting/Ingredient;", "FIELD:Lmctech/u/x;->b:I", "FIELD:Lmctech/u/x;->c:Lmctech/u/x$c;", "FIELD:Lmctech/u/x;->d:F", "FIELD:Lmctech/u/x;->e:Z", "FIELD:Lmctech/u/x;->f:F", "FIELD:Lmctech/u/x;->g:F", "FIELD:Lmctech/u/x;->h:I", "FIELD:Lmctech/u/x;->i:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0196x.class), C0196x.class, "catalyst;xpCost;target;successChance;penaltyOnFail;bonusDelta;penaltyDelta;durationTicks;energyCost", "FIELD:Lmctech/u/x;->a:Lnet/minecraft/world/item/crafting/Ingredient;", "FIELD:Lmctech/u/x;->b:I", "FIELD:Lmctech/u/x;->c:Lmctech/u/x$c;", "FIELD:Lmctech/u/x;->d:F", "FIELD:Lmctech/u/x;->e:Z", "FIELD:Lmctech/u/x;->f:F", "FIELD:Lmctech/u/x;->g:F", "FIELD:Lmctech/u/x;->h:I", "FIELD:Lmctech/u/x;->i:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0196x.class, Object.class), C0196x.class, "catalyst;xpCost;target;successChance;penaltyOnFail;bonusDelta;penaltyDelta;durationTicks;energyCost", "FIELD:Lmctech/u/x;->a:Lnet/minecraft/world/item/crafting/Ingredient;", "FIELD:Lmctech/u/x;->b:I", "FIELD:Lmctech/u/x;->c:Lmctech/u/x$c;", "FIELD:Lmctech/u/x;->d:F", "FIELD:Lmctech/u/x;->e:Z", "FIELD:Lmctech/u/x;->f:F", "FIELD:Lmctech/u/x;->g:F", "FIELD:Lmctech/u/x;->h:I", "FIELD:Lmctech/u/x;->i:I").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public Ingredient c() {
        return this.a;
    }

    public int d() {
        return this.b;
    }

    public c e() {
        return this.c;
    }

    public float f() {
        return this.d;
    }

    public boolean g() {
        return this.e;
    }

    public float h() {
        return this.f;
    }

    public float i() {
        return this.g;
    }

    public int j() {
        return this.h;
    }

    public int k() {
        return this.i;
    }

    /* JADX INFO: renamed from: mctech.u.x$c */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/x$c.class */
    public enum c implements StringRepresentable {
        BONUS_CHANCE("bonusChance"),
        LUCK("luck");

        private final String e;
        public static final Codec<c> c = StringRepresentable.fromEnum(c::values);
        public static final StreamCodec<RegistryFriendlyByteBuf, c> d = StreamCodec.of((registryFriendlyByteBuf, cVar) -> {
            registryFriendlyByteBuf.writeVarInt(cVar.ordinal());
        }, registryFriendlyByteBuf2 -> {
            return values()[registryFriendlyByteBuf2.readVarInt()];
        });

        c(String str) {
            this.e = str;
        }

        @NotNull
        public String getSerializedName() {
            return this.e;
        }
    }

    @NotNull
    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> nonNullListCreate = NonNullList.create();
        nonNullListCreate.add(this.a);
        return nonNullListCreate;
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
        return (RecipeSerializer) MCTechRecipes.REGISTERED_SERIALIZERS.get("genetic_stabilizer").get();
    }

    @NotNull
    public RecipeType<?> getType() {
        return (RecipeType) MCTechRecipes.REGISTERED_RECIPES.get("genetic_stabilizer").get();
    }

    public boolean a() {
        return this.a != null && !this.a.isEmpty() && this.b > 0 && this.c != null && this.d > 0.0f && this.h > 0 && this.i > 0 && this.f > 0.0f;
    }

    public int b() {
        return Math.max(1, this.i / Math.max(1, this.h));
    }

    /* JADX INFO: renamed from: mctech.u.x$a */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/x$a.class */
    public static final class a extends Record implements RecipeInput {
        private final ItemStack a;

        public a(ItemStack itemStack) {
            this.a = itemStack;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "catalystStack", "FIELD:Lmctech/u/x$a;->a:Lnet/minecraft/world/item/ItemStack;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "catalystStack", "FIELD:Lmctech/u/x$a;->a:Lnet/minecraft/world/item/ItemStack;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "catalystStack", "FIELD:Lmctech/u/x$a;->a:Lnet/minecraft/world/item/ItemStack;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
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

        public boolean a(C0196x c0196x) {
            return !this.a.isEmpty() && c0196x.c().test(this.a);
        }
    }

    /* JADX INFO: renamed from: mctech.u.x$b */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/x$b.class */
    public static class b implements RecipeSerializer<C0196x> {
        public static final MapCodec<C0196x> a = RecordCodecBuilder.mapCodec(instance -> {
            return instance.group(Ingredient.CODEC_NONEMPTY.fieldOf("catalyst").forGetter((v0) -> {
                return v0.c();
            }), Codec.INT.fieldOf("xpCost").forGetter((v0) -> {
                return v0.d();
            }), c.c.fieldOf("target").forGetter((v0) -> {
                return v0.e();
            }), Codec.FLOAT.fieldOf("successChance").forGetter((v0) -> {
                return v0.f();
            }), Codec.BOOL.fieldOf("penaltyOnFail").forGetter((v0) -> {
                return v0.g();
            }), Codec.FLOAT.fieldOf("bonusDelta").forGetter((v0) -> {
                return v0.h();
            }), Codec.FLOAT.fieldOf("penaltyDelta").forGetter((v0) -> {
                return v0.i();
            }), Codec.INT.fieldOf("durationTicks").forGetter((v0) -> {
                return v0.j();
            }), Codec.INT.fieldOf("energyCost").forGetter((v0) -> {
                return v0.k();
            })).apply(instance, (v1, v2, v3, v4, v5, v6, v7, v8, v9) -> {
                return new C0196x(v1, v2, v3, v4, v5, v6, v7, v8, v9);
            });
        });
        public static final StreamCodec<RegistryFriendlyByteBuf, C0196x> b = StreamCodec.of((registryFriendlyByteBuf, c0196x) -> {
            Ingredient.CONTENTS_STREAM_CODEC.encode(registryFriendlyByteBuf, c0196x.c());
            registryFriendlyByteBuf.writeVarInt(c0196x.d());
            c.d.encode(registryFriendlyByteBuf, c0196x.e());
            registryFriendlyByteBuf.writeFloat(c0196x.f());
            registryFriendlyByteBuf.writeBoolean(c0196x.g());
            registryFriendlyByteBuf.writeFloat(c0196x.h());
            registryFriendlyByteBuf.writeFloat(c0196x.i());
            registryFriendlyByteBuf.writeVarInt(c0196x.j());
            registryFriendlyByteBuf.writeVarInt(c0196x.k());
        }, registryFriendlyByteBuf2 -> {
            return new C0196x((Ingredient) Ingredient.CONTENTS_STREAM_CODEC.decode(registryFriendlyByteBuf2), registryFriendlyByteBuf2.readVarInt(), (c) c.d.decode(registryFriendlyByteBuf2), registryFriendlyByteBuf2.readFloat(), registryFriendlyByteBuf2.readBoolean(), registryFriendlyByteBuf2.readFloat(), registryFriendlyByteBuf2.readFloat(), registryFriendlyByteBuf2.readVarInt(), registryFriendlyByteBuf2.readVarInt());
        });

        @NotNull
        public MapCodec<C0196x> codec() {
            return a;
        }

        @NotNull
        public StreamCodec<RegistryFriendlyByteBuf, C0196x> streamCodec() {
            return b;
        }
    }
}
