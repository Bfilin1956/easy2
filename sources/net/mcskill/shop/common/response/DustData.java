package net.mcskill.shop.common.response;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import net.mcskill.core.common.network.ByteBufferSerializer;
import net.minecraft.network.FriendlyByteBuf;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: DustData.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/common/response/DustData.class */
@Serializable
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 .2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002./B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\t\u0010\rBG\b\u0010\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\t\u0010\u0011J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J;\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020\u0005HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001J%\u0010'\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020\u00002\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0001¢\u0006\u0002\b-R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015¨\u00060"}, d2 = {"Lnet/mcskill/shop/common/response/DustData;", "Lnet/mcskill/core/common/network/ByteBufferSerializer;", "registryName", "", "meta", "", "nbt", "amount", "caseId", "<init>", "(Ljava/lang/String;ILjava/lang/String;II)V", "buf", "Lnet/minecraft/network/FriendlyByteBuf;", "(Lnet/minecraft/network/FriendlyByteBuf;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;ILjava/lang/String;IILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getRegistryName", "()Ljava/lang/String;", "getMeta", "()I", "getNbt", "getAmount", "getCaseId", "serialize", "", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$MSShop", "Companion", "$serializer", "MSShop"})
public final /* data */ class DustData implements ByteBufferSerializer<DustData> {

    @NotNull
    private final String registryName;
    private final int meta;

    @NotNull
    private final String nbt;
    private final int amount;
    private final int caseId;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final DustData EMPTY = new DustData("minecraft:air", 0, "", 0, -1);

    @NotNull
    public final String component1() {
        return this.registryName;
    }

    public final int component2() {
        return this.meta;
    }

    @NotNull
    public final String component3() {
        return this.nbt;
    }

    public final int component4() {
        return this.amount;
    }

    public final int component5() {
        return this.caseId;
    }

    @NotNull
    public final DustData copy(@NotNull String registryName, int meta, @NotNull String nbt, int amount, int caseId) {
        Intrinsics.checkNotNullParameter(registryName, "registryName");
        Intrinsics.checkNotNullParameter(nbt, "nbt");
        return new DustData(registryName, meta, nbt, amount, caseId);
    }

    public static /* synthetic */ DustData copy$default(DustData dustData, String str, int i, String str2, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = dustData.registryName;
        }
        if ((i4 & 2) != 0) {
            i = dustData.meta;
        }
        if ((i4 & 4) != 0) {
            str2 = dustData.nbt;
        }
        if ((i4 & 8) != 0) {
            i2 = dustData.amount;
        }
        if ((i4 & 16) != 0) {
            i3 = dustData.caseId;
        }
        return dustData.copy(str, i, str2, i2, i3);
    }

    @NotNull
    public String toString() {
        return "DustData(registryName=" + this.registryName + ", meta=" + this.meta + ", nbt=" + this.nbt + ", amount=" + this.amount + ", caseId=" + this.caseId + ")";
    }

    public int hashCode() {
        int result = this.registryName.hashCode();
        return (((((((result * 31) + Integer.hashCode(this.meta)) * 31) + this.nbt.hashCode()) * 31) + Integer.hashCode(this.amount)) * 31) + Integer.hashCode(this.caseId);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DustData)) {
            return false;
        }
        DustData dustData = (DustData) other;
        return Intrinsics.areEqual(this.registryName, dustData.registryName) && this.meta == dustData.meta && Intrinsics.areEqual(this.nbt, dustData.nbt) && this.amount == dustData.amount && this.caseId == dustData.caseId;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$MSShop(DustData self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.registryName);
        output.encodeIntElement(serialDesc, 1, self.meta);
        output.encodeStringElement(serialDesc, 2, self.nbt);
        output.encodeIntElement(serialDesc, 3, self.amount);
        output.encodeIntElement(serialDesc, 4, self.caseId);
    }

    public /* synthetic */ DustData(int seen0, String registryName, int meta, String nbt, int amount, int caseId, SerializationConstructorMarker serializationConstructorMarker) {
        if (31 != (31 & seen0)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 31, DustData$$serializer.INSTANCE.getDescriptor());
        }
        this.registryName = registryName;
        this.meta = meta;
        this.nbt = nbt;
        this.amount = amount;
        this.caseId = caseId;
    }

    public DustData(@NotNull String registryName, int meta, @NotNull String nbt, int amount, int caseId) {
        Intrinsics.checkNotNullParameter(registryName, "registryName");
        Intrinsics.checkNotNullParameter(nbt, "nbt");
        this.registryName = registryName;
        this.meta = meta;
        this.nbt = nbt;
        this.amount = amount;
        this.caseId = caseId;
    }

    @NotNull
    public final String getRegistryName() {
        return this.registryName;
    }

    public final int getMeta() {
        return this.meta;
    }

    @NotNull
    public final String getNbt() {
        return this.nbt;
    }

    public final int getAmount() {
        return this.amount;
    }

    public final int getCaseId() {
        return this.caseId;
    }

    /* JADX INFO: compiled from: DustData.kt */
    /* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/common/response/DustData$Companion.class */
    @Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lnet/mcskill/shop/common/response/DustData$Companion;", "", "<init>", "()V", "EMPTY", "Lnet/mcskill/shop/common/response/DustData;", "getEMPTY", "()Lnet/mcskill/shop/common/response/DustData;", "serializer", "Lkotlinx/serialization/KSerializer;", "MSShop"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final KSerializer<DustData> serializer() {
            return DustData$$serializer.INSTANCE;
        }

        @NotNull
        public final DustData getEMPTY() {
            return DustData.EMPTY;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public DustData(@NotNull FriendlyByteBuf buf) {
        Intrinsics.checkNotNullParameter(buf, "buf");
        String utf = buf.readUtf();
        Intrinsics.checkNotNullExpressionValue(utf, "readUtf(...)");
        int i = buf.readInt();
        String utf2 = buf.readUtf();
        Intrinsics.checkNotNullExpressionValue(utf2, "readUtf(...)");
        this(utf, i, utf2, buf.readInt(), -1);
    }

    public void serialize(@NotNull FriendlyByteBuf buf) {
        Intrinsics.checkNotNullParameter(buf, "buf");
        buf.writeUtf(this.registryName);
        buf.writeInt(this.meta);
        buf.writeUtf(this.nbt);
        buf.writeInt(this.amount);
    }
}
