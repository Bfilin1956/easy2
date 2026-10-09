package mctech.u.d;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import mctech.u.C0198z;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/d/p.class */
public class p implements RecipeSerializer<C0198z> {
    public static final MapCodec<C0198z> a = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Ingredient.CODEC.fieldOf("ingredient").forGetter((v0) -> {
            return v0.h();
        }), Codec.INT.fieldOf("input_count").forGetter((v0) -> {
            return v0.a();
        }), ItemStack.CODEC.optionalFieldOf("result0", ItemStack.EMPTY).forGetter((v0) -> {
            return v0.b();
        }), ItemStack.CODEC.optionalFieldOf("result1", ItemStack.EMPTY).forGetter((v0) -> {
            return v0.c();
        }), ItemStack.CODEC.optionalFieldOf("result2", ItemStack.EMPTY).forGetter((v0) -> {
            return v0.d();
        }), Codec.DOUBLE.fieldOf("energy").forGetter((v0) -> {
            return v0.i();
        }), Codec.INT.fieldOf("cookingtime").forGetter((v0) -> {
            return v0.j();
        })).apply(instance, (v1, v2, v3, v4, v5, v6, v7) -> {
            return new C0198z(v1, v2, v3, v4, v5, v6, v7);
        });
    });
    public static final StreamCodec<RegistryFriendlyByteBuf, C0198z> b = i.a(Ingredient.CONTENTS_STREAM_CODEC, (v0) -> {
        return v0.h();
    }, ByteBufCodecs.INT, (v0) -> {
        return v0.a();
    }, ItemStack.STREAM_CODEC, (v0) -> {
        return v0.b();
    }, ItemStack.STREAM_CODEC, (v0) -> {
        return v0.c();
    }, ItemStack.STREAM_CODEC, (v0) -> {
        return v0.d();
    }, ByteBufCodecs.DOUBLE, (v0) -> {
        return v0.i();
    }, ByteBufCodecs.INT, (v0) -> {
        return v0.j();
    }, (v1, v2, v3, v4, v5, v6, v7) -> {
        return new C0198z(v1, v2, v3, v4, v5, v6, v7);
    });

    public MapCodec<C0198z> codec() {
        return a;
    }

    public StreamCodec<RegistryFriendlyByteBuf, C0198z> streamCodec() {
        return b;
    }
}
