package mctech.u.d;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import mctech.u.C0192t;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/d/m.class */
public class m implements RecipeSerializer<C0192t> {
    public static final MapCodec<C0192t> a = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Ingredient.CODEC.fieldOf("ingredient").forGetter((v0) -> {
            return v0.h();
        }), ItemStack.CODEC.fieldOf("result").forGetter((v0) -> {
            return v0.l();
        }), Codec.DOUBLE.fieldOf("energy").forGetter((v0) -> {
            return v0.i();
        }), Codec.INT.fieldOf("cookingtime").forGetter((v0) -> {
            return v0.j();
        })).apply(instance, (v1, v2, v3, v4) -> {
            return new C0192t(v1, v2, v3, v4);
        });
    });
    public static final StreamCodec<RegistryFriendlyByteBuf, C0192t> b = StreamCodec.composite(Ingredient.CONTENTS_STREAM_CODEC, (v0) -> {
        return v0.h();
    }, ItemStack.STREAM_CODEC, (v0) -> {
        return v0.l();
    }, ByteBufCodecs.DOUBLE, (v0) -> {
        return v0.i();
    }, ByteBufCodecs.INT, (v0) -> {
        return v0.j();
    }, (v1, v2, v3, v4) -> {
        return new C0192t(v1, v2, v3, v4);
    });

    public MapCodec<C0192t> codec() {
        return a;
    }

    public StreamCodec<RegistryFriendlyByteBuf, C0192t> streamCodec() {
        return b;
    }
}
