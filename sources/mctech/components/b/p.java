package mctech.components.b;

import com.mojang.blaze3d.systems.RenderSystem;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.regex.Pattern;
import mctech.api.util.ILocation;
import mctech.components.a.C0091d;
import mctech.components.a.C0101n;
import mctech.components.a.E;
import mctech.components.a.K;
import mctech.init.MCTechLang;
import mctech.m.b.S;
import mctech.utils.math.geometry.Vec2i;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.texture.MissingTextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.network.PacketDistributor;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/b/p.class */
public class p extends mctech.m.d.a.a implements mctech.m.d.b.a {
    private static final int a = 3000;
    private static final int b = 3001;
    private static final int c = 3002;
    private static final int d = 3003;
    private static final int e = 3004;
    private static final int f = 3005;
    private static final int g = 3006;
    private static final int h = 3007;
    private static final int i = 3008;
    private static final int j = 3009;
    private final ILocation k;
    private final Vec2i l;
    private mctech.a.b.c.a<?> m;
    private static final Pattern n = Pattern.compile("[+\\-*/()\\d\\s.]+");
    private String s;
    private boolean t;
    private int u;
    private E v;
    private mctech.utils.math.geometry.b w;
    private ResourceLocation x;

    public p(E e2, ILocation iLocation, Vec2i vec2i) {
        super(new mctech.utils.math.geometry.b((-118) + vec2i.getX(), vec2i.getY(), 118, 67));
        this.s = "";
        this.t = false;
        this.u = 0;
        this.v = e2;
        this.k = iLocation;
        this.l = vec2i;
        this.w = mctech.utils.math.geometry.b.a;
        this.x = C0101n.f.a();
        a_(false);
    }

    public p a(ResourceLocation resourceLocation) {
        this.x = resourceLocation;
        return this;
    }

