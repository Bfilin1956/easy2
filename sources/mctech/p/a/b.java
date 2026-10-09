package mctech.p.a;

import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.context.UseOnContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/p/a/b.class */
public interface b {
    default InteractionResult a(@NotNull UseOnContext useOnContext) {
        return InteractionResult.SUCCESS;
    }
}
