package mctech.api.blocks;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import java.util.List;
import java.util.Map;
import mctech.api.blocks.wrench.ChestWrenchHandler;
import mctech.api.blocks.wrench.DispenserWrenchHandler;
import mctech.api.blocks.wrench.HopperWrenchHandler;
import mctech.api.blocks.wrench.HorizontalWrenchHandler;
import mctech.api.blocks.wrench.InvertedHorizontalWrenchHandler;
import mctech.api.blocks.wrench.ObserverBlockWrenchHandler;
import mctech.api.blocks.wrench.PillarWrenchHandler;
import mctech.api.blocks.wrench.PistonWrenchHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/blocks/IWrenchable.class */
public interface IWrenchable {
    Direction getFacing(BlockState blockState, Level level, BlockPos blockPos);

    boolean canSetFacing(BlockState blockState, Level level, BlockPos blockPos, Player player, Direction direction);

    boolean setFacing(BlockState blockState, Level level, BlockPos blockPos, Player player, Direction direction);

    boolean doSpecialAction(BlockState blockState, Level level, BlockPos blockPos, Direction direction, Player player, Vec3 vec3);

    AABB hasSpecialAction(BlockState blockState, Level level, BlockPos blockPos, Direction direction, Player player, Vec3 vec3);

    boolean canRemoveBlock(BlockState blockState, Level level, BlockPos blockPos, Player player);

    double getDropRate(BlockState blockState, Level level, BlockPos blockPos, Player player);

    List<ItemStack> getDrops(BlockState blockState, Level level, BlockPos blockPos, Player player);

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/blocks/IWrenchable$WrenchRegistry.class */
    public static final class WrenchRegistry {
        public static final WrenchRegistry INSTANCE = new WrenchRegistry();
        private final Map<Block, IWrenchable> wrenchableBlocks = new Object2ObjectOpenHashMap();

        public void init() {
            registerWrenchHandler(PistonWrenchHandler.INSTANCE, Blocks.PISTON, Blocks.STICKY_PISTON);
            registerWrenchHandler(ObserverBlockWrenchHandler.INSTANCE, Blocks.OBSERVER);
            registerWrenchHandler(ChestWrenchHandler.INSTANCE, Blocks.CHEST, Blocks.ENDER_CHEST, Blocks.TRAPPED_CHEST);
            registerWrenchHandler(HorizontalWrenchHandler.INSTANCE, Blocks.FURNACE, Blocks.BLAST_FURNACE, Blocks.SMOKER);
            registerWrenchHandler(InvertedHorizontalWrenchHandler.INSTANCE, Blocks.REPEATER, Blocks.COMPARATOR);
            registerWrenchHandler(PillarWrenchHandler.INSTANCE, Blocks.ACACIA_LOG, Blocks.BIRCH_LOG, Blocks.DARK_OAK_LOG, Blocks.JUNGLE_LOG, Blocks.OAK_LOG, Blocks.SPRUCE_LOG, Blocks.STRIPPED_ACACIA_LOG, Blocks.STRIPPED_BIRCH_LOG, Blocks.STRIPPED_DARK_OAK_LOG, Blocks.STRIPPED_JUNGLE_LOG, Blocks.STRIPPED_OAK_LOG, Blocks.STRIPPED_SPRUCE_LOG);
            registerWrenchHandler(DispenserWrenchHandler.INSTANCE, Blocks.DISPENSER, Blocks.DROPPER);
            registerWrenchHandler(HopperWrenchHandler.INSTANCE, Blocks.HOPPER);
        }

        public void registerWrenchHandler(IWrenchable iWrenchable, Block... blockArr) {
            for (Block block : blockArr) {
                this.wrenchableBlocks.put(block, iWrenchable);
            }
        }

        public IWrenchable getWrenchable(BlockState blockState) {
            IWrenchable block = blockState.getBlock();
            return this.wrenchableBlocks.getOrDefault(block, block instanceof IWrenchable ? block : null);
        }
    }
}
