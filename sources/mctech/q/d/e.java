package mctech.q.d;

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

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/q/d/e.class */
public final class e extends Record implements CustomPacketPayload {
    private final BlockPos c;
    private final int d;
    private final int e;
    private final boolean f;
    public static final CustomPacketPayload.Type<e> a = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "pqs"));
    public static final StreamCodec<RegistryFriendlyByteBuf, e> b = StreamCodec.composite(BlockPos.STREAM_CODEC, (v0) -> {
        return v0.a();
    }, ByteBufCodecs.INT, (v0) -> {
        return v0.b();
    }, ByteBufCodecs.INT, (v0) -> {
        return v0.c();
    }, ByteBufCodecs.BOOL, (v0) -> {
        return v0.d();
    }, (v1, v2, v3, v4) -> {
        return new e(v1, v2, v3, v4);
    });

    public e(BlockPos blockPos, int i, int i2, boolean z) {
        this.c = blockPos;
        this.d = i;
        this.e = i2;
        this.f = z;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, e.class), e.class, "tilePosition;id;amount;item", "FIELD:Lmctech/q/d/e;->c:Lnet/minecraft/core/BlockPos;", "FIELD:Lmctech/q/d/e;->d:I", "FIELD:Lmctech/q/d/e;->e:I", "FIELD:Lmctech/q/d/e;->f:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, e.class), e.class, "tilePosition;id;amount;item", "FIELD:Lmctech/q/d/e;->c:Lnet/minecraft/core/BlockPos;", "FIELD:Lmctech/q/d/e;->d:I", "FIELD:Lmctech/q/d/e;->e:I", "FIELD:Lmctech/q/d/e;->f:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, e.class, Object.class), e.class, "tilePosition;id;amount;item", "FIELD:Lmctech/q/d/e;->c:Lnet/minecraft/core/BlockPos;", "FIELD:Lmctech/q/d/e;->d:I", "FIELD:Lmctech/q/d/e;->e:I", "FIELD:Lmctech/q/d/e;->f:Z").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public BlockPos a() {
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

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return a;
    }

    public static void a(e eVar, IPayloadContext iPayloadContext) {
    }
}
