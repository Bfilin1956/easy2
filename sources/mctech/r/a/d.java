package mctech.r.a;

import mctech.blockentities.c.C0055b;
import mctech.u.E;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.registries.DeferredHolder;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/r/a/d.class */
public enum d {
    ORE_MACERATOR("ore_macerator", C0055b.class, 2, E.a),
    CONCENTRATOR("concentrator", C0055b.class, 2, E.e, new int[]{0, 22}, new int[]{0, 22}, new int[]{0, 23}, new int[]{0, 28}, new int[]{0, 23}, 1, new int[]{62, 25}),
    HYDRAULIC_WASHER("hydraulic_washer", C0055b.class, 1, E.g, new int[]{0, 0}, new int[]{0, 0}, new int[]{0, -22}, new int[]{0, 28}, new int[]{0, -22}, 2, new int[]{62, 25}, new int[]{142, 27}),
    INGOT_FOUNDRY("ingot_foundry", C0055b.class, 1, E.i, new int[]{0, 0}, new int[]{0, -7}, new int[]{0, -22}, new int[]{0, 28}, new int[]{0, -22}),
    ORE_COMBINE("ore_combine", C0055b.class, 3, E.k, new int[]{0, 0}, new int[]{0, 0}, new int[]{0, 25}, new int[]{0, 28}, new int[]{0, 25}),
    CHEMICAL_PURIFICATING("chemical_purification", C0055b.class, 1, E.c, new int[]{0, 22}, new int[]{0, 22}, new int[]{0, 0}, new int[]{0, 0}, new int[]{0, 0}, 1, new int[]{62, 25});

    private final String g;
    private final Class<? extends BlockEntity> h;
    private final int i;
    private final DeferredHolder<RecipeType<?>, RecipeType<?>> j;
    private final int[] k;
    private final int[] l;
    private final int[] m;
    private final int n;
    private final int[] o;
    private final int[] p;
    private final int[] q;
    private final int[] r;

    d(String str, Class cls, int i, DeferredHolder deferredHolder, int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, int[] iArr5, int i2, int[] iArr6, int[] iArr7) {
        this.g = str;
        this.h = cls;
        this.i = i;
        this.j = deferredHolder;
        this.k = iArr;
        this.l = iArr2;
        this.n = i2;
        this.o = iArr6;
        this.p = iArr7;
        this.q = iArr5;
        this.r = iArr4;
        this.m = iArr3;
    }

    d(String str, Class cls, int i, DeferredHolder deferredHolder, int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, int[] iArr5, int i2, int[] iArr6) {
        this(str, cls, i, deferredHolder, iArr, iArr2, iArr3, iArr4, iArr5, i2, iArr6, new int[]{0, 0});
    }

    d(String str, Class cls, int i, DeferredHolder deferredHolder, int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, int[] iArr5) {
        this(str, cls, i, deferredHolder, iArr, iArr2, iArr3, iArr4, iArr5, 0, new int[]{0, 0});
    }

    d(String str, Class cls, int i, DeferredHolder deferredHolder) {
        this(str, cls, i, deferredHolder, new int[]{0, 0}, new int[]{0, 0}, new int[]{0, 0}, new int[]{0, 0}, new int[]{0, 0});
    }

    public String a(c cVar) {
        return cVar.c() + "_" + this.g;
    }

    public Class<? extends BlockEntity> a() {
        return this.h;
    }

    public int b() {
        return this.i;
    }

    public String c() {
        return this.g;
    }

    public DeferredHolder<RecipeType<?>, RecipeType<?>> d() {
        return this.j;
    }

    public int[] e() {
        return this.k;
    }

    public int[] f() {
        return this.l;
    }

    public int g() {
        return this.n;
    }

    public int[] h() {
        return this.o;
    }

    public int[] i() {
        return this.p;
    }

    public int[] j() {
        return this.q;
    }

    public int[] k() {
        return this.r;
    }

    public int[] l() {
        return this.m;
    }
}
