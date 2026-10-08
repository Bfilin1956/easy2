package net.mcskill.shop.common.network.packet.take;

import io.netty.buffer.ByteBuf;
import java.util.function.Function;
import java.util.function.IntFunction;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty1;
import net.mcskill.shop.common.network.CartAction;
import net.mcskill.shop.server.MSShopServer;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: RequestCartActionPacket.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/common/network/packet/take/RequestCartActionPacket.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00000\u000fH\u0016J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u001c"}, d2 = {"Lnet/mcskill/shop/common/network/packet/take/RequestCartActionPacket;", "Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload;", "action", "Lnet/mcskill/shop/common/network/CartAction;", "elementId", "", "count", "<init>", "(Lnet/mcskill/shop/common/network/CartAction;II)V", "getAction", "()Lnet/mcskill/shop/common/network/CartAction;", "getElementId", "()I", "getCount", "type", "Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload$Type;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "", "Companion", "MSShop"})
public final /* data */ class RequestCartActionPacket implements CustomPacketPayload {

    @NotNull
    private final CartAction action;
    private final int elementId;
    private final int count;
    private static final StreamCodec<ByteBuf, RequestCartActionPacket> CODEC;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final CustomPacketPayload.Type<RequestCartActionPacket> TYPE = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath("msshop", "cart_action"));

    @NotNull
    public final CartAction component1() {
        return this.action;
    }

    public final int component2() {
        return this.elementId;
    }

    public final int component3() {
        return this.count;
    }

    @NotNull
    public final RequestCartActionPacket copy(@NotNull CartAction action, int elementId, int count) {
        Intrinsics.checkNotNullParameter(action, "action");
        return new RequestCartActionPacket(action, elementId, count);
    }

    public static /* synthetic */ RequestCartActionPacket copy$default(RequestCartActionPacket requestCartActionPacket, CartAction cartAction, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            cartAction = requestCartActionPacket.action;
        }
        if ((i3 & 2) != 0) {
            i = requestCartActionPacket.elementId;
        }
        if ((i3 & 4) != 0) {
            i2 = requestCartActionPacket.count;
        }
        return requestCartActionPacket.copy(cartAction, i, i2);
    }

    @NotNull
    public String toString() {
        return "RequestCartActionPacket(action=" + this.action + ", elementId=" + this.elementId + ", count=" + this.count + ")";
    }

    public int hashCode() {
        int result = this.action.hashCode();
        return (((result * 31) + Integer.hashCode(this.elementId)) * 31) + Integer.hashCode(this.count);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RequestCartActionPacket)) {
            return false;
        }
        RequestCartActionPacket requestCartActionPacket = (RequestCartActionPacket) other;
        return this.action == requestCartActionPacket.action && this.elementId == requestCartActionPacket.elementId && this.count == requestCartActionPacket.count;
    }

    public RequestCartActionPacket() {
        this(null, 0, 0, 7, null);
    }

    public RequestCartActionPacket(@NotNull CartAction action, int elementId, int count) {
        Intrinsics.checkNotNullParameter(action, "action");
        this.action = action;
        this.elementId = elementId;
        this.count = count;
    }

    public /* synthetic */ RequestCartActionPacket(CartAction cartAction, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? CartAction.NONE : cartAction, (i3 & 2) != 0 ? -1 : i, (i3 & 4) != 0 ? 1 : i2);
    }

    @NotNull
    public final CartAction getAction() {
        return this.action;
    }

    public final int getElementId() {
        return this.elementId;
    }

    public final int getCount() {
        return this.count;
    }

    /* JADX INFO: compiled from: RequestCartActionPacket.kt */
    /* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/common/network/packet/take/RequestCartActionPacket$Companion.class */
    @Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0014R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bRS\u0010\t\u001aB\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00060\u0006 \f* \u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\n0\n¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0015"}, d2 = {"Lnet/mcskill/shop/common/network/packet/take/RequestCartActionPacket$Companion;", "", "<init>", "()V", "TYPE", "Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload$Type;", "Lnet/mcskill/shop/common/network/packet/take/RequestCartActionPacket;", "getTYPE", "()Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload$Type;", "CODEC", "Lnet/minecraft/network/codec/StreamCodec;", "Lio/netty/buffer/ByteBuf;", "kotlin.jvm.PlatformType", "getCODEC", "()Lnet/minecraft/network/codec/StreamCodec;", "Lnet/minecraft/network/codec/StreamCodec;", "handle", "", "packet", "context", "Lnet/neoforged/neoforge/network/handling/IPayloadContext;", "MSShop"})
    public static final class Companion {

        /* JADX INFO: compiled from: RequestCartActionPacket.kt */
        /* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/common/network/packet/take/RequestCartActionPacket$Companion$WhenMappings.class */
        @Metadata(mv = {2, 0, 0}, k = 3, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[CartAction.values().length];
                try {
                    iArr[CartAction.ACTIVATE_GROUP.ordinal()] = 1;
                } catch (NoSuchFieldError e) {
                }
                try {
                    iArr[CartAction.OPEN_CASE.ordinal()] = 2;
                } catch (NoSuchFieldError e2) {
                }
                try {
                    iArr[CartAction.TAKE_ITEM.ordinal()] = 3;
                } catch (NoSuchFieldError e3) {
                }
                try {
                    iArr[CartAction.OPEN_BUY_CASE.ordinal()] = 4;
                } catch (NoSuchFieldError e4) {
                }
                try {
                    iArr[CartAction.OPEN_DUST_CASE.ordinal()] = 5;
                } catch (NoSuchFieldError e5) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final CustomPacketPayload.Type<RequestCartActionPacket> getTYPE() {
            return RequestCartActionPacket.TYPE;
        }

        public final StreamCodec<ByteBuf, RequestCartActionPacket> getCODEC() {
            return RequestCartActionPacket.CODEC;
        }

        public final void handle(@NotNull RequestCartActionPacket packet, @NotNull IPayloadContext context) {
            Intrinsics.checkNotNullParameter(packet, "packet");
            Intrinsics.checkNotNullParameter(context, "context");
            int elementId = packet.getElementId();
            ServerPlayer serverPlayerPlayer = context.player();
            Intrinsics.checkNotNull(serverPlayerPlayer, "null cannot be cast to non-null type net.minecraft.server.level.ServerPlayer");
            ServerPlayer player = serverPlayerPlayer;
            CartAction action = packet.getAction();
            switch (WhenMappings.$EnumSwitchMapping$0[action.ordinal()]) {
                case 1:
                    MSShopServer.Companion.getPacketHandler$MSShop().activateGroupPacket(elementId, player);
                    break;
                case 2:
                    MSShopServer.Companion.getPacketHandler$MSShop().openCasePacket(elementId, player, packet.getCount());
                    break;
                case 3:
                    MSShopServer.Companion.getPacketHandler$MSShop().takeItemPacket(elementId, player);
                    break;
                case 4:
                case 5:
                    MSShopServer.Companion.getPacketHandler$MSShop().requestBuyOpenCasePacket(elementId, player, action == CartAction.OPEN_DUST_CASE, packet.getCount());
                    break;
            }
        }
    }

    static {
        IntFunction<CartAction> by_id = CartAction.INSTANCE.getBY_ID();
        KProperty1 kProperty1 = new PropertyReference1Impl() { // from class: net.mcskill.shop.common.network.packet.take.RequestCartActionPacket$Companion$CODEC$1
            public Object get(Object receiver0) {
                return Integer.valueOf(((CartAction) receiver0).ordinal());
            }
        };
        StreamCodec streamCodecIdMapper = ByteBufCodecs.idMapper(by_id, (v1) -> {
            return CODEC$lambda$0(r1, v1);
        });
        KProperty1 kProperty2 = new PropertyReference1Impl() { // from class: net.mcskill.shop.common.network.packet.take.RequestCartActionPacket$Companion$CODEC$2
            public Object get(Object receiver0) {
                return ((RequestCartActionPacket) receiver0).getAction();
            }
        };
        Function function = (v1) -> {
            return CODEC$lambda$1(r1, v1);
        };
        StreamCodec streamCodec = ByteBufCodecs.VAR_INT;
        KProperty1 kProperty3 = new PropertyReference1Impl() { // from class: net.mcskill.shop.common.network.packet.take.RequestCartActionPacket$Companion$CODEC$3
            public Object get(Object receiver0) {
                return Integer.valueOf(((RequestCartActionPacket) receiver0).getElementId());
            }
        };
        Function function2 = (v1) -> {
            return CODEC$lambda$2(r3, v1);
        };
        StreamCodec streamCodec2 = ByteBufCodecs.VAR_INT;
        KProperty1 kProperty4 = new PropertyReference1Impl() { // from class: net.mcskill.shop.common.network.packet.take.RequestCartActionPacket$Companion$CODEC$4
            public Object get(Object receiver0) {
                return Integer.valueOf(((RequestCartActionPacket) receiver0).getCount());
            }
        };
        CODEC = StreamCodec.composite(streamCodecIdMapper, function, streamCodec, function2, streamCodec2, (v1) -> {
            return CODEC$lambda$3(r5, v1);
        }, (v1, v2, v3) -> {
            return new RequestCartActionPacket(v1, v2, v3);
        });
    }

    private static final int CODEC$lambda$0(KProperty1 $tmp0, CartAction p0) {
        return ((Number) ((Function1) $tmp0).invoke(p0)).intValue();
    }

    private static final CartAction CODEC$lambda$1(KProperty1 $tmp0, RequestCartActionPacket p0) {
        return (CartAction) ((Function1) $tmp0).invoke(p0);
    }

    private static final Integer CODEC$lambda$2(KProperty1 $tmp0, RequestCartActionPacket p0) {
        return (Integer) ((Function1) $tmp0).invoke(p0);
    }

    private static final Integer CODEC$lambda$3(KProperty1 $tmp0, RequestCartActionPacket p0) {
        return (Integer) ((Function1) $tmp0).invoke(p0);
    }

    @NotNull
    public CustomPacketPayload.Type<RequestCartActionPacket> type() {
        return TYPE;
    }
}
