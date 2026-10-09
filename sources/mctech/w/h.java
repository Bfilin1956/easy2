package mctech.w;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import mctech.MCTech;
import mctech.components.ContainerComponent;
import mctech.components.G;
import mctech.integration.emi.plugin.core.EMIPlugin;
import mctech.items.base.q;
import mctech.m.b.S;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.gui.ScreenUtils;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/w/h.class */
@OnlyIn(Dist.CLIENT)
public class h extends mctech.m.d.a {
    private static final ResourceLocation A = ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "textures/gui/components/blade_result.png");
    private a B;
    private int C;

    public h(ContainerComponent<?> containerComponent) {
        super(containerComponent);
    }

    @Override // mctech.m.d.a, mctech.m.d.b
    protected void init() {
        super.init();
        addRenderableWidget(new G(this.leftPos + 108, this.topPos + 82, 10, 16, EMIPlugin.GRINDING_MACHINE));
    }

    @Override // mctech.m.d.a, mctech.m.d.b
    public void containerTick() {
        super.containerTick();
        if (this.B != null) {
            int i = this.C;
            this.C = i + 1;
            if (i >= 120) {
                n();
            }
        }
    }

    public void a(boolean z, q qVar) {
        if (this.B != null) {
            n();
        }
        this.B = new a(this.leftPos + 14, (this.topPos - 72) - 2, z, qVar);
        addRenderableWidget(this.B);
    }

    private void n() {
        removeWidget(this.B);
        this.B = null;
        this.C = 0;
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/w/h$a.class */
    private class a extends AbstractWidget {
        private final boolean b;
        private final q c;

        public a(int i, int i2, boolean z, q qVar) {
            super(i, i2, 176, 72, Component.empty());
            this.b = z;
            this.c = qVar;
        }

        private boolean a(double d, double d2) {
            int x = (getX() + this.width) - 9;
            int y = getY();
            return d >= ((double) x) && d <= ((double) (x + 9)) && d2 >= ((double) y) && d2 <= ((double) (y + 9));
        }

        protected boolean clicked(double d, double d2) {
            return super.clicked(d, d2) && a(d, d2);
        }

        public void onClick(double d, double d2) {
            h.this.n();
        }

        public void renderWidget(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
            MutableComponent mutableComponentAppend;
            RenderSystem.setShader(GameRenderer::getPositionTexShader);
            RenderSystem.setShaderTexture(0, h.A);
            RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, this.alpha);
            ScreenUtils.drawTexturedModalRect(guiGraphics, getX(), getY(), 0, 0, this.width, this.height, 0.0f);
            ScreenUtils.drawTexturedModalRect(guiGraphics, (getX() + this.width) - 9, getY(), 176, 0, 9, 9, 0.0f);
            if (a(i, i2)) {
                mctech.utils.l.a(guiGraphics, ((getX() + this.width) - 9) + 1, getY() + 1, 0.0f, 7.0f, 7.0f, 1.0f, -1);
            }
            MutableComponent mutableComponentWithStyle = this.b ? Component.literal("УСПЕХ").withStyle(ChatFormatting.GREEN) : Component.literal("НЕУДАЧА").withStyle(ChatFormatting.RED);
            PoseStack poseStackPose = guiGraphics.pose();
            float x = getX() + (this.width * 0.5f);
            float fWidth = x - ((h.this.font.width(mutableComponentWithStyle) * 0.5f) * 2.0f);
            float y = getY() + 16;
            poseStackPose.pushPose();
            poseStackPose.translate(fWidth, y, 0.0d);
            poseStackPose.scale(2.0f, 2.0f, 2.0f);
            poseStackPose.translate(-fWidth, -y, 0.0d);
            guiGraphics.drawString(h.this.font, mutableComponentWithStyle.getVisualOrderText(), fWidth, y, -1, false);
            poseStackPose.popPose();
            Item item = ((S) h.this.menu).getSlot(2).getItem().getItem();
            if (!(item instanceof mctech.items.e.d)) {
                return;
            }
            mctech.items.e.d dVar = (mctech.items.e.d) item;
            if (this.b) {
                mutableComponentAppend = Component.literal("Уровень повышен до ").withStyle(ChatFormatting.WHITE).append(Component.literal("\"" + dVar.a() + "\"").withStyle(ChatFormatting.GREEN));
            } else {
                mutableComponentAppend = this.c.d > 0 ? Component.literal("Уровень понижен до ").withStyle(ChatFormatting.WHITE).append(Component.literal("\"" + dVar.a() + "\"").withStyle(ChatFormatting.RED)) : Component.literal("Уровень ").withStyle(ChatFormatting.WHITE).append(Component.literal("\"" + dVar.a() + "\"").withStyle(ChatFormatting.RED));
            }
            float fWidth2 = x - ((h.this.font.width(mutableComponentAppend) * 0.5f) * 1.0f);
            float f2 = y + 22.0f;
            poseStackPose.pushPose();
            poseStackPose.translate(fWidth2, f2, 0.0d);
            poseStackPose.scale(1.0f, 1.0f, 1.0f);
            poseStackPose.translate(-fWidth2, -f2, 0.0d);
            guiGraphics.drawString(h.this.font, mutableComponentAppend.getVisualOrderText(), fWidth2, f2, -1, false);
            poseStackPose.popPose();
            mctech.h.a.d.a aVarA = mctech.h.a.d.a(dVar.a());
            if (aVarA == null) {
                return;
            }
            MutableComponent mutableComponentAppend2 = Component.literal("Урон: ").append(Component.literal("\"" + aVarA.a + "\"").withStyle(this.b ? ChatFormatting.GREEN : ChatFormatting.RED));
            float fWidth3 = x - ((h.this.font.width(mutableComponentAppend2) * 0.5f) * 1.0f);
            float f3 = f2 + 12.0f;
            poseStackPose.pushPose();
            poseStackPose.translate(fWidth3, f3, 0.0d);
            poseStackPose.scale(1.0f, 1.0f, 1.0f);
            poseStackPose.translate(-fWidth3, -f3, 0.0d);
            guiGraphics.drawString(h.this.font, mutableComponentAppend2.getVisualOrderText(), fWidth3, f3, -1, false);
            poseStackPose.popPose();
        }

        protected void updateWidgetNarration(NarrationElementOutput narrationElementOutput) {
        }
    }
}
