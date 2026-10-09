package mctech.api.tiles.display;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.Font;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/tiles/display/IMonitorRenderer.class */
@OnlyIn(Dist.CLIENT)
public interface IMonitorRenderer {
    MultiBufferSource.BufferSource getBatcher();

    Font getFont();

    ItemRenderer getItemRenderer();

    void renderGuiItems(PoseStack poseStack, ItemStack itemStack, float f, float f2);

    void renderGuiItemText(PoseStack poseStack, Font font, ItemStack itemStack, float f, float f2, String str);

    default void renderGuiItemText(PoseStack poseStack, ItemStack itemStack, float f, float f2, String str) {
        renderGuiItemText(poseStack, getFont(), itemStack, f, f2, str);
    }
}
