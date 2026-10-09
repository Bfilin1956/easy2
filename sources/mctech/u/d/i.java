package mctech.u.d;

import com.mojang.datafixers.util.Function11;
import com.mojang.datafixers.util.Function7;
import com.mojang.datafixers.util.Function8;
import java.util.function.Function;
import net.minecraft.network.codec.StreamCodec;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/d/i.class */
public class i {
    public static <B, C, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> StreamCodec<B, C> a(final StreamCodec<? super B, T1> streamCodec, final Function<C, T1> function, final StreamCodec<? super B, T2> streamCodec2, final Function<C, T2> function2, final StreamCodec<? super B, T3> streamCodec3, final Function<C, T3> function3, final StreamCodec<? super B, T4> streamCodec4, final Function<C, T4> function4, final StreamCodec<? super B, T5> streamCodec5, final Function<C, T5> function5, final StreamCodec<? super B, T6> streamCodec6, final Function<C, T6> function6, final StreamCodec<? super B, T7> streamCodec7, final Function<C, T7> function7, final StreamCodec<? super B, T8> streamCodec8, final Function<C, T8> function8, final StreamCodec<? super B, T9> streamCodec9, final Function<C, T9> function9, final StreamCodec<? super B, T10> streamCodec10, final Function<C, T10> function10, final StreamCodec<? super B, T11> streamCodec11, final Function<C, T11> function11, final Function11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, C> function12) {
        return new StreamCodec<B, C>() { // from class: mctech.u.d.i.1
            public C decode(B b) {
                return (C) function12.apply(streamCodec.decode(b), streamCodec2.decode(b), streamCodec3.decode(b), streamCodec4.decode(b), streamCodec5.decode(b), streamCodec6.decode(b), streamCodec7.decode(b), streamCodec8.decode(b), streamCodec9.decode(b), streamCodec10.decode(b), streamCodec11.decode(b));
            }

            public void encode(B b, C c) {
                streamCodec.encode(b, function.apply(c));
                streamCodec2.encode(b, function2.apply(c));
                streamCodec3.encode(b, function3.apply(c));
                streamCodec4.encode(b, function4.apply(c));
                streamCodec5.encode(b, function5.apply(c));
                streamCodec6.encode(b, function6.apply(c));
                streamCodec7.encode(b, function7.apply(c));
                streamCodec8.encode(b, function8.apply(c));
                streamCodec9.encode(b, function9.apply(c));
                streamCodec10.encode(b, function10.apply(c));
                streamCodec11.encode(b, function11.apply(c));
            }
        };
    }

    public static <B, C, T1, T2, T3, T4, T5, T6, T7, T8> StreamCodec<B, C> a(final StreamCodec<? super B, T1> streamCodec, final Function<C, T1> function, final StreamCodec<? super B, T2> streamCodec2, final Function<C, T2> function2, final StreamCodec<? super B, T3> streamCodec3, final Function<C, T3> function3, final StreamCodec<? super B, T4> streamCodec4, final Function<C, T4> function4, final StreamCodec<? super B, T5> streamCodec5, final Function<C, T5> function5, final StreamCodec<? super B, T6> streamCodec6, final Function<C, T6> function6, final StreamCodec<? super B, T7> streamCodec7, final Function<C, T7> function7, final StreamCodec<? super B, T8> streamCodec8, final Function<C, T8> function8, final Function8<T1, T2, T3, T4, T5, T6, T7, T8, C> function9) {
        return new StreamCodec<B, C>() { // from class: mctech.u.d.i.2
            public C decode(B b) {
                return (C) function9.apply(streamCodec.decode(b), streamCodec2.decode(b), streamCodec3.decode(b), streamCodec4.decode(b), streamCodec5.decode(b), streamCodec6.decode(b), streamCodec7.decode(b), streamCodec8.decode(b));
            }

            public void encode(B b, C c) {
                streamCodec.encode(b, function.apply(c));
                streamCodec2.encode(b, function2.apply(c));
                streamCodec3.encode(b, function3.apply(c));
                streamCodec4.encode(b, function4.apply(c));
                streamCodec5.encode(b, function5.apply(c));
                streamCodec6.encode(b, function6.apply(c));
                streamCodec7.encode(b, function7.apply(c));
                streamCodec8.encode(b, function8.apply(c));
            }
        };
    }

    public static <B, C, T1, T2, T3, T4, T5, T6, T7> StreamCodec<B, C> a(final StreamCodec<? super B, T1> streamCodec, final Function<C, T1> function, final StreamCodec<? super B, T2> streamCodec2, final Function<C, T2> function2, final StreamCodec<? super B, T3> streamCodec3, final Function<C, T3> function3, final StreamCodec<? super B, T4> streamCodec4, final Function<C, T4> function4, final StreamCodec<? super B, T5> streamCodec5, final Function<C, T5> function5, final StreamCodec<? super B, T6> streamCodec6, final Function<C, T6> function6, final StreamCodec<? super B, T7> streamCodec7, final Function<C, T7> function7, final Function7<T1, T2, T3, T4, T5, T6, T7, C> function8) {
        return new StreamCodec<B, C>() { // from class: mctech.u.d.i.3
            public C decode(B b) {
                return (C) function8.apply(streamCodec.decode(b), streamCodec2.decode(b), streamCodec3.decode(b), streamCodec4.decode(b), streamCodec5.decode(b), streamCodec6.decode(b), streamCodec7.decode(b));
            }

            public void encode(B b, C c) {
                streamCodec.encode(b, function.apply(c));
                streamCodec2.encode(b, function2.apply(c));
                streamCodec3.encode(b, function3.apply(c));
                streamCodec4.encode(b, function4.apply(c));
                streamCodec5.encode(b, function5.apply(c));
                streamCodec6.encode(b, function6.apply(c));
                streamCodec7.encode(b, function7.apply(c));
            }
        };
    }
}
