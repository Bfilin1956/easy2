package mctech.components;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import mctech.MCTech;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: mctech.components.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/o.class */
@OnlyIn(Dist.CLIENT)
public class C0121o extends AbstractWidget {
    private final mctech.w.l a;
    private final int b;
    private final int c;
    private a d;
    private final Set<b> e;
    private final Set<c> f;

    public C0121o(int i, int i2, mctech.w.l lVar, int i3, int i4, C0121o c0121o) {
        super(i, i2, 10, 10, Component.empty());
        this.e = new HashSet();
        this.f = new HashSet();
        this.a = lVar;
        this.b = i3;
        this.c = i4;
        if (c0121o != null && c0121o.d != null) {
            c();
        }
    }

    public void onClick(double d, double d2) {
        if (this.d == null) {
            c();
        } else {
            b();
        }
    }

    public boolean a() {
        return this.d != null;
    }

    public void b() {
        this.a.removeWidget(this.d);
        this.d.b();
        this.d = null;
        Iterator<c> it = this.f.iterator();
        while (it.hasNext()) {
            this.a.removeWidget((c) it.next());
        }
        this.f.clear();
    }

    private void c() {
        this.d = this.a.addRenderableWidget(new a());
        this.d.a();
        for (b bVar : this.e) {
            for (int i : bVar.a) {
                Slot slot = ((mctech.o.h) this.a.getMenu()).getSlot(i);
                this.f.add((c) this.a.addRenderableWidget(new c(slot.x + this.a.getGuiLeft(), slot.y + this.a.getGuiTop(), slot, bVar)));
            }
        }
    }

    public void a(double d, double d2, int i) {
        if (this.d != null) {
            this.d.a(d, d2, i);
        }
    }

    protected void renderWidget(GuiGraphics guiGraphics, int i, int i2, float f) {
        if (isHoveredOrFocused()) {
            mctech.utils.l.a(guiGraphics, getX(), getY(), 0.0f, this.width, this.height, 1.0f, -1);
        }
    }

    public void a(@NotNull GuiGraphics guiGraphics, int i, int i2) {
        if (isMouseOver(i, i2)) {
            guiGraphics.renderTooltip(Minecraft.getInstance().font, Component.translatable("gui.mctech.filter.button"), i, i2);
        } else if (this.d != null) {
            this.d.a(guiGraphics, i, i2);
        }
    }

    public void a(int i, Supplier<ItemStack[]> supplier) {
        if (i > 0) {
            int iSum = this.e.stream().mapToInt(bVar -> {
                return bVar.a.length;
            }).sum();
            this.e.add(new b(IntStream.range(iSum, iSum + i).toArray(), supplier));
        }
    }

    protected void updateWidgetNarration(NarrationElementOutput narrationElementOutput) {
    }

    /* JADX INFO: renamed from: mctech.components.o$a */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/o$a.class */
    public class a extends AbstractWidget {
        private final EditBox b;
        private final J c;
        private ItemStack[] d;
        private final List<ItemStack> e;
        private static final ResourceLocation f = ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "textures/gui/components/filter_helper.png");

