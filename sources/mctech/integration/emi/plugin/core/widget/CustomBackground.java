package mctech.integration.emi.plugin.core.widget;

import dev.emi.emi.api.widget.Bounds;
import dev.emi.emi.api.widget.Widget;
import dev.emi.emi.api.widget.WidgetHolder;
import dev.emi.emi.runtime.EmiDrawContext;
import dev.emi.emi.screen.WidgetGroup;
import dev.emi.emi.widget.RecipeBackground;
import java.util.ArrayList;
import java.util.Iterator;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/integration/emi/plugin/core/widget/CustomBackground.class */
@OnlyIn(Dist.CLIENT)
public class CustomBackground extends Widget {

    @NotNull
    private final ResourceLocation textureLocation;
    private final int textureSize;
    private final int cornerSize;
    private final int centerSize;
    private final int width;
    private final int height;
    private final int x;
    private final int y;
    private int tintColor;

    public CustomBackground(@NotNull ResourceLocation resourceLocation, int i, int i2, int i3, int i4) {
        this(resourceLocation, 17, 4, 9, i, i2, i3, i4);
    }

    public CustomBackground(@NotNull ResourceLocation resourceLocation, int i, int i2) {
        this(resourceLocation, 17, 4, 9, 0, 0, i, i2);
    }

    public CustomBackground(@NotNull ResourceLocation resourceLocation, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.textureLocation = resourceLocation;
        this.textureSize = i;
        this.cornerSize = i2;
        this.centerSize = i3;
        this.x = i4;
        this.y = i5;
        this.width = i6;
        this.height = i7;
        this.tintColor = -1;
    }

    public CustomBackground tintColor(int i) {
        this.tintColor = i;
        return this;
    }

    public CustomBackground apply(WidgetHolder widgetHolder) {
        if (widgetHolder instanceof WidgetGroup) {
            WidgetGroup widgetGroup = (WidgetGroup) widgetHolder;
            ArrayList arrayList = new ArrayList();
            for (RecipeBackground recipeBackground : widgetGroup.widgets) {
                if (recipeBackground instanceof RecipeBackground) {
                    arrayList.add(recipeBackground);
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                widgetGroup.widgets.remove((RecipeBackground) it.next());
            }
            if (!widgetGroup.widgets.contains(this)) {
                widgetHolder.add(this);
            }
        }
        return this;
    }

    public Bounds getBounds() {
        return Bounds.EMPTY;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public void render(GuiGraphics guiGraphics, int i, int i2, float f) {
        EmiDrawContext emiDrawContextWrap = EmiDrawContext.wrap(guiGraphics);
        emiDrawContextWrap.push();
        if (this.tintColor != -1) {
            emiDrawContextWrap.setColor(((this.tintColor >> 16) & 255) / 255.0f, ((this.tintColor >> 8) & 255) / 255.0f, (this.tintColor & 255) / 255.0f);
        }
        int i3 = this.width - (this.cornerSize * 2);
        int i4 = this.height - (this.cornerSize * 2);
        emiDrawContextWrap.drawTexture(this.textureLocation, this.x, 0, this.cornerSize, this.y + this.cornerSize, 0.0f, 0.0f, this.cornerSize, this.cornerSize, this.textureSize, this.textureSize);
        emiDrawContextWrap.drawTexture(this.textureLocation, this.x + this.cornerSize, this.y, i3, this.cornerSize, this.cornerSize, 0.0f, this.centerSize, this.cornerSize, this.textureSize, this.textureSize);
        emiDrawContextWrap.drawTexture(this.textureLocation, this.x + this.cornerSize + i3, this.y, this.cornerSize, this.cornerSize, this.cornerSize + this.centerSize, 0.0f, this.cornerSize, this.cornerSize, this.textureSize, this.textureSize);
        emiDrawContextWrap.drawTexture(this.textureLocation, this.x, this.cornerSize, this.y + this.cornerSize, i4, 0.0f, this.cornerSize, this.cornerSize, this.cornerSize, this.textureSize, this.textureSize);
        emiDrawContextWrap.drawTexture(this.textureLocation, this.x + this.cornerSize, this.y + this.cornerSize, i3, i4, this.cornerSize, this.cornerSize, this.cornerSize, this.cornerSize, this.textureSize, this.textureSize);
        emiDrawContextWrap.drawTexture(this.textureLocation, this.x + this.cornerSize + i3, this.y + this.cornerSize, this.cornerSize, i4, this.cornerSize + this.centerSize, this.cornerSize, this.cornerSize, this.cornerSize, this.textureSize, this.textureSize);
        emiDrawContextWrap.drawTexture(this.textureLocation, this.x, this.cornerSize + i4, this.y + this.cornerSize, this.cornerSize, 0.0f, this.cornerSize + this.centerSize, this.cornerSize, this.cornerSize, this.textureSize, this.textureSize);
        emiDrawContextWrap.drawTexture(this.textureLocation, this.x + this.cornerSize, this.y + this.cornerSize + i4, i3, this.cornerSize, this.cornerSize, this.cornerSize + this.centerSize, this.cornerSize, this.cornerSize, this.textureSize, this.textureSize);
        emiDrawContextWrap.drawTexture(this.textureLocation, this.x + this.cornerSize + i3, this.y + this.cornerSize + i4, this.cornerSize, this.cornerSize, this.cornerSize + this.centerSize, this.cornerSize + this.centerSize, this.cornerSize, this.cornerSize, this.textureSize, this.textureSize);
        if (this.tintColor != -1) {
            emiDrawContextWrap.setColor(1.0f, 1.0f, 1.0f);
        }
        emiDrawContextWrap.pop();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.textureLocation.equals(((CustomBackground) obj).textureLocation);
    }

    public int hashCode() {
        return this.textureLocation.hashCode();
    }
}
