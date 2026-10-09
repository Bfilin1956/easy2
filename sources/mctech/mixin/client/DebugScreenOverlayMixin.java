package mctech.mixin.client;

import java.util.List;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.DebugScreenOverlay;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/mixin/client/DebugScreenOverlayMixin.class */
@Mixin(value = {DebugScreenOverlay.class}, remap = false)
public class DebugScreenOverlayMixin {

    @Shadow
    private HitResult block;

    @Shadow
    @Final
    private Minecraft minecraft;

    @Inject(method = {"getSystemInformation"}, at = {@At("RETURN")}, remap = false, cancellable = true)
    private void onGetSystemInformation(CallbackInfoReturnable<List<String>> callbackInfoReturnable) {
        BlockPos blockPos;
        BlockEntity blockEntity;
        List list = (List) callbackInfoReturnable.getReturnValue();
        if (list == null || this.block.getType() != HitResult.Type.BLOCK) {
            return;
        }
        BlockHitResult blockHitResult = this.block;
        if (blockHitResult instanceof BlockHitResult) {
            BlockHitResult blockHitResult2 = blockHitResult;
            if (this.minecraft.level != null && (blockEntity = this.minecraft.level.getBlockEntity((blockPos = blockHitResult2.getBlockPos()))) != null) {
                list.add("");
                list.add(String.valueOf(ChatFormatting.UNDERLINE) + "Targeted BlockEntity: " + blockPos.getX() + ", " + blockPos.getY() + ", " + blockPos.getZ());
                list.add(blockEntity.getClass().getSimpleName() + ", " + String.valueOf(blockEntity.getType().builtInRegistryHolder().getKey().location()));
                callbackInfoReturnable.setReturnValue(list);
            }
        }
    }
}
