package mctech.blockentities.f;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.saveddata.SavedData;
import net.neoforged.fml.util.thread.SidedThreadGroups;
import net.neoforged.neoforge.server.ServerLifecycleHooks;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/f/g.class */
public class g extends SavedData {
    private static final String a = "mctech_teleports";
    private static final String b = "teleports";
    private static final g c = new g();
    private final Map<String, e> d = new ConcurrentHashMap();

    public static g a() {
        MinecraftServer currentServer;
        if (Thread.currentThread().getThreadGroup() == SidedThreadGroups.SERVER && (currentServer = ServerLifecycleHooks.getCurrentServer()) != null) {
            ServerLevel level = currentServer.getLevel(Level.OVERWORLD);
            if (level == null) {
                return c;
            }
            return (g) level.getDataStorage().computeIfAbsent(new SavedData.Factory(g::new, g::a), a);
        }
        return c;
    }

    public static g a(CompoundTag compoundTag, HolderLookup.Provider provider) {
        g gVar = new g();
        CompoundTag compound = compoundTag.getCompound(b);
        for (String str : compound.getAllKeys()) {
            gVar.d.put(str, new e(provider, compound.getCompound(str)));
        }
        return gVar;
    }

    @NotNull
    public CompoundTag save(@NotNull CompoundTag compoundTag, HolderLookup.Provider provider) {
        CompoundTag compoundTag2 = new CompoundTag();
        for (Map.Entry<String, e> entry : this.d.entrySet()) {
            compoundTag2.put(entry.getValue().a(), entry.getValue().serializeNBT(provider));
        }
        compoundTag.put(b, compoundTag2);
        return compoundTag;
    }

    public void a(@NotNull e eVar) {
        this.d.put(eVar.a(), eVar);
        setDirty();
    }

    public void b(@NotNull e eVar) {
        this.d.remove(eVar.a());
        setDirty();
    }

    public Optional<e> a(@NotNull String str) {
        return Optional.ofNullable(this.d.get(str));
    }

    public Optional<e> b(@NotNull String str) {
        return b().filter(eVar -> {
            return eVar.e().equals(str);
        }).findFirst();
    }

    public Optional<e> c(@NotNull String str) {
        return b().filter(eVar -> {
            return eVar.d().equals(str);
        }).findFirst();
    }

    public List<e> d(@NotNull String str) {
        return (List) b().filter(eVar -> {
            return eVar.e().equals(str);
        }).collect(Collectors.toList());
    }

    public List<e> e(@NotNull String str) {
        return (List) b().filter(eVar -> {
            return eVar.d().equals(str);
        }).collect(Collectors.toList());
    }

    public List<e> a(@NotNull UUID uuid) {
        return (List) b().filter(eVar -> {
            return eVar.f().equals(uuid);
        }).collect(Collectors.toList());
    }

    public List<e> a(@NotNull Player player) {
        return a(player.getUUID());
    }

    private Stream<e> b() {
        return this.d.values().stream();
    }
}
