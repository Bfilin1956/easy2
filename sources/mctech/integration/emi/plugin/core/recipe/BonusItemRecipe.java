package mctech.integration.emi.plugin.core.recipe;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.List;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/integration/emi/plugin/core/recipe/BonusItemRecipe.class */
public final class BonusItemRecipe extends Record {
    private final ResourceLocation id;
    private final Ingredient input;
    private final List<ItemStack> outputs;
    private final ItemStack outputBonus;
    private final float chance;

    public BonusItemRecipe(ResourceLocation resourceLocation, Ingredient ingredient, List<ItemStack> list, ItemStack itemStack, float f) {
        this.id = resourceLocation;
        this.input = ingredient;
        this.outputs = list;
        this.outputBonus = itemStack;
        this.chance = f;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, BonusItemRecipe.class), BonusItemRecipe.class, "id;input;outputs;outputBonus;chance", "FIELD:Lmctech/integration/emi/plugin/core/recipe/BonusItemRecipe;->id:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lmctech/integration/emi/plugin/core/recipe/BonusItemRecipe;->input:Lnet/minecraft/world/item/crafting/Ingredient;", "FIELD:Lmctech/integration/emi/plugin/core/recipe/BonusItemRecipe;->outputs:Ljava/util/List;", "FIELD:Lmctech/integration/emi/plugin/core/recipe/BonusItemRecipe;->outputBonus:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/integration/emi/plugin/core/recipe/BonusItemRecipe;->chance:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, BonusItemRecipe.class), BonusItemRecipe.class, "id;input;outputs;outputBonus;chance", "FIELD:Lmctech/integration/emi/plugin/core/recipe/BonusItemRecipe;->id:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lmctech/integration/emi/plugin/core/recipe/BonusItemRecipe;->input:Lnet/minecraft/world/item/crafting/Ingredient;", "FIELD:Lmctech/integration/emi/plugin/core/recipe/BonusItemRecipe;->outputs:Ljava/util/List;", "FIELD:Lmctech/integration/emi/plugin/core/recipe/BonusItemRecipe;->outputBonus:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/integration/emi/plugin/core/recipe/BonusItemRecipe;->chance:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, BonusItemRecipe.class, Object.class), BonusItemRecipe.class, "id;input;outputs;outputBonus;chance", "FIELD:Lmctech/integration/emi/plugin/core/recipe/BonusItemRecipe;->id:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lmctech/integration/emi/plugin/core/recipe/BonusItemRecipe;->input:Lnet/minecraft/world/item/crafting/Ingredient;", "FIELD:Lmctech/integration/emi/plugin/core/recipe/BonusItemRecipe;->outputs:Ljava/util/List;", "FIELD:Lmctech/integration/emi/plugin/core/recipe/BonusItemRecipe;->outputBonus:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/integration/emi/plugin/core/recipe/BonusItemRecipe;->chance:F").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public ResourceLocation id() {
        return this.id;
    }

    public Ingredient input() {
        return this.input;
    }

    public List<ItemStack> outputs() {
        return this.outputs;
    }

    public ItemStack outputBonus() {
        return this.outputBonus;
    }

    public float chance() {
        return this.chance;
    }
}
