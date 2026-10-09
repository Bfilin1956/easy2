package mctech.components;

import java.util.Set;
import java.util.function.Consumer;
import mctech.api.tiles.readers.IProgressMachine;
import mctech.utils.math.geometry.Vec2i;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: renamed from: mctech.components.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/n.class */
public class C0120n extends mctech.m.d.a.a {
    private ResourceLocation a;
    private final IProgressMachine b;
    private final Vec2i c;
    private final boolean d;
    private final boolean e;

    public C0120n(mctech.utils.math.geometry.b bVar, IProgressMachine iProgressMachine, Vec2i vec2i, boolean z) {
        this(bVar, iProgressMachine, vec2i, z, false);
    }

    public C0120n(mctech.utils.math.geometry.b bVar, IProgressMachine iProgressMachine, Vec2i vec2i, boolean z, boolean z2) {
        super(bVar);
        this.b = iProgressMachine;
        this.c = vec2i;
        this.d = z;
        this.e = z2;
    }

    public C0120n a(ResourceLocation resourceLocation) {
        this.a = resourceLocation;
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
        if (this.a != null) {
            this.q.c(this.a);
        }
        float progress = this.b.getProgress();
        if (progress >= 0.0f) {
            mctech.utils.math.geometry.b bVarV = v();
            int iD = bVarV.d();
            int iC = bVarV.c();
            float fMin = (this.d ? iC : iD) * Math.min(1.0f, progress / this.b.getMaxProgress());
            if (fMin <= 0.0f) {
                return;
            }
            if (this.d) {
                if (this.e) {
                    this.q.b(guiGraphics, this.q.getGuiLeft() + bVarV.a(), this.q.getGuiTop() + bVarV.b(), this.c.getX(), this.c.getY(), bVarV.d(), fMin);
                    return;
                } else {
                    this.q.b(guiGraphics, this.q.getGuiLeft() + bVarV.a(), this.q.getGuiTop() + bVarV.b() + (iC - fMin), this.c.getX(), this.c.getY() + (iC - fMin), iD, fMin);
                    return;
                }
            }
            if (this.e) {
                this.q.b(guiGraphics, this.q.getGuiLeft() + bVarV.a(), this.q.getGuiTop() + bVarV.b(), this.c.getX(), this.c.getY(), fMin, iC);
                return;
            }
            this.q.b(guiGraphics, this.q.getGuiLeft() + bVarV.a(), this.q.getGuiTop() + bVarV.b(), this.c.getX(), this.c.getY(), fMin, iC);
        }
        if (this.a != null) {
            this.q.c();
        }
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(GuiGraphics guiGraphics, int i, int i2, Consumer<Component> consumer) {
        if (a(i, i2) && y() && this.q.getSlotUnderMouse() == null) {
            consumer.accept(c("gui.mctech.progress", mctech.utils.c.c.c.format(this.b.getProgress()), mctech.utils.c.c.c.format(this.b.getMaxProgress())));
        }
    }
}
