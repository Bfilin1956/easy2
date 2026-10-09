package mctech.q.d.d.a.b;

import io.netty.buffer.ByteBuf;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import mctech.MCTech;
import mctech.api.network.tile.INetworkEventListener;
import net.minecraft.core.BlockPos;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.network.handling.IPayloadContext;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/q/d/d/a/b/c.class */
public class c {
    public static void a(a aVar, IPayloadContext iPayloadContext) {
        INetworkEventListener blockEntity = iPayloadContext.player().level().getBlockEntity(aVar.c);
        if (!(blockEntity instanceof INetworkEventListener)) {
            return;
        }
        blockEntity.onServerDataReceived(aVar.d, aVar.e);
    }

    public static void b(a aVar, IPayloadContext iPayloadContext) {
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/q/d/d/a/b/c$a.class */
    public static final class a extends Record implements CustomPacketPayload {
        private final BlockPos c;
        private final int d;
        private final int e;
        public static final CustomPacketPayload.Type<a> a = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "ste"));
        public static final StreamCodec<ByteBuf, a> b = StreamCodec.composite(BlockPos.STREAM_CODEC, (v0) -> {
            return v0.a();
        }, ByteBufCodecs.INT, (v0) -> {
            return v0.b();
        }, ByteBufCodecs.INT, (v0) -> {
            return v0.c();
        }, (v1, v2, v3) -> {
            return new a(v1, v2, v3);
        });

        public a(BlockPos blockPos, int i, int i2) {
            this.c = blockPos;
            this.d = i;
            this.e = i2;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "pos;key;value", "FIELD:Lmctech/q/d/d/a/b/c$a;->c:Lnet/minecraft/core/BlockPos;", "FIELD:Lmctech/q/d/d/a/b/c$a;->d:I", "FIELD:Lmctech/q/d/d/a/b/c$a;->e:I").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "pos;key;value", "FIELD:Lmctech/q/d/d/a/b/c$a;->c:Lnet/minecraft/core/BlockPos;", "FIELD:Lmctech/q/d/d/a/b/c$a;->d:I", "FIELD:Lmctech/q/d/d/a/b/c$a;->e:I").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "pos;key;value", "FIELD:Lmctech/q/d/d/a/b/c$a;->c:Lnet/minecraft/core/BlockPos;", "FIELD:Lmctech/q/d/d/a/b/c$a;->d:I", "FIELD:Lmctech/q/d/d/a/b/c$a;->e:I").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
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

        public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
            return a;
        }
    }
}
