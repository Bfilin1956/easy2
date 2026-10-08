package net.mcskill.shop.common.network.packet.sync;

import gg.essential.universal.UScreen;
import java.util.List;
import java.util.function.Function;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty1;
import net.mcskill.shop.common.network.ListType;
import net.mcskill.shop.common.network.PacketHandleable;
import net.mcskill.shop.common.response.shop.CaseData;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ResponseCasesPacket.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/common/network/packet/sync/ResponseCasesPacket.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B!\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00000\rH\u0016J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J#\u0010\u0010\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u000b¨\u0006\u0019"}, d2 = {"Lnet/mcskill/shop/common/network/packet/sync/ResponseCasesPacket;", "Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload;", "cases", "", "Lnet/mcskill/shop/common/response/shop/CaseData;", "isCart", "", "<init>", "(Ljava/util/List;Z)V", "getCases", "()Ljava/util/List;", "()Z", "type", "Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload$Type;", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "Companion", "MSShop"})
public final /* data */ class ResponseCasesPacket implements CustomPacketPayload {

    @NotNull
    private final List<CaseData> cases;
    private final boolean isCart;
    private static final StreamCodec<FriendlyByteBuf, ResponseCasesPacket> CODEC;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final CustomPacketPayload.Type<ResponseCasesPacket> TYPE = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath("msshop", "cases"));

    @NotNull
    public final List<CaseData> component1() {
        return this.cases;
    }

    public final boolean component2() {
        return this.isCart;
    }

    @NotNull
    public final ResponseCasesPacket copy(@NotNull List<CaseData> cases, boolean isCart) {
        Intrinsics.checkNotNullParameter(cases, "cases");
        return new ResponseCasesPacket(cases, isCart);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ResponseCasesPacket copy$default(ResponseCasesPacket responseCasesPacket, List list, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            list = responseCasesPacket.cases;
        }
        if ((i & 2) != 0) {
            z = responseCasesPacket.isCart;
        }
        return responseCasesPacket.copy(list, z);
    }

    @NotNull
    public String toString() {
        return "ResponseCasesPacket(cases=" + this.cases + ", isCart=" + this.isCart + ")";
    }

    public int hashCode() {
        int result = this.cases.hashCode();
        return (result * 31) + Boolean.hashCode(this.isCart);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ResponseCasesPacket)) {
            return false;
        }
        ResponseCasesPacket responseCasesPacket = (ResponseCasesPacket) other;
        return Intrinsics.areEqual(this.cases, responseCasesPacket.cases) && this.isCart == responseCasesPacket.isCart;
    }

    public ResponseCasesPacket() {
        this(null, false, 3, null);
    }

    public ResponseCasesPacket(@NotNull List<CaseData> list, boolean isCart) {
        Intrinsics.checkNotNullParameter(list, "cases");
        this.cases = list;
        this.isCart = isCart;
    }

    public /* synthetic */ ResponseCasesPacket(List list, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? false : z);
    }

    @NotNull
    public final List<CaseData> getCases() {
        return this.cases;
    }

    public final boolean isCart() {
        return this.isCart;
    }

    /* JADX INFO: compiled from: ResponseCasesPacket.kt */
    /* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/common/network/packet/sync/ResponseCasesPacket$Companion.class */
    @Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0014R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bRS\u0010\t\u001aB\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00060\u0006 \f* \u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\n0\n¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0015"}, d2 = {"Lnet/mcskill/shop/common/network/packet/sync/ResponseCasesPacket$Companion;", "", "<init>", "()V", "TYPE", "Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload$Type;", "Lnet/mcskill/shop/common/network/packet/sync/ResponseCasesPacket;", "getTYPE", "()Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload$Type;", "CODEC", "Lnet/minecraft/network/codec/StreamCodec;", "Lnet/minecraft/network/FriendlyByteBuf;", "kotlin.jvm.PlatformType", "getCODEC", "()Lnet/minecraft/network/codec/StreamCodec;", "Lnet/minecraft/network/codec/StreamCodec;", "handle", "", "packet", "context", "Lnet/neoforged/neoforge/network/handling/IPayloadContext;", "MSShop"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final CustomPacketPayload.Type<ResponseCasesPacket> getTYPE() {
            return ResponseCasesPacket.TYPE;
        }

        public final StreamCodec<FriendlyByteBuf, ResponseCasesPacket> getCODEC() {
            return ResponseCasesPacket.CODEC;
        }

        public final void handle(@NotNull ResponseCasesPacket packet, @NotNull IPayloadContext context) {
            Intrinsics.checkNotNullParameter(packet, "packet");
            Intrinsics.checkNotNullParameter(context, "context");
            ListType type = packet.isCart() ? ListType.CART_CASE : ListType.CASE;
            PacketHandleable currentScreen = UScreen.Companion.getCurrentScreen();
            PacketHandleable packetHandleable = currentScreen instanceof PacketHandleable ? currentScreen : null;
            if (packetHandleable != null) {
                packetHandleable.updateList(packet.getCases(), type);
            }
        }
    }

    static {
        StreamCodec streamCodecApply = CaseData.INSTANCE.getCODEC().apply(ByteBufCodecs.list());
        KProperty1 kProperty1 = new PropertyReference1Impl() { // from class: net.mcskill.shop.common.network.packet.sync.ResponseCasesPacket$Companion$CODEC$1
            public Object get(Object receiver0) {
                return ((ResponseCasesPacket) receiver0).getCases();
            }
        };
        Function function = (v1) -> {
            return CODEC$lambda$0(r1, v1);
        };
        StreamCodec streamCodec = ByteBufCodecs.BOOL;
        KProperty1 kProperty2 = new PropertyReference1Impl() { // from class: net.mcskill.shop.common.network.packet.sync.ResponseCasesPacket$Companion$CODEC$2
            public Object get(Object receiver0) {
                return Boolean.valueOf(((ResponseCasesPacket) receiver0).isCart());
            }
        };
        CODEC = StreamCodec.composite(streamCodecApply, function, streamCodec, (v1) -> {
            return CODEC$lambda$1(r3, v1);
        }, (v1, v2) -> {
            return new ResponseCasesPacket(v1, v2);
        });
    }

    private static final List CODEC$lambda$0(KProperty1 $tmp0, ResponseCasesPacket p0) {
        return (List) ((Function1) $tmp0).invoke(p0);
    }

    private static final Boolean CODEC$lambda$1(KProperty1 $tmp0, ResponseCasesPacket p0) {
        return (Boolean) ((Function1) $tmp0).invoke(p0);
    }

    @NotNull
    public CustomPacketPayload.Type<ResponseCasesPacket> type() {
        return TYPE;
    }
}
