package mctech.q.d;

import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.Map;
import mctech.MCTech;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/q/d/h.class */
public final class h extends Record implements CustomPacketPayload {
    private final Map<Fluid, Integer> c;
    public static final CustomPacketPayload.Type<h> a = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "sync_coolant"));
    public static final StreamCodec<FriendlyByteBuf, h> b = new StreamCodec<FriendlyByteBuf, h>() { // from class: mctech.q.d.h.1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public h decode(FriendlyByteBuf friendlyByteBuf) {
            int i = friendlyByteBuf.readInt();
            Object2ObjectMap object2ObjectMapE = mctech.utils.a.b.e();
            while (true) {
                int i2 = i;
                i--;
                if (i2 > 0) {
                    Fluid fluid = (Fluid) BuiltInRegistries.FLUID.get(ResourceLocation.parse(friendlyByteBuf.readUtf()));
                    int i3 = friendlyByteBuf.readInt();
                    if (fluid != null && i3 > 0) {
                        object2ObjectMapE.put(fluid, Integer.valueOf(i3));
                    }
                } else {
                    return new h(object2ObjectMapE);
                }
            }
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void encode(FriendlyByteBuf friendlyByteBuf, h hVar) {
        }
    };

    public h(Map<Fluid, Integer> map) {
        this.c = map;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, h.class), h.class, "coolantMap", "FIELD:Lmctech/q/d/h;->c:Ljava/util/Map;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, h.class), h.class, "coolantMap", "FIELD:Lmctech/q/d/h;->c:Ljava/util/Map;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, h.class, Object.class), h.class, "coolantMap", "FIELD:Lmctech/q/d/h;->c:Ljava/util/Map;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public Map<Fluid, Integer> a() {
        return this.c;
    }

    public static void a(h hVar, IPayloadContext iPayloadContext) {
        mctech.blockentities.m.a(hVar.a());
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return a;
    }
}
