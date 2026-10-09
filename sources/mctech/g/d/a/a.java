package mctech.g.d.a;

import appeng.api.ids.AEItemIds;
import mctech.MCTech;
import mctech.g.a.l;
import mctech.g.a.m;
import mctech.g.d.c.i;
import mctech.g.d.c.j;
import mctech.g.d.c.k;
import mctech.g.d.c.o;
import mctech.g.d.c.p;
import mctech.init.MCTechBlocks;
import mctech.init.MCTechConduitTypes;
import mctech.init.MCTechItems;
import mctech.init.MCTechMenus;
import mctech.init.MCTechTiles;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.capabilities.BlockCapability;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.client.event.ModelEvent;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/a/a.class */
@EventBusSubscriber(modid = MCTech.MODID)
public class a {
    @SubscribeEvent
    public static void a(RegisterCapabilitiesEvent registerCapabilitiesEvent) {
        l.a.entrySet().stream().flatMap(entry -> {
            return ((m) entry.getValue()).b().stream();
        }).forEach(blockCapability -> {
            a(registerCapabilitiesEvent, blockCapability);
        });
        registerCapabilitiesEvent.registerItem(mctech.g.a.d.f, mctech.g.d.b.a.b, new ItemLike[]{MCTechItems.BASIC_ITEM_FILTER, MCTechItems.ADVANCED_ITEM_FILTER, MCTechItems.BIG_ITEM_FILTER, MCTechItems.BIG_ADVANCED_ITEM_FILTER, MCTechItems.BASIC_ITEM_FILTER, MCTechItems.BASIC_FLUID_FILTER, MCTechItems.LIMITED_ITEM_FILTER});
        registerCapabilitiesEvent.registerItem(mctech.g.a.d.b, mctech.g.d.a.b.b.b.a, new ItemLike[]{MCTechItems.BASIC_ITEM_FILTER, MCTechItems.ADVANCED_ITEM_FILTER, MCTechItems.BIG_ITEM_FILTER, MCTechItems.BIG_ADVANCED_ITEM_FILTER});
        registerCapabilitiesEvent.registerItem(mctech.g.a.d.b, mctech.g.d.a.b.b.a.b.a, new ItemLike[]{MCTechItems.LIMITED_ITEM_FILTER});
        registerCapabilitiesEvent.registerItem(mctech.g.a.d.c, mctech.g.d.a.b.a.b.a, new ItemLike[]{MCTechItems.BASIC_FLUID_FILTER});
        registerCapabilitiesEvent.registerItem(mctech.g.a.d.d, (itemStack, r3) -> {
            return i.a;
        }, new ItemLike[]{MCTechItems.NOT_FILTER});
        registerCapabilitiesEvent.registerItem(mctech.g.a.d.e, (itemStack2, r4) -> {
            return i.a;
        }, new ItemLike[]{MCTechItems.NOT_FILTER});
        registerCapabilitiesEvent.registerItem(mctech.g.a.d.d, (itemStack3, r5) -> {
            return new j(itemStack3);
        }, new ItemLike[]{MCTechItems.OR_FILTER});
        registerCapabilitiesEvent.registerItem(mctech.g.a.d.d, (itemStack4, r6) -> {
            return new mctech.g.d.c.b(itemStack4);
        }, new ItemLike[]{MCTechItems.AND_FILTER});
        registerCapabilitiesEvent.registerItem(mctech.g.a.d.d, (itemStack5, r7) -> {
            return new mctech.g.d.c.h(itemStack5);
        }, new ItemLike[]{MCTechItems.NOR_FILTER});
        registerCapabilitiesEvent.registerItem(mctech.g.a.d.d, (itemStack6, r8) -> {
            return new mctech.g.d.c.g(itemStack6);
        }, new ItemLike[]{MCTechItems.NAND_FILTER});
        registerCapabilitiesEvent.registerItem(mctech.g.a.d.d, (itemStack7, r9) -> {
            return new p(itemStack7);
        }, new ItemLike[]{MCTechItems.XOR_FILTER});
        registerCapabilitiesEvent.registerItem(mctech.g.a.d.d, (itemStack8, r10) -> {
            return new o(itemStack8);
        }, new ItemLike[]{MCTechItems.XNOR_FILTER});
        registerCapabilitiesEvent.registerItem(mctech.g.a.d.d, (itemStack9, r11) -> {
            return new mctech.g.d.c.l(itemStack9);
        }, new ItemLike[]{MCTechItems.TLATCH_FILTER});
        registerCapabilitiesEvent.registerItem(mctech.g.a.d.d, (itemStack10, r12) -> {
            return new mctech.g.d.c.c(itemStack10);
        }, new ItemLike[]{MCTechItems.COUNT_FILTER});
        registerCapabilitiesEvent.registerItem(mctech.g.a.d.e, (itemStack11, r13) -> {
            return k.a;
        }, new ItemLike[]{MCTechItems.SENSOR_FILTER});
        registerCapabilitiesEvent.registerItem(mctech.g.a.d.e, (itemStack12, r14) -> {
            return new mctech.g.d.c.m(itemStack12);
        }, new ItemLike[]{MCTechItems.TIMER_FILTER});
        registerCapabilitiesEvent.registerItem(mctech.g.a.d.a, mctech.g.d.a.d.f.a.a, new ItemLike[]{(ItemLike) BuiltInRegistries.ITEM.get(AEItemIds.FACADE)});
    }

