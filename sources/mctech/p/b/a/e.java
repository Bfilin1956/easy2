package mctech.p.b.a;

import com.google.common.base.Strings;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import java.util.Set;
import mctech.MCTech;
import mctech.api.network.buffer.INetworkDataBuffer;
import mctech.api.network.buffer.NetworkInfo;
import mctech.api.network.tile.INetworkClientEventListener;
import mctech.api.network.tile.INetworkFieldNotifier;
import mctech.api.network.tile.INetworkFieldProvider;
import mctech.api.network.tile.PacketRange;
import mctech.c.g;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.util.Mth;
import net.minecraft.world.Nameable;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.network.PacketDistributor;
import org.jetbrains.annotations.MustBeInvokedByOverriders;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/p/b/a/e.class */
public class e extends mctech.p.b.b implements INetworkClientEventListener, INetworkFieldNotifier, INetworkFieldProvider, Nameable {
    private final boolean a;
    private boolean b;

    @NetworkInfo(fieldName = "isActive")
    private boolean c;

    @NetworkInfo(fieldName = "customName")
    private String d;
    private long e;
    private List<mctech.d.d<?>> f;
    private boolean g;
    private boolean h;
    private boolean i;
    private boolean j;
    private boolean k;
    private boolean l;

    public e(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState);
        this.a = MCTech.PLATFORM.g();
        this.h = false;
        this.i = false;
        this.j = false;
        this.k = false;
        this.l = false;
        this.c = false;
        this.d = "";
        this.f = mctech.utils.a.b.i();
        this.g = false;
        this.b = false;
        this.e = Mth.getSeed(blockPos) & 4294967295L;
        addNetworkFields(this);
    }

    public final boolean r() {
        return this.a;
    }

    public final boolean s() {
        return !r();
    }

    @Override // mctech.api.network.tile.INetworkClientEventListener
    public void onClientDataReceived(Player player, int i, int i2) {
    }

    public void onNetworkFieldChanged(Set<String> set, Player player) {
    }

    @Override // mctech.api.network.tile.INetworkFieldNotifier
    public void onGuiFieldChanged(Set<String> set, Player player) {
    }

    @Override // mctech.api.network.tile.INetworkFieldProvider
    public boolean isDefaultData(String str) {
        if (str.equals("isActive")) {
            return !this.c;
        }
        return str.equals("customName") && Strings.isNullOrEmpty(this.d);
    }

    public boolean hasCustomName() {
        return !Strings.isNullOrEmpty(this.d);
    }

    @NotNull
    public Component getCustomName() {
        return Component.literal(this.d);
    }

    @NotNull
    public Component getName() {
        return Component.translatable(getBlockState().getBlock().getDescriptionId());
    }

    @NotNull
    public Component a(@Nullable Component component) {
        this.d = component == null ? "" : component.toString();
        updateNetworkField(this, "customName");
        return getCustomName();
    }

    public boolean t() {
        return r();
    }

    @Nullable
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override // mctech.p.b.b
    @MustBeInvokedByOverriders
    protected void loadAdditional(@NotNull CompoundTag compoundTag, HolderLookup.Provider provider) {
        super.loadAdditional(compoundTag, provider);
        this.c = compoundTag.getBoolean("isActive");
        this.d = mctech.utils.c.e.a(compoundTag, this.d, "");
    }

    @Override // mctech.p.b.b
    @MustBeInvokedByOverriders
    protected void saveAdditional(@NotNull CompoundTag compoundTag, HolderLookup.Provider provider) {
        super.saveAdditional(compoundTag, provider);
        mctech.utils.c.e.a(compoundTag, "active", this.c, false);
        mctech.utils.c.e.a(compoundTag, "customName", this.d, "");
    }

    public void setRemoved() {
        if (this.h) {
            b(false);
        }
        super.setRemoved();
    }

    public void onChunkUnloaded() {
        if (this.h) {
            b(true);
        }
        super.onChunkUnloaded();
    }

    public void u() {
        this.h = true;
        if (r()) {
            for (mctech.d.d<?> dVar : this.f) {
                if (dVar != null) {
                    dVar.d();
                }
            }
            D();
        }
    }

    public void b(boolean z) {
        this.h = false;
        this.f.clear();
    }

    public void d(boolean z) {
        if (this.level != null) {
            boolean zHasProperty = getBlockState().hasProperty(a.b);
            if (((Boolean) getBlockState().getOptionalValue(a.b).orElse(false)).booleanValue() != z && zHasProperty) {
                this.level.setBlock(getBlockPos(), (BlockState) getBlockState().setValue(a.b, Boolean.valueOf(z)), 2);
            }
        }
        boolean z2 = z != this.c;
        this.c = z;
        if (z2) {
            updateNetworkField(this, "isActive");
        }
    }

    public void v() {
    }

    protected void w() {
    }

    protected boolean x() {
        return this.b;
    }

    protected boolean y() {
        return this.l;
    }

    protected boolean z() {
        return this.k;
    }

    public final boolean A() {
        return this.h;
    }

    public boolean B() {
        return this.c;
    }

    public void a(mctech.d.d<?>... dVarArr) {
        this.f.addAll(ObjectArrayList.wrap(dVarArr));
        for (mctech.d.d<?> dVar : dVarArr) {
            if (dVar != null) {
                dVar.a(this::C);
            }
        }
    }

    protected void C() {
    }

    protected void D() {
    }

    public final long a(int i) {
        if (this.level == null) {
            return -1L;
        }
        return Math.abs(this.level.getGameTime() + this.e) % ((long) i);
    }

    public final boolean b(int i) {
        return a(i) == 0;
    }

    public final boolean c(int i) {
        return !b(i);
    }

    public final boolean d(int i) {
        if (this.level == null) {
            return false;
        }
        return this.level.isAreaLoaded(this.worldPosition, i);
    }

    public final boolean a(BlockPos blockPos, int i) {
        if (this.level == null) {
            return false;
        }
        return this.level.isAreaLoaded(blockPos, i);
    }

    public void a(Block block, BlockPos blockPos) {
    }

    public boolean E() {
        return false;
    }

    public final void a(int i, int i2) {
        PacketDistributor.sendToServer(new mctech.q.d.a.a.C0034a(getBlockPos(), i, i2), new CustomPacketPayload[0]);
    }

    public final void a(Player player, int i, int i2) {
    }

    public final void a(String str, INetworkDataBuffer iNetworkDataBuffer) {
        PacketDistributor.sendToServer(new mctech.q.d.a.c.b(new mctech.q.d.a.c.a(getBlockPos(), str, iNetworkDataBuffer)), new CustomPacketPayload[0]);
    }

    public final void a(String str, INetworkDataBuffer iNetworkDataBuffer, PacketRange packetRange) {
    }

    public final void a(Player player, String str, INetworkDataBuffer iNetworkDataBuffer) {
    }

    public final void F() {
        this.i = true;
    }

    public final void G() {
        this.i = false;
    }

    protected final void a(g gVar, boolean z) {
    }

    protected final void b(g gVar, boolean z) {
    }
}
