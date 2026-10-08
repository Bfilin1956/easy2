package net.mcskill.shop.common.response;

import java.time.Instant;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import net.mcskill.core.common.json.serializer.InstantAsUnixSerializer;
import net.mcskill.core.common.network.ByteBufferSerializer;
import net.minecraft.network.FriendlyByteBuf;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: PurchaseData.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/common/response/PurchaseData.class */
@Serializable
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 )2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002()B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\nB-\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0006\u0010\u000fJ\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\b\u001a\u00020\tH\u0016J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\fHÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001J%\u0010!\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0001¢\u0006\u0002\b'R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006*"}, d2 = {"Lnet/mcskill/shop/common/response/PurchaseData;", "Lnet/mcskill/core/common/network/ByteBufferSerializer;", "status", "", "expiry", "Ljava/time/Instant;", "<init>", "(ZLjava/time/Instant;)V", "buf", "Lnet/minecraft/network/FriendlyByteBuf;", "(Lnet/minecraft/network/FriendlyByteBuf;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IZLjava/time/Instant;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getStatus", "()Z", "getExpiry$annotations", "()V", "getExpiry", "()Ljava/time/Instant;", "serialize", "", "component1", "component2", "copy", "equals", "other", "", "hashCode", "toString", "", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$MSShop", "$serializer", "Companion", "MSShop"})
public final /* data */ class PurchaseData implements ByteBufferSerializer<PurchaseData> {
    private final boolean status;

    @NotNull
    private final Instant expiry;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @JvmField
    @NotNull
    private static final KSerializer<Object>[] $childSerializers = {null, new InstantAsUnixSerializer()};

    @Serializable(with = InstantAsUnixSerializer.class)
    public static /* synthetic */ void getExpiry$annotations() {
    }

    public final boolean component1() {
        return this.status;
    }

    @NotNull
    public final Instant component2() {
        return this.expiry;
    }

    @NotNull
    public final PurchaseData copy(boolean status, @NotNull Instant expiry) {
        Intrinsics.checkNotNullParameter(expiry, "expiry");
        return new PurchaseData(status, expiry);
    }

    public static /* synthetic */ PurchaseData copy$default(PurchaseData purchaseData, boolean z, Instant instant, int i, Object obj) {
        if ((i & 1) != 0) {
            z = purchaseData.status;
        }
        if ((i & 2) != 0) {
            instant = purchaseData.expiry;
        }
        return purchaseData.copy(z, instant);
    }

    @NotNull
    public String toString() {
        return "PurchaseData(status=" + this.status + ", expiry=" + this.expiry + ")";
    }

    public int hashCode() {
        int result = Boolean.hashCode(this.status);
        return (result * 31) + this.expiry.hashCode();
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PurchaseData)) {
            return false;
        }
        PurchaseData purchaseData = (PurchaseData) other;
        return this.status == purchaseData.status && Intrinsics.areEqual(this.expiry, purchaseData.expiry);
    }

    /* JADX INFO: compiled from: PurchaseData.kt */
    /* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/common/response/PurchaseData$Companion.class */
    @Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lnet/mcskill/shop/common/response/PurchaseData$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lnet/mcskill/shop/common/response/PurchaseData;", "MSShop"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        @NotNull
        public final KSerializer<PurchaseData> serializer() {
            return PurchaseData$$serializer.INSTANCE;
        }
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$MSShop(PurchaseData self, CompositeEncoder output, SerialDescriptor serialDesc) {
        SerializationStrategy[] serializationStrategyArr = $childSerializers;
        output.encodeBooleanElement(serialDesc, 0, self.status);
        output.encodeSerializableElement(serialDesc, 1, serializationStrategyArr[1], self.expiry);
    }

    public /* synthetic */ PurchaseData(int seen0, boolean status, Instant expiry, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (3 & seen0)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 3, PurchaseData$$serializer.INSTANCE.getDescriptor());
        }
        this.status = status;
        this.expiry = expiry;
    }

    public PurchaseData(boolean status, @NotNull Instant expiry) {
        Intrinsics.checkNotNullParameter(expiry, "expiry");
        this.status = status;
        this.expiry = expiry;
    }

    public final boolean getStatus() {
        return this.status;
    }

    @NotNull
    public final Instant getExpiry() {
        return this.expiry;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public PurchaseData(@NotNull FriendlyByteBuf buf) {
        Intrinsics.checkNotNullParameter(buf, "buf");
        boolean z = buf.readBoolean();
        Instant instantOfEpochSecond = Instant.ofEpochSecond(buf.readLong());
        Intrinsics.checkNotNullExpressionValue(instantOfEpochSecond, "ofEpochSecond(...)");
        this(z, instantOfEpochSecond);
    }

    public void serialize(@NotNull FriendlyByteBuf buf) {
        Intrinsics.checkNotNullParameter(buf, "buf");
        buf.writeBoolean(this.status);
        buf.writeLong(this.expiry.getEpochSecond());
    }
}
