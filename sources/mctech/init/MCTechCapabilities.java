package mctech.init;

import appeng.api.AECapabilities;
import java.util.Iterator;
import java.util.List;
import mctech.MCTech;
import mctech.api.energy.tile.IEnergySink;
import mctech.api.energy.tile.IEnergySource;
import mctech.api.tiles.IFluidMachine;
import mctech.api.tiles.readers.IEUStorage;
import mctech.blockentities.b.c;
import mctech.blockentities.b.l;
import mctech.blockentities.c.C0055b;
import mctech.blockentities.c.C0074u;
import mctech.blockentities.c.S;
import mctech.blockentities.i;
import mctech.blockentities.n;
import mctech.blocks.b.j;
import mctech.r.a.b;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.capabilities.BlockCapability;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.ICapabilityProvider;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/init/MCTechCapabilities.class */
public class MCTechCapabilities {

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/init/MCTechCapabilities$Capability.class */
    private interface Capability<Cap, Context, BE extends BlockEntity> {
        Cap provide(BE be, Context context);
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/init/MCTechCapabilities$Energy.class */
    public static class Energy {
        public static final BlockCapability<IEnergySink, Direction> ENERGY_SINK = BlockCapability.createSided(MCTech.loc("energy_sink"), IEnergySink.class);
        public static final BlockCapability<IEnergySource, Direction> ENERGY_SOURCE = BlockCapability.createSided(MCTech.loc("energy_source"), IEnergySource.class);
        public static final BlockCapability<IEUStorage, Direction> ENERGY_STORAGE = BlockCapability.createSided(MCTech.loc("energy_storage"), IEUStorage.class);
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/init/MCTechCapabilities$MultiblockCapability.class */
    private interface MultiblockCapability<Cap, Context, BE extends BlockEntity> {
        Cap provide(BE be, Context context);
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/init/MCTechCapabilities$MultiblockChecker.class */
    @FunctionalInterface
    private interface MultiblockChecker {
        boolean test(BlockPos blockPos, BlockPos blockPos2, Direction direction);
    }

