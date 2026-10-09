package mctech.items.e.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import mctech.api.items.IItemVariant;
import mctech.api.items.electric.ElectricItem;
import mctech.api.items.electric.IDamagelessElectricItem;
import mctech.api.items.electric.IElectricItem;
import mctech.items.base.MCTechElectricItem;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/e/a/d.class */
public class d extends HoeItem implements IItemVariant, IDamagelessElectricItem, mctech.utils.e.a, mctech.utils.e.b {
    protected int a;

    public d() {
        super(Tiers.IRON, new Item.Properties().setNoRepair().stacksTo(1).attributes(a((Tier) Tiers.IRON)).component(DataComponents.TOOL, b((Tier) Tiers.IRON)));
        this.a = 50;
    }

    public static ItemAttributeModifiers a(Tier tier) {
        return PickaxeItem.createAttributes(tier, 0.0f, -3.0f);
    }

    public static Tool b(Tier tier) {
        return new Tool(List.of(Tool.Rule.deniesDrops(tier.getIncorrectBlocksForDrops()), Tool.Rule.minesAndDrops(BlockTags.MINEABLE_WITH_HOE, tier.getSpeed())), tier.getSpeed(), 1);
    }

    @Override // mctech.utils.e.a
    @OnlyIn(Dist.CLIENT)
    public void addToolTip(ItemStack itemStack, Player player, TooltipFlag tooltipFlag, mctech.utils.e.d dVar) {
        dVar.b(a(mctech.s.a.BLOCK_CLICK, "tooltip.item.mctech.hoe.seedmode", new Object[0]));
    }

    public boolean isDamageable(ItemStack itemStack) {
        return false;
    }

    public InteractionResult useOn(UseOnContext useOnContext) {
        InteractionResult interactionResultUseOn = super.useOn(useOnContext);
        if (interactionResultUseOn.consumesAction()) {
            ElectricItem.MANAGER.use(useOnContext.getPlayer().getItemInHand(useOnContext.getHand()), this.a, useOnContext.getPlayer());
        }
        return interactionResultUseOn;
    }

    public boolean mineBlock(ItemStack itemStack, Level level, BlockState blockState, BlockPos blockPos, LivingEntity livingEntity) {
        boolean zMineBlock = super.mineBlock(itemStack, level, blockState, blockPos, livingEntity);
        if (livingEntity instanceof Player) {
            ElectricItem.MANAGER.use(itemStack, this.a, livingEntity);
        } else {
            ElectricItem.MANAGER.discharge(itemStack, this.a, 1, true, false, false);
        }
        return zMineBlock;
    }

    @Override // mctech.api.items.electric.IElectricItem
    public boolean canProvideEnergy(ItemStack itemStack) {
        return false;
    }

    public boolean a(ItemStack itemStack) {
        return true;
    }

    @Override // mctech.api.items.electric.IElectricItem
    public int getCapacity(ItemStack itemStack) {
        return 10000;
    }

    @Override // mctech.api.items.electric.IElectricItem
    public int getTier(ItemStack itemStack) {
        return 1;
    }

    @Override // mctech.api.items.electric.IElectricItem
    public int getTransferLimit(ItemStack itemStack) {
        return 100;
    }

    @Override // mctech.api.items.IItemVariant
    public Collection<ItemStack> getVariants() {
        ArrayList arrayList = new ArrayList();
        MCTechElectricItem.addEmptyAndFullToGroup((ItemLike) this, (List<ItemStack>) arrayList);
        return arrayList;
    }

    public int getBarWidth(ItemStack itemStack) {
        return MCTechElectricItem.getElectricWidth(itemStack);
    }

    public int getBarColor(ItemStack itemStack) {
        return MCTechElectricItem.getRGBDurability(itemStack);
    }

    public boolean isBarVisible(ItemStack itemStack) {
        return true;
    }

    public <T extends LivingEntity> int damageItem(ItemStack itemStack, int i, @Nullable T t, Consumer<Item> consumer) {
        ElectricItem.MANAGER.discharge(itemStack, ElectricItem.applyEnchantmentEffect(itemStack, this.a * i), Integer.MAX_VALUE, true, false, false);
        return 0;
    }

    public boolean isEnchantable(ItemStack itemStack) {
        return false;
    }

    @Override // mctech.api.items.electric.IElectricItem
    public IElectricItem.ElectricType getElectricType(ItemStack itemStack) {
        return IElectricItem.ElectricType.TOOL;
    }
}
