package mctech.utils.c;

import com.google.common.annotations.Beta;
import it.unimi.dsi.fastutil.PriorityQueue;
import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectMaps;
import it.unimi.dsi.fastutil.objects.Object2ObjectSortedMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayFIFOQueue;
import it.unimi.dsi.fastutil.objects.ObjectArrayPriorityQueue;
import it.unimi.dsi.fastutil.objects.ObjectList;
import it.unimi.dsi.fastutil.objects.ObjectSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import mctech.MCTech;
import mctech.api.util.DirectionList;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.server.ServerLifecycleHooks;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/c/a.class */
public class a {
    public static final int a = 1;
    public static final int b = 2;
    public static final int c = 4;
    public static final int d = 8;
    public static final int e = 16;
    public static final int f = 32;

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/c/a$b.class */
    public interface b extends InterfaceC0043a {
        void a(LevelReader levelReader, BlockPos blockPos, Map<Block, List<BlockPos>> map);
    }

    public static int a(Level level, BlockPos blockPos, int i, InterfaceC0043a interfaceC0043a, int i2, DirectionList directionList) {
        return c(level, blockPos, mctech.utils.math.geometry.a.a(blockPos, i), interfaceC0043a, i2, directionList, Integer.MAX_VALUE).a();
    }

    public static int a(Level level, BlockPos blockPos, int i, InterfaceC0043a interfaceC0043a, int i2, DirectionList directionList, int i3) {
        return c(level, blockPos, mctech.utils.math.geometry.a.a(blockPos, i), interfaceC0043a, i2, directionList, i3).a();
    }

    public static int a(Level level, BlockPos blockPos, mctech.utils.math.geometry.a aVar, InterfaceC0043a interfaceC0043a, int i, DirectionList directionList, int i2) {
        return c(level, blockPos, aVar, interfaceC0043a, i, directionList, i2).a();
    }

    public static d b(Level level, BlockPos blockPos, int i, InterfaceC0043a interfaceC0043a, int i2, DirectionList directionList) {
        return c(level, blockPos, mctech.utils.math.geometry.a.a(blockPos, i), interfaceC0043a, i2, directionList, Integer.MAX_VALUE);
    }

    public static d b(Level level, BlockPos blockPos, int i, InterfaceC0043a interfaceC0043a, int i2, DirectionList directionList, int i3) {
        return c(level, blockPos, mctech.utils.math.geometry.a.a(blockPos, i), interfaceC0043a, i2, directionList, i3);
    }

    public static c c(Level level, BlockPos blockPos, int i, InterfaceC0043a interfaceC0043a, int i2, DirectionList directionList) {
        return b(level, blockPos, mctech.utils.math.geometry.a.a(blockPos, i), interfaceC0043a, i2, directionList, Integer.MAX_VALUE);
    }

    public static c c(Level level, BlockPos blockPos, int i, InterfaceC0043a interfaceC0043a, int i2, DirectionList directionList, int i3) {
        return b(level, blockPos, mctech.utils.math.geometry.a.a(blockPos, i), interfaceC0043a, i2, directionList, i3);
    }

    public static c b(Level level, BlockPos blockPos, mctech.utils.math.geometry.a aVar, InterfaceC0043a interfaceC0043a, int i, DirectionList directionList, int i2) {
        return new c(level, blockPos, aVar, interfaceC0043a, i, directionList, i2);
    }

    @Beta
    public static void a(Level level, BlockPos blockPos, int i, InterfaceC0043a interfaceC0043a, int i2, DirectionList directionList, Consumer<d> consumer) {
        a(level, blockPos, mctech.utils.math.geometry.a.a(blockPos, i), interfaceC0043a, i2, directionList, Integer.MAX_VALUE, consumer);
    }

    @Beta
    public static void a(Level level, BlockPos blockPos, int i, InterfaceC0043a interfaceC0043a, int i2, DirectionList directionList, int i3, Consumer<d> consumer) {
        a(level, blockPos, mctech.utils.math.geometry.a.a(blockPos, i), interfaceC0043a, i2, directionList, i3, consumer);
    }

