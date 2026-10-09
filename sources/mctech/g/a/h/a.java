package mctech.g.a.h;

import mctech.g.a.c.e;
import mctech.g.a.i;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.DyeColor;
import net.neoforged.neoforge.capabilities.BlockCapability;
import net.neoforged.neoforge.items.IItemHandlerModifiable;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/a/h/a.class */
@ApiStatus.AvailableSince("8.0.0")
public interface a {
    BlockPos a();

    boolean b();

    boolean c();

    void d();

    i e();

    boolean a(d<?> dVar);

    @Nullable
    c f();

    @Nullable
    <T extends c> T b(d<T> dVar);

    <T extends c> T c(d<T> dVar);

    <T extends c> void a(@Nullable T t);

    @Nullable
    <TCapability> TCapability a(BlockCapability<TCapability, Direction> blockCapability, Direction direction);

    @Nullable
    <TCapability> TCapability b(BlockCapability<TCapability, Void> blockCapability, Direction direction);

    boolean a(@Nullable DyeColor dyeColor);

    boolean a(Direction direction);

    boolean b(Direction direction);

    mctech.g.a.c.c c(Direction direction);

    <T extends mctech.g.a.c.c> T a(Direction direction, e<T> eVar);

    IItemHandlerModifiable d(Direction direction);
}
