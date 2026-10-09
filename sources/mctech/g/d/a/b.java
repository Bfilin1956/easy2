package mctech.g.d.a;

import com.google.common.base.Preconditions;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.Sets;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import mctech.g.a.i;
import mctech.g.a.j;
import mctech.g.a.k;
import net.minecraft.CrashReportCategory;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.ChunkPos;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/a/b.class */
public class b extends mctech.l.c<b, c> implements i {
    public static final Codec<b> a = RecordCodecBuilder.create(instance -> {
        return instance.group(mctech.g.a.a.b.fieldOf("conduit").forGetter(bVar -> {
            return bVar.d;
        }), j.a.optionalFieldOf("context").forGetter(bVar2 -> {
            return (bVar2.e == null || !bVar2.e.a().a()) ? Optional.empty() : Optional.of(bVar2.e);
        })).and(a(instance, c.a)).apply(instance, b::new);
    });
    private final Holder<mctech.g.a.a<?, ?>> d;

    @Nullable
    private j<?> e;
    private final boolean f;
    private boolean g;
    private boolean h;
    private final Set<c> i;
    private final Multimap<Long, c> j;
    private final Set<c> k;
    private final SetMultimap<c, mctech.g.a.c.a> l;
    private final Map<mctech.g.a.c.a, List<mctech.g.a.c.a>> m;
    private final List<mctech.g.a.c.a> n;
    private final List<mctech.g.a.c.a> o;
    private final Set<DyeColor> p;
    private final ListMultimap<DyeColor, mctech.g.a.c.a> q;
    private final ListMultimap<DyeColor, mctech.g.a.c.a> r;
    private final Map<mctech.g.a.c.a, List<mctech.g.a.c.a>> s;
    private final Map<mctech.g.a.c.a, List<mctech.g.a.c.a>> t;

    @Nullable
    private Consumer<b> u;

    public b(Holder<mctech.g.a.a<?, ?>> holder, c cVar) {
        super(cVar);
        this.g = true;
        this.h = true;
        this.i = Sets.newHashSet();
        this.j = HashMultimap.create();
        this.k = Sets.newHashSet();
        this.l = HashMultimap.create();
        this.m = Maps.newHashMap();
        this.n = Lists.newArrayList();
        this.o = Lists.newArrayList();
        this.p = Sets.newHashSet();
        this.q = ArrayListMultimap.create();
        this.r = ArrayListMultimap.create();
        this.s = Maps.newHashMap();
        this.t = Maps.newHashMap();
        this.u = null;
        this.d = holder;
        this.f = ((mctech.g.a.a) holder.value()).e() != null;
    }

    public b(Holder<mctech.g.a.a<?, ?>> holder, Optional<j<?>> optional, List<c> list, mctech.l.c.a aVar) {
        super(list, aVar);
        this.g = true;
        this.h = true;
        this.i = Sets.newHashSet();
        this.j = HashMultimap.create();
        this.k = Sets.newHashSet();
        this.l = HashMultimap.create();
        this.m = Maps.newHashMap();
        this.n = Lists.newArrayList();
        this.o = Lists.newArrayList();
        this.p = Sets.newHashSet();
        this.q = ArrayListMultimap.create();
        this.r = ArrayListMultimap.create();
        this.s = Maps.newHashMap();
        this.t = Maps.newHashMap();
        this.u = null;
        this.d = holder;
        this.e = optional.orElse(null);
        this.f = ((mctech.g.a.a) holder.value()).e() != null;
    }

    protected b(Holder<mctech.g.a.a<?, ?>> holder) {
        this.g = true;
        this.h = true;
        this.i = Sets.newHashSet();
        this.j = HashMultimap.create();
        this.k = Sets.newHashSet();
        this.l = HashMultimap.create();
        this.m = Maps.newHashMap();
        this.n = Lists.newArrayList();
        this.o = Lists.newArrayList();
        this.p = Sets.newHashSet();
        this.q = ArrayListMultimap.create();
        this.r = ArrayListMultimap.create();
        this.s = Maps.newHashMap();
        this.t = Maps.newHashMap();
        this.u = null;
        this.d = holder;
        this.f = ((mctech.g.a.a) holder.value()).e() != null;
    }

    public Holder<mctech.g.a.a<?, ?>> j() {
        return this.d;
    }

    public Set<Long> k() {
        return this.j.keySet();
    }

