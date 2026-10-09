package mctech.components.b;

import java.util.Set;
import java.util.function.Consumer;
import mctech.api.tiles.readers.ISubProgressMachine;
import mctech.utils.math.geometry.Vec2i;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/b/u.class */
public class u extends mctech.m.d.a.a {
    ISubProgressMachine a;
    Vec2i b;
    boolean c;

    public u(mctech.utils.math.geometry.b bVar, ISubProgressMachine iSubProgressMachine, Vec2i vec2i, boolean z) {
        super(bVar);
        this.a = iSubProgressMachine;
        this.b = vec2i;
        this.c = z;
    }

    @Override // mctech.m.d.a.a
    protected void a(Set<mctech.m.d.a.a.EnumC0027a> set) {
        set.add(mctech.m.d.a.a.EnumC0027a.DRAW_BACKGROUND);
        set.add(mctech.m.d.a.a.EnumC0027a.TOOLTIP);
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(GuiGraphics guiGraphics, int i, int i2, float f) {
        float subProgress = this.a.getSubProgress();
        if (subProgress >= 1.0f) {
            mctech.utils.math.geometry.b bVarV = v();
            int iD = bVarV.d();
            int iC = bVarV.c();
            float fMin = (this.c ? iC : iD) * Math.min(1.0f, subProgress / this.a.getMaxSubProgress());
            if (fMin <= 0.0f) {
                return;
            }
            if (this.c) {
                this.q.b(guiGraphics, this.q.getGuiLeft() + bVarV.a(), this.q.getGuiTop() + bVarV.b() + (iC - fMin), this.b.getX(), this.b.getY() + (iC - fMin), iD, fMin);
            } else {
                this.q.b(guiGraphics, this.q.getGuiLeft() + bVarV.a(), this.q.getGuiTop() + bVarV.b(), this.b.getX(), this.b.getY(), fMin, iC);
            }
        }
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(GuiGraphics guiGraphics, int i, int i2, Consumer<Component> consumer) {
        if (a(i, i2) && y() && this.q.getSlotUnderMouse() == null) {
            consumer.accept(c("gui.mctech.progress.sub", mctech.utils.c.c.c.format(this.a.getSubProgress()), mctech.utils.c.c.c.format(this.a.getMaxSubProgress())));
        }
    }
}
