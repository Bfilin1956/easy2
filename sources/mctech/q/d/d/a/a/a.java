package mctech.q.d.d.a.a;

import io.netty.buffer.ByteBuf;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import mctech.MCTech;
import net.minecraft.core.Direction;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.neoforged.neoforge.network.handling.IPayloadContext;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/q/d/d/a/a/a.class */
public class a {
    public static void a(C0037a c0037a, IPayloadContext iPayloadContext) {
        mctech.m.a.d entity = iPayloadContext.player().level().getEntity(c0037a.c);
        if (entity instanceof mctech.m.a.d) {
            MCTech.PLATFORM.a(iPayloadContext.player(), c0037a.d ? InteractionHand.MAIN_HAND : InteractionHand.OFF_HAND, Direction.DOWN, entity, c0037a.e);
            return;
        }
        throw new RuntimeException("Packet Contains invalid Gui Data");
    }

    public static void b(C0037a c0037a, IPayloadContext iPayloadContext) {
    }

    /* JADX INFO: renamed from: mctech.q.d.d.a.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/q/d/d/a/a/a$a.class */
    public static final class C0037a extends Record implements CustomPacketPayload {
        private final int c;
        private final boolean d;
        private final int e;
        public static final CustomPacketPayload.Type<C0037a> a = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "oegp"));
        public static final StreamCodec<ByteBuf, C0037a> b = StreamCodec.composite(ByteBufCodecs.INT, (v0) -> {
            return v0.a();
        }, ByteBufCodecs.BOOL, (v0) -> {
            return v0.b();
        }, ByteBufCodecs.INT, (v0) -> {
            return v0.c();
        }, (v1, v2, v3) -> {
            return new C0037a(v1, v2, v3);
        });

        public C0037a(int i, boolean z, int i2) {
            this.c = i;
            this.d = z;
            this.e = i2;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0037a.class), C0037a.class, "entityId;mainHand;windowID", "FIELD:Lmctech/q/d/d/a/a/a$a;->c:I", "FIELD:Lmctech/q/d/d/a/a/a$a;->d:Z", "FIELD:Lmctech/q/d/d/a/a/a$a;->e:I").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0037a.class), C0037a.class, "entityId;mainHand;windowID", "FIELD:Lmctech/q/d/d/a/a/a$a;->c:I", "FIELD:Lmctech/q/d/d/a/a/a$a;->d:Z", "FIELD:Lmctech/q/d/d/a/a/a$a;->e:I").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0037a.class, Object.class), C0037a.class, "entityId;mainHand;windowID", "FIELD:Lmctech/q/d/d/a/a/a$a;->c:I", "FIELD:Lmctech/q/d/d/a/a/a$a;->d:Z", "FIELD:Lmctech/q/d/d/a/a/a$a;->e:I").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        public int a() {
            return this.c;
        }

        public boolean b() {
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
