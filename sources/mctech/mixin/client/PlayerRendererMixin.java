package mctech.mixin.client;

import mctech.v.d.k;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HumanoidArmorModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/mixin/client/PlayerRendererMixin.class */
@Mixin(value = {PlayerRenderer.class}, remap = false)
public abstract class PlayerRendererMixin extends LivingEntityRenderer {
    public PlayerRendererMixin(EntityRendererProvider.Context context, EntityModel entityModel, float f) {
        super(context, entityModel, f);
    }

    @Inject(method = {"<init>(Lnet/minecraft/client/renderer/entity/EntityRendererProvider$Context;Z)V"}, at = {@At("RETURN")})
    public void PlayerRenderer(EntityRendererProvider.Context context, boolean z, CallbackInfo callbackInfo) {
        addLayer(new k(this, new HumanoidArmorModel(context.bakeLayer(z ? ModelLayers.PLAYER_SLIM_OUTER_ARMOR : ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
    }
}
