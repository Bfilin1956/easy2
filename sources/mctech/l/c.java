package mctech.l;

import com.google.common.base.Preconditions;
import com.google.common.collect.Queues;
import com.google.common.collect.Sets;
import com.google.common.graph.ElementOrder;
import com.google.common.graph.GraphBuilder;
import com.google.common.graph.MutableGraph;
import com.mojang.datafixers.Products;
import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Stream;
import mctech.l.b;
import mctech.l.c;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/l/c.class */
public abstract class c<TNet extends c<TNet, TNode>, TNode extends b<TNet, TNode>> {
    final MutableGraph<TNode> b;
    boolean c;

    protected abstract TNet n();

    public c(TNode tnode) {
        this(List.of(tnode), List.of());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(List<TNode> list, List<Pair<TNode, TNode>> list2) {
        this.b = GraphBuilder.undirected().allowsSelfLoops(false).nodeOrder(ElementOrder.stable()).incidentEdgeOrder(ElementOrder.stable()).build();
        Preconditions.checkArgument(!list.isEmpty(), "Cannot create a network with no nodes.");
        Preconditions.checkArgument(list.stream().noneMatch((v0) -> {
            return v0.j();
        }), "Some nodes are already in networks.");
        if (list.size() == 1) {
            Preconditions.checkArgument(list2.isEmpty(), "A single node cannot have any edges.");
            b bVar = (b) list.getFirst();
            this.b.addNode(bVar);
            bVar.a(d());
            b(bVar);
            return;
        }
        Preconditions.checkArgument(list2.stream().allMatch(pair -> {
            return list.contains(pair.getFirst()) && list.contains(pair.getSecond());
        }), "Some edges reference nodes that were not included in the node list.");
        for (TNode tnode : list) {
            this.b.addNode(tnode);
            tnode.a(d());
            b(tnode);
        }
        for (Pair<TNode, TNode> pair2 : list2) {
            this.b.putEdge((b) pair2.getFirst(), (b) pair2.getSecond());
            b((b) pair2.getFirst(), (b) pair2.getSecond());
        }
    }

    public c(List<TNode> list, a aVar) {
        this(list, aVar.a(list));
    }

    protected c() {
        this.b = GraphBuilder.undirected().allowsSelfLoops(false).nodeOrder(ElementOrder.stable()).incidentEdgeOrder(ElementOrder.stable()).build();
    }

    public final boolean o() {
        return !this.c;
    }

    public final boolean p() {
        return this.c;
    }

    public final int a() {
        t();
        return this.b.nodes().size();
    }

    public final boolean b() {
        t();
        return this.b.nodes().isEmpty();
    }

    public final boolean c(TNode tnode) {
        t();
        return this.b.nodes().contains(tnode);
    }

    public final Set<TNode> c() {
        t();
        return this.b.nodes();
    }

    public final Set<TNode> d(TNode tnode) {
        t();
        return this.b.adjacentNodes(tnode);
    }

    public final Stream<Pair<TNode, TNode>> q() {
        return this.b.edges().stream().map(endpointPair -> {
            return Pair.of((b) endpointPair.nodeU(), (b) endpointPair.nodeV());
        });
    }

    public final void a(TNode tnode, TNode tnode2) {
        a(tnode, tnode2, (Consumer) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(TNode tnode, TNode tnode2, @Nullable Consumer<TNet> consumer) {
        t();
        Preconditions.checkArgument(tnode.j(), "Node is not valid");
        Preconditions.checkArgument(tnode != tnode2, "Cannot connect a node to itself.");
        Preconditions.checkArgument(c(tnode), "Node is not in this graph.");
        if (tnode2.j()) {
            a(tnode2.l(), consumer);
        } else {
            tnode2.a(d());
            this.b.addNode(tnode2);
            b(tnode2);
        }
        this.b.putEdge(tnode, tnode2);
        b(tnode, tnode2);
    }

    public final void a(TNode tnode, List<TNode> list) {
        a(tnode, list, (Consumer) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(TNode tnode, List<TNode> list, @Nullable Consumer<TNet> consumer) {
        t();
        Preconditions.checkArgument(tnode.j(), "Node is not valid");
        Preconditions.checkArgument(c(tnode), "Node is not in this graph.");
        HashSet hashSetNewHashSet = Sets.newHashSet();
        Iterator<TNode> it = list.iterator();
        while (it.hasNext()) {
            TNode next = it.next();
            Preconditions.checkArgument(next != tnode, "Cannot connect a node to itself.");
            if (next.j() && next.l() != this) {
                hashSetNewHashSet.add(next.l());
            }
        }
        Iterator it2 = hashSetNewHashSet.iterator();
        while (it2.hasNext()) {
            a((c) it2.next(), consumer);
        }
        for (TNode tnode2 : list) {
            if (!tnode2.j()) {
                tnode2.a(d());
                this.b.addNode(tnode2);
                b(tnode2);
            }
            this.b.putEdge(tnode, tnode2);
            b(tnode, tnode2);
        }
    }

    protected void b(TNode tnode) {
    }

    protected void b(TNode tnode, TNode tnode2) {
    }

    public final void c(TNode tnode, TNode tnode2) {
        b(tnode, tnode2, null);
    }

    public final void b(TNode tnode, TNode tnode2, @Nullable Consumer<TNet> consumer) {
        t();
        Preconditions.checkArgument(tnode != tnode2, "Cannot disconnect a node from itself");
        Preconditions.checkArgument(tnode.j(), "Node 1 is not valid");
        Preconditions.checkArgument(tnode2.j(), "Node 2 is not valid");
        Preconditions.checkArgument(c(tnode), "Node 1 does not belong to this network");
        Preconditions.checkArgument(c(tnode2), "Node 2 does not belong to this network");
        this.b.removeEdge(tnode, tnode2);
        a(consumer);
        d(tnode, tnode2);
    }

    protected void d(TNode tnode, TNode tnode2) {
    }

    public final void e(TNode tnode) {
        a(tnode, (Consumer) null);
    }

    public final void a(TNode tnode, @Nullable Consumer<TNet> consumer) {
        t();
        Preconditions.checkArgument(tnode.j(), "Node is not valid");
        Preconditions.checkArgument(c(tnode), "Node does not belong to this network");
        this.b.removeNode(tnode);
        tnode.a(null);
        a(consumer);
        a(tnode);
    }

    protected void a(TNode tnode) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void a(TNet tnet, @Nullable Consumer<TNet> consumer) {
        if (tnet == this) {
            return;
        }
        Set setNodes = tnet.b.nodes();
        MutableGraph<TNode> mutableGraph = this.b;
        Objects.requireNonNull(mutableGraph);
        setNodes.forEach((v1) -> {
            r1.addNode(v1);
        });
        Set setEdges = tnet.b.edges();
        MutableGraph<TNode> mutableGraph2 = this.b;
        Objects.requireNonNull(mutableGraph2);
        setEdges.forEach(mutableGraph2::putEdge);
        Iterator it = tnet.b.nodes().iterator();
        while (it.hasNext()) {
            ((b) it.next()).a(d());
        }
        a(tnet);
        tnet.c = true;
        if (consumer != null) {
            consumer.accept(tnet);
        }
    }

    protected void a(TNet tnet) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void a(@Nullable Consumer<TNet> consumer) {
        if (this.b.nodes().isEmpty()) {
            return;
        }
        HashSet hashSetNewHashSet = Sets.newHashSet(this.b.nodes());
        HashSet hashSetNewHashSet2 = Sets.newHashSet();
        ArrayDeque arrayDequeNewArrayDeque = Queues.newArrayDeque();
        b bVar = (b) hashSetNewHashSet.iterator().next();
        arrayDequeNewArrayDeque.add(bVar);
        hashSetNewHashSet2.add(bVar);
        hashSetNewHashSet.remove(bVar);
        while (!arrayDequeNewArrayDeque.isEmpty()) {
            for (b bVar2 : this.b.adjacentNodes((b) arrayDequeNewArrayDeque.poll())) {
                if (!hashSetNewHashSet2.contains(bVar2)) {
                    hashSetNewHashSet2.add(bVar2);
                    arrayDequeNewArrayDeque.add(bVar2);
                    hashSetNewHashSet.remove(bVar2);
                }
            }
        }
        if (hashSetNewHashSet.isEmpty()) {
            return;
        }
        HashSet hashSetNewHashSet3 = Sets.newHashSet();
        while (!hashSetNewHashSet.isEmpty()) {
            c cVarN = n();
            b bVar3 = (b) hashSetNewHashSet.iterator().next();
            arrayDequeNewArrayDeque.add(bVar3);
            hashSetNewHashSet2.add(bVar3);
            hashSetNewHashSet.remove(bVar3);
            while (!arrayDequeNewArrayDeque.isEmpty()) {
                b bVar4 = (b) arrayDequeNewArrayDeque.poll();
                for (b bVar5 : this.b.adjacentNodes(bVar4)) {
                    if (!hashSetNewHashSet2.contains(bVar5)) {
                        hashSetNewHashSet2.add(bVar5);
                        arrayDequeNewArrayDeque.add(bVar5);
                        hashSetNewHashSet.remove(bVar5);
                    }
                }
                cVarN.b.addNode(bVar4);
                Set setIncidentEdges = this.b.incidentEdges(bVar4);
                MutableGraph<TNode> mutableGraph = cVarN.b;
                Objects.requireNonNull(mutableGraph);
                setIncidentEdges.forEach(mutableGraph::putEdge);
                this.b.removeNode(bVar4);
                bVar4.a(cVarN);
            }
            hashSetNewHashSet3.add(cVarN);
            if (consumer != 0) {
                consumer.accept(cVarN);
            }
        }
        a(hashSetNewHashSet3);
    }

    protected void a(Set<TNet> set) {
    }

    protected static <TNet extends c<TNet, TNode>, TNode extends b<TNet, TNode>> Products.P2<RecordCodecBuilder.Mu<TNet>, List<TNode>, a> a(RecordCodecBuilder.Instance<TNet> instance, Codec<TNode> codec) {
        return instance.group(codec.listOf().fieldOf("nodes").forGetter((v0) -> {
            return v0.r();
        }), a.a.fieldOf("edges").forGetter((v0) -> {
            return v0.s();
        }));
    }

    public List<TNode> r() {
        return List.copyOf(c());
    }

    public a s() {
        List<TNode> listR = r();
        return new a(q().map(pair -> {
            return Pair.of(Integer.valueOf(listR.indexOf(pair.getFirst())), Integer.valueOf(listR.indexOf(pair.getSecond())));
        }).toList());
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/l/c$a.class */
    public static final class a extends Record {
        private final List<Pair<Integer, Integer>> b;
        private static final Codec<Pair<Integer, Integer>> c = RecordCodecBuilder.create(instance -> {
            return instance.group(Codec.INT.fieldOf("first").forGetter((v0) -> {
                return v0.getFirst();
            }), Codec.INT.fieldOf("second").forGetter((v0) -> {
                return v0.getSecond();
            })).apply(instance, (v0, v1) -> {
                return Pair.of(v0, v1);
            });
        });
        public static final Codec<a> a = c.listOf().xmap(a::new, (v0) -> {
            return v0.a();
        });

        public a(List<Pair<Integer, Integer>> list) {
            this.b = list;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "edges", "FIELD:Lmctech/l/c$a;->b:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "edges", "FIELD:Lmctech/l/c$a;->b:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "edges", "FIELD:Lmctech/l/c$a;->b:Ljava/util/List;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        public List<Pair<Integer, Integer>> a() {
            return this.b;
        }

        public <TNode extends b<? extends c<?, TNode>, TNode>> List<Pair<TNode, TNode>> a(List<TNode> list) {
            return this.b.stream().map(pair -> {
                return Pair.of((b) list.get(((Integer) pair.getFirst()).intValue()), (b) list.get(((Integer) pair.getSecond()).intValue()));
            }).toList();
        }
    }

    protected final void t() {
        Preconditions.checkState(!this.c, "Cannot use a discarded network.");
    }

    private TNet d() {
        return this;
    }
}
