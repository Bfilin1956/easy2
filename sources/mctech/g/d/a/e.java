package mctech.g.d.a;

import com.mojang.datafixers.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.Vec3i;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/a/e.class */
public class e {
    private static final VoxelShape e = Block.box(2.5d, 2.5d, 15.0d, 13.5d, 13.5d, 16.0d);
    public static final VoxelShape a = Block.box(6.5d, 6.5d, 9.5d, 9.5d, 9.5d, 16.0d);
    private static final VoxelShape f = Block.box(6.5d, 6.5d, 6.5d, 9.5d, 9.5d, 9.5d);
    private final Map<Pair<Direction, Holder<mctech.g.a.a<?, ?>>>, VoxelShape> b = new HashMap();
    private final Map<Holder<mctech.g.a.a<?, ?>>, VoxelShape> c = new HashMap();
    private final Map<Holder<mctech.g.a.a<?, ?>>, List<VoxelShape>> d = new HashMap();
    private VoxelShape g = f;

    public void a(mctech.g.a.c cVar) {
        this.c.clear();
        this.b.clear();
        this.d.clear();
        Iterator<Holder<mctech.g.a.a<?, ?>>> it = cVar.a().iterator();
        while (it.hasNext()) {
            a(cVar, it.next());
        }
        b();
    }

    public VoxelShape a(BlockPos blockPos, HitResult hitResult) {
        Holder<mctech.g.a.a<?, ?>> holderB = b(blockPos, hitResult);
        if (holderB == null || !this.d.containsKey(holderB)) {
            return Shapes.empty();
        }
        Vec3 vec3Subtract = hitResult.getLocation().subtract(blockPos.getX(), blockPos.getY(), blockPos.getZ());
        for (VoxelShape voxelShape : this.d.get(holderB)) {
            Optional optionalClosestPointTo = voxelShape.closestPointTo(vec3Subtract);
            if (!optionalClosestPointTo.isEmpty() && ((Vec3) optionalClosestPointTo.get()).closerThan(vec3Subtract, 9.999999747378752E-6d)) {
                return voxelShape;
            }
        }
        return Shapes.empty();
    }

    @Nullable
    public Holder<mctech.g.a.a<?, ?>> b(BlockPos blockPos, HitResult hitResult) {
        return (Holder) a(this.c, blockPos, hitResult);
    }

    @Nullable
    public Pair<Direction, Holder<mctech.g.a.a<?, ?>>> c(BlockPos blockPos, HitResult hitResult) {
        return (Pair) a(this.b, blockPos, hitResult);
    }

    @Nullable
    private <T> T a(Map<T, VoxelShape> map, BlockPos blockPos, HitResult hitResult) {
        Vec3 vec3Subtract = hitResult.getLocation().subtract(blockPos.getX(), blockPos.getY(), blockPos.getZ());
        for (Map.Entry<T, VoxelShape> entry : map.entrySet()) {
            Optional optionalClosestPointTo = entry.getValue().closestPointTo(vec3Subtract);
            if (!optionalClosestPointTo.isEmpty() && ((Vec3) optionalClosestPointTo.get()).closerThan(vec3Subtract, 9.999999747378752E-6d)) {
                return entry.getKey();
            }
        }
        return null;
    }

    private void b() {
        this.g = Shapes.empty();
        this.c.values().forEach(voxelShape -> {
            this.g = Shapes.joinUnoptimized(this.g, voxelShape, BooleanOp.OR);
        });
        this.g.optimize();
    }

