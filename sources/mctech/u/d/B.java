package mctech.u.d;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import mctech.u.X;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/d/B.class */
public class B implements RecipeSerializer<X> {
    public static final MapCodec<X> a = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Ingredient.CODEC.fieldOf("ingredient").forGetter((v0) -> {
            return v0.h();
        }), ItemStack.CODEC.fieldOf("result").forGetter((v0) -> {
            return v0.l();
        }), Codec.DOUBLE.fieldOf("energy").forGetter((v0) -> {
            return v0.i();
        }), Codec.INT.fieldOf("cookingtime").forGetter((v0) -> {
            return v0.j();
        }), Codec.BOOL.fieldOf("stone").forGetter((v0) -> {
            return v0.k();
        })).apply(instance, (v1, v2, v3, v4, v5) -> {
            return new X(v1, v2, v3, v4, v5);
        });
    });
    public static final StreamCodec<RegistryFriendlyByteBuf, X> b = StreamCodec.composite(Ingredient.CONTENTS_STREAM_CODEC, (v0) -> {
        return v0.h();
    }, ItemStack.STREAM_CODEC, (v0) -> {
        return v0.l();
    }, ByteBufCodecs.DOUBLE, (v0) -> {
        return v0.i();
    }, ByteBufCodecs.INT, (v0) -> {
        return v0.j();
    }, ByteBufCodecs.BOOL, (v0) -> {
        return v0.k();
    }, (v1, v2, v3, v4, v5) -> {
        return new X(v1, v2, v3, v4, v5);
    });

    public MapCodec<X> codec() {
        return a;
    }

    public StreamCodec<RegistryFriendlyByteBuf, X> streamCodec() {
        return b;
    }
}
