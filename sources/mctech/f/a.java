package mctech.f;

import io.netty.buffer.ByteBuf;
import java.util.function.Supplier;
import net.minecraft.network.codec.StreamCodec;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/f/a.class */
public class a {
    public static <T> StreamCodec<ByteBuf, T> a(Supplier<T> supplier) {
        return StreamCodec.of((byteBuf, obj) -> {
        }, byteBuf2 -> {
            return supplier.get();
        });
    }
}
