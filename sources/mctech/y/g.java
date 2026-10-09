package mctech.y;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import mctech.MCTech;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/y/g.class */
public class g {

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/y/g$b.class */
    public static final class b extends Record implements CustomPacketPayload {
        private final f c;
        public static final CustomPacketPayload.Type<b> a = new CustomPacketPayload.Type<>(MCTech.loc("xray_enable"));
        public static final StreamCodec<RegistryFriendlyByteBuf, b> b = StreamCodec.composite(f.a, (v0) -> {
            return v0.a();
        }, b::new);

        public b(f fVar) {
            this.c = fVar;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, b.class), b.class, "xrayData", "FIELD:Lmctech/y/g$b;->c:Lmctech/y/f;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, b.class), b.class, "xrayData", "FIELD:Lmctech/y/g$b;->c:Lmctech/y/f;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, b.class, Object.class), b.class, "xrayData", "FIELD:Lmctech/y/g$b;->c:Lmctech/y/f;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        public f a() {
            return this.c;
        }

        @NotNull
        public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
            return a;
        }

        public static void a(b bVar, IPayloadContext iPayloadContext) {
            iPayloadContext.enqueueWork(() -> {
                h.a(new e(bVar.a().b(), bVar.a().c().stream().map(aVar -> {
                    return mctech.y.a.a(bVar.a().a(), aVar);
                }).toList(), true));
            });
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/y/g$c.class */
    public static final class c extends Record implements CustomPacketPayload {
        private final f c;
        public static final CustomPacketPayload.Type<c> a = new CustomPacketPayload.Type<>(MCTech.loc("xray_enable_item"));
        public static final StreamCodec<RegistryFriendlyByteBuf, c> b = StreamCodec.composite(f.a, (v0) -> {
            return v0.a();
        }, c::new);

        public c(f fVar) {
            this.c = fVar;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, c.class), c.class, "xrayData", "FIELD:Lmctech/y/g$c;->c:Lmctech/y/f;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, c.class), c.class, "xrayData", "FIELD:Lmctech/y/g$c;->c:Lmctech/y/f;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, c.class, Object.class), c.class, "xrayData", "FIELD:Lmctech/y/g$c;->c:Lmctech/y/f;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        public f a() {
            return this.c;
        }

        @NotNull
        public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
            return a;
        }

        public static void a(c cVar, IPayloadContext iPayloadContext) {
            iPayloadContext.enqueueWork(() -> {
                h.a(new e(cVar.a().b(), cVar.a().c(), true));
            });
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/y/g$a.class */
    public static final class a extends Record implements CustomPacketPayload {
        public static final CustomPacketPayload.Type<a> a = new CustomPacketPayload.Type<>(MCTech.loc("xray_disable"));
        public static final StreamCodec<RegistryFriendlyByteBuf, a> b = StreamCodec.unit(new a());

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        @NotNull
        public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
            return a;
        }

        public static void a(a aVar, IPayloadContext iPayloadContext) {
            iPayloadContext.enqueueWork(h::a);
        }
    }
}
