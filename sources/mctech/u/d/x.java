package mctech.u.d;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import mctech.u.R;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/d/x.class */
public class x implements RecipeSerializer<R> {
    public static final MapCodec<R> a = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Ingredient.CODEC.fieldOf("ingredient").forGetter((v0) -> {
            return v0.b();
        }), Codec.FLOAT.fieldOf("amount").forGetter((v0) -> {
            return v0.c();
        }), ResourceLocation.CODEC.fieldOf("material").forGetter((v0) -> {
            return v0.d();
        })).apply(instance, (v1, v2, v3) -> {
            return new R(v1, v2, v3);
        });
    });
    public static final StreamCodec<RegistryFriendlyByteBuf, R> b = StreamCodec.composite(Ingredient.CONTENTS_STREAM_CODEC, (v0) -> {
        return v0.b();
    }, ByteBufCodecs.FLOAT, (v0) -> {
        return v0.c();
    }, ResourceLocation.STREAM_CODEC, (v0) -> {
        return v0.d();
    }, (v1, v2, v3) -> {
        return new R(v1, v2, v3);
    });

    public MapCodec<R> codec() {
        return a;
    }

    public StreamCodec<RegistryFriendlyByteBuf, R> streamCodec() {
        return b;
    }
}
