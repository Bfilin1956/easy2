package net.mcskill.shop.common.network;

import io.netty.buffer.ByteBuf;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.mcskill.shop.common.network.packet.NotifyPacket;
import net.mcskill.shop.common.network.packet.NotifyVelocityPacket;
import net.mcskill.shop.common.network.packet.RequestBalancePacket;
import net.mcskill.shop.common.network.packet.RequestShopDataPacket;
import net.mcskill.shop.common.network.packet.buy.RequestBuyCasePacket;
import net.mcskill.shop.common.network.packet.buy.RequestBuyGroupPacket;
import net.mcskill.shop.common.network.packet.buy.RequestBuyItemPacket;
import net.mcskill.shop.common.network.packet.buy.RequestExchangePacket;
import net.mcskill.shop.common.network.packet.sync.ResponseBalancePacket;
import net.mcskill.shop.common.network.packet.sync.ResponseCanOpenCasePacket;
import net.mcskill.shop.common.network.packet.sync.ResponseCaseRewardPacket;
import net.mcskill.shop.common.network.packet.sync.ResponseCasesPacket;
import net.mcskill.shop.common.network.packet.sync.ResponseCategoriesPacket;
import net.mcskill.shop.common.network.packet.sync.ResponseConfigPacket;
import net.mcskill.shop.common.network.packet.sync.ResponseExchangePacket;
import net.mcskill.shop.common.network.packet.sync.ResponseGroupsPacket;
import net.mcskill.shop.common.network.packet.sync.ResponseItemsPacket;
import net.mcskill.shop.common.network.packet.sync.ResponseOpenCart;
import net.mcskill.shop.common.network.packet.take.CheckCanOpenCasePacket;
import net.mcskill.shop.common.network.packet.take.RequestCartActionPacket;
import net.mcskill.shop.common.network.packet.take.RequestGiftGroup;
import net.mcskill.shop.common.network.packet.take.RequestRewardPacket;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ChannelHandler.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/common/network/ChannelHandler.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0000¢\u0006\u0002\b\rJ\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J*\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0018J\u0016\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u001bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lnet/mcskill/shop/common/network/ChannelHandler;", "", "<init>", "()V", "_wasInitialized", "", "CHANNEL_IDENTIFIER", "", "PROTOCOL_VERSION", "register", "", "modBus", "Lnet/neoforged/bus/api/IEventBus;", "register$MSShop", "onRegisterPackets", "event", "Lnet/neoforged/neoforge/network/event/RegisterPayloadHandlersEvent;", "notify", "text", "player", "Lnet/minecraft/server/level/ServerPlayer;", "status", "", "duration", "", "sendTo", "packet", "Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload;", "sendToServer", "MSShop"})
public final class ChannelHandler {

    @NotNull
    public static final ChannelHandler INSTANCE = new ChannelHandler();
    private static boolean _wasInitialized;

    @NotNull
    public static final String CHANNEL_IDENTIFIER = "msshop";

    @NotNull
    private static final String PROTOCOL_VERSION = "1.0.0";

    private ChannelHandler() {
    }

    public final void register$MSShop(@NotNull IEventBus modBus) {
        Intrinsics.checkNotNullParameter(modBus, "modBus");
        if (_wasInitialized) {
            return;
        }
        modBus.addListener(this::onRegisterPackets);
        _wasInitialized = true;
    }

