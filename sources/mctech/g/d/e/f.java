package mctech.g.d.e;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import net.minecraft.core.NonNullList;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/e/f.class */
public class f {
    public static <T> Codec<List<T>> a(Codec<T> codec, T t) {
        return a(Integer.MAX_VALUE, codec, t);
    }

    public static <T> Codec<List<T>> a(int i, Codec<T> codec, T t) {
        return a(codec, i).sizeLimitedListOf(i).xmap(list -> {
            return a((List<a<Object>>) list, t);
        }, f::a);
    }

    private static <T> Codec<a<T>> a(Codec<T> codec, int i) {
        return RecordCodecBuilder.create(instance -> {
            return instance.group(Codec.intRange(0, i - 1).fieldOf("index").forGetter((v0) -> {
                return v0.a();
            }), codec.fieldOf("value").forGetter((v0) -> {
                return v0.b();
            })).apply(instance, (v1, v2) -> {
                return new a(v1, v2);
            });
        });
    }

    private static <T> List<a<T>> a(List<T> list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            arrayList.add(new a(i, list.get(i)));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> List<T> a(List<a<T>> list, T t) {
        OptionalInt optionalIntMax = list.stream().mapToInt((v0) -> {
            return v0.a();
        }).max();
        if (optionalIntMax.isEmpty()) {
            return List.of();
        }
        NonNullList nonNullListWithSize = NonNullList.withSize(optionalIntMax.getAsInt() + 1, t);
        for (a<T> aVar : list) {
            nonNullListWithSize.set(((a) aVar).a, ((a) aVar).b);
        }
        return nonNullListWithSize;
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/e/f$a.class */
    private static final class a<T> extends Record {
        private final int a;
        private final T b;

        private a(int i, T t) {
            this.a = i;
            this.b = t;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "index;value", "FIELD:Lmctech/g/d/e/f$a;->a:I", "FIELD:Lmctech/g/d/e/f$a;->b:Ljava/lang/Object;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "index;value", "FIELD:Lmctech/g/d/e/f$a;->a:I", "FIELD:Lmctech/g/d/e/f$a;->b:Ljava/lang/Object;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "index;value", "FIELD:Lmctech/g/d/e/f$a;->a:I", "FIELD:Lmctech/g/d/e/f$a;->b:Ljava/lang/Object;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        public int a() {
            return this.a;
        }

        public T b() {
            return this.b;
        }
    }
}
