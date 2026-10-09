package mctech.api.blocks;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import it.unimi.dsi.fastutil.objects.ObjectLinkedOpenHashSet;
import it.unimi.dsi.fastutil.objects.ObjectLists;
import it.unimi.dsi.fastutil.objects.ObjectSet;
import it.unimi.dsi.fastutil.objects.ObjectSets;
import java.util.List;
import java.util.Set;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/blocks/BlockRegistries.class */
public class BlockRegistries {
    static final Object2IntMap<Block> ORE_VALUES = new Object2IntOpenHashMap();
    static final Int2ObjectMap<ObjectSet<Block>> VALUES_TO_ORES = new Int2ObjectOpenHashMap();
    static final List<Runnable> LISTENERS = ObjectLists.synchronize(new ObjectArrayList());

    public static void registerListener(Runnable runnable) {
        LISTENERS.add(runnable);
    }

    public static void reload() {
        ORE_VALUES.clear();
        VALUES_TO_ORES.clear();
        LISTENERS.forEach((v0) -> {
            v0.run();
        });
        ObjectIterator it = ORE_VALUES.object2IntEntrySet().iterator();
        while (it.hasNext()) {
            Object2IntMap.Entry entry = (Object2IntMap.Entry) it.next();
            ObjectLinkedOpenHashSet objectLinkedOpenHashSet = (ObjectSet) VALUES_TO_ORES.get(entry.getIntValue());
            if (objectLinkedOpenHashSet == null) {
                objectLinkedOpenHashSet = new ObjectLinkedOpenHashSet();
                VALUES_TO_ORES.put(entry.getIntValue(), objectLinkedOpenHashSet);
            }
            objectLinkedOpenHashSet.add((Block) entry.getKey());
        }
    }

    public static void registerOre(int i, TagKey<Block> tagKey) {
        BuiltInRegistries.BLOCK.getTag(tagKey).ifPresent(named -> {
            named.forEach(holder -> {
                ORE_VALUES.put((Block) holder.value(), i);
            });
        });
    }

    public static void registerOre(int i, Block... blockArr) {
        for (Block block : blockArr) {
            ORE_VALUES.put(block, i);
        }
    }

    public static Set<Block> getBlocksForOreValue(int i) {
        return ObjectSets.unmodifiable((ObjectSet) VALUES_TO_ORES.getOrDefault(i, ObjectSets.emptySet()));
    }

    public static int getOreValue(BlockState blockState) {
        return ORE_VALUES.getInt(blockState.getBlock());
    }

    public static int getOreValue(Block block) {
        return ORE_VALUES.getInt(block);
    }

    public static List<Block> getAllValueBlocks() {
        return new ObjectArrayList(ORE_VALUES.keySet());
    }
}