    private final void onRegisterPackets(RegisterPayloadHandlersEvent event) {
        PayloadRegistrar $this$onRegisterPackets_u24lambda_u240 = event.registrar(PROTOCOL_VERSION);
        CustomPacketPayload.Type<RequestShopDataPacket> type = RequestShopDataPacket.INSTANCE.getTYPE();
        StreamCodec<ByteBuf, RequestShopDataPacket> codec = RequestShopDataPacket.INSTANCE.getCODEC();
        RequestShopDataPacket requestShopDataPacket = RequestShopDataPacket.INSTANCE;
        $this$onRegisterPackets_u24lambda_u240.playToServer(type, codec, requestShopDataPacket::handle);
        CustomPacketPayload.Type<RequestBuyCasePacket> type2 = RequestBuyCasePacket.INSTANCE.getTYPE();
        StreamCodec<ByteBuf, RequestBuyCasePacket> codec2 = RequestBuyCasePacket.INSTANCE.getCODEC();
        RequestBuyCasePacket.Companion companion = RequestBuyCasePacket.INSTANCE;
        $this$onRegisterPackets_u24lambda_u240.playToServer(type2, codec2, companion::handle);
        CustomPacketPayload.Type<RequestBuyGroupPacket> type3 = RequestBuyGroupPacket.INSTANCE.getTYPE();
        StreamCodec<ByteBuf, RequestBuyGroupPacket> codec3 = RequestBuyGroupPacket.INSTANCE.getCODEC();
        RequestBuyGroupPacket.Companion companion2 = RequestBuyGroupPacket.INSTANCE;
        $this$onRegisterPackets_u24lambda_u240.playToServer(type3, codec3, companion2::handle);
        CustomPacketPayload.Type<RequestBuyItemPacket> type4 = RequestBuyItemPacket.INSTANCE.getTYPE();
        StreamCodec<ByteBuf, RequestBuyItemPacket> codec4 = RequestBuyItemPacket.INSTANCE.getCODEC();
        RequestBuyItemPacket.Companion companion3 = RequestBuyItemPacket.INSTANCE;
        $this$onRegisterPackets_u24lambda_u240.playToServer(type4, codec4, companion3::handle);
        CustomPacketPayload.Type<RequestRewardPacket> type5 = RequestRewardPacket.INSTANCE.getTYPE();
        StreamCodec<ByteBuf, RequestRewardPacket> codec5 = RequestRewardPacket.INSTANCE.getCODEC();
        RequestRewardPacket requestRewardPacket = RequestRewardPacket.INSTANCE;
        $this$onRegisterPackets_u24lambda_u240.playToServer(type5, codec5, requestRewardPacket::handle);
        CustomPacketPayload.Type<RequestGiftGroup> type6 = RequestGiftGroup.INSTANCE.getTYPE();
        StreamCodec<ByteBuf, RequestGiftGroup> codec6 = RequestGiftGroup.INSTANCE.getCODEC();
        RequestGiftGroup.Companion companion4 = RequestGiftGroup.INSTANCE;
        $this$onRegisterPackets_u24lambda_u240.playToServer(type6, codec6, companion4::handle);
        CustomPacketPayload.Type<RequestBalancePacket> type7 = RequestBalancePacket.INSTANCE.getTYPE();
        StreamCodec<ByteBuf, RequestBalancePacket> codec7 = RequestBalancePacket.INSTANCE.getCODEC();
        RequestBalancePacket.Companion companion5 = RequestBalancePacket.INSTANCE;
        $this$onRegisterPackets_u24lambda_u240.playToServer(type7, codec7, companion5::handle);
        CustomPacketPayload.Type<RequestExchangePacket> type8 = RequestExchangePacket.INSTANCE.getTYPE();
        StreamCodec<ByteBuf, RequestExchangePacket> codec8 = RequestExchangePacket.INSTANCE.getCODEC();
        RequestExchangePacket.Companion companion6 = RequestExchangePacket.INSTANCE;
        $this$onRegisterPackets_u24lambda_u240.playToServer(type8, codec8, companion6::handle);
        CustomPacketPayload.Type<RequestCartActionPacket> type9 = RequestCartActionPacket.INSTANCE.getTYPE();
        StreamCodec<ByteBuf, RequestCartActionPacket> codec9 = RequestCartActionPacket.INSTANCE.getCODEC();
        RequestCartActionPacket.Companion companion7 = RequestCartActionPacket.INSTANCE;
        $this$onRegisterPackets_u24lambda_u240.playToServer(type9, codec9, companion7::handle);
        CustomPacketPayload.Type<CheckCanOpenCasePacket> type10 = CheckCanOpenCasePacket.INSTANCE.getTYPE();
        StreamCodec<ByteBuf, CheckCanOpenCasePacket> codec10 = CheckCanOpenCasePacket.INSTANCE.getCODEC();
        CheckCanOpenCasePacket.Companion companion8 = CheckCanOpenCasePacket.INSTANCE;
        $this$onRegisterPackets_u24lambda_u240.playToServer(type10, codec10, companion8::handle);
        CustomPacketPayload.Type<NotifyVelocityPacket> type11 = NotifyVelocityPacket.INSTANCE.getTYPE();
        StreamCodec<ByteBuf, NotifyVelocityPacket> codec11 = NotifyVelocityPacket.INSTANCE.getCODEC();
        NotifyVelocityPacket.Companion companion9 = NotifyVelocityPacket.INSTANCE;
        $this$onRegisterPackets_u24lambda_u240.playToClient(type11, codec11, companion9::handle);
        CustomPacketPayload.Type<NotifyPacket> type12 = NotifyPacket.INSTANCE.getTYPE();
        StreamCodec<ByteBuf, NotifyPacket> codec12 = NotifyPacket.INSTANCE.getCODEC();
        NotifyPacket.Companion companion10 = NotifyPacket.INSTANCE;
        $this$onRegisterPackets_u24lambda_u240.playToClient(type12, codec12, companion10::handle);
        CustomPacketPayload.Type<ResponseBalancePacket> type13 = ResponseBalancePacket.INSTANCE.getTYPE();
        StreamCodec<ByteBuf, ResponseBalancePacket> codec13 = ResponseBalancePacket.INSTANCE.getCODEC();
        ResponseBalancePacket.Companion companion11 = ResponseBalancePacket.INSTANCE;
        $this$onRegisterPackets_u24lambda_u240.playToClient(type13, codec13, companion11::handle);
        CustomPacketPayload.Type<ResponseCanOpenCasePacket> type14 = ResponseCanOpenCasePacket.INSTANCE.getTYPE();
        StreamCodec<ByteBuf, ResponseCanOpenCasePacket> codec14 = ResponseCanOpenCasePacket.INSTANCE.getCODEC();
        ResponseCanOpenCasePacket.Companion companion12 = ResponseCanOpenCasePacket.INSTANCE;
        $this$onRegisterPackets_u24lambda_u240.playToClient(type14, codec14, companion12::handle);
        CustomPacketPayload.Type<ResponseCaseRewardPacket> type15 = ResponseCaseRewardPacket.INSTANCE.getTYPE();
        StreamCodec<FriendlyByteBuf, ResponseCaseRewardPacket> codec15 = ResponseCaseRewardPacket.INSTANCE.getCODEC();
        ResponseCaseRewardPacket.Companion companion13 = ResponseCaseRewardPacket.INSTANCE;
        $this$onRegisterPackets_u24lambda_u240.playToClient(type15, codec15, companion13::handle);
        CustomPacketPayload.Type<ResponseCategoriesPacket> type16 = ResponseCategoriesPacket.INSTANCE.getTYPE();
        StreamCodec<FriendlyByteBuf, ResponseCategoriesPacket> codec16 = ResponseCategoriesPacket.INSTANCE.getCODEC();
        ResponseCategoriesPacket.Companion companion14 = ResponseCategoriesPacket.INSTANCE;
        $this$onRegisterPackets_u24lambda_u240.playToClient(type16, codec16, companion14::handle);
        CustomPacketPayload.Type<ResponseCasesPacket> type17 = ResponseCasesPacket.INSTANCE.getTYPE();
        StreamCodec<FriendlyByteBuf, ResponseCasesPacket> codec17 = ResponseCasesPacket.INSTANCE.getCODEC();
        ResponseCasesPacket.Companion companion15 = ResponseCasesPacket.INSTANCE;
        $this$onRegisterPackets_u24lambda_u240.playToClient(type17, codec17, companion15::handle);
        CustomPacketPayload.Type<ResponseGroupsPacket> type18 = ResponseGroupsPacket.INSTANCE.getTYPE();
        StreamCodec<FriendlyByteBuf, ResponseGroupsPacket> codec18 = ResponseGroupsPacket.INSTANCE.getCODEC();
        ResponseGroupsPacket.Companion companion16 = ResponseGroupsPacket.INSTANCE;
        $this$onRegisterPackets_u24lambda_u240.playToClient(type18, codec18, companion16::handle);
        CustomPacketPayload.Type<ResponseItemsPacket> type19 = ResponseItemsPacket.INSTANCE.getTYPE();
        StreamCodec<FriendlyByteBuf, ResponseItemsPacket> codec19 = ResponseItemsPacket.INSTANCE.getCODEC();
        ResponseItemsPacket.Companion companion17 = ResponseItemsPacket.INSTANCE;
        $this$onRegisterPackets_u24lambda_u240.playToClient(type19, codec19, companion17::handle);
        CustomPacketPayload.Type<ResponseExchangePacket> type20 = ResponseExchangePacket.INSTANCE.getTYPE();
        StreamCodec<ByteBuf, ResponseExchangePacket> codec20 = ResponseExchangePacket.INSTANCE.getCODEC();
        ResponseExchangePacket.Companion companion18 = ResponseExchangePacket.INSTANCE;
        $this$onRegisterPackets_u24lambda_u240.playToClient(type20, codec20, companion18::handle);
        CustomPacketPayload.Type<ResponseConfigPacket> type21 = ResponseConfigPacket.INSTANCE.getTYPE();
        StreamCodec<ByteBuf, ResponseConfigPacket> codec21 = ResponseConfigPacket.INSTANCE.getCODEC();
        ResponseConfigPacket.Companion companion19 = ResponseConfigPacket.INSTANCE;
        $this$onRegisterPackets_u24lambda_u240.playToClient(type21, codec21, companion19::handle);
        CustomPacketPayload.Type<ResponseOpenCart> type22 = ResponseOpenCart.INSTANCE.getTYPE();
        StreamCodec<ByteBuf, ResponseOpenCart> codec22 = ResponseOpenCart.INSTANCE.getCODEC();
        ResponseOpenCart responseOpenCart = ResponseOpenCart.INSTANCE;
        $this$onRegisterPackets_u24lambda_u240.playToClient(type22, codec22, responseOpenCart::handle);
    }

    public static /* synthetic */ void notify$default(ChannelHandler channelHandler, String str, ServerPlayer serverPlayer, int i, float f, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        if ((i2 & 8) != 0) {
            f = 5.0f;
        }
        channelHandler.notify(str, serverPlayer, i, f);
    }

    public final void notify(@NotNull String text, @NotNull ServerPlayer player, int status, float duration) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(player, "player");
        sendTo(new NotifyPacket(text, status, duration), player);
    }

    public final void sendTo(@NotNull CustomPacketPayload packet, @NotNull ServerPlayer player) {
        Intrinsics.checkNotNullParameter(packet, "packet");
        Intrinsics.checkNotNullParameter(player, "player");
        PacketDistributor.sendToPlayer(player, packet, new CustomPacketPayload[0]);
    }

    public final void sendToServer(@NotNull CustomPacketPayload packet) {
        Intrinsics.checkNotNullParameter(packet, "packet");
        PacketDistributor.sendToServer(packet, new CustomPacketPayload[0]);
    }
}
