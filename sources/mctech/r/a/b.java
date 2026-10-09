package mctech.r.a;

import java.util.HashMap;
import java.util.Map;
import mctech.blockentities.c.C0055b;
import mctech.blocks.c.C0082c;
import mctech.init.MCTechBlocks;
import mctech.init.MCTechCreativeTabs;
import mctech.init.MCTechTiles;
import net.mcskill.msregistry.registry.holder.LBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/r/a/b.class */
public class b {
    private static final Map<String, LBlock<? extends Block>> b = new HashMap();
    public static final Map<String, DeferredHolder<BlockEntityType<?>, BlockEntityType<C0055b>>> a = new HashMap();

    public static void a(d dVar, c cVar) {
        String strA = dVar.a(cVar);
        b.put(strA, MCTechBlocks.registerItemBlock(strA, C0082c::new, MCTechCreativeTabs.MACHINES));
        a.put(strA, MCTechTiles.registerBlockEntityAndGet(strA, C0055b.class, (blockEntityType, blockPos, blockState) -> {
            C0055b c0055b = new C0055b(blockEntityType, blockPos, blockState);
            c0055b.a(cVar);
            c0055b.a(dVar);
            c0055b.a(cVar.d(), cVar.e());
            c0055b.setSlotCount((cVar.e() * (dVar.b() + 1)) + 4);
            c0055b.a(cVar.h());
            c0055b.a(dVar.b());
            return c0055b;
        }, (DeferredBlock) b.get(strA)));
    }

    public static LBlock<? extends Block> b(d dVar, c cVar) {
        return b.get(dVar.a(cVar));
    }
}
