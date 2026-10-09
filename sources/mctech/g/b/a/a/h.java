package mctech.g.b.a.a;

import java.util.function.Consumer;
import java.util.function.Supplier;
import net.minecraft.world.level.Level;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/b/a/a/h.class */
public abstract class h implements m {
    private int a;

    public abstract int b();

    public abstract void a(int i);

    public static h a() {
        return new h() { // from class: mctech.g.b.a.a.h.1
            private int a;

            @Override // mctech.g.b.a.a.h
            public int b() {
                return this.a;
            }

            @Override // mctech.g.b.a.a.h
            public void a(int i) {
                this.a = i;
            }
        };
    }

    public static h a(final Supplier<Integer> supplier, final Consumer<Integer> consumer) {
        return new h() { // from class: mctech.g.b.a.a.h.2
            @Override // mctech.g.b.a.a.h
            public int b() {
                return ((Integer) supplier.get()).intValue();
            }

            @Override // mctech.g.b.a.a.h
            public void a(int i) {
                consumer.accept(Integer.valueOf(i));
            }
        };
    }

    public static h a(final Supplier<Integer> supplier) {
        return new h() { // from class: mctech.g.b.a.a.h.3
            @Override // mctech.g.b.a.a.h
            public int b() {
                return ((Integer) supplier.get()).intValue();
            }

            @Override // mctech.g.b.a.a.h
            public void a(int i) {
                throw new UnsupportedOperationException("Attempt to set a read-only sync slot.");
            }
        };
    }

    @Override // mctech.g.b.a.a.m
    public m.a c() {
        int iB = b();
        m.a aVar = iB != this.a ? m.a.FULL : m.a.NONE;
        this.a = iB;
        return aVar;
    }

    @Override // mctech.g.b.a.a.m
    public mctech.g.b.a.a.a.l a(Level level, m.a aVar) {
        return new mctech.g.b.a.a.a.e(b());
    }

    @Override // mctech.g.b.a.a.m
    public void a(Level level, mctech.g.b.a.a.a.l lVar) {
        if (lVar instanceof mctech.g.b.a.a.a.e) {
            a(((mctech.g.b.a.a.a.e) lVar).b());
        }
    }
}
