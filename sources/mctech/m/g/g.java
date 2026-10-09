package mctech.m.g;

import mctech.MCTech;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/g/g.class */
public class g extends x implements n {
    mctech.m.c.g c;

    public g(mctech.m.a.g gVar, int i, int i2, int i3, mctech.m.c.g gVar2) {
        super(gVar, i, i2, i3);
        this.c = gVar2;
    }

    public boolean mayPlace(ItemStack itemStack) {
        return this.c == null || this.c.matches(itemStack);
    }

    @Override // mctech.m.g.n
    public int ad_() {
        return this.index;
    }

    @Override // mctech.m.g.n
    public int b() {
        return this.x;
    }

    @Override // mctech.m.g.n
    public int c() {
        return this.y;
    }

    @Override // mctech.m.g.n
    public boolean b(ItemStack itemStack) {
        return mayPlace(itemStack);
    }

    public void a(ItemStack itemStack) {
    }

    public static Slot a(mctech.m.a.g gVar, int i, int i2, int i3, Class<?> cls) {
        return new g(gVar, i, i2, i3, new mctech.m.c.d(cls));
    }

    public static Slot a(mctech.m.a.g gVar, int i, int i2, int i3) {
        return new g(gVar, i, i2, i3, mctech.m.c.a.c.a).a(a("charge_slot"));
    }

    public static Slot a(mctech.m.a.g gVar, int i, int i2, int i3, int i4) {
        return new g(gVar, i2, i3, i4, new mctech.m.c.a.c(true, true, i)).a(a("charge_slot"));
    }

    public static Slot b(mctech.m.a.g gVar, int i, int i2, int i3, int i4) {
        return new g(gVar, i2, i3, i4, new mctech.m.c.a.c(false, true, i)).a(a("discharge"));
    }

    public static Slot b(mctech.m.a.g gVar, int i, int i2, int i3) {
        return new g(gVar, i, i2, i3, mctech.m.c.a.c.d).a(a("discharge"));
    }

    public static Slot c(mctech.m.a.g gVar, int i, int i2, int i3, int i4) {
        return new g(gVar, i2, i3, i4, mctech.m.c.a.c.g) { // from class: mctech.m.g.g.1
            @Override // mctech.m.g.x
            public int getMaxStackSize() {
                return 1;
            }
        };
    }

    public static Slot d(mctech.m.a.g gVar, int i, int i2, int i3, int i4) {
        return new g(gVar, i2, i3, i4, mctech.m.c.a.c.h) { // from class: mctech.m.g.g.2
            @Override // mctech.m.g.x
            public int getMaxStackSize() {
                return 1;
            }
        };
    }

    public static Slot c(mctech.m.a.g gVar, int i, int i2, int i3) {
        return new g(gVar, i, i2, i3, mctech.m.c.f.a).a(a("fluid_drain"));
    }

    public static Slot a(mctech.m.a.g gVar, int i, int i2, int i3, Fluid fluid) {
        return new g(gVar, i, i2, i3, mctech.m.c.f.a(fluid)).a(a("fluid_drain"));
    }

    public static Slot a(mctech.m.a.g gVar, int i, int i2, int i3, Fluid... fluidArr) {
        return new g(gVar, i, i2, i3, new mctech.m.c.f(fluidArr)).a(a("fluid_drain"));
    }

    public static Slot a(mctech.m.a.g gVar, int i, int i2, int i3, IFluidHandler iFluidHandler) {
        return new g(gVar, i, i2, i3, new mctech.m.c.f.b(iFluidHandler)).a(a("fluid_drain"));
    }

    public static Slot b(mctech.m.a.g gVar, int i, int i2, int i3, IFluidHandler iFluidHandler) {
        return new g(gVar, i, i2, i3, new mctech.m.c.f.c(iFluidHandler)).a(a("fluid_drain"));
    }

    public static Slot d(mctech.m.a.g gVar, int i, int i2, int i3) {
        return new g(gVar, i, i2, i3, mctech.m.c.r.c);
    }

    public static Slot e(mctech.m.a.g gVar, int i, int i2, int i3) {
        return new g(gVar, i, i2, i3, mctech.m.c.r.c).a(a("fluid_drain"));
    }

    public static Slot a(mctech.m.a.g gVar, int i, int i2, int i3, boolean z) {
        return new g(gVar, i, i2, i3, z ? mctech.m.c.a.f.a : mctech.m.c.a.f.b).a(a("fuel"));
    }

    private static ResourceLocation a(String str) {
        return ResourceLocation.fromNamespaceAndPath(MCTech.MODID, String.format("gui/components/slot/%s", str.replace(".png", "")));
    }
}
