package mctech.m.a;

import mctech.m.b.S;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/a/d.class */
public interface d {
    S createContainer(Player player, InteractionHand interactionHand, Direction direction, int i);

    @OnlyIn(Dist.CLIENT)
    Screen a(Player player, InteractionHand interactionHand, Direction direction, S s);

    boolean c(Player player);

    default boolean a(Player player, InteractionHand interactionHand, Direction direction) {
        return true;
    }

    default void a_(Player player) {
    }
}
