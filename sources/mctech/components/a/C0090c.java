package mctech.components.a;

import com.mojang.blaze3d.platform.Lighting;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import java.util.function.Consumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: renamed from: mctech.components.a.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/a/c.class */
public class C0090c extends Q {
    DyeColor a;
    ItemStack b;
    Consumer<C0090c> c;

    public C0090c(int i, int i2, int i3, int i4, DyeColor dyeColor, Consumer<C0090c> consumer) {
        super(i, i2, i3, i4, Component.empty(), null);
        this.b = ItemStack.EMPTY;
        this.c = consumer;
        a(dyeColor);
    }

    public C0090c a(DyeColor dyeColor) {
        this.a = dyeColor;
        this.b = mctech.m.c.r.b(dyeColor);
        return this;
    }

    public DyeColor a() {
        return this.a;
    }

    public void onPress() {
        this.c.accept(this);
    }

    public void renderWidget(GuiGraphics guiGraphics, int i, int i2, float f) {
        if (this.visible) {
            PoseStack poseStackPose = guiGraphics.pose();
            Minecraft.getInstance();
            this.isHovered = i >= getX() && i2 >= getY() && i < getX() + this.width && i2 < getY() + this.height;
            if (!this.b.isEmpty()) {
                RenderSystem.setShaderTexture(0, InventoryMenu.BLOCK_ATLAS);
                poseStackPose.pushPose();
                poseStackPose.translate(getX(), getY(), 0.0d);
                poseStackPose.scale(1.0f / (20.0f / this.width), 1.0f / (20.0f / this.height), 1.0f);
                Lighting.setupFor3DItems();
                RenderSystem.enableDepthTest();
                RenderSystem.disableDepthTest();
                poseStackPose.popPose();
            }
        }
    }
}
