package net.mcskill.shop.common.network.packet.take;

import io.netty.buffer.ByteBuf;
import java.util.function.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty1;
import net.mcskill.core.server.util.DelayManager;
import net.mcskill.shop.common.network.packet.sync.ResponseCanOpenCasePacket;
import net.mcskill.shop.server.config.ShopConfig;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CheckCanOpenCasePacket.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/common/network/packet/take/CheckCanOpenCasePacket.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00000\u000bH\u0016J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0017"}, d2 = {"Lnet/mcskill/shop/common/network/packet/take/CheckCanOpenCasePacket;", "Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload;", "elementId", "", "count", "<init>", "(II)V", "getElementId", "()I", "getCount", "type", "Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload$Type;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "Companion", "MSShop"})
public final /* data */ class CheckCanOpenCasePacket implements CustomPacketPayload {
    private final int elementId;
    private final int count;
    private static final StreamCodec<ByteBuf, CheckCanOpenCasePacket> CODEC;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final CustomPacketPayload.Type<CheckCanOpenCasePacket> TYPE = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath("msshop", "check_open_case"));

    public final int component1() {
        return this.elementId;
    }

    public final int component2() {
        return this.count;
    }

    @NotNull
    public final CheckCanOpenCasePacket copy(int elementId, int count) {
        return new CheckCanOpenCasePacket(elementId, count);
    }

    public static /* synthetic */ CheckCanOpenCasePacket copy$default(CheckCanOpenCasePacket checkCanOpenCasePacket, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = checkCanOpenCasePacket.elementId;
        }
        if ((i3 & 2) != 0) {
            i2 = checkCanOpenCasePacket.count;
        }
        return checkCanOpenCasePacket.copy(i, i2);
    }

    @NotNull
    public String toString() {
        return "CheckCanOpenCasePacket(elementId=" + this.elementId + ", count=" + this.count + ")";
    }

    public int hashCode() {
        int result = Integer.hashCode(this.elementId);
        return (result * 31) + Integer.hashCode(this.count);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CheckCanOpenCasePacket)) {
            return false;
        }
        CheckCanOpenCasePacket checkCanOpenCasePacket = (CheckCanOpenCasePacket) other;
        return this.elementId == checkCanOpenCasePacket.elementId && this.count == checkCanOpenCasePacket.count;
    }

    public CheckCanOpenCasePacket() {
        this(0, 0, 3, null);
    }

    public CheckCanOpenCasePacket(int elementId, int count) {
        this.elementId = elementId;
        this.count = count;
    }

    public /* synthetic */ CheckCanOpenCasePacket(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? -1 : i, (i3 & 2) != 0 ? 1 : i2);
    }

    public final int getElementId() {
        return this.elementId;
    }

    public final int getCount() {
        return this.count;
    }

    /* JADX INFO: compiled from: CheckCanOpenCasePacket.kt */
    /* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/common/network/packet/take/CheckCanOpenCasePacket$Companion.class */
    @Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0014R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bRS\u0010\t\u001aB\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00060\u0006 \f* \u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\n0\n¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0015"}, d2 = {"Lnet/mcskill/shop/common/network/packet/take/CheckCanOpenCasePacket$Companion;", "", "<init>", "()V", "TYPE", "Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload$Type;", "Lnet/mcskill/shop/common/network/packet/take/CheckCanOpenCasePacket;", "getTYPE", "()Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload$Type;", "CODEC", "Lnet/minecraft/network/codec/StreamCodec;", "Lio/netty/buffer/ByteBuf;", "kotlin.jvm.PlatformType", "getCODEC", "()Lnet/minecraft/network/codec/StreamCodec;", "Lnet/minecraft/network/codec/StreamCodec;", "handle", "", "packet", "context", "Lnet/neoforged/neoforge/network/handling/IPayloadContext;", "MSShop"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final CustomPacketPayload.Type<CheckCanOpenCasePacket> getTYPE() {
            return CheckCanOpenCasePacket.TYPE;
        }

        public final StreamCodec<ByteBuf, CheckCanOpenCasePacket> getCODEC() {
            return CheckCanOpenCasePacket.CODEC;
        }

        public final void handle(@NotNull CheckCanOpenCasePacket packet, @NotNull IPayloadContext context) {
            Intrinsics.checkNotNullParameter(packet, "packet");
            Intrinsics.checkNotNullParameter(context, "context");
            ServerPlayer serverPlayerPlayer = context.player();
            Intrinsics.checkNotNull(serverPlayerPlayer, "null cannot be cast to non-null type net.minecraft.server.level.ServerPlayer");
            ServerPlayer player = serverPlayerPlayer;
            boolean canOpenCase = (DelayManager.INSTANCE.hasActiveDelayCheck(player, "opening_case", (long) ShopConfig.Companion.getInstance().getThresholdRequestsTime()) || DelayManager.INSTANCE.hasActiveDelayCheck(player, "requests", (long) ShopConfig.Companion.getInstance().getThresholdRequestsTime())) ? false : true;
            PacketDistributor.sendToPlayer(player, new ResponseCanOpenCasePacket(canOpenCase), new CustomPacketPayload[0]);
        }
    }

    static {
        StreamCodec streamCodec = ByteBufCodecs.VAR_INT;
        KProperty1 kProperty1 = new PropertyReference1Impl() { // from class: net.mcskill.shop.common.network.packet.take.CheckCanOpenCasePacket$Companion$CODEC$1
            public Object get(Object receiver0) {
                return Integer.valueOf(((CheckCanOpenCasePacket) receiver0).getElementId());
            }
        };
        Function function = (v1) -> {
            return CODEC$lambda$0(r1, v1);
        };
        StreamCodec streamCodec2 = ByteBufCodecs.VAR_INT;
        KProperty1 kProperty2 = new PropertyReference1Impl() { // from class: net.mcskill.shop.common.network.packet.take.CheckCanOpenCasePacket$Companion$CODEC$2
            public Object get(Object receiver0) {
                return Integer.valueOf(((CheckCanOpenCasePacket) receiver0).getCount());
            }
        };
        CODEC = StreamCodec.composite(streamCodec, function, streamCodec2, (v1) -> {
            return CODEC$lambda$1(r3, v1);
        }, (v1, v2) -> {
            return new CheckCanOpenCasePacket(v1, v2);
        });
    }

    private static final Integer CODEC$lambda$0(KProperty1 $tmp0, CheckCanOpenCasePacket p0) {
        return (Integer) ((Function1) $tmp0).invoke(p0);
    }

    private static final Integer CODEC$lambda$1(KProperty1 $tmp0, CheckCanOpenCasePacket p0) {
        return (Integer) ((Function1) $tmp0).invoke(p0);
    }

    @NotNull
    public CustomPacketPayload.Type<CheckCanOpenCasePacket> type() {
        return TYPE;
    }
}
