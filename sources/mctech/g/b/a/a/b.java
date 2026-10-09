package mctech.g.b.a.a;

import java.util.function.Consumer;
import java.util.function.Supplier;
import net.minecraft.world.level.Level;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/b/a/a/b.class */
public abstract class b implements m {
    private boolean a;

    public abstract boolean b();

    public abstract void a(boolean z);

    public static b a() {
        return new b() { // from class: mctech.g.b.a.a.b.1
            private boolean a;

            @Override // mctech.g.b.a.a.b
            public boolean b() {
                return this.a;
            }

            @Override // mctech.g.b.a.a.b
            public void a(boolean z) {
                this.a = z;
            }
        };
    }

    public static b a(final Supplier<Boolean> supplier, final Consumer<Boolean> consumer) {
        return new b() { // from class: mctech.g.b.a.a.b.2
            @Override // mctech.g.b.a.a.b
            public boolean b() {
                return ((Boolean) supplier.get()).booleanValue();
            }

            @Override // mctech.g.b.a.a.b
            public void a(boolean z) {
                consumer.accept(Boolean.valueOf(z));
            }
        };
    }

    public static b a(final Supplier<Boolean> supplier) {
        return new b() { // from class: mctech.g.b.a.a.b.3
            @Override // mctech.g.b.a.a.b
            public boolean b() {
                return ((Boolean) supplier.get()).booleanValue();
            }

            @Override // mctech.g.b.a.a.b
            public void a(boolean z) {
                throw new UnsupportedOperationException("Attempt to set a read-only sync slot.");
            }
        };
    }

    @Override // mctech.g.b.a.a.m
    public m.a c() {
        boolean zB = b();
        m.a aVar = zB != this.a ? m.a.FULL : m.a.NONE;
        this.a = zB;
        return aVar;
    }

    @Override // mctech.g.b.a.a.m
    public mctech.g.b.a.a.a.l a(Level level, m.a aVar) {
        return new mctech.g.b.a.a.a.b(b());
    }

    @Override // mctech.g.b.a.a.m
    public void a(Level level, mctech.g.b.a.a.a.l lVar) {
        if (lVar instanceof mctech.g.b.a.a.a.b) {
            a(((mctech.g.b.a.a.a.b) lVar).b());
        }
    }
}