    @Beta
    public static void a(Level level, BlockPos blockPos, mctech.utils.math.geometry.a aVar, InterfaceC0043a interfaceC0043a, int i, DirectionList directionList, int i2, Consumer<d> consumer) {
        MinecraftServer currentServer = ServerLifecycleHooks.getCurrentServer();
        if (currentServer == null) {
            throw new IllegalStateException("Only Usable on a Server!");
        }
        MCTech.OFF_THREAD_WORKER.execute(new e(new j(level, aVar, true, true), blockPos, aVar, interfaceC0043a, directionList, i, i2, dVar -> {
            currentServer.execute(() -> {
                consumer.accept(dVar);
            });
        }));
    }

    public static void a(Level level, Consumer<BlockEntity> consumer) {
        if (level instanceof ServerLevel) {
            a((ServerLevel) level, consumer);
        }
    }

    public static void a(ServerLevel serverLevel, Consumer<BlockEntity> consumer) {
    }

    public static d c(Level level, BlockPos blockPos, mctech.utils.math.geometry.a aVar, InterfaceC0043a interfaceC0043a, int i, DirectionList directionList, int i2) {
        ObjectList objectListI = mctech.utils.a.b.i();
        Object2ObjectSortedMap object2ObjectSortedMapF = (i & 32) != 0 ? mctech.utils.a.b.f() : Object2ObjectMaps.emptyMap();
        boolean z = (i & 32) != 0;
        boolean z2 = (i & 1) != 0;
        j jVar = new j(level, aVar, (i & 1) != 0);
        if ((i & 2) != 0) {
            for (BlockPos blockPos2 : (i & 8) != 0 ? aVar.z() : aVar) {
                if (z2 || jVar.hasChunk(blockPos2.getX() >> 4, blockPos2.getZ() >> 4)) {
                    if (interfaceC0043a.a(jVar, blockPos2)) {
                        objectListI.add(blockPos2.immutable());
                        a(interfaceC0043a, jVar, blockPos2, z, object2ObjectSortedMapF);
                        if (objectListI.size() >= i2) {
                            return new d(objectListI, object2ObjectSortedMapF);
                        }
                    } else {
                        continue;
                    }
                }
            }
            return new d(objectListI, object2ObjectSortedMapF);
        }
        ObjectArrayFIFOQueue objectArrayFIFOQueue = new ObjectArrayFIFOQueue();
        ObjectSet objectSetG = mctech.utils.a.b.g();
        Iterator<Direction> it = ((i & 4) != 0 ? directionList.getRandomIterator() : directionList).iterator();
        while (it.hasNext()) {
            objectArrayFIFOQueue.enqueue(blockPos.relative(it.next()));
        }
        while (objectArrayFIFOQueue.size() > 0) {
            BlockPos blockPos3 = (BlockPos) objectArrayFIFOQueue.dequeue();
            if (aVar.d(blockPos3) && objectSetG.add(blockPos3) && (z2 || jVar.hasChunk(blockPos3.getX() >> 4, blockPos3.getZ() >> 4))) {
                if (interfaceC0043a.a(jVar, blockPos3)) {
                    objectListI.add(blockPos3);
                    a(interfaceC0043a, jVar, blockPos3, z, object2ObjectSortedMapF);
                    if (objectListI.size() >= i2) {
                        return new d(objectListI, object2ObjectSortedMapF);
                    }
                    Iterator<Direction> it2 = directionList.iterator();
                    while (it2.hasNext()) {
                        BlockPos blockPosRelative = blockPos3.relative(it2.next());
                        if (aVar.d(blockPosRelative) && !objectSetG.contains(blockPosRelative)) {
                            objectArrayFIFOQueue.enqueue(blockPosRelative);
                        }
                    }
                } else {
                    continue;
                }
            }
        }
        return new d(objectListI, object2ObjectSortedMapF);
    }

