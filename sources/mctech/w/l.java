package mctech.w;

import com.mojang.blaze3d.vertex.PoseStack;
import it.unimi.dsi.fastutil.ints.IntIntPair;
import javax.annotation.Nonnull;
import mctech.api.items.electric.ElectricItem;
import mctech.components.C0121o;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Renderable;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.narration.NarratableEntry;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/w/l.class */
@OnlyIn(Dist.CLIENT)
public class l extends AbstractContainerScreen<mctech.o.h> {
    private static final int[][] a = {new int[]{62, 82, 207, 6}, new int[]{62, 102, 207, 26}, new int[]{121, 82, 207, 40}, new int[]{121, 102, 207, 60}};
    private final m b;
    private C0121o c;

    public l(mctech.o.h hVar, Inventory inventory, Component component) {
        super(hVar, inventory, component);
        this.imageWidth = 190;
        this.imageHeight = 237;
        this.b = new m(this, m.a(hVar, mctech.o.h.d), m.a(hVar));
    }

    protected void init() {
        super.init();
        this.c = addRenderableWidget(new C0121o(this.leftPos + 3, this.topPos + 17, this, -3, -3, this.c));
        this.c.a(((mctech.o.h) this.menu).c().g().getSlots(), () -> {
            return m.e((mctech.o.e) getMenu());
        });
        this.c.a(((mctech.o.h) this.menu).c().h().getSlots(), () -> {
            return m.b((mctech.o.e) getMenu());
        });
        this.c.a(((mctech.o.h) this.menu).c().c().getSlots(), m::a);
    }

    protected void containerTick() {
    }

    public boolean mouseReleased(double d, double d2, int i) {
        if (this.c.a()) {
            this.c.a(d, d2, i);
        }
        return super.mouseReleased(d, d2, i);
    }

    @NotNull
    public <T extends GuiEventListener & Renderable & NarratableEntry> T addRenderableWidget(@NotNull T t) {
        return (T) super.addRenderableWidget(t);
    }

    public void removeWidget(@NotNull GuiEventListener guiEventListener) {
        super.removeWidget(guiEventListener);
    }

    public void render(@Nonnull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.render(guiGraphics, i, i2, f);
        renderTooltip(guiGraphics, i, i2);
    }

    public boolean keyPressed(int i, int i2, int i3) {
        if (i == 256 && this.c.a()) {
            this.c.b();
            return true;
        }
        return super.keyPressed(i, i2, i3);
    }

    public boolean shouldCloseOnEsc() {
        return this.c == null || !this.c.a();
    }

    protected void renderLabels(@Nonnull GuiGraphics guiGraphics, int i, int i2) {
        ItemStack stackInSlot = ((mctech.o.h) this.menu).c().c().getStackInSlot(0);
        PoseStack poseStackPose = guiGraphics.pose();
        if (!stackInSlot.isEmpty()) {
            Item item = stackInSlot.getItem();
            if (item instanceof mctech.items.e.d) {
                MutableComponent mutableComponentAppend = Component.literal("Заточка ").withStyle(ChatFormatting.WHITE).append(Component.literal(String.valueOf(((mctech.items.e.d) item).a())).withStyle(ChatFormatting.RED)).append(Component.literal(" из ").withStyle(ChatFormatting.WHITE)).append(Component.literal(String.valueOf(13)).withStyle(ChatFormatting.GREEN));
                float fWidth = 102.0f - ((this.font.width(mutableComponentAppend) * 0.5f) * 0.5f);
                poseStackPose.pushPose();
                poseStackPose.translate(fWidth, 120.0f, 0.0f);
                poseStackPose.scale(0.5f, 0.5f, 0.5f);
                poseStackPose.translate(-fWidth, -120.0f, 0.0f);
                guiGraphics.drawString(this.font, mutableComponentAppend.getVisualOrderText(), fWidth, 120.0f, -1, false);
                poseStackPose.popPose();
                MutableComponent mutableComponentWithStyle = Component.literal("УРОН").withStyle(ChatFormatting.WHITE);
                float fWidth2 = 102.0f - ((this.font.width(mutableComponentWithStyle) * 0.5f) * 1.5f);
                poseStackPose.pushPose();
                poseStackPose.translate(fWidth2, 35.0f, 0.0f);
                poseStackPose.scale(1.5f, 1.5f, 1.5f);
                poseStackPose.translate(-fWidth2, -35.0f, 0.0f);
                guiGraphics.drawString(this.font, mutableComponentWithStyle.getVisualOrderText(), fWidth2, 35.0f, -1, false);
                poseStackPose.popPose();
                MutableComponent mutableComponentWithStyle2 = Component.literal(mctech.items.e.h.a(Minecraft.getInstance().player.getItemInHand(((mctech.o.h) this.menu).a()), (Player) Minecraft.getInstance().player)).withStyle(ChatFormatting.RED);
                float fWidth3 = 102.0f - ((this.font.width(mutableComponentWithStyle2) * 0.5f) * 2.0f);
                float f = 35.0f + 16.0f;
                poseStackPose.pushPose();
                poseStackPose.translate(fWidth3, f, 0.0f);
                poseStackPose.scale(2.0f, 2.0f, 2.0f);
                poseStackPose.translate(-fWidth3, -f, 0.0f);
                guiGraphics.drawString(this.font, mutableComponentWithStyle2.getVisualOrderText(), fWidth3, f, -1, false);
                poseStackPose.popPose();
                return;
            }
        }
        MutableComponent mutableComponentWithStyle3 = Component.literal("Установите").withStyle(ChatFormatting.RED);
        float fWidth4 = 102.0f - ((this.font.width(mutableComponentWithStyle3) * 0.5f) * 0.75f);
        poseStackPose.pushPose();
        poseStackPose.translate(fWidth4, 40.0f, 0.0f);
        poseStackPose.scale(0.75f, 0.75f, 0.75f);
        poseStackPose.translate(-fWidth4, -40.0f, 0.0f);
        guiGraphics.drawString(this.font, mutableComponentWithStyle3.getVisualOrderText(), fWidth4, 40.0f, -1, false);
        poseStackPose.popPose();
        MutableComponent mutableComponentWithStyle4 = Component.literal("клинок").withStyle(ChatFormatting.RED);
        float fWidth5 = 102.0f - ((this.font.width(mutableComponentWithStyle4) * 0.5f) * 0.75f);
        float f2 = 40.0f + 6.0f;
        poseStackPose.pushPose();
        poseStackPose.translate(fWidth5, f2, 0.0f);
        poseStackPose.scale(0.75f, 0.75f, 0.75f);
        poseStackPose.translate(-fWidth5, -f2, 0.0f);
        guiGraphics.drawString(this.font, mutableComponentWithStyle4.getVisualOrderText(), fWidth5, f2, -1, false);
        poseStackPose.popPose();
    }

