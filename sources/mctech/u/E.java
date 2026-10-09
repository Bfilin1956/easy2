package mctech.u;

import mctech.MCTech;
import mctech.init.MCTechRecipes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.neoforge.registries.DeferredHolder;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/E.class */
public final class E {
    public static final DeferredHolder<RecipeType<?>, RecipeType<N>> a = a("ore_macerator", N.class);
    public static final DeferredHolder<RecipeSerializer<?>, mctech.u.d.v> b = MCTechRecipes.RECIPE_SERIALIZERS.register("ore_macerator", mctech.u.d.v::new);
    public static final DeferredHolder<RecipeType<?>, RecipeType<C0183k>> c = a("chemical_purification", C0183k.class);
    public static final DeferredHolder<RecipeSerializer<?>, mctech.u.d.f> d = MCTechRecipes.RECIPE_SERIALIZERS.register("chemical_purification", mctech.u.d.f::new);
    public static final DeferredHolder<RecipeType<?>, RecipeType<C0185m>> e = a("concentrator", C0185m.class);
    public static final DeferredHolder<RecipeSerializer<?>, mctech.u.d.h> f = MCTechRecipes.RECIPE_SERIALIZERS.register("concentrator", mctech.u.d.h::new);
    public static final DeferredHolder<RecipeType<?>, RecipeType<A>> g = a("hydraulic_washer", A.class);
    public static final DeferredHolder<RecipeSerializer<?>, mctech.u.d.q> h = MCTechRecipes.RECIPE_SERIALIZERS.register("hydraulic_washer", mctech.u.d.q::new);
    public static final DeferredHolder<RecipeType<?>, RecipeType<C>> i = a("ingot_foundry", C.class);
    public static final DeferredHolder<RecipeSerializer<?>, mctech.u.d.r> j = MCTechRecipes.RECIPE_SERIALIZERS.register("ingot_foundry", mctech.u.d.r::new);
    public static final DeferredHolder<RecipeType<?>, RecipeType<M>> k = a("ore_combine", M.class);
    public static final DeferredHolder<RecipeSerializer<?>, mctech.u.d.u> l = MCTechRecipes.RECIPE_SERIALIZERS.register("ore_combine", mctech.u.d.u::new);
    public static final DeferredHolder<RecipeType<?>, RecipeType<C0188p>> m = a("dust_factory", C0188p.class);
    public static final DeferredHolder<RecipeSerializer<?>, mctech.u.d.j> n = MCTechRecipes.RECIPE_SERIALIZERS.register("dust_factory", mctech.u.d.j::new);
    public static final DeferredHolder<RecipeType<?>, RecipeType<C0198z>> o = a("greenhouse", C0198z.class);
    public static final DeferredHolder<RecipeSerializer<?>, mctech.u.d.p> p = MCTechRecipes.RECIPE_SERIALIZERS.register("greenhouse", mctech.u.d.p::new);

    private static <T extends Recipe<?>> DeferredHolder<RecipeType<?>, RecipeType<T>> a(String str, Class<T> cls) {
        return MCTechRecipes.RECIPE_TYPES.register(str, () -> {
            return RecipeType.simple(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, str));
        });
    }

    public static void a() {
    }
}
