package mctech.components.a;

import com.mojang.blaze3d.vertex.PoseStack;
import mctech.utils.math.geometry.Vec2i;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/a/D.class */
public class D extends R<D> {
    private final ItemStack a;
    private boolean b;

    public D(int i, int i2, ItemLike itemLike) {
        super(C0101n.f, i, i2, 20, 20, new Vec2i(236, 12), new Vec2i(216, 12), new Vec2i(57, 21));
        this.a = new ItemStack(itemLike);
        b(itemLike.asItem().getDescription());
        c(false);
    }

    public D a(boolean z) {
        this.b = z;
        return this;
    }

    @Override // mctech.components.a.R
    public Vec2i d() {
        return new Vec2i(this.b ? 216 : 236, 12);
    }

    @Override // mctech.components.a.R
    public Vec2i aa_() {
        return this.b ? new Vec2i(236, 236) : super.aa_();
    }

    @Override // mctech.components.a.R, mctech.m.d.a.a
    public void a(GuiGraphics guiGraphics, int i, int i2, float f) {
        super.a(guiGraphics, i, i2, f);
        PoseStack poseStackPose = guiGraphics.pose();
        poseStackPose.pushPose();
        poseStackPose.translate(this.q.getGuiLeft() + this.o.a() + 2, this.q.getGuiTop() + this.o.b() + 2, 0.0f);
        poseStackPose.scale(0.8f, 0.8f, 0.8f);
        guiGraphics.setColor(this.b ? 0.5f : 1.0f, this.b ? 0.5f : 1.0f, this.b ? 0.5f : 1.0f, 1.0f);
        guiGraphics.renderItem(this.a, 2, 2);
        guiGraphics.setColor(1.0f, 1.0f, 1.0f, 1.0f);
        poseStackPose.popPose();
    }
}
