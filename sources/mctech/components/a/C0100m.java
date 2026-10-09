package mctech.components.a;

import java.util.Set;
import java.util.function.Consumer;
import mctech.api.tiles.readers.IFuelStorage;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: renamed from: mctech.components.a.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/a/m.class */
public class C0100m extends mctech.m.d.a.a {
    private final C0101n a;
    private final IFuelStorage b;
    private boolean c;
    private boolean d;

    public C0100m(int i, int i2, IFuelStorage iFuelStorage) {
        this(i, i2, iFuelStorage, C0101n.a);
    }

    public C0100m(int i, int i2, IFuelStorage iFuelStorage, C0101n c0101n) {
        super(new mctech.utils.math.geometry.b(i, i2, C0101n.n.getX(), C0101n.n.getY()));
        this.a = c0101n;
        this.b = iFuelStorage;
        this.c = true;
    }

    public C0100m a(boolean z) {
        this.c = z;
        return this;
    }

    public C0100m b(boolean z) {
        this.d = z;
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
        if (this.b.getFuel() <= 0) {
            return;
        }
        this.q.c(this.a.a());
        float fC = (this.c ? this.o.c() : this.o.d()) * Math.min(1.0f, this.b.getFuel() / this.b.getMaxFuel());
        if (this.c) {
            this.q.b(guiGraphics, this.q.getGuiLeft() + this.o.a(), ((this.q.getGuiTop() + this.o.b()) + this.o.c()) - fC, C0101n.a.o.getX(), C0101n.a.o.getY() + (this.o.c() - fC), this.o.d(), fC);
        } else {
            this.q.b(guiGraphics, this.q.getGuiLeft() + this.o.a(), this.q.getGuiTop() + this.o.b(), C0101n.a.o.getX(), C0101n.a.o.getY(), fC, this.o.c());
        }
        this.q.c();
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(GuiGraphics guiGraphics, int i, int i2, Consumer<Component> consumer) {
        if (a(i, i2)) {
            if (y() || !this.d) {
                consumer.accept(c("gui.mctech.fuel", mctech.utils.c.c.c.format(this.b.getFuel()), mctech.utils.c.c.c.format(this.b.getMaxFuel())));
            }
        }
    }
}
