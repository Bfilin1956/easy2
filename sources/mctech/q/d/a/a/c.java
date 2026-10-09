package mctech.q.d.a.a;

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

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/q/d/a/a/c.class */
public class c {
    public static void a(a aVar, IPayloadContext iPayloadContext) {
    }

    public static void b(a aVar, IPayloadContext iPayloadContext) {
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/q/d/a/a/c$a.class */
    public static final class a extends Record implements CustomPacketPayload {
        private final boolean c;
        public static final CustomPacketPayload.Type<a> a = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "sp"));
        public static final StreamCodec<ByteBuf, a> b = StreamCodec.composite(ByteBufCodecs.BOOL, (v0) -> {
            return v0.a();
        }, (v1) -> {
            return new a(v1);
        });

        public a(boolean z) {
            this.c = z;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "scroll", "FIELD:Lmctech/q/d/a/a/c$a;->c:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "scroll", "FIELD:Lmctech/q/d/a/a/c$a;->c:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "scroll", "FIELD:Lmctech/q/d/a/a/c$a;->c:Z").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        public boolean a() {
            return this.c;
        }

        public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
            return a;
        }
    }
}
