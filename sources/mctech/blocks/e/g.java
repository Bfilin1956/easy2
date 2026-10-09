package mctech.blocks.e;

import java.util.ArrayList;
import java.util.List;
import mctech.init.MCTechBlocks;
import mctech.utils.m;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShearsItem;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blocks/e/g.class */
public class g extends LeavesBlock implements mctech.blocks.base.a {
    public g() {
        super(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).strength(0.2f).randomTicks().sound(SoundType.GRASS).noOcclusion().isValidSpawn(Blocks::ocelotOrParrot).isSuffocating((blockState, blockGetter, blockPos) -> {
            return false;
        }).isViewBlocking((blockState2, blockGetter2, blockPos2) -> {
            return false;
        }).ignitedByLava().pushReaction(PushReaction.DESTROY).isRedstoneConductor((blockState3, blockGetter3, blockPos3) -> {
            return false;
        }));
    }

    @Override // mctech.blocks.base.a
    public mctech.items.base.g createItem() {
        return new mctech.items.base.g(this);
    }

    public int getFlammability(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, Direction direction) {
        return 30;
    }

    public int getFireSpreadSpeed(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, Direction direction) {
        return 60;
    }

    @OnlyIn(Dist.CLIENT)
    public int a(ItemStack itemStack, int i) {
        return 8431445;
    }

    @OnlyIn(Dist.CLIENT)
    public int a(BlockState blockState, BlockAndTintGetter blockAndTintGetter, BlockPos blockPos, int i) {
        return 8431445;
    }

    public List<ItemStack> getDrops(BlockState blockState, LootParams.Builder builder) {
        LootTable lootTable = builder.getLevel().getServer().reloadableRegistries().getLootTable(getLootTable());
        if (lootTable != LootTable.EMPTY) {
            return lootTable.getRandomItems(builder.withParameter(LootContextParams.BLOCK_STATE, blockState).create(LootContextParamSets.BLOCK));
        }
        ArrayList arrayList = new ArrayList();
        ItemStack itemStack = (ItemStack) builder.getOptionalParameter(LootContextParams.TOOL);
        if ((itemStack.getItem() instanceof ShearsItem) || m.a(Enchantments.SILK_TOUCH, itemStack, builder.getLevel()) > 0) {
            arrayList.add(new ItemStack(this));
        }
        if (builder.getLevel().getRandom().nextInt(35) == 0) {
            arrayList.add(new ItemStack(MCTechBlocks.RUBBER_SAPLING));
        }
        return arrayList;
    }
}
