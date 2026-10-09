package mctech.g.c.b.a;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.List;
import mctech.g.a.c.g;
import mctech.g.a.c.h;
import net.minecraft.world.item.DyeColor;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/c/b/a/d.class */
public final class d extends Record {
    private final boolean a;
    private final DyeColor b;
    private final boolean c;
    private final DyeColor d;
    private final boolean e;
    private final DyeColor f;

    public d(boolean z, DyeColor dyeColor, boolean z2, DyeColor dyeColor2, boolean z3, DyeColor dyeColor3) {
        this.a = z;
        this.b = dyeColor;
        this.c = z2;
        this.d = dyeColor2;
        this.e = z3;
        this.f = dyeColor3;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, d.class), d.class, "canInput;inputChannel;canOutput;outputChannel;isRedstoneSensitive;redstoneChannel", "FIELD:Lmctech/g/c/b/a/d;->a:Z", "FIELD:Lmctech/g/c/b/a/d;->b:Lnet/minecraft/world/item/DyeColor;", "FIELD:Lmctech/g/c/b/a/d;->c:Z", "FIELD:Lmctech/g/c/b/a/d;->d:Lnet/minecraft/world/item/DyeColor;", "FIELD:Lmctech/g/c/b/a/d;->e:Z", "FIELD:Lmctech/g/c/b/a/d;->f:Lnet/minecraft/world/item/DyeColor;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, d.class), d.class, "canInput;inputChannel;canOutput;outputChannel;isRedstoneSensitive;redstoneChannel", "FIELD:Lmctech/g/c/b/a/d;->a:Z", "FIELD:Lmctech/g/c/b/a/d;->b:Lnet/minecraft/world/item/DyeColor;", "FIELD:Lmctech/g/c/b/a/d;->c:Z", "FIELD:Lmctech/g/c/b/a/d;->d:Lnet/minecraft/world/item/DyeColor;", "FIELD:Lmctech/g/c/b/a/d;->e:Z", "FIELD:Lmctech/g/c/b/a/d;->f:Lnet/minecraft/world/item/DyeColor;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, d.class, Object.class), d.class, "canInput;inputChannel;canOutput;outputChannel;isRedstoneSensitive;redstoneChannel", "FIELD:Lmctech/g/c/b/a/d;->a:Z", "FIELD:Lmctech/g/c/b/a/d;->b:Lnet/minecraft/world/item/DyeColor;", "FIELD:Lmctech/g/c/b/a/d;->c:Z", "FIELD:Lmctech/g/c/b/a/d;->d:Lnet/minecraft/world/item/DyeColor;", "FIELD:Lmctech/g/c/b/a/d;->e:Z", "FIELD:Lmctech/g/c/b/a/d;->f:Lnet/minecraft/world/item/DyeColor;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public boolean b() {
        return this.a;
    }

    public DyeColor c() {
        return this.b;
    }

    public boolean d() {
        return this.c;
    }

    public DyeColor e() {
        return this.d;
    }

    public boolean f() {
        return this.e;
    }

    public DyeColor g() {
        return this.f;
    }

    public static d a() {
        return new d(false, DyeColor.GREEN, false, DyeColor.GREEN, false, DyeColor.RED);
    }

    public static d a(mctech.g.a.c.c cVar) {
        boolean zE = false;
        boolean zF = false;
        DyeColor dyeColorG = DyeColor.GREEN;
        DyeColor dyeColorH = DyeColor.GREEN;
        if (cVar instanceof g) {
            g gVar = (g) cVar;
            zE = gVar.e();
            zF = gVar.f();
            dyeColorG = gVar.g();
            dyeColorH = gVar.h();
        }
        boolean z = false;
        DyeColor dyeColor = DyeColor.RED;
        if (cVar instanceof h) {
            List<DyeColor> listB = ((h) cVar).b();
            if (!listB.isEmpty()) {
                z = true;
                dyeColor = (DyeColor) listB.getFirst();
            }
        }
        return new d(zE, dyeColorG, zF, dyeColorH, z, dyeColor);
    }
}
