package mctech.m.d;

import appeng.util.ReadableNumberConverter;
import com.mojang.blaze3d.platform.Lighting;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.BufferUploader;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.blaze3d.vertex.VertexFormat;
import com.mojang.datafixers.util.Pair;
import it.unimi.dsi.fastutil.ints.Int2IntMap;
import it.unimi.dsi.fastutil.ints.Int2IntOpenHashMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectList;
import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import mctech.components.a.C;
import mctech.m.b.S;
import mctech.m.g.q;
import mctech.mixin.client.ScreenMixin;
import mctech.o.f;
import mctech.o.g;
import mctech.utils.math.geometry.Vec2i;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Renderable;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.narration.NarratableEntry;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.AbstractTexture;
import net.minecraft.client.renderer.texture.MissingTextureAtlasSprite;
import net.minecraft.client.renderer.texture.SimpleTexture;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.IFluidTank;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix4f;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/d/b.class */
@OnlyIn(Dist.CLIENT)
public class b extends AbstractContainerScreen<S> {
    public static final int a = 4210752;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 4;
    public static final int e = 8;
    public static final int f = 16;
    public static final int g = 32;
    public static final int h = 64;
    public static final int i = 128;
    public static long j = 200;
    ResourceLocation k;
    AbstractTexture l;
    List<mctech.m.d.b.b> m;
    List<AbstractWidget> n;
    Int2ObjectMap<AbstractWidget> o;
    Int2IntMap p;
    int q;
    int r;
    int s;
    int t;
    long u;
    int v;
    Component w;
    Vec2i x;
    Vec2i y;
    Predicate<Slot> z;

    public b(S s, Inventory inventory, Component component) {
        super(s, inventory, component);
        this.m = mctech.utils.a.b.i();
        this.n = mctech.utils.a.b.i();
        this.o = new Int2ObjectOpenHashMap();
        this.p = new Int2IntOpenHashMap();
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.t = 0;
        this.u = 0L;
        this.v = 0;
        this.x = new Vec2i();
        this.y = new Vec2i();
        b(3);
        this.w = component;
        this.p.defaultReturnValue(-2130706433);
    }

    public <U extends AbstractWidget> U a(int i2, U u) {
        this.o.put(i2, u);
        return addRenderableWidget(u);
    }

    @NotNull
    public <T extends GuiEventListener & Renderable & NarratableEntry> T addRenderableWidget(@NotNull T t) {
        if (t instanceof mctech.m.d.b.b) {
            this.m.add((mctech.m.d.b.b) t);
        }
        if (t instanceof C) {
            this.n.add((C) t);
        }
        return (T) super.addRenderableWidget(t);
    }

    public void a(int i2) {
        AbstractWidget abstractWidget = (AbstractWidget) this.o.get(i2);
        if (abstractWidget != null) {
            this.n.add(abstractWidget);
        }
    }

    public void a(ResourceLocation resourceLocation) {
        this.k = resourceLocation;
        this.l = null;
    }

    public void b(int i2) {
        this.q |= i2;
    }

    public void c(int i2) {
        this.q &= i2 ^ (-1);
    }

    public boolean d(int i2) {
        return (this.q & i2) == i2;
    }

    public void a(int... iArr) {
        for (int i2 : iArr) {
            this.p.put(i2, 0);
        }
    }

    public void a(int i2, int... iArr) {
        for (int i3 : iArr) {
            this.p.put(i3, i2);
        }
    }

    public void b(int... iArr) {
        for (int i2 : iArr) {
            this.p.remove(i2);
        }
    }

    public void a(Predicate<Slot> predicate) {
        this.z = predicate;
    }

    protected void init() {
        super.init();
        clearWidgets();
        this.o.clear();
        this.m.clear();
        for (mctech.m.d.b.b bVar : ((S) this.menu).slots) {
            if (bVar instanceof mctech.m.d.b.b) {
                this.m.add(bVar);
            }
        }
    }

    public void removed() {
        super.removed();
    }

    public void render(GuiGraphics guiGraphics, int i2, int i3, float f2) {
        if (d(16)) {
            c(16);
            this.minecraft.resizeDisplay();
        }
        if (d(8)) {
            c(8);
            init();
        }
        super.render(guiGraphics, i2, i3, f2);
        if (getFocused() != null && !(getFocused() instanceof EditBox)) {
            setFocused(null);
        }
        renderTooltip(guiGraphics, i2, i3);
        a(guiGraphics, f2, i2, i3);
        int guiLeft = i2 - getGuiLeft();
        int guiTop = i2 - getGuiTop();
        ObjectList objectListI = mctech.utils.a.b.i();
        if (i2 != Integer.MAX_VALUE && i3 != Integer.MAX_VALUE) {
            a(guiGraphics, i2, i3, component -> {
                objectListI.addAll(this.font.split(component, Math.max(i2, this.width - i2)));
            });
        }
        if ((!d(128) && (this.s != i2 || this.t != i3)) || objectListI.isEmpty()) {
            this.u = System.currentTimeMillis();
            this.s = i2;
            this.t = i3;
            if (objectListI.isEmpty()) {
                c(128);
            }
            this.v = 0;
            return;
        }
        b(128);
        this.v = 0;
        guiGraphics.renderTooltip(this.font, objectListI, i2, i3);
        this.v = objectListI.size();
    }

