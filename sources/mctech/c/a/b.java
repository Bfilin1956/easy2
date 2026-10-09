package mctech.c.a;

import mctech.c.f;
import mctech.c.h;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/c/a/b.class */
public class b implements h {

    @NotNull
    private final Entity a;

    @NotNull
    private final mctech.c.b.a b;

    public b(@NotNull Entity entity, mctech.c.b.a aVar) {
        this.a = entity;
        this.b = aVar;
    }

    @Override // mctech.c.h
    public f a() {
        return e.a(this.a, this.b);
    }

    @Override // mctech.c.h
    public boolean a(@NotNull Level level) {
        return this.a.isAlive() && f.a(level, this.a.getCommandSenderWorld());
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public boolean equals(Object obj) {
        return (obj instanceof b) && ((b) obj).a == this.a;
    }
}
