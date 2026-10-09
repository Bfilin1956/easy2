package mctech.init;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
import java.util.function.IntSupplier;
import java.util.function.ToIntFunction;
import mctech.api.ticks.ITickScheduler;
import mctech.utils.a.b;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.level.Level;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/init/TickScheduler.class */
public class TickScheduler implements ITickScheduler {
    Map<Level, TreeMap<Long, List<ToIntFunction<Level>>>> worldCallbacks = b.e();
    NavigableMap<Long, List<ToIntFunction<MinecraftServer>>> serverCallbacks = b.j();
    NavigableMap<Long, List<IntSupplier>> clientCallbacks = b.j();
    long serverTick = 0;
    long clientTicker = 0;

    @Override // mctech.api.ticks.ITickScheduler
    public void addWorldCallback(Level level, ToIntFunction<Level> toIntFunction) {
        addWorldCallback(level, toIntFunction, 0);
    }

    @Override // mctech.api.ticks.ITickScheduler
    public void addWorldCallback(Level level, ToIntFunction<Level> toIntFunction, int i) {
        if (i < 0) {
            return;
        }
        TreeMap<Long, List<ToIntFunction<Level>>> treeMapJ = this.worldCallbacks.get(level);
        if (treeMapJ == null) {
            treeMapJ = b.j();
            this.worldCallbacks.put(level, treeMapJ);
        }
        long gameTime = level.getGameTime() + ((long) i);
        List<ToIntFunction<Level>> arrayList = treeMapJ.get(Long.valueOf(gameTime));
        if (arrayList == null) {
            arrayList = new ArrayList();
            treeMapJ.put(Long.valueOf(gameTime), arrayList);
        }
        arrayList.add(toIntFunction);
    }

    @Override // mctech.api.ticks.ITickScheduler
    public void addServerCallback(ToIntFunction<MinecraftServer> toIntFunction) {
        addServerCallback(toIntFunction, 0);
    }

    @Override // mctech.api.ticks.ITickScheduler
    public void addServerCallback(ToIntFunction<MinecraftServer> toIntFunction, int i) {
    }

    @Override // mctech.api.ticks.ITickScheduler
    public void addClientCallback(IntSupplier intSupplier) {
        addClientCallback(intSupplier, 0);
    }

    @Override // mctech.api.ticks.ITickScheduler
    public void addClientCallback(IntSupplier intSupplier, int i) {
        if (i < 0) {
            return;
        }
        long j = this.clientTicker + ((long) i);
        List arrayList = (List) this.clientCallbacks.get(Long.valueOf(j));
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.clientCallbacks.put(Long.valueOf(j), arrayList);
        }
        arrayList.add(intSupplier);
    }

    public void onWorldTick(Level level) {
    }

    public void onClientTick() {
        this.clientTicker++;
        while (!this.serverCallbacks.isEmpty()) {
            Map.Entry<Long, List<IntSupplier>> entryFirstEntry = this.clientCallbacks.firstEntry();
            if (entryFirstEntry.getKey().longValue() > this.clientTicker) {
                return;
            }
            List<IntSupplier> value = entryFirstEntry.getValue();
            this.serverCallbacks.pollFirstEntry();
            for (IntSupplier intSupplier : value) {
                int asInt = intSupplier.getAsInt();
                if (asInt > 0) {
                    addClientCallback(intSupplier, asInt);
                }
            }
        }
    }

    public void onWorldUnload(Level level) {
        this.worldCallbacks.remove(level);
    }

    public void onServerTick(MinecraftServer minecraftServer) {
    }

    public void onServerStopped() {
    }
}
