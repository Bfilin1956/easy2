package mctech.mixin.client;

import mctech.api.items.IInteractionItemExtensions;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.effect.MobEffectUtil;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.event.EventHooks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/mixin/client/PlayerMixin.class */
@Mixin({Player.class})
public abstract class PlayerMixin {
    @Shadow(remap = false)
    public abstract Inventory getInventory();

    @Inject(method = {"getDigSpeed"}, at = {@At("HEAD")}, cancellable = true, remap = false)
    private void preventFlySlowdown(BlockState blockState, BlockPos blockPos, CallbackInfoReturnable<Float> callbackInfoReturnable) {
        float f;
        Player player = (Player) this;
        ItemStack selected = getInventory().getSelected();
        float destroySpeed = getInventory().getDestroySpeed(blockState);
        if (destroySpeed > 1.0f) {
            destroySpeed += (float) player.getAttributeValue(Attributes.MINING_EFFICIENCY);
        }
        if (MobEffectUtil.hasDigSpeed(player)) {
            destroySpeed *= 1.0f + ((MobEffectUtil.getDigSpeedAmplification(player) + 1) * 0.2f);
        }
        if (player.hasEffect(MobEffects.DIG_SLOWDOWN)) {
            switch (player.getEffect(MobEffects.DIG_SLOWDOWN).getAmplifier()) {
                case 0:
                    f = 0.3f;
                    break;
                case 1:
                    f = 0.09f;
                    break;
                case 2:
                    f = 0.0027f;
                    break;
                default:
                    f = 8.1E-4f;
                    break;
            }
            destroySpeed *= f;
        }
        float attributeValue = destroySpeed * ((float) player.getAttributeValue(Attributes.BLOCK_BREAK_SPEED));
        if (player.isEyeInFluid(FluidTags.WATER)) {
            attributeValue *= (float) player.getAttribute(Attributes.SUBMERGED_MINING_SPEED).getValue();
        }
        IInteractionItemExtensions item = selected.getItem();
        if (item instanceof IInteractionItemExtensions) {
            if (!item.shouldPreventFlyBreakingBlockSlowdown(selected, player) && !player.onGround()) {
                attributeValue /= 5.0f;
            }
        } else if (!player.onGround()) {
            attributeValue /= 5.0f;
        }
        callbackInfoReturnable.setReturnValue(Float.valueOf(EventHooks.getBreakSpeed(player, blockState, attributeValue, blockPos)));
    }
}
