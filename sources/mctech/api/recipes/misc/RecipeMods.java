package mctech.api.recipes.misc;

import mctech.init.MCTechDataComponent;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredHolder;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/recipes/misc/RecipeMods.class */
public enum RecipeMods {
    ENERGY_USAGE(MCTechDataComponent.ENERGY_MOD, MCTechDataComponent.ENERGY_ADD),
    RECIPE_TIME(MCTechDataComponent.TIME_MOD, MCTechDataComponent.TIME_ADD);

    DeferredHolder<DataComponentType<?>, DataComponentType<Double>> mod_tag;
    DeferredHolder<DataComponentType<?>, DataComponentType<Integer>> add_tag;

    RecipeMods(DeferredHolder deferredHolder, DeferredHolder deferredHolder2) {
        this.mod_tag = deferredHolder;
        this.add_tag = deferredHolder2;
    }

    public int apply(ItemStack itemStack, int i) {
        long jRound = Math.round(((double) (i + ((Integer) itemStack.getOrDefault(this.add_tag, 0)).intValue())) * (itemStack.has(this.mod_tag) ? ((Double) itemStack.get(this.mod_tag)).doubleValue() : 1.0d));
        return Math.max(1, (int) (jRound > 2147483647L ? 2147483647L : jRound));
    }

    public ItemStack create(ItemStack itemStack, double d, int i) {
        itemStack.set(this.add_tag, Integer.valueOf(i));
        itemStack.set(this.mod_tag, Double.valueOf(d));
        return itemStack;
    }

    public ItemStack create(ItemStack itemStack, double d) {
        itemStack.set(this.mod_tag, Double.valueOf(d));
        return itemStack;
    }

    public ItemStack create(ItemStack itemStack, int i) {
        itemStack.set(this.add_tag, Integer.valueOf(i));
        return itemStack;
    }

    public static int apply(int i, int i2, int i3, double d) {
        long jRound = Math.round(((double) (i2 + i3)) * d);
        return Math.max(i, (int) (jRound > 2147483647L ? 2147483647L : jRound));
    }

    public static int apply(int i, int i2, double d) {
        long jRound = Math.round(((double) (i + i2)) * d);
        return Math.max(1, (int) (jRound > 2147483647L ? 2147483647L : jRound));
    }

    public static float apply(float f, float f2, float f3, double d) {
        double d2 = ((double) (f2 + f3)) * d;
        return Math.max(f, (float) (d2 > 2.147483647E9d ? 2.147483647E9d : d2));
    }

    public static float apply(float f, float f2, double d) {
        double d2 = ((double) (f + f2)) * d;
        return Math.max(1.0f, (float) (d2 > 2.147483647E9d ? 2.147483647E9d : d2));
    }

    public static double apply(double d, double d2, double d3) {
        double d4 = (d + d2) * d3;
        return Math.max(1.0d, d4 > 9.223372036854776E18d ? 9.223372036854776E18d : d4);
    }
}
