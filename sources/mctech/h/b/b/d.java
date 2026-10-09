package mctech.h.b.b;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/h/b/b/d.class */
public abstract class d implements c {
    protected final mctech.h.b.a.d a;
    protected final Class<?> b;

    public abstract void a(mctech.h.b.a aVar);

    public d(Class<?> cls) {
        this.b = cls;
        this.a = mctech.h.b.a.a(cls);
    }

    @Override // mctech.h.b.b.c
    public final void a(@NotNull String str, mctech.h.b.a aVar) {
        if (str.equals(this.a.a())) {
            a(aVar);
        }
    }
}
