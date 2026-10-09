package mctech.mixin.client;

import appeng.api.stacks.AEKeyType;
import appeng.items.tools.powered.PortableCellItem;
import java.util.List;
import mctech.MCTech;
import mctech.init.MCTechDataComponent;
import mctech.s.a;
import mctech.utils.e.d;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/mixin/client/PortableCellItemMixin.class */
@Mixin({PortableCellItem.class})
public class PortableCellItemMixin {

    @Shadow(remap = false)
    @Final
    private AEKeyType keyType;

    @Inject(method = {"appendHoverText"}, at = {@At("TAIL")}, remap = false)
    public void appendHoverText(ItemStack itemStack, Item.TooltipContext tooltipContext, List<Component> list, TooltipFlag tooltipFlag, CallbackInfo callbackInfo) {
        if (this.keyType == AEKeyType.items()) {
            d dVar = new d(list);
            boolean zBooleanValue = false;
            if (itemStack.has(MCTechDataComponent.AE_PORTABLE_CELL_AUTO_PICKUP)) {
                zBooleanValue = ((Boolean) itemStack.getOrDefault(MCTechDataComponent.AE_PORTABLE_CELL_AUTO_PICKUP, false)).booleanValue();
            }
            dVar.a(Component.literal("Автоподбор включен: ").append(boolComponent(zBooleanValue)));
            dVar.a(Component.translatable("tooltip.mctech.press_key_description", new Object[]{MCTech.KEYBOARD.a(a.MODE_KEY).withStyle(ChatFormatting.GOLD), Component.literal("Переключить автоподбор").withStyle(ChatFormatting.UNDERLINE)}));
        }
    }

    @Unique
    private static Component boolComponent(boolean z) {
        return Component.literal(z ? "да" : "нет").withStyle(z ? ChatFormatting.GREEN : ChatFormatting.RED);
    }
}
