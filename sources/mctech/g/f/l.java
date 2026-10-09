package mctech.g.f;

import com.mojang.serialization.Codec;
import io.netty.buffer.ByteBuf;
import java.util.function.IntFunction;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.util.ByIdMap;
import net.minecraft.util.StringRepresentable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/f/l.class */
@Deprecated(since = "8.0.0")
public enum l implements e, StringRepresentable {
    CONNECTED(0, "connected"),
    CONNECTED_ACTIVE(1, "connected_active"),
    DISCONNECTED(2, "disconnected"),
    DISABLED(3, "disabled");

    public static final Codec<l> g = StringRepresentable.fromEnum(l::values);
    public static final IntFunction<l> h = ByIdMap.continuous(lVar -> {
        return lVar.j;
    }, values(), ByIdMap.OutOfBoundsStrategy.ZERO);
    public static final StreamCodec<ByteBuf, l> i = ByteBufCodecs.idMapper(h, lVar -> {
        return lVar.j;
    });
    private final int j;
    private final String k;

    l(int i2, String str) {
        this.j = i2;
        this.k = str;
    }

    @Override // mctech.g.f.e
    public boolean a() {
        return this == CONNECTED || this == CONNECTED_ACTIVE;
    }

    public String getSerializedName() {
        return this.k;
    }
}
