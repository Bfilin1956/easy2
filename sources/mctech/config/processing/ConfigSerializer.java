package mctech.config.processing;

import com.google.gson.JsonObject;
import java.lang.reflect.Field;
import java.util.Arrays;
import mctech.config.ConfigHolder;
import mctech.config.annotation.BooleanValue;
import mctech.config.annotation.DoubleValue;
import mctech.config.annotation.FloatValue;
import mctech.config.annotation.IntValue;
import mctech.config.annotation.ObjectValue;
import mctech.config.annotation.StringValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/config/processing/ConfigSerializer.class */
public class ConfigSerializer {
    private static boolean isConfigField(@Nullable Field field) {
        if (field == null) {
            return false;
        }
        return field.isAnnotationPresent(BooleanValue.class) || field.isAnnotationPresent(DoubleValue.class) || field.isAnnotationPresent(FloatValue.class) || field.isAnnotationPresent(IntValue.class) || field.isAnnotationPresent(StringValue.class) || field.isAnnotationPresent(ObjectValue.class);
    }

    public static <Config extends ConfigHolder<Config>> JsonObject serialize(Config config) {
        JsonObject jsonObject = new JsonObject();
        Arrays.stream(config.getClass().getDeclaredFields()).filter(ConfigSerializer::isConfigField).forEach(field -> {
            try {
                config.set(jsonObject, field.getName(), field.get(config));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        });
        return jsonObject;
    }

    public static <Config extends ConfigHolder<Config>> Config deserialize(Config config, @NotNull JsonObject jsonObject) {
        Arrays.stream(config.getClass().getDeclaredFields()).filter(ConfigSerializer::isConfigField).forEach(field -> {
            try {
                if (field.isAnnotationPresent(BooleanValue.class)) {
                    field.set(config, config.get(jsonObject, field.getName(), Boolean.valueOf(((BooleanValue) field.getAnnotation(BooleanValue.class)).defaultValue())));
                } else if (field.isAnnotationPresent(DoubleValue.class)) {
                    field.set(config, config.get(jsonObject, field.getName(), Double.valueOf(((DoubleValue) field.getAnnotation(DoubleValue.class)).defaultValue())));
                } else if (field.isAnnotationPresent(FloatValue.class)) {
                    field.set(config, config.get(jsonObject, field.getName(), Float.valueOf(((FloatValue) field.getAnnotation(FloatValue.class)).defaultValue())));
                } else if (field.isAnnotationPresent(IntValue.class)) {
                    field.set(config, config.get(jsonObject, field.getName(), Integer.valueOf(((IntValue) field.getAnnotation(IntValue.class)).defaultValue())));
                } else if (field.isAnnotationPresent(StringValue.class)) {
                    field.set(config, config.get(jsonObject, field.getName(), ((StringValue) field.getAnnotation(StringValue.class)).defaultValue()));
                } else if (field.isAnnotationPresent(ObjectValue.class)) {
                    field.set(config, config.get(jsonObject, field.getName(), (Class) field.getClass()));
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        });
        return config;
    }
}
