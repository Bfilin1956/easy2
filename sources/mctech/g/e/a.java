package mctech.g.e;

import net.mcskill.msregistry.datagen.DataGenContext;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/e/a.class */
public class a {
    public static void a(BlockStateProvider blockStateProvider, DataGenContext<Block, ? extends Block> dataGenContext) {
        blockStateProvider.simpleBlock((Block) dataGenContext.get(), ((c) blockStateProvider.models().getBuilder(dataGenContext.getName()).customLoader((v0, v1) -> {
            return c.a(v0, v1);
        })).end());
    }
}
