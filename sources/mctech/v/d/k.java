package mctech.v.d;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.ModelManager;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import software.bernie.geckolib.util.Color;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/d/k.class */
@OnlyIn(Dist.CLIENT)
public class k<T extends LivingEntity, M extends HumanoidModel<T>, A extends HumanoidModel<T>> extends RenderLayer<T, M> {
    private final A a;

    public k(RenderLayerParent<T, M> renderLayerParent, A a, ModelManager modelManager) {
        super(renderLayerParent);
        this.a = a;
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void render(PoseStack poseStack, MultiBufferSource multiBufferSource, int i, T t, float f, float f2, float f3, float f4, float f5, float f6) {
        ItemStack itemBySlot = t.getItemBySlot(EquipmentSlot.CHEST);
        mctech.items.e.b item = itemBySlot.getItem();
        if (item instanceof mctech.items.e.b) {
            mctech.e.a aVar = new mctech.e.a(itemBySlot, item.b());
            a(aVar.b(), poseStack, multiBufferSource, t, i, this.a, f, f2, f3, f5, f6);
            a(aVar.d(), poseStack, multiBufferSource, t, i, this.a, f, f2, f3, f5, f6);
        }
    }

    private void a(mctech.items.g gVar, PoseStack poseStack, MultiBufferSource multiBufferSource, T t, int i, A a, float f, float f2, float f3, float f4, float f5) {
        GeoArmorRenderer geoArmorRenderer;
        if (gVar.getSlots() <= 0) {
            return;
        }
        ItemStack stackInSlot = gVar.getStackInSlot(0);
        if (!stackInSlot.isEmpty()) {
            ArmorItem item = stackInSlot.getItem();
            if (!(item instanceof ArmorItem) || (geoArmorRenderer = GeoRenderProvider.of(item).getGeoArmorRenderer(t, stackInSlot, EquipmentSlot.CHEST, a)) == null) {
                return;
            }
            getParentModel().copyPropertiesTo(a);
            if (geoArmorRenderer instanceof GeoArmorRenderer) {
                geoArmorRenderer.prepForRender(t, stackInSlot, EquipmentSlot.CHEST, a, multiBufferSource, f3, f, f2, f4, f5);
            }
            a.copyPropertiesTo(geoArmorRenderer);
            geoArmorRenderer.renderToBuffer(poseStack, (VertexConsumer) null, i, OverlayTexture.NO_OVERLAY, Color.WHITE.argbInt());
        }
    }
}
