package mctech.g.c.a;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.datafixers.util.Pair;
import java.util.Locale;
import java.util.Objects;
import java.util.function.Function;
import mctech.MCTech;
import mctech.utils.c.h;
import mctech.utils.math.geometry.Vec2i;
import mctech.v.l;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FastColor;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.ClickType;
import net.minecraft.world.inventory.Slot;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.fluids.FluidStack;
import org.apache.commons.lang3.NotImplementedException;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/c/a/a.class */
public class a extends mctech.g.b.a<mctech.g.d.a.b.a.c> {
    private static final ResourceLocation e = MCTech.loc("textures/conduit/filters/filter_1x9.png");
    private static final ResourceLocation f = MCTech.loc("textures/conduit/filters/filter_2x9.png");
    private static final ResourceLocation g = MCTech.loc("textures/conduit/filters/filter_3x9.png");
    private static final ResourceLocation h = MCTech.loc("textures/conduit/filters/filter_4x9.png");
    protected Function<Boolean, Component> b;
    protected Function<Boolean, Component> c;
    private final ResourceLocation i;
    protected boolean d;

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.commons.lang3.NotImplementedException */
    public a(mctech.g.d.a.b.a.c cVar, Inventory inventory, Component component) throws NotImplementedException {
        super(cVar, inventory, component);
        this.b = bool -> {
            return a(new Pair<>("да", ChatFormatting.DARK_GREEN), new Pair<>("нет", ChatFormatting.DARK_RED), bool.booleanValue());
        };
        this.c = bool2 -> {
            return a(new Pair<>("черный", ChatFormatting.DARK_GRAY), new Pair<>("белый", ChatFormatting.WHITE), bool2.booleanValue());
        };
        this.imageWidth = 208;
        this.d = ((mctech.g.d.a.b.a.c) getMenu()).e.c();
        switch (cVar.e.a()) {
            case 1:
                this.i = e;
                this.imageHeight = 163;
                return;
            case 2:
                this.i = f;
                this.imageHeight = 181;
                return;
            case 3:
                this.i = g;
                this.imageHeight = 199;
                return;
            case 4:
                this.i = h;
                this.imageHeight = 217;
                return;
            default:
                throw new NotImplementedException();
        }
    }

    protected void init() {
        super.init();
        int guiLeft = getGuiLeft();
        int guiTop = getGuiTop() + 27 + (((mctech.g.d.a.b.a.c) this.menu).e.a() * 18);
        if (this.d) {
            ResourceLocation resourceLocation = this.i;
            mctech.g.d.a.b.a.c cVar = (mctech.g.d.a.b.a.c) getMenu();
            Objects.requireNonNull(cVar);
            addRenderableWidget(mctech.g.b.b.d.a(guiLeft + 159, guiTop + 2, 26, 7, resourceLocation, cVar::h, bool -> {
                a(2);
            }).a(bool2 -> {
                return new Vec2i(53, bool2.booleanValue() ? 221 : d.d);
            }).b(bool3 -> {
                return Component.literal("Сравнивает NBT: ").append(this.b.apply(bool3));
            }));
        }
        ResourceLocation resourceLocation2 = this.i;
        mctech.g.d.a.b.a.c cVar2 = (mctech.g.d.a.b.a.c) getMenu();
        Objects.requireNonNull(cVar2);
        addRenderableWidget(mctech.g.b.b.d.a(guiLeft + 159, guiTop + 14, 26, 7, resourceLocation2, cVar2::g, bool4 -> {
            a(1);
        }).a(bool5 -> {
            return new Vec2i(53, !bool5.booleanValue() ? 221 : d.d);
        }).b(bool6 -> {
            return Component.literal("Список: ").append(this.c.apply(bool6));
        }));
    }

    protected void renderBg(GuiGraphics guiGraphics, float f2, int i, int i2) {
        guiGraphics.blit(this.i, getGuiLeft(), getGuiTop(), 0, 0, this.imageWidth, this.imageHeight);
        int guiLeft = getGuiLeft();
        int guiTop = getGuiTop() + 27 + (((mctech.g.d.a.b.a.c) this.menu).e.a() * 18);
        if (this.d) {
            guiGraphics.blit(this.i, guiLeft + 159, guiTop + 2, 41, 12, 182.0f, 231.0f, 41, 12, h.i, h.i);
        }
        guiGraphics.blit(this.i, guiLeft + 159, guiTop + 10, 42, 11, 182.0f, 244.0f, 42, 11, h.i, h.i);
    }

