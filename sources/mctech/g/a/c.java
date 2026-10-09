package mctech.g.a;

import java.util.List;
import java.util.function.Consumer;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.items.IItemHandlerModifiable;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/a/c.class */
public interface c {
    List<Holder<a<?, ?>>> a();

    boolean a(Holder<a<?, ?>> holder);

    mctech.g.a.b.a a(Holder<a<?, ?>> holder, @Nullable Direction direction, @Nullable Player player);

    void a(Holder<a<?, ?>> holder, @Nullable Consumer<ItemStack> consumer);

    mctech.g.a.h.a b(Holder<a<?, ?>> holder);

    @Nullable
    CompoundTag c(Holder<a<?, ?>> holder);

    @Nullable
    CompoundTag a(Holder<a<?, ?>> holder, Direction direction);

    boolean d(Holder<a<?, ?>> holder);

    boolean a(m<?> mVar);

    @Nullable
    Holder<a<?, ?>> b(m<?> mVar);

    @Nullable
    Holder<a<?, ?>> e(Holder<a<?, ?>> holder);

    boolean f(Holder<a<?, ?>> holder);

    boolean b();

    boolean c();

    boolean a(Holder<a<?, ?>> holder, Direction direction, boolean z);

    List<Holder<a<?, ?>>> b(Direction direction);

    mctech.g.a.c.f b(Holder<a<?, ?>> holder, Direction direction);

    mctech.g.a.c.c c(Holder<a<?, ?>> holder, Direction direction);

    void a(Holder<a<?, ?>> holder, Direction direction, mctech.g.a.c.c cVar);

    <T extends mctech.g.a.c.c> T a(Holder<a<?, ?>> holder, Direction direction, mctech.g.a.c.e<T> eVar);

    @Nullable
    IItemHandlerModifiable d(Holder<a<?, ?>> holder, Direction direction);

    ItemStack d();

    void a(ItemStack itemStack);

    boolean e();

    Block f();

    mctech.g.a.d.b g();
}
