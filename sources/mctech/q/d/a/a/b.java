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

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/q/d/a/a/b.class */
public final class b extends Record implements CustomPacketPayload {
    private final BlockPos c;
    private final int d;
    private final boolean e;
    public static final CustomPacketPayload.Type<b> a = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "fcp"));
    public static final StreamCodec<RegistryFriendlyByteBuf, b> b = StreamCodec.composite(BlockPos.STREAM_CODEC, (v0) -> {
        return v0.a();
    }, ByteBufCodecs.INT, (v0) -> {
        return v0.b();
    }, ByteBufCodecs.BOOL, (v0) -> {
        return v0.c();
    }, (v1, v2, v3) -> {
        return new b(v1, v2, v3);
    });

    public b(BlockPos blockPos, int i, boolean z) {
        this.c = blockPos;
        this.d = i;
        this.e = z;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, b.class), b.class, "blockPos;fluidTankId;shiftPressed", "FIELD:Lmctech/q/d/a/a/b;->c:Lnet/minecraft/core/BlockPos;", "FIELD:Lmctech/q/d/a/a/b;->d:I", "FIELD:Lmctech/q/d/a/a/b;->e:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, b.class), b.class, "blockPos;fluidTankId;shiftPressed", "FIELD:Lmctech/q/d/a/a/b;->c:Lnet/minecraft/core/BlockPos;", "FIELD:Lmctech/q/d/a/a/b;->d:I", "FIELD:Lmctech/q/d/a/a/b;->e:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, b.class, Object.class), b.class, "blockPos;fluidTankId;shiftPressed", "FIELD:Lmctech/q/d/a/a/b;->c:Lnet/minecraft/core/BlockPos;", "FIELD:Lmctech/q/d/a/a/b;->d:I", "FIELD:Lmctech/q/d/a/a/b;->e:Z").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public BlockPos a() {
        return this.c;
    }

    public int b() {
        return this.d;
    }

    public boolean c() {
        return this.e;
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return a;
    }

    public static void a(@NotNull b bVar, IPayloadContext iPayloadContext) {
    }

    public static void b(@NotNull b bVar, IPayloadContext iPayloadContext) {
    }
}
