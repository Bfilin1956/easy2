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
import mctech.MCTech;
import mctech.api.items.IInteractionItemExtensions;
import mctech.api.items.IItemVariant;
import mctech.api.items.electric.ElectricItem;
import mctech.api.items.electric.IDamagelessElectricItem;
import mctech.api.items.electric.IElectricItem;
import mctech.blockentities.m;
import mctech.blocks.c.G;
import mctech.init.MCTechDataComponent;
import mctech.init.MCTechTags;
import mctech.m.a.i;
import mctech.m.f.o;
import mctech.v.z;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.DefaultedRegistry;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.item.component.Unbreakable;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.common.SimpleTier;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.extensions.IItemExtension;
import net.neoforged.neoforge.energy.IEnergyStorage;
import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.registries.DeferredBlock;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.GeckoLibConstants;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.SingletonGeoAnimatable;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.Animation;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.util.GeckoLibUtil;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/e/c/d.class */
public class d extends Item implements IInteractionItemExtensions, IItemVariant, IDamagelessElectricItem, mctech.m.a.e, IItemExtension, GeoItem {
    private final AnimatableInstanceCache b;
    private static final int c = 8600319;
    private static final int d = 717055;
    private static final int e = 150;
    private final int g;
    private final int h;
    private final int i;
    private final int j;
    private final int k;
    private final int l;
    private final mctech.h.a.e.c m;
    private static final Tier f = new SimpleTier(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 2031, 150.0f, 1.0f, 15, () -> {
        return Ingredient.EMPTY;
    });
    public static final Consumer<Item> a = item -> {
    };
    private static final List<BiFunction<Level, BlockPos, Boolean>> n = List.of((level, blockPos) -> {
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
    }, (level8, blockPos8) -> {
        return Boolean.valueOf(level8.getBlockEntity(blockPos8) instanceof m);
    }, (level9, blockPos9) -> {
        return Boolean.valueOf(level9.getBlockEntity(blockPos9) instanceof mctech.blockentities.b.f);
    });

    public d(Item.Properties properties) {
        super(properties.stacksTo(1).setNoRepair().component(DataComponents.TOOL, a(f, mctech.h.a.e.f.c(), (TagKey<Block>[]) new TagKey[]{BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.MINEABLE_WITH_SHOVEL, BlockTags.MINEABLE_WITH_AXE, BlockTags.MINEABLE_WITH_HOE, BlockTags.SWORD_EFFICIENT, MCTechTags.BEDROCK_ORE})).component(MCTechDataComponent.SINGULAR_STAFF_SETTINGS, e.a).component(DataComponents.UNBREAKABLE, new Unbreakable(false)));
        this.b = GeckoLibUtil.createInstanceCache(this);
        SingletonGeoAnimatable.registerSyncedAnimatable(this);
        this.m = mctech.h.a.e.f;
        this.g = this.m.a();
        this.h = 1;
        this.i = this.m.b();
        this.j = this.m.c();
        this.k = this.m.d();
        this.l = this.m.e();
    }

    public Optional<e> b(@NotNull ItemStack itemStack) {
        if (itemStack.isEmpty() || !(itemStack.getItem() instanceof d)) {
            return Optional.empty();
        }
        return Optional.ofNullable((e) itemStack.get(MCTechDataComponent.SINGULAR_STAFF_SETTINGS));
    }

