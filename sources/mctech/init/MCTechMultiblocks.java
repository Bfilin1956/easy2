package mctech.init;

import java.util.Objects;
import mctech.MCTech;
import mctech.blocks.d.a;
import mctech.p.a.d;
import mctech.p.a.e;
import net.mcskill.msregistry.registry.holder.LBlock;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/init/MCTechMultiblocks.class */
public class MCTechMultiblocks {
    public static final d MOLECULAR_CONVERTER;

    static {
        d.b bVarA = d.a(MCTech.loc("molecular_converter")).a("ff", "ff").a("gg", "gg").a("ff", "ff").a('f', (LBlock) MCTechBlocks.MOLECULAR_CONVERTER_FRAME_BLOCK).a('g', (LBlock) MCTechBlocks.MOLECULAR_CONVERTER_GLASS_BLOCK).a((DeferredBlock<? extends Block>) MCTechBlocks.MOLECULAR_CONVERTER);
        LBlock<a> lBlock = MCTechBlocks.MOLECULAR_CONVERTER_CORE_BLOCK;
        Objects.requireNonNull(lBlock);
        MOLECULAR_CONVERTER = e.a(bVarA.a(lBlock::asItem).a(true).a());
    }

    public static void init() {
    }
}
