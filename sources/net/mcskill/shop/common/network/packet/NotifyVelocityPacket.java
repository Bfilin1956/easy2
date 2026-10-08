package net.mcskill.shop.common.network.packet;

import io.netty.buffer.ByteBuf;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: NotifyVelocityPacket.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/common/network/packet/NotifyVelocityPacket.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00000\tH\u0016J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Lnet/mcskill/shop/common/network/packet/NotifyVelocityPacket;", "Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "type", "Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload$Type;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "Companion", "MSShop"})
public final /* data */ class NotifyVelocityPacket implements CustomPacketPayload {

    @NotNull
    private final String message;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final CustomPacketPayload.Type<NotifyVelocityPacket> TYPE = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath("msess", "chatmessage"));
    private static final StreamCodec<ByteBuf, NotifyVelocityPacket> CODEC = StreamCodec.of(NotifyVelocityPacket::CODEC$lambda$0, NotifyVelocityPacket::CODEC$lambda$1);

    @NotNull
    public final String component1() {
        return this.message;
    }

    @NotNull
    public final NotifyVelocityPacket copy(@NotNull String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        return new NotifyVelocityPacket(message);
    }

    public static /* synthetic */ NotifyVelocityPacket copy$default(NotifyVelocityPacket notifyVelocityPacket, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = notifyVelocityPacket.message;
        }
        return notifyVelocityPacket.copy(str);
    }

    @NotNull
    public String toString() {
        return "NotifyVelocityPacket(message=" + this.message + ")";
    }

    public int hashCode() {
        return this.message.hashCode();
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof NotifyVelocityPacket) && Intrinsics.areEqual(this.message, ((NotifyVelocityPacket) other).message);
    }

    public NotifyVelocityPacket() {
        this(null, 1, null);
    }

    public NotifyVelocityPacket(@NotNull String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.message = message;
    }

    public /* synthetic */ NotifyVelocityPacket(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str);
    }

    @NotNull
    public final String getMessage() {
        return this.message;
    }

    /* JADX INFO: compiled from: NotifyVelocityPacket.kt */
    /* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/common/network/packet/NotifyVelocityPacket$Companion.class */
    @Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0014R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bRS\u0010\t\u001aB\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00060\u0006 \f* \u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\n0\n¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0015"}, d2 = {"Lnet/mcskill/shop/common/network/packet/NotifyVelocityPacket$Companion;", "", "<init>", "()V", "TYPE", "Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload$Type;", "Lnet/mcskill/shop/common/network/packet/NotifyVelocityPacket;", "getTYPE", "()Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload$Type;", "CODEC", "Lnet/minecraft/network/codec/StreamCodec;", "Lio/netty/buffer/ByteBuf;", "kotlin.jvm.PlatformType", "getCODEC", "()Lnet/minecraft/network/codec/StreamCodec;", "Lnet/minecraft/network/codec/StreamCodec;", "handle", "", "packet", "context", "Lnet/neoforged/neoforge/network/handling/IPayloadContext;", "MSShop"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final CustomPacketPayload.Type<NotifyVelocityPacket> getTYPE() {
            return NotifyVelocityPacket.TYPE;
        }

        public final StreamCodec<ByteBuf, NotifyVelocityPacket> getCODEC() {
            return NotifyVelocityPacket.CODEC;
        }

        public final void handle(@NotNull NotifyVelocityPacket packet, @NotNull IPayloadContext context) {
            Intrinsics.checkNotNullParameter(packet, "packet");
            Intrinsics.checkNotNullParameter(context, "context");
        }
    }

    private static final void CODEC$lambda$0(ByteBuf byteBuf, NotifyVelocityPacket packet) {
        byte[] byteArray = packet.message.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(byteArray, "getBytes(...)");
        byteBuf.writeInt(byteArray.length);
        byteBuf.writeBytes(byteArray);
    }

    private static final NotifyVelocityPacket CODEC$lambda$1(ByteBuf byteBuf) {
        int length = byteBuf.readInt();
        byte[] readBytes = new byte[length];
        byteBuf.readBytes(readBytes);
        return new NotifyVelocityPacket(new String(readBytes, Charsets.UTF_8));
    }

    @NotNull
    public CustomPacketPayload.Type<NotifyVelocityPacket> type() {
        return TYPE;
    }
}
