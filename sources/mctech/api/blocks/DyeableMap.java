package mctech.api.blocks;

import it.unimi.dsi.fastutil.objects.Object2ObjectLinkedOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectLinkedOpenHashSet;
import it.unimi.dsi.fastutil.objects.ObjectSet;
import it.unimi.dsi.fastutil.objects.ObjectSets;
import java.util.Map;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/blocks/DyeableMap.class */
public class DyeableMap {
    Map<Block, DyeColor> blockToColor = new Object2ObjectLinkedOpenHashMap();
    Map<DyeColor, Block> colorToBlock = new Object2ObjectLinkedOpenHashMap();
    ObjectSet<Block> blocks = new ObjectLinkedOpenHashSet();

    public void addBlock(Block block, DyeColor dyeColor) {
        this.blocks.add(block);
        this.blockToColor.put(block, dyeColor);
        this.colorToBlock.put(dyeColor, block);
    }

    public void addBlocks(Map<Block, DyeColor> map) {
        this.blocks.addAll(map.keySet());
        this.blockToColor.putAll(map);
        for (Map.Entry<Block, DyeColor> entry : map.entrySet()) {
            this.colorToBlock.put(entry.getValue(), entry.getKey());
        }
    }

    public void addReverseBlocks(Map<DyeColor, Block> map) {
        this.blocks.addAll(map.values());
        this.colorToBlock.putAll(map);
        for (Map.Entry<DyeColor, Block> entry : map.entrySet()) {
            this.blockToColor.put(entry.getValue(), entry.getKey());
        }
    }

    public Block getBlock(DyeColor dyeColor) {
        return this.colorToBlock.get(dyeColor);
    }

    public Block getBlock(DyeColor dyeColor, Block block) {
        return this.colorToBlock.getOrDefault(dyeColor, block);
    }

    public DyeColor getColor(Block block) {
        return this.blockToColor.get(block);
    }

    public ObjectSet<Block> getBlocks() {
        return ObjectSets.unmodifiable(this.blocks);
    }

    public Block[] getBlockArray() {
        return (Block[]) this.blocks.toArray(i -> {
            return new Block[i];
        });
    }

    public boolean contains(Block block) {
        return this.blocks.contains(block);
    }
}
