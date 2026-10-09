package mctech.u.d;

import com.mojang.datafixers.util.Function11;
import com.mojang.datafixers.util.Function9;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.function.Function;
import mctech.u.W;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.crafting.FluidIngredient;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/d/A.class */
public class A implements RecipeSerializer<W> {
    public static final MapCodec<W> a = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Ingredient.CODEC.fieldOf("catalyst").orElse(Ingredient.EMPTY).forGetter((v0) -> {
            return v0.d();
        }), FluidIngredient.CODEC.fieldOf("fluid0").orElse(FluidIngredient.empty()).forGetter((v0) -> {
            return v0.e();
        }), Codec.INT.fieldOf("fluid0_amount").orElse(0).forGetter((v0) -> {
            return v0.f();
        }), FluidIngredient.CODEC.fieldOf("fluid1").orElse(FluidIngredient.empty()).forGetter((v0) -> {
            return v0.h();
        }), Codec.INT.fieldOf("fluid1_amount").orElse(0).forGetter((v0) -> {
            return v0.g();
        }), ItemStack.CODEC.fieldOf("result0").orElse(ItemStack.EMPTY).forGetter((v0) -> {
            return v0.i();
        }), ItemStack.CODEC.fieldOf("result1").orElse(ItemStack.EMPTY).forGetter((v0) -> {
            return v0.j();
        }), ItemStack.CODEC.fieldOf("result2").orElse(ItemStack.EMPTY).forGetter((v0) -> {
            return v0.k();
        }), FluidStack.CODEC.fieldOf("result3").orElse(FluidStack.EMPTY).forGetter((v0) -> {
            return v0.l();
        }), Codec.DOUBLE.fieldOf("energy").forGetter((v0) -> {
            return v0.m();
        }), Codec.INT.fieldOf("cookingtime").forGetter((v0) -> {
            return v0.n();
        })).apply(instance, (v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11) -> {
            return new W(v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11);
        });
    });
    public static final StreamCodec<RegistryFriendlyByteBuf, W> b = a(Ingredient.CONTENTS_STREAM_CODEC, (v0) -> {
        return v0.d();
    }, FluidIngredient.STREAM_CODEC, (v0) -> {
        return v0.e();
    }, ByteBufCodecs.INT, (v0) -> {
        return v0.f();
    }, FluidIngredient.STREAM_CODEC, (v0) -> {
        return v0.h();
    }, ByteBufCodecs.INT, (v0) -> {
        return v0.g();
    }, ItemStack.OPTIONAL_STREAM_CODEC, (v0) -> {
        return v0.i();
    }, ItemStack.OPTIONAL_STREAM_CODEC, (v0) -> {
        return v0.j();
    }, ItemStack.OPTIONAL_STREAM_CODEC, (v0) -> {
        return v0.k();
    }, FluidStack.OPTIONAL_STREAM_CODEC, (v0) -> {
        return v0.l();
    }, ByteBufCodecs.DOUBLE, (v0) -> {
        return v0.m();
    }, ByteBufCodecs.INT, (v0) -> {
        return v0.n();
    }, (v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11) -> {
        return new W(v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11);
    });

    public MapCodec<W> codec() {
        return a;
    }

    public StreamCodec<RegistryFriendlyByteBuf, W> streamCodec() {
        return b;
    }

    static <B, C, T1, T2, T3, T4, T5, T6, T7, T8, T9> StreamCodec<B, C> a(final StreamCodec<? super B, T1> streamCodec, final Function<C, T1> function, final StreamCodec<? super B, T2> streamCodec2, final Function<C, T2> function2, final StreamCodec<? super B, T3> streamCodec3, final Function<C, T3> function3, final StreamCodec<? super B, T4> streamCodec4, final Function<C, T4> function4, final StreamCodec<? super B, T5> streamCodec5, final Function<C, T5> function5, final StreamCodec<? super B, T6> streamCodec6, final Function<C, T6> function6, final StreamCodec<? super B, T7> streamCodec7, final Function<C, T7> function7, final StreamCodec<? super B, T8> streamCodec8, final Function<C, T8> function8, final StreamCodec<? super B, T9> streamCodec9, final Function<C, T9> function9, final Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, C> function10) {
        return new StreamCodec<B, C>() { // from class: mctech.u.d.A.1
            public C decode(B b2) {
                return (C) function10.apply(streamCodec.decode(b2), streamCodec2.decode(b2), streamCodec3.decode(b2), streamCodec4.decode(b2), streamCodec5.decode(b2), streamCodec6.decode(b2), streamCodec7.decode(b2), streamCodec8.decode(b2), streamCodec9.decode(b2));
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
                streamCodec9.encode(b2, function9.apply(c));
            }
        };
    }

    static <B, C, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> StreamCodec<B, C> a(final StreamCodec<? super B, T1> streamCodec, final Function<C, T1> function, final StreamCodec<? super B, T2> streamCodec2, final Function<C, T2> function2, final StreamCodec<? super B, T3> streamCodec3, final Function<C, T3> function3, final StreamCodec<? super B, T4> streamCodec4, final Function<C, T4> function4, final StreamCodec<? super B, T5> streamCodec5, final Function<C, T5> function5, final StreamCodec<? super B, T6> streamCodec6, final Function<C, T6> function6, final StreamCodec<? super B, T7> streamCodec7, final Function<C, T7> function7, final StreamCodec<? super B, T8> streamCodec8, final Function<C, T8> function8, final StreamCodec<? super B, T9> streamCodec9, final Function<C, T9> function9, final StreamCodec<? super B, T10> streamCodec10, final Function<C, T10> function10, final StreamCodec<? super B, T11> streamCodec11, final Function<C, T11> function11, final Function11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, C> function12) {
        return new StreamCodec<B, C>() { // from class: mctech.u.d.A.2
            public C decode(B b2) {
                return (C) function12.apply(streamCodec.decode(b2), streamCodec2.decode(b2), streamCodec3.decode(b2), streamCodec4.decode(b2), streamCodec5.decode(b2), streamCodec6.decode(b2), streamCodec7.decode(b2), streamCodec8.decode(b2), streamCodec9.decode(b2), streamCodec10.decode(b2), streamCodec11.decode(b2));
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
                streamCodec9.encode(b2, function9.apply(c));
                streamCodec10.encode(b2, function10.apply(c));
                streamCodec11.encode(b2, function11.apply(c));
            }
        };
    }
}
