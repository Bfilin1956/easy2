package mctech.mixin.client;

import mctech.e.a;
import mctech.items.e.b;
import net.minecraft.client.renderer.entity.layers.ElytraLayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/mixin/client/ElytraLayerMixin.class */
@Mixin(value = {ElytraLayer.class}, remap = false)
public abstract class ElytraLayerMixin {
    @Inject(method = {"shouldRender(Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/entity/LivingEntity;)Z"}, at = {@At("RETURN")}, cancellable = true)
    public void shouldRender(ItemStack itemStack, LivingEntity livingEntity, CallbackInfoReturnable<Boolean> callbackInfoReturnable) {
        if (((Boolean) callbackInfoReturnable.getReturnValue()).booleanValue()) {
            return;
        }
        b item = itemStack.getItem();
        if (item instanceof b) {
            a aVar = new a(itemStack, item.b());
            if (aVar.b().getSlots() > 0 && aVar.b().getStackInSlot(0).getItem() == Items.ELYTRA) {
                callbackInfoReturnable.setReturnValue(true);
            }
        }
    }
}
