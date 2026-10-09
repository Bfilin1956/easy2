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
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.network.handling.IPayloadContext;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/q/d/d/b.class */
public class b {
    public static void a(a aVar, IPayloadContext iPayloadContext) {
        Entity entity = iPayloadContext.player().level().getEntity(aVar.e);
        if (entity == null) {
            return;
        }
        if (aVar.c) {
            entity.moveRelative(10.0f, new Vec3(0.0d, 0.0d, 0.4d * ((double) aVar.d)));
        } else {
            entity.setDeltaMovement(entity.getDeltaMovement().add(0.0d, aVar.d, 0.0d));
        }
    }

    public static void b(a aVar, IPayloadContext iPayloadContext) {
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/q/d/d/b$a.class */
    public static final class a extends Record implements CustomPacketPayload {
        private final boolean c;
        private final float d;
        private final int e;
        public static final CustomPacketPayload.Type<a> a = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "rmp"));
        public static final StreamCodec<ByteBuf, a> b = StreamCodec.composite(ByteBufCodecs.BOOL, (v0) -> {
            return v0.a();
        }, ByteBufCodecs.FLOAT, (v0) -> {
            return v0.b();
        }, ByteBufCodecs.INT, (v0) -> {
            return v0.c();
        }, (v1, v2, v3) -> {
            return new a(v1, v2, v3);
        });

        public a(boolean z, float f, int i) {
            this.c = z;
            this.d = f;
            this.e = i;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "elytra;power;entityId", "FIELD:Lmctech/q/d/d/b$a;->c:Z", "FIELD:Lmctech/q/d/d/b$a;->d:F", "FIELD:Lmctech/q/d/d/b$a;->e:I").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "elytra;power;entityId", "FIELD:Lmctech/q/d/d/b$a;->c:Z", "FIELD:Lmctech/q/d/d/b$a;->d:F", "FIELD:Lmctech/q/d/d/b$a;->e:I").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "elytra;power;entityId", "FIELD:Lmctech/q/d/d/b$a;->c:Z", "FIELD:Lmctech/q/d/d/b$a;->d:F", "FIELD:Lmctech/q/d/d/b$a;->e:I").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        public boolean a() {
            return this.c;
        }

        public float b() {
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
