package mctech.g.d.a;

import com.google.common.base.Preconditions;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.Objects;
import java.util.Optional;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.world.item.DyeColor;
import net.neoforged.neoforge.capabilities.BlockCapability;
import net.neoforged.neoforge.items.IItemHandlerModifiable;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/a/c.class */
public final class c implements mctech.g.a.h.a, mctech.l.b<b, c> {
    private static final Codec<c> b = RecordCodecBuilder.create(instance -> {
        return instance.group(BlockPos.CODEC.fieldOf("pos").forGetter((v0) -> {
            return v0.a();
        }), mctech.g.f.c.a.fieldOf("data").forGetter(cVar -> {
            return cVar.f;
        })).apply(instance, c::new);
    });
    private static final Codec<c> c = RecordCodecBuilder.create(instance -> {
        return instance.group(BlockPos.CODEC.fieldOf("pos").forGetter((v0) -> {
            return v0.a();
        }), mctech.g.a.h.c.a.optionalFieldOf("data").forGetter(cVar -> {
            return (cVar.e == null || !cVar.e.a().a()) ? Optional.empty() : Optional.of(cVar.e);
        })).apply(instance, c::new);
    });
    public static final Codec<c> a = Codec.withAlternative(c, b);
    private final BlockPos d;

    @Nullable
    private mctech.g.a.h.c e;

    @Nullable
    private mctech.g.f.c f;

    @Nullable
    private b g;

    @Nullable
    private mctech.g.a.h.b h;
    private Holder<mctech.g.a.a<?, ?>> i;

    public c(Holder<mctech.g.a.a<?, ?>> holder, BlockPos blockPos) {
        this(holder, blockPos, (mctech.g.a.h.c) null);
    }

    public c(Holder<mctech.g.a.a<?, ?>> holder, BlockPos blockPos, @Nullable mctech.g.a.h.c cVar) {
        this.f = null;
        this.d = blockPos;
        this.e = cVar;
        this.g = new b(holder, this);
    }

    public c(Holder<mctech.g.a.a<?, ?>> holder, BlockPos blockPos, mctech.g.f.c cVar) {
        this(holder, blockPos, (mctech.g.a.h.c) null);
        mctech.g.f.a<?> aVarB = cVar.b();
        if (aVarB != null) {
            this.f = cVar;
            this.e = aVarB.g();
        }
    }

    private c(BlockPos blockPos, Optional<mctech.g.a.h.c> optional) {
        this.f = null;
        this.d = blockPos;
        this.e = optional.orElse(null);
    }

    private c(BlockPos blockPos, mctech.g.f.c cVar) {
        this(blockPos, (Optional<mctech.g.a.h.c>) Optional.empty());
        mctech.g.f.a<?> aVarB = cVar.b();
        if (aVarB != null) {
            this.f = cVar;
            this.e = aVarB.g();
        }
    }

    public void a(mctech.g.a.h.b bVar, Holder<mctech.g.a.a<?, ?>> holder) {
        Preconditions.checkState(this.g != null, "Conduit node is not connected to a network.");
        this.h = bVar;
        this.i = holder;
        this.g.a(this);
        n();
    }

    public void g() {
        if (this.h == null || this.i == null) {
            return;
        }
        this.h = null;
        this.i = null;
        if (this.g != null) {
            this.g.a(this);
        }
    }

    public void h() {
        if (this.g != null) {
            this.g.a(this);
        }
    }

    public void i() {
        if (this.g != null) {
            this.g.a(this);
        }
    }

    @Override // mctech.g.a.h.a
    public BlockPos a() {
        return this.d;
    }

    @Override // mctech.g.a.h.a
    public boolean b() {
        return j() && this.h != null && this.i != null && this.h.getLevel() != null && this.h.hasLevel() && this.h.getLevel().isLoaded(this.d);
    }

    @Override // mctech.g.a.h.a
    public boolean c() {
        return b() && this.h.getLevel().shouldTickBlocksAt(this.d);
    }

