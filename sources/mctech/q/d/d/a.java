package mctech.q.d.d;

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

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/q/d/d/a.class */
public class a {
    public static void a(C0036a c0036a, IPayloadContext iPayloadContext) {
    }

    public static void b(C0036a c0036a, IPayloadContext iPayloadContext) {
    }

    /* JADX INFO: renamed from: mctech.q.d.d.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/q/d/d/a$a.class */
    public static final class C0036a extends Record implements CustomPacketPayload {
        private final int c;
        public static final CustomPacketPayload.Type<C0036a> a = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "kp"));
        public static final StreamCodec<ByteBuf, C0036a> b = StreamCodec.composite(ByteBufCodecs.INT, (v0) -> {
            return v0.a();
        }, (v1) -> {
            return new C0036a(v1);
        });

        public C0036a(int i) {
            this.c = i;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0036a.class), C0036a.class, "keyCode", "FIELD:Lmctech/q/d/d/a$a;->c:I").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0036a.class), C0036a.class, "keyCode", "FIELD:Lmctech/q/d/d/a$a;->c:I").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0036a.class, Object.class), C0036a.class, "keyCode", "FIELD:Lmctech/q/d/d/a$a;->c:I").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        public int a() {
            return this.c;
        }

        public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
            return a;
        }
    }
}
