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

/* JADX INFO: compiled from: RequestBuyItemPacket.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/common/network/packet/buy/RequestBuyItemPacket.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00000\u0010H\u0016J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001d"}, d2 = {"Lnet/mcskill/shop/common/network/packet/buy/RequestBuyItemPacket;", "Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload;", "itemId", "", "count", "catId", "type", "", "<init>", "(IIILjava/lang/String;)V", "getItemId", "()I", "getCount", "getCatId", "getType", "()Ljava/lang/String;", "Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload$Type;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "Companion", "MSShop"})
public final /* data */ class RequestBuyItemPacket implements CustomPacketPayload {
    private final int itemId;
    private final int count;
    private final int catId;

    @NotNull
    private final String type;
    private static final StreamCodec<ByteBuf, RequestBuyItemPacket> CODEC;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final CustomPacketPayload.Type<RequestBuyItemPacket> TYPE = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath("msshop", "buy_item"));

    public final int component1() {
        return this.itemId;
    }

    public final int component2() {
        return this.count;
    }

    public final int component3() {
        return this.catId;
    }

    @NotNull
    public final String component4() {
        return this.type;
    }

    @NotNull
    public final RequestBuyItemPacket copy(int itemId, int count, int catId, @NotNull String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return new RequestBuyItemPacket(itemId, count, catId, type);
    }

    public static /* synthetic */ RequestBuyItemPacket copy$default(RequestBuyItemPacket requestBuyItemPacket, int i, int i2, int i3, String str, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = requestBuyItemPacket.itemId;
        }
        if ((i4 & 2) != 0) {
            i2 = requestBuyItemPacket.count;
        }
        if ((i4 & 4) != 0) {
            i3 = requestBuyItemPacket.catId;
        }
        if ((i4 & 8) != 0) {
            str = requestBuyItemPacket.type;
        }
        return requestBuyItemPacket.copy(i, i2, i3, str);
    }

    @NotNull
    public String toString() {
        return "RequestBuyItemPacket(itemId=" + this.itemId + ", count=" + this.count + ", catId=" + this.catId + ", type=" + this.type + ")";
    }

    public int hashCode() {
        int result = Integer.hashCode(this.itemId);
        return (((((result * 31) + Integer.hashCode(this.count)) * 31) + Integer.hashCode(this.catId)) * 31) + this.type.hashCode();
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RequestBuyItemPacket)) {
            return false;
        }
        RequestBuyItemPacket requestBuyItemPacket = (RequestBuyItemPacket) other;
        return this.itemId == requestBuyItemPacket.itemId && this.count == requestBuyItemPacket.count && this.catId == requestBuyItemPacket.catId && Intrinsics.areEqual(this.type, requestBuyItemPacket.type);
    }

    public RequestBuyItemPacket() {
        this(0, 0, 0, null, 15, null);
    }

    public RequestBuyItemPacket(int itemId, int count, int catId, @NotNull String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.itemId = itemId;
        this.count = count;
        this.catId = catId;
        this.type = type;
    }

    public /* synthetic */ RequestBuyItemPacket(int i, int i2, int i3, String str, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? -1 : i, (i4 & 2) != 0 ? 0 : i2, (i4 & 4) != 0 ? -1 : i3, (i4 & 8) != 0 ? "" : str);
    }

    public final int getItemId() {
        return this.itemId;
    }

    public final int getCount() {
        return this.count;
    }

    public final int getCatId() {
        return this.catId;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: compiled from: RequestBuyItemPacket.kt */
    /* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/common/network/packet/buy/RequestBuyItemPacket$Companion.class */
    @Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0014R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bRS\u0010\t\u001aB\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00060\u0006 \f* \u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\n0\n¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0015"}, d2 = {"Lnet/mcskill/shop/common/network/packet/buy/RequestBuyItemPacket$Companion;", "", "<init>", "()V", "TYPE", "Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload$Type;", "Lnet/mcskill/shop/common/network/packet/buy/RequestBuyItemPacket;", "getTYPE", "()Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload$Type;", "CODEC", "Lnet/minecraft/network/codec/StreamCodec;", "Lio/netty/buffer/ByteBuf;", "kotlin.jvm.PlatformType", "getCODEC", "()Lnet/minecraft/network/codec/StreamCodec;", "Lnet/minecraft/network/codec/StreamCodec;", "handle", "", "packet", "context", "Lnet/neoforged/neoforge/network/handling/IPayloadContext;", "MSShop"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final CustomPacketPayload.Type<RequestBuyItemPacket> getTYPE() {
            return RequestBuyItemPacket.TYPE;
        }

        public final StreamCodec<ByteBuf, RequestBuyItemPacket> getCODEC() {
            return RequestBuyItemPacket.CODEC;
        }

        public final void handle(@NotNull RequestBuyItemPacket packet, @NotNull IPayloadContext context) {
            Intrinsics.checkNotNullParameter(packet, "packet");
            Intrinsics.checkNotNullParameter(context, "context");
            PacketHandler packetHandler$MSShop = MSShopServer.Companion.getPacketHandler$MSShop();
            ServerPlayer serverPlayerPlayer = context.player();
            Intrinsics.checkNotNull(serverPlayerPlayer, "null cannot be cast to non-null type net.minecraft.server.level.ServerPlayer");
            packetHandler$MSShop.requestBuyItemPacket(packet, serverPlayerPlayer);
        }
    }

    static {
        StreamCodec streamCodec = ByteBufCodecs.VAR_INT;
        KProperty1 kProperty1 = new PropertyReference1Impl() { // from class: net.mcskill.shop.common.network.packet.buy.RequestBuyItemPacket$Companion$CODEC$1
            public Object get(Object receiver0) {
                return Integer.valueOf(((RequestBuyItemPacket) receiver0).getItemId());
            }
        };
        Function function = (v1) -> {
            return CODEC$lambda$0(r1, v1);
        };
        StreamCodec streamCodec2 = ByteBufCodecs.VAR_INT;
        KProperty1 kProperty2 = new PropertyReference1Impl() { // from class: net.mcskill.shop.common.network.packet.buy.RequestBuyItemPacket$Companion$CODEC$2
            public Object get(Object receiver0) {
                return Integer.valueOf(((RequestBuyItemPacket) receiver0).getCount());
            }
        };
        Function function2 = (v1) -> {
            return CODEC$lambda$1(r3, v1);
        };
        StreamCodec streamCodec3 = ByteBufCodecs.VAR_INT;
        KProperty1 kProperty3 = new PropertyReference1Impl() { // from class: net.mcskill.shop.common.network.packet.buy.RequestBuyItemPacket$Companion$CODEC$3
            public Object get(Object receiver0) {
                return Integer.valueOf(((RequestBuyItemPacket) receiver0).getCatId());
            }
        };
        Function function3 = (v1) -> {
            return CODEC$lambda$2(r5, v1);
        };
        StreamCodec streamCodec4 = ByteBufCodecs.STRING_UTF8;
        KProperty1 kProperty4 = new PropertyReference1Impl() { // from class: net.mcskill.shop.common.network.packet.buy.RequestBuyItemPacket$Companion$CODEC$4
            public Object get(Object receiver0) {
                return ((RequestBuyItemPacket) receiver0).getType();
            }
        };
        CODEC = StreamCodec.composite(streamCodec, function, streamCodec2, function2, streamCodec3, function3, streamCodec4, (v1) -> {
            return CODEC$lambda$3(r7, v1);
        }, (v1, v2, v3, v4) -> {
            return new RequestBuyItemPacket(v1, v2, v3, v4);
        });
    }

    private static final Integer CODEC$lambda$0(KProperty1 $tmp0, RequestBuyItemPacket p0) {
        return (Integer) ((Function1) $tmp0).invoke(p0);
    }

    private static final Integer CODEC$lambda$1(KProperty1 $tmp0, RequestBuyItemPacket p0) {
        return (Integer) ((Function1) $tmp0).invoke(p0);
    }

    private static final Integer CODEC$lambda$2(KProperty1 $tmp0, RequestBuyItemPacket p0) {
        return (Integer) ((Function1) $tmp0).invoke(p0);
    }

    private static final String CODEC$lambda$3(KProperty1 $tmp0, RequestBuyItemPacket p0) {
        return (String) ((Function1) $tmp0).invoke(p0);
    }

    @NotNull
    public CustomPacketPayload.Type<RequestBuyItemPacket> type() {
        return TYPE;
    }
}
