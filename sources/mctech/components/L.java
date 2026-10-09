package mctech.components;

import com.mojang.blaze3d.vertex.PoseStack;
import java.util.Set;
import mctech.utils.math.geometry.Vec2i;
import net.minecraft.client.gui.GuiGraphics;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/L.class */
public class L extends mctech.m.d.a.a {
    private mctech.blockentities.b.a a;
    private Vec2i b;
    private Vec2i c;

    public L(mctech.blockentities.b.a aVar, mctech.utils.math.geometry.b bVar, Vec2i vec2i, Vec2i vec2i2) {
        super(bVar);
        this.a = aVar;
        this.b = vec2i;
        this.c = vec2i2;
    }

    @Override // mctech.m.d.a.a
    protected void a(Set<mctech.m.d.a.a.EnumC0027a> set) {
        set.add(mctech.m.d.a.a.EnumC0027a.DRAW_BACKGROUND);
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(GuiGraphics guiGraphics, int i, int i2, float f) {
        mctech.utils.math.geometry.b bVarV = v();
        if (this.a.l()) {
            Vec2i vec2i = this.a.n() ? this.b : this.c;
            this.q.b(guiGraphics, this.q.getGuiLeft() + bVarV.a(), this.q.getGuiTop() + bVarV.b(), vec2i.getX(), vec2i.getY(), bVarV.d(), bVarV.c());
        }
        PoseStack poseStackPose = guiGraphics.pose();
        poseStackPose.translate(0.0f, 0.0f, 10.0f);
        int i3 = 5 - this.a.i;
        for (int i4 = 0; i4 < i3; i4++) {
            this.q.b(guiGraphics, (this.q.getGuiLeft() + 174) - (i4 * 24), this.q.getGuiTop() + 65, 233.0f, 10.0f, 20.0f, 20.0f);
        }
        poseStackPose.translate(0.0f, 0.0f, -10.0f);
    }
}
