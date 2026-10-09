package mctech.q.d.a;

import io.netty.buffer.ByteBuf;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import mctech.MCTech;
import net.minecraft.core.BlockPos;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/q/d/a/a.class */
public class a {
    public static void a(C0034a c0034a, IPayloadContext iPayloadContext) {
    }

    public static void b(C0034a c0034a, IPayloadContext iPayloadContext) {
    }

    /* JADX INFO: renamed from: mctech.q.d.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/q/d/a/a$a.class */
    public static final class C0034a extends Record implements CustomPacketPayload {
        private final BlockPos c;
        private final int d;
        private final int e;
        public static final CustomPacketPayload.Type<C0034a> a = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "cte"));
        public static final StreamCodec<ByteBuf, C0034a> b = StreamCodec.composite(BlockPos.STREAM_CODEC, (v0) -> {
            return v0.a();
        }, ByteBufCodecs.INT, (v0) -> {
            return v0.b();
        }, ByteBufCodecs.INT, (v0) -> {
            return v0.c();
        }, (v1, v2, v3) -> {
            return new C0034a(v1, v2, v3);
        });

        public C0034a(BlockPos blockPos, int i, int i2) {
            this.c = blockPos;
            this.d = i;
            this.e = i2;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0034a.class), C0034a.class, "pos;key;value", "FIELD:Lmctech/q/d/a/a$a;->c:Lnet/minecraft/core/BlockPos;", "FIELD:Lmctech/q/d/a/a$a;->d:I", "FIELD:Lmctech/q/d/a/a$a;->e:I").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0034a.class), C0034a.class, "pos;key;value", "FIELD:Lmctech/q/d/a/a$a;->c:Lnet/minecraft/core/BlockPos;", "FIELD:Lmctech/q/d/a/a$a;->d:I", "FIELD:Lmctech/q/d/a/a$a;->e:I").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0034a.class, Object.class), C0034a.class, "pos;key;value", "FIELD:Lmctech/q/d/a/a$a;->c:Lnet/minecraft/core/BlockPos;", "FIELD:Lmctech/q/d/a/a$a;->d:I", "FIELD:Lmctech/q/d/a/a$a;->e:I").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
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

        @NotNull
        public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
            return a;
        }
    }
}
