package mctech.g.d.e;

import com.google.common.collect.Sets;
import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.Reference2ObjectMap;
import it.unimi.dsi.fastutil.objects.Reference2ObjectOpenHashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/e/b.class */
public class b<T> {
    private final Long2ObjectMap<Set<T>> a = new Long2ObjectOpenHashMap();
    private final Reference2ObjectMap<T, Set<ChunkPos>> b = new Reference2ObjectOpenHashMap();

    @Nullable
    public Set<T> a(ChunkPos chunkPos) {
        return (Set) this.a.get(chunkPos.toLong());
    }

    public void a(ChunkPos chunkPos, T t) {
        ((Set) this.a.computeIfAbsent(chunkPos.toLong(), j -> {
            return new HashSet();
        })).add(t);
        ((Set) this.b.computeIfAbsent(t, obj -> {
            return new HashSet();
        })).add(chunkPos);
    }

    public void b(ChunkPos chunkPos, T t) {
        if (this.a.containsKey(chunkPos.toLong())) {
            ((Set) this.a.get(chunkPos.toLong())).remove(t);
        }
        if (this.b.containsKey(t)) {
            ((Set) this.b.get(t)).remove(chunkPos);
        }
    }

    public void a(BlockPos blockPos, int i, T t) {
        a(blockPos, i).forEach(chunkPos -> {
            a(chunkPos, t);
        });
    }

    public void b(BlockPos blockPos, int i, T t) {
        Set<ChunkPos> set = (Set) this.b.get(t);
        if (set == null) {
            a(blockPos, i, t);
        } else {
            a(t, set, (Set<ChunkPos>) a(blockPos, i).collect(Collectors.toSet()));
        }
    }

    public void a(ChunkPos chunkPos, int i, T t) {
        ChunkPos.rangeClosed(chunkPos, i).forEach(chunkPos2 -> {
            a(chunkPos2, t);
        });
    }

    public void b(ChunkPos chunkPos, int i, T t) {
        Set<ChunkPos> set = (Set) this.b.get(t);
        if (set == null) {
            a(chunkPos, i, t);
        } else {
            a(t, set, (Set<ChunkPos>) ChunkPos.rangeClosed(chunkPos, i).collect(Collectors.toSet()));
        }
    }

    private Stream<ChunkPos> a(BlockPos blockPos, int i) {
        return ChunkPos.rangeClosed(new ChunkPos(new BlockPos(blockPos.getX() - i, 0, blockPos.getZ() - i)), new ChunkPos(new BlockPos(blockPos.getX() + i, 0, blockPos.getZ() + i)));
    }

    private void a(T t, Set<ChunkPos> set, Set<ChunkPos> set2) {
        Sets.SetView setViewDifference = Sets.difference(set, set2);
        Sets.SetView setViewDifference2 = Sets.difference(set2, set);
        setViewDifference.forEach(chunkPos -> {
            b(chunkPos, t);
        });
        setViewDifference2.forEach(chunkPos2 -> {
            a(chunkPos2, t);
        });
    }

    public void a(T t) {
        for (ChunkPos chunkPos : (Set) this.b.get(t)) {
            Set set = (Set) this.a.get(chunkPos.toLong());
            if (set != null) {
                set.remove(t);
                if (set.isEmpty()) {
                    this.a.remove(chunkPos.toLong());
                }
            }
        }
        this.b.remove(t);
    }
}
