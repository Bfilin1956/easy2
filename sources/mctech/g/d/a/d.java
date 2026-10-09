package mctech.g.d.a;

import com.google.common.base.Preconditions;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.mojang.datafixers.util.Pair;
import com.mojang.logging.LogUtils;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapLike;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import mctech.g.a.j;
import mctech.g.a.k;
import mctech.g.a.l;
import net.minecraft.CrashReport;
import net.minecraft.ReportedException;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.Registry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.nbt.Tag;
import net.minecraft.resources.RegistryOps;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.saveddata.SavedData;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.level.ChunkEvent;
import net.neoforged.neoforge.event.tick.LevelTickEvent;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/a/d.class */
@EventBusSubscriber
public class d extends SavedData {
    private final Multimap<Holder<mctech.g.a.a<?, ?>>, b> b = HashMultimap.create();
    private final Multimap<Long, b> c = HashMultimap.create();
    private final Multimap<b, Long> d = HashMultimap.create();
    private final Map<Long, Boolean> e = Maps.newHashMap();
    private final Map<Holder<mctech.g.a.a<?, ?>>, Map<BlockPos, c>> f = Maps.newHashMap();
    private static final String g = "Networks";
    private static final String i = "Graphs";
    private static final String j = "Type";
    private static final String k = "GraphObjects";
    private static final String l = "GraphConnections";
    private static final String m = "GraphContext";
    public static final Codec<d> a = b.a.listOf().xmap(d::new, (v0) -> {
        return v0.a();
    });
    private static final Logger h = LogUtils.getLogger();

    public static d a(ServerLevel serverLevel) {
        return (d) serverLevel.getDataStorage().computeIfAbsent(new SavedData.Factory(d::new, d::a), "mctech_conduit_network");
    }

    public d() {
    }

    private d(List<b> list) {
        for (b bVar : list) {
            bVar.a(this::c);
            this.b.put(bVar.j(), bVar);
            for (c cVar : bVar.c()) {
                this.f.computeIfAbsent(bVar.j(), holder -> {
                    return Maps.newHashMap();
                }).put(cVar.a(), cVar);
            }
        }
    }

    private static d a(CompoundTag compoundTag, HolderLookup.Provider provider) {
        if (compoundTag.contains(i)) {
            return b(compoundTag, provider);
        }
        return (d) a.parse(provider.createSerializationContext(NbtOps.INSTANCE), compoundTag.get(g)).getPartialOrThrow();
    }

    private List<b> a() {
        return this.b.values().stream().filter(bVar -> {
            return bVar.o() && !bVar.b();
        }).toList();
    }

    public CompoundTag save(CompoundTag compoundTag, HolderLookup.Provider provider) {
        compoundTag.put(g, (Tag) a.encodeStart(provider.createSerializationContext(NbtOps.INSTANCE), this).getOrThrow());
        return compoundTag;
    }

    @Nullable
    public c a(Holder<mctech.g.a.a<?, ?>> holder, BlockPos blockPos) {
        Map<BlockPos, c> map = this.f.get(holder);
        if (map == null) {
            h.warn("Conduit data is missing!");
            return null;
        }
        if (!map.containsKey(blockPos)) {
            h.warn("Conduit data is missing node at {}", blockPos);
            h.warn("Returning defaulted instance for {} at {}", holder.getKey().location(), blockPos);
            return new c(holder, blockPos);
        }
        return map.remove(blockPos);
    }

    public void a(Holder<mctech.g.a.a<?, ?>> holder, BlockPos blockPos, c cVar) {
        this.f.computeIfAbsent(holder, holder2 -> {
            return Maps.newHashMap();
        }).put(blockPos, cVar);
    }

    public static void a(ServerLevel serverLevel, b bVar) {
        a(serverLevel).a(bVar);
    }

    private void a(b bVar) {
        Preconditions.checkArgument(bVar.o(), "New network is not valid!");
        this.b.put(bVar.j(), bVar);
        c(bVar);
        bVar.a(this::c);
    }

    public static void b(ServerLevel serverLevel, b bVar) {
        Preconditions.checkArgument(bVar.p(), "Network is not discarded!");
        a(serverLevel).b(bVar);
    }

    private void b(b bVar) {
        this.b.remove(bVar.j(), bVar);
        for (Long l2 : bVar.k()) {
            this.c.remove(l2, bVar);
            this.d.remove(bVar, l2);
        }
    }

