package mctech.blocks.base;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import mctech.MCTech;
import mctech.api.blocks.IAdvancedComparable;
import mctech.api.blocks.IBlockDropProvider;
import mctech.api.blocks.IRarityProvider;
import mctech.api.blocks.IWrenchable;
import mctech.api.features.IClickable;
import mctech.api.features.ICollideable;
import mctech.api.features.IDropProvider;
import mctech.api.features.IParticleSpawner;
import mctech.api.features.IWrenchableTile;
import mctech.api.features.redstone.IComparatorProvider;
import mctech.api.features.redstone.IRedstoneListener;
import mctech.api.features.redstone.IRedstoneProvider;
import mctech.blockentities.q;
import mctech.init.MCTechProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.Nameable;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.SignalGetter;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blocks/base/e.class */
public abstract class e extends BaseEntityBlock implements IAdvancedComparable, IRarityProvider, IWrenchable, a, mctech.utils.e.b {
    protected boolean animations;
    protected Rarity rarityOverride;
    List<mctech.utils.e.a.d> tooltips;
    IBlockDropProvider provider;
    BlockEntityType<? extends BlockEntity> blockEntityType;

    public e(BlockBehaviour.Properties properties) {
        super(properties);
        this.rarityOverride = null;
        this.tooltips = null;
        this.provider = IBlockDropProvider.SELF;
    }

    public IBlockDropProvider getDropProvider() {
        return this.provider;
    }

    public e setDropProvider(IBlockDropProvider iBlockDropProvider) {
        this.provider = iBlockDropProvider;
        return this;
    }

    public e setOverrideRarity(Rarity rarity) {
        this.rarityOverride = rarity;
        return this;
    }

    public e setTooltips(mctech.utils.e.a.d dVar) {
        this.tooltips = mctech.utils.a.b.a(dVar);
        return this;
    }

    public e addTooltip(mctech.utils.e.a.d dVar) {
        if (this.tooltips == null) {
            this.tooltips = mctech.utils.a.b.i();
        }
        this.tooltips.add(dVar);
        return this;
    }

    @Override // mctech.api.blocks.IRarityProvider
    public Rarity getRarity(ItemStack itemStack) {
        return this.rarityOverride;
    }

