package mctech.components;

import java.util.Set;
import mctech.blockentities.c.C0074u;
import mctech.m.b.aI;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: renamed from: mctech.components.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/b.class */
public class C0108b extends mctech.m.d.a.a {
    private static final int[] a = {32, 128, mctech.q.c.c, 2048, 4096, mctech.q.c.a, C0074u.o, 32768, 65536, 131072};
    private static final int[] b = {15, 17, 17, 15, 15, 15, 17, 20, 20, 19};
    private final mctech.blockentities.g.b c;
    private final ResourceLocation d;
    private int e;
    private int f;

    public C0108b(mctech.blockentities.g.b bVar, ResourceLocation resourceLocation) {
        super(mctech.utils.math.geometry.b.a);
        this.c = bVar;
        this.d = resourceLocation;
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
        this.e = this.c.b;
        this.f = this.c.c;
        int guiLeft = bVar.getGuiLeft();
        int guiTop = bVar.getGuiTop();
        Component componentC = c("tooltip.mctech.press_key_description", f("tooltip.mctech.ctrl.name"), "10x");
        Component componentAppend = A().append(componentC).append(Character.toString('\n')).append(c("tooltip.mctech.press_key_description", f("tooltip.mctech.shift.name"), "100x")).append(Character.toString('\n')).append(c("tooltip.mctech.press_key_description", f("tooltip.mctech.alt.name"), "1000x"));
        bVar.a(0, new mctech.components.a.L(guiLeft + 176, guiTop + 29, 9, 9, this.d, 37, aI.f, button -> {
            a(1);
        }).a(componentC));
        bVar.a(1, new mctech.components.a.L(guiLeft + 176, guiTop + 41, 9, 9, this.d, 37, aI.f, button2 -> {
            c(1);
        }).a(componentAppend));
        bVar.a(2, new mctech.components.a.L(guiLeft + 25, guiTop + 29, 9, 9, this.d, 37, aI.f, button3 -> {
            a(-1);
        }).a(componentC));
        bVar.a(3, new mctech.components.a.L(guiLeft + 25, guiTop + 41, 9, 9, this.d, 37, aI.f, button4 -> {
            c(-1);
        }).a(componentAppend));
        bVar.a(4, new mctech.components.a.L(guiLeft + 87, guiTop + 76, 36, 11, this.d, 0, 245, button5 -> {
            a();
        })).active = true;
        int i = 43;
        int i2 = 7;
        if (this.c instanceof mctech.blockentities.g.c) {
            i2 = 10;
            i = 11;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = i4;
            int i6 = b[i5];
            bVar.addRenderableWidget(new mctech.components.a.L(guiLeft + i, guiTop + 59, i6, 9, this.d, 36 + i3, 245, button6 -> {
                b(i5);
            }));
            i3 += i6;
            i += 2 + i6;
        }
    }

    @OnlyIn(Dist.CLIENT)
    public void a() {
        this.c.sendToServer(0, this.e);
        this.c.sendToServer(1, this.f);
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void b(mctech.m.d.b bVar) {
        bVar.g(0).active = this.e < 32;
        bVar.g(1).active = this.f <= this.c.f;
        bVar.g(2).active = this.e > 1;
        bVar.g(3).active = this.f > 1;
    }

    @OnlyIn(Dist.CLIENT)
    public void a(int i) {
        this.e = Mth.clamp(this.e + (i * (Screen.hasControlDown() ? 10 : 1)), 1, 32);
    }

    public void b(int i) {
        this.f = a[i];
    }

    @OnlyIn(Dist.CLIENT)
    public void c(int i) {
        this.f = Mth.clamp(this.f + (i * (Screen.hasControlDown() ? 10 : 1) * (Screen.hasShiftDown() ? 100 : 1) * (Screen.hasAltDown() ? 1000 : 1)), this.c.e, this.c.f);
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(GuiGraphics guiGraphics, int i, int i2) {
        this.q.b(guiGraphics, (Component) c("gui.mctech.creative_source.eu", mctech.utils.c.c.c.format(this.f)), 105, 42, -1);
        this.q.b(guiGraphics, (Component) c("gui.mctech.creative_source.packets", mctech.utils.c.c.c.format(this.e)), 105, 30, -1);
    }
}
