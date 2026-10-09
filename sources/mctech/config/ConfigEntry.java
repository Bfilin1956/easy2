package mctech.config;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectLists;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.UUID;
import java.util.function.Function;
import java.util.function.Predicate;
import mctech.api.IConfigSerializer;
import mctech.api.IReloadMode;
import mctech.api.ISuggestedEnum;
import mctech.api.buffer.IReadBuffer;
import mctech.api.buffer.IWriteBuffer;
import mctech.config.utils.Helpers;
import mctech.config.utils.IEntryDataType;
import mctech.config.utils.MultilinePolicy;
import mctech.config.utils.ParseResult;
import mctech.config.utils.SyncType;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/config/ConfigEntry.class */
public abstract class ConfigEntry<T> {
    private String key;
    private T value;
    private T defaultValue;
    private T lastValue;
    private String[] comment;
    private SyncedConfig<ConfigEntry<T>> syncCache;
    private boolean used = false;
    private boolean serverSync = false;
    private IReloadMode reload = null;
    private List<Suggestion> suggestions = new ObjectArrayList();

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/config/ConfigEntry$IArrayConfig.class */
    public interface IArrayConfig {
        List<String> getEntries();

        List<String> getDefaults();

        ParseResult<Boolean> canSetArray(List<String> list);

        void setArray(List<String> list);
    }

    protected abstract ConfigEntry<T> copy();

    public abstract ParseResult<T> parseValue(String str);

    public abstract IEntryDataType getDataType();

    public abstract char getPrefix();

    public abstract String getLimitations();

    public abstract void serialize(IWriteBuffer iWriteBuffer);

    protected abstract void deserializeValue(IReadBuffer iReadBuffer);

    public ConfigEntry(String str, T t, String... strArr) {
        if (Helpers.validateString(str)) {
            throw new IllegalArgumentException("ConfigEntry key must not be null, empty or start/end with white spaces");
        }
        if (str.contains(":") || str.contains("=")) {
            throw new IllegalArgumentException("ConfigEntry key must not contain any ':' or '=' signs. Key: " + str);
        }
        if (t == null) {
            throw new IllegalArgumentException("ConfigEntry default value must not be null. Key: " + str);
        }
        this.key = str;
        this.value = t;
        this.defaultValue = t;
        this.comment = Helpers.validateComments(strArr);
    }

    public String[] getComment() {
        return this.comment;
    }

    void parseComment(String... strArr) {
        if (this.comment == null) {
            this.comment = Helpers.validateComments(strArr);
        }
    }

    public ConfigEntry<T> setComment(String... strArr) {
        this.comment = Helpers.validateComments(strArr);
        return this;
    }

    protected ConfigEntry<T> deepCopy() {
        ConfigEntry<T> configEntryCopy = copy();
        configEntryCopy.suggestions.addAll(this.suggestions);
        return configEntryCopy;
    }

    public T getValue() {
        return this.value;
    }

    public T getDefault() {
        return this.defaultValue;
    }

    public ParseResult<Boolean> canSetValue(String str) {
        ParseResult<T> value = parseValue(str);
        return value.hasError() ? value.withDefault(false) : canSet(value.getValue());
    }

    public ParseResult<Boolean> canSet(T t) {
        return ParseResult.result(t != null, NullPointerException::new, "Value isn't allowed to be null");
    }

    public ConfigEntry<T> set(T t) {
        if (t != null) {
            this.value = t;
        }
        return this;
    }

    public String getKey() {
        return this.key;
    }

    protected final <S extends ConfigEntry<T>> S addSuggestionInternal(String str) {
        return (S) addSuggestionInternal(str, str, null);
    }

    protected final <S extends ConfigEntry<T>> S addSuggestionInternal(String str, String str2) {
        return (S) addSuggestionInternal(str, str2, null);
    }

