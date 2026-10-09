package mctech.utils.c;

import it.unimi.dsi.fastutil.longs.LongArrayList;
import it.unimi.dsi.fastutil.longs.LongList;
import it.unimi.dsi.fastutil.objects.Object2ObjectSortedMap;
import it.unimi.dsi.fastutil.objects.ObjectList;
import java.util.List;
import java.util.Map;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraft.world.level.chunk.LevelChunkSection;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/c/f.class */
public class f {
    int a;
    int b;
    LevelChunkSection c;

    public f(ChunkPos chunkPos, LevelChunkSection levelChunkSection) {
        this.a = chunkPos.x;
        this.b = chunkPos.z;
        this.c = levelChunkSection;
    }

    public f(int i, int i2, LevelChunkSection levelChunkSection) {
        this.a = i;
        this.b = i2;
        this.c = levelChunkSection;
    }

    public static List<f> a(Level level, mctech.utils.math.geometry.a aVar) {
        int iF = aVar.f() >> 4;
        int iH = aVar.h() >> 4;
        int iJ = ((aVar.j() >> 4) + 1) - iF;
        int iL = ((aVar.l() >> 4) + 1) - iH;
        ObjectList objectListI = mctech.utils.a.b.i();
        for (int i = 0; i < iJ; i++) {
            for (int i2 = 0; i2 < iL; i2++) {
                for (LevelChunkSection levelChunkSection : level.getChunk(iF + i, iH + i2).getSections()) {
                    if (!levelChunkSection.hasOnlyAir()) {
                        objectListI.add(new f(iF + i, iH + i2, levelChunkSection));
                    }
                }
            }
        }
        return objectListI;
    }

    public static List<f> a(LevelChunk levelChunk) {
        ObjectList objectListI = mctech.utils.a.b.i();
        for (LevelChunkSection levelChunkSection : levelChunk.getSections()) {
            if (!levelChunkSection.hasOnlyAir()) {
                objectListI.add(new f(levelChunk.getPos(), levelChunkSection));
            }
        }
        return objectListI;
    }

    public Map<BlockState, LongList> a() {
        Object2ObjectSortedMap object2ObjectSortedMapF = mctech.utils.a.b.f();
        int i = this.a << 4;
        int i2 = this.b << 4;
        for (int i3 = 0; i3 < 16; i3++) {
            for (int i4 = 0; i4 < 16; i4++) {
                for (int i5 = 0; i5 < 16; i5++) {
                    ((LongList) object2ObjectSortedMapF.computeIfAbsent(this.c.getBlockState(i3, i4, i5), this::a)).add(BlockPos.asLong(i3 + i, i4 + 0, i5 + i2));
                }
            }
        }
        return object2ObjectSortedMapF;
    }

    public Map<Block, LongList> b() {
        Object2ObjectSortedMap object2ObjectSortedMapF = mctech.utils.a.b.f();
        int i = this.a << 4;
        int i2 = this.b << 4;
        for (int i3 = 0; i3 < 16; i3++) {
            for (int i4 = 0; i4 < 16; i4++) {
                for (int i5 = 0; i5 < 16; i5++) {
                    ((LongList) object2ObjectSortedMapF.computeIfAbsent(this.c.getBlockState(i3, i4, i5).getBlock(), this::a)).add(BlockPos.asLong(i3 + i, i4 + 0, i5 + i2));
                }
            }
        }
        return object2ObjectSortedMapF;
    }

    private LongList a(Block block) {
        return new LongArrayList();
    }

    private LongList a(BlockState blockState) {
        return new LongArrayList();
    }
}