        public a() {
            super((C0121o.this.getX() - 122) + C0121o.this.b, C0121o.this.getY() + C0121o.this.c, 122, 132, Component.empty());
            this.e = new ArrayList();
            this.b = new EditBox(Minecraft.getInstance().font, getX() + 10, getY() + 22, 100, 10, C0121o.this.d == null ? null : C0121o.this.d.b, Component.empty());
            this.b.setBordered(false);
            this.b.setMaxLength(Integer.MAX_VALUE);
            this.b.setResponder(str -> {
                c();
            });
            this.c = new J(new mctech.utils.math.geometry.b(getX() + 101, getY() + 35, 12, 88), new mctech.utils.math.geometry.b(0, 132, 12, 15), 5).a(4).a(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "textures/gui/components/filter_helper.png"));
        }

        private void a() {
            C0121o.this.a.addRenderableWidget(this.b);
            C0121o.this.a.addRenderableWidget(this.c);
        }

        private void b() {
            C0121o.this.a.removeWidget(this.b);
            C0121o.this.a.removeWidget(this.c);
        }

        private void a(@NotNull b bVar) {
            this.d = bVar.a();
            this.c.b(this.d.length);
            c();
        }

        private void c() {
            if (this.d == null) {
                return;
            }
            String lowerCase = this.b.getValue().toLowerCase(Locale.ROOT);
            this.e.clear();
            if (lowerCase.isEmpty()) {
                this.e.addAll(Arrays.stream(this.d).toList());
                return;
            }
            for (ItemStack itemStack : this.d) {
                if (itemStack.getHoverName().getString().toLowerCase(Locale.ROOT).contains(lowerCase)) {
                    this.e.add(itemStack);
                }
            }
        }

        protected boolean isValidClickButton(int i) {
            return false;
        }

        public boolean mouseScrolled(double d, double d2, double d3, double d4) {
            return this.c.mouseScrolled(d, d2, d3, d4);
        }

        public void a(double d, double d2, int i) {
            if (this.c.g) {
                this.c.mouseReleased(d, d2, i);
            }
        }

        public void a(@NotNull GuiGraphics guiGraphics, int i, int i2) {
            int iB = this.c.b();
            for (int i3 = 0; i3 < 25 && this.e.size() > i3 + iB; i3++) {
                int x = getX() + 9 + (18 * (i3 % 5));
                int y = getY() + 35 + (18 * (i3 / 5));
                if (i >= x && i <= x + 16 && i2 >= y && i2 <= y + 16) {
                    guiGraphics.renderTooltip(Minecraft.getInstance().font, this.e.get(i3 + iB), i, i2);
                    return;
                }
            }
            for (c cVar : C0121o.this.f) {
                if (!cVar.b && cVar.isMouseOver(i, i2)) {
                    cVar.a(guiGraphics, i, i2);
                }
            }
        }

        protected void updateWidgetNarration(NarrationElementOutput narrationElementOutput) {
        }

        protected void renderWidget(GuiGraphics guiGraphics, int i, int i2, float f2) {
            RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, this.alpha);
            RenderSystem.enableBlend();
            RenderSystem.defaultBlendFunc();
            RenderSystem.enableDepthTest();
            guiGraphics.blit(f, getX(), getY(), 0, 0, this.width, this.height);
            int iB = this.c.b();
            for (int i3 = 0; i3 < 25 && this.e.size() > i3 + iB; i3++) {
                guiGraphics.renderItem(this.e.get(i3 + iB), getX() + 9 + (18 * (i3 % 5)), getY() + 35 + (18 * (i3 / 5)));
            }
            Font font = Minecraft.getInstance().font;
            MutableComponent mutableComponentLiteral = Component.literal("Фильтр Предметов");
            guiGraphics.drawString(font, mutableComponentLiteral.getVisualOrderText(), (getX() + 61) - (font.width(mutableComponentLiteral) / 2.0f), getY() + 9, 16777215, true);
        }
    }

    /* JADX INFO: renamed from: mctech.components.o$c */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/o$c.class */
    private class c extends AbstractWidget {
        private boolean b;
        private final int c;
        private final b d;

        public c(int i, int i2, Slot slot, b bVar) {
            super(i, i2, 16, 16, Component.empty());
            this.d = bVar;
            if (slot instanceof mctech.m.a.j) {
                mctech.m.a.j jVar = (mctech.m.a.j) slot;
                this.c = jVar.o() - 16;
                this.width = jVar.o();
                this.height = jVar.o();
                return;
            }
            this.c = 0;
        }

        protected void renderWidget(GuiGraphics guiGraphics, int i, int i2, float f) {
            int i3 = this.b ? -2130720768 : -2145473563;
            RenderSystem.enableDepthTest();
            RenderSystem.enableBlend();
            RenderSystem.defaultBlendFunc();
            RenderSystem.setShader(GameRenderer::getPositionColorShader);
            mctech.utils.l.a(guiGraphics, getX() - 3, getY() - 3, 0.0f, 22 + this.c, 22 + this.c, ((i3 >> 16) & 255) / 255.0f, ((i3 >> 8) & 255) / 255.0f, (i3 & 255) / 255.0f, ((i3 >> 24) & 255) / 255.0f);
        }

        public void a(@NotNull GuiGraphics guiGraphics, int i, int i2) {
            guiGraphics.renderTooltip(Minecraft.getInstance().font, Component.literal("Нажмите, чтобы посмотреть доступные предметы"), i, i2);
        }

        public void onClick(double d, double d2) {
            for (c cVar : C0121o.this.f) {
                if (cVar.d == this.d) {
                    if (!cVar.b) {
                        cVar.b = true;
                    }
                } else if (cVar.b) {
                    cVar.b = false;
                }
            }
            if (C0121o.this.d != null) {
                C0121o.this.d.a(this.d);
            }
        }

        protected void updateWidgetNarration(NarrationElementOutput narrationElementOutput) {
        }
    }

    /* JADX INFO: renamed from: mctech.components.o$b */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/o$b.class */
    private static class b {
        private final int[] a;
        private final Supplier<ItemStack[]> b;
        private ItemStack[] c;

        private b(int[] iArr, Supplier<ItemStack[]> supplier) {
            this.a = iArr;
            this.b = supplier;
        }

        private ItemStack[] a() {
            if (this.c == null) {
                this.c = this.b.get();
            }
            return this.c;
        }
    }
}
