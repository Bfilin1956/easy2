package mctech.d;

import java.util.Arrays;
import mctech.api.util.DirectionList;
import mctech.api.util.ILocation;
import net.minecraft.core.Direction;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/d/a.class */
public abstract class a<T> implements d<T> {
    protected ILocation a;
    protected DirectionList b;
    protected Runnable c;
    protected T[] d = (T[]) new Object[6];
    protected DirectionList e = DirectionList.EMPTY;

    public a(ILocation iLocation, DirectionList directionList) {
        this.a = iLocation;
        this.b = directionList;
    }

    @Override // mctech.d.d
    public void a(Runnable runnable) {
        this.c = runnable;
    }

    @Override // mctech.d.d
    public void a() {
        if (this.c != null) {
            this.c.run();
        }
    }

    @Override // mctech.d.d
    public void b() {
        this.e = DirectionList.EMPTY;
        Arrays.fill(this.d, (Object) null);
    }

    protected T a(Direction direction) {
        return this.d[direction.get3DDataValue()];
    }

    @Override // mctech.d.d
    public T b(Direction direction) {
        return this.d[direction.get3DDataValue()];
    }

    @Override // mctech.d.d
    public DirectionList c() {
        return this.e;
    }

    protected void a(Direction direction, T t) {
        this.d[direction.get3DDataValue()] = t;
        if (t != null) {
            this.e = this.e.add(direction);
        }
    }

    protected void c(Direction direction) {
        this.d[direction.get3DDataValue()] = null;
        this.e = this.e.remove(direction);
        a();
    }
}
