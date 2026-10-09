package mctech.modules;

import com.mojang.datafixers.Products;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import mctech.modules.config.EnergyCostConfig;
import mctech.modules.config.ModuleConfig;
import mctech.modules.config.ModuleConfigJsonSerializer;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/modules/e.class */
public interface e<C extends ModuleConfig> {
    public static final MapCodec<e<?>> a = RecordCodecBuilder.mapCodec(instance -> {
        Products.P1 p1Group = instance.group(ResourceLocation.CODEC.fieldOf("registryName").forGetter((v0) -> {
            return v0.a();
        }));
        h hVarA = h.a();
        Objects.requireNonNull(hVarA);
        return p1Group.apply(instance, hVarA::b);
    });
    public static final StreamCodec<ByteBuf, e<?>> b;

    @Nonnull
    ResourceLocation a();

    @Nonnull
    ModuleConfigJsonSerializer<C> b();

    int a(int i);

    boolean c();

    static {
        StreamCodec streamCodec = ResourceLocation.STREAM_CODEC;
        Function function = (v0) -> {
            return v0.a();
        };
        h hVarA = h.a();
        Objects.requireNonNull(hVarA);
        b = StreamCodec.composite(streamCodec, function, hVarA::b);
    }

    default void a(@Nonnull mctech.items.base.b bVar, int i) {
    }

    default void b(@Nonnull mctech.items.base.b bVar, int i) {
    }

    default void a(@Nonnull mctech.items.base.d dVar, @Nonnull ItemStack itemStack, @Nullable Level level, @Nonnull List<Component> list, @Nonnull TooltipFlag tooltipFlag) {
        ModuleConfig moduleConfigA = h.a().a(this, dVar.b());
        if (moduleConfigA instanceof EnergyCostConfig) {
            list.add(Component.literal(String.valueOf(ChatFormatting.GOLD) + "Потребление: " + String.valueOf(ChatFormatting.YELLOW) + ((EnergyCostConfig) moduleConfigA).getEnergyCost() + "EU"));
        }
    }

    @Nonnull
    default Component d() {
        return Component.translatable(String.format("configuration.%s.%s.name", a().getNamespace(), a().getPath()));
    }
}
