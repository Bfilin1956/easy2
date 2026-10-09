package mctech.items.f.j;

import java.util.List;
import java.util.Optional;
import mctech.api.items.IXrayUpgrade;
import mctech.init.MCTechDataComponent;
import mctech.y.c;
import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.Unbreakable;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/f/j/a.class */
public class a extends Item implements IXrayUpgrade {
    public a(Item.Properties properties, mctech.y.a aVar) {
        super(properties.component(MCTechDataComponent.BLOCK_APPEARANCE, aVar).stacksTo(1).setNoRepair().component(DataComponents.UNBREAKABLE, new Unbreakable(false)));
    }

    public void appendHoverText(@NotNull ItemStack itemStack, @NotNull Item.TooltipContext tooltipContext, @NotNull List<Component> list, @NotNull TooltipFlag tooltipFlag) {
        mctech.y.a aVar = (mctech.y.a) itemStack.get(MCTechDataComponent.BLOCK_APPEARANCE);
        if (aVar != null) {
            boolean z = aVar.c() == c.COLORED;
            list.add(Component.literal("Режим отображения: ").append(Component.literal(z ? "цветовое выделение" : "полу-прозрачная текстура")).withStyle(Style.EMPTY.withColor(z ? aVar.d() : ((Integer) Optional.ofNullable(ChatFormatting.GRAY.getColor()).orElse(-1)).intValue())));
        }
    }

    @Override // mctech.api.items.IXrayUpgrade
    public void onInstall(ItemStack itemStack, ItemStack itemStack2) {
    }

    @Override // mctech.api.items.IXrayUpgrade
    public void onUninstall(ItemStack itemStack, ItemStack itemStack2) {
    }
}
