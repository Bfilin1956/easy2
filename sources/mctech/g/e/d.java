package mctech.g.e;

import java.util.concurrent.CompletableFuture;
import mctech.MCTech;
import mctech.g.a.l;
import mctech.init.MCTechBlocks;
import mctech.init.MCTechConduits;
import mctech.init.MCTechDataComponent;
import mctech.init.MCTechItems;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponentPredicate;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/e/d.class */
public class d extends RecipeProvider {
    private final CompletableFuture<HolderLookup.Provider> a;

    public d(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(packOutput, completableFuture);
        this.a = completableFuture;
    }

    protected void buildRecipes(@NotNull RecipeOutput recipeOutput) {
        ((HolderLookup.Provider) this.a.resultNow()).lookup(l.a.f).ifPresent(registryLookup -> {
            d(recipeOutput, registryLookup);
            c(recipeOutput, registryLookup);
            b(recipeOutput, registryLookup);
            a(recipeOutput, registryLookup);
        });
    }

    private static void a(@NotNull RecipeOutput recipeOutput, HolderLookup.RegistryLookup<mctech.g.a.a<?, ?>> registryLookup) {
        if (MCTech.isFrozen()) {
            a.a(registryLookup).a(MCTechConduits.HEAT, 3).a("RRR").a("ICI").a("RRR").a('R', "rubber_gasket").a('I', (ItemLike) Items.TORCH).a('C', (ItemLike) Items.COMPARATOR).a(recipeOutput);
        }
        a.a(registryLookup).a(MCTechConduits.REDSTONE, 4).a("III").a("TCB").a("III").a('I', "rubber_gasket").a('T', (ItemLike) Items.TORCH).a('B', (ItemLike) Items.REDSTONE_BLOCK).a('C', (ItemLike) Items.COMPARATOR).a(recipeOutput);
        a.a(registryLookup).a(MCTechConduits.ME_NORMAL, 4).a(" F ").a("WCW").a(" F ").a('F', ResourceLocation.parse("ae2:quartz_fiber")).a('W', (ItemLike) Items.WHITE_WOOL).a('C', ResourceLocation.parse("ae2:fluix_glass_cable")).a(recipeOutput);
        a.a(registryLookup).a(MCTechConduits.ME_DENSE, 4).a(" F ").a("WCW").a(" F ").a('F', ResourceLocation.parse("ae2:quartz_fiber")).b('W', MCTechConduits.ME_NORMAL.location()).a('C', ResourceLocation.parse("ae2:fluix_glass_cable")).a(recipeOutput);
    }

    private static void b(@NotNull RecipeOutput recipeOutput, HolderLookup.RegistryLookup<mctech.g.a.a<?, ?>> registryLookup) {
        a.a(registryLookup).a(MCTechConduits.FLUID_COAL, 6).a("CCC").a("RPR").a("CCC").a('C', Ingredient.of(ItemTags.COALS)).a('R', (ItemLike) Items.REPEATER).a('P', (ItemLike) Items.STICKY_PISTON).a(recipeOutput);
        a.a(registryLookup).a(MCTechConduits.FLUID_REDSTONE, 6).a("III").a("ICI").a("III").a('I', (ItemLike) Items.REDSTONE).b('C', MCTech.loc("fluid/coal")).a(recipeOutput);
        a.a(registryLookup).a(MCTechConduits.FLUID_LAPIS, 6).a("III").a("ICI").a("III").a('I', (ItemLike) Items.LAPIS_LAZULI).b('C', MCTech.loc("fluid/redstone")).a(recipeOutput);
        a.a(registryLookup).a(MCTechConduits.FLUID_AMETHYST, 6).a("PPP").a("PCP").a("PPP").a('P', "amethyst_rough_plate").b('C', MCTech.loc("fluid/lapis")).a(recipeOutput);
        a.a(registryLookup).a(MCTechConduits.FLUID_QUARTZ, 6).a("PPP").a("ACA").a("PPP").a('P', "quartz_rough_plate").a('A', "cut_quartz_power_crystal").b('C', MCTech.loc("fluid/amethyst")).a(recipeOutput);
        a.a(registryLookup).a(MCTechConduits.FLUID_LUMINITE, 6).a("PPP").a("ACA").a("PPP").a('P', "lumenite_rough_plate").a('A', "cut_lumenite_power_crystal").b('C', MCTech.loc("fluid/quartz")).a(recipeOutput);
        a.a(registryLookup).a(MCTechConduits.FLUID_DIAMOND, 6).a("PPP").a("ACA").a("PPP").a('P', "diamond_rough_plate").a('A', "cut_diamond_power_crystal").b('C', MCTech.loc("fluid/luminite")).a(recipeOutput);
        a.a(registryLookup).a(MCTechConduits.FLUID_EMERALD, 6).a("PPP").a("ACA").a("PPP").a('P', "emerald_pressed_plate").a('A', "cut_emerald_power_crystal").b('C', MCTech.loc("fluid/diamond")).a(recipeOutput);
        a.a(registryLookup).a(MCTechConduits.FLUID_RUBY, 6).a("PPP").a("ACA").a("PPP").a('P', "ruby_polished_plate").a('A', "polished_ruby_power_crystal").b('C', MCTech.loc("fluid/emerald")).a(recipeOutput);
        a.a(registryLookup).a(MCTechConduits.FLUID_ZIRCON, 6).a("PPP").a("ACA").a("PPP").a('P', "zircon_polished_plate").a('A', "polished_zircon_power_crystal").b('C', MCTech.loc("fluid/ruby")).a(recipeOutput);
        a.a(registryLookup).a(MCTechConduits.FLUID_SAPPHIRE, 4).a("PPP").a("ACA").a("PPP").a('P', "sapphire_pressed_plate").a('A', "cut_sapphire_power_crystal").b('C', MCTech.loc("fluid/zircon")).a(recipeOutput);
    }

