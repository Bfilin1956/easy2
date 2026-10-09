package mctech.config;

import com.electronwill.nightconfig.core.AbstractConfig;
import mctech.config.IConfig;
import net.neoforged.neoforge.common.ModConfigSpec;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/config/IConfig.class */
public interface IConfig<C extends IConfig<C>> {
    void buildEntry(String str, ModConfigSpec.Builder builder);

    C update(AbstractConfig abstractConfig);

    default int getInt(AbstractConfig abstractConfig, String str, int i) {
        ModConfigSpec.IntValue intValue = (ModConfigSpec.IntValue) abstractConfig.get(str);
        if (intValue != null) {
            return intValue.getAsInt();
        }
        return i;
    }

    default long getLong(AbstractConfig abstractConfig, String str, long j) {
        ModConfigSpec.LongValue longValue = (ModConfigSpec.LongValue) abstractConfig.get(str);
        if (longValue != null) {
            return longValue.getAsLong();
        }
        return j;
    }

    default boolean getBoolean(AbstractConfig abstractConfig, String str, boolean z) {
        ModConfigSpec.BooleanValue booleanValue = (ModConfigSpec.BooleanValue) abstractConfig.get(str);
        if (booleanValue != null) {
            return booleanValue.getAsBoolean();
        }
        return z;
    }

    default double getDouble(AbstractConfig abstractConfig, String str, double d) {
        ModConfigSpec.DoubleValue doubleValue = (ModConfigSpec.DoubleValue) abstractConfig.get(str);
        if (doubleValue != null) {
            return doubleValue.getAsDouble();
        }
        return d;
    }

    default String getString(AbstractConfig abstractConfig, String str, String str2) {
        ModConfigSpec.ConfigValue configValue = (ModConfigSpec.ConfigValue) abstractConfig.get(str);
        if (configValue != null) {
            return (String) configValue.get();
        }
        return str2;
    }

    default <T extends Enum<T>> T getEnum(AbstractConfig abstractConfig, String str, T t) {
        ModConfigSpec.EnumValue enumValue = (ModConfigSpec.EnumValue) abstractConfig.get(str);
        if (enumValue != null) {
            return (T) enumValue.get();
        }
        return t;
    }
}
