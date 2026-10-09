package mctech.g.b.a;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import mctech.MCTech;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/b/a/w.class */
public final class w extends Record implements CustomPacketPayload {
    private final int c;
    private final int d;
    private final ItemStack e;
    public static final CustomPacketPayload.Type<w> a = new CustomPacketPayload.Type<>(MCTech.loc("set_item_filter_slot"));
    public static final StreamCodec<RegistryFriendlyByteBuf, w> b = StreamCodec.composite(ByteBufCodecs.INT, (v0) -> {
        return v0.a();
    }, ByteBufCodecs.INT, (v0) -> {
        return v0.b();
    }, ItemStack.STREAM_CODEC, (v0) -> {
        return v0.c();
    }, (v1, v2, v3) -> {
        return new w(v1, v2, v3);
    });

    public w(int i, int i2, ItemStack itemStack) {
        this.c = i;
        this.d = i2;
        this.e = itemStack;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, w.class), w.class, "containerId;slotIndex;itemStack", "FIELD:Lmctech/g/b/a/w;->c:I", "FIELD:Lmctech/g/b/a/w;->d:I", "FIELD:Lmctech/g/b/a/w;->e:Lnet/minecraft/world/item/ItemStack;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, w.class), w.class, "containerId;slotIndex;itemStack", "FIELD:Lmctech/g/b/a/w;->c:I", "FIELD:Lmctech/g/b/a/w;->d:I", "FIELD:Lmctech/g/b/a/w;->e:Lnet/minecraft/world/item/ItemStack;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, w.class, Object.class), w.class, "containerId;slotIndex;itemStack", "FIELD:Lmctech/g/b/a/w;->c:I", "FIELD:Lmctech/g/b/a/w;->d:I", "FIELD:Lmctech/g/b/a/w;->e:Lnet/minecraft/world/item/ItemStack;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public int a() {
        return this.c;
    }

    public int b() {
        return this.d;
    }

    public ItemStack c() {
        return this.e;
    }

    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return a;
    }
}
