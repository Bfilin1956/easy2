package mctech.components;

import java.util.Set;
import mctech.blockentities.c.C0073t;
import mctech.init.MCTechLang;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: renamed from: mctech.components.r, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/r.class */
public class C0124r extends mctech.m.d.a.a {
    private final C0073t a;
    private final mctech.m.b.J b;

    public C0124r(C0073t c0073t, mctech.m.b.J j) {
        super(mctech.utils.math.geometry.b.a);
        this.a = c0073t;
        this.b = j;
    }

    @Override // mctech.m.d.a.a
    protected void a(Set<mctech.m.d.a.a.EnumC0027a> set) {
        set.add(mctech.m.d.a.a.EnumC0027a.DRAW_FOREGROUND);
        set.add(mctech.m.d.a.a.EnumC0027a.DRAW_BACKGROUND);
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(GuiGraphics guiGraphics, int i, int i2, float f) {
        switch (this.a.l) {
            case 1:
                guiGraphics.blit(this.b.getTexture(), this.q.getGuiLeft() + 140, this.q.getGuiTop() + 58, 22, 22, 190.0f, 234.0f, 22, 22, mctech.utils.c.h.i, mctech.utils.c.h.i);
                break;
            case 2:
            case 3:
                guiGraphics.blit(this.b.getTexture(), this.q.getGuiLeft() + 140, this.q.getGuiTop() + 58, 22, 22, 212.0f, 234.0f, 22, 22, mctech.utils.c.h.i, mctech.utils.c.h.i);
                break;
            case 4:
                guiGraphics.blit(this.b.getTexture(), this.q.getGuiLeft() + 140, this.q.getGuiTop() + 58, 22, 22, 234.0f, 234.0f, 22, 22, mctech.utils.c.h.i, mctech.utils.c.h.i);
                break;
        }
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(GuiGraphics guiGraphics, int i, int i2) {
        guiGraphics.pose().pushPose();
        guiGraphics.pose().scale(1.0f, 1.0f, 1.0f);
        this.q.b(guiGraphics, a(), (int) (152 / 1.0f), (int) (50 / 1.0f), -65794);
        guiGraphics.pose().popPose();
    }

    private Component a() {
        switch (this.a.l) {
            case 1:
                return MCTechLang.GUI_GENETIC_STABILIZER_STATUS_SUCCESS.get().copy().withStyle(ChatFormatting.DARK_GREEN);
            case 2:
                return MCTechLang.GUI_GENETIC_STABILIZER_STATUS_FAIL.get().copy().withStyle(ChatFormatting.DARK_RED);
            case 3:
                return MCTechLang.GUI_GENETIC_STABILIZER_STATUS_MISS.get().copy().withStyle(ChatFormatting.DARK_RED);
            case 4:
                return Component.translatable("gui.mctech.genetic_stabilizer.status.maxed").copy().withStyle(ChatFormatting.GOLD);
            default:
                return Component.translatable("gui.mctech.genetic_stabilizer.status.idle").copy().withStyle(ChatFormatting.WHITE);
        }
    }
}
