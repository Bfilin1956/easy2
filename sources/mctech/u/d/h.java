package mctech.u.d;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import mctech.u.C0185m;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.neoforged.neoforge.fluids.crafting.FluidIngredient;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/d/h.class */
public class h implements RecipeSerializer<C0185m> {
    public static final MapCodec<C0185m> a = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Ingredient.CODEC.fieldOf("ingredient").orElse(Ingredient.EMPTY).forGetter((v0) -> {
            return v0.h();
        }), Codec.INT.fieldOf("input_count").orElse(0).forGetter((v0) -> {
            return v0.a();
        }), ItemStack.CODEC.fieldOf("result0").orElse(ItemStack.EMPTY).forGetter((v0) -> {
            return v0.b();
        }), ItemStack.CODEC.fieldOf("result1").orElse(ItemStack.EMPTY).forGetter((v0) -> {
            return v0.c();
        }), Codec.DOUBLE.fieldOf("energy").orElse(Double.valueOf(0.0d)).forGetter((v0) -> {
            return v0.i();
        }), Codec.INT.fieldOf("cookingtime").orElse(0).forGetter((v0) -> {
            return v0.j();
        }), FluidIngredient.CODEC.fieldOf("fluid").orElse(FluidIngredient.empty()).forGetter((v0) -> {
            return v0.e();
        }), Codec.INT.fieldOf("fluid_amount").orElse(0).forGetter((v0) -> {
            return v0.g();
        })).apply(instance, (v1, v2, v3, v4, v5, v6, v7, v8) -> {
            return new C0185m(v1, v2, v3, v4, v5, v6, v7, v8);
        });
    });
    public static final StreamCodec<RegistryFriendlyByteBuf, C0185m> b = i.a(Ingredient.CONTENTS_STREAM_CODEC, (v0) -> {
        return v0.h();
    }, ByteBufCodecs.INT, (v0) -> {
        return v0.a();
    }, ItemStack.STREAM_CODEC, (v0) -> {
        return v0.b();
    }, ItemStack.STREAM_CODEC, (v0) -> {
        return v0.c();
    }, ByteBufCodecs.DOUBLE, (v0) -> {
        return v0.i();
    }, ByteBufCodecs.INT, (v0) -> {
        return v0.j();
    }, FluidIngredient.STREAM_CODEC, (v0) -> {
        return v0.e();
    }, ByteBufCodecs.INT, (v0) -> {
        return v0.g();
    }, (v1, v2, v3, v4, v5, v6, v7, v8) -> {
        return new C0185m(v1, v2, v3, v4, v5, v6, v7, v8);
    });

    public MapCodec<C0185m> codec() {
        return a;
    }

    public StreamCodec<RegistryFriendlyByteBuf, C0185m> streamCodec() {
        return b;
    }
}
