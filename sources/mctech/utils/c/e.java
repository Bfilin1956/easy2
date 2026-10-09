package mctech.utils.c;

import it.unimi.dsi.fastutil.bytes.ByteCollection;
import it.unimi.dsi.fastutil.ints.IntArrays;
import it.unimi.dsi.fastutil.ints.IntCollection;
import it.unimi.dsi.fastutil.longs.LongCollection;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.minecraft.core.DefaultedRegistry;
import net.minecraft.nbt.ByteArrayTag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.IntArrayTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.LongArrayTag;
import net.minecraft.nbt.NumericTag;
import net.minecraft.nbt.StringTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/c/e.class */
public class e {
    public static void a(CompoundTag compoundTag, String str, boolean z, boolean z2) {
        if (z == z2) {
            compoundTag.remove(str);
        } else {
            compoundTag.putBoolean(str, z);
        }
    }

    public static void a(CompoundTag compoundTag, String str, byte b, byte b2) {
        if (b == b2) {
            compoundTag.remove(str);
        } else {
            compoundTag.putByte(str, b);
        }
    }

    public static void a(CompoundTag compoundTag, String str, int i, int i2) {
        if (i == i2) {
            compoundTag.remove(str);
        } else {
            compoundTag.putByte(str, (byte) i);
        }
    }

    public static void a(CompoundTag compoundTag, String str, short s, short s2) {
        if (s == s2) {
            compoundTag.remove(str);
        } else {
            compoundTag.putShort(str, s);
        }
    }

    public static void b(CompoundTag compoundTag, String str, int i, int i2) {
        if (i == i2) {
            compoundTag.remove(str);
        } else {
            compoundTag.putShort(str, (short) i);
        }
    }

    public static void c(CompoundTag compoundTag, String str, int i, int i2) {
        if (i == i2) {
            compoundTag.remove(str);
        } else {
            compoundTag.putInt(str, i);
        }
    }

    public static void a(CompoundTag compoundTag, String str, long j, long j2) {
        if (j == j2) {
            compoundTag.remove(str);
        } else {
            compoundTag.putLong(str, j);
        }
    }

    public static void a(CompoundTag compoundTag, String str, float f, float f2) {
        if (Float.floatToIntBits(f) == Float.floatToIntBits(f2)) {
            compoundTag.remove(str);
        } else {
            compoundTag.putFloat(str, f);
        }
    }

    public static void a(CompoundTag compoundTag, String str, double d, double d2) {
        if (Double.doubleToLongBits(d) == Double.doubleToLongBits(d2)) {
            compoundTag.remove(str);
        } else {
            compoundTag.putDouble(str, d);
        }
    }

    public static void a(CompoundTag compoundTag, String str, String str2, String str3) {
        if (Objects.equals(str2, str3)) {
            compoundTag.remove(str);
        } else {
            compoundTag.putString(str, str2);
        }
    }

    public static <T extends Enum<T>> void a(CompoundTag compoundTag, String str, @Nullable T t) {
        int iOrdinal = t == null ? 0 : t.ordinal() + 1;
        if (iOrdinal == 0) {
            compoundTag.remove(str);
            return;
        }
        if (iOrdinal < 127) {
            compoundTag.putByte(str, (byte) iOrdinal);
        } else if (iOrdinal < 32767) {
            compoundTag.putShort(str, (short) iOrdinal);
        } else {
            compoundTag.putInt(str, iOrdinal);
        }
    }

    public static <T extends Enum<T>> void a(CompoundTag compoundTag, String str, @Nonnull T t, @Nonnull T t2) {
        if (t == t2 || t == null) {
            compoundTag.remove(str);
            return;
        }
        int iOrdinal = t.ordinal() + 1;
        if (iOrdinal < 127) {
            compoundTag.putByte(str, (byte) iOrdinal);
        } else if (iOrdinal < 32767) {
            compoundTag.putShort(str, (short) iOrdinal);
        } else {
            compoundTag.putInt(str, iOrdinal);
        }
    }

    public static <T> void a(CompoundTag compoundTag, String str, T t, T t2, DefaultedRegistry<T> defaultedRegistry) {
        if (t == t2) {
            compoundTag.remove(str);
        } else {
            compoundTag.putString(str, defaultedRegistry.getKey(t).toString());
        }
    }

