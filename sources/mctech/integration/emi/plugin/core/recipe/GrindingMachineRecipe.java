package mctech.integration.emi.plugin.core.recipe;

import java.util.Locale;
import mctech.MCTech;
import mctech.items.e.d;
import mctech.items.e.l;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/integration/emi/plugin/core/recipe/GrindingMachineRecipe.class */
public class GrindingMachineRecipe {
    private final d blade;
    private final d nextLevelBlade;
    private final l whetstone;
    private final ResourceLocation id;

    public GrindingMachineRecipe(@NotNull d dVar, @NotNull l lVar) {
        this.blade = dVar;
        this.nextLevelBlade = d.a(dVar.a() + 1);
        this.whetstone = lVar;
        this.id = ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "/" + lVar.a().name().toLowerCase(Locale.ROOT) + "_" + dVar.a());
    }

    public d getBlade() {
        return this.blade;
    }

    public d getNextLevelBlade() {
        return this.nextLevelBlade;
    }

    public l getWhetstone() {
        return this.whetstone;
    }

    public ResourceLocation getId() {
        return this.id;
    }
}
