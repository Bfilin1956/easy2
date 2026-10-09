package mctech.m.g;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.FluidUtil;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/g/h.class */
public class h extends x implements m, n {
    mctech.m.a.b a;

    public <T extends mctech.m.a.g & mctech.m.a.b> h(T t, int i, int i2, int i3) {
        super(t, i, i2, i3);
        this.a = t;
    }

    public boolean mayPlace(ItemStack itemStack) {
        return this.a.b(this.g, ((FluidStack) FluidUtil.getFluidContained(itemStack).orElse(FluidStack.EMPTY)).getFluid());
    }

    public boolean mayPickup(Player player) {
        return false;
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

    @Override // mctech.m.g.n
    public void a(ItemStack itemStack) {
        Fluid fluidA = mctech.utils.c.b.a(itemStack);
        if (this.a.b(this.g, fluidA)) {
            this.a.a(this.g, fluidA);
        }
    }

    @Override // mctech.m.g.n
    public n.a ae_() {
        return n.a.FILTER;
    }
}
