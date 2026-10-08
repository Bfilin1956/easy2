package net.mcskill.shop.common.network.packet.sync;

import gg.essential.universal.UScreen;
import io.netty.buffer.ByteBuf;
import java.util.function.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty1;
import net.mcskill.shop.common.network.PacketHandleable;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ResponseBalancePacket.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/common/network/packet/sync/ResponseBalancePacket.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00000\u000bH\u0016J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0017"}, d2 = {"Lnet/mcskill/shop/common/network/packet/sync/ResponseBalancePacket;", "Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload;", "skillCoins", "", "emeralds", "<init>", "(II)V", "getSkillCoins", "()I", "getEmeralds", "type", "Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload$Type;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "Companion", "MSShop"})
public final /* data */ class ResponseBalancePacket implements CustomPacketPayload {
    private final int skillCoins;
    private final int emeralds;
    private static final StreamCodec<ByteBuf, ResponseBalancePacket> CODEC;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final CustomPacketPayload.Type<ResponseBalancePacket> TYPE = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath("msshop", "sync_balance"));

    public final int component1() {
        return this.skillCoins;
    }

    public final int component2() {
        return this.emeralds;
    }

    @NotNull
    public final ResponseBalancePacket copy(int skillCoins, int emeralds) {
        return new ResponseBalancePacket(skillCoins, emeralds);
    }

    public static /* synthetic */ ResponseBalancePacket copy$default(ResponseBalancePacket responseBalancePacket, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = responseBalancePacket.skillCoins;
        }
        if ((i3 & 2) != 0) {
            i2 = responseBalancePacket.emeralds;
        }
        return responseBalancePacket.copy(i, i2);
    }

    @NotNull
    public String toString() {
        return "ResponseBalancePacket(skillCoins=" + this.skillCoins + ", emeralds=" + this.emeralds + ")";
    }

    public int hashCode() {
        int result = Integer.hashCode(this.skillCoins);
        return (result * 31) + Integer.hashCode(this.emeralds);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ResponseBalancePacket)) {
            return false;
        }
        ResponseBalancePacket responseBalancePacket = (ResponseBalancePacket) other;
        return this.skillCoins == responseBalancePacket.skillCoins && this.emeralds == responseBalancePacket.emeralds;
    }

    public ResponseBalancePacket() {
        this(0, 0, 3, null);
    }

    public ResponseBalancePacket(int skillCoins, int emeralds) {
        this.skillCoins = skillCoins;
        this.emeralds = emeralds;
    }

    public /* synthetic */ ResponseBalancePacket(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2);
    }

    public final int getSkillCoins() {
        return this.skillCoins;
    }

    public final int getEmeralds() {
        return this.emeralds;
    }

    /* JADX INFO: compiled from: ResponseBalancePacket.kt */
    /* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/common/network/packet/sync/ResponseBalancePacket$Companion.class */
    @Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0014R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bRS\u0010\t\u001aB\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00060\u0006 \f* \u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\n0\n¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0015"}, d2 = {"Lnet/mcskill/shop/common/network/packet/sync/ResponseBalancePacket$Companion;", "", "<init>", "()V", "TYPE", "Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload$Type;", "Lnet/mcskill/shop/common/network/packet/sync/ResponseBalancePacket;", "getTYPE", "()Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload$Type;", "CODEC", "Lnet/minecraft/network/codec/StreamCodec;", "Lio/netty/buffer/ByteBuf;", "kotlin.jvm.PlatformType", "getCODEC", "()Lnet/minecraft/network/codec/StreamCodec;", "Lnet/minecraft/network/codec/StreamCodec;", "handle", "", "packet", "context", "Lnet/neoforged/neoforge/network/handling/IPayloadContext;", "MSShop"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final CustomPacketPayload.Type<ResponseBalancePacket> getTYPE() {
            return ResponseBalancePacket.TYPE;
        }

        public final StreamCodec<ByteBuf, ResponseBalancePacket> getCODEC() {
            return ResponseBalancePacket.CODEC;
        }

        public final void handle(@NotNull ResponseBalancePacket packet, @NotNull IPayloadContext context) {
            Intrinsics.checkNotNullParameter(packet, "packet");
            Intrinsics.checkNotNullParameter(context, "context");
            PacketHandleable currentScreen = UScreen.Companion.getCurrentScreen();
            PacketHandleable packetHandleable = currentScreen instanceof PacketHandleable ? currentScreen : null;
            if (packetHandleable != null) {
                packetHandleable.handlePacket(packet);
            }
        }
    }

    static {
        StreamCodec streamCodec = ByteBufCodecs.VAR_INT;
        KProperty1 kProperty1 = new PropertyReference1Impl() { // from class: net.mcskill.shop.common.network.packet.sync.ResponseBalancePacket$Companion$CODEC$1
            public Object get(Object receiver0) {
                return Integer.valueOf(((ResponseBalancePacket) receiver0).getSkillCoins());
            }
        };
        Function function = (v1) -> {
            return CODEC$lambda$0(r1, v1);
        };
        StreamCodec streamCodec2 = ByteBufCodecs.VAR_INT;
        KProperty1 kProperty2 = new PropertyReference1Impl() { // from class: net.mcskill.shop.common.network.packet.sync.ResponseBalancePacket$Companion$CODEC$2
            public Object get(Object receiver0) {
                return Integer.valueOf(((ResponseBalancePacket) receiver0).getEmeralds());
            }
        };
        CODEC = StreamCodec.composite(streamCodec, function, streamCodec2, (v1) -> {
            return CODEC$lambda$1(r3, v1);
        }, (v1, v2) -> {
            return new ResponseBalancePacket(v1, v2);
        });
    }

    private static final Integer CODEC$lambda$0(KProperty1 $tmp0, ResponseBalancePacket p0) {
        return (Integer) ((Function1) $tmp0).invoke(p0);
    }

    private static final Integer CODEC$lambda$1(KProperty1 $tmp0, ResponseBalancePacket p0) {
        return (Integer) ((Function1) $tmp0).invoke(p0);
    }

    @NotNull
    public CustomPacketPayload.Type<ResponseBalancePacket> type() {
        return TYPE;
    }
}
