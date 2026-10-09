package mctech.components;

import com.mojang.blaze3d.vertex.PoseStack;
import java.util.Set;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.util.Mth;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/P.class */
public class P extends mctech.m.d.a.a {
    mctech.blockentities.b.a a;
    int b;
    int c;

    public P(mctech.blockentities.b.a aVar) {
        super(mctech.utils.math.geometry.b.a);
        this.a = aVar;
    }

    @Override // mctech.m.d.a.a
    protected void a(Set<mctech.m.d.a.a.EnumC0027a> set) {
        set.add(mctech.m.d.a.a.EnumC0027a.GUI_INIT);
        set.add(mctech.m.d.a.a.EnumC0027a.GUI_TICK);
        set.add(mctech.m.d.a.a.EnumC0027a.DRAW_FOREGROUND);
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(mctech.m.d.b bVar) {
        this.c = this.a.v;
        this.b = this.a.u;
        int guiLeft = bVar.getGuiLeft();
        int guiTop = bVar.getGuiTop();
        MutableComponent mutableComponentC = c("tooltip.mctech.press_key_description", f("tooltip.mctech.ctrl.name"), "10x");
        Component componentAppend = A().append(mutableComponentC).append(Character.toString('\n')).append(c("tooltip.mctech.press_key_description", f("tooltip.mctech.shift.name"), "100x")).append(Character.toString('\n')).append(c("tooltip.mctech.press_key_description", f("tooltip.mctech.alt.name"), "1000x"));
        bVar.a(0, new mctech.utils.i(guiLeft + 160, guiTop + 43, 11, 9, e("-"), button -> {
            a(-1);
            a();
        }, "textures/gui/mssolarsgui.png", 213, 57).a(componentAppend));
        bVar.a(1, new mctech.utils.i(guiLeft + 175, guiTop + 43, 11, 9, e("+"), button2 -> {
            a(1);
            a();
        }, "textures/gui/mssolarsgui.png", 225, 57).a(componentAppend));
        bVar.g(0).visible = this.a.q;
        bVar.g(1).visible = this.a.q;
    }

    @OnlyIn(Dist.CLIENT)
    public void a() {
        this.a.sendToServer(0, this.a.v);
        this.c = this.a.v;
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void b(mctech.m.d.b bVar) {
        bVar.g(0).visible = this.a.q;
        bVar.g(1).visible = this.a.q;
    }

    @OnlyIn(Dist.CLIENT)
    public void a(int i) {
        this.a.v = Mth.clamp(this.a.v + (i * (Screen.hasControlDown() ? 10 : 1) * (Screen.hasShiftDown() ? 100 : 1) * (Screen.hasAltDown() ? 1000 : 1)), 1, 32768);
    }

    @OnlyIn(Dist.CLIENT)
    public void a(PoseStack poseStack, int i, int i2) {
    }
}
