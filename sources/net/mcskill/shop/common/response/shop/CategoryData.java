package net.mcskill.shop.common.response.shop;

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
import net.mcskill.core.common.json.serializer.BoolAsIntSerializer;
import net.mcskill.core.common.network.ByteBufferSerializer;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CategoryData.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/common/response/shop/CategoryData.class */
@Serializable
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 .2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002./B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\t\u0010\rB=\b\u0010\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\t\u0010\u0011J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J1\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\"\u001a\u00020\u00052\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\t\u0010&\u001a\u00020\u0007HÖ\u0001J%\u0010'\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020\u00002\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0001¢\u0006\u0002\b-R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013¨\u00060"}, d2 = {"Lnet/mcskill/shop/common/response/shop/CategoryData;", "Lnet/mcskill/core/common/network/ByteBufferSerializer;", "id", "", "enabled", "", "name", "", "sort", "<init>", "(IZLjava/lang/String;I)V", "buf", "Lnet/minecraft/network/FriendlyByteBuf;", "(Lnet/minecraft/network/FriendlyByteBuf;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IIZLjava/lang/String;ILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId", "()I", "getEnabled$annotations", "()V", "getEnabled", "()Z", "getName", "()Ljava/lang/String;", "getSort", "serialize", "", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "toString", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$MSShop", "Companion", "$serializer", "MSShop"})
public final /* data */ class CategoryData implements ByteBufferSerializer<CategoryData> {
    private final int id;
    private final boolean enabled;

    @NotNull
    private final String name;
    private final int sort;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @JvmField
    @NotNull
    private static final KSerializer<Object>[] $childSerializers = {null, new BoolAsIntSerializer(), null, null};
    private static final StreamCodec<FriendlyByteBuf, CategoryData> CODEC = StreamCodec.ofMember((v0, v1) -> {
        v0.serialize(v1);
    }, CategoryData::new);

    @Serializable(with = BoolAsIntSerializer.class)
    public static /* synthetic */ void getEnabled$annotations() {
    }

    public final int component1() {
        return this.id;
    }

    public final boolean component2() {
        return this.enabled;
    }

    @NotNull
    public final String component3() {
        return this.name;
    }

    public final int component4() {
        return this.sort;
    }

    @NotNull
    public final CategoryData copy(int id, boolean enabled, @NotNull String name, int sort) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new CategoryData(id, enabled, name, sort);
    }

    public static /* synthetic */ CategoryData copy$default(CategoryData categoryData, int i, boolean z, String str, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = categoryData.id;
        }
        if ((i3 & 2) != 0) {
            z = categoryData.enabled;
        }
        if ((i3 & 4) != 0) {
            str = categoryData.name;
        }
        if ((i3 & 8) != 0) {
            i2 = categoryData.sort;
        }
        return categoryData.copy(i, z, str, i2);
    }

    @NotNull
    public String toString() {
        return "CategoryData(id=" + this.id + ", enabled=" + this.enabled + ", name=" + this.name + ", sort=" + this.sort + ")";
    }

    public int hashCode() {
        int result = Integer.hashCode(this.id);
        return (((((result * 31) + Boolean.hashCode(this.enabled)) * 31) + this.name.hashCode()) * 31) + Integer.hashCode(this.sort);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CategoryData)) {
            return false;
        }
        CategoryData categoryData = (CategoryData) other;
        return this.id == categoryData.id && this.enabled == categoryData.enabled && Intrinsics.areEqual(this.name, categoryData.name) && this.sort == categoryData.sort;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$MSShop(CategoryData self, CompositeEncoder output, SerialDescriptor serialDesc) {
        SerializationStrategy[] serializationStrategyArr = $childSerializers;
        output.encodeIntElement(serialDesc, 0, self.id);
        output.encodeSerializableElement(serialDesc, 1, serializationStrategyArr[1], Boolean.valueOf(self.enabled));
        output.encodeStringElement(serialDesc, 2, self.name);
        output.encodeIntElement(serialDesc, 3, self.sort);
    }

    public /* synthetic */ CategoryData(int seen0, int id, boolean enabled, String name, int sort, SerializationConstructorMarker serializationConstructorMarker) {
        if (15 != (15 & seen0)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 15, CategoryData$$serializer.INSTANCE.getDescriptor());
        }
        this.id = id;
        this.enabled = enabled;
        this.name = name;
        this.sort = sort;
    }

    public CategoryData(int id, boolean enabled, @NotNull String name, int sort) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.id = id;
        this.enabled = enabled;
        this.name = name;
        this.sort = sort;
    }

    public final int getId() {
        return this.id;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public final int getSort() {
        return this.sort;
    }

    /* JADX INFO: compiled from: CategoryData.kt */
    /* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/common/response/shop/CategoryData$Companion.class */
    @Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\rRS\u0010\u0004\u001aB\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\b0\b \u0007* \u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\b0\b\u0018\u00010\u00050\u0005¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lnet/mcskill/shop/common/response/shop/CategoryData$Companion;", "", "<init>", "()V", "CODEC", "Lnet/minecraft/network/codec/StreamCodec;", "Lnet/minecraft/network/FriendlyByteBuf;", "kotlin.jvm.PlatformType", "Lnet/mcskill/shop/common/response/shop/CategoryData;", "getCODEC", "()Lnet/minecraft/network/codec/StreamCodec;", "Lnet/minecraft/network/codec/StreamCodec;", "serializer", "Lkotlinx/serialization/KSerializer;", "MSShop"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final KSerializer<CategoryData> serializer() {
            return CategoryData$$serializer.INSTANCE;
        }

        public final StreamCodec<FriendlyByteBuf, CategoryData> getCODEC() {
            return CategoryData.CODEC;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public CategoryData(@NotNull FriendlyByteBuf buf) {
        Intrinsics.checkNotNullParameter(buf, "buf");
        int i = buf.readInt();
        boolean z = buf.readBoolean();
        String utf = buf.readUtf();
        Intrinsics.checkNotNullExpressionValue(utf, "readUtf(...)");
        this(i, z, utf, buf.readShort());
    }

    public void serialize(@NotNull FriendlyByteBuf buf) {
        Intrinsics.checkNotNullParameter(buf, "buf");
        buf.writeInt(this.id);
        buf.writeBoolean(this.enabled);
        buf.writeUtf(this.name);
        buf.writeShort(this.sort);
    }
}
