package mctech.g.d.b;

import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;
import java.lang.runtime.ObjectMethods;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import mctech.MCTech;
import mctech.g.a.l;
import mctech.init.MCTechDataComponent;
import mctech.init.MCTechItems;
import mctech.utils.e.d;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.NbtOps;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.RegistryOps;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.fml.loading.FMLEnvironment;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/b/c.class */
public class c extends Item {
    private static final Set<String> b = Set.of("DEFAULT", "CODEC", "STREAM_CODEC", "TYPE");
    public static final ResourceLocation a = MCTech.loc("probe_state");

    public c(Item.Properties properties) {
        super(properties.stacksTo(1).component(MCTechDataComponent.PROBE_STATE, b.COPY_PASTE));
    }

    public void appendHoverText(@NotNull ItemStack itemStack, @NotNull Item.TooltipContext tooltipContext, @NotNull List<Component> list, @NotNull TooltipFlag tooltipFlag) {
        super.appendHoverText(itemStack, tooltipContext, list, tooltipFlag);
        d dVar = new d(list);
        dVar.a(Component.literal("Режим: ").append(Component.literal(a(itemStack).toString()).withStyle(ChatFormatting.LIGHT_PURPLE)));
        dVar.a(Component.translatable("tooltip.mctech.press_key_description", new Object[]{MCTech.KEYBOARD.a(mctech.s.a.MODE_KEY).withStyle(ChatFormatting.GOLD), Component.literal("сменить режим").withStyle(ChatFormatting.UNDERLINE)}));
        if (a(itemStack) == b.COPY_PASTE) {
            dVar.a(Component.translatable("tooltip.mctech.press_key_description", new Object[]{Component.literal("ПКМ").withStyle(ChatFormatting.GOLD), Component.literal("вставить настройки").withStyle(ChatFormatting.UNDERLINE)}));
            dVar.a(Component.translatable("tooltip.mctech.press_key_description", new Object[]{Component.literal("Shift + ПКМ").withStyle(ChatFormatting.GOLD), Component.literal("скопировать настройки").withStyle(ChatFormatting.UNDERLINE)}));
        } else {
            dVar.a(Component.translatable("tooltip.mctech.press_key_description", new Object[]{Component.literal("ПКМ").withStyle(ChatFormatting.GOLD), Component.literal("получить информацию").withStyle(ChatFormatting.UNDERLINE)}));
        }
        a aVar = (a) itemStack.get(MCTechDataComponent.PROBE_CONFIG);
        HolderLookup.Provider providerRegistries = tooltipContext.registries();
        if (aVar != null && !aVar.a().isEmpty() && providerRegistries != null) {
            MutableComponent mutableComponentLiteral = Component.literal("Скопировано: ");
            aVar.a().keySet().forEach(resourceLocation -> {
                mutableComponentLiteral.append(a(providerRegistries, resourceLocation).copy().withStyle(ChatFormatting.LIGHT_PURPLE));
            });
            dVar.a(mutableComponentLiteral);
        }
    }

