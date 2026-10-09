package mctech.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import com.mojang.serialization.JsonOps;
import java.awt.Color;
import java.io.IOException;
import java.io.Reader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.Map;
import java.util.Properties;
import java.util.function.Supplier;
import javax.annotation.Nonnull;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentSerialization;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/t.class */
public final class t {
    public static final Gson a = new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create();

    public static void a(@Nonnull Gson gson, @Nonnull JsonObject jsonObject, @Nonnull Path path) throws IOException {
        Files.writeString(path, gson.toJson(jsonObject), StandardCharsets.UTF_8, new OpenOption[0]);
    }

    public static void a(@Nonnull JsonObject jsonObject, @Nonnull Path path) throws IOException {
        a(a, jsonObject, path);
    }

    @Nonnull
    public static JsonObject a(@Nonnull Path path) throws IOException {
        return a(Files.readString(path, StandardCharsets.UTF_8));
    }

    @Nonnull
    public static JsonArray b(@Nonnull Path path) throws IOException {
        return b(Files.readString(path, StandardCharsets.UTF_8));
    }

    @Nonnull
    public static JsonObject a(@Nonnull Gson gson, @Nonnull Reader reader) throws JsonSyntaxException, JsonIOException {
        JsonObject jsonObject = (JsonObject) gson.fromJson(reader, JsonObject.class);
        return jsonObject == null ? new JsonObject() : jsonObject;
    }

    @Nonnull
    public static JsonObject a(@Nonnull Reader reader) throws JsonSyntaxException, JsonIOException {
        return a(a, reader);
    }

    @Nonnull
    public static JsonObject a(@Nonnull Gson gson, @Nonnull String str) throws JsonSyntaxException, JsonIOException {
        JsonObject jsonObject = (JsonObject) gson.fromJson(str, JsonObject.class);
        return jsonObject == null ? new JsonObject() : jsonObject;
    }

    @Nonnull
    public static JsonObject a(@Nonnull String str) throws JsonSyntaxException, JsonIOException {
        return a(a, str);
    }

    @Nonnull
    public static JsonArray b(@Nonnull Gson gson, @Nonnull Reader reader) throws JsonSyntaxException, JsonIOException {
        JsonArray jsonArray = (JsonArray) gson.fromJson(reader, JsonArray.class);
        return jsonArray == null ? new JsonArray() : jsonArray;
    }

    @Nonnull
    public static JsonArray b(@Nonnull Reader reader) throws JsonSyntaxException, JsonIOException {
        return b(a, reader);
    }

    @Nonnull
    public static JsonArray b(@Nonnull Gson gson, @Nonnull String str) throws JsonSyntaxException, JsonIOException {
        JsonArray jsonArray = (JsonArray) gson.fromJson(str, JsonArray.class);
        return jsonArray == null ? new JsonArray() : jsonArray;
    }

    @Nonnull
    public static JsonArray b(@Nonnull String str) throws JsonSyntaxException, JsonIOException {
        return b(a, str);
    }

    @Nonnull
    public static JsonObject a(@Nonnull JsonObject jsonObject, @Nonnull String str) {
        return a(jsonObject, str, (Supplier<JsonObject>) JsonObject::new);
    }

    @Nonnull
    public static JsonObject a(@Nonnull JsonObject jsonObject, @Nonnull String str, @Nonnull JsonObject jsonObject2) {
        return a(jsonObject, str, (Supplier<JsonObject>) () -> {
            return jsonObject2;
        });
    }

    @Nonnull
    public static JsonObject a(@Nonnull JsonObject jsonObject, @Nonnull String str, @Nonnull Supplier<JsonObject> supplier) {
        if (jsonObject.has(str)) {
            JsonElement jsonElement = jsonObject.get(str);
            if (jsonElement.isJsonObject()) {
                return jsonElement.getAsJsonObject();
            }
        }
        JsonObject jsonObject2 = supplier.get();
        jsonObject.add(str, jsonObject2);
        return jsonObject2;
    }

    @Nonnull
    public static JsonArray b(@Nonnull JsonObject jsonObject, @Nonnull String str) {
        return b(jsonObject, str, JsonArray::new);
    }

    @Nonnull
    public static JsonArray b(@Nonnull JsonObject jsonObject, @Nonnull String str, @Nonnull Supplier<JsonArray> supplier) {
        if (jsonObject.has(str)) {
            JsonElement jsonElement = jsonObject.get(str);
            if (jsonElement.isJsonArray()) {
                return jsonElement.getAsJsonArray();
            }
        }
        JsonArray jsonArray = supplier.get();
        jsonObject.add(str, jsonArray);
        return jsonArray;
    }

