package mctech.u.d;

import com.mojang.datafixers.util.Function6;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.function.Function;
import mctech.u.C0181i;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;

/* JADX INFO: renamed from: mctech.u.d.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/d/d.class */
public class C0176d implements RecipeSerializer<C0181i> {
    public static final MapCodec<C0181i> a = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Ingredient.CODEC.fieldOf("ingredient0").forGetter((v0) -> {
            return v0.a();
        }), Ingredient.CODEC.fieldOf("ingredient1").forGetter((v0) -> {
            return v0.b();
        }), Codec.INT.fieldOf("input_count").forGetter((v0) -> {
            return v0.c();
        }), ItemStack.CODEC.fieldOf("result").forGetter((v0) -> {
            return v0.f();
        }), Codec.DOUBLE.fieldOf("energy").forGetter((v0) -> {
            return v0.d();
        }), Codec.INT.fieldOf("cookingtime").forGetter((v0) -> {
            return v0.e();
        })).apply(instance, (v1, v2, v3, v4, v5, v6) -> {
            return new C0181i(v1, v2, v3, v4, v5, v6);
        });
    });
    public static final StreamCodec<RegistryFriendlyByteBuf, C0181i> b = a(Ingredient.CONTENTS_STREAM_CODEC, (v0) -> {
        return v0.a();
    }, Ingredient.CONTENTS_STREAM_CODEC, (v0) -> {
        return v0.b();
    }, ByteBufCodecs.INT, (v0) -> {
        return v0.c();
    }, ItemStack.STREAM_CODEC, (v0) -> {
        return v0.f();
    }, ByteBufCodecs.DOUBLE, (v0) -> {
        return v0.d();
    }, ByteBufCodecs.INT, (v0) -> {
        return v0.e();
    }, (v1, v2, v3, v4, v5, v6) -> {
        return new C0181i(v1, v2, v3, v4, v5, v6);
    });

    public MapCodec<C0181i> codec() {
        return a;
    }

    public StreamCodec<RegistryFriendlyByteBuf, C0181i> streamCodec() {
        return b;
    }

    static <B, C, T1, T2, T3, T4, T5, T6> StreamCodec<B, C> a(final StreamCodec<? super B, T1> streamCodec, final Function<C, T1> function, final StreamCodec<? super B, T2> streamCodec2, final Function<C, T2> function2, final StreamCodec<? super B, T3> streamCodec3, final Function<C, T3> function3, final StreamCodec<? super B, T4> streamCodec4, final Function<C, T4> function4, final StreamCodec<? super B, T5> streamCodec5, final Function<C, T5> function5, final StreamCodec<? super B, T6> streamCodec6, final Function<C, T6> function6, final Function6<T1, T2, T3, T4, T5, T6, C> function7) {
        return new StreamCodec<B, C>() { // from class: mctech.u.d.d.1
            public C decode(B b2) {
                return (C) function7.apply(streamCodec.decode(b2), streamCodec2.decode(b2), streamCodec3.decode(b2), streamCodec4.decode(b2), streamCodec5.decode(b2), streamCodec6.decode(b2));
            }

            public void encode(B b2, C c) {
                streamCodec.encode(b2, function.apply(c));
                streamCodec2.encode(b2, function2.apply(c));
                streamCodec3.encode(b2, function3.apply(c));
                streamCodec4.encode(b2, function4.apply(c));
                streamCodec5.encode(b2, function5.apply(c));
                streamCodec6.encode(b2, function6.apply(c));
            }
        };
    }
}
