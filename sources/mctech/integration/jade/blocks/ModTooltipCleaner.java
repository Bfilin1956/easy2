package mctech.integration.jade.blocks;

import mctech.MCTech;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import snownee.jade.api.BlockAccessor;
import snownee.jade.api.EntityAccessor;
import snownee.jade.api.IBlockComponentProvider;
import snownee.jade.api.IEntityComponentProvider;
import snownee.jade.api.ITooltip;
import snownee.jade.api.JadeIds;
import snownee.jade.api.config.IPluginConfig;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/integration/jade/blocks/ModTooltipCleaner.class */
public class ModTooltipCleaner {

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/integration/jade/blocks/ModTooltipCleaner$Block.class */
    public static class Block implements IBlockComponentProvider {
        public static final Block TAIL = new Block(10000);
        public static final Block HEAD = new Block(-10000);
        private final int priority;

        public Block(int i) {
            this.priority = i;
        }

        public void appendTooltip(ITooltip iTooltip, BlockAccessor blockAccessor, IPluginConfig iPluginConfig) {
            if (BuiltInRegistries.BLOCK.getKey(blockAccessor.getBlock()).getNamespace().equals(MCTech.MODID)) {
                iTooltip.remove(JadeIds.CORE_MOD_NAME);
            }
        }

        public ResourceLocation getUid() {
            return ResourceLocation.fromNamespaceAndPath(MCTech.MODID, String.format("jade_block_mod_name_remover_%s", Integer.valueOf(this.priority)));
        }

        public int getDefaultPriority() {
            return this.priority;
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/integration/jade/blocks/ModTooltipCleaner$Item.class */
    public static class Item implements IEntityComponentProvider {
        public static final Item TAIL = new Item(10000);
        public static final Item HEAD = new Item(-10000);
        private final int priority;

        public Item(int i) {
            this.priority = i;
        }

        public void appendTooltip(ITooltip iTooltip, EntityAccessor entityAccessor, IPluginConfig iPluginConfig) {
            ItemEntity entity = entityAccessor.getEntity();
            if (entity instanceof ItemEntity) {
                ItemStack item = entity.getItem();
                if (!item.isEmpty() && BuiltInRegistries.ITEM.getKey(item.getItem()).getNamespace().equals(MCTech.MODID)) {
                    iTooltip.remove(JadeIds.CORE_MOD_NAME);
                }
            }
        }

        public ResourceLocation getUid() {
            return ResourceLocation.fromNamespaceAndPath(MCTech.MODID, String.format("jade_item_mod_name_remover_%s", Integer.valueOf(this.priority)));
        }

        public int getDefaultPriority() {
            return this.priority;
        }
    }
}
