package mctech.init;

import appeng.api.AECapabilities;
import appeng.api.implementations.blockentities.ICraftingMachine;
import appeng.blockentity.AEBaseBlockEntity;
import com.mojang.datafixers.types.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Supplier;
import javax.annotation.Nullable;
import mctech.MCTech;
import mctech.blockentities.b.e;
import mctech.blockentities.b.f;
import mctech.blockentities.b.j;
import mctech.blockentities.b.k;
import mctech.blockentities.b.l;
import mctech.blockentities.c.A;
import mctech.blockentities.c.B;
import mctech.blockentities.c.C;
import mctech.blockentities.c.C0054a;
import mctech.blockentities.c.C0056c;
import mctech.blockentities.c.C0057d;
import mctech.blockentities.c.C0058e;
import mctech.blockentities.c.C0059f;
import mctech.blockentities.c.C0060g;
import mctech.blockentities.c.C0061h;
import mctech.blockentities.c.C0062i;
import mctech.blockentities.c.C0063j;
import mctech.blockentities.c.C0064k;
import mctech.blockentities.c.C0066m;
import mctech.blockentities.c.C0067n;
import mctech.blockentities.c.C0068o;
import mctech.blockentities.c.C0069p;
import mctech.blockentities.c.C0070q;
import mctech.blockentities.c.C0071r;
import mctech.blockentities.c.C0072s;
import mctech.blockentities.c.C0073t;
import mctech.blockentities.c.C0074u;
import mctech.blockentities.c.C0075v;
import mctech.blockentities.c.C0076w;
import mctech.blockentities.c.C0077x;
import mctech.blockentities.c.C0078y;
import mctech.blockentities.c.C0079z;
import mctech.blockentities.c.D;
import mctech.blockentities.c.E;
import mctech.blockentities.c.G;
import mctech.blockentities.c.H;
import mctech.blockentities.c.I;
import mctech.blockentities.c.J;
import mctech.blockentities.c.K;
import mctech.blockentities.c.L;
import mctech.blockentities.c.M;
import mctech.blockentities.c.N;
import mctech.blockentities.c.O;
import mctech.blockentities.c.P;
import mctech.blockentities.c.Q;
import mctech.blockentities.c.R;
import mctech.blockentities.c.S;
import mctech.blockentities.c.T;
import mctech.blockentities.c.U;
import mctech.blockentities.c.V;
import mctech.blockentities.c.W;
import mctech.blockentities.c.X;
import mctech.blockentities.c.Y;
import mctech.blockentities.c.Z;
import mctech.blockentities.c.a.a;
import mctech.blockentities.c.aa;
import mctech.blockentities.c.ab;
import mctech.blockentities.c.ac;
import mctech.blockentities.c.ad;
import mctech.blockentities.c.ae;
import mctech.blockentities.c.af;
import mctech.blockentities.c.ag;
import mctech.blockentities.e.g;
import mctech.blockentities.g.m;
import mctech.blockentities.p;
import mctech.blockentities.u;
import mctech.blockentities.v;
import mctech.blocks.base.blocks.BaseFacingBlock;
import mctech.g.d.a.a.b;
import mctech.i.i;
import mctech.p.b.a.c;
import mctech.p.b.d;
import mctech.utils.c.h;
import net.mcskill.msregistry.core.MachineTier;
import net.mcskill.msregistry.registry.holder.LBlock;
import net.mcskill.msregistry.registry.holder.LBlockEntity;
import net.mcskill.msregistry.registry.type.BlockEntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/init/MCTechTiles.class */
public class MCTechTiles {
    public static final BlockEntityRegistry BLOCK_ENTITY_REGISTRY = MCTech.REGISTRY.blockEntityRegistry();
    public static final LBlockEntity<b> CONDUIT = BLOCK_ENTITY_REGISTRY.registerBlockEntity("conduit", b::new, new Supplier[]{MCTechBlocks.CONDUIT});
    public static final LBlockEntity<mctech.blockentities.c.a.b> FARMING_STATION = BLOCK_ENTITY_REGISTRY.registerBlockEntity("farming_station", mctech.blockentities.c.a.b::new, new Supplier[]{MCTechBlocks.FARMING_STATION}).addCapability(Capabilities.ItemHandler.BLOCK, (v0, v1) -> {
        return v0.getItemHandler(v1);
    });
    public static final LBlockEntity<a> FARMING_STATION_CULTIVATOR = BLOCK_ENTITY_REGISTRY.registerBlockEntity("farming_station_cultivator", a::new, new Supplier[]{MCTechBlocks.FARMING_STATION_CULTIVATOR});
    public static final LBlockEntity<C0074u> GLASS_FURNACE = BLOCK_ENTITY_REGISTRY.registerBlockEntity("glass_furnace", C0074u::new, new Supplier[]{MCTechBlocks.GLASS_FURNACE});
    public static final LBlockEntity<d> GLASS_FURNACE_TEMPLATE = BLOCK_ENTITY_REGISTRY.registerBlockEntity("glass_furnace_template", new BlockEntityType.BlockEntitySupplier<d>() { // from class: mctech.init.MCTechTiles.1
        @NotNull
        /* JADX INFO: renamed from: create, reason: merged with bridge method [inline-methods] */
        public d m465create(@NotNull BlockPos blockPos, @NotNull BlockState blockState) {
            return new d((BlockEntityType) MCTechTiles.GLASS_FURNACE_TEMPLATE.get(), blockPos, blockState);
        }
    }, new Supplier[]{MCTechBlocks.GLASS_FURNACE});
    public static final LBlockEntity<l> WINDMILL_GENERATOR = BLOCK_ENTITY_REGISTRY.registerBlockEntity("windmill", l::new, new Supplier[]{MCTechBlocks.WINDMILL});
    public static final LBlockEntity<d> WINDMILL_GENERATOR_TEMPLATE = BLOCK_ENTITY_REGISTRY.registerBlockEntity("windmill_template", new BlockEntityType.BlockEntitySupplier<d>() { // from class: mctech.init.MCTechTiles.2
        @NotNull
        /* JADX INFO: renamed from: create, reason: merged with bridge method [inline-methods] */
        public d m466create(@NotNull BlockPos blockPos, @NotNull BlockState blockState) {
            return new d((BlockEntityType) MCTechTiles.WINDMILL_GENERATOR_TEMPLATE.get(), blockPos, blockState);
        }
    }, new Supplier[]{MCTechBlocks.WINDMILL});
    public static final LBlockEntity<A> ITEM_DUPLICATOR = BLOCK_ENTITY_REGISTRY.registerBlockEntity("item_duplicator", A::new, new Supplier[]{MCTechBlocks.ITEM_DUPLICATOR}).addCapability(Capabilities.ItemHandler.BLOCK, (v0, v1) -> {
        return v0.getItemHandler(v1);
    });
    public static final LBlockEntity<C0079z> ITEM_DESTROYER = BLOCK_ENTITY_REGISTRY.registerBlockEntity("item_destroyer", C0079z::new, new Supplier[]{MCTechBlocks.ITEM_DESTROYER}).addCapability(Capabilities.ItemHandler.BLOCK, (v0, v1) -> {
        return v0.getItemHandler(v1);
    });
    public static final LBlockEntity<p> BASE_TELEPORTER = BLOCK_ENTITY_REGISTRY.registerBlockEntity("base_teleporter", p::new, new Supplier[]{MCTechBlocks.BASE_TELEPORTER});
    public static final LBlockEntity<mctech.blockentities.f.b> ELEVATOR_TELEPORTER = BLOCK_ENTITY_REGISTRY.registerBlockEntity("elevator_teleporter", mctech.blockentities.f.b::new, new Supplier[]{MCTechBlocks.ELEVATOR_TELEPORTER});
    public static final LBlockEntity<mctech.blockentities.f.d> LINKED_TELEPORTER = BLOCK_ENTITY_REGISTRY.registerBlockEntity("linked_teleporter", mctech.blockentities.f.d::new, new Supplier[]{MCTechBlocks.LINKED_TELEPORTER});
    public static final LBlockEntity<L> QUANTUM_COMPOSTER = BLOCK_ENTITY_REGISTRY.registerBlockEntity("quantum_composter", L::new, new Supplier[]{MCTechBlocks.QUANTUM_COMPOSTER}).condition(MCTech::isFrozen).addCapability(Capabilities.ItemHandler.BLOCK, (v0, v1) -> {
        return v0.getItemHandler(v1);
    }).addCapability(Capabilities.FluidHandler.BLOCK, (v0, v1) -> {
        return v0.getConnectedTank(v1);
    });
    public static final LBlockEntity<e> QUANTUM_GENERATOR = BLOCK_ENTITY_REGISTRY.registerBlockEntity(i.QUANTUM_GENERATOR.getSerializedName(), e::new, new Supplier[]{MCTechBlocks.QUANTUM_GENERATOR}).addCapability(Capabilities.ItemHandler.BLOCK, (v0, v1) -> {
        return v0.getItemHandler(v1);
    });
    public static final LBlockEntity<H> PATTERN_FORGE_ENCODER = BLOCK_ENTITY_REGISTRY.registerBlockEntity("pattern_forge_encoder", H::new, new Supplier[]{MCTechBlocks.PATTERN_FORGE_ENCODER});
    public static final LBlockEntity<G> PATTERN_ASSEMBLY_ENCODER = BLOCK_ENTITY_REGISTRY.registerBlockEntity("pattern_assembly_encoder", G::new, new Supplier[]{MCTechBlocks.PATTERN_ASSEMBLY_ENCODER});
    public static final LBlockEntity<I> PATTERN_QUANTUM_WORKBENCH_ENCODER = BLOCK_ENTITY_REGISTRY.registerBlockEntity("pattern_quantum_workbench_encoder", I::new, new Supplier[]{MCTechBlocks.PATTERN_QUANTUM_WORKBENCH_ENCODER});
    public static final LBlockEntity<C0070q> FLUID_TANK = BLOCK_ENTITY_REGISTRY.registerBlockEntity("fluid_tank", C0070q::new, new Supplier[]{(Supplier) MCTechBlocks.REGISTERED_FLUID_TANKS.get(MachineTier.T1), (Supplier) MCTechBlocks.REGISTERED_FLUID_TANKS.get(MachineTier.T4), (Supplier) MCTechBlocks.REGISTERED_FLUID_TANKS.get(MachineTier.T5), (Supplier) MCTechBlocks.REGISTERED_FLUID_TANKS.get(MachineTier.T6), (Supplier) MCTechBlocks.REGISTERED_FLUID_TANKS.get(MachineTier.T7)}).addCapability(Capabilities.FluidHandler.BLOCK, (v0, v1) -> {
        return v0.getConnectedTank(v1);
    }).addCapability(Capabilities.ItemHandler.BLOCK, (v0, v1) -> {
        return v0.getItemHandler(v1);
    });
    public static final LBlockEntity<C0069p> FLUID_GENERATOR = BLOCK_ENTITY_REGISTRY.registerBlockEntity("fluid_generator", C0069p::new, new Supplier[]{(Supplier) MCTechBlocks.REGISTERED_WATER_GENERATORS.get(MachineTier.T2), (Supplier) MCTechBlocks.REGISTERED_LAVA_GENERATORS.get(MachineTier.T2), (Supplier) MCTechBlocks.REGISTERED_WATER_GENERATORS.get(MachineTier.T3), (Supplier) MCTechBlocks.REGISTERED_LAVA_GENERATORS.get(MachineTier.T3), (Supplier) MCTechBlocks.REGISTERED_WATER_GENERATORS.get(MachineTier.T4), (Supplier) MCTechBlocks.REGISTERED_LAVA_GENERATORS.get(MachineTier.T4), (Supplier) MCTechBlocks.REGISTERED_WATER_GENERATORS.get(MachineTier.T5), (Supplier) MCTechBlocks.REGISTERED_LAVA_GENERATORS.get(MachineTier.T5)}).addCapability(Capabilities.FluidHandler.BLOCK, (v0, v1) -> {
        return v0.getConnectedTank(v1);
    }).addCapability(Capabilities.ItemHandler.BLOCK, (v0, v1) -> {
        return v0.getItemHandler(v1);
    });
    public static final LBlockEntity<aa> STONE_FLUID_GENERATOR = BLOCK_ENTITY_REGISTRY.registerBlockEntity("stone_fluid_generator", aa::new, new Supplier[]{(Supplier) MCTechBlocks.REGISTERED_WATER_GENERATORS.get(MachineTier.T1), (Supplier) MCTechBlocks.REGISTERED_LAVA_GENERATORS.get(MachineTier.T1)}).addCapability(Capabilities.FluidHandler.BLOCK, (v0, v1) -> {
        return v0.getConnectedTank(v1);
    }).addCapability(Capabilities.ItemHandler.BLOCK, (v0, v1) -> {
        return v0.getItemHandler(v1);
    });
    public static final LBlockEntity<C0061h> COBBLESTONE_GENERATOR = BLOCK_ENTITY_REGISTRY.registerBlockEntity("cobblestone_generator", C0061h::new, new Supplier[]{(Supplier) MCTechBlocks.REGISTERED_COBBLESTONE_GENERATORS.get(MachineTier.T2), (Supplier) MCTechBlocks.REGISTERED_COBBLESTONE_GENERATORS.get(MachineTier.T3), (Supplier) MCTechBlocks.REGISTERED_COBBLESTONE_GENERATORS.get(MachineTier.T4), (Supplier) MCTechBlocks.REGISTERED_COBBLESTONE_GENERATORS.get(MachineTier.T5)}).addCapability(Capabilities.FluidHandler.BLOCK, (v0, v1) -> {
        return v0.getConnectedTank(v1);
    }).addCapability(Capabilities.ItemHandler.BLOCK, (v0, v1) -> {
        return v0.getItemHandler(v1);
    });
    public static final LBlockEntity<X> STONE_COBBLESTONE_GENERATOR = BLOCK_ENTITY_REGISTRY.registerBlockEntity("stone_cobblestone_generator", X::new, new Supplier[]{(Supplier) MCTechBlocks.REGISTERED_COBBLESTONE_GENERATORS.get(MachineTier.T1)}).addCapability(Capabilities.FluidHandler.BLOCK, (v0, v1) -> {
        return v0.getConnectedTank(v1);
    }).addCapability(Capabilities.ItemHandler.BLOCK, (v0, v1) -> {
        return v0.getItemHandler(v1);
    });
    public static final LBlockEntity<K> PLASMA_GENERATOR = BLOCK_ENTITY_REGISTRY.registerBlockEntity(i.PLASMA_GENERATOR.getSerializedName(), K::new, new Supplier[]{(Supplier) MCTechBlocks.REGISTERED_PLASMA_GENERATORS.get(MachineTier.T4), (Supplier) MCTechBlocks.REGISTERED_PLASMA_GENERATORS.get(MachineTier.T6), (Supplier) MCTechBlocks.REGISTERED_PLASMA_GENERATORS.get(MachineTier.T8)}).addCapability(Capabilities.FluidHandler.BLOCK, (v0, v1) -> {
        return v0.getConnectedTank(v1);
    }).addCapability(Capabilities.ItemHandler.BLOCK, (v0, v1) -> {
        return v0.getItemHandler(v1);
    });
    public static final LBlockEntity<E> MOLECULAR_CONVERTER = BLOCK_ENTITY_REGISTRY.registerBlockEntity(i.MOLECULAR_CONVERTER.getSerializedName(), E::new, new Supplier[]{MCTechBlocks.MOLECULAR_CONVERTER});
    public static final LBlockEntity<mctech.p.b.b> MOLECULAR_CONVERTER_TEMPLATE = BLOCK_ENTITY_REGISTRY.registerBlockEntity(i.MOLECULAR_CONVERTER.getSerializedName() + "_template", new BlockEntityType.BlockEntitySupplier<mctech.p.b.b>() { // from class: mctech.init.MCTechTiles.3
        @NotNull
        /* JADX INFO: renamed from: create, reason: merged with bridge method [inline-methods] */
        public mctech.p.b.b m467create(@NotNull BlockPos blockPos, @NotNull BlockState blockState) {
            return new c((BlockEntityType) MCTechTiles.MOLECULAR_CONVERTER_TEMPLATE.get(), blockPos, blockState);
        }
    }, new Supplier[]{MCTechBlocks.MOLECULAR_CONVERTER});
    public static final LBlockEntity<M> QUANTUM_WORKBENCH = BLOCK_ENTITY_REGISTRY.registerBlockEntity(i.QUANTUM_WORKBENCH.getSerializedName(), M::new, new Supplier[]{MCTechBlocks.QUANTUM_WORKBENCH}).addCapability(Capabilities.ItemHandler.BLOCK, (v0, v1) -> {
        return v0.getItemHandler(v1);
    }).addCapability(AECapabilities.CRAFTING_MACHINE, (m, direction) -> {
        return (ICraftingMachine) m.getData(MCTechAttachments.ATTACHMENT_QUANTUM_WORKBENCH);
    });
    public static final LBlockEntity<C0077x> INDUSTRIAL_FORGE = BLOCK_ENTITY_REGISTRY.registerBlockEntity("industrial_forge", C0077x::new, new Supplier[]{MCTechBlocks.INDUSTRIAL_FORGE}).addCapability(Capabilities.ItemHandler.BLOCK, (v0, v1) -> {
        return v0.getItemHandler(v1);
    }).addCapability(AECapabilities.CRAFTING_MACHINE, (c0077x, direction) -> {
        return (ICraftingMachine) c0077x.getData(MCTechAttachments.ATTACHMENT_INDUSTRIAL_FORGE);
    });
    public static final LBlockEntity<C0057d> ASSEMBLY_STATION = BLOCK_ENTITY_REGISTRY.registerBlockEntity(i.ASSEMBLY_STATION.getSerializedName(), C0057d::new, new Supplier[]{MCTechBlocks.ASSEMBLY_STATION}).addCapability(Capabilities.FluidHandler.BLOCK, (v0, v1) -> {
        return v0.getConnectedTank(v1);
    }).addCapability(Capabilities.ItemHandler.BLOCK, (v0, v1) -> {
        return v0.getItemHandler(v1);
    }).addCapability(AECapabilities.CRAFTING_MACHINE, (c0057d, direction) -> {
        return (ICraftingMachine) c0057d.getData(MCTechAttachments.ATTACHMENT_ASSEMBLY_STATION);
    });
    public static final LBlockEntity<ae> TRANSFORMATION_ASSEMBLER = BLOCK_ENTITY_REGISTRY.registerBlockEntity(i.TRANSFORMATION_ASSEMBLER.getSerializedName(), ae::new, new Supplier[]{MCTechBlocks.TRANSFORMATION_ASSEMBLER}).addCapability(Capabilities.ItemHandler.BLOCK, (v0, v1) -> {
        return v0.getItemHandler(v1);
    });
    public static final LBlockEntity<J> PATTERN_TRANSFORMATION_ASSEMBLER_ENCODER = BLOCK_ENTITY_REGISTRY.registerBlockEntity("pattern_transformation_assembler_encoder", J::new, new Supplier[]{MCTechBlocks.PATTERN_TRANSFORMATION_ASSEMBLER_ENCODER});
    public static final LBlockEntity<C0058e> ATOMIC_SMELTER = BLOCK_ENTITY_REGISTRY.registerBlockEntity(i.ATOMIC_SMELTER.getSerializedName(), C0058e::new, new Supplier[]{MCTechBlocks.ATOMIC_SMELTER}).addCapability(Capabilities.FluidHandler.BLOCK, (v0, v1) -> {
        return v0.getConnectedTank(v1);
    }).addCapability(Capabilities.ItemHandler.BLOCK, (v0, v1) -> {
        return v0.getItemHandler(v1);
    });
    public static final LBlockEntity<ag> VENDING_MACHINE = BLOCK_ENTITY_REGISTRY.registerBlockEntity("vending_machine", ag::new, new Supplier[]{MCTechBlocks.VENDING_MACHINE}).addCapability(Capabilities.ItemHandler.BLOCK, (v0, v1) -> {
        return v0.getItemHandler(v1);
    });
    public static final LBlockEntity<u> NUCLEAR_REACTOR = BLOCK_ENTITY_REGISTRY.registerBlockEntity("nuclear_reactor", u::new, new Supplier[]{(Supplier) MCTechBlocks.REGISTERED_NUCLEAR_REACTORS.get(MachineTier.T1), (Supplier) MCTechBlocks.REGISTERED_NUCLEAR_REACTORS.get(MachineTier.T2), (Supplier) MCTechBlocks.REGISTERED_NUCLEAR_REACTORS.get(MachineTier.T3)}).addCapability(Capabilities.ItemHandler.BLOCK, (v0, v1) -> {
        return v0.getItemHandler(v1);
    }).addCapability(Capabilities.FluidHandler.BLOCK, (v0, v1) -> {
        return v0.getConnectedTank(v1);
    });
    public static final LBlockEntity<f> REACTOR_CHAMBER = BLOCK_ENTITY_REGISTRY.registerBlockEntity("reactor_chamber", f::new, new Supplier[]{(Supplier) MCTechBlocks.REGISTERED_NUCLEAR_CHAMBERS.get(MachineTier.T1), (Supplier) MCTechBlocks.REGISTERED_NUCLEAR_CHAMBERS.get(MachineTier.T2), (Supplier) MCTechBlocks.REGISTERED_NUCLEAR_CHAMBERS.get(MachineTier.T3)}).addCapability(Capabilities.ItemHandler.BLOCK, (v0, v1) -> {
        return v0.a(v1);
    }).addCapability(Capabilities.FluidHandler.BLOCK, (v0, v1) -> {
        return v0.getConnectedTank(v1);
    });
    public static final LBlockEntity<v> THERMONUCLEAR_REACTOR = BLOCK_ENTITY_REGISTRY.registerBlockEntity("thermonuclear_reactor", v::new, new Supplier[]{MCTechBlocks.THERMONUCLEAR_REACTOR}).addCapability(Capabilities.ItemHandler.BLOCK, (v0, v1) -> {
        return v0.getItemHandler(v1);
    }).addCapability(Capabilities.FluidHandler.BLOCK, (v0, v1) -> {
        return v0.getConnectedTank(v1);
    });
    public static final LBlockEntity<C0071r> FORMING_MACHINE = BLOCK_ENTITY_REGISTRY.registerBlockEntity("forming_machine", C0071r::new, new Supplier[]{(Supplier) MCTechBlocks.REGISTERED_FORMERS.get(MachineTier.T2), (Supplier) MCTechBlocks.REGISTERED_FORMERS.get(MachineTier.T3), (Supplier) MCTechBlocks.REGISTERED_FORMERS.get(MachineTier.T4), (Supplier) MCTechBlocks.REGISTERED_FORMERS.get(MachineTier.T5)}).addCapability(Capabilities.ItemHandler.BLOCK, (v0, v1) -> {
        return v0.getItemHandler(v1);
    });
    public static final LBlockEntity<B> MASS_FABRICATOR = BLOCK_ENTITY_REGISTRY.registerBlockEntity("mass_fabricator", B::new, new Supplier[]{(Supplier) MCTechBlocks.REGISTERED_MASS_FABRICATORS.get(MachineTier.T5), (Supplier) MCTechBlocks.REGISTERED_MASS_FABRICATORS.get(MachineTier.T6), (Supplier) MCTechBlocks.REGISTERED_MASS_FABRICATORS.get(MachineTier.T7)}).addCapability(Capabilities.ItemHandler.BLOCK, (v0, v1) -> {
        return v0.getItemHandler(v1);
    }).addCapability(Capabilities.FluidHandler.BLOCK, (v0, v1) -> {
        return v0.getConnectedTank(v1);
    });
    public static final LBlockEntity<U> SINGULARITY_COLLECTOR = BLOCK_ENTITY_REGISTRY.registerBlockEntity("singularity_collector", U::new, new Supplier[]{(Supplier) MCTechBlocks.REGISTERED_SINGULARITY_COLLECTORS.get(MachineTier.T3), (Supplier) MCTechBlocks.REGISTERED_SINGULARITY_COLLECTORS.get(MachineTier.T4), (Supplier) MCTechBlocks.REGISTERED_SINGULARITY_COLLECTORS.get(MachineTier.T5), (Supplier) MCTechBlocks.REGISTERED_SINGULARITY_COLLECTORS.get(MachineTier.T6), (Supplier) MCTechBlocks.REGISTERED_SINGULARITY_COLLECTORS.get(MachineTier.T7)}).addCapability(Capabilities.ItemHandler.BLOCK, (v0, v1) -> {
        return v0.getItemHandler(v1);
    });
    public static final LBlockEntity<mctech.a.a.a.a> WIRELESS_CONNECTOR_64K = registerWirelessConnectorTile("wireless_connector_64k", 64, MCTechBlocks.WIRELESS_CONNECTOR_64K);
    public static final LBlockEntity<mctech.a.a.a.a> WIRELESS_CONNECTOR_128K = registerWirelessConnectorTile("wireless_connector_128k", 128, MCTechBlocks.WIRELESS_CONNECTOR_128K);
    public static final LBlockEntity<mctech.a.a.a.a> WIRELESS_CONNECTOR_256K = registerWirelessConnectorTile("wireless_connector_256k", h.i, MCTechBlocks.WIRELESS_CONNECTOR_256K);
    public static final LBlockEntity<C> MATRIX_CONVERTER = BLOCK_ENTITY_REGISTRY.registerBlockEntity("matrix_converter", C::new, new Supplier[]{MCTechBlocks.MATRIX_CONVERTER}).addCapability(Capabilities.ItemHandler.BLOCK, (v0, v1) -> {
        return v0.getItemHandler(v1);
    });
    public static final LBlockEntity<C0063j> CRYSTAL_SYNTH = BLOCK_ENTITY_REGISTRY.registerBlockEntity("crystal_synth", C0063j::new, new Supplier[]{(Supplier) MCTechBlocks.REGISTERED_CRYSTAL_SYNTH.get(MachineTier.T2), (Supplier) MCTechBlocks.REGISTERED_CRYSTAL_SYNTH.get(MachineTier.T3), (Supplier) MCTechBlocks.REGISTERED_CRYSTAL_SYNTH.get(MachineTier.T4), (Supplier) MCTechBlocks.REGISTERED_CRYSTAL_SYNTH.get(MachineTier.T5), (Supplier) MCTechBlocks.REGISTERED_CRYSTAL_SYNTH.get(MachineTier.T6), (Supplier) MCTechBlocks.REGISTERED_CRYSTAL_SYNTH.get(MachineTier.T7)}).addCapability(Capabilities.ItemHandler.BLOCK, (v0, v1) -> {
        return v0.getItemHandler(v1);
    });
    public static final LBlockEntity<D> METAL_FORMER = BLOCK_ENTITY_REGISTRY.registerBlockEntity("metal_former", D::new, new Supplier[]{(Supplier) MCTechBlocks.REGISTERED_METAL_FORMERS.get(MachineTier.T2), (Supplier) MCTechBlocks.REGISTERED_METAL_FORMERS.get(MachineTier.T3), (Supplier) MCTechBlocks.REGISTERED_METAL_FORMERS.get(MachineTier.T4), (Supplier) MCTechBlocks.REGISTERED_METAL_FORMERS.get(MachineTier.T5), (Supplier) MCTechBlocks.REGISTERED_METAL_FORMERS.get(MachineTier.T6), (Supplier) MCTechBlocks.REGISTERED_METAL_FORMERS.get(MachineTier.T7)}).addCapability(Capabilities.ItemHandler.BLOCK, (v0, v1) -> {
        return v0.getItemHandler(v1);
    });
    public static final LBlockEntity<P> RARE_EXTRACTOR = BLOCK_ENTITY_REGISTRY.registerBlockEntity("rare_extractor", P::new, new Supplier[]{(Supplier) MCTechBlocks.REGISTERED_RARE_EXTRACTORS.get(MachineTier.T2), (Supplier) MCTechBlocks.REGISTERED_RARE_EXTRACTORS.get(MachineTier.T3), (Supplier) MCTechBlocks.REGISTERED_RARE_EXTRACTORS.get(MachineTier.T4), (Supplier) MCTechBlocks.REGISTERED_RARE_EXTRACTORS.get(MachineTier.T5), (Supplier) MCTechBlocks.REGISTERED_RARE_EXTRACTORS.get(MachineTier.T6), (Supplier) MCTechBlocks.REGISTERED_RARE_EXTRACTORS.get(MachineTier.T7)}).addCapability(Capabilities.ItemHandler.BLOCK, (v0, v1) -> {
        return v0.getItemHandler(v1);
    });
    public static final LBlockEntity<C0054a> ALLOY_SMELTER = BLOCK_ENTITY_REGISTRY.registerBlockEntity("alloy_smelter", C0054a::new, new Supplier[]{(Supplier) MCTechBlocks.REGISTERED_ALLOY_SMELTERS.get(MachineTier.T2), (Supplier) MCTechBlocks.REGISTERED_ALLOY_SMELTERS.get(MachineTier.T3), (Supplier) MCTechBlocks.REGISTERED_ALLOY_SMELTERS.get(MachineTier.T4), (Supplier) MCTechBlocks.REGISTERED_ALLOY_SMELTERS.get(MachineTier.T5), (Supplier) MCTechBlocks.REGISTERED_ALLOY_SMELTERS.get(MachineTier.T6), (Supplier) MCTechBlocks.REGISTERED_ALLOY_SMELTERS.get(MachineTier.T7)}).addCapability(Capabilities.ItemHandler.BLOCK, (v0, v1) -> {
        return v0.getItemHandler(v1);
    });
    public static final LBlockEntity<V> STONE_ALLOY_SMELTER = BLOCK_ENTITY_REGISTRY.registerBlockEntity("stone_alloy_smelter", V::new, new Supplier[]{(Supplier) MCTechBlocks.REGISTERED_ALLOY_SMELTERS.get(MachineTier.T1)}).addCapability(Capabilities.ItemHandler.BLOCK, (v0, v1) -> {
        return v0.getItemHandler(v1);
    });
    public static final LBlockEntity<ac> STONE_RARE_EXTRACTOR = BLOCK_ENTITY_REGISTRY.registerBlockEntity("stone_rare_extractor", ac::new, new Supplier[]{(Supplier) MCTechBlocks.REGISTERED_RARE_EXTRACTORS.get(MachineTier.T1)}).addCapability(Capabilities.ItemHandler.BLOCK, (v0, v1) -> {
        return v0.getItemHandler(v1);
    });
    public static final LBlockEntity<C0067n> ELECTRONIC_PLANT = BLOCK_ENTITY_REGISTRY.registerBlockEntity("electronic_plant", C0067n::new, new Supplier[]{(Supplier) MCTechBlocks.REGISTERED_ELECTRONIC_PLANTS.get(MachineTier.T2), (Supplier) MCTechBlocks.REGISTERED_ELECTRONIC_PLANTS.get(MachineTier.T3), (Supplier) MCTechBlocks.REGISTERED_ELECTRONIC_PLANTS.get(MachineTier.T4), (Supplier) MCTechBlocks.REGISTERED_ELECTRONIC_PLANTS.get(MachineTier.T5), (Supplier) MCTechBlocks.REGISTERED_ELECTRONIC_PLANTS.get(MachineTier.T6), (Supplier) MCTechBlocks.REGISTERED_ELECTRONIC_PLANTS.get(MachineTier.T7)}).addCapability(Capabilities.ItemHandler.BLOCK, (v0, v1) -> {
        return v0.getItemHandler(v1);
    });
    public static final LBlockEntity<mctech.processing.a> COMPRESSOR = BLOCK_ENTITY_REGISTRY.registerBlockEntity("compressor", mctech.processing.a::new, new Supplier[]{(Supplier) MCTechBlocks.REGISTERED_COMPRESSORS.get(MachineTier.T2), (Supplier) MCTechBlocks.REGISTERED_COMPRESSORS.get(MachineTier.T3), (Supplier) MCTechBlocks.REGISTERED_COMPRESSORS.get(MachineTier.T4), (Supplier) MCTechBlocks.REGISTERED_COMPRESSORS.get(MachineTier.T5), (Supplier) MCTechBlocks.REGISTERED_COMPRESSORS.get(MachineTier.T6), (Supplier) MCTechBlocks.REGISTERED_COMPRESSORS.get(MachineTier.T7)}).addCapability(Capabilities.ItemHandler.BLOCK, (v0, v1) -> {
        return v0.getItemHandler(v1);
    });
    public static final LBlockEntity<mctech.processing.c> FURNACE = BLOCK_ENTITY_REGISTRY.registerBlockEntity("furnace", mctech.processing.c::new, new Supplier[]{(Supplier) MCTechBlocks.REGISTERED_FURNACES.get(MachineTier.T2), (Supplier) MCTechBlocks.REGISTERED_FURNACES.get(MachineTier.T3), (Supplier) MCTechBlocks.REGISTERED_FURNACES.get(MachineTier.T4), (Supplier) MCTechBlocks.REGISTERED_FURNACES.get(MachineTier.T5), (Supplier) MCTechBlocks.REGISTERED_FURNACES.get(MachineTier.T6), (Supplier) MCTechBlocks.REGISTERED_FURNACES.get(MachineTier.T7)}).addCapability(Capabilities.ItemHandler.BLOCK, (v0, v1) -> {
        return v0.getItemHandler(v1);
    });
    public static final LBlockEntity<mctech.processing.d> MACERATOR = BLOCK_ENTITY_REGISTRY.registerBlockEntity("macerator", mctech.processing.d::new, new Supplier[]{(Supplier) MCTechBlocks.REGISTERED_MACERATORS.get(MachineTier.T2), (Supplier) MCTechBlocks.REGISTERED_MACERATORS.get(MachineTier.T3), (Supplier) MCTechBlocks.REGISTERED_MACERATORS.get(MachineTier.T4), (Supplier) MCTechBlocks.REGISTERED_MACERATORS.get(MachineTier.T5), (Supplier) MCTechBlocks.REGISTERED_MACERATORS.get(MachineTier.T6), (Supplier) MCTechBlocks.REGISTERED_MACERATORS.get(MachineTier.T7)}).addCapability(Capabilities.ItemHandler.BLOCK, (v0, v1) -> {
        return v0.getItemHandler(v1);
    });
    public static final LBlockEntity<mctech.processing.b> EXTRACTOR = BLOCK_ENTITY_REGISTRY.registerBlockEntity("extractor", mctech.processing.b::new, new Supplier[]{(Supplier) MCTechBlocks.REGISTERED_EXTRACTORS.get(MachineTier.T2), (Supplier) MCTechBlocks.REGISTERED_EXTRACTORS.get(MachineTier.T3), (Supplier) MCTechBlocks.REGISTERED_EXTRACTORS.get(MachineTier.T4), (Supplier) MCTechBlocks.REGISTERED_EXTRACTORS.get(MachineTier.T5), (Supplier) MCTechBlocks.REGISTERED_EXTRACTORS.get(MachineTier.T6), (Supplier) MCTechBlocks.REGISTERED_EXTRACTORS.get(MachineTier.T7)}).addCapability(Capabilities.ItemHandler.BLOCK, (v0, v1) -> {
        return v0.getItemHandler(v1);
    });
    public static Supplier<BlockEntityType<Y>> STONE_COMPRESSOR = register("stone_compressor", Y::new, MCTechBlocks.STONE_COMPRESSOR);
    public static Supplier<BlockEntityType<Q>> ADVANCED_RECYCLER = register("advanced_recycler", Q::new, MCTechBlocks.NANO_RECYCLER, MCTechBlocks.QUANTUM_RECYCLER, MCTechBlocks.SINGULAR_RECYCLER);
    public static Supplier<BlockEntityType<Z>> STONE_EXTRACTOR = register("stone_extractor", Z::new, MCTechBlocks.STONE_EXTRACTOR);
    public static LBlockEntity<C0056c> ADVANCED_REFINERY = BLOCK_ENTITY_REGISTRY.registerBlockEntity("advanced_refinery", C0056c::new, new Supplier[]{MCTechBlocks.NANO_REFINERY, MCTechBlocks.QUANTUM_REFINERY, MCTechBlocks.SINGULAR_REFINERY}).addCapability(Capabilities.ItemHandler.BLOCK, (v0, v1) -> {
        return v0.getItemHandler(v1);
    }).addCapability(Capabilities.FluidHandler.BLOCK, (v0, v1) -> {
        return v0.getConnectedTank(v1);
    });
    public static Supplier<BlockEntityType<C0062i>> CRYSTAL_GROWTH_CHAMBER = register("crystal_growth_chamber", C0062i::new, MCTechBlocks.CRYSTAL_GROWTH_CHAMBER);
    public static final LBlockEntity<C0072s> GENETIC_SEQUENTOR = BLOCK_ENTITY_REGISTRY.registerBlockEntity("genetic_sequentor", C0072s::new, new Supplier[]{MCTechBlocks.GENETIC_SEQUENTOR}).addCapability(Capabilities.ItemHandler.BLOCK, (c0072s, direction) -> {
        Direction direction = (Direction) c0072s.getBlockState().getValue(BaseFacingBlock.FACING);
        if (direction != direction.getOpposite() && direction != direction && direction != Direction.DOWN) {
            return c0072s.getItemHandler(direction);
        }
        return null;
    });
    public static final LBlockEntity<C0073t> GENETIC_STABILIZER = BLOCK_ENTITY_REGISTRY.registerBlockEntity("genetic_stabilizer", C0073t::new, new Supplier[]{MCTechBlocks.GENETIC_STABILIZER}).addCapability(Capabilities.ItemHandler.BLOCK, (c0073t, direction) -> {
        if (direction == c0073t.getBlockState().getValue(BaseFacingBlock.FACING).getClockWise() || direction == Direction.UP || direction == Direction.DOWN) {
            return c0073t.getItemHandler(direction);
        }
        return null;
    }).addCapability(Capabilities.FluidHandler.BLOCK, (c0073t2, direction2) -> {
        if (direction2 == c0073t2.getBlockState().getValue(BaseFacingBlock.FACING).getClockWise() || direction2 == Direction.UP || direction2 == Direction.DOWN) {
            return c0073t2.getConnectedTank(direction2);
        }
        return null;
    });
    public static final LBlockEntity<ad> SYNTHETIC_PRINTER = BLOCK_ENTITY_REGISTRY.registerBlockEntity("synthetic_printer", ad::new, new Supplier[]{MCTechBlocks.SYNTHETIC_PRINTER}).addCapability(Capabilities.ItemHandler.BLOCK, (adVar, direction) -> {
        Direction direction = (Direction) adVar.getBlockState().getValue(BaseFacingBlock.FACING);
        if (direction != direction.getOpposite() && direction != direction) {
            return adVar.getItemHandler(direction);
        }
        return null;
    });
    public static final LBlockEntity<C0068o> EXPERIENCE_EXTRACTOR = BLOCK_ENTITY_REGISTRY.registerBlockEntity("experience_extractor", C0068o::new, new Supplier[]{MCTechBlocks.EXPERIENCE_EXTRACTOR}).addCapability(Capabilities.ItemHandler.BLOCK, (c0068o, direction) -> {
        if (direction == c0068o.getBlockState().getValue(BaseFacingBlock.FACING).getOpposite() || direction == Direction.UP || direction == Direction.DOWN) {
            return c0068o.getItemHandler(direction);
        }
        return null;
    }).addCapability(Capabilities.FluidHandler.BLOCK, (c0068o2, direction2) -> {
        if (direction2 == c0068o2.getBlockState().getValue(BaseFacingBlock.FACING).getOpposite() || direction2 == Direction.UP || direction2 == Direction.DOWN) {
            return c0068o2.getConnectedTank(direction2);
        }
        return null;
    });
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<C0076w>> GRINDING_MACHINE = register(MCTechBlocks.GRINDING_MACHINE, C0076w::new);
    public static final Map<Class<?>, BlockEntityType<?>> CLASS_TO_TYPE = new HashMap();

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/init/MCTechTiles$BlockEntityBuilder.class */
    @FunctionalInterface
    public interface BlockEntityBuilder<T extends BlockEntity> {
        T create(BlockEntityType<T> blockEntityType, BlockPos blockPos, BlockState blockState);
    }

