package net.mcskill.shop.common.network.packet.sync;

import gg.essential.elementa.dsl.ComponentsKt;
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
import net.mcskill.shop.client.screen.ShopScreen;
import net.mcskill.shop.client.screen.modal.Modal;
import net.mcskill.shop.client.screen.modal.cases.BaseCaseModal;
import net.mcskill.shop.client.screen.modal.cases.roulette.RouletteCaseModal;
import net.mcskill.shop.common.response.shop.CaseData;
import net.mcskill.shop.common.response.shop.CaseItemData;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import okhttp3.internal.Util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ResponseCaseRewardPacket.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/common/network/packet/sync/ResponseCaseRewardPacket.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 (2\u00020\u0001:\u0001(BI\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fB)\b\u0016\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\u000fJ\u000e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00000\u0019H\u0016J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003JK\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\t\u0010&\u001a\u00020'HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006)"}, d2 = {"Lnet/mcskill/shop/common/network/packet/sync/ResponseCaseRewardPacket;", "Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload;", "firstProgress", "", "firstMax", "secondProgress", "secondMax", "casesCount", "reward", "", "Lnet/mcskill/shop/common/response/shop/CaseItemData;", "<init>", "(IIIIILjava/util/List;)V", "case", "Lnet/mcskill/shop/common/response/shop/CaseData;", "(Lnet/mcskill/shop/common/response/shop/CaseData;Ljava/util/List;I)V", "getFirstProgress", "()I", "getFirstMax", "getSecondProgress", "getSecondMax", "getCasesCount", "getReward", "()Ljava/util/List;", "type", "Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload$Type;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "toString", "", "Companion", "MSShop"})
public final /* data */ class ResponseCaseRewardPacket implements CustomPacketPayload {
    private final int firstProgress;
    private final int firstMax;
    private final int secondProgress;
    private final int secondMax;
    private final int casesCount;

    @NotNull
    private final List<CaseItemData> reward;
    private static final StreamCodec<FriendlyByteBuf, ResponseCaseRewardPacket> CODEC;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final CustomPacketPayload.Type<ResponseCaseRewardPacket> TYPE = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath("msshop", "case_reward"));

    public final int component1() {
        return this.firstProgress;
    }

    public final int component2() {
        return this.firstMax;
    }

    public final int component3() {
        return this.secondProgress;
    }

    public final int component4() {
        return this.secondMax;
    }

    public final int component5() {
        return this.casesCount;
    }

    @NotNull
    public final List<CaseItemData> component6() {
        return this.reward;
    }

    @NotNull
    public final ResponseCaseRewardPacket copy(int firstProgress, int firstMax, int secondProgress, int secondMax, int casesCount, @NotNull List<CaseItemData> reward) {
        Intrinsics.checkNotNullParameter(reward, "reward");
        return new ResponseCaseRewardPacket(firstProgress, firstMax, secondProgress, secondMax, casesCount, reward);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ResponseCaseRewardPacket copy$default(ResponseCaseRewardPacket responseCaseRewardPacket, int i, int i2, int i3, int i4, int i5, List list, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = responseCaseRewardPacket.firstProgress;
        }
        if ((i6 & 2) != 0) {
            i2 = responseCaseRewardPacket.firstMax;
        }
        if ((i6 & 4) != 0) {
            i3 = responseCaseRewardPacket.secondProgress;
        }
        if ((i6 & 8) != 0) {
            i4 = responseCaseRewardPacket.secondMax;
        }
        if ((i6 & 16) != 0) {
            i5 = responseCaseRewardPacket.casesCount;
        }
        if ((i6 & 32) != 0) {
            list = responseCaseRewardPacket.reward;
        }
        return responseCaseRewardPacket.copy(i, i2, i3, i4, i5, list);
    }

    @NotNull
    public String toString() {
        return "ResponseCaseRewardPacket(firstProgress=" + this.firstProgress + ", firstMax=" + this.firstMax + ", secondProgress=" + this.secondProgress + ", secondMax=" + this.secondMax + ", casesCount=" + this.casesCount + ", reward=" + this.reward + ")";
    }

    public int hashCode() {
        int result = Integer.hashCode(this.firstProgress);
        return (((((((((result * 31) + Integer.hashCode(this.firstMax)) * 31) + Integer.hashCode(this.secondProgress)) * 31) + Integer.hashCode(this.secondMax)) * 31) + Integer.hashCode(this.casesCount)) * 31) + this.reward.hashCode();
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ResponseCaseRewardPacket)) {
            return false;
        }
        ResponseCaseRewardPacket responseCaseRewardPacket = (ResponseCaseRewardPacket) other;
        return this.firstProgress == responseCaseRewardPacket.firstProgress && this.firstMax == responseCaseRewardPacket.firstMax && this.secondProgress == responseCaseRewardPacket.secondProgress && this.secondMax == responseCaseRewardPacket.secondMax && this.casesCount == responseCaseRewardPacket.casesCount && Intrinsics.areEqual(this.reward, responseCaseRewardPacket.reward);
    }

    public ResponseCaseRewardPacket() {
        this(0, 0, 0, 0, 0, null, 63, null);
    }

    public ResponseCaseRewardPacket(int firstProgress, int firstMax, int secondProgress, int secondMax, int casesCount, @NotNull List<CaseItemData> list) {
        Intrinsics.checkNotNullParameter(list, "reward");
        this.firstProgress = firstProgress;
        this.firstMax = firstMax;
        this.secondProgress = secondProgress;
        this.secondMax = secondMax;
        this.casesCount = casesCount;
        this.reward = list;
    }

    public /* synthetic */ ResponseCaseRewardPacket(int i, int i2, int i3, int i4, int i5, List list, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this((i6 & 1) != 0 ? 0 : i, (i6 & 2) != 0 ? 0 : i2, (i6 & 4) != 0 ? 0 : i3, (i6 & 8) != 0 ? 0 : i4, (i6 & 16) != 0 ? 1 : i5, (i6 & 32) != 0 ? Util.immutableListOf(new CaseItemData[0]) : list);
    }

    public final int getFirstProgress() {
        return this.firstProgress;
    }

    public final int getFirstMax() {
        return this.firstMax;
    }

    public final int getSecondProgress() {
        return this.secondProgress;
    }

    public final int getSecondMax() {
        return this.secondMax;
    }

    public final int getCasesCount() {
        return this.casesCount;
    }

    @NotNull
    public final List<CaseItemData> getReward() {
        return this.reward;
    }

    public /* synthetic */ ResponseCaseRewardPacket(CaseData caseData, List list, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(caseData, list, (i2 & 4) != 0 ? 1 : i);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ResponseCaseRewardPacket(@NotNull CaseData caseData, @NotNull List<CaseItemData> list, int casesCount) {
        this(caseData.getGuarantyFirstProgress(), caseData.getGuarantyFirstLimit(), caseData.getGuarantySecondProgress(), caseData.getGuarantySecondLimit(), casesCount, list);
        Intrinsics.checkNotNullParameter(caseData, "case");
        Intrinsics.checkNotNullParameter(list, "reward");
    }

    /* JADX INFO: compiled from: ResponseCaseRewardPacket.kt */
    /* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/common/network/packet/sync/ResponseCaseRewardPacket$Companion.class */
    @Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0014R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bRS\u0010\t\u001aB\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00060\u0006 \f* \u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\n0\n¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0015"}, d2 = {"Lnet/mcskill/shop/common/network/packet/sync/ResponseCaseRewardPacket$Companion;", "", "<init>", "()V", "TYPE", "Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload$Type;", "Lnet/mcskill/shop/common/network/packet/sync/ResponseCaseRewardPacket;", "getTYPE", "()Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload$Type;", "CODEC", "Lnet/minecraft/network/codec/StreamCodec;", "Lnet/minecraft/network/FriendlyByteBuf;", "kotlin.jvm.PlatformType", "getCODEC", "()Lnet/minecraft/network/codec/StreamCodec;", "Lnet/minecraft/network/codec/StreamCodec;", "handle", "", "packet", "context", "Lnet/neoforged/neoforge/network/handling/IPayloadContext;", "MSShop"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final CustomPacketPayload.Type<ResponseCaseRewardPacket> getTYPE() {
            return ResponseCaseRewardPacket.TYPE;
        }

        public final StreamCodec<FriendlyByteBuf, ResponseCaseRewardPacket> getCODEC() {
            return ResponseCaseRewardPacket.CODEC;
        }

        public final void handle(@NotNull ResponseCaseRewardPacket packet, @NotNull IPayloadContext context) {
            Intrinsics.checkNotNullParameter(packet, "packet");
            Intrinsics.checkNotNullParameter(context, "context");
            ShopScreen currentScreen = UScreen.Companion.getCurrentScreen();
            ShopScreen shopScreen = currentScreen instanceof ShopScreen ? currentScreen : null;
            if (shopScreen == null) {
                return;
            }
            ShopScreen shopScreen2 = shopScreen;
            Modal lastCaseModal = Modal.INSTANCE.last();
            if (lastCaseModal instanceof BaseCaseModal) {
                if (((Number) ((BaseCaseModal) lastCaseModal).getCasesAmount().get()).intValue() < 2) {
                    ((BaseCaseModal) lastCaseModal).close();
                } else {
                    ((BaseCaseModal) lastCaseModal).getCasesAmount().set(Integer.valueOf(((Number) ((BaseCaseModal) lastCaseModal).getCasesAmount().get()).intValue() - packet.getCasesCount()));
                }
                int firstProg = packet.component1();
                int firstMax = packet.component2();
                int secondProg = packet.component3();
                int secondMax = packet.component4();
                BaseCaseModal caseModal = (BaseCaseModal) CollectionsKt.firstOrNull(shopScreen2.getWindow().childrenOfType(BaseCaseModal.class));
                ComponentsKt.childOf(new RouletteCaseModal(caseModal, ((BaseCaseModal) lastCaseModal).getCase().getItems(), packet.getReward(), firstProg, firstMax, secondProg, secondMax), shopScreen2.getWindow());
            }
        }
    }

    static {
        StreamCodec streamCodec = ByteBufCodecs.VAR_INT;
        KProperty1 kProperty1 = new PropertyReference1Impl() { // from class: net.mcskill.shop.common.network.packet.sync.ResponseCaseRewardPacket$Companion$CODEC$1
            public Object get(Object receiver0) {
                return Integer.valueOf(((ResponseCaseRewardPacket) receiver0).getFirstProgress());
            }
        };
        Function function = (v1) -> {
            return CODEC$lambda$0(r1, v1);
        };
        StreamCodec streamCodec2 = ByteBufCodecs.VAR_INT;
        KProperty1 kProperty2 = new PropertyReference1Impl() { // from class: net.mcskill.shop.common.network.packet.sync.ResponseCaseRewardPacket$Companion$CODEC$2
            public Object get(Object receiver0) {
                return Integer.valueOf(((ResponseCaseRewardPacket) receiver0).getFirstMax());
            }
        };
        Function function2 = (v1) -> {
            return CODEC$lambda$1(r3, v1);
        };
        StreamCodec streamCodec3 = ByteBufCodecs.VAR_INT;
        KProperty1 kProperty3 = new PropertyReference1Impl() { // from class: net.mcskill.shop.common.network.packet.sync.ResponseCaseRewardPacket$Companion$CODEC$3
            public Object get(Object receiver0) {
                return Integer.valueOf(((ResponseCaseRewardPacket) receiver0).getSecondProgress());
            }
        };
        Function function3 = (v1) -> {
            return CODEC$lambda$2(r5, v1);
        };
        StreamCodec streamCodec4 = ByteBufCodecs.VAR_INT;
        KProperty1 kProperty4 = new PropertyReference1Impl() { // from class: net.mcskill.shop.common.network.packet.sync.ResponseCaseRewardPacket$Companion$CODEC$4
            public Object get(Object receiver0) {
                return Integer.valueOf(((ResponseCaseRewardPacket) receiver0).getSecondMax());
            }
        };
        Function function4 = (v1) -> {
            return CODEC$lambda$3(r7, v1);
        };
        StreamCodec streamCodec5 = ByteBufCodecs.VAR_INT;
        KProperty1 kProperty5 = new PropertyReference1Impl() { // from class: net.mcskill.shop.common.network.packet.sync.ResponseCaseRewardPacket$Companion$CODEC$5
            public Object get(Object receiver0) {
                return Integer.valueOf(((ResponseCaseRewardPacket) receiver0).getCasesCount());
            }
        };
        Function function5 = (v1) -> {
            return CODEC$lambda$4(r9, v1);
        };
        StreamCodec streamCodecApply = CaseItemData.INSTANCE.getCODEC().apply(ByteBufCodecs.list());
        KProperty1 kProperty6 = new PropertyReference1Impl() { // from class: net.mcskill.shop.common.network.packet.sync.ResponseCaseRewardPacket$Companion$CODEC$6
            public Object get(Object receiver0) {
                return ((ResponseCaseRewardPacket) receiver0).getReward();
            }
        };
        CODEC = StreamCodec.composite(streamCodec, function, streamCodec2, function2, streamCodec3, function3, streamCodec4, function4, streamCodec5, function5, streamCodecApply, (v1) -> {
            return CODEC$lambda$5(r11, v1);
        }, (v1, v2, v3, v4, v5, v6) -> {
            return new ResponseCaseRewardPacket(v1, v2, v3, v4, v5, v6);
        });
    }

    private static final Integer CODEC$lambda$0(KProperty1 $tmp0, ResponseCaseRewardPacket p0) {
        return (Integer) ((Function1) $tmp0).invoke(p0);
    }

    private static final Integer CODEC$lambda$1(KProperty1 $tmp0, ResponseCaseRewardPacket p0) {
        return (Integer) ((Function1) $tmp0).invoke(p0);
    }

    private static final Integer CODEC$lambda$2(KProperty1 $tmp0, ResponseCaseRewardPacket p0) {
        return (Integer) ((Function1) $tmp0).invoke(p0);
    }

    private static final Integer CODEC$lambda$3(KProperty1 $tmp0, ResponseCaseRewardPacket p0) {
        return (Integer) ((Function1) $tmp0).invoke(p0);
    }

    private static final Integer CODEC$lambda$4(KProperty1 $tmp0, ResponseCaseRewardPacket p0) {
        return (Integer) ((Function1) $tmp0).invoke(p0);
    }

    private static final List CODEC$lambda$5(KProperty1 $tmp0, ResponseCaseRewardPacket p0) {
        return (List) ((Function1) $tmp0).invoke(p0);
    }

    @NotNull
    public CustomPacketPayload.Type<ResponseCaseRewardPacket> type() {
        return TYPE;
    }
}
