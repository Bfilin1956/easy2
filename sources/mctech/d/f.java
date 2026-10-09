package mctech.d;

import mctech.api.util.DirectionList;
import mctech.api.util.ILocation;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/d/f.class */
public class f<T extends BlockEntity> extends a<T> {
    Class<T> f;
    boolean g;

    public f(ILocation iLocation, DirectionList directionList, Class<T> cls) {
        super(iLocation, directionList);
        this.g = false;
        this.f = cls;
    }

    public void f() {
        this.g = true;
        boolean z = false;
        for (Direction direction : this.e) {
            T tA = a(direction);
            if (tA != null && tA.isRemoved()) {
                c(direction);
                z = true;
            }
        }
        if (z) {
            d();
        }
        this.g = false;
    }

    @Override // mctech.d.a, mctech.d.d
    public void a() {
        if (this.g) {
            return;
        }
        super.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // mctech.d.d
    public void d() {
        this.g = true;
        Level level = this.a.getLevel();
        BlockPos position = this.a.getPosition();
        for (Direction direction : this.b) {
            BlockEntity neighborTile = DirectionList.getNeighborTile(level, position, direction);
            if (!this.f.isInstance(neighborTile)) {
                c(direction);
            } else {
                a(direction, neighborTile);
            }
        }
        this.g = true;
    }

    @Override // mctech.d.a, mctech.d.d
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public T b(Direction direction) {
        T tA = a(direction);
        if (tA != null && tA.isRemoved()) {
            c(direction);
            return null;
        }
        return tA;
    }
}
