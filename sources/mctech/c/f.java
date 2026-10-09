package mctech.c;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/c/f.class */
public interface f {
    @NotNull
    Level a();

    @NotNull
    Vec3 b();

    default boolean a(Level level) {
        return a(level, a());
    }

    static boolean a(Level level, Level level2) {
        return b(level) == b(level2);
    }

    static ResourceKey<Level> b(Level level) {
        if (level == null) {
            return null;
        }
        return level.dimension();
    }
}
