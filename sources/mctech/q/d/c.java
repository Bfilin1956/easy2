package mctech.q.d;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import mctech.MCTech;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.network.handling.IPayloadContext;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/q/d/c.class */
public final class c extends Record implements CustomPacketPayload {
    private final int c;
    private final ItemStack d;
    public static final CustomPacketPayload.Type<c> a = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "drop_stack"));
    public static final StreamCodec<RegistryFriendlyByteBuf, c> b = StreamCodec.composite(ByteBufCodecs.INT, (v0) -> {
        return v0.a();
    }, ItemStack.OPTIONAL_STREAM_CODEC, (v0) -> {
        return v0.b();
    }, (v1, v2) -> {
        return new c(v1, v2);
    });

    public c(int i, ItemStack itemStack) {
        this.c = i;
        this.d = itemStack;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, c.class), c.class, "slotId;dropStack", "FIELD:Lmctech/q/d/c;->c:I", "FIELD:Lmctech/q/d/c;->d:Lnet/minecraft/world/item/ItemStack;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, c.class), c.class, "slotId;dropStack", "FIELD:Lmctech/q/d/c;->c:I", "FIELD:Lmctech/q/d/c;->d:Lnet/minecraft/world/item/ItemStack;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, c.class, Object.class), c.class, "slotId;dropStack", "FIELD:Lmctech/q/d/c;->c:I", "FIELD:Lmctech/q/d/c;->d:Lnet/minecraft/world/item/ItemStack;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public int a() {
        return this.c;
    }

    public ItemStack b() {
        return this.d;
    }

    public static void a(c cVar, IPayloadContext iPayloadContext) {
    }

    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return a;
    }
}
