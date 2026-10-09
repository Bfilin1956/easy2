package mctech.blocks.c;

import com.mojang.serialization.MapCodec;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;
import javax.annotation.Nullable;
import mctech.blockentities.c.J;
import mctech.init.MCTechCodecs;
import mctech.init.MCTechTiles;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blocks/c/z.class */
public class z extends mctech.blocks.b {
    public z(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override // mctech.blocks.b
    @NotNull
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return MCTechCodecs.PATTERN_TRANSFORMATION_ASSEMBLER_ENCODER_BLOCK_CODEC;
    }

    @Override // mctech.blocks.base.e
    @Nullable
    public BlockEntity newBlockEntity(@NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        return ((BlockEntityType) MCTechTiles.PATTERN_TRANSFORMATION_ASSEMBLER_ENCODER.get()).create(blockPos, blockState);
    }

    @Override // mctech.blocks.base.e
    @NotNull
    public List<ItemStack> getDrops(@NotNull BlockState blockState, LootParams.Builder builder) {
        BlockEntity blockEntity = (BlockEntity) builder.getOptionalParameter(LootContextParams.BLOCK_ENTITY);
        if (blockEntity instanceof J) {
            J j = (J) blockEntity;
            ItemStack itemStack = new ItemStack(this);
            ArrayList arrayList = new ArrayList();
            arrayList.add(itemStack);
            Stream<ItemStack> streamU_ = j.e().U_();
            Objects.requireNonNull(arrayList);
            streamU_.forEach((v1) -> {
                r1.add(v1);
            });
            return arrayList;
        }
        return List.of(new ItemStack(this));
    }
}
