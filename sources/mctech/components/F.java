package mctech.components;

import com.mojang.blaze3d.platform.Lighting;
import com.mojang.blaze3d.systems.RenderSystem;
import it.unimi.dsi.fastutil.objects.ObjectList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.function.Consumer;
import mctech.MCTech;
import mctech.init.MCTechItems;
import mctech.m.b.C0140am;
import mctech.utils.math.geometry.Vec2i;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.gui.widget.ExtendedButton;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/F.class */
public class F extends mctech.m.d.a.a {
    private C0140am a;
    private mctech.components.b.q b;
    private List<ItemStack> c;
    private ItemStack[] d;
    private List<ItemStack>[] e;
    private Vec2i f;

    public F(mctech.blockentities.b.g gVar, C0140am c0140am) {
        super(new mctech.utils.math.geometry.b(-118, 16, 118, 132));
        this.c = mctech.utils.a.b.i();
        this.e = new List[]{mctech.utils.a.b.i(), mctech.utils.a.b.i(), mctech.utils.a.b.i(), mctech.utils.a.b.i(), mctech.utils.a.b.i(), mctech.utils.a.b.i()};
        this.d = new ItemStack[]{new ItemStack(MCTechItems.URANIUM_ROD_SINGLE.asItem()), new ItemStack(MCTechItems.VENT_ELECTRIC_ADVANCED.asItem()), new ItemStack(MCTechItems.HEAT_EXCHANGER_ADVANCED.asItem()), new ItemStack(MCTechItems.HEAT_BALANCER_ADVANCED.asItem()), new ItemStack(MCTechItems.REFLECTOR.asItem()), new ItemStack(Items.WATER_BUCKET)};
        this.f = new Vec2i(112, 16);
        for (Item item : BuiltInRegistries.ITEM) {
            if (item instanceof mctech.items.d.o) {
                this.e[0].add(new ItemStack(item));
            } else if (item instanceof mctech.items.d.j) {
                this.e[1].add(new ItemStack(item));
            } else if (item instanceof mctech.items.d.f) {
                this.e[2].add(new ItemStack(item));
            } else if (item instanceof mctech.items.d.e) {
                this.e[3].add(new ItemStack(item));
            } else if (item instanceof mctech.items.d.a.d) {
                this.e[4].add(new ItemStack(item));
            }
        }
        this.a = c0140am;
        this.b = ((mctech.components.b.q) a(new mctech.components.b.q(new mctech.utils.math.geometry.b((-123) + this.f.getX(), 41 + this.f.getY(), 12, 88), new mctech.utils.math.geometry.b(19, 133, 12, 15), 5))).a(4).a(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "textures/gui/gui_atlas_2.png"));
    }

    @Override // mctech.m.d.a.a
    protected void a(Set<mctech.m.d.a.a.EnumC0027a> set) {
        set.add(mctech.m.d.a.a.EnumC0027a.GUI_INIT);
        set.add(mctech.m.d.a.a.EnumC0027a.DRAW_BACKGROUND);
        set.add(mctech.m.d.a.a.EnumC0027a.DRAW_FOREGROUND);
        set.add(mctech.m.d.a.a.EnumC0027a.TOOLTIP);
        set.add(mctech.m.d.a.a.EnumC0027a.MOUSE_INPUT);
        set.add(mctech.m.d.a.a.EnumC0027a.MOUSE_SCROLL);
        set.add(mctech.m.d.a.a.EnumC0027a.KEY_INPUT);
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(mctech.m.d.b bVar) {
        EditBox editBoxA = bVar.a(1000, new EditBox(bVar.j(), (bVar.getGuiLeft() + 11) - this.f.getX(), bVar.getGuiTop() + 28 + this.f.getY(), 99, 9, A()));
        editBoxA.setMaxLength(50);
        editBoxA.setBordered(false);
        editBoxA.setCanLoseFocus(true);
        editBoxA.setResponder(this::a);
        for (int i = 0; i < 6; i++) {
            bVar.a(1001 + i, new a(i, ((19 * i) + bVar.getGuiLeft()) - 107, bVar.getGuiTop() + 21, 18, 18, Component.empty(), button -> {
                this.c.clear();
                this.c.addAll(this.e[((a) button).a()]);
                this.b.d(0);
                this.b.c(this.c.size());
            }));
        }
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(GuiGraphics guiGraphics, int i, int i2, float f) {
        this.q.c(this.a.getTexture());
        int guiLeft = this.q.getGuiLeft() - this.f.getX();
        int guiTop = this.q.getGuiTop() + this.f.getY();
        this.q.a(guiGraphics, guiLeft, guiTop, 333.0f, 0.0f, 122.0f, 138.0f, 122.0f, 138.0f, mctech.q.c.c, mctech.utils.c.h.i);
        Lighting.setupFor3DItems();
        int iB = this.b.b();
        for (int i3 = 0; i3 < 25 && this.c.size() > i3 + iB; i3++) {
            int i4 = guiLeft + 9 + (18 * (i3 % 5));
            int i5 = guiTop + 41 + (18 * (i3 / 5));
            guiGraphics.renderItem(this.c.get(i3 + iB), i4, i5);
            guiGraphics.renderItemDecorations(this.q.j(), this.c.get(i3 + iB), i4, i5, "");
            if (i + this.q.getGuiLeft() >= i4 && i + this.q.getGuiLeft() <= i4 + 16 && i2 + this.q.getGuiTop() >= i5 && i2 + this.q.getGuiTop() <= i5 + 16) {
                RenderSystem.disableDepthTest();
                RenderSystem.colorMask(true, true, true, false);
                int slotColor = this.q.getSlotColor(0);
                RenderSystem.enableBlend();
                RenderSystem.defaultBlendFunc();
                this.q.a(guiGraphics, i4, i5, 16.0f, 16.0f, slotColor);
                RenderSystem.disableBlend();
                RenderSystem.colorMask(true, true, true, true);
                RenderSystem.enableDepthTest();
            }
        }
        Lighting.setupFor3DItems();
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(GuiGraphics guiGraphics, int i, int i2) {
        Lighting.setupFor3DItems();
        for (int i3 = 0; i3 < 6; i3++) {
            guiGraphics.renderItem(this.d[i3], (19 * i3) - 106, 22);
        }
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        guiGraphics.pose().translate(0.0d, 0.0d, 100.0d);
        guiGraphics.pose().translate(0.0d, 0.0d, -100.0d);
        RenderSystem.disableBlend();
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(GuiGraphics guiGraphics, int i, int i2, Consumer<Component> consumer) {
        int iB = this.b.b();
        for (int i3 = 0; i3 < 25 && this.c.size() > i3 + iB; i3++) {
            int i4 = (-103) + (18 * (i3 % 5));
            int i5 = 57 + (18 * (i3 / 5));
            if (i >= i4 && i <= i4 + 16 && i2 >= i5 && i2 <= i5 + 16) {
                Iterator it = this.c.get(i3 + iB).getTooltipLines(Item.TooltipContext.of((Level) null), this.q.f(), TooltipFlag.Default.NORMAL).iterator();
                while (it.hasNext()) {
                    consumer.accept((Component) it.next());
                }
            }
        }
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public boolean a(int i, int i2, int i3) {
        int i4;
        for (int i5 = 0; i5 < 6; i5++) {
            AbstractWidget abstractWidgetG = this.q.g(1001 + i5);
            if (abstractWidgetG.isHovered()) {
                abstractWidgetG.onClick(i, i2, i3);
                for (int i6 = 0; i6 < 6; i6++) {
                    this.q.g(1001 + i6).active = true;
                }
                abstractWidgetG.active = false;
                return true;
            }
        }
        mctech.m.d.b bVar = this.q;
        if (bVar instanceof mctech.w.j) {
            mctech.w.j jVar = (mctech.w.j) bVar;
            if (this.o.a(i, i2)) {
                GuiEventListener guiEventListenerG = this.q.g(1000);
                int i7 = ((-this.f.getX()) - i) + 10;
                int i8 = ((-this.f.getY()) - i2) + 20;
                if (i7 <= guiEventListenerG.getX() && i8 <= 0 && i7 > guiEventListenerG.getX() - guiEventListenerG.getWidth() && i8 > (-guiEventListenerG.getHeight())) {
                    this.q.setFocused(guiEventListenerG);
                    return true;
                }
                int i9 = i8 + 52;
                int i10 = i7 * (-1);
                int i11 = i9 * (-1);
                if (i10 > 0 && i11 > 0 && i10 < 88 && i11 < 88 && (i4 = ((i11 / 18) * 5) + (i10 / 18)) >= 0 && i4 < this.c.size() && !this.q.isDragging()) {
                    jVar.A = this.c.get(i4);
                }
                this.q.setFocused(null);
                return false;
            }
        }
        this.q.setFocused(null);
        if (this.q.a(i, i2)) {
            return false;
        }
        return w();
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public boolean b(int i, int i2, int i3) {
        if (!this.b.a(i, i2) && this.o.a(i, i2)) {
            this.b.b(i, i2, i3);
            return false;
        }
        return false;
    }

    public void a(String str) {
        ObjectList objectListI = mctech.utils.a.b.i();
        int i = -1;
        for (int i2 = 0; i2 < 6; i2++) {
            if (!this.q.g(1001 + i2).active) {
                i = i2;
                break;
            }
        }
        if (i >= 0) {
            for (ItemStack itemStack : this.e[i]) {
                if (itemStack.getDisplayName().getString().toLowerCase(Locale.ROOT).contains(str.toLowerCase(Locale.ROOT))) {
                    objectListI.add(itemStack);
                }
            }
            this.c.clear();
            this.c.addAll(objectListI);
        }
        this.b.c(this.c.size());
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public boolean b_(int i) {
        return super.b_(i);
    }

    @OnlyIn(Dist.CLIENT)
    public void a() {
    }

    @OnlyIn(Dist.CLIENT)
    public void a(boolean z) {
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/F$a.class */
    public static class a extends ExtendedButton {
        private final int a;

        public a(int i, int i2, int i3, int i4, int i5, Component component, Button.OnPress onPress) {
            super(i2, i3, i4, i5, component, onPress);
            this.a = i;
        }

        public int a() {
            return this.a;
        }
    }
}
