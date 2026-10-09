package mctech.g.b.a;

import io.netty.buffer.ByteBuf;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import mctech.MCTech;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.item.DyeColor;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/b/a/p.class */
public final class p extends Record implements CustomPacketPayload {
    private final DyeColor c;
    private final int d;
    private final int e;
    private final boolean f;
    public static final CustomPacketPayload.Type<p> a = new CustomPacketPayload.Type<>(MCTech.loc("count_filter_packet"));
    public static final StreamCodec<ByteBuf, p> b = StreamCodec.composite(DyeColor.STREAM_CODEC, (v0) -> {
        return v0.a();
    }, ByteBufCodecs.VAR_INT, (v0) -> {
        return v0.b();
    }, ByteBufCodecs.VAR_INT, (v0) -> {
        return v0.c();
    }, ByteBufCodecs.BOOL, (v0) -> {
        return v0.d();
    }, (v1, v2, v3, v4) -> {
        return new p(v1, v2, v3, v4);
    });

    public p(DyeColor dyeColor, int i, int i2, boolean z) {
        this.c = dyeColor;
        this.d = i;
        this.e = i2;
        this.f = z;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, p.class), p.class, "channel1;maxCount;count;active", "FIELD:Lmctech/g/b/a/p;->c:Lnet/minecraft/world/item/DyeColor;", "FIELD:Lmctech/g/b/a/p;->d:I", "FIELD:Lmctech/g/b/a/p;->e:I", "FIELD:Lmctech/g/b/a/p;->f:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, p.class), p.class, "channel1;maxCount;count;active", "FIELD:Lmctech/g/b/a/p;->c:Lnet/minecraft/world/item/DyeColor;", "FIELD:Lmctech/g/b/a/p;->d:I", "FIELD:Lmctech/g/b/a/p;->e:I", "FIELD:Lmctech/g/b/a/p;->f:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, p.class, Object.class), p.class, "channel1;maxCount;count;active", "FIELD:Lmctech/g/b/a/p;->c:Lnet/minecraft/world/item/DyeColor;", "FIELD:Lmctech/g/b/a/p;->d:I", "FIELD:Lmctech/g/b/a/p;->e:I", "FIELD:Lmctech/g/b/a/p;->f:Z").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public DyeColor a() {
        return this.c;
    }

    public int b() {
        return this.d;
    }

    public int c() {
        return this.e;
    }

    public boolean d() {
        return this.f;
    }

    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return a;
    }
}
