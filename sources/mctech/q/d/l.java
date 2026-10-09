package mctech.q.d;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import mctech.MCTech;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/q/d/l.class */
public final class l extends Record implements CustomPacketPayload {
    private final BlockPos c;
    private final Direction d;
    public static final CustomPacketPayload.Type<l> a = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "teleport_elevator_packet"));
    public static final StreamCodec<RegistryFriendlyByteBuf, l> b = StreamCodec.composite(BlockPos.STREAM_CODEC, (v0) -> {
        return v0.a();
    }, Direction.STREAM_CODEC, (v0) -> {
        return v0.b();
    }, l::new);

    public l(BlockPos blockPos, Direction direction) {
        this.c = blockPos;
        this.d = direction;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, l.class), l.class, "tilePosition;direction", "FIELD:Lmctech/q/d/l;->c:Lnet/minecraft/core/BlockPos;", "FIELD:Lmctech/q/d/l;->d:Lnet/minecraft/core/Direction;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, l.class), l.class, "tilePosition;direction", "FIELD:Lmctech/q/d/l;->c:Lnet/minecraft/core/BlockPos;", "FIELD:Lmctech/q/d/l;->d:Lnet/minecraft/core/Direction;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, l.class, Object.class), l.class, "tilePosition;direction", "FIELD:Lmctech/q/d/l;->c:Lnet/minecraft/core/BlockPos;", "FIELD:Lmctech/q/d/l;->d:Lnet/minecraft/core/Direction;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public BlockPos a() {
        return this.c;
    }

    public Direction b() {
        return this.d;
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return a;
    }

    public static void a(@NotNull l lVar, IPayloadContext iPayloadContext) {
    }

    public static void b(@NotNull l lVar, IPayloadContext iPayloadContext) {
    }

    private static boolean a(Level level, Player player, BlockPos blockPos) {
        return (level.isLoaded(blockPos) && player.containerMenu.stillValid(player)) ? false : true;
    }
}