    public static void a(CompoundTag compoundTag, String str, byte[] bArr) {
        if (bArr.length <= 0) {
            compoundTag.remove(str);
        } else {
            compoundTag.putByteArray(str, bArr);
        }
    }

    public static void a(CompoundTag compoundTag, String str, ByteCollection byteCollection) {
        if (byteCollection.isEmpty()) {
            compoundTag.remove(str);
        } else {
            compoundTag.putByteArray(str, byteCollection.toByteArray());
        }
    }

    public static void a(CompoundTag compoundTag, String str, byte[] bArr, byte[] bArr2) {
        if (Arrays.equals(bArr, bArr2)) {
            compoundTag.remove(str);
        } else {
            compoundTag.putByteArray(str, bArr);
        }
    }

    public static void a(CompoundTag compoundTag, String str, int[] iArr) {
        if (iArr.length <= 0) {
            compoundTag.remove(str);
        } else {
            compoundTag.putIntArray(str, iArr);
        }
    }

    public static void a(CompoundTag compoundTag, String str, IntCollection intCollection) {
        if (intCollection.isEmpty()) {
            compoundTag.remove(str);
        } else {
            compoundTag.putIntArray(str, intCollection.toIntArray());
        }
    }

    public static void a(CompoundTag compoundTag, String str, int[] iArr, int[] iArr2) {
        if (Arrays.equals(iArr, iArr2)) {
            compoundTag.remove(str);
        } else {
            compoundTag.putIntArray(str, iArr);
        }
    }

    public static void b(CompoundTag compoundTag, String str, int[] iArr, int[] iArr2) {
        IntArrays.quickSort(iArr);
        if (Arrays.equals(iArr, iArr2)) {
            compoundTag.remove(str);
        } else {
            compoundTag.putIntArray(str, iArr);
        }
    }

    public static void a(CompoundTag compoundTag, String str, long[] jArr) {
        if (jArr.length <= 0) {
            compoundTag.remove(str);
        } else {
            compoundTag.putLongArray(str, jArr);
        }
    }

    public static void a(CompoundTag compoundTag, String str, LongCollection longCollection) {
        if (longCollection.isEmpty()) {
            compoundTag.remove(str);
        } else {
            compoundTag.putLongArray(str, longCollection.toLongArray());
        }
    }

    public static void a(CompoundTag compoundTag, String str, long[] jArr, long[] jArr2) {
        if (Arrays.equals(jArr, jArr2)) {
            compoundTag.remove(str);
        } else {
            compoundTag.putLongArray(str, jArr);
        }
    }

    public static void a(CompoundTag compoundTag, String str, CompoundTag compoundTag2) {
        if (compoundTag2.isEmpty()) {
            compoundTag.remove(str);
        } else {
            compoundTag.put(str, compoundTag2);
        }
    }

    public static void a(CompoundTag compoundTag, String str, ListTag listTag) {
        if (listTag.isEmpty()) {
            compoundTag.remove(str);
        } else {
            compoundTag.put(str, listTag);
        }
    }

    public static void a(CompoundTag compoundTag, String str, CompoundTag compoundTag2, boolean z) {
        if (compoundTag2.isEmpty() || !z) {
            compoundTag.remove(str);
        } else {
            compoundTag.put(str, compoundTag2);
        }
    }

    public static void a(CompoundTag compoundTag, String str, ListTag listTag, boolean z) {
        if (listTag.isEmpty() || !z) {
            compoundTag.remove(str);
        } else {
            compoundTag.put(str, listTag);
        }
    }

    public static void a(ListTag listTag, Tag tag) {
        if ((tag instanceof CompoundTag) && ((CompoundTag) tag).isEmpty()) {
            return;
        }
        if ((tag instanceof ListTag) && ((ListTag) tag).isEmpty()) {
            return;
        }
        listTag.add(tag);
    }

    public static boolean a(CompoundTag compoundTag, String str, boolean z) {
        return a(compoundTag, str, (byte) (z ? 1 : 0)) == 1;
    }

    public static byte a(CompoundTag compoundTag, String str, byte b) {
        NumericTag numericTag = compoundTag.get(str);
        return numericTag instanceof NumericTag ? numericTag.getAsByte() : b;
    }

