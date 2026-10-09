package mctech.api.gui;

import it.unimi.dsi.fastutil.objects.Object2ObjectMaps;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import java.util.Map;
import java.util.function.BiFunction;
import mctech.config.utils.IEntryDataType;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/gui/DataType.class */
public class DataType {
    public static final DataType BOOLEAN = null;
    public static final DataType INTEGER = null;
    public static final DataType DOUBLE = null;
    public static final DataType STRING = null;
    private static final Map<Class<?>, DataType> AUTO_DATA_TYPES = Object2ObjectMaps.synchronize(new Object2ObjectOpenHashMap());
    boolean allowsEmptyValue;
    String defaultValue;
    BiFunction<IConfigNode, IValueNode, ConfigElement> creator;
    IArrayFunction arrayCreator;

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/gui/DataType$IArrayFunction.class */
    public interface IArrayFunction {
        ConfigElement create(IConfigNode iConfigNode, IArrayNode iArrayNode, int i);
    }

    public DataType(boolean z, String str, BiFunction<IConfigNode, IValueNode, ConfigElement> biFunction, IArrayFunction iArrayFunction) {
        this.allowsEmptyValue = z;
        this.defaultValue = str;
        this.creator = biFunction;
        this.arrayCreator = iArrayFunction;
    }

    public ConfigElement create(IConfigNode iConfigNode) {
        return this.creator.apply(iConfigNode, iConfigNode.asValue());
    }

    public ConfigElement create(IConfigNode iConfigNode, IValueNode iValueNode) {
        return this.creator.apply(iConfigNode, iValueNode);
    }

    public ConfigElement create(IConfigNode iConfigNode, IArrayNode iArrayNode, int i) {
        return this.arrayCreator.create(iConfigNode, iArrayNode, i);
    }

    public String getDefaultValue() {
        return this.defaultValue;
    }

    public boolean isAllowEmptyValue() {
        return this.allowsEmptyValue;
    }

    public static DataType bySimple(IEntryDataType.SimpleDataType simpleDataType) {
        return byConfig(simpleDataType.getType(), simpleDataType.getVariant());
    }

    public static DataType byConfig(IEntryDataType.EntryDataType entryDataType, Class<?> cls) {
        switch (entryDataType) {
            case BOOLEAN:
                return BOOLEAN;
            case INTEGER:
                return INTEGER;
            case DOUBLE:
                return DOUBLE;
            case STRING:
                return STRING;
            case CUSTOM:
                return byClass(cls);
            default:
                throw new IllegalStateException("Undefined DataType shouldn't be used");
        }
    }

    public static DataType byClass(Class<?> cls) {
        return AUTO_DATA_TYPES.getOrDefault(cls, STRING);
    }

    public static void registerType(Class<?> cls, DataType dataType) {
        AUTO_DATA_TYPES.putIfAbsent(cls, dataType);
    }
}
