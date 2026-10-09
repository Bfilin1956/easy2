package mctech.blocks.c;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;
import javax.annotation.Nullable;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blocks/c/v.class */
public class v extends mctech.blocks.b {
    private final MachineTier c;

    public v(MachineTier machineTier, BlockBehaviour.Properties properties) {
        super(properties);
        this.c = machineTier;
        registerDefaultState((BlockState) ((BlockState) ((BlockState) this.stateDefinition.any().setValue(FACING, Direction.NORTH)).setValue(mctech.i.i.m, mctech.i.i.ORE_MACERATOR)).setValue(MachineTier.PROPERTY, machineTier));
    }

    @Override // mctech.blocks.base.blocks.BaseActivityBlock, mctech.blocks.base.blocks.BaseFacingBlock
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(new Property[]{mctech.i.i.m, MachineTier.PROPERTY});
    }

    @Override // mctech.blocks.base.blocks.BaseFacingBlock
    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        return (BlockState) ((BlockState) defaultBlockState().setValue(FACING, blockPlaceContext.getHorizontalDirection().getOpposite())).setValue(ACTIVE, false);
    }

    @NotNull
    public static String a(MachineTier machineTier) {
        return String.format("%s_ore_macerator", machineTier.name);
    }

    @Override // mctech.blocks.base.e
    @NotNull
    public List<ItemStack> getDrops(BlockState blockState, LootParams.Builder builder) {
        mctech.m.e.e eVar = (BlockEntity) builder.getOptionalParameter(LootContextParams.BLOCK_ENTITY);
        if (eVar instanceof mctech.m.e.e) {
            mctech.m.e.e eVar2 = eVar;
            if (eVar instanceof mctech.m.a.g) {
                mctech.m.a.g gVar = (mctech.m.a.g) eVar;
                ItemStack itemStack = new ItemStack(this);
                IntStream intStream = eVar2.getInventoryHandler().h().intStream();
                Objects.requireNonNull(gVar);
                ArrayList arrayList = new ArrayList(intStream.mapToObj(gVar::getStackInSlot).filter(itemStack2 -> {
                    return !itemStack2.isEmpty();
                }).toList());
                arrayList.add(itemStack);
                return arrayList;
            }
        }
        return super.getDrops(blockState, builder);
    }

    @Override // mctech.blocks.base.e
    public void onNeighborChange(BlockState blockState, LevelReader levelReader, BlockPos blockPos, BlockPos blockPos2) {
        super.onNeighborChange(blockState, levelReader, blockPos, blockPos2);
    }

    public MachineTier a() {
        return this.c;
    }
}
