package mctech.q.d.a;

import io.netty.buffer.ByteBuf;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import mctech.MCTech;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.network.handling.IPayloadContext;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/q/d/a/b.class */
public class b {
    public static void a(a aVar, IPayloadContext iPayloadContext) {
    }

    public static void b(a aVar, IPayloadContext iPayloadContext) {
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/q/d/a/b$a.class */
    public static final class a extends Record implements CustomPacketPayload {
        private final int c;
        public static final CustomPacketPayload.Type<a> a = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "osp"));
        public static final StreamCodec<ByteBuf, a> b = StreamCodec.composite(ByteBufCodecs.INT, (v0) -> {
            return v0.a();
        }, (v1) -> {
            return new a(v1);
        });

        public a(int i) {
            this.c = i;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "slot", "FIELD:Lmctech/q/d/a/b$a;->c:I").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "slot", "FIELD:Lmctech/q/d/a/b$a;->c:I").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "slot", "FIELD:Lmctech/q/d/a/b$a;->c:I").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        public int a() {
            return this.c;
        }

        public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
            return a;
        }
    }
}
