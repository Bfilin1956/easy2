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

/* JADX INFO: compiled from: TypeData.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/common/response/TypeData.class */
@Serializable
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 &2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002%&B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\nB-\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u0006\u0010\u000eJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\tH\u0016J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J%\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0001¢\u0006\u0002\b$R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006'"}, d2 = {"Lnet/mcskill/shop/common/response/TypeData;", "Lnet/mcskill/core/common/network/ByteBufferSerializer;", "name", "", "code", "", "<init>", "(Ljava/lang/String;I)V", "buf", "Lnet/minecraft/network/FriendlyByteBuf;", "(Lnet/minecraft/network/FriendlyByteBuf;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;ILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getName", "()Ljava/lang/String;", "getCode", "()I", "serialize", "", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$MSShop", "$serializer", "Companion", "MSShop"})
public final /* data */ class TypeData implements ByteBufferSerializer<TypeData> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private final String name;
    private final int code;

    @NotNull
    public final String component1() {
        return this.name;
    }

    public final int component2() {
        return this.code;
    }

    @NotNull
    public final TypeData copy(@NotNull String name, int code) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new TypeData(name, code);
    }

    public static /* synthetic */ TypeData copy$default(TypeData typeData, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = typeData.name;
        }
        if ((i2 & 2) != 0) {
            i = typeData.code;
        }
        return typeData.copy(str, i);
    }

    @NotNull
    public String toString() {
        return "TypeData(name=" + this.name + ", code=" + this.code + ")";
    }

    public int hashCode() {
        int result = this.name.hashCode();
        return (result * 31) + Integer.hashCode(this.code);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TypeData)) {
            return false;
        }
        TypeData typeData = (TypeData) other;
        return Intrinsics.areEqual(this.name, typeData.name) && this.code == typeData.code;
    }

    /* JADX INFO: compiled from: TypeData.kt */
    /* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/common/response/TypeData$Companion.class */
    @Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lnet/mcskill/shop/common/response/TypeData$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lnet/mcskill/shop/common/response/TypeData;", "MSShop"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        @NotNull
        public final KSerializer<TypeData> serializer() {
            return TypeData$$serializer.INSTANCE;
        }
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$MSShop(TypeData self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.name);
        output.encodeIntElement(serialDesc, 1, self.code);
    }

    public /* synthetic */ TypeData(int seen0, String name, int code, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (3 & seen0)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 3, TypeData$$serializer.INSTANCE.getDescriptor());
        }
        this.name = name;
        this.code = code;
    }

    public TypeData(@NotNull String name, int code) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
        this.code = code;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public final int getCode() {
        return this.code;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public TypeData(@NotNull FriendlyByteBuf buf) {
        Intrinsics.checkNotNullParameter(buf, "buf");
        String utf = buf.readUtf();
        Intrinsics.checkNotNullExpressionValue(utf, "readUtf(...)");
        this(utf, buf.readInt());
    }

    public void serialize(@NotNull FriendlyByteBuf buf) {
        Intrinsics.checkNotNullParameter(buf, "buf");
        buf.writeUtf(this.name);
        buf.writeInt(this.code);
    }
}
