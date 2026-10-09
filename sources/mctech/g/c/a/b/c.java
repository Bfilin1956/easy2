package mctech.g.c.a.b;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.function.Supplier;
import mctech.g.b.a.o;
import mctech.init.MCTechLang;
import mctech.v.l;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.components.Tooltip;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FastColor;
import net.minecraft.world.item.component.TooltipProvider;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.network.PacketDistributor;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/c/a/b/c.class */
public class c extends mctech.g.a.j.d<mctech.g.d.a.d.c.b> {
    @Override // mctech.g.a.j.d, mctech.g.a.j.c
    public void a(mctech.g.a.j.a<mctech.g.d.a.d.c.b> aVar, GuiGraphics guiGraphics, int i, int i2, Font font, int i3, int i4, int i5, int i6) {
        super.a(aVar, guiGraphics, i, i2, font, i3, i4, i5, i6);
        TooltipProvider tooltipProviderA = aVar.a();
        if ((tooltipProviderA instanceof mctech.g.d.a.d.c.a) && ((mctech.g.d.a.d.c.a) tooltipProviderA).q()) {
            l.a(guiGraphics, font, (Component) Component.literal(String.format("Приоритет: %s", Integer.valueOf(((mctech.g.d.a.d.c.b) aVar.c()).k()))), i5, i6, i + 80, i2 + 77, mctech.g.c.a.d.b);
        }
        l.a(guiGraphics, font, (Component) Component.literal("Режим работы:"), i5, i6, i + 105 + 75, i2 + 77, mctech.g.c.a.d.b);
    }

    private int a() {
        if (Screen.hasControlDown()) {
            return 100;
        }
        if (Screen.hasShiftDown()) {
            return 10;
        }
        return 1;
    }

    @Override // mctech.g.a.j.d
    public void c(mctech.g.a.j.b bVar, int i, int i2, mctech.g.a.j.a<mctech.g.d.a.d.c.b> aVar) {
        super.c(bVar, i, i2, aVar);
        TooltipProvider tooltipProviderA = aVar.a();
        if ((tooltipProviderA instanceof mctech.g.d.a.d.c.a) && !((mctech.g.d.a.d.c.a) tooltipProviderA).p()) {
            bVar.a(new a(i + 2, i2 + 9, () -> {
                return a((mctech.g.a.j.a<mctech.g.d.a.d.c.b>) aVar);
            }, () -> {
                PacketDistributor.sendToServer(new o(aVar.b()), new CustomPacketPayload[0]);
            }));
        } else {
            bVar.a(i + 2, i2 + 9, Component.literal("Канал импорта"), () -> {
                return ((mctech.g.d.a.d.c.b) aVar.c()).g();
            }, dyeColor -> {
                aVar.a(bVar2 -> {
                    return bVar2.a(dyeColor);
                });
            });
        }
        TooltipProvider tooltipProviderA2 = aVar.a();
        if ((tooltipProviderA2 instanceof mctech.g.d.a.d.c.a) && ((mctech.g.d.a.d.c.a) tooltipProviderA2).q()) {
            bVar.a(i + 83, i2 + 71, 9, 9, Component.empty(), mctech.g.c.a.d.c, () -> {
                aVar.a(bVar2 -> {
                    return bVar2.a(bVar2.k() + a());
                });
            }).a(67, 247).setTooltip(Tooltip.create(Component.literal("Нажмите вместе с\n").append(Component.literal("Ctrl").withStyle(ChatFormatting.GREEN)).append(" - чтобы x100\n").append(Component.literal("Shift").withStyle(ChatFormatting.AQUA)).append(" - чтобы x10")));
            bVar.a(i + 83, i2 + 80, 9, 9, Component.empty(), mctech.g.c.a.d.c, () -> {
                aVar.a(bVar2 -> {
                    return bVar2.a(bVar2.k() - a());
                });
            }).a(76, 247).setTooltip(Tooltip.create(Component.literal("Нажмите вместе с\n").append(Component.literal("Ctrl").withStyle(ChatFormatting.GREEN)).append(" - чтобы x100\n").append(Component.literal("Shift").withStyle(ChatFormatting.AQUA)).append(" - чтобы x10")));
        }
        bVar.a(i + 80, i2 + 22, 1);
    }