    public void a(Consumer<b> consumer) {
        this.u = consumer;
    }

    @Override // mctech.g.a.i
    public boolean a(mctech.g.a.h.a aVar) {
        if (aVar instanceof c) {
            return c((c) aVar);
        }
        return false;
    }

    @Override // mctech.g.a.i
    public Set<? extends mctech.g.a.h.a> b(mctech.g.a.h.a aVar) {
        if (aVar instanceof c) {
            return d((c) aVar);
        }
        return Set.of();
    }

    @Override // mctech.g.a.i
    public Collection<c> d() {
        t();
        Preconditions.checkState(this.f, "This conduit does not support caching as it has no ticker!");
        return Collections.unmodifiableCollection(this.k);
    }

    @Override // mctech.g.a.i
    public Collection<c> e() {
        t();
        Preconditions.checkState(this.f, "This conduit does not support caching as it has no ticker!");
        return Collections.unmodifiableCollection(this.l.keySet());
    }

    @Override // mctech.g.a.i
    public Collection<mctech.g.a.c.a> f() {
        t();
        Preconditions.checkState(this.f, "This conduit does not support caching as it has no ticker!");
        return Collections.unmodifiableCollection(this.l.values());
    }

    @Override // mctech.g.a.i
    public List<mctech.g.a.c.a> a(mctech.g.a.c.a aVar) {
        t();
        Preconditions.checkState(this.f, "This conduit does not support caching as it has no ticker!");
        return this.m.getOrDefault(aVar, List.of());
    }

    @Override // mctech.g.a.i
    public Set<DyeColor> g() {
        t();
        Preconditions.checkState(this.f, "This conduit does not support caching as it has no ticker!");
        return this.p;
    }

    @Override // mctech.g.a.i
    public List<mctech.g.a.c.a> h() {
        t();
        Preconditions.checkState(this.f, "This conduit does not support caching as it has no ticker!");
        return Collections.unmodifiableList(this.n);
    }

    @Override // mctech.g.a.i
    public List<mctech.g.a.c.a> a(DyeColor dyeColor) {
        t();
        Preconditions.checkState(this.f, "This conduit does not support caching as it has no ticker!");
        return this.q.get(dyeColor);
    }

    @Override // mctech.g.a.i
    public List<mctech.g.a.c.a> b(mctech.g.a.c.a aVar) {
        t();
        Preconditions.checkState(this.f, "This conduit does not support caching as it has no ticker!");
        return this.s.getOrDefault(aVar, List.of());
    }

    @Override // mctech.g.a.i
    public List<mctech.g.a.c.a> i() {
        t();
        Preconditions.checkState(this.f, "This conduit does not support caching as it has no ticker!");
        return Collections.unmodifiableList(this.o);
    }

    @Override // mctech.g.a.i
    public List<mctech.g.a.c.a> b(DyeColor dyeColor) {
        t();
        Preconditions.checkState(this.f, "This conduit does not support caching as it has no ticker!");
        return this.r.get(dyeColor);
    }

    @Override // mctech.g.a.i
    public List<mctech.g.a.c.a> c(mctech.g.a.c.a aVar) {
        t();
        Preconditions.checkState(this.f, "This conduit does not support caching as it has no ticker!");
        return this.t.getOrDefault(aVar, List.of());
    }

    @Override // mctech.g.a.i
    public boolean a(k<?> kVar) {
        t();
        return this.e != null && this.e.a() == kVar;
    }

    @Override // mctech.g.a.i
    @Nullable
    public <C extends j<C>> C b(k<C> kVar) {
        t();
        if (this.e != null && this.e.a() == kVar) {
            return (C) this.e;
        }
        return null;
    }

    @Override // mctech.g.a.i
    public <C extends j<C>> C c(k<C> kVar) {
        t();
        if (this.e != null && this.e.a() == kVar) {
            return (C) this.e;
        }
        this.e = (j) kVar.d().get();
        return (C) this.e;
    }

    public void l() {
        t();
        if (!this.f) {
            return;
        }
        if (this.g) {
            w();
        } else {
            for (c cVar : this.i) {
                if (cVar.c()) {
                    if (this.k.contains(cVar)) {
                        e(cVar);
                    }
                    d(cVar);
                } else if (this.k.contains(cVar)) {
                    e(cVar);
                }
            }
            this.i.clear();
        }
        if (this.h) {
            u();
            v();
        }
    }

