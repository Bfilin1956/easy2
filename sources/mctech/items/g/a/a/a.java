package mctech.items.g.a.a;

import java.util.ArrayList;
import java.util.List;
import mctech.MCTech;
import mctech.api.network.item.INetworkItemEvent;
import mctech.init.MCTechDataComponent;
import mctech.m.a.e;
import mctech.m.a.i;
import mctech.m.f.r;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.Dist;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoItem;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/g/a/a/a.class */
public class a extends d implements INetworkItemEvent, e, GeoItem {
    public a(Item.Properties properties, int i, int i2) {
        super(properties, i, i2);
    }

    public void appendHoverText(@NotNull ItemStack itemStack, @NotNull Item.TooltipContext tooltipContext, @NotNull List<Component> list, @NotNull TooltipFlag tooltipFlag) {
        if (itemStack.has(MCTechDataComponent.BLOCK_APPEARANCE_LIST)) {
            List list2 = (List) itemStack.getOrDefault(MCTechDataComponent.BLOCK_APPEARANCE_LIST, new ArrayList());
            if (!list2.isEmpty()) {
                list.add(Component.literal("Установленные модули: ").append(Component.literal(String.valueOf(list2.size())).withStyle(ChatFormatting.GOLD)));
            }
        }
    }

    @NotNull
    public InteractionResultHolder<ItemStack> use(@NotNull Level level, Player player, @NotNull InteractionHand interactionHand) {
        if (player.isShiftKeyDown()) {
            ItemStack itemInHand = player.getItemInHand(interactionHand);
            if (MCTech.PLATFORM.a(player, player.getUsedItemHand(), Direction.UP, a(player, player.getUsedItemHand(), itemInHand))) {
                return InteractionResultHolder.consume(itemInHand);
            }
            return InteractionResultHolder.fail(itemInHand);
        }
        return super.use(level, player, interactionHand);
    }

    @Override // mctech.m.a.e
    public i a(Player player, InteractionHand interactionHand, ItemStack itemStack) {
        return new r(player, this, itemStack, null).a(itemStack);
    }

    @Override // mctech.api.network.item.INetworkItemEvent
    public void onEventReceived(ItemStack itemStack, Player player, int i, int i2, Dist dist) {
    }
}
