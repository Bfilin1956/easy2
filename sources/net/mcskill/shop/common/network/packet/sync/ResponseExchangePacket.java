package net.mcskill.shop.common.network.packet.sync;

import gg.essential.elementa.UIComponent;
import gg.essential.elementa.dsl.ComponentsKt;
import gg.essential.elementa.state.StateKt;
import gg.essential.elementa.utils.ResourcesKt;
import gg.essential.universal.UScreen;
import io.netty.buffer.ByteBuf;
import java.util.function.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KProperty1;
import net.mcskill.shop.client.screen.ShopScreen;
import net.mcskill.shop.client.screen.modal.Modal;
import net.mcskill.shop.client.screen.modal.money.ExchangeModal;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ResponseExchangePacket.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/common/network/packet/sync/ResponseExchangePacket.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00000\u000fH\u0016J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001d"}, d2 = {"Lnet/mcskill/shop/common/network/packet/sync/ResponseExchangePacket;", "Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload;", "siteAmount", "", "gameAmount", "exchangeType", "course", "<init>", "(IIII)V", "getSiteAmount", "()I", "getGameAmount", "getExchangeType", "getCourse", "type", "Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload$Type;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "", "Companion", "MSShop"})
public final /* data */ class ResponseExchangePacket implements CustomPacketPayload {
    private final int siteAmount;
    private final int gameAmount;
    private final int exchangeType;
    private final int course;
    private static final StreamCodec<ByteBuf, ResponseExchangePacket> CODEC;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final CustomPacketPayload.Type<ResponseExchangePacket> TYPE = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath("msshop", "course"));

    public final int component1() {
        return this.siteAmount;
    }

    public final int component2() {
        return this.gameAmount;
    }

    public final int component3() {
        return this.exchangeType;
    }

    public final int component4() {
        return this.course;
    }

    @NotNull
    public final ResponseExchangePacket copy(int siteAmount, int gameAmount, int exchangeType, int course) {
        return new ResponseExchangePacket(siteAmount, gameAmount, exchangeType, course);
    }

    public static /* synthetic */ ResponseExchangePacket copy$default(ResponseExchangePacket responseExchangePacket, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = responseExchangePacket.siteAmount;
        }
        if ((i5 & 2) != 0) {
            i2 = responseExchangePacket.gameAmount;
        }
        if ((i5 & 4) != 0) {
            i3 = responseExchangePacket.exchangeType;
        }
        if ((i5 & 8) != 0) {
            i4 = responseExchangePacket.course;
        }
        return responseExchangePacket.copy(i, i2, i3, i4);
    }

    @NotNull
    public String toString() {
        return "ResponseExchangePacket(siteAmount=" + this.siteAmount + ", gameAmount=" + this.gameAmount + ", exchangeType=" + this.exchangeType + ", course=" + this.course + ")";
    }

    public int hashCode() {
        int result = Integer.hashCode(this.siteAmount);
        return (((((result * 31) + Integer.hashCode(this.gameAmount)) * 31) + Integer.hashCode(this.exchangeType)) * 31) + Integer.hashCode(this.course);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ResponseExchangePacket)) {
            return false;
        }
        ResponseExchangePacket responseExchangePacket = (ResponseExchangePacket) other;
        return this.siteAmount == responseExchangePacket.siteAmount && this.gameAmount == responseExchangePacket.gameAmount && this.exchangeType == responseExchangePacket.exchangeType && this.course == responseExchangePacket.course;
    }

    public ResponseExchangePacket() {
        this(0, 0, 0, 0, 15, null);
    }

    public ResponseExchangePacket(int siteAmount, int gameAmount, int exchangeType, int course) {
        this.siteAmount = siteAmount;
        this.gameAmount = gameAmount;
        this.exchangeType = exchangeType;
        this.course = course;
    }

    public /* synthetic */ ResponseExchangePacket(int i, int i2, int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? -1 : i, (i5 & 2) != 0 ? -1 : i2, (i5 & 4) != 0 ? -1 : i3, (i5 & 8) != 0 ? 1 : i4);
    }

    public final int getSiteAmount() {
        return this.siteAmount;
    }

    public final int getGameAmount() {
        return this.gameAmount;
    }

    public final int getExchangeType() {
        return this.exchangeType;
    }

    public final int getCourse() {
        return this.course;
    }

    /* JADX INFO: compiled from: ResponseExchangePacket.kt */
    /* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/common/network/packet/sync/ResponseExchangePacket$Companion.class */
    @Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0014R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bRS\u0010\t\u001aB\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00060\u0006 \f* \u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\n0\n¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0015"}, d2 = {"Lnet/mcskill/shop/common/network/packet/sync/ResponseExchangePacket$Companion;", "", "<init>", "()V", "TYPE", "Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload$Type;", "Lnet/mcskill/shop/common/network/packet/sync/ResponseExchangePacket;", "getTYPE", "()Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload$Type;", "CODEC", "Lnet/minecraft/network/codec/StreamCodec;", "Lio/netty/buffer/ByteBuf;", "kotlin.jvm.PlatformType", "getCODEC", "()Lnet/minecraft/network/codec/StreamCodec;", "Lnet/minecraft/network/codec/StreamCodec;", "handle", "", "packet", "context", "Lnet/neoforged/neoforge/network/handling/IPayloadContext;", "MSShop"})
    @SourceDebugExtension({"SMAP\nResponseExchangePacket.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ResponseExchangePacket.kt\nnet/mcskill/shop/common/network/packet/sync/ResponseExchangePacket$Companion\n+ 2 UIComponent.kt\ngg/essential/elementa/UIComponent\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,66:1\n263#2:67\n1863#3,2:68\n*S KotlinDebug\n*F\n+ 1 ResponseExchangePacket.kt\nnet/mcskill/shop/common/network/packet/sync/ResponseExchangePacket$Companion\n*L\n39#1:67\n39#1:68,2\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final CustomPacketPayload.Type<ResponseExchangePacket> getTYPE() {
            return ResponseExchangePacket.TYPE;
        }

        public final StreamCodec<ByteBuf, ResponseExchangePacket> getCODEC() {
            return ResponseExchangePacket.CODEC;
        }

        public final void handle(@NotNull ResponseExchangePacket packet, @NotNull IPayloadContext context) {
            ExchangeModal exchangeModal;
            Intrinsics.checkNotNullParameter(packet, "packet");
            Intrinsics.checkNotNullParameter(context, "context");
            ShopScreen currentScreen = UScreen.Companion.getCurrentScreen();
            ShopScreen shopScreen = currentScreen instanceof ShopScreen ? currentScreen : null;
            if (shopScreen == null) {
                return;
            }
            ShopScreen screen = shopScreen;
            UIComponent this_$iv = screen.getWindow();
            Iterable $this$forEach$iv = this_$iv.childrenOfType(Modal.class);
            for (Object element$iv : $this$forEach$iv) {
                Modal p0 = (Modal) element$iv;
                p0.close();
            }
            ResourceLocation skillCoinTexture = ResourcesKt.asResource("textures/ui/skill_coin.png", "msshop");
            ResourceLocation emeraldTexture = ResourcesKt.asResource("textures/ui/emerald.png", "msshop");
            if (packet.getExchangeType() == 1) {
                int exchangeType = packet.getExchangeType();
                Intrinsics.checkNotNull(skillCoinTexture);
                Intrinsics.checkNotNull(emeraldTexture);
                exchangeModal = new ExchangeModal(exchangeType, "Обмен скиллкоинов", skillCoinTexture, emeraldTexture, StateKt.state(Integer.valueOf(packet.getSiteAmount())), StateKt.state(Integer.valueOf(packet.getGameAmount())), packet.getCourse());
            } else {
                Intrinsics.checkNotNull(emeraldTexture);
                exchangeModal = new ExchangeModal(packet.getExchangeType(), "Обмен эмеральдов", emeraldTexture, emeraldTexture, StateKt.state(Integer.valueOf(packet.getSiteAmount())), StateKt.state(Integer.valueOf(packet.getGameAmount())), 0, 64, null);
            }
            ComponentsKt.childOf((UIComponent) exchangeModal, screen.getWindow());
        }
    }

    static {
        StreamCodec streamCodec = ByteBufCodecs.VAR_INT;
        KProperty1 kProperty1 = new PropertyReference1Impl() { // from class: net.mcskill.shop.common.network.packet.sync.ResponseExchangePacket$Companion$CODEC$1
            public Object get(Object receiver0) {
                return Integer.valueOf(((ResponseExchangePacket) receiver0).getSiteAmount());
            }
        };
        Function function = (v1) -> {
            return CODEC$lambda$0(r1, v1);
        };
        StreamCodec streamCodec2 = ByteBufCodecs.VAR_INT;
        KProperty1 kProperty2 = new PropertyReference1Impl() { // from class: net.mcskill.shop.common.network.packet.sync.ResponseExchangePacket$Companion$CODEC$2
            public Object get(Object receiver0) {
                return Integer.valueOf(((ResponseExchangePacket) receiver0).getGameAmount());
            }
        };
        Function function2 = (v1) -> {
            return CODEC$lambda$1(r3, v1);
        };
        StreamCodec streamCodec3 = ByteBufCodecs.VAR_INT;
        KProperty1 kProperty3 = new PropertyReference1Impl() { // from class: net.mcskill.shop.common.network.packet.sync.ResponseExchangePacket$Companion$CODEC$3
            public Object get(Object receiver0) {
                return Integer.valueOf(((ResponseExchangePacket) receiver0).getExchangeType());
            }
        };
        Function function3 = (v1) -> {
            return CODEC$lambda$2(r5, v1);
        };
        StreamCodec streamCodec4 = ByteBufCodecs.VAR_INT;
        KProperty1 kProperty4 = new PropertyReference1Impl() { // from class: net.mcskill.shop.common.network.packet.sync.ResponseExchangePacket$Companion$CODEC$4
            public Object get(Object receiver0) {
                return Integer.valueOf(((ResponseExchangePacket) receiver0).getCourse());
            }
        };
        CODEC = StreamCodec.composite(streamCodec, function, streamCodec2, function2, streamCodec3, function3, streamCodec4, (v1) -> {
            return CODEC$lambda$3(r7, v1);
        }, (v1, v2, v3, v4) -> {
            return new ResponseExchangePacket(v1, v2, v3, v4);
        });
    }

    private static final Integer CODEC$lambda$0(KProperty1 $tmp0, ResponseExchangePacket p0) {
        return (Integer) ((Function1) $tmp0).invoke(p0);
    }

    private static final Integer CODEC$lambda$1(KProperty1 $tmp0, ResponseExchangePacket p0) {
        return (Integer) ((Function1) $tmp0).invoke(p0);
    }

    private static final Integer CODEC$lambda$2(KProperty1 $tmp0, ResponseExchangePacket p0) {
        return (Integer) ((Function1) $tmp0).invoke(p0);
    }

    private static final Integer CODEC$lambda$3(KProperty1 $tmp0, ResponseExchangePacket p0) {
        return (Integer) ((Function1) $tmp0).invoke(p0);
    }

    @NotNull
    public CustomPacketPayload.Type<ResponseExchangePacket> type() {
        return TYPE;
    }
}
