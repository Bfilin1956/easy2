package mctech.init;

import java.util.function.Supplier;
import mctech.MCTech;
import mctech.n.a;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.storage.loot.functions.LootItemFunctionType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/init/MCTechLootTableFunctions.class */
public class MCTechLootTableFunctions {
    public static final DeferredRegister<LootItemFunctionType<?>> LOOT_FUNCTION_TYPES = DeferredRegister.create(Registries.LOOT_FUNCTION_TYPE, MCTech.MODID);
    public static final Supplier<LootItemFunctionType<a>> DROP_INVENTORY = LOOT_FUNCTION_TYPES.register("drop_inventory", () -> {
        return new LootItemFunctionType(a.b);
    });

    public static void register(IEventBus iEventBus) {
        LOOT_FUNCTION_TYPES.register(iEventBus);
    }
}
