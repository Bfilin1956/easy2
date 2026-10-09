package mctech.q.d.b;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import mctech.MCTech;
import mctech.api.network.item.INetworkItemBufferEvent;
import mctech.q.d.a.c;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.neoforge.network.handling.IPayloadContext;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/q/d/b/a.class */
public class a {
    public static void a(C0035a c0035a, IPayloadContext iPayloadContext) {
        INetworkItemBufferEvent item = c0035a.e.getItem();
        if (!(item instanceof INetworkItemBufferEvent)) {
            return;
        }
        item.onDataBufferReceived(c0035a.e, iPayloadContext.player(), c0035a.c, c0035a.d.d, c0035a.f ? Dist.CLIENT : Dist.DEDICATED_SERVER);
    }

    /* JADX INFO: renamed from: mctech.q.d.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/q/d/b/a$a.class */
    public static final class C0035a extends Record implements CustomPacketPayload {
        private final String c;
        private final c.a d;
        private final ItemStack e;
        private final boolean f;
        public static final CustomPacketPayload.Type<C0035a> a = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "idbp"));
        public static final StreamCodec<RegistryFriendlyByteBuf, C0035a> b = StreamCodec.composite(ByteBufCodecs.STRING_UTF8, (v0) -> {
            return v0.a();
        }, c.a.a, (v0) -> {
            return v0.b();
        }, ItemStack.STREAM_CODEC, (v0) -> {
            return v0.c();
        }, ByteBufCodecs.BOOL, (v0) -> {
            return v0.d();
        }, (v1, v2, v3, v4) -> {
            return new C0035a(v1, v2, v3, v4);
        });

        public C0035a(String str, c.a aVar, ItemStack itemStack, boolean z) {
            this.c = str;
            this.d = aVar;
            this.e = itemStack;
            this.f = z;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0035a.class), C0035a.class, "id;data;itemStack;client", "FIELD:Lmctech/q/d/b/a$a;->c:Ljava/lang/String;", "FIELD:Lmctech/q/d/b/a$a;->d:Lmctech/q/d/a/c$a;", "FIELD:Lmctech/q/d/b/a$a;->e:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/q/d/b/a$a;->f:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0035a.class), C0035a.class, "id;data;itemStack;client", "FIELD:Lmctech/q/d/b/a$a;->c:Ljava/lang/String;", "FIELD:Lmctech/q/d/b/a$a;->d:Lmctech/q/d/a/c$a;", "FIELD:Lmctech/q/d/b/a$a;->e:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/q/d/b/a$a;->f:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0035a.class, Object.class), C0035a.class, "id;data;itemStack;client", "FIELD:Lmctech/q/d/b/a$a;->c:Ljava/lang/String;", "FIELD:Lmctech/q/d/b/a$a;->d:Lmctech/q/d/a/c$a;", "FIELD:Lmctech/q/d/b/a$a;->e:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/q/d/b/a$a;->f:Z").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        public String a() {
            return this.c;
        }

        public c.a b() {
            return this.d;
        }

        public ItemStack c() {
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
