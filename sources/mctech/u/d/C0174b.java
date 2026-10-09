package mctech.u.d;

import com.mojang.datafixers.util.Function9;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Function;
import mctech.u.C0172d;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.neoforged.neoforge.fluids.FluidStack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: mctech.u.d.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/d/b.class */
public class C0174b implements RecipeSerializer<C0172d> {
    public static final MapCodec<C0172d> a = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Codec.unboundedMap(Codec.STRING, ItemStack.CODEC).optionalFieldOf("crafting_matrix", new HashMap()).forGetter((v0) -> {
            return v0.a();
        }), Codec.STRING.listOf().optionalFieldOf("pattern", new ArrayList()).forGetter((v0) -> {
            return v0.b();
        }), ItemStack.CODEC.listOf().optionalFieldOf("shapeless", new ArrayList()).forGetter((v0) -> {
            return v0.c();
        }), FluidStack.CODEC.listOf().fieldOf("fluids").forGetter((v0) -> {
            return v0.d();
        }), Codec.STRING.listOf().fieldOf("consumables").forGetter((v0) -> {
            return v0.e();
        }), Codec.INT.fieldOf("required_energy").forGetter((v0) -> {
            return v0.f();
        }), Codec.INT.fieldOf("required_time").forGetter((v0) -> {
            return v0.g();
        }), Codec.FLOAT.fieldOf("experience").forGetter((v0) -> {
            return v0.h();
        }), ItemStack.CODEC.fieldOf("result").forGetter((v0) -> {
            return v0.i();
        })).apply(instance, (v1, v2, v3, v4, v5, v6, v7, v8, v9) -> {
            return new C0172d(v1, v2, v3, v4, v5, v6, v7, v8, v9);
        });
    });
    public static final StreamCodec<RegistryFriendlyByteBuf, C0172d> b = a(ByteBufCodecs.map(HashMap::new, ByteBufCodecs.STRING_UTF8, ItemStack.STREAM_CODEC), (v0) -> {
        return v0.a();
    }, ByteBufCodecs.STRING_UTF8.apply(ByteBufCodecs.list()), (v0) -> {
        return v0.b();
    }, ItemStack.STREAM_CODEC.apply(ByteBufCodecs.list()), (v0) -> {
        return v0.c();
    }, ByteBufCodecs.collection(ArrayList::new, FluidStack.STREAM_CODEC), (v0) -> {
        return v0.d();
    }, ByteBufCodecs.STRING_UTF8.apply(ByteBufCodecs.list()), (v0) -> {
        return v0.e();
    }, ByteBufCodecs.INT, (v0) -> {
        return v0.f();
    }, ByteBufCodecs.INT, (v0) -> {
        return v0.g();
    }, ByteBufCodecs.FLOAT, (v0) -> {
        return v0.h();
    }, ItemStack.STREAM_CODEC, (v0) -> {
        return v0.i();
    }, (v1, v2, v3, v4, v5, v6, v7, v8, v9) -> {
        return new C0172d(v1, v2, v3, v4, v5, v6, v7, v8, v9);
    });

    @NotNull
    public MapCodec<C0172d> codec() {
        return a;
    }

    @NotNull
    public StreamCodec<RegistryFriendlyByteBuf, C0172d> streamCodec() {
        return b;
    }

    static <B, C, T1, T2, T3, T4, T5, T6, T7, T8, T9> StreamCodec<B, C> a(final StreamCodec<? super B, T1> streamCodec, final Function<C, T1> function, final StreamCodec<? super B, T2> streamCodec2, final Function<C, T2> function2, final StreamCodec<? super B, T3> streamCodec3, final Function<C, T3> function3, final StreamCodec<? super B, T4> streamCodec4, final Function<C, T4> function4, final StreamCodec<? super B, T5> streamCodec5, final Function<C, T5> function5, final StreamCodec<? super B, T6> streamCodec6, final Function<C, T6> function6, final StreamCodec<? super B, T7> streamCodec7, final Function<C, T7> function7, final StreamCodec<? super B, T8> streamCodec8, final Function<C, T8> function8, final StreamCodec<? super B, T9> streamCodec9, final Function<C, T9> function9, final Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, C> function10) {
        return new StreamCodec<B, C>() { // from class: mctech.u.d.b.1
            @NotNull
            public C decode(@NotNull B b2) {
                return (C) function10.apply(streamCodec.decode(b2), streamCodec2.decode(b2), streamCodec3.decode(b2), streamCodec4.decode(b2), streamCodec5.decode(b2), streamCodec6.decode(b2), streamCodec7.decode(b2), streamCodec8.decode(b2), streamCodec9.decode(b2));
            }

            public void encode(@NotNull B b2, @NotNull C c) {
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
}
