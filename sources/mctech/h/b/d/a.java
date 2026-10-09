package mctech.h.b.d;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import mctech.y.c;
import net.minecraft.resources.ResourceLocation;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/h/b/d/a.class */
public class a extends TypeAdapter<mctech.y.a> {
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void write(JsonWriter jsonWriter, mctech.y.a aVar) throws IOException {
        jsonWriter.beginObject();
        jsonWriter.name("targetType").value(aVar.a().name());
        jsonWriter.name("target").value(aVar.b().toString());
        jsonWriter.name("renderMode").value(aVar.c().name());
        jsonWriter.name("color").value(aVar.d());
        jsonWriter.name("alpha").value(aVar.e());
        jsonWriter.name("brightness").value(aVar.f());
        jsonWriter.endObject();
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public mctech.y.a read(JsonReader jsonReader) throws IOException {
        jsonReader.beginObject();
        mctech.y.a.EnumC0053a enumC0053aValueOf = null;
        String strNextString = null;
        c cVarValueOf = null;
        int iNextInt = 0;
        int iNextInt2 = 0;
        float fNextDouble = 0.0f;
        while (jsonReader.hasNext()) {
            switch (jsonReader.nextName()) {
                case "targetType":
                    enumC0053aValueOf = mctech.y.a.EnumC0053a.valueOf(jsonReader.nextString());
                    break;
                case "target":
                    strNextString = jsonReader.nextString();
                    break;
                case "renderMode":
                    cVarValueOf = c.valueOf(jsonReader.nextString());
                    break;
                case "color":
                    iNextInt = jsonReader.nextInt();
                    break;
                case "alpha":
                    iNextInt2 = jsonReader.nextInt();
                    break;
                case "brightness":
                    fNextDouble = (float) jsonReader.nextDouble();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        if (enumC0053aValueOf == null || strNextString == null || cVarValueOf == null) {
            throw new IOException("Invalid BlockAppearance JSON");
        }
        return new mctech.y.a(enumC0053aValueOf, ResourceLocation.parse(strNextString), cVarValueOf, iNextInt, iNextInt2, fNextDouble);
    }
}
