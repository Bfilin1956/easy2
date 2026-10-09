package mctech.g.b.a;

import io.netty.buffer.ByteBuf;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.Optional;
import mctech.MCTech;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/b/a/b.class */
public final class b extends Record implements CustomPacketPayload {
    private final int c;

    @Nullable
    private final CompoundTag d;
    public static final CustomPacketPayload.Type<b> a = new CustomPacketPayload.Type<>(MCTech.loc("conduit_extra_gui_data"));
    public static final StreamCodec<ByteBuf, b> b = StreamCodec.composite(ByteBufCodecs.INT, (v0) -> {
        return v0.a();
    }, ByteBufCodecs.optional(ByteBufCodecs.COMPOUND_TAG).map(optional -> {
        return (CompoundTag) optional.orElse(null);
    }, (v0) -> {
        return Optional.ofNullable(v0);
    }), (v0) -> {
        return v0.b();
    }, (v1, v2) -> {
        return new b(v1, v2);
    });

    public b(int i, @Nullable CompoundTag compoundTag) {
        this.c = i;
        this.d = compoundTag;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, b.class), b.class, "containerId;extraGuiData", "FIELD:Lmctech/g/b/a/b;->c:I", "FIELD:Lmctech/g/b/a/b;->d:Lnet/minecraft/nbt/CompoundTag;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, b.class), b.class, "containerId;extraGuiData", "FIELD:Lmctech/g/b/a/b;->c:I", "FIELD:Lmctech/g/b/a/b;->d:Lnet/minecraft/nbt/CompoundTag;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, b.class, Object.class), b.class, "containerId;extraGuiData", "FIELD:Lmctech/g/b/a/b;->c:I", "FIELD:Lmctech/g/b/a/b;->d:Lnet/minecraft/nbt/CompoundTag;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public int a() {
        return this.c;
    }

    @Nullable
    public CompoundTag b() {
        return this.d;
    }

    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return a;
    }
}
