package mctech.init;

import appeng.api.util.AEColor;
import java.util.Locale;
import java.util.function.Function;
import mctech.MCTech;
import mctech.a.a.b.a;
import mctech.blocks.base.blocks.BaseActivityBlock;
import mctech.i.i;
import mctech.utils.math.geometry.e;
import mctech.v.A;
import mctech.v.g;
import mctech.v.j;
import mctech.v.k;
import net.mcskill.msregistry.core.MachineTier;
import net.mcskill.msregistry.datagen.DataGenContext;
import net.mcskill.msregistry.datagen.data.LItemModelProvider;
import net.mcskill.msregistry.registry.render.GeneratedItemModel;
import net.mcskill.msregistry.registry.render.GeneratedModel;
import net.mcskill.msregistry.registry.type.ModelRegistry;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.MultiPartBlockStateBuilder;
import software.bernie.geckolib.constant.DataTickets;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/init/MCTechModels.class */
public class MCTechModels {
    public static final ModelRegistry MODEL_REGISTRY = MCTech.REGISTRY.modelRegistry();

    static {
        MODEL_REGISTRY.register(new GeneratedItemModel(MCTechItems.DESTROYER).item(hVar -> {
            return MCTechItems.DESTROYER.getId().getPath();
        }, hVar2 -> {
            return MCTechItems.DESTROYER.getId().getPath();
        }, hVar3 -> {
            return "destroyer";
        }).overrideItem(geckoModel -> {
            geckoModel.setCustomAnimationStateHandler((hVar4, animationState) -> {
                ItemDisplayContext itemDisplayContext = (ItemDisplayContext) animationState.getData(DataTickets.ITEM_RENDER_PERSPECTIVE);
                if (itemDisplayContext != null) {
                    switch (AnonymousClass1.$SwitchMap$net$minecraft$world$item$ItemDisplayContext[itemDisplayContext.ordinal()]) {
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                            break;
                        default:
                            return true;
                    }
                }
                return false;
            });
            return geckoModel;
        }).itemLayers(new Function[]{g::new}));
        MODEL_REGISTRY.register(new GeneratedItemModel(MCTechItems.ADVANCED_DESTROYER).item(gVar -> {
            return MCTechItems.ADVANCED_DESTROYER.getId().getPath();
        }, gVar2 -> {
            return MCTechItems.ADVANCED_DESTROYER.getId().getPath();
        }, gVar3 -> {
            return "destroyer";
        }).overrideItem(geckoModel2 -> {
            geckoModel2.setCustomAnimationStateHandler((gVar4, animationState) -> {
                ItemDisplayContext itemDisplayContext = (ItemDisplayContext) animationState.getData(DataTickets.ITEM_RENDER_PERSPECTIVE);
                if (itemDisplayContext != null) {
                    switch (AnonymousClass1.$SwitchMap$net$minecraft$world$item$ItemDisplayContext[itemDisplayContext.ordinal()]) {
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                            break;
                        default:
                            return true;
                    }
                }
                return false;
            });
            return geckoModel2;
        }).itemLayers(new Function[]{g::new}));
        MODEL_REGISTRY.register(new GeneratedItemModel(MCTechItems.CHAINSAW).item(cVar -> {
            return MCTechItems.CHAINSAW.getId().getPath();
        }, cVar2 -> {
            return MCTechItems.CHAINSAW.getId().getPath();
        }, cVar3 -> {
            return "chainsaw";
        }).overrideItem(geckoModel3 -> {
            geckoModel3.setCustomAnimationStateHandler((cVar4, animationState) -> {
                ItemDisplayContext itemDisplayContext = (ItemDisplayContext) animationState.getData(DataTickets.ITEM_RENDER_PERSPECTIVE);
                if (itemDisplayContext != null) {
                    switch (AnonymousClass1.$SwitchMap$net$minecraft$world$item$ItemDisplayContext[itemDisplayContext.ordinal()]) {
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                            break;
                        default:
                            return true;
                    }
                }
                return false;
            });
            return geckoModel3;
        }));
        MODEL_REGISTRY.register(new GeneratedItemModel(MCTechItems.ADVANCED_CHAINSAW).item(cVar4 -> {
            return MCTechItems.ADVANCED_CHAINSAW.getId().getPath();
        }, cVar5 -> {
            return MCTechItems.ADVANCED_CHAINSAW.getId().getPath();
        }, cVar6 -> {
            return "chainsaw";
        }).overrideItem(geckoModel4 -> {
            geckoModel4.setCustomAnimationStateHandler((cVar7, animationState) -> {
                ItemDisplayContext itemDisplayContext = (ItemDisplayContext) animationState.getData(DataTickets.ITEM_RENDER_PERSPECTIVE);
                if (itemDisplayContext != null) {
                    switch (AnonymousClass1.$SwitchMap$net$minecraft$world$item$ItemDisplayContext[itemDisplayContext.ordinal()]) {
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                            break;
                        default:
                            return true;
                    }
                }
                return false;
            });
            return geckoModel4;
        }));
        MODEL_REGISTRY.register(MODEL_REGISTRY.tierActiveRelated(i.ASSEMBLY_STATION.getSerializedName(), MCTechTiles.ASSEMBLY_STATION, false));
        MODEL_REGISTRY.register(new GeneratedModel(MCTechTiles.ELEVATOR_TELEPORTER).block(bVar -> {
            return "elevator_teleporter";
        }, bVar2 -> {
            return "elevator_teleporter";
        }, bVar3 -> {
            return "elevator_teleporter";
        }).item().overrideItemSubtype("block"));
        MODEL_REGISTRY.register(new GeneratedModel(MCTechTiles.LINKED_TELEPORTER).block(dVar -> {
            return "linked_teleporter";
        }, dVar2 -> {
            return "linked_teleporter";
        }, dVar3 -> {
            return "linked_teleporter";
        }).item().overrideItemSubtype("block"));
        MODEL_REGISTRY.register(MODEL_REGISTRY.tierStateRelated(i.ATOMIC_SMELTER.getSerializedName(), MCTechTiles.ATOMIC_SMELTER, c0058e -> {
            Object[] objArr = new Object[1];
            objArr[0] = ((Boolean) c0058e.getBlockState().getOptionalValue(BaseActivityBlock.ACTIVE).orElse(false)).booleanValue() ? "on" : "off";
            return c0058e.isOverheating() ? "overheat" : String.format("%s", objArr);
        }, cVar7 -> {
            return "t6_on";
        }, false));
        GeneratedModel generatedModelTierActiveRelated = MODEL_REGISTRY.tierActiveRelated(i.COBBLESTONE_GENERATOR.getSerializedName(), MCTechTiles.COBBLESTONE_GENERATOR, false);
        generatedModelTierActiveRelated.itemLayers(new Function[]{geoItemRenderer -> {
            return new k(geoItemRenderer).a(dVar4 -> {
                return new k.a(new e(13.0f, 3.5f, 1.0f), new e(2.0f, 9.0f, 14.0f), Fluids.WATER, new k.b(1, 1, 0.05f, true, true, new e(-0.5f, 0.0f, -0.5f)));
            }).a(dVar5 -> {
                return new k.a(new e(1.0f, 3.5f, 1.0f), new e(2.0f, 9.0f, 14.0f), Fluids.LAVA, new k.b(1, 1, 0.05f, true, true, new e(-0.5f, 0.0f, -0.5f)));
            });
        }}).blockLayers(new Function[]{geoBlockRenderer -> {
            return new k(geoBlockRenderer).a(c0061h -> {
                return new k.a(new e(13.0f, 3.5f, 1.0f), new e(2.0f, 9.0f, 14.0f), Fluids.WATER, new k.b(c0061h.a.getFluidAmount(), c0061h.a.getCapacity(), 0.05f, false, true, new e(-0.5f, 0.0f, -0.5f)));
            }).a(c0061h2 -> {
                return new k.a(new e(1.0f, 3.5f, 1.0f), new e(2.0f, 9.0f, 14.0f), Fluids.LAVA, new k.b(c0061h2.b.getFluidAmount(), c0061h2.b.getCapacity(), 0.05f, false, true, new e(-0.5f, 0.0f, -0.5f)));
            });
        }});
        GeneratedModel generatedModelTierActiveRelated2 = MODEL_REGISTRY.tierActiveRelated(i.COBBLESTONE_GENERATOR.getSerializedName(), MCTechTiles.STONE_COBBLESTONE_GENERATOR, true);
        generatedModelTierActiveRelated2.itemLayers(new Function[]{geoItemRenderer2 -> {
            return new k(geoItemRenderer2).a(dVar4 -> {
                return new k.a(new e(13.0f, 3.5f, 1.0f), new e(2.0f, 9.0f, 14.0f), Fluids.WATER, new k.b(1, 1, 0.05f, true, true, new e(-0.5f, 0.0f, -0.5f)));
            }).a(dVar5 -> {
                return new k.a(new e(1.0f, 3.5f, 1.0f), new e(2.0f, 9.0f, 14.0f), Fluids.LAVA, new k.b(1, 1, 0.05f, true, true, new e(-0.5f, 0.0f, -0.5f)));
            });
        }}).blockLayers(new Function[]{geoBlockRenderer2 -> {
            return new k(geoBlockRenderer2).a(x -> {
                return new k.a(new e(13.0f, 3.5f, 1.0f), new e(2.0f, 9.0f, 14.0f), Fluids.WATER, new k.b(x.f.getFluidAmount(), x.f.getCapacity(), 0.05f, false, true, new e(-0.5f, 0.0f, -0.5f)));
            }).a(x2 -> {
                return new k.a(new e(1.0f, 3.5f, 1.0f), new e(2.0f, 9.0f, 14.0f), Fluids.LAVA, new k.b(x2.g.getFluidAmount(), x2.g.getCapacity(), 0.05f, false, true, new e(-0.5f, 0.0f, -0.5f)));
            });
        }});
        MODEL_REGISTRY.register(generatedModelTierActiveRelated2);
        MODEL_REGISTRY.register(generatedModelTierActiveRelated);
        MODEL_REGISTRY.register(MODEL_REGISTRY.tierActiveRelated(i.PLASMA_GENERATOR.getSerializedName(), MCTechTiles.PLASMA_GENERATOR, false).blockLayers(new Function[]{geoBlockRenderer3 -> {
            return new k(geoBlockRenderer3).a(k -> {
                return new k.a(new e(-5.0f, 3.0f, -7.0f), new e(10.0f, 10.0f, 4.0f), k.N_(), new k.b(k.a.getFluidAmount(), k.a.getCapacity(), 0.0f, false, false));
            });
        }}));
        GeneratedModel generatedModelTierActiveRelated3 = MODEL_REGISTRY.tierActiveRelated(i.FLUID_GENERATOR.getSerializedName(), MCTechTiles.FLUID_GENERATOR, false);
        generatedModelTierActiveRelated3.itemLayers(new Function[]{geoItemRenderer3 -> {
            return new k(geoItemRenderer3).a(hVar4 -> {
                return new k.a(new e(-7.25f, 3.5f, -7.25f), new e(14.5f, 9.0f, 2.25f), hVar4.g().a(), new k.b(1, 1, 0.05f, true, true));
            });
        }}).blockLayers(new Function[]{geoBlockRenderer4 -> {
            return new k(geoBlockRenderer4).a(c0069p -> {
                return new k.a(new e(-7.25f, 3.5f, -7.25f), new e(14.5f, 9.0f, 2.25f), c0069p.g().a(), new k.b(c0069p.a.getFluidAmount(), c0069p.a.getCapacity(), 0.05f, false, true));
            });
        }});
        MODEL_REGISTRY.register(generatedModelTierActiveRelated3);
        GeneratedModel generatedModelTierActiveRelated4 = MODEL_REGISTRY.tierActiveRelated(i.FLUID_GENERATOR.getSerializedName(), MCTechTiles.STONE_FLUID_GENERATOR, true);
        generatedModelTierActiveRelated4.itemLayers(new Function[]{geoItemRenderer4 -> {
            return new k(geoItemRenderer4).a(hVar4 -> {
                return new k.a(new e(-7.25f, 3.5f, -7.25f), new e(14.5f, 9.0f, 2.25f), hVar4.g().a(), new k.b(1, 1, 0.05f, false, true));
            });
        }}).blockLayers(new Function[]{geoBlockRenderer5 -> {
            return new k(geoBlockRenderer5).a(aaVar -> {
                return new k.a(new e(-7.25f, 3.5f, -7.25f), new e(14.5f, 9.0f, 2.25f), aaVar.g().a(), new k.b(aaVar.f.getFluidAmount(), aaVar.f.getCapacity(), 0.05f, false, true));
            });
        }});
        MODEL_REGISTRY.register(generatedModelTierActiveRelated4);
        MODEL_REGISTRY.register(MODEL_REGISTRY.tierRelated(i.FLUID_TANK.getSerializedName(), MCTechTiles.FLUID_TANK, false).requireRotation(false).blockLayers(new Function[]{geoBlockRenderer6 -> {
            return new k(geoBlockRenderer6).a(c0070q -> {
                return new k.a(new e(-4.5f, 2.0f, -4.5f), new e(9.0f, 12.0f, 9.0f), c0070q.f.getFluid().getFluid(), new k.b(c0070q.f.getFluidAmount(), c0070q.f.getCapacity(), 0.0f, false, false));
            });
        }}));
        MODEL_REGISTRY.register(MODEL_REGISTRY.register("item_duplicator", MCTechTiles.ITEM_DUPLICATOR, a -> {
            return "item_duplicator";
        }, item -> {
            return "item_duplicator";
        }, false));
        MODEL_REGISTRY.register(MODEL_REGISTRY.register("item_destroyer", MCTechTiles.ITEM_DESTROYER, c0079z -> {
            return "item_destroyer";
        }, item2 -> {
            return "item_destroyer";
        }, false));
        MODEL_REGISTRY.register(MODEL_REGISTRY.register("pattern_forge_encoder", MCTechTiles.PATTERN_FORGE_ENCODER, h -> {
            return "pattern_forge_encoder";
        }, item3 -> {
            return "pattern_forge_encoder";
        }, false));
        MODEL_REGISTRY.register(MODEL_REGISTRY.register("pattern_assembly_encoder", MCTechTiles.PATTERN_ASSEMBLY_ENCODER, g -> {
            return "pattern_assembly_encoder";
        }, item4 -> {
            return "pattern_assembly_encoder";
        }, false));
        MODEL_REGISTRY.register(MODEL_REGISTRY.register("pattern_quantum_workbench_encoder", MCTechTiles.PATTERN_QUANTUM_WORKBENCH_ENCODER, i -> {
            return "pattern_quantum_workbench_encoder";
        }, item5 -> {
            return "pattern_quantum_workbench_encoder";
        }, false));
        MODEL_REGISTRY.register(MODEL_REGISTRY.register("pattern_transformation_assembler_encoder", MCTechTiles.PATTERN_TRANSFORMATION_ASSEMBLER_ENCODER, j -> {
            return "pattern_transformation_assembler_encoder";
        }, item6 -> {
            return "pattern_transformation_assembler_encoder";
        }, false));
        MODEL_REGISTRY.register(MODEL_REGISTRY.register("thermonuclear_reactor", MCTechTiles.THERMONUCLEAR_REACTOR, vVar -> {
            return "thermonuclear_reactor";
        }, item7 -> {
            return "thermonuclear_reactor";
        }, false));
        MODEL_REGISTRY.register(new GeneratedModel(MCTechTiles.GLASS_FURNACE).block(c0074u -> {
            return "glass_furnace";
        }, c0074u2 -> {
            return c0074u2.isActive() ? "glass_furnace_working" : "glass_furnace";
        }, c0074u3 -> {
            return "glass_furnace";
        }).item().requireRotation(true).overrideItemSubtype("block").blockLayers(new Function[]{(v1) -> {
            return new j(v1);
        }}).itemLayers(new Function[]{(v1) -> {
            return new j(v1);
        }}).blockLayers(new Function[]{geoBlockRenderer7 -> {
            return new k(geoBlockRenderer7).a(c0074u4 -> {
                return new k.a(new e(-21.5f, 21.0f, 9.5f), new e(9.0f, 20.0f, 8.0f), c0074u4.p.getFluid().getFluid(), new k.b(c0074u4.p.getFluidAmount(), c0074u4.p.getCapacity(), 0.0f, false, false, new e(0.0f, 0.0f, 0.0f), true));
            });
        }}));
        MODEL_REGISTRY.register(new GeneratedModel(MCTechTiles.GENETIC_SEQUENTOR).block(c0072s -> {
            return "genetic_sequentor";
        }, c0072s2 -> {
            return c0072s2.isActive() ? "genetic_sequentor_working" : "genetic_sequentor";
        }, c0072s3 -> {
            return "genetic_sequentor";
        }).item().requireRotation(true).overrideItemSubtype("block").blockLayers(new Function[]{(v1) -> {
            return new j(v1);
        }}).itemLayers(new Function[]{(v1) -> {
            return new j(v1);
        }}));
        MODEL_REGISTRY.register(new GeneratedModel(MCTechTiles.GENETIC_STABILIZER).block(c0073t -> {
            return "genetic_stabilizer";
        }, c0073t2 -> {
            return "genetic_stabilizer";
        }, c0073t3 -> {
            return "genetic_stabilizer";
        }).item().requireRotation(true).overrideItemSubtype("block").blockLayers(new Function[]{(v1) -> {
            return new j(v1);
        }}).itemLayers(new Function[]{(v1) -> {
            return new j(v1);
        }}).blockLayers(new Function[]{geoBlockRenderer8 -> {
            return new k(geoBlockRenderer8).a(c0073t4 -> {
                return new k.a(new e(-7.35f, 5.0f, -7.35f), new e(7.7f, 10.4f, 7.6f), c0073t4.i.getFluid().getFluid(), new k.b(c0073t4.i.getFluidAmount(), c0073t4.i.getCapacity(), 0.0f, false, false, new e(0.0f, 0.0f, 0.0f), true));
            });
        }}));
        MODEL_REGISTRY.register(new GeneratedModel(MCTechTiles.EXPERIENCE_EXTRACTOR).block(c0068o -> {
            return "experience_extractor";
        }, c0068o2 -> {
            return "experience_extractor";
        }, c0068o3 -> {
            return "experience_extractor";
        }).item().requireRotation(true).overrideItemSubtype("block").blockLayers(new Function[]{(v1) -> {
            return new j(v1);
        }}).itemLayers(new Function[]{(v1) -> {
            return new j(v1);
        }}).blockLayers(new Function[]{geoBlockRenderer9 -> {
            return new k(geoBlockRenderer9).a(c0068o4 -> {
                return new k.a(new e(-3.9f, 3.0f, -5.9f), new e(7.8f, 10.0f, 6.4f), c0068o4.e.getFluid().getFluid(), new k.b(c0068o4.e.getFluidAmount(), c0068o4.e.getCapacity(), 0.0f, false, false, new e(0.0f, 0.0f, 0.0f), true));
            });
        }}));
        MODEL_REGISTRY.register(new GeneratedModel(MCTechTiles.SYNTHETIC_PRINTER).block(adVar -> {
            return "synthetic_printer";
        }, adVar2 -> {
            return "synthetic_printer";
        }, adVar3 -> {
            return "synthetic_printer";
        }).item().requireRotation(true).overrideItemSubtype("block").blockLayers(new Function[]{(v1) -> {
            return new j(v1);
        }}).blockLayers(new Function[]{(v1) -> {
            return new A(v1);
        }}).itemLayers(new Function[]{(v1) -> {
            return new j(v1);
        }}));
        MODEL_REGISTRY.register(new GeneratedModel(MCTechTiles.QUANTUM_GENERATOR).block(eVar -> {
            return i.QUANTUM_GENERATOR.getSerializedName();
        }, eVar2 -> {
            return i.QUANTUM_GENERATOR.getSerializedName();
        }, eVar3 -> {
            return i.QUANTUM_GENERATOR.getSerializedName();
        }).item().requireRotation(true).overrideItemSubtype("block"));
        MODEL_REGISTRY.register(new GeneratedModel(MCTechTiles.TRANSFORMATION_ASSEMBLER).block(aeVar -> {
            return i.TRANSFORMATION_ASSEMBLER.getSerializedName();
        }, aeVar2 -> {
            return i.TRANSFORMATION_ASSEMBLER.getSerializedName();
        }, aeVar3 -> {
            return i.TRANSFORMATION_ASSEMBLER.getSerializedName();
        }).item().requireRotation(true).overrideItemSubtype("block"));
        MODEL_REGISTRY.register(new GeneratedModel(MCTechTiles.FARMING_STATION).block(bVar4 -> {
            return "farming_station";
        }, bVar5 -> {
            return "farming_station";
        }, bVar6 -> {
            return "farming_station";
        }).item().requireRotation(true).overrideItemSubtype("block"));
        MODEL_REGISTRY.register(new GeneratedModel(MCTechTiles.FARMING_STATION_CULTIVATOR).block(aVar -> {
            return "farming_station_cultivator";
        }, aVar2 -> {
            return "farming_station_cultivator";
        }, aVar3 -> {
            return "farming_station_cultivator";
        }).item().requireRotation(true).overrideItemSubtype("block"));
    }

