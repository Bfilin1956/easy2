package mctech.blocks;

import com.mojang.serialization.MapCodec;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import mctech.items.base.g;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootParams;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blocks/c.class */
public class c extends FallingBlock implements mctech.blocks.base.a {
    public static final MapCodec<c> a = simpleCodec(c::new);

    public c(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override // mctech.blocks.base.a
    public g createItem() {
        return new g(this);
    }

    public List<ItemStack> getDrops(BlockState blockState, LootParams.Builder builder) {
        return new ArrayList();
    }

    public ItemStack a(BlockState blockState, ItemStack itemStack, RandomSource randomSource, @Nullable BlockEntity blockEntity) {
        return new ItemStack(this);
    }

    public void a(List<ItemStack> list, BlockState blockState, ItemStack itemStack, RandomSource randomSource) {
    }

    protected MapCodec<? extends FallingBlock> codec() {
        return a;
    }
}
