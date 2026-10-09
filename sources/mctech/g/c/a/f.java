package mctech.g.c.a;

import java.lang.Enum;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/c/a/f.class */
public class f<T extends Enum<T>> {
    private final EnumMap<T, ResourceLocation> a;

    public f(String str, Class<T> cls, String str2, String str3, boolean z) {
        this.a = new EnumMap<>((Map) Arrays.stream(cls.getEnumConstants()).collect(Collectors.toMap(r2 -> {
            return r2;
        }, r10 -> {
            return a(str, str2, str3, r10, z);
        })));
    }

    public f(String str, Class<T> cls, String str2, String str3) {
        this(str, cls, str2, str3, false);
    }

    private f(EnumMap<T, ResourceLocation> enumMap) {
        this.a = enumMap;
    }

    @Nullable
    public ResourceLocation a(T t) {
        return this.a.get(t);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T extends Enum<T>> ResourceLocation a(String str, String str2, String str3, T t, boolean z) {
        return ResourceLocation.fromNamespaceAndPath(str, str2 + "/" + str3 + "/" + t.name().toLowerCase(Locale.ROOT) + (z ? ".png" : ""));
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/c/a/f$a.class */
    public static class a<T extends Enum<T>> {
        private final String a;
        private final Class<T> b;
        private final String c;
        private final String d;
        private final boolean e;
        private final EnumMap<T, ResourceLocation> f;

        public a(String str, Class<T> cls, String str2, String str3) {
            this(str, cls, str2, str3, false);
        }

        public a(String str, Class<T> cls, String str2, String str3, boolean z) {
            this.a = str;
            this.b = cls;
            this.d = str3;
            this.c = str2;
            this.e = z;
            this.f = new EnumMap<>(cls);
        }

        public a<T> a(T t) {
            this.f.put(t, f.a(this.a, this.c, this.d, t, this.e));
            return this;
        }

        public a<T> a(T t, ResourceLocation resourceLocation) {
            this.f.put(t, resourceLocation);
            return this;
        }

        public a<T> a() {
            for (T t : this.b.getEnumConstants()) {
                this.f.put(t, f.a(this.a, this.c, this.d, t, this.e));
            }
            return this;
        }

        public a<T> b(T t) {
            this.f.remove(t);
            return this;
        }

        public f<T> b() {
            return new f<>(this.f);
        }
    }
}
