package mctech.g.b.a.a;

import java.lang.Enum;
import java.util.function.Consumer;
import java.util.function.Supplier;
import net.minecraft.world.level.Level;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/b/a/a/e.class */
public abstract class e<T extends Enum<T>> implements m {
    private final Class<T> a;
    private T b;

    public abstract T a();

    public abstract void a(T t);

    public static <T extends Enum<T>> e<T> a(final Class<T> cls) {
        return (e<T>) new e<T>(cls) { // from class: mctech.g.b.a.a.e.1
            private T b;

            {
                this.b = (T) ((Enum[]) cls.getEnumConstants())[0];
            }

            @Override // mctech.g.b.a.a.e
            public T a() {
                return this.b;
            }

            @Override // mctech.g.b.a.a.e
            public void a(T t) {
                this.b = t;
            }
        };
    }

    public static <T extends Enum<T>> e<T> a(Class<T> cls, final Supplier<T> supplier, final Consumer<T> consumer) {
        return (e<T>) new e<T>(cls) { // from class: mctech.g.b.a.a.e.2
            @Override // mctech.g.b.a.a.e
            public T a() {
                return (T) supplier.get();
            }

            @Override // mctech.g.b.a.a.e
            public void a(T t) {
                consumer.accept(t);
            }
        };
    }

    public static <T extends Enum<T>> e<T> a(Class<T> cls, final Supplier<T> supplier) {
        return (e<T>) new e<T>(cls) { // from class: mctech.g.b.a.a.e.3
            @Override // mctech.g.b.a.a.e
            public T a() {
                return (T) supplier.get();
            }

            @Override // mctech.g.b.a.a.e
            public void a(T t) {
                throw new UnsupportedOperationException("Attempt to set a read-only sync slot.");
            }
        };
    }

    public e(Class<T> cls) {
        if (cls.getEnumConstants().length == 0) {
            throw new IllegalArgumentException("Enum class must have at least one enum.");
        }
        this.a = cls;
    }

    @Override // mctech.g.b.a.a.m
    public m.a c() {
        T t = (T) a();
        m.a aVar = t != this.b ? m.a.FULL : m.a.NONE;
        this.b = t;
        return aVar;
    }

    @Override // mctech.g.b.a.a.m
    public mctech.g.b.a.a.a.l a(Level level, m.a aVar) {
        return new mctech.g.b.a.a.a.e(a().ordinal());
    }

    @Override // mctech.g.b.a.a.m
    public void a(Level level, mctech.g.b.a.a.a.l lVar) {
        if (lVar instanceof mctech.g.b.a.a.a.e) {
            mctech.g.b.a.a.a.e eVar = (mctech.g.b.a.a.a.e) lVar;
            T[] enumConstants = this.a.getEnumConstants();
            if (eVar.b() >= 0 && eVar.b() < enumConstants.length) {
                a(enumConstants[eVar.b()]);
            }
        }
    }
}
