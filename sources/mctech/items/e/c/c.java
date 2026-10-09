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
import net.minecraft.tags.FluidTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.component.Unbreakable;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.neoforged.neoforge.common.SimpleTier;
import net.neoforged.neoforge.common.extensions.IItemExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/e/c/c.class */
public class c extends ShovelItem implements IInteractionItemExtensions, IItemVariant, IDamagelessElectricItem, IItemExtension {
    private static final int b = 8600319;
    private static final int c = 717055;
    private static final int d = 32;
    private static final Tier e = new SimpleTier(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 2031, 32.0f, 1.0f, 15, () -> {
        return Ingredient.EMPTY;
    });
    public static final Consumer<Item> a = item -> {
    };
    private final int f;
    private final int g;
    private final int h;
    private final int i;
    private final int j;

    public c(Item.Properties properties) {
        super(e, properties.stacksTo(1).setNoRepair().component(DataComponents.TOOL, e.createToolProperties(BlockTags.MINEABLE_WITH_SHOVEL)).component(DataComponents.UNBREAKABLE, new Unbreakable(false)));
        mctech.h.a.e.c cVar = mctech.h.a.e.e;
        this.f = cVar.a();
        this.g = 1;
        this.h = cVar.b();
        this.i = cVar.c();
        this.j = cVar.d();
    }

    @NotNull
    public InteractionResult useOn(@NotNull UseOnContext useOnContext) {
        ItemStack itemInHand = useOnContext.getItemInHand();
        if (b(itemInHand)) {
            return InteractionResult.PASS;
        }
        Player player = useOnContext.getPlayer();
        if (player == null) {
            return InteractionResult.PASS;
        }
        InteractionResult interactionResultUseOn = super.useOn(useOnContext);
        if (interactionResultUseOn == InteractionResult.PASS) {
            return use(useOnContext.getLevel(), player, player.getUsedItemHand()).getResult();
        }
        a(itemInHand, this.j, player);
        return interactionResultUseOn;
    }

    @NotNull
    public InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand interactionHand) {
        ItemStack itemInHand = player.getItemInHand(interactionHand);
        if (b(itemInHand)) {
            return InteractionResultHolder.fail(itemInHand);
        }
        BlockHitResult playerPOVHitResult = getPlayerPOVHitResult(level, player, ClipContext.Fluid.ANY);
        if (playerPOVHitResult.getType() == HitResult.Type.BLOCK && level.getFluidState(playerPOVHitResult.getBlockPos()).is(FluidTags.WATER)) {
            return InteractionResultHolder.sidedSuccess(itemInHand, true);
        }
        return super.use(level, player, interactionHand);
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
        if (b(itemStack)) {
            return false;
        }
        return super.isCorrectToolForDrops(itemStack, blockState);
    }

    public float getDestroySpeed(@NotNull ItemStack itemStack, @NotNull BlockState blockState) {
        if (b(itemStack)) {
            return 0.0f;
        }
        return super.getDestroySpeed(itemStack, blockState);
    }

    public <T extends LivingEntity> int damageItem(@NotNull ItemStack itemStack, int i, @Nullable T t, @NotNull Consumer<Item> consumer) {
        return 0;
    }

    public <T extends LivingEntity> int a(@NotNull ItemStack itemStack, int i, @Nullable T t) {
        return damageItem(itemStack, i, t, a);
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

    public boolean b(@NotNull ItemStack itemStack) {
        return getCharge(itemStack) <= 0;
    }

    public boolean c(@NotNull ItemStack itemStack) {
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
        return c(itemStack);
    }
}
