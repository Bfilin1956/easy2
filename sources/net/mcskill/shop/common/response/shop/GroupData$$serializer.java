package net.mcskill.shop.common.response.shop;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import net.mcskill.shop.common.response.PurchaseData;
import net.mcskill.shop.common.response.PurchaseData$$serializer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: GroupData.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/common/response/shop/GroupData$$serializer.class */
@Deprecated(message = "This synthesized declaration should not be used directly", level = DeprecationLevel.HIDDEN)
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"net/mcskill/shop/common/response/shop/GroupData.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lnet/mcskill/shop/common/response/shop/GroupData;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "MSShop"})
public /* synthetic */ class GroupData$$serializer implements GeneratedSerializer<GroupData> {

    @NotNull
    public static final GroupData$$serializer INSTANCE = new GroupData$$serializer();

    @NotNull
    private static final SerialDescriptor descriptor;

    private GroupData$$serializer() {
    }

    @NotNull
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    public final void serialize(@NotNull Encoder encoder, @NotNull GroupData value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        GroupData.write$Self$MSShop(value, compositeEncoderBeginStructure, serialDescriptor);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlinx.serialization.UnknownFieldException */
    @NotNull
    /* JADX INFO: renamed from: deserialize, reason: merged with bridge method [inline-methods] */
    public final GroupData m199deserialize(@NotNull Decoder decoder) throws UnknownFieldException {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        boolean z = true;
        int i = 0;
        int iDecodeIntElement = 0;
        int iDecodeIntElement2 = 0;
        int iDecodeIntElement3 = 0;
        String strDecodeStringElement = null;
        String strDecodeStringElement2 = null;
        String strDecodeStringElement3 = null;
        String strDecodeStringElement4 = null;
        String strDecodeStringElement5 = null;
        int iDecodeIntElement4 = 0;
        String strDecodeStringElement6 = null;
        int iDecodeIntElement5 = 0;
        int iDecodeIntElement6 = 0;
        int iDecodeIntElement7 = 0;
        int iDecodeIntElement8 = 0;
        int iDecodeIntElement9 = 0;
        int iDecodeIntElement10 = 0;
        int iDecodeIntElement11 = 0;
        int iDecodeIntElement12 = 0;
        int iDecodeIntElement13 = 0;
        int iDecodeIntElement14 = 0;
        int iDecodeIntElement15 = 0;
        boolean zBooleanValue = false;
        boolean zBooleanValue2 = false;
        boolean zBooleanValue3 = false;
        boolean zBooleanValue4 = false;
        int iDecodeIntElement16 = 0;
        PurchaseData purchaseData = null;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        DeserializationStrategy[] deserializationStrategyArr = GroupData.$childSerializers;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            iDecodeIntElement = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 0);
            iDecodeIntElement2 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 1);
            iDecodeIntElement3 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 2);
            strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 3);
            strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 4);
            strDecodeStringElement3 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 5);
            strDecodeStringElement4 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 6);
            strDecodeStringElement5 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 7);
            iDecodeIntElement4 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 8);
            strDecodeStringElement6 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 9);
            iDecodeIntElement5 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 10);
            iDecodeIntElement6 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 11);
            iDecodeIntElement7 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 12);
            iDecodeIntElement8 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 13);
            iDecodeIntElement9 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 14);
            iDecodeIntElement10 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 15);
            iDecodeIntElement11 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 16);
            iDecodeIntElement12 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 17);
            iDecodeIntElement13 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 18);
            iDecodeIntElement14 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 19);
            iDecodeIntElement15 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 20);
            zBooleanValue = ((Boolean) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 21, deserializationStrategyArr[21], false)).booleanValue();
            zBooleanValue2 = ((Boolean) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 22, deserializationStrategyArr[22], false)).booleanValue();
            zBooleanValue3 = ((Boolean) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 23, deserializationStrategyArr[23], false)).booleanValue();
            zBooleanValue4 = ((Boolean) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 24, deserializationStrategyArr[24], false)).booleanValue();
            iDecodeIntElement16 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 25);
            purchaseData = (PurchaseData) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 26, PurchaseData$$serializer.INSTANCE, (Object) null);
            i = 0 | 1 | 2 | 4 | 8 | 16 | 32 | 64 | 128 | 256 | 512 | 1024 | 2048 | 4096 | 8192 | 16384 | 32768 | 65536 | 131072 | 262144 | 524288 | 1048576 | 2097152 | 4194304 | 8388608 | 16777216 | 33554432 | 67108864;
        } else {
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case -1:
                        z = false;
                        break;
                    case 0:
                        iDecodeIntElement = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 0);
                        i |= 1;
                        break;
                    case 1:
                        iDecodeIntElement2 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 1);
                        i |= 2;
                        break;
                    case 2:
                        iDecodeIntElement3 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 2);
                        i |= 4;
                        break;
                    case 3:
                        strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 3);
                        i |= 8;
                        break;
                    case 4:
                        strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 4);
                        i |= 16;
                        break;
                    case 5:
                        strDecodeStringElement3 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 5);
                        i |= 32;
                        break;
                    case 6:
                        strDecodeStringElement4 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 6);
                        i |= 64;
                        break;
                    case 7:
                        strDecodeStringElement5 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 7);
                        i |= 128;
                        break;
                    case 8:
                        iDecodeIntElement4 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 8);
                        i |= 256;
                        break;
                    case 9:
                        strDecodeStringElement6 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 9);
                        i |= 512;
                        break;
                    case 10:
                        iDecodeIntElement5 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 10);
                        i |= 1024;
                        break;
                    case 11:
                        iDecodeIntElement6 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 11);
                        i |= 2048;
                        break;
                    case 12:
                        iDecodeIntElement7 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 12);
                        i |= 4096;
                        break;
                    case 13:
                        iDecodeIntElement8 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 13);
                        i |= 8192;
                        break;
                    case 14:
                        iDecodeIntElement9 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 14);
                        i |= 16384;
                        break;
                    case 15:
                        iDecodeIntElement10 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 15);
                        i |= 32768;
                        break;
                    case 16:
                        iDecodeIntElement11 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 16);
                        i |= 65536;
                        break;
                    case 17:
                        iDecodeIntElement12 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 17);
                        i |= 131072;
                        break;
                    case 18:
                        iDecodeIntElement13 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 18);
                        i |= 262144;
                        break;
                    case 19:
                        iDecodeIntElement14 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 19);
                        i |= 524288;
                        break;
                    case 20:
                        iDecodeIntElement15 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 20);
                        i |= 1048576;
                        break;
                    case 21:
                        zBooleanValue = ((Boolean) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 21, deserializationStrategyArr[21], Boolean.valueOf(zBooleanValue))).booleanValue();
                        i |= 2097152;
                        break;
                    case 22:
                        zBooleanValue2 = ((Boolean) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 22, deserializationStrategyArr[22], Boolean.valueOf(zBooleanValue2))).booleanValue();
                        i |= 4194304;
                        break;
                    case 23:
                        zBooleanValue3 = ((Boolean) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 23, deserializationStrategyArr[23], Boolean.valueOf(zBooleanValue3))).booleanValue();
                        i |= 8388608;
                        break;
                    case 24:
                        zBooleanValue4 = ((Boolean) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 24, deserializationStrategyArr[24], Boolean.valueOf(zBooleanValue4))).booleanValue();
                        i |= 16777216;
                        break;
                    case 25:
                        iDecodeIntElement16 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 25);
                        i |= 33554432;
                        break;
                    case 26:
                        purchaseData = (PurchaseData) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 26, PurchaseData$$serializer.INSTANCE, purchaseData);
                        i |= 67108864;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new GroupData(i, iDecodeIntElement, iDecodeIntElement2, iDecodeIntElement3, strDecodeStringElement, strDecodeStringElement2, strDecodeStringElement3, strDecodeStringElement4, strDecodeStringElement5, iDecodeIntElement4, strDecodeStringElement6, iDecodeIntElement5, iDecodeIntElement6, iDecodeIntElement7, iDecodeIntElement8, iDecodeIntElement9, iDecodeIntElement10, iDecodeIntElement11, iDecodeIntElement12, iDecodeIntElement13, iDecodeIntElement14, iDecodeIntElement15, zBooleanValue, zBooleanValue2, zBooleanValue3, zBooleanValue4, iDecodeIntElement16, purchaseData, (SerializationConstructorMarker) null);
    }

    @NotNull
    public final KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr = GroupData.$childSerializers;
        return new KSerializer[]{IntSerializer.INSTANCE, IntSerializer.INSTANCE, IntSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, IntSerializer.INSTANCE, StringSerializer.INSTANCE, IntSerializer.INSTANCE, IntSerializer.INSTANCE, IntSerializer.INSTANCE, IntSerializer.INSTANCE, IntSerializer.INSTANCE, IntSerializer.INSTANCE, IntSerializer.INSTANCE, IntSerializer.INSTANCE, IntSerializer.INSTANCE, IntSerializer.INSTANCE, IntSerializer.INSTANCE, kSerializerArr[21], kSerializerArr[22], kSerializerArr[23], kSerializerArr[24], IntSerializer.INSTANCE, PurchaseData$$serializer.INSTANCE};
    }

    @NotNull
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("net.mcskill.shop.common.response.shop.GroupData", INSTANCE, 27);
        pluginGeneratedSerialDescriptor.addElement("order", true);
        pluginGeneratedSerialDescriptor.addElement("id", true);
        pluginGeneratedSerialDescriptor.addElement("group_id", true);
        pluginGeneratedSerialDescriptor.addElement("site_name", false);
        pluginGeneratedSerialDescriptor.addElement("shortstory", true);
        pluginGeneratedSerialDescriptor.addElement("img", false);
        pluginGeneratedSerialDescriptor.addElement("pex_name", true);
        pluginGeneratedSerialDescriptor.addElement("color", true);
        pluginGeneratedSerialDescriptor.addElement("upgrade", false);
        pluginGeneratedSerialDescriptor.addElement("desc", false);
        pluginGeneratedSerialDescriptor.addElement("price_month", false);
        pluginGeneratedSerialDescriptor.addElement("price_em_month", false);
        pluginGeneratedSerialDescriptor.addElement("price_perm", false);
        pluginGeneratedSerialDescriptor.addElement("price_year", false);
        pluginGeneratedSerialDescriptor.addElement("price_month_discount", true);
        pluginGeneratedSerialDescriptor.addElement("price_perm_discount", true);
        pluginGeneratedSerialDescriptor.addElement("price_year_discount", true);
        pluginGeneratedSerialDescriptor.addElement("discount_month", true);
        pluginGeneratedSerialDescriptor.addElement("discount_perm", true);
        pluginGeneratedSerialDescriptor.addElement("discount_year", true);
        pluginGeneratedSerialDescriptor.addElement("sort", false);
        pluginGeneratedSerialDescriptor.addElement("sell_em_month", true);
        pluginGeneratedSerialDescriptor.addElement("sell_month", true);
        pluginGeneratedSerialDescriptor.addElement("sell_year", true);
        pluginGeneratedSerialDescriptor.addElement("sell_perm", true);
        pluginGeneratedSerialDescriptor.addElement("time", true);
        pluginGeneratedSerialDescriptor.addElement("purchase", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }
}
