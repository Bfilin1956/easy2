package mctech.g.a.j;

import java.util.function.Function;
import mctech.g.a.c.c;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/a/j/a.class */
@ApiStatus.Experimental
public interface a<T extends mctech.g.a.c.c> {
    mctech.g.a.a<?, T> a();

    BlockPos b();

    T c();

    void a(Function<T, T> function);

    @Nullable
    CompoundTag d();
}
