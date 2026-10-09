package mctech.utils;

/* JADX INFO: renamed from: mctech.utils.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/c.class */
public class C0201c<T> {
    private final T a;

    /* JADX INFO: renamed from: mctech.utils.c$a */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/c$a.class */
    public interface a<T> {
        void a(T t) throws Throwable;
    }

    /* JADX INFO: renamed from: mctech.utils.c$b */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/c$b.class */
    public interface b<T, R> {
        R a(T t) throws Throwable;
    }

    /* JADX INFO: renamed from: mctech.utils.c$c, reason: collision with other inner class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/c$c.class */
    public interface InterfaceC0042c<R> {
        R a() throws Throwable;
    }

    public C0201c(T t) {
        this.a = t;
    }

    public C0201c() {
        this.a = null;
    }

    public static <T> C0201c<T> a(T t) {
        return new C0201c<>(t);
    }

    public static <T> C0201c<T> a() {
        return new C0201c<>();
    }

    public <S> C0201c<S> a(b<? super T, ? extends S> bVar) {
        try {
            return new C0201c<>(this.a == null ? null : bVar.a(this.a));
        } catch (Throwable th) {
            return a();
        }
    }

    public void a(a<? super T> aVar) {
        if (this.a != null) {
            try {
                aVar.a(this.a);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public boolean b() {
        return this.a != null;
    }

    public T b(T t) {
        return this.a == null ? t : this.a;
    }

    public T a(InterfaceC0042c<T> interfaceC0042c) {
        try {
            return this.a == null ? interfaceC0042c.a() : this.a;
        } catch (Throwable th) {
            return this.a;
        }
    }

    public T c() {
        return this.a;
    }

    public boolean d() {
        if (this.a != null && (this.a instanceof Boolean)) {
            return ((Boolean) this.a).booleanValue();
        }
        return false;
    }

    public int e() {
        if (this.a != null && (this.a instanceof Integer)) {
            return ((Integer) this.a).intValue();
        }
        return 0;
    }

    public long f() {
        if (this.a != null && (this.a instanceof Long)) {
            return ((Long) this.a).longValue();
        }
        return 0L;
    }

    public double g() {
        if (this.a != null && (this.a instanceof Double)) {
            return ((Double) this.a).doubleValue();
        }
        return 0.0d;
    }

    public float h() {
        if (this.a != null && (this.a instanceof Float)) {
            return ((Float) this.a).floatValue();
        }
        return 0.0f;
    }
}
