package net.mcskill.shop.common.network.packet.buy;

import io.netty.buffer.ByteBuf;
import java.util.function.Function;
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

/* JADX INFO: compiled from: RequestBuyGroupPacket.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/common/network/packet/buy/RequestBuyGroupPacket.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00000\u000fH\u0016J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001b"}, d2 = {"Lnet/mcskill/shop/common/network/packet/buy/RequestBuyGroupPacket;", "Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload;", "groupId", "", "time", "receiver", "", "<init>", "(IILjava/lang/String;)V", "getGroupId", "()I", "getTime", "getReceiver", "()Ljava/lang/String;", "type", "Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload$Type;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "Companion", "MSShop"})
public final /* data */ class RequestBuyGroupPacket implements CustomPacketPayload {
    private final int groupId;
    private final int time;

    @NotNull
    private final String receiver;
    private static final StreamCodec<ByteBuf, RequestBuyGroupPacket> CODEC;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final CustomPacketPayload.Type<RequestBuyGroupPacket> TYPE = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath("msshop", "buy_group"));

    public final int component1() {
        return this.groupId;
    }

    public final int component2() {
        return this.time;
    }

    @NotNull
    public final String component3() {
        return this.receiver;
    }

    @NotNull
    public final RequestBuyGroupPacket copy(int groupId, int time, @NotNull String receiver) {
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        return new RequestBuyGroupPacket(groupId, time, receiver);
    }

    public static /* synthetic */ RequestBuyGroupPacket copy$default(RequestBuyGroupPacket requestBuyGroupPacket, int i, int i2, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = requestBuyGroupPacket.groupId;
        }
        if ((i3 & 2) != 0) {
            i2 = requestBuyGroupPacket.time;
        }
        if ((i3 & 4) != 0) {
            str = requestBuyGroupPacket.receiver;
        }
        return requestBuyGroupPacket.copy(i, i2, str);
    }

    @NotNull
    public String toString() {
        return "RequestBuyGroupPacket(groupId=" + this.groupId + ", time=" + this.time + ", receiver=" + this.receiver + ")";
    }

    public int hashCode() {
        int result = Integer.hashCode(this.groupId);
        return (((result * 31) + Integer.hashCode(this.time)) * 31) + this.receiver.hashCode();
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RequestBuyGroupPacket)) {
            return false;
        }
        RequestBuyGroupPacket requestBuyGroupPacket = (RequestBuyGroupPacket) other;
        return this.groupId == requestBuyGroupPacket.groupId && this.time == requestBuyGroupPacket.time && Intrinsics.areEqual(this.receiver, requestBuyGroupPacket.receiver);
    }

    public RequestBuyGroupPacket() {
        this(0, 0, null, 7, null);
    }

    public RequestBuyGroupPacket(int groupId, int time, @NotNull String receiver) {
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        this.groupId = groupId;
        this.time = time;
        this.receiver = receiver;
    }

    public /* synthetic */ RequestBuyGroupPacket(int i, int i2, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? -1 : i, (i3 & 2) != 0 ? -1 : i2, (i3 & 4) != 0 ? "" : str);
    }

    public final int getGroupId() {
        return this.groupId;
    }

    public final int getTime() {
        return this.time;
    }

    @NotNull
    public final String getReceiver() {
        return this.receiver;
    }

    /* JADX INFO: compiled from: RequestBuyGroupPacket.kt */
    /* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/common/network/packet/buy/RequestBuyGroupPacket$Companion.class */
    @Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0014R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bRS\u0010\t\u001aB\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00060\u0006 \f* \u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\n0\n¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0015"}, d2 = {"Lnet/mcskill/shop/common/network/packet/buy/RequestBuyGroupPacket$Companion;", "", "<init>", "()V", "TYPE", "Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload$Type;", "Lnet/mcskill/shop/common/network/packet/buy/RequestBuyGroupPacket;", "getTYPE", "()Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload$Type;", "CODEC", "Lnet/minecraft/network/codec/StreamCodec;", "Lio/netty/buffer/ByteBuf;", "kotlin.jvm.PlatformType", "getCODEC", "()Lnet/minecraft/network/codec/StreamCodec;", "Lnet/minecraft/network/codec/StreamCodec;", "handle", "", "packet", "context", "Lnet/neoforged/neoforge/network/handling/IPayloadContext;", "MSShop"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final CustomPacketPayload.Type<RequestBuyGroupPacket> getTYPE() {
            return RequestBuyGroupPacket.TYPE;
        }

        public final StreamCodec<ByteBuf, RequestBuyGroupPacket> getCODEC() {
            return RequestBuyGroupPacket.CODEC;
        }

        public final void handle(@NotNull RequestBuyGroupPacket packet, @NotNull IPayloadContext context) {
            Intrinsics.checkNotNullParameter(packet, "packet");
            Intrinsics.checkNotNullParameter(context, "context");
            PacketHandler packetHandler$MSShop = MSShopServer.Companion.getPacketHandler$MSShop();
            ServerPlayer serverPlayerPlayer = context.player();
            Intrinsics.checkNotNull(serverPlayerPlayer, "null cannot be cast to non-null type net.minecraft.server.level.ServerPlayer");
            packetHandler$MSShop.requestBuyGroupPacket(packet, serverPlayerPlayer);
        }
    }

    static {
        StreamCodec streamCodec = ByteBufCodecs.VAR_INT;
        KProperty1 kProperty1 = new PropertyReference1Impl() { // from class: net.mcskill.shop.common.network.packet.buy.RequestBuyGroupPacket$Companion$CODEC$1
            public Object get(Object receiver0) {
                return Integer.valueOf(((RequestBuyGroupPacket) receiver0).getGroupId());
            }
        };
        Function function = (v1) -> {
            return CODEC$lambda$0(r1, v1);
        };
        StreamCodec streamCodec2 = ByteBufCodecs.VAR_INT;
        KProperty1 kProperty2 = new PropertyReference1Impl() { // from class: net.mcskill.shop.common.network.packet.buy.RequestBuyGroupPacket$Companion$CODEC$2
            public Object get(Object receiver0) {
                return Integer.valueOf(((RequestBuyGroupPacket) receiver0).getTime());
            }
        };
        Function function2 = (v1) -> {
            return CODEC$lambda$1(r3, v1);
        };
        StreamCodec streamCodec3 = ByteBufCodecs.STRING_UTF8;
        KProperty1 kProperty3 = new PropertyReference1Impl() { // from class: net.mcskill.shop.common.network.packet.buy.RequestBuyGroupPacket$Companion$CODEC$3
            public Object get(Object receiver0) {
                return ((RequestBuyGroupPacket) receiver0).getReceiver();
            }
        };
        CODEC = StreamCodec.composite(streamCodec, function, streamCodec2, function2, streamCodec3, (v1) -> {
            return CODEC$lambda$2(r5, v1);
        }, (v1, v2, v3) -> {
            return new RequestBuyGroupPacket(v1, v2, v3);
        });
    }

    private static final Integer CODEC$lambda$0(KProperty1 $tmp0, RequestBuyGroupPacket p0) {
        return (Integer) ((Function1) $tmp0).invoke(p0);
    }

    private static final Integer CODEC$lambda$1(KProperty1 $tmp0, RequestBuyGroupPacket p0) {
        return (Integer) ((Function1) $tmp0).invoke(p0);
    }

    private static final String CODEC$lambda$2(KProperty1 $tmp0, RequestBuyGroupPacket p0) {
        return (String) ((Function1) $tmp0).invoke(p0);
    }

    @NotNull
    public CustomPacketPayload.Type<RequestBuyGroupPacket> type() {
        return TYPE;
    }
}