    @Nonnull
    public static String a(@Nonnull JsonObject jsonObject, @Nonnull String str, @Nonnull String str2) {
        if (jsonObject.has(str)) {
            JsonElement jsonElement = jsonObject.get(str);
            if (jsonElement.isJsonPrimitive()) {
                JsonPrimitive asJsonPrimitive = jsonElement.getAsJsonPrimitive();
                if (asJsonPrimitive.isString()) {
                    return asJsonPrimitive.getAsString();
                }
            }
        }
        jsonObject.addProperty(str, str2);
        return str2;
    }

    @Nonnull
    public static <E extends Enum<E>> E a(@Nonnull JsonObject jsonObject, @Nonnull String str, @Nonnull E e) {
        if (jsonObject.has(str)) {
            JsonElement jsonElement = jsonObject.get(str);
            if (jsonElement.isJsonPrimitive()) {
                JsonPrimitive asJsonPrimitive = jsonElement.getAsJsonPrimitive();
                if (asJsonPrimitive.isString()) {
                    try {
                        return (E) Enum.valueOf(e.getDeclaringClass(), asJsonPrimitive.getAsString());
                    } catch (IllegalArgumentException e2) {
                        return e;
                    }
                }
            }
        }
        jsonObject.addProperty(str, e.name());
        return e;
    }

    public static int a(@Nonnull JsonObject jsonObject, @Nonnull String str, int i) {
        if (jsonObject.has(str)) {
            JsonElement jsonElement = jsonObject.get(str);
            if (jsonElement.isJsonPrimitive()) {
                JsonPrimitive asJsonPrimitive = jsonElement.getAsJsonPrimitive();
                if (asJsonPrimitive.isNumber()) {
                    return asJsonPrimitive.getAsInt();
                }
            }
        }
        jsonObject.addProperty(str, Integer.valueOf(i));
        return i;
    }

    public static long a(@Nonnull JsonObject jsonObject, @Nonnull String str, long j) {
        if (jsonObject.has(str)) {
            JsonElement jsonElement = jsonObject.get(str);
            if (jsonElement.isJsonPrimitive()) {
                JsonPrimitive asJsonPrimitive = jsonElement.getAsJsonPrimitive();
                if (asJsonPrimitive.isNumber()) {
                    return asJsonPrimitive.getAsLong();
                }
            }
        }
        jsonObject.addProperty(str, Long.valueOf(j));
        return j;
    }

    public static float a(@Nonnull JsonObject jsonObject, @Nonnull String str, float f) {
        if (jsonObject.has(str)) {
            JsonElement jsonElement = jsonObject.get(str);
            if (jsonElement.isJsonPrimitive()) {
                JsonPrimitive asJsonPrimitive = jsonElement.getAsJsonPrimitive();
                if (asJsonPrimitive.isNumber()) {
                    return asJsonPrimitive.getAsFloat();
                }
            }
        }
        jsonObject.addProperty(str, Float.valueOf(f));
        return f;
    }

    public static double a(@Nonnull JsonObject jsonObject, @Nonnull String str, double d) {
        if (jsonObject.has(str)) {
            JsonElement jsonElement = jsonObject.get(str);
            if (jsonElement.isJsonPrimitive()) {
                JsonPrimitive asJsonPrimitive = jsonElement.getAsJsonPrimitive();
                if (asJsonPrimitive.isNumber()) {
                    return asJsonPrimitive.getAsDouble();
                }
            }
        }
        jsonObject.addProperty(str, Double.valueOf(d));
        return d;
    }

    @Nonnull
    public static BigInteger a(@Nonnull JsonObject jsonObject, @Nonnull String str, @Nonnull BigInteger bigInteger) {
        if (jsonObject.has(str)) {
            JsonElement jsonElement = jsonObject.get(str);
            if (jsonElement.isJsonPrimitive()) {
                JsonPrimitive asJsonPrimitive = jsonElement.getAsJsonPrimitive();
                if (asJsonPrimitive.isNumber()) {
                    return asJsonPrimitive.getAsBigInteger();
                }
            }
        }
        jsonObject.addProperty(str, bigInteger);
        return bigInteger;
    }

    @Nonnull
    public static BigDecimal a(@Nonnull JsonObject jsonObject, @Nonnull String str, @Nonnull BigDecimal bigDecimal) {
        if (jsonObject.has(str)) {
            JsonElement jsonElement = jsonObject.get(str);
            if (jsonElement.isJsonPrimitive()) {
                JsonPrimitive asJsonPrimitive = jsonElement.getAsJsonPrimitive();
                if (asJsonPrimitive.isNumber()) {
                    return asJsonPrimitive.getAsBigDecimal();
                }
            }
        }
        jsonObject.addProperty(str, bigDecimal);
        return bigDecimal;
    }