    public static void register(IEventBus iEventBus) {
        BLOCK_ENTITY_REGISTRY.register(iEventBus);
    }

    private static LBlockEntity<mctech.a.a.a.a> registerWirelessConnectorTile(String str, int i, LBlock<mctech.a.a.b.a> lBlock) {
        return BLOCK_ENTITY_REGISTRY.registerBlockEntity(str, () -> {
            AtomicReference atomicReference = new AtomicReference();
            BlockEntityType blockEntityTypeBuild = BlockEntityType.Builder.of((blockPos, blockState) -> {
                return new mctech.a.a.a.a((BlockEntityType) atomicReference.get(), blockPos, blockState, i, (ItemLike) lBlock.get());
            }, new Block[]{(Block) lBlock.get()}).build((Type) null);
            atomicReference.set(blockEntityTypeBuild);
            ((mctech.a.a.b.a) lBlock.get()).setBlockEntity(mctech.a.a.a.a.class, blockEntityTypeBuild, null, (level, blockPos2, blockState2, aVar) -> {
                aVar.serverTick();
            });
            AEBaseBlockEntity.registerBlockEntityItem(blockEntityTypeBuild, ((mctech.a.a.b.a) lBlock.get()).asItem());
            return blockEntityTypeBuild;
        });
    }

