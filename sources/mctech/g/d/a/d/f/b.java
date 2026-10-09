package mctech.g.d.a.d.f;

import appeng.api.networking.IGridNode;
import appeng.api.networking.IInWorldGridNodeHost;
import appeng.api.networking.IManagedGridNode;
import appeng.api.util.AECableType;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import mctech.init.MCTechConduitTypes;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/a/d/f/b.class */
public class b implements IInWorldGridNodeHost, mctech.g.f.a<b> {
    public static final MapCodec<b> a = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(CompoundTag.CODEC.fieldOf("main_node").forGetter((v0) -> {
            return v0.e();
        })).apply(instance, b::new);
    });
    public static final StreamCodec<RegistryFriendlyByteBuf, b> b = mctech.f.a.a(b::new).cast();

    @Nullable
    private IManagedGridNode d;

    @Nullable
    private CompoundTag e;
    private boolean f;

    public b() {
        this.d = null;
        this.e = null;
    }

    public b(@Nullable CompoundTag compoundTag) {
        this.d = null;
        this.e = null;
        this.e = compoundTag;
    }

    @Override // mctech.g.f.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public b h() {
        return this;
    }

    @Override // mctech.g.f.a
    public mctech.g.f.d<b> b() {
        return MCTechConduitTypes.Data.ME.get();
    }

    @Nullable
    public IManagedGridNode c() {
        return this.d;
    }

    public void a(IManagedGridNode iManagedGridNode, boolean z) {
        this.d = iManagedGridNode;
        this.f = z;
    }

    public void d() {
        this.d = null;
        this.f = false;
    }

    protected CompoundTag e() {
        CompoundTag compoundTag = new CompoundTag();
        if (this.d != null) {
            this.d.saveToNBT(compoundTag);
        }
        return compoundTag;
    }

    public void f() {
        if (this.d == null) {
            throw new IllegalStateException("mainNode cannot be null.");
        }
        if (this.e == null) {
            return;
        }
        this.d.loadFromNBT(this.e);
        this.e = null;
    }

    @Nullable
    public IGridNode getGridNode(Direction direction) {
        if (this.d != null) {
            return this.d.getNode();
        }
        return null;
    }

    public AECableType getCableConnectionType(Direction direction) {
        if (this.f) {
            return AECableType.DENSE_SMART;
        }
        return AECableType.SMART;
    }

    @Override // mctech.g.f.a
    public mctech.g.a.h.c g() {
        return new f(this.d, this.e, this.f);
    }
}
