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
import net.neoforged.neoforge.fluids.capability.IFluidHandler;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/b/n.class */
public class n<T extends IFluidHandler & IFluidTank> extends mctech.m.d.a.a {
    static final Component a = Component.translatable("gui.mctech.tank.multi");
    static final Component b = Component.translatable("gui.mctech.tank.no_fluid");
    T c;
    Vec2i d;

    public n(mctech.utils.math.geometry.b bVar, T t) {
        this(bVar, v.a, t);
    }

    public n(mctech.utils.math.geometry.b bVar, Vec2i vec2i, T t) {
        super(bVar);
        this.d = vec2i;
        this.c = t;
    }

    @Override // mctech.m.d.a.a
    protected void a(Set<mctech.m.d.a.a.EnumC0027a> set) {
        set.add(mctech.m.d.a.a.EnumC0027a.DRAW_BACKGROUND);
        set.add(mctech.m.d.a.a.EnumC0027a.TOOLTIP);
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(GuiGraphics guiGraphics, int i, int i2, float f) {
        this.q.a(guiGraphics, this.o.a(), this.o.b(), this.d.getX(), this.d.getY(), this.o.c(), this.c);
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(GuiGraphics guiGraphics, int i, int i2, Consumer<Component> consumer) {
        if (this.o.a(i, i2)) {
            int tanks = this.c.getTanks();
            int i3 = 0;
            consumer.accept(a);
            consumer.accept(c("gui.mctech.tank.capacity", mctech.utils.c.c.c.format(this.c.getFluidAmount()), mctech.utils.c.c.c.format(this.c.getCapacity())));
            for (int i4 = tanks - 1; i4 >= 0; i4--) {
                FluidStack fluidInTank = this.c.getFluidInTank(i4);
                if (!fluidInTank.isEmpty() || (i4 <= 0 && i3 <= 0)) {
                    i3++;
                    consumer.accept(fluidInTank.isEmpty() ? b : c("gui.mctech.tank.fluid", fluidInTank.getDisplayName(), mctech.utils.c.c.c.format(fluidInTank.getAmount())));
                }
            }
        }
    }
}
