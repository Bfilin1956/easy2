package mctech.g.a.c;

import net.minecraft.world.item.DyeColor;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/a/c/b.class */
@FunctionalInterface
public interface b {
    public static final b a = dyeColor -> {
        return false;
    };

    boolean hasRedstoneSignal(@Nullable DyeColor dyeColor);
}
