package mctech.config;

import it.unimi.dsi.fastutil.objects.Object2ObjectLinkedOpenHashMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectMaps;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.concurrent.atomic.AtomicInteger;
import mctech.api.IConfigSerializer;
import mctech.config.utils.Helpers;
import mctech.config.utils.MultilinePolicy;
import mctech.config.utils.SyncType;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/config/ConfigSection.class */
public class ConfigSection {
    private String name;
    private String[] comment;
    private ConfigSection parent = null;
    private boolean used = false;
    private Object2ObjectMap<String, ConfigEntry<?>> entries = new Object2ObjectLinkedOpenHashMap();
    private Object2ObjectMap<String, ConfigSection> subSections = new Object2ObjectLinkedOpenHashMap();

    public ConfigSection(String str) {
        if (Helpers.validateString(str)) {
            throw new IllegalArgumentException("ConfigSection name must not be null, empty or start/end with white spaces");
        }
        if (str.contains(".")) {
            throw new IllegalArgumentException("ConfigSection name must not contain period signs. Name: " + str);
        }
        this.name = str;
    }

    public ConfigSection setComment(String... strArr) {
        this.comment = Helpers.validateComments(strArr);
        return this;
    }

    void parseComment(String... strArr) {
        if (strArr != null) {
            return;
        }
        this.comment = Helpers.validateComments(strArr);
    }

    public <V, T extends ConfigEntry<V>> T add(T t) {
        ConfigEntry configEntry = (ConfigEntry) this.entries.get(t.getKey());
        if (configEntry != null) {
            if (!(configEntry instanceof ConfigEntry.TempValue)) {
                return (T) (configEntry.getPrefix() != t.getPrefix() ? t : configEntry).setUsed();
            }
            t.deserializeValue(configEntry.serialize());
        }
        this.entries.put(t.getKey(), t.setUsed());
        return t;
    }

    <V, T extends ConfigEntry<V>> T addParsed(T t) {
        this.entries.putIfAbsent(t.getKey(), t);
        return t;
    }

    public ConfigEntry.BoolValue addBool(String str, boolean z, String str2) {
        return (ConfigEntry.BoolValue) add(new ConfigEntry.BoolValue(str, Boolean.valueOf(z), str2));
    }

    public ConfigEntry.BoolValue addBool(String str, boolean z) {
        return (ConfigEntry.BoolValue) add(new ConfigEntry.BoolValue(str, Boolean.valueOf(z)));
    }

    public ConfigEntry.IntValue addInt(String str, int i, String str2) {
        return (ConfigEntry.IntValue) add(new ConfigEntry.IntValue(str, Integer.valueOf(i), str2));
    }

    public ConfigEntry.IntValue addInt(String str, int i) {
        return (ConfigEntry.IntValue) add(new ConfigEntry.IntValue(str, Integer.valueOf(i)));
    }

    public ConfigEntry.DoubleValue addDouble(String str, double d, String... strArr) {
        return (ConfigEntry.DoubleValue) add(new ConfigEntry.DoubleValue(str, Double.valueOf(d), strArr));
    }

    public ConfigEntry.DoubleValue addDouble(String str, double d) {
        return (ConfigEntry.DoubleValue) add(new ConfigEntry.DoubleValue(str, Double.valueOf(d)));
    }

    public ConfigEntry.StringValue addString(String str, String str2, String... strArr) {
        return (ConfigEntry.StringValue) add(new ConfigEntry.StringValue(str, str2, strArr));
    }

    public ConfigEntry.StringValue addString(String str, String str2) {
        return (ConfigEntry.StringValue) add(new ConfigEntry.StringValue(str, str2));
    }

    public ConfigEntry.ArrayValue addArray(String str, String[] strArr, String... strArr2) {
        return (ConfigEntry.ArrayValue) add(new ConfigEntry.ArrayValue(str, strArr, strArr2));
    }

