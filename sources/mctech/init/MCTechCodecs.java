package mctech.init;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Supplier;
import mctech.MCTech;
import mctech.blocks.b.d;
import mctech.blocks.b.e;
import mctech.blocks.b.f;
import mctech.blocks.b.h;
import mctech.blocks.c.A;
import mctech.blocks.c.C;
import mctech.blocks.c.C0083d;
import mctech.blocks.c.C0084e;
import mctech.blocks.c.C0085f;
import mctech.blocks.c.C0086g;
import mctech.blocks.c.F;
import mctech.blocks.c.G;
import mctech.blocks.c.i;
import mctech.blocks.c.l;
import mctech.blocks.c.q;
import mctech.blocks.c.r;
import mctech.blocks.c.t;
import mctech.blocks.c.w;
import mctech.blocks.c.x;
import mctech.blocks.c.y;
import mctech.blocks.c.z;
import mctech.g.a.a.b;
import mctech.i.c;
import mctech.modules.config.ModuleConfig;
import mctech.modules.j;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.core.component.DataComponentPatch;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/init/MCTechCodecs.class */
public class MCTechCodecs {
    public static final DeferredRegister<MapCodec<? extends ModuleConfig>> DEFERRED = DeferredRegister.create(MCTechModules.MODULES, MCTech.MODID);
    public static final Supplier<MapCodec<j>> SOUL_REAPER = DEFERRED.register("soul_reaper", () -> {
        return j.a;
    });
    public static final Codec<Integer> FROM_ZERO = Codec.intRange(0, Integer.MAX_VALUE);
    public static final Codec<Integer> FROM_ONE = Codec.intRange(1, Integer.MAX_VALUE);
    public static final Codec<Float> CHANCE = Codec.floatRange(0.0f, 1.0f);
    public static final Codec<UUID> UUID_CODEC = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.LONG.fieldOf("mostSigBits").forGetter((v0) -> {
            return v0.getMostSignificantBits();
        }), Codec.LONG.fieldOf("leastSigBits").forGetter((v0) -> {
            return v0.getLeastSignificantBits();
        })).apply(instance, (v1, v2) -> {
            return new UUID(v1, v2);
        });
    });
    public static final Codec<c> GENERATOR_TYPE_CODEC = StringRepresentable.fromEnum(c::values);
    public static final Codec<MachineTier> MACHINE_TIER_CODEC = StringRepresentable.fromEnum(MachineTier::values);
    public static final StreamCodec<RegistryFriendlyByteBuf, MachineTier> MACHINE_TIER_STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.INT, (v0) -> {
        return v0.ordinal();
    }, num -> {
        return MachineTier.values()[num.intValue()];
    });
    public static final MapCodec<i> FLUID_GENERATOR_BLOCK_CODEC = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(MACHINE_TIER_CODEC.fieldOf("machineTier").forGetter((v0) -> {
            return v0.a();
        }), GENERATOR_TYPE_CODEC.fieldOf("generatorType").forGetter((v0) -> {
            return v0.b();
        }), BlockBehaviour.propertiesCodec()).apply(instance, i::new);
    });
    public static final MapCodec<C0085f> COBBLESTONE_GENERATOR_BLOCK_CODEC = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(MACHINE_TIER_CODEC.fieldOf("machineTier").forGetter((v0) -> {
            return v0.a();
        }), BlockBehaviour.propertiesCodec()).apply(instance, C0085f::new);
    });
    public static final MapCodec<A> PLASMA_GENERATOR_BLOCK_CODEC = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(MACHINE_TIER_CODEC.fieldOf("machineTier").forGetter((v0) -> {
            return v0.a();
        }), BlockBehaviour.propertiesCodec()).apply(instance, A::new);
    });
    public static final MapCodec<mctech.blocks.c.j> TANK_BLOCK_CODEC = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(MACHINE_TIER_CODEC.fieldOf("machineTier").forGetter((v0) -> {
            return v0.machineTier();
        }), BlockBehaviour.propertiesCodec()).apply(instance, mctech.blocks.c.j::new);
    });
    public static final MapCodec<t> MOLECULAR_CONVERTER_BLOCK_CODEC = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(BlockBehaviour.propertiesCodec()).apply(instance, t::new);
    });
    public static final MapCodec<C> QUANTUM_WORKBENCH_BLOCK_CODEC = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(BlockBehaviour.propertiesCodec()).apply(instance, C::new);
    });
    public static final MapCodec<d> QUANTUM_GENERATOR_BLOCK_CODEC = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(BlockBehaviour.propertiesCodec()).apply(instance, d::new);
    });
    public static final MapCodec<C0083d> ASSEMBLY_STATION_BLOCK_CODEC = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(BlockBehaviour.propertiesCodec()).apply(instance, C0083d::new);
    });
    public static final MapCodec<C0084e> ATOMIC_SMELTER_BLOCK_CODEC = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(BlockBehaviour.propertiesCodec()).apply(instance, C0084e::new);
    });
    public static final MapCodec<G> VENDING_MACHINE_BLOCK_CODEC = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(BlockBehaviour.propertiesCodec()).apply(instance, G::new);
    });
    public static final MapCodec<r> ITEM_DUPLICATOR_BLOCK_CODEC = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(BlockBehaviour.propertiesCodec()).apply(instance, r::new);
    });
    public static final MapCodec<q> ITEM_DESTROYER_BLOCK_CODEC = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(BlockBehaviour.propertiesCodec()).apply(instance, q::new);
    });
    public static final MapCodec<x> PATTERN_ENCODER_FORGE_BLOCK_CODEC = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(BlockBehaviour.propertiesCodec()).apply(instance, x::new);
    });
    public static final MapCodec<w> PATTERN_ASSEMBLY_ENCODER_BLOCK_CODEC = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(BlockBehaviour.propertiesCodec()).apply(instance, w::new);
    });
    public static final MapCodec<y> PATTERN_QUANTUM_WORKBENCH_BLOCK_CODEC = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(BlockBehaviour.propertiesCodec()).apply(instance, y::new);
    });
    public static final MapCodec<F> TRANSFORMATION_ASSEMBLER_BLOCK_CODEC = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(BlockBehaviour.propertiesCodec()).apply(instance, F::new);
    });
    public static final MapCodec<z> PATTERN_TRANSFORMATION_ASSEMBLER_ENCODER_BLOCK_CODEC = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(BlockBehaviour.propertiesCodec()).apply(instance, z::new);
    });
    public static final MapCodec<e> REACTOR = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(BlockBehaviour.propertiesCodec(), MACHINE_TIER_CODEC.fieldOf("machineTier").forGetter((v0) -> {
            return v0.a();
        })).apply(instance, e::new);
    });
    public static final MapCodec<h> THERMONUCLEAR_REACTOR = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(BlockBehaviour.propertiesCodec()).apply(instance, h::new);
    });
    public static final MapCodec<f> REACTOR_CHAMBER = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(BlockBehaviour.propertiesCodec(), MACHINE_TIER_CODEC.fieldOf("machineTier").forGetter((v0) -> {
            return v0.a();
        })).apply(instance, f::new);
    });
    public static final MapCodec<mctech.blocks.b.j> WINDMILL_GENERATOR_BLOCK_CODEC = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(BlockBehaviour.propertiesCodec()).apply(instance, mctech.blocks.b.j::new);
    });
    public static final MapCodec<l> GLASS_FURNACE_BLOCK_CODEC = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(BlockBehaviour.propertiesCodec()).apply(instance, l::new);
    });
    public static final MapCodec<C0086g> FARMING_STATION_BLOCK_CODEC = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(BlockBehaviour.propertiesCodec()).apply(instance, C0086g::new);
    });
    public static final MapCodec<mctech.blocks.c.h> FARMING_STATION_CULTIVATOR_BLOCK_CODEC = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(BlockBehaviour.propertiesCodec()).apply(instance, mctech.blocks.c.h::new);
    });
    public static final MapCodec<ItemStack> UNLIMITED_ITEM_STACK = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(BuiltInRegistries.ITEM.holderByNameCodec().fieldOf(b.a).forGetter((v0) -> {
            return v0.getItemHolder();
        }), Codec.INT.fieldOf("count").forGetter((v0) -> {
            return v0.getCount();
        }), DataComponentPatch.CODEC.optionalFieldOf("components", DataComponentPatch.EMPTY).forGetter((v0) -> {
            return v0.getComponentsPatch();
        })).apply(instance, (v1, v2, v3) -> {
            return new ItemStack(v1, v2, v3);
        });
    });
    public static final Codec<ItemStack> OPTIONAL_UNLIMITED_ITEM_STACK = Codec.lazyInitialized(() -> {
        return RecordCodecBuilder.create(instance -> {
            return instance.group(BuiltInRegistries.ITEM.holderByNameCodec().fieldOf(b.a).forGetter((v0) -> {
                return v0.getItemHolder();
            }), Codec.INT.optionalFieldOf("count", 1).forGetter((v0) -> {
                return v0.getCount();
            }), DataComponentPatch.CODEC.optionalFieldOf("components", DataComponentPatch.EMPTY).forGetter((v0) -> {
                return v0.getComponentsPatch();
            })).apply(instance, (holder, num, dataComponentPatch) -> {
                if (num.intValue() <= 0) {
                    return ItemStack.EMPTY;
                }
                return new ItemStack(holder, num.intValue(), dataComponentPatch);
            });
        });
    });
    public static final Codec<ItemStack> OPTIONAL_UNBOUNDED_ITEM_STACK = Codec.lazyInitialized(() -> {
        return ExtraCodecs.optionalEmptyMap(OPTIONAL_UNLIMITED_ITEM_STACK).xmap(optional -> {
            return (ItemStack) optional.orElse(ItemStack.EMPTY);
        }, itemStack -> {
            return (itemStack == null || itemStack.isEmpty()) ? Optional.empty() : Optional.of(itemStack);
        });
    });

    public static void register(IEventBus iEventBus) {
        DEFERRED.register(iEventBus);
    }
}
