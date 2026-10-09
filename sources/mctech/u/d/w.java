package mctech.u.d;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import mctech.u.O;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.neoforged.neoforge.fluids.FluidStack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/d/w.class */
public class w implements RecipeSerializer<O> {
    public static final MapCodec<O> a = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(ItemStack.CODEC.listOf().fieldOf("ingredients").forGetter((v0) -> {
            return v0.d();
        }), Codec.INT.fieldOf("required_energy").forGetter((v0) -> {
            return v0.b();
        }), Codec.INT.fieldOf("required_time").forGetter((v0) -> {
            return v0.c();
        }), Codec.DOUBLE.optionalFieldOf("experience", Double.valueOf(0.0d)).forGetter((v0) -> {
            return v0.a();
        }), FluidStack.CODEC.fieldOf("fluid_result").forGetter((v0) -> {
            return v0.e();
        })).apply(instance, (v1, v2, v3, v4, v5) -> {
            return new O(v1, v2, v3, v4, v5);
        });
    });
    public static final StreamCodec<RegistryFriendlyByteBuf, O> b = StreamCodec.composite(ItemStack.LIST_STREAM_CODEC, (v0) -> {
        return v0.d();
    }, ByteBufCodecs.INT, (v0) -> {
        return v0.b();
    }, ByteBufCodecs.INT, (v0) -> {
        return v0.c();
    }, ByteBufCodecs.DOUBLE, (v0) -> {
        return v0.a();
    }, FluidStack.STREAM_CODEC, (v0) -> {
        return v0.e();
    }, (v1, v2, v3, v4, v5) -> {
        return new O(v1, v2, v3, v4, v5);
    });

    @NotNull
    public MapCodec<O> codec() {
        return a;
    }

    @NotNull
    public StreamCodec<RegistryFriendlyByteBuf, O> streamCodec() {
        return b;
    }
}
