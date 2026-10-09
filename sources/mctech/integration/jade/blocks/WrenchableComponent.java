package mctech.integration.jade.blocks;

import mctech.init.MCTechItems;
import mctech.integration.jade.core.BlockComponent;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec2;
import snownee.jade.api.BlockAccessor;
import snownee.jade.api.ITooltip;
import snownee.jade.api.theme.IThemeHelper;
import snownee.jade.api.ui.IElement;
import snownee.jade.api.ui.IElementHelper;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/integration/jade/blocks/WrenchableComponent.class */
public class WrenchableComponent extends BlockComponent {
    public static final WrenchableComponent INSTANCE = new WrenchableComponent();
    private static final Component CHECK = Component.literal("✔");
    private static final Component X = Component.literal("✕");
    private static final Vec2 ITEM_SIZE = new Vec2(10.0f, 0.0f);

    @Override // mctech.integration.jade.core.BlockComponent
    public void append(ITooltip iTooltip, BlockAccessor blockAccessor, CompoundTag compoundTag) {
        IThemeHelper iThemeHelper = IThemeHelper.get();
        IElementHelper iElementHelper = IElementHelper.get();
        boolean z = compoundTag.getBoolean("canHarvest");
        double d = compoundTag.getDouble("chance");
        ItemStack tool = getTool(blockAccessor.getPlayer());
        if (!(tool.getItem() instanceof BlockItem) && !tool.isEmpty()) {
            iTooltip.append(0, iElementHelper.item(tool, 0.75f).translate(new Vec2(-1.0f, -3.0f)).size(ITEM_SIZE).align(IElement.Align.RIGHT).message((String) null));
            iTooltip.append(0, iElementHelper.text(z ? iThemeHelper.success(CHECK) : iThemeHelper.danger(X)).scale(0.75f).zOffset(800).align(IElement.Align.RIGHT).size(Vec2.ZERO).translate(new Vec2(-3.0f, 3.25f)));
        }
        if (!z) {
            iTooltip.add(iElementHelper.text(iThemeHelper.warning(Component.literal("Можно добыть при помощи"))));
            iTooltip.append(iElementHelper.item(MCTechItems.WRENCH.toStack(), 0.75f).translate(new Vec2(0.0f, -3)).size(ITEM_SIZE).message((String) null));
        } else {
            iTooltip.add(iElementHelper.item(MCTechItems.WRENCH.toStack(), 0.75f).translate(new Vec2(0.0f, -3)).size(ITEM_SIZE).message((String) null));
            iTooltip.append(iElementHelper.text(iThemeHelper.success(Component.literal("  Шанс добычи: " + Mth.floor(d * 100.0d) + "%"))));
        }
    }

    public ResourceLocation getUid() {
        return makeId(this);
    }

    public int getDefaultPriority() {
        return 10000;
    }

    private ItemStack getTool(Player player) {
        ItemStack mainHandItem = player.getMainHandItem();
        return !mainHandItem.isEmpty() ? mainHandItem : player.getOffhandItem();
    }
}