    @NotNull
    private static <T extends BlockEntity> DeferredHolder<BlockEntityType<?>, BlockEntityType<T>> register(@NotNull DeferredBlock<?> deferredBlock, BlockEntityType.BlockEntitySupplier<T> blockEntitySupplier) {
        return BLOCK_ENTITY_REGISTRY.register(deferredBlock.getId().getPath(), () -> {
            return BlockEntityType.Builder.of(blockEntitySupplier, new Block[]{(Block) deferredBlock.get()}).build((Type) null);
        });
    }

    @Nullable
    @Deprecated(forRemoval = true, since = "Use MSRegistry for registering tiles")
    public static <T extends BlockEntity> LBlockEntity<T> registerBlockEntityAndGet(@NotNull String str, Class<T> cls, BlockEntityBuilder<T> blockEntityBuilder, DeferredBlock<?>... deferredBlockArr) {
        if (deferredBlockArr == null || deferredBlockArr.length == 0) {
            MCTech.LOGGER.error("Can't register block entity '" + str + "' because target block is empty");
            return null;
        }
        for (DeferredBlock<?> deferredBlock : deferredBlockArr) {
            if (deferredBlock == null) {
                MCTech.LOGGER.error("Can't register block entity '" + str + "' because target block is empty");
                return null;
            }
        }
        return BLOCK_ENTITY_REGISTRY.registerBlockEntity(str, () -> {
            AtomicReference atomicReference = new AtomicReference();
            BlockEntityType.BlockEntitySupplier blockEntitySupplier = (blockPos, blockState) -> {
                return blockEntityBuilder.create((BlockEntityType) atomicReference.get(), blockPos, blockState);
            };
            mctech.blocks.base.e[] eVarArr = (Block[]) Arrays.stream(deferredBlockArr).map((v0) -> {
                return v0.get();
            }).toArray(i -> {
                return new Block[i];
            });
            BlockEntityType<? extends BlockEntity> blockEntityTypeBuild = BlockEntityType.Builder.of(blockEntitySupplier, eVarArr).build((Type) null);
            atomicReference.setPlain(blockEntityTypeBuild);
            CLASS_TO_TYPE.put(cls, blockEntityTypeBuild);
            for (mctech.blocks.base.e eVar : eVarArr) {
                if (eVar instanceof mctech.blocks.base.e) {
                    eVar.setBlockEntityType(blockEntityTypeBuild);
                }
            }
            return blockEntityTypeBuild;
        });
    }

