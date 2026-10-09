package mctech.q.d.d.a.b;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.List;
import mctech.MCTech;
import mctech.q.d;
import net.minecraft.core.BlockPos;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.network.handling.IPayloadContext;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/q/d/d/a/b/b.class */
public class b {
    public static void a(a aVar, IPayloadContext iPayloadContext) {
        BlockEntity blockEntity = iPayloadContext.player().level().getBlockEntity(aVar.a());
        if (blockEntity != null) {
            mctech.q.c.a.a(blockEntity, aVar.b(), false, iPayloadContext.player());
        }
    }

    public static void b(a aVar, IPayloadContext iPayloadContext) {
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/q/d/d/a/b/b$a.class */
    public static final class a extends Record implements CustomPacketPayload {
        private final BlockPos c;
        private final List<d.a> d;
        public static final CustomPacketPayload.Type<a> a = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "nfu"));
        public static final StreamCodec<RegistryFriendlyByteBuf, a> b = StreamCodec.composite(BlockPos.STREAM_CODEC, (v0) -> {
            return v0.a();
        }, d.a.b, (v0) -> {
            return v0.b();
        }, a::new);

        public a(BlockPos blockPos, List<d.a> list) {
            this.c = blockPos;
            this.d = list;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "pos;data", "FIELD:Lmctech/q/d/d/a/b/b$a;->c:Lnet/minecraft/core/BlockPos;", "FIELD:Lmctech/q/d/d/a/b/b$a;->d:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "pos;data", "FIELD:Lmctech/q/d/d/a/b/b$a;->c:Lnet/minecraft/core/BlockPos;", "FIELD:Lmctech/q/d/d/a/b/b$a;->d:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "pos;data", "FIELD:Lmctech/q/d/d/a/b/b$a;->c:Lnet/minecraft/core/BlockPos;", "FIELD:Lmctech/q/d/d/a/b/b$a;->d:Ljava/util/List;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        public BlockPos a() {
            return this.c;
        }

        public List<d.a> b() {
            return this.d;
        }

        public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
            return a;
        }
    }
}
