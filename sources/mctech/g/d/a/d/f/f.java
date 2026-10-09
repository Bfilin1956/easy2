package mctech.g.d.a.d.f;

import appeng.api.networking.IGridNode;
import appeng.api.networking.IInWorldGridNodeHost;
import appeng.api.networking.IManagedGridNode;
import appeng.api.util.AECableType;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/a/d/f/f.class */
public final class f implements IInWorldGridNodeHost, mctech.g.a.h.c {
    public static final MapCodec<f> b = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(CompoundTag.CODEC.fieldOf("main_node").forGetter((v0) -> {
            return v0.e();
        })).apply(instance, f::new);
    });
    public static final mctech.g.a.h.d<f> c = new mctech.g.a.h.d<>(b, f::new);

    @Nullable
    private IManagedGridNode d;

    @Nullable
    private CompoundTag e;
    private AECableType f;

    public f() {
        this.d = null;
        this.e = null;
        this.f = AECableType.SMART;
    }

    private f(@Nullable CompoundTag compoundTag) {
        this.d = null;
        this.e = null;
        this.f = AECableType.SMART;
        this.e = compoundTag;
    }

    f(@Nullable IManagedGridNode iManagedGridNode, @Nullable CompoundTag compoundTag, boolean z) {
        this.d = null;
        this.e = null;
        this.f = AECableType.SMART;
        this.d = iManagedGridNode;
        this.e = compoundTag;
        this.f = z ? AECableType.DENSE_SMART : AECableType.SMART;
    }

    @Nullable
    public IManagedGridNode b() {
        return this.d;
    }

    public void a(IManagedGridNode iManagedGridNode, boolean z) {
        this.d = iManagedGridNode;
        this.f = z ? AECableType.DENSE_SMART : AECableType.SMART;
    }

    public void c() {
        this.d = null;
        this.f = AECableType.SMART;
    }

    public void d() {
        if (this.d == null) {
            throw new IllegalStateException("mainNode cannot be null.");
        }
        if (this.e == null) {
            return;
        }
        this.d.loadFromNBT(this.e);
        this.e = null;
    }

    private CompoundTag e() {
        CompoundTag compoundTag = new CompoundTag();
        if (this.d != null) {
            this.d.saveToNBT(compoundTag);
        }
        return compoundTag;
    }

    @Override // mctech.g.a.h.c
    public mctech.g.a.h.d<?> a() {
        return c;
    }

    @Nullable
    public IGridNode getGridNode(Direction direction) {
        if (this.d != null) {
            return this.d.getNode();
        }
        return null;
    }

    public AECableType getCableConnectionType(Direction direction) {
        return this.f;
    }
}
