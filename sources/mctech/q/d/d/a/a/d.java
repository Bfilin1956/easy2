package mctech.q.d.d.a.a;

import io.netty.buffer.ByteBuf;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import mctech.MCTech;
import mctech.m.a.f;
import mctech.m.a.i;
import net.minecraft.client.Minecraft;
import net.minecraft.core.Direction;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.network.handling.IPayloadContext;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/q/d/d/a/a/d.class */
public class d {
    public static void a(a aVar, IPayloadContext iPayloadContext) {
        if (aVar.d == -1) {
            return;
        }
        try {
            Slot slot = iPayloadContext.player().containerMenu.getSlot(aVar.d);
            ItemStack item = slot.getItem();
            f item2 = item.getItem();
            if (item2 instanceof f) {
                f fVar = item2;
                i iVarA = slot.container instanceof Inventory ? fVar.a(iPayloadContext.player(), InteractionHand.MAIN_HAND, item) : fVar.a(iPayloadContext.player(), item, slot);
                if (iVarA != null) {
                    if (iPayloadContext.player().containerMenu != iPayloadContext.player().inventoryMenu) {
                        mctech.s.d.a().h.push(new mctech.s.d.a(iPayloadContext.player().containerMenu, Minecraft.getInstance().screen));
                    }
                    MCTech.PLATFORM.a(iPayloadContext.player(), InteractionHand.MAIN_HAND, Direction.NORTH, iVarA, aVar.c);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void b(a aVar, IPayloadContext iPayloadContext) {
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/q/d/d/a/a/d$a.class */
    public static final class a extends Record implements CustomPacketPayload {
        private final int c;
        private final int d;
        public static final CustomPacketPayload.Type<a> a = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "soig"));
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
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "windowID;slotId", "FIELD:Lmctech/q/d/d/a/a/d$a;->c:I", "FIELD:Lmctech/q/d/d/a/a/d$a;->d:I").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "windowID;slotId", "FIELD:Lmctech/q/d/d/a/a/d$a;->c:I", "FIELD:Lmctech/q/d/d/a/a/d$a;->d:I").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "windowID;slotId", "FIELD:Lmctech/q/d/d/a/a/d$a;->c:I", "FIELD:Lmctech/q/d/d/a/a/d$a;->d:I").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
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
