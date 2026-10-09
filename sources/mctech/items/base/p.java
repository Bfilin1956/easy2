package mctech.items.base;

import mctech.init.MCTechItems;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/base/p.class */
public class p implements Tier {
    public static final p a = new p(300, 6.0f, 2.0f, BlockTags.INCORRECT_FOR_IRON_TOOL, 14, Ingredient.of(new ItemLike[]{MCTechItems.INGOT_BRONZE}));
    public static final p b = new p(200, 6.0f, 2.0f, BlockTags.INCORRECT_FOR_IRON_TOOL, 14, Ingredient.of(new ItemLike[]{MCTechItems.INGOT_TIN}));
    public static final p c = new p(200, 6.0f, 2.0f, BlockTags.INCORRECT_FOR_IRON_TOOL, 14, Ingredient.of(new ItemLike[]{MCTechItems.INGOT_BRONZE}));
    private final int d;
    private final float e;
    private final float f;
    private final TagKey<Block> g;
    private final int h;
    private final Ingredient i;

    public p(int i, float f, float f2, TagKey<Block> tagKey, int i2, Ingredient ingredient) {
        this.d = i;
        this.e = f;
        this.f = f2;
        this.g = tagKey;
        this.h = i2;
        this.i = ingredient;
    }

    public int getUses() {
        return this.d;
    }

    public float getSpeed() {
        return this.e;
    }

    public float getAttackDamageBonus() {
        return this.f;
    }

    public int getEnchantmentValue() {
        return this.h;
    }

    @NotNull
    public Ingredient getRepairIngredient() {
        return this.i;
    }

    @NotNull
    public TagKey<Block> getIncorrectBlocksForDrops() {
        return this.g;
    }
}
