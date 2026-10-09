package mctech.f;

import com.mojang.datafixers.util.Function7;
import com.mojang.datafixers.util.Function8;
import io.netty.buffer.ByteBuf;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;
import javax.annotation.Nonnull;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.Utf8String;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/f/d.class */
public class d {
    public static final StreamCodec<FriendlyByteBuf, UUID> a = StreamCodec.composite(ByteBufCodecs.STRING_UTF8, (v0) -> {
        return v0.toString();
    }, UUID::fromString);
    public static final StreamCodec<ByteBuf, Optional<String>> b = new StreamCodec<ByteBuf, Optional<String>>() { // from class: mctech.f.d.1
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Optional<String> decode(@NotNull ByteBuf byteBuf) {
            return byteBuf.readBoolean() ? Optional.of(Utf8String.read(byteBuf, mctech.q.c.b)) : Optional.empty();
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void encode(@NotNull ByteBuf byteBuf, @NotNull Optional<String> optional) {
            byteBuf.writeBoolean(optional.isPresent());
            optional.ifPresent(str -> {
                Utf8String.write(byteBuf, str, mctech.q.c.b);
            });
        }
    };

    public static <E extends Enum<E>> StreamCodec<ByteBuf, E> a(Class<E> cls) {
        return StreamCodec.of((byteBuf, r4) -> {
            byteBuf.writeInt(r4.ordinal());
        }, byteBuf2 -> {
            return ((Enum[]) cls.getEnumConstants())[byteBuf2.readInt()];
        });
    }

    public static <B, C, T1, T2, T3, T4, T5, T6, T7> StreamCodec<B, C> a(final StreamCodec<? super B, T1> streamCodec, final Function<C, T1> function, final StreamCodec<? super B, T2> streamCodec2, final Function<C, T2> function2, final StreamCodec<? super B, T3> streamCodec3, final Function<C, T3> function3, final StreamCodec<? super B, T4> streamCodec4, final Function<C, T4> function4, final StreamCodec<? super B, T5> streamCodec5, final Function<C, T5> function5, final StreamCodec<? super B, T6> streamCodec6, final Function<C, T6> function6, final StreamCodec<? super B, T7> streamCodec7, final Function<C, T7> function7, final Function7<T1, T2, T3, T4, T5, T6, T7, C> function8) {
        return new StreamCodec<B, C>() { // from class: mctech.f.d.2
            @Nonnull
            public C decode(@Nonnull B b2) {
                return (C) function8.apply(streamCodec.decode(b2), streamCodec2.decode(b2), streamCodec3.decode(b2), streamCodec4.decode(b2), streamCodec5.decode(b2), streamCodec6.decode(b2), streamCodec7.decode(b2));
            }

            public void encode(@Nonnull B b2, @Nonnull C c) {
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

    public static <B, C, T1, T2, T3, T4, T5, T6, T7, T8> StreamCodec<B, C> a(final StreamCodec<? super B, T1> streamCodec, final Function<C, T1> function, final StreamCodec<? super B, T2> streamCodec2, final Function<C, T2> function2, final StreamCodec<? super B, T3> streamCodec3, final Function<C, T3> function3, final StreamCodec<? super B, T4> streamCodec4, final Function<C, T4> function4, final StreamCodec<? super B, T5> streamCodec5, final Function<C, T5> function5, final StreamCodec<? super B, T6> streamCodec6, final Function<C, T6> function6, final StreamCodec<? super B, T7> streamCodec7, final Function<C, T7> function7, final StreamCodec<? super B, T8> streamCodec8, final Function<C, T8> function8, final Function8<T1, T2, T3, T4, T5, T6, T7, T8, C> function9) {
        return new StreamCodec<B, C>() { // from class: mctech.f.d.3
            @Nonnull
            public C decode(@Nonnull B b2) {
                return (C) function9.apply(streamCodec.decode(b2), streamCodec2.decode(b2), streamCodec3.decode(b2), streamCodec4.decode(b2), streamCodec5.decode(b2), streamCodec6.decode(b2), streamCodec7.decode(b2), streamCodec8.decode(b2));
            }

            public void encode(@Nonnull B b2, @Nonnull C c) {
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
