package net.mcskill.shop.common.response.shop;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import net.mcskill.core.common.json.serializer.BoolAsIntSerializer;
import net.mcskill.core.common.network.ByteBufferSerializer;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ItemData.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/common/response/shop/ItemData.class */
@Serializable
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u0002\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 Z2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002Z[B¥\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00000\u0016¢\u0006\u0004\b\u0017\u0010\u0018B\u0011\b\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u001a¢\u0006\u0004\b\u0017\u0010\u001bB±\u0001\b\u0010\u0012\u0006\u0010\u001c\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0016\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\b\u0017\u0010\u001fJ\u0010\u0010;\u001a\u00020<2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\t\u0010>\u001a\u00020\u0005HÆ\u0003J\t\u0010?\u001a\u00020\u0007HÆ\u0003J\t\u0010@\u001a\u00020\u0007HÆ\u0003J\t\u0010A\u001a\u00020\u0007HÆ\u0003J\t\u0010B\u001a\u00020\u0007HÆ\u0003J\t\u0010C\u001a\u00020\u0007HÆ\u0003J\t\u0010D\u001a\u00020\u0007HÆ\u0003J\t\u0010E\u001a\u00020\u0003HÆ\u0003J\t\u0010F\u001a\u00020\u0007HÆ\u0003J\t\u0010G\u001a\u00020\u0010HÆ\u0003J\t\u0010H\u001a\u00020\u0010HÆ\u0003J\t\u0010I\u001a\u00020\u0003HÆ\u0003J\t\u0010J\u001a\u00020\u0003HÆ\u0003J\t\u0010K\u001a\u00020\u0003HÆ\u0003J\u000f\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00000\u0016HÆ\u0003J¯\u0001\u0010M\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00000\u0016HÆ\u0001J\u0013\u0010N\u001a\u00020\u00052\b\u0010O\u001a\u0004\u0018\u00010PHÖ\u0003J\t\u0010Q\u001a\u00020\u0003HÖ\u0001J\t\u0010R\u001a\u00020\u0007HÖ\u0001J%\u0010S\u001a\u00020<2\u0006\u0010T\u001a\u00020\u00002\u0006\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020XH\u0001¢\u0006\u0002\bYR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b(\u0010'R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b)\u0010'R\u001c\u0010\n\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b*\u0010#\u001a\u0004\b+\u0010'R\u0011\u0010\u000b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b,\u0010'R\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b-\u0010'R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010!R\u0011\u0010\u000e\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b/\u0010'R\u001c\u0010\u000f\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b0\u0010#\u001a\u0004\b1\u00102R\u001c\u0010\u0011\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b3\u0010#\u001a\u0004\b4\u00102R\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b5\u0010!R\u001c\u0010\u0013\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b6\u0010#\u001a\u0004\b7\u0010!R\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b8\u0010!R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00000\u0016¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:¨\u0006\\"}, d2 = {"Lnet/mcskill/shop/common/response/shop/ItemData;", "Lnet/mcskill/core/common/network/ByteBufferSerializer;", "id", "", "enabled", "", "name", "", "description", "type", "itemName", "img", "image", "amount", "extra", "priceRub", "", "priceEm", "sort", "catId", "discount", "items", "", "<init>", "(IZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;DDIIILjava/util/List;)V", "buf", "Lnet/minecraft/network/FriendlyByteBuf;", "(Lnet/minecraft/network/FriendlyByteBuf;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IIZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;DDIIILjava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId", "()I", "getEnabled$annotations", "()V", "getEnabled", "()Z", "getName", "()Ljava/lang/String;", "getDescription", "getType", "getItemName$annotations", "getItemName", "getImg", "getImage", "getAmount", "getExtra", "getPriceRub$annotations", "getPriceRub", "()D", "getPriceEm$annotations", "getPriceEm", "getSort", "getCatId$annotations", "getCatId", "getDiscount", "getItems", "()Ljava/util/List;", "serialize", "", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "copy", "equals", "other", "", "hashCode", "toString", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$MSShop", "Companion", "$serializer", "MSShop"})
public final /* data */ class ItemData implements ByteBufferSerializer<ItemData> {
    private final int id;
    private final boolean enabled;

    @NotNull
    private final String name;

    @NotNull
    private final String description;

    @NotNull
    private final String type;

    @NotNull
    private final String itemName;

    @NotNull
    private final String img;

    @NotNull
    private final String image;
    private final int amount;

    @NotNull
    private final String extra;
    private final double priceRub;
    private final double priceEm;
    private final int sort;
    private final int catId;
    private final int discount;

    @NotNull
    private final List<ItemData> items;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @JvmField
    @NotNull
    private static final KSerializer<Object>[] $childSerializers = {null, new BoolAsIntSerializer(), null, null, null, null, null, null, null, null, null, null, null, null, null, null};
    private static final StreamCodec<FriendlyByteBuf, ItemData> CODEC = StreamCodec.ofMember((v0, v1) -> {
        v0.serialize(v1);
    }, ItemData::new);

    @Serializable(with = BoolAsIntSerializer.class)
    public static /* synthetic */ void getEnabled$annotations() {
    }

    @SerialName("itemname")
    public static /* synthetic */ void getItemName$annotations() {
    }

    @SerialName("pricerub")
    public static /* synthetic */ void getPriceRub$annotations() {
    }

    @SerialName("priceem")
    public static /* synthetic */ void getPriceEm$annotations() {
    }

    @SerialName("catid")
    public static /* synthetic */ void getCatId$annotations() {
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

    @NotNull
    public final String component4() {
        return this.description;
    }

    @NotNull
    public final String component5() {
        return this.type;
    }

    @NotNull
    public final String component6() {
        return this.itemName;
    }

    @NotNull
    public final String component7() {
        return this.img;
    }

    @NotNull
    public final String component8() {
        return this.image;
    }

    public final int component9() {
        return this.amount;
    }

    @NotNull
    public final String component10() {
        return this.extra;
    }

    public final double component11() {
        return this.priceRub;
    }

    public final double component12() {
        return this.priceEm;
    }

    public final int component13() {
        return this.sort;
    }

    public final int component14() {
        return this.catId;
    }

    public final int component15() {
        return this.discount;
    }

    @NotNull
    public final List<ItemData> component16() {
        return this.items;
    }

    @NotNull
    public final ItemData copy(int id, boolean enabled, @NotNull String name, @NotNull String description, @NotNull String type, @NotNull String itemName, @NotNull String img, @NotNull String image, int amount, @NotNull String extra, double priceRub, double priceEm, int sort, int catId, int discount, @NotNull List<ItemData> items) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(itemName, "itemName");
        Intrinsics.checkNotNullParameter(img, "img");
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(extra, "extra");
        Intrinsics.checkNotNullParameter(items, "items");
        return new ItemData(id, enabled, name, description, type, itemName, img, image, amount, extra, priceRub, priceEm, sort, catId, discount, items);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ItemData copy$default(ItemData itemData, int i, boolean z, String str, String str2, String str3, String str4, String str5, String str6, int i2, String str7, double d, double d2, int i3, int i4, int i5, List list, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = itemData.id;
        }
        if ((i6 & 2) != 0) {
            z = itemData.enabled;
        }
        if ((i6 & 4) != 0) {
            str = itemData.name;
        }
        if ((i6 & 8) != 0) {
            str2 = itemData.description;
        }
        if ((i6 & 16) != 0) {
            str3 = itemData.type;
        }
        if ((i6 & 32) != 0) {
            str4 = itemData.itemName;
        }
        if ((i6 & 64) != 0) {
            str5 = itemData.img;
        }
        if ((i6 & 128) != 0) {
            str6 = itemData.image;
        }
        if ((i6 & 256) != 0) {
            i2 = itemData.amount;
        }
        if ((i6 & 512) != 0) {
            str7 = itemData.extra;
        }
        if ((i6 & 1024) != 0) {
            d = itemData.priceRub;
        }
        if ((i6 & 2048) != 0) {
            d2 = itemData.priceEm;
        }
        if ((i6 & 4096) != 0) {
            i3 = itemData.sort;
        }
        if ((i6 & 8192) != 0) {
            i4 = itemData.catId;
        }
        if ((i6 & 16384) != 0) {
            i5 = itemData.discount;
        }
        if ((i6 & 32768) != 0) {
            list = itemData.items;
        }
        return itemData.copy(i, z, str, str2, str3, str4, str5, str6, i2, str7, d, d2, i3, i4, i5, list);
    }

    @NotNull
    public String toString() {
        int i = this.id;
        boolean z = this.enabled;
        String str = this.name;
        String str2 = this.description;
        String str3 = this.type;
        String str4 = this.itemName;
        String str5 = this.img;
        String str6 = this.image;
        int i2 = this.amount;
        String str7 = this.extra;
        double d = this.priceRub;
        double d2 = this.priceEm;
        int i3 = this.sort;
        int i4 = this.catId;
        int i5 = this.discount;
        List<ItemData> list = this.items;
        return "ItemData(id=" + i + ", enabled=" + z + ", name=" + str + ", description=" + str2 + ", type=" + str3 + ", itemName=" + str4 + ", img=" + str5 + ", image=" + str6 + ", amount=" + i2 + ", extra=" + str7 + ", priceRub=" + d + ", priceEm=" + i + ", sort=" + d2 + ", catId=" + i + ", discount=" + i3 + ", items=" + i4 + ")";
    }

    public int hashCode() {
        int result = Integer.hashCode(this.id);
        return (((((((((((((((((((((((((((((result * 31) + Boolean.hashCode(this.enabled)) * 31) + this.name.hashCode()) * 31) + this.description.hashCode()) * 31) + this.type.hashCode()) * 31) + this.itemName.hashCode()) * 31) + this.img.hashCode()) * 31) + this.image.hashCode()) * 31) + Integer.hashCode(this.amount)) * 31) + this.extra.hashCode()) * 31) + Double.hashCode(this.priceRub)) * 31) + Double.hashCode(this.priceEm)) * 31) + Integer.hashCode(this.sort)) * 31) + Integer.hashCode(this.catId)) * 31) + Integer.hashCode(this.discount)) * 31) + this.items.hashCode();
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ItemData)) {
            return false;
        }
        ItemData itemData = (ItemData) other;
        return this.id == itemData.id && this.enabled == itemData.enabled && Intrinsics.areEqual(this.name, itemData.name) && Intrinsics.areEqual(this.description, itemData.description) && Intrinsics.areEqual(this.type, itemData.type) && Intrinsics.areEqual(this.itemName, itemData.itemName) && Intrinsics.areEqual(this.img, itemData.img) && Intrinsics.areEqual(this.image, itemData.image) && this.amount == itemData.amount && Intrinsics.areEqual(this.extra, itemData.extra) && Double.compare(this.priceRub, itemData.priceRub) == 0 && Double.compare(this.priceEm, itemData.priceEm) == 0 && this.sort == itemData.sort && this.catId == itemData.catId && this.discount == itemData.discount && Intrinsics.areEqual(this.items, itemData.items);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$MSShop(ItemData self, CompositeEncoder output, SerialDescriptor serialDesc) {
        SerializationStrategy[] serializationStrategyArr = $childSerializers;
        output.encodeIntElement(serialDesc, 0, self.id);
        boolean z = output.shouldEncodeElementDefault(serialDesc, 1) || !self.enabled;
        if (z) {
            output.encodeSerializableElement(serialDesc, 1, serializationStrategyArr[1], Boolean.valueOf(self.enabled));
        }
        output.encodeStringElement(serialDesc, 2, self.name);
        boolean z2 = output.shouldEncodeElementDefault(serialDesc, 3) || !Intrinsics.areEqual(self.description, "");
        if (z2) {
            output.encodeStringElement(serialDesc, 3, self.description);
        }
        output.encodeStringElement(serialDesc, 4, self.type);
        boolean z3 = output.shouldEncodeElementDefault(serialDesc, 5) || !Intrinsics.areEqual(self.itemName, "");
        if (z3) {
            output.encodeStringElement(serialDesc, 5, self.itemName);
        }
        boolean z4 = output.shouldEncodeElementDefault(serialDesc, 6) || !Intrinsics.areEqual(self.img, "");
        if (z4) {
            output.encodeStringElement(serialDesc, 6, self.img);
        }
        boolean z5 = output.shouldEncodeElementDefault(serialDesc, 7) || !Intrinsics.areEqual(self.image, "");
        if (z5) {
            output.encodeStringElement(serialDesc, 7, self.image);
        }
        output.encodeIntElement(serialDesc, 8, self.amount);
        boolean z6 = output.shouldEncodeElementDefault(serialDesc, 9) || !Intrinsics.areEqual(self.extra, "");
        if (z6) {
            output.encodeStringElement(serialDesc, 9, self.extra);
        }
        boolean z7 = output.shouldEncodeElementDefault(serialDesc, 10) || Double.compare(self.priceRub, 0.0d) != 0;
        if (z7) {
            output.encodeDoubleElement(serialDesc, 10, self.priceRub);
        }
        boolean z8 = output.shouldEncodeElementDefault(serialDesc, 11) || Double.compare(self.priceEm, 0.0d) != 0;
        if (z8) {
            output.encodeDoubleElement(serialDesc, 11, self.priceEm);
        }
        boolean z9 = output.shouldEncodeElementDefault(serialDesc, 12) || self.sort != 0;
        if (z9) {
            output.encodeIntElement(serialDesc, 12, self.sort);
        }
        boolean z10 = output.shouldEncodeElementDefault(serialDesc, 13) || self.catId != -1;
        if (z10) {
            output.encodeIntElement(serialDesc, 13, self.catId);
        }
        boolean z11 = output.shouldEncodeElementDefault(serialDesc, 14) || self.discount != 0;
        if (z11) {
            output.encodeIntElement(serialDesc, 14, self.discount);
        }
        boolean z12 = output.shouldEncodeElementDefault(serialDesc, 15) || !Intrinsics.areEqual(self.items, CollectionsKt.emptyList());
        if (z12) {
            output.encodeSerializableElement(serialDesc, 15, new ArrayListSerializer(ItemData$$serializer.INSTANCE), self.items);
        }
    }

    public /* synthetic */ ItemData(int seen0, int id, boolean enabled, String name, String description, String type, String itemName, String img, String image, int amount, String extra, double priceRub, double priceEm, int sort, int catId, int discount, List items, SerializationConstructorMarker serializationConstructorMarker) {
        if (277 != (277 & seen0)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 277, ItemData$$serializer.INSTANCE.getDescriptor());
        }
        this.id = id;
        if ((seen0 & 2) == 0) {
            this.enabled = true;
        } else {
            this.enabled = enabled;
        }
        this.name = name;
        if ((seen0 & 8) == 0) {
            this.description = "";
        } else {
            this.description = description;
        }
        this.type = type;
        if ((seen0 & 32) == 0) {
            this.itemName = "";
        } else {
            this.itemName = itemName;
        }
        if ((seen0 & 64) == 0) {
            this.img = "";
        } else {
            this.img = img;
        }
        if ((seen0 & 128) == 0) {
            this.image = "";
        } else {
            this.image = image;
        }
        this.amount = amount;
        if ((seen0 & 512) == 0) {
            this.extra = "";
        } else {
            this.extra = extra;
        }
        if ((seen0 & 1024) == 0) {
            this.priceRub = 0.0d;
        } else {
            this.priceRub = priceRub;
        }
        if ((seen0 & 2048) == 0) {
            this.priceEm = 0.0d;
        } else {
            this.priceEm = priceEm;
        }
        if ((seen0 & 4096) == 0) {
            this.sort = 0;
        } else {
            this.sort = sort;
        }
        if ((seen0 & 8192) == 0) {
            this.catId = -1;
        } else {
            this.catId = catId;
        }
        if ((seen0 & 16384) == 0) {
            this.discount = 0;
        } else {
            this.discount = discount;
        }
        if ((seen0 & 32768) == 0) {
            this.items = CollectionsKt.emptyList();
        } else {
            this.items = items;
        }
    }

    public ItemData(int id, boolean enabled, @NotNull String name, @NotNull String description, @NotNull String type, @NotNull String itemName, @NotNull String img, @NotNull String image, int amount, @NotNull String extra, double priceRub, double priceEm, int sort, int catId, int discount, @NotNull List<ItemData> list) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(itemName, "itemName");
        Intrinsics.checkNotNullParameter(img, "img");
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(extra, "extra");
        Intrinsics.checkNotNullParameter(list, "items");
        this.id = id;
        this.enabled = enabled;
        this.name = name;
        this.description = description;
        this.type = type;
        this.itemName = itemName;
        this.img = img;
        this.image = image;
        this.amount = amount;
        this.extra = extra;
        this.priceRub = priceRub;
        this.priceEm = priceEm;
        this.sort = sort;
        this.catId = catId;
        this.discount = discount;
        this.items = list;
    }

    public /* synthetic */ ItemData(int i, boolean z, String str, String str2, String str3, String str4, String str5, String str6, int i2, String str7, double d, double d2, int i3, int i4, int i5, List list, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i6 & 2) != 0 ? true : z, str, (i6 & 8) != 0 ? "" : str2, str3, (i6 & 32) != 0 ? "" : str4, (i6 & 64) != 0 ? "" : str5, (i6 & 128) != 0 ? "" : str6, i2, (i6 & 512) != 0 ? "" : str7, (i6 & 1024) != 0 ? 0.0d : d, (i6 & 2048) != 0 ? 0.0d : d2, (i6 & 4096) != 0 ? 0 : i3, (i6 & 8192) != 0 ? -1 : i4, (i6 & 16384) != 0 ? 0 : i5, (i6 & 32768) != 0 ? CollectionsKt.emptyList() : list);
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

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    @NotNull
    public final String getItemName() {
        return this.itemName;
    }

    @NotNull
    public final String getImg() {
        return this.img;
    }

    @NotNull
    public final String getImage() {
        return this.image;
    }

    public final int getAmount() {
        return this.amount;
    }

    @NotNull
    public final String getExtra() {
        return this.extra;
    }

    public final double getPriceRub() {
        return this.priceRub;
    }

    public final double getPriceEm() {
        return this.priceEm;
    }

    public final int getSort() {
        return this.sort;
    }

    public final int getCatId() {
        return this.catId;
    }

    public final int getDiscount() {
        return this.discount;
    }

    @NotNull
    public final List<ItemData> getItems() {
        return this.items;
    }

    /* JADX INFO: compiled from: ItemData.kt */
    /* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/common/response/shop/ItemData$Companion.class */
    @Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\rRS\u0010\u0004\u001aB\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\b0\b \u0007* \u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\b0\b\u0018\u00010\u00050\u0005¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lnet/mcskill/shop/common/response/shop/ItemData$Companion;", "", "<init>", "()V", "CODEC", "Lnet/minecraft/network/codec/StreamCodec;", "Lnet/minecraft/network/FriendlyByteBuf;", "kotlin.jvm.PlatformType", "Lnet/mcskill/shop/common/response/shop/ItemData;", "getCODEC", "()Lnet/minecraft/network/codec/StreamCodec;", "Lnet/minecraft/network/codec/StreamCodec;", "serializer", "Lkotlinx/serialization/KSerializer;", "MSShop"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final KSerializer<ItemData> serializer() {
            return ItemData$$serializer.INSTANCE;
        }

        public final StreamCodec<FriendlyByteBuf, ItemData> getCODEC() {
            return ItemData.CODEC;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ItemData(@NotNull FriendlyByteBuf buf) {
        Intrinsics.checkNotNullParameter(buf, "buf");
        int i = buf.readInt();
        boolean z = buf.readBoolean();
        String utf = buf.readUtf();
        Intrinsics.checkNotNullExpressionValue(utf, "readUtf(...)");
        String utf2 = buf.readUtf();
        Intrinsics.checkNotNullExpressionValue(utf2, "readUtf(...)");
        String utf3 = buf.readUtf();
        Intrinsics.checkNotNullExpressionValue(utf3, "readUtf(...)");
        String utf4 = buf.readUtf();
        Intrinsics.checkNotNullExpressionValue(utf4, "readUtf(...)");
        String utf5 = buf.readUtf();
        Intrinsics.checkNotNullExpressionValue(utf5, "readUtf(...)");
        String utf6 = buf.readUtf();
        Intrinsics.checkNotNullExpressionValue(utf6, "readUtf(...)");
        int i2 = buf.readInt();
        String utf7 = buf.readUtf();
        Intrinsics.checkNotNullExpressionValue(utf7, "readUtf(...)");
        double d = buf.readDouble();
        double d2 = buf.readDouble();
        byte b = buf.readByte();
        short s = buf.readShort();
        short s2 = buf.readShort();
        AnonymousClass1 anonymousClass1 = AnonymousClass1.INSTANCE;
        List list = buf.readList((v1) -> {
            return _init_$lambda$0(r17, v1);
        });
        Intrinsics.checkNotNullExpressionValue(list, "readList(...)");
        this(i, z, utf, utf2, utf3, utf4, utf5, utf6, i2, utf7, d, d2, b, s, s2, list);
    }

    /* JADX INFO: renamed from: net.mcskill.shop.common.response.shop.ItemData$1, reason: invalid class name */
    /* JADX INFO: compiled from: ItemData.kt */
    /* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/common/response/shop/ItemData$1.class */
    @Metadata(mv = {2, 0, 0}, k = 3, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<FriendlyByteBuf, ItemData> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(1, ItemData.class, "<init>", "<init>(Lnet/minecraft/network/FriendlyByteBuf;)V", 0);
        }

        public final ItemData invoke(FriendlyByteBuf p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return new ItemData(p0);
        }
    }

    private static final ItemData _init_$lambda$0(Function1 $tmp0, Object p0) {
        return (ItemData) $tmp0.invoke(p0);
    }

    public void serialize(@NotNull FriendlyByteBuf buf) {
        Intrinsics.checkNotNullParameter(buf, "buf");
        buf.writeInt(this.id);
        buf.writeBoolean(this.enabled);
        buf.writeUtf(this.name);
        buf.writeUtf(this.description);
        buf.writeUtf(this.type);
        buf.writeUtf(this.itemName);
        buf.writeUtf(this.img);
        buf.writeUtf(this.image);
        buf.writeInt(this.amount);
        buf.writeUtf(this.extra);
        buf.writeDouble(this.priceRub);
        buf.writeDouble(this.priceEm);
        buf.writeByte(this.sort);
        buf.writeShort(this.catId);
        buf.writeShort(this.discount);
        List<ItemData> list = this.items;
        Function2 function2 = ItemData::serialize$lambda$1;
        buf.writeCollection(list, (v1, v2) -> {
            serialize$lambda$2(r2, v1, v2);
        });
    }

    private static final void serialize$lambda$2(Function2 $tmp0, Object p0, ItemData p1) {
        $tmp0.invoke(p0, p1);
    }

    private static final Unit serialize$lambda$1(FriendlyByteBuf innerBuf, ItemData item) {
        Intrinsics.checkNotNull(innerBuf);
        item.serialize(innerBuf);
        return Unit.INSTANCE;
    }
}
