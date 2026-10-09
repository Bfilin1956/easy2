package mctech.config.impl.entries;

import mctech.api.buffer.IReadBuffer;
import mctech.api.buffer.IWriteBuffer;
import mctech.config.ConfigEntry;
import mctech.config.utils.IEntryDataType;
import mctech.config.utils.MultilinePolicy;
import mctech.config.utils.ParseResult;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/config/impl/entries/ColorEntry.class */
public class ColorEntry extends ConfigEntry.BasicConfigEntry<ColorWrapper> {
    public ColorEntry(String str, int i, String... strArr) {
        super(str, new ColorWrapper(i), strArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mctech.config.ConfigEntry
    public ColorEntry copy() {
        return new ColorEntry(getKey(), get(), getComment());
    }

    public final ColorEntry addSuggestions(int... iArr) {
        for (int i : iArr) {
            addSuggestionInternal(Long.toHexString(1095216660480L | ((long) i)).substring(2), serializedValue(MultilinePolicy.DISABLED, new ColorWrapper(i)), ColorWrapper.class);
        }
        return this;
    }

    public final ColorEntry addSuggestion(String str, int i) {
        return (ColorEntry) addSuggestionInternal(str, serializedValue(MultilinePolicy.DISABLED, new ColorWrapper(i)), ColorWrapper.class);
    }

    @Override // mctech.config.ConfigEntry
    public ParseResult<ColorWrapper> parseValue(String str) {
        ParseResult<Integer> parseResult = ColorWrapper.parseInt(str);
        return parseResult.hasError() ? parseResult.onlyError() : ParseResult.success(new ColorWrapper(parseResult.getValue().intValue()));
    }

    @Override // mctech.config.ConfigEntry
    public IEntryDataType getDataType() {
        return IEntryDataType.SimpleDataType.ofVariant(ColorWrapper.class);
    }

    public int get() {
        return getValue().getColor();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mctech.config.ConfigEntry
    public String serializedValue(MultilinePolicy multilinePolicy, ColorWrapper colorWrapper) {
        return ColorWrapper.serialize(colorWrapper.getColor());
    }

    @Override // mctech.config.ConfigEntry
    public char getPrefix() {
        return 'C';
    }

    @Override // mctech.config.ConfigEntry
    public String getLimitations() {
        return "";
    }

    @Override // mctech.config.ConfigEntry
    public void serialize(IWriteBuffer iWriteBuffer) {
        iWriteBuffer.writeInt(get());
    }

    @Override // mctech.config.ConfigEntry
    protected void deserializeValue(IReadBuffer iReadBuffer) {
        set(new ColorWrapper(iReadBuffer.readInt()));
    }

    public static ParseResult<ColorEntry> parse(String str, String str2, String... strArr) {
        ParseResult<Integer> parseResult = ColorWrapper.parseInt(str2);
        if (parseResult.hasError()) {
            return parseResult.withDefault(new ColorEntry(str, 0, strArr));
        }
        return ParseResult.success(new ColorEntry(str, parseResult.getValue().intValue(), strArr));
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/config/impl/entries/ColorEntry$ColorWrapper.class */
    public static class ColorWrapper {
        int color;

        public ColorWrapper(int i) {
            this.color = i;
        }

        public int getColor() {
            return this.color;
        }

        public static ParseResult<Integer> parseInt(String str) {
            try {
                return ParseResult.success(Integer.valueOf(Long.decode(str).intValue()));
            } catch (Exception e) {
                return ParseResult.error(str, e, "Couldn't parse Number");
            }
        }

        public static String serialize(long j) {
            return "0x" + Long.toHexString(1095216660480L | (j & 4294967295L)).substring(2);
        }
    }
}
