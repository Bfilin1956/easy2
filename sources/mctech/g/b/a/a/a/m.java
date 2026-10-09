package mctech.g.b.a.a.a;

import io.netty.buffer.ByteBuf;
import java.util.function.IntFunction;
import java.util.function.Supplier;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.util.ByIdMap;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/b/a/a/a/m.class */
public enum m {
    NULL(() -> {
        return i.a;
    }),
    INT(() -> {
        return e.a;
    }),
    FLOAT(() -> {
        return c.a;
    }),
    LONG(() -> {
        return h.a;
    }),
    STRING(() -> {
        return n.a;
    }),
    BOOL(() -> {
        return b.a;
    }),
    BLOCK_POS(() -> {
        return a.a;
    }),
    ITEM_STACK(() -> {
        return f.a;
    }),
    FLUID_STACK(() -> {
        return d.a;
    }),
    RESOURCE_LOCATION(() -> {
        return k.a;
    }),
    LIST(() -> {
        return g.a;
    }),
    PAIR(() -> {
        return j.a;
    });

    public static final IntFunction<m> m = ByIdMap.continuous((v0) -> {
        return v0.ordinal();
    }, values(), ByIdMap.OutOfBoundsStrategy.WRAP);
    public static final StreamCodec<ByteBuf, m> n = ByteBufCodecs.idMapper(m, (v0) -> {
        return v0.ordinal();
    });
    private final Supplier<StreamCodec<RegistryFriendlyByteBuf, ? extends l>> o;

    m(Supplier supplier) {
        this.o = supplier;
    }

    public StreamCodec<RegistryFriendlyByteBuf, ? extends l> a() {
        return this.o.get();
    }
}
