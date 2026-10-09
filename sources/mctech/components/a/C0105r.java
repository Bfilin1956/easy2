package mctech.components.a;

import com.mojang.blaze3d.platform.Lighting;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import java.util.function.Consumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.network.chat.Component;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: renamed from: mctech.components.a.r, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/a/r.class */
public class C0105r extends AbstractWidget implements mctech.m.d.b.b {
    ItemStack a;
    Component b;
    boolean c;

    public C0105r(int i, int i2, int i3, int i4, ItemStack itemStack) {
        super(i, i2, i3, i4, Component.empty());
        this.c = false;
        this.a = itemStack;
    }

    public C0105r a(Component component) {
        this.b = component;
        return this;
    }

    public C0105r a(String str, Object... objArr) {
        return a((Component) Component.translatable(str, objArr));
    }

    public C0105r a(String str) {
        return a((Component) Component.translatable(str));
    }

    public C0105r a(ItemStack itemStack) {
        this.a = itemStack;
        return this;
    }

    public C0105r a(boolean z) {
        this.c = z;
        return this;
    }

    protected boolean isValidClickButton(int i) {
        return false;
    }

    public void renderWidget(GuiGraphics guiGraphics, int i, int i2, float f) {
        if (this.visible) {
            Minecraft.getInstance();
            this.isHovered = i >= getX() && i2 >= getY() && i < getX() + this.width && i2 < getY() + this.height;
            RenderSystem.setShaderTexture(0, InventoryMenu.BLOCK_ATLAS);
            PoseStack poseStackPose = guiGraphics.pose();
            poseStackPose.pushPose();
            poseStackPose.translate(getX(), getY(), 0.0d);
            poseStackPose.scale(1.0f / (20.0f / this.width), 1.0f / (20.0f / this.height), 1.0f);
            Lighting.setupFor3DItems();
            RenderSystem.enableDepthTest();
            if (this.c) {
            }
            RenderSystem.disableDepthTest();
            poseStackPose.popPose();
        }
    }

    @Override // mctech.m.d.b.b
    public void a(mctech.m.d.b bVar, int i, int i2, Consumer<Component> consumer) {
        if (isHoveredOrFocused() && this.b != null) {
            consumer.accept(this.b);
        }
    }

    protected void updateWidgetNarration(NarrationElementOutput narrationElementOutput) {
    }
}
