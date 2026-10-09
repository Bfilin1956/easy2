package mctech.components;

import com.mojang.blaze3d.vertex.PoseStack;
import java.util.Set;
import java.util.function.Consumer;
import mctech.utils.math.geometry.Vec2i;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.joml.Matrix4f;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/M.class */
public class M extends mctech.m.d.a.a {
    private final ResourceLocation a;
    private final a b;
    private final Vec2i c;
    private final boolean d;
    private float e;

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/M$a.class */
    public interface a {
        float a();

        float b();
    }

    public M(mctech.utils.math.geometry.b bVar, ResourceLocation resourceLocation, Vec2i vec2i, boolean z, a aVar) {
        super(bVar);
        this.a = resourceLocation;
        this.b = aVar;
        this.c = vec2i;
        this.d = z;
        this.e = 0.0f;
    }

    @Override // mctech.m.d.a.a
    protected void a(Set<mctech.m.d.a.a.EnumC0027a> set) {
        set.add(mctech.m.d.a.a.EnumC0027a.DRAW_BACKGROUND);
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(GuiGraphics guiGraphics, int i, int i2, float f) {
        this.q.c(this.a);
        PoseStack poseStackPose = guiGraphics.pose();
        poseStackPose.pushPose();
        poseStackPose.translate(((double) (this.q.getGuiLeft() + this.o.a())) + (((double) this.o.d()) / 2.0d), ((double) (this.q.getGuiTop() + this.o.b())) + (((double) this.o.c()) / 2.0d), 0.0d);
        poseStackPose.mulPose(new Matrix4f().rotationZ((float) Math.toRadians(this.e)));
        poseStackPose.translate(-(((double) (this.q.getGuiLeft() + this.o.a())) + (((double) this.o.d()) / 2.0d)), -(((double) (this.q.getGuiTop() + this.o.b())) + (((double) this.o.c()) / 2.0d)), 0.0d);
        float fA = this.b.a();
        if (fA >= 0.0f) {
            mctech.utils.math.geometry.b bVarV = v();
            int iD = bVarV.d();
            int iC = bVarV.c();
            float fMin = (this.d ? iC : iD) * Math.min(1.0f, fA / this.b.b());
            if (fMin <= 0.0f) {
                return;
            }
            if (this.d) {
                this.q.b(guiGraphics, this.q.getGuiLeft() + bVarV.a(), this.q.getGuiTop() + bVarV.b() + (iC - fMin), this.c.getX(), this.c.getY() + (iC - fMin), iD, fMin);
                return;
            }
            this.q.b(guiGraphics, this.q.getGuiLeft() + bVarV.a(), this.q.getGuiTop() + bVarV.b(), this.c.getX(), this.c.getY(), fMin, iC);
        }
        poseStackPose.popPose();
        this.q.c();
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(GuiGraphics guiGraphics, int i, int i2, Consumer<Component> consumer) {
    }

    public M a(float f) {
        this.e = f;
        return this;
    }
}
