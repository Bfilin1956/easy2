package mctech.integration.jade.blocks;

import mctech.integration.jade.core.BlockComponent;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import snownee.jade.api.BlockAccessor;
import snownee.jade.api.ITooltip;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/integration/jade/blocks/RecipeComponent.class */
public class RecipeComponent extends BlockComponent {
    public static final RecipeComponent INSTANCE = new RecipeComponent();

    @Override // mctech.integration.jade.core.BlockComponent
    public boolean requireEUReader() {
        return true;
    }

    @Override // mctech.integration.jade.core.BlockComponent
    public void append(ITooltip iTooltip, BlockAccessor blockAccessor, CompoundTag compoundTag) {
        tooltipGroup(iTooltip, Component.literal("Производство").withStyle(ChatFormatting.AQUA), 1143219303, (iTooltip2, compoundTag2) -> {
            if (compoundTag2.contains("progressList")) {
                for (CompoundTag compoundTag2 : compoundTag2.getList("progressList", 10)) {
                    if (compoundTag2 instanceof CompoundTag) {
                        CompoundTag compoundTag3 = compoundTag2;
                        recipeProgress(iTooltip2, compoundTag3.getFloat("progress"), compoundTag3.getFloat("maxProgress"));
                    }
                }
            }
        }, compoundTag, true);
    }

    public int getDefaultPriority() {
        return -10000;
    }

    public ResourceLocation getUid() {
        return makeId(this);
    }
}
