package mctech.g.b.a.a;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Supplier;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/b/a/a/j.class */
public abstract class j<T> implements m {
    private final ResourceKey<Registry<T>> a;
    private T b;

    @Nullable
    public abstract T a();

    public abstract void a(@Nullable T t);

    public static <T> j<T> a(ResourceKey<Registry<T>> resourceKey) {
        return new j<T>(resourceKey) { // from class: mctech.g.b.a.a.j.1

            @Nullable
            private T a;

            @Override // mctech.g.b.a.a.j
            @Nullable
            public T a() {
                return this.a;
            }

            @Override // mctech.g.b.a.a.j
            public void a(@Nullable T t) {
                this.a = t;
            }
        };
    }

    public static <T> j<T> a(ResourceKey<Registry<T>> resourceKey, final Supplier<T> supplier, final Consumer<T> consumer) {
        return new j<T>(resourceKey) { // from class: mctech.g.b.a.a.j.2
            @Override // mctech.g.b.a.a.j
            @Nullable
            public T a() {
                return (T) supplier.get();
            }

            @Override // mctech.g.b.a.a.j
            public void a(@Nullable T t) {
                consumer.accept(t);
            }
        };
    }

    public static <T> j<T> a(ResourceKey<Registry<T>> resourceKey, final Supplier<T> supplier) {
        return new j<T>(resourceKey) { // from class: mctech.g.b.a.a.j.3
            @Override // mctech.g.b.a.a.j
            @Nullable
            public T a() {
                return (T) supplier.get();
            }

            @Override // mctech.g.b.a.a.j
            public void a(@Nullable T t) {
                throw new UnsupportedOperationException("Attempt to set a read-only sync slot.");
            }
        };
    }

    protected j(ResourceKey<Registry<T>> resourceKey) {
        this.a = resourceKey;
    }

    @Override // mctech.g.b.a.a.m
    public m.a c() {
        T tA = a();
        m.a aVar = Objects.equals(tA, this.b) ? m.a.FULL : m.a.NONE;
        this.b = tA;
        return aVar;
    }

    @Override // mctech.g.b.a.a.m
    public mctech.g.b.a.a.a.l a(Level level, m.a aVar) {
        return new mctech.g.b.a.a.a.e(level.registryAccess().registryOrThrow(this.a).getId(a()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // mctech.g.b.a.a.m
    public void a(Level level, mctech.g.b.a.a.a.l lVar) {
        if (lVar instanceof mctech.g.b.a.a.a.e) {
            a(level.registryAccess().registryOrThrow(this.a).byId(((mctech.g.b.a.a.a.e) lVar).b()));
        }
    }
}
