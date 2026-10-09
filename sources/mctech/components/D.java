package mctech.components;

import java.util.Set;
import java.util.function.Consumer;
import mctech.MCTech;
import mctech.api.reactor.IReactor;
import mctech.blockentities.c.C0074u;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/D.class */
public class D extends mctech.m.d.a.a {
    IReactor a;
    int b;

    public D(IReactor iReactor, int i) {
        super(mctech.utils.math.geometry.b.a);
        this.a = iReactor;
        this.b = i;
    }

    @Override // mctech.m.d.a.a
    protected void a(Set<mctech.m.d.a.a.EnumC0027a> set) {
        set.add(mctech.m.d.a.a.EnumC0027a.DRAW_BACKGROUND);
        set.add(mctech.m.d.a.a.EnumC0027a.DRAW_FOREGROUND);
        set.add(mctech.m.d.a.a.EnumC0027a.TOOLTIP);
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(GuiGraphics guiGraphics, int i, int i2) {
        if (this.a instanceof mctech.blockentities.m) {
            int i3 = 0;
            switch (this.b) {
                case C0074u.j /* 10 */:
                    i3 = 0 + 9;
                    break;
                case 11:
                    i3 = 0 + 18;
                    break;
            }
            this.q.a(guiGraphics, (Component) f("gui.mctech.reactor.heat"), i3 + 44, 144, -15000805);
            this.q.c(guiGraphics, (Component) c("gui.mctech.reactor.energy_output", Integer.valueOf((int) (this.a.getEnergyOutput() * ((double) MCTech.CONFIG.reactorOutput.get())))), i3 + 200, 144, -15000805);
        }
    }

    @Override // mctech.m.d.a.a
    public void a(GuiGraphics guiGraphics, int i, int i2, Consumer<Component> consumer) {
        int i3;
        IReactor iReactor = this.a;
        if (iReactor instanceof mctech.blockentities.m) {
            mctech.blockentities.m mVar = (mctech.blockentities.m) iReactor;
            mctech.m.f.p pVar = mVar.l;
            int i4 = 123 - (9 * this.b);
            switch (this.b) {
                case C0074u.j /* 10 */:
                    i4 += 9;
                    break;
                case 11:
                    i4 += 18;
                    break;
            }
            int i5 = mVar.k + 6;
            for (int i6 = 0; i6 < pVar.getSlotCount(); i6++) {
                ItemStack stackInSlot = pVar.getStackInSlot(i6);
                if (!stackInSlot.isEmpty() && mVar.getStackInSlot(i6).isEmpty() && (i3 = i6 % i5) < this.b) {
                    int i7 = i4 + (18 * i3);
                    int i8 = 29 + (18 * (i6 / i5));
                    if (i >= i7 && i <= i7 + 18 && i2 >= i8 && i2 <= i8 + 18) {
                        consumer.accept(f("gui.mctech.reactor.filter").append(stackInSlot.getDisplayName()));
                    }
                }
            }
        }
    }
}
