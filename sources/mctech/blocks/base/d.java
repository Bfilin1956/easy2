package mctech.blocks.base;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import java.util.Optional;
import javax.annotation.Nullable;
import mctech.api.blocks.IRarityProvider;
import mctech.api.features.IDropProvider;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Nameable;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.HitResult;
import net.neoforged.neoforge.common.CommonHooks;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blocks/base/d.class */
public abstract class d extends Block implements IRarityProvider, a, mctech.utils.d.b, mctech.utils.e.b {
    Rarity b;
    protected ResourceLocation c;

    public d(BlockBehaviour.Properties properties) {
        super(properties);
        this.b = null;
    }

    public boolean canSurvive(BlockState blockState, LevelReader levelReader, BlockPos blockPos) {
        return super.canSurvive(blockState, levelReader, blockPos);
    }

    public d a(Rarity rarity) {
        this.b = rarity;
        return this;
    }

    @Override // mctech.api.blocks.IRarityProvider
    public Rarity getRarity(ItemStack itemStack) {
        return this.b;
    }

    @Override // mctech.utils.d.b
    public ResourceLocation b() {
        return this.c;
    }

    @Override // mctech.utils.d.b
    public void a(ResourceLocation resourceLocation) {
        if (this.c == null) {
            this.c = resourceLocation;
        }
    }

    public ItemStack getCloneItemStack(BlockState blockState, HitResult hitResult, LevelReader levelReader, BlockPos blockPos, Player player) {
        ItemStack cloneItemStack = super.getCloneItemStack(blockState, hitResult, levelReader, blockPos, player);
        Nameable blockEntity = levelReader.getBlockEntity(blockPos);
        if (blockEntity instanceof Nameable) {
            Nameable nameable = blockEntity;
            if (nameable.hasCustomName()) {
                cloneItemStack.set(DataComponents.CUSTOM_NAME, nameable.getCustomName());
            }
        }
        return cloneItemStack;
    }

    public List<ItemStack> getDrops(BlockState blockState, LootParams.Builder builder) {
        LootTable lootTable = builder.getLevel().getServer().reloadableRegistries().getLootTable(getLootTable());
        if (lootTable != LootTable.EMPTY) {
            return lootTable.getRandomItems(builder.withParameter(LootContextParams.BLOCK_STATE, blockState).create(LootContextParamSets.BLOCK));
        }
        List<ItemStack> objectArrayList = new ObjectArrayList<>();
        Nameable nameable = (BlockEntity) builder.getOptionalParameter(LootContextParams.BLOCK_ENTITY);
        ItemStack itemStackA = a(blockState, (ItemStack) builder.getOptionalParameter(LootContextParams.TOOL), builder.getLevel().getRandom(), (BlockEntity) nameable);
        if (!itemStackA.isEmpty()) {
            if ((nameable instanceof Nameable) && nameable.hasCustomName()) {
                itemStackA.set(DataComponents.CUSTOM_NAME, nameable.getCustomName());
            }
            objectArrayList.add(itemStackA);
        }
        a(objectArrayList, blockState, itemStackA, builder.getLevel().getRandom());
        if (nameable instanceof IDropProvider) {
            ((IDropProvider) nameable).addDrops(objectArrayList);
        }
        CommonHooks.modifyLoot(getLootTable().location(), objectArrayList, new LootContext.Builder(builder.withParameter(LootContextParams.BLOCK_STATE, blockState).create(LootContextParamSets.BLOCK)).create(Optional.empty()));
        ResourceKey lootTable2 = blockState.getBlock().getLootTable();
        if (lootTable2 != BuiltInLootTables.EMPTY) {
            LootParams lootParamsCreate = builder.withParameter(LootContextParams.BLOCK_STATE, blockState).create(LootContextParamSets.BLOCK);
            LootTable lootTable3 = lootParamsCreate.getLevel().getServer().reloadableRegistries().getLootTable(lootTable2);
            ObjectArrayList objectArrayListModifyLoot = CommonHooks.modifyLoot(lootTable3.getLootTableId(), new ObjectArrayList(objectArrayList), new LootContext.Builder(lootParamsCreate).create(Optional.empty()));
            objectArrayList.clear();
            objectArrayList.addAll(objectArrayListModifyLoot);
        }
        return objectArrayList;
    }

    public ItemStack a(BlockState blockState, ItemStack itemStack, RandomSource randomSource, @Nullable BlockEntity blockEntity) {
        return new ItemStack(this);
    }

    public void a(List<ItemStack> list, BlockState blockState, ItemStack itemStack, RandomSource randomSource) {
    }
}
