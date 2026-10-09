package mctech.c.a;

import mctech.c.f;
import mctech.c.h;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/c/a/c.class */
public class c implements h {

    @NotNull
    private final BlockEntity a;

    public c(@NotNull BlockEntity blockEntity) {
        this.a = blockEntity;
    }

    @Override // mctech.c.h
    public f a() {
        return new e(this.a.getLevel(), this.a.getBlockPos());
    }

    @Override // mctech.c.h
    public boolean a(@NotNull Level level) {
        return !this.a.isRemoved() && f.a(level, this.a.getLevel());
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public boolean equals(Object obj) {
        return (obj instanceof c) && ((c) obj).a.equals(this.a);
    }
}
