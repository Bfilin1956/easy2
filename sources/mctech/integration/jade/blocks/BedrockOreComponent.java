package mctech.integration.jade.blocks;

import java.util.Iterator;
import java.util.List;
import mctech.init.MCTechDataComponent;
import mctech.init.MCTechItems;
import mctech.integration.jade.core.BlockComponent;
import mctech.items.e.c;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.phys.Vec2;
import snownee.jade.api.BlockAccessor;
import snownee.jade.api.ITooltip;
import snownee.jade.api.theme.IThemeHelper;
import snownee.jade.api.ui.IElement;
import snownee.jade.api.ui.IElementHelper;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/integration/jade/blocks/BedrockOreComponent.class */
public class BedrockOreComponent extends BlockComponent {
    public static final BedrockOreComponent INSTANCE = new BedrockOreComponent();
    private static final Component CHECK = Component.literal("✔");
    private static final Component X = Component.literal("✕");
    private static final Vec2 ITEM_SIZE = new Vec2(10.0f, 0.0f);
    private final List<ItemStack> pickaxeSet = List.of(new ItemStack((ItemLike) MCTechItems.SINGULAR_PICKAXE.get()), new ItemStack((ItemLike) MCTechItems.COMPOSITE_PICKAXE.get()), new ItemStack((ItemLike) MCTechItems.NANO_PICKAXE.get()), new ItemStack((ItemLike) MCTechItems.QUANTUM_PICKAXE.get()), new ItemStack((ItemLike) MCTechItems.ADMIN_PICKAXE.get()));
    private final List<ItemStack> singularSet = List.of(new ItemStack((ItemLike) MCTechItems.ENHANCED_QUANTUM_STAFF.get()), new ItemStack((ItemLike) MCTechItems.ENHANCED_QUANTUM_PICKAXE.get()));

    public BedrockOreComponent() {
        Iterator<ItemStack> it = this.pickaxeSet.iterator();
        while (it.hasNext()) {
            it.next().set(MCTechDataComponent.HIDE_BAR, true);
        }
        Iterator<ItemStack> it2 = this.singularSet.iterator();
        while (it2.hasNext()) {
            it2.next().set(MCTechDataComponent.HIDE_BAR, true);
        }
    }

    @Override // mctech.integration.jade.core.BlockComponent
    public void append(ITooltip iTooltip, BlockAccessor blockAccessor, CompoundTag compoundTag) {
        ItemStack itemStackCopy = blockAccessor.getPlayer().getMainHandItem().copy();
        itemStackCopy.set(MCTechDataComponent.HIDE_BAR, true);
        IThemeHelper iThemeHelper = IThemeHelper.get();
        IElementHelper iElementHelper = IElementHelper.get();
        boolean z = compoundTag.getBoolean("can_harvest");
        boolean z2 = compoundTag.getBoolean("has_module");
        boolean z3 = compoundTag.getBoolean("has_energy");
        boolean z4 = compoundTag.getBoolean("singular_tool");
        if (!(itemStackCopy.getItem() instanceof BlockItem) && !itemStackCopy.isEmpty()) {
            iTooltip.append(iElementHelper.item(itemStackCopy, 0.75f).translate(new Vec2(-1.0f, -3.0f)).size(ITEM_SIZE).align(IElement.Align.RIGHT).message((String) null));
            iTooltip.append(iElementHelper.text(z ? iThemeHelper.success(CHECK) : iThemeHelper.danger(X)).scale(0.75f).zOffset(800).align(IElement.Align.RIGHT).size(Vec2.ZERO).translate(new Vec2(-3.0f, 3.25f)));
        }
        if (!z) {
            iTooltip.add(iElementHelper.text(iThemeHelper.danger(Component.literal("✕ Нельзя добыть"))));
            if (z4) {
                if (!z3) {
                    iTooltip.add(iElementHelper.text(iThemeHelper.warning(Component.literal("Не достаточно энергии"))));
                    return;
                }
                return;
            }
            if (itemStackCopy.getItem() instanceof c) {
                if (!z3) {
                    iTooltip.add(iElementHelper.text(iThemeHelper.warning(Component.literal("Не достаточно энергии"))));
                }
                if (!z2) {
                    iTooltip.add(iElementHelper.text(iThemeHelper.warning(Component.literal("Не хватает модуля "))));
                    iTooltip.append(iElementHelper.item(new ItemStack((ItemLike) MCTechItems.MODULE_BEDROCK_ORE_DESTROY.get()), 0.75f).translate(new Vec2(-1.0f, -3.0f)).size(ITEM_SIZE).message((String) null));
                    return;
                }
                return;
            }
            iTooltip.add(iElementHelper.spacer(0, 10));
            iTooltip.add(iElementHelper.text(iThemeHelper.warning(Component.literal("Можно добыть при помощи"))));
            iTooltip.add(iElementHelper.spacer(0, 10));
            Iterator<ItemStack> it = this.pickaxeSet.iterator();
            while (it.hasNext()) {
                iTooltip.append(iElementHelper.item(it.next(), 0.75f).translate(new Vec2(-1.0f, -3)).size(ITEM_SIZE).message((String) null));
            }
            iTooltip.append(iElementHelper.text(Component.literal(" +")));
            iTooltip.append(iElementHelper.item(new ItemStack((ItemLike) MCTechItems.MODULE_BEDROCK_ORE_DESTROY.get()), 0.75f).translate(new Vec2(-1.0f, -3)).size(ITEM_SIZE).message((String) null));
            iTooltip.add(iElementHelper.text(iThemeHelper.warning(Component.literal("или используя "))));
            Iterator<ItemStack> it2 = this.singularSet.iterator();
            while (it2.hasNext()) {
                iTooltip.append(iElementHelper.item(it2.next(), 0.75f).translate(new Vec2(-1.0f, -3)).size(ITEM_SIZE).message((String) null));
            }
        }
    }

    public ResourceLocation getUid() {
        return makeId(this);
    }
}
