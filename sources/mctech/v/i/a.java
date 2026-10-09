package mctech.v.i;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipComponent;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FastColor;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.fluids.FluidStack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/i/a.class */
public class a<T> implements ClientTooltipComponent {
    private final List<T> a;

    public a(@NotNull b<T> bVar) {
        this.a = bVar.a().stream().filter(obj -> {
            if (obj instanceof ItemStack) {
                return !((ItemStack) obj).isEmpty();
            }
            return (obj instanceof FluidStack) && !((FluidStack) obj).isEmpty();
        }).toList();
    }

    public int getHeight() {
        return b() * 20;
    }

    public int getWidth(@NotNull Font font) {
        return (a() * 18) + 2;
    }

    public void renderImage(@NotNull Font font, int i, int i2, @NotNull GuiGraphics guiGraphics) {
        int iA = a();
        int iB = b();
        int i3 = 0;
        for (int i4 = 0; i4 < iB; i4++) {
            for (int i5 = 0; i5 < iA; i5++) {
                int i6 = i3;
                i3++;
                a(i + (i5 * 18) + 1, i2 + (i4 * 20) + 1, i6, font, guiGraphics);
            }
        }
    }

    private void a(int i, int i2, int i3, @NotNull Font font, @NotNull GuiGraphics guiGraphics) {
        if (i3 >= 0 && i3 < this.a.size()) {
            T t = this.a.get(i3);
            if (t instanceof ItemStack) {
                ItemStack itemStack = (ItemStack) t;
                guiGraphics.renderItem(itemStack, i + 1, i2 + 1, i3);
                guiGraphics.renderItemDecorations(font, itemStack, i + 1, i2 + 1);
            }
            if (t instanceof FluidStack) {
                FluidStack fluidStack = (FluidStack) t;
                IClientFluidTypeExtensions iClientFluidTypeExtensionsOf = IClientFluidTypeExtensions.of(fluidStack.getFluid());
                ResourceLocation stillTexture = iClientFluidTypeExtensionsOf.getStillTexture(fluidStack);
                TextureAtlas texture = Minecraft.getInstance().getTextureManager().getTexture(TextureAtlas.LOCATION_BLOCKS);
                if (texture instanceof TextureAtlas) {
                    TextureAtlasSprite sprite = texture.getSprite(stillTexture);
                    int tintColor = iClientFluidTypeExtensionsOf.getTintColor();
                    RenderSystem.setShaderColor(FastColor.ARGB32.red(tintColor) / 255.0f, FastColor.ARGB32.green(tintColor) / 255.0f, FastColor.ARGB32.blue(tintColor) / 255.0f, FastColor.ARGB32.alpha(tintColor) / 255.0f);
                    RenderSystem.enableBlend();
                    int iWidth = (int) (sprite.contents().width() / (sprite.getU1() - sprite.getU0()));
                    int iHeight = (int) (sprite.contents().height() / (sprite.getV1() - sprite.getV0()));
                    guiGraphics.blit(TextureAtlas.LOCATION_BLOCKS, i + 1, i2 + 1, 16, 16, sprite.getU0() * iWidth, sprite.getV0() * iHeight, sprite.contents().width(), sprite.contents().height(), iWidth, iHeight);
                    RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
                }
            }
        }
    }

    private int a() {
        return Mth.clamp(this.a.size(), 1, 9);
    }

    private int b() {
        return (int) Math.ceil(((double) this.a.size()) / ((double) a()));
    }
}
