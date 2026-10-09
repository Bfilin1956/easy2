package mctech.components;

import com.mojang.blaze3d.vertex.PoseStack;
import java.util.Set;
import mctech.api.energy.IEnergyCrystal;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.joml.Quaternionf;

/* JADX INFO: renamed from: mctech.components.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/k.class */
public class C0117k extends mctech.m.d.a.a {
    protected mctech.blockentities.f a;

    public C0117k(mctech.blockentities.f fVar) {
        super(mctech.utils.math.geometry.b.a);
        this.a = fVar;
    }

    @Override // mctech.m.d.a.a
    protected void a(Set<mctech.m.d.a.a.EnumC0027a> set) {
        set.add(mctech.m.d.a.a.EnumC0027a.DRAW_BACKGROUND);
        set.add(mctech.m.d.a.a.EnumC0027a.DRAW_FOREGROUND);
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(GuiGraphics guiGraphics, int i, int i2, float f) {
        int guiLeft = this.q.getGuiLeft();
        int guiTop = this.q.getGuiTop();
        ItemStack itemStack = (ItemStack) this.a.inventory.get(0);
        if (!itemStack.isEmpty()) {
            IEnergyCrystal item = itemStack.getItem();
            if (item.getEnergyCapacity() > item.getCharge(itemStack)) {
                float fMin = Math.min(1.0f, item.getCharge(itemStack) / item.getEnergyCapacity()) * 17.0f;
                if (fMin > 0.0f) {
                    this.q.b(guiGraphics, guiLeft + 58, guiTop + 49, this.a.b() * 14, 179.0f, 14.0f, fMin);
                }
            }
        }
        ItemStack itemStack2 = (ItemStack) this.a.inventory.get(1);
        if (!itemStack2.isEmpty()) {
            IEnergyCrystal item2 = itemStack2.getItem();
            if (item2.getCharge(itemStack2) > 0) {
                int i3 = guiLeft + 180;
                int i4 = guiTop + 65;
                float fMin2 = 17.0f - (Math.min(1.0f, item2.getCharge(itemStack2) / item2.getEnergyCapacity()) * 17.0f);
                PoseStack poseStackPose = guiGraphics.pose();
                poseStackPose.pushPose();
                poseStackPose.translate(i3, i4, 0.0f);
                poseStackPose.mulPose(new Quaternionf().rotateXYZ(0.0f, 0.0f, 3.1415927f));
                poseStackPose.translate(-i3, -i4, 0.0f);
                if (fMin2 > 0.0f) {
                    this.q.b(guiGraphics, i3, i4, this.a.b() * 14, 180.0f, 14.0f, fMin2);
                }
                poseStackPose.popPose();
            }
        }
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(GuiGraphics guiGraphics, int i, int i2) {
    }
}
