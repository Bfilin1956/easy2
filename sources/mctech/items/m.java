package mctech.items;

import java.util.List;
import mctech.MCTech;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/m.class */
public class m extends BlockItem implements mctech.p.a.a, mctech.p.a.b {
    public m(mctech.blocks.d.a aVar, Item.Properties properties) {
        super(aVar, properties);
    }

    public void appendHoverText(@NotNull ItemStack itemStack, @NotNull Item.TooltipContext tooltipContext, @NotNull List<Component> list, @NotNull TooltipFlag tooltipFlag) {
        MutableComponent mutableComponentEmpty = Component.empty();
        mutableComponentEmpty.append(Component.literal("Нажмите <Shift> ").withStyle(ChatFormatting.GOLD));
        mutableComponentEmpty.append(Component.literal("что бы ").withStyle(ChatFormatting.RESET));
        mutableComponentEmpty.append(Component.literal("отрисовать структуру").withStyle(ChatFormatting.DARK_GREEN));
        list.add(mutableComponentEmpty);
        super.appendHoverText(itemStack, tooltipContext, list, tooltipFlag);
    }

    @NotNull
    public InteractionResult useOn(@NotNull UseOnContext useOnContext) {
        InteractionResult interactionResultA = a(useOnContext);
        if (interactionResultA != InteractionResult.FAIL) {
            return interactionResultA;
        }
        return InteractionResult.PASS;
    }

    @Override // mctech.p.a.a
    @NotNull
    public ResourceLocation a() {
        return MCTech.loc("molecular_converter");
    }
}
