package mctech.mixin.client;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import mctech.init.MCTechMobEffects;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/mixin/client/MinecraftMixin.class */
@Mixin(value = {Minecraft.class}, remap = false)
public class MinecraftMixin {

    @Shadow
    @Nullable
    public LocalPlayer player;

    @Inject(method = {"shouldEntityAppearGlowing"}, at = {@At("RETURN")}, cancellable = true, remap = false)
    private void shouldEntityAppearGlowingInject(Entity entity, @Nonnull CallbackInfoReturnable<Boolean> callbackInfoReturnable) {
        if (!((Boolean) callbackInfoReturnable.getReturnValue()).booleanValue() && this.player != null && entity != this.player && (entity instanceof LivingEntity) && this.player.hasEffect(MCTechMobEffects.XRAY_VISION) && this.player.distanceTo(entity) <= 50.0f) {
            callbackInfoReturnable.setReturnValue(true);
        }
    }
}
