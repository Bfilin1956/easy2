package mctech.d;

import com.google.common.collect.ObjectArrays;
import mctech.api.util.DirectionList;
import mctech.api.util.ILocation;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/d/e.class */
public class e<T> extends a<T> {
    Class<T> f;
    boolean g;

    public e(ILocation iLocation, DirectionList directionList, Class<T> cls) {
        super(iLocation, directionList);
        this.g = false;
        this.f = cls;
        this.d = (T[]) ObjectArrays.newArray(cls, 6);
    }

    public void f() {
        this.g = true;
        boolean z = false;
        for (Direction direction : this.e) {
            T tA = a(direction);
            if ((tA instanceof BlockEntity) && ((BlockEntity) tA).isRemoved()) {
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

    @Override // mctech.d.d
    public void d() {
        this.g = true;
        Level level = this.a.getLevel();
        BlockPos position = this.a.getPosition();
        for (Direction direction : this.e.invert().remove(this.b.invert())) {
            BlockPos blockPosRelative = position.relative(direction);
            if (!level.isLoaded(blockPosRelative)) {
                c(direction);
            } else {
                BlockEntity blockEntity = level.getBlockEntity(blockPosRelative);
                if (!this.f.isInstance(blockEntity)) {
                    c(direction);
                } else {
                    a(direction, blockEntity);
                }
            }
        }
        this.g = false;
    }

    @Override // mctech.d.a, mctech.d.d
    public T b(Direction direction) {
        T tA = a(direction);
        if ((tA instanceof BlockEntity) && ((BlockEntity) tA).isRemoved()) {
            c(direction);
            return null;
        }
        return tA;
    }
}
