package mctech.g.f;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/f/g.class */
@Deprecated(since = "8.0.0")
public final class g extends Record {
    private final boolean a;
    private final DyeColor b;
    private final boolean c;
    private final DyeColor d;
    private final mctech.g.a.f.a e;
    private final DyeColor f;
    private final ItemStack g;
    private final ItemStack h;
    private final ItemStack i;

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, g.class), g.class, "isImport;importChannel;isExport;exportChannel;redstoneSettings;redstoneChannel;importFilter;exportFilter;upgradeItem", "FIELD:Lmctech/g/f/g;->a:Z", "FIELD:Lmctech/g/f/g;->b:Lnet/minecraft/world/item/DyeColor;", "FIELD:Lmctech/g/f/g;->c:Z", "FIELD:Lmctech/g/f/g;->d:Lnet/minecraft/world/item/DyeColor;", "FIELD:Lmctech/g/f/g;->e:Lmctech/g/a/f/a;", "FIELD:Lmctech/g/f/g;->f:Lnet/minecraft/world/item/DyeColor;", "FIELD:Lmctech/g/f/g;->g:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/g/f/g;->h:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/g/f/g;->i:Lnet/minecraft/world/item/ItemStack;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, g.class), g.class, "isImport;importChannel;isExport;exportChannel;redstoneSettings;redstoneChannel;importFilter;exportFilter;upgradeItem", "FIELD:Lmctech/g/f/g;->a:Z", "FIELD:Lmctech/g/f/g;->b:Lnet/minecraft/world/item/DyeColor;", "FIELD:Lmctech/g/f/g;->c:Z", "FIELD:Lmctech/g/f/g;->d:Lnet/minecraft/world/item/DyeColor;", "FIELD:Lmctech/g/f/g;->e:Lmctech/g/a/f/a;", "FIELD:Lmctech/g/f/g;->f:Lnet/minecraft/world/item/DyeColor;", "FIELD:Lmctech/g/f/g;->g:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/g/f/g;->h:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/g/f/g;->i:Lnet/minecraft/world/item/ItemStack;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, g.class, Object.class), g.class, "isImport;importChannel;isExport;exportChannel;redstoneSettings;redstoneChannel;importFilter;exportFilter;upgradeItem", "FIELD:Lmctech/g/f/g;->a:Z", "FIELD:Lmctech/g/f/g;->b:Lnet/minecraft/world/item/DyeColor;", "FIELD:Lmctech/g/f/g;->c:Z", "FIELD:Lmctech/g/f/g;->d:Lnet/minecraft/world/item/DyeColor;", "FIELD:Lmctech/g/f/g;->e:Lmctech/g/a/f/a;", "FIELD:Lmctech/g/f/g;->f:Lnet/minecraft/world/item/DyeColor;", "FIELD:Lmctech/g/f/g;->g:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/g/f/g;->h:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/g/f/g;->i:Lnet/minecraft/world/item/ItemStack;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public boolean a() {
        return this.a;
    }

    public DyeColor b() {
        return this.b;
    }

    public boolean c() {
        return this.c;
    }

    public DyeColor d() {
        return this.d;
    }

    public mctech.g.a.f.a e() {
        return this.e;
    }

    public DyeColor f() {
        return this.f;
    }

    public ItemStack g() {
        return this.g;
    }

    public ItemStack h() {
        return this.h;
    }

    public ItemStack i() {
        return this.i;
    }

    public g(boolean z, DyeColor dyeColor, boolean z2, DyeColor dyeColor2, mctech.g.a.f.a aVar, DyeColor dyeColor3, ItemStack itemStack, ItemStack itemStack2, ItemStack itemStack3) {
        this.a = z;
        this.b = dyeColor;
        this.c = z2;
        this.d = dyeColor2;
        this.e = aVar;
        this.f = dyeColor3;
        this.g = itemStack;
        this.h = itemStack2;
        this.i = itemStack3;
    }
}
