package mctech.init;

import appeng.core.definitions.AEBlocks;
import com.mojang.datafixers.util.Pair;
import java.util.HashMap;
import java.util.function.Supplier;
import mctech.MCTech;
import mctech.i.i;
import mctech.u.C0170b;
import mctech.u.C0181i;
import mctech.u.C0182j;
import mctech.u.C0184l;
import mctech.u.C0186n;
import mctech.u.C0187o;
import mctech.u.C0189q;
import mctech.u.C0190r;
import mctech.u.C0191s;
import mctech.u.C0192t;
import mctech.u.C0193u;
import mctech.u.C0194v;
import mctech.u.C0195w;
import mctech.u.C0196x;
import mctech.u.C0197y;
import mctech.u.F;
import mctech.u.G;
import mctech.u.H;
import mctech.u.I;
import mctech.u.J;
import mctech.u.K;
import mctech.u.L;
import mctech.u.Q;
import mctech.u.T;
import mctech.u.V;
import mctech.u.W;
import mctech.u.X;
import mctech.u.Y;
import mctech.u.Z;
import mctech.u.aa;
import mctech.u.c.b;
import mctech.u.d.A;
import mctech.u.d.B;
import mctech.u.d.C;
import mctech.u.d.C0173a;
import mctech.u.d.C0174b;
import mctech.u.d.C0175c;
import mctech.u.d.C0176d;
import mctech.u.d.D;
import mctech.u.d.e;
import mctech.u.d.g;
import mctech.u.d.k;
import mctech.u.d.l;
import mctech.u.d.m;
import mctech.u.d.n;
import mctech.u.d.o;
import mctech.u.d.s;
import mctech.u.d.t;
import mctech.u.d.w;
import mctech.u.d.z;
import net.mcskill.msregistry.registry.holder.LRecipe;
import net.mcskill.msregistry.registry.type.RecipeRegistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.ItemLike;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/init/MCTechRecipes.class */
public final class MCTechRecipes {
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(Registries.RECIPE_TYPE, MCTech.MODID);
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(Registries.RECIPE_SERIALIZER, MCTech.MODID);
    public static final HashMap<String, DeferredHolder<RecipeType<?>, RecipeType<?>>> REGISTERED_RECIPES = new HashMap<>();
    public static final HashMap<String, DeferredHolder<RecipeSerializer<?>, ? extends RecipeSerializer<?>>> REGISTERED_SERIALIZERS = new HashMap<>();
    public static final RecipeRegistry RECIPE_REGISTRY = MCTech.REGISTRY.recipeRegistry();
    public static final DeferredHolder<RecipeType<?>, RecipeType<G>> MACERATOR = register("macerator", G.class);
    public static final DeferredHolder<RecipeSerializer<?>, s> MACERATOR_SERIALIZER = RECIPE_SERIALIZERS.register("macerator", s::new);
    public static final DeferredHolder<RecipeType<?>, RecipeType<C0192t>> EXTRACTOR = register("extractor", C0192t.class);
    public static final DeferredHolder<RecipeSerializer<?>, m> EXTRACTOR_SERIALIZER = RECIPE_SERIALIZERS.register("extractor", m::new);
    public static final DeferredHolder<RecipeType<?>, RecipeType<C0184l>> COMPRESSOR = register("compressor", C0184l.class);
    public static final DeferredHolder<RecipeSerializer<?>, g> COMPRESSOR_SERIALIZER = RECIPE_SERIALIZERS.register("compressor", g::new);
    public static final DeferredHolder<RecipeType<?>, RecipeType<C0170b>> ALLOY_SMELTER = register("alloy_smelter", C0170b.class);
    public static final DeferredHolder<RecipeSerializer<?>, C0173a> ALLOY_SMELTER_SERIALIZER = RECIPE_SERIALIZERS.register("alloy_smelter", C0173a::new);
    public static final DeferredHolder<RecipeType<?>, RecipeType<C0197y>> GLASS_FURNACE = register("glass_furnace", C0197y.class);
    public static final DeferredHolder<RecipeSerializer<?>, o> GLASS_FURNACE_SERIALIZER = RECIPE_SERIALIZERS.register("glass_furnace", o::new);
    public static final DeferredHolder<RecipeType<?>, RecipeType<C0189q>> ELECTROLYZER = register("electrolyzer", C0189q.class);
    public static final DeferredHolder<RecipeSerializer<?>, k> ELECTROLYZER_SERIALIZER = RECIPE_SERIALIZERS.register("electrolyzer", k::new);
    public static final DeferredHolder<RecipeType<?>, RecipeType<C0182j>> CANNER_FOOD = register("canner_food", C0182j.class);
    public static final DeferredHolder<RecipeSerializer<?>, e> CANNER_FOOD_SERIALIZER = RECIPE_SERIALIZERS.register("canner_food", e::new);
    public static final DeferredHolder<RecipeType<?>, RecipeType<C0181i>> CANNER_FILL = register("canner_fill", C0181i.class);
    public static final DeferredHolder<RecipeSerializer<?>, C0176d> CANNER_FILL_SERIALIZER = RECIPE_SERIALIZERS.register("canner_fill", C0176d::new);
    public static final DeferredHolder<RecipeType<?>, RecipeType<W>> REFINERY = register("refinery", W.class);
    public static final DeferredHolder<RecipeSerializer<?>, A> REFINERY_SERIALIZER = RECIPE_SERIALIZERS.register("refinery", A::new);
    public static final DeferredHolder<RecipeType<?>, RecipeType<X>> SAWMILL = register("sawmill", X.class);
    public static final DeferredHolder<RecipeSerializer<?>, B> SAWMILL_SERIALIZER = RECIPE_SERIALIZERS.register("sawmill", B::new);
    public static final DeferredHolder<RecipeType<?>, RecipeType<V>> RECYCLER = register("recycler", V.class);
    public static final DeferredHolder<RecipeSerializer<?>, z> RECYCLER_SERIALIZER = RECIPE_SERIALIZERS.register("recycler", z::new);
    public static final DeferredHolder<RecipeType<?>, RecipeType<Y>> SCRAP_BOX = register("scrap_box", Y.class);
    public static final DeferredHolder<RecipeSerializer<?>, C> SCRAPBOX_SERIALIZER = RECIPE_SERIALIZERS.register("scrap_box", C::new);
    public static final DeferredHolder<RecipeType<?>, RecipeType<aa>> URANIUM_ENRICHER = register("uranium_enricher", aa.class);
    public static final DeferredHolder<RecipeSerializer<?>, D> URANIUM_ENRICHER_SERIALIZER = RECIPE_SERIALIZERS.register("uranium_enricher", D::new);
    public static final DeferredHolder<RecipeType<?>, RecipeType<C0191s>> ENRICHER_MATERIAL = register("enricher_material", C0191s.class);
    public static final DeferredHolder<RecipeSerializer<?>, l> ENRICHER_MATERIAL_SERIALIZER = RECIPE_SERIALIZERS.register("enricher_material", l::new);
    public static final DeferredHolder<RecipeType<?>, RecipeType<C0193u>> FLUID_FUEL = register("fluid_fuel", C0193u.class);
    public static final DeferredHolder<RecipeSerializer<?>, n> FLUID_FUEL_SERIALIZER = RECIPE_SERIALIZERS.register("fluid_fuel", n::new);
    public static final DeferredHolder<RecipeType<?>, RecipeType<L>> NUCLEAR_ENRICHMENT = register("nuclear_enrichment", L.class);
    public static final DeferredHolder<RecipeSerializer<?>, t> NUCLEAR_ENRICHMENT_SERIALIZER = RECIPE_SERIALIZERS.register("nuclear_enrichment", t::new);

