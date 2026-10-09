package mctech.g.d;

import java.util.Arrays;
import net.minecraft.core.Vec3i;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/a.class */
public class a {
    private Vec3i a;
    private Vec3i b;

    public a(Vec3i... vec3iArr) {
        this(new Vec3i(Arrays.stream(vec3iArr).mapToInt((v0) -> {
            return v0.getX();
        }).min().getAsInt(), Arrays.stream(vec3iArr).mapToInt((v0) -> {
            return v0.getY();
        }).min().getAsInt(), Arrays.stream(vec3iArr).mapToInt((v0) -> {
            return v0.getZ();
        }).min().getAsInt()), new Vec3i(Arrays.stream(vec3iArr).mapToInt((v0) -> {
            return v0.getX();
        }).max().getAsInt(), Arrays.stream(vec3iArr).mapToInt((v0) -> {
            return v0.getY();
        }).max().getAsInt(), Arrays.stream(vec3iArr).mapToInt((v0) -> {
            return v0.getZ();
        }).max().getAsInt()));
    }

    private a(Vec3i vec3i, Vec3i vec3i2) {
        this.a = vec3i;
        this.b = vec3i2;
    }

    public void a(Vec3i vec3i) {
        this.a = new Vec3i(Math.min(this.a.getX(), vec3i.getX()), Math.min(this.a.getY(), vec3i.getY()), Math.min(this.a.getZ(), vec3i.getZ()));
        this.b = new Vec3i(Math.max(this.b.getX(), vec3i.getX()), Math.max(this.b.getY(), vec3i.getY()), Math.max(this.b.getZ(), vec3i.getZ()));
    }

    public Vec3i a() {
        return this.a;
    }

    public Vec3i b() {
        return this.b;
    }

    public Vec3i c() {
        return new Vec3i((this.b.getX() - this.a.getX()) + 1, (this.b.getY() - this.a.getY()) + 1, (this.b.getZ() - this.a.getZ()) + 1);
    }

    public boolean b(Vec3i vec3i) {
        return this.a.getX() <= vec3i.getX() && vec3i.getX() <= this.b.getX() && this.a.getY() <= vec3i.getY() && vec3i.getY() <= this.b.getY() && this.a.getZ() <= vec3i.getZ() && vec3i.getZ() <= this.b.getZ();
    }
}
