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

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/integration/emi/plugin/core/widget/TexturedBackground.class */
@OnlyIn(Dist.CLIENT)
public class TexturedBackground extends Widget {

    @NotNull
    private final ResourceLocation textureLocation;
    private final int width;
    private final int height;
    private final int x;
    private final int y;

    public TexturedBackground(@NotNull ResourceLocation resourceLocation, int i, int i2, int i3, int i4) {
        this.textureLocation = resourceLocation;
        this.x = i;
        this.y = i2;
        this.width = i3;
        this.height = i4;
    }

    public TexturedBackground(@NotNull ResourceLocation resourceLocation, int i, int i2) {
        this(resourceLocation, 0, 0, i, i2);
    }

    public TexturedBackground apply(WidgetHolder widgetHolder) {
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
        emiDrawContextWrap.drawTexture(this.textureLocation, this.x, this.y, 0, 0, this.width, this.height);
        emiDrawContextWrap.pop();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.textureLocation.equals(((TexturedBackground) obj).textureLocation);
    }

    public int hashCode() {
        return this.textureLocation.hashCode();
    }
}
