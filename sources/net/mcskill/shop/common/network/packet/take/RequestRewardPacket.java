package net.mcskill.shop.common.network.packet.take;

import io.netty.buffer.ByteBuf;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.mcskill.shop.server.MSShopServer;
import net.mcskill.shop.server.network.PacketHandler;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: RequestRewardPacket.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/common/network/packet/take/RequestRewardPacket.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00000\u0005H\u0016R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00000\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007RS\u0010\b\u001aB\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\n0\n\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\u00000\u0000 \u000b* \u0012\f\u0012\n \u000b*\u0004\u0018\u00010\n0\n\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\u00000\u0000\u0018\u00010\t0\t¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"Lnet/mcskill/shop/common/network/packet/take/RequestRewardPacket;", "Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload;", "<init>", "()V", "TYPE", "Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload$Type;", "getTYPE", "()Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload$Type;", "CODEC", "Lnet/minecraft/network/codec/StreamCodec;", "Lio/netty/buffer/ByteBuf;", "kotlin.jvm.PlatformType", "getCODEC", "()Lnet/minecraft/network/codec/StreamCodec;", "Lnet/minecraft/network/codec/StreamCodec;", "handle", "", "packet", "context", "Lnet/neoforged/neoforge/network/handling/IPayloadContext;", "type", "MSShop"})
public final class RequestRewardPacket implements CustomPacketPayload {

    @NotNull
    public static final RequestRewardPacket INSTANCE = new RequestRewardPacket();

    @NotNull
    private static final CustomPacketPayload.Type<RequestRewardPacket> TYPE = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath("msshop", "request_reward"));
    private static final StreamCodec<ByteBuf, RequestRewardPacket> CODEC = StreamCodec.unit(INSTANCE);

    private RequestRewardPacket() {
    }

    @NotNull
    public final CustomPacketPayload.Type<RequestRewardPacket> getTYPE() {
        return TYPE;
    }

    public final StreamCodec<ByteBuf, RequestRewardPacket> getCODEC() {
        return CODEC;
    }

    public final void handle(@NotNull RequestRewardPacket packet, @NotNull IPayloadContext context) {
        Intrinsics.checkNotNullParameter(packet, "packet");
        Intrinsics.checkNotNullParameter(context, "context");
        PacketHandler packetHandler$MSShop = MSShopServer.Companion.getPacketHandler$MSShop();
        ServerPlayer serverPlayerPlayer = context.player();
        Intrinsics.checkNotNull(serverPlayerPlayer, "null cannot be cast to non-null type net.minecraft.server.level.ServerPlayer");
        packetHandler$MSShop.giveRewardNow(serverPlayerPlayer);
    }

    @NotNull
    public CustomPacketPayload.Type<RequestRewardPacket> type() {
        return TYPE;
    }
}