    public static void registerCapabilities(RegisterCapabilitiesEvent registerCapabilitiesEvent) {
        registerCapabilitiesEvent.setProxyable(Energy.ENERGY_SINK);
        registerCapabilitiesEvent.setProxyable(Energy.ENERGY_SOURCE);
        registerCapabilitiesEvent.setProxyable(Energy.ENERGY_STORAGE);
        registerCapabilitiesEvent.registerBlockEntity(AECapabilities.IN_WORLD_GRID_NODE_HOST, (BlockEntityType) MCTechTiles.WIRELESS_CONNECTOR_64K.get(), (aVar, r3) -> {
            return aVar;
        });
        registerCapabilitiesEvent.registerBlockEntity(AECapabilities.IN_WORLD_GRID_NODE_HOST, (BlockEntityType) MCTechTiles.WIRELESS_CONNECTOR_128K.get(), (aVar2, r4) -> {
            return aVar2;
        });
        registerCapabilitiesEvent.registerBlockEntity(AECapabilities.IN_WORLD_GRID_NODE_HOST, (BlockEntityType) MCTechTiles.WIRELESS_CONNECTOR_256K.get(), (aVar3, r5) -> {
            return aVar3;
        });
        registerCapabilitiesEvent.registerBlockEntity(AECapabilities.IN_WORLD_GRID_NODE_HOST, (BlockEntityType) MCTechTiles.TRANSFORMATION_ASSEMBLER.get(), (aeVar, r6) -> {
            return aeVar;
        });
        Iterator it = MCTechTiles.getInstanceOf(i.class).iterator();
        while (it.hasNext()) {
            registerCapabilitiesEvent.registerBlockEntity(Capabilities.ItemHandler.BLOCK, (BlockEntityType) it.next(), (v0, v1) -> {
                return v0.getItemHandler(v1);
            });
        }
        Iterator it2 = MCTechTiles.getInstanceOf(n.class).iterator();
        while (it2.hasNext()) {
            registerCapabilitiesEvent.registerBlockEntity(Capabilities.ItemHandler.BLOCK, (BlockEntityType) it2.next(), (v0, v1) -> {
                return v0.a(v1);
            });
        }
        register(registerCapabilitiesEvent, Capabilities.FluidHandler.BLOCK, S.class, (v0, v1) -> {
            return v0.getConnectedTank(v1);
        });
        register(registerCapabilitiesEvent, Capabilities.FluidHandler.BLOCK, c.class, (v0, v1) -> {
            return v0.getConnectedTank(v1);
        });
        MCTechTiles.CLASS_TO_TYPE.keySet().stream().filter(cls -> {
            return IFluidMachine.class.isAssignableFrom(cls);
        }).map(MCTechTiles::getBlockEntity).forEach(blockEntityType -> {
            registerCapability(registerCapabilitiesEvent, Capabilities.FluidHandler.BLOCK, blockEntityType, (blockEntity, direction) -> {
                if (blockEntity instanceof IFluidMachine) {
                    return ((IFluidMachine) blockEntity).getConnectedTank(direction);
                }
                return null;
            });
        });
        registerCapability(registerCapabilitiesEvent, Capabilities.ItemHandler.BLOCK, MCTechTiles.STONE_COMPRESSOR.get(), (v0, v1) -> {
            return v0.getItemHandler(v1);
        });
        registerCapability(registerCapabilitiesEvent, Capabilities.ItemHandler.BLOCK, MCTechTiles.ADVANCED_RECYCLER.get(), (v0, v1) -> {
            return v0.getItemHandler(v1);
        });
        registerCapability(registerCapabilitiesEvent, Capabilities.ItemHandler.BLOCK, MCTechTiles.STONE_EXTRACTOR.get(), (v0, v1) -> {
            return v0.getItemHandler(v1);
        });
        registerCapability(registerCapabilitiesEvent, Capabilities.FluidHandler.BLOCK, (BlockEntityType) MCTechTiles.ADVANCED_REFINERY.get(), (v0, v1) -> {
            return v0.getConnectedTank(v1);
        });
        registerCapability(registerCapabilitiesEvent, Capabilities.ItemHandler.BLOCK, (BlockEntityType) MCTechTiles.ADVANCED_REFINERY.get(), (v0, v1) -> {
            return v0.getItemHandler(v1);
        });
        registerCapability(registerCapabilitiesEvent, Capabilities.ItemHandler.BLOCK, MCTechTiles.CRYSTAL_GROWTH_CHAMBER.get(), (v0, v1) -> {
            return v0.getItemHandler(v1);
        });
        for (DeferredHolder<BlockEntityType<?>, BlockEntityType<C0055b>> deferredHolder : b.a.values()) {
            registerCapability(registerCapabilitiesEvent, Capabilities.FluidHandler.BLOCK, (BlockEntityType) deferredHolder.get(), (v0, v1) -> {
                return v0.getConnectedTank(v1);
            });
            registerCapability(registerCapabilitiesEvent, Capabilities.ItemHandler.BLOCK, (BlockEntityType) deferredHolder.get(), (v0, v1) -> {
                return v0.getItemHandler(v1);
            });
        }
        registerCapabilitiesEvent.registerBlock(Capabilities.ItemHandler.BLOCK, (level, blockPos, blockState, blockEntity, direction) -> {
            j block = blockState.getBlock();
            if (block instanceof j) {
                j jVar = block;
                Direction value = blockState.getValue(j.b);
                BlockPos blockPosA = jVar.a((BlockGetter) level, blockPos);
                if (blockPosA == null) {
                    return null;
                }
                BlockEntity blockEntity = level.getBlockEntity(blockPosA);
                if (blockEntity instanceof l) {
                    l lVar = (l) blockEntity;
                    if (blockPosA.relative(value.getOpposite()).relative(value.getCounterClockWise()).equals(blockPos)) {
                        return lVar.getItemHandler(direction);
                    }
                    return null;
                }
                return null;
            }
            return null;
        }, new Block[]{(Block) MCTechBlocks.WINDMILL.get()});
        registerCapabilitiesEvent.registerBlock(Energy.ENERGY_SOURCE, (level2, blockPos2, blockState2, blockEntity2, direction2) -> {
            j block = blockState2.getBlock();
            if (block instanceof j) {
                j jVar = block;
                Direction value = blockState2.getValue(j.b);
                BlockPos blockPosA = jVar.a((BlockGetter) level2, blockPos2);
                if (blockPosA == null) {
                    return null;
                }
                BlockEntity blockEntity2 = level2.getBlockEntity(blockPosA);
                if (blockEntity2 instanceof l) {
                    l lVar = (l) blockEntity2;
                    if (blockPosA.relative(value.getOpposite()).relative(value.getClockWise()).equals(blockPos2)) {
                        return lVar;
                    }
                    return null;
                }
                return null;
            }
            return null;
        }, new Block[]{(Block) MCTechBlocks.WINDMILL.get()});
        registerCapabilitiesEvent.registerBlock(Energy.ENERGY_STORAGE, (level3, blockPos3, blockState3, blockEntity3, direction3) -> {
            j block = blockState3.getBlock();
            if (block instanceof j) {
                j jVar = block;
                Direction value = blockState3.getValue(j.b);
                BlockPos blockPosA = jVar.a((BlockGetter) level3, blockPos3);
                if (blockPosA == null) {
                    return null;
                }
                BlockEntity blockEntity3 = level3.getBlockEntity(blockPosA);
                if (blockEntity3 instanceof l) {
                    l lVar = (l) blockEntity3;
                    if (blockPosA.relative(value.getOpposite()).relative(value.getClockWise()).equals(blockPos3)) {
                        return lVar;
                    }
                    return null;
                }
                return null;
            }
            return null;
        }, new Block[]{(Block) MCTechBlocks.WINDMILL.get()});
        delegateMultiblock(registerCapabilitiesEvent, (blockEntity4, obj) -> {
            if (!(blockEntity4 instanceof C0074u)) {
                return null;
            }
            C0074u c0074u = (C0074u) blockEntity4;
            if (obj instanceof Direction) {
                if (c0074u.getFacing() == ((Direction) obj)) {
                    return c0074u;
                }
                return null;
            }
            return null;
        }, (blockPos4, blockPos5, direction4) -> {
            return blockPos4.relative(direction4).equals(blockPos5) || blockPos4.relative(direction4).relative(direction4.getCounterClockWise()).equals(blockPos5) || blockPos4.relative(direction4).relative(Direction.UP).equals(blockPos5);
        }, List.of((Block) MCTechBlocks.GLASS_FURNACE.get()), Energy.ENERGY_STORAGE, Energy.ENERGY_SINK);
        delegateMultiblock(registerCapabilitiesEvent, (blockEntity5, obj2) -> {
            Direction direction5;
            if (blockEntity5 instanceof C0074u) {
                C0074u c0074u = (C0074u) blockEntity5;
                if ((obj2 instanceof Direction) && c0074u.getFacing() == (direction5 = (Direction) obj2)) {
                    return c0074u.getConnectedTank(direction5);
                }
                return null;
            }
            return null;
        }, (blockPos6, blockPos7, direction5) -> {
            return blockPos6.relative(direction5).equals(blockPos7) || blockPos6.relative(direction5).relative(direction5.getCounterClockWise()).equals(blockPos7) || blockPos6.relative(direction5).relative(Direction.UP).equals(blockPos7);
        }, List.of((Block) MCTechBlocks.GLASS_FURNACE.get()), Capabilities.FluidHandler.BLOCK);
        delegateMultiblock(registerCapabilitiesEvent, (blockEntity6, obj3) -> {
            Direction direction6;
            if (blockEntity6 instanceof C0074u) {
                C0074u c0074u = (C0074u) blockEntity6;
                if ((obj3 instanceof Direction) && c0074u.getFacing() == (direction6 = (Direction) obj3)) {
                    return c0074u.getItemHandler(direction6);
                }
                return null;
            }
            return null;
        }, (blockPos8, blockPos9, direction6) -> {
            return blockPos8.relative(direction6).equals(blockPos9) || blockPos8.relative(direction6).relative(direction6.getCounterClockWise()).equals(blockPos9) || blockPos8.relative(direction6).relative(Direction.UP).equals(blockPos9);
        }, List.of((Block) MCTechBlocks.GLASS_FURNACE.get()), Capabilities.ItemHandler.BLOCK);
    }

