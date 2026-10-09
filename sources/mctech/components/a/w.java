package mctech.components.a;

import com.mojang.blaze3d.vertex.PoseStack;
import java.util.Set;
import net.minecraft.client.gui.GuiGraphics;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/a/w.class */
public class w extends mctech.m.d.a.a {
    private a a;
    private float b;

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/a/w$a.class */
    public interface a {
        String getString();
    }

    public w(mctech.utils.math.geometry.b bVar, float f, a aVar) {
        super(bVar);
        this.b = f;
        this.a = aVar;
    }

    @Override // mctech.m.d.a.a
    protected void a(Set<mctech.m.d.a.a.EnumC0027a> set) {
        set.add(mctech.m.d.a.a.EnumC0027a.DRAW_FOREGROUND);
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(GuiGraphics guiGraphics, int i, int i2) {
        if (this.a != null && w()) {
            PoseStack poseStackPose = guiGraphics.pose();
            poseStackPose.pushPose();
            poseStackPose.translate(this.o.a(), this.o.b(), 0.0f);
            poseStackPose.scale(this.b, this.b, 1.0f);
            poseStackPose.translate(-this.o.a(), -this.o.b(), 0.0f);
            guiGraphics.drawCenteredString(this.q.j(), this.a.getString(), this.o.a(), this.o.b(), -1);
            poseStackPose.popPose();
        }
    }
}
