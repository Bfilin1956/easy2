package mctech.components.a;

import mctech.utils.math.geometry.Vec2i;
import net.neoforged.fml.ModList;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: mctech.components.a.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/a/i.class */
public class C0096i extends M<C0096i> {
    private static final boolean a = ModList.get().isLoaded("emi");
    private final a b;
    private boolean c;

    public C0096i(int i, int i2, @NotNull a aVar) {
        this(C0101n.a, i, i2, C0101n.q.getX(), C0101n.q.getY(), C0101n.a.v, C0101n.a.v, () -> {
            return 0;
        }, aVar);
    }

    public C0096i(@NotNull C0101n c0101n, int i, int i2, int i3, int i4, @NotNull Vec2i vec2i, @NotNull Vec2i vec2i2, @NotNull InterfaceC0102o interfaceC0102o, @NotNull a aVar) {
        super(c0101n, i, i2, i3, i4, vec2i, vec2i2, interfaceC0102o);
        this.b = aVar;
        c(false);
        a();
        g(1);
    }

    public C0096i(@NotNull C0101n c0101n, int i, int i2, int i3, int i4, @NotNull a aVar) {
        super(c0101n, i, i2, i3, i4, new Vec2i(mctech.utils.c.h.i - i3, mctech.utils.c.h.i - i4), new Vec2i(mctech.utils.c.h.i - i3, mctech.utils.c.h.i - i4), () -> {
            return 0;
        });
        this.b = aVar;
        c(false);
        a();
        g(1);
    }

    public void a() {
        if (!a) {
            return;
        }
        if (!this.c) {
            b(C0101n.a.u);
        } else {
            b(Vec2i.EMPTY);
            c(Vec2i.EMPTY);
        }
        d("gui.mctech.wiki.show.craft");
        a(m -> {
            if (this.b.a()) {
                this.b.openCategory();
            }
        });
    }

    public C0096i b() {
        this.c = true;
        return this;
    }

    @Override // mctech.components.a.M, mctech.components.a.R
    public Vec2i d() {
        return C0101n.a.v;
    }

    @Override // mctech.components.a.R
    public Vec2i e() {
        return C0101n.a.v;
    }

    /* JADX INFO: renamed from: mctech.components.a.i$a */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/a/i$a.class */
    public interface a {
        void openCategory();

        default boolean a() {
            return true;
        }
    }
}