    public static boolean a(@Nonnull JsonObject jsonObject, @Nonnull String str, boolean z) {
        if (jsonObject.has(str)) {
            JsonElement jsonElement = jsonObject.get(str);
            if (jsonElement.isJsonPrimitive()) {
                JsonPrimitive asJsonPrimitive = jsonElement.getAsJsonPrimitive();
                if (asJsonPrimitive.isBoolean()) {
                    return asJsonPrimitive.getAsBoolean();
                }
            }
        }
        jsonObject.addProperty(str, Boolean.valueOf(z));
        return z;
    }

    @Nonnull
    public static ResourceLocation a(@Nonnull JsonObject jsonObject, @Nonnull String str, @Nonnull ResourceLocation resourceLocation) {
        ResourceLocation resourceLocationTryParse;
        if (jsonObject.has(str)) {
            JsonElement jsonElement = jsonObject.get(str);
            if (jsonElement.isJsonPrimitive()) {
                JsonPrimitive asJsonPrimitive = jsonElement.getAsJsonPrimitive();
                if (asJsonPrimitive.isString() && (resourceLocationTryParse = ResourceLocation.tryParse(asJsonPrimitive.getAsString())) != null) {
                    return resourceLocationTryParse;
                }
            }
        }
        jsonObject.addProperty(str, resourceLocation.toString());
        return resourceLocation;
    }

    @Nonnull
    public static Color a(@Nonnull JsonObject jsonObject, @Nonnull String str, @Nonnull Color color) {
        if (jsonObject.has(str)) {
            JsonElement jsonElement = jsonObject.get(str);
            if (jsonElement.isJsonPrimitive()) {
                JsonPrimitive asJsonPrimitive = jsonElement.getAsJsonPrimitive();
                if (asJsonPrimitive.isString()) {
                    String asString = asJsonPrimitive.getAsString();
                    if (asString.startsWith("#")) {
                        try {
                            long j = Long.parseLong(asString.substring(1), 16);
                            return new Color((j >> 16) & 255, (j >> 8) & 255, j & 255, (j >> 24) & 255);
                        } catch (NumberFormatException e) {
                        }
                    }
                    return Color.decode(asJsonPrimitive.getAsString());
                }
                if (asJsonPrimitive.isNumber()) {
                    try {
                        long asLong = asJsonPrimitive.getAsLong();
                        return new Color((asLong >> 16) & 255, (asLong >> 8) & 255, asLong & 255, (asLong >> 24) & 255);
                    } catch (NumberFormatException e2) {
                    }
                }
            }
        }
        jsonObject.addProperty(str, "#" + Integer.toHexString(color.getAlpha() == 255 ? color.getRGB() & 16777215 : color.getRGB()));
        return color;
    }

    @Nonnull
    public static Properties c(@Nonnull JsonObject jsonObject, @Nonnull String str, @Nonnull Supplier<Properties> supplier) {
        if (jsonObject.has(str)) {
            JsonElement jsonElement = jsonObject.get(str);
            if (jsonElement.isJsonObject()) {
                Properties properties = new Properties();
                for (Map.Entry entry : jsonElement.getAsJsonObject().entrySet()) {
                    if (((JsonElement) entry.getValue()).isJsonPrimitive()) {
                        properties.put(entry.getKey(), ((JsonElement) entry.getValue()).getAsString());
                    }
                }
                return properties;
            }
        }
        JsonObject jsonObject2 = new JsonObject();
        Properties properties2 = supplier.get();
        for (Map.Entry entry2 : properties2.entrySet()) {
            jsonObject2.addProperty(entry2.getKey().toString(), entry2.getValue().toString());
        }
        jsonObject.add(str, jsonObject2);
        return properties2;
    }

    @Nonnull
    public static Component a(@Nonnull JsonObject jsonObject, @Nonnull String str, @Nonnull Component component) {
        MutableComponent mutableComponentFromJson;
        if (jsonObject.has(str) && (mutableComponentFromJson = Component.Serializer.fromJson(jsonObject.get(str), RegistryAccess.EMPTY)) != null) {
            return mutableComponentFromJson;
        }
        jsonObject.add(str, a(component, (HolderLookup.Provider) RegistryAccess.EMPTY));
        return component;
    }

    public static JsonElement a(Component component, HolderLookup.Provider provider) {
        return (JsonElement) ComponentSerialization.CODEC.encodeStart(provider.createSerializationContext(JsonOps.INSTANCE), component).getOrThrow(JsonParseException::new);
    }

    public static int a(@Nonnull JsonElement jsonElement, int i) {
        if (jsonElement.isJsonPrimitive()) {
            JsonPrimitive asJsonPrimitive = jsonElement.getAsJsonPrimitive();
            if (asJsonPrimitive.isNumber()) {
                return asJsonPrimitive.getAsInt();
            }
        }
        return i;
    }
}