    /* JADX INFO: renamed from: mctech.init.MCTechModels$1, reason: invalid class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/init/MCTechModels$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$net$minecraft$world$item$ItemDisplayContext = new int[ItemDisplayContext.values().length];

        static {
            try {
                $SwitchMap$net$minecraft$world$item$ItemDisplayContext[ItemDisplayContext.FIRST_PERSON_LEFT_HAND.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$net$minecraft$world$item$ItemDisplayContext[ItemDisplayContext.FIRST_PERSON_RIGHT_HAND.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$net$minecraft$world$item$ItemDisplayContext[ItemDisplayContext.THIRD_PERSON_LEFT_HAND.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$net$minecraft$world$item$ItemDisplayContext[ItemDisplayContext.THIRD_PERSON_RIGHT_HAND.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public static void init(IEventBus iEventBus) {
        MODEL_REGISTRY.register(iEventBus);
    }

    public static <B extends Block> void createWirelessConnector(BlockStateProvider blockStateProvider, DataGenContext<Block, B> dataGenContext, MachineTier machineTier) {
        MultiPartBlockStateBuilder multipartBuilder = blockStateProvider.getMultipartBuilder((Block) dataGenContext.get());
        ((MultiPartBlockStateBuilder.PartBuilder) multipartBuilder.part().modelFile(blockStateProvider.models().getBuilder("wireless_connect_off_t" + machineTier.asIntegerString()).parent(blockStateProvider.models().getExistingFile(blockStateProvider.mcLoc("block/cube_all"))).texture("all", MCTech.loc(String.format("block/wireless_connect/t%s/wireless_connect_off_t%s", machineTier.asIntegerString(), machineTier.asIntegerString())))).addModel()).condition(a.a, new Boolean[]{false});
        AEColor[] aEColorArrValues = AEColor.values();
        int length = aEColorArrValues.length;
        for (int i = 0; i < length; i++) {
            AEColor aEColor = aEColorArrValues[i];
            String lowerCase = aEColor == AEColor.TRANSPARENT ? "fluix" : aEColor.name().toLowerCase(Locale.ROOT);
            ((MultiPartBlockStateBuilder.PartBuilder) multipartBuilder.part().modelFile(blockStateProvider.models().getBuilder("wireless_connect_" + lowerCase + "_t" + machineTier.asIntegerString()).parent(blockStateProvider.models().getExistingFile(blockStateProvider.mcLoc("block/cube_all"))).texture("all", MCTech.loc(String.format("block/wireless_connect/t%s/wireless_connect_%s_t%s", machineTier.asIntegerString(), lowerCase, machineTier.asIntegerString())))).addModel()).condition(a.a, new Boolean[]{true}).condition(a.b, new Integer[]{Integer.valueOf(aEColor.ordinal())});
        }
    }

    public static <B extends Block> void createAllSidedActiveInactive(BlockStateProvider blockStateProvider, DataGenContext<Block, B> dataGenContext, String str) {
        blockStateProvider.getVariantBuilder((Block) dataGenContext.get()).forAllStatesExcept(blockState -> {
            String str2 = ((Boolean) blockState.getValue(MCTechProperties.ACTIVE)).booleanValue() ? "active" : "inactive";
            return ConfiguredModel.builder().modelFile(blockStateProvider.models().cube(String.format("%s_%s", str2, dataGenContext.getId().getPath()), ResourceLocation.fromNamespaceAndPath(MCTech.MODID, String.format("block/%s/%s_%s", str, str2, Direction.DOWN.getName())), ResourceLocation.fromNamespaceAndPath(MCTech.MODID, String.format("block/%s/%s_%s", str, str2, Direction.UP.getName())), ResourceLocation.fromNamespaceAndPath(MCTech.MODID, String.format("block/%s/%s_%s", str, str2, Direction.NORTH.getName())), ResourceLocation.fromNamespaceAndPath(MCTech.MODID, String.format("block/%s/%s_%s", str, str2, Direction.SOUTH.getName())), ResourceLocation.fromNamespaceAndPath(MCTech.MODID, String.format("block/%s/%s_%s", str, str2, Direction.EAST.getName())), ResourceLocation.fromNamespaceAndPath(MCTech.MODID, String.format("block/%s/%s_%s", str, str2, Direction.WEST.getName()))).texture("particle", ResourceLocation.fromNamespaceAndPath(MCTech.MODID, String.format("block/%s/%s_%s", str, str2, Direction.NORTH.getName())))).rotationY(((int) blockState.getValue(MCTechProperties.ALL_FACINGS).toYRot()) % 360).build();
        }, new Property[]{MachineTier.PROPERTY});
    }

    public static <I extends Item> ItemModelBuilder createBlockItem(LItemModelProvider lItemModelProvider, DataGenContext<Item, I> dataGenContext, String str) {
        ResourceLocation key = BuiltInRegistries.ITEM.getKey((Item) dataGenContext.get());
        if (str.isEmpty()) {
            str = key.getPath();
        }
        return lItemModelProvider.withExistingParent(key.toString(), lItemModelProvider.modLoc(String.format("block/%s", str)));
    }
}
