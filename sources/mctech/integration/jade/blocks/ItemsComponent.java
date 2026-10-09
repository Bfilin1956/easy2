package mctech.integration.jade.blocks;

import java.util.Iterator;
import mctech.integration.jade.core.BlockComponent;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import snownee.jade.api.BlockAccessor;
import snownee.jade.api.ITooltip;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/integration/jade/blocks/ItemsComponent.class */
public class ItemsComponent extends BlockComponent {
    public static final ItemsComponent INSTANCE = new ItemsComponent();

    @Override // mctech.integration.jade.core.BlockComponent
    public boolean requireEUReader() {
        return true;
    }

    @Override // mctech.integration.jade.core.BlockComponent
    public void append(ITooltip iTooltip, BlockAccessor blockAccessor, CompoundTag compoundTag) {
        ListTag list = compoundTag.getList("items", 10);
        tooltipGroup(iTooltip, Component.literal("Предметы").withStyle(ChatFormatting.DARK_GREEN), 1142179604, (iTooltip2, listTag) -> {
            Iterator it = listTag.iterator();
            while (it.hasNext()) {
                BlockComponent.ItemsHolder.CODEC.decode(this.nbtOps, (Tag) it.next()).result().map((v0) -> {
                    return v0.getFirst();
                }).ifPresent(itemsHolder -> {
                    if (!itemsHolder.isEmpty()) {
                        slotType(iTooltip2, itemsHolder);
                    }
                });
            }
        }, list, (compoundTag.isEmpty() || list.isEmpty()) ? false : true);
    }

    public int getDefaultPriority() {
        return 0;
    }

    public ResourceLocation getUid() {
        return makeId(this);
    }
}
