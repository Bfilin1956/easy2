package mctech.components.a;

import java.util.Set;
import java.util.function.Consumer;
import mctech.api.tiles.readers.IEUStorage;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: renamed from: mctech.components.a.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/a/g.class */
public class C0094g extends mctech.m.d.a.a {
    private final C0101n a;
    private final InterfaceC0102o b;
    private final IEUStorage c;
    private final int d;

    public C0094g(int i, int i2, int i3, IEUStorage iEUStorage, InterfaceC0102o interfaceC0102o) {
        this(i, i2, i3, iEUStorage, interfaceC0102o, C0101n.a);
    }

    public C0094g(int i, int i2, int i3, IEUStorage iEUStorage, InterfaceC0102o interfaceC0102o, C0101n c0101n) {
        super(new mctech.utils.math.geometry.b(i, i2, C0101n.m.getX(), C0101n.m.getY()));
        this.a = c0101n;
        this.b = interfaceC0102o;
        this.c = iEUStorage;
        this.d = i3;
    }

    @Override // mctech.m.d.a.a
    protected void a(Set<mctech.m.d.a.a.EnumC0027a> set) {
        set.add(mctech.m.d.a.a.EnumC0027a.DRAW_BACKGROUND);
        set.add(mctech.m.d.a.a.EnumC0027a.TOOLTIP);
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(GuiGraphics guiGraphics, int i, int i2, float f) {
        long longStoredEU = this.c.getLongStoredEU();
        if (longStoredEU <= 0) {
            return;
        }
        this.q.c(this.a.a());
        float fClamp = this.d * Mth.clamp(longStoredEU / this.c.getLongMaxEU(), 0.0f, 1.0f);
        this.q.b(guiGraphics, this.q.getGuiLeft() + this.o.a(), this.q.getGuiTop() + this.o.b(), C0101n.r[this.b.tierIndex()].getX(), C0101n.r[this.b.tierIndex()].getY(), fClamp > 16.0f ? 16.0f : fClamp, 19.0f);
        for (int i3 = 1; i3 < fClamp / 15.0f; i3++) {
            float f2 = 1 + (i3 * 15);
            this.q.b(guiGraphics, this.q.getGuiLeft() + this.o.a() + f2, this.q.getGuiTop() + this.o.b(), C0101n.r[this.b.tierIndex()].getX() + 17, C0101n.r[this.b.tierIndex()].getY(), fClamp - f2 < 15.0f ? fClamp - f2 : 15.0f, 19.0f);
        }
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(GuiGraphics guiGraphics, int i, int i2, Consumer<Component> consumer) {
        if (a(i, i2) && y()) {
            consumer.accept(c("gui.mctech.charge", mctech.utils.c.c.c.format(this.c.getLongStoredEU()), mctech.utils.c.c.c.format(this.c.getLongMaxEU())));
        }
    }

    @Override // mctech.m.d.a.a
    public boolean a(int i, int i2) {
        return i >= this.o.a() && i2 >= this.o.b() && i < this.o.a() + this.d && i2 < this.o.b() + 16;
    }
}
