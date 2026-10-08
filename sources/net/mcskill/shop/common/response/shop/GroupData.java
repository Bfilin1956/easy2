package net.mcskill.shop.common.response.shop;

import java.time.Instant;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import net.mcskill.core.common.json.serializer.BoolAsIntSerializer;
import net.mcskill.core.common.network.ByteBufferSerializer;
import net.mcskill.core.common.util.FormattingCode;
import net.mcskill.shop.common.response.PurchaseData;
import net.mcskill.shop.common.response.PurchaseData$$serializer;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: GroupData.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/common/response/shop/GroupData.class */
@Serializable
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b9\n\u0002\u0010\u0002\n\u0002\b\u001e\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u008b\u00012\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0004\u008b\u0001\u008c\u0001B\u0083\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u001a\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001a\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001a\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001a\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001f\u001a\u00020 ¢\u0006\u0004\b!\u0010\"B\u0011\b\u0016\u0012\u0006\u0010#\u001a\u00020$¢\u0006\u0004\b!\u0010%B\u0081\u0002\b\u0010\u0012\u0006\u0010&\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u001a\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010\u001c\u001a\u00020\u001a\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u0010\u001e\u001a\u00020\u0003\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\b\u0010'\u001a\u0004\u0018\u00010(¢\u0006\u0004\b!\u0010)J\u0010\u0010a\u001a\u00020b2\u0006\u0010#\u001a\u00020$H\u0016J\t\u0010c\u001a\u00020\u0003HÆ\u0003J\t\u0010d\u001a\u00020\u0003HÆ\u0003J\t\u0010e\u001a\u00020\u0003HÆ\u0003J\t\u0010f\u001a\u00020\u0007HÆ\u0003J\t\u0010g\u001a\u00020\u0007HÆ\u0003J\t\u0010h\u001a\u00020\u0007HÆ\u0003J\t\u0010i\u001a\u00020\u0007HÆ\u0003J\t\u0010j\u001a\u00020\u0007HÆ\u0003J\t\u0010k\u001a\u00020\u0003HÆ\u0003J\t\u0010l\u001a\u00020\u0007HÆ\u0003J\t\u0010m\u001a\u00020\u0003HÆ\u0003J\t\u0010n\u001a\u00020\u0003HÆ\u0003J\t\u0010o\u001a\u00020\u0003HÆ\u0003J\t\u0010p\u001a\u00020\u0003HÆ\u0003J\t\u0010q\u001a\u00020\u0003HÆ\u0003J\t\u0010r\u001a\u00020\u0003HÆ\u0003J\t\u0010s\u001a\u00020\u0003HÆ\u0003J\t\u0010t\u001a\u00020\u0003HÆ\u0003J\t\u0010u\u001a\u00020\u0003HÆ\u0003J\t\u0010v\u001a\u00020\u0003HÆ\u0003J\t\u0010w\u001a\u00020\u0003HÆ\u0003J\t\u0010x\u001a\u00020\u001aHÆ\u0003J\t\u0010y\u001a\u00020\u001aHÆ\u0003J\t\u0010z\u001a\u00020\u001aHÆ\u0003J\t\u0010{\u001a\u00020\u001aHÆ\u0003J\t\u0010|\u001a\u00020\u0003HÆ\u0003J\t\u0010}\u001a\u00020 HÆ\u0003J\u0097\u0002\u0010~\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u001a2\b\b\u0002\u0010\u001d\u001a\u00020\u001a2\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020 HÆ\u0001J\u0015\u0010\u007f\u001a\u00020\u001a2\n\u0010\u0080\u0001\u001a\u0005\u0018\u00010\u0081\u0001HÖ\u0003J\n\u0010\u0082\u0001\u001a\u00020\u0003HÖ\u0001J\n\u0010\u0083\u0001\u001a\u00020\u0007HÖ\u0001J,\u0010\u0084\u0001\u001a\u00020b2\u0007\u0010\u0085\u0001\u001a\u00020\u00002\b\u0010\u0086\u0001\u001a\u00030\u0087\u00012\b\u0010\u0088\u0001\u001a\u00030\u0089\u0001H\u0001¢\u0006\u0003\b\u008a\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010+R\u001c\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b-\u0010.\u001a\u0004\b/\u0010+R\u001c\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b0\u0010.\u001a\u0004\b1\u00102R\u001c\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b3\u0010.\u001a\u0004\b4\u00102R\u001c\u0010\t\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b5\u0010.\u001a\u0004\b6\u00102R\u001c\u0010\n\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b7\u0010.\u001a\u0004\b8\u00102R\u0011\u0010\u000b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b9\u00102R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b:\u0010+R\u0011\u0010\r\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b;\u00102R\u001c\u0010\u000e\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b<\u0010.\u001a\u0004\b=\u0010+R\u001c\u0010\u000f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b>\u0010.\u001a\u0004\b?\u0010+R\u001c\u0010\u0010\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b@\u0010.\u001a\u0004\bA\u0010+R\u001c\u0010\u0011\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bB\u0010.\u001a\u0004\bC\u0010+R\u001c\u0010\u0012\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bD\u0010.\u001a\u0004\bE\u0010+R\u001c\u0010\u0013\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bF\u0010.\u001a\u0004\bG\u0010+R\u001c\u0010\u0014\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bH\u0010.\u001a\u0004\bI\u0010+R\u001c\u0010\u0015\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bJ\u0010.\u001a\u0004\bK\u0010+R\u001c\u0010\u0016\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bL\u0010.\u001a\u0004\bM\u0010+R\u001c\u0010\u0017\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bN\u0010.\u001a\u0004\bO\u0010+R\u0011\u0010\u0018\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bP\u0010+R\u001c\u0010\u0019\u001a\u00020\u001a8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bQ\u0010.\u001a\u0004\bR\u0010SR\u001c\u0010\u001b\u001a\u00020\u001a8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bT\u0010.\u001a\u0004\bU\u0010SR\u001c\u0010\u001c\u001a\u00020\u001a8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bV\u0010.\u001a\u0004\bW\u0010SR\u001c\u0010\u001d\u001a\u00020\u001a8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bX\u0010.\u001a\u0004\bY\u0010SR\u0011\u0010\u001e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010+R\u0011\u0010\u001f\u001a\u00020 ¢\u0006\b\n\u0000\u001a\u0004\b[\u0010\\R\u001b\u0010]\u001a\u00020\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b_\u0010`\u001a\u0004\b^\u00102¨\u0006\u008d\u0001"}, d2 = {"Lnet/mcskill/shop/common/response/shop/GroupData;", "Lnet/mcskill/core/common/network/ByteBufferSerializer;", "order", "", "id", "groupId", "name", "", "shortStory", "image", "pexName", "color", "upgrade", "desc", "priceMonth", "priceEmMonth", "pricePerm", "priceYear", "priceMonthDiscount", "pricePermDiscount", "priceYearDiscount", "discountMonth", "discountPerm", "discountYear", "sort", "sellEmMonth", "", "sellMonth", "sellYear", "sellPerm", "time", "purchase", "Lnet/mcskill/shop/common/response/PurchaseData;", "<init>", "(IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;IIIIIIIIIIIZZZZILnet/mcskill/shop/common/response/PurchaseData;)V", "buf", "Lnet/minecraft/network/FriendlyByteBuf;", "(Lnet/minecraft/network/FriendlyByteBuf;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IIIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;IIIIIIIIIIIZZZZILnet/mcskill/shop/common/response/PurchaseData;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getOrder", "()I", "getId", "getGroupId$annotations", "()V", "getGroupId", "getName$annotations", "getName", "()Ljava/lang/String;", "getShortStory$annotations", "getShortStory", "getImage$annotations", "getImage", "getPexName$annotations", "getPexName", "getColor", "getUpgrade", "getDesc", "getPriceMonth$annotations", "getPriceMonth", "getPriceEmMonth$annotations", "getPriceEmMonth", "getPricePerm$annotations", "getPricePerm", "getPriceYear$annotations", "getPriceYear", "getPriceMonthDiscount$annotations", "getPriceMonthDiscount", "getPricePermDiscount$annotations", "getPricePermDiscount", "getPriceYearDiscount$annotations", "getPriceYearDiscount", "getDiscountMonth$annotations", "getDiscountMonth", "getDiscountPerm$annotations", "getDiscountPerm", "getDiscountYear$annotations", "getDiscountYear", "getSort", "getSellEmMonth$annotations", "getSellEmMonth", "()Z", "getSellMonth$annotations", "getSellMonth", "getSellYear$annotations", "getSellYear", "getSellPerm$annotations", "getSellPerm", "getTime", "getPurchase", "()Lnet/mcskill/shop/common/response/PurchaseData;", "prettyName", "getPrettyName", "prettyName$delegate", "Lkotlin/Lazy;", "serialize", "", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "copy", "equals", "other", "", "hashCode", "toString", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$MSShop", "Companion", "$serializer", "MSShop"})
public final /* data */ class GroupData implements ByteBufferSerializer<GroupData> {
    private final int order;
    private final int id;
    private final int groupId;

    @NotNull
    private final String name;

    @NotNull
    private final String shortStory;

    @NotNull
    private final String image;

    @NotNull
    private final String pexName;

    @NotNull
    private final String color;
    private final int upgrade;

    @NotNull
    private final String desc;
    private final int priceMonth;
    private final int priceEmMonth;
    private final int pricePerm;
    private final int priceYear;
    private final int priceMonthDiscount;
    private final int pricePermDiscount;
    private final int priceYearDiscount;
    private final int discountMonth;
    private final int discountPerm;
    private final int discountYear;
    private final int sort;
    private final boolean sellEmMonth;
    private final boolean sellMonth;
    private final boolean sellYear;
    private final boolean sellPerm;
    private final int time;

    @NotNull
    private final PurchaseData purchase;

    /* JADX INFO: renamed from: prettyName$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy prettyName;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @JvmField
    @NotNull
    private static final KSerializer<Object>[] $childSerializers = {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, new BoolAsIntSerializer(), new BoolAsIntSerializer(), new BoolAsIntSerializer(), new BoolAsIntSerializer(), null, null};
    private static final StreamCodec<FriendlyByteBuf, GroupData> CODEC = StreamCodec.ofMember((v0, v1) -> {
        v0.serialize(v1);
    }, GroupData::new);

    @SerialName("group_id")
    public static /* synthetic */ void getGroupId$annotations() {
    }

    @SerialName("site_name")
    public static /* synthetic */ void getName$annotations() {
    }

    @SerialName("shortstory")
    public static /* synthetic */ void getShortStory$annotations() {
    }

    @SerialName("img")
    public static /* synthetic */ void getImage$annotations() {
    }

    @SerialName("pex_name")
    public static /* synthetic */ void getPexName$annotations() {
    }

    @SerialName("price_month")
    public static /* synthetic */ void getPriceMonth$annotations() {
    }

    @SerialName("price_em_month")
    public static /* synthetic */ void getPriceEmMonth$annotations() {
    }

    @SerialName("price_perm")
    public static /* synthetic */ void getPricePerm$annotations() {
    }

    @SerialName("price_year")
    public static /* synthetic */ void getPriceYear$annotations() {
    }

    @SerialName("price_month_discount")
    public static /* synthetic */ void getPriceMonthDiscount$annotations() {
    }

    @SerialName("price_perm_discount")
    public static /* synthetic */ void getPricePermDiscount$annotations() {
    }

    @SerialName("price_year_discount")
    public static /* synthetic */ void getPriceYearDiscount$annotations() {
    }

    @SerialName("discount_month")
    public static /* synthetic */ void getDiscountMonth$annotations() {
    }

    @SerialName("discount_perm")
    public static /* synthetic */ void getDiscountPerm$annotations() {
    }

    @SerialName("discount_year")
    public static /* synthetic */ void getDiscountYear$annotations() {
    }

    @SerialName("sell_em_month")
    @Serializable(with = BoolAsIntSerializer.class)
    public static /* synthetic */ void getSellEmMonth$annotations() {
    }

    @SerialName("sell_month")
    @Serializable(with = BoolAsIntSerializer.class)
    public static /* synthetic */ void getSellMonth$annotations() {
    }

    @SerialName("sell_year")
    @Serializable(with = BoolAsIntSerializer.class)
    public static /* synthetic */ void getSellYear$annotations() {
    }

    @SerialName("sell_perm")
    @Serializable(with = BoolAsIntSerializer.class)
    public static /* synthetic */ void getSellPerm$annotations() {
    }

    public final int component1() {
        return this.order;
    }

    public final int component2() {
        return this.id;
    }

    public final int component3() {
        return this.groupId;
    }

    @NotNull
    public final String component4() {
        return this.name;
    }

    @NotNull
    public final String component5() {
        return this.shortStory;
    }

    @NotNull
    public final String component6() {
        return this.image;
    }

    @NotNull
    public final String component7() {
        return this.pexName;
    }

    @NotNull
    public final String component8() {
        return this.color;
    }

    public final int component9() {
        return this.upgrade;
    }

    @NotNull
    public final String component10() {
        return this.desc;
    }

    public final int component11() {
        return this.priceMonth;
    }

    public final int component12() {
        return this.priceEmMonth;
    }

    public final int component13() {
        return this.pricePerm;
    }

    public final int component14() {
        return this.priceYear;
    }

    public final int component15() {
        return this.priceMonthDiscount;
    }

    public final int component16() {
        return this.pricePermDiscount;
    }

    public final int component17() {
        return this.priceYearDiscount;
    }

    public final int component18() {
        return this.discountMonth;
    }

    public final int component19() {
        return this.discountPerm;
    }

    public final int component20() {
        return this.discountYear;
    }

    public final int component21() {
        return this.sort;
    }

    public final boolean component22() {
        return this.sellEmMonth;
    }

    public final boolean component23() {
        return this.sellMonth;
    }

    public final boolean component24() {
        return this.sellYear;
    }

    public final boolean component25() {
        return this.sellPerm;
    }

    public final int component26() {
        return this.time;
    }

    @NotNull
    public final PurchaseData component27() {
        return this.purchase;
    }

    @NotNull
    public final GroupData copy(int order, int id, int groupId, @NotNull String name, @NotNull String shortStory, @NotNull String image, @NotNull String pexName, @NotNull String color, int upgrade, @NotNull String desc, int priceMonth, int priceEmMonth, int pricePerm, int priceYear, int priceMonthDiscount, int pricePermDiscount, int priceYearDiscount, int discountMonth, int discountPerm, int discountYear, int sort, boolean sellEmMonth, boolean sellMonth, boolean sellYear, boolean sellPerm, int time, @NotNull PurchaseData purchase) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(shortStory, "shortStory");
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(pexName, "pexName");
        Intrinsics.checkNotNullParameter(color, "color");
        Intrinsics.checkNotNullParameter(desc, "desc");
        Intrinsics.checkNotNullParameter(purchase, "purchase");
        return new GroupData(order, id, groupId, name, shortStory, image, pexName, color, upgrade, desc, priceMonth, priceEmMonth, pricePerm, priceYear, priceMonthDiscount, pricePermDiscount, priceYearDiscount, discountMonth, discountPerm, discountYear, sort, sellEmMonth, sellMonth, sellYear, sellPerm, time, purchase);
    }

    public static /* synthetic */ GroupData copy$default(GroupData groupData, int i, int i2, int i3, String str, String str2, String str3, String str4, String str5, int i4, String str6, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, boolean z, boolean z2, boolean z3, boolean z4, int i16, PurchaseData purchaseData, int i17, Object obj) {
        if ((i17 & 1) != 0) {
            i = groupData.order;
        }
        if ((i17 & 2) != 0) {
            i2 = groupData.id;
        }
        if ((i17 & 4) != 0) {
            i3 = groupData.groupId;
        }
        if ((i17 & 8) != 0) {
            str = groupData.name;
        }
        if ((i17 & 16) != 0) {
            str2 = groupData.shortStory;
        }
        if ((i17 & 32) != 0) {
            str3 = groupData.image;
        }
        if ((i17 & 64) != 0) {
            str4 = groupData.pexName;
        }
        if ((i17 & 128) != 0) {
            str5 = groupData.color;
        }
        if ((i17 & 256) != 0) {
            i4 = groupData.upgrade;
        }
        if ((i17 & 512) != 0) {
            str6 = groupData.desc;
        }
        if ((i17 & 1024) != 0) {
            i5 = groupData.priceMonth;
        }
        if ((i17 & 2048) != 0) {
            i6 = groupData.priceEmMonth;
        }
        if ((i17 & 4096) != 0) {
            i7 = groupData.pricePerm;
        }
        if ((i17 & 8192) != 0) {
            i8 = groupData.priceYear;
        }
        if ((i17 & 16384) != 0) {
            i9 = groupData.priceMonthDiscount;
        }
        if ((i17 & 32768) != 0) {
            i10 = groupData.pricePermDiscount;
        }
        if ((i17 & 65536) != 0) {
            i11 = groupData.priceYearDiscount;
        }
        if ((i17 & 131072) != 0) {
            i12 = groupData.discountMonth;
        }
        if ((i17 & 262144) != 0) {
            i13 = groupData.discountPerm;
        }
        if ((i17 & 524288) != 0) {
            i14 = groupData.discountYear;
        }
        if ((i17 & 1048576) != 0) {
            i15 = groupData.sort;
        }
        if ((i17 & 2097152) != 0) {
            z = groupData.sellEmMonth;
        }
        if ((i17 & 4194304) != 0) {
            z2 = groupData.sellMonth;
        }
        if ((i17 & 8388608) != 0) {
            z3 = groupData.sellYear;
        }
        if ((i17 & 16777216) != 0) {
            z4 = groupData.sellPerm;
        }
        if ((i17 & 33554432) != 0) {
            i16 = groupData.time;
        }
        if ((i17 & 67108864) != 0) {
            purchaseData = groupData.purchase;
        }
        return groupData.copy(i, i2, i3, str, str2, str3, str4, str5, i4, str6, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, z, z2, z3, z4, i16, purchaseData);
    }

    @NotNull
    public String toString() {
        return "GroupData(order=" + this.order + ", id=" + this.id + ", groupId=" + this.groupId + ", name=" + this.name + ", shortStory=" + this.shortStory + ", image=" + this.image + ", pexName=" + this.pexName + ", color=" + this.color + ", upgrade=" + this.upgrade + ", desc=" + this.desc + ", priceMonth=" + this.priceMonth + ", priceEmMonth=" + this.priceEmMonth + ", pricePerm=" + this.pricePerm + ", priceYear=" + this.priceYear + ", priceMonthDiscount=" + this.priceMonthDiscount + ", pricePermDiscount=" + this.pricePermDiscount + ", priceYearDiscount=" + this.priceYearDiscount + ", discountMonth=" + this.discountMonth + ", discountPerm=" + this.discountPerm + ", discountYear=" + this.discountYear + ", sort=" + this.sort + ", sellEmMonth=" + this.sellEmMonth + ", sellMonth=" + this.sellMonth + ", sellYear=" + this.sellYear + ", sellPerm=" + this.sellPerm + ", time=" + this.time + ", purchase=" + this.purchase + ")";
    }

    public int hashCode() {
        int result = Integer.hashCode(this.order);
        return (((((((((((((((((((((((((((((((((((((((((((((((((((result * 31) + Integer.hashCode(this.id)) * 31) + Integer.hashCode(this.groupId)) * 31) + this.name.hashCode()) * 31) + this.shortStory.hashCode()) * 31) + this.image.hashCode()) * 31) + this.pexName.hashCode()) * 31) + this.color.hashCode()) * 31) + Integer.hashCode(this.upgrade)) * 31) + this.desc.hashCode()) * 31) + Integer.hashCode(this.priceMonth)) * 31) + Integer.hashCode(this.priceEmMonth)) * 31) + Integer.hashCode(this.pricePerm)) * 31) + Integer.hashCode(this.priceYear)) * 31) + Integer.hashCode(this.priceMonthDiscount)) * 31) + Integer.hashCode(this.pricePermDiscount)) * 31) + Integer.hashCode(this.priceYearDiscount)) * 31) + Integer.hashCode(this.discountMonth)) * 31) + Integer.hashCode(this.discountPerm)) * 31) + Integer.hashCode(this.discountYear)) * 31) + Integer.hashCode(this.sort)) * 31) + Boolean.hashCode(this.sellEmMonth)) * 31) + Boolean.hashCode(this.sellMonth)) * 31) + Boolean.hashCode(this.sellYear)) * 31) + Boolean.hashCode(this.sellPerm)) * 31) + Integer.hashCode(this.time)) * 31) + this.purchase.hashCode();
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GroupData)) {
            return false;
        }
        GroupData groupData = (GroupData) other;
        return this.order == groupData.order && this.id == groupData.id && this.groupId == groupData.groupId && Intrinsics.areEqual(this.name, groupData.name) && Intrinsics.areEqual(this.shortStory, groupData.shortStory) && Intrinsics.areEqual(this.image, groupData.image) && Intrinsics.areEqual(this.pexName, groupData.pexName) && Intrinsics.areEqual(this.color, groupData.color) && this.upgrade == groupData.upgrade && Intrinsics.areEqual(this.desc, groupData.desc) && this.priceMonth == groupData.priceMonth && this.priceEmMonth == groupData.priceEmMonth && this.pricePerm == groupData.pricePerm && this.priceYear == groupData.priceYear && this.priceMonthDiscount == groupData.priceMonthDiscount && this.pricePermDiscount == groupData.pricePermDiscount && this.priceYearDiscount == groupData.priceYearDiscount && this.discountMonth == groupData.discountMonth && this.discountPerm == groupData.discountPerm && this.discountYear == groupData.discountYear && this.sort == groupData.sort && this.sellEmMonth == groupData.sellEmMonth && this.sellMonth == groupData.sellMonth && this.sellYear == groupData.sellYear && this.sellPerm == groupData.sellPerm && this.time == groupData.time && Intrinsics.areEqual(this.purchase, groupData.purchase);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$MSShop(GroupData self, CompositeEncoder output, SerialDescriptor serialDesc) {
        boolean z;
        SerializationStrategy[] serializationStrategyArr = $childSerializers;
        boolean z2 = output.shouldEncodeElementDefault(serialDesc, 0) || self.order != -1;
        if (z2) {
            output.encodeIntElement(serialDesc, 0, self.order);
        }
        boolean z3 = output.shouldEncodeElementDefault(serialDesc, 1) || self.id != -1;
        if (z3) {
            output.encodeIntElement(serialDesc, 1, self.id);
        }
        boolean z4 = output.shouldEncodeElementDefault(serialDesc, 2) || self.groupId != -1;
        if (z4) {
            output.encodeIntElement(serialDesc, 2, self.groupId);
        }
        output.encodeStringElement(serialDesc, 3, self.name);
        boolean z5 = output.shouldEncodeElementDefault(serialDesc, 4) || !Intrinsics.areEqual(self.shortStory, "");
        if (z5) {
            output.encodeStringElement(serialDesc, 4, self.shortStory);
        }
        output.encodeStringElement(serialDesc, 5, self.image);
        boolean z6 = output.shouldEncodeElementDefault(serialDesc, 6) || !Intrinsics.areEqual(self.pexName, "");
        if (z6) {
            output.encodeStringElement(serialDesc, 6, self.pexName);
        }
        boolean z7 = output.shouldEncodeElementDefault(serialDesc, 7) || !Intrinsics.areEqual(self.color, "");
        if (z7) {
            output.encodeStringElement(serialDesc, 7, self.color);
        }
        output.encodeIntElement(serialDesc, 8, self.upgrade);
        output.encodeStringElement(serialDesc, 9, self.desc);
        output.encodeIntElement(serialDesc, 10, self.priceMonth);
        output.encodeIntElement(serialDesc, 11, self.priceEmMonth);
        output.encodeIntElement(serialDesc, 12, self.pricePerm);
        output.encodeIntElement(serialDesc, 13, self.priceYear);
        boolean z8 = output.shouldEncodeElementDefault(serialDesc, 14) || self.priceMonthDiscount != -1;
        if (z8) {
            output.encodeIntElement(serialDesc, 14, self.priceMonthDiscount);
        }
        boolean z9 = output.shouldEncodeElementDefault(serialDesc, 15) || self.pricePermDiscount != -1;
        if (z9) {
            output.encodeIntElement(serialDesc, 15, self.pricePermDiscount);
        }
        boolean z10 = output.shouldEncodeElementDefault(serialDesc, 16) || self.priceYearDiscount != -1;
        if (z10) {
            output.encodeIntElement(serialDesc, 16, self.priceYearDiscount);
        }
        boolean z11 = output.shouldEncodeElementDefault(serialDesc, 17) || self.discountMonth != -1;
        if (z11) {
            output.encodeIntElement(serialDesc, 17, self.discountMonth);
        }
        boolean z12 = output.shouldEncodeElementDefault(serialDesc, 18) || self.discountPerm != -1;
        if (z12) {
            output.encodeIntElement(serialDesc, 18, self.discountPerm);
        }
        boolean z13 = output.shouldEncodeElementDefault(serialDesc, 19) || self.discountYear != -1;
        if (z13) {
            output.encodeIntElement(serialDesc, 19, self.discountYear);
        }
        output.encodeIntElement(serialDesc, 20, self.sort);
        boolean z14 = output.shouldEncodeElementDefault(serialDesc, 21) || self.sellEmMonth;
        if (z14) {
            output.encodeSerializableElement(serialDesc, 21, serializationStrategyArr[21], Boolean.valueOf(self.sellEmMonth));
        }
        boolean z15 = output.shouldEncodeElementDefault(serialDesc, 22) || self.sellMonth;
        if (z15) {
            output.encodeSerializableElement(serialDesc, 22, serializationStrategyArr[22], Boolean.valueOf(self.sellMonth));
        }
        boolean z16 = output.shouldEncodeElementDefault(serialDesc, 23) || self.sellYear;
        if (z16) {
            output.encodeSerializableElement(serialDesc, 23, serializationStrategyArr[23], Boolean.valueOf(self.sellYear));
        }
        boolean z17 = output.shouldEncodeElementDefault(serialDesc, 24) || self.sellPerm;
        if (z17) {
            output.encodeSerializableElement(serialDesc, 24, serializationStrategyArr[24], Boolean.valueOf(self.sellPerm));
        }
        boolean z18 = output.shouldEncodeElementDefault(serialDesc, 25) || self.time != -1;
        if (z18) {
            output.encodeIntElement(serialDesc, 25, self.time);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 26)) {
            z = true;
        } else {
            PurchaseData purchaseData = self.purchase;
            Instant instant = Instant.EPOCH;
            Intrinsics.checkNotNullExpressionValue(instant, "EPOCH");
            z = !Intrinsics.areEqual(purchaseData, new PurchaseData(false, instant));
        }
        if (z) {
            output.encodeSerializableElement(serialDesc, 26, PurchaseData$$serializer.INSTANCE, self.purchase);
        }
    }

    public /* synthetic */ GroupData(int seen0, int order, int id, int groupId, String name, String shortStory, String image, String pexName, String color, int upgrade, String desc, int priceMonth, int priceEmMonth, int pricePerm, int priceYear, int priceMonthDiscount, int pricePermDiscount, int priceYearDiscount, int discountMonth, int discountPerm, int discountYear, int sort, boolean sellEmMonth, boolean sellMonth, boolean sellYear, boolean sellPerm, int time, PurchaseData purchase, SerializationConstructorMarker serializationConstructorMarker) {
        if (1064744 != (1064744 & seen0)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 1064744, GroupData$$serializer.INSTANCE.getDescriptor());
        }
        if ((seen0 & 1) == 0) {
            this.order = -1;
        } else {
            this.order = order;
        }
        if ((seen0 & 2) == 0) {
            this.id = -1;
        } else {
            this.id = id;
        }
        if ((seen0 & 4) == 0) {
            this.groupId = -1;
        } else {
            this.groupId = groupId;
        }
        this.name = name;
        if ((seen0 & 16) == 0) {
            this.shortStory = "";
        } else {
            this.shortStory = shortStory;
        }
        this.image = image;
        if ((seen0 & 64) == 0) {
            this.pexName = "";
        } else {
            this.pexName = pexName;
        }
        if ((seen0 & 128) == 0) {
            this.color = "";
        } else {
            this.color = color;
        }
        this.upgrade = upgrade;
        this.desc = desc;
        this.priceMonth = priceMonth;
        this.priceEmMonth = priceEmMonth;
        this.pricePerm = pricePerm;
        this.priceYear = priceYear;
        if ((seen0 & 16384) == 0) {
            this.priceMonthDiscount = -1;
        } else {
            this.priceMonthDiscount = priceMonthDiscount;
        }
        if ((seen0 & 32768) == 0) {
            this.pricePermDiscount = -1;
        } else {
            this.pricePermDiscount = pricePermDiscount;
        }
        if ((seen0 & 65536) == 0) {
            this.priceYearDiscount = -1;
        } else {
            this.priceYearDiscount = priceYearDiscount;
        }
        if ((seen0 & 131072) == 0) {
            this.discountMonth = -1;
        } else {
            this.discountMonth = discountMonth;
        }
        if ((seen0 & 262144) == 0) {
            this.discountPerm = -1;
        } else {
            this.discountPerm = discountPerm;
        }
        if ((seen0 & 524288) == 0) {
            this.discountYear = -1;
        } else {
            this.discountYear = discountYear;
        }
        this.sort = sort;
        if ((seen0 & 2097152) == 0) {
            this.sellEmMonth = false;
        } else {
            this.sellEmMonth = sellEmMonth;
        }
        if ((seen0 & 4194304) == 0) {
            this.sellMonth = false;
        } else {
            this.sellMonth = sellMonth;
        }
        if ((seen0 & 8388608) == 0) {
            this.sellYear = false;
        } else {
            this.sellYear = sellYear;
        }
        if ((seen0 & 16777216) == 0) {
            this.sellPerm = false;
        } else {
            this.sellPerm = sellPerm;
        }
        if ((seen0 & 33554432) == 0) {
            this.time = -1;
        } else {
            this.time = time;
        }
        if ((seen0 & 67108864) == 0) {
            Instant instant = Instant.EPOCH;
            Intrinsics.checkNotNullExpressionValue(instant, "EPOCH");
            this.purchase = new PurchaseData(false, instant);
        } else {
            this.purchase = purchase;
        }
        this.prettyName = LazyKt.lazy(() -> {
            return _init_$lambda$1(r1);
        });
    }

    public GroupData(int order, int id, int groupId, @NotNull String name, @NotNull String shortStory, @NotNull String image, @NotNull String pexName, @NotNull String color, int upgrade, @NotNull String desc, int priceMonth, int priceEmMonth, int pricePerm, int priceYear, int priceMonthDiscount, int pricePermDiscount, int priceYearDiscount, int discountMonth, int discountPerm, int discountYear, int sort, boolean sellEmMonth, boolean sellMonth, boolean sellYear, boolean sellPerm, int time, @NotNull PurchaseData purchase) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(shortStory, "shortStory");
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(pexName, "pexName");
        Intrinsics.checkNotNullParameter(color, "color");
        Intrinsics.checkNotNullParameter(desc, "desc");
        Intrinsics.checkNotNullParameter(purchase, "purchase");
        this.order = order;
        this.id = id;
        this.groupId = groupId;
        this.name = name;
        this.shortStory = shortStory;
        this.image = image;
        this.pexName = pexName;
        this.color = color;
        this.upgrade = upgrade;
        this.desc = desc;
        this.priceMonth = priceMonth;
        this.priceEmMonth = priceEmMonth;
        this.pricePerm = pricePerm;
        this.priceYear = priceYear;
        this.priceMonthDiscount = priceMonthDiscount;
        this.pricePermDiscount = pricePermDiscount;
        this.priceYearDiscount = priceYearDiscount;
        this.discountMonth = discountMonth;
        this.discountPerm = discountPerm;
        this.discountYear = discountYear;
        this.sort = sort;
        this.sellEmMonth = sellEmMonth;
        this.sellMonth = sellMonth;
        this.sellYear = sellYear;
        this.sellPerm = sellPerm;
        this.time = time;
        this.purchase = purchase;
        this.prettyName = LazyKt.lazy(() -> {
            return prettyName_delegate$lambda$0(r1);
        });
    }

    public /* synthetic */ GroupData(int i, int i2, int i3, String str, String str2, String str3, String str4, String str5, int i4, String str6, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, boolean z, boolean z2, boolean z3, boolean z4, int i16, PurchaseData purchaseData, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        i = (i17 & 1) != 0 ? -1 : i;
        i2 = (i17 & 2) != 0 ? -1 : i2;
        i3 = (i17 & 4) != 0 ? -1 : i3;
        str2 = (i17 & 16) != 0 ? "" : str2;
        str4 = (i17 & 64) != 0 ? "" : str4;
        str5 = (i17 & 128) != 0 ? "" : str5;
        i9 = (i17 & 16384) != 0 ? -1 : i9;
        i10 = (i17 & 32768) != 0 ? -1 : i10;
        i11 = (i17 & 65536) != 0 ? -1 : i11;
        i12 = (i17 & 131072) != 0 ? -1 : i12;
        i13 = (i17 & 262144) != 0 ? -1 : i13;
        i14 = (i17 & 524288) != 0 ? -1 : i14;
        z = (i17 & 2097152) != 0 ? false : z;
        z2 = (i17 & 4194304) != 0 ? false : z2;
        z3 = (i17 & 8388608) != 0 ? false : z3;
        z4 = (i17 & 16777216) != 0 ? false : z4;
        i16 = (i17 & 33554432) != 0 ? -1 : i16;
        if ((i17 & 67108864) != 0) {
            Instant instant = Instant.EPOCH;
            Intrinsics.checkNotNullExpressionValue(instant, "EPOCH");
            purchaseData = new PurchaseData(false, instant);
        }
        this(i, i2, i3, str, str2, str3, str4, str5, i4, str6, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, z, z2, z3, z4, i16, purchaseData);
    }

    public final int getOrder() {
        return this.order;
    }

    public final int getId() {
        return this.id;
    }

    public final int getGroupId() {
        return this.groupId;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getShortStory() {
        return this.shortStory;
    }

    @NotNull
    public final String getImage() {
        return this.image;
    }

    @NotNull
    public final String getPexName() {
        return this.pexName;
    }

    @NotNull
    public final String getColor() {
        return this.color;
    }

    public final int getUpgrade() {
        return this.upgrade;
    }

    @NotNull
    public final String getDesc() {
        return this.desc;
    }

    public final int getPriceMonth() {
        return this.priceMonth;
    }

    public final int getPriceEmMonth() {
        return this.priceEmMonth;
    }

    public final int getPricePerm() {
        return this.pricePerm;
    }

    public final int getPriceYear() {
        return this.priceYear;
    }

    public final int getPriceMonthDiscount() {
        return this.priceMonthDiscount;
    }

    public final int getPricePermDiscount() {
        return this.pricePermDiscount;
    }

    public final int getPriceYearDiscount() {
        return this.priceYearDiscount;
    }

    public final int getDiscountMonth() {
        return this.discountMonth;
    }

    public final int getDiscountPerm() {
        return this.discountPerm;
    }

    public final int getDiscountYear() {
        return this.discountYear;
    }

    public final int getSort() {
        return this.sort;
    }

    public final boolean getSellEmMonth() {
        return this.sellEmMonth;
    }

    public final boolean getSellMonth() {
        return this.sellMonth;
    }

    public final boolean getSellYear() {
        return this.sellYear;
    }

    public final boolean getSellPerm() {
        return this.sellPerm;
    }

    public final int getTime() {
        return this.time;
    }

    @NotNull
    public final PurchaseData getPurchase() {
        return this.purchase;
    }

    /* JADX INFO: compiled from: GroupData.kt */
    /* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/common/response/shop/GroupData$Companion.class */
    @Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\rRS\u0010\u0004\u001aB\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\b0\b \u0007* \u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\b0\b\u0018\u00010\u00050\u0005¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lnet/mcskill/shop/common/response/shop/GroupData$Companion;", "", "<init>", "()V", "CODEC", "Lnet/minecraft/network/codec/StreamCodec;", "Lnet/minecraft/network/FriendlyByteBuf;", "kotlin.jvm.PlatformType", "Lnet/mcskill/shop/common/response/shop/GroupData;", "getCODEC", "()Lnet/minecraft/network/codec/StreamCodec;", "Lnet/minecraft/network/codec/StreamCodec;", "serializer", "Lkotlinx/serialization/KSerializer;", "MSShop"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final KSerializer<GroupData> serializer() {
            return GroupData$$serializer.INSTANCE;
        }

        public final StreamCodec<FriendlyByteBuf, GroupData> getCODEC() {
            return GroupData.CODEC;
        }
    }

    @NotNull
    public final String getPrettyName() {
        return (String) this.prettyName.getValue();
    }

    private static final String prettyName_delegate$lambda$0(GroupData this$0) {
        int prefixIndex = StringsKt.indexOf$default(this$0.name, ']', 0, false, 6, (Object) null) + 1;
        String str = this$0.color;
        String strSubstring = this$0.name.substring(0, prefixIndex);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        String strSubstring2 = this$0.name.substring(prefixIndex);
        Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
        return "&l" + str + strSubstring + "&r&l" + strSubstring2;
    }

    private static final String _init_$lambda$1(GroupData this$0) {
        int prefixIndex = StringsKt.indexOf$default(this$0.name, ']', 0, false, 6, (Object) null) + 1;
        String str = this$0.color;
        String strSubstring = this$0.name.substring(0, prefixIndex);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        String strSubstring2 = this$0.name.substring(prefixIndex);
        Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
        return "&l" + str + strSubstring + "&r&l" + strSubstring2;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public GroupData(@NotNull FriendlyByteBuf buf) {
        Intrinsics.checkNotNullParameter(buf, "buf");
        int i = buf.readInt();
        int i2 = buf.readInt();
        int i3 = buf.readInt();
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
        int i4 = buf.readInt();
        String utf6 = buf.readUtf();
        Intrinsics.checkNotNullExpressionValue(utf6, "readUtf(...)");
        this(i, i2, i3, utf, utf2, utf3, utf4, utf5, i4, utf6, buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readShort(), buf.readBoolean(), buf.readBoolean(), buf.readBoolean(), buf.readBoolean(), buf.readInt(), new PurchaseData(buf));
    }

    public void serialize(@NotNull FriendlyByteBuf buf) {
        Intrinsics.checkNotNullParameter(buf, "buf");
        buf.writeInt(this.order);
        buf.writeInt(this.id);
        buf.writeInt(this.groupId);
        buf.writeUtf(FormattingCode.Companion.cleanupTags(this.name));
        buf.writeUtf(this.shortStory);
        buf.writeUtf(this.image);
        buf.writeUtf(this.pexName);
        buf.writeUtf(this.color);
        buf.writeInt(this.upgrade);
        buf.writeUtf(this.desc);
        buf.writeInt(this.priceMonth);
        buf.writeInt(this.priceEmMonth);
        buf.writeInt(this.pricePerm);
        buf.writeInt(this.priceYear);
        buf.writeInt(this.priceMonthDiscount);
        buf.writeInt(this.pricePermDiscount);
        buf.writeInt(this.priceYearDiscount);
        buf.writeInt(this.discountMonth);
        buf.writeInt(this.discountPerm);
        buf.writeInt(this.discountYear);
        buf.writeShort(this.sort);
        buf.writeBoolean(this.sellEmMonth);
        buf.writeBoolean(this.sellMonth);
        buf.writeBoolean(this.sellYear);
        buf.writeBoolean(this.sellPerm);
        buf.writeInt(this.time);
        this.purchase.serialize(buf);
    }
}
