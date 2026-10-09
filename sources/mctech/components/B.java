package mctech.components;

import java.util.Set;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.sounds.SoundEvents;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/B.class */
public class B extends mctech.m.d.a.a {
    private final mctech.blockentities.c.L a;

    public B(mctech.blockentities.c.L l) {
        super(new mctech.utils.math.geometry.b(59, 23, 18, 56));
        this.a = l;
    }

    @Override // mctech.m.d.a.a
    protected void a(Set<mctech.m.d.a.a.EnumC0027a> set) {
        set.add(mctech.m.d.a.a.EnumC0027a.DRAW_BACKGROUND);
        set.add(mctech.m.d.a.a.EnumC0027a.DRAW_FOREGROUND);
        set.add(mctech.m.d.a.a.EnumC0027a.TOOLTIP);
        set.add(mctech.m.d.a.a.EnumC0027a.MOUSE_INPUT);
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(GuiGraphics guiGraphics, int i, int i2) {
    }

    @Override // mctech.m.d.a.a
    public void a(GuiGraphics guiGraphics, int i, int i2, float f) {
        guiGraphics.pose().pushPose();
        guiGraphics.pose().translate(u().getGuiLeft(), u().getGuiTop(), 0.0f);
        u().c(u().h());
        int iB = this.a.b();
        if (iB == 0) {
            u().b(guiGraphics, v().a(), v().b(), 0.0f, 222.0f, 18.0f, 18.0f);
            u().b(guiGraphics, v().a() + 18, v().b() + 8, 48.0f, 209.0f, 34.0f, 22.0f);
            u().b(guiGraphics, v().a() + 1, v().b() + 1, 16.0f, 240.0f, 16.0f, 16.0f);
        } else if (iB == 1) {
            u().b(guiGraphics, v().a(), v().b() + 19, 0.0f, 222.0f, 18.0f, 18.0f);
            u().b(guiGraphics, v().a() + 18, v().b() + 26, 48.0f, 252.0f, 34.0f, 4.0f);
            u().b(guiGraphics, v().a() + 1, v().b() + 20, 0.0f, 240.0f, 16.0f, 16.0f);
        } else {
            u().b(guiGraphics, v().a(), v().b() + 38, 0.0f, 222.0f, 18.0f, 18.0f);
            u().b(guiGraphics, v().a() + 18, v().b() + 26, 48.0f, 231.0f, 34.0f, 21.0f);
            u().b(guiGraphics, v().a() + 1, v().b() + 39, 32.0f, 240.0f, 16.0f, 16.0f);
        }
        guiGraphics.pose().popPose();
        u().c();
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public boolean a(int i, int i2, int i3) {
        if (i >= v().a() && i <= v().a() + v().d()) {
            if (i2 >= v().b() && i2 <= v().b() + 16) {
                Minecraft.getInstance().getSoundManager().play(SimpleSoundInstance.forUI(SoundEvents.UI_BUTTON_CLICK, 1.0f));
                this.a.sendToServer(0, 0);
                return true;
            }
            if (i2 >= v().b() + 20 && i2 <= v().b() + 38) {
                Minecraft.getInstance().getSoundManager().play(SimpleSoundInstance.forUI(SoundEvents.UI_BUTTON_CLICK, 1.0f));
                this.a.sendToServer(0, 1);
                return true;
            }
            if (i2 >= v().b() + 40 && i2 <= v().b() + 56) {
                Minecraft.getInstance().getSoundManager().play(SimpleSoundInstance.forUI(SoundEvents.UI_BUTTON_CLICK, 1.0f));
                this.a.sendToServer(0, 2);
                return true;
            }
            return false;
        }
        return false;
    }
}
