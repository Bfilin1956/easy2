package mctech.g.a.f;

import com.mojang.serialization.Codec;
import io.netty.buffer.ByteBuf;
import java.util.Objects;
import java.util.function.IntFunction;
import java.util.function.UnaryOperator;
import mctech.init.MCTechLang;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.NbtOps;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.util.ByIdMap;
import net.minecraft.util.StringRepresentable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/a/f/a.class */
public enum a implements StringRepresentable {
    ALWAYS_ACTIVE(0, "always_active", bool -> {
        return true;
    }, false),
    ACTIVE_WITH_SIGNAL(1, "active_with_signal", bool2 -> {
        return bool2;
    }, true),
    ACTIVE_WITHOUT_SIGNAL(2, "active_without_signal", bool3 -> {
        return Boolean.valueOf(!bool3.booleanValue());
    }, true),
    NEVER_ACTIVE(3, "never_active", bool4 -> {
        return false;
    }, false);

    public static final Codec<a> e = StringRepresentable.fromEnum(a::values);
    public static final IntFunction<a> f = ByIdMap.continuous(aVar -> {
        return aVar.h;
    }, values(), ByIdMap.OutOfBoundsStrategy.ZERO);
    public static final StreamCodec<ByteBuf, a> g = ByteBufCodecs.idMapper(f, aVar -> {
        return aVar.h;
    });
    private final int h;
    private final String i;
    private final UnaryOperator<Boolean> j;
    private final boolean k;

    a(int i, String str, UnaryOperator unaryOperator, boolean z) {
        this.h = i;
        this.i = str;
        this.j = unaryOperator;
        this.k = z;
    }

    public boolean a(boolean z) {
        return ((Boolean) this.j.apply(Boolean.valueOf(z))).booleanValue();
    }

    public boolean a() {
        return this.k;
    }

    public String getSerializedName() {
        return this.i;
    }

    public Tag a(HolderLookup.Provider provider) {
        return (Tag) e.encodeStart(provider.createSerializationContext(NbtOps.INSTANCE), this).getOrThrow();
    }

    public static a a(HolderLookup.Provider provider, Tag tag) {
        return (a) e.parse(provider.createSerializationContext(NbtOps.INSTANCE), tag).getOrThrow();
    }

    public MutableComponent b() {
        return (MutableComponent) Objects.requireNonNull(MCTechLang.REDSTONE_CONTROL.get(this).copy());
    }
}
