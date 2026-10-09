package mctech.items.e.c;

import appeng.blockentity.AEBaseBlockEntity;
import appeng.blockentity.networking.CableBusBlockEntity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.stream.Stream;
import mctech.api.items.IInteractionItemExtensions;
import mctech.api.items.IItemVariant;
import mctech.api.items.electric.ElectricItem;
import mctech.api.items.electric.IDamagelessElectricItem;
import mctech.api.items.electric.IElectricItem;
import mctech.blocks.c.G;
import mctech.init.MCTechDataComponent;
import mctech.init.MCTechTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.DefaultedRegistry;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.item.component.Unbreakable;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.common.SimpleTier;
import net.neoforged.neoforge.common.extensions.IItemExtension;
import net.neoforged.neoforge.energy.IEnergyStorage;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.registries.DeferredBlock;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/e/c/b.class */
public class b extends PickaxeItem implements IInteractionItemExtensions, IItemVariant, IDamagelessElectricItem, IItemExtension {
    private static final int b = 8600319;
    private static final int c = 717055;
    private static final int d = 32;
    private static final int e = 6;
    private final int g;
    private final int h;
    private final int i;
    private final int j;
    private static final Tier f = new SimpleTier(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 2031, 32.0f, 1.0f, 15, () -> {
        return Ingredient.EMPTY;
    });
    public static final Consumer<Item> a = item -> {
    };
    private static final List<BiFunction<Level, BlockPos, Boolean>> k = List.of((level, blockPos) -> {
        return Boolean.valueOf((((IItemHandler) level.getCapability(Capabilities.ItemHandler.BLOCK, blockPos, (Object) null)) == null && ((IFluidHandler) level.getCapability(Capabilities.FluidHandler.BLOCK, blockPos, (Object) null)) == null && ((IEnergyStorage) level.getCapability(Capabilities.EnergyStorage.BLOCK, blockPos, (Object) null)) == null) ? false : true);
    }, (level2, blockPos2) -> {
        return Boolean.valueOf(level2.getBlockEntity(blockPos2) instanceof mctech.g.d.a.a.b);
    }, (level3, blockPos3) -> {
        return Boolean.valueOf(level3.getBlockEntity(blockPos3) instanceof mctech.p.b.b);
    }, (level4, blockPos4) -> {
        return Boolean.valueOf(level4.getBlockEntity(blockPos4) instanceof mctech.p.b.d);
    }, (level5, blockPos5) -> {
        return Boolean.valueOf(level5.getBlockState(blockPos5).getBlock() instanceof mctech.p.b.c);
    }, (level6, blockPos6) -> {
        return Boolean.valueOf(level6.getBlockEntity(blockPos6) instanceof AEBaseBlockEntity);
    }, (level7, blockPos7) -> {
        return Boolean.valueOf(level7.getBlockEntity(blockPos7) instanceof CableBusBlockEntity);
    });

    public b(Item.Properties properties) {
        super(f, properties.stacksTo(1).setNoRepair().component(DataComponents.TOOL, a(f, mctech.h.a.e.d.c(), (TagKey<Block>[]) new TagKey[]{BlockTags.MINEABLE_WITH_PICKAXE, MCTechTags.BEDROCK_ORE})).component(DataComponents.UNBREAKABLE, new Unbreakable(false)));
        mctech.h.a.e.c cVar = mctech.h.a.e.d;
        this.g = cVar.a();
        this.h = 1;
        this.i = cVar.b();
        this.j = cVar.c();
    }

    public boolean mineBlock(@NotNull ItemStack itemStack, @NotNull Level level, @NotNull BlockState blockState, @NotNull BlockPos blockPos, @NotNull LivingEntity livingEntity) {
        if (!(livingEntity instanceof Player)) {
            return false;
        }
        if (b(itemStack) || !isCorrectToolForDrops(itemStack, blockState) || blockState.getDestroySpeed(level, blockPos) <= 0.0f || !a(level, blockPos)) {
            return false;
        }
        return super.mineBlock(itemStack, level, blockState, blockPos, livingEntity);
    }

    @Override // mctech.api.items.IInteractionItemExtensions
    public boolean shouldPreventBlockDestroy(@NotNull Level level, @NotNull ItemStack itemStack, @NotNull BlockPos blockPos, @NotNull BlockState blockState, @NotNull Player player) {
        return !player.isShiftKeyDown();
    }

