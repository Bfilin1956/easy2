package mctech.init;

import com.mojang.serialization.Codec;
import io.netty.buffer.ByteBuf;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import mctech.MCTech;
import mctech.a.b.d.d;
import mctech.g.a.a.a;
import mctech.g.a.a.b;
import mctech.g.d.b.c;
import mctech.g.d.c.l;
import mctech.g.d.c.m;
import mctech.g.d.e.e;
import mctech.items.e.i;
import mctech.items.e.j;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.core.Holder;
import net.minecraft.core.UUIDUtil;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.util.Unit;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemContainerContents;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.fluids.SimpleFluidContent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/init/MCTechDataComponent.class */
public class MCTechDataComponent {
    public static final DeferredRegister<DataComponentType<?>> REGISTRY = DeferredRegister.create(BuiltInRegistries.DATA_COMPONENT_TYPE, MCTech.MODID);
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Integer>> CHARGE = register("charge", builder -> {
        return builder.persistent(ExtraCodecs.NON_NEGATIVE_INT).networkSynchronized(ByteBufCodecs.VAR_INT);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Double>> ENERGY_MOD = register("energy_mod", builder -> {
        return builder.persistent(Codec.DOUBLE).networkSynchronized(ByteBufCodecs.DOUBLE);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Integer>> ENERGY_ADD = register("energy_add", builder -> {
        return builder.persistent(Codec.INT).networkSynchronized(ByteBufCodecs.VAR_INT);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Double>> TIME_MOD = register("time_mod", builder -> {
        return builder.persistent(Codec.DOUBLE).networkSynchronized(ByteBufCodecs.DOUBLE);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Integer>> TIME_ADD = register("time_add", builder -> {
        return builder.persistent(Codec.INT).networkSynchronized(ByteBufCodecs.VAR_INT);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Long>> TARGET_POS = register("target_pos", builder -> {
        return builder.persistent(Codec.LONG).networkSynchronized(ByteBufCodecs.VAR_LONG);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Boolean>> HIDE_BAR = register("hide_bar", builder -> {
        return builder.persistent(Codec.BOOL).networkSynchronized(ByteBufCodecs.BOOL);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Integer>> FLAGS = register(j.a, builder -> {
        return builder.persistent(Codec.INT).networkSynchronized(ByteBufCodecs.INT);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<String>> PLAN = register("plan", builder -> {
        return builder.persistent(Codec.STRING).networkSynchronized(ByteBufCodecs.STRING_UTF8);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<String>> PLAN_NAME = register("plan_name", builder -> {
        return builder.persistent(Codec.STRING).networkSynchronized(ByteBufCodecs.STRING_UTF8);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<String>> ID = register(b.a, builder -> {
        return builder.persistent(Codec.STRING).networkSynchronized(ByteBufCodecs.STRING_UTF8);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Byte>> GROWTH = register("growth", builder -> {
        return builder.persistent(Codec.BYTE).networkSynchronized(ByteBufCodecs.BYTE);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Byte>> GAIN = register("gain", builder -> {
        return builder.persistent(Codec.BYTE).networkSynchronized(ByteBufCodecs.BYTE);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Byte>> RESISTANCE = register("resistance", builder -> {
        return builder.persistent(Codec.BYTE).networkSynchronized(ByteBufCodecs.BYTE);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Byte>> SCAN = register("scan", builder -> {
        return builder.persistent(Codec.BYTE).networkSynchronized(ByteBufCodecs.BYTE);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Boolean>> BREED = register("breed", builder -> {
        return builder.persistent(Codec.BOOL).networkSynchronized(ByteBufCodecs.BOOL);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Integer>> POINTS = register("points", builder -> {
        return builder.persistent(Codec.INT).networkSynchronized(ByteBufCodecs.INT);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Long>> SEED = register("seed", builder -> {
        return builder.persistent(Codec.LONG).networkSynchronized(ByteBufCodecs.VAR_LONG);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<List<Integer>>> BREED_LIST = register("breed_list", builder -> {
        return builder.persistent(Codec.INT.listOf()).networkSynchronized(ByteBufCodecs.INT.apply(ByteBufCodecs.list()));
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Integer>> DATA = register("data", builder -> {
        return builder.persistent(Codec.INT).networkSynchronized(ByteBufCodecs.INT);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Byte>> PROGRESS = register("progress", builder -> {
        return builder.persistent(Codec.BYTE).networkSynchronized(ByteBufCodecs.BYTE);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Integer>> BREED_ROD = register("breed_rod", builder -> {
        return builder.persistent(Codec.INT).networkSynchronized(ByteBufCodecs.VAR_INT);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Double>> WATER_BUFFER = register("water_buffer", builder -> {
        return builder.persistent(Codec.DOUBLE).networkSynchronized(ByteBufCodecs.DOUBLE);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Double>> HEAT_STORAGE = register("heat_storage", builder -> {
        return builder.persistent(Codec.DOUBLE).networkSynchronized(ByteBufCodecs.DOUBLE);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Integer>> DIRECTIONS = register("directions", builder -> {
        return builder.persistent(Codec.INT).networkSynchronized(ByteBufCodecs.VAR_INT);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Integer>> RESET = register("reset", builder -> {
        return builder.persistent(Codec.INT).networkSynchronized(ByteBufCodecs.VAR_INT);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Integer>> TOTAL = register("total", builder -> {
        return builder.persistent(Codec.INT).networkSynchronized(ByteBufCodecs.VAR_INT);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Float>> AVERAGE = register("average", builder -> {
        return builder.persistent(Codec.FLOAT).networkSynchronized(ByteBufCodecs.FLOAT);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Integer>> REFILLED = register("refilled", builder -> {
        return builder.persistent(Codec.INT).networkSynchronized(ByteBufCodecs.VAR_INT);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Boolean>> VISIBLE = register("visible", builder -> {
        return builder.persistent(Codec.BOOL).networkSynchronized(ByteBufCodecs.BOOL);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Integer>> RADIUS = register("radius", builder -> {
        return builder.persistent(Codec.INT).networkSynchronized(ByteBufCodecs.VAR_INT);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<List<Long>>> POSITIONS = register("positions", builder -> {
        return builder.persistent(Codec.LONG.listOf()).networkSynchronized(ByteBufCodecs.VAR_LONG.apply(ByteBufCodecs.list()));
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Long>> TRACK_POS = register("track_pos", builder -> {
        return builder.persistent(Codec.LONG).networkSynchronized(ByteBufCodecs.VAR_LONG);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Long>> LAST_POS = register("last_pos", builder -> {
        return builder.persistent(Codec.LONG).networkSynchronized(ByteBufCodecs.VAR_LONG);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Long>> POS = register("pos", builder -> {
        return builder.persistent(Codec.LONG).networkSynchronized(ByteBufCodecs.VAR_LONG);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<List<Integer>>> VALID = register("valid", builder -> {
        return builder.persistent(Codec.INT.listOf()).networkSynchronized(ByteBufCodecs.INT.apply(ByteBufCodecs.list()));
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<List<ItemStack>>> ITEMS = register("items", builder -> {
        return builder.persistent(ItemStack.CODEC.listOf()).networkSynchronized(ItemStack.STREAM_CODEC.apply(ByteBufCodecs.list()));
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Integer>> SLOT = register("slot", builder -> {
        return builder.persistent(Codec.INT).networkSynchronized(ByteBufCodecs.INT);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<List<Integer>>> SLOTS = register("slots", builder -> {
        return builder.persistent(Codec.INT.listOf()).networkSynchronized(ByteBufCodecs.INT.apply(ByteBufCodecs.list()));
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Integer>> SELECTED = register("selected", builder -> {
        return builder.persistent(Codec.INT).networkSynchronized(ByteBufCodecs.INT);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Integer>> GUI_ID = register("gui_id", builder -> {
        return builder.persistent(Codec.INT).networkSynchronized(ByteBufCodecs.INT);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Integer>> ORE_SCANNER_COUNT = register("ore_scanner_count", builder -> {
        return builder.persistent(Codec.INT).networkSynchronized(ByteBufCodecs.INT);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<CompoundTag>> NBT_TAG = register("nbt_tag", builder -> {
        return builder.persistent(CompoundTag.CODEC).networkSynchronized(ByteBufCodecs.COMPOUND_TAG);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Integer>> AGE = register("age", builder -> {
        return builder.persistent(Codec.INT).networkSynchronized(ByteBufCodecs.VAR_INT);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Boolean>> SPECIAL_MODE = register("special_mode", builder -> {
        return builder.persistent(Codec.BOOL).networkSynchronized(ByteBufCodecs.BOOL);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Integer>> MODE = register("mode", builder -> {
        return builder.persistent(Codec.INT).networkSynchronized(ByteBufCodecs.VAR_INT);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Integer>> LOSS_USES = register("loss_uses", builder -> {
        return builder.persistent(Codec.INT).networkSynchronized(ByteBufCodecs.VAR_INT);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Boolean>> LOSSLESS_MODE = register("lossless_mode", builder -> {
        return builder.persistent(Codec.BOOL).networkSynchronized(ByteBufCodecs.BOOL);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<String>> DIM = register("dim", builder -> {
        return builder.persistent(Codec.STRING).networkSynchronized(ByteBufCodecs.STRING_UTF8);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Long>> LAST_TIME = register("last_time", builder -> {
        return builder.persistent(Codec.LONG).networkSynchronized(ByteBufCodecs.VAR_LONG);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Long>> LAST_OUT = register("last_out", builder -> {
        return builder.persistent(Codec.LONG).networkSynchronized(ByteBufCodecs.VAR_LONG);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Long>> LAST_IN = register("last_in", builder -> {
        return builder.persistent(Codec.LONG).networkSynchronized(ByteBufCodecs.VAR_LONG);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Byte>> FACING = register("facing", builder -> {
        return builder.persistent(Codec.BYTE).networkSynchronized(ByteBufCodecs.BYTE);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Boolean>> AUTO_REFILL = register("auto_refill", builder -> {
        return builder.persistent(Codec.BOOL).networkSynchronized(ByteBufCodecs.BOOL);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Integer>> STORED = register("stored", builder -> {
        return builder.persistent(Codec.INT).networkSynchronized(ByteBufCodecs.INT);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<CompoundTag>> BLOCK = register("block", builder -> {
        return builder.persistent(CompoundTag.CODEC).networkSynchronized(ByteBufCodecs.COMPOUND_TAG);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Byte>> LAYER = register("layer", builder -> {
        return builder.persistent(Codec.BYTE).networkSynchronized(ByteBufCodecs.BYTE);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<CompoundTag>> TARGET = register("target", builder -> {
        return builder.persistent(CompoundTag.CODEC).networkSynchronized(ByteBufCodecs.COMPOUND_TAG);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<String>> TARGET_NAME = register("target_name", builder -> {
        return builder.persistent(Codec.STRING).networkSynchronized(ByteBufCodecs.STRING_UTF8);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Integer>> TRANSFER_SIZE = register("transfer_size", builder -> {
        return builder.persistent(Codec.INT).networkSynchronized(ByteBufCodecs.INT);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Integer>> FILTER_FLAGS = register("filter_flags", builder -> {
        return builder.persistent(Codec.INT).networkSynchronized(ByteBufCodecs.INT);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Integer>> FILTER_DURABILITY = register("filter_durability", builder -> {
        return builder.persistent(Codec.INT).networkSynchronized(ByteBufCodecs.INT);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Boolean>> FILTER_INVERTED = register("filter_inverted", builder -> {
        return builder.persistent(Codec.BOOL).networkSynchronized(ByteBufCodecs.BOOL);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<CompoundTag>> FILTERS = register("filters", builder -> {
        return builder.persistent(CompoundTag.CODEC).networkSynchronized(ByteBufCodecs.COMPOUND_TAG);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Integer>> CRYSTAL_CHARGE = register("crystal_charge", builder -> {
        return builder.persistent(Codec.INT).networkSynchronized(ByteBufCodecs.INT);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<String>> CONSUMABLE_CATEGORY = register("consumable_category", builder -> {
        return builder.persistent(Codec.STRING).networkSynchronized(ByteBufCodecs.STRING_UTF8);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Integer>> CONSUMABLE_FUEL_HEAT_SPEED = register("consumable_fuel_heat_speed", builder -> {
        return builder.persistent(Codec.INT).networkSynchronized(ByteBufCodecs.INT);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Boolean>> CONSUMABLE_INFINITE = register("consumable_infinite", builder -> {
        return builder.persistent(Codec.BOOL).networkSynchronized(ByteBufCodecs.BOOL);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Integer>> VISION_TICKER = register("vision_ticker", builder -> {
        return builder.persistent(Codec.INT).networkSynchronized(ByteBufCodecs.INT);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Boolean>> VISION_ENABLED = register("vision_enabled", builder -> {
        return builder.persistent(Codec.BOOL).networkSynchronized(ByteBufCodecs.BOOL);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<i.a>> SCHEME_STORAGE = register("scheme_storage", builder -> {
        return builder.persistent(i.a.b).networkSynchronized(i.a.c);
    });
    public static Supplier<DataComponentType<MachineTier>> MACHINE_TIER = register("machine_tier", builder -> {
        return builder.persistent(MCTechCodecs.MACHINE_TIER_CODEC).networkSynchronized(MCTechCodecs.MACHINE_TIER_STREAM_CODEC);
    });
    public static Supplier<DataComponentType<SimpleFluidContent>> ITEM_FLUID_CONTENT = register("item_fluid_content", builder -> {
        return builder.persistent(SimpleFluidContent.CODEC).networkSynchronized(SimpleFluidContent.STREAM_CODEC);
    });
    public static Supplier<DataComponentType<e>> NAMED_FLUID_CONTENTS = register("named_fluid_contents", builder -> {
        return builder.persistent(e.a).networkSynchronized(e.b);
    });
    public static Supplier<DataComponentType<Integer>> ENERGY = register("energy", builder -> {
        return builder.persistent(Codec.INT).networkSynchronized(ByteBufCodecs.INT);
    });
    public static Supplier<DataComponentType<b>> STORED_ENTITY = register("stored_entity", builder -> {
        return builder.persistent(b.c).networkSynchronized(b.d);
    });
    public static Supplier<DataComponentType<Boolean>> TOGGLED = register("toggled", builder -> {
        return builder.persistent(Codec.BOOL).networkSynchronized(ByteBufCodecs.BOOL);
    });
    public static Supplier<DataComponentType<a>> COORDINATE_SELECTION = register("coordinate_selection", builder -> {
        return builder.persistent(a.a).networkSynchronized(a.b);
    });
    public static final DataComponentType<c.b> PROBE_STATE = registerV2("probe_state", builder -> {
        return builder.persistent(c.b.c).networkSynchronized(c.b.d);
    });
    public static final DataComponentType<c.a> PROBE_CONFIG = registerV2("probe_config", builder -> {
        return builder.persistent(c.a.a).networkSynchronized(c.a.b);
    });
    public static final DataComponentType<mctech.g.d.a.b.b.a> ITEM_FILTER = registerV2("item_filter", builder -> {
        return builder.persistent(mctech.g.d.a.b.b.a.b).networkSynchronized(mctech.g.d.a.b.b.a.c);
    });
    public static final DataComponentType<mctech.g.d.a.b.b.a.a> LIMITED_ITEM_FILTER = registerV2("limited_item_filter", builder -> {
        return builder.persistent(mctech.g.d.a.b.b.a.a.c).networkSynchronized(mctech.g.d.a.b.b.a.a.d);
    });
    public static final DataComponentType<mctech.g.d.a.b.a.a> FLUID_FILTER = registerV2("fluid_filter", builder -> {
        return builder.persistent(mctech.g.d.a.b.a.a.b).networkSynchronized(mctech.g.d.a.b.a.a.c);
    });
    public static final DataComponentType<mctech.g.d.c.a.C0015a> REDSTONE_FILTER_DOUBLE_CHANNEL = registerV2("redstone_filter_double_channel", builder -> {
        return builder.persistent(mctech.g.d.c.a.C0015a.a).networkSynchronized(mctech.g.d.c.a.C0015a.b);
    });
    public static final DataComponentType<mctech.g.d.c.c.a> REDSTONE_COUNT_FILTER = registerV2("redstone_count_filter", builder -> {
        return builder.persistent(mctech.g.d.c.c.a.a).networkSynchronized(mctech.g.d.c.c.a.b);
    });
    public static final DataComponentType<m.a> REDSTONE_TIMER_FILTER = registerV2("redstone_timer_filter", builder -> {
        return builder.persistent(m.a.a).networkSynchronized(m.a.b);
    });
    public static final DataComponentType<l.a> REDSTONE_TLATCH_FILTER = registerV2("redstone_tlatch_filter", builder -> {
        return builder.persistent(l.a.a).networkSynchronized(l.a.b);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Holder<mctech.g.a.a<?, ?>>>> CONDUIT = register("conduit", builder -> {
        return builder.persistent(mctech.g.a.a.b).networkSynchronized(mctech.g.a.a.c);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<mctech.g.a.d.b>> FACADE_TYPE = register("facade_type", builder -> {
        return builder.persistent(mctech.g.a.d.b.e).networkSynchronized(mctech.g.a.d.b.g);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Integer>> EXTRACTION_SPEED_UPGRADE_TIER = register("extraction_speed_upgrade_tier", builder -> {
        return builder.persistent(Codec.INT).networkSynchronized(ByteBufCodecs.INT);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<mctech.g.d.c.a.C0015a>> REDSTONE_AND_FILTER = register("redstone_and_filter", builder -> {
        return builder.persistent(mctech.g.d.c.a.C0015a.a).networkSynchronized(mctech.g.d.c.a.C0015a.b);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<mctech.g.d.c.a.C0015a>> REDSTONE_NAND_FILTER = register("redstone_nand_filter", builder -> {
        return builder.persistent(mctech.g.d.c.a.C0015a.a).networkSynchronized(mctech.g.d.c.a.C0015a.b);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<mctech.g.d.c.a.C0015a>> REDSTONE_NOR_FILTER = register("redstone_nor_filter", builder -> {
        return builder.persistent(mctech.g.d.c.a.C0015a.a).networkSynchronized(mctech.g.d.c.a.C0015a.b);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Unit>> REDSTONE_NOT_FILTER = register("redstone_not_filter", builder -> {
        return builder.persistent(Codec.unit(Unit.INSTANCE)).networkSynchronized(StreamCodec.unit(Unit.INSTANCE));
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<mctech.g.d.c.a.C0015a>> REDSTONE_OR_FILTER = register("redstone_or_filter", builder -> {
        return builder.persistent(mctech.g.d.c.a.C0015a.a).networkSynchronized(mctech.g.d.c.a.C0015a.b);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Unit>> REDSTONE_SENSOR_FILTER = register("redstone_sensor_filter", builder -> {
        return builder.persistent(Codec.unit(Unit.INSTANCE)).networkSynchronized(StreamCodec.unit(Unit.INSTANCE));
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<mctech.g.d.c.a.C0015a>> REDSTONE_XNOR_FILTER = register("redstone_xnor_filter", builder -> {
        return builder.persistent(mctech.g.d.c.a.C0015a.a).networkSynchronized(mctech.g.d.c.a.C0015a.b);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<mctech.g.d.c.a.C0015a>> REDSTONE_XOR_FILTER = register("redstone_xor_filter", builder -> {
        return builder.persistent(mctech.g.d.c.a.C0015a.a).networkSynchronized(mctech.g.d.c.a.C0015a.b);
    });
    public static final Supplier<DataComponentType<SimpleFluidContent>> TANK_CONTENT = register("tank_content", builder -> {
        return builder.persistent(SimpleFluidContent.CODEC).networkSynchronized(SimpleFluidContent.STREAM_CODEC);
    });
    public static final Supplier<DataComponentType<ItemContainerContents>> AE2_CELLS = register("ae2_cells", builder -> {
        return builder.persistent(ItemContainerContents.CODEC).networkSynchronized(ItemContainerContents.STREAM_CODEC);
    });
    public static final Supplier<DataComponentType<Boolean>> KEEP = register("keep", builder -> {
        return builder.persistent(Codec.BOOL).networkSynchronized(ByteBufCodecs.BOOL);
    });
    public static final Supplier<DataComponentType<ItemContainerContents>> FLY_ITEM = register("fly_item", builder -> {
        return builder.persistent(ItemContainerContents.CODEC).networkSynchronized(ItemContainerContents.STREAM_CODEC);
    });
    public static final Supplier<DataComponentType<ItemContainerContents>> EU_READER_ITEM = register("eu_reader_item", builder -> {
        return builder.persistent(ItemContainerContents.CODEC).networkSynchronized(ItemContainerContents.STREAM_CODEC);
    });
    public static final Supplier<DataComponentType<ItemContainerContents>> BATPACK_ITEM = register("batpack_item", builder -> {
        return builder.persistent(ItemContainerContents.CODEC).networkSynchronized(ItemContainerContents.STREAM_CODEC);
    });
    public static final Supplier<DataComponentType<Integer>> CAPACITY = register("capacity", ExtraCodecs.NON_NEGATIVE_INT, ByteBufCodecs.VAR_INT);
    public static final Supplier<DataComponentType<ItemContainerContents>> BATTERIES = register("batteries", ItemContainerContents.CODEC, ItemContainerContents.STREAM_CODEC);
    public static final Supplier<DataComponentType<ItemContainerContents>> MODULES = register("modules", ItemContainerContents.CODEC, ItemContainerContents.STREAM_CODEC);
    public static final Supplier<DataComponentType<ModulesInfo>> MODULES_INFO = register("modules_info", ModulesInfo.CODEC, ModulesInfo.STREAM_CODEC);
    public static final Supplier<DataComponentType<ItemContainerContents>> SINGULAR_CELLS = register("singular_cells", ItemContainerContents.CODEC, ItemContainerContents.STREAM_CODEC);
    public static final Supplier<DataComponentType<ItemContainerContents>> SINGULAR_ENERGY_PACKS = register("singular_energy_packs", ItemContainerContents.CODEC, ItemContainerContents.STREAM_CODEC);
    public static final Supplier<DataComponentType<ItemContainerContents>> SINGULAR_EU_READER = register("singular_eu_reader", ItemContainerContents.CODEC, ItemContainerContents.STREAM_CODEC);
    public static final Supplier<DataComponentType<SingularFeaturesInfo>> SINGULAR_FEATURES = register("singular_features", SingularFeaturesInfo.CODEC, SingularFeaturesInfo.STREAM_CODEC);
    public static final Supplier<DataComponentType<Boolean>> ACTIVATED = register("activated", Codec.BOOL, ByteBufCodecs.BOOL);
    public static final Supplier<DataComponentType<ItemContainerContents>> BLADE = register("blade", ItemContainerContents.CODEC, ItemContainerContents.STREAM_CODEC);
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Boolean>> ACTIVE = register("active", builder -> {
        return builder.persistent(Codec.BOOL).networkSynchronized(ByteBufCodecs.BOOL);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Boolean>> ENABLED = register("enabled", builder -> {
        return builder.persistent(Codec.BOOL).networkSynchronized(ByteBufCodecs.BOOL);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Integer>> ENERGY_STORED = register("energy_stored", builder -> {
        return builder.persistent(Codec.INT).networkSynchronized(ByteBufCodecs.INT);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Integer>> ENERGY_CAPACITY = register("energy_capacity", builder -> {
        return builder.persistent(Codec.INT).networkSynchronized(ByteBufCodecs.INT);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Boolean>> JETPACK_HOVERING = register("jetpack_hovering", builder -> {
        return builder.persistent(Codec.BOOL).networkSynchronized(ByteBufCodecs.BOOL);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Boolean>> JETPACK_ENABLED = register("jetpack_enabled", builder -> {
        return builder.persistent(Codec.BOOL).networkSynchronized(ByteBufCodecs.BOOL);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Byte>> JETPACK_TICKER = register("jetpack_ticker", builder -> {
        return builder.persistent(Codec.BYTE).networkSynchronized(ByteBufCodecs.BYTE);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Byte>> JETPACK_TIMER = register("jetpack_timer", builder -> {
        return builder.persistent(Codec.BYTE).networkSynchronized(ByteBufCodecs.BYTE);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Byte>> JETPACK_USE_MODE = register("jetpack_use_mode", builder -> {
        return builder.persistent(Codec.BYTE).networkSynchronized(ByteBufCodecs.BYTE);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Byte>> JETPACK_HOVER_MODE = register("jetpack_hover_mode", builder -> {
        return builder.persistent(Codec.BYTE).networkSynchronized(ByteBufCodecs.BYTE);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<mctech.a.b.d.c>> ENCODED_ASSEMBLY_STATION_PATTERN = register("encoded_assembly_station_pattern", builder -> {
        return builder.persistent(mctech.a.b.d.c.a).networkSynchronized(mctech.a.b.d.c.b);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<d>> ENCODED_INDUSTRIAL_FORGE_PATTERN = register("encoded_industrial_forge_pattern", builder -> {
        return builder.persistent(d.a).networkSynchronized(d.b);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<mctech.a.b.d.j>> ENCODED_QUANTUM_WORKBENCH_PATTERN = register("encoded_quantum_workbench_pattern", builder -> {
        return builder.persistent(mctech.a.b.d.j.a).networkSynchronized(mctech.a.b.d.j.b);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<mctech.a.b.d.e>> ENCODED_TRANSFORMATION_ASSEMBLER_PATTERN = register("encoded_transformation_assembler_pattern", builder -> {
        return builder.persistent(mctech.a.b.d.e.a).networkSynchronized(mctech.a.b.d.e.b);
    });
    public static Supplier<DataComponentType<mctech.y.a>> BLOCK_APPEARANCE = register("block_appearance", builder -> {
        return builder.persistent(mctech.y.a.a).networkSynchronized(mctech.y.a.b);
    });
    public static Supplier<DataComponentType<List<mctech.y.a>>> BLOCK_APPEARANCE_LIST = register("block_appearance_list", builder -> {
        return builder.persistent(mctech.y.a.a.listOf()).networkSynchronized(mctech.y.a.b.apply(ByteBufCodecs.list()));
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Boolean>> BLOCK_APPEARANCE_LIST_CHANGED = register("block_appearance_changed", builder -> {
        return builder.persistent(Codec.BOOL).networkSynchronized(ByteBufCodecs.BOOL);
    });
    public static Supplier<DataComponentType<mctech.blockentities.f.c>> TELEPORT_TARGET = register("teleport_target", builder -> {
        return builder.persistent(mctech.blockentities.f.c.a).networkSynchronized(mctech.blockentities.f.c.b);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<UUID>> UUID = register("uuid", builder -> {
        return builder.persistent(UUIDUtil.CODEC).networkSynchronized(UUIDUtil.STREAM_CODEC);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Boolean>> AE_PORTABLE_CELL_AUTO_PICKUP = register("ae2_portable_pickup", builder -> {
        return builder.persistent(Codec.BOOL).networkSynchronized(ByteBufCodecs.BOOL);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Integer>> BLOCKS_BRAKED = register("blocks_braked", builder -> {
        return builder.persistent(Codec.INT).networkSynchronized(ByteBufCodecs.INT);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Integer>> ATTACK_MAKES = register("attack_makes", builder -> {
        return builder.persistent(Codec.INT).networkSynchronized(ByteBufCodecs.INT);
    });
    public static Supplier<DataComponentType<mctech.items.e.c.e>> SINGULAR_STAFF_SETTINGS = register("singular_staff_settings", builder -> {
        return builder.persistent(mctech.items.e.c.e.b).networkSynchronized(mctech.items.e.c.e.c);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<ResourceLocation>> ENTITY_TYPE = register("entity_type", builder -> {
        return builder.persistent(ResourceLocation.CODEC).networkSynchronized(ResourceLocation.STREAM_CODEC);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Float>> BASE_CHANCE = register("base_chance", builder -> {
        return builder.persistent(Codec.FLOAT).networkSynchronized(ByteBufCodecs.FLOAT);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Float>> BONUS_CHANCE = register("bonus_chance", builder -> {
        return builder.persistent(Codec.FLOAT).networkSynchronized(ByteBufCodecs.FLOAT);
    });
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Integer>> LUCK_LEVEL = register("luck_level", builder -> {
        return builder.persistent(Codec.INT).networkSynchronized(ByteBufCodecs.VAR_INT);
    });

    public static void register(IEventBus iEventBus) {
        REGISTRY.register(iEventBus);
    }

    private static <T> DeferredHolder<DataComponentType<?>, DataComponentType<T>> register(String str, UnaryOperator<DataComponentType.Builder<T>> unaryOperator) {
        return REGISTRY.register(str, () -> {
            return ((DataComponentType.Builder) unaryOperator.apply(DataComponentType.builder())).build();
        });
    }

    private static <T> DataComponentType<T> registerV2(String str, UnaryOperator<DataComponentType.Builder<T>> unaryOperator) {
        DataComponentType<T> dataComponentTypeBuild = ((DataComponentType.Builder) unaryOperator.apply(DataComponentType.builder())).build();
        REGISTRY.register(str, () -> {
            return dataComponentTypeBuild;
        });
        return dataComponentTypeBuild;
    }

    private static <T> Supplier<DataComponentType<T>> register(String str, Codec<T> codec, StreamCodec<? super RegistryFriendlyByteBuf, T> streamCodec) {
        return register(str, builder -> {
            return builder.persistent(codec).networkSynchronized(streamCodec);
        });
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/init/MCTechDataComponent$ModulesInfo.class */
    public static final class ModulesInfo extends Record {
        private final Map<ResourceLocation, Integer> levels;
        public static ModulesInfo EMPTY = new ModulesInfo(Map.of());
        public static final Codec<Map<ResourceLocation, Integer>> LEVELS_CODEC = Codec.unboundedMap(ResourceLocation.CODEC, Codec.INT);
        public static final StreamCodec<ByteBuf, Map<ResourceLocation, Integer>> LEVELS_STREAM_CODEC = ByteBufCodecs.map(HashMap::new, ResourceLocation.STREAM_CODEC, ByteBufCodecs.INT);
        public static final Codec<ModulesInfo> CODEC = LEVELS_CODEC.xmap(ModulesInfo::new, (v0) -> {
            return v0.levels();
        });
        public static final StreamCodec<ByteBuf, ModulesInfo> STREAM_CODEC = LEVELS_STREAM_CODEC.map(ModulesInfo::new, (v0) -> {
            return v0.levels();
        });

        public ModulesInfo(Map<ResourceLocation, Integer> map) {
            this.levels = map;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, ModulesInfo.class), ModulesInfo.class, "levels", "FIELD:Lmctech/init/MCTechDataComponent$ModulesInfo;->levels:Ljava/util/Map;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, ModulesInfo.class), ModulesInfo.class, "levels", "FIELD:Lmctech/init/MCTechDataComponent$ModulesInfo;->levels:Ljava/util/Map;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, ModulesInfo.class, Object.class), ModulesInfo.class, "levels", "FIELD:Lmctech/init/MCTechDataComponent$ModulesInfo;->levels:Ljava/util/Map;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        public Map<ResourceLocation, Integer> levels() {
            return this.levels;
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/init/MCTechDataComponent$SingularFeaturesInfo.class */
    public static final class SingularFeaturesInfo extends Record {
        private final Map<String, Boolean> features;
        public static final SingularFeaturesInfo EMPTY = new SingularFeaturesInfo(Map.of());
        public static final Codec<Map<String, Boolean>> FEATURES_CODEC = Codec.unboundedMap(Codec.STRING, Codec.BOOL);
        public static final StreamCodec<ByteBuf, Map<String, Boolean>> FEATURES_STREAM_CODEC = ByteBufCodecs.map(HashMap::new, ByteBufCodecs.STRING_UTF8, ByteBufCodecs.BOOL);
        public static final Codec<SingularFeaturesInfo> CODEC = FEATURES_CODEC.xmap(SingularFeaturesInfo::new, (v0) -> {
            return v0.features();
        });
        public static final StreamCodec<ByteBuf, SingularFeaturesInfo> STREAM_CODEC = FEATURES_STREAM_CODEC.map(SingularFeaturesInfo::new, (v0) -> {
            return v0.features();
        });

        public SingularFeaturesInfo(Map<String, Boolean> map) {
            this.features = map;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, SingularFeaturesInfo.class), SingularFeaturesInfo.class, "features", "FIELD:Lmctech/init/MCTechDataComponent$SingularFeaturesInfo;->features:Ljava/util/Map;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, SingularFeaturesInfo.class), SingularFeaturesInfo.class, "features", "FIELD:Lmctech/init/MCTechDataComponent$SingularFeaturesInfo;->features:Ljava/util/Map;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, SingularFeaturesInfo.class, Object.class), SingularFeaturesInfo.class, "features", "FIELD:Lmctech/init/MCTechDataComponent$SingularFeaturesInfo;->features:Ljava/util/Map;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        public Map<String, Boolean> features() {
            return this.features;
        }

        public boolean isEnabled(String str) {
            return this.features.getOrDefault(str, true).booleanValue();
        }
    }
}
