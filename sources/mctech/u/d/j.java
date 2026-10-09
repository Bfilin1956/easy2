package mctech.u.d;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import mctech.u.C0188p;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeSerializer;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/d/j.class */
public class j implements RecipeSerializer<C0188p> {
    public static final MapCodec<C0188p> a = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Codec.list(ItemStack.CODEC).fieldOf("inputs").forGetter((v0) -> {
            return v0.b();
        }), Codec.list(ItemStack.CODEC).fieldOf("results").forGetter((v0) -> {
            return v0.c();
        }), Codec.DOUBLE.fieldOf("energy").forGetter((v0) -> {
            return v0.d();
        }), Codec.INT.fieldOf("cookingtime").forGetter((v0) -> {
            return v0.j();
        })).apply(instance, (v1, v2, v3, v4) -> {
            return new C0188p(v1, v2, v3, v4);
        });
    });
    public static final StreamCodec<RegistryFriendlyByteBuf, C0188p> b = StreamCodec.of((registryFriendlyByteBuf, c0188p) -> {
        registryFriendlyByteBuf.writeInt(c0188p.b().size());
        Iterator<ItemStack> it = c0188p.b().iterator();
        while (it.hasNext()) {
            ItemStack.STREAM_CODEC.encode(registryFriendlyByteBuf, it.next());
        }
        registryFriendlyByteBuf.writeInt(c0188p.c().size());
        Iterator<ItemStack> it2 = c0188p.c().iterator();
        while (it2.hasNext()) {
            ItemStack.STREAM_CODEC.encode(registryFriendlyByteBuf, it2.next());
        }
        registryFriendlyByteBuf.writeDouble(c0188p.d());
        registryFriendlyByteBuf.writeInt(c0188p.j());
    }, registryFriendlyByteBuf2 -> {
        int i = registryFriendlyByteBuf2.readInt();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add((ItemStack) ItemStack.STREAM_CODEC.decode(registryFriendlyByteBuf2));
        }
        int i3 = registryFriendlyByteBuf2.readInt();
        ArrayList arrayList2 = new ArrayList();
        for (int i4 = 0; i4 < i3; i4++) {
            arrayList2.add((ItemStack) ItemStack.STREAM_CODEC.decode(registryFriendlyByteBuf2));
        }
        return new C0188p(arrayList, arrayList2, registryFriendlyByteBuf2.readDouble(), registryFriendlyByteBuf2.readInt());
    });

    public MapCodec<C0188p> codec() {
        return a;
    }

    public StreamCodec<RegistryFriendlyByteBuf, C0188p> streamCodec() {
        return b;
    }
}
