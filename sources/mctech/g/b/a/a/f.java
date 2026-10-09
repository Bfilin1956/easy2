package mctech.g.b.a.a;

import java.util.function.Consumer;
import java.util.function.Supplier;
import net.minecraft.world.level.Level;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/b/a/a/f.class */
public abstract class f implements m {
    private float a;

    public abstract float b();

    public abstract void a(float f);

    public static f a() {
        return new f() { // from class: mctech.g.b.a.a.f.1
            private float a;

            @Override // mctech.g.b.a.a.f
            public float b() {
                return this.a;
            }

            @Override // mctech.g.b.a.a.f
            public void a(float f) {
                this.a = f;
            }
        };
    }

    public static f a(final Supplier<Float> supplier, final Consumer<Float> consumer) {
        return new f() { // from class: mctech.g.b.a.a.f.2
            @Override // mctech.g.b.a.a.f
            public float b() {
                return ((Float) supplier.get()).floatValue();
            }

            @Override // mctech.g.b.a.a.f
            public void a(float f) {
                consumer.accept(Float.valueOf(f));
            }
        };
    }

    public static f a(final Supplier<Float> supplier) {
        return new f() { // from class: mctech.g.b.a.a.f.3
            @Override // mctech.g.b.a.a.f
            public float b() {
                return ((Float) supplier.get()).floatValue();
            }

            @Override // mctech.g.b.a.a.f
            public void a(float f) {
                throw new UnsupportedOperationException("Attempt to set a read-only sync slot.");
            }
        };
    }

    @Override // mctech.g.b.a.a.m
    public m.a c() {
        float fB = b();
        m.a aVar = fB != this.a ? m.a.FULL : m.a.NONE;
        this.a = fB;
        return aVar;
    }

    @Override // mctech.g.b.a.a.m
    public mctech.g.b.a.a.a.l a(Level level, m.a aVar) {
        return new mctech.g.b.a.a.a.c(b());
    }

    @Override // mctech.g.b.a.a.m
    public void a(Level level, mctech.g.b.a.a.a.l lVar) {
        if (lVar instanceof mctech.g.b.a.a.a.c) {
            a(((mctech.g.b.a.a.a.c) lVar).b());
        }
    }
}
