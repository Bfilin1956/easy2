package mctech.g.b.a;

import io.netty.buffer.ByteBuf;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import mctech.MCTech;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.item.DyeColor;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/b/a/s.class */
public final class s extends Record implements CustomPacketPayload {
    private final DyeColor c;
    private final DyeColor d;
    public static final CustomPacketPayload.Type<s> a = new CustomPacketPayload.Type<>(MCTech.loc("double_channel_packet"));
    public static final StreamCodec<ByteBuf, s> b = StreamCodec.composite(DyeColor.STREAM_CODEC, (v0) -> {
        return v0.a();
    }, DyeColor.STREAM_CODEC, (v0) -> {
        return v0.b();
    }, s::new);

    public s(DyeColor dyeColor, DyeColor dyeColor2) {
        this.c = dyeColor;
        this.d = dyeColor2;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, s.class), s.class, "channel1;channel2", "FIELD:Lmctech/g/b/a/s;->c:Lnet/minecraft/world/item/DyeColor;", "FIELD:Lmctech/g/b/a/s;->d:Lnet/minecraft/world/item/DyeColor;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, s.class), s.class, "channel1;channel2", "FIELD:Lmctech/g/b/a/s;->c:Lnet/minecraft/world/item/DyeColor;", "FIELD:Lmctech/g/b/a/s;->d:Lnet/minecraft/world/item/DyeColor;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, s.class, Object.class), s.class, "channel1;channel2", "FIELD:Lmctech/g/b/a/s;->c:Lnet/minecraft/world/item/DyeColor;", "FIELD:Lmctech/g/b/a/s;->d:Lnet/minecraft/world/item/DyeColor;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public DyeColor a() {
        return this.c;
    }

    public DyeColor b() {
        return this.d;
    }

    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return a;
    }
}
