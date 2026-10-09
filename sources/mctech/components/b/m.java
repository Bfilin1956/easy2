package mctech.components.b;

import java.util.Set;
import java.util.function.Consumer;
import mctech.api.tiles.readers.IProgressMachine;
import mctech.utils.math.geometry.Vec2i;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/b/m.class */
public class m extends mctech.m.d.a.a {
    private IProgressMachine a;
    private Vec2i b;
    private boolean c;
    private int d;
    private ResourceLocation e;

    public m(mctech.utils.math.geometry.b bVar, IProgressMachine iProgressMachine, Vec2i vec2i, int i, boolean z) {
        this(bVar, iProgressMachine, vec2i, i, z, null);
    }

    public m(mctech.utils.math.geometry.b bVar, IProgressMachine iProgressMachine, Vec2i vec2i, int i, boolean z, ResourceLocation resourceLocation) {
        super(bVar);
        this.a = iProgressMachine;
        this.b = vec2i;
        this.c = z;
        this.d = i;
        this.e = resourceLocation;
    }

    @Override // mctech.m.d.a.a
    protected void a(Set<mctech.m.d.a.a.EnumC0027a> set) {
        set.add(mctech.m.d.a.a.EnumC0027a.DRAW_BACKGROUND);
        set.add(mctech.m.d.a.a.EnumC0027a.TOOLTIP);
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(GuiGraphics guiGraphics, int i, int i2, float f) {
        for (int i3 = 0; i3 < this.a.getSlots(); i3++) {
            float progressSlot = this.a.getProgressSlot(i3);
            if (progressSlot >= 0.0f) {
                mctech.utils.math.geometry.b bVarV = v();
                int iD = bVarV.d() / this.a.getSlots();
                int iC = bVarV.c();
                float fMin = (this.c ? iC : iD) * Math.min(1.0f, progressSlot / this.a.getMaxProgressSlot(i3));
                if (fMin > 0.0f) {
                    if (this.e != null) {
                        this.q.c(this.e);
                        iD = 14;
                    }
                    if (this.c) {
                        this.q.b(guiGraphics, this.q.getGuiLeft() + bVarV.a() + (i3 * this.d), this.q.getGuiTop() + bVarV.b(), this.b.getX(), this.b.getY(), iD, fMin);
                    } else {
                        this.q.b(guiGraphics, this.q.getGuiLeft() + bVarV.a(), this.q.getGuiTop() + bVarV.b(), this.b.getX(), this.b.getY(), fMin, iC);
                    }
                }
            }
        }
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(GuiGraphics guiGraphics, int i, int i2, Consumer<Component> consumer) {
        if (a(i, i2) && y() && this.q.getSlotUnderMouse() == null) {
            int iMin = Math.min(this.a.getSlots() - 1, (int) ((i - this.o.a()) / (this.o.d() / this.a.getSlots())));
            consumer.accept(c("gui.mctech.progress", mctech.utils.c.c.c.format(this.a.getProgressSlot(iMin)), mctech.utils.c.c.c.format(this.a.getMaxProgressSlot(iMin))));
        }
    }
}
