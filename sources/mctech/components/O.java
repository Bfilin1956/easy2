package mctech.components;

import java.util.Set;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/O.class */
public class O extends mctech.m.d.a.a {
    private final mctech.blockentities.v a;

    public O(mctech.blockentities.v vVar, int i, int i2, int i3, int i4) {
        super(new mctech.utils.math.geometry.b(i, i2, i3, i4));
        this.a = vVar;
    }

    @Override // mctech.m.d.a.a
    protected void a(Set<mctech.m.d.a.a.EnumC0027a> set) {
        set.add(mctech.m.d.a.a.EnumC0027a.DRAW_FOREGROUND);
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(GuiGraphics guiGraphics, int i, int i2) {
        String strH = this.a.h();
        int iA = v().a() + (v().d() / 2);
        int iB = v().b() + 2;
        if (strH.isEmpty()) {
            this.q.b(guiGraphics, (Component) Component.literal("Нет топлива"), iA, iB + 3, -5561076);
            return;
        }
        guiGraphics.pose().pushPose();
        guiGraphics.pose().scale(0.8f, 0.8f, 0.8f);
        this.q.b(guiGraphics, (Component) Component.literal(strH), (int) (iA / 0.8f), (int) (iB / 0.8f), -15159);
        this.q.b(guiGraphics, (Component) Component.literal(String.format("Износ: x%.1f", Float.valueOf(mctech.blockentities.v.a(this.a.f())))), (int) (iA / 0.8f), ((int) (iB / 0.8f)) + 11, -15159);
        guiGraphics.pose().popPose();
    }
}