    public RenderShape getRenderShape(BlockState blockState) {
        return RenderShape.MODEL;
    }

    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return this.blockEntityType.create(blockPos, blockState);
    }

    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState blockState, BlockEntityType<T> blockEntityType) {
        return null;
    }

    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack itemStack, BlockGetter blockGetter, List<Component> list, TooltipFlag tooltipFlag) {
        if (this.tooltips != null) {
            int size = this.tooltips.size();
            for (int i = 0; i < size; i++) {
                this.tooltips.get(i).a(itemStack, blockGetter, list, tooltipFlag);
            }
        }
    }

    public ItemInteractionResult useItemOn(ItemStack itemStack, BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
        mctech.m.a.d blockEntity = level.getBlockEntity(blockPos);
        if (blockEntity instanceof IClickable) {
            IClickable iClickable = (IClickable) blockEntity;
            if (iClickable.getRequiredActions().canDoRightClick() && iClickable.onRightClick(player, interactionHand, blockHitResult.getDirection(), blockHitResult)) {
                return ItemInteractionResult.SUCCESS;
            }
        }
        if (player.isShiftKeyDown()) {
            return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
        }
        if (blockEntity instanceof mctech.m.a.d) {
            mctech.m.a.d dVar = blockEntity;
            if ((MCTech.PLATFORM.h() && dVar.a(player, interactionHand, blockHitResult.getDirection())) || MCTech.PLATFORM.a(player, interactionHand, blockHitResult.getDirection(), dVar)) {
                return ItemInteractionResult.SUCCESS;
            }
        }
        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    public void attack(BlockState blockState, Level level, BlockPos blockPos, Player player) {
        IClickable blockEntity = level.getBlockEntity(blockPos);
        if (!(blockEntity instanceof IClickable)) {
            return;
        }
        IClickable iClickable = blockEntity;
        if (iClickable.getRequiredActions().canDoLeftClick()) {
            iClickable.onLeftClick(player, blockPos);
        }
    }

    public boolean hasAnalogOutputSignal(BlockState blockState) {
        return true;
    }

    @Override // mctech.api.blocks.IAdvancedComparable
    public int getComparatorInputOverride(BlockState blockState, Level level, BlockPos blockPos, Direction direction) {
        IComparatorProvider blockEntity = level.getBlockEntity(blockPos);
        if (blockEntity instanceof IComparatorProvider) {
            return blockEntity.getSignalStrength(direction);
        }
        return 0;
    }

    public int getAnalogOutputSignal(BlockState blockState, Level level, BlockPos blockPos) {
        return getComparatorInputOverride(blockState, level, blockPos, null);
    }

    public int getDirectSignal(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, Direction direction) {
        IRedstoneProvider blockEntity = blockGetter.getBlockEntity(blockPos);
        if (blockEntity instanceof IRedstoneProvider) {
            return blockEntity.getStrongSignalStrength(direction);
        }
        return 0;
    }

    public int getSignal(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, Direction direction) {
        IRedstoneProvider blockEntity = blockGetter.getBlockEntity(blockPos);
        if (blockEntity instanceof IRedstoneProvider) {
            return blockEntity.getWeakSignalStrength(direction);
        }
        return 0;
    }

    public boolean shouldCheckWeakPower(BlockState blockState, SignalGetter signalGetter, BlockPos blockPos, Direction direction) {
        IRedstoneListener blockEntity = signalGetter.getBlockEntity(blockPos);
        if (blockEntity instanceof IRedstoneListener) {
            return blockEntity.allowWeakSignal(direction);
        }
        return super.shouldCheckWeakPower(blockState, signalGetter, blockPos, direction);
    }

    public boolean canConnectRedstone(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, Direction direction) {
        IRedstoneListener blockEntity = blockGetter.getBlockEntity(blockPos);
        if (blockEntity instanceof IRedstoneListener) {
            return blockEntity.canConnectToRedstone(direction);
        }
        return super.canConnectRedstone(blockState, blockGetter, blockPos, direction);
    }

    public void onNeighborChange(BlockState blockState, LevelReader levelReader, BlockPos blockPos, BlockPos blockPos2) {
        BlockEntity blockEntity = levelReader.getBlockEntity(blockPos);
        if (blockEntity instanceof q) {
            ((q) blockEntity).onComparatorUpdate(blockPos2);
        }
    }

    public ItemStack getCloneItemStack(BlockState blockState, HitResult hitResult, LevelReader levelReader, BlockPos blockPos, Player player) {
        ItemStack cloneItemStack = super.getCloneItemStack(blockState, hitResult, levelReader, blockPos, player);
        Nameable blockEntity = levelReader.getBlockEntity(blockPos);
        if ((blockEntity instanceof Nameable) && blockEntity.hasCustomName()) {
            cloneItemStack.set(DataComponents.CUSTOM_NAME, blockEntity.getCustomName());
        }
        return cloneItemStack;
    }

    public List<ItemStack> getDrops(BlockState blockState, LootParams.Builder builder) {
        LootTable lootTable = builder.getLevel().getServer().reloadableRegistries().getLootTable(getLootTable());
        if (lootTable != LootTable.EMPTY) {
            return lootTable.getRandomItems(builder.withParameter(LootContextParams.BLOCK_STATE, blockState).create(LootContextParamSets.BLOCK));
        }
        ArrayList arrayList = new ArrayList();
        Nameable nameable = (BlockEntity) builder.getOptionalParameter(LootContextParams.BLOCK_ENTITY);
        ItemStack itemStackCreateDrop = createDrop(blockState, (ItemStack) builder.getOptionalParameter(LootContextParams.TOOL), builder.getLevel().getRandom(), nameable, false);
        if (!itemStackCreateDrop.isEmpty()) {
            if ((nameable instanceof Nameable) && nameable.hasCustomName()) {
                itemStackCreateDrop.set(DataComponents.CUSTOM_NAME, nameable.getCustomName());
            }
            arrayList.add(itemStackCreateDrop);
        }
        addExtraDrops(arrayList, blockState, itemStackCreateDrop, builder.getLevel().getRandom());
        if (nameable instanceof IDropProvider) {
            ((IDropProvider) nameable).addDrops(arrayList);
        }
        return arrayList;
    }

    public ItemStack createDrop(BlockState blockState, ItemStack itemStack, RandomSource randomSource, @Nullable BlockEntity blockEntity, boolean z) {
        return this.provider.createDrop(blockState, itemStack, randomSource, blockEntity, z);
    }

    public void addExtraDrops(List<ItemStack> list, BlockState blockState, ItemStack itemStack, RandomSource randomSource) {
    }

    public void neighborChanged(BlockState blockState, Level level, BlockPos blockPos, Block block, BlockPos blockPos2, boolean z) {
        BlockEntity blockEntity = level.getBlockEntity(blockPos);
        if (blockEntity instanceof q) {
            ((q) blockEntity).onBlockUpdate(block, blockPos2);
        }
    }

    public void entityInside(BlockState blockState, Level level, BlockPos blockPos, Entity entity) {
        ICollideable blockEntity = level.getBlockEntity(blockPos);
        if (blockEntity instanceof ICollideable) {
            blockEntity.onEntityCollided(entity);
        }
    }

    @Override // mctech.api.blocks.IWrenchable
    public Direction getFacing(BlockState blockState, Level level, BlockPos blockPos) {
        if ((level.getBlockEntity(blockPos) instanceof q) && blockState.hasProperty(MCTechProperties.ALL_FACINGS)) {
            return blockState.getValue(MCTechProperties.ALL_FACINGS);
        }
        return Direction.NORTH;
    }

    @Override // mctech.api.blocks.IWrenchable
    public boolean canSetFacing(BlockState blockState, Level level, BlockPos blockPos, Player player, Direction direction) {
        IWrenchableTile blockEntity = level.getBlockEntity(blockPos);
        return (blockEntity instanceof IWrenchableTile) && blockEntity.canSetFacing(direction);
    }

    @Override // mctech.api.blocks.IWrenchable
    public boolean setFacing(BlockState blockState, Level level, BlockPos blockPos, Player player, Direction direction) {
        IWrenchableTile blockEntity = level.getBlockEntity(blockPos);
        if (blockEntity instanceof IWrenchableTile) {
            IWrenchableTile iWrenchableTile = blockEntity;
            if (blockState.hasProperty(MCTechProperties.ALL_FACINGS) && iWrenchableTile.canSetFacing(direction)) {
                level.setBlock(blockPos, (BlockState) blockState.setValue(MCTechProperties.ALL_FACINGS, direction), 3);
                iWrenchableTile.setFacing(direction);
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // mctech.api.blocks.IWrenchable
    public AABB hasSpecialAction(BlockState blockState, Level level, BlockPos blockPos, Direction direction, Player player, Vec3 vec3) {
        IWrenchableTile blockEntity = level.getBlockEntity(blockPos);
        if (blockEntity instanceof IWrenchableTile) {
            return blockEntity.hasSpecialAction(direction, vec3, player);
        }
        return null;
    }

    @Override // mctech.api.blocks.IWrenchable
    public boolean doSpecialAction(BlockState blockState, Level level, BlockPos blockPos, Direction direction, Player player, Vec3 vec3) {
        IWrenchableTile blockEntity = level.getBlockEntity(blockPos);
        return (blockEntity instanceof IWrenchableTile) && blockEntity.doSpecialAction(direction, vec3, player);
    }

    @Override // mctech.api.blocks.IWrenchable
    public boolean canRemoveBlock(BlockState blockState, Level level, BlockPos blockPos, Player player) {
        IWrenchableTile blockEntity = level.getBlockEntity(blockPos);
        return (blockEntity instanceof IWrenchableTile) && blockEntity.canRemoveBlock(player);
    }

    @Override // mctech.api.blocks.IWrenchable
    public double getDropRate(BlockState blockState, Level level, BlockPos blockPos, Player player) {
        IWrenchableTile blockEntity = level.getBlockEntity(blockPos);
        if (blockEntity instanceof IWrenchableTile) {
            return blockEntity.getDropRate(player);
        }
        return 0.0d;
    }

    @Override // mctech.api.blocks.IWrenchable
    public List<ItemStack> getDrops(BlockState blockState, Level level, BlockPos blockPos, Player player) {
        Nameable blockEntity = level.getBlockEntity(blockPos);
        ArrayList arrayList = new ArrayList();
        ItemStack itemStackCreateDrop = createDrop(blockState, ItemStack.EMPTY, level.random, blockEntity, true);
        if (!itemStackCreateDrop.isEmpty()) {
            if ((blockEntity instanceof Nameable) && blockEntity.hasCustomName()) {
                itemStackCreateDrop.set(DataComponents.CUSTOM_NAME, blockEntity.getCustomName());
            }
            arrayList.add(itemStackCreateDrop);
        }
        if (blockEntity instanceof IDropProvider) {
            ((IDropProvider) blockEntity).addDrops(arrayList);
        }
        return arrayList;
    }

    @OnlyIn(Dist.CLIENT)
    public void animateTick(BlockState blockState, Level level, BlockPos blockPos, RandomSource randomSource) {
        if (this.animations) {
            IParticleSpawner blockEntity = level.getBlockEntity(blockPos);
            if (blockEntity instanceof IParticleSpawner) {
                blockEntity.animationTick(randomSource);
            }
        }
    }

    public void setBlockEntityType(BlockEntityType<? extends BlockEntity> blockEntityType) {
        this.blockEntityType = blockEntityType;
    }
}
