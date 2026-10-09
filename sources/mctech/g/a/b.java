package mctech.g.a;

import mctech.init.MCTechBlocks;
import mctech.init.MCTechDataComponent;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/a/b.class */
public class b {
    public static ItemStack a(Holder<a<?, ?>> holder, int i) {
        ItemStack itemStack = new ItemStack(MCTechBlocks.CONDUIT.asItem(), i);
        itemStack.set(MCTechDataComponent.CONDUIT, holder);
        return itemStack;
    }

    public static ItemStack a(@NotNull HolderLookup.Provider provider, @NotNull ResourceKey<a<?, ?>> resourceKey, int i) {
        ItemStack itemStack = new ItemStack(MCTechBlocks.CONDUIT.asItem(), i);
        provider.lookup(l.a.f).flatMap(registryLookup -> {
            return registryLookup.get(resourceKey);
        }).ifPresent(reference -> {
            itemStack.set(MCTechDataComponent.CONDUIT, reference);
        });
        return itemStack;
    }

    public static ItemStack a(@NotNull HolderLookup.Provider provider, @NotNull ResourceLocation resourceLocation, int i) {
        return a(provider, (ResourceKey<a<?, ?>>) ResourceKey.create(l.a.f, resourceLocation), i);
    }

    public static int a(Holder<a<?, ?>> holder) {
        return mctech.g.d.a.f.a(holder);
    }

    public static <T extends a<T, ?>> int a(@NotNull Holder<a<?, ?>> holder, @NotNull Holder<a<?, ?>> holder2) {
        return a((a) holder.value(), (a<?, ?>) holder2.value());
    }

    public static <T extends a<T, ?>> int a(@NotNull a<T, ?> aVar, @NotNull a<?, ?> aVar2) {
        return aVar.compareTo(aVar2);
    }
}
