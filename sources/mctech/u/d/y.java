package mctech.u.d;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import mctech.u.S;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeSerializer;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/d/y.class */
public class y implements RecipeSerializer<S> {
    public static final MapCodec<S> a = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(ItemStack.CODEC.fieldOf("result").forGetter((v0) -> {
            return v0.b();
        }), Codec.FLOAT.fieldOf("amount").forGetter((v0) -> {
            return v0.c();
        }), ResourceLocation.CODEC.fieldOf("material").forGetter((v0) -> {
            return v0.d();
        })).apply(instance, (v1, v2, v3) -> {
            return new S(v1, v2, v3);
        });
    });
    public static final StreamCodec<RegistryFriendlyByteBuf, S> b = StreamCodec.composite(ItemStack.STREAM_CODEC, (v0) -> {
        return v0.b();
    }, ByteBufCodecs.FLOAT, (v0) -> {
        return v0.c();
    }, ResourceLocation.STREAM_CODEC, (v0) -> {
        return v0.d();
    }, (v1, v2, v3) -> {
        return new S(v1, v2, v3);
    });

    public MapCodec<S> codec() {
        return a;
    }

    public StreamCodec<RegistryFriendlyByteBuf, S> streamCodec() {
        return b;
    }
}