    static {
        register(i.PLASMA_GENERATOR.getSerializedName(), w::new);
        register(i.ASSEMBLY_STATION.getSerializedName(), C0174b::new);
        register(i.ATOMIC_SMELTER.getSerializedName(), C0175c::new);
        register("forming_machine", C0194v.b::new);
        register("crystal_synth", C0187o.b::new);
        register("metal_former", J.b::new);
        register("rare_extractor", T.b::new);
        register("electronic_plant", C0190r.b::new);
        registerAndCreate("crystal_growth_chamber", C0186n.a::new, new Pair("chipped_budding_quartz", () -> {
            return new C0186n(Ingredient.of(new ItemLike[]{AEBlocks.CHIPPED_BUDDING_QUARTZ}), 200, 1);
        }), new Pair("damaged_budding_quartz", () -> {
            return new C0186n(Ingredient.of(new ItemLike[]{AEBlocks.DAMAGED_BUDDING_QUARTZ}), 400, 1);
        }), new Pair("flawed_budding_quartz", () -> {
            return new C0186n(Ingredient.of(new ItemLike[]{AEBlocks.FLAWED_BUDDING_QUARTZ}), 100, 1);
        }), new Pair("flawless_budding_quartz", () -> {
            return new C0186n(Ingredient.of(new ItemLike[]{AEBlocks.FLAWLESS_BUDDING_QUARTZ}), 100, 3);
        }));
        register("industrial_forge", mctech.u.B.b::new);
        register("genetic_printer", C0195w.c::new);
        register("genetic_stabilizer", C0196x.b::new);
        registerAndCreate("macerator_bonus_item", F.b::new, new Pair("iron_dust", () -> {
            return new F(Ingredient.of(new ItemLike[]{Items.IRON_INGOT}), MCTechItems.DUST_IRON.toStack(), 0.2f);
        }));
        registerAndCreate("mass_fabricator", H.b::new, new Pair("t5_uu", () -> {
            return new H(new b(Ingredient.of(new ItemLike[]{MCTechItems.SCRAP}), 1), new ItemStack((ItemLike) MCTechItems.UUMATTER.get()), 25000000, 0, FluidStack.EMPTY);
        }), new Pair("t5_uu2", () -> {
            return new H(new b(Ingredient.of(new ItemLike[]{MCTechItems.SCRAP}), 1), new ItemStack((ItemLike) MCTechItems.UU_MATTER_2.get()), 50000000, 1, FluidStack.EMPTY);
        }), new Pair("t5_uu3", () -> {
            return new H(new b(Ingredient.of(new ItemLike[]{MCTechItems.SCRAP}), 1), new ItemStack((ItemLike) MCTechItems.UU_MATTER_3.get()), 75000000, 2, FluidStack.EMPTY);
        }), new Pair("t7_uu_0", () -> {
            return new H(new b(Ingredient.of(new ItemLike[]{MCTechItems.SCRAP}), 1), new ItemStack((ItemLike) MCTechItems.UUMATTER.get()), 75000000, 0, new FluidStack(MCTechFluids.LIQUID_MATTER.getSource(), 100));
        }), new Pair("t7_uu_1", () -> {
            return new H(new b(Ingredient.of(new ItemLike[]{MCTechItems.SCRAP}), 1), new ItemStack((ItemLike) MCTechItems.UU_MATTER_2.get()), 75000000, 1, new FluidStack(MCTechFluids.LIQUID_MATTER.getSource(), 100));
        }), new Pair("t7_uu_2", () -> {
            return new H(new b(Ingredient.of(new ItemLike[]{MCTechItems.SCRAP}), 1), new ItemStack((ItemLike) MCTechItems.UU_MATTER_3.get()), 75000000, 2, new FluidStack(MCTechFluids.LIQUID_MATTER.getSource(), 100));
        }));
        create("canner", new Pair("rod_uranium_blaze", () -> {
            return new C0181i(Ingredient.of(new ItemLike[]{MCTechItems.INGOT_URANIUM_ENRICHED_BLAZE}), Ingredient.of(new ItemLike[]{MCTechFluids.CELL_EMPTY}), 1, new ItemStack((ItemLike) MCTechItems.URANIUM_ROD_BLAZE_SINGLE.get()), 1024.0d, 400);
        }));
        register(i.QUANTUM_WORKBENCH.getSerializedName(), Q.c::new);
        register(i.MOLECULAR_CONVERTER.getSerializedName(), K.b::new);
        register(i.MATRIX_CONVERTER.getSerializedName(), I.b::new);
        register(i.TRANSFORMATION_ASSEMBLER.getSerializedName(), Z.b::new);
    }

