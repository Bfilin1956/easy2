package mctech.q.d.b;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import mctech.MCTech;
import mctech.api.network.item.INetworkItemEvent;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.neoforge.network.handling.IPayloadContext;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/q/d/b/b.class */
public class b {
    public static void a(a aVar, IPayloadContext iPayloadContext) {
        INetworkItemEvent item = aVar.c.getItem();
        if (!(item instanceof INetworkItemEvent)) {
            return;
        }
        item.onEventReceived(aVar.c, iPayloadContext.player(), aVar.d, aVar.e, aVar.f ? Dist.CLIENT : Dist.DEDICATED_SERVER);
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/q/d/b/b$a.class */
    public static final class a extends Record implements CustomPacketPayload {
        private final ItemStack c;
        private final int d;
        private final int e;
        private final boolean f;
        public static final CustomPacketPayload.Type<a> a = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "iep"));
        public static final StreamCodec<RegistryFriendlyByteBuf, a> b = StreamCodec.composite(ItemStack.STREAM_CODEC, (v0) -> {
            return v0.a();
        }, ByteBufCodecs.INT, (v0) -> {
            return v0.b();
        }, ByteBufCodecs.INT, (v0) -> {
            return v0.c();
        }, ByteBufCodecs.BOOL, (v0) -> {
            return v0.d();
        }, (v1, v2, v3, v4) -> {
            return new a(v1, v2, v3, v4);
        });

        public a(ItemStack itemStack, int i, int i2, boolean z) {
            this.c = itemStack;
            this.d = i;
            this.e = i2;
            this.f = z;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "itemStack;key;value;client", "FIELD:Lmctech/q/d/b/b$a;->c:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/q/d/b/b$a;->d:I", "FIELD:Lmctech/q/d/b/b$a;->e:I", "FIELD:Lmctech/q/d/b/b$a;->f:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "itemStack;key;value;client", "FIELD:Lmctech/q/d/b/b$a;->c:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/q/d/b/b$a;->d:I", "FIELD:Lmctech/q/d/b/b$a;->e:I", "FIELD:Lmctech/q/d/b/b$a;->f:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "itemStack;key;value;client", "FIELD:Lmctech/q/d/b/b$a;->c:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/q/d/b/b$a;->d:I", "FIELD:Lmctech/q/d/b/b$a;->e:I", "FIELD:Lmctech/q/d/b/b$a;->f:Z").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        public ItemStack a() {
            return this.c;
        }

        public int b() {
            return this.d;
        }

        public int c() {
            return this.e;
        }

        public boolean d() {
            return this.f;
        }

        public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
            return a;
        }
    }
}