    protected void renderBg(GuiGraphics guiGraphics, float f2, int i2, int i3) {
        c();
        if (this.menu instanceof f) {
            a(guiGraphics, getGuiLeft(), getGuiTop(), 0.0f, 0.0f, getXSize(), getYSize());
            return;
        }
        g gVar = this.menu;
        if (gVar instanceof g) {
            g gVar2 = gVar;
            a(guiGraphics, getGuiLeft(), getGuiTop(), 0.0f, 0.0f, getXSize(), getYSize(), getXSize(), getYSize(), gVar2.a(), gVar2.b());
        } else {
            b(guiGraphics, getGuiLeft(), getGuiTop(), 0.0f, 0.0f, getXSize(), getYSize());
        }
    }

    public void a(GuiGraphics guiGraphics, float f2, float f3, float f4, float f5, float f6, float f7) {
        f fVar = this.menu;
        Matrix4f matrix4fPose = guiGraphics.pose().last().pose();
        float f8 = f2 + f6;
        float f9 = f3 + f7;
        float fC = f4 / fVar.c();
        float fD = f5 / fVar.d();
        float fC2 = (f4 + f6) / fVar.c();
        float fD2 = (f5 + f7) / fVar.d();
        BufferBuilder bufferBuilderBegin = Tesselator.getInstance().begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        bufferBuilderBegin.addVertex(matrix4fPose, f2, f9, 0.0f).setUv(fC, fD2);
        bufferBuilderBegin.addVertex(matrix4fPose, f8, f9, 0.0f).setUv(fC2, fD2);
        bufferBuilderBegin.addVertex(matrix4fPose, f8, f3, 0.0f).setUv(fC2, fD);
        bufferBuilderBegin.addVertex(matrix4fPose, f2, f3, 0.0f).setUv(fC, fD);
        BufferUploader.drawWithShader(bufferBuilderBegin.buildOrThrow());
    }

    public void renderSlot(GuiGraphics guiGraphics, Slot slot) {
        super.renderSlot(guiGraphics, slot);
    }

    protected void renderSlotContents(@NotNull GuiGraphics guiGraphics, @NotNull ItemStack itemStack, @NotNull Slot slot, @Nullable String str) {
        if (this.minecraft == null) {
            return;
        }
        if (slot.getMaxStackSize() < 999) {
            super.renderSlotContents(guiGraphics, itemStack, slot, str);
            return;
        }
        int i2 = slot.x;
        int i3 = slot.y;
        int i4 = slot.x + (slot.y * this.imageWidth);
        if (slot.isFake()) {
            guiGraphics.renderFakeItem(itemStack, i2, i3, i4);
        } else {
            guiGraphics.renderItem(itemStack, i2, i3, i4);
        }
        if (!itemStack.isEmpty()) {
            a(guiGraphics, this.minecraft.font, i2, i3, str == null ? ReadableNumberConverter.format(itemStack.getCount(), 4) : str, false);
        }
        if (itemStack.isBarVisible()) {
            int barWidth = itemStack.getBarWidth();
            int barColor = itemStack.getBarColor();
            int i5 = i2 + 2;
            int i6 = i3 + 13;
            guiGraphics.fill(RenderType.guiOverlay(), i5, i6, i5 + 13, i6 + 2, mctech.utils.math.a.f);
            guiGraphics.fill(RenderType.guiOverlay(), i5, i6, i5 + barWidth, i6 + 1, barColor | mctech.utils.math.a.f);
        }
    }

    protected void renderLabels(GuiGraphics guiGraphics, int i2, int i3) {
        if (d(1)) {
            guiGraphics.drawString(this.font, this.playerInventoryTitle, 8 + this.y.getX(), (this.imageHeight - 92) + this.y.getY(), a, false);
        }
        if (d(2)) {
            guiGraphics.drawString(this.font, this.w, ((this.imageWidth / 2) + this.x.getX()) - (this.font.width(this.w) / 2), 6 + this.x.getY(), a, false);
        }
    }

    public void a(GuiGraphics guiGraphics, float f2, int i2, int i3) {
    }

    public void a(GuiGraphics guiGraphics, int i2, int i3, Consumer<Component> consumer) {
    }

    public void containerTick() {
        this.r++;
        super.containerTick();
    }

    public void b() {
    }

    public boolean a(int i2, int i3) {
        int i4 = i2 + this.leftPos;
        int i5 = i3 + this.topPos;
        int size = this.n.size();
        for (int i6 = 0; i6 < size; i6++) {
            if (this.n.get(i6).isMouseOver(i4, i5)) {
                return true;
            }
        }
        return false;
    }