    public ConfigEntry.ArrayValue addArray(String str, String[] strArr) {
        return (ConfigEntry.ArrayValue) add(new ConfigEntry.ArrayValue(str, strArr));
    }

    public ConfigEntry.ArrayValue addArray(String str, String str2) {
        return (ConfigEntry.ArrayValue) add(new ConfigEntry.ArrayValue(str, str2));
    }

    public ConfigEntry.ArrayValue addArray(String str) {
        return (ConfigEntry.ArrayValue) add(new ConfigEntry.ArrayValue(str));
    }

    public <E extends Enum<E>> ConfigEntry.EnumValue<E> addEnum(String str, E e, Class<E> cls, String... strArr) {
        return (ConfigEntry.EnumValue) add(new ConfigEntry.EnumValue(str, e, cls, strArr));
    }

    public <E extends Enum<E>> ConfigEntry.EnumValue<E> addEnum(String str, E e, Class<E> cls) {
        return (ConfigEntry.EnumValue) add(new ConfigEntry.EnumValue(str, e, cls));
    }

    public <T> ConfigEntry.ParsedValue<T> addParsed(String str, T t, IConfigSerializer<T> iConfigSerializer, String... strArr) {
        return (ConfigEntry.ParsedValue) add(new ConfigEntry.ParsedValue(str, t, iConfigSerializer, strArr));
    }

    public <T> ConfigEntry.ParsedValue<T> addParsed(String str, T t, IConfigSerializer<T> iConfigSerializer) {
        return (ConfigEntry.ParsedValue) add(new ConfigEntry.ParsedValue(str, t, iConfigSerializer));
    }

    public <T> ConfigEntry.ParsedArray<T> addParsedArray(String str, List<T> list, IConfigSerializer<T> iConfigSerializer, String... strArr) {
        return (ConfigEntry.ParsedArray) add(new ConfigEntry.ParsedArray(str, list, iConfigSerializer, strArr));
    }

    public <T> ConfigEntry.ParsedArray<T> addParsedArray(String str, List<T> list, IConfigSerializer<T> iConfigSerializer) {
        return (ConfigEntry.ParsedArray) add(new ConfigEntry.ParsedArray(str, list, iConfigSerializer));
    }

    public ConfigSection addSubSection(String str) {
        ConfigSection configSection = (ConfigSection) this.subSections.get(str);
        if (configSection == null) {
            configSection = new ConfigSection(str);
            configSection.parent = this;
            this.subSections.put(str, configSection);
        }
        return configSection.setUsed();
    }

    public ConfigSection add(ConfigSection configSection) {
        if (configSection.parent != null) {
            throw new IllegalStateException("ConfigSection must not be added to multiple sections. Section name: " + configSection.getName());
        }
        configSection.parent = this;
        this.subSections.putIfAbsent(configSection.name, configSection);
        return configSection.setUsed();
    }

    public ConfigEntry<?> getEntry(String str) {
        return (ConfigEntry) this.entries.get(str);
    }

    public ConfigSection getSubSection(String str) {
        return (ConfigSection) this.subSections.get(str);
    }

    ConfigSection parseSubSection(String str) {
        ConfigSection configSection = (ConfigSection) this.subSections.get(str);
        if (configSection == null) {
            configSection = new ConfigSection(str);
            configSection.parent = this;
            this.subSections.put(str, configSection);
        }
        return configSection;
    }

    public List<ConfigSection> getChildren() {
        return new ObjectArrayList(this.subSections.values());
    }

    public List<ConfigEntry<?>> getEntries() {
        return new ObjectArrayList(this.entries.values());
    }

    protected ConfigSection copy() {
        ConfigSection configSection = new ConfigSection(this.name);
        ObjectIterator it = this.subSections.values().iterator();
        while (it.hasNext()) {
            configSection.add(((ConfigSection) it.next()).copy());
        }
        ObjectIterator it2 = this.entries.values().iterator();
        while (it2.hasNext()) {
            configSection.add(((ConfigEntry) it2.next()).deepCopy());
        }
        return configSection;
    }

