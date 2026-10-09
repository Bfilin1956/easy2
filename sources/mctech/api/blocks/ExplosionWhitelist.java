package mctech.api.blocks;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import java.util.Set;
import net.minecraft.world.level.block.Block;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/blocks/ExplosionWhitelist.class */
public class ExplosionWhitelist {
    static final Set<Block> WHITELIST = new ObjectOpenHashSet();

    public static void addWhitelist(Block... blockArr) {
        WHITELIST.addAll(ObjectArrayList.wrap(blockArr));
    }

    public static void removeWhitelist(Block... blockArr) {
        WHITELIST.removeAll(ObjectArrayList.wrap(blockArr));
    }

    public static boolean isWhitelisted(Block block) {
        return WHITELIST.contains(block);
    }
}