    @Override // mctech.g.a.h.a
    public void d() {
        if (b()) {
            this.h.h();
        }
    }

    @Override // mctech.g.a.h.a
    public boolean a(mctech.g.a.h.d<?> dVar) {
        return this.e != null && this.e.a() == dVar;
    }

    @Override // mctech.g.a.h.a
    @Nullable
    public mctech.g.a.h.c f() {
        return this.e;
    }

    @Override // mctech.g.a.h.a
    @Nullable
    public <D extends mctech.g.a.h.c> D b(mctech.g.a.h.d<D> dVar) {
        if (this.e != null && dVar == this.e.a()) {
            return (D) this.e;
        }
        return null;
    }

    @Override // mctech.g.a.h.a
    public <D extends mctech.g.a.h.c> D c(mctech.g.a.h.d<D> dVar) {
        if (this.e != null && dVar == this.e.a()) {
            return (D) this.e;
        }
        this.e = dVar.c();
        return (D) this.e;
    }

    @Override // mctech.g.a.h.a
    public <D extends mctech.g.a.h.c> void a(@Nullable D d) {
        this.e = d;
    }

    @Override // mctech.g.a.h.a
    public <TCapability> TCapability a(BlockCapability<TCapability, Direction> blockCapability, Direction direction) {
        m();
        return (TCapability) this.h.a(this.i, blockCapability, direction);
    }

    @Override // mctech.g.a.h.a
    public <TCapability> TCapability b(BlockCapability<TCapability, Void> blockCapability, Direction direction) {
        m();
        return (TCapability) this.h.b(this.i, blockCapability, direction);
    }

    @Override // mctech.g.a.h.a
    public boolean a(@Nullable DyeColor dyeColor) {
        m();
        return this.h.a(dyeColor);
    }

    @Override // mctech.g.a.h.a
    public boolean a(Direction direction) {
        m();
        return this.h.b(this.i, direction).c();
    }

    @Override // mctech.g.a.h.a
    public boolean b(Direction direction) {
        m();
        return this.h.b(this.i, direction).b();
    }

    @Override // mctech.g.a.h.a
    public mctech.g.a.c.c c(Direction direction) {
        m();
        return this.h.c(this.i, direction);
    }

    @Override // mctech.g.a.h.a
    public <T extends mctech.g.a.c.c> T a(Direction direction, mctech.g.a.c.e<T> eVar) {
        m();
        return (T) this.h.a(this.i, direction, eVar);
    }

    @Override // mctech.g.a.h.a
    public IItemHandlerModifiable d(Direction direction) {
        m();
        IItemHandlerModifiable iItemHandlerModifiableD = this.h.d(this.i, direction);
        if (iItemHandlerModifiableD == null) {
            throw new IllegalStateException("This conduit does not have an inventory!");
        }
        return iItemHandlerModifiableD;
    }

    @Override // mctech.l.b
    public boolean j() {
        return this.g != null;
    }

    @Override // mctech.g.a.h.a
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public b e() {
        return (b) Objects.requireNonNull(this.g, "Node is not valid!");
    }

    @Override // mctech.l.b
    public void a(@Nullable b bVar) {
        this.g = bVar;
        n();
    }

    private void m() {
        Preconditions.checkState(this.g != null, "Conduit node is not connected to a network.");
        Preconditions.checkState(this.h != null, "Conduit node is detached.");
        Preconditions.checkState(this.h.hasLevel(), "Conduit bundle is not attached to a level");
        Preconditions.checkState(b(), "Conduit node is not loaded - more specific error unavailable.");
    }

    private void n() {
        if (this.g != null && this.f != null && b()) {
            ((mctech.g.a.a) this.g.j().value()).a(this, this.f, (direction, cVar) -> {
                this.h.a(this.i, direction, cVar);
            });
            this.f = null;
        }
    }
}
