package mctech.q.d;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.List;
import mctech.MCTech;
import mctech.blockentities.p;
import net.minecraft.core.BlockPos;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/q/d/n.class */
public final class n extends Record implements CustomPacketPayload {
    private final BlockPos c;
    private final List<mctech.blockentities.f.e> d;
    public static final CustomPacketPayload.Type<n> a = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "teleport_sync"));
    public static final StreamCodec<RegistryFriendlyByteBuf, n> b = StreamCodec.composite(BlockPos.STREAM_CODEC, (v0) -> {
        return v0.a();
    }, mctech.blockentities.f.e.b.apply(ByteBufCodecs.list()), (v0) -> {
        return v0.b();
    }, n::new);

    public n(BlockPos blockPos, List<mctech.blockentities.f.e> list) {
        this.c = blockPos;
        this.d = list;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, n.class), n.class, "tilePosition;teleportList", "FIELD:Lmctech/q/d/n;->c:Lnet/minecraft/core/BlockPos;", "FIELD:Lmctech/q/d/n;->d:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, n.class), n.class, "tilePosition;teleportList", "FIELD:Lmctech/q/d/n;->c:Lnet/minecraft/core/BlockPos;", "FIELD:Lmctech/q/d/n;->d:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, n.class, Object.class), n.class, "tilePosition;teleportList", "FIELD:Lmctech/q/d/n;->c:Lnet/minecraft/core/BlockPos;", "FIELD:Lmctech/q/d/n;->d:Ljava/util/List;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public BlockPos a() {
        return this.c;
    }

    public List<mctech.blockentities.f.e> b() {
        return this.d;
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return a;
    }

    public static void a(@NotNull n nVar, IPayloadContext iPayloadContext) {
        iPayloadContext.enqueueWork(() -> {
            Player player = iPayloadContext.player();
            Level level = player.level();
            if (level.isLoaded(nVar.a())) {
                BlockEntity blockEntity = level.getBlockEntity(nVar.a());
                if (blockEntity instanceof p) {
                    p pVar = (p) blockEntity;
                    if (pVar.b(player)) {
                        pVar.a(nVar.b());
                    }
                }
            }
        });
    }

    public static void b(@NotNull n nVar, IPayloadContext iPayloadContext) {
        iPayloadContext.enqueueWork(() -> {
        });
    }
}
