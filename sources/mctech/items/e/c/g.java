package mctech.items.e.c;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/e/c/g.class */
public class g extends SwordItem {
    private static final Tier a = new SimpleTier(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 2031, 9.0f, 4.0f, 15, () -> {
        return Ingredient.EMPTY;
    });

    public g(Item.Properties properties) {
        super(a, properties);
    }
}
