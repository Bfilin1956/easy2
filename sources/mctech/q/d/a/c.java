package mctech.q.d.a;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import mctech.MCTech;
import mctech.api.network.buffer.INetworkDataBuffer;
import mctech.api.network.tile.INetworkDataEventListener;
import mctech.q.d;
import net.minecraft.core.BlockPos;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/q/d/a/c.class */
public class c {
    public static void a(b bVar, IPayloadContext iPayloadContext) {
        if (bVar.c == null) {
            return;
        }
        INetworkDataEventListener blockEntity = iPayloadContext.player().level().getBlockEntity(bVar.c.b);
        if (!(blockEntity instanceof INetworkDataEventListener)) {
            return;
        }
        blockEntity.onDataBufferReceived(iPayloadContext.player(), bVar.c.c, bVar.c.d, Dist.CLIENT);
    }

    public static void b(b bVar, IPayloadContext iPayloadContext) {
        if (bVar.c == null) {
            return;
        }
        INetworkDataEventListener blockEntity = iPayloadContext.player().level().getBlockEntity(bVar.c.b);
        if (!(blockEntity instanceof INetworkDataEventListener)) {
            return;
        }
        blockEntity.onDataBufferReceived(iPayloadContext.player(), bVar.c.c, bVar.c.d, Dist.DEDICATED_SERVER);
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/q/d/a/c$b.class */
    public static final class b extends Record implements CustomPacketPayload {
        private final a c;
        public static final CustomPacketPayload.Type<b> a = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "tdbe"));
        public static final StreamCodec<RegistryFriendlyByteBuf, b> b = StreamCodec.composite(a.a, (v0) -> {
            return v0.a();
        }, b::new);

        public b(a aVar) {
            this.c = aVar;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, b.class), b.class, "dataBuffer", "FIELD:Lmctech/q/d/a/c$b;->c:Lmctech/q/d/a/c$a;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, b.class), b.class, "dataBuffer", "FIELD:Lmctech/q/d/a/c$b;->c:Lmctech/q/d/a/c$a;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, b.class, Object.class), b.class, "dataBuffer", "FIELD:Lmctech/q/d/a/c$b;->c:Lmctech/q/d/a/c$a;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        public a a() {
            return this.c;
        }

        @NotNull
        public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
            return a;
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/q/d/a/c$a.class */
    public static class a {
        public static final StreamCodec<RegistryFriendlyByteBuf, a> a = new StreamCodec<RegistryFriendlyByteBuf, a>() { // from class: mctech.q.d.a.c.a.1
            @NotNull
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public a decode(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
                BlockPos blockPosOf = BlockPos.of(registryFriendlyByteBuf.readLong());
                String utf = registryFriendlyByteBuf.readUtf();
                INetworkDataBuffer iNetworkDataBufferA = d.a(registryFriendlyByteBuf.readResourceLocation());
                iNetworkDataBufferA.read(registryFriendlyByteBuf);
                return new a(blockPosOf, utf, iNetworkDataBufferA);
            }

            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void encode(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf, @NotNull a aVar) {
                registryFriendlyByteBuf.writeLong(aVar.b.asLong());
                registryFriendlyByteBuf.writeUtf(aVar.c);
                registryFriendlyByteBuf.writeResourceLocation(d.a(aVar.d));
                aVar.d.write(registryFriendlyByteBuf);
            }
        };
        public BlockPos b;
        public String c;
        public INetworkDataBuffer d;

        public a(String str, INetworkDataBuffer iNetworkDataBuffer) {
            this(BlockPos.ZERO, str, iNetworkDataBuffer);
        }

        public a(BlockPos blockPos, String str, INetworkDataBuffer iNetworkDataBuffer) {
            this.b = blockPos;
            this.c = str;
            this.d = iNetworkDataBuffer;
        }
    }
}
