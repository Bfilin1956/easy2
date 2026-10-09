package mctech.c.a;

import mctech.c.f;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/c/a/a.class */
public class a implements f {

    @NotNull
    private final Entity a;

    public a(@NotNull Entity entity) {
        this.a = entity;
    }

    @Override // mctech.c.f
    @NotNull
    public Level a() {
        return this.a.level();
    }

    @Override // mctech.c.f
    @NotNull
    public Vec3 b() {
        return this.a.position();
    }
}
