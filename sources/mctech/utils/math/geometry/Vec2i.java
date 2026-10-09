package mctech.utils.math.geometry;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/math/geometry/Vec2i.class */
public class Vec2i {
    public static final Vec2i EMPTY = new Vec2i(-9999, -9999);
    public static final Vec2i ZERO = new Vec2i();
    private int x;
    private int y;

    public Vec2i() {
        this(0, 0);
    }

    public Vec2i(int i) {
        this(i, i);
    }

    public Vec2i(int i, int i2) {
        this.x = i;
        this.y = i2;
    }

    public Vec2i(Vec2i vec2i) {
        this(vec2i.x, vec2i.y);
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setX(int i) {
        this.x = i;
    }

    public void setY(int i) {
        this.y = i;
    }

    public void set(Vec2i vec2i) {
        this.x = vec2i.x;
        this.y = vec2i.y;
    }

    public void set(int i, int i2) {
        this.x = i;
        this.y = i2;
    }

    public Vec2i add(int i, int i2) {
        return new Vec2i(this.x + i, this.y + i2);
    }

    public Vec2i add(Vec2i vec2i) {
        return add(vec2i.x, vec2i.y);
    }

    public Vec2i subtract(int i, int i2) {
        return add(-i, -i2);
    }

    public Vec2i subtract(Vec2i vec2i) {
        return add(-vec2i.x, -vec2i.y);
    }

    public Vec2i abs() {
        return new Vec2i(Math.abs(this.x), Math.abs(this.y));
    }

    public Vec2i multiply(int i) {
        return new Vec2i(this.x * i, this.y * i);
    }

    public Vec2i divide(int i) {
        return i != 0 ? new Vec2i(this.x / i, this.y / i) : this;
    }

    public int distance(int i, int i2) {
        return (int) Math.sqrt(distanceSquared(i, i2));
    }

    public int distance(Vec2i vec2i) {
        return (int) Math.sqrt(distanceSquared(vec2i.x, vec2i.y));
    }

    public int distanceSquared(int i, int i2) {
        return (int) (Math.pow(this.x - i, 2.0d) + Math.pow(this.y - i2, 2.0d));
    }

    public int distanceSquared(Vec2i vec2i) {
        return distanceSquared(vec2i.x, vec2i.y);
    }

    public int length() {
        return (int) Math.sqrt(lengthSquared());
    }

    public int lengthSquared() {
        return (this.x * this.x) + (this.y * this.y);
    }

    public Vec2i normalize() {
        int length = length();
        return length != 0 ? divide(length) : new Vec2i(0, 0);
    }

    public int dot(Vec2i vec2i) {
        return (this.x * vec2i.x) + (this.y * vec2i.y);
    }

    public Vec2i copy() {
        return new Vec2i(this);
    }

    public d toVec2f() {
        return new d(this.x, this.y);
    }

    public c toVec2() {
        return new c(this.x, this.y);
    }

    public float[] toFloatArray() {
        return new float[]{this.x, this.y};
    }

    public int[] toDoubleArray() {
        return new int[]{this.x, this.y};
    }

    public boolean isEmpty() {
        return this.x == -9999 && this.y == -9999;
    }

    public boolean isZero() {
        return this.x == 0 && this.y == 0;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Vec2i) {
            Vec2i vec2i = (Vec2i) obj;
            if (vec2i.x == this.x && vec2i.y == this.y) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Double.hashCode(this.x) + (Double.hashCode(this.y) * 31);
    }

    public String toString() {
        return "Vec2i[x=" + this.x + ", y=" + this.y + "]";
    }
}
