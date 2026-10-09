package mctech.a.b.b;

import mctech.MCTech;
import mctech.init.MCTechBlocks;
import mctech.init.MCTechItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/a/b/b/f.class */
public enum f {
    ASSEMBLY_STATION(MCTechBlocks.ASSEMBLY_STATION, MCTech.loc("textures/gui/container/pattern_encoder/assembly_encoder.png"), MCTechItems.ASSEMBLY_STATION_PATTERN),
    INDUSTRIAL_FORGE(MCTechBlocks.INDUSTRIAL_FORGE, MCTech.loc("textures/gui/container/pattern_encoder/forge_encoder.png"), MCTechItems.INDUSTRIAL_FORGE_PATTERN),
    QUANTUM_WORKBENCH(MCTechBlocks.QUANTUM_WORKBENCH, MCTech.loc("textures/gui/container/pattern_encoder/forge_encoder.png"), MCTechItems.QUANTUM_WORKBENCH_PATTERN),
    TRANSFORMATION_ASSEMBLER(MCTechBlocks.TRANSFORMATION_ASSEMBLER, MCTech.loc("textures/gui/container/pattern_encoder/gui_pattern_transformation_assembler_encoder.png"), MCTechItems.TRANSFORMATION_ASSEMBLER_PATTERN);

    private final ItemLike e;
    private final ResourceLocation f;
    private final ItemLike g;

    f(ItemLike itemLike, ResourceLocation resourceLocation, ItemLike itemLike2) {
        this.e = itemLike;
        this.f = resourceLocation;
        this.g = itemLike2;
    }

    public ItemLike a() {
        return this.e;
    }

    public ResourceLocation b() {
        return this.f;
    }

    public ItemLike c() {
        return this.g;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    public f d() throws MatchException {
        switch (this) {
            case ASSEMBLY_STATION:
                return INDUSTRIAL_FORGE;
            case INDUSTRIAL_FORGE:
                return QUANTUM_WORKBENCH;
            case QUANTUM_WORKBENCH:
                return TRANSFORMATION_ASSEMBLER;
            case TRANSFORMATION_ASSEMBLER:
                return ASSEMBLY_STATION;
            default:
                throw new MatchException((String) null, (Throwable) null);
        }
    }
}
