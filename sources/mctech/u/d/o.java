package mctech.u.d;

import com.mojang.datafixers.util.Function8;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.function.Function;
import mctech.u.C0197y;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/d/o.class */
public class o implements RecipeSerializer<C0197y> {
    public static final MapCodec<C0197y> a = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Ingredient.CODEC.fieldOf("ingredient0").forGetter((v0) -> {
            return v0.a();
        }), Ingredient.CODEC.fieldOf("ingredient1").forGetter((v0) -> {
            return v0.b();
        }), Codec.INT.fieldOf("input_count0").forGetter((v0) -> {
            return v0.c();
        }), Codec.INT.fieldOf("input_count1").forGetter((v0) -> {
            return v0.d();
        }), ItemStack.CODEC.fieldOf("result").forGetter((v0) -> {
            return v0.g();
        }), Codec.DOUBLE.fieldOf("energy").forGetter((v0) -> {
            return v0.e();
        }), Codec.INT.fieldOf("cookingtime").forGetter((v0) -> {
            return v0.f();
        }), Codec.INT.fieldOf("molten_glass_amount").forGetter((v0) -> {
            return v0.h();
        })).apply(instance, (v1, v2, v3, v4, v5, v6, v7, v8) -> {
            return new C0197y(v1, v2, v3, v4, v5, v6, v7, v8);
        });
    });
    public static final StreamCodec<RegistryFriendlyByteBuf, C0197y> b = a(Ingredient.CONTENTS_STREAM_CODEC, (v0) -> {
        return v0.a();
    }, Ingredient.CONTENTS_STREAM_CODEC, (v0) -> {
        return v0.b();
    }, ByteBufCodecs.INT, (v0) -> {
        return v0.c();
    }, ByteBufCodecs.INT, (v0) -> {
        return v0.d();
    }, ItemStack.STREAM_CODEC, (v0) -> {
        return v0.g();
    }, ByteBufCodecs.DOUBLE, (v0) -> {
        return v0.e();
    }, ByteBufCodecs.INT, (v0) -> {
        return v0.f();
    }, ByteBufCodecs.INT, (v0) -> {
        return v0.h();
    }, (v1, v2, v3, v4, v5, v6, v7, v8) -> {
        return new C0197y(v1, v2, v3, v4, v5, v6, v7, v8);
    });

    public MapCodec<C0197y> codec() {
        return a;
    }

    public StreamCodec<RegistryFriendlyByteBuf, C0197y> streamCodec() {
        return b;
    }

    static <B, C, T1, T2, T3, T4, T5, T6, T7, T8> StreamCodec<B, C> a(final StreamCodec<? super B, T1> streamCodec, final Function<C, T1> function, final StreamCodec<? super B, T2> streamCodec2, final Function<C, T2> function2, final StreamCodec<? super B, T3> streamCodec3, final Function<C, T3> function3, final StreamCodec<? super B, T4> streamCodec4, final Function<C, T4> function4, final StreamCodec<? super B, T5> streamCodec5, final Function<C, T5> function5, final StreamCodec<? super B, T6> streamCodec6, final Function<C, T6> function6, final StreamCodec<? super B, T7> streamCodec7, final Function<C, T7> function7, final StreamCodec<? super B, T8> streamCodec8, final Function<C, T8> function8, final Function8<T1, T2, T3, T4, T5, T6, T7, T8, C> function9) {
        return new StreamCodec<B, C>() { // from class: mctech.u.d.o.1
            public C decode(B b2) {
                return (C) function9.apply(streamCodec.decode(b2), streamCodec2.decode(b2), streamCodec3.decode(b2), streamCodec4.decode(b2), streamCodec5.decode(b2), streamCodec6.decode(b2), streamCodec7.decode(b2), streamCodec8.decode(b2));
            }

            public void encode(B b2, C c) {
                streamCodec.encode(b2, function.apply(c));
                streamCodec2.encode(b2, function2.apply(c));
                streamCodec3.encode(b2, function3.apply(c));
                streamCodec4.encode(b2, function4.apply(c));
                streamCodec5.encode(b2, function5.apply(c));
                streamCodec6.encode(b2, function6.apply(c));
                streamCodec7.encode(b2, function7.apply(c));
                streamCodec8.encode(b2, function8.apply(c));
            }
        };
    }
}