    @Deprecated(forRemoval = true, since = "Use MSRegistry for registering tiles")
    private static <T extends BlockEntity> Supplier<BlockEntityType<T>> register(String str, BlockEntityType.BlockEntitySupplier<T> blockEntitySupplier, DeferredBlock<?>... deferredBlockArr) {
        return BLOCK_ENTITY_REGISTRY.register(str, () -> {
            return BlockEntityType.Builder.of(blockEntitySupplier, (Block[]) Arrays.stream(deferredBlockArr).map((v0) -> {
                return v0.get();
            }).toArray(i -> {
                return new Block[i];
            })).build((Type) null);
        });
    }

    @Deprecated(forRemoval = true, since = "Use MSRegistry for registering tiles")
    public static <T extends BlockEntity> void registerBlockEntity(String str, Class<T> cls, BlockEntityBuilder<T> blockEntityBuilder, DeferredBlock<?>... deferredBlockArr) {
        registerBlockEntityAndGet(str, cls, blockEntityBuilder, deferredBlockArr);
    }

    public static <T extends BlockEntity> List<BlockEntityType<T>> getInstanceOf(Class<T> cls) {
        ArrayList arrayList = new ArrayList();
        CLASS_TO_TYPE.forEach((cls2, blockEntityType) -> {
            if (cls.isAssignableFrom(cls2)) {
                arrayList.add(blockEntityType);
            }
        });
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public static <T extends BlockEntity> BlockEntityType<T> getBlockEntity(Class<T> cls) {
        return CLASS_TO_TYPE.get(cls);
    }

    public static void loadTiles() {
        registerBlockEntity("iron_furnace", C0078y.class, C0078y::new, MCTechBlocks.IRON_FURNACE);
        registerBlockEntity("stone_macerator", ab.class, ab::new, MCTechBlocks.STONE_MACERATOR);
        registerBlockEntity("stone_canner", W.class, W::new, MCTechBlocks.STONE_CANNER);
        registerBlockEntity("recycler", R.class, R::new, MCTechBlocks.RECYCLER);
        registerBlockEntity("sawmill", T.class, T::new, MCTechBlocks.SAWMILL);
        registerBlockEntity("rare_earth_extractor", O.class, O::new, MCTechBlocks.RARE_EARTH_EXTRACTOR);
        registerBlockEntity("canner", C0059f.class, C0059f::new, MCTechBlocks.CANNER);
        registerBlockEntity("electrolyzer", C0066m.class, C0066m::new, MCTechBlocks.ELECTROLYZER);
        registerBlockEntity("charged_electrolyzer", C0060g.class, C0060g::new, MCTechBlocks.CHARGED_ELECTROLYZER);
        registerBlockEntity("centrifugal_rare_earth_extractor", N.class, N::new, MCTechBlocks.CENTRIFUGAL_RARE_EARTH_EXTRACTOR);
        registerBlockEntity("refinery", S.class, S::new, MCTechBlocks.REFINERY);
        registerBlockEntity("uranium_enricher", af.class, af::new, MCTechBlocks.URANIUM_ENRICHER);
        registerBlockEntity("generator", mctech.blockentities.b.b.class, mctech.blockentities.b.b::new, MCTechBlocks.GENERATOR);
        registerBlockEntity("geo_generator", mctech.blockentities.b.c.class, mctech.blockentities.b.c::new, MCTechBlocks.GEOTHERMAL_GENERATOR);
        registerBlockEntity("slag_generator", mctech.blockentities.b.h.class, mctech.blockentities.b.h::new, MCTechBlocks.SLAG_GENERATOR);
        registerBlockEntity("water_mill", k.class, k::new, MCTechBlocks.WATER_MILL);
        registerBlockEntity("water_mill_t2", k.a.class, k.a::new, MCTechBlocks.WATER_MILL_T2);
        registerBlockEntity("water_mill_t3", k.b.class, k.b::new, MCTechBlocks.WATER_MILL_T3);
        registerBlockEntity("water_mill_t4", k.c.class, k.c::new, MCTechBlocks.WATER_MILL_T4);
        registerBlockEntity("thermal_generator", j.class, j::new, MCTechBlocks.THERMAL_GENERATOR);
        registerBlockEntity("standard_solar_panel", mctech.blockentities.b.a.j.class, mctech.blockentities.b.a.j::new, MCTechBlocks.STANDARD_SOLAR_PANEL);
        registerBlockEntity("simple_solar_panel", mctech.blockentities.b.a.i.class, mctech.blockentities.b.a.i::new, MCTechBlocks.SIMPLE_SOLAR_PANEL);
        registerBlockEntity("advanced_solar_panel", mctech.blockentities.b.a.b.class, mctech.blockentities.b.a.b::new, MCTechBlocks.ADVANCED_SOLAR_PANEL);
        registerBlockEntity("hybrid_solar_panel", mctech.blockentities.b.a.d.class, mctech.blockentities.b.a.d::new, MCTechBlocks.HYBRID_SOLAR_PANEL);
        registerBlockEntity("proton_solar_panel", mctech.blockentities.b.a.f.class, mctech.blockentities.b.a.f::new, MCTechBlocks.PROTON_SOLAR_PANEL);
        registerBlockEntity("composite_solar_panel", mctech.blockentities.b.a.c.class, mctech.blockentities.b.a.c::new, MCTechBlocks.COMPOSITE_SOLAR_PANEL);
        registerBlockEntity("nano_solar_panel", mctech.blockentities.b.a.e.class, mctech.blockentities.b.a.e::new, MCTechBlocks.NANO_SOLAR_PANEL);
        registerBlockEntity("quant_solar_panel", mctech.blockentities.b.a.g.class, mctech.blockentities.b.a.g::new, MCTechBlocks.QUANT_SOLAR_PANEL);
        registerBlockEntity("singular_solar_panel", mctech.blockentities.b.a.h.class, mctech.blockentities.b.a.h::new, MCTechBlocks.SINGULAR_SOLAR_PANEL);
        registerBlockEntity("admin_solar_panel", mctech.blockentities.b.a.C0001a.class, mctech.blockentities.b.a.C0001a::new, MCTechBlocks.ADMIN_SOLAR_PANEL);
        registerBlockEntity("composite_multisolar_panel", mctech.blockentities.b.d.a.class, mctech.blockentities.b.d.a::new, MCTechBlocks.COMPOSITE_MULTISOLAR_PANEL);
        registerBlockEntity("nano_multisolar_panel", mctech.blockentities.b.d.b.class, mctech.blockentities.b.d.b::new, MCTechBlocks.NANO_MULTISOLAR_PANEL);
        registerBlockEntity("quant_multisolar_panel", mctech.blockentities.b.d.c.class, mctech.blockentities.b.d.c::new, MCTechBlocks.QUANT_MULTISOLAR_PANEL);
        registerBlockEntity("singular_multisolar_panel", mctech.blockentities.b.d.e.class, mctech.blockentities.b.d.e::new, MCTechBlocks.SINGULAR_MULTISOLAR_PANEL);
        registerBlockEntity("rubid_multisolar_panel", mctech.blockentities.b.d.C0002d.class, mctech.blockentities.b.d.C0002d::new, MCTechBlocks.RUBID_MULTISOLAR_PANEL);
        registerBlockEntity("energy_storage_1", mctech.blockentities.e.e.class, mctech.blockentities.e.e::new, MCTechBlocks.ENERGY_STORAGE_1);
        registerBlockEntity("energy_storage_2", mctech.blockentities.e.j.class, mctech.blockentities.e.j::new, MCTechBlocks.ENERGY_STORAGE_2);
        registerBlockEntity("energy_storage_3", mctech.blockentities.e.i.class, mctech.blockentities.e.i::new, MCTechBlocks.ENERGY_STORAGE_3);
        registerBlockEntity("energy_storage_4", mctech.blockentities.e.c.class, mctech.blockentities.e.c::new, MCTechBlocks.ENERGY_STORAGE_4);
        registerBlockEntity("energy_storage_5", mctech.blockentities.e.b.class, mctech.blockentities.e.b::new, MCTechBlocks.ENERGY_STORAGE_5);
        registerBlockEntity("energy_storage_6", g.class, g::new, MCTechBlocks.ENERGY_STORAGE_6);
        registerBlockEntity("energy_storage_7", mctech.blockentities.e.f.class, mctech.blockentities.e.f::new, MCTechBlocks.ENERGY_STORAGE_7);
        registerBlockEntity("energy_storage_8", mctech.blockentities.e.a.class, mctech.blockentities.e.a::new, MCTechBlocks.ENERGY_STORAGE_8);
        registerBlockEntity("energy_storage_9", mctech.blockentities.e.d.class, mctech.blockentities.e.d::new, MCTechBlocks.ENERGY_STORAGE_9);
        registerBlockEntity("energy_storage_10", mctech.blockentities.e.h.class, mctech.blockentities.e.h::new, MCTechBlocks.ENERGY_STORAGE_10);
        registerBlockEntity("transformer_0", m.class, m::new, MCTechBlocks.TRANSFORMER_0);
        registerBlockEntity("transformer_1", mctech.blockentities.g.h.class, mctech.blockentities.g.h::new, MCTechBlocks.TRANSFORMER_1);
        registerBlockEntity("transformer_2", mctech.blockentities.g.l.class, mctech.blockentities.g.l::new, MCTechBlocks.TRANSFORMER_2);
        registerBlockEntity("transformer_3", mctech.blockentities.g.k.class, mctech.blockentities.g.k::new, MCTechBlocks.TRANSFORMER_3);
        registerBlockEntity("transformer_4", mctech.blockentities.g.f.class, mctech.blockentities.g.f::new, MCTechBlocks.TRANSFORMER_4);
        registerBlockEntity("transformer_5", mctech.blockentities.g.e.class, mctech.blockentities.g.e::new, MCTechBlocks.TRANSFORMER_5);
        registerBlockEntity("transformer_adjustable_1", mctech.blockentities.g.a.class, mctech.blockentities.g.a::new, MCTechBlocks.TRANSFORMER_ADJUSTABLE_1);
        registerBlockEntity("transformer_6", mctech.blockentities.g.j.class, mctech.blockentities.g.j::new, MCTechBlocks.TRANSFORMER_6);
        registerBlockEntity("transformer_7", mctech.blockentities.g.i.class, mctech.blockentities.g.i::new, MCTechBlocks.TRANSFORMER_7);
        registerBlockEntity("transformer_8", mctech.blockentities.g.d.class, mctech.blockentities.g.d::new, MCTechBlocks.TRANSFORMER_8);
        registerBlockEntity("transformer_9", mctech.blockentities.g.g.class, mctech.blockentities.g.g::new, MCTechBlocks.TRANSFORMER_9);
        registerBlockEntity("transformer_adjustable_2", mctech.blockentities.g.c.class, mctech.blockentities.g.c::new, MCTechBlocks.TRANSFORMER_ADJUSTABLE_2);
        registerBlockEntity("chargepad_1", mctech.blockentities.d.e.class, mctech.blockentities.d.e::new, (DeferredBlock) MCTechBlocks.REGISTERED_CHARGE_PADS.get(MachineTier.T1));
        registerBlockEntity("chargepad_2", mctech.blockentities.d.j.class, mctech.blockentities.d.j::new, (DeferredBlock) MCTechBlocks.REGISTERED_CHARGE_PADS.get(MachineTier.T2));
        registerBlockEntity("chargepad_3", mctech.blockentities.d.i.class, mctech.blockentities.d.i::new, (DeferredBlock) MCTechBlocks.REGISTERED_CHARGE_PADS.get(MachineTier.T3));
        registerBlockEntity("chargepad_4", mctech.blockentities.d.c.class, mctech.blockentities.d.c::new, (DeferredBlock) MCTechBlocks.REGISTERED_CHARGE_PADS.get(MachineTier.T4));
        registerBlockEntity("chargepad_5", mctech.blockentities.d.b.class, mctech.blockentities.d.b::new, (DeferredBlock) MCTechBlocks.REGISTERED_CHARGE_PADS.get(MachineTier.T5));
        registerBlockEntity("chargepad_6", mctech.blockentities.d.g.class, mctech.blockentities.d.g::new, (DeferredBlock) MCTechBlocks.REGISTERED_CHARGE_PADS.get(MachineTier.T6));
        registerBlockEntity("chargepad_7", mctech.blockentities.d.f.class, mctech.blockentities.d.f::new, (DeferredBlock) MCTechBlocks.REGISTERED_CHARGE_PADS.get(MachineTier.T7));
        registerBlockEntity("chargepad_8", mctech.blockentities.d.a.class, mctech.blockentities.d.a::new, (DeferredBlock) MCTechBlocks.REGISTERED_CHARGE_PADS.get(MachineTier.T8));
        registerBlockEntity("chargepad_9", mctech.blockentities.d.d.class, mctech.blockentities.d.d::new, (DeferredBlock) MCTechBlocks.REGISTERED_CHARGE_PADS.get(MachineTier.T9));
        registerBlockEntity("chargepad_10", mctech.blockentities.d.h.class, mctech.blockentities.d.h::new, (DeferredBlock) MCTechBlocks.REGISTERED_CHARGE_PADS.get(MachineTier.T10));
        registerBlockEntity("charging_bench_1", mctech.blockentities.a.e.class, mctech.blockentities.a.e::new, MCTechBlocks.CHARGING_BENCH_1);
        registerBlockEntity("charging_bench_2", mctech.blockentities.a.j.class, mctech.blockentities.a.j::new, MCTechBlocks.CHARGING_BENCH_2);
        registerBlockEntity("charging_bench_3", mctech.blockentities.a.i.class, mctech.blockentities.a.i::new, MCTechBlocks.CHARGING_BENCH_3);
        registerBlockEntity("charging_bench_4", mctech.blockentities.a.c.class, mctech.blockentities.a.c::new, MCTechBlocks.CHARGING_BENCH_4);
        registerBlockEntity("charging_bench_5", mctech.blockentities.a.b.class, mctech.blockentities.a.b::new, MCTechBlocks.CHARGING_BENCH_5);
        registerBlockEntity("charging_bench_6", mctech.blockentities.a.g.class, mctech.blockentities.a.g::new, MCTechBlocks.CHARGING_BENCH_6);
        registerBlockEntity("charging_bench_7", mctech.blockentities.a.f.class, mctech.blockentities.a.f::new, MCTechBlocks.CHARGING_BENCH_7);
        registerBlockEntity("charging_bench_8", mctech.blockentities.a.a.class, mctech.blockentities.a.a::new, MCTechBlocks.CHARGING_BENCH_8);
        registerBlockEntity("charging_bench_9", mctech.blockentities.a.d.class, mctech.blockentities.a.d::new, MCTechBlocks.CHARGING_BENCH_9);
        registerBlockEntity("charging_bench_10", mctech.blockentities.a.h.class, mctech.blockentities.a.h::new, MCTechBlocks.CHARGING_BENCH_10);
        for (mctech.r.a.d dVar : mctech.r.a.d.values()) {
            for (mctech.r.a.c cVar : mctech.r.a.c.values()) {
                mctech.r.a.b.a(dVar, cVar);
            }
        }
        registerBlockEntity("dust_factory", C0064k.class, C0064k::new, MCTechBlocks.DUST_FACTORY);
        registerBlockEntity("greenhouse", C0075v.class, C0075v::new, MCTechBlocks.GREENHOUSE);
        registerBlockEntity("reactor_planner", mctech.blockentities.b.g.class, mctech.blockentities.b.g::new, MCTechBlocks.REACTOR_PLANNER);
    }
}
