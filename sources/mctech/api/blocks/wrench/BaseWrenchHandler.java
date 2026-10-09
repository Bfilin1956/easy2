package mctech.api.blocks.wrench;

import it.unimi.dsi.fastutil.objects.ObjectLists;
import java.util.List;
import mctech.api.blocks.IWrenchable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/blocks/wrench/BaseWrenchHandler.class */
public abstract class BaseWrenchHandler implements IWrenchable {
    @Override // mctech.api.blocks.IWrenchable
    public boolean doSpecialAction(BlockState blockState, Level level, BlockPos blockPos, Direction direction, Player player, Vec3 vec3) {
        return false;
    }

    @Override // mctech.api.blocks.IWrenchable
    public AABB hasSpecialAction(BlockState blockState, Level level, BlockPos blockPos, Direction direction, Player player, Vec3 vec3) {
        return null;
    }

    @Override // mctech.api.blocks.IWrenchable
    public boolean canRemoveBlock(BlockState blockState, Level level, BlockPos blockPos, Player player) {
        return false;
    }

    @Override // mctech.api.blocks.IWrenchable
    public double getDropRate(BlockState blockState, Level level, BlockPos blockPos, Player player) {
        return 0.0d;
    }

    @Override // mctech.api.blocks.IWrenchable
    public List<ItemStack> getDrops(BlockState blockState, Level level, BlockPos blockPos, Player player) {
        if (!(level instanceof ServerLevel)) {
            return ObjectLists.emptyList();
        }
        return Block.getDrops(blockState, (ServerLevel) level, blockPos, (BlockEntity) null);
    }
}