    public VoxelShape a() {
        return this.g;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    private void a(mctech.g.a.c cVar, Holder<mctech.g.a.a<?, ?>> holder) throws MatchException {
        List<VoxelShape> listComputeIfAbsent = this.d.computeIfAbsent(holder, holder2 -> {
            return new ArrayList();
        });
        VoxelShape voxelShapeEmpty = Shapes.empty();
        Direction.Axis axisA = g.a(cVar);
        HashMap map = new HashMap();
        for (Direction direction : Direction.values()) {
            VoxelShape voxelShapeEmpty2 = Shapes.empty();
            if (cVar.b(holder, direction) == mctech.g.a.c.f.CONNECTED_BLOCK) {
                VoxelShape voxelShapeA = a(e, direction);
                voxelShapeEmpty = Shapes.joinUnoptimized(voxelShapeEmpty, voxelShapeA, BooleanOp.OR);
                voxelShapeEmpty2 = Shapes.joinUnoptimized(voxelShapeA, voxelShapeA, BooleanOp.OR);
                listComputeIfAbsent.add(voxelShapeA);
            }
            List<Holder<mctech.g.a.a<?, ?>>> listB = cVar.b(direction);
            if (listB.contains(holder)) {
                Vec3i vec3iA = g.a(direction.getAxis(), g.a(listB.indexOf(holder), listB.size()));
                ((List) map.computeIfAbsent(holder, holder3 -> {
                    return new ArrayList();
                })).add(vec3iA);
                VoxelShape voxelShapeMove = a(a, direction).move((vec3iA.getX() * 3.0f) / 16.0f, (vec3iA.getY() * 3.0f) / 16.0f, (vec3iA.getZ() * 3.0f) / 16.0f);
                voxelShapeEmpty = Shapes.joinUnoptimized(voxelShapeEmpty, voxelShapeMove, BooleanOp.OR);
                voxelShapeEmpty2 = Shapes.joinUnoptimized(voxelShapeEmpty2, voxelShapeMove, BooleanOp.OR);
                listComputeIfAbsent.add(voxelShapeMove);
            }
            this.b.put(new Pair<>(direction, holder), voxelShapeEmpty2.optimize());
        }
        List<Holder<mctech.g.a.a<?, ?>>> listA = cVar.a();
        mctech.g.d.a aVar = null;
        Holder<mctech.g.a.a<?, ?>> holder4 = null;
        int iIndexOf = listA.indexOf(holder);
        if (iIndexOf == -1) {
            this.c.put(holder, Shapes.block());
            return;
        }
        List list = (List) map.get(holder);
        if (list == null) {
            holder4 = holder;
        } else if (list.stream().distinct().count() != 1) {
            aVar = new mctech.g.d.a((Vec3i[]) list.toArray(new Vec3i[0]));
        }
        VoxelShape voxelShapeEmpty3 = Shapes.empty();
        if (list != null && (aVar == null || !aVar.b((Vec3i) list.get(0)))) {
            voxelShapeEmpty3 = Shapes.joinUnoptimized(voxelShapeEmpty3, f.move((((Vec3i) list.get(0)).getX() * 3.0f) / 16.0f, (((Vec3i) list.get(0)).getY() * 3.0f) / 16.0f, (((Vec3i) list.get(0)).getZ() * 3.0f) / 16.0f), BooleanOp.OR);
        }
        if (aVar != null) {
            if (holder4 != null) {
                Vec3i vec3iA2 = g.a(axisA, g.a(iIndexOf, listA.size()));
                if (!aVar.b(vec3iA2)) {
                    voxelShapeEmpty3 = Shapes.joinUnoptimized(voxelShapeEmpty3, f.move((vec3iA2.getX() * 3.0f) / 16.0f, (vec3iA2.getY() * 3.0f) / 16.0f, (vec3iA2.getZ() * 3.0f) / 16.0f), BooleanOp.OR);
                }
            }
            voxelShapeEmpty3 = Shapes.joinUnoptimized(voxelShapeEmpty3, f.move((aVar.a().getX() * 3.0f) / 16.0f, (aVar.a().getY() * 3.0f) / 16.0f, (aVar.a().getZ() * 3.0f) / 16.0f), BooleanOp.OR);
        } else if (holder4 != null) {
            Vec3i vec3iA3 = g.a(axisA, g.a(iIndexOf, listA.size()));
            voxelShapeEmpty3 = Shapes.joinUnoptimized(voxelShapeEmpty3, f.move((vec3iA3.getX() * 3.0f) / 16.0f, (vec3iA3.getY() * 3.0f) / 16.0f, (vec3iA3.getZ() * 3.0f) / 16.0f), BooleanOp.OR);
        }
        this.c.put(holder, Shapes.joinUnoptimized(voxelShapeEmpty, voxelShapeEmpty3, BooleanOp.OR).optimize());
        listComputeIfAbsent.add(voxelShapeEmpty3.optimize());
    }

    public static VoxelShape a(VoxelShape voxelShape, Direction direction) {
        VoxelShape[] voxelShapeArr = {voxelShape, Shapes.empty()};
        if (direction.get2DDataValue() == -1) {
            if (direction == Direction.DOWN) {
                voxelShapeArr[0].forAllBoxes((d, d2, d3, d4, d5, d6) -> {
                    voxelShapeArr[1] = Shapes.or(voxelShapeArr[1], Shapes.box(d, 1.0d - d6, d2, d4, 1.0d - d3, d5));
                });
            } else {
                voxelShapeArr[0].forAllBoxes((d7, d8, d9, d10, d11, d12) -> {
                    voxelShapeArr[1] = Shapes.or(voxelShapeArr[1], Shapes.box(d7, d9, d8, d10, d12, d11));
                });
            }
            return voxelShapeArr[1];
        }
        for (int i = 0; i < direction.get2DDataValue() % 4; i++) {
            voxelShapeArr[0].forAllBoxes((d13, d14, d15, d16, d17, d18) -> {
                voxelShapeArr[1] = Shapes.or(voxelShapeArr[1], Shapes.box(1.0d - d18, d14, d13, 1.0d - d15, d17, d16));
            });
            voxelShapeArr[0] = voxelShapeArr[1];
            voxelShapeArr[1] = Shapes.empty();
        }
        return voxelShapeArr[0];
    }
}
