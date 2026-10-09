package mctech.init;

import com.mojang.serialization.MapCodec;
import mctech.MCTech;
import mctech.n.a;
import net.mcskill.msregistry.datagen.data.LBlockLootProvider;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.CopyComponentsFunction;
import net.minecraft.world.level.storage.loot.functions.LootItemFunctionType;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/init/MCTechLootModifiers.class */
public class MCTechLootModifiers {
    private static final DeferredRegister<MapCodec<? extends IGlobalLootModifier>> SERIALIZERS = DeferredRegister.create(NeoForgeRegistries.GLOBAL_LOOT_MODIFIER_SERIALIZERS, MCTech.MODID);
    private static final DeferredRegister<LootItemConditionType> CONDITIONS = DeferredRegister.create(Registries.LOOT_CONDITION_TYPE, MCTech.MODID);
    private static final DeferredRegister<LootItemFunctionType<?>> FUNCTIONS = DeferredRegister.create(Registries.LOOT_FUNCTION_TYPE, MCTech.MODID);

    public static void register(IEventBus iEventBus) {
        SERIALIZERS.register(iEventBus);
        CONDITIONS.register(iEventBus);
        FUNCTIONS.register(iEventBus);
    }

    public static <B extends Block> void defaultLootTable(LBlockLootProvider lBlockLootProvider, B b) {
        lBlockLootProvider.add(b, LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0f)).add(LootItem.lootTableItem(b).apply(CopyComponentsFunction.copyComponents(CopyComponentsFunction.Source.BLOCK_ENTITY).include(DataComponents.CUSTOM_NAME)).apply(new a.C0030a()))));
    }
}
