package mctech.g.b.a;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import mctech.MCTech;
import net.minecraft.core.BlockPos;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/b/a/n.class */
public final class n extends Record implements CustomPacketPayload {
    private final BlockPos c;
    private final byte[] d;
    public static final CustomPacketPayload.Type<n> a = new CustomPacketPayload.Type<>(MCTech.loc("s2c_data_slot_update"));
    public static final StreamCodec<RegistryFriendlyByteBuf, n> b = StreamCodec.composite(BlockPos.STREAM_CODEC, (v0) -> {
        return v0.a();
    }, ByteBufCodecs.BYTE_ARRAY, (v0) -> {
        return v0.b();
    }, n::new);

    public n(BlockPos blockPos, byte[] bArr) {
        this.c = blockPos;
        this.d = bArr;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, n.class), n.class, "pos;slotData", "FIELD:Lmctech/g/b/a/n;->c:Lnet/minecraft/core/BlockPos;", "FIELD:Lmctech/g/b/a/n;->d:[B").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, n.class), n.class, "pos;slotData", "FIELD:Lmctech/g/b/a/n;->c:Lnet/minecraft/core/BlockPos;", "FIELD:Lmctech/g/b/a/n;->d:[B").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, n.class, Object.class), n.class, "pos;slotData", "FIELD:Lmctech/g/b/a/n;->c:Lnet/minecraft/core/BlockPos;", "FIELD:Lmctech/g/b/a/n;->d:[B").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public BlockPos a() {
        return this.c;
    }

    public byte[] b() {
        return this.d;
    }

    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return a;
    }
}
