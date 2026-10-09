package mctech.u.d;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import mctech.u.Y;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeSerializer;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/d/C.class */
public class C implements RecipeSerializer<Y> {
    public static final MapCodec<Y> a = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Codec.FLOAT.fieldOf("chance").forGetter((v0) -> {
            return v0.a();
        }), ItemStack.CODEC.fieldOf("result").forGetter((v0) -> {
            return v0.b();
        })).apply(instance, (v1, v2) -> {
            return new Y(v1, v2);
        });
    });
    public static final StreamCodec<RegistryFriendlyByteBuf, Y> b = StreamCodec.composite(ByteBufCodecs.FLOAT, (v0) -> {
        return v0.a();
    }, ItemStack.STREAM_CODEC, (v0) -> {
        return v0.b();
    }, (v1, v2) -> {
        return new Y(v1, v2);
    });

    public MapCodec<Y> codec() {
        return a;
    }

    public StreamCodec<RegistryFriendlyByteBuf, Y> streamCodec() {
        return b;
    }
}