    public boolean a(int i2, int i3, int i4, int i5, int i6, int i7) {
        return i2 >= i4 && i3 >= i5 && i2 <= i4 + i6 && i3 <= i5 + i7;
    }

    protected boolean hasClickedOutside(double d2, double d3, int i2, int i3, int i4) {
        return !d(32) && super.hasClickedOutside(d2, d3, i2, i3, i4);
    }

    public void a(GuiGraphics guiGraphics, Component component, int i2, int i3, int i4) {
        guiGraphics.drawString(this.font, component, i2, i3, i4, false);
    }

    public void b(GuiGraphics guiGraphics, Component component, int i2, int i3, int i4) {
        guiGraphics.drawString(this.font, component.getVisualOrderText(), i2 - (this.font.width(component.getVisualOrderText()) / 2), i3, i4, false);
    }

    public void c(GuiGraphics guiGraphics, Component component, int i2, int i3, int i4) {
        guiGraphics.drawString(this.font, component.getVisualOrderText(), i2 - this.font.width(component.getVisualOrderText()), i3, i4, false);
    }

    public void a(GuiGraphics guiGraphics, FormattedCharSequence formattedCharSequence, int i2, int i3, int i4) {
        guiGraphics.drawString(this.font, formattedCharSequence, i2, i3, i4, false);
    }

    public void b(GuiGraphics guiGraphics, FormattedCharSequence formattedCharSequence, int i2, int i3, int i4) {
        guiGraphics.drawString(this.font, formattedCharSequence, i2 - (this.font.width(formattedCharSequence) / 2), i3, i4, false);
    }

    public void c(GuiGraphics guiGraphics, FormattedCharSequence formattedCharSequence, int i2, int i3, int i4) {
        guiGraphics.drawString(this.font, formattedCharSequence, i2 - this.font.width(formattedCharSequence), i3, i4, false);
    }

    public void a(GuiGraphics guiGraphics, float f2, float f3, ItemStack itemStack) {
        a(guiGraphics, f2, f3, itemStack, 20.0f, 20.0f);
    }

    public void a(GuiGraphics guiGraphics, float f2, float f3, ItemStack itemStack, float f4, float f5) {
        a(guiGraphics, f2, f3, itemStack, f4, f5, false, (String) null);
    }

    public void b(GuiGraphics guiGraphics, float f2, float f3, ItemStack itemStack) {
        a(guiGraphics, f2, f3, itemStack, 20.0f, 20.0f, true, (String) null);
    }

    public void a(GuiGraphics guiGraphics, float f2, float f3, ItemStack itemStack, float f4, float f5, boolean z, String str) {
        PoseStack poseStackPose = guiGraphics.pose();
        poseStackPose.pushPose();
        poseStackPose.translate(f2, f3, 0.0d);
        poseStackPose.scale(1.0f / (20.0f / f4), 1.0f / (20.0f / f5), 1.0f);
        Lighting.setupFor3DItems();
        RenderSystem.enableDepthTest();
        guiGraphics.renderItem(itemStack, 2, 2);
        if (z) {
            guiGraphics.renderItemDecorations(this.font, itemStack, 2, 2, str);
        }
        RenderSystem.disableDepthTest();
        poseStackPose.popPose();
        RenderSystem.applyModelViewMatrix();
    }

    public void b(GuiGraphics guiGraphics, float f2, float f3, float f4, float f5, float f6, float f7) {
        a(guiGraphics, f2, f3, f4, f5, f6, f7, f6, f7);
    }

