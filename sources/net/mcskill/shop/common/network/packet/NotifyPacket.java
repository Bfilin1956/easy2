package net.mcskill.shop.common.network.packet;

import io.netty.buffer.ByteBuf;
import java.util.function.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty1;
import net.mcskill.shop.client.screen.notification.Notifications;
import net.mcskill.shop.client.screen.notification.ShopNotification;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: NotifyPacket.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/common/network/packet/NotifyPacket.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00000\u0011H\u0016J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J'\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001d"}, d2 = {"Lnet/mcskill/shop/common/network/packet/NotifyPacket;", "Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload;", "text", "", "status", "", "duration", "", "<init>", "(Ljava/lang/String;IF)V", "getText", "()Ljava/lang/String;", "getStatus", "()I", "getDuration", "()F", "type", "Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload$Type;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "Companion", "MSShop"})
public final /* data */ class NotifyPacket implements CustomPacketPayload {

    @NotNull
    private final String text;
    private final int status;
    private final float duration;
    private static final StreamCodec<ByteBuf, NotifyPacket> CODEC;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final CustomPacketPayload.Type<NotifyPacket> TYPE = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath("msshop", "notify"));

    @NotNull
    public final String component1() {
        return this.text;
    }

    public final int component2() {
        return this.status;
    }

    public final float component3() {
        return this.duration;
    }

    @NotNull
    public final NotifyPacket copy(@NotNull String text, int status, float duration) {
        Intrinsics.checkNotNullParameter(text, "text");
        return new NotifyPacket(text, status, duration);
    }

    public static /* synthetic */ NotifyPacket copy$default(NotifyPacket notifyPacket, String str, int i, float f, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = notifyPacket.text;
        }
        if ((i2 & 2) != 0) {
            i = notifyPacket.status;
        }
        if ((i2 & 4) != 0) {
            f = notifyPacket.duration;
        }
        return notifyPacket.copy(str, i, f);
    }

    @NotNull
    public String toString() {
        return "NotifyPacket(text=" + this.text + ", status=" + this.status + ", duration=" + this.duration + ")";
    }

    public int hashCode() {
        int result = this.text.hashCode();
        return (((result * 31) + Integer.hashCode(this.status)) * 31) + Float.hashCode(this.duration);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NotifyPacket)) {
            return false;
        }
        NotifyPacket notifyPacket = (NotifyPacket) other;
        return Intrinsics.areEqual(this.text, notifyPacket.text) && this.status == notifyPacket.status && Float.compare(this.duration, notifyPacket.duration) == 0;
    }

    public NotifyPacket() {
        this(null, 0, 0.0f, 7, null);
    }

    public NotifyPacket(@NotNull String text, int status, float duration) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.text = text;
        this.status = status;
        this.duration = duration;
    }

    public /* synthetic */ NotifyPacket(String str, int i, float f, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? 5.0f : f);
    }

    @NotNull
    public final String getText() {
        return this.text;
    }

    public final int getStatus() {
        return this.status;
    }

    public final float getDuration() {
        return this.duration;
    }

    /* JADX INFO: compiled from: NotifyPacket.kt */
    /* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/common/network/packet/NotifyPacket$Companion.class */
    @Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0014R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bRS\u0010\t\u001aB\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00060\u0006 \f* \u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\n0\n¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0015"}, d2 = {"Lnet/mcskill/shop/common/network/packet/NotifyPacket$Companion;", "", "<init>", "()V", "TYPE", "Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload$Type;", "Lnet/mcskill/shop/common/network/packet/NotifyPacket;", "getTYPE", "()Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload$Type;", "CODEC", "Lnet/minecraft/network/codec/StreamCodec;", "Lio/netty/buffer/ByteBuf;", "kotlin.jvm.PlatformType", "getCODEC", "()Lnet/minecraft/network/codec/StreamCodec;", "Lnet/minecraft/network/codec/StreamCodec;", "handle", "", "packet", "context", "Lnet/neoforged/neoforge/network/handling/IPayloadContext;", "MSShop"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final CustomPacketPayload.Type<NotifyPacket> getTYPE() {
            return NotifyPacket.TYPE;
        }

        public final StreamCodec<ByteBuf, NotifyPacket> getCODEC() {
            return NotifyPacket.CODEC;
        }

        public final void handle(@NotNull NotifyPacket packet, @NotNull IPayloadContext context) {
            Intrinsics.checkNotNullParameter(packet, "packet");
            Intrinsics.checkNotNullParameter(context, "context");
            Notifications.INSTANCE.push(packet.getText(), ShopNotification.Status.INSTANCE.fetchBy(packet.getStatus()), packet.getDuration());
        }
    }

    static {
        StreamCodec streamCodec = ByteBufCodecs.STRING_UTF8;
        KProperty1 kProperty1 = new PropertyReference1Impl() { // from class: net.mcskill.shop.common.network.packet.NotifyPacket$Companion$CODEC$1
            public Object get(Object receiver0) {
                return ((NotifyPacket) receiver0).getText();
            }
        };
        Function function = (v1) -> {
            return CODEC$lambda$0(r1, v1);
        };
        StreamCodec streamCodec2 = ByteBufCodecs.VAR_INT;
        KProperty1 kProperty2 = new PropertyReference1Impl() { // from class: net.mcskill.shop.common.network.packet.NotifyPacket$Companion$CODEC$2
            public Object get(Object receiver0) {
                return Integer.valueOf(((NotifyPacket) receiver0).getStatus());
            }
        };
        Function function2 = (v1) -> {
            return CODEC$lambda$1(r3, v1);
        };
        StreamCodec streamCodec3 = ByteBufCodecs.FLOAT;
        KProperty1 kProperty3 = new PropertyReference1Impl() { // from class: net.mcskill.shop.common.network.packet.NotifyPacket$Companion$CODEC$3
            public Object get(Object receiver0) {
                return Float.valueOf(((NotifyPacket) receiver0).getDuration());
            }
        };
        CODEC = StreamCodec.composite(streamCodec, function, streamCodec2, function2, streamCodec3, (v1) -> {
            return CODEC$lambda$2(r5, v1);
        }, (v1, v2, v3) -> {
            return new NotifyPacket(v1, v2, v3);
        });
    }

    private static final String CODEC$lambda$0(KProperty1 $tmp0, NotifyPacket p0) {
        return (String) ((Function1) $tmp0).invoke(p0);
    }

    private static final Integer CODEC$lambda$1(KProperty1 $tmp0, NotifyPacket p0) {
        return (Integer) ((Function1) $tmp0).invoke(p0);
    }

    private static final Float CODEC$lambda$2(KProperty1 $tmp0, NotifyPacket p0) {
        return (Float) ((Function1) $tmp0).invoke(p0);
    }

    @NotNull
    public CustomPacketPayload.Type<NotifyPacket> type() {
        return TYPE;
    }
}
