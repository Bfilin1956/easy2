package mctech.components.b;

import java.util.Set;
import java.util.function.Consumer;
import mctech.api.tiles.readers.IEUStorage;
import mctech.utils.math.geometry.Vec2i;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/b/c.class */
public class c extends mctech.m.d.a.a {
    IEUStorage a;
    Vec2i b;
    boolean c;
    int d;
    int e;

    public c(mctech.utils.math.geometry.b bVar, IEUStorage iEUStorage, Vec2i vec2i, boolean z) {
        super(bVar);
        this.d = 0;
        this.e = 0;
        this.a = iEUStorage;
        this.b = vec2i;
        this.c = z;
    }

    public c b(int i, int i2) {
        this.d = i;
        this.e = i2;
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
        int storedEU = this.a.getStoredEU();
        if (storedEU > 0) {
            mctech.utils.math.geometry.b bVarV = v();
            int iD = bVarV.d();
            int iC = bVarV.c();
            int i3 = this.c ? iC : iD;
            float fMin = i3 * Math.min(1.0f, storedEU / this.a.getMaxEU());
            if (fMin <= 0.0f) {
                return;
            }
            if (this.d > 0) {
                boolean z = fMin >= ((float) i3);
                fMin = z ? i3 : (((int) fMin) / this.d) * this.d;
                if (fMin <= 0.0f) {
                    return;
                }
                if (!z) {
                    fMin += this.e;
                }
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
        if (a(i, i2) && y()) {
            consumer.accept(c("gui.mctech.charge", mctech.utils.c.c.c.format(this.a.getStoredEU()), mctech.utils.c.c.c.format(this.a.getMaxEU())));
        }
    }
}