    public void a(c cVar) {
        if (this.f && !this.g) {
            this.i.add(cVar);
        }
    }

    public void a(long j) {
        if (!this.f || this.g) {
            return;
        }
        this.i.addAll(this.j.get(Long.valueOf(j)));
    }

    private void d(c cVar) {
        this.k.add(cVar);
        for (Direction direction : Direction.values()) {
            if (cVar.a(direction)) {
                mctech.g.a.c.a aVar = new mctech.g.a.c.a(cVar, direction);
                this.l.put(cVar, aVar);
                Iterator<List<mctech.g.a.c.a>> it = this.m.values().iterator();
                while (it.hasNext()) {
                    it.next().add(aVar);
                }
                this.m.computeIfAbsent(aVar, aVar2 -> {
                    return new ArrayList(this.l.values().size());
                });
                for (mctech.g.a.c.a aVar3 : this.l.values()) {
                    if (aVar3 != aVar) {
                        this.m.get(aVar).add(aVar3);
                    }
                }
                mctech.g.a.c.c cVarC = cVar.c(direction);
                if (cVarC instanceof mctech.g.a.c.g) {
                    mctech.g.a.c.g gVar = (mctech.g.a.c.g) cVarC;
                    Objects.requireNonNull(cVar);
                    boolean zA = gVar.a(cVar::a);
                    Objects.requireNonNull(cVar);
                    boolean zB = gVar.b(cVar::a);
                    if (zA) {
                        this.n.add(aVar);
                        this.q.put(gVar.g(), aVar);
                    }
                    if (zB) {
                        this.o.add(aVar);
                        this.r.put(gVar.h(), aVar);
                    }
                    if (zA) {
                        this.s.computeIfAbsent(aVar, aVar4 -> {
                            return new ArrayList();
                        }).addAll(this.r.get(gVar.g()));
                        Iterator it2 = this.r.get(gVar.g()).iterator();
                        while (it2.hasNext()) {
                            this.t.computeIfAbsent((mctech.g.a.c.a) it2.next(), aVar5 -> {
                                return new ArrayList();
                            }).add(aVar);
                        }
                    }
                    if (zB) {
                        this.t.computeIfAbsent(aVar, aVar6 -> {
                            return new ArrayList();
                        }).addAll(this.q.get(gVar.h()));
                        for (mctech.g.a.c.a aVar7 : this.q.get(gVar.h())) {
                            if (aVar7 != aVar) {
                                this.s.computeIfAbsent(aVar7, aVar8 -> {
                                    return new ArrayList();
                                }).add(aVar);
                            }
                        }
                    }
                }
                this.h = true;
            }
        }
    }

    private void e(c cVar) {
        if (!this.k.contains(cVar)) {
            return;
        }
        this.k.remove(cVar);
        for (mctech.g.a.c.a aVar : this.l.get(cVar)) {
            this.m.remove(aVar);
            for (DyeColor dyeColor : DyeColor.values()) {
                this.n.remove(aVar);
                this.o.remove(aVar);
                this.q.remove(dyeColor, aVar);
                this.r.remove(dyeColor, aVar);
            }
            this.s.remove(aVar);
            this.t.remove(aVar);
            Iterator<List<mctech.g.a.c.a>> it = this.m.values().iterator();
            while (it.hasNext()) {
                it.next().remove(aVar);
            }
            Iterator<List<mctech.g.a.c.a>> it2 = this.s.values().iterator();
            while (it2.hasNext()) {
                it2.next().remove(aVar);
            }
            Iterator<List<mctech.g.a.c.a>> it3 = this.t.values().iterator();
            while (it3.hasNext()) {
                it3.next().remove(aVar);
            }
            this.h = true;
        }
        this.l.removeAll(cVar);
    }

    private void u() {
        this.p.clear();
        this.p.addAll(this.q.keySet());
        this.p.addAll(this.r.keySet());
    }

