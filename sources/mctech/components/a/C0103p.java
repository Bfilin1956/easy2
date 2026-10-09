package mctech.components.a;

import com.mojang.blaze3d.platform.Lighting;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import java.util.function.Consumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.FormattedText;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.client.gui.widget.ExtendedButton;

/* JADX INFO: renamed from: mctech.components.a.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/a/p.class */
public class C0103p extends ExtendedButton implements mctech.m.d.b.b {
    ItemStack a;
    Component b;
    boolean c;
    boolean d;

    public C0103p(int i, int i2, int i3, int i4, ItemStack itemStack, Button.OnPress onPress) {
        super(i, i2, i3, i4, Component.empty(), onPress);
        this.c = false;
        this.d = false;
        this.a = itemStack;
    }

    public C0103p a(Component component) {
        this.b = component;
        return this;
    }

    public C0103p a(String str, Object... objArr) {
        return a((Component) Component.translatable(str, objArr));
    }

    public C0103p a(String str) {
        return a((Component) Component.translatable(str));
    }

    public C0103p a() {
        this.d = true;
        return this;
    }

    public C0103p a(ItemStack itemStack) {
        this.a = itemStack;
        return this;
    }

    public C0103p a(boolean z) {
        this.c = z;
        return this;
    }

    public ItemStack b() {
        return this.a;
    }

    public void renderWidget(GuiGraphics guiGraphics, int i, int i2, float f) {
        if (this.visible) {
            PoseStack poseStackPose = guiGraphics.pose();
            Minecraft minecraft = Minecraft.getInstance();
            this.isHovered = i >= getX() && i2 >= getY() && i < getX() + this.width && i2 < getY() + this.height;
            if (!this.d) {
                FormattedText message = getMessage();
                int iWidth = minecraft.font.width(message);
                int iWidth2 = minecraft.font.width("...");
                if (iWidth > this.width - 6 && iWidth > iWidth2) {
                    message = Component.literal(minecraft.font.substrByWidth(message, (this.width - 6) - iWidth2).getString() + "...");
                }
                guiGraphics.drawCenteredString(minecraft.font, message, getX() + (this.width / 2), getY() + ((this.height - 8) / 2), getFGColor());
            }
            RenderSystem.setShaderTexture(0, InventoryMenu.BLOCK_ATLAS);
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
        if (this.visible && isHoveredOrFocused() && this.b != null) {
            consumer.accept(this.b);
        }
    }
}
