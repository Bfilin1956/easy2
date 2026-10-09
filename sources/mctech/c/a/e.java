package mctech.c.a;

import mctech.c.f;
import mctech.c.h;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/c/a/e.class */
public class e implements f {

    @NotNull
    private final Level a;

    @NotNull
    private final Vec3 b;

    public e(@NotNull Level level, @NotNull BlockPos blockPos) {
        this(level, Vec3.atLowerCornerOf(blockPos));
    }

    public e(@NotNull Level level, @NotNull Vec3 vec3) {
        this.a = level;
        this.b = vec3;
    }

    @Override // mctech.c.f
    @NotNull
    public Level a() {
        return this.a;
    }

    @Override // mctech.c.f
    @NotNull
    public Vec3 b() {
        return this.b;
    }

    @Nullable
    public static f a(@Nullable Object obj, @NotNull mctech.c.b.a aVar) {
        if (obj instanceof h) {
            return ((h) obj).a();
        }
        if (obj instanceof f) {
            return (f) obj;
        }
        if (obj instanceof Entity) {
            Entity entity = (Entity) obj;
            if (aVar == mctech.c.b.a.STATIC) {
                return new e(entity.getCommandSenderWorld(), entity.position());
            }
            return new a(entity);
        }
        if (!(obj instanceof BlockEntity)) {
            return null;
        }
        BlockEntity blockEntity = (BlockEntity) obj;
        if (blockEntity.getLevel() != null) {
            return new e(blockEntity.getLevel(), blockEntity.getBlockPos());
        }
        return null;
    }
}
