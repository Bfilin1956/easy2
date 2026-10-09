package mctech.components.b;

import java.util.function.Consumer;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/b/j.class */
public interface j {
    int a();

    int b();

    int c();

    int d();

    boolean a(ItemStack itemStack);

    void b(ItemStack itemStack);

    boolean e();

    boolean f();

    static j a(mctech.m.g.n nVar) {
        return new a(nVar);
    }

    static j a(int i, int i2, int i3, int i4, mctech.m.c.g gVar, Consumer<ItemStack> consumer) {
        return new b(i, i2, i3, i4, gVar, consumer);
    }

    static j b(int i, int i2, int i3, int i4, mctech.m.c.g gVar, Consumer<ItemStack> consumer) {
        return new b(i, i2, i3, i4, gVar, consumer).g();
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/b/j$b.class */
    public static class b implements j {
        int a;
        int b;
        int c;
        int d;
        mctech.m.c.g e;
        Consumer<ItemStack> f;
        boolean g = true;
        boolean h = false;

        public b(int i, int i2, int i3, int i4, mctech.m.c.g gVar, Consumer<ItemStack> consumer) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
            this.e = gVar;
            this.f = consumer;
        }

        public j g() {
            this.g = false;
            return this;
        }

        public j h() {
            this.h = true;
            return this;
        }

        @Override // mctech.components.b.j
        public int a() {
            return this.a;
        }

        @Override // mctech.components.b.j
        public int b() {
            return this.b;
        }

        @Override // mctech.components.b.j
        public int c() {
            return this.c;
        }

        @Override // mctech.components.b.j
        public int d() {
            return this.d;
        }

        @Override // mctech.components.b.j
        public boolean f() {
            return this.h;
        }

        @Override // mctech.components.b.j
        public boolean a(ItemStack itemStack) {
            return this.e.matches(itemStack);
        }

        @Override // mctech.components.b.j
        public void b(ItemStack itemStack) {
            this.f.accept(itemStack);
        }

        @Override // mctech.components.b.j
        public boolean e() {
            return this.g;
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/b/j$a.class */
    public static class a implements j {
        mctech.m.g.n a;

        public a(mctech.m.g.n nVar) {
            this.a = nVar;
        }

        @Override // mctech.components.b.j
        public int a() {
            return this.a.b() - 2;
        }

        @Override // mctech.components.b.j
        public int b() {
            return this.a.c() - 2;
        }

        @Override // mctech.components.b.j
        public int c() {
            return ((mctech.m.a.j) this.a).o() + 4;
        }

        @Override // mctech.components.b.j
        public int d() {
            return ((mctech.m.a.j) this.a).o() + 4;
        }

        @Override // mctech.components.b.j
        public boolean f() {
            return this.a instanceof mctech.m.g.m;
        }

        @Override // mctech.components.b.j
        public boolean e() {
            return this.a.ae_() == mctech.m.g.n.a.FILTER;
        }

        @Override // mctech.components.b.j
        public boolean a(ItemStack itemStack) {
            return this.a.b(itemStack);
        }

        @Override // mctech.components.b.j
        public void b(ItemStack itemStack) {
        }
    }
}
