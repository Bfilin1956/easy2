package mctech.blocks.e;

import java.util.Collections;
import java.util.List;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blocks/e/b.class */
public class b extends Block {
    public b(BlockBehaviour.Properties properties) {
        super(properties);
    }

    public float getDestroyProgress(@NotNull BlockState blockState, Player player, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos) {
        ItemStack mainHandItem = player.getMainHandItem();
        if (!a(mainHandItem, blockState)) {
            return 0.0f;
        }
        float destroySpeed = blockState.getDestroySpeed(blockGetter, blockPos);
        if (destroySpeed < 0.0f) {
            return 0.0f;
        }
        float fMax = Math.max(player.getDestroySpeed(blockState), mainHandItem.getDestroySpeed(blockState));
        if (fMax <= 0.0f) {
            return 0.0f;
        }
        return (fMax / destroySpeed) / 30.0f;
    }

    @NotNull
    public List<ItemStack> getDrops(@NotNull BlockState blockState, LootParams.Builder builder) {
        if (a((ItemStack) builder.getOptionalParameter(LootContextParams.TOOL), blockState)) {
            return super.getDrops(blockState, builder);
        }
        return Collections.emptyList();
    }

    private boolean a(ItemStack itemStack, BlockState blockState) {
        if (itemStack == null || itemStack.isEmpty()) {
            return false;
        }
        if ((itemStack.getItem() instanceof mctech.items.e.c.b) || (itemStack.getItem() instanceof mctech.items.e.c.d)) {
            return true;
        }
        mctech.items.e.c item = itemStack.getItem();
        if (!(item instanceof mctech.items.e.c)) {
            return false;
        }
        return item.isCorrectToolForDrops(itemStack, blockState);
    }

    public boolean a(ItemStack itemStack) {
        return false;
    }
}
