package mctech.config;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.runtime.SwitchBootstraps;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import mctech.config.processing.IConfigSerializer;
import mctech.utils.math.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/config/ConfigHolder.class */
public abstract class ConfigHolder<Holder> implements IConfigSerializer<ConfigHolder<Holder>> {
    public <Value> Value get(@NotNull JsonObject jsonObject, @NotNull String str, Class<Value> cls) {
        if (jsonObject.has(str)) {
            JsonElement jsonElement = jsonObject.get(str);
            if (jsonElement.isJsonObject()) {
                return (Value) new Gson().fromJson(jsonElement, cls);
            }
            if (jsonElement.isJsonArray()) {
                return (Value) new ArrayList();
            }
            System.err.println("Cannot obtain " + str + " unknown type");
            return null;
        }
        System.err.println("Cannot obtain " + str + " cause is not defined in json");
        return null;
    }

    @Nullable
    public <Value> Value get(@NotNull JsonObject jsonObject, @NotNull String str, Value value) {
        if (jsonObject.has(str)) {
            JsonElement jsonElement = jsonObject.get(str);
            if (jsonElement.isJsonPrimitive()) {
                JsonPrimitive asJsonPrimitive = jsonElement.getAsJsonPrimitive();
                if (asJsonPrimitive.isString() && (value instanceof String)) {
                    return (Value) asJsonPrimitive.getAsString();
                }
                if (asJsonPrimitive.isBoolean() && (value instanceof Boolean)) {
                    return (Value) Boolean.valueOf(asJsonPrimitive.getAsBoolean());
                }
                if (asJsonPrimitive.isNumber() && (value instanceof Number)) {
                    return (Value) asJsonPrimitive.getAsNumber();
                }
                System.err.println("Cannot obtain primitive " + str + " cause default value not primitive");
                return value;
            }
            if (jsonElement.isJsonObject()) {
                return (Value) new Gson().fromJson(jsonElement, value.getClass());
            }
            if (jsonElement.isJsonArray()) {
                return (Value) new Gson().fromJson(jsonElement, new ListTypeToken(value.getClass()));
            }
            System.err.println("Cannot obtain " + str + " unknown type");
            return value;
        }
        System.err.println("Cannot obtain " + str + " cause is not defined in json");
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <Value> void set(@NotNull JsonObject jsonObject, @NotNull String str, Value value) {
        switch ((int) SwitchBootstraps.typeSwitch(MethodHandles.lookup(), "typeSwitch", MethodType.methodType(Integer.TYPE, Object.class, Integer.TYPE), String.class, Number.class, Boolean.class, Character.class, Collection.class).dynamicInvoker().invoke(value, 0) /* invoke-custom */) {
            case a.b /* -1 */:
                System.err.println("Cannot set " + str + " as NULL value");
                break;
            case 0:
                jsonObject.addProperty(str, (String) value);
                break;
            case 1:
                jsonObject.addProperty(str, (Number) value);
                break;
            case 2:
                jsonObject.addProperty(str, (Boolean) value);
                break;
            case 3:
                jsonObject.addProperty(str, (Character) value);
                break;
            case 4:
                Collection collection = (Collection) value;
                JsonArray jsonArray = new JsonArray(collection.size());
                collection.forEach(obj -> {
                    jsonArray.add(new Gson().toJsonTree(obj));
                });
                jsonObject.add(str, jsonArray);
                break;
            default:
                jsonObject.add(str, new Gson().toJsonTree(value));
                break;
        }
    }

    public <Value> Value getOrCreate(@NotNull JsonObject jsonObject, @NotNull String str, Value value) {
        Value value2 = (Value) get(jsonObject, str, value);
        if (value2 == null) {
            set(jsonObject, str, value);
        }
        return value2 == null ? value : value2;
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/config/ConfigHolder$ListTypeToken.class */
    private static class ListTypeToken<T> implements ParameterizedType {
        private final Class<?> clazz;

        /* JADX WARN: Multi-variable type inference failed */
        public ListTypeToken(Class<T> cls) {
            this.clazz = cls;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return new Type[]{this.clazz};
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return List.class;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getOwnerType() {
            return null;
        }
    }
}
