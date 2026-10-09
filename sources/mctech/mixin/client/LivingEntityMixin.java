package mctech.mixin.client;

import mctech.items.e.a.g;
import mctech.items.e.a.h;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/mixin/client/LivingEntityMixin.class */
@Mixin({LivingEntity.class})
public class LivingEntityMixin {
    @Inject(method = {"swing(Lnet/minecraft/world/InteractionHand;Z)V"}, at = {@At("HEAD")}, cancellable = true, remap = false)
    private void cancelSwingAnimation(InteractionHand interactionHand, boolean z, CallbackInfo callbackInfo) {
        ItemStack itemInHand = ((LivingEntity) this).getItemInHand(interactionHand);
        if ((itemInHand.getItem() instanceof h) || (itemInHand.getItem() instanceof g)) {
            callbackInfo.cancel();
        }
    }
}
