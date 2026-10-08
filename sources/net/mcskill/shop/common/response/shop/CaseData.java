package net.mcskill.shop.common.response.shop;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
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
import kotlinx.serialization.Transient;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import net.mcskill.core.common.json.serializer.BoolAsIntSerializer;
import net.mcskill.core.common.network.ByteBufferSerializer;
import net.mcskill.shop.common.response.DustData;
import net.mcskill.shop.common.response.DustData$$serializer;
import net.mcskill.shop.common.response.TypeData;
import net.mcskill.shop.common.response.TypeData$$serializer;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CaseData.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/common/response/shop/CaseData.class */
@Serializable
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b4\n\u0002\u0010\u0002\n\u0002\b\u0018\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 }2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002}~BÏ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0016\u001a\u00020\f\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u001a\u0012\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c¢\u0006\u0004\b\u001e\u0010\u001fB\u0011\b\u0016\u0012\u0006\u0010 \u001a\u00020!¢\u0006\u0004\b\u001e\u0010\"B×\u0001\b\u0010\u0012\u0006\u0010#\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000e\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\f\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c\u0012\b\u0010$\u001a\u0004\u0018\u00010%¢\u0006\u0004\b\u001e\u0010&J\u0010\u0010Y\u001a\u00020Z2\u0006\u0010 \u001a\u00020!H\u0016J\t\u0010[\u001a\u00020\u0003HÆ\u0003J\t\u0010\\\u001a\u00020\u0005HÆ\u0003J\t\u0010]\u001a\u00020\u0005HÆ\u0003J\t\u0010^\u001a\u00020\bHÆ\u0003J\t\u0010_\u001a\u00020\u0003HÆ\u0003J\t\u0010`\u001a\u00020\u0003HÆ\u0003J\t\u0010a\u001a\u00020\fHÆ\u0003J\t\u0010b\u001a\u00020\u0005HÆ\u0003J\t\u0010c\u001a\u00020\fHÆ\u0003J\t\u0010d\u001a\u00020\u0003HÆ\u0003J\t\u0010e\u001a\u00020\u0003HÆ\u0003J\t\u0010f\u001a\u00020\u0003HÆ\u0003J\t\u0010g\u001a\u00020\u0003HÆ\u0003J\t\u0010h\u001a\u00020\u0003HÆ\u0003J\t\u0010i\u001a\u00020\u0003HÆ\u0003J\t\u0010j\u001a\u00020\u0003HÆ\u0003J\t\u0010k\u001a\u00020\fHÆ\u0003J\t\u0010l\u001a\u00020\u0003HÆ\u0003J\t\u0010m\u001a\u00020\u0005HÆ\u0003J\t\u0010n\u001a\u00020\u001aHÆ\u0003J\u000f\u0010o\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cHÆ\u0003Já\u0001\u0010p\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\f2\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cHÆ\u0001J\u0013\u0010q\u001a\u00020\f2\b\u0010r\u001a\u0004\u0018\u00010sHÖ\u0003J\t\u0010t\u001a\u00020\u0003HÖ\u0001J\t\u0010u\u001a\u00020\u0005HÖ\u0001J%\u0010v\u001a\u00020Z2\u0006\u0010w\u001a\u00020\u00002\u0006\u0010x\u001a\u00020y2\u0006\u0010z\u001a\u00020{H\u0001¢\u0006\u0002\b|R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u001c\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b+\u0010,\u001a\u0004\b-\u0010*R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010(R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010(R\u001c\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b2\u0010,\u001a\u0004\b3\u00104R\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b5\u0010*R\u001c\u0010\u000e\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b6\u0010,\u001a\u0004\b7\u00104R\u001a\u0010\u000f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010(\"\u0004\b9\u0010:R\u001c\u0010\u0010\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b;\u0010,\u001a\u0004\b<\u0010(R\u001c\u0010\u0011\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b=\u0010,\u001a\u0004\b>\u0010(R$\u0010\u0012\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b?\u0010,\u001a\u0004\b@\u0010(\"\u0004\bA\u0010:R$\u0010\u0013\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bB\u0010,\u001a\u0004\bC\u0010(\"\u0004\bD\u0010:R\u001c\u0010\u0014\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bE\u0010,\u001a\u0004\bF\u0010(R\u001c\u0010\u0015\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bG\u0010,\u001a\u0004\bH\u0010(R\u001c\u0010\u0016\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bI\u0010,\u001a\u0004\bJ\u00104R\u001c\u0010\u0017\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bK\u0010,\u001a\u0004\bL\u0010(R\u001c\u0010\u0018\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bM\u0010,\u001a\u0004\bN\u0010*R\u001a\u0010\u0019\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c¢\u0006\b\n\u0000\u001a\u0004\bS\u0010TR\u001c\u0010U\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bV\u0010,\u001a\u0004\bU\u00104R\u001c\u0010W\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bX\u0010,\u001a\u0004\bW\u00104¨\u0006\u007f"}, d2 = {"Lnet/mcskill/shop/common/response/shop/CaseData;", "Lnet/mcskill/core/common/network/ByteBufferSerializer;", "id", "", "name", "", "image", "type", "Lnet/mcskill/shop/common/response/TypeData;", "sort", "price", "test", "", "url", "enabled", "amount", "guarantyFirstLimit", "guarantySecondLimit", "guarantyFirstProgress", "guarantySecondProgress", "guarantyFirstChance", "guarantySecondChance", "hasDust", "dustType", "dustItem", "dustData", "Lnet/mcskill/shop/common/response/DustData;", "items", "", "Lnet/mcskill/shop/common/response/shop/CaseItemData;", "<init>", "(ILjava/lang/String;Ljava/lang/String;Lnet/mcskill/shop/common/response/TypeData;IIZLjava/lang/String;ZIIIIIIIZILjava/lang/String;Lnet/mcskill/shop/common/response/DustData;Ljava/util/List;)V", "buf", "Lnet/minecraft/network/FriendlyByteBuf;", "(Lnet/minecraft/network/FriendlyByteBuf;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILjava/lang/String;Ljava/lang/String;Lnet/mcskill/shop/common/response/TypeData;IIZLjava/lang/String;ZIIIIIIIZILjava/lang/String;Lnet/mcskill/shop/common/response/DustData;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId", "()I", "getName", "()Ljava/lang/String;", "getImage$annotations", "()V", "getImage", "getType", "()Lnet/mcskill/shop/common/response/TypeData;", "getSort", "getPrice", "getTest$annotations", "getTest", "()Z", "getUrl", "getEnabled$annotations", "getEnabled", "getAmount", "setAmount", "(I)V", "getGuarantyFirstLimit$annotations", "getGuarantyFirstLimit", "getGuarantySecondLimit$annotations", "getGuarantySecondLimit", "getGuarantyFirstProgress$annotations", "getGuarantyFirstProgress", "setGuarantyFirstProgress", "getGuarantySecondProgress$annotations", "getGuarantySecondProgress", "setGuarantySecondProgress", "getGuarantyFirstChance$annotations", "getGuarantyFirstChance", "getGuarantySecondChance$annotations", "getGuarantySecondChance", "getHasDust$annotations", "getHasDust", "getDustType$annotations", "getDustType", "getDustItem$annotations", "getDustItem", "getDustData", "()Lnet/mcskill/shop/common/response/DustData;", "setDustData", "(Lnet/mcskill/shop/common/response/DustData;)V", "getItems", "()Ljava/util/List;", "isGuarantFirstActive", "isGuarantFirstActive$annotations", "isGuarantSecondActive", "isGuarantSecondActive$annotations", "serialize", "", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "copy", "equals", "other", "", "hashCode", "toString", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$MSShop", "Companion", "$serializer", "MSShop"})
public final /* data */ class CaseData implements ByteBufferSerializer<CaseData> {
    private final int id;

    @NotNull
    private final String name;

    @NotNull
    private final String image;

    @NotNull
    private final TypeData type;
    private final int sort;
    private final int price;
    private final boolean test;

    @NotNull
    private final String url;
    private final boolean enabled;
    private int amount;
    private final int guarantyFirstLimit;
    private final int guarantySecondLimit;
    private int guarantyFirstProgress;
    private int guarantySecondProgress;
    private final int guarantyFirstChance;
    private final int guarantySecondChance;
    private final boolean hasDust;
    private final int dustType;

    @NotNull
    private final String dustItem;

    @NotNull
    private DustData dustData;

    @NotNull
    private final List<CaseItemData> items;
    private final boolean isGuarantFirstActive;
    private final boolean isGuarantSecondActive;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @JvmField
    @NotNull
    private static final KSerializer<Object>[] $childSerializers = {null, null, null, null, null, null, new BoolAsIntSerializer(), null, new BoolAsIntSerializer(), null, null, null, null, null, null, null, new BoolAsIntSerializer(), null, null, null, new ArrayListSerializer(CaseItemData$$serializer.INSTANCE)};
    private static final StreamCodec<FriendlyByteBuf, CaseData> CODEC = StreamCodec.ofMember((v0, v1) -> {
        v0.serialize(v1);
    }, CaseData::new);

    @SerialName("img")
    public static /* synthetic */ void getImage$annotations() {
    }

    @Serializable(with = BoolAsIntSerializer.class)
    public static /* synthetic */ void getTest$annotations() {
    }

    @Serializable(with = BoolAsIntSerializer.class)
    public static /* synthetic */ void getEnabled$annotations() {
    }

    @SerialName("guarant1_limit")
    public static /* synthetic */ void getGuarantyFirstLimit$annotations() {
    }

    @SerialName("guarant2_limit")
    public static /* synthetic */ void getGuarantySecondLimit$annotations() {
    }

    @SerialName("guarant1_progress")
    public static /* synthetic */ void getGuarantyFirstProgress$annotations() {
    }

    @SerialName("guarant2_progress")
    public static /* synthetic */ void getGuarantySecondProgress$annotations() {
    }

    @SerialName("guarant1_chance")
    public static /* synthetic */ void getGuarantyFirstChance$annotations() {
    }

    @SerialName("guarant2_chance")
    public static /* synthetic */ void getGuarantySecondChance$annotations() {
    }

    @SerialName("dust")
    @Serializable(with = BoolAsIntSerializer.class)
    public static /* synthetic */ void getHasDust$annotations() {
    }

    @SerialName("dust_type")
    public static /* synthetic */ void getDustType$annotations() {
    }

    @SerialName("bonus_items")
    public static /* synthetic */ void getDustItem$annotations() {
    }

    @Transient
    public static /* synthetic */ void isGuarantFirstActive$annotations() {
    }

    @Transient
    public static /* synthetic */ void isGuarantSecondActive$annotations() {
    }

    public final int component1() {
        return this.id;
    }

    @NotNull
    public final String component2() {
        return this.name;
    }

    @NotNull
    public final String component3() {
        return this.image;
    }

    @NotNull
    public final TypeData component4() {
        return this.type;
    }

    public final int component5() {
        return this.sort;
    }

    public final int component6() {
        return this.price;
    }

    public final boolean component7() {
        return this.test;
    }

    @NotNull
    public final String component8() {
        return this.url;
    }

    public final boolean component9() {
        return this.enabled;
    }

    public final int component10() {
        return this.amount;
    }

    public final int component11() {
        return this.guarantyFirstLimit;
    }

    public final int component12() {
        return this.guarantySecondLimit;
    }

    public final int component13() {
        return this.guarantyFirstProgress;
    }

    public final int component14() {
        return this.guarantySecondProgress;
    }

    public final int component15() {
        return this.guarantyFirstChance;
    }

    public final int component16() {
        return this.guarantySecondChance;
    }

    public final boolean component17() {
        return this.hasDust;
    }

    public final int component18() {
        return this.dustType;
    }

    @NotNull
    public final String component19() {
        return this.dustItem;
    }

    @NotNull
    public final DustData component20() {
        return this.dustData;
    }

    @NotNull
    public final List<CaseItemData> component21() {
        return this.items;
    }

    @NotNull
    public final CaseData copy(int id, @NotNull String name, @NotNull String image, @NotNull TypeData type, int sort, int price, boolean test, @NotNull String url, boolean enabled, int amount, int guarantyFirstLimit, int guarantySecondLimit, int guarantyFirstProgress, int guarantySecondProgress, int guarantyFirstChance, int guarantySecondChance, boolean hasDust, int dustType, @NotNull String dustItem, @NotNull DustData dustData, @NotNull List<CaseItemData> items) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(dustItem, "dustItem");
        Intrinsics.checkNotNullParameter(dustData, "dustData");
        Intrinsics.checkNotNullParameter(items, "items");
        return new CaseData(id, name, image, type, sort, price, test, url, enabled, amount, guarantyFirstLimit, guarantySecondLimit, guarantyFirstProgress, guarantySecondProgress, guarantyFirstChance, guarantySecondChance, hasDust, dustType, dustItem, dustData, items);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CaseData copy$default(CaseData caseData, int i, String str, String str2, TypeData typeData, int i2, int i3, boolean z, String str3, boolean z2, int i4, int i5, int i6, int i7, int i8, int i9, int i10, boolean z3, int i11, String str4, DustData dustData, List list, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i = caseData.id;
        }
        if ((i12 & 2) != 0) {
            str = caseData.name;
        }
        if ((i12 & 4) != 0) {
            str2 = caseData.image;
        }
        if ((i12 & 8) != 0) {
            typeData = caseData.type;
        }
        if ((i12 & 16) != 0) {
            i2 = caseData.sort;
        }
        if ((i12 & 32) != 0) {
            i3 = caseData.price;
        }
        if ((i12 & 64) != 0) {
            z = caseData.test;
        }
        if ((i12 & 128) != 0) {
            str3 = caseData.url;
        }
        if ((i12 & 256) != 0) {
            z2 = caseData.enabled;
        }
        if ((i12 & 512) != 0) {
            i4 = caseData.amount;
        }
        if ((i12 & 1024) != 0) {
            i5 = caseData.guarantyFirstLimit;
        }
        if ((i12 & 2048) != 0) {
            i6 = caseData.guarantySecondLimit;
        }
        if ((i12 & 4096) != 0) {
            i7 = caseData.guarantyFirstProgress;
        }
        if ((i12 & 8192) != 0) {
            i8 = caseData.guarantySecondProgress;
        }
        if ((i12 & 16384) != 0) {
            i9 = caseData.guarantyFirstChance;
        }
        if ((i12 & 32768) != 0) {
            i10 = caseData.guarantySecondChance;
        }
        if ((i12 & 65536) != 0) {
            z3 = caseData.hasDust;
        }
        if ((i12 & 131072) != 0) {
            i11 = caseData.dustType;
        }
        if ((i12 & 262144) != 0) {
            str4 = caseData.dustItem;
        }
        if ((i12 & 524288) != 0) {
            dustData = caseData.dustData;
        }
        if ((i12 & 1048576) != 0) {
            list = caseData.items;
        }
        return caseData.copy(i, str, str2, typeData, i2, i3, z, str3, z2, i4, i5, i6, i7, i8, i9, i10, z3, i11, str4, dustData, list);
    }

    @NotNull
    public String toString() {
        return "CaseData(id=" + this.id + ", name=" + this.name + ", image=" + this.image + ", type=" + this.type + ", sort=" + this.sort + ", price=" + this.price + ", test=" + this.test + ", url=" + this.url + ", enabled=" + this.enabled + ", amount=" + this.amount + ", guarantyFirstLimit=" + this.guarantyFirstLimit + ", guarantySecondLimit=" + this.guarantySecondLimit + ", guarantyFirstProgress=" + this.guarantyFirstProgress + ", guarantySecondProgress=" + this.guarantySecondProgress + ", guarantyFirstChance=" + this.guarantyFirstChance + ", guarantySecondChance=" + this.guarantySecondChance + ", hasDust=" + this.hasDust + ", dustType=" + this.dustType + ", dustItem=" + this.dustItem + ", dustData=" + this.dustData + ", items=" + this.items + ")";
    }

    public int hashCode() {
        int result = Integer.hashCode(this.id);
        return (((((((((((((((((((((((((((((((((((((((result * 31) + this.name.hashCode()) * 31) + this.image.hashCode()) * 31) + this.type.hashCode()) * 31) + Integer.hashCode(this.sort)) * 31) + Integer.hashCode(this.price)) * 31) + Boolean.hashCode(this.test)) * 31) + this.url.hashCode()) * 31) + Boolean.hashCode(this.enabled)) * 31) + Integer.hashCode(this.amount)) * 31) + Integer.hashCode(this.guarantyFirstLimit)) * 31) + Integer.hashCode(this.guarantySecondLimit)) * 31) + Integer.hashCode(this.guarantyFirstProgress)) * 31) + Integer.hashCode(this.guarantySecondProgress)) * 31) + Integer.hashCode(this.guarantyFirstChance)) * 31) + Integer.hashCode(this.guarantySecondChance)) * 31) + Boolean.hashCode(this.hasDust)) * 31) + Integer.hashCode(this.dustType)) * 31) + this.dustItem.hashCode()) * 31) + this.dustData.hashCode()) * 31) + this.items.hashCode();
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CaseData)) {
            return false;
        }
        CaseData caseData = (CaseData) other;
        return this.id == caseData.id && Intrinsics.areEqual(this.name, caseData.name) && Intrinsics.areEqual(this.image, caseData.image) && Intrinsics.areEqual(this.type, caseData.type) && this.sort == caseData.sort && this.price == caseData.price && this.test == caseData.test && Intrinsics.areEqual(this.url, caseData.url) && this.enabled == caseData.enabled && this.amount == caseData.amount && this.guarantyFirstLimit == caseData.guarantyFirstLimit && this.guarantySecondLimit == caseData.guarantySecondLimit && this.guarantyFirstProgress == caseData.guarantyFirstProgress && this.guarantySecondProgress == caseData.guarantySecondProgress && this.guarantyFirstChance == caseData.guarantyFirstChance && this.guarantySecondChance == caseData.guarantySecondChance && this.hasDust == caseData.hasDust && this.dustType == caseData.dustType && Intrinsics.areEqual(this.dustItem, caseData.dustItem) && Intrinsics.areEqual(this.dustData, caseData.dustData) && Intrinsics.areEqual(this.items, caseData.items);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$MSShop(CaseData self, CompositeEncoder output, SerialDescriptor serialDesc) {
        SerializationStrategy[] serializationStrategyArr = $childSerializers;
        output.encodeIntElement(serialDesc, 0, self.id);
        output.encodeStringElement(serialDesc, 1, self.name);
        output.encodeStringElement(serialDesc, 2, self.image);
        output.encodeSerializableElement(serialDesc, 3, TypeData$$serializer.INSTANCE, self.type);
        output.encodeIntElement(serialDesc, 4, self.sort);
        output.encodeIntElement(serialDesc, 5, self.price);
        boolean z = output.shouldEncodeElementDefault(serialDesc, 6) || self.test;
        if (z) {
            output.encodeSerializableElement(serialDesc, 6, serializationStrategyArr[6], Boolean.valueOf(self.test));
        }
        output.encodeStringElement(serialDesc, 7, self.url);
        output.encodeSerializableElement(serialDesc, 8, serializationStrategyArr[8], Boolean.valueOf(self.enabled));
        boolean z2 = output.shouldEncodeElementDefault(serialDesc, 9) || self.amount != 0;
        if (z2) {
            output.encodeIntElement(serialDesc, 9, self.amount);
        }
        boolean z3 = output.shouldEncodeElementDefault(serialDesc, 10) || self.guarantyFirstLimit != 0;
        if (z3) {
            output.encodeIntElement(serialDesc, 10, self.guarantyFirstLimit);
        }
        boolean z4 = output.shouldEncodeElementDefault(serialDesc, 11) || self.guarantySecondLimit != 0;
        if (z4) {
            output.encodeIntElement(serialDesc, 11, self.guarantySecondLimit);
        }
        boolean z5 = output.shouldEncodeElementDefault(serialDesc, 12) || self.guarantyFirstProgress != 0;
        if (z5) {
            output.encodeIntElement(serialDesc, 12, self.guarantyFirstProgress);
        }
        boolean z6 = output.shouldEncodeElementDefault(serialDesc, 13) || self.guarantySecondProgress != 0;
        if (z6) {
            output.encodeIntElement(serialDesc, 13, self.guarantySecondProgress);
        }
        boolean z7 = output.shouldEncodeElementDefault(serialDesc, 14) || self.guarantyFirstChance != 0;
        if (z7) {
            output.encodeIntElement(serialDesc, 14, self.guarantyFirstChance);
        }
        boolean z8 = output.shouldEncodeElementDefault(serialDesc, 15) || self.guarantySecondChance != 0;
        if (z8) {
            output.encodeIntElement(serialDesc, 15, self.guarantySecondChance);
        }
        boolean z9 = output.shouldEncodeElementDefault(serialDesc, 16) || self.hasDust;
        if (z9) {
            output.encodeSerializableElement(serialDesc, 16, serializationStrategyArr[16], Boolean.valueOf(self.hasDust));
        }
        boolean z10 = output.shouldEncodeElementDefault(serialDesc, 17) || self.dustType != 0;
        if (z10) {
            output.encodeIntElement(serialDesc, 17, self.dustType);
        }
        boolean z11 = output.shouldEncodeElementDefault(serialDesc, 18) || !Intrinsics.areEqual(self.dustItem, "");
        if (z11) {
            output.encodeStringElement(serialDesc, 18, self.dustItem);
        }
        boolean z12 = output.shouldEncodeElementDefault(serialDesc, 19) || !Intrinsics.areEqual(self.dustData, DustData.INSTANCE.getEMPTY());
        if (z12) {
            output.encodeSerializableElement(serialDesc, 19, DustData$$serializer.INSTANCE, self.dustData);
        }
        boolean z13 = output.shouldEncodeElementDefault(serialDesc, 20) || !Intrinsics.areEqual(self.items, new ArrayList());
        if (z13) {
            output.encodeSerializableElement(serialDesc, 20, serializationStrategyArr[20], self.items);
        }
    }

    public /* synthetic */ CaseData(int seen0, int id, String name, String image, TypeData type, int sort, int price, boolean test, String url, boolean enabled, int amount, int guarantyFirstLimit, int guarantySecondLimit, int guarantyFirstProgress, int guarantySecondProgress, int guarantyFirstChance, int guarantySecondChance, boolean hasDust, int dustType, String dustItem, DustData dustData, List items, SerializationConstructorMarker serializationConstructorMarker) {
        if (447 != (447 & seen0)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 447, CaseData$$serializer.INSTANCE.getDescriptor());
        }
        this.id = id;
        this.name = name;
        this.image = image;
        this.type = type;
        this.sort = sort;
        this.price = price;
        if ((seen0 & 64) == 0) {
            this.test = false;
        } else {
            this.test = test;
        }
        this.url = url;
        this.enabled = enabled;
        if ((seen0 & 512) == 0) {
            this.amount = 0;
        } else {
            this.amount = amount;
        }
        if ((seen0 & 1024) == 0) {
            this.guarantyFirstLimit = 0;
        } else {
            this.guarantyFirstLimit = guarantyFirstLimit;
        }
        if ((seen0 & 2048) == 0) {
            this.guarantySecondLimit = 0;
        } else {
            this.guarantySecondLimit = guarantySecondLimit;
        }
        if ((seen0 & 4096) == 0) {
            this.guarantyFirstProgress = 0;
        } else {
            this.guarantyFirstProgress = guarantyFirstProgress;
        }
        if ((seen0 & 8192) == 0) {
            this.guarantySecondProgress = 0;
        } else {
            this.guarantySecondProgress = guarantySecondProgress;
        }
        if ((seen0 & 16384) == 0) {
            this.guarantyFirstChance = 0;
        } else {
            this.guarantyFirstChance = guarantyFirstChance;
        }
        if ((seen0 & 32768) == 0) {
            this.guarantySecondChance = 0;
        } else {
            this.guarantySecondChance = guarantySecondChance;
        }
        if ((seen0 & 65536) == 0) {
            this.hasDust = false;
        } else {
            this.hasDust = hasDust;
        }
        if ((seen0 & 131072) == 0) {
            this.dustType = 0;
        } else {
            this.dustType = dustType;
        }
        if ((seen0 & 262144) == 0) {
            this.dustItem = "";
        } else {
            this.dustItem = dustItem;
        }
        if ((seen0 & 524288) == 0) {
            this.dustData = DustData.INSTANCE.getEMPTY();
        } else {
            this.dustData = dustData;
        }
        if ((seen0 & 1048576) == 0) {
            this.items = new ArrayList();
        } else {
            this.items = items;
        }
        this.isGuarantFirstActive = this.guarantyFirstLimit > 0 && this.guarantyFirstChance > 0;
        this.isGuarantSecondActive = this.guarantySecondLimit > 0 && this.guarantySecondChance > 0;
    }

    public CaseData(int id, @NotNull String name, @NotNull String image, @NotNull TypeData type, int sort, int price, boolean test, @NotNull String url, boolean enabled, int amount, int guarantyFirstLimit, int guarantySecondLimit, int guarantyFirstProgress, int guarantySecondProgress, int guarantyFirstChance, int guarantySecondChance, boolean hasDust, int dustType, @NotNull String dustItem, @NotNull DustData dustData, @NotNull List<CaseItemData> list) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(dustItem, "dustItem");
        Intrinsics.checkNotNullParameter(dustData, "dustData");
        Intrinsics.checkNotNullParameter(list, "items");
        this.id = id;
        this.name = name;
        this.image = image;
        this.type = type;
        this.sort = sort;
        this.price = price;
        this.test = test;
        this.url = url;
        this.enabled = enabled;
        this.amount = amount;
        this.guarantyFirstLimit = guarantyFirstLimit;
        this.guarantySecondLimit = guarantySecondLimit;
        this.guarantyFirstProgress = guarantyFirstProgress;
        this.guarantySecondProgress = guarantySecondProgress;
        this.guarantyFirstChance = guarantyFirstChance;
        this.guarantySecondChance = guarantySecondChance;
        this.hasDust = hasDust;
        this.dustType = dustType;
        this.dustItem = dustItem;
        this.dustData = dustData;
        this.items = list;
        this.isGuarantFirstActive = this.guarantyFirstLimit > 0 && this.guarantyFirstChance > 0;
        this.isGuarantSecondActive = this.guarantySecondLimit > 0 && this.guarantySecondChance > 0;
    }

    public /* synthetic */ CaseData(int i, String str, String str2, TypeData typeData, int i2, int i3, boolean z, String str3, boolean z2, int i4, int i5, int i6, int i7, int i8, int i9, int i10, boolean z3, int i11, String str4, DustData dustData, List list, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, str2, typeData, i2, i3, (i12 & 64) != 0 ? false : z, str3, z2, (i12 & 512) != 0 ? 0 : i4, (i12 & 1024) != 0 ? 0 : i5, (i12 & 2048) != 0 ? 0 : i6, (i12 & 4096) != 0 ? 0 : i7, (i12 & 8192) != 0 ? 0 : i8, (i12 & 16384) != 0 ? 0 : i9, (i12 & 32768) != 0 ? 0 : i10, (i12 & 65536) != 0 ? false : z3, (i12 & 131072) != 0 ? 0 : i11, (i12 & 262144) != 0 ? "" : str4, (i12 & 524288) != 0 ? DustData.INSTANCE.getEMPTY() : dustData, (i12 & 1048576) != 0 ? new ArrayList() : list);
    }

    public final int getId() {
        return this.id;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getImage() {
        return this.image;
    }

    @NotNull
    public final TypeData getType() {
        return this.type;
    }

    public final int getSort() {
        return this.sort;
    }

    public final int getPrice() {
        return this.price;
    }

    public final boolean getTest() {
        return this.test;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final int getAmount() {
        return this.amount;
    }

    public final void setAmount(int i) {
        this.amount = i;
    }

    public final int getGuarantyFirstLimit() {
        return this.guarantyFirstLimit;
    }

    public final int getGuarantySecondLimit() {
        return this.guarantySecondLimit;
    }

    public final int getGuarantyFirstProgress() {
        return this.guarantyFirstProgress;
    }

    public final void setGuarantyFirstProgress(int i) {
        this.guarantyFirstProgress = i;
    }

    public final int getGuarantySecondProgress() {
        return this.guarantySecondProgress;
    }

    public final void setGuarantySecondProgress(int i) {
        this.guarantySecondProgress = i;
    }

    public final int getGuarantyFirstChance() {
        return this.guarantyFirstChance;
    }

    public final int getGuarantySecondChance() {
        return this.guarantySecondChance;
    }

    public final boolean getHasDust() {
        return this.hasDust;
    }

    public final int getDustType() {
        return this.dustType;
    }

    @NotNull
    public final String getDustItem() {
        return this.dustItem;
    }

    @NotNull
    public final DustData getDustData() {
        return this.dustData;
    }

    public final void setDustData(@NotNull DustData dustData) {
        Intrinsics.checkNotNullParameter(dustData, "<set-?>");
        this.dustData = dustData;
    }

    @NotNull
    public final List<CaseItemData> getItems() {
        return this.items;
    }

    public final boolean isGuarantFirstActive() {
        return this.isGuarantFirstActive;
    }

    public final boolean isGuarantSecondActive() {
        return this.isGuarantSecondActive;
    }

    /* JADX INFO: compiled from: CaseData.kt */
    /* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/common/response/shop/CaseData$Companion.class */
    @Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\rRS\u0010\u0004\u001aB\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\b0\b \u0007* \u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\b0\b\u0018\u00010\u00050\u0005¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lnet/mcskill/shop/common/response/shop/CaseData$Companion;", "", "<init>", "()V", "CODEC", "Lnet/minecraft/network/codec/StreamCodec;", "Lnet/minecraft/network/FriendlyByteBuf;", "kotlin.jvm.PlatformType", "Lnet/mcskill/shop/common/response/shop/CaseData;", "getCODEC", "()Lnet/minecraft/network/codec/StreamCodec;", "Lnet/minecraft/network/codec/StreamCodec;", "serializer", "Lkotlinx/serialization/KSerializer;", "MSShop"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final KSerializer<CaseData> serializer() {
            return CaseData$$serializer.INSTANCE;
        }

        public final StreamCodec<FriendlyByteBuf, CaseData> getCODEC() {
            return CaseData.CODEC;
        }
    }

    public CaseData(@NotNull FriendlyByteBuf buf) {
        Intrinsics.checkNotNullParameter(buf, "buf");
        int i = buf.readInt();
        String utf = buf.readUtf();
        Intrinsics.checkNotNullExpressionValue(utf, "readUtf(...)");
        String utf2 = buf.readUtf();
        Intrinsics.checkNotNullExpressionValue(utf2, "readUtf(...)");
        TypeData typeData = new TypeData(buf);
        short s = buf.readShort();
        int i2 = buf.readInt();
        String utf3 = buf.readUtf();
        Intrinsics.checkNotNullExpressionValue(utf3, "readUtf(...)");
        boolean z = buf.readBoolean();
        int i3 = buf.readInt();
        int i4 = buf.readInt();
        int i5 = buf.readInt();
        int i6 = buf.readInt();
        int i7 = buf.readInt();
        int i8 = buf.readInt();
        int i9 = buf.readInt();
        boolean z2 = buf.readBoolean();
        int i10 = buf.readInt();
        String utf4 = buf.readUtf();
        Intrinsics.checkNotNullExpressionValue(utf4, "readUtf(...)");
        DustData dustData = new DustData(buf);
        AnonymousClass1 anonymousClass1 = AnonymousClass1.INSTANCE;
        List list = buf.readList((v1) -> {
            return _init_$lambda$0(r22, v1);
        });
        Intrinsics.checkNotNullExpressionValue(list, "readList(...)");
        this(i, utf, utf2, typeData, s, i2, false, utf3, z, i3, i4, i5, i6, i7, i8, i9, z2, i10, utf4, dustData, list);
    }

    /* JADX INFO: renamed from: net.mcskill.shop.common.response.shop.CaseData$1, reason: invalid class name */
    /* JADX INFO: compiled from: CaseData.kt */
    /* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/common/response/shop/CaseData$1.class */
    @Metadata(mv = {2, 0, 0}, k = 3, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<FriendlyByteBuf, CaseItemData> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(1, CaseItemData.class, "<init>", "<init>(Lnet/minecraft/network/FriendlyByteBuf;)V", 0);
        }

        public final CaseItemData invoke(FriendlyByteBuf p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return new CaseItemData(p0);
        }
    }

    private static final CaseItemData _init_$lambda$0(Function1 $tmp0, Object p0) {
        return (CaseItemData) $tmp0.invoke(p0);
    }

    public void serialize(@NotNull FriendlyByteBuf buf) {
        Intrinsics.checkNotNullParameter(buf, "buf");
        buf.writeInt(this.id);
        buf.writeUtf(this.name);
        buf.writeUtf(this.image);
        this.type.serialize(buf);
        buf.writeShort(this.sort);
        buf.writeInt(this.price);
        buf.writeUtf(this.url);
        buf.writeBoolean(this.enabled);
        buf.writeInt(this.amount);
        buf.writeInt(this.guarantyFirstLimit);
        buf.writeInt(this.guarantySecondLimit);
        buf.writeInt(this.guarantyFirstProgress);
        buf.writeInt(this.guarantySecondProgress);
        buf.writeInt(this.guarantyFirstChance);
        buf.writeInt(this.guarantySecondChance);
        buf.writeBoolean(this.hasDust);
        buf.writeInt(this.dustType);
        buf.writeUtf(this.dustItem);
        this.dustData.serialize(buf);
        List<CaseItemData> list = this.items;
        Function2 function2 = CaseData::serialize$lambda$1;
        buf.writeCollection(list, (v1, v2) -> {
            serialize$lambda$2(r2, v1, v2);
        });
    }

    private static final void serialize$lambda$2(Function2 $tmp0, Object p0, CaseItemData p1) {
        $tmp0.invoke(p0, p1);
    }

    private static final Unit serialize$lambda$1(FriendlyByteBuf innerBuf, CaseItemData item) {
        Intrinsics.checkNotNull(innerBuf);
        item.serialize(innerBuf);
        return Unit.INSTANCE;
    }
}