    public void a(GuiGraphics guiGraphics, float f2, float f3, float f4, float f5, float f6, float f7, int i2) {
        Matrix4f matrix4fPose = guiGraphics.pose().last().pose();
        float f8 = f2 + f6;
        float f9 = f3 + f7;
        float f10 = f4 / 256.0f;
        float f11 = f5 / 256.0f;
        float f12 = (f4 + f6) / 256.0f;
        float f13 = (f5 + f7) / 256.0f;
        BufferBuilder bufferBuilderBegin = Tesselator.getInstance().begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX_COLOR);
        RenderSystem.setShader(GameRenderer::getPositionTexColorShader);
        bufferBuilderBegin.addVertex(matrix4fPose, f2, f9, a()).setColor(i2).setUv(f10, f13);
        bufferBuilderBegin.addVertex(matrix4fPose, f8, f9, a()).setColor(i2).setUv(f12, f13);
        bufferBuilderBegin.addVertex(matrix4fPose, f8, f3, a()).setColor(i2).setUv(f12, f11);
        bufferBuilderBegin.addVertex(matrix4fPose, f2, f3, a()).setColor(i2).setUv(f10, f11);
        BufferUploader.drawWithShader(bufferBuilderBegin.buildOrThrow());
    }

    public void a(GuiGraphics guiGraphics, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        Matrix4f matrix4fPose = guiGraphics.pose().last().pose();
        float f10 = f2 + f6;
        float f11 = f3 + f7;
        float f12 = f4 / 256.0f;
        float f13 = f5 / 256.0f;
        float f14 = (f4 + f8) / 256.0f;
        float f15 = (f5 + f9) / 256.0f;
        BufferBuilder bufferBuilderBegin = Tesselator.getInstance().begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        bufferBuilderBegin.addVertex(matrix4fPose, f2, f11, 0.0f).setUv(f12, f15);
        bufferBuilderBegin.addVertex(matrix4fPose, f10, f11, 0.0f).setUv(f14, f15);
        bufferBuilderBegin.addVertex(matrix4fPose, f10, f3, 0.0f).setUv(f14, f13);
        bufferBuilderBegin.addVertex(matrix4fPose, f2, f3, 0.0f).setUv(f12, f13);
        BufferUploader.drawWithShader(bufferBuilderBegin.buildOrThrow());
    }

    public void a(GuiGraphics guiGraphics, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, int i2, int i3) {
        Matrix4f matrix4fPose = guiGraphics.pose().last().pose();
        float f10 = f2 + f6;
        float f11 = f3 + f7;
        float f12 = f4 / i2;
        float f13 = f5 / i3;
        float f14 = (f4 + f8) / i2;
        float f15 = (f5 + f9) / i3;
        BufferBuilder bufferBuilderBegin = Tesselator.getInstance().begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        bufferBuilderBegin.addVertex(matrix4fPose, f2, f11, 0.0f).setUv(f12, f15);
        bufferBuilderBegin.addVertex(matrix4fPose, f10, f11, 0.0f).setUv(f14, f15);
        bufferBuilderBegin.addVertex(matrix4fPose, f10, f3, 0.0f).setUv(f14, f13);
        bufferBuilderBegin.addVertex(matrix4fPose, f2, f3, 0.0f).setUv(f12, f13);
        BufferUploader.drawWithShader(bufferBuilderBegin.buildOrThrow());
    }

    public void a(GuiGraphics guiGraphics, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, int i2) {
        Matrix4f matrix4fPose = guiGraphics.pose().last().pose();
        float f10 = f2 + f6;
        float f11 = f3 + f7;
        float f12 = f4 / 256.0f;
        float f13 = f5 / 256.0f;
        float f14 = (f4 + f8) / 256.0f;
        float f15 = (f5 + f9) / 256.0f;
        BufferBuilder bufferBuilderBegin = Tesselator.getInstance().begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
        RenderSystem.setShader(GameRenderer::getPositionTexColorShader);
        bufferBuilderBegin.addVertex(matrix4fPose, f2, f11, 0.0f).setColor(i2).setUv(f12, f15);
        bufferBuilderBegin.addVertex(matrix4fPose, f10, f11, 0.0f).setColor(i2).setUv(f14, f15);
        bufferBuilderBegin.addVertex(matrix4fPose, f10, f3, 0.0f).setColor(i2).setUv(f14, f13);
        bufferBuilderBegin.addVertex(matrix4fPose, f2, f3, 0.0f).setColor(i2).setUv(f12, f13);
        BufferUploader.drawWithShader(bufferBuilderBegin.buildOrThrow());
    }

    public static void a(GuiGraphics guiGraphics, float f2, float f3, float f4, TextureAtlasSprite textureAtlasSprite, float f5, float f6) {
        Matrix4f matrix4fPose = guiGraphics.pose().last().pose();
        float f7 = f2 + f5;
        float f8 = f3 + f6;
        BufferBuilder bufferBuilderBegin = Tesselator.getInstance().begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        bufferBuilderBegin.addVertex(matrix4fPose, f2, f8, f4).setUv(textureAtlasSprite.getU0(), textureAtlasSprite.getV1());
        bufferBuilderBegin.addVertex(matrix4fPose, f7, f8, f4).setUv(textureAtlasSprite.getU1(), textureAtlasSprite.getV1());
        bufferBuilderBegin.addVertex(matrix4fPose, f7, f3, f4).setUv(textureAtlasSprite.getU1(), textureAtlasSprite.getV0());
        bufferBuilderBegin.addVertex(matrix4fPose, f2, f3, f4).setUv(textureAtlasSprite.getU0(), textureAtlasSprite.getV0());
        BufferUploader.drawWithShader(bufferBuilderBegin.buildOrThrow());
    }

    public static void a(GuiGraphics guiGraphics, float f2, float f3, float f4, TextureAtlasSprite textureAtlasSprite, int i2, float f5, float f6, float f7, float f8) {
        if (textureAtlasSprite == null || guiGraphics == null) {
            return;
        }
        float f9 = ((i2 >> 24) & 255) / 255.0f;
        float f10 = ((i2 >> 16) & 255) / 255.0f;
        float f11 = ((i2 >> 8) & 255) / 255.0f;
        float f12 = (i2 & 255) / 255.0f;
        float u0 = textureAtlasSprite.getU0();
        float v0 = textureAtlasSprite.getV0();
        double u1 = (textureAtlasSprite.getU1() - u0) / f5;
        double v1 = (textureAtlasSprite.getV1() - v0) / f6;
        RenderSystem.setShaderTexture(0, textureAtlasSprite.atlasLocation());
        RenderSystem.setShader(GameRenderer::getPositionTexColorShader);
        RenderSystem.enableBlend();
        Matrix4f matrix4fPose = guiGraphics.pose().last().pose();
        BufferBuilder bufferBuilderBegin = Tesselator.getInstance().begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX_COLOR);
        double d2 = f3;
        while (true) {
            double d3 = d2;
            if (d3 < f3 + f8) {
                double dMin = Math.min(f6, ((double) (f8 + f3)) - d3);
                double d4 = d3 + dMin;
                float f13 = (float) (((double) v0) + (v1 * dMin));
                double d5 = f2;
                while (true) {
                    double d6 = d5;
                    if (d6 < f2 + f7) {
                        double dMin2 = Math.min(f5, ((double) (f7 + f2)) - d6);
                        double d7 = d6 + dMin2;
                        float f14 = (float) (((double) u0) + (u1 * dMin2));
                        bufferBuilderBegin.addVertex(matrix4fPose, (float) d6, (float) d4, f4).setUv(u0, f13).setColor(f10, f11, f12, f9);
                        bufferBuilderBegin.addVertex(matrix4fPose, (float) d7, (float) d4, f4).setUv(f14, f13).setColor(f10, f11, f12, f9);
                        bufferBuilderBegin.addVertex(matrix4fPose, (float) d7, (float) d3, f4).setUv(f14, v0).setColor(f10, f11, f12, f9);
                        bufferBuilderBegin.addVertex(matrix4fPose, (float) d6, (float) d3, f4).setUv(u0, v0).setColor(f10, f11, f12, f9);
                        d5 = d6 + ((double) f5);
                    }
                }
                d2 = d3 + ((double) f6);
            } else {
                BufferUploader.drawWithShader(bufferBuilderBegin.buildOrThrow());
                RenderSystem.disableBlend();
                return;
            }
        }
    }

    public static void a(GuiGraphics guiGraphics, float f2, float f3, float f4, TextureAtlasSprite textureAtlasSprite, int i2, float f5, float f6) {
        Matrix4f matrix4fPose = guiGraphics.pose().last().pose();
        float f7 = f2 + f5;
        float f8 = f3 + f6;
        BufferBuilder bufferBuilderBegin = Tesselator.getInstance().begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX_COLOR);
        RenderSystem.setShader(GameRenderer::getPositionTexColorShader);
        bufferBuilderBegin.addVertex(matrix4fPose, f2, f8, f4).setColor(i2).setUv(textureAtlasSprite.getU0(), textureAtlasSprite.getV1());
        bufferBuilderBegin.addVertex(matrix4fPose, f7, f8, f4).setColor(i2).setUv(textureAtlasSprite.getU1(), textureAtlasSprite.getV1());
        bufferBuilderBegin.addVertex(matrix4fPose, f7, f3, f4).setColor(i2).setUv(textureAtlasSprite.getU1(), textureAtlasSprite.getV0());
        bufferBuilderBegin.addVertex(matrix4fPose, f2, f3, f4).setColor(i2).setUv(textureAtlasSprite.getU0(), textureAtlasSprite.getV0());
        BufferUploader.drawWithShader(bufferBuilderBegin.buildOrThrow());
    }

    public void a(GuiGraphics guiGraphics, float f2, float f3, float f4, float f5, int i2) {
        Matrix4f matrix4fPose = guiGraphics.pose().last().pose();
        BufferBuilder bufferBuilderBegin = Tesselator.getInstance().begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_COLOR);
        RenderSystem.setShader(GameRenderer::getPositionColorShader);
        bufferBuilderBegin.addVertex(matrix4fPose, f2, f3 + f5, a()).setColor(i2);
        bufferBuilderBegin.addVertex(matrix4fPose, f2 + f4, f3 + f5, a()).setColor(i2);
        bufferBuilderBegin.addVertex(matrix4fPose, f2 + f4, f3, a()).setColor(i2);
        bufferBuilderBegin.addVertex(matrix4fPose, f2, f3, a()).setColor(i2);
        BufferUploader.drawWithShader(bufferBuilderBegin.buildOrThrow());
    }

    private int a() {
        return 0;
    }

    public void b(GuiGraphics guiGraphics, float f2, float f3, float f4, float f5, int i2) {
        Matrix4f matrix4fPose = guiGraphics.pose().last().pose();
        BufferBuilder bufferBuilderBegin = Tesselator.getInstance().begin(VertexFormat.Mode.LINES, DefaultVertexFormat.POSITION_COLOR);
        RenderSystem.setShader(GameRenderer::getPositionColorShader);
        bufferBuilderBegin.addVertex(matrix4fPose, f2, f3, a()).setColor(i2);
        bufferBuilderBegin.addVertex(matrix4fPose, f2 + f4, f3, a()).setColor(i2);
        bufferBuilderBegin.addVertex(matrix4fPose, f2 + f4, f3, a()).setColor(i2);
        bufferBuilderBegin.addVertex(matrix4fPose, f2 + f4, f3 + f5, a()).setColor(i2);
        bufferBuilderBegin.addVertex(matrix4fPose, f2 + f4, f3 + f5, a()).setColor(i2);
        bufferBuilderBegin.addVertex(matrix4fPose, f2, f3 + f5, a()).setColor(i2);
        bufferBuilderBegin.addVertex(matrix4fPose, f2, f3 + f5, a()).setColor(i2);
        bufferBuilderBegin.addVertex(matrix4fPose, f2, f3, a()).setColor(i2);
        BufferUploader.drawWithShader(bufferBuilderBegin.buildOrThrow());
    }

    public static void c(GuiGraphics guiGraphics, float f2, float f3, float f4, float f5, int i2) {
        Matrix4f matrix4fPose = guiGraphics.pose().last().pose();
        BufferBuilder bufferBuilderBegin = Tesselator.getInstance().begin(VertexFormat.Mode.LINES, DefaultVertexFormat.POSITION_COLOR);
        RenderSystem.setShader(GameRenderer::getPositionColorShader);
        bufferBuilderBegin.addVertex(matrix4fPose, f2, f3, 0.0f).setColor(i2);
        bufferBuilderBegin.addVertex(matrix4fPose, f2 + f4, f3, 0.0f).setColor(i2);
        bufferBuilderBegin.addVertex(matrix4fPose, f2 + f4, f3, 0.0f).setColor(i2);
        bufferBuilderBegin.addVertex(matrix4fPose, f2 + f4, f3 + f5, 0.0f).setColor(i2);
        bufferBuilderBegin.addVertex(matrix4fPose, f2 + f4, f3 + f5, 0.0f).setColor(i2);
        bufferBuilderBegin.addVertex(matrix4fPose, f2, f3 + f5, 0.0f).setColor(i2);
        bufferBuilderBegin.addVertex(matrix4fPose, f2, f3 + f5, 0.0f).setColor(i2);
        bufferBuilderBegin.addVertex(matrix4fPose, f2, f3, 0.0f).setColor(i2);
        BufferUploader.drawWithShader(bufferBuilderBegin.buildOrThrow());
    }

    public void a(GuiGraphics guiGraphics, float f2, float f3, float f4, float f5, int i2, int i3) {
        Matrix4f matrix4fPose = guiGraphics.pose().last().pose();
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        BufferBuilder bufferBuilderBegin = Tesselator.getInstance().begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_COLOR);
        RenderSystem.setShader(GameRenderer::getPositionColorShader);
        bufferBuilderBegin.addVertex(matrix4fPose, f2, f3 + f5, a()).setColor(i2 | mctech.utils.math.a.f);
        bufferBuilderBegin.addVertex(matrix4fPose, f2 + f4, f3 + f5, a()).setColor(i3 | mctech.utils.math.a.f);
        bufferBuilderBegin.addVertex(matrix4fPose, f2 + f4, f3, a()).setColor(i3 | mctech.utils.math.a.f);
        bufferBuilderBegin.addVertex(matrix4fPose, f2, f3, a()).setColor(i2 | mctech.utils.math.a.f);
        BufferUploader.drawWithShader(bufferBuilderBegin.buildOrThrow());
        RenderSystem.disableBlend();
    }

    public void b(GuiGraphics guiGraphics, float f2, float f3, float f4, float f5, int i2, int i3) {
        Matrix4f matrix4fPose = guiGraphics.pose().last().pose();
        BufferBuilder bufferBuilderBegin = Tesselator.getInstance().begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_COLOR);
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.setShader(GameRenderer::getPositionColorShader);
        bufferBuilderBegin.addVertex(matrix4fPose, f2, f3 + f5, a()).setColor(i3 | mctech.utils.math.a.f);
        bufferBuilderBegin.addVertex(matrix4fPose, f2 + f4, f3 + f5, a()).setColor(i3 | mctech.utils.math.a.f);
        bufferBuilderBegin.addVertex(matrix4fPose, f2 + f4, f3, a()).setColor(i2 | mctech.utils.math.a.f);
        bufferBuilderBegin.addVertex(matrix4fPose, f2, f3, a()).setColor(i2 | mctech.utils.math.a.f);
        BufferUploader.drawWithShader(bufferBuilderBegin.buildOrThrow());
        RenderSystem.disableBlend();
    }

    public void a(GuiGraphics guiGraphics, Slot slot) {
        int i2 = slot.x + this.leftPos;
        int i3 = slot.y + this.topPos;
        ItemStack item = slot.getItem();
        if (item.isEmpty() && slot.isActive()) {
            Pair noItemIcon = slot.getNoItemIcon();
            if (noItemIcon != null) {
                RenderSystem.setShaderTexture(0, (ResourceLocation) noItemIcon.getFirst());
                return;
            }
            return;
        }
        RenderSystem.enableDepthTest();
        guiGraphics.renderItem(item, i2, i3);
        guiGraphics.renderItemDecorations(this.font, item, i2, i3, (String) null);
    }

    protected void renderTooltip(GuiGraphics guiGraphics, int i2, int i3) {
        if (d(4) && (getSlotUnderMouse() instanceof q)) {
            return;
        }
        super.renderTooltip(guiGraphics, i2, i3);
    }

    public boolean mouseClicked(double d2, double d3, int i2) {
        this.u = System.currentTimeMillis();
        return super.mouseClicked(d2, d3, i2);
    }

    public boolean mouseReleased(double d2, double d3, int i2) {
        this.u = System.currentTimeMillis();
        return super.mouseReleased(d2, d3, i2);
    }

    public void c() {
        RenderSystem.setShaderTexture(0, d().getId());
    }

    public AbstractTexture d() {
        if (this.l == null) {
            this.l = b(this.k);
        }
        return this.l;
    }

    public AbstractTexture b(ResourceLocation resourceLocation) {
        AbstractTexture texture = this.minecraft.getTextureManager().getTexture(resourceLocation);
        if (texture == null) {
            texture = new SimpleTexture(resourceLocation);
            this.minecraft.getTextureManager().register(resourceLocation, texture);
        }
        return texture;
    }

    public void c(ResourceLocation resourceLocation) {
        RenderSystem.setShaderTexture(0, b(resourceLocation).getId());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void e() {
        ((ScreenMixin) this).setLastClickButton(0);
    }

    public void b(int i2, int i3) {
        this.y.setX(i2);
        this.y.setY(i3);
    }

    public void c(int i2, int i3) {
        this.x.setX(i2);
        this.x.setY(i3);
    }

    public void d(int i2, int i3) {
        this.imageWidth += i2;
        this.imageHeight += i3;
    }

    public void e(int i2, int i3) {
        this.imageWidth = i2;
        this.imageHeight = i3;
    }

    public void e(int i2) {
        this.imageWidth = i2;
    }

    public void f(int i2) {
        this.imageHeight = i2;
    }

    public void a(Component component) {
        this.w = component;
    }

    public Component getTitle() {
        return this.w;
    }

    public void a(boolean z) {
    }

    public LocalPlayer f() {
        return this.minecraft.player;
    }

    public UUID g() {
        return this.minecraft.player.getUUID();
    }

    public ResourceLocation h() {
        return this.k;
    }

    public AbstractTexture i() {
        return this.l;
    }

    public Font j() {
        return this.font;
    }

    public int k() {
        return this.r;
    }

    public boolean l() {
        return this.isQuickCrafting;
    }

    public AbstractWidget g(int i2) {
        return (AbstractWidget) this.o.get(i2);
    }

    public <K extends AbstractWidget> K a(int i2, Class<K> cls) {
        return (K) this.o.get(i2);
    }

    public boolean h(int i2) {
        return this.o.containsKey(i2);
    }

    public Int2ObjectMap<AbstractWidget> m() {
        return this.o;
    }

    public void b(Predicate<AbstractWidget> predicate) {
        children().removeIf(guiEventListener -> {
            return (guiEventListener instanceof AbstractWidget) && predicate.test((AbstractWidget) guiEventListener);
        });
        this.renderables.removeIf(renderable -> {
            return (renderable instanceof AbstractWidget) && predicate.test((AbstractWidget) renderable);
        });
    }

    public int getSlotColor(int i2) {
        return this.p.get(i2);
    }

    public boolean a(Slot slot, int i2, int i3) {
        return isHovering(slot.x, slot.y, 16, 16, i2 + this.leftPos, i3 + this.topPos);
    }

    public <K extends AbstractContainerMenu> K b(Class<K> cls) {
        if (cls.isInstance(this.menu)) {
            return (S) this.menu;
        }
        return null;
    }

    public static Style a(List<FormattedCharSequence> list, int i2, int i3) {
        int i4 = 9;
        if (i2 < 0 || i3 < 0) {
            return null;
        }
        int i5 = 0;
        while (i4 <= i3) {
            i4 += 9;
            i5++;
        }
        if (i5 >= list.size()) {
            return null;
        }
        return Minecraft.getInstance().font.getSplitter().componentStyleAtWidth(list.get(i5), i2);
    }

    public <T extends IFluidHandler & IFluidTank> void a(GuiGraphics guiGraphics, int i2, int i3, int i4, int i5, int i6, T t) {
        if (t.getFluidAmount() <= 0) {
            return;
        }
        RenderSystem.enableBlend();
        int guiLeft = i2 + getGuiLeft();
        int guiTop = i3 + getGuiTop() + i6;
        Function textureAtlas = this.minecraft.getTextureAtlas(InventoryMenu.BLOCK_ATLAS);
        c(InventoryMenu.BLOCK_ATLAS);
        float f2 = 0.0f;
        float f3 = 0.0f;
        int capacity = t.getCapacity();
        int tanks = t.getTanks();
        for (int i7 = 0; i7 < tanks; i7++) {
            FluidStack fluidInTank = t.getFluidInTank(i7);
            float amount = fluidInTank.isEmpty() ? 0.0f : (fluidInTank.getAmount() / capacity) * i6;
            if (amount > 0.0f) {
                f2 += amount;
                IClientFluidTypeExtensions iClientFluidTypeExtensionsOf = IClientFluidTypeExtensions.of(fluidInTank.getFluid());
                TextureAtlasSprite textureAtlasSprite = (TextureAtlasSprite) textureAtlas.apply(iClientFluidTypeExtensionsOf.getStillTexture(fluidInTank));
                if (textureAtlasSprite != textureAtlas.apply(MissingTextureAtlasSprite.getLocation())) {
                    int tintColor = iClientFluidTypeExtensionsOf.getTintColor(fluidInTank);
                    while (f3 < f2) {
                        float fMin = Math.min(16.0f, f2 - f3);
                        a(guiGraphics, guiLeft, (guiTop - f3) - fMin, a(), textureAtlasSprite, tintColor, 16.0f, fMin);
                        if (fMin <= 0.0f || f3 + 1.0f >= f2) {
                            break;
                        } else {
                            f3 += fMin;
                        }
                    }
                }
            }
        }
        c();
        b(guiGraphics, guiLeft, guiTop - i6, i4, i5, 16.0f, i6);
    }

    public void a(GuiGraphics guiGraphics, float f2, float f3, float f4, float f5, float f6, float f7, FluidStack fluidStack) {
        a(guiGraphics, f2, f3, f4, f5, 16.0f, f6, f7, fluidStack);
    }

    public void a(GuiGraphics guiGraphics, float f2, float f3, float f4, float f5, float f6, float f7, float f8, FluidStack fluidStack) {
        a(guiGraphics, f2, f3, f4, f5, 16.0f, f7, f8, fluidStack, true);
        b(guiGraphics, f2, f3 - f8, f4, f5, f6, f8);
    }

    public void a(GuiGraphics guiGraphics, float f2, float f3, float f4, float f5, float f6, float f7, float f8, FluidStack fluidStack, boolean z) {
        if (fluidStack.isEmpty()) {
            return;
        }
        float guiLeft = f2 + getGuiLeft();
        float guiTop = f3 + getGuiTop();
        Function textureAtlas = this.minecraft.getTextureAtlas(InventoryMenu.BLOCK_ATLAS);
        IClientFluidTypeExtensions iClientFluidTypeExtensionsOf = IClientFluidTypeExtensions.of(fluidStack.getFluid());
        TextureAtlasSprite textureAtlasSprite = (TextureAtlasSprite) textureAtlas.apply(iClientFluidTypeExtensionsOf.getStillTexture(fluidStack));
        if (textureAtlasSprite == textureAtlas.apply(MissingTextureAtlasSprite.getLocation())) {
            return;
        }
        c(InventoryMenu.BLOCK_ATLAS);
        RenderSystem.enableBlend();
        int tintColor = iClientFluidTypeExtensionsOf.getTintColor(fluidStack);
        int iCeil = 0;
        float f9 = guiTop + f8;
        while (iCeil < f7) {
            float fMin = Math.min(16.0f, f7 - iCeil);
            a(guiGraphics, guiLeft, (f9 - iCeil) - fMin, a(), textureAtlasSprite, tintColor, 16.0f, 16.0f, f6, fMin);
            iCeil += Mth.ceil(fMin);
            if (fMin <= 0.0f || iCeil >= f7) {
                break;
            }
        }
        c();
    }

    private static void a(Matrix4f matrix4f, Font font, float f2, float f3, String str, boolean z) {
        float f4 = z ? 0.85f : 0.666f;
        float f5 = 1.0f / f4;
        int i2 = z ? 0 : -1;
        RenderSystem.disableBlend();
        int iWidth = (int) (((((f2 + i2) + 16.0f) + 2.0f) - (font.width(str) * f4)) * f5);
        int i3 = (int) ((((f3 + i2) + 16.0f) - (5.0f * f4)) * f5);
        MultiBufferSource.BufferSource bufferSource = Minecraft.getInstance().renderBuffers().bufferSource();
        font.drawInBatch(str, iWidth + 1, i3 + 1, 4276052, false, matrix4f, bufferSource, Font.DisplayMode.NORMAL, 0, 15728880);
        font.drawInBatch(str, iWidth, i3, 16777215, false, matrix4f, bufferSource, Font.DisplayMode.NORMAL, 0, 15728880);
        bufferSource.endBatch();
        RenderSystem.enableBlend();
    }

    private static void a(GuiGraphics guiGraphics, Font font, float f2, float f3, String str, boolean z) {
        float f4 = z ? 0.85f : 0.666f;
        PoseStack poseStackPose = guiGraphics.pose();
        poseStackPose.pushPose();
        poseStackPose.translate(0.0f, 0.0f, 200.0f);
        poseStackPose.scale(f4, f4, f4);
        a(poseStackPose.last().pose(), font, f2, f3, str, z);
        poseStackPose.popPose();
    }
}
