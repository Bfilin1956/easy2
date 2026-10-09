package mctech.q.d.d.a.a;

import io.netty.buffer.ByteBuf;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import mctech.MCTech;
import mctech.m.a.e;
import mctech.m.a.i;
import net.minecraft.core.Direction;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.network.handling.IPayloadContext;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/q/d/d/a/a/b.class */
public class b {
    public static void a(a aVar, IPayloadContext iPayloadContext) {
        i iVarA;
        if (iPayloadContext.player().getInventory().selected != aVar.d && aVar.d != -1) {
            return;
        }
        InteractionHand interactionHand = aVar.d == -1 ? InteractionHand.OFF_HAND : InteractionHand.MAIN_HAND;
        ItemStack itemInHand = iPayloadContext.player().getItemInHand(interactionHand);
        e item = itemInHand.getItem();
        if ((item instanceof e) && (iVarA = item.a(iPayloadContext.player(), interactionHand, itemInHand)) != null) {
            MCTech.PLATFORM.a(iPayloadContext.player(), interactionHand, Direction.NORTH, iVarA, aVar.c);
        }
    }

    public static void b(a aVar, IPayloadContext iPayloadContext) {
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/q/d/d/a/a/b$a.class */
    public static final class a extends Record implements CustomPacketPayload {
        private final int c;
        private final int d;
        public static final CustomPacketPayload.Type<a> a = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "oigp"));
        public static final StreamCodec<ByteBuf, a> b = StreamCodec.composite(ByteBufCodecs.INT, (v0) -> {
            return v0.a();
        }, ByteBufCodecs.INT, (v0) -> {
            return v0.b();
        }, (v1, v2) -> {
            return new a(v1, v2);
        });

        public a(int i, int i2) {
            this.c = i;
            this.d = i2;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "windowID;inventorySlot", "FIELD:Lmctech/q/d/d/a/a/b$a;->c:I", "FIELD:Lmctech/q/d/d/a/a/b$a;->d:I").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "windowID;inventorySlot", "FIELD:Lmctech/q/d/d/a/a/b$a;->c:I", "FIELD:Lmctech/q/d/d/a/a/b$a;->d:I").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "windowID;inventorySlot", "FIELD:Lmctech/q/d/d/a/a/b$a;->c:I", "FIELD:Lmctech/q/d/d/a/a/b$a;->d:I").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        public int a() {
            return this.c;
        }

        public int b() {
            return this.d;
        }

        public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
            return a;
        }
    }
}
