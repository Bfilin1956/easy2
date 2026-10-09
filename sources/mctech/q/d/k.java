package mctech.q.d;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.UUID;
import mctech.MCTech;
import net.minecraft.core.UUIDUtil;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/q/d/k.class */
public final class k extends Record implements CustomPacketPayload {
    private final UUID c;
    private final int d;
    private final mctech.items.e.c.e e;
    public static final CustomPacketPayload.Type<k> a = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "sssp"));
    public static final StreamCodec<RegistryFriendlyByteBuf, k> b = StreamCodec.composite(UUIDUtil.STREAM_CODEC, (v0) -> {
        return v0.a();
    }, ByteBufCodecs.INT, (v0) -> {
        return v0.b();
    }, mctech.items.e.c.e.c, (v0) -> {
        return v0.c();
    }, (v1, v2, v3) -> {
        return new k(v1, v2, v3);
    });

    public k(UUID uuid, int i, mctech.items.e.c.e eVar) {
        this.c = uuid;
        this.d = i;
        this.e = eVar;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, k.class), k.class, "playerUid;windowId;singularStaffSettings", "FIELD:Lmctech/q/d/k;->c:Ljava/util/UUID;", "FIELD:Lmctech/q/d/k;->d:I", "FIELD:Lmctech/q/d/k;->e:Lmctech/items/e/c/e;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, k.class), k.class, "playerUid;windowId;singularStaffSettings", "FIELD:Lmctech/q/d/k;->c:Ljava/util/UUID;", "FIELD:Lmctech/q/d/k;->d:I", "FIELD:Lmctech/q/d/k;->e:Lmctech/items/e/c/e;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, k.class, Object.class), k.class, "playerUid;windowId;singularStaffSettings", "FIELD:Lmctech/q/d/k;->c:Ljava/util/UUID;", "FIELD:Lmctech/q/d/k;->d:I", "FIELD:Lmctech/q/d/k;->e:Lmctech/items/e/c/e;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public UUID a() {
        return this.c;
    }

    public int b() {
        return this.d;
    }

    public mctech.items.e.c.e c() {
        return this.e;
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return a;
    }

    public static void a(k kVar, IPayloadContext iPayloadContext) {
    }
}
