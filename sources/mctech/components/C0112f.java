package mctech.components;

import java.util.List;
import java.util.Set;
import mctech.MCTech;
import mctech.components.a.C0101n;
import mctech.components.a.S;
import mctech.utils.math.geometry.Vec2i;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: renamed from: mctech.components.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/f.class */
public class C0112f extends mctech.m.d.a.a {
    private static final int a = 8;
    private final mctech.components.b.w[] b;
    private final mctech.components.a.J c;
    private final mctech.blockentities.p d;
    private final S<?> e;

    public C0112f(mctech.components.a.J j, mctech.blockentities.p pVar) {
        super(mctech.utils.math.geometry.b.a);
        this.b = new mctech.components.b.w[8];
        this.c = j;
        this.e = (S) a(new S(C0101n.h.a(), new mctech.utils.math.geometry.b(199, 38, 11, 127)).e(new Vec2i(0, 214)).b(new Vec2i(12, 214)).d(new Vec2i(24, 214)).c(new Vec2i(36, 214)).a(new Vec2i(12, 15)).a(8).a(s -> {
            a();
        }));
        this.d = pVar;
    }

    @Override // mctech.m.d.a.a
    protected void a(Set<mctech.m.d.a.a.EnumC0027a> set) {
        set.add(mctech.m.d.a.a.EnumC0027a.DRAW_FOREGROUND);
        set.add(mctech.m.d.a.a.EnumC0027a.GUI_INIT);
        set.add(mctech.m.d.a.a.EnumC0027a.GUI_TICK);
        set.add(mctech.m.d.a.a.EnumC0027a.KEY_INPUT);
    }

    @Override // mctech.m.d.a.a
    public boolean a(int i, int i2) {
        return true;
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(mctech.m.d.b bVar) {
        int guiLeft = bVar.getGuiLeft();
        int guiTop = bVar.getGuiTop();
        boolean zIsActive = this.d.isActive();
        for (int i = 0; i < 8; i++) {
            int i2 = i;
            this.b[i] = (mctech.components.b.w) bVar.a(1000 + i, new mctech.components.b.w(guiLeft + 23, guiTop + 39 + (i * 16), null, zIsActive, bVar.j(), wVar -> {
                a(i2);
            }));
        }
        a();
        this.e.a(this.d.g().size() > 8);
    }

    public void a(int i) {
        MCTech.NETWORKING.sendClientTileEvent(this.d, 0, this.e.b() + i);
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public boolean b_(int i) {
        return this.c.h() && i == 69;
    }

    @Override // mctech.m.d.a.a
    public void b(mctech.m.d.b bVar) {
        int size = this.d.g().size();
        this.e.a(size > 8);
        boolean z = false;
        if (this.e.a() != size) {
            this.e.c(size);
            z = true;
        }
        if (z) {
            a();
        }
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(GuiGraphics guiGraphics, int i, int i2) {
        this.q.c(guiGraphics, (Component) Component.literal(this.d.b()), 178, 26, -1);
        this.q.a(guiGraphics, (Component) Component.literal(this.d.a()), 35, 26, -1);
    }

    private void a() {
        List<mctech.blockentities.f.e> listG = this.d.g();
        for (int i = 0; i < 8; i++) {
            int iB = this.e.b() + i;
            mctech.blockentities.f.e eVar = null;
            if (iB < listG.size()) {
                eVar = listG.get(iB);
            }
            this.b[i].a(eVar, true);
        }
    }
}