    public static short a(CompoundTag compoundTag, String str, short s) {
        NumericTag numericTag = compoundTag.get(str);
        return numericTag instanceof NumericTag ? numericTag.getAsShort() : s;
    }

    public static int a(CompoundTag compoundTag, String str, int i) {
        NumericTag numericTag = compoundTag.get(str);
        return numericTag instanceof NumericTag ? numericTag.getAsInt() : i;
    }

    public static long a(CompoundTag compoundTag, String str, long j) {
        NumericTag numericTag = compoundTag.get(str);
        return numericTag instanceof NumericTag ? numericTag.getAsLong() : j;
    }

    public static float a(CompoundTag compoundTag, String str, float f) {
        NumericTag numericTag = compoundTag.get(str);
        return numericTag instanceof NumericTag ? numericTag.getAsFloat() : f;
    }

    public static double a(CompoundTag compoundTag, String str, double d) {
        NumericTag numericTag = compoundTag.get(str);
        return numericTag instanceof NumericTag ? numericTag.getAsDouble() : d;
    }

    public static String a(CompoundTag compoundTag, String str, String str2) {
        Tag tag = compoundTag.get(str);
        return tag instanceof StringTag ? tag.getAsString() : str2;
    }

    public static <T extends Enum<T>> T a(CompoundTag compoundTag, String str, Class<T> cls) {
        int i = compoundTag.getInt(str);
        if (i == 0) {
            return null;
        }
        return cls.getEnumConstants()[i - 1];
    }

    public static <T extends Enum<T>> T a(CompoundTag compoundTag, String str, Class<T> cls, T t) {
        int i = compoundTag.getInt(str);
        return i == 0 ? t : cls.getEnumConstants()[i - 1];
    }

    public static <T> T a(CompoundTag compoundTag, String str, DefaultedRegistry<T> defaultedRegistry, T t) {
        Tag tag = compoundTag.get(str);
        return tag instanceof StringTag ? (T) defaultedRegistry.get(ResourceLocation.tryParse(tag.getAsString())) : t;
    }

    public static byte[] b(CompoundTag compoundTag, String str, byte[] bArr) {
        ByteArrayTag byteArrayTag = compoundTag.get(str);
        return byteArrayTag instanceof ByteArrayTag ? byteArrayTag.getAsByteArray() : bArr;
    }

    public static int[] b(CompoundTag compoundTag, String str, int[] iArr) {
        IntArrayTag intArrayTag = compoundTag.get(str);
        return intArrayTag instanceof IntArrayTag ? intArrayTag.getAsIntArray() : iArr;
    }

    public static long[] b(CompoundTag compoundTag, String str, long[] jArr) {
        LongArrayTag longArrayTag = compoundTag.get(str);
        return longArrayTag instanceof LongArrayTag ? longArrayTag.getAsLongArray() : jArr;
    }

    public static void a(CompoundTag compoundTag, String str) {
        CompoundTag compoundTag2 = compoundTag.get(str);
        if (compoundTag2 == null) {
            return;
        }
        if (compoundTag2 instanceof CompoundTag) {
            CompoundTag compoundTag3 = compoundTag2;
            if (compoundTag3.size() == 1) {
                a(compoundTag3, (String) compoundTag3.getAllKeys().iterator().next());
            }
            if (compoundTag3.isEmpty()) {
                compoundTag.remove(str);
                return;
            }
            return;
        }
        if ((compoundTag2 instanceof ListTag) && ((ListTag) compoundTag2).isEmpty()) {
            compoundTag.remove(str);
        }
    }

    static void a(List<Component> list, int i, List<Component> list2) {
        for (Component component : list) {
            list2.add(Component.literal(a(i, "")).append(component.plainCopy().setStyle(component.getStyle())));
            a((List<Component>) component.getSiblings(), i + 1, list2);
        }
    }

    static boolean a(String str) {
        return str.startsWith("{") || str.startsWith("[") || str.endsWith("[") || str.endsWith("{");
    }

    static boolean b(String str) {
        return str.startsWith("}") || str.startsWith("]");
    }

    static String a(int i, String str) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("\t");
        }
        sb.append(str);
        return sb.toString();
    }
}
