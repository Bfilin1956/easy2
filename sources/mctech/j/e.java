package mctech.j;

import appeng.init.client.InitScreens;
import mctech.MCTech;
import mctech.blockentities.c.C0075v;
import mctech.blockentities.g.i;
import mctech.blockentities.g.j;
import mctech.blockentities.g.k;
import mctech.blockentities.g.l;
import mctech.blockentities.g.m;
import mctech.init.MCTechBlocks;
import mctech.init.MCTechItems;
import mctech.init.MCTechTiles;
import mctech.v.C0210d;
import mctech.v.C0211e;
import mctech.v.D;
import mctech.v.t;
import mctech.v.w;
import net.mcskill.msregistry.registry.holder.LBlock;
import net.minecraft.client.particle.ParticleEngine;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.HitResult;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.neoforged.neoforge.client.event.RegisterItemDecorationsEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.client.extensions.common.IClientBlockExtensions;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/j/e.class */
@EventBusSubscriber
public class e {
    @SubscribeEvent
    public static void a(EntityRenderersEvent.AddLayers addLayers) {
    }

    @SubscribeEvent
    public static void a(EntityRenderersEvent.RegisterRenderers registerRenderers) {
        a(registerRenderers, m.class);
        a(registerRenderers, mctech.blockentities.g.h.class);
        a(registerRenderers, l.class);
        a(registerRenderers, k.class);
        a(registerRenderers, mctech.blockentities.g.f.class);
        a(registerRenderers, mctech.blockentities.g.e.class);
        a(registerRenderers, j.class);
        a(registerRenderers, i.class);
        a(registerRenderers, mctech.blockentities.g.d.class);
        a(registerRenderers, mctech.blockentities.g.g.class);
        a(registerRenderers, mctech.blockentities.g.a.class);
        a(registerRenderers, mctech.blockentities.g.c.class);
        a(registerRenderers, mctech.blockentities.d.e.class);
        a(registerRenderers, mctech.blockentities.d.j.class);
        a(registerRenderers, mctech.blockentities.d.i.class);
        a(registerRenderers, mctech.blockentities.d.c.class);
        a(registerRenderers, mctech.blockentities.d.b.class);
        a(registerRenderers, mctech.blockentities.d.g.class);
        a(registerRenderers, mctech.blockentities.d.f.class);
        a(registerRenderers, mctech.blockentities.d.a.class);
        a(registerRenderers, mctech.blockentities.d.d.class);
        a(registerRenderers, mctech.blockentities.d.h.class);
        a(registerRenderers, mctech.blockentities.a.e.class);
        a(registerRenderers, mctech.blockentities.a.j.class);
        a(registerRenderers, mctech.blockentities.a.i.class);
        a(registerRenderers, mctech.blockentities.a.c.class);
        a(registerRenderers, mctech.blockentities.a.b.class);
        a(registerRenderers, mctech.blockentities.a.g.class);
        a(registerRenderers, mctech.blockentities.a.f.class);
        a(registerRenderers, mctech.blockentities.a.a.class);
        a(registerRenderers, mctech.blockentities.a.d.class);
        a(registerRenderers, mctech.blockentities.a.h.class);
        a(registerRenderers, C0075v.class);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) MCTechTiles.MOLECULAR_CONVERTER.get(), t::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) MCTechTiles.QUANTUM_WORKBENCH.get(), w::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) MCTechTiles.WINDMILL_GENERATOR.get(), D::new);
    }

    private static <T extends BlockEntity & mctech.v.f.b> void a(EntityRenderersEvent.RegisterRenderers registerRenderers, Class<T> cls) {
        registerRenderers.registerBlockEntityRenderer(MCTechTiles.getBlockEntity(cls), C0211e::new);
    }

    @SubscribeEvent
    public static void a(RegisterItemDecorationsEvent registerItemDecorationsEvent) {
        registerItemDecorationsEvent.register((ItemLike) MCTechItems.GENETIC_MATERIAL.get(), mctech.v.d.e.a);
        registerItemDecorationsEvent.register((ItemLike) MCTechItems.DNA_SAMPLE.get(), mctech.v.d.e.a);
    }

    @SubscribeEvent
    public static void a(RegisterClientExtensionsEvent registerClientExtensionsEvent) {
        registerClientExtensionsEvent.registerBlock(new IClientBlockExtensions() { // from class: mctech.j.e.1
            public boolean addDestroyEffects(BlockState blockState, Level level, BlockPos blockPos, ParticleEngine particleEngine) {
                return true;
            }

            public boolean addHitEffects(BlockState blockState, Level level, HitResult hitResult, ParticleEngine particleEngine) {
                return true;
            }
        }, new Holder[]{MCTechBlocks.TRANSFORMER_0, MCTechBlocks.TRANSFORMER_1, MCTechBlocks.TRANSFORMER_2, MCTechBlocks.TRANSFORMER_3, MCTechBlocks.TRANSFORMER_4, MCTechBlocks.TRANSFORMER_5, MCTechBlocks.TRANSFORMER_6, MCTechBlocks.TRANSFORMER_7, MCTechBlocks.TRANSFORMER_8, MCTechBlocks.TRANSFORMER_9, MCTechBlocks.TRANSFORMER_ADJUSTABLE_1, MCTechBlocks.TRANSFORMER_ADJUSTABLE_2, MCTechBlocks.CHARGING_BENCH_1, MCTechBlocks.CHARGING_BENCH_2, MCTechBlocks.CHARGING_BENCH_3, MCTechBlocks.CHARGING_BENCH_4, MCTechBlocks.CHARGING_BENCH_5, MCTechBlocks.CHARGING_BENCH_6, MCTechBlocks.CHARGING_BENCH_7, MCTechBlocks.CHARGING_BENCH_8, MCTechBlocks.CHARGING_BENCH_9, MCTechBlocks.CHARGING_BENCH_10, MCTechBlocks.GREENHOUSE});
        registerClientExtensionsEvent.registerBlock(new IClientBlockExtensions() { // from class: mctech.j.e.2
            public boolean addDestroyEffects(BlockState blockState, Level level, BlockPos blockPos, ParticleEngine particleEngine) {
                return true;
            }

            public boolean addHitEffects(BlockState blockState, Level level, HitResult hitResult, ParticleEngine particleEngine) {
                return true;
            }
        }, (Holder[]) MCTechBlocks.REGISTERED_CHARGE_PADS.values().toArray(new LBlock[0]));
        registerClientExtensionsEvent.registerItem(new IClientItemExtensions() { // from class: mctech.j.e.3
            private mctech.v.f a;

            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                if (this.a == null) {
                    this.a = new mctech.v.f();
                }
                return this.a;
            }
        }, new Item[]{MCTechBlocks.TRANSFORMER_0.asItem(), MCTechBlocks.TRANSFORMER_1.asItem(), MCTechBlocks.TRANSFORMER_2.asItem(), MCTechBlocks.TRANSFORMER_3.asItem(), MCTechBlocks.TRANSFORMER_4.asItem(), MCTechBlocks.TRANSFORMER_5.asItem(), MCTechBlocks.TRANSFORMER_6.asItem(), MCTechBlocks.TRANSFORMER_7.asItem(), MCTechBlocks.TRANSFORMER_8.asItem(), MCTechBlocks.TRANSFORMER_9.asItem(), MCTechBlocks.TRANSFORMER_ADJUSTABLE_1.asItem(), MCTechBlocks.TRANSFORMER_ADJUSTABLE_2.asItem(), MCTechBlocks.CHARGING_BENCH_1.asItem(), MCTechBlocks.CHARGING_BENCH_2.asItem(), MCTechBlocks.CHARGING_BENCH_3.asItem(), MCTechBlocks.CHARGING_BENCH_4.asItem(), MCTechBlocks.CHARGING_BENCH_5.asItem(), MCTechBlocks.CHARGING_BENCH_6.asItem(), MCTechBlocks.CHARGING_BENCH_7.asItem(), MCTechBlocks.CHARGING_BENCH_8.asItem(), MCTechBlocks.CHARGING_BENCH_9.asItem(), MCTechBlocks.CHARGING_BENCH_10.asItem(), MCTechBlocks.GREENHOUSE.asItem()});
        registerClientExtensionsEvent.registerItem(new IClientItemExtensions() { // from class: mctech.j.e.4
            private mctech.v.f a;

            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                if (this.a == null) {
                    this.a = new mctech.v.f();
                }
                return this.a;
            }
        }, (Item[]) MCTechBlocks.REGISTERED_CHARGE_PADS.values().stream().map((v0) -> {
            return v0.asItem();
        }).toList().toArray(new Item[0]));
        registerClientExtensionsEvent.registerItem(new IClientItemExtensions() { // from class: mctech.j.e.5
            private C0210d<?> a;

            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                if (this.a == null) {
                    this.a = new C0210d<>(mctech.v.a.a.EnumC0045a.ENERGYPACK);
                }
                return this.a;
            }
        }, new Holder[]{MCTechItems.ENERGY_LAPPACK, MCTechItems.ADVANCED_ENERGY_LAPPACK, MCTechItems.COMPOSITE_ENERGY_LAPPACK, MCTechItems.NANO_ENERGY_LAPPACK, MCTechItems.QUANTUM_ENERGY_LAPPACK, MCTechItems.SINGULARITY_ENERGY_LAPPACK, MCTechItems.RUBIDIUM_ENERGY_LAPPACK});
        registerClientExtensionsEvent.registerItem(new IClientItemExtensions() { // from class: mctech.j.e.6
            private C0210d<?> a;

            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                if (this.a == null) {
                    this.a = new C0210d<>(mctech.v.a.a.EnumC0045a.JETPACK);
                }
                return this.a;
            }
        }, new Holder[]{MCTechItems.JETPACK, MCTechItems.ADVANCED_JETPACK, MCTechItems.GRAVITATION_JETPACK, MCTechItems.ROCKET_GRAVITATION_JETPACK, MCTechItems.DEBUG_JETPACK});
    }

    @SubscribeEvent
    public static void a(RegisterMenuScreensEvent registerMenuScreensEvent) {
        InitScreens.register(registerMenuScreensEvent, mctech.a.a.e.a.a, mctech.a.a.d.a::new, "/screens/wireless_connector_ex.json");
    }

    @SubscribeEvent
    public static void a(RegisterColorHandlersEvent.Block block) {
        block.register((blockState, blockAndTintGetter, blockPos, i) -> {
            return 8431445;
        }, new Block[]{(Block) MCTechBlocks.RUBBER_LEAVES.get()});
    }

    @SubscribeEvent
    public static void a(RegisterColorHandlersEvent.Item item) {
        item.register((itemStack, i) -> {
            return 8431445;
        }, new ItemLike[]{(ItemLike) MCTechBlocks.RUBBER_LEAVES.get()});
    }

    public static void a(Item item) {
        ItemProperties.register(item, ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "state"), (itemStack, clientLevel, livingEntity, i) -> {
            return ((mctech.items.misc.a) itemStack.getItem()).a(itemStack, livingEntity);
        });
    }
}