    private static <T extends Recipe<?>> DeferredHolder<RecipeType<?>, RecipeType<T>> register(String str, Class<T> cls) {
        return RECIPE_TYPES.register(str, () -> {
            return RecipeType.simple(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, str));
        });
    }

    @SafeVarargs
    private static <I extends RecipeInput, R extends Recipe<I>, S extends RecipeSerializer<R>> void registerAndCreate(i iVar, Supplier<S> supplier, Pair<String, Supplier<R>>... pairArr) {
        registerAndCreate(iVar.getSerializedName(), supplier, pairArr);
    }

    @SafeVarargs
    private static <I extends RecipeInput, R extends Recipe<I>, S extends RecipeSerializer<R>> void registerAndCreate(String str, Supplier<S> supplier, Pair<String, Supplier<R>>... pairArr) {
        REGISTERED_RECIPES.put(str, RECIPE_TYPES.register(str, () -> {
            return RecipeType.simple(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, str));
        }));
        REGISTERED_SERIALIZERS.put(str, RECIPE_SERIALIZERS.register(str, supplier));
        for (Pair<String, Supplier<R>> pair : pairArr) {
            if (pair != null) {
                RECIPE_REGISTRY.register(new LRecipe[]{new LRecipe(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, String.format("%s/%s", str, pair.getFirst())), (Supplier) pair.getSecond())});
            }
        }
    }

    @SafeVarargs
    private static <I extends RecipeInput, R extends Recipe<I>, S extends RecipeSerializer<R>> void create(String str, Pair<String, Supplier<R>>... pairArr) {
        for (Pair<String, Supplier<R>> pair : pairArr) {
            if (pair != null) {
                RECIPE_REGISTRY.register(new LRecipe[]{new LRecipe(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, String.format("%s/%s", str, pair.getFirst())), (Supplier) pair.getSecond())});
            }
        }
    }

    private static <T extends Recipe<?>, S extends RecipeSerializer<T>> void register(String str, Supplier<S> supplier) {
        REGISTERED_RECIPES.put(str, RECIPE_TYPES.register(str, () -> {
            return RecipeType.simple(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, str));
        }));
        REGISTERED_SERIALIZERS.put(str, RECIPE_SERIALIZERS.register(str, supplier));
    }

    public static <I extends RecipeInput, T extends Recipe<I>> RecipeType<T> type(i iVar) {
        return type(iVar.getSerializedName());
    }

    public static <I extends RecipeInput, T extends Recipe<I>> RecipeType<T> type(String str) {
        if (!REGISTERED_RECIPES.containsKey(str)) {
            throw new RuntimeException(String.format("Recipe type for %s not found! Did you registered recipe?", str));
        }
        return (RecipeType) REGISTERED_RECIPES.get(str).get();
    }

    public static <I extends RecipeInput, T extends Recipe<I>> ResourceLocation typeLocation(String str) {
        if (!REGISTERED_RECIPES.containsKey(str)) {
            throw new RuntimeException(String.format("Recipe type for %s not found! Did you registered recipe?", str));
        }
        return REGISTERED_RECIPES.get(str).getId();
    }

    public static <T extends Recipe<?>, S extends RecipeSerializer<T>> S serializer(i iVar) {
        return (S) serializer(iVar.getSerializedName());
    }

    public static <T extends Recipe<?>, S extends RecipeSerializer<T>> S serializer(String str) {
        if (!REGISTERED_SERIALIZERS.containsKey(str)) {
            throw new RuntimeException(String.format("Recipe type for %s not found! Did you registered recipe?", str));
        }
        return (S) REGISTERED_SERIALIZERS.get(str).get();
    }

    public static void register(IEventBus iEventBus) {
        RECIPE_TYPES.register(iEventBus);
        RECIPE_SERIALIZERS.register(iEventBus);
    }
}