    protected void renderTooltip(@Nonnull GuiGraphics guiGraphics, int i, int i2) {
        this.c.a(guiGraphics, i, i2);
        if (this.c.a()) {
            return;
        }
        super.renderTooltip(guiGraphics, i, i2);
        this.b.a(guiGraphics, i, i2, this.hoveredSlot);
        int i3 = 42 + this.leftPos;
        int i4 = 132 + this.topPos;
        if (i > i3 && i <= i3 + 120 && i2 > i4 && i2 <= i4 + 7) {
            IntIntPair intIntPairC = c();
            guiGraphics.renderTooltip(this.font, Component.literal(a(intIntPairC.rightInt()) + " / " + a(intIntPairC.leftInt()) + " EU").withStyle(ChatFormatting.AQUA), i, i2);
        }
    }

    @Nonnull
    private String a(int i) {
        StringBuilder sbAppend = new StringBuilder().append(i);
        for (int length = sbAppend.length() - 3; length > 0; length -= 3) {
            sbAppend.insert(length, ',');
        }
        return sbAppend.toString();
    }

    protected void renderBg(@Nonnull GuiGraphics guiGraphics, float f, int i, int i2) {
        ResourceLocation resourceLocationA = a();
        guiGraphics.blit(resourceLocationA, this.leftPos, (this.height - this.imageHeight) / 2, 0, 0, this.imageWidth, this.imageHeight);
        float fB = b();
        if (fB != 0.0f) {
            guiGraphics.blit(resourceLocationA, this.leftPos + 44, this.topPos + 134, 14, 238, (int) (116.0f * fB), 3);
            guiGraphics.blit(resourceLocationA, this.leftPos + 102, this.topPos + 139, 14, 246, 5, 7);
        }
        int slots = ((mctech.o.h) getMenu()).c().h().getSlots();
        for (int i3 = 0; i3 < slots; i3++) {
            guiGraphics.blit(resourceLocationA, this.leftPos + a[i3][0], this.topPos + a[i3][1], a[i3][2], a[i3][3], 21, 10);
        }
        ItemStack stackInSlot = ((mctech.o.h) this.menu).c().c().getStackInSlot(0);
        if (!stackInSlot.isEmpty()) {
            Item item = stackInSlot.getItem();
            if (item instanceof mctech.items.e.d) {
                guiGraphics.blit(resourceLocationA, this.leftPos + 64, this.topPos + 126, 14, 242, (int) ((76.0f * ((mctech.items.e.d) item).a()) / 13.0f), 3);
            }
        }
        this.b.a(guiGraphics);
    }

    private ResourceLocation a() {
        return mctech.m.a.a("saber", ((mctech.o.h) this.menu).c().e().e());
    }

    private float b() {
        IntIntPair intIntPairC = c();
        if (intIntPairC.leftInt() == 0.0f) {
            return 0.0f;
        }
        return intIntPairC.rightInt() / intIntPairC.leftInt();
    }

    @Nonnull
    private IntIntPair c() {
        mctech.items.g gVarH = ((mctech.o.h) getMenu()).c().h();
        int capacity = 0;
        int charge = 0;
        for (int i = 0; i < gVarH.getSlots(); i++) {
            ItemStack stackInSlot = gVarH.getStackInSlot(i);
            if (!stackInSlot.isEmpty()) {
                Item item = stackInSlot.getItem();
                if (item instanceof mctech.items.base.h) {
                    mctech.items.base.h hVar = (mctech.items.base.h) item;
                    capacity += hVar.getEnergyCapacity();
                    charge += hVar.getCharge(stackInSlot);
                } else {
                    capacity += ElectricItem.MANAGER.getCapacity(stackInSlot);
                    charge += ElectricItem.MANAGER.getCharge(stackInSlot);
                }
            }
        }
        return IntIntPair.of(capacity, charge);
    }
}
