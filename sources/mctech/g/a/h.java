package mctech.g.a;

import java.util.function.BiConsumer;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.conditions.ICondition;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/a/h.class */
public interface h {
    void a(IEventBus iEventBus);

    void a(BootstrapContext<a<?, ?>> bootstrapContext);

    void a(BiConsumer<ResourceKey<?>, ICondition> biConsumer);

    void a(HolderLookup.Provider provider, RecipeOutput recipeOutput);
}