    @Override // mctech.g.b.a
    protected void renderLabels(@NotNull GuiGraphics guiGraphics, int i, int i2) {
        super.renderLabels(guiGraphics, i, i2);
        int iA = 27 + (((mctech.g.d.a.b.a.c) this.menu).e.a() * 18);
        if (this.d) {
            l.a(guiGraphics, this.font, (Component) Component.literal("Сравнение NBT:"), getGuiLeft(), getGuiTop(), 0 + 157, iA + 1, d.b);
        }
        l.a(guiGraphics, this.font, (Component) Component.literal("Список:"), getGuiLeft(), getGuiTop(), 0 + 157, iA + 13, d.b);
        l.a(guiGraphics, this.font, Component.literal(getTitle().copy().getString().toUpperCase(Locale.ROOT)), getGuiLeft(), getGuiTop(), 26, 6, 156, d.b);
    }

    public void renderSlot(@NotNull GuiGraphics guiGraphics, @NotNull Slot slot) {
        super.renderSlot(guiGraphics, slot);
        if (slot instanceof mctech.g.d.a.b.a.d) {
            mctech.g.d.a.b.a.d dVar = (mctech.g.d.a.b.a.d) slot;
            if (this.minecraft == null) {
                return;
            }
            FluidStack fluidStackB = dVar.b();
            if (fluidStackB.isEmpty()) {
                return;
            }
            IClientFluidTypeExtensions iClientFluidTypeExtensionsOf = IClientFluidTypeExtensions.of(fluidStackB.getFluid());
            ResourceLocation stillTexture = iClientFluidTypeExtensionsOf.getStillTexture(fluidStackB);
            TextureAtlas texture = this.minecraft.getTextureManager().getTexture(TextureAtlas.LOCATION_BLOCKS);
            if (texture instanceof TextureAtlas) {
                TextureAtlasSprite sprite = texture.getSprite(stillTexture);
                int tintColor = iClientFluidTypeExtensionsOf.getTintColor();
                RenderSystem.setShaderColor(FastColor.ARGB32.red(tintColor) / 255.0f, FastColor.ARGB32.green(tintColor) / 255.0f, FastColor.ARGB32.blue(tintColor) / 255.0f, FastColor.ARGB32.alpha(tintColor) / 255.0f);
                RenderSystem.enableBlend();
                int iWidth = (int) (sprite.contents().width() / (sprite.getU1() - sprite.getU0()));
                int iHeight = (int) (sprite.contents().height() / (sprite.getV1() - sprite.getV0()));
                guiGraphics.blit(TextureAtlas.LOCATION_BLOCKS, slot.x, slot.y, 16, 16, sprite.getU0() * iWidth, sprite.getV0() * iHeight, sprite.contents().width(), sprite.contents().height(), iWidth, iHeight);
                RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
            }
        }
    }

    @Override // mctech.g.b.a
    protected boolean a(GuiGraphics guiGraphics, int i, int i2) {
        if (!((mctech.g.d.a.b.a.c) this.menu).getCarried().isEmpty()) {
            return false;
        }
        Slot slot = this.hoveredSlot;
        if (slot instanceof mctech.g.d.a.b.a.d) {
            FluidStack fluidStackB = ((mctech.g.d.a.b.a.d) slot).b();
            if (!fluidStackB.isEmpty()) {
                guiGraphics.renderTooltip(this.font, fluidStackB.getHoverName(), i, i2);
                return true;
            }
            return false;
        }
        return false;
    }

    protected void slotClicked(@NotNull Slot slot, int i, int i2, @NotNull ClickType clickType) {
        super.slotClicked(slot, i, i2, clickType);
    }

    @Override // mctech.g.b.a
    public boolean a(int i, int i2, int i3) {
        if (this.minecraft != null && i == 256 && this.minecraft.player != null) {
            a(0);
            return true;
        }
        return super.a(i, i2, i3);
    }

    protected Component a(Pair<String, ChatFormatting> pair, Pair<String, ChatFormatting> pair2, boolean z) {
        return z ? Component.literal((String) pair.getFirst()).withStyle((ChatFormatting) pair.getSecond()) : Component.literal((String) pair2.getFirst()).withStyle((ChatFormatting) pair2.getSecond());
    }
}
