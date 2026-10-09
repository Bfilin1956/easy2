package mctech.items.e.c;

import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import mctech.api.items.IInteractionItemExtensions;
import mctech.api.items.IItemVariant;
import mctech.api.items.electric.ElectricItem;
import mctech.api.items.electric.IDamagelessElectricItem;
import mctech.api.items.electric.IElectricItem;
import mctech.init.MCTechDataComponent;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.component.DataComponents;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.component.Unbreakable;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.SimpleTier;
import net.neoforged.neoforge.common.extensions.IItemExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/e/c/a.class */
public class a extends AxeItem implements IInteractionItemExtensions, IItemVariant, IDamagelessElectricItem, IItemExtension {
    private static final int a = 8600319;
    private static final int b = 717055;
    private static final int c = 32;
    private static final int d = 560;
    private static final Tier e = new SimpleTier(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 2031, 32.0f, 1.0f, 15, () -> {
        return Ingredient.EMPTY;
    });
    private final int f;
    private final int g;
    private final int h;
    private final int i;
    private final int j;

    public a(Item.Properties properties) {
        super(e, properties.stacksTo(1).setNoRepair().component(DataComponents.TOOL, e.createToolProperties(BlockTags.MINEABLE_WITH_AXE)).component(DataComponents.UNBREAKABLE, new Unbreakable(false)));
        mctech.h.a.e.c cVar = mctech.h.a.e.c;
        this.f = cVar.a();
        this.g = 1;
        this.h = cVar.b();
        this.i = cVar.c();
        this.j = cVar.d();
    }

    @NotNull
    public InteractionResult useOn(@NotNull UseOnContext useOnContext) {
        if (c(useOnContext.getItemInHand())) {
            return InteractionResult.PASS;
        }
        return super.useOn(useOnContext);
    }

    @NotNull
    public ItemAttributeModifiers getDefaultAttributeModifiers(@NotNull ItemStack itemStack) {
        return c(itemStack) ? super.getDefaultAttributeModifiers(itemStack) : ItemAttributeModifiers.builder().add(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_ID, 560.0d, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND).add(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_ID, Tiers.NETHERITE.getSpeed(), AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND).build();
    }

    public boolean hurtEnemy(@NotNull ItemStack itemStack, @NotNull LivingEntity livingEntity, @NotNull LivingEntity livingEntity2) {
        return true;
    }

    public boolean mineBlock(@NotNull ItemStack itemStack, @NotNull Level level, @NotNull BlockState blockState, @NotNull BlockPos blockPos, @NotNull LivingEntity livingEntity) {
        if (!(livingEntity instanceof Player)) {
            return false;
        }
        if (!isCorrectToolForDrops(itemStack, blockState) || blockState.getDestroySpeed(level, blockPos) <= 0.0f) {
            return false;
        }
        return super.mineBlock(itemStack, level, blockState, blockPos, livingEntity);
    }

    @Override // mctech.api.items.IInteractionItemExtensions
    public boolean shouldPreventBlockDestroy(@NotNull Level level, @NotNull ItemStack itemStack, @NotNull BlockPos blockPos, @NotNull BlockState blockState, @NotNull Player player) {
        return !player.isShiftKeyDown();
    }

    public boolean isCorrectToolForDrops(@NotNull ItemStack itemStack, @NotNull BlockState blockState) {
        if (c(itemStack)) {
            return false;
        }
        return super.isCorrectToolForDrops(itemStack, blockState);
    }

    public float getDestroySpeed(@NotNull ItemStack itemStack, @NotNull BlockState blockState) {
        if (c(itemStack)) {
            return 0.0f;
        }
        return super.getDestroySpeed(itemStack, blockState);
    }

    public <T extends LivingEntity> int damageItem(@NotNull ItemStack itemStack, int i, @Nullable T t, @NotNull Consumer<Item> consumer) {
        ElectricItem.MANAGER.discharge(itemStack, ElectricItem.applyEnchantmentEffect(itemStack, a(itemStack) * i), getTier(itemStack), true, false, false);
        return 0;
    }

    public boolean isBarVisible(@NotNull ItemStack itemStack) {
        return !((Boolean) itemStack.getOrDefault((DataComponentType) MCTechDataComponent.HIDE_BAR.get(), false)).booleanValue();
    }

    public int getBarWidth(@NotNull ItemStack itemStack) {
        return (int) Math.round((((double) ElectricItem.MANAGER.getCharge(itemStack)) / ((double) ElectricItem.MANAGER.getCapacity(itemStack))) * 13.0d);
    }

    public int getBarColor(@NotNull ItemStack itemStack) {
        return mctech.utils.math.a.a(717055, 8600319, 1.0f - (itemStack.getItem().getBarWidth(itemStack) / 13.0f)) | mctech.utils.math.a.f;
    }

    public int a(@NotNull ItemStack itemStack) {
        if (itemStack.isEmpty()) {
            return 0;
        }
        return this.i;
    }

    @Override // mctech.api.items.electric.IElectricItem
    public boolean canProvideEnergy(@NotNull ItemStack itemStack) {
        return false;
    }

    @Override // mctech.api.items.electric.IElectricItem
    public int getCapacity(ItemStack itemStack) {
        return this.h;
    }

    @Override // mctech.api.items.electric.IElectricItem
    public int getTier(ItemStack itemStack) {
        return this.g;
    }

    @Override // mctech.api.items.electric.IElectricItem
    public int getTransferLimit(ItemStack itemStack) {
        return this.f;
    }

    @Override // mctech.api.items.electric.IElectricItem
    public IElectricItem.ElectricType getElectricType(ItemStack itemStack) {
        return IElectricItem.ElectricType.TOOL;
    }

    public boolean isEnchantable(@NotNull ItemStack itemStack) {
        return false;
    }

    public int b(@NotNull ItemStack itemStack) {
        return d;
    }

    public boolean c(@NotNull ItemStack itemStack) {
        return getCharge(itemStack) <= 0;
    }

    public boolean d(@NotNull ItemStack itemStack) {
        return getCharge(itemStack) >= getCapacity(itemStack);
    }

    public boolean a(@NotNull ItemStack itemStack, int i) {
        return getCharge(itemStack) >= i;
    }

    @Override // mctech.api.items.IItemVariant
    public Collection<ItemStack> getVariants() {
        ItemStack itemStack = new ItemStack(this, 1);
        ItemStack itemStack2 = new ItemStack(this, 1);
        ElectricItem.MANAGER.discharge(itemStack, Integer.MAX_VALUE, Integer.MAX_VALUE, true, false, false);
        ElectricItem.MANAGER.charge(itemStack2, Integer.MAX_VALUE, Integer.MAX_VALUE, true, false);
        return List.of(itemStack, itemStack2);
    }

    @Override // mctech.api.items.IInteractionItemExtensions
    public boolean shouldPreventFlyBreakingBlockSlowdown(@NotNull ItemStack itemStack, @NotNull Player player) {
        return d(itemStack);
    }
}
