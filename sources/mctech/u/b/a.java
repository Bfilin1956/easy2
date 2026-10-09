package mctech.u.b;

import java.util.Set;
import mctech.api.blocks.BlockRegistries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/b/a.class */
public class a implements Runnable {
    public static final Set<TagKey<Block>> a = mctech.utils.a.b.g();
    Set<TagKey<Block>> b = mctech.utils.a.b.g();

    @Override // java.lang.Runnable
    public void run() {
        this.b.clear();
        a(BlockTags.COPPER_ORES, 3);
        a(TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mctech.g.d.d.a.a, "ores/tin")), 3);
        a(TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mctech.g.d.d.a.a, "ores/silver")), 5);
        a(TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mctech.g.d.d.a.a, "ores/uranium")), 6);
        a(TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(mctech.g.d.d.a.a, "ores/aluminium")), 4);
        a(Tags.Blocks.ORES_COAL, 2);
        a(Tags.Blocks.ORES_DIAMOND, 6);
        a(Tags.Blocks.ORES_EMERALD, 6);
        a(Tags.Blocks.ORES_NETHERITE_SCRAP, 6);
        a(Tags.Blocks.ORES_GOLD, 5);
        a(Tags.Blocks.ORES_IRON, 3);
        a(Tags.Blocks.ORES_LAPIS, 4);
        a(Tags.Blocks.ORES_QUARTZ, 4);
        a(Tags.Blocks.ORES_REDSTONE, 5);
        BuiltInRegistries.BLOCK.getTagNames().forEach(tagKey -> {
            if (tagKey.location().getPath().startsWith("ores/")) {
                a(tagKey, 1);
            }
        });
    }

    public void a(TagKey<Block> tagKey, int i) {
        if (a.contains(tagKey) || !this.b.add(tagKey)) {
            return;
        }
        BlockRegistries.registerOre(i, tagKey);
    }
}
