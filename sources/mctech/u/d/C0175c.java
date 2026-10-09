package mctech.u.d;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.ArrayList;
import mctech.u.C0177e;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.neoforged.neoforge.fluids.FluidStack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: mctech.u.d.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/d/c.class */
public class C0175c implements RecipeSerializer<C0177e> {
    public static final MapCodec<C0177e> a = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(ItemStack.CODEC.listOf().optionalFieldOf("ingredients", new ArrayList()).forGetter((v0) -> {
            return v0.a();
        }), FluidStack.CODEC.fieldOf("fluid_ingredient").forGetter((v0) -> {
            return v0.b();
        }), Codec.STRING.listOf().fieldOf("consumables").forGetter((v0) -> {
            return v0.c();
        }), FluidStack.CODEC.fieldOf("result").forGetter((v0) -> {
            return v0.d();
        })).apply(instance, C0177e::new);
    });
    public static final StreamCodec<RegistryFriendlyByteBuf, C0177e> b = StreamCodec.composite(ItemStack.STREAM_CODEC.apply(ByteBufCodecs.list()), (v0) -> {
        return v0.a();
    }, FluidStack.STREAM_CODEC, (v0) -> {
        return v0.b();
    }, ByteBufCodecs.STRING_UTF8.apply(ByteBufCodecs.list()), (v0) -> {
        return v0.c();
    }, FluidStack.STREAM_CODEC, (v0) -> {
        return v0.d();
    }, C0177e::new);

    @NotNull
    public MapCodec<C0177e> codec() {
        return a;
    }

    @NotNull
    public StreamCodec<RegistryFriendlyByteBuf, C0177e> streamCodec() {
        return b;
    }
}
