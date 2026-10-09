package mctech.g.f;

import com.mojang.serialization.Codec;
import java.util.Objects;
import java.util.Optional;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.NbtOps;
import net.minecraft.nbt.Tag;
import net.minecraft.util.ExtraCodecs;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/f/c.class */
@Deprecated(since = "8.0.0")
public class c implements b {
    public static final Codec<c> a = ExtraCodecs.optionalEmptyMap(a.c).xmap(c::new, cVar -> {
        return Optional.ofNullable(cVar.b);
    });

    @Nullable
    private a<?> b;

    public c() {
    }

    public c(@Nullable a<?> aVar) {
        this.b = aVar;
    }

    private c(Optional<a<?>> optional) {
        this.b = optional.orElse(null);
    }

    public boolean a() {
        return this.b != null;
    }

    @Override // mctech.g.f.b
    public boolean a(d<?> dVar) {
        return this.b != null && this.b.b() == dVar;
    }

    @Nullable
    public a<?> b() {
        return this.b;
    }

    @Override // mctech.g.f.b
    @Nullable
    public <T extends a<T>> T b(d<T> dVar) {
        if (this.b != null && dVar == this.b.b()) {
            return (T) this.b;
        }
        return null;
    }

    @Override // mctech.g.f.b
    public <T extends a<T>> T c(d<T> dVar) {
        if (this.b != null && dVar == this.b.b()) {
            return (T) this.b;
        }
        this.b = dVar.c().get();
        return (T) this.b;
    }

    public Tag a(HolderLookup.Provider provider) {
        return (Tag) a.encodeStart(provider.createSerializationContext(NbtOps.INSTANCE), this).getPartialOrThrow();
    }

    public static c a(HolderLookup.Provider provider, Tag tag) {
        return (c) a.parse(provider.createSerializationContext(NbtOps.INSTANCE), tag).getPartialOrThrow();
    }

    public c c() {
        return new c((a<?>) (this.b == null ? null : this.b.h()));
    }

    public int hashCode() {
        return Objects.hash(this.b);
    }
}
