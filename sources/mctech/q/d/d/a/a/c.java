package mctech.q.d.d.a.a;

import io.netty.buffer.ByteBuf;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import mctech.MCTech;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.neoforged.neoforge.network.handling.IPayloadContext;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/q/d/d/a/a/c.class */
public class c {
    public static void a(a aVar, IPayloadContext iPayloadContext) {
        mctech.m.a.d blockEntity = iPayloadContext.player().level().getBlockEntity(aVar.c);
        if (!(blockEntity instanceof mctech.m.a.d)) {
            throw new RuntimeException("Packet Contains invalid Gui Data");
        }
        MCTech.PLATFORM.a(iPayloadContext.player(), aVar.d ? InteractionHand.MAIN_HAND : InteractionHand.OFF_HAND, aVar.e, blockEntity, aVar.f);
    }

    public static void b(a aVar, IPayloadContext iPayloadContext) {
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/q/d/d/a/a/c$a.class */
    public static final class a extends Record implements CustomPacketPayload {
        private final BlockPos c;
        private final boolean d;
        private final Direction e;
        private final int f;
        public static final CustomPacketPayload.Type<a> a = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "cce"));
        public static final StreamCodec<ByteBuf, a> b = StreamCodec.composite(BlockPos.STREAM_CODEC, (v0) -> {
            return v0.a();
        }, ByteBufCodecs.BOOL, (v0) -> {
            return v0.b();
        }, Direction.STREAM_CODEC, (v0) -> {
            return v0.c();
        }, ByteBufCodecs.VAR_INT, (v0) -> {
            return v0.d();
        }, (v1, v2, v3, v4) -> {
            return new a(v1, v2, v3, v4);
        });

        public a(BlockPos blockPos, boolean z, Direction direction, int i) {
            this.c = blockPos;
            this.d = z;
            this.e = direction;
            this.f = i;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "pos;mainHand;side;windowID", "FIELD:Lmctech/q/d/d/a/a/c$a;->c:Lnet/minecraft/core/BlockPos;", "FIELD:Lmctech/q/d/d/a/a/c$a;->d:Z", "FIELD:Lmctech/q/d/d/a/a/c$a;->e:Lnet/minecraft/core/Direction;", "FIELD:Lmctech/q/d/d/a/a/c$a;->f:I").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "pos;mainHand;side;windowID", "FIELD:Lmctech/q/d/d/a/a/c$a;->c:Lnet/minecraft/core/BlockPos;", "FIELD:Lmctech/q/d/d/a/a/c$a;->d:Z", "FIELD:Lmctech/q/d/d/a/a/c$a;->e:Lnet/minecraft/core/Direction;", "FIELD:Lmctech/q/d/d/a/a/c$a;->f:I").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "pos;mainHand;side;windowID", "FIELD:Lmctech/q/d/d/a/a/c$a;->c:Lnet/minecraft/core/BlockPos;", "FIELD:Lmctech/q/d/d/a/a/c$a;->d:Z", "FIELD:Lmctech/q/d/d/a/a/c$a;->e:Lnet/minecraft/core/Direction;", "FIELD:Lmctech/q/d/d/a/a/c$a;->f:I").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        public BlockPos a() {
            return this.c;
        }

        public boolean b() {
            return this.d;
        }

        public Direction c() {
            return this.e;
        }

        public int d() {
            return this.f;
        }

        public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
            return a;
        }
    }
}
