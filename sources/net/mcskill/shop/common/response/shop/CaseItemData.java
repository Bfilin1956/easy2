package net.mcskill.shop.common.response.shop;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
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
import net.mcskill.shop.common.response.TypeData;
import net.mcskill.shop.common.response.TypeData$$serializer;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CaseItemData.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/common/response/shop/CaseItemData.class */
@Serializable
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 Q2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002QRBw\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003¢\u0006\u0004\b\u0013\u0010\u0014B\u0011\b\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0016¢\u0006\u0004\b\u0013\u0010\u0017B\u0091\u0001\b\u0010\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b\u0013\u0010\u001bJ\u0010\u00105\u001a\u0002062\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0005HÆ\u0003J\t\u00109\u001a\u00020\u0007HÆ\u0003J\t\u0010:\u001a\u00020\u0007HÆ\u0003J\t\u0010;\u001a\u00020\u0007HÆ\u0003J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\t\u0010=\u001a\u00020\u0007HÆ\u0003J\t\u0010>\u001a\u00020\u0007HÆ\u0003J\t\u0010?\u001a\u00020\u0007HÆ\u0003J\t\u0010@\u001a\u00020\u0003HÆ\u0003J\t\u0010A\u001a\u00020\u0010HÆ\u0003J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\u008b\u0001\u0010D\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u0003HÆ\u0001J\u0013\u0010E\u001a\u00020\u00102\b\u0010F\u001a\u0004\u0018\u00010GHÖ\u0003J\t\u0010H\u001a\u00020\u0003HÖ\u0001J\t\u0010I\u001a\u00020\u0007HÖ\u0001J%\u0010J\u001a\u0002062\u0006\u0010K\u001a\u00020\u00002\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020OH\u0001¢\u0006\u0002\bPR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001c\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b$\u0010!\u001a\u0004\b%\u0010#R\u001c\u0010\t\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010!\u001a\u0004\b'\u0010#R\u001c\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b(\u0010!\u001a\u0004\b)\u0010\u001dR\u001c\u0010\u000b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b*\u0010!\u001a\u0004\b+\u0010#R\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b,\u0010#R\u0011\u0010\r\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b-\u0010#R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001dR\u001c\u0010\u000f\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b/\u0010!\u001a\u0004\b0\u00101R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u001dR\u001c\u0010\u0012\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b3\u0010!\u001a\u0004\b4\u0010\u001d¨\u0006S"}, d2 = {"Lnet/mcskill/shop/common/response/shop/CaseItemData;", "Lnet/mcskill/core/common/network/ByteBufferSerializer;", "id", "", "type", "Lnet/mcskill/shop/common/response/TypeData;", "name", "", "registryName", "image", "amount", "enchant", "nbt", "command", "rarity", "enabled", "", "sort", "guarantType", "<init>", "(ILnet/mcskill/shop/common/response/TypeData;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IZII)V", "buf", "Lnet/minecraft/network/FriendlyByteBuf;", "(Lnet/minecraft/network/FriendlyByteBuf;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILnet/mcskill/shop/common/response/TypeData;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IZIILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId", "()I", "getType", "()Lnet/mcskill/shop/common/response/TypeData;", "getName$annotations", "()V", "getName", "()Ljava/lang/String;", "getRegistryName$annotations", "getRegistryName", "getImage$annotations", "getImage", "getAmount$annotations", "getAmount", "getEnchant$annotations", "getEnchant", "getNbt", "getCommand", "getRarity", "getEnabled$annotations", "getEnabled", "()Z", "getSort", "getGuarantType$annotations", "getGuarantType", "serialize", "", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "equals", "other", "", "hashCode", "toString", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$MSShop", "Companion", "$serializer", "MSShop"})
public final /* data */ class CaseItemData implements ByteBufferSerializer<CaseItemData> {
    private final int id;

    @NotNull
    private final TypeData type;

    @NotNull
    private final String name;

    @NotNull
    private final String registryName;

    @NotNull
    private final String image;
    private final int amount;

    @NotNull
    private final String enchant;

    @NotNull
    private final String nbt;

    @NotNull
    private final String command;
    private final int rarity;
    private final boolean enabled;
    private final int sort;
    private final int guarantType;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @JvmField
    @NotNull
    private static final KSerializer<Object>[] $childSerializers = {null, null, null, null, null, null, null, null, null, null, new BoolAsIntSerializer(), null, null};
    private static final StreamCodec<FriendlyByteBuf, CaseItemData> CODEC = StreamCodec.ofMember((v0, v1) -> {
        v0.serialize(v1);
    }, CaseItemData::new);

    @SerialName("item_name")
    public static /* synthetic */ void getName$annotations() {
    }

    @SerialName("minecraft_id")
    public static /* synthetic */ void getRegistryName$annotations() {
    }

    @SerialName("img")
    public static /* synthetic */ void getImage$annotations() {
    }

    @SerialName("count")
    public static /* synthetic */ void getAmount$annotations() {
    }

    @SerialName("ench")
    public static /* synthetic */ void getEnchant$annotations() {
    }

    @Serializable(with = BoolAsIntSerializer.class)
    public static /* synthetic */ void getEnabled$annotations() {
    }

    @SerialName("cases_guarant")
    public static /* synthetic */ void getGuarantType$annotations() {
    }

    public final int component1() {
        return this.id;
    }

    @NotNull
    public final TypeData component2() {
        return this.type;
    }

    @NotNull
    public final String component3() {
        return this.name;
    }

    @NotNull
    public final String component4() {
        return this.registryName;
    }

    @NotNull
    public final String component5() {
        return this.image;
    }

    public final int component6() {
        return this.amount;
    }

    @NotNull
    public final String component7() {
        return this.enchant;
    }

    @NotNull
    public final String component8() {
        return this.nbt;
    }

    @NotNull
    public final String component9() {
        return this.command;
    }

    public final int component10() {
        return this.rarity;
    }

    public final boolean component11() {
        return this.enabled;
    }

    public final int component12() {
        return this.sort;
    }

    public final int component13() {
        return this.guarantType;
    }

    @NotNull
    public final CaseItemData copy(int id, @NotNull TypeData type, @NotNull String name, @NotNull String registryName, @NotNull String image, int amount, @NotNull String enchant, @NotNull String nbt, @NotNull String command, int rarity, boolean enabled, int sort, int guarantType) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(registryName, "registryName");
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(enchant, "enchant");
        Intrinsics.checkNotNullParameter(nbt, "nbt");
        Intrinsics.checkNotNullParameter(command, "command");
        return new CaseItemData(id, type, name, registryName, image, amount, enchant, nbt, command, rarity, enabled, sort, guarantType);
    }

    public static /* synthetic */ CaseItemData copy$default(CaseItemData caseItemData, int i, TypeData typeData, String str, String str2, String str3, int i2, String str4, String str5, String str6, int i3, boolean z, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = caseItemData.id;
        }
        if ((i6 & 2) != 0) {
            typeData = caseItemData.type;
        }
        if ((i6 & 4) != 0) {
            str = caseItemData.name;
        }
        if ((i6 & 8) != 0) {
            str2 = caseItemData.registryName;
        }
        if ((i6 & 16) != 0) {
            str3 = caseItemData.image;
        }
        if ((i6 & 32) != 0) {
            i2 = caseItemData.amount;
        }
        if ((i6 & 64) != 0) {
            str4 = caseItemData.enchant;
        }
        if ((i6 & 128) != 0) {
            str5 = caseItemData.nbt;
        }
        if ((i6 & 256) != 0) {
            str6 = caseItemData.command;
        }
        if ((i6 & 512) != 0) {
            i3 = caseItemData.rarity;
        }
        if ((i6 & 1024) != 0) {
            z = caseItemData.enabled;
        }
        if ((i6 & 2048) != 0) {
            i4 = caseItemData.sort;
        }
        if ((i6 & 4096) != 0) {
            i5 = caseItemData.guarantType;
        }
        return caseItemData.copy(i, typeData, str, str2, str3, i2, str4, str5, str6, i3, z, i4, i5);
    }

    @NotNull
    public String toString() {
        return "CaseItemData(id=" + this.id + ", type=" + this.type + ", name=" + this.name + ", registryName=" + this.registryName + ", image=" + this.image + ", amount=" + this.amount + ", enchant=" + this.enchant + ", nbt=" + this.nbt + ", command=" + this.command + ", rarity=" + this.rarity + ", enabled=" + this.enabled + ", sort=" + this.sort + ", guarantType=" + this.guarantType + ")";
    }

    public int hashCode() {
        int result = Integer.hashCode(this.id);
        return (((((((((((((((((((((((result * 31) + this.type.hashCode()) * 31) + this.name.hashCode()) * 31) + this.registryName.hashCode()) * 31) + this.image.hashCode()) * 31) + Integer.hashCode(this.amount)) * 31) + this.enchant.hashCode()) * 31) + this.nbt.hashCode()) * 31) + this.command.hashCode()) * 31) + Integer.hashCode(this.rarity)) * 31) + Boolean.hashCode(this.enabled)) * 31) + Integer.hashCode(this.sort)) * 31) + Integer.hashCode(this.guarantType);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CaseItemData)) {
            return false;
        }
        CaseItemData caseItemData = (CaseItemData) other;
        return this.id == caseItemData.id && Intrinsics.areEqual(this.type, caseItemData.type) && Intrinsics.areEqual(this.name, caseItemData.name) && Intrinsics.areEqual(this.registryName, caseItemData.registryName) && Intrinsics.areEqual(this.image, caseItemData.image) && this.amount == caseItemData.amount && Intrinsics.areEqual(this.enchant, caseItemData.enchant) && Intrinsics.areEqual(this.nbt, caseItemData.nbt) && Intrinsics.areEqual(this.command, caseItemData.command) && this.rarity == caseItemData.rarity && this.enabled == caseItemData.enabled && this.sort == caseItemData.sort && this.guarantType == caseItemData.guarantType;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$MSShop(CaseItemData self, CompositeEncoder output, SerialDescriptor serialDesc) {
        SerializationStrategy[] serializationStrategyArr = $childSerializers;
        output.encodeIntElement(serialDesc, 0, self.id);
        output.encodeSerializableElement(serialDesc, 1, TypeData$$serializer.INSTANCE, self.type);
        output.encodeStringElement(serialDesc, 2, self.name);
        output.encodeStringElement(serialDesc, 3, self.registryName);
        output.encodeStringElement(serialDesc, 4, self.image);
        output.encodeIntElement(serialDesc, 5, self.amount);
        boolean z = output.shouldEncodeElementDefault(serialDesc, 6) || !Intrinsics.areEqual(self.enchant, "");
        if (z) {
            output.encodeStringElement(serialDesc, 6, self.enchant);
        }
        boolean z2 = output.shouldEncodeElementDefault(serialDesc, 7) || !Intrinsics.areEqual(self.nbt, "");
        if (z2) {
            output.encodeStringElement(serialDesc, 7, self.nbt);
        }
        boolean z3 = output.shouldEncodeElementDefault(serialDesc, 8) || !Intrinsics.areEqual(self.command, "");
        if (z3) {
            output.encodeStringElement(serialDesc, 8, self.command);
        }
        output.encodeIntElement(serialDesc, 9, self.rarity);
        output.encodeSerializableElement(serialDesc, 10, serializationStrategyArr[10], Boolean.valueOf(self.enabled));
        output.encodeIntElement(serialDesc, 11, self.sort);
        boolean z4 = output.shouldEncodeElementDefault(serialDesc, 12) || self.guarantType != 0;
        if (z4) {
            output.encodeIntElement(serialDesc, 12, self.guarantType);
        }
    }

    public /* synthetic */ CaseItemData(int seen0, int id, TypeData type, String name, String registryName, String image, int amount, String enchant, String nbt, String command, int rarity, boolean enabled, int sort, int guarantType, SerializationConstructorMarker serializationConstructorMarker) {
        if (3647 != (3647 & seen0)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 3647, CaseItemData$$serializer.INSTANCE.getDescriptor());
        }
        this.id = id;
        this.type = type;
        this.name = name;
        this.registryName = registryName;
        this.image = image;
        this.amount = amount;
        if ((seen0 & 64) == 0) {
            this.enchant = "";
        } else {
            this.enchant = enchant;
        }
        if ((seen0 & 128) == 0) {
            this.nbt = "";
        } else {
            this.nbt = nbt;
        }
        if ((seen0 & 256) == 0) {
            this.command = "";
        } else {
            this.command = command;
        }
        this.rarity = rarity;
        this.enabled = enabled;
        this.sort = sort;
        if ((seen0 & 4096) == 0) {
            this.guarantType = 0;
        } else {
            this.guarantType = guarantType;
        }
    }

    public CaseItemData(int id, @NotNull TypeData type, @NotNull String name, @NotNull String registryName, @NotNull String image, int amount, @NotNull String enchant, @NotNull String nbt, @NotNull String command, int rarity, boolean enabled, int sort, int guarantType) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(registryName, "registryName");
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(enchant, "enchant");
        Intrinsics.checkNotNullParameter(nbt, "nbt");
        Intrinsics.checkNotNullParameter(command, "command");
        this.id = id;
        this.type = type;
        this.name = name;
        this.registryName = registryName;
        this.image = image;
        this.amount = amount;
        this.enchant = enchant;
        this.nbt = nbt;
        this.command = command;
        this.rarity = rarity;
        this.enabled = enabled;
        this.sort = sort;
        this.guarantType = guarantType;
    }

    public /* synthetic */ CaseItemData(int i, TypeData typeData, String str, String str2, String str3, int i2, String str4, String str5, String str6, int i3, boolean z, int i4, int i5, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, typeData, str, str2, str3, i2, (i6 & 64) != 0 ? "" : str4, (i6 & 128) != 0 ? "" : str5, (i6 & 256) != 0 ? "" : str6, i3, z, i4, (i6 & 4096) != 0 ? 0 : i5);
    }

    public final int getId() {
        return this.id;
    }

    @NotNull
    public final TypeData getType() {
        return this.type;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getRegistryName() {
        return this.registryName;
    }

    @NotNull
    public final String getImage() {
        return this.image;
    }

    public final int getAmount() {
        return this.amount;
    }

    @NotNull
    public final String getEnchant() {
        return this.enchant;
    }

    @NotNull
    public final String getNbt() {
        return this.nbt;
    }

    @NotNull
    public final String getCommand() {
        return this.command;
    }

    public final int getRarity() {
        return this.rarity;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final int getSort() {
        return this.sort;
    }

    public final int getGuarantType() {
        return this.guarantType;
    }

    /* JADX INFO: compiled from: CaseItemData.kt */
    /* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/common/response/shop/CaseItemData$Companion.class */
    @Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\rRS\u0010\u0004\u001aB\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\b0\b \u0007* \u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\b0\b\u0018\u00010\u00050\u0005¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lnet/mcskill/shop/common/response/shop/CaseItemData$Companion;", "", "<init>", "()V", "CODEC", "Lnet/minecraft/network/codec/StreamCodec;", "Lnet/minecraft/network/FriendlyByteBuf;", "kotlin.jvm.PlatformType", "Lnet/mcskill/shop/common/response/shop/CaseItemData;", "getCODEC", "()Lnet/minecraft/network/codec/StreamCodec;", "Lnet/minecraft/network/codec/StreamCodec;", "serializer", "Lkotlinx/serialization/KSerializer;", "MSShop"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final KSerializer<CaseItemData> serializer() {
            return CaseItemData$$serializer.INSTANCE;
        }

        public final StreamCodec<FriendlyByteBuf, CaseItemData> getCODEC() {
            return CaseItemData.CODEC;
        }
    }

    public CaseItemData(@NotNull FriendlyByteBuf buf) {
        Intrinsics.checkNotNullParameter(buf, "buf");
        TypeData typeData = new TypeData(buf);
        String utf = buf.readUtf();
        Intrinsics.checkNotNullExpressionValue(utf, "readUtf(...)");
        String utf2 = buf.readUtf();
        Intrinsics.checkNotNullExpressionValue(utf2, "readUtf(...)");
        String utf3 = buf.readUtf();
        Intrinsics.checkNotNullExpressionValue(utf3, "readUtf(...)");
        int i = buf.readInt();
        String utf4 = buf.readUtf();
        Intrinsics.checkNotNullExpressionValue(utf4, "readUtf(...)");
        String utf5 = buf.readUtf();
        Intrinsics.checkNotNullExpressionValue(utf5, "readUtf(...)");
        this(0, typeData, utf, utf2, utf3, i, utf4, utf5, "", buf.readInt(), buf.readBoolean(), buf.readInt(), buf.readInt());
    }

    public void serialize(@NotNull FriendlyByteBuf buf) {
        Intrinsics.checkNotNullParameter(buf, "buf");
        this.type.serialize(buf);
        buf.writeUtf(this.name);
        buf.writeUtf(this.registryName);
        buf.writeUtf(this.image);
        buf.writeInt(this.amount);
        buf.writeUtf(this.enchant);
        buf.writeUtf(this.nbt);
        buf.writeInt(this.rarity);
        buf.writeBoolean(this.enabled);
        buf.writeInt(this.sort);
        buf.writeInt(this.guarantType);
    }
}