    private static void a(InterfaceC0043a interfaceC0043a, LevelReader levelReader, BlockPos blockPos, boolean z, Map<Block, List<BlockPos>> map) {
        if (z) {
            if (interfaceC0043a instanceof b) {
                ((b) interfaceC0043a).a(levelReader, blockPos, map);
            } else {
                a(levelReader.getBlockState(blockPos).getBlock(), blockPos, map);
            }
        }
    }

    public static void a(Block block, BlockPos blockPos, Map<Block, List<BlockPos>> map) {
        List<BlockPos> listI = map.get(block);
        if (listI == null) {
            listI = mctech.utils.a.b.i();
            map.put(block, listI);
        }
        listI.add(blockPos);
    }

    public static <T extends Entity> T a(List<T> list, Vec3 vec3) {
        double d2 = Double.MAX_VALUE;
        T t = null;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            T t2 = list.get(i);
            double dDistanceToSqr = t2.distanceToSqr(vec3);
            if (d2 > dDistanceToSqr) {
                d2 = dDistanceToSqr;
                t = t2;
            }
        }
        return t;
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/c/a$d.class */
    public static class d {
        ObjectList<BlockPos> a;
        Object2ObjectMap<Block, List<BlockPos>> b;

        public d(ObjectList<BlockPos> objectList, Object2ObjectMap<Block, List<BlockPos>> object2ObjectMap) {
            this.a = objectList;
            this.b = object2ObjectMap;
        }

        public int a() {
            return this.a.size();
        }

        public ObjectList<BlockPos> b() {
            return this.a;
        }

