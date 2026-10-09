package mctech.i;

import net.mcskill.msregistry.core.IMachineTier;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/i/h.class */
public interface h extends IMachineTier {
    i d();

    MachineTier a(@NotNull BlockState blockState);

    i b(@NotNull BlockState blockState);

    @NotNull
    String V_();

    @NotNull
    String c(@NotNull BlockState blockState);
}
