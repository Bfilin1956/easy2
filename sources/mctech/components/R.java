package mctech.components;

import java.util.Set;
import mctech.api.items.IWindmillBlade;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/R.class */
public class R extends mctech.m.d.a.a {
    private final mctech.blockentities.b.l a;

    public R(mctech.blockentities.b.l lVar) {
        super(mctech.utils.math.geometry.b.a);
        this.a = lVar;
    }

    @Override // mctech.m.d.a.a
    protected void a(Set<mctech.m.d.a.a.EnumC0027a> set) {
        set.add(mctech.m.d.a.a.EnumC0027a.DRAW_FOREGROUND);
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(GuiGraphics guiGraphics, int i, int i2) {
        guiGraphics.pose().pushPose();
        guiGraphics.pose().scale(0.7f, 0.7f, 0.7f);
        int i3 = 28 + 9;
        this.q.a(guiGraphics, (Component) e(String.format("Выход: %s EU/t", mctech.utils.c.c.c.format(this.a.c()))), (int) (117 / 0.7f), (int) (i3 / 0.7f), -65794);
        int i4 = i3 + 9;
        this.q.a(guiGraphics, (Component) e(String.format("Прочность: %s", a())), (int) (117 / 0.7f), (int) (i4 / 0.7f), -65794);
        this.q.a(guiGraphics, (Component) e(String.format("%s", b())), (int) (117 / 0.7f), (int) ((i4 + 9) / 0.7f), -65794);
        guiGraphics.pose().popPose();
    }

    private String a() {
        ItemStack stackInSlot = this.a.getStackInSlot(0);
        IWindmillBlade item = stackInSlot.getItem();
        if (!(item instanceof IWindmillBlade)) {
            return "-";
        }
        IWindmillBlade iWindmillBlade = item;
        if (iWindmillBlade.isInfinite(stackInSlot)) {
            return "∞";
        }
        return String.format("%s/%s", mctech.utils.c.c.c.format(iWindmillBlade.getRemainingDurability(stackInSlot)), mctech.utils.c.c.c.format(iWindmillBlade.getMaxRotorDurability(stackInSlot)));
    }

    private String b() {
        switch (this.a.e()) {
            case 0:
                return "Работает";
            case 2:
                return "Сломан";
            default:
                return "Нет ротора";
        }
    }
}