    @Override // mctech.g.a.j.d
    public void d(mctech.g.a.j.b bVar, int i, int i2, mctech.g.a.j.a<mctech.g.d.a.d.c.b> aVar) {
        super.d(bVar, i, i2, aVar);
        TooltipProvider tooltipProviderA = aVar.a();
        if ((tooltipProviderA instanceof mctech.g.d.a.d.c.a) && ((mctech.g.d.a.d.c.a) tooltipProviderA).p()) {
            bVar.a((i + 92) - 15, i2 + 9, Component.literal("Канал экспорта"), () -> {
                return ((mctech.g.d.a.d.c.b) aVar.c()).h();
            }, dyeColor -> {
                aVar.a(bVar2 -> {
                    return bVar2.b(dyeColor);
                });
            });
        }
        mctech.g.c.a.c.b bVarA = bVar.a((i + 92) - 11, (i2 + 75) - 11, MCTechLang.GUI_REDSTONE_CHANNEL, () -> {
            return ((mctech.g.d.a.d.c.b) aVar.c()).j();
        }, dyeColor2 -> {
            aVar.a(bVar2 -> {
                return bVar2.c(dyeColor2);
            });
        }).a(9, 9);
        bVar.a(() -> {
            bVarA.visible = ((mctech.g.d.a.d.c.b) aVar.c()).i().a();
        });
        bVar.b((i + 92) - 13, i2 + 75, MCTechLang.GUI_REDSTONE_MODE, () -> {
            return ((mctech.g.d.a.d.c.b) aVar.c()).i();
        }, aVar2 -> {
            aVar.a(bVar2 -> {
                return bVar2.a(aVar2);
            });
        });
        bVar.a(i + 2, i2 + 22, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mctech.g.a.j.d
    public mctech.g.d.a.d.c.b a(mctech.g.d.a.d.c.b bVar, boolean z) {
        return bVar.a(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mctech.g.a.j.d
    public mctech.g.d.a.d.c.b b(mctech.g.d.a.d.c.b bVar, boolean z) {
        return bVar.b(z);
    }

    private Fluid a(mctech.g.a.j.a<mctech.g.d.a.d.c.b> aVar) {
        CompoundTag compoundTagD = aVar.d();
        if (compoundTagD == null) {
            return Fluids.EMPTY;
        }
        if (!compoundTagD.contains("LockedFluid")) {
            return Fluids.EMPTY;
        }
        return (Fluid) BuiltInRegistries.FLUID.get(ResourceLocation.parse(compoundTagD.getString("LockedFluid")));
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/c/a/b/c$a.class */
    private static class a extends AbstractWidget {
        private final Runnable a;
        private final Supplier<Fluid> b;

        a(int i, int i2, Supplier<Fluid> supplier, Runnable runnable) {
            super(i, i2, 13, 13, Component.empty());
            this.a = runnable;
            this.b = supplier;
        }

        public void updateWidgetNarration(@NotNull NarrationElementOutput narrationElementOutput) {
        }

        public void renderWidget(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
            MutableComponent mutableComponentAppend;
            if (isHoveredOrFocused()) {
                if (this.b.get().isSame(Fluids.EMPTY)) {
                    mutableComponentAppend = Component.literal("Принимает любые жидкости");
                } else {
                    mutableComponentAppend = Component.literal("Принимает жидкость:\n").append(this.b.get().getFluidType().getDescription().copy().withStyle(ChatFormatting.GOLD)).append("\n\nНажмите что бы сбросить");
                }
                setTooltip(Tooltip.create(mutableComponentAppend));
            }
            if (isMouseOver(i, i2)) {
                guiGraphics.pose().pushPose();
                guiGraphics.pose().translate(0.0f, 0.0f, 399.0f);
                guiGraphics.fill(getX() - 1, getY() - 1, getX() + getWidth() + 1, getY(), -1);
                guiGraphics.fill(getX() - 1, getY() + getHeight(), getX() + getWidth() + 1, getY() + getHeight() + 1, -1);
                guiGraphics.fill(getX() - 1, getY() - 1, getX(), getY() + getHeight() + 1, -1);
                guiGraphics.fill(getX() + getWidth(), getY() - 1, getX() + getWidth() + 1, getY() + getHeight() + 1, -1);
                guiGraphics.pose().popPose();
            }
            RenderSystem.enableBlend();
            RenderSystem.defaultBlendFunc();
            RenderSystem.enableDepthTest();
            guiGraphics.fill(getX(), getY(), getX() + getWidth(), getY() + getHeight(), -14145496);
            guiGraphics.fill(getX(), getY(), getX() + getWidth(), getY() + 2, -13027015);
            guiGraphics.fill(getX() + 1, getY() + 1, (getX() + getWidth()) - 1, (getY() + getHeight()) - 1, -15000805);
            guiGraphics.setColor(1.0f, 1.0f, 1.0f, 1.0f);
            if (this.b.get().isSame(Fluids.EMPTY)) {
                return;
            }
            IClientFluidTypeExtensions iClientFluidTypeExtensionsOf = IClientFluidTypeExtensions.of(this.b.get());
            ResourceLocation stillTexture = iClientFluidTypeExtensionsOf.getStillTexture();
            TextureAtlas texture = Minecraft.getInstance().getTextureManager().getTexture(TextureAtlas.LOCATION_BLOCKS);
            if (texture instanceof TextureAtlas) {
                TextureAtlasSprite sprite = texture.getSprite(stillTexture);
                int tintColor = iClientFluidTypeExtensionsOf.getTintColor();
                RenderSystem.setShaderColor(FastColor.ARGB32.red(tintColor) / 255.0f, FastColor.ARGB32.green(tintColor) / 255.0f, FastColor.ARGB32.blue(tintColor) / 255.0f, FastColor.ARGB32.alpha(tintColor) / 255.0f);
                RenderSystem.enableBlend();
                int iWidth = (int) (sprite.contents().width() / (sprite.getU1() - sprite.getU0()));
                int iHeight = (int) (sprite.contents().height() / (sprite.getV1() - sprite.getV0()));
                guiGraphics.blit(TextureAtlas.LOCATION_BLOCKS, getX() + 1, getY() + 1, 0, sprite.getU0() * iWidth, sprite.getV0() * iHeight, 11, 11, iWidth, iHeight);
                RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
            }
            RenderSystem.disableBlend();
            RenderSystem.disableDepthTest();
        }

        public void onClick(double d, double d2) {
            this.a.run();
        }
    }
}