    public void a(mctech.a.b.c.a<?> aVar) {
        if (this.m == aVar) {
            return;
        }
        this.m = aVar;
        this.u = aVar == null ? 0 : aVar.g();
        this.s = String.valueOf(this.u);
        a();
        if (this.q != null) {
            GuiEventListener guiEventListener = (AbstractWidget) this.q.m().get(a);
            if (guiEventListener instanceof EditBox) {
                GuiEventListener guiEventListener2 = (EditBox) guiEventListener;
                guiEventListener2.setValue(this.s);
                this.q.setFocused(guiEventListener2);
            }
            b(this.q);
        }
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(mctech.m.d.b bVar) {
        this.w = new mctech.utils.math.geometry.b(bVar.getGuiLeft() + this.o.a() + this.l.getX() + 14, bVar.getGuiTop() + this.o.b() + this.l.getY() + 25, 16, 16);
        int guiLeft = bVar.getGuiLeft() + this.o.a() + this.l.getX();
        int guiTop = bVar.getGuiTop() + this.o.b() + this.l.getY();
        bVar.a(b, a(guiLeft + 11, guiTop + 10, 0, 152, button -> {
            a(1);
        }));
        bVar.a(c, a(guiLeft + 36, guiTop + 10, 0, 161, button2 -> {
            a(10);
        }));
        bVar.a(d, a(guiLeft + 61, guiTop + 10, 0, 170, button3 -> {
            a(100);
        }));
        bVar.a(e, a(guiLeft + 86, guiTop + 10, 0, 179, button4 -> {
            a(1000);
        }));
        bVar.a(f, a(guiLeft + 11, guiTop + 47, 23, 152, button5 -> {
            a(-1);
        }));
        bVar.a(g, a(guiLeft + 36, guiTop + 47, 23, 161, button6 -> {
            a(-10);
        }));
        bVar.a(h, a(guiLeft + 61, guiTop + 47, 23, 170, button7 -> {
            a(-100);
        }));
        bVar.a(i, a(guiLeft + 86, guiTop + 47, 23, 179, button8 -> {
            a(-1000);
        }));
        bVar.a(j, a(guiLeft + 86, guiTop + 28, 0, 143, button9 -> {
            b();
        }));
        EditBox editBoxA = bVar.a(a, new EditBox(bVar.j(), guiLeft + 38, guiTop + 29, 47, 16, Component.empty()));
        editBoxA.setMaxLength(6);
        editBoxA.setBordered(false);
        editBoxA.setCanLoseFocus(true);
        editBoxA.setVisible(false);
        editBoxA.setResponder(this::a);
        b(bVar);
    }

    private void a(AbstractWidget abstractWidget, boolean z) {
        abstractWidget.active = z;
        abstractWidget.visible = z;
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void b(mctech.m.d.b bVar) {
        a(bVar.g(b), w());
        a(bVar.g(c), w());
        a(bVar.g(d), w());
        a(bVar.g(e), w());
        a(bVar.g(f), w());
        a(bVar.g(g), w());
        a(bVar.g(h), w());
        a(bVar.g(i), w());
        a(bVar.g(j), w());
        a(bVar.g(a), w());
    }

    private Component a(Component component, long j2) {
        return component.plainCopy().append(String.valueOf(j2));
    }

    private void a(String str) {
        this.s = str;
        a();
    }

    private void a() {
        if (this.m == null) {
            this.t = false;
            return;
        }
        try {
            if (n.matcher(this.s).matches() && !this.s.trim().isEmpty()) {
                int iB = b(this.s);
                if (iB < this.m.i() || iB > this.m.h()) {
                    this.t = false;
                } else {
                    this.t = true;
                    this.u = iB;
                }
            } else {
                this.t = false;
            }
        } catch (Exception e2) {
            this.t = false;
        }
        EditBox editBoxG = this.q.g(a);
        if (editBoxG instanceof EditBox) {
            editBoxG.setTextColor(this.t ? 16777215 : 16733525);
        }
    }

    private int b(String str) {
        String strReplaceAll = str.replaceAll("\\s", "");
        if (strReplaceAll.isEmpty()) {
            return 0;
        }
        try {
            return Integer.parseInt(strReplaceAll);
        } catch (NumberFormatException e2) {
            try {
                return new BigDecimal(strReplaceAll).intValue();
            } catch (Exception e3) {
                throw new RuntimeException("Invalid expression");
            }
        }
    }

    private void a(int i2) {
        if (this.m == null) {
            return;
        }
        int iMax = Math.max(this.m.i(), Math.min(this.m.h(), Math.addExact(this.u, i2)));
        this.u = iMax;
        this.s = String.valueOf(iMax);
        EditBox editBoxG = this.q.g(a);
        if (editBoxG instanceof EditBox) {
            editBoxG.setValue(this.s);
        }
        a();
    }

    private void b() {
        if (this.m != null && this.t) {
            this.m.a(this.u);
            if (FMLEnvironment.dist.isClient()) {
                PacketDistributor.sendToServer(new mctech.q.d.e(this.k.getPosition(), this.m.a(), this.u, this.m instanceof mctech.a.b.e.a), new CustomPacketPayload[0]);
            }
        }
    }

    @Override // mctech.m.d.b.a
    @OnlyIn(Dist.CLIENT)
    public void c(mctech.m.d.b bVar) {
        a_(false);
        b(bVar);
        a((mctech.a.b.c.a<?>) null);
    }

    @Override // mctech.m.d.a.a
    public void a_(boolean z) {
        super.a_(z);
        a((mctech.a.b.c.a<?>) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // mctech.m.d.a.a
    public boolean a(int i2, int i3, int i4) {
        if (i4 == 1 && this.m != null && new mctech.utils.math.geometry.b(this.m.c(), this.m.d(), this.m.e(), this.m.f()).a(i2, i3)) {
            PacketDistributor.sendToServer(new mctech.q.d.e(this.k.getPosition(), this.m.a(), 0, this.m instanceof mctech.a.b.e.a), new CustomPacketPayload[0]);
            a((mctech.a.b.c.a<?>) null);
            return true;
        }
        mctech.a.b.e.a slotUnderMouse = this.q.getSlotUnderMouse();
        if (slotUnderMouse instanceof mctech.a.b.e.a) {
            mctech.a.b.e.a aVar = slotUnderMouse;
            if (((S) this.q.getMenu()).getCarried().isEmpty() && aVar.hasItem()) {
                a(aVar);
                return true;
            }
        }
        mctech.m.d.b bVar = this.q;
        if (bVar instanceof mctech.m.d.a) {
            for (mctech.m.d.a.a aVar2 : ((mctech.m.d.a) bVar).a()) {
                if (aVar2 instanceof mctech.a.b.c.a) {
                    mctech.a.b.c.a<?> aVar3 = (mctech.a.b.c.a) aVar2;
                    if (aVar2.a(i2, i3)) {
                        a(aVar3);
                        return true;
                    }
                }
            }
        }
        return super.a(i2, i3, i4);
    }

    public void b(GuiGraphics guiGraphics, int i2, int i3) {
        ArrayList arrayList = new ArrayList();
        mctech.a.b.e.a slotUnderMouse = this.q.getSlotUnderMouse();
        if (slotUnderMouse instanceof mctech.a.b.e.a) {
            mctech.a.b.e.a aVar = slotUnderMouse;
            if ((this.m != null && ((Slot) slotUnderMouse).x - 2 == this.m.c() && ((Slot) slotUnderMouse).y - 2 == this.m.d()) && aVar.hasItem()) {
                arrayList.addAll(Screen.getTooltipFromItem(this.q.getMinecraft(), aVar.getItem()));
                arrayList.add(MCTechLang.QUANTITY_RIGHT_CLICK_TIP);
                arrayList.add(mctech.g.d.e.h.a(MCTechLang.QUANTITY_VALID_RANGE, Integer.valueOf(aVar.i()), Integer.valueOf(aVar.h())));
            } else if (aVar.hasItem()) {
                arrayList.addAll(Screen.getTooltipFromItem(this.q.getMinecraft(), aVar.getItem()));
                arrayList.add(MCTechLang.QUANTITY_RIGHT_CLICK_TIP);
                arrayList.add(MCTechLang.QUANTITY_MIDDLE_CLICK_TIP);
            } else {
                arrayList.add(MCTechLang.QUANTITY_PLACE_ITEM);
            }
        } else if (this.m != null && this.w.a(i2, i3) && w()) {
            mctech.a.b.c.a<?> aVar2 = this.m;
            if (aVar2 instanceof mctech.a.b.e.a) {
                arrayList.addAll(Screen.getTooltipFromItem(this.q.getMinecraft(), ((mctech.a.b.e.a) aVar2).getItem()));
            } else {
                mctech.a.b.c.a<?> aVar3 = this.m;
                if (aVar3 instanceof C0091d) {
                    arrayList.add(Component.translatable(((C0091d) aVar3).b().getDescriptionId()));
                }
            }
        }
        if (this.o.a(i2, i3) && !this.t && !this.s.isEmpty()) {
            arrayList.clear();
            arrayList.add(MCTechLang.QUANTITY_INVALID.withStyle(ChatFormatting.RED));
            if (this.m != null) {
                arrayList.add(mctech.g.d.e.h.a(MCTechLang.QUANTITY_VALID_RANGE, Integer.valueOf(this.m.i()), Integer.valueOf(this.m.h())).withStyle(ChatFormatting.YELLOW));
            }
        }
        if (!arrayList.isEmpty()) {
            guiGraphics.renderTooltip(this.q.j(), arrayList, Optional.empty(), i2, i3);
        }
    }

    private List<mctech.a.b.c.a<?>> d() {
        ArrayList arrayList = new ArrayList();
        for (mctech.a.b.c.a aVar : ((S) this.q.getMenu()).slots) {
            if (aVar instanceof mctech.a.b.c.a) {
                arrayList.add(aVar);
            }
        }
        mctech.m.d.b bVar = this.q;
        if (bVar instanceof mctech.m.d.a) {
            for (mctech.utils.e.b bVar2 : ((mctech.m.d.a) bVar).a()) {
                if (bVar2 instanceof mctech.a.b.c.a) {
                    arrayList.add((mctech.a.b.c.a) bVar2);
                }
            }
        }
        return arrayList;
    }

    @Override // mctech.m.d.a.a
    protected void a(Set<mctech.m.d.a.a.EnumC0027a> set) {
        set.add(mctech.m.d.a.a.EnumC0027a.GUI_TICK);
        set.add(mctech.m.d.a.a.EnumC0027a.GUI_INIT);
        set.add(mctech.m.d.a.a.EnumC0027a.DRAW_BACKGROUND);
        set.add(mctech.m.d.a.a.EnumC0027a.DRAW_FOREGROUND);
        set.add(mctech.m.d.a.a.EnumC0027a.MOUSE_INPUT);
        set.add(mctech.m.d.a.a.EnumC0027a.MOUSE_SCROLL);
        set.add(mctech.m.d.a.a.EnumC0027a.KEY_INPUT);
    }

    @Override // mctech.m.d.a.a
    public boolean a(int i2, int i3) {
        return true;
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(GuiGraphics guiGraphics, int i2, int i3, float f2) {
        if (!w()) {
            return;
        }
        this.q.c(this.x);
        this.q.b(guiGraphics, (this.q.getGuiLeft() - 118) + this.l.getX(), this.q.getGuiTop() + this.l.getY(), 0.0f, 189.0f, 118.0f, 67.0f);
        this.q.c(C0101n.a.a());
        if (this.m != null) {
            Object objB = this.m.b();
            if (objB instanceof ItemStack) {
                ItemStack itemStack = (ItemStack) objB;
                guiGraphics.renderItem(itemStack, this.w.a(), this.w.b());
                guiGraphics.renderItemDecorations(this.q.j(), itemStack, this.w.a(), this.w.b(), itemStack.isDamageableItem() ? "" : String.valueOf(itemStack.getCount()));
                return;
            }
            Object objB2 = this.m.b();
            if (objB2 instanceof FluidStack) {
                FluidStack fluidStack = (FluidStack) objB2;
                if (!fluidStack.isEmpty()) {
                    Function textureAtlas = this.q.getMinecraft().getTextureAtlas(InventoryMenu.BLOCK_ATLAS);
                    IClientFluidTypeExtensions iClientFluidTypeExtensionsOf = IClientFluidTypeExtensions.of(fluidStack.getFluid());
                    TextureAtlasSprite textureAtlasSprite = (TextureAtlasSprite) textureAtlas.apply(iClientFluidTypeExtensionsOf.getStillTexture(fluidStack));
                    if (textureAtlasSprite != textureAtlas.apply(MissingTextureAtlasSprite.getLocation())) {
                        this.q.c(InventoryMenu.BLOCK_ATLAS);
                        RenderSystem.enableBlend();
                        mctech.m.d.b.a(guiGraphics, this.w.a(), this.w.b(), 0.0f, textureAtlasSprite, iClientFluidTypeExtensionsOf.getTintColor(fluidStack), this.w.d(), this.w.c(), this.w.d(), this.w.c());
                        this.q.c();
                    }
                }
            }
        }
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(GuiGraphics guiGraphics, int i2, int i3) {
        if (w()) {
            RenderSystem.enableBlend();
            RenderSystem.defaultBlendFunc();
            guiGraphics.pose().translate(0.0d, 0.0d, 100.0d);
            d().stream().filter((v0) -> {
                return v0.l();
            }).forEach(aVar -> {
                this.q.a(guiGraphics, aVar.c(), aVar.d(), aVar.e(), aVar.f(), this.m != null && aVar.c() == this.m.c() && aVar.d() == this.m.d() ? 268500736 : 268435711);
            });
            guiGraphics.pose().translate(0.0d, 0.0d, -100.0d);
            RenderSystem.disableBlend();
            b(guiGraphics, i2, i3);
        }
    }

    private K a(int i2, int i3, int i4, int i5, Button.OnPress onPress) {
        return new K(i2, i3, 23, 9, this.x, new mctech.utils.math.geometry.b(i4, i5, 23, 9), onPress).b(false).a(mctech.utils.c.h.i, mctech.utils.c.h.i);
    }
}