    private static void c(@NotNull RecipeOutput recipeOutput, HolderLookup.RegistryLookup<mctech.g.a.a<?, ?>> registryLookup) {
        a.a(registryLookup).a(MCTechConduits.ITEM_COAL, 6).a("CCC").a("RPR").a("CCC").a('C', Ingredient.of(ItemTags.COALS)).a('R', (ItemLike) Items.REPEATER).a('P', (ItemLike) Items.PISTON).a(recipeOutput);
        a.a(registryLookup).a(MCTechConduits.ITEM_REDSTONE, 6).a("III").a("ICI").a("III").a('I', (ItemLike) Items.REDSTONE).b('C', MCTech.loc("item/coal")).a(recipeOutput);
        a.a(registryLookup).a(MCTechConduits.ITEM_LAPIS, 6).a("III").a("ICI").a("III").a('I', (ItemLike) Items.LAPIS_LAZULI).b('C', MCTech.loc("item/redstone")).a(recipeOutput);
        a.a(registryLookup).a(MCTechConduits.ITEM_AMETHYST, 6).a("PPP").a("PCP").a("PPP").a('P', "amethyst_rough_plate").b('C', MCTech.loc("item/lapis")).a(recipeOutput);
        a.a(registryLookup).a(MCTechConduits.ITEM_QUARTZ, 6).a("PPP").a("ACA").a("PPP").a('P', "quartz_rough_plate").a('A', "cut_quartz_power_crystal").b('C', MCTech.loc("item/amethyst")).a(recipeOutput);
        a.a(registryLookup).a(MCTechConduits.ITEM_LUMINITE, 6).a("PPP").a("ACA").a("PPP").a('P', "lumenite_rough_plate").a('A', "cut_lumenite_power_crystal").b('C', MCTech.loc("item/quartz")).a(recipeOutput);
        a.a(registryLookup).a(MCTechConduits.ITEM_DIAMOND, 6).a("PPP").a("ACA").a("PPP").a('P', "diamond_rough_plate").a('A', "cut_diamond_power_crystal").b('C', MCTech.loc("item/luminite")).a(recipeOutput);
        a.a(registryLookup).a(MCTechConduits.ITEM_EMERALD, 6).a("PPP").a("ACA").a("PPP").a('P', "emerald_pressed_plate").a('A', "cut_emerald_power_crystal").b('C', MCTech.loc("item/diamond")).a(recipeOutput);
        a.a(registryLookup).a(MCTechConduits.ITEM_RUBY, 6).a("PPP").a("ACA").a("PPP").a('P', "ruby_polished_plate").a('A', "polished_ruby_power_crystal").b('C', MCTech.loc("item/emerald")).a(recipeOutput);
        a.a(registryLookup).a(MCTechConduits.ITEM_ZIRCON, 1).a("PPP").a("ACA").a("PPP").a('P', "zircon_polished_plate").a('A', "polished_zircon_power_crystal").b('C', MCTech.loc("item/ruby")).a(recipeOutput);
        a.a(registryLookup).a(MCTechConduits.ITEM_SAPPHIRE, 4).a("PPP").a("ACA").a("PPP").a('P', "sapphire_pressed_plate").a('A', "cut_sapphire_power_crystal").b('C', MCTech.loc("item/zircon")).a(recipeOutput);
    }

