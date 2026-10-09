package mctech.v.f;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Iterator;
import java.util.List;
import mctech.api.util.DirectionList;
import mctech.v.u;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.BlockElementFace;
import net.minecraft.client.renderer.block.model.BlockElementRotation;
import net.minecraft.client.renderer.block.model.BlockFaceUV;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.BlockModelRotation;
import net.minecraft.core.Direction;
import net.minecraft.world.phys.AABB;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/f/f.class */
public class f {
    public static final float a = 0.0625f;
    List<b> b = new ObjectArrayList();

    public f a(double d, double d2, double d3, double d4, double d5, double d6) {
        return b(d, d2, d3, d4, d5, d6).a().b();
    }

    public c b(double d, double d2, double d3, double d4, double d5, double d6) {
        return new c(this, this, new AABB(d, d2, d3, d4, d5, d6));
    }

    public c a(AABB aabb) {
        return b(aabb.minX, aabb.minY, aabb.minZ, aabb.maxX, aabb.maxY, aabb.maxZ);
    }

    @OnlyIn(Dist.CLIENT)
    public void a(TextureAtlasSprite textureAtlasSprite, BlockModelRotation blockModelRotation, BlockElementRotation blockElementRotation, boolean z, List<BakedQuad> list) {
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            b bVar = this.b.get(i);
            list.add(u.a(bVar.a, bVar.c, bVar.c(), textureAtlasSprite, blockModelRotation, blockElementRotation, z));
        }
    }

    @OnlyIn(Dist.CLIENT)
    public void b(TextureAtlasSprite textureAtlasSprite, BlockModelRotation blockModelRotation, BlockElementRotation blockElementRotation, boolean z, List<BakedQuad> list) {
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            b bVar = this.b.get(i);
            list.add(u.b(bVar.a, bVar.c, bVar.c(), textureAtlasSprite, blockModelRotation, blockElementRotation, z));
        }
    }

    @OnlyIn(Dist.CLIENT)
    public void a(TextureAtlasSprite textureAtlasSprite, BlockModelRotation blockModelRotation, BlockElementRotation blockElementRotation, boolean z, int i, int i2, List<BakedQuad> list) {
        int size = this.b.size();
        for (int i3 = i; i3 < size && i3 < i2; i3++) {
            b bVar = this.b.get(i3);
            list.add(u.a(bVar.a, bVar.c, bVar.c(), textureAtlasSprite, blockModelRotation, blockElementRotation, z));
        }
    }

    @OnlyIn(Dist.CLIENT)
    public void b(TextureAtlasSprite textureAtlasSprite, BlockModelRotation blockModelRotation, BlockElementRotation blockElementRotation, boolean z, int i, int i2, List<BakedQuad> list) {
        int size = this.b.size();
        for (int i3 = i; i3 < size && i3 < i2; i3++) {
            b bVar = this.b.get(i3);
            list.add(u.b(bVar.a, bVar.c, bVar.c(), textureAtlasSprite, blockModelRotation, blockElementRotation, z));
        }
    }

    @OnlyIn(Dist.CLIENT)
    public void a(TextureAtlasSprite textureAtlasSprite, BlockModelRotation blockModelRotation, BlockElementRotation blockElementRotation, boolean z, List<BakedQuad>[] listArr) {
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            b bVar = this.b.get(i);
            listArr[bVar.d ? Direction.rotate(blockModelRotation.getRotation().getMatrix(), bVar.c).get3DDataValue() : 6].add(u.a(bVar.a, bVar.c, bVar.c(), textureAtlasSprite, blockModelRotation, blockElementRotation, z));
        }
    }

    @OnlyIn(Dist.CLIENT)
    public void b(TextureAtlasSprite textureAtlasSprite, BlockModelRotation blockModelRotation, BlockElementRotation blockElementRotation, boolean z, List<BakedQuad>[] listArr) {
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            b bVar = this.b.get(i);
            listArr[bVar.d ? Direction.rotate(blockModelRotation.getRotation().getMatrix(), bVar.c).get3DDataValue() : 6].add(u.b(bVar.a, bVar.c, bVar.c(), textureAtlasSprite, blockModelRotation, blockElementRotation, z));
        }
    }

    @OnlyIn(Dist.CLIENT)
    public void a(TextureAtlasSprite[] textureAtlasSpriteArr, BlockModelRotation blockModelRotation, BlockElementRotation blockElementRotation, boolean z, List<BakedQuad> list) {
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            b bVar = this.b.get(i);
            list.add(u.a(bVar.a, bVar.c, bVar.c(), textureAtlasSpriteArr[bVar.c.get3DDataValue()], blockModelRotation, blockElementRotation, z));
        }
    }

    @OnlyIn(Dist.CLIENT)
    public void b(TextureAtlasSprite[] textureAtlasSpriteArr, BlockModelRotation blockModelRotation, BlockElementRotation blockElementRotation, boolean z, List<BakedQuad> list) {
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            b bVar = this.b.get(i);
            list.add(u.b(bVar.a, bVar.c, bVar.c(), textureAtlasSpriteArr[bVar.c.get3DDataValue()], blockModelRotation, blockElementRotation, z));
        }
    }

    public List<b> a() {
        return this.b;
    }

    public List<b>[] b() {
        List<b>[] listArrA = mctech.utils.a.b.a(6);
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            b bVar = this.b.get(i);
            listArrA[bVar.c.get3DDataValue()].add(bVar);
        }
        return listArrA;
    }

    /* JADX INFO: renamed from: mctech.v.f.f$1, reason: invalid class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/f/f$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[Direction.values().length];

        static {
            try {
                a[Direction.DOWN.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[Direction.UP.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[Direction.SOUTH.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[Direction.WEST.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                a[Direction.EAST.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public static float[] a(Direction direction, AABB aabb) {
        switch (AnonymousClass1.a[direction.ordinal()]) {
            case 1:
                return new float[]{(float) aabb.minX, 16.0f - ((float) aabb.maxZ), (float) aabb.maxX, 16.0f - ((float) aabb.minZ)};
            case 2:
                return new float[]{(float) aabb.minX, (float) aabb.minZ, (float) aabb.maxX, (float) aabb.maxZ};
            case 3:
                return new float[]{(float) aabb.minX, 16.0f - ((float) aabb.maxY), (float) aabb.maxX, 16.0f - ((float) aabb.minY)};
            case 4:
                return new float[]{(float) aabb.minZ, 16.0f - ((float) aabb.maxY), (float) aabb.maxZ, 16.0f - ((float) aabb.minY)};
            case 5:
                return new float[]{16.0f - ((float) aabb.maxZ), 16.0f - ((float) aabb.maxY), 16.0f - ((float) aabb.minZ), 16.0f - ((float) aabb.minY)};
            default:
                return new float[]{16.0f - ((float) aabb.maxX), 16.0f - ((float) aabb.maxY), 16.0f - ((float) aabb.minX), 16.0f - ((float) aabb.minY)};
        }
    }

    public static b a(AABB aabb, Direction direction, a aVar, boolean z) {
        return new b(aabb, direction, aVar, z);
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/f/f$c.class */
    public class c {
        AABB a;
        f b;

        c(f fVar, f fVar2, AABB aabb) {
            this.b = fVar2;
            this.a = aabb;
        }

        public c a() {
            return a(DirectionList.ALL);
        }

        public c a(DirectionList directionList) {
            return a(directionList, -1, 0);
        }

        public c a(DirectionList directionList, int i) {
            return a(directionList, i, 0);
        }

        public c a(DirectionList directionList, int i, int i2) {
            for (Direction direction : directionList) {
                a(direction, i, i2, f.a(direction, this.a));
            }
            return this;
        }

        public c a(float... fArr) {
            return a(-1, fArr);
        }

        public c a(float[]... fArr) {
            for (Direction direction : DirectionList.ALL) {
                a(direction, -1, fArr[direction.get3DDataValue()]);
            }
            return this;
        }

        public c b(float[]... fArr) {
            for (Direction direction : DirectionList.HORIZONTAL) {
                a(direction, -1, fArr[direction.get2DDataValue()]);
            }
            return this;
        }

        public c a(int i, float... fArr) {
            Iterator<Direction> it = DirectionList.ALL.iterator();
            while (it.hasNext()) {
                a(it.next(), i, fArr);
            }
            return this;
        }

        public c a(int i, float[]... fArr) {
            for (Direction direction : DirectionList.HORIZONTAL) {
                a(direction, i, fArr[direction.get2DDataValue()]);
            }
            return this;
        }

        public c b(int i, float[]... fArr) {
            for (Direction direction : DirectionList.ALL) {
                a(direction, i, fArr[direction.get3DDataValue()]);
            }
            return this;
        }

        public c b(float... fArr) {
            return b(-1, fArr);
        }

        public c c(float[]... fArr) {
            for (Direction direction : DirectionList.ALL) {
                b(direction, -1, fArr[direction.get3DDataValue()]);
            }
            return this;
        }

        public c d(float[]... fArr) {
            for (Direction direction : DirectionList.HORIZONTAL) {
                b(direction, -1, fArr[direction.get2DDataValue()]);
            }
            return this;
        }

        public c b(int i, float... fArr) {
            Iterator<Direction> it = DirectionList.ALL.iterator();
            while (it.hasNext()) {
                b(it.next(), i, fArr);
            }
            return this;
        }

        public c c(int i, float[]... fArr) {
            for (Direction direction : DirectionList.HORIZONTAL) {
                b(direction, i, fArr[direction.get2DDataValue()]);
            }
            return this;
        }

        public c d(int i, float[]... fArr) {
            for (Direction direction : DirectionList.ALL) {
                b(direction, i, fArr[direction.get3DDataValue()]);
            }
            return this;
        }

        public c a(DirectionList directionList, float... fArr) {
            Iterator<Direction> it = directionList.iterator();
            while (it.hasNext()) {
                a(it.next(), fArr);
            }
            return this;
        }

        public c a(DirectionList directionList, int i, float... fArr) {
            Iterator<Direction> it = directionList.iterator();
            while (it.hasNext()) {
                a(it.next(), i, fArr);
            }
            return this;
        }

        public c a(DirectionList directionList, int i, int i2, float... fArr) {
            Iterator<Direction> it = directionList.iterator();
            while (it.hasNext()) {
                a(it.next(), i, i2, fArr);
            }
            return this;
        }

        public c b(DirectionList directionList, float... fArr) {
            Iterator<Direction> it = directionList.iterator();
            while (it.hasNext()) {
                b(it.next(), fArr);
            }
            return this;
        }

        public c b(DirectionList directionList, int i, float... fArr) {
            Iterator<Direction> it = directionList.iterator();
            while (it.hasNext()) {
                b(it.next(), i, fArr);
            }
            return this;
        }

        public c b(DirectionList directionList, int i, int i2, float... fArr) {
            Iterator<Direction> it = directionList.iterator();
            while (it.hasNext()) {
                b(it.next(), i, i2, fArr);
            }
            return this;
        }

        public c a(Direction direction, float... fArr) {
            return a(direction, -1, 0, fArr);
        }

        public c a(Direction direction, int i, float... fArr) {
            return a(direction, i, 0, fArr);
        }

        public c a(Direction direction, int i, int i2, float... fArr) {
            if (fArr.length != 4) {
                throw new IllegalStateException("has to be 4 elements");
            }
            this.b.b.add(new b(this.a, direction, new a(i, i2, fArr), false));
            return this;
        }

        public c b(Direction direction, float... fArr) {
            return b(direction, -1, 0, fArr);
        }

        public c b(Direction direction, int i, float... fArr) {
            return b(direction, i, 0, fArr);
        }

        public c b(Direction direction, int i, int i2, float... fArr) {
            if (fArr.length != 4) {
                throw new IllegalStateException("has to be 4 elements");
            }
            this.b.b.add(new b(this.a, direction, new a(i, i2, fArr), true));
            return this;
        }

        public f b() {
            return this.b;
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/f/f$b.class */
    public static class b {
        AABB a;
        a b;
        Direction c;
        boolean d;

        b(AABB aabb, Direction direction, a aVar, boolean z) {
            this.a = aabb;
            this.b = aVar;
            this.c = direction;
            this.d = z;
        }

        public AABB a() {
            return this.a;
        }

        public a b() {
            return this.b;
        }

        @OnlyIn(Dist.CLIENT)
        public BlockElementFace c() {
            return this.b.a();
        }

        public Direction d() {
            return this.c;
        }

        public boolean e() {
            return this.d;
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/f/f$a.class */
    public static class a {
        int a;
        int b;
        float[] c;

        public a(int i, int i2, float[] fArr) {
            this.a = i;
            this.b = i2;
            this.c = fArr;
        }

        @OnlyIn(Dist.CLIENT)
        public BlockElementFace a() {
            return new BlockElementFace((Direction) null, this.a, "", new BlockFaceUV(this.c, this.b));
        }
    }
}
