package mctech.components.a;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import java.util.function.Consumer;
import mctech.MCTech;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.FormattedText;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/a/v.class */
@OnlyIn(Dist.CLIENT)
public class v extends Button implements mctech.m.d.b.b {
    Button.OnPress a;
    ItemStack b;
    a c;
    boolean d;
    boolean e;
    ResourceLocation[] f;
    Component g;

    public v(int i, int i2, int i3, int i4, Button.OnPress onPress, a aVar, boolean z) {
        this(i, i2, i3, i4, onPress, aVar);
        a(z);
    }

    public v(int i, int i2, int i3, int i4, Button.OnPress onPress, ItemStack itemStack, boolean z) {
        this(i, i2, i3, i4, onPress, itemStack);
        a(z);
    }

    public v(int i, int i2, int i3, int i4, Button.OnPress onPress, a aVar) {
        super(i, i2, i3, i4, Component.empty(), (Button.OnPress) null, DEFAULT_NARRATION);
        this.d = true;
        this.a = onPress;
        this.b = ItemStack.EMPTY;
        this.c = aVar;
        this.f = new ResourceLocation[]{ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "textures/misc/gui/yes.png"), ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "textures/misc/gui/no.png")};
    }

    public v(int i, int i2, int i3, int i4, Button.OnPress onPress, ItemStack itemStack) {
        super(i, i2, i3, i4, Component.empty(), (Button.OnPress) null, DEFAULT_NARRATION);
        this.d = true;
        this.a = onPress;
        this.b = itemStack;
        this.f = new ResourceLocation[]{ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "textures/misc/gui/yes.png"), ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "textures/misc/gui/no.png")};
    }

    public boolean a() {
        return this.e;
    }

    public v b() {
        this.d = false;
        return this;
    }

    public v a(boolean z) {
        this.e = z;
        return this;
    }

    public v a(Component component) {
        this.g = component;
        return this;
    }

    public v a(String str, Object... objArr) {
        return a((Component) Component.translatable(str, objArr));
    }

    public v a(String str) {
        return a((Component) Component.translatable(str));
    }

    public void onPress() {
        if (this.a != null) {
            this.a.onPress(this);
        } else {
            this.e = !this.e;
        }
    }

    protected void renderWidget(GuiGraphics guiGraphics, int i, int i2, float f) {
        if (this.visible) {
            Minecraft minecraft = Minecraft.getInstance();
            this.isHovered = i >= getX() && i2 >= getY() && i < getX() + this.width && i2 < getY() + this.height;
            PoseStack poseStackPose = guiGraphics.pose();
            FormattedText message = getMessage();
            int iWidth = minecraft.font.width(message);
            int iWidth2 = minecraft.font.width("...");
            if (iWidth > this.width - 6 && iWidth > iWidth2) {
                message = Component.literal(minecraft.font.substrByWidth(message, (this.width - 6) - iWidth2).getString() + "...");
            }
            guiGraphics.drawCenteredString(minecraft.font, message, getX() + (this.width / 2), getY() + ((this.height - 8) / 2), getFGColor());
            poseStackPose.pushPose();
            poseStackPose.translate(getX(), getY(), 0.0d);
            poseStackPose.scale(1.0f / (20.0f / this.width), 1.0f / (20.0f / this.height), 1.0f);
            guiGraphics.renderItem(this.b, 2, 2);
            RenderSystem.disableDepthTest();
            int i3 = this.width - (this.width / 2);
            int i4 = this.height - (this.height / 2);
            poseStackPose.popPose();
            guiGraphics.blit(this.f[!this.e ? (char) 0 : (char) 1], getX() + i3, getY() + i4, 0.0f, 0.0f, this.width / 2, this.height / 2, 8, 8);
        }
    }

    @Override // mctech.m.d.b.b
    public void a(mctech.m.d.b bVar, int i, int i2, Consumer<Component> consumer) {
        if (isHoveredOrFocused() && this.g != null) {
            consumer.accept(this.g);
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/a/v$a.class */
    public enum a {
        YES(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "misc/gui"), "yes"),
        NO(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "misc/gui"), "no"),
        MEMORY_STICK(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "misc/gui"), "memory_stick"),
        ADD(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "misc/gui"), "add"),
        REMOVE(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "misc/gui"), "remove"),
        SWAP(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "misc/gui"), "swap"),
        SLOT_DIVERSITY(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "item/upgrades/inventory"), "slot_diversity"),
        STACK_DIVERSITY(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "item/upgrades/inventory"), "stack_diversity");

        private final ResourceLocation i;
        private final String j;

        a(ResourceLocation resourceLocation, String str) {
            this.i = resourceLocation;
            this.j = str;
        }

        public ResourceLocation a() {
            return this.i;
        }

        public String b() {
            return this.j;
        }
    }
}
