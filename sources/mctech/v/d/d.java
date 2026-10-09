package mctech.v.d;

import com.mojang.blaze3d.platform.Lighting;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.client.ClientHooks;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.renderer.GeoItemRenderer;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/d/d.class */
public class d extends GeoItemRenderer<mctech.items.e.d> {
    public d() {
        super(i.a());
    }

    public void renderByItem(ItemStack itemStack, ItemDisplayContext itemDisplayContext, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int i2) {
        super.renderByItem(itemStack, itemDisplayContext, poseStack, multiBufferSource, i, i2);
    }

    public static void a(mctech.items.e.d dVar, ItemDisplayContext itemDisplayContext, @NotNull PoseStack poseStack, MultiBufferSource multiBufferSource, int i, boolean z) {
        poseStack.pushPose();
        BakedModel bakedModelHandleCameraTransforms = ClientHooks.handleCameraTransforms(poseStack, mctech.v.f.i.a(dVar).a(), itemDisplayContext, z);
        poseStack.translate(-0.5d, -0.5d, -0.5d);
        if (itemDisplayContext == ItemDisplayContext.GUI) {
            Lighting.setupForFlatItems();
            MultiBufferSource.BufferSource bufferSource = multiBufferSource instanceof MultiBufferSource.BufferSource ? (MultiBufferSource.BufferSource) multiBufferSource : Minecraft.getInstance().renderBuffers().bufferSource();
            mctech.v.f.h.a(poseStack, bufferSource, bakedModelHandleCameraTransforms, i);
            bufferSource.endBatch();
            RenderSystem.enableDepthTest();
            Lighting.setupFor3DItems();
        } else {
            mctech.v.f.h.a(poseStack, multiBufferSource, bakedModelHandleCameraTransforms, i);
        }
        poseStack.popPose();
    }
}
