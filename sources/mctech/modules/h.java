package mctech.modules;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import mctech.items.base.l;
import mctech.items.v;
import mctech.modules.config.ModularItemTierConfig;
import mctech.modules.config.ModuleConfig;
import net.minecraft.core.DefaultedRegistry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/modules/h.class */
public final class h {
    private static final h a = new h();
    private final Map<ResourceLocation, e<?>> b = new LinkedHashMap();
    private final Map<e<?>, a<?>> c = new LinkedHashMap();
    private final Multimap<e<?>, ResourceLocation> d = HashMultimap.create();
    private final Multimap<e<?>, e<?>> e = HashMultimap.create();
    private final Map<ResourceLocation, l> f = new LinkedHashMap();
    private final Map<l, ModularItemTierConfig> g = new LinkedHashMap();

    public <C extends ModuleConfig> void a(@Nonnull e<C> eVar, @Nonnull C c, int i) {
        this.b.put(eVar.a(), eVar);
        g<C> gVar = new g<>(eVar, c, i);
        this.c.computeIfAbsent(eVar, eVar2 -> {
            return new a(gVar);
        }).b(i, gVar);
    }

    public synchronized <C extends ModuleConfig> void a(@Nonnull e<C> eVar, @Nonnull C c, int i, @Nonnull ResourceLocation resourceLocation) {
        a(eVar, c, i);
        this.d.put(eVar, resourceLocation);
    }

    public synchronized void a(@Nonnull e<?>... eVarArr) {
        for (int i = 0; i < eVarArr.length; i++) {
            e<?> eVar = eVarArr[i];
            for (int i2 = 0; i2 < eVarArr.length; i2++) {
                if (i2 != i) {
                    this.e.put(eVar, eVarArr[i2]);
                }
            }
        }
    }

    public boolean a(@Nonnull e<?> eVar, @Nonnull e<?> eVar2) {
        return this.e.get(eVar).contains(eVar2);
    }

    public boolean a(@Nonnull e<?> eVar, @Nonnull Collection<? extends e<?>> collection) {
        Collection collection2 = this.e.get(eVar);
        Iterator<? extends e<?>> it = collection.iterator();
        while (it.hasNext()) {
            if (collection2.contains(it.next())) {
                return true;
            }
        }
        return false;
    }

    public <C extends ModuleConfig> C a(@Nonnull e<C> eVar, int i) {
        return (C) this.c.get(eVar).a(i).b();
    }

    public <C extends ModuleConfig> C a(@Nonnull e<C> eVar) {
        return (C) a(eVar, 1);
    }

    public synchronized void a(@Nonnull l lVar, @Nonnull ModularItemTierConfig modularItemTierConfig) {
        this.f.put(lVar.d(), lVar);
        this.g.put(lVar, modularItemTierConfig);
    }

    public ModularItemTierConfig a(@Nonnull l lVar) {
        if (lVar instanceof v) {
            return ((v) lVar).f();
        }
        return this.g.get(lVar);
    }

    public ModularItemTierConfig b(@Nonnull l lVar) {
        return this.g.get(lVar);
    }

    public l a(@Nonnull ResourceLocation resourceLocation) {
        return this.f.get(resourceLocation);
    }

    @Nonnull
    public Set<e<?>> a(@Nonnull String str) {
        return (Set) this.c.keySet().stream().filter(eVar -> {
            return eVar.a().getNamespace().equals(str);
        }).collect(Collectors.toSet());
    }

    @Nonnull
    public Set<l> b(@Nonnull String str) {
        return (Set) this.f.values().stream().filter(lVar -> {
            return lVar.d().getNamespace().equals(str);
        }).collect(Collectors.toSet());
    }

    @Nonnull
    public Set<l> c(@Nonnull String str) {
        return (Set) this.f.values().stream().filter(lVar -> {
            return lVar.d().getPath().startsWith(str);
        }).collect(Collectors.toSet());
    }

    @Nonnull
    public Collection<g<?>> d(@Nonnull String str) {
        return (Collection) this.c.values().stream().flatMap(aVar -> {
            return aVar.a.values().stream();
        }).filter(gVar -> {
            return gVar.a().a().getNamespace().equals(str);
        }).collect(Collectors.toSet());
    }

