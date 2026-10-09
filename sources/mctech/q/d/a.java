package mctech.q.d;

import io.netty.buffer.ByteBuf;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import mctech.MCTech;
import mctech.components.ContainerComponent;
import mctech.components.v;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/q/d/a.class */
public final class a extends Record implements CustomPacketPayload {
    private final int c;
    public static final CustomPacketPayload.Type<a> a = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "fill_tank"));
    public static final StreamCodec<ByteBuf, a> b = StreamCodec.composite(ByteBufCodecs.VAR_INT, (v0) -> {
        return v0.a();
    }, (v1) -> {
        return new a(v1);
    });

    public a(int i) {
        this.c = i;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "widgetId", "FIELD:Lmctech/q/d/a;->c:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "widgetId", "FIELD:Lmctech/q/d/a;->c:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "widgetId", "FIELD:Lmctech/q/d/a;->c:I").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public int a() {
        return this.c;
    }

    public a(@NotNull v vVar) {
        this(vVar.a());
    }

    public static void a(a aVar, IPayloadContext iPayloadContext) {
        ServerPlayer serverPlayerPlayer = iPayloadContext.player();
        if (serverPlayerPlayer instanceof ServerPlayer) {
            ServerPlayer serverPlayer = serverPlayerPlayer;
            AbstractContainerMenu abstractContainerMenu = serverPlayer.containerMenu;
            if (abstractContainerMenu instanceof ContainerComponent) {
                ((ContainerComponent) abstractContainerMenu).getComponents().stream().filter(aVar2 -> {
                    return aVar2 instanceof v;
                }).map(aVar3 -> {
                    return (v) aVar3;
                }).filter(vVar -> {
                    return vVar.a() == aVar.c;
                }).findFirst().ifPresent(vVar2 -> {
                    vVar2.a(serverPlayer);
                });
            }
        }
    }

    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return a;
    }
}
