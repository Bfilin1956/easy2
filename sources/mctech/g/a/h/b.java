package mctech.g.a.h;

import mctech.g.a.c.e;
import mctech.g.a.c.f;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.capabilities.BlockCapability;
import net.neoforged.neoforge.items.IItemHandlerModifiable;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/a/h/b.class */
public interface b {
    boolean hasLevel();

    @Nullable
    Level getLevel();

    void h();

    @Nullable
    <TCapability> TCapability a(Holder<mctech.g.a.a<?, ?>> holder, BlockCapability<TCapability, Direction> blockCapability, Direction direction);

    @Nullable
    <TCapability> TCapability b(Holder<mctech.g.a.a<?, ?>> holder, BlockCapability<TCapability, Void> blockCapability, Direction direction);

    boolean a(@Nullable DyeColor dyeColor);

    f b(Holder<mctech.g.a.a<?, ?>> holder, Direction direction);

    mctech.g.a.c.c c(Holder<mctech.g.a.a<?, ?>> holder, Direction direction);

    <T extends mctech.g.a.c.c> T a(Holder<mctech.g.a.a<?, ?>> holder, Direction direction, e<T> eVar);

    void a(Holder<mctech.g.a.a<?, ?>> holder, Direction direction, mctech.g.a.c.c cVar);

    @Nullable
    IItemHandlerModifiable d(Holder<mctech.g.a.a<?, ?>> holder, Direction direction);
}
