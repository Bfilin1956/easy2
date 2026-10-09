package mctech.config.utils;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.AbstractMap;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/config/utils/IEntryDataType.class */
public interface IEntryDataType {
    boolean isCompound();

    default SimpleDataType asDataType() {
        throw new IllegalStateException("Type isn't a Simple DataEntry");
    }

    default CompoundDataType asCompound() {
        throw new IllegalStateException("Type isn't a Compound DataEntry");
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/config/utils/IEntryDataType$SimpleDataType.class */
    public static class SimpleDataType implements IEntryDataType {
        EntryDataType dataType;
        Class<?> variant;

        private SimpleDataType(EntryDataType entryDataType, Class<?> cls) {
            this.dataType = entryDataType;
            this.variant = cls;
        }

        public static SimpleDataType ofVariant(Class<?> cls) {
            return new SimpleDataType(EntryDataType.CUSTOM, cls);
        }

        @Override // mctech.config.utils.IEntryDataType
        public boolean isCompound() {
            return false;
        }

        @Override // mctech.config.utils.IEntryDataType
        public SimpleDataType asDataType() {
            return this;
        }

        public EntryDataType getType() {
            return this.dataType;
        }

        public Class<?> getVariant() {
            return this.variant;
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/config/utils/IEntryDataType$EntryDataType.class */
    public enum EntryDataType {
        BOOLEAN,
        INTEGER,
        DOUBLE,
        STRING,
        CUSTOM(true);

        SimpleDataType owner;

        EntryDataType() {
            this(false);
        }

        EntryDataType(boolean z) {
            this.owner = z ? null : new SimpleDataType(this, null);
        }

        public SimpleDataType toSimpleType() {
            return this.owner;
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/config/utils/IEntryDataType$CompoundDataType.class */
    public static final class CompoundDataType implements IEntryDataType {
        List<Map.Entry<String, EntryDataType>> values = new ObjectArrayList();
        Map<String, Class<?>> customVariants = new Object2ObjectOpenHashMap();
        Map<String, EntryDataType> customDisplay = new Object2ObjectOpenHashMap();

        public CompoundDataType with(String str, EntryDataType entryDataType) {
            Objects.requireNonNull(str);
            Objects.requireNonNull(entryDataType);
            if (entryDataType == EntryDataType.CUSTOM) {
                throw new IllegalStateException("Use withCustom to add custom entries!");
            }
            this.values.add(new AbstractMap.SimpleEntry(str, entryDataType));
            return this;
        }

        public CompoundDataType withCustom(String str, Class<?> cls, EntryDataType entryDataType) {
            Objects.requireNonNull(str);
            Objects.requireNonNull(cls);
            this.values.add(new AbstractMap.SimpleEntry(str, EntryDataType.CUSTOM));
            this.customVariants.put(str, cls);
            this.customDisplay.put(str, entryDataType);
            return this;
        }

        public List<Map.Entry<String, EntryDataType>> getCompound() {
            return Collections.unmodifiableList(this.values);
        }

        public Class<?> getVariant(String str) {
            return this.customVariants.get(str);
        }

        public EntryDataType getDisplay(String str) {
            return this.customDisplay.get(str);
        }

        @Override // mctech.config.utils.IEntryDataType
        public CompoundDataType asCompound() {
            return this;
        }

        @Override // mctech.config.utils.IEntryDataType
        public boolean isCompound() {
            return true;
        }
    }
}
