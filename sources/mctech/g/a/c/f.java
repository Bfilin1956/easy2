package mctech.g.a.c;

import io.netty.buffer.ByteBuf;
import java.util.function.IntFunction;
import javax.annotation.Nullable;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.util.ByIdMap;
import net.minecraft.util.StringRepresentable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/a/c/f.class */
public enum f implements StringRepresentable {
    DISCONNECTED("none"),
    CONNECTED_BLOCK("connected_block"),
    CONNECTED_CONDUIT("connected_conduit"),
    DISABLED("disabled");

    public static final StringRepresentable.EnumCodec<f> e = StringRepresentable.fromEnum(f::values);
    public static final IntFunction<f> f = ByIdMap.continuous((v0) -> {
        return v0.ordinal();
    }, values(), ByIdMap.OutOfBoundsStrategy.ZERO);
    public static final StreamCodec<ByteBuf, f> g = ByteBufCodecs.idMapper(f, (v0) -> {
        return v0.ordinal();
    });
    private final String h;

    f(String str) {
        this.h = str;
    }

    public boolean a() {
        return this == DISCONNECTED;
    }

    public boolean b() {
        return (this == DISCONNECTED || this == DISABLED) ? false : true;
    }

    public boolean c() {
        return this == CONNECTED_BLOCK;
    }

    public String getSerializedName() {
        return this.h;
    }

    @Nullable
    public static f a(@Nullable String str) {
        return (f) e.byName(str);
    }
}
