package mctech.g.a.d;

import com.mojang.serialization.Codec;
import io.netty.buffer.ByteBuf;
import java.util.function.IntFunction;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.util.ByIdMap;
import net.minecraft.util.StringRepresentable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/a/d/b.class */
public enum b implements StringRepresentable {
    BASIC(0, "basic", false, false),
    HARDENED(1, "hardened", false, true),
    TRANSPARENT(2, "transparent", true, false),
    TRANSPARENT_HARDENED(3, "transparent_hardened", true, true);

    public static final Codec<b> e = StringRepresentable.fromEnum(b::values);
    public static final IntFunction<b> f = ByIdMap.continuous(bVar -> {
        return bVar.h;
    }, values(), ByIdMap.OutOfBoundsStrategy.ZERO);
    public static final StreamCodec<ByteBuf, b> g = ByteBufCodecs.idMapper(f, bVar -> {
        return bVar.h;
    });
    private final int h;
    private final String i;
    private final boolean j;
    private final boolean k;

    b(int i, String str, boolean z, boolean z2) {
        this.h = i;
        this.i = str;
        this.j = z;
        this.k = z2;
    }

    public boolean a() {
        return this.j;
    }

    public boolean b() {
        return this.k;
    }

    public String getSerializedName() {
        return this.i;
    }
}
