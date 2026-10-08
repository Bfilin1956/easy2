package net.mcskill.shop.common.network.packet;

import io.netty.buffer.ByteBuf;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty1;
import net.mcskill.shop.server.MSShopServer;
import net.mcskill.shop.server.network.PacketHandler;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: RequestBalancePacket.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/common/network/packet/RequestBalancePacket.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00000\bH\u0016J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lnet/mcskill/shop/common/network/packet/RequestBalancePacket;", "Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload;", "type", "", "<init>", "(I)V", "getType", "()I", "Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload$Type;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "Companion", "MSShop"})
public final /* data */ class RequestBalancePacket implements CustomPacketPayload {
    private final int type;
    private static final StreamCodec<ByteBuf, RequestBalancePacket> CODEC;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final CustomPacketPayload.Type<RequestBalancePacket> TYPE = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath("mscore", "request_balance"));

    public final int component1() {
        return this.type;
    }

    @NotNull
    public final RequestBalancePacket copy(int type) {
        return new RequestBalancePacket(type);
    }

    public static /* synthetic */ RequestBalancePacket copy$default(RequestBalancePacket requestBalancePacket, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = requestBalancePacket.type;
        }
        return requestBalancePacket.copy(i);
    }

    @NotNull
    public String toString() {
        return "RequestBalancePacket(type=" + this.type + ")";
    }

    public int hashCode() {
        return Integer.hashCode(this.type);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof RequestBalancePacket) && this.type == ((RequestBalancePacket) other).type;
    }

    public RequestBalancePacket() {
        this(0, 1, null);
    }

    public RequestBalancePacket(int type) {
        this.type = type;
    }

    public /* synthetic */ RequestBalancePacket(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? -1 : i);
    }

    public final int getType() {
        return this.type;
    }

    /* JADX INFO: compiled from: RequestBalancePacket.kt */
    /* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/common/network/packet/RequestBalancePacket$Companion.class */
    @Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0014R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bRS\u0010\t\u001aB\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00060\u0006 \f* \u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\n0\n¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0015"}, d2 = {"Lnet/mcskill/shop/common/network/packet/RequestBalancePacket$Companion;", "", "<init>", "()V", "TYPE", "Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload$Type;", "Lnet/mcskill/shop/common/network/packet/RequestBalancePacket;", "getTYPE", "()Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload$Type;", "CODEC", "Lnet/minecraft/network/codec/StreamCodec;", "Lio/netty/buffer/ByteBuf;", "kotlin.jvm.PlatformType", "getCODEC", "()Lnet/minecraft/network/codec/StreamCodec;", "Lnet/minecraft/network/codec/StreamCodec;", "handle", "", "packet", "context", "Lnet/neoforged/neoforge/network/handling/IPayloadContext;", "MSShop"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final CustomPacketPayload.Type<RequestBalancePacket> getTYPE() {
            return RequestBalancePacket.TYPE;
        }

        public final StreamCodec<ByteBuf, RequestBalancePacket> getCODEC() {
            return RequestBalancePacket.CODEC;
        }

        public final void handle(@NotNull RequestBalancePacket packet, @NotNull IPayloadContext context) {
            Intrinsics.checkNotNullParameter(packet, "packet");
            Intrinsics.checkNotNullParameter(context, "context");
            PacketHandler packetHandler$MSShop = MSShopServer.Companion.getPacketHandler$MSShop();
            ServerPlayer serverPlayerPlayer = context.player();
            Intrinsics.checkNotNull(serverPlayerPlayer, "null cannot be cast to non-null type net.minecraft.server.level.ServerPlayer");
            packetHandler$MSShop.requestBalance(packet, serverPlayerPlayer);
        }
    }

    static {
        StreamCodec streamCodec = ByteBufCodecs.VAR_INT;
        KProperty1 kProperty1 = new PropertyReference1Impl() { // from class: net.mcskill.shop.common.network.packet.RequestBalancePacket$Companion$CODEC$1
            public Object get(Object receiver0) {
                return Integer.valueOf(((RequestBalancePacket) receiver0).getType());
            }
        };
        CODEC = StreamCodec.composite(streamCodec, (v1) -> {
            return CODEC$lambda$0(r1, v1);
        }, (v1) -> {
            return new RequestBalancePacket(v1);
        });
    }

    private static final Integer CODEC$lambda$0(KProperty1 $tmp0, RequestBalancePacket p0) {
        return (Integer) ((Function1) $tmp0).invoke(p0);
    }

    @NotNull
    public CustomPacketPayload.Type<RequestBalancePacket> type() {
        return TYPE;
    }
}
