package mctech.components;

import java.util.Set;
import mctech.blockentities.c.S;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/H.class */
public class H extends mctech.m.d.a.a {
    S a;

    public H(S s) {
        super(mctech.utils.math.geometry.b.a);
        this.a = s;
    }

    @Override // mctech.m.d.a.a
    protected void a(Set<mctech.m.d.a.a.EnumC0027a> set) {
        set.add(mctech.m.d.a.a.EnumC0027a.GUI_INIT);
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(mctech.m.d.b bVar) {
        bVar.addRenderableWidget(new mctech.components.a.Q(bVar.getGuiLeft() + 133, bVar.getGuiTop() + 78, 12, 12, e("F"), button -> {
            a(2);
        })).a("gui.mctech.refinery.fill");
    }

    private void a(int i) {
        this.a.sendToServer(i, 0);
    }
}