    @SubscribeEvent
    public static void a(RegisterClientExtensionsEvent registerClientExtensionsEvent) {
        registerClientExtensionsEvent.registerBlock(mctech.g.c.b.a, new Holder[]{MCTechBlocks.CONDUIT});
    }

    @SubscribeEvent
    public static void a(mctech.g.a.g.b bVar) {
        bVar.a(MCTechConduitTypes.REDSTONE.get(), mctech.g.c.b.c.c::new);
        bVar.a(MCTechConduitTypes.FLUID.get(), mctech.g.c.b.c.b::new);
    }

    @SubscribeEvent
    public static void a(mctech.g.a.j.e eVar) {
        eVar.a(MCTechConduitTypes.ENERGY.get(), new mctech.g.c.a.b.b());
        eVar.a(MCTechConduitTypes.FLUID.get(), new mctech.g.c.a.b.c());
        eVar.a(MCTechConduitTypes.REDSTONE.get(), new mctech.g.c.a.b.e());
        eVar.a(MCTechConduitTypes.ITEM.get(), new mctech.g.c.a.b.d());
    }

    @SubscribeEvent
    public static void a(ModelEvent.RegisterGeometryLoaders registerGeometryLoaders) {
        registerGeometryLoaders.register(MCTech.loc("conduit"), new mctech.g.c.b.a.a.C0009a());
        registerGeometryLoaders.register(MCTech.loc("conduit_item"), new mctech.g.c.b.e());
        registerGeometryLoaders.register(MCTech.loc("facades_item"), new mctech.g.c.b.b.b.a());
    }

    @SubscribeEvent
    public static void a(RegisterColorHandlersEvent.Block block) {
        block.register(mctech.g.c.c.a, new Block[]{(Block) MCTechBlocks.CONDUIT.get()});
    }

    @SubscribeEvent
    public static void a(RegisterMenuScreensEvent registerMenuScreensEvent) {
        registerMenuScreensEvent.register((MenuType) MCTechMenus.CONDUIT_MENU.get(), mctech.g.c.a.d::new);
        registerMenuScreensEvent.register((MenuType) MCTechMenus.LIMITED_ITEM_FILTER.get(), mctech.g.c.a.c::new);
        registerMenuScreensEvent.register((MenuType) MCTechMenus.BASIC_ITEM_FILTER.get(), mctech.g.c.a.b::new);
        registerMenuScreensEvent.register((MenuType) MCTechMenus.ADVANCED_ITEM_FILTER.get(), mctech.g.c.a.b::new);
        registerMenuScreensEvent.register((MenuType) MCTechMenus.BIG_ITEM_FILTER.get(), mctech.g.c.a.b::new);
        registerMenuScreensEvent.register((MenuType) MCTechMenus.BIG_ADVANCED_ITEM_FILTER.get(), mctech.g.c.a.b::new);
        registerMenuScreensEvent.register((MenuType) MCTechMenus.BASIC_FLUID_FILTER.get(), mctech.g.c.a.a::new);
        registerMenuScreensEvent.register((MenuType) MCTechMenus.REDSTONE_DOUBLE_CHANNEL_FILTER.get(), mctech.g.c.a.a.b::new);
        registerMenuScreensEvent.register((MenuType) MCTechMenus.REDSTONE_TIMER_FILTER.get(), mctech.g.c.a.a.c::new);
        registerMenuScreensEvent.register((MenuType) MCTechMenus.REDSTONE_COUNT_FILTER.get(), mctech.g.c.a.a.a::new);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <TCap, TContext> void a(RegisterCapabilitiesEvent registerCapabilitiesEvent, BlockCapability<TCap, TContext> blockCapability) {
        registerCapabilitiesEvent.registerBlockEntity(blockCapability, (BlockEntityType) MCTechTiles.CONDUIT.get(), mctech.g.d.a.a.b.a(blockCapability));
    }
}
