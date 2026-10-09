package mctech.utils;

import java.util.Optional;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.item.enchantment.Enchantment;
import net.neoforged.neoforge.server.ServerLifecycleHooks;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/y.class */
public class y {
    public static <T, R extends Registry<? extends T>> Optional<Holder.Reference<T>> a(ResourceKey<R> resourceKey, ResourceKey<T> resourceKey2) {
        MinecraftServer currentServer = ServerLifecycleHooks.getCurrentServer();
        return currentServer == null ? Optional.empty() : currentServer.overworld().registryAccess().lookup(resourceKey).flatMap(registryLookup -> {
            return registryLookup.get(resourceKey2);
        });
    }

    public static Optional<Holder.Reference<Enchantment>> a(ResourceKey<Enchantment> resourceKey) {
        return a(Registries.ENCHANTMENT, resourceKey);
    }

    public static <T, R extends Registry<? extends T>> Optional<T> b(ResourceKey<R> resourceKey, ResourceKey<T> resourceKey2) {
        MinecraftServer currentServer = ServerLifecycleHooks.getCurrentServer();
        return currentServer == null ? Optional.empty() : currentServer.overworld().registryAccess().registry(resourceKey).map(registry -> {
            return registry.get(resourceKey2);
        });
    }

    public static Optional<Enchantment> b(ResourceKey<Enchantment> resourceKey) {
        return b(Registries.ENCHANTMENT, resourceKey);
    }
}