    protected final <S extends ConfigEntry<T>> S addSuggestionInternal(Object obj, String str) {
        return (S) addSuggestionInternal(str, str, obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected final <S extends ConfigEntry<T>> S addSuggestionInternal(String str, String str2, Object obj) {
        if (!canSetValue(str2).getValue().booleanValue()) {
            throw new IllegalArgumentException("Value [" + str2 + "] is not valid. Meaning it can not be a suggestion");
        }
        this.suggestions.add(new Suggestion(str, str2, obj));
        return this;
    }

    public final List<Suggestion> getSuggestions() {
        return this.suggestions;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <S extends ConfigEntry<T>> S clearSuggestions() {
        this.suggestions.clear();
        return this;
    }

    boolean isUsed() {
        return this.used;
    }

    ConfigEntry<T> setUsed() {
        this.used = true;
        return this;
    }

    public final boolean hasChanged() {
        return this.used && (!this.value.getClass().isArray() ? Objects.equals(this.lastValue, this.value) : Objects.deepEquals(this.lastValue, this.value));
    }

    public final boolean isDefault() {
        return this.used && (!this.value.getClass().isArray() ? !Objects.equals(this.defaultValue, this.value) : !Objects.deepEquals(this.defaultValue, this.value));
    }

    public final IReloadMode getReloadState() {
        return this.reload;
    }

    public final void onSynced() {
        this.lastValue = this.value;
    }

    SyncType getSyncType() {
        if (this.syncCache != null) {
            return SyncType.CLIENT_TO_SERVER;
        }
        return this.serverSync ? SyncType.SERVER_TO_CLIENT : SyncType.NONE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <S extends ConfigEntry<T>> S setServerSynced() {
        if (this.syncCache != null) {
            throw new IllegalStateException("Client Synced Configs can not Server Sync");
        }
        this.serverSync = true;
        return this;
    }

    public final <S extends ConfigEntry<T>> SyncedConfig<S> setClientSynced() {
        if (this.serverSync) {
            throw new IllegalStateException("Server Synced Configs can not Client Sync");
        }
        if (this.syncCache == null) {
            this.syncCache = new SyncedConfig<>(() -> {
                return copy();
            }, this);
        }
        return this.syncCache;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <S extends ConfigEntry<T>> S setRequiredReload(IReloadMode iReloadMode) {
        this.reload = iReloadMode;
        return this;
    }

    public ConfigEntry<T> setKey(String str) {
        if (Helpers.validateString(str)) {
            throw new IllegalArgumentException("ConfigEntry key must not be null, empty or start/end with white spaces");
        }
        if (str.contains(":") || str.contains("=")) {
            throw new IllegalArgumentException("ConfigEntry key must not contain any ':' or '=' signs. Key: " + str);
        }
        this.key = str;
        return this;
    }

    public ParseResult<String> deserializeValue(String str) {
        ParseResult<T> value = parseValue(str);
        if (value.hasError()) {
            return value.withDefault(str);
        }
        set(value.getValue());
        return ParseResult.success(str);
    }

    public void resetDefault() {
        this.value = this.defaultValue;
    }

    public String serializeDefault() {
        return serializedValue(MultilinePolicy.DISABLED, this.defaultValue);
    }

    public String serialize() {
        return serializedValue(MultilinePolicy.DISABLED, this.value);
    }

    protected String serializedValue(MultilinePolicy multilinePolicy, T t) {
        return String.valueOf(t);
    }

    protected String serializeArray(MultilinePolicy multilinePolicy, String... strArr) {
        if (multilinePolicy == MultilinePolicy.MULTILINE_IF_TO_LONG) {
            StringBuilder sb = new StringBuilder();
            int length = 0;
            for (String str : strArr) {
                if (length > 0 && length + str.length() > 75) {
                    sb.append('\n');
                    length = 0;
                }
                sb.append(str).append(", ");
                length += str.length() + 2;
            }
            sb.setLength(sb.length() - 2);
            return sb.toString();
        }
        StringJoiner stringJoiner = new StringJoiner(multilinePolicy == MultilinePolicy.ALWAYS_MULTILINE ? ", \n" : ", ");
        for (String str2 : strArr) {
            stringJoiner.add(str2);
        }
        return stringJoiner.toString();
    }

    public final String serialize(MultilinePolicy multilinePolicy, int i) {
        String str = "\n" + Helpers.generateIndent(i);
        StringBuilder sb = new StringBuilder();
        if (this.comment != null && this.comment.length > 0) {
            sb.append('\n');
            for (int i2 = 0; i2 < this.comment.length; i2++) {
                sb.append(str);
                sb.append("# ");
                sb.append(this.comment[i2].replaceAll("\\R", str + "# "));
            }
        }
        String limitations = getLimitations();
        if (limitations != null && !limitations.isEmpty()) {
            if (sb.length() == 0) {
                sb.append("\n");
            }
            sb.append(str);
            sb.append("#").append((char) 8203).append(" ");
            sb.append(limitations);
        }
        sb.append(str);
        sb.append(getPrefix());
        sb.append(':');
        sb.append(this.key);
        sb.append('=');
        String strSerializedValue = serializedValue(multilinePolicy, this.value);
        if (multilinePolicy != MultilinePolicy.DISABLED && (this instanceof IArrayConfig) && strSerializedValue.contains("\n")) {
            String str2 = "\n" + Helpers.generateIndent(i + 1);
            sb.append(" < ").append(str2).append(strSerializedValue.replaceAll("\\R", str2));
            sb.append(str).append(">");
        } else {
            sb.append(strSerializedValue);
        }
        return sb.toString();
    }

    public void deserialize(IReadBuffer iReadBuffer, UUID uuid) {
        if (this.syncCache != null) {
            this.syncCache.onSync(iReadBuffer, uuid);
        } else {
            deserializeValue(iReadBuffer);
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/config/ConfigEntry$Suggestion.class */
    public static class Suggestion {
        String name;
        String value;
        Object extra;

        public Suggestion(String str) {
            this(str, str, null);
        }

        public Suggestion(String str, Object obj) {
            this(str, str, obj);
        }

        public Suggestion(String str, String str2) {
            this(str, str2, null);
        }

        public Suggestion(String str, String str2, Object obj) {
            this.name = str;
            this.value = str2;
            this.extra = obj;
        }

        public String getName() {
            return this.name;
        }

        public String getValue() {
            return this.value;
        }

        public Object getExtra() {
            return this.extra;
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/config/ConfigEntry$BasicConfigEntry.class */
    public static abstract class BasicConfigEntry<T> extends ConfigEntry<T> {
        public BasicConfigEntry(String str, T t, String... strArr) {
            super(str, t, strArr);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final <S extends BasicConfigEntry<T>> S addSuggestions(T... tArr) {
            for (T t : tArr) {
                addSuggestionInternal(serializedValue(MultilinePolicy.DISABLED, t));
            }
            return this;
        }

        public final <S extends BasicConfigEntry<T>> S addSuggestion(T t) {
            return (S) addSuggestionInternal(serializedValue(MultilinePolicy.DISABLED, t));
        }

        public final <S extends BasicConfigEntry<T>> S addSuggestion(T t, Object obj) {
            return (S) addSuggestionInternal(obj, serializedValue(MultilinePolicy.DISABLED, t));
        }

        public final <S extends BasicConfigEntry<T>> S addSuggestion(String str, T t) {
            return (S) addSuggestionInternal(str, serializedValue(MultilinePolicy.DISABLED, t));
        }

        public final <S extends BasicConfigEntry<T>> S addSuggestion(String str, T t, Object obj) {
            return (S) addSuggestionInternal(str, serializedValue(MultilinePolicy.DISABLED, t), obj);
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/config/ConfigEntry$ArrayConfigEntry.class */
    public static abstract class ArrayConfigEntry<T> extends ConfigEntry<T[]> {
        public ArrayConfigEntry(String str, T[] tArr, String... strArr) {
            super(str, tArr, strArr);
        }

        public <K, V> MappedConfig<K, V> createdMappedConfig(ConfigHandler configHandler, Function<T, K> function, Function<T, V> function2) {
            return MappedConfig.create(configHandler, this, function, function2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final <S extends ArrayConfigEntry<T>> S addSuggestions(T... tArr) {
            for (T t : tArr) {
                addSuggestionInternal(serializedValue(MultilinePolicy.DISABLED, toArray(t)));
            }
            return this;
        }

        public final <S extends ArrayConfigEntry<T>> S addSuggestion(T t) {
            return (S) addSuggestionInternal(serializedValue(MultilinePolicy.DISABLED, toArray(t)));
        }

        public final <S extends ArrayConfigEntry<T>> S addSuggestion(T t, Object obj) {
            return (S) addSuggestionInternal(obj, serializedValue(MultilinePolicy.DISABLED, toArray(t)));
        }

        public final <S extends ArrayConfigEntry<T>> S addSuggestion(String str, T t) {
            return (S) addSuggestionInternal(str, serializedValue(MultilinePolicy.DISABLED, toArray(t)));
        }

        public final <S extends ArrayConfigEntry<T>> S addSuggestion(String str, T t, Object obj) {
            return (S) addSuggestionInternal(str, serializedValue(MultilinePolicy.DISABLED, toArray(t)), obj);
        }

        T[] toArray(T t) {
            T[] tArr = (T[]) ((Object[]) Array.newInstance(t.getClass(), 1));
            tArr[0] = t;
            return tArr;
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/config/ConfigEntry$CollectionConfigEntry.class */
    public static abstract class CollectionConfigEntry<T, E extends Collection<T>> extends ConfigEntry<E> {
        protected abstract E create(T t);

        public CollectionConfigEntry(String str, E e, String... strArr) {
            super(str, e, strArr);
        }

        public <K, V> MappedConfig<K, V> createdMappedConfig(ConfigHandler configHandler, Function<T, K> function, Function<T, V> function2) {
            return MappedConfig.create(configHandler, this, function, function2);
        }

        public final <S extends CollectionConfigEntry<T, E>> S addSuggestions(T... tArr) {
            for (T t : tArr) {
                addSuggestionInternal(serializedValue(MultilinePolicy.DISABLED, create(t)));
            }
            return this;
        }

        public final <S extends CollectionConfigEntry<T, E>> S addSuggestion(T t) {
            return (S) addSuggestionInternal(serializedValue(MultilinePolicy.DISABLED, create(t)));
        }

        public final <S extends CollectionConfigEntry<T, E>> S addSuggestion(T t, Object obj) {
            return (S) addSuggestionInternal(obj, serializedValue(MultilinePolicy.DISABLED, create(t)));
        }

        public final <S extends CollectionConfigEntry<T, E>> S addSuggestion(String str, T t) {
            return (S) addSuggestionInternal(str, serializedValue(MultilinePolicy.DISABLED, create(t)));
        }

        public final <S extends CollectionConfigEntry<T, E>> S addSuggestion(String str, T t, Object obj) {
            return (S) addSuggestionInternal(str, serializedValue(MultilinePolicy.DISABLED, create(t)), obj);
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/config/ConfigEntry$IntValue.class */
    public static class IntValue extends BasicConfigEntry<Integer> {
        private int min;
        private int max;

        public IntValue(String str, Integer num, String... strArr) {
            super(str, num, strArr);
            this.min = Integer.MIN_VALUE;
            this.max = Integer.MAX_VALUE;
        }

        public IntValue(String str, Integer num) {
            super(str, num, new String[0]);
            this.min = Integer.MIN_VALUE;
            this.max = Integer.MAX_VALUE;
        }

        public IntValue setMin(int i) {
            this.min = i;
            return this;
        }

        public IntValue setMax(int i) {
            this.max = i;
            return this;
        }

        public IntValue setRange(int i, int i2) {
            this.min = i;
            this.max = i2;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // mctech.config.ConfigEntry
        public IntValue copy() {
            return new IntValue(getKey(), getDefault(), getComment()).setRange(this.min, this.max);
        }

        @Override // mctech.config.ConfigEntry
        public IntValue set(Integer num) {
            super.set(Integer.valueOf(Helpers.clamp(num.intValue(), this.min, this.max)));
            return this;
        }

        @Override // mctech.config.ConfigEntry
        public ParseResult<Boolean> canSet(Integer num) {
            ParseResult<Boolean> parseResultCanSet = super.canSet(num);
            if (parseResultCanSet.hasError()) {
                return parseResultCanSet;
            }
            return ParseResult.result(num.intValue() >= this.min && num.intValue() <= this.max, IllegalArgumentException::new, "Value [" + num + "] has to be within [" + this.min + " ~ " + this.max);
        }

        @Override // mctech.config.ConfigEntry
        public String getLimitations() {
            if (this.min == Integer.MIN_VALUE) {
                if (this.max == Integer.MAX_VALUE) {
                    return "";
                }
                return "Range: < " + this.max;
            }
            if (this.max != Integer.MAX_VALUE) {
                return "Range: " + this.min + " ~ " + this.max;
            }
            if (this.min == Integer.MIN_VALUE) {
                return "";
            }
            return "Range: > " + this.min;
        }

        @Override // mctech.config.ConfigEntry
        public char getPrefix() {
            return 'I';
        }

        @Override // mctech.config.ConfigEntry
        public IEntryDataType.SimpleDataType getDataType() {
            return IEntryDataType.EntryDataType.INTEGER.toSimpleType();
        }

        public int get() {
            return getValue().intValue();
        }

        @Override // mctech.config.ConfigEntry
        public ParseResult<Integer> parseValue(String str) {
            return Helpers.parseInt(str);
        }

        public static ParseResult<IntValue> parse(String str, String str2, String... strArr) {
            ParseResult<Integer> parseResult = Helpers.parseInt(str2);
            if (parseResult.hasError()) {
                return parseResult.withDefault(new IntValue(str, 0, strArr));
            }
            return ParseResult.success(new IntValue(str, parseResult.getValue(), strArr));
        }

        @Override // mctech.config.ConfigEntry
        public void serialize(IWriteBuffer iWriteBuffer) {
            iWriteBuffer.writeInt(get());
        }

        @Override // mctech.config.ConfigEntry
        public void deserializeValue(IReadBuffer iReadBuffer) {
            set(Integer.valueOf(iReadBuffer.readInt()));
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/config/ConfigEntry$DoubleValue.class */
    public static class DoubleValue extends BasicConfigEntry<Double> {
        private double min;
        private double max;

        public DoubleValue(String str, Double d, String... strArr) {
            super(str, d, strArr);
            this.min = -1.7976931348623157E308d;
            this.max = Double.MAX_VALUE;
        }

        public DoubleValue(String str, Double d) {
            super(str, d, new String[0]);
            this.min = -1.7976931348623157E308d;
            this.max = Double.MAX_VALUE;
        }

        public DoubleValue setMin(double d) {
            this.min = d;
            return this;
        }

        public DoubleValue setMax(double d) {
            this.max = d;
            return this;
        }

        public DoubleValue setRange(double d, double d2) {
            this.min = d;
            this.max = d2;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // mctech.config.ConfigEntry
        public DoubleValue copy() {
            return new DoubleValue(getKey(), getDefault(), getComment()).setRange(this.min, this.max);
        }

        @Override // mctech.config.ConfigEntry
        public ParseResult<Boolean> canSet(Double d) {
            ParseResult<Boolean> parseResultCanSet = super.canSet(d);
            if (parseResultCanSet.hasError()) {
                return parseResultCanSet;
            }
            boolean z = d.doubleValue() >= this.min && d.doubleValue() <= this.max;
            Function function = IllegalArgumentException::new;
            double d2 = this.min;
            double d3 = this.max;
            return ParseResult.result(z, function, "Value [" + d + "] has to be within [" + d2 + " ~ " + z);
        }

        @Override // mctech.config.ConfigEntry
        public DoubleValue set(Double d) {
            super.set(Double.valueOf(Helpers.clamp(d.doubleValue(), this.min, this.max)));
            return this;
        }

        @Override // mctech.config.ConfigEntry
        public char getPrefix() {
            return 'D';
        }

        @Override // mctech.config.ConfigEntry
        public IEntryDataType.SimpleDataType getDataType() {
            return IEntryDataType.EntryDataType.DOUBLE.toSimpleType();
        }

        public double get() {
            return getValue().doubleValue();
        }

        @Override // mctech.config.ConfigEntry
        public String getLimitations() {
            if (this.min == Double.MIN_VALUE) {
                if (this.max == Double.MAX_VALUE) {
                    return "";
                }
                return "Range: < " + this.max;
            }
            if (this.max != Double.MAX_VALUE) {
                double d = this.min;
                double d2 = this.max;
                return "Range: " + d + " ~ " + d;
            }
            if (this.min == Double.MIN_VALUE) {
                return "";
            }
            return "Range: > " + this.min;
        }

        @Override // mctech.config.ConfigEntry
        public ParseResult<Double> parseValue(String str) {
            return Helpers.parseDouble(str);
        }

        public static ParseResult<DoubleValue> parse(String str, String str2, String... strArr) {
            ParseResult<Double> parseResult = Helpers.parseDouble(str2);
            if (parseResult.hasError()) {
                return parseResult.withDefault(new DoubleValue(str, Double.valueOf(0.0d), strArr));
            }
            return ParseResult.success(new DoubleValue(str, parseResult.getValue(), strArr));
        }

        @Override // mctech.config.ConfigEntry
        public void serialize(IWriteBuffer iWriteBuffer) {
            iWriteBuffer.writeDouble(get());
        }

        @Override // mctech.config.ConfigEntry
        public void deserializeValue(IReadBuffer iReadBuffer) {
            set(Double.valueOf(iReadBuffer.readDouble()));
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/config/ConfigEntry$BoolValue.class */
    public static class BoolValue extends BasicConfigEntry<Boolean> {
        public BoolValue(String str, Boolean bool, String... strArr) {
            super(str, bool, strArr);
        }

        public BoolValue(String str, Boolean bool) {
            super(str, bool, new String[0]);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // mctech.config.ConfigEntry
        public BoolValue copy() {
            return new BoolValue(getKey(), getDefault(), getComment());
        }

        public boolean get() {
            return getValue().booleanValue();
        }

        @Override // mctech.config.ConfigEntry
        public char getPrefix() {
            return 'B';
        }

        @Override // mctech.config.ConfigEntry
        public IEntryDataType.SimpleDataType getDataType() {
            return IEntryDataType.EntryDataType.BOOLEAN.toSimpleType();
        }

        @Override // mctech.config.ConfigEntry
        public String getLimitations() {
            return "";
        }

        @Override // mctech.config.ConfigEntry
        public ParseResult<Boolean> parseValue(String str) {
            return ParseResult.success(Boolean.valueOf(Boolean.parseBoolean(str)));
        }

        public static ParseResult<BoolValue> parse(String str, String str2, String... strArr) {
            return ParseResult.success(new BoolValue(str, Boolean.valueOf(Boolean.parseBoolean(str2)), strArr));
        }

        @Override // mctech.config.ConfigEntry
        public void serialize(IWriteBuffer iWriteBuffer) {
            iWriteBuffer.writeBoolean(get());
        }

        @Override // mctech.config.ConfigEntry
        public void deserializeValue(IReadBuffer iReadBuffer) {
            set(Boolean.valueOf(iReadBuffer.readBoolean()));
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/config/ConfigEntry$TempValue.class */
    public static class TempValue extends StringValue {
        @Override // mctech.config.ConfigEntry.StringValue
        public /* bridge */ /* synthetic */ StringValue withFilter(Predicate predicate) {
            return withFilter((Predicate<String>) predicate);
        }

        private TempValue(String str, String str2, String[] strArr) {
            super(str, str2, strArr);
        }

        public static ParseResult<TempValue> parseTemp(String str, String str2, String... strArr) {
            return ParseResult.success(new TempValue(str, str2, strArr));
        }

        @Override // mctech.config.ConfigEntry.StringValue
        public TempValue withFilter(Predicate<String> predicate) {
            throw new UnsupportedOperationException("Filters are not supported with Temp Values");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // mctech.config.ConfigEntry.StringValue, mctech.config.ConfigEntry
        public TempValue copy() {
            return new TempValue(getKey(), getDefault(), getComment());
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/config/ConfigEntry$StringValue.class */
    public static class StringValue extends BasicConfigEntry<String> {
        protected Predicate<String> filter;

        public StringValue(String str, String str2, String... strArr) {
            super(str, str2, strArr);
        }

        public StringValue(String str, String str2) {
            super(str, str2, new String[0]);
        }

        public StringValue withFilter(Predicate<String> predicate) {
            this.filter = predicate;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // mctech.config.ConfigEntry
        public StringValue copy() {
            return new StringValue(getKey(), getDefault(), getComment()).withFilter(this.filter);
        }

        @Override // mctech.config.ConfigEntry
        public char getPrefix() {
            return 'S';
        }

        @Override // mctech.config.ConfigEntry
        public IEntryDataType.SimpleDataType getDataType() {
            return IEntryDataType.EntryDataType.STRING.toSimpleType();
        }

        public String get() {
            return getValue();
        }

        @Override // mctech.config.ConfigEntry
        public String getLimitations() {
            return "";
        }

        @Override // mctech.config.ConfigEntry
        public ParseResult<Boolean> canSet(String str) {
            if (str == null) {
                return ParseResult.partial(false, NullPointerException::new, "Value isn't allowed to be null");
            }
            if (this.filter == null || this.filter.test(str)) {
                return ParseResult.success(true);
            }
            return ParseResult.partial(false, IllegalStateException::new, "Value [" + str + "] isn't valid");
        }

        @Override // mctech.config.ConfigEntry
        public ParseResult<String> parseValue(String str) {
            return ParseResult.successOrError(str, this.filter == null || this.filter.test(str), IllegalArgumentException::new, "Value [" + str + "] is not valid");
        }

        public static ParseResult<StringValue> parse(String str, String str2, String... strArr) {
            return ParseResult.success(new StringValue(str, str2, strArr));
        }

        @Override // mctech.config.ConfigEntry
        public void serialize(IWriteBuffer iWriteBuffer) {
            iWriteBuffer.writeString(get());
        }

        @Override // mctech.config.ConfigEntry
        public void deserializeValue(IReadBuffer iReadBuffer) {
            set(iReadBuffer.readString());
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/config/ConfigEntry$ArrayValue.class */
    public static class ArrayValue extends ArrayConfigEntry<String> implements IArrayConfig {
        protected Predicate<String> filter;

        public ArrayValue(String str, String[] strArr, String... strArr2) {
            super(str, strArr, strArr2);
        }

        public ArrayValue(String str, String[] strArr) {
            super(str, strArr, new String[0]);
        }

        public ArrayValue(String str, String str2) {
            super(str, new String[0], str2);
        }

        public ArrayValue(String str) {
            super(str, new String[0], new String[0]);
        }

        public ArrayValue withFilter(Predicate<String> predicate) {
            this.filter = predicate;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // mctech.config.ConfigEntry
        public ArrayValue copy() {
            return new ArrayValue(getKey(), (String[]) getDefault(), getComment());
        }

        @Override // mctech.config.ConfigEntry
        public char getPrefix() {
            return 'A';
        }

        @Override // mctech.config.ConfigEntry
        public IEntryDataType.SimpleDataType getDataType() {
            return IEntryDataType.EntryDataType.STRING.toSimpleType();
        }

        public String[] get() {
            return (String[]) getValue();
        }

        @Override // mctech.config.ConfigEntry
        public String getLimitations() {
            return "";
        }

        @Override // mctech.config.ConfigEntry.IArrayConfig
        public List<String> getEntries() {
            return new ObjectArrayList((String[]) getValue());
        }

        @Override // mctech.config.ConfigEntry.IArrayConfig
        public List<String> getDefaults() {
            return ObjectArrayList.wrap((String[]) getDefault());
        }

        @Override // mctech.config.ConfigEntry.IArrayConfig
        public ParseResult<Boolean> canSetArray(List<String> list) {
            if (list == null) {
                return ParseResult.partial(false, NullPointerException::new, "Value isn't allowed to be null");
            }
            if (this.filter != null) {
                for (int i = 0; i < list.size(); i++) {
                    if (!this.filter.test(list.get(i))) {
                        return ParseResult.partial(false, IllegalArgumentException::new, "Value [" + list.get(i) + "] isn't valid");
                    }
                }
            }
            return ParseResult.success(true);
        }

        @Override // mctech.config.ConfigEntry.IArrayConfig
        public void setArray(List<String> list) {
            set((String[]) list.toArray(new String[list.size()]));
        }

        @Override // mctech.config.ConfigEntry
        public ParseResult<String[]> parseValue(String str) {
            return ParseResult.success(Helpers.splitArray(str, ","));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // mctech.config.ConfigEntry
        public String serializedValue(MultilinePolicy multilinePolicy, String[] strArr) {
            return serializeArray(multilinePolicy, strArr);
        }

        public static ParseResult<ArrayValue> parse(String str, String str2, String... strArr) {
            return ParseResult.success(new ArrayValue(str, Helpers.splitArray(str2, ","), strArr));
        }

        @Override // mctech.config.ConfigEntry
        public void serialize(IWriteBuffer iWriteBuffer) {
            iWriteBuffer.writeVarInt(get().length);
            for (String str : get()) {
                iWriteBuffer.writeString(str);
            }
        }

        @Override // mctech.config.ConfigEntry
        public void deserializeValue(IReadBuffer iReadBuffer) {
            String[] strArr = new String[iReadBuffer.readVarInt()];
            for (int i = 0; i < strArr.length; i++) {
                strArr[i] = iReadBuffer.readString();
            }
            set(strArr);
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/config/ConfigEntry$EnumValue.class */
    public static class EnumValue<E extends Enum<E>> extends BasicConfigEntry<E> {
        private Class<E> enumClass;

        public EnumValue(String str, E e, Class<E> cls, String... strArr) {
            super(str, e, strArr);
            this.enumClass = cls;
            addSuggestions();
        }

        public EnumValue(String str, E e, Class<E> cls) {
            super(str, e, new String[0]);
            this.enumClass = cls;
            addSuggestions();
        }

        private void addSuggestions() {
            for (E e : this.enumClass.getEnumConstants()) {
                ISuggestedEnum wrapper = ISuggestedEnum.getWrapper(e);
                if (wrapper != null) {
                    addSuggestion(wrapper.getName(e), e);
                } else {
                    addSuggestion(e);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // mctech.config.ConfigEntry
        public EnumValue<E> copy() {
            return new EnumValue<>(getKey(), getDefault(), this.enumClass, getComment());
        }

        @Override // mctech.config.ConfigEntry
        public char getPrefix() {
            return 'E';
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // mctech.config.ConfigEntry
        public String serializedValue(MultilinePolicy multilinePolicy, E e) {
            return e.name();
        }

        @Override // mctech.config.ConfigEntry
        public IEntryDataType.SimpleDataType getDataType() {
            return IEntryDataType.EntryDataType.STRING.toSimpleType();
        }

        @Override // mctech.config.ConfigEntry
        public ParseResult<Boolean> canSet(E e) {
            return ParseResult.result(this.enumClass.isInstance(e), IllegalArgumentException::new, "Value must be one of the following: " + Arrays.toString(toArray()));
        }

        public E get() {
            return getValue();
        }

        @Override // mctech.config.ConfigEntry
        public String getLimitations() {
            return "Must be one of " + Arrays.toString(toArray());
        }

        private String[] toArray() {
            E[] enumConstants = this.enumClass.getEnumConstants();
            String[] strArr = new String[enumConstants.length];
            int length = enumConstants.length;
            for (int i = 0; i < length; i++) {
                strArr[i] = enumConstants[i].name();
            }
            return strArr;
        }

        @Override // mctech.config.ConfigEntry
        public ParseResult<E> parseValue(String str) {
            try {
                return ParseResult.success(Enum.valueOf(this.enumClass, str));
            } catch (Exception e) {
                return ParseResult.error(str, e);
            }
        }

        @Override // mctech.config.ConfigEntry
        public void serialize(IWriteBuffer iWriteBuffer) {
            iWriteBuffer.writeEnum(get());
        }

        @Override // mctech.config.ConfigEntry
        public void deserializeValue(IReadBuffer iReadBuffer) {
            set(iReadBuffer.readEnum(this.enumClass));
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/config/ConfigEntry$ParsedValue.class */
    public static class ParsedValue<T> extends BasicConfigEntry<T> {
        IConfigSerializer<T> serializer;

        public ParsedValue(String str, T t, IConfigSerializer<T> iConfigSerializer, String[] strArr) {
            super(str, t, strArr);
            this.serializer = iConfigSerializer;
        }

        public ParsedValue(String str, T t, IConfigSerializer<T> iConfigSerializer) {
            super(str, t, new String[0]);
            this.serializer = iConfigSerializer;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // mctech.config.ConfigEntry
        public ParsedValue<T> copy() {
            return new ParsedValue<>(getKey(), getDefault(), this.serializer, getComment());
        }

        @Override // mctech.config.ConfigEntry
        public char getPrefix() {
            return 'p';
        }

        @Override // mctech.config.ConfigEntry
        public IEntryDataType.CompoundDataType getDataType() {
            return this.serializer.getFormat();
        }

        public T get() {
            return getValue();
        }

        @Override // mctech.config.ConfigEntry
        public ParseResult<Boolean> canSet(T t) {
            ParseResult<Boolean> parseResultCanSet = super.canSet(t);
            if (parseResultCanSet.hasError()) {
                return parseResultCanSet;
            }
            return this.serializer.isValid(t);
        }

        @Override // mctech.config.ConfigEntry
        public ParseResult<T> parseValue(String str) {
            return this.serializer.deserialize(Helpers.splitArray(str, ";"));
        }

        @Override // mctech.config.ConfigEntry
        protected String serializedValue(MultilinePolicy multilinePolicy, T t) {
            return Helpers.mergeCompound(this.serializer.serialize(t));
        }

        private String buildFormat() {
            IEntryDataType.EntryDataType display;
            StringJoiner stringJoiner = new StringJoiner(";");
            for (Map.Entry<String, IEntryDataType.EntryDataType> entry : this.serializer.getFormat().getCompound()) {
                IEntryDataType.EntryDataType value = entry.getValue();
                if (entry.getValue() == IEntryDataType.EntryDataType.CUSTOM && (display = this.serializer.getFormat().getDisplay(entry.getKey())) != null) {
                    value = display;
                }
                stringJoiner.add(entry.getKey() + "(" + Helpers.firstLetterUppercase(value.name().toLowerCase()));
            }
            return stringJoiner.toString();
        }

        @Override // mctech.config.ConfigEntry
        public String getLimitations() {
            return "Format: [" + buildFormat() + "], Example: [" + serializedValue(MultilinePolicy.DISABLED, this.serializer.getExample());
        }

        @Override // mctech.config.ConfigEntry
        public void serialize(IWriteBuffer iWriteBuffer) {
            this.serializer.serialize(iWriteBuffer, getValue());
        }

        @Override // mctech.config.ConfigEntry
        public void deserializeValue(IReadBuffer iReadBuffer) {
            set(this.serializer.deserialize(iReadBuffer));
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/config/ConfigEntry$ParsedArray.class */
    public static class ParsedArray<T> extends CollectionConfigEntry<T, List<T>> implements IArrayConfig {
        IConfigSerializer<T> serializer;

        public ParsedArray(String str, List<T> list, IConfigSerializer<T> iConfigSerializer, String... strArr) {
            super(str, list, strArr);
            this.serializer = iConfigSerializer;
        }

        public ParsedArray(String str, List<T> list, IConfigSerializer<T> iConfigSerializer) {
            super(str, list, new String[0]);
            this.serializer = iConfigSerializer;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // mctech.config.ConfigEntry
        public ParsedArray<T> copy() {
            return new ParsedArray<>(getKey(), (List) getValue(), this.serializer, getComment());
        }

        @Override // mctech.config.ConfigEntry
        public ParseResult<List<T>> parseValue(String str) {
            ObjectArrayList objectArrayList = new ObjectArrayList();
            for (String str2 : Helpers.splitArray(str, ",")) {
                ParseResult<T> parseResultDeserialize = this.serializer.deserialize(Helpers.splitArray(str2, ";"));
                if (parseResultDeserialize.isValid()) {
                    objectArrayList.add(parseResultDeserialize.getValue());
                }
            }
            return ParseResult.success(objectArrayList);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // mctech.config.ConfigEntry
        public String serializedValue(MultilinePolicy multilinePolicy, List<T> list) {
            String[] strArr = new String[list.size()];
            int size = list.size();
            for (int i = 0; i < size; i++) {
                strArr[i] = Helpers.mergeCompound(this.serializer.serialize(list.get(i)));
            }
            return serializeArray(multilinePolicy, strArr);
        }

        @Override // mctech.config.ConfigEntry
        public ParseResult<Boolean> canSet(List<T> list) {
            if (list == null) {
                return ParseResult.partial(false, NullPointerException::new, "Value isn't allowed to be null");
            }
            int size = list.size();
            for (int i = 0; i < size; i++) {
                T t = list.get(i);
                if (t == null) {
                    return ParseResult.partial(false, NullPointerException::new, "Value isn't allowed to be null");
                }
                ParseResult<Boolean> parseResultIsValid = this.serializer.isValid(t);
                if (!parseResultIsValid.getValue().booleanValue()) {
                    return parseResultIsValid;
                }
            }
            return ParseResult.success(true);
        }

        @Override // mctech.config.ConfigEntry.IArrayConfig
        public List<String> getEntries() {
            ObjectArrayList objectArrayList = new ObjectArrayList();
            Iterator it = ((List) getValue()).iterator();
            while (it.hasNext()) {
                objectArrayList.add(Helpers.mergeCompound(this.serializer.serialize((T) it.next())));
            }
            return objectArrayList;
        }

        @Override // mctech.config.ConfigEntry.IArrayConfig
        public List<String> getDefaults() {
            ObjectArrayList objectArrayList = new ObjectArrayList();
            Iterator it = ((List) getDefault()).iterator();
            while (it.hasNext()) {
                objectArrayList.add(Helpers.mergeCompound(this.serializer.serialize((T) it.next())));
            }
            return objectArrayList;
        }

        @Override // mctech.config.ConfigEntry.IArrayConfig
        public ParseResult<Boolean> canSetArray(List<String> list) {
            if (list == null) {
                return ParseResult.partial(false, NullPointerException::new, "Value isn't allowed to be null");
            }
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ParseResult<T> parseResultDeserialize = this.serializer.deserialize(Helpers.splitArray(list.get(i), ";"));
                if (parseResultDeserialize.hasError()) {
                    return parseResultDeserialize.onlyError();
                }
                ParseResult<Boolean> parseResultIsValid = this.serializer.isValid(parseResultDeserialize.getValue());
                if (parseResultIsValid.hasError()) {
                    return parseResultIsValid;
                }
            }
            return ParseResult.success(true);
        }

        @Override // mctech.config.ConfigEntry.IArrayConfig
        public void setArray(List<String> list) {
            StringJoiner stringJoiner = new StringJoiner(",");
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                stringJoiner.add(it.next());
            }
            deserializeValue(stringJoiner.toString());
        }

        @Override // mctech.config.ConfigEntry
        public IEntryDataType getDataType() {
            return this.serializer.getFormat();
        }

        @Override // mctech.config.ConfigEntry
        public char getPrefix() {
            return 'P';
        }

        private String buildFormat() {
            IEntryDataType.EntryDataType display;
            StringJoiner stringJoiner = new StringJoiner(";");
            for (Map.Entry<String, IEntryDataType.EntryDataType> entry : this.serializer.getFormat().getCompound()) {
                IEntryDataType.EntryDataType value = entry.getValue();
                if (entry.getValue() == IEntryDataType.EntryDataType.CUSTOM && (display = this.serializer.getFormat().getDisplay(entry.getKey())) != null) {
                    value = display;
                }
                stringJoiner.add(entry.getKey() + "(" + Helpers.firstLetterUppercase(value.name().toLowerCase()));
            }
            return stringJoiner.toString();
        }

        @Override // mctech.config.ConfigEntry
        public String getLimitations() {
            return "Format: [" + buildFormat() + "], Example: [" + serializedValue(MultilinePolicy.DISABLED, (List) ObjectLists.singleton(this.serializer.getExample()));
        }

        @Override // mctech.config.ConfigEntry
        public void serialize(IWriteBuffer iWriteBuffer) {
            List list = (List) getValue();
            iWriteBuffer.writeVarInt(list.size());
            int size = list.size();
            for (int i = 0; i < size; i++) {
                this.serializer.serialize(iWriteBuffer, (T) list.get(i));
            }
        }

        @Override // mctech.config.ConfigEntry
        public void deserializeValue(IReadBuffer iReadBuffer) {
            ObjectArrayList objectArrayList = new ObjectArrayList();
            int varInt = iReadBuffer.readVarInt();
            for (int i = 0; i < varInt; i++) {
                T tDeserialize = this.serializer.deserialize(iReadBuffer);
                if (tDeserialize != null) {
                    objectArrayList.add(tDeserialize);
                }
            }
            set(objectArrayList);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // mctech.config.ConfigEntry.CollectionConfigEntry
        public List<T> create(T t) {
            return ObjectLists.singleton(t);
        }
    }
}
