package mctech.g.b.a.a;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Supplier;
import mctech.g.b.a.a.a.n;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/b/a/a/l.class */
public abstract class l implements m {

    @Nullable
    private String a;

    @Nullable
    public abstract String b();

    public abstract void a(@Nullable String str);

    public static l a() {
        return new l() { // from class: mctech.g.b.a.a.l.1

            @Nullable
            private String a;

            @Override // mctech.g.b.a.a.l
            @Nullable
            public String b() {
                return this.a;
            }

            @Override // mctech.g.b.a.a.l
            public void a(@Nullable String str) {
                this.a = str;
            }
        };
    }

    public static l a(final Supplier<String> supplier, final Consumer<String> consumer) {
        return new l() { // from class: mctech.g.b.a.a.l.2
            @Override // mctech.g.b.a.a.l
            @Nullable
            public String b() {
                return (String) supplier.get();
            }

            @Override // mctech.g.b.a.a.l
            public void a(@Nullable String str) {
                consumer.accept(str);
            }
        };
    }

    public static l a(final Supplier<String> supplier) {
        return new l() { // from class: mctech.g.b.a.a.l.3
            @Override // mctech.g.b.a.a.l
            @Nullable
            public String b() {
                return (String) supplier.get();
            }

            @Override // mctech.g.b.a.a.l
            public void a(@Nullable String str) {
                throw new UnsupportedOperationException("Attempt to set a read-only sync slot.");
            }
        };
    }

    @Override // mctech.g.b.a.a.m
    public m.a c() {
        String strB = b();
        m.a aVar = Objects.equals(strB, this.a) ? m.a.NONE : m.a.FULL;
        this.a = strB;
        return aVar;
    }

    @Override // mctech.g.b.a.a.m
    public mctech.g.b.a.a.a.l a(Level level, m.a aVar) {
        String strB = b();
        if (strB == null) {
            return new mctech.g.b.a.a.a.i();
        }
        return new n(strB);
    }

    @Override // mctech.g.b.a.a.m
    public void a(Level level, mctech.g.b.a.a.a.l lVar) {
        if (lVar instanceof n) {
            a(((n) lVar).b());
        } else if (lVar instanceof mctech.g.b.a.a.a.i) {
            a((String) null);
        }
    }
}
