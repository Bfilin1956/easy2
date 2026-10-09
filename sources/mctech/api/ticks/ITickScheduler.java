package mctech.api.ticks;

import java.util.function.IntSupplier;
import java.util.function.ToIntFunction;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.level.Level;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/ticks/ITickScheduler.class */
public interface ITickScheduler {
    void addWorldCallback(Level level, ToIntFunction<Level> toIntFunction);

    void addWorldCallback(Level level, ToIntFunction<Level> toIntFunction, int i);

    void addServerCallback(ToIntFunction<MinecraftServer> toIntFunction);

    void addServerCallback(ToIntFunction<MinecraftServer> toIntFunction, int i);

    void addClientCallback(IntSupplier intSupplier);

    void addClientCallback(IntSupplier intSupplier, int i);
}
