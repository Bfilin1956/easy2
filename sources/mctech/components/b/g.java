package mctech.components.b;

import com.mojang.blaze3d.platform.Lighting;
import com.mojang.blaze3d.systems.RenderSystem;
import it.unimi.dsi.fastutil.objects.ObjectList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.function.Consumer;
import mctech.MCTech;
import mctech.api.items.ITagItem;
import mctech.components.ContainerComponent;
import mctech.components.a.C;
import mctech.init.MCTechItems;
import mctech.m.b.S;
import mctech.utils.math.geometry.Vec2i;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/b/g.class */
public class g extends mctech.m.d.a.a implements mctech.m.d.b.a {
    public static final ResourceLocation a = ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "textures/gui/components/filter_helper.png");
    private static final Component b = Component.translatable("gui.mctech.inventory.selected").withStyle(ChatFormatting.YELLOW);
    private static final Component c = Component.translatable("gui.mctech.inventory.configure").withStyle(ChatFormatting.YELLOW);
    private Component d;
    private boolean e;
    private j f;
    private List<ItemStack> g;
    private List<String> h;
    private List<ItemStack> i;
    private q j;
    private String k;
    private Vec2i l;
    private Vec2i m;
    private boolean n;
    private boolean s;
    private boolean t;
    private ContainerComponent<?> u;

    public g(Vec2i vec2i) {
        super(new mctech.utils.math.geometry.b((-118) + vec2i.getX(), vec2i.getY(), 118, 132));
        this.g = mctech.utils.a.b.i();
        this.h = mctech.utils.a.b.i();
        this.i = mctech.utils.a.b.i();
        this.k = "";
        this.l = vec2i;
        this.e = false;
        this.m = null;
        this.d = f("gui.mctech.filter.ghost");
        this.j = ((q) a(new q(new mctech.utils.math.geometry.b((-19) + vec2i.getX(), 37 + vec2i.getY(), 12, 88), new mctech.utils.math.geometry.b(0, 132, 12, 15), 5))).a(4).a(a());
        a_(false);
        this.j.a_(false);
    }

    public g(Vec2i vec2i, Vec2i vec2i2) {
        super(new mctech.utils.math.geometry.b((-118) + vec2i.getX(), vec2i.getY(), 118, 132));
        this.g = mctech.utils.a.b.i();
        this.h = mctech.utils.a.b.i();
        this.i = mctech.utils.a.b.i();
        this.k = "";
        this.l = vec2i;
        this.m = vec2i2;
        this.e = true;
        this.d = f("gui.mctech.filter.normal");
        this.j = ((q) a(new q(new mctech.utils.math.geometry.b((-19) + vec2i.getX(), 37 + vec2i.getY(), 12, 88), new mctech.utils.math.geometry.b(0, 132, 12, 15), 5))).a(4).a(a());
        a_(false);
        this.j.a_(false);
    }

    public g(ContainerComponent<?> containerComponent, Vec2i vec2i, Vec2i vec2i2) {
        super(new mctech.utils.math.geometry.b((-118) + vec2i.getX(), vec2i.getY(), containerComponent.getFilterGuiSize().getX(), containerComponent.getFilterGuiSize().getY()));
        this.u = containerComponent;
        this.g = mctech.utils.a.b.i();
        this.h = mctech.utils.a.b.i();
        this.i = mctech.utils.a.b.i();
        this.k = "";
        this.l = vec2i;
        this.m = vec2i2;
        this.e = true;
        this.d = f("gui.mctech.filter.normal");
        this.j = ((q) a(new q(new mctech.utils.math.geometry.b((-19) + vec2i.getX() + containerComponent.getFilterScrollOffset().getX(), 37 + vec2i.getY() + containerComponent.getFilterScrollOffset().getY(), 12, 88), new mctech.utils.math.geometry.b(0, 132, 12, 15), 5))).a(4).a(a());
        a_(false);
        this.j.a_(false);
    }

    public ResourceLocation a() {
        if (this.u != null) {
            ResourceLocation filterTexture = this.u.getFilterTexture();
            return filterTexture == null ? a : filterTexture;
        }
        return a;
    }

    public g b() {
        this.n = true;
        return this;
    }

    public g d() {
        this.t = true;
        return this;
    }

    public g e() {
        this.s = true;
        return this;
    }

    @Override // mctech.m.d.a.a
    public boolean a(int i, int i2) {
        return true;
    }

    @OnlyIn(Dist.CLIENT)
    public void a(j jVar) {
        if (this.f == jVar) {
            return;
        }
        this.i.clear();
        this.g.clear();
        this.j.c(0);
        if (jVar == null) {
            this.f = null;
            return;
        }
        if (!this.e) {
            a(true);
        }
        this.f = jVar;
        if (jVar.e()) {
            this.g.add(ItemStack.EMPTY);
            this.h.add("empty");
        }
        if (this.s && jVar.f()) {
            for (Fluid fluid : BuiltInRegistries.FLUID) {
                if (fluid.isSource(fluid.defaultFluidState())) {
                    ItemStack itemStackA = mctech.items.misc.b.a(fluid);
                    this.g.add(itemStackA);
                    this.h.add(a(itemStackA));
                }
            }
        } else {
            ObjectList objectListI = mctech.utils.a.b.i();
            ItemStack[] itemStackArrD = mctech.u.b.b.b.d();
            int iB = mctech.u.b.b.b.b();
            for (int i = 0; i < iB; i++) {
                ItemStack itemStack = itemStackArrD[i];
                if (jVar.a(itemStack)) {
                    if (itemStack.getItem() instanceof ITagItem) {
                        objectListI.add(itemStack);
                    } else if (!(itemStack.getItem() instanceof mctech.items.misc.f)) {
                        this.g.add(itemStack.copy());
                        this.h.add(a(itemStack));
                    }
                }
            }
            BuiltInRegistries.ITEM.getTagNames().forEach(tagKey -> {
                ItemStack itemStack2 = new ItemStack((ItemLike) MCTechItems.TAG_ITEM.get());
                mctech.items.misc.f.a(itemStack2, tagKey.location());
                if (jVar.a(itemStack2)) {
                    this.g.add(itemStack2);
                    this.h.add(a(itemStack2));
                }
            });
            if (this.n) {
                BuiltInRegistries.BLOCK.getTagNames().forEach(tagKey2 -> {
                    ItemStack itemStack2 = new ItemStack((ItemLike) MCTechItems.TAG_BLOCK.get());
                    mctech.items.misc.e.a(itemStack2, tagKey2.location());
                    if (jVar.a(itemStack2)) {
                        this.g.add(itemStack2);
                        this.h.add(a(itemStack2));
                    }
                });
            }
            this.g.addAll(objectListI);
            int size = objectListI.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.h.add(a((ItemStack) objectListI.get(i2)));
            }
        }
        String str = this.k;
        this.k = "THIS WILL NEVER MATCH";
        a(str);
    }

    @OnlyIn(Dist.CLIENT)
    private String a(ItemStack itemStack) {
        List tooltipLines = itemStack.getTooltipLines(Item.TooltipContext.of(Minecraft.getInstance().level), this.q.f(), this.q.getMinecraft().options.advancedItemTooltips ? TooltipFlag.Default.ADVANCED : TooltipFlag.Default.NORMAL);
        StringBuilder sb = new StringBuilder();
        int size = tooltipLines.size();
        for (int i = 0; i < size; i++) {
            sb.append(ChatFormatting.stripFormatting(((Component) tooltipLines.get(i)).getString()).toLowerCase(Locale.ROOT));
        }
        return sb.toString();
    }

    public boolean f() {
        return this.e;
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
        if (bVar instanceof mctech.m.d.a) {
            ((mctech.m.d.a) bVar).a(new a(this));
        }
        EditBox editBoxA = bVar.a(this.e ? 1001 : 1000, new EditBox(bVar.j(), (bVar.getGuiLeft() - 110) + this.l.getX(), bVar.getGuiTop() + 22 + this.l.getY(), 99, 9, A()));
        editBoxA.setMaxLength(50);
        editBoxA.setBordered(false);
        editBoxA.setCanLoseFocus(true);
        editBoxA.setVisible(false);
        editBoxA.setResponder(this::a);
        if (this.e) {
            int x = 5 + this.m.getX();
            int y = 16 + this.m.getY();
            ResourceLocation atlasTexture = null;
            Vec2i filterButtonTextureOffset = Vec2i.ZERO;
            if (this.u != null) {
                filterButtonTextureOffset = this.u.getFilterButtonTextureOffset();
                atlasTexture = this.u.getAtlasTexture();
            }
            bVar.a(1002, new C(bVar.getGuiLeft() + x, bVar.getGuiTop() + y, 10, 10, e("S"), button -> {
                a(!w());
            }, atlasTexture, filterButtonTextureOffset).a("gui.mctech.filter.button"));
        }
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(GuiGraphics guiGraphics, int i, int i2, float f) {
        this.q.c(a());
        int guiLeft = (this.q.getGuiLeft() - (this.u == null ? 118 : this.u.getFilterGuiSize().getX())) + this.l.getX();
        int guiTop = this.q.getGuiTop() + this.l.getY();
        this.q.b(guiGraphics, guiLeft, guiTop, 0.0f, 0.0f, this.u == null ? 118 : this.u.getFilterGuiSize().getX(), this.u == null ? 132 : this.u.getFilterGuiSize().getY());
        this.q.b(guiGraphics, this.d, guiLeft + 57, guiTop + 8, this.u == null ? mctech.m.d.b.a : 16777215);
        Lighting.setupFor3DItems();
        int iB = this.j.b();
        for (int i3 = 0; i3 < 25 && this.i.size() > i3 + iB; i3++) {
            int x = (this.u == null ? 0 : this.u.getFilterItemsOffset().getX()) + guiLeft + 6 + (18 * (i3 % 5));
            int y = (this.u == null ? 0 : this.u.getFilterItemsOffset().getY()) + guiTop + 37 + (18 * (i3 / 5));
            guiGraphics.renderItem(this.i.get(i3 + iB), x, y);
            guiGraphics.renderItemDecorations(this.q.j(), this.i.get(i3 + iB), x, y, "");
            if (i + this.q.getGuiLeft() >= x && i + this.q.getGuiLeft() <= x + 16 && i2 + this.q.getGuiTop() >= y && i2 + this.q.getGuiTop() <= y + 16) {
                RenderSystem.disableDepthTest();
                RenderSystem.colorMask(true, true, true, false);
                int slotColor = this.q.getSlotColor(0);
                RenderSystem.enableBlend();
                RenderSystem.defaultBlendFunc();
                this.q.a(guiGraphics, x, y, 16.0f, 16.0f, slotColor);
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
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        guiGraphics.pose().translate(0.0d, 0.0d, 100.0d);
        if (this.f != null) {
            this.q.a(guiGraphics, this.f.a(), this.f.b(), this.f.c(), this.f.d(), -2130720768);
        }
        for (mctech.m.g.n nVar : ((S) this.q.getMenu()).slots) {
            if (nVar.isActive() && (nVar instanceof mctech.m.g.n)) {
                if (nVar.ae_() == (this.e ? mctech.m.g.n.a.NORMAL : mctech.m.g.n.a.FILTER) && (this.f == null || ((Slot) nVar).x - 2 != this.f.a() || ((Slot) nVar).y - 2 != this.f.b())) {
                    int iO = ((mctech.m.a.j) nVar).o();
                    this.q.a(guiGraphics, ((Slot) nVar).x - 2, ((Slot) nVar).y - 2, iO + 4.0f, iO + 4.0f, -2145473563);
                }
            }
        }
        guiGraphics.pose().translate(0.0d, 0.0d, -100.0d);
        RenderSystem.disableBlend();
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(GuiGraphics guiGraphics, int i, int i2, Consumer<Component> consumer) {
        int iB = this.j.b();
        for (int i3 = 0; i3 < 25 && this.i.size() > i3 + iB; i3++) {
            int x = (-113) + (18 * (i3 % 5)) + this.l.getX();
            int y = 37 + (18 * (i3 / 5)) + this.l.getY();
            if (i >= x && i <= x + 16 && i2 >= y && i2 <= y + 16) {
                Iterator it = this.i.get(i3 + iB).getTooltipLines(Item.TooltipContext.of((Level) null), this.q.f(), TooltipFlag.Default.NORMAL).iterator();
                while (it.hasNext()) {
                    consumer.accept((Component) it.next());
                }
            }
        }
        for (mctech.m.g.n nVar : ((S) this.q.getMenu()).slots) {
            if (nVar.isActive() && (nVar instanceof mctech.m.g.n)) {
                mctech.m.g.n nVar2 = nVar;
                int iO = ((mctech.m.a.j) nVar).o();
                if (nVar2.ae_() == (this.e ? mctech.m.g.n.a.NORMAL : mctech.m.g.n.a.FILTER) && ((Slot) nVar).x <= i && ((Slot) nVar).x + iO >= i && ((Slot) nVar).y <= i2 && ((Slot) nVar).y + iO >= i2) {
                    if (this.f != null && ((Slot) nVar).x - 2 == this.f.a() && ((Slot) nVar).y - 2 == this.f.b()) {
                        consumer.accept(b);
                    } else {
                        consumer.accept(c);
                    }
                }
            }
        }
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public boolean a(int i, int i2, int i3) {
        if (this.o.a(i, i2)) {
            if (this.f != null && !this.e) {
                int iB = this.j.b();
                for (int i4 = 0; i4 < 25 && this.i.size() > i4 + iB; i4++) {
                    int iA = this.o.a() + 6 + (18 * (i4 % 5));
                    int iB2 = this.o.b() + 37 + (18 * (i4 / 5));
                    if (i >= iA && i <= iA + 18 && i2 >= iB2 && i2 <= iB2 + 18) {
                        this.f.b(this.i.get(i4 + iB));
                        a(false);
                        return true;
                    }
                }
            }
            GuiEventListener guiEventListenerG = this.q.g(this.e ? 1001 : 1000);
            int i5 = ((-this.l.getX()) - i) + 10;
            int i6 = ((-this.l.getY()) - i2) + 20;
            if (i5 <= guiEventListenerG.getX() && i6 <= 0 && i5 > guiEventListenerG.getX() - guiEventListenerG.getWidth() && i6 > (-guiEventListenerG.getHeight())) {
                this.q.setFocused(guiEventListenerG);
                return true;
            }
            this.q.setFocused(null);
            return false;
        }
        this.q.setFocused(null);
        if (this.q.a(i, i2)) {
            return false;
        }
        mctech.m.g.n slotUnderMouse = this.q.getSlotUnderMouse();
        if (slotUnderMouse instanceof mctech.m.g.n) {
            mctech.m.g.n nVar = slotUnderMouse;
            if (nVar.ae_() == mctech.m.g.n.a.FILTER && !slotUnderMouse.hasItem() && ((S) this.q.getMenu()).getCarried().isEmpty()) {
                return false;
            }
            if (this.e && nVar.ae_() == mctech.m.g.n.a.NORMAL) {
                return false;
            }
        }
        if (w() && !this.e) {
            a(false);
            return true;
        }
        return w();
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public boolean b(int i, int i2, int i3) {
        if (!this.j.a(i, i2) && this.o.a(i, i2)) {
            this.j.b(i, i2, i3);
            return false;
        }
        return false;
    }

    public void a(String str) {
        String lowerCase = str.toLowerCase(Locale.ROOT);
        if (lowerCase.equalsIgnoreCase(this.k)) {
            return;
        }
        this.k = lowerCase;
        this.i.clear();
        int size = this.g.size();
        for (int i = 0; i < size; i++) {
            if (this.h.get(i).contains(lowerCase)) {
                this.i.add(this.g.get(i));
            }
        }
        this.j.c(this.i.size());
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public boolean b_(int i) {
        if (w()) {
            if (i == 69) {
                if (this.q.g(this.e ? 1001 : 1000).isFocused()) {
                    return true;
                }
            }
            if (i == 256) {
                a_(false);
                this.j.a_(false);
                this.q.g(this.e ? 1001 : 1000).visible = false;
                return true;
            }
        }
        return super.b_(i);
    }

    @OnlyIn(Dist.CLIENT)
    public void g() {
        this.q.b();
        a_(false);
        this.j.a_(false);
        this.q.g(this.e ? 1001 : 1000).visible = false;
        a((j) null);
    }

    @OnlyIn(Dist.CLIENT)
    public void a(boolean z) {
        if (!this.t) {
            this.q.b();
        } else if (!z) {
            a((j) null);
        }
        a_(z);
        this.j.a_(z);
        this.q.g(this.e ? 1001 : 1000).visible = z;
    }

    @Override // mctech.m.d.b.a
    @OnlyIn(Dist.CLIENT)
    public void c(mctech.m.d.b bVar) {
        a_(false);
        this.j.a_(false);
        this.q.g(this.e ? 1001 : 1000).visible = false;
        a((j) null);
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/b/g$a.class */
    public static class a extends mctech.m.d.a.a {
        g a;

        public a(g gVar) {
            super(mctech.utils.math.geometry.b.a);
            this.a = gVar;
        }

        @Override // mctech.m.d.a.a
        public boolean a(int i, int i2) {
            return !this.a.e || this.a.w();
        }

        @Override // mctech.m.d.a.a
        protected void a(Set<mctech.m.d.a.a.EnumC0027a> set) {
            set.add(mctech.m.d.a.a.EnumC0027a.MOUSE_INPUT);
        }

        @Override // mctech.m.d.a.a
        @OnlyIn(Dist.CLIENT)
        public boolean a(int i, int i2, int i3) {
            mctech.m.g.n slotUnderMouse = this.q.getSlotUnderMouse();
            if (slotUnderMouse instanceof mctech.m.g.n) {
                mctech.m.g.n nVar = slotUnderMouse;
                if ((nVar.ae_() == mctech.m.g.n.a.FILTER && !slotUnderMouse.hasItem() && ((S) this.q.getMenu()).getCarried().isEmpty()) || (this.a.e && nVar.ae_() == mctech.m.g.n.a.NORMAL)) {
                    this.a.a(j.a(slotUnderMouse));
                    return true;
                }
            }
            return super.a(i, i2, i3);
        }
    }
}
