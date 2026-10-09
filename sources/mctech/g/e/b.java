package mctech.g.e;

import java.util.concurrent.CompletableFuture;
import mctech.MCTech;
import mctech.init.MCTechBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/e/b.class */
public class b extends BlockTagsProvider {
    public b(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> completableFuture, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, completableFuture, MCTech.MODID, existingFileHelper);
    }

    protected void addTags(HolderLookup.Provider provider) {
        tag(mctech.g.d.d.a.C0016a.a).add(new Block[]{Blocks.PISTON, Blocks.STICKY_PISTON, Blocks.REDSTONE_LAMP, Blocks.NOTE_BLOCK, Blocks.DISPENSER, Blocks.DROPPER, Blocks.POWERED_RAIL, Blocks.ACTIVATOR_RAIL, Blocks.MOVING_PISTON, Blocks.COPPER_BULB, Blocks.EXPOSED_COPPER_BULB, Blocks.WEATHERED_COPPER_BULB, Blocks.OXIDIZED_COPPER_BULB, Blocks.WAXED_COPPER_BULB, Blocks.WAXED_EXPOSED_COPPER_BULB, Blocks.WAXED_WEATHERED_COPPER_BULB, Blocks.WAXED_OXIDIZED_COPPER_BULB, Blocks.CRAFTER, (Block) MCTechBlocks.THERMONUCLEAR_REACTOR.get()}).addTags(new TagKey[]{BlockTags.DOORS, BlockTags.TRAPDOORS, BlockTags.REDSTONE_ORES});
        tag(mctech.g.d.d.a.C0016a.b).add((Block) MCTechBlocks.CONDUIT.get());
    }
}
