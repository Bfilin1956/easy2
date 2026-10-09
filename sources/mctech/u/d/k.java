package mctech.u.d;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import mctech.u.C0189q;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/d/k.class */
public class k implements RecipeSerializer<C0189q> {
    public static final MapCodec<C0189q> a = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Ingredient.CODEC.fieldOf("ingredient").forGetter((v0) -> {
            return v0.b();
        }), Codec.INT.fieldOf("input_count").forGetter((v0) -> {
            return v0.a();
        }), ItemStack.CODEC.fieldOf("result").forGetter((v0) -> {
            return v0.e();
        }), Codec.DOUBLE.fieldOf("energy").forGetter((v0) -> {
            return v0.c();
        }), Codec.INT.fieldOf("cookingtime").forGetter((v0) -> {
            return v0.d();
        }), Codec.BOOL.fieldOf("charge").forGetter((v0) -> {
            return v0.f();
        })).apply(instance, (v1, v2, v3, v4, v5, v6) -> {
            return new C0189q(v1, v2, v3, v4, v5, v6);
        });
    });
    public static final StreamCodec<RegistryFriendlyByteBuf, C0189q> b = StreamCodec.composite(Ingredient.CONTENTS_STREAM_CODEC, (v0) -> {
        return v0.b();
    }, ByteBufCodecs.INT, (v0) -> {
        return v0.a();
    }, ItemStack.STREAM_CODEC, (v0) -> {
        return v0.e();
    }, ByteBufCodecs.DOUBLE, (v0) -> {
        return v0.c();
    }, ByteBufCodecs.INT, (v0) -> {
        return v0.d();
    }, ByteBufCodecs.BOOL, (v0) -> {
        return v0.f();
    }, (v1, v2, v3, v4, v5, v6) -> {
        return new C0189q(v1, v2, v3, v4, v5, v6);
    });

    public MapCodec<C0189q> codec() {
        return a;
    }

    public StreamCodec<RegistryFriendlyByteBuf, C0189q> streamCodec() {
        return b;
    }
}
