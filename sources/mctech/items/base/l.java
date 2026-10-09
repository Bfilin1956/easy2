package mctech.items.base;

import com.mojang.datafixers.Products;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Nonnull;
import mctech.modules.config.ModularItemTierConfig;
import mctech.modules.config.ModularItemTierConfigJsonSerializer;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/base/l.class */
public interface l {
    public static final MapCodec<l> i = RecordCodecBuilder.mapCodec(instance -> {
        Products.P1 p1Group = instance.group(ResourceLocation.CODEC.fieldOf("registryName").forGetter((v0) -> {
            return v0.d();
        }));
        mctech.modules.h hVarA = mctech.modules.h.a();
        Objects.requireNonNull(hVarA);
        return p1Group.apply(instance, hVarA::a);
    });
    public static final StreamCodec<ByteBuf, l> j;

    @Nonnull
    ModularItemTierConfig f();

    @Nonnull
    ModularItemTierConfigJsonSerializer<?> b();

    @Nonnull
    ResourceLocation d();

    MachineTier e();

    static {
        StreamCodec streamCodec = ResourceLocation.STREAM_CODEC;
        Function function = (v0) -> {
            return v0.d();
        };
        mctech.modules.h hVarA = mctech.modules.h.a();
        Objects.requireNonNull(hVarA);
        j = StreamCodec.composite(streamCodec, function, hVarA::a);
    }

    default boolean b(@Nonnull ItemStack itemStack) {
        if (itemStack.getItem() instanceof h) {
            return f().getValidBatteryItems().contains(BuiltInRegistries.ITEM.getKey(itemStack.getItem()));
        }
        return false;
    }
}
