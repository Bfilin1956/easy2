package mctech.u.d;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import mctech.u.C0191s;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/d/l.class */
public class l implements RecipeSerializer<C0191s> {
    public static final MapCodec<C0191s> a = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Ingredient.CODEC.fieldOf("ingredient").forGetter((v0) -> {
            return v0.b();
        }), Codec.INT.fieldOf("amount").forGetter((v0) -> {
            return v0.c();
        }), ResourceLocation.CODEC.fieldOf("material").forGetter((v0) -> {
            return v0.d();
        }), Codec.STRING.fieldOf("color").forGetter((v0) -> {
            return v0.f();
        })).apply(instance, (v1, v2, v3, v4) -> {
            return new C0191s(v1, v2, v3, v4);
        });
    });
    public static final StreamCodec<RegistryFriendlyByteBuf, C0191s> b = StreamCodec.composite(Ingredient.CONTENTS_STREAM_CODEC, (v0) -> {
        return v0.b();
    }, ByteBufCodecs.INT, (v0) -> {
        return v0.c();
    }, ResourceLocation.STREAM_CODEC, (v0) -> {
        return v0.d();
    }, ByteBufCodecs.STRING_UTF8, (v0) -> {
        return v0.f();
    }, (v1, v2, v3, v4) -> {
        return new C0191s(v1, v2, v3, v4);
    });

    public MapCodec<C0191s> codec() {
        return a;
    }

    public StreamCodec<RegistryFriendlyByteBuf, C0191s> streamCodec() {
        return b;
    }
}
