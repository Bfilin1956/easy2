package mctech.m.g;

import mctech.api.tiles.IMachine;
import mctech.api.util.DirectionList;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/g/y.class */
public class y {
    private final int[] a;

    @NotNull
    private final mctech.m.e.k b;

    @Nullable
    private mctech.m.e.a c;

    @Nullable
    private DirectionList d;

    @Nullable
    private mctech.m.e.a.a e;

    @Nullable
    private mctech.m.c.g f;

    @Nullable
    private mctech.m.e.a.a g;

    @Nullable
    private mctech.m.c.g h;

    @Nullable
    private mctech.m.e.g i;
    private boolean j;
    private int k;

    private y() {
        this.a = new int[4];
        this.b = mctech.m.e.k.b;
        this.k = 64;
    }

    public y(@NotNull mctech.m.e.k kVar, int... iArr) {
        this.a = iArr;
        this.b = kVar;
        this.k = 64;
        if (iArr.length == 0) {
            throw new RuntimeException("Cannot create parameters for empty slot list!");
        }
    }

    public y a(@NotNull mctech.m.e.a aVar) {
        this.c = aVar;
        return this;
    }

    public y a(@NotNull DirectionList directionList) {
        this.d = directionList;
        return this;
    }

    public y a(@NotNull mctech.m.e.a.a aVar) {
        this.e = aVar;
        return this;
    }

    public y a(@Nullable mctech.m.c.g gVar) {
        this.f = gVar;
        return this;
    }

    public y b(@Nullable mctech.m.e.a.a aVar) {
        this.g = aVar;
        return this;
    }

    public y b(@Nullable mctech.m.c.g gVar) {
        this.h = gVar;
        return this;
    }

    public y a(boolean z) {
        this.j = z;
        return this;
    }

    public y a(@Nullable mctech.m.e.g gVar) {
        this.i = gVar;
        return this;
    }

    public y a(int i) {
        this.k = i;
        return this;
    }

    public int a() {
        return this.k;
    }

    public boolean b(int i) {
        for (int i2 : this.a) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public int[] b() {
        return this.a;
    }

    @NotNull
    public mctech.m.e.k c() {
        return this.b;
    }

    @Nullable
    public mctech.m.e.a d() {
        return this.c;
    }

    @Nullable
    public DirectionList e() {
        return this.d;
    }

    @Nullable
    public mctech.m.e.a.a f() {
        return this.e;
    }

    @Nullable
    public mctech.m.c.g g() {
        return this.f;
    }

    @Nullable
    public mctech.m.c.g h() {
        return this.h;
    }

    @Nullable
    public mctech.m.e.a.a i() {
        return this.g;
    }

    public final void a(@NotNull mctech.m.e.i iVar) {
        if (this.i != null) {
            iVar.a(this.i);
            return;
        }
        if (this.j) {
            iVar.b(this.b, this.a);
        } else {
            iVar.a(this.b, this.a);
        }
        if (this.c != null) {
            iVar.a(this.c, this.a);
        }
        if (this.d != null) {
            iVar.a(this.d, this.a);
        }
        if (this.e != null) {
            iVar.a(this.e, this.a);
        } else if (this.f != null) {
            iVar.a(this.f, this.a);
        }
        if (this.g != null) {
            iVar.b(this.g, this.a);
        } else if (this.h != null) {
            iVar.b(this.h, this.a);
        }
    }

    public static y b(@NotNull mctech.m.e.g gVar) {
        return new y().a(gVar);
    }

    public static y a(int... iArr) {
        return new y(mctech.m.e.k.n, iArr).a(mctech.m.e.a.IMPORT).a(DirectionList.ALL).a(mctech.m.c.a.f.b);
    }

    public static y b(int... iArr) {
        return new y(mctech.m.e.k.p, iArr).a(DirectionList.ALL).a(mctech.m.e.a.BOTH).a(mctech.m.c.r.a()).b(mctech.m.c.a.c.e);
    }

    public static y c(int... iArr) {
        return new y(mctech.m.e.k.q, iArr).a(DirectionList.ALL).a(mctech.m.e.a.BOTH).a(mctech.m.c.a.c.a).b(mctech.m.c.a.c.b);
    }

    public static y d(int... iArr) {
        return new y(mctech.m.e.k.l, iArr).a(DirectionList.ALL).a(mctech.m.e.a.EXPORT).a(mctech.m.c.r.c).b(mctech.m.c.r.d);
    }

    public static y e(int... iArr) {
        return new y(mctech.m.e.k.m, iArr).a(DirectionList.ALL).a(mctech.m.e.a.EXPORT).a(mctech.m.c.r.c).b(mctech.m.c.r.d);
    }

    public static y f(int... iArr) {
        return new y(mctech.m.e.k.g, iArr).a(DirectionList.ALL).a(mctech.m.e.a.IMPORT);
    }

    public static y g(int... iArr) {
        return new y(mctech.m.e.k.h, iArr).a(DirectionList.ALL).a(mctech.m.e.a.IMPORT);
    }

    public static <M extends BlockEntity & IMachine> y a(M m, int... iArr) {
        return new y(mctech.m.e.k.c, iArr).a(mctech.m.e.a.DISABLED).a(new mctech.m.c.u(m)).a(DirectionList.ALL);
    }

    public static y a(mctech.m.e.k kVar, int... iArr) {
        return new y(kVar, iArr).a(DirectionList.ALL).a(mctech.m.e.a.IMPORT);
    }
}
