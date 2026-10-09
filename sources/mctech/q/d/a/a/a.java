package mctech.q.d.a.a;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import mctech.MCTech;
import net.minecraft.core.BlockPos;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/q/d/a/a/a.class */
public final class a extends Record implements CustomPacketPayload {
    private final BlockPos c;
    private final int d;
    public static final CustomPacketPayload.Type<a> a = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "efcp"));
    public static final StreamCodec<RegistryFriendlyByteBuf, a> b = StreamCodec.composite(BlockPos.STREAM_CODEC, (v0) -> {
        return v0.a();
    }, ByteBufCodecs.INT, (v0) -> {
        return v0.b();
    }, (v1, v2) -> {
        return new a(v1, v2);
    });

    public a(BlockPos blockPos, int i) {
        this.c = blockPos;
        this.d = i;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "blockPos;tankId", "FIELD:Lmctech/q/d/a/a/a;->c:Lnet/minecraft/core/BlockPos;", "FIELD:Lmctech/q/d/a/a/a;->d:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "blockPos;tankId", "FIELD:Lmctech/q/d/a/a/a;->c:Lnet/minecraft/core/BlockPos;", "FIELD:Lmctech/q/d/a/a/a;->d:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "blockPos;tankId", "FIELD:Lmctech/q/d/a/a/a;->c:Lnet/minecraft/core/BlockPos;", "FIELD:Lmctech/q/d/a/a/a;->d:I").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public BlockPos a() {
        return this.c;
    }

    public int b() {
        return this.d;
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return a;
    }

    public static void a(@NotNull a aVar, IPayloadContext iPayloadContext) {
    }

    public static void b(@NotNull a aVar, IPayloadContext iPayloadContext) {
    }
}
