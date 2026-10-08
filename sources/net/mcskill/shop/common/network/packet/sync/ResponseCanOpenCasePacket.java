package net.mcskill.shop.common.network.packet.sync;

import gg.essential.universal.UScreen;
import io.netty.buffer.ByteBuf;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty1;
import net.mcskill.shop.client.screen.ShopScreen;
import net.mcskill.shop.client.screen.modal.cases.impl.PreviewCaseModal;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ResponseCanOpenCasePacket.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/common/network/packet/sync/ResponseCanOpenCasePacket.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00000\tH\u0016J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Lnet/mcskill/shop/common/network/packet/sync/ResponseCanOpenCasePacket;", "Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload;", "canOpen", "", "<init>", "(Z)V", "getCanOpen", "()Z", "type", "Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload$Type;", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "Companion", "MSShop"})
public final /* data */ class ResponseCanOpenCasePacket implements CustomPacketPayload {
    private final boolean canOpen;
    private static final StreamCodec<ByteBuf, ResponseCanOpenCasePacket> CODEC;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final CustomPacketPayload.Type<ResponseCanOpenCasePacket> TYPE = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath("msshop", "response_can_open_case"));

    public final boolean component1() {
        return this.canOpen;
    }

    @NotNull
    public final ResponseCanOpenCasePacket copy(boolean canOpen) {
        return new ResponseCanOpenCasePacket(canOpen);
    }

    public static /* synthetic */ ResponseCanOpenCasePacket copy$default(ResponseCanOpenCasePacket responseCanOpenCasePacket, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = responseCanOpenCasePacket.canOpen;
        }
        return responseCanOpenCasePacket.copy(z);
    }

    @NotNull
    public String toString() {
        return "ResponseCanOpenCasePacket(canOpen=" + this.canOpen + ")";
    }

    public int hashCode() {
        return Boolean.hashCode(this.canOpen);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ResponseCanOpenCasePacket) && this.canOpen == ((ResponseCanOpenCasePacket) other).canOpen;
    }

    public ResponseCanOpenCasePacket() {
        this(false, 1, null);
    }

    public ResponseCanOpenCasePacket(boolean canOpen) {
        this.canOpen = canOpen;
    }

    public /* synthetic */ ResponseCanOpenCasePacket(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z);
    }

    public final boolean getCanOpen() {
        return this.canOpen;
    }

    /* JADX INFO: compiled from: ResponseCanOpenCasePacket.kt */
    /* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/common/network/packet/sync/ResponseCanOpenCasePacket$Companion.class */
    @Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0014R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bRS\u0010\t\u001aB\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00060\u0006 \f* \u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\n0\n¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0015"}, d2 = {"Lnet/mcskill/shop/common/network/packet/sync/ResponseCanOpenCasePacket$Companion;", "", "<init>", "()V", "TYPE", "Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload$Type;", "Lnet/mcskill/shop/common/network/packet/sync/ResponseCanOpenCasePacket;", "getTYPE", "()Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload$Type;", "CODEC", "Lnet/minecraft/network/codec/StreamCodec;", "Lio/netty/buffer/ByteBuf;", "kotlin.jvm.PlatformType", "getCODEC", "()Lnet/minecraft/network/codec/StreamCodec;", "Lnet/minecraft/network/codec/StreamCodec;", "handle", "", "packet", "context", "Lnet/neoforged/neoforge/network/handling/IPayloadContext;", "MSShop"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final CustomPacketPayload.Type<ResponseCanOpenCasePacket> getTYPE() {
            return ResponseCanOpenCasePacket.TYPE;
        }

        public final StreamCodec<ByteBuf, ResponseCanOpenCasePacket> getCODEC() {
            return ResponseCanOpenCasePacket.CODEC;
        }

        public final void handle(@NotNull ResponseCanOpenCasePacket packet, @NotNull IPayloadContext context) {
            Intrinsics.checkNotNullParameter(packet, "packet");
            Intrinsics.checkNotNullParameter(context, "context");
            ShopScreen currentScreen = UScreen.Companion.getCurrentScreen();
            ShopScreen shopScreen = currentScreen instanceof ShopScreen ? currentScreen : null;
            if (shopScreen == null) {
                return;
            }
            ShopScreen shopScreen2 = shopScreen;
            PreviewCaseModal caseModal = (PreviewCaseModal) CollectionsKt.firstOrNull(shopScreen2.getWindow().childrenOfType(PreviewCaseModal.class));
            if (caseModal == null) {
                return;
            }
            caseModal.getActionButton().setEnabled(packet.getCanOpen());
            caseModal.getActionButtonX5().setEnabled(packet.getCanOpen());
        }
    }

    static {
        StreamCodec streamCodec = ByteBufCodecs.BOOL;
        KProperty1 kProperty1 = new PropertyReference1Impl() { // from class: net.mcskill.shop.common.network.packet.sync.ResponseCanOpenCasePacket$Companion$CODEC$1
            public Object get(Object receiver0) {
                return Boolean.valueOf(((ResponseCanOpenCasePacket) receiver0).getCanOpen());
            }
        };
        CODEC = StreamCodec.composite(streamCodec, (v1) -> {
            return CODEC$lambda$0(r1, v1);
        }, (v1) -> {
            return new ResponseCanOpenCasePacket(v1);
        });
    }

    private static final Boolean CODEC$lambda$0(KProperty1 $tmp0, ResponseCanOpenCasePacket p0) {
        return (Boolean) ((Function1) $tmp0).invoke(p0);
    }

    @NotNull
    public CustomPacketPayload.Type<ResponseCanOpenCasePacket> type() {
        return TYPE;
    }
}