    private void v() {
        Comparator<mctech.g.a.c.a> comparatorI = ((mctech.g.a.a) j().value()).i();
        if (comparatorI != null) {
            this.n.sort(comparatorI);
            this.o.sort(comparatorI);
        }
        for (Map.Entry<mctech.g.a.c.a, List<mctech.g.a.c.a>> entry : this.m.entrySet()) {
            a(entry.getKey(), entry.getValue());
        }
        for (Map.Entry<mctech.g.a.c.a, List<mctech.g.a.c.a>> entry2 : this.s.entrySet()) {
            a(entry2.getKey(), entry2.getValue());
        }
        for (Map.Entry<mctech.g.a.c.a, List<mctech.g.a.c.a>> entry3 : this.t.entrySet()) {
            a(entry3.getKey(), entry3.getValue());
        }
        this.h = false;
    }

    private void w() {
        this.i.clear();
        this.j.clear();
        this.k.clear();
        this.l.clear();
        this.m.clear();
        this.n.clear();
        this.o.clear();
        this.q.clear();
        this.r.clear();
        this.t.clear();
        this.s.clear();
        for (c cVar : c()) {
            a(cVar, true);
            if (cVar.c()) {
                d(cVar);
            }
        }
        u();
        v();
        if (this.u != null) {
            this.u.accept(this);
        }
        this.g = false;
        this.h = false;
    }

    private void a(mctech.g.a.c.a aVar, List<mctech.g.a.c.a> list) {
        list.sort((aVar2, aVar3) -> {
            return ((mctech.g.a.a) this.d.value()).a(aVar, aVar2, aVar3);
        });
    }

    private void a(c cVar, boolean z) {
        long jAsLong = ChunkPos.asLong(cVar.a());
        boolean z2 = !this.j.containsKey(Long.valueOf(jAsLong));
        this.j.put(Long.valueOf(jAsLong), cVar);
        if (!z && z2 && this.u != null) {
            this.u.accept(this);
        }
    }

    private void f(c cVar) {
        long jAsLong = ChunkPos.asLong(cVar.a());
        this.j.remove(Long.valueOf(jAsLong), cVar);
        if ((!this.j.containsKey(Long.valueOf(jAsLong))) && this.u != null) {
            this.u.accept(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mctech.l.c
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public b n() {
        return new b(this.d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mctech.l.c
    public void b(c cVar) {
        if (this.j == null || this.g) {
            return;
        }
        a(cVar, false);
        this.i.add(cVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mctech.l.c
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void a(c cVar) {
        if (this.g) {
            return;
        }
        f(cVar);
        if (!this.g) {
            this.i.add(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mctech.l.c
    public void a(b bVar) {
        if (this.e != null && bVar.e != null) {
            this.e = this.e.a(bVar.x());
        } else if (this.e == null && bVar.e != null) {
            this.e = bVar.e;
        }
        this.g = true;
    }

    private <Z extends j<Z>> Z x() {
        return (Z) Objects.requireNonNull(this.e);
    }

    @Override // mctech.l.c
    protected void a(Set<b> set) {
        this.g = true;
        if (this.e == null) {
            return;
        }
        Set<? extends i> set2 = (Set) Stream.concat(Stream.of(this), set.stream()).collect(Collectors.toSet());
        for (b bVar : set) {
            bVar.e = this.e.a(bVar, set2);
            if (bVar.e == this.e) {
                throw new IllegalStateException("Splitting context for a network of '" + this.d.getRegisteredName() + "' resulted in the same context for multiple networks.");
            }
            bVar.g = true;
        }
        j<?> jVarA = this.e.a(this, set2);
        if (jVarA == this.e) {
            throw new IllegalStateException("Splitting context for a network of '" + this.d.getRegisteredName() + "' resulted in the same context for multiple networks.");
        }
        this.e = jVarA;
    }

    public void a(CrashReportCategory crashReportCategory) {
        crashReportCategory.setDetail("ShouldRebuildCache", Boolean.valueOf(this.g));
        crashReportCategory.setDetail("HaveConnectionsChanged", Boolean.valueOf(this.h));
        crashReportCategory.setDetail("NodeCount", Integer.valueOf(a()));
        crashReportCategory.setDetail("TickingNodeCount", Integer.valueOf(this.k.size()));
        crashReportCategory.setDetail("NodesByChunkPos", Integer.valueOf(this.j.size()));
        crashReportCategory.setDetail("DirtNodes", Integer.valueOf(this.i.size()));
        crashReportCategory.setDetail("AllChannels", Integer.valueOf(this.p.size()));
        crashReportCategory.setDetail("InsertConnections", Integer.valueOf(this.n.size()));
        crashReportCategory.setDetail("ExtractConnections", Integer.valueOf(this.o.size()));
    }
}
