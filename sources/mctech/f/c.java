package mctech.f;

import com.mojang.datafixers.util.Pair;
import com.mojang.datafixers.util.Unit;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.DynamicOps;
import com.mojang.serialization.Lifecycle;
import com.mojang.serialization.ListBuilder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/f/c.class */
public final class c<E> extends Record implements Codec<Set<E>> {
    private final Codec<E> a;
    private final int b;
    private final int c;

    public c(Codec<E> codec, int i, int i2) {
        this.a = codec;
        this.b = i;
        this.c = i2;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, c.class), c.class, "elementCodec;minSize;maxSize", "FIELD:Lmctech/f/c;->a:Lcom/mojang/serialization/Codec;", "FIELD:Lmctech/f/c;->b:I", "FIELD:Lmctech/f/c;->c:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, c.class, Object.class), c.class, "elementCodec;minSize;maxSize", "FIELD:Lmctech/f/c;->a:Lcom/mojang/serialization/Codec;", "FIELD:Lmctech/f/c;->b:I", "FIELD:Lmctech/f/c;->c:I").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public Codec<E> a() {
        return this.a;
    }

    public int b() {
        return this.b;
    }

    public int c() {
        return this.c;
    }

    public /* synthetic */ DataResult encode(Object obj, DynamicOps dynamicOps, Object obj2) {
        return a((Set) obj, (DynamicOps<Object>) dynamicOps, obj2);
    }

    public static <E> Codec<Set<E>> a(Codec<E> codec) {
        return a(codec, 0, Integer.MAX_VALUE);
    }

    public static <E> Codec<Set<E>> a(Codec<E> codec, int i, int i2) {
        return new c(codec, i, i2);
    }

    private <R> DataResult<R> a(int i) {
        return DataResult.error(() -> {
            return "Set is too short: " + i + ", expected range [" + this.b + "-" + this.c + "]";
        });
    }

    private <R> DataResult<R> b(int i) {
        return DataResult.error(() -> {
            return "Set is too long: " + i + ", expected range [" + this.b + "-" + this.c + "]";
        });
    }

    public <T> DataResult<T> a(Set<E> set, DynamicOps<T> dynamicOps, T t) {
        if (set.size() < this.b) {
            return (DataResult<T>) a(set.size());
        }
        if (set.size() > this.c) {
            return (DataResult<T>) b(set.size());
        }
        ListBuilder listBuilder = dynamicOps.listBuilder();
        Iterator<E> it = set.iterator();
        while (it.hasNext()) {
            listBuilder.add(this.a.encodeStart(dynamicOps, it.next()));
        }
        return listBuilder.build(t);
    }

    public <T> DataResult<Pair<Set<E>, T>> decode(DynamicOps<T> dynamicOps, T t) {
        return dynamicOps.getList(t).setLifecycle(Lifecycle.stable()).flatMap(consumer -> {
            a aVar = new a(dynamicOps);
            Objects.requireNonNull(aVar);
            consumer.accept(aVar::a);
            return aVar.a();
        });
    }

    @Override // java.lang.Record
    public String toString() {
        return "SetCodec[" + String.valueOf(this.a) + "]";
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/f/c$a.class */
    private class a<T> {
        private static final DataResult<Unit> b = DataResult.success(Unit.INSTANCE, Lifecycle.stable());
        private final DynamicOps<T> c;
        private final Set<E> d = new HashSet();
        private final Stream.Builder<T> e = Stream.builder();
        private DataResult<Unit> f = b;
        private int g;

        private a(DynamicOps<T> dynamicOps) {
            this.c = dynamicOps;
        }

        public void a(T t) {
            this.g++;
            if (this.d.size() >= c.this.c) {
                this.e.add(t);
                return;
            }
            DataResult dataResultDecode = c.this.a.decode(this.c, t);
            dataResultDecode.error().ifPresent(error -> {
                this.e.add(t);
            });
            dataResultDecode.resultOrPartial().ifPresent(pair -> {
                this.d.add((E) pair.getFirst());
            });
            this.f = this.f.apply2stable((unit, pair2) -> {
                return unit;
            }, dataResultDecode);
        }

        public DataResult<Pair<Set<E>, T>> a() {
            if (this.d.size() < c.this.b) {
                return c.this.a(this.d.size());
            }
            Pair pairOf = Pair.of(Set.copyOf(this.d), this.c.createList(this.e.build()));
            if (this.g > c.this.c) {
                this.f = c.this.b(this.g);
            }
            return this.f.map(unit -> {
                return pairOf;
            }).setPartial(pairOf);
        }
    }
}
