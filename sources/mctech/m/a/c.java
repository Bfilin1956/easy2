package mctech.m.a;

import mctech.api.network.buffer.INetworkDataBuffer;
import mctech.components.ContainerComponent;
import mctech.m.b.S;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/a/c.class */
public interface c {
    boolean a(Player player);

    S a(Player player, int i);

    @OnlyIn(Dist.CLIENT)
    default Screen a(Player player, S s) {
        return new mctech.m.d.a((ContainerComponent) s);
    }

    default void a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
    }

    default void a(String str, INetworkDataBuffer iNetworkDataBuffer, Dist dist) {
    }
}
