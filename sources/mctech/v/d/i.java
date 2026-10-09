package mctech.v.d;

import com.mojang.blaze3d.vertex.PoseStack;
import mctech.MCTech;
import mctech.init.MCTechDataComponent;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/d/i.class */
public class i extends GeoItemRenderer<mctech.items.e.d> {
    private ItemStack a;

    public i() {
        super(a());
    }

    public void a(ItemStack itemStack, ItemStack itemStack2, mctech.items.e.d dVar, ItemDisplayContext itemDisplayContext, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int i2) {
        Boolean bool;
        AnimationController animationController = (AnimationController) dVar.getAnimatableInstanceCache().getManagerForId(GeoItem.getId(itemStack)).getAnimationControllers().get("controller");
        this.a = itemStack;
        if (animationController != null && animationController.getAnimationState() == AnimationController.State.STOPPED && (bool = (Boolean) itemStack.get(MCTechDataComponent.ACTIVATED)) != null && bool.booleanValue()) {
            animationController.forceAnimationReset();
            animationController.setAnimation(RawAnimation.begin().thenLoop("activated"));
        }
        super.renderByItem(itemStack2, itemDisplayContext, poseStack, multiBufferSource, i, i2);
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public long getInstanceId(mctech.items.e.d dVar) {
        return GeoItem.getId(this.a);
    }

    public static GeoModel<mctech.items.e.d> a() {
        return new GeoModel<mctech.items.e.d>() { // from class: mctech.v.d.i.1
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public ResourceLocation getModelResource(mctech.items.e.d dVar) {
                return ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "geo/item/blade_" + dVar.a() + ".geo.json");
            }

            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public ResourceLocation getTextureResource(mctech.items.e.d dVar) {
                int iA = dVar.a();
                if (iA > 9) {
                    return ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "textures/item/model/blade_10.png");
                }
                if (iA > 5) {
                    return ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "textures/item/model/blade_6.png");
                }
                return ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "textures/item/model/blade_1.png");
            }

            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public ResourceLocation getAnimationResource(mctech.items.e.d dVar) {
                return ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "animations/item/blade_" + dVar.a() + ".animation.json");
            }
        };
    }
}
