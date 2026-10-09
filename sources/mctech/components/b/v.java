package mctech.components.b;

import java.util.Set;
import java.util.function.Consumer;
import mctech.utils.math.geometry.Vec2i;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.IFluidTank;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/b/v.class */
public class v extends mctech.m.d.a.a {
    public static final Vec2i a = new Vec2i(176, 0);
    static final Component b = Component.translatable("gui.mctech.tank.no_fluid");
    protected IFluidTank c;
    protected Vec2i d;
    mctech.utils.math.geometry.b e;
    Component f;

    public v(mctech.utils.math.geometry.b bVar, IFluidTank iFluidTank) {
        this(bVar, a, iFluidTank);
    }

    public v(mctech.utils.math.geometry.b bVar, Vec2i vec2i, IFluidTank iFluidTank) {
        super(bVar);
        this.f = f("gui.mctech.tank.simple");
        this.d = vec2i;
        this.c = iFluidTank;
    }

    public v a(String str) {
        return a((Component) f(str));
    }

    public v a(Component component) {
        this.f = component;
        return this;
    }

    @Override // mctech.m.d.a.a
    protected void a(Set<mctech.m.d.a.a.EnumC0027a> set) {
        set.add(mctech.m.d.a.a.EnumC0027a.DRAW_BACKGROUND);
        set.add(mctech.m.d.a.a.EnumC0027a.TOOLTIP);
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(GuiGraphics guiGraphics, int i, int i2, float f) {
        this.q.a(guiGraphics, this.o.a(), this.o.b(), this.d.getX(), this.d.getY(), this.o.d(), (this.c.getFluidAmount() / this.c.getCapacity()) * this.o.c(), this.o.c(), this.c.getFluid());
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(GuiGraphics guiGraphics, int i, int i2, Consumer<Component> consumer) {
        if (this.o.a(i, i2)) {
            consumer.accept(this.f);
            consumer.accept(c("gui.mctech.tank.capacity", mctech.utils.c.c.c.format(this.c.getFluidAmount()), mctech.utils.c.c.c.format(this.c.getCapacity())));
            FluidStack fluid = this.c.getFluid();
            consumer.accept(this.c.getFluidAmount() <= 0 ? b : c("gui.mctech.tank.fluid", fluid.getDisplayName(), mctech.utils.c.c.c.format(fluid.getAmount())));
        }
    }
}
