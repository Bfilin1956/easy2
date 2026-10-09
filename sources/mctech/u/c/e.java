package mctech.u.c;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.stream.Stream;
import mctech.init.MCTechIngredients;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.crafting.ICustomIngredient;
import net.neoforged.neoforge.common.crafting.IngredientType;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/c/e.class */
public final class e extends Record implements ICustomIngredient {
    private final ResourceLocation c;
    private final int d;
    public static final MapCodec<e> a = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(ResourceLocation.CODEC.fieldOf(mctech.g.a.a.b.a).forGetter((v0) -> {
            return v0.b();
        }), Codec.INT.fieldOf("count").forGetter((v0) -> {
            return v0.c();
        })).apply(instance, (v1, v2) -> {
            return new e(v1, v2);
        });
    });
    public static final StreamCodec<RegistryFriendlyByteBuf, e> b = StreamCodec.composite(ResourceLocation.STREAM_CODEC, (v0) -> {
        return v0.b();
    }, ByteBufCodecs.INT, (v0) -> {
        return v0.c();
    }, (v1, v2) -> {
        return new e(v1, v2);
    });

    public e(ResourceLocation resourceLocation, int i) {
        this.c = resourceLocation;
        this.d = i;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, e.class), e.class, "resourceLocation;count", "FIELD:Lmctech/u/c/e;->c:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lmctech/u/c/e;->d:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, e.class), e.class, "resourceLocation;count", "FIELD:Lmctech/u/c/e;->c:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lmctech/u/c/e;->d:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, e.class, Object.class), e.class, "resourceLocation;count", "FIELD:Lmctech/u/c/e;->c:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lmctech/u/c/e;->d:I").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public ResourceLocation b() {
        return this.c;
    }

    public int c() {
        return this.d;
    }

    public static e a(ResourceLocation resourceLocation, int i) {
        return new e(resourceLocation, i);
    }

    public boolean test(@NotNull ItemStack itemStack) {
        return ItemStack.isSameItemSameComponents(a(), itemStack);
    }

    @NotNull
    public Stream<ItemStack> getItems() {
        return Stream.of(a());
    }

    public boolean isSimple() {
        return false;
    }

    @NotNull
    public IngredientType<?> getType() {
        return (IngredientType) MCTechIngredients.RESOURCE_INGREDIENT.get();
    }

    public ItemStack a() {
        return new ItemStack((ItemLike) BuiltInRegistries.ITEM.get(this.c), this.d);
    }
}