    private void c(b bVar) {
        Collection collection = this.d.get(bVar);
        Set<Long> setK = bVar.k();
        List list = collection.stream().filter(l2 -> {
            return !setK.contains(l2);
        }).toList();
        List<Long> list2 = setK.stream().filter(l3 -> {
            return !collection.contains(l3);
        }).toList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            this.c.remove((Long) it.next(), bVar);
        }
        Iterator<Long> it2 = list2.iterator();
        while (it2.hasNext()) {
            this.c.put(it2.next(), bVar);
        }
        this.d.get(bVar).clear();
        this.d.get(bVar).addAll(setK);
    }

    public boolean isDirty() {
        return true;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: net.minecraft.ReportedException */
    @SubscribeEvent
    public static void a(LevelTickEvent.Post post) throws ReportedException {
        ServerLevel level = post.getLevel();
        if (level instanceof ServerLevel) {
            ServerLevel serverLevel = level;
            a(serverLevel).b(serverLevel);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: net.minecraft.ReportedException */
    private void b(ServerLevel serverLevel) throws ReportedException {
        this.b.values().stream().filter(bVar -> {
            return !bVar.o() || bVar.b();
        }).toList().forEach(this::b);
        for (Long l2 : this.c.keySet()) {
            boolean z = serverLevel.hasChunk(ChunkPos.getX(l2.longValue()), ChunkPos.getZ(l2.longValue())) && serverLevel.shouldTickBlocksAt(l2.longValue());
            if (!this.e.containsKey(l2) || z != this.e.get(l2).booleanValue()) {
                this.e.put(l2, Boolean.valueOf(z));
                this.c.get(l2).forEach(bVar2 -> {
                    bVar2.a(l2.longValue());
                });
            }
        }
        Registry registryRegistryOrThrow = serverLevel.registryAccess().registryOrThrow(l.a.f);
        for (Holder<mctech.g.a.a<?, ?>> holder : new HashSet(this.b.keySet())) {
            mctech.g.a.k.a aVarE = ((mctech.g.a.a) holder.value()).e();
            if (aVarE != null) {
                int id = registryRegistryOrThrow.getId((mctech.g.a.a) holder.value());
                if (this.b.containsKey(holder)) {
                    for (b bVar3 : new ArrayList(this.b.get(holder))) {
                        try {
                            a(serverLevel, holder, id, aVarE, bVar3);
                        } catch (Throwable th) {
                            CrashReport crashReportForThrowable = CrashReport.forThrowable(th, "Ticking conduit network");
                            bVar3.a(crashReportForThrowable.addCategory(holder.getRegisteredName() + " network being ticked"));
                            throw new ReportedException(crashReportForThrowable);
                        }
                    }
                } else {
                    continue;
                }
            }
        }
    }

    private <T extends mctech.g.a.a<T, ?>> void a(ServerLevel serverLevel, Holder<mctech.g.a.a<?, ?>> holder, int i2, mctech.g.a.k.a<T> aVar, b bVar) {
        int iC = ((mctech.g.a.a) holder.value()).c();
        if (serverLevel.getGameTime() % ((long) iC) == i2 % iC) {
            bVar.l();
            aVar.a(serverLevel, (mctech.g.a.a) holder.value(), bVar);
        }
    }

    @SubscribeEvent
    public static void a(ChunkEvent.Unload unload) {
        ServerLevel level = unload.getLevel();
        if (level instanceof ServerLevel) {
            a(level).e.remove(Long.valueOf(unload.getChunk().getPos().toLong()));
        }
    }

    private static d b(CompoundTag compoundTag, HolderLookup.Provider provider) {
        d dVar = new d();
        for (CompoundTag compoundTag2 : compoundTag.getList(i, 10)) {
            ResourceKey resourceKeyCreate = ResourceKey.create(l.a.f, ResourceLocation.parse(compoundTag2.getString(j)));
            Optional optional = provider.lookupOrThrow(l.a.f).get(resourceKeyCreate);
            if (optional.isPresent()) {
                a(provider, (Holder) optional.get(), compoundTag2.getList(i, 10), dVar);
            } else {
                h.warn("Skipping graph for missing conduit: {}", resourceKeyCreate);
            }
        }
        return dVar;
    }

    private static void a(HolderLookup.Provider provider, Holder<mctech.g.a.a<?, ?>> holder, ListTag listTag, d dVar) {
        Iterator it = listTag.iterator();
        while (it.hasNext()) {
            CompoundTag compoundTag = (Tag) it.next();
            ListTag list = compoundTag.getList(k, 10);
            ListTag<CompoundTag> list2 = compoundTag.getList(l, 10);
            if (!list.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < list.size(); i2++) {
                    arrayList.add((c) ((Pair) c.a.decode(provider.createSerializationContext(NbtOps.INSTANCE), list.getCompound(i2)).getOrThrow()).getFirst());
                }
                ArrayList arrayList2 = new ArrayList();
                for (CompoundTag compoundTag2 : list2) {
                    arrayList2.add(new Pair(Integer.valueOf(compoundTag2.getInt("0")), Integer.valueOf(compoundTag2.getInt("1"))));
                }
                j<?> jVarA = null;
                if (compoundTag.contains(m)) {
                    jVarA = a(provider, compoundTag.getCompound(m));
                }
                b bVar = new b(holder, Optional.ofNullable(jVarA), arrayList, new mctech.l.c.a(arrayList2));
                if (arrayList.stream().anyMatch(cVar -> {
                    return !cVar.j();
                })) {
                    h.error("Node(s) are still invalid after loading the network. Please report this issue to McSkill, loading cannot continue.");
                    throw new IllegalStateException("Graph was null after loading the conduit network");
                }
                dVar.b.put(holder, bVar);
                for (c cVar2 : bVar.c()) {
                    dVar.f.computeIfAbsent(bVar.j(), holder2 -> {
                        return Maps.newHashMap();
                    }).put(cVar2.a(), cVar2);
                }
            }
        }
    }

    @Nullable
    private static j<?> a(HolderLookup.Provider provider, CompoundTag compoundTag) {
        ResourceLocation resourceLocation = ResourceLocation.parse(compoundTag.getString(j));
        k kVar = (k) Objects.requireNonNull((k) l.c.get(resourceLocation), "Unable to find conduit network context type with key " + String.valueOf(resourceLocation));
        if (kVar.c() == null) {
            return null;
        }
        CompoundTag compound = compoundTag.getCompound(mctech.g.d.a.a.c.e);
        RegistryOps registryOpsCreateSerializationContext = provider.createSerializationContext(NbtOps.INSTANCE);
        return (j) kVar.c().decode(registryOpsCreateSerializationContext, (MapLike) registryOpsCreateSerializationContext.getMap(compound).getOrThrow()).getOrThrow();
    }
}