    public void resetDefault() {
        this.subSections.values().forEach((v0) -> {
            v0.resetDefault();
        });
        this.entries.values().forEach((v0) -> {
            v0.resetDefault();
        });
    }

    boolean hasChanged() {
        ObjectIterator it = this.entries.values().iterator();
        while (it.hasNext()) {
            if (((ConfigEntry) it.next()).hasChanged()) {
                return true;
            }
        }
        ObjectIterator it2 = this.subSections.values().iterator();
        while (it2.hasNext()) {
            if (((ConfigSection) it2.next()).hasChanged()) {
                return true;
            }
        }
        return false;
    }

    boolean isDefault() {
        ObjectIterator it = this.entries.values().iterator();
        while (it.hasNext()) {
            if (!((ConfigEntry) it.next()).isDefault()) {
                return false;
            }
        }
        ObjectIterator it2 = this.subSections.values().iterator();
        while (it2.hasNext()) {
            if (!((ConfigSection) it2.next()).isDefault()) {
                return false;
            }
        }
        return true;
    }

    public ConfigSection getParent() {
        return this.parent;
    }

    public String getName() {
        return this.name;
    }

    public String getSectionPath() {
        return (this.parent != null ? this.parent.getSectionPath() : "") + this.name;
    }

    boolean isUsed() {
        return this.used;
    }

    ConfigSection setUsed() {
        this.used = true;
        return this;
    }

    void getSyncedEntries(Map<String, ConfigEntry<?>> map, SyncType syncType) {
        ObjectIterator it = this.entries.values().iterator();
        while (it.hasNext()) {
            ConfigEntry<?> configEntry = (ConfigEntry) it.next();
            if (configEntry.getSyncType() == syncType) {
                map.put(getSectionPath() + "." + configEntry.getKey(), configEntry);
            }
        }
        ObjectIterator it2 = this.subSections.values().iterator();
        while (it2.hasNext()) {
            ((ConfigSection) it2.next()).getSyncedEntries(map, syncType);
        }
    }

    public String serialize(MultilinePolicy multilinePolicy) {
        return serialize(multilinePolicy, 0);
    }

    public String serialize(MultilinePolicy multilinePolicy, int i) {
        if (this.entries.size() == 0 && this.subSections.size() == 0) {
            return null;
        }
        AtomicInteger atomicInteger = new AtomicInteger(0);
        StringBuilder sb = new StringBuilder(this.parent == null ? "" : "\n" + Helpers.generateIndent(i));
        if (this.comment != null && this.comment.length > 0) {
            String str = "\n" + Helpers.generateIndent(i);
            for (int i2 = 0; i2 < this.comment.length; i2++) {
                sb.append(str);
                sb.append("# ");
                sb.append(this.comment[i2].replaceAll("\\R", str + "# "));
            }
            sb.append(str);
            sb.delete(0, 1);
        }
        sb.append('[');
        sb.append(getSectionPath());
        sb.append(']');
        int i3 = i + 1;
        Object2ObjectMaps.fastForEach(this.entries, entry -> {
            if (!((ConfigEntry) entry.getValue()).isUsed()) {
                return;
            }
            sb.append(((ConfigEntry) entry.getValue()).serialize(multilinePolicy, i3));
            atomicInteger.incrementAndGet();
        });
        StringJoiner stringJoiner = new StringJoiner("\n", (this.entries.size() == 0 || this.subSections.size() == 0) ? "" : "\n", "");
        Object2ObjectMaps.fastForEach(this.subSections, entry2 -> {
            String strSerialize;
            if (!((ConfigSection) entry2.getValue()).isUsed() || (strSerialize = ((ConfigSection) entry2.getValue()).serialize(multilinePolicy, i3)) == null) {
                return;
            }
            stringJoiner.add(strSerialize);
            atomicInteger.getAndIncrement();
        });
        sb.append(stringJoiner.toString());
        if (atomicInteger.get() > 0) {
            return sb.toString();
        }
        return null;
    }
}