        public Object2ObjectMap<Block, List<BlockPos>> c() {
            return this.b;
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/c/a$c.class */
    public static class c {
        Level a;
        j b;
        BlockPos c;
        mctech.utils.math.geometry.a d;
        InterfaceC0043a e;
        DirectionList f;
        int j;
        int k;
        PriorityQueue<BlockPos> g = new ObjectArrayPriorityQueue();
        Set<BlockPos> h = mctech.utils.a.b.g();
        List<BlockPos> i = mctech.utils.a.b.i();
        int l = 100;

        c(Level level, BlockPos blockPos, mctech.utils.math.geometry.a aVar, InterfaceC0043a interfaceC0043a, int i, DirectionList directionList, int i2) {
            this.a = level;
            this.c = blockPos;
            this.d = aVar;
            this.e = interfaceC0043a;
            this.f = directionList;
            this.k = i;
        }

        public c a(int i) {
            this.l = i;
            return this;
        }

        public int a() {
            if (this.g.isEmpty()) {
                return this.i.size();
            }
            return -1;
        }

        public List<BlockPos> b() {
            if (this.g.isEmpty()) {
                return this.i;
            }
            return null;
        }

        public boolean a(boolean z) {
            if (this.b == null) {
                this.b = new j(this.a, this.d, (this.k & 1) != 0);
                if ((this.k & 2) != 0) {
                    Iterator<BlockPos> it = ((this.k & 8) != 0 ? this.d.z() : this.d).iterator();
                    while (it.hasNext()) {
                        this.g.enqueue(it.next().immutable());
                    }
                } else {
                    Iterator<Direction> it2 = ((this.k & 4) != 0 ? this.f.getRandomIterator() : this.f).iterator();
                    while (it2.hasNext()) {
                        this.g.enqueue(this.c.relative(it2.next()));
                    }
                }
                if ((this.k & 16) == 0) {
                    return !z;
                }
            }
            boolean z2 = (this.k & 1) != 0;
            boolean z3 = (this.k & 2) != 0;
            for (int i = 0; i < this.l && this.g.size() > 0; i++) {
                BlockPos blockPos = (BlockPos) this.g.dequeue();
                if ((z3 || (this.d.d(blockPos) && this.h.add(blockPos))) && ((z2 || this.b.hasChunk(blockPos.getX() >> 4, blockPos.getZ() >> 4)) && this.e.a(this.b, blockPos))) {
                    this.i.add(blockPos);
                    if (this.i.size() >= this.j) {
                        this.g.clear();
                        return z;
                    }
                    if (!z3) {
                        Iterator<Direction> it3 = this.f.iterator();
                        while (it3.hasNext()) {
                            BlockPos blockPosRelative = blockPos.relative(it3.next());
                            if (this.d.d(blockPosRelative) && !this.h.contains(blockPosRelative)) {
                                this.g.enqueue(blockPosRelative);
                            }
                        }
                    }
                }
            }
            return this.g.isEmpty() == z;
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/c/a$e.class */
    static class e implements Runnable {
        j a;
        BlockPos b;
        mctech.utils.math.geometry.a c;
        InterfaceC0043a d;
        DirectionList e;
        int f;
        int g;
        Consumer<d> h;

        public e(j jVar, BlockPos blockPos, mctech.utils.math.geometry.a aVar, InterfaceC0043a interfaceC0043a, DirectionList directionList, int i, int i2, Consumer<d> consumer) {
            this.a = jVar;
            this.b = blockPos;
            this.c = aVar;
            this.d = interfaceC0043a;
            this.e = directionList;
            this.f = i;
            this.g = i2;
            this.h = consumer;
        }

        @Override // java.lang.Runnable
        public void run() {
            ObjectList objectListI = mctech.utils.a.b.i();
            Object2ObjectSortedMap object2ObjectSortedMapF = (this.f & 32) != 0 ? mctech.utils.a.b.f() : Object2ObjectMaps.emptyMap();
            boolean z = (this.f & 32) != 0;
            if ((this.f & 2) != 0) {
                for (BlockPos blockPos : (this.f & 8) != 0 ? this.c.z() : this.c) {
                    if (this.a.hasChunk(blockPos.getX() >> 4, blockPos.getZ() >> 4) && this.d.a(this.a, blockPos)) {
                        objectListI.add(blockPos.immutable());
                        a.a(this.d, this.a, blockPos, z, object2ObjectSortedMapF);
                        if (objectListI.size() >= this.g) {
                            this.h.accept(new d(objectListI, object2ObjectSortedMapF));
                            return;
                        }
                    }
                }
                this.h.accept(new d(objectListI, object2ObjectSortedMapF));
                return;
            }
            ObjectArrayFIFOQueue objectArrayFIFOQueue = new ObjectArrayFIFOQueue();
            ObjectSet objectSetG = mctech.utils.a.b.g();
            Iterator<Direction> it = ((this.f & 4) != 0 ? this.e.getRandomIterator() : this.e).iterator();
            while (it.hasNext()) {
                objectArrayFIFOQueue.enqueue(this.b.relative(it.next()));
            }
            while (objectArrayFIFOQueue.size() > 0) {
                BlockPos blockPos2 = (BlockPos) objectArrayFIFOQueue.dequeue();
                if (this.c.d(blockPos2) && !objectSetG.contains(blockPos2)) {
                    objectSetG.add(blockPos2);
                    if (this.a.hasChunk(blockPos2.getX() >> 4, blockPos2.getZ() >> 4) && this.d.a(this.a, blockPos2)) {
                        objectListI.add(blockPos2);
                        a.a(this.d, this.a, blockPos2, z, object2ObjectSortedMapF);
                        if (objectListI.size() >= this.g) {
                            this.h.accept(new d(objectListI, object2ObjectSortedMapF));
                            return;
                        }
                        Iterator<Direction> it2 = this.e.iterator();
                        while (it2.hasNext()) {
                            BlockPos blockPosRelative = blockPos2.relative(it2.next());
                            if (this.c.d(blockPosRelative) && !objectSetG.contains(blockPosRelative)) {
                                objectArrayFIFOQueue.enqueue(blockPosRelative);
                            }
                        }
                    }
                }
            }
            this.h.accept(new d(objectListI, object2ObjectSortedMapF));
        }
    }

    /* JADX INFO: renamed from: mctech.utils.c.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/c/a$a.class */
    @FunctionalInterface
    public interface InterfaceC0043a {
        boolean isValid(BlockState blockState);

        default boolean a(LevelReader levelReader, BlockPos blockPos) {
            return isValid(levelReader.getBlockState(blockPos));
        }
    }
}
