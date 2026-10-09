package mctech.u.d;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import mctech.u.L;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.neoforged.neoforge.fluids.FluidStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/d/t.class */
public class t implements RecipeSerializer<L> {
    public static final MapCodec<L> a = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(FluidStack.CODEC.fieldOf("ingredient").forGetter((v0) -> {
            return v0.a();
        }), FluidStack.CODEC.fieldOf("result").forGetter((v0) -> {
            return v0.c();
        }), Codec.INT.fieldOf("energy").forGetter((v0) -> {
            return v0.b();
        })).apply(instance, (v1, v2, v3) -> {
            return new L(v1, v2, v3);
        });
    });
    public static final StreamCodec<RegistryFriendlyByteBuf, L> b = StreamCodec.composite(FluidStack.STREAM_CODEC, (v0) -> {
        return v0.a();
    }, FluidStack.STREAM_CODEC, (v0) -> {
        return v0.c();
    }, ByteBufCodecs.INT, (v0) -> {
        return v0.b();
    }, (v1, v2, v3) -> {
        return new L(v1, v2, v3);
    });

    public MapCodec<L> codec() {
        return a;
    }

    public StreamCodec<RegistryFriendlyByteBuf, L> streamCodec() {
        return b;
    }
}