    private static void d(@NotNull RecipeOutput recipeOutput, HolderLookup.RegistryLookup<mctech.g.a.a<?, ?>> registryLookup) {
        a.a(registryLookup).a(MCTechConduits.EU_TIN, 3).a("RRR").a("CCC").a("RRR").a('C', (ItemLike) MCTechItems.INGOT_TIN).a('R', (ItemLike) MCTechItems.RUBBER.get()).a(recipeOutput);
        a.a(registryLookup).a(MCTechConduits.EU_COPPER, 3).a("RRR").a("CCC").a("RRR").a('C', (ItemLike) Items.COPPER_INGOT).a('R', (ItemLike) MCTechItems.RUBBER.get()).a(recipeOutput);
        a.a(registryLookup).a(MCTechConduits.EU_ALUMINUM, 24).a("RRR").a("WWW").a("RRR").a('R', (ItemLike) MCTechItems.RUBBER.get()).a('W', "aluminum_tempered_wire").a(recipeOutput);
        a.a(registryLookup).a(MCTechConduits.EU_BRONZE, 12).a("RRR").a("WWW").a("RRR").a('R', (ItemLike) MCTechItems.RUBBER.get()).a('W', "bronze_tempered_wire").a(recipeOutput);
        a.a(registryLookup).a(MCTechConduits.EU_GOLD, 4).a("RRR").a("WWW").a("RRR").a('R', (ItemLike) MCTechItems.RUBBER.get()).a('W', "gold_tempered_wire").a(recipeOutput);
        a.a(registryLookup).a(MCTechConduits.EU_IRON, 2).a("RRR").a("WWW").a("RRR").a('R', (ItemLike) MCTechItems.RUBBER.get()).a('W', "iron_tempered_wire").a(recipeOutput);
        a.a(registryLookup).a(MCTechConduits.EU_GLASS, 6).a("FFF").a("ACA").a("FFF").a('F', "glass_fiber_redstone").a('A', "cut_amethyst_crystal").a('C', MCTechConduits.EU_GOLD).b(recipeOutput, "gold");
        a.a(registryLookup).a(MCTechConduits.EU_GLASS, 6).a("FFF").a("ACA").a("FFF").a('F', "glass_fiber_redstone").a('A', "cut_amethyst_crystal").a('C', MCTechConduits.EU_IRON).b(recipeOutput, "iron");
        a.a(registryLookup).a(MCTechConduits.EU_GLASS, 6).a("FFF").a("ACA").a("FFF").a('F', "glass_fiber_redstone").a('A', "cut_amethyst_crystal").a('C', MCTechConduits.EU_ALUMINUM).b(recipeOutput, "aluminium");
        a.a(registryLookup).a(MCTechConduits.EU_GLASS, 6).a("FFF").a("ACA").a("FFF").a('F', "glass_fiber_redstone").a('A', "cut_amethyst_crystal").a('C', MCTechConduits.EU_BRONZE).b(recipeOutput, "bronze");
        a.a(registryLookup).a(MCTechConduits.EU_NETHERITE, 3).a("WWW").a("WCW").a("WWW").a('W', "netherite_tempered_wire").a('C', MCTechConduits.EU_GLASS).a(recipeOutput);
        a.a(registryLookup).a(MCTechConduits.EU_COMPOSITE, 3).a("WWW").a("WCW").a("WWW").a('W', "composite_tempered_wire").a('C', MCTechConduits.EU_NETHERITE).a(recipeOutput);
        a.a(registryLookup).a(MCTechConduits.EU_NANO, 3).a("WWW").a("WCW").a("WWW").a('W', "brass_tempered_wire").a('C', MCTechConduits.EU_COMPOSITE).a(recipeOutput);
        a.a(registryLookup).a(MCTechConduits.EU_QUANTUM, 3).a("WWW").a("WCW").a("WWW").a('W', "iridium_tempered_wire").a('C', MCTechConduits.EU_NANO).a(recipeOutput);
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/e/d$a.class */
    private static class a {
        private final HolderLookup.RegistryLookup<mctech.g.a.a<?, ?>> a;
        private ShapedRecipeBuilder b;
        private ResourceKey<mctech.g.a.a<?, ?>> c;

        public static a a(HolderLookup.RegistryLookup<mctech.g.a.a<?, ?>> registryLookup) {
            return new a(registryLookup);
        }

        private a(HolderLookup.RegistryLookup<mctech.g.a.a<?, ?>> registryLookup) {
            this.a = registryLookup;
        }

        public a a(ResourceKey<mctech.g.a.a<?, ?>> resourceKey, int i) {
            this.c = resourceKey;
            this.b = ShapedRecipeBuilder.shaped(RecipeCategory.MISC, mctech.g.a.b.a((Holder<mctech.g.a.a<?, ?>>) this.a.getOrThrow(resourceKey), i)).unlockedBy("has_ingredient", InventoryChangeTrigger.TriggerInstance.hasItems(new ItemPredicate.Builder[]{ItemPredicate.Builder.item().of(new ItemLike[]{(ItemLike) MCTechBlocks.CONDUIT.get()}).hasComponents(DataComponentPredicate.builder().expect((DataComponentType) MCTechDataComponent.CONDUIT.get(), this.a.getOrThrow(resourceKey)).build())}));
            return this;
        }

        public a a(ResourceLocation resourceLocation, int i) {
            this.c = ResourceKey.create(l.a.f, resourceLocation);
            this.b = ShapedRecipeBuilder.shaped(RecipeCategory.MISC, mctech.g.a.b.a((Holder<mctech.g.a.a<?, ?>>) this.a.getOrThrow(this.c), i)).unlockedBy("has_ingredient", InventoryChangeTrigger.TriggerInstance.hasItems(new ItemPredicate.Builder[]{ItemPredicate.Builder.item().of(new ItemLike[]{(ItemLike) MCTechBlocks.CONDUIT.get()}).hasComponents(DataComponentPredicate.builder().expect((DataComponentType) MCTechDataComponent.CONDUIT.get(), this.a.getOrThrow(this.c)).build())}));
            return this;
        }

        public a a(String str) {
            this.b.pattern(str);
            return this;
        }

        public a a(char c, ResourceLocation resourceLocation, int i) {
            this.b.define(Character.valueOf(c), mctech.u.c.e.a(resourceLocation, i).toVanilla());
            return this;
        }

        public a a(char c, ResourceKey<mctech.g.a.a<?, ?>> resourceKey, int i) {
            this.b.define(Character.valueOf(c), mctech.u.c.a.a(this.a.getOrThrow(resourceKey), i));
            return this;
        }

        public a a(char c, ResourceKey<mctech.g.a.a<?, ?>> resourceKey) {
            this.b.define(Character.valueOf(c), mctech.u.c.a.a(this.a.getOrThrow(resourceKey)));
            return this;
        }

        public a a(char c, ResourceLocation resourceLocation) {
            return a(c, resourceLocation, 1);
        }

        public a b(char c, ResourceLocation resourceLocation) {
            return a(c, ResourceKey.create(l.a.f, resourceLocation), 1);
        }

        public a a(char c, String str, int i) {
            return a(c, ResourceLocation.parse(String.format("kubejs:%s", str)), i);
        }

        public a a(char c, String str) {
            return a(c, str, 1);
        }

        public a a(char c, ItemLike itemLike) {
            this.b.define(Character.valueOf(c), itemLike);
            return this;
        }

        public a a(char c, Ingredient ingredient) {
            this.b.define(Character.valueOf(c), ingredient);
            return this;
        }

        public void a(RecipeOutput recipeOutput) {
            this.b.save(recipeOutput, MCTech.loc(String.format("conduits/%s", this.c.location().getPath())));
        }

        public void a(RecipeOutput recipeOutput, String str) {
            this.b.save(recipeOutput, MCTech.loc(String.format("%s/%s", str, this.c.location().getPath())));
        }

        public void a(RecipeOutput recipeOutput, String str, String str2) {
            this.b.save(recipeOutput, MCTech.loc(String.format("%s/%s_%s", str, this.c.location().getPath(), str2)));
        }

        public void b(RecipeOutput recipeOutput, String str) {
            this.b.save(recipeOutput, MCTech.loc(String.format("conduits/%s_%s", this.c.location().getPath(), str)));
        }
    }
}
