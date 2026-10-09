package mctech.api.blocks;

import com.mojang.serialization.DataResult;
import com.mojang.serialization.DynamicOps;
import com.mojang.serialization.codecs.PrimitiveCodec;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import javax.annotation.Nullable;
import mctech.init.MCTechBlocks;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/blocks/IBlockDropProvider.class */
public interface IBlockDropProvider {
    public static final PrimitiveCodec<IBlockDropProvider> CODEC = new PrimitiveCodec<IBlockDropProvider>() { // from class: mctech.api.blocks.IBlockDropProvider.1
        public <T> DataResult<IBlockDropProvider> read(DynamicOps<T> dynamicOps, T t) {
            return DataResult.success(IBlockDropProvider.PROVIDERS.get(((Integer) dynamicOps.getNumberValue(t).map((v0) -> {
                return v0.intValue();
            }).getOrThrow()).intValue()));
        }

        public <T> T write(DynamicOps<T> dynamicOps, IBlockDropProvider iBlockDropProvider) {
            return (T) dynamicOps.createInt(IBlockDropProvider.PROVIDERS.indexOf(iBlockDropProvider));
        }

        public String toString() {
            return "Drop";
        }
    };
    public static final List<IBlockDropProvider> PROVIDERS = new ArrayList();
    public static final IBlockDropProvider SELF = new SelfProvider();
    public static final IBlockDropProvider SELF_OR_MACHINE = new SelfOrOther(() -> {
        return new ItemStack(MCTechBlocks.MACHINE_BLOCK);
    });
    public static final IBlockDropProvider SELF_OR_ADV_MACHINE = new SelfOrOther(() -> {
        return new ItemStack(MCTechBlocks.ADVANCED_MACHINE_BLOCK);
    });
    public static final IBlockDropProvider SELF_OR_STABLE_MACHINE = new SelfOrOther(() -> {
        return new ItemStack(MCTechBlocks.STABILIZED_MACHINE_BLOCK);
    });
    public static final IBlockDropProvider SELF_OR_GENERATOR = new SelfOrOther(() -> {
        return new ItemStack(MCTechBlocks.GENERATOR);
    });
    public static final IBlockDropProvider SELF_OR_COLOSSAL = new SelfOrOther(() -> {
        return new ItemStack(MCTechBlocks.COLOSSAL_BASE);
    });
    public static final IBlockDropProvider SELF_OR_ENERGY_STORAGE_1 = new SelfOrOther(() -> {
        return new ItemStack(MCTechBlocks.ENERGY_STORAGE_1);
    });
    public static final IBlockDropProvider SELF_OR_ENERGY_STORAGE_2 = new SelfOrOther(() -> {
        return new ItemStack(MCTechBlocks.ENERGY_STORAGE_2);
    });
    public static final IBlockDropProvider SELF_OR_ENERGY_STORAGE_3 = new SelfOrOther(() -> {
        return new ItemStack(MCTechBlocks.ENERGY_STORAGE_3);
    });
    public static final IBlockDropProvider SELF_OR_ENERGY_STORAGE_4 = new SelfOrOther(() -> {
        return new ItemStack(MCTechBlocks.ENERGY_STORAGE_4);
    });
    public static final IBlockDropProvider SELF_OR_ENERGY_STORAGE_5 = new SelfOrOther(() -> {
        return new ItemStack(MCTechBlocks.ENERGY_STORAGE_5);
    });
    public static final IBlockDropProvider SELF_OR_TRANSFORMER_2 = new SelfOrOther(() -> {
        return new ItemStack(MCTechBlocks.TRANSFORMER_2);
    });
    public static final IBlockDropProvider SELF_OR_TRANSFORMER_3 = new SelfOrOther(() -> {
        return new ItemStack(MCTechBlocks.TRANSFORMER_3);
    });
    public static final IBlockDropProvider SELF_OR_TRANSFORMER_4 = new SelfOrOther(() -> {
        return new ItemStack(MCTechBlocks.TRANSFORMER_4);
    });
    public static final IBlockDropProvider SELF_OR_TRANSFORMER_5 = new SelfOrOther(() -> {
        return new ItemStack(MCTechBlocks.TRANSFORMER_5);
    });
    public static final IBlockDropProvider SELF_OR_TRANSFORMER_6 = new SelfOrOther(() -> {
        return new ItemStack(MCTechBlocks.TRANSFORMER_6);
    });
    public static final IBlockDropProvider SELF_OR_TRANSFORMER_7 = new SelfOrOther(() -> {
        return new ItemStack(MCTechBlocks.TRANSFORMER_7);
    });
    public static final IBlockDropProvider SELF_OR_TRANSFORMER_8 = new SelfOrOther(() -> {
        return new ItemStack(MCTechBlocks.TRANSFORMER_8);
    });

    ItemStack createDrop(BlockState blockState, ItemStack itemStack, RandomSource randomSource, @Nullable BlockEntity blockEntity, boolean z);

    static IBlockDropProvider custom(Supplier<ItemStack> supplier) {
        return new CustomProvider(supplier);
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/blocks/IBlockDropProvider$SelfOrOther.class */
    public static class SelfOrOther implements IBlockDropProvider {
        Supplier<ItemStack> drop;

        public SelfOrOther() {
            PROVIDERS.add(this);
        }

        public SelfOrOther(Supplier<ItemStack> supplier) {
            this.drop = supplier;
        }

        @Override // mctech.api.blocks.IBlockDropProvider
        public ItemStack createDrop(BlockState blockState, ItemStack itemStack, RandomSource randomSource, BlockEntity blockEntity, boolean z) {
            return z ? new ItemStack(blockState.getBlock()) : this.drop.get();
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/blocks/IBlockDropProvider$CustomProvider.class */
    public static class CustomProvider implements IBlockDropProvider {
        Supplier<ItemStack> drop;

        public CustomProvider() {
            PROVIDERS.add(this);
        }

        public CustomProvider(Supplier<ItemStack> supplier) {
            this.drop = supplier;
        }

        @Override // mctech.api.blocks.IBlockDropProvider
        public ItemStack createDrop(BlockState blockState, ItemStack itemStack, RandomSource randomSource, BlockEntity blockEntity, boolean z) {
            return this.drop.get();
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/blocks/IBlockDropProvider$SelfProvider.class */
    public static class SelfProvider implements IBlockDropProvider {
        public SelfProvider() {
            PROVIDERS.add(this);
        }

        @Override // mctech.api.blocks.IBlockDropProvider
        public ItemStack createDrop(BlockState blockState, ItemStack itemStack, RandomSource randomSource, BlockEntity blockEntity, boolean z) {
            return new ItemStack(blockState.getBlock());
        }
    }
}