    @Nonnull
    public <T extends l> Collection<T> a(@Nonnull Class<T> cls) {
        Stream<l> stream = this.g.keySet().stream();
        Objects.requireNonNull(cls);
        Stream<l> streamFilter = stream.filter((v1) -> {
            return r1.isInstance(v1);
        });
        Objects.requireNonNull(cls);
        return (Collection) streamFilter.map((v1) -> {
            return r1.cast(v1);
        }).collect(Collectors.toSet());
    }

    @Nonnull
    public <C extends ModuleConfig> Collection<g<C>> b(@Nonnull e<C> eVar) {
        return (Collection) ((a) this.c.get(eVar)).a.int2ObjectEntrySet().stream().sorted(Comparator.comparingInt((v0) -> {
            return v0.getIntKey();
        })).map((v0) -> {
            return v0.getValue();
        }).collect(Collectors.toList());
    }

    public int c(@Nonnull e<?> eVar) {
        a<?> aVar = this.c.get(eVar);
        if (aVar == null) {
            return 0;
        }
        return ((a) aVar).a.size();
    }

    public e<?> b(@Nonnull ResourceLocation resourceLocation) {
        return this.b.get(resourceLocation);
    }

    @Nonnull
    public mctech.q.d.i c(@Nullable ResourceLocation resourceLocation) {
        return new mctech.q.d.i((Set) this.c.values().stream().flatMap(aVar -> {
            return aVar.a.values().stream();
        }).collect(Collectors.toSet()), this.g, Optional.ofNullable(resourceLocation));
    }

    public synchronized void a(@Nonnull mctech.q.d.i iVar) {
        if (iVar.c().isPresent()) {
            this.g.entrySet().removeIf(entry -> {
                return ((l) entry.getKey()).d().equals(iVar.c().get());
            });
            this.c.forEach((eVar, aVar) -> {
                if (eVar.a().equals(iVar.c().get())) {
                    aVar.a.clear();
                }
            });
        } else {
            this.g.clear();
            this.c.forEach((eVar2, aVar2) -> {
                aVar2.a.clear();
            });
        }
        this.g.putAll(iVar.b());
        iVar.a().forEach(gVar -> {
            this.c.get(gVar.a()).a(gVar.c(), gVar);
        });
    }

    @Nonnull
    public Collection<ResourceLocation> c(@Nonnull l lVar) {
        ArrayList arrayList = new ArrayList();
        this.c.values().stream().flatMap(aVar -> {
            return aVar.a.values().stream();
        }).filter(gVar -> {
            return gVar.b().tier() == lVar;
        }).forEach(gVar2 -> {
            for (ResourceLocation resourceLocation : this.d.get(gVar2.a())) {
                Item item = (Item) BuiltInRegistries.ITEM.get(resourceLocation);
                if ((item instanceof mctech.items.base.d) && ((mctech.items.base.d) item).b() == gVar2.c()) {
                    arrayList.add(resourceLocation);
                }
            }
        });
        return arrayList;
    }

    @Nullable
    public Item d(@Nonnull e<?> eVar) {
        Stream stream = this.d.get(eVar).stream();
        DefaultedRegistry defaultedRegistry = BuiltInRegistries.ITEM;
        Objects.requireNonNull(defaultedRegistry);
        return (Item) stream.map(defaultedRegistry::get).filter(item -> {
            return (item instanceof mctech.items.base.d) && ((mctech.items.base.d) item).b() == 1;
        }).findFirst().orElse(null);
    }

    public static h a() {
        return a;
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/modules/h$a.class */
    private static class a<C extends ModuleConfig> {

        @Nonnull
        private final Int2ObjectMap<g<C>> a = new Int2ObjectOpenHashMap();

        private a(@Nonnull g<C> gVar) {
            this.a.defaultReturnValue(gVar);
        }

        @Nonnull
        public g<C> a(int i) {
            return (g) this.a.get(i);
        }

        private void a(int i, @Nonnull g<?> gVar) {
            this.a.put(i, gVar);
        }

        private void b(int i, @Nonnull g<C> gVar) {
            this.a.put(i, gVar);
        }
    }
}
