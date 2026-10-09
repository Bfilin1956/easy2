package mctech.u.d;

import com.mojang.datafixers.util.Function7;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.function.Function;
import mctech.u.aa;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/d/D.class */
public class D implements RecipeSerializer<aa> {
    public static final MapCodec<aa> a = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Ingredient.CODEC.fieldOf("ingredient").forGetter((v0) -> {
            return v0.b();
        }), Codec.INT.fieldOf("input_count").forGetter((v0) -> {
            return v0.a();
        }), ResourceLocation.CODEC.fieldOf("material").forGetter((v0) -> {
            return v0.c();
        }), Codec.INT.fieldOf("cookingtime").forGetter((v0) -> {
            return v0.e();
        }), Codec.INT.fieldOf("energy").forGetter((v0) -> {
            return v0.g();
        }), Codec.INT.fieldOf("points").forGetter((v0) -> {
            return v0.f();
        }), ItemStack.CODEC.fieldOf("result").forGetter((v0) -> {
            return v0.d();
        })).apply(instance, (v1, v2, v3, v4, v5, v6, v7) -> {
            return new aa(v1, v2, v3, v4, v5, v6, v7);
        });
    });
    public static final StreamCodec<RegistryFriendlyByteBuf, aa> b = a(Ingredient.CONTENTS_STREAM_CODEC, (v0) -> {
        return v0.b();
    }, ByteBufCodecs.INT, (v0) -> {
        return v0.a();
    }, ResourceLocation.STREAM_CODEC, (v0) -> {
        return v0.c();
    }, ByteBufCodecs.INT, (v0) -> {
        return v0.e();
    }, ByteBufCodecs.INT, (v0) -> {
        return v0.g();
    }, ByteBufCodecs.INT, (v0) -> {
        return v0.f();
    }, ItemStack.STREAM_CODEC, (v0) -> {
        return v0.d();
    }, (v1, v2, v3, v4, v5, v6, v7) -> {
        return new aa(v1, v2, v3, v4, v5, v6, v7);
    });

    public MapCodec<aa> codec() {
        return a;
    }

    public StreamCodec<RegistryFriendlyByteBuf, aa> streamCodec() {
        return b;
    }

    static <B, C, T1, T2, T3, T4, T5, T6, T7> StreamCodec<B, C> a(final StreamCodec<? super B, T1> streamCodec, final Function<C, T1> function, final StreamCodec<? super B, T2> streamCodec2, final Function<C, T2> function2, final StreamCodec<? super B, T3> streamCodec3, final Function<C, T3> function3, final StreamCodec<? super B, T4> streamCodec4, final Function<C, T4> function4, final StreamCodec<? super B, T5> streamCodec5, final Function<C, T5> function5, final StreamCodec<? super B, T6> streamCodec6, final Function<C, T6> function6, final StreamCodec<? super B, T7> streamCodec7, final Function<C, T7> function7, final Function7<T1, T2, T3, T4, T5, T6, T7, C> function8) {
        return new StreamCodec<B, C>() { // from class: mctech.u.d.D.1
            public C decode(B b2) {
                return (C) function8.apply(streamCodec.decode(b2), streamCodec2.decode(b2), streamCodec3.decode(b2), streamCodec4.decode(b2), streamCodec5.decode(b2), streamCodec6.decode(b2), streamCodec7.decode(b2));
            }

            public void encode(B b2, C c) {
                streamCodec.encode(b2, function.apply(c));
                streamCodec2.encode(b2, function2.apply(c));
                streamCodec3.encode(b2, function3.apply(c));
                streamCodec4.encode(b2, function4.apply(c));
                streamCodec5.encode(b2, function5.apply(c));
                streamCodec6.encode(b2, function6.apply(c));
                streamCodec7.encode(b2, function7.apply(c));
            }
        };
    }
}
