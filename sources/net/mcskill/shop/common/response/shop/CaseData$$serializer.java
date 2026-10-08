package net.mcskill.shop.common.response.shop;

import java.util.List;
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
import net.mcskill.shop.common.response.DustData;
import net.mcskill.shop.common.response.DustData$$serializer;
import net.mcskill.shop.common.response.TypeData;
import net.mcskill.shop.common.response.TypeData$$serializer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: CaseData.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/common/response/shop/CaseData$$serializer.class */
@Deprecated(message = "This synthesized declaration should not be used directly", level = DeprecationLevel.HIDDEN)
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"net/mcskill/shop/common/response/shop/CaseData.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lnet/mcskill/shop/common/response/shop/CaseData;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "MSShop"})
public /* synthetic */ class CaseData$$serializer implements GeneratedSerializer<CaseData> {

    @NotNull
    public static final CaseData$$serializer INSTANCE = new CaseData$$serializer();

    @NotNull
    private static final SerialDescriptor descriptor;

    private CaseData$$serializer() {
    }

    @NotNull
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    public final void serialize(@NotNull Encoder encoder, @NotNull CaseData value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        CaseData.write$Self$MSShop(value, compositeEncoderBeginStructure, serialDescriptor);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlinx.serialization.UnknownFieldException */
    @NotNull
    /* JADX INFO: renamed from: deserialize, reason: merged with bridge method [inline-methods] */
    public final CaseData m189deserialize(@NotNull Decoder decoder) throws UnknownFieldException {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        boolean z = true;
        int i = 0;
        int iDecodeIntElement = 0;
        String strDecodeStringElement = null;
        String strDecodeStringElement2 = null;
        TypeData typeData = null;
        int iDecodeIntElement2 = 0;
        int iDecodeIntElement3 = 0;
        boolean zBooleanValue = false;
        String strDecodeStringElement3 = null;
        boolean zBooleanValue2 = false;
        int iDecodeIntElement4 = 0;
        int iDecodeIntElement5 = 0;
        int iDecodeIntElement6 = 0;
        int iDecodeIntElement7 = 0;
        int iDecodeIntElement8 = 0;
        int iDecodeIntElement9 = 0;
        int iDecodeIntElement10 = 0;
        boolean zBooleanValue3 = false;
        int iDecodeIntElement11 = 0;
        String strDecodeStringElement4 = null;
        DustData dustData = null;
        List list = null;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        DeserializationStrategy[] deserializationStrategyArr = CaseData.$childSerializers;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            iDecodeIntElement = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 0);
            strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 1);
            strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 2);
            typeData = (TypeData) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 3, TypeData$$serializer.INSTANCE, (Object) null);
            iDecodeIntElement2 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 4);
            iDecodeIntElement3 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 5);
            zBooleanValue = ((Boolean) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 6, deserializationStrategyArr[6], false)).booleanValue();
            strDecodeStringElement3 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 7);
            zBooleanValue2 = ((Boolean) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 8, deserializationStrategyArr[8], false)).booleanValue();
            iDecodeIntElement4 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 9);
            iDecodeIntElement5 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 10);
            iDecodeIntElement6 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 11);
            iDecodeIntElement7 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 12);
            iDecodeIntElement8 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 13);
            iDecodeIntElement9 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 14);
            iDecodeIntElement10 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 15);
            zBooleanValue3 = ((Boolean) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 16, deserializationStrategyArr[16], false)).booleanValue();
            iDecodeIntElement11 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 17);
            strDecodeStringElement4 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 18);
            dustData = (DustData) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 19, DustData$$serializer.INSTANCE, (Object) null);
            list = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 20, deserializationStrategyArr[20], (Object) null);
            i = 0 | 1 | 2 | 4 | 8 | 16 | 32 | 64 | 128 | 256 | 512 | 1024 | 2048 | 4096 | 8192 | 16384 | 32768 | 65536 | 131072 | 262144 | 524288 | 1048576;
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
                        strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 1);
                        i |= 2;
                        break;
                    case 2:
                        strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 2);
                        i |= 4;
                        break;
                    case 3:
                        typeData = (TypeData) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 3, TypeData$$serializer.INSTANCE, typeData);
                        i |= 8;
                        break;
                    case 4:
                        iDecodeIntElement2 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 4);
                        i |= 16;
                        break;
                    case 5:
                        iDecodeIntElement3 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 5);
                        i |= 32;
                        break;
                    case 6:
                        zBooleanValue = ((Boolean) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 6, deserializationStrategyArr[6], Boolean.valueOf(zBooleanValue))).booleanValue();
                        i |= 64;
                        break;
                    case 7:
                        strDecodeStringElement3 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 7);
                        i |= 128;
                        break;
                    case 8:
                        zBooleanValue2 = ((Boolean) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 8, deserializationStrategyArr[8], Boolean.valueOf(zBooleanValue2))).booleanValue();
                        i |= 256;
                        break;
                    case 9:
                        iDecodeIntElement4 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 9);
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
                        zBooleanValue3 = ((Boolean) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 16, deserializationStrategyArr[16], Boolean.valueOf(zBooleanValue3))).booleanValue();
                        i |= 65536;
                        break;
                    case 17:
                        iDecodeIntElement11 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 17);
                        i |= 131072;
                        break;
                    case 18:
                        strDecodeStringElement4 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 18);
                        i |= 262144;
                        break;
                    case 19:
                        dustData = (DustData) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 19, DustData$$serializer.INSTANCE, dustData);
                        i |= 524288;
                        break;
                    case 20:
                        list = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 20, deserializationStrategyArr[20], list);
                        i |= 1048576;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new CaseData(i, iDecodeIntElement, strDecodeStringElement, strDecodeStringElement2, typeData, iDecodeIntElement2, iDecodeIntElement3, zBooleanValue, strDecodeStringElement3, zBooleanValue2, iDecodeIntElement4, iDecodeIntElement5, iDecodeIntElement6, iDecodeIntElement7, iDecodeIntElement8, iDecodeIntElement9, iDecodeIntElement10, zBooleanValue3, iDecodeIntElement11, strDecodeStringElement4, dustData, list, (SerializationConstructorMarker) null);
    }

    @NotNull
    public final KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr = CaseData.$childSerializers;
        return new KSerializer[]{IntSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, TypeData$$serializer.INSTANCE, IntSerializer.INSTANCE, IntSerializer.INSTANCE, kSerializerArr[6], StringSerializer.INSTANCE, kSerializerArr[8], IntSerializer.INSTANCE, IntSerializer.INSTANCE, IntSerializer.INSTANCE, IntSerializer.INSTANCE, IntSerializer.INSTANCE, IntSerializer.INSTANCE, IntSerializer.INSTANCE, kSerializerArr[16], IntSerializer.INSTANCE, StringSerializer.INSTANCE, DustData$$serializer.INSTANCE, kSerializerArr[20]};
    }

    @NotNull
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("net.mcskill.shop.common.response.shop.CaseData", INSTANCE, 21);
        pluginGeneratedSerialDescriptor.addElement("id", false);
        pluginGeneratedSerialDescriptor.addElement("name", false);
        pluginGeneratedSerialDescriptor.addElement("img", false);
        pluginGeneratedSerialDescriptor.addElement("type", false);
        pluginGeneratedSerialDescriptor.addElement("sort", false);
        pluginGeneratedSerialDescriptor.addElement("price", false);
        pluginGeneratedSerialDescriptor.addElement("test", true);
        pluginGeneratedSerialDescriptor.addElement("url", false);
        pluginGeneratedSerialDescriptor.addElement("enabled", false);
        pluginGeneratedSerialDescriptor.addElement("amount", true);
        pluginGeneratedSerialDescriptor.addElement("guarant1_limit", true);
        pluginGeneratedSerialDescriptor.addElement("guarant2_limit", true);
        pluginGeneratedSerialDescriptor.addElement("guarant1_progress", true);
        pluginGeneratedSerialDescriptor.addElement("guarant2_progress", true);
        pluginGeneratedSerialDescriptor.addElement("guarant1_chance", true);
        pluginGeneratedSerialDescriptor.addElement("guarant2_chance", true);
        pluginGeneratedSerialDescriptor.addElement("dust", true);
        pluginGeneratedSerialDescriptor.addElement("dust_type", true);
        pluginGeneratedSerialDescriptor.addElement("bonus_items", true);
        pluginGeneratedSerialDescriptor.addElement("dustData", true);
        pluginGeneratedSerialDescriptor.addElement("items", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }
}
