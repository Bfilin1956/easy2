package mctech.g.a;

import com.mojang.serialization.Codec;
import java.util.Comparator;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import mctech.g.a.a;
import mctech.g.a.c.c;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.RegistryFixedCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipProvider;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.capabilities.BlockCapability;
import org.apache.commons.lang3.NotImplementedException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector2i;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/a/a.class */
public interface a<TConduit extends a<TConduit, TConnectionConfig>, TConnectionConfig extends mctech.g.a.c.c> extends Comparable<TConduit>, mctech.g.a.i.a, TooltipProvider {
    public static final Codec<a<?, ?>> a = l.a.byNameCodec().dispatch((v0) -> {
        return v0.d();
    }, (v0) -> {
        return v0.a();
    });
    public static final Codec<Holder<a<?, ?>>> b = RegistryFixedCodec.create(l.a.f);
    public static final StreamCodec<RegistryFriendlyByteBuf, Holder<a<?, ?>>> c = ByteBufCodecs.holderRegistry(l.a.f);
    public static final int d = 0;
    public static final int e = 1;

    ResourceLocation a();

    Component b();

    m<TConduit> d();

    @Nullable
    mctech.g.a.k.a<TConduit> e();

    mctech.g.a.c.e<TConnectionConfig> f();

    boolean g();

    boolean a(Level level, BlockPos blockPos, Direction direction);

    default int c() {
        return 5;
    }

    @Nullable
    default <TCapability, TContext> TCapability a(Level level, @Nullable mctech.g.a.h.a aVar, BlockCapability<TCapability, TContext> blockCapability, @Nullable TContext tcontext) {
        return null;
    }

    default boolean a(TConduit tconduit) {
        return false;
    }

    default boolean b(TConduit tconduit) {
        return equals(tconduit);
    }

    default boolean h() {
        return false;
    }

    default boolean a(mctech.g.a.h.a aVar, mctech.g.a.h.a aVar2) {
        return true;
    }

    default int a(mctech.g.a.c.a aVar, mctech.g.a.c.a aVar2, mctech.g.a.c.a aVar3) {
        return Integer.compare(aVar.a().distManhattan(aVar2.a()), aVar.a().distManhattan(aVar3.a()));
    }

    @Nullable
    default Comparator<mctech.g.a.c.a> i() {
        return null;
    }

    default boolean j() {
        return false;
    }

    default boolean b(Level level, BlockPos blockPos, Direction direction) {
        return a(level, blockPos, direction);
    }

    default void a(mctech.g.a.h.a aVar, Level level, BlockPos blockPos, @Nullable Player player) {
    }

    default void a(mctech.g.a.h.a aVar, Level level, BlockPos blockPos) {
    }

    default void a(@Nullable mctech.g.a.h.a aVar, Level level, BlockPos blockPos, Set<Direction> set) {
    }

    default void b(mctech.g.a.h.a aVar, mctech.g.a.h.a aVar2) {
    }

    default int k() {
        return 0;
    }

    default boolean a(int i, ItemStack itemStack) {
        return true;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.commons.lang3.NotImplementedException */
    default Vector2i a(int i) throws NotImplementedException {
        if (k() > 0) {
            throw new NotImplementedException("This conduit has an inventory, but getSlotPosition has not been implemented!");
        }
        throw new UnsupportedOperationException("This conduit does not have an inventory.");
    }

    @Deprecated(since = "8.0.0")
    default int a(mctech.g.f.k kVar) {
        return -1;
    }

    @Nullable
    default CompoundTag a(c cVar, mctech.g.a.h.a aVar, Direction direction) {
        return null;
    }

    @Nullable
    default CompoundTag a(c cVar, mctech.g.a.h.a aVar) {
        return null;
    }

    default void addToTooltip(@NotNull Item.TooltipContext tooltipContext, @NotNull Consumer<Component> consumer, @NotNull TooltipFlag tooltipFlag) {
    }

    default boolean l() {
        return false;
    }

    default boolean m() {
        return false;
    }

    @Deprecated(since = "8.0.0")
    default TConnectionConfig a(boolean z, boolean z2, DyeColor dyeColor, DyeColor dyeColor2, mctech.g.a.f.a aVar, DyeColor dyeColor3) {
        return (TConnectionConfig) f().a();
    }

    @Deprecated(since = "8.0.0")
    default void a(mctech.g.a.h.a aVar, mctech.g.f.b bVar, BiConsumer<Direction, mctech.g.a.c.c> biConsumer) {
    }

    @Override // mctech.g.a.i.a
    default void a(@NotNull Level level, @NotNull BlockPos blockPos, @NotNull Player player, Holder<a<?, ?>> holder) {
        BlockEntity blockEntity = level.getBlockEntity(blockPos);
        if (blockEntity instanceof mctech.g.d.a.a.b) {
            mctech.g.d.a.b bVarK = ((mctech.g.d.a.a.b) blockEntity).b(holder).l();
            Set<Long> setK = bVarK.k();
            MutableComponent mutableComponentEmpty = Component.empty();
            mutableComponentEmpty.append("---- Проводник ----").withStyle(ChatFormatting.GOLD);
            mutableComponentEmpty.append("\n").append(Component.literal("Тип: ").withStyle(ChatFormatting.GRAY)).append(b().copy().withStyle(ChatFormatting.LIGHT_PURPLE));
            a(level, mutableComponentEmpty);
            mutableComponentEmpty.append("\n").append("---- Сеть ----").withStyle(ChatFormatting.GOLD);
            mutableComponentEmpty.append("\n").append(a("Занятые чанки", String.format("%s шт", Integer.valueOf(setK.size()))));
            mutableComponentEmpty.append("\n").append(a("Каналы", String.format("%s шт", Integer.valueOf(bVarK.g().size()))));
            mutableComponentEmpty.append("\n").append(a("Все ноды", String.format("%s шт", Integer.valueOf(bVarK.a()))));
            mutableComponentEmpty.append("\n").append(a("Тикающие ноды", String.format("%s шт", Integer.valueOf(bVarK.d().size()))));
            mutableComponentEmpty.append("\n").append(a("Подключенные ноды", String.format("%s шт", Integer.valueOf(bVarK.f().size()))));
            mutableComponentEmpty.append("\n").append(a("Принимающие ноды (активные)", String.format("%s шт", Integer.valueOf(bVarK.h().size()))));
            mutableComponentEmpty.append("\n").append(a("Извлекающие ноды (активные)", String.format("%s шт", Integer.valueOf(bVarK.i().size()))));
            player.sendSystemMessage(mutableComponentEmpty);
        }
    }

    default void a(@NotNull Level level, @NotNull MutableComponent mutableComponent) {
        mutableComponent.append("\n").append(a("Тикрейт", String.format("каждые %s тиков", Integer.valueOf(c()))));
        mutableComponent.append("\n").append(a("Настраиваемый", g() ? "да" : "нет"));
        addToTooltip(Item.TooltipContext.of(level), component -> {
            mutableComponent.append("\n").append(component);
        }, TooltipFlag.NORMAL);
    }

    default Component a(@NotNull String str, @NotNull String str2) {
        return Component.literal(String.format("%s: ", str)).withStyle(ChatFormatting.GRAY).append(Component.literal(str2).withStyle(ChatFormatting.LIGHT_PURPLE));
    }
}