    @NotNull
    public InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand interactionHand) {
        ItemStack itemInHand = player.getItemInHand(interactionHand);
        if ((!FMLEnvironment.production || MCTech.PLATFORM.g()) && MCTech.KEYBOARD.d(player)) {
            a(player, itemInHand);
        }
        return InteractionResultHolder.pass(itemInHand);
    }

    @NotNull
    public InteractionResult onItemUseFirst(@NotNull ItemStack itemStack, UseOnContext useOnContext) {
        Level level = useOnContext.getLevel();
        BlockPos clickedPos = useOnContext.getClickedPos();
        BlockState blockState = level.getBlockState(clickedPos);
        BlockEntity blockEntity = level.getBlockEntity(clickedPos);
        Player player = useOnContext.getPlayer();
        if (player == null) {
            return super.onItemUseFirst(itemStack, useOnContext);
        }
        if (level.isClientSide()) {
            return InteractionResult.SUCCESS;
        }
        switch (a(itemStack)) {
            case PROBE:
                if (blockEntity instanceof mctech.g.d.a.a.b) {
                    Pair<Direction, Holder<mctech.g.a.a<?, ?>>> pairC = ((mctech.g.d.a.a.b) blockEntity).j().c(clickedPos, useOnContext.getHitResult());
                    if (pairC != null) {
                        Holder<mctech.g.a.a<?, ?>> holder = (Holder) pairC.getSecond();
                        ((mctech.g.a.a) holder.value()).a(level, clickedPos, player, holder);
                    }
                } else if (blockEntity instanceof mctech.g.a.i.a) {
                    ((mctech.g.a.i.a) blockEntity).a(level, clickedPos, player);
                } else {
                    mctech.g.a.i.a block = blockState.getBlock();
                    if (block instanceof mctech.g.a.i.a) {
                        block.a(level, clickedPos, player);
                    } else {
                        player.sendSystemMessage(Component.literal("Данный блок не поддерживается!").withStyle(ChatFormatting.YELLOW));
                    }
                }
                break;
            case COPY_PASTE:
                if (!(blockEntity instanceof mctech.g.d.a.a.b)) {
                    return super.onItemUseFirst(itemStack, useOnContext);
                }
                mctech.g.d.a.a.b bVar = (mctech.g.d.a.a.b) blockEntity;
                Pair<Direction, Holder<mctech.g.a.a<?, ?>>> pairC2 = bVar.j().c(clickedPos, useOnContext.getHitResult());
                if (pairC2 == null || !bVar.b((Holder<mctech.g.a.a<?, ?>>) pairC2.getSecond(), (Direction) pairC2.getFirst()).c()) {
                    player.sendSystemMessage(Component.literal("Нода не подключена к блоку или текущее подключение неактивно").withStyle(ChatFormatting.YELLOW));
                    return InteractionResult.FAIL;
                }
                Direction direction = (Direction) pairC2.getFirst();
                if (useOnContext.isSecondaryUseActive()) {
                    b(bVar, direction, itemStack, player);
                } else {
                    a(bVar, direction, itemStack, player);
                }
                break;
                break;
        }
        return InteractionResult.SUCCESS;
    }

    private void b(mctech.g.d.a.a.b bVar, Direction direction, ItemStack itemStack, Player player) {
        if (bVar.getLevel() == null) {
            return;
        }
        a aVar = new a(new HashMap());
        bVar.a().forEach(holder -> {
            mctech.g.a.c.c cVarC = bVar.c((Holder<mctech.g.a.a<?, ?>>) holder, direction);
            if (cVarC != null) {
                ResourceLocation resourceLocation = ResourceLocation.parse(holder.getRegisteredName());
                RegistryOps registryOpsCreate = RegistryOps.create(NbtOps.INSTANCE, bVar.getLevel().registryAccess());
                mctech.g.a.c.c.a.encodeStart(registryOpsCreate, cVarC).result().flatMap(tag -> {
                    return mctech.g.a.c.c.a.parse(registryOpsCreate, tag).result();
                }).ifPresent(cVar -> {
                    aVar.a().put(resourceLocation, cVar);
                });
            }
        });
        itemStack.set(MCTechDataComponent.PROBE_CONFIG, aVar);
        if (!aVar.a().isEmpty()) {
            ArrayList arrayList = new ArrayList();
            MutableComponent mutableComponentEmpty = Component.empty();
            aVar.a().forEach((resourceLocation, cVar) -> {
                for (Field field : cVar.getClass().getDeclaredFields()) {
                    if (!b.contains(field.getName())) {
                        mutableComponentEmpty.append(a(field, cVar));
                    }
                }
                arrayList.add(resourceLocation);
            });
            player.sendSystemMessage(Component.literal("Настройки трубы скопированы!").withStyle(ChatFormatting.GRAY));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                player.sendSystemMessage(Component.literal(" -> ").append(a((HolderLookup.Provider) ((Level) Objects.requireNonNull(bVar.getLevel())).registryAccess(), (ResourceLocation) it.next())).withStyle(ChatFormatting.DARK_GREEN));
            }
        }
    }

    public void a(mctech.g.d.a.a.b bVar, Direction direction, ItemStack itemStack, Player player) {
        a aVar = (a) itemStack.get(MCTechDataComponent.PROBE_CONFIG);
        if (aVar == null) {
            return;
        }
        List<Holder<mctech.g.a.a<?, ?>>> listA = bVar.a();
        ArrayList arrayList = new ArrayList();
        listA.forEach(holder -> {
            ResourceLocation resourceLocation = ResourceLocation.parse(holder.getRegisteredName());
            mctech.g.a.c.c cVar = aVar.a().get(resourceLocation);
            if (cVar != null) {
                bVar.a((Holder<mctech.g.a.a<?, ?>>) holder, direction, cVar);
                arrayList.add(resourceLocation);
            }
        });
        if (!arrayList.isEmpty()) {
            player.sendSystemMessage(Component.literal("Настройки трубы применены!").withStyle(ChatFormatting.GRAY));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                player.sendSystemMessage(Component.literal(" <- ").append(a((HolderLookup.Provider) ((Level) Objects.requireNonNull(bVar.getLevel())).registryAccess(), (ResourceLocation) it.next())).withStyle(ChatFormatting.DARK_GREEN));
            }
        } else {
            player.sendSystemMessage(Component.literal("Для данной ноды нет поддерживаемых настроек").withStyle(ChatFormatting.YELLOW));
        }
        bVar.setChanged();
        bVar.k();
    }

    public static b a(ItemStack itemStack) {
        return (b) itemStack.getOrDefault(MCTechDataComponent.PROBE_STATE, b.PROBE);
    }

    public static void a(Player player, ItemStack itemStack, b bVar) {
        if (!itemStack.is(MCTechItems.CONDUIT_PROBE)) {
            throw new IllegalArgumentException("Invalid item passed to setState.");
        }
        itemStack.set(MCTechDataComponent.PROBE_STATE, bVar);
    }

    public static void a(Player player, ItemStack itemStack) {
        if (!itemStack.is(MCTechItems.CONDUIT_PROBE)) {
            throw new IllegalArgumentException("Invalid item passed to switchState.");
        }
        b bVar = b.values()[(a(itemStack).ordinal() + 1) % b.values().length];
        a(player, itemStack, bVar);
        player.displayClientMessage(Component.literal("Режим переключен в ").append(Component.literal(bVar.toString()).withStyle(ChatFormatting.LIGHT_PURPLE)), true);
    }

    private Component a(HolderLookup.Provider provider, ResourceLocation resourceLocation) {
        Optional optionalLookup = provider.lookup(l.a.f);
        if (optionalLookup.isPresent()) {
            return (Component) ((HolderLookup.RegistryLookup) optionalLookup.get()).get(ResourceKey.create(l.a.f, resourceLocation)).map(reference -> {
                return ((mctech.g.a.a) reference.value()).b().copy();
            }).orElse(Component.literal("<UNK>").withStyle(ChatFormatting.RED));
        }
        return Component.literal("<UNK>").withStyle(ChatFormatting.RED);
    }

    private Component a(Field field, mctech.g.a.c.c cVar) {
        StringBuilder sb = new StringBuilder();
        sb.append(" - ").append(field.getName()).append(": ");
        try {
            field.setAccessible(true);
            sb.append(field.get(cVar));
        } catch (IllegalAccessException e) {
            sb.append(": <unable to access>");
        }
        sb.append("\n");
        return Component.literal(sb.toString()).withStyle(ChatFormatting.GRAY);
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/b/c$b.class */
    public enum b {
        PROBE,
        COPY_PASTE;

        public static final Codec<b> c = Codec.STRING.xmap(b::valueOf, (v0) -> {
            return v0.name();
        });
        public static final StreamCodec<RegistryFriendlyByteBuf, b> d = ByteBufCodecs.STRING_UTF8.map(b::valueOf, (v0) -> {
            return v0.name();
        }).cast();

        /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
        @Override // java.lang.Enum
        public String toString() throws MatchException {
            switch (this) {
                case PROBE:
                    return "тестирование";
                case COPY_PASTE:
                    return "копировать/вставить";
                default:
                    throw new MatchException((String) null, (Throwable) null);
            }
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/b/c$a.class */
    public static final class a extends Record {
        private final Map<ResourceLocation, mctech.g.a.c.c> c;
        public static final Codec<a> a = RecordCodecBuilder.create(instance -> {
            return instance.group(Codec.unboundedMap(ResourceLocation.CODEC, mctech.g.a.c.c.a).fieldOf("conduit_data").forGetter((v0) -> {
                return v0.a();
            })).apply(instance, a::new);
        });
        public static final StreamCodec<RegistryFriendlyByteBuf, a> b = StreamCodec.composite(ByteBufCodecs.map(HashMap::new, ResourceLocation.STREAM_CODEC, mctech.g.a.c.c.b), (v0) -> {
            return v0.a();
        }, a::new);

        public a(Map<ResourceLocation, mctech.g.a.c.c> map) {
            this.c = map;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "conduitData", "FIELD:Lmctech/g/d/b/c$a;->c:Ljava/util/Map;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "conduitData", "FIELD:Lmctech/g/d/b/c$a;->c:Ljava/util/Map;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "conduitData", "FIELD:Lmctech/g/d/b/c$a;->c:Ljava/util/Map;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        public Map<ResourceLocation, mctech.g.a.c.c> a() {
            return this.c;
        }
    }
}
