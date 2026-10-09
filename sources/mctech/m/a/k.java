package mctech.m.a;

import mctech.components.ContainerComponent;
import mctech.m.b.S;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/a/k.class */
public interface k extends d {
    @Override // mctech.m.a.d
    default boolean c(Player player) {
        return !((BlockEntity) this).isRemoved() && player.isAlive() && player.distanceToSqr(((BlockEntity) this).getBlockPos().getCenter()) <= 64.0d;
    }

    @Override // mctech.m.a.d
    @OnlyIn(Dist.CLIENT)
    default Screen a(Player player, InteractionHand interactionHand, Direction direction, S s) {
        return new mctech.m.d.a((ContainerComponent) s);
    }
}
