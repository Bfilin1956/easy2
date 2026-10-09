package mctech.u.d;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import mctech.u.C0193u;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.neoforged.neoforge.fluids.crafting.FluidIngredient;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/d/n.class */
public class n implements RecipeSerializer<C0193u> {
    public static final MapCodec<C0193u> a = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(FluidIngredient.CODEC.fieldOf("ingredient").forGetter((v0) -> {
            return v0.a();
        }), Codec.INT.fieldOf("energy").forGetter((v0) -> {
            return v0.b();
        }), Codec.INT.fieldOf("worktime").forGetter((v0) -> {
            return v0.c();
        })).apply(instance, (v1, v2, v3) -> {
            return new C0193u(v1, v2, v3);
        });
    });
    public static final StreamCodec<RegistryFriendlyByteBuf, C0193u> b = StreamCodec.composite(FluidIngredient.STREAM_CODEC, (v0) -> {
        return v0.a();
    }, ByteBufCodecs.INT, (v0) -> {
        return v0.b();
    }, ByteBufCodecs.INT, (v0) -> {
        return v0.c();
    }, (v1, v2, v3) -> {
        return new C0193u(v1, v2, v3);
    });

    public MapCodec<C0193u> codec() {
        return a;
    }

    public StreamCodec<RegistryFriendlyByteBuf, C0193u> streamCodec() {
        return b;
    }
}