    public boolean isCorrectToolForDrops(@NotNull ItemStack itemStack, @NotNull BlockState blockState) {
        if ((blockState.hasProperty(G.d) && ((Boolean) blockState.getOptionalValue(G.d).orElse(false)).booleanValue()) || b(itemStack) || !ElectricItem.MANAGER.canUse(itemStack, a(itemStack))) {
            return false;
        }
        return super.isCorrectToolForDrops(itemStack, blockState);
    }

    public float getDestroySpeed(@NotNull ItemStack itemStack, @NotNull BlockState blockState) {
        if ((blockState.hasProperty(G.d) && ((Boolean) blockState.getOptionalValue(G.d).orElse(false)).booleanValue()) || b(itemStack)) {
            return 0.0f;
        }
        return super.getDestroySpeed(itemStack, blockState);
    }

    public <T extends LivingEntity> int damageItem(@NotNull ItemStack itemStack, int i, @Nullable T t, @NotNull Consumer<Item> consumer) {
        ElectricItem.MANAGER.discharge(itemStack, ElectricItem.applyEnchantmentEffect(itemStack, a(itemStack) * i), getTier(itemStack), true, false, false);
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
        return this.j;
    }

    @Override // mctech.api.items.electric.IElectricItem
    public boolean canProvideEnergy(@NotNull ItemStack itemStack) {
        return false;
    }

    @Override // mctech.api.items.electric.IElectricItem
    public int getCapacity(ItemStack itemStack) {
        return this.i;
    }

    @Override // mctech.api.items.electric.IElectricItem
    public int getTier(ItemStack itemStack) {
        return this.h;
    }

    @Override // mctech.api.items.electric.IElectricItem
    public int getTransferLimit(ItemStack itemStack) {
        return this.g;
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

    private boolean a(@NotNull Level level, BlockPos blockPos) {
        Iterator<BiFunction<Level, BlockPos, Boolean>> it = k.iterator();
        while (it.hasNext()) {
            if (it.next().apply(level, blockPos).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    private static Tool.Rule a(Block... blockArr) {
        DefaultedRegistry defaultedRegistry = BuiltInRegistries.BLOCK;
        Stream stream = Arrays.stream(blockArr);
        Objects.requireNonNull(defaultedRegistry);
        return new Tool.Rule(HolderSet.direct(stream.map((v1) -> {
            return r1.getKey(v1);
        }).map(resourceLocation -> {
            return (Holder.Reference) defaultedRegistry.getHolder(resourceLocation).orElse(null);
        }).filter((v0) -> {
            return Objects.nonNull(v0);
        }).toList()), Optional.empty(), Optional.of(false));
    }

    private static Tool.Rule a(DeferredBlock<? extends Block>... deferredBlockArr) {
        DefaultedRegistry defaultedRegistry = BuiltInRegistries.BLOCK;
        return new Tool.Rule(HolderSet.direct(Arrays.stream(deferredBlockArr).map((v0) -> {
            return v0.getKey();
        }).map(resourceKey -> {
            return (Holder.Reference) defaultedRegistry.getHolder(resourceKey).orElse(null);
        }).filter((v0) -> {
            return Objects.nonNull(v0);
        }).toList()), Optional.empty(), Optional.of(false));
    }

    private static Tool.Rule a(ResourceLocation... resourceLocationArr) {
        DefaultedRegistry defaultedRegistry = BuiltInRegistries.BLOCK;
        Stream stream = Arrays.stream(resourceLocationArr);
        Objects.requireNonNull(defaultedRegistry);
        return new Tool.Rule(HolderSet.direct(stream.filter(defaultedRegistry::containsKey).map(resourceLocation -> {
            return (Holder.Reference) defaultedRegistry.getHolder(resourceLocation).orElse(null);
        }).filter((v0) -> {
            return Objects.nonNull(v0);
        }).toList()), Optional.empty(), Optional.of(false));
    }

    @SafeVarargs
    private static Tool a(Tier tier, int i, TagKey<Block>... tagKeyArr) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Tool.Rule.deniesDrops(tier.getIncorrectBlocksForDrops()));
        arrayList.add(a(Blocks.BEDROCK, Blocks.BARRIER));
        Stream map = Arrays.stream(tagKeyArr).map(tagKey -> {
            return Tool.Rule.minesAndDrops(tagKey, tier.getSpeed());
        });
        Objects.requireNonNull(arrayList);
        map.forEach((v1) -> {
            r1.add(v1);
        });
        return new Tool(arrayList, 1.0f, i);
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