    @Override // mctech.m.a.e
    public i a(Player player, InteractionHand interactionHand, ItemStack itemStack) {
        return new o(player, this, itemStack, null).a(itemStack);
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

    @Override // mctech.api.items.IInteractionItemExtensions
    public void onItemEquippedToSlot(@NotNull Player player, @NotNull ItemStack itemStack, @NotNull EquipmentSlot equipmentSlot) {
        Long l = (Long) itemStack.get((DataComponentType) GeckoLibConstants.STACK_ANIMATABLE_ID_COMPONENT.get());
        if (l != null) {
            stopTriggeredAnim(player, l.longValue(), "staff", "idle");
        }
    }

    @Override // mctech.api.items.IInteractionItemExtensions
    public void onItemUnequippedFromSlot(@NotNull Player player, @NotNull ItemStack itemStack, @NotNull EquipmentSlot equipmentSlot) {
        Long l = (Long) itemStack.get((DataComponentType) GeckoLibConstants.STACK_ANIMATABLE_ID_COMPONENT.get());
        if (l != null) {
            stopTriggeredAnim(player, l.longValue(), "staff", "idle");
        }
    }

    public boolean canPerformAction(@NotNull ItemStack itemStack, @NotNull ItemAbility itemAbility) {
        return ItemAbilities.DEFAULT_AXE_ACTIONS.contains(itemAbility);
    }

    @NotNull
    public UseAnim getUseAnimation(@NotNull ItemStack itemStack) {
        return UseAnim.BLOCK;
    }

    public boolean mineBlock(@NotNull ItemStack itemStack, @NotNull Level level, @NotNull BlockState blockState, @NotNull BlockPos blockPos, @NotNull LivingEntity livingEntity) {
        if (!(livingEntity instanceof Player)) {
            return false;
        }
        if (d(itemStack) || !isCorrectToolForDrops(itemStack, blockState) || blockState.getDestroySpeed(level, blockPos) <= 0.0f || !a(level, blockPos)) {
            return false;
        }
        return super.mineBlock(itemStack, level, blockState, blockPos, livingEntity);
    }

    @Override // mctech.api.items.IInteractionItemExtensions
    public boolean shouldPreventBlockDestroy(@NotNull Level level, @NotNull ItemStack itemStack, @NotNull BlockPos blockPos, @NotNull BlockState blockState, @NotNull Player player) {
        return !player.isShiftKeyDown();
    }

    public boolean isCorrectToolForDrops(@NotNull ItemStack itemStack, @NotNull BlockState blockState) {
        if ((blockState.hasProperty(G.d) && ((Boolean) blockState.getOptionalValue(G.d).orElse(false)).booleanValue()) || d(itemStack) || !ElectricItem.MANAGER.canUse(itemStack, c(itemStack))) {
            return false;
        }
        return super.isCorrectToolForDrops(itemStack, blockState);
    }

    public float getDestroySpeed(@NotNull ItemStack itemStack, @NotNull BlockState blockState) {
        if ((blockState.hasProperty(G.d) && ((Boolean) blockState.getOptionalValue(G.d).orElse(false)).booleanValue()) || d(itemStack)) {
            return 0.0f;
        }
        if (blockState.getBlock() instanceof mctech.blocks.e.b) {
            return f.getSpeed();
        }
        if (!isCorrectToolForDrops(itemStack, blockState)) {
            return 0.0f;
        }
        return ((Integer) b(itemStack).map((v0) -> {
            return v0.c();
        }).orElse(Integer.valueOf(e))).intValue();
    }

    public <T extends LivingEntity> int damageItem(@NotNull ItemStack itemStack, int i, @Nullable T t, @NotNull Consumer<Item> consumer) {
        ElectricItem.MANAGER.discharge(itemStack, ElectricItem.applyEnchantmentEffect(itemStack, c(itemStack) * i), getTier(itemStack), true, false, false);
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

    public int c(@NotNull ItemStack itemStack) {
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

    public boolean d(@NotNull ItemStack itemStack) {
        return getCharge(itemStack) <= 0;
    }

    public boolean e(@NotNull ItemStack itemStack) {
        return getCharge(itemStack) >= getCapacity(itemStack);
    }

    public boolean b(@NotNull ItemStack itemStack, int i) {
        return getCharge(itemStack) >= i;
    }

    public int f(@NotNull ItemStack itemStack) {
        return this.l;
    }

    private boolean a(@NotNull Level level, BlockPos blockPos) {
        Iterator<BiFunction<Level, BlockPos, Boolean>> it = n.iterator();
        while (it.hasNext()) {
            if (it.next().apply(level, blockPos).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    private boolean a(@NotNull Level level, @NotNull Player player, @NotNull BlockPos blockPos) {
        return level.mayInteract(player, blockPos) && !NeoForge.EVENT_BUS.post(new BlockEvent.BreakEvent(level, blockPos, level.getBlockState(blockPos), player)).isCanceled();
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
        arrayList.add(Tool.Rule.minesAndDrops(Tags.Blocks.GLASS_BLOCKS, tier.getSpeed()));
        arrayList.add(Tool.Rule.minesAndDrops(List.of(Blocks.GLOWSTONE), tier.getSpeed()));
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
        return e(itemStack);
    }

    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController(this, "staff", 2, animationState -> {
            if (animationState.getData(DataTickets.ITEM_RENDER_PERSPECTIVE) == ItemDisplayContext.GUI) {
                return PlayState.STOP;
            }
            return PlayState.CONTINUE;
        }).triggerableAnim("idle", RawAnimation.begin().then("animation", Animation.LoopType.LOOP)));
    }

    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.b;
    }

    public void createGeoRenderer(Consumer<GeoRenderProvider> consumer) {
        consumer.accept(new GeoRenderProvider(this) { // from class: mctech.items.e.c.d.1
            private z a;

            public BlockEntityWithoutLevelRenderer getGeoItemRenderer() {
                if (this.a == null) {
                    this.a = new z();
                }
                return this.a;
            }
        });
    }
}
