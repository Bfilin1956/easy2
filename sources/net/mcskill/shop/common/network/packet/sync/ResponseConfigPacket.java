package net.mcskill.shop.common.network.packet.sync;

import io.netty.buffer.ByteBuf;
import java.util.function.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty1;
import net.mcskill.shop.client.MSShopClient;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ResponseConfigPacket.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/common/network/packet/sync/ResponseConfigPacket.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00000\u0011H\u0016J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001e"}, d2 = {"Lnet/mcskill/shop/common/network/packet/sync/ResponseConfigPacket;", "Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload;", "dustInfo", "", "enableDiscountColors", "", "guarantInfo", "emeraldsPriority", "<init>", "(Ljava/lang/String;ZLjava/lang/String;Z)V", "getDustInfo", "()Ljava/lang/String;", "getEnableDiscountColors", "()Z", "getGuarantInfo", "getEmeraldsPriority", "type", "Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload$Type;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "Companion", "MSShop"})
public final /* data */ class ResponseConfigPacket implements CustomPacketPayload {

    @NotNull
    private final String dustInfo;
    private final boolean enableDiscountColors;

    @NotNull
    private final String guarantInfo;
    private final boolean emeraldsPriority;
    private static final StreamCodec<ByteBuf, ResponseConfigPacket> CODEC;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final CustomPacketPayload.Type<ResponseConfigPacket> TYPE = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath("msshop", "config"));

    @NotNull
    public final String component1() {
        return this.dustInfo;
    }

    public final boolean component2() {
        return this.enableDiscountColors;
    }

    @NotNull
    public final String component3() {
        return this.guarantInfo;
    }

    public final boolean component4() {
        return this.emeraldsPriority;
    }

    @NotNull
    public final ResponseConfigPacket copy(@NotNull String dustInfo, boolean enableDiscountColors, @NotNull String guarantInfo, boolean emeraldsPriority) {
        Intrinsics.checkNotNullParameter(dustInfo, "dustInfo");
        Intrinsics.checkNotNullParameter(guarantInfo, "guarantInfo");
        return new ResponseConfigPacket(dustInfo, enableDiscountColors, guarantInfo, emeraldsPriority);
    }

    public static /* synthetic */ ResponseConfigPacket copy$default(ResponseConfigPacket responseConfigPacket, String str, boolean z, String str2, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = responseConfigPacket.dustInfo;
        }
        if ((i & 2) != 0) {
            z = responseConfigPacket.enableDiscountColors;
        }
        if ((i & 4) != 0) {
            str2 = responseConfigPacket.guarantInfo;
        }
        if ((i & 8) != 0) {
            z2 = responseConfigPacket.emeraldsPriority;
        }
        return responseConfigPacket.copy(str, z, str2, z2);
    }

    @NotNull
    public String toString() {
        return "ResponseConfigPacket(dustInfo=" + this.dustInfo + ", enableDiscountColors=" + this.enableDiscountColors + ", guarantInfo=" + this.guarantInfo + ", emeraldsPriority=" + this.emeraldsPriority + ")";
    }

    public int hashCode() {
        int result = this.dustInfo.hashCode();
        return (((((result * 31) + Boolean.hashCode(this.enableDiscountColors)) * 31) + this.guarantInfo.hashCode()) * 31) + Boolean.hashCode(this.emeraldsPriority);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ResponseConfigPacket)) {
            return false;
        }
        ResponseConfigPacket responseConfigPacket = (ResponseConfigPacket) other;
        return Intrinsics.areEqual(this.dustInfo, responseConfigPacket.dustInfo) && this.enableDiscountColors == responseConfigPacket.enableDiscountColors && Intrinsics.areEqual(this.guarantInfo, responseConfigPacket.guarantInfo) && this.emeraldsPriority == responseConfigPacket.emeraldsPriority;
    }

    public ResponseConfigPacket() {
        this(null, false, null, false, 15, null);
    }

    public ResponseConfigPacket(@NotNull String dustInfo, boolean enableDiscountColors, @NotNull String guarantInfo, boolean emeraldsPriority) {
        Intrinsics.checkNotNullParameter(dustInfo, "dustInfo");
        Intrinsics.checkNotNullParameter(guarantInfo, "guarantInfo");
        this.dustInfo = dustInfo;
        this.enableDiscountColors = enableDiscountColors;
        this.guarantInfo = guarantInfo;
        this.emeraldsPriority = emeraldsPriority;
    }

    public /* synthetic */ ResponseConfigPacket(String str, boolean z, String str2, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? true : z, (i & 4) != 0 ? "" : str2, (i & 8) != 0 ? true : z2);
    }

    @NotNull
    public final String getDustInfo() {
        return this.dustInfo;
    }

    public final boolean getEnableDiscountColors() {
        return this.enableDiscountColors;
    }

    @NotNull
    public final String getGuarantInfo() {
        return this.guarantInfo;
    }

    public final boolean getEmeraldsPriority() {
        return this.emeraldsPriority;
    }

    /* JADX INFO: compiled from: ResponseConfigPacket.kt */
    /* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/common/network/packet/sync/ResponseConfigPacket$Companion.class */
    @Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0014R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bRS\u0010\t\u001aB\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00060\u0006 \f* \u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\n0\n¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0015"}, d2 = {"Lnet/mcskill/shop/common/network/packet/sync/ResponseConfigPacket$Companion;", "", "<init>", "()V", "TYPE", "Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload$Type;", "Lnet/mcskill/shop/common/network/packet/sync/ResponseConfigPacket;", "getTYPE", "()Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload$Type;", "CODEC", "Lnet/minecraft/network/codec/StreamCodec;", "Lio/netty/buffer/ByteBuf;", "kotlin.jvm.PlatformType", "getCODEC", "()Lnet/minecraft/network/codec/StreamCodec;", "Lnet/minecraft/network/codec/StreamCodec;", "handle", "", "packet", "context", "Lnet/neoforged/neoforge/network/handling/IPayloadContext;", "MSShop"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final CustomPacketPayload.Type<ResponseConfigPacket> getTYPE() {
            return ResponseConfigPacket.TYPE;
        }

        public final StreamCodec<ByteBuf, ResponseConfigPacket> getCODEC() {
            return ResponseConfigPacket.CODEC;
        }

        public final void handle(@NotNull ResponseConfigPacket packet, @NotNull IPayloadContext context) {
            Intrinsics.checkNotNullParameter(packet, "packet");
            Intrinsics.checkNotNullParameter(context, "context");
            MSShopClient.Companion $this$handle_u24lambda_u240 = MSShopClient.INSTANCE;
            $this$handle_u24lambda_u240.setDustInfo$MSShop(packet.getDustInfo());
            $this$handle_u24lambda_u240.setEnableDiscountColors$MSShop(packet.getEnableDiscountColors());
            $this$handle_u24lambda_u240.setGuarantInfo$MSShop(packet.getGuarantInfo());
            $this$handle_u24lambda_u240.setEmeraldsPriority$MSShop(packet.getEmeraldsPriority());
        }
    }

    static {
        StreamCodec streamCodec = ByteBufCodecs.STRING_UTF8;
        KProperty1 kProperty1 = new PropertyReference1Impl() { // from class: net.mcskill.shop.common.network.packet.sync.ResponseConfigPacket$Companion$CODEC$1
            public Object get(Object receiver0) {
                return ((ResponseConfigPacket) receiver0).getDustInfo();
            }
        };
        Function function = (v1) -> {
            return CODEC$lambda$0(r1, v1);
        };
        StreamCodec streamCodec2 = ByteBufCodecs.BOOL;
        KProperty1 kProperty2 = new PropertyReference1Impl() { // from class: net.mcskill.shop.common.network.packet.sync.ResponseConfigPacket$Companion$CODEC$2
            public Object get(Object receiver0) {
                return Boolean.valueOf(((ResponseConfigPacket) receiver0).getEnableDiscountColors());
            }
        };
        Function function2 = (v1) -> {
            return CODEC$lambda$1(r3, v1);
        };
        StreamCodec streamCodec3 = ByteBufCodecs.STRING_UTF8;
        KProperty1 kProperty3 = new PropertyReference1Impl() { // from class: net.mcskill.shop.common.network.packet.sync.ResponseConfigPacket$Companion$CODEC$3
            public Object get(Object receiver0) {
                return ((ResponseConfigPacket) receiver0).getGuarantInfo();
            }
        };
        Function function3 = (v1) -> {
            return CODEC$lambda$2(r5, v1);
        };
        StreamCodec streamCodec4 = ByteBufCodecs.BOOL;
        KProperty1 kProperty4 = new PropertyReference1Impl() { // from class: net.mcskill.shop.common.network.packet.sync.ResponseConfigPacket$Companion$CODEC$4
            public Object get(Object receiver0) {
                return Boolean.valueOf(((ResponseConfigPacket) receiver0).getEmeraldsPriority());
            }
        };
        CODEC = StreamCodec.composite(streamCodec, function, streamCodec2, function2, streamCodec3, function3, streamCodec4, (v1) -> {
            return CODEC$lambda$3(r7, v1);
        }, (v1, v2, v3, v4) -> {
            return new ResponseConfigPacket(v1, v2, v3, v4);
        });
    }

    private static final String CODEC$lambda$0(KProperty1 $tmp0, ResponseConfigPacket p0) {
        return (String) ((Function1) $tmp0).invoke(p0);
    }

    private static final Boolean CODEC$lambda$1(KProperty1 $tmp0, ResponseConfigPacket p0) {
        return (Boolean) ((Function1) $tmp0).invoke(p0);
    }

    private static final String CODEC$lambda$2(KProperty1 $tmp0, ResponseConfigPacket p0) {
        return (String) ((Function1) $tmp0).invoke(p0);
    }

    private static final Boolean CODEC$lambda$3(KProperty1 $tmp0, ResponseConfigPacket p0) {
        return (Boolean) ((Function1) $tmp0).invoke(p0);
    }

    @NotNull
    public CustomPacketPayload.Type<ResponseConfigPacket> type() {
        return TYPE;
    }
}
