package mctech.g.a.i;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/a/i/a.class */
public interface a {
    default void a(@NotNull Level level, @NotNull BlockPos blockPos, @NotNull Player player) {
    }

    default void a(@NotNull Level level, @NotNull BlockPos blockPos, @NotNull Player player, Holder<mctech.g.a.a<?, ?>> holder) {
    }
}
