package mctech.components;

import java.util.Set;
import java.util.function.Consumer;
import mctech.integration.emi.plugin.core.EMIPlugin;
import mctech.utils.math.geometry.Vec2i;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: mctech.components.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/c.class */
public class C0109c extends mctech.m.d.a.a {
    private final mctech.blockentities.s a;
    private final int b;
    private final Vec2i c;
    private final boolean d;

    public C0109c(mctech.blockentities.s sVar, int i, mctech.utils.math.geometry.b bVar, Vec2i vec2i, boolean z) {
        super(bVar);
        this.b = i;
        this.a = sVar;
        this.c = vec2i;
        this.d = z;
    }

    @Override // mctech.m.d.a.a
    protected void a(@NotNull Set<mctech.m.d.a.a.EnumC0027a> set) {
        set.add(mctech.m.d.a.a.EnumC0027a.DRAW_BACKGROUND);
        set.add(mctech.m.d.a.a.EnumC0027a.TOOLTIP);
        set.add(mctech.m.d.a.a.EnumC0027a.MOUSE_INPUT);
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(GuiGraphics guiGraphics, int i, int i2, float f) {
        guiGraphics.pose().pushPose();
        this.q.c();
        float progressSlot = this.a.getProgressSlot(this.b);
        if (progressSlot >= 0.0f) {
            mctech.utils.math.geometry.b bVarV = v();
            int iD = bVarV.d();
            int iC = bVarV.c();
            float fMin = (this.d ? iC : iD) * Math.min(1.0f, progressSlot / this.a.getMaxProgressSlot(this.b));
            if (fMin <= 0.0f) {
                return;
            }
            if (this.d) {
                this.q.b(guiGraphics, this.q.getGuiLeft() + bVarV.a(), this.q.getGuiTop() + bVarV.b(), this.c.getX(), this.c.getY(), iD, fMin);
            } else {
                this.q.b(guiGraphics, this.q.getGuiLeft() + bVarV.a(), this.q.getGuiTop() + bVarV.b(), this.c.getX(), this.c.getY(), fMin, iC);
            }
        }
        guiGraphics.pose().popPose();
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public boolean a(int i, int i2, int i3) {
        EMIPlugin.showTypes(this.a);
        return true;
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(GuiGraphics guiGraphics, int i, int i2, Consumer<Component> consumer) {
        if (a(i, i2)) {
            if (y()) {
                consumer.accept(c("gui.mctech.progress", mctech.utils.c.c.c.format(this.a.getProgressSlot(this.b)), mctech.utils.c.c.c.format(this.a.getMaxProgressSlot(this.b))));
            }
            consumer.accept(f("jei.tooltip.show.recipes"));
        }
    }
}
