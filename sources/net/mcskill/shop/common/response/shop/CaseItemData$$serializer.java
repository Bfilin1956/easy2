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
import net.mcskill.shop.common.response.TypeData;
import net.mcskill.shop.common.response.TypeData$$serializer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: CaseItemData.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/common/response/shop/CaseItemData$$serializer.class */
@Deprecated(message = "This synthesized declaration should not be used directly", level = DeprecationLevel.HIDDEN)
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"net/mcskill/shop/common/response/shop/CaseItemData.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lnet/mcskill/shop/common/response/shop/CaseItemData;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "MSShop"})
public /* synthetic */ class CaseItemData$$serializer implements GeneratedSerializer<CaseItemData> {

    @NotNull
    public static final CaseItemData$$serializer INSTANCE = new CaseItemData$$serializer();

    @NotNull
    private static final SerialDescriptor descriptor;

    private CaseItemData$$serializer() {
    }

    @NotNull
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    public final void serialize(@NotNull Encoder encoder, @NotNull CaseItemData value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        CaseItemData.write$Self$MSShop(value, compositeEncoderBeginStructure, serialDescriptor);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlinx.serialization.UnknownFieldException */
    @NotNull
    /* JADX INFO: renamed from: deserialize, reason: merged with bridge method [inline-methods] */
    public final CaseItemData m193deserialize(@NotNull Decoder decoder) throws UnknownFieldException {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        boolean z = true;
        int i = 0;
        int iDecodeIntElement = 0;
        TypeData typeData = null;
        String strDecodeStringElement = null;
        String strDecodeStringElement2 = null;
        String strDecodeStringElement3 = null;
        int iDecodeIntElement2 = 0;
        String strDecodeStringElement4 = null;
        String strDecodeStringElement5 = null;
        String strDecodeStringElement6 = null;
        int iDecodeIntElement3 = 0;
        boolean zBooleanValue = false;
        int iDecodeIntElement4 = 0;
        int iDecodeIntElement5 = 0;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        DeserializationStrategy[] deserializationStrategyArr = CaseItemData.$childSerializers;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            iDecodeIntElement = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 0);
            typeData = (TypeData) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, TypeData$$serializer.INSTANCE, (Object) null);
            strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 2);
            strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 3);
            strDecodeStringElement3 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 4);
            iDecodeIntElement2 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 5);
            strDecodeStringElement4 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 6);
            strDecodeStringElement5 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 7);
            strDecodeStringElement6 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 8);
            iDecodeIntElement3 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 9);
            zBooleanValue = ((Boolean) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 10, deserializationStrategyArr[10], false)).booleanValue();
            iDecodeIntElement4 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 11);
            iDecodeIntElement5 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 12);
            i = 0 | 1 | 2 | 4 | 8 | 16 | 32 | 64 | 128 | 256 | 512 | 1024 | 2048 | 4096;
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
                        typeData = (TypeData) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, TypeData$$serializer.INSTANCE, typeData);
                        i |= 2;
                        break;
                    case 2:
                        strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 2);
                        i |= 4;
                        break;
                    case 3:
                        strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 3);
                        i |= 8;
                        break;
                    case 4:
                        strDecodeStringElement3 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 4);
                        i |= 16;
                        break;
                    case 5:
                        iDecodeIntElement2 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 5);
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
                        strDecodeStringElement6 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 8);
                        i |= 256;
                        break;
                    case 9:
                        iDecodeIntElement3 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 9);
                        i |= 512;
                        break;
                    case 10:
                        zBooleanValue = ((Boolean) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 10, deserializationStrategyArr[10], Boolean.valueOf(zBooleanValue))).booleanValue();
                        i |= 1024;
                        break;
                    case 11:
                        iDecodeIntElement4 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 11);
                        i |= 2048;
                        break;
                    case 12:
                        iDecodeIntElement5 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 12);
                        i |= 4096;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new CaseItemData(i, iDecodeIntElement, typeData, strDecodeStringElement, strDecodeStringElement2, strDecodeStringElement3, iDecodeIntElement2, strDecodeStringElement4, strDecodeStringElement5, strDecodeStringElement6, iDecodeIntElement3, zBooleanValue, iDecodeIntElement4, iDecodeIntElement5, (SerializationConstructorMarker) null);
    }

    @NotNull
    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{IntSerializer.INSTANCE, TypeData$$serializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, IntSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, IntSerializer.INSTANCE, CaseItemData.$childSerializers[10], IntSerializer.INSTANCE, IntSerializer.INSTANCE};
    }

    @NotNull
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("net.mcskill.shop.common.response.shop.CaseItemData", INSTANCE, 13);
        pluginGeneratedSerialDescriptor.addElement("id", false);
        pluginGeneratedSerialDescriptor.addElement("type", false);
        pluginGeneratedSerialDescriptor.addElement("item_name", false);
        pluginGeneratedSerialDescriptor.addElement("minecraft_id", false);
        pluginGeneratedSerialDescriptor.addElement("img", false);
        pluginGeneratedSerialDescriptor.addElement("count", false);
        pluginGeneratedSerialDescriptor.addElement("ench", true);
        pluginGeneratedSerialDescriptor.addElement("nbt", true);
        pluginGeneratedSerialDescriptor.addElement("command", true);
        pluginGeneratedSerialDescriptor.addElement("rarity", false);
        pluginGeneratedSerialDescriptor.addElement("enabled", false);
        pluginGeneratedSerialDescriptor.addElement("sort", false);
        pluginGeneratedSerialDescriptor.addElement("cases_guarant", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }
}