    private static void delegateMultiblock(RegisterCapabilitiesEvent registerCapabilitiesEvent, MultiblockCapability multiblockCapability, MultiblockChecker multiblockChecker, List<Block> list, BlockCapability<?, ?>... blockCapabilityArr) {
        for (BlockCapability<?, ?> blockCapability : blockCapabilityArr) {
            registerCapabilitiesEvent.registerBlock(blockCapability, (level, blockPos, blockState, blockEntity, obj) -> {
                BlockEntity blockEntity;
                mctech.p.b.c block = blockState.getBlock();
                if (!(block instanceof mctech.p.b.c)) {
                    return null;
                }
                mctech.p.b.c cVar = block;
                if (blockEntity == null) {
                    return null;
                }
                Direction direction = (Direction) blockState.getValue(mctech.p.b.c.b);
                BlockPos blockPosA = cVar.a((BlockGetter) level, blockPos);
                if (blockPosA != null && (blockEntity = level.getBlockEntity(blockPosA)) != null && multiblockChecker.test(blockPosA, blockPos, direction)) {
                    return multiblockCapability.provide(blockEntity, obj);
                }
                return null;
            }, (Block[]) list.toArray(new Block[0]));
        }
    }

    private static <T, C, BE extends BlockEntity> void register(RegisterCapabilitiesEvent registerCapabilitiesEvent, BlockCapability<T, C> blockCapability, Class<BE> cls, ICapabilityProvider<? super BE, C, T> iCapabilityProvider) {
        Iterator it = MCTechTiles.getInstanceOf(cls).iterator();
        while (it.hasNext()) {
            registerCapabilitiesEvent.registerBlockEntity(blockCapability, (BlockEntityType) it.next(), iCapabilityProvider);
        }
    }

    private static <T, C, BE extends BlockEntity> void registerCapability(RegisterCapabilitiesEvent registerCapabilitiesEvent, BlockCapability<T, C> blockCapability, Class<BE> cls, Capability<T, C, BE> capability) {
        registerCapability(registerCapabilitiesEvent, blockCapability, MCTechTiles.getBlockEntity(cls), capability);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T, C, BE extends BlockEntity> void registerCapability(RegisterCapabilitiesEvent registerCapabilitiesEvent, BlockCapability<T, C> blockCapability, BlockEntityType<BE> blockEntityType, final Capability<T, C, BE> capability) {
        registerCapabilitiesEvent.registerBlockEntity(blockCapability, blockEntityType, new ICapabilityProvider<BE, C, T>() { // from class: mctech.init.MCTechCapabilities.1
            /* JADX WARN: Incorrect types in method signature: (TBE;TC;)TT; */
            @Nullable
            public Object getCapability(@NotNull BlockEntity blockEntity, Object obj) {
                return capability.provide(blockEntity, obj);
            }
        });
    }
}
