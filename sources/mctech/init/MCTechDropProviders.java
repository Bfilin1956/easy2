package mctech.init;

import java.util.function.Supplier;
import mctech.api.blocks.IBlockDropProvider;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/init/MCTechDropProviders.class */
public class MCTechDropProviders {
    public static final IBlockDropProvider SELF_OR_COMPOSITE_MACHINE = register(MCTechBlocks.COMPOSITE_MACHINE_BLOCK);
    public static final IBlockDropProvider SELF_OR_NANO_MACHINE = register(MCTechBlocks.NANO_MACHINE_BLOCK);
    public static final IBlockDropProvider SELF_OR_QUANTUM_MACHINE = register(MCTechBlocks.QUANTUM_MACHINE_BLOCK);
    public static final IBlockDropProvider SELF_OR_SINGULAR_MACHINE = register(MCTechBlocks.SINGULAR_MACHINE_BLOCK);
    public static final IBlockDropProvider SELF_OR_ADMIN_MACHINE = register(MCTechBlocks.ADMIN_MACHINE_BLOCK);

    private static IBlockDropProvider register(Supplier<? extends Block> supplier) {
        return new IBlockDropProvider.SelfOrOther(() -> {
            return new ItemStack((ItemLike) supplier.get());
        });
    }
}
