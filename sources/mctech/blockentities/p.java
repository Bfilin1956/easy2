package mctech.blockentities;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import mctech.MCTech;
import mctech.api.energy.tile.IEnergyEmitter;
import mctech.api.energy.tile.IEnergySink;
import mctech.api.features.ITileActivityProvider;
import mctech.api.features.IWrenchableTile;
import mctech.api.network.buffer.NetworkInfo;
import mctech.api.network.tile.INetworkClientEventListener;
import mctech.api.tiles.readers.IEUStorage;
import mctech.blockentities.c.C0074u;
import mctech.init.MCTechTiles;
import mctech.m.b.C0150j;
import mctech.m.b.S;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.network.PacketDistributor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/p.class */
public class p extends q implements IEnergySink, ITileActivityProvider, IWrenchableTile, INetworkClientEventListener, IEUStorage, mctech.m.a.k {
    public static final int a = 0;

    @NetworkInfo(fieldName = "energyStored")
    private int c;

    @NetworkInfo(fieldName = "energyCapacity")
    private int d;

    @NetworkInfo(fieldName = "energyUsage")
    private int e;

    @NetworkInfo(fieldName = "owner")
    @Nullable
    public UUID b;

    @NetworkInfo(fieldName = "networkName")
    private String f;

    @NetworkInfo(fieldName = "teleportName")
    private String g;
    private final List<mctech.blockentities.f.e> h;

    @Nullable
    private mctech.blockentities.f.e i;

    public p(BlockPos blockPos, BlockState blockState) {
        this((BlockEntityType) MCTechTiles.BASE_TELEPORTER.get(), blockPos, blockState);
    }

    public p(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState);
        this.h = new ArrayList();
        this.f = "default";
        this.g = "Мой телепорт";
        this.c = 0;
        this.d = C0074u.e;
        this.e = 4000;
        addNetworkFields(this);
    }

    public void a(@NotNull Player player) {
        a(player.getUUID());
    }

    public void a(@NotNull UUID uuid) {
        this.b = uuid;
        updateNetworkFields(this);
        c();
        setChanged();
    }

    public boolean b(@NotNull Player player) {
        if (MCTech.PLATFORM.a(player.getUUID())) {
            return true;
        }
        return this.b != null && this.b.equals(player.getUUID());
    }

    public String a() {
        return this.f;
    }

    public String b() {
        return this.g;
    }

    public void a(String str) {
        this.f = str;
    }

    public void b(String str) {
        this.g = str;
    }

    public void c() {
        if (this.b == null) {
            return;
        }
        a(mctech.blockentities.f.g.a().a(this.b));
    }

    public void a(List<mctech.blockentities.f.e> list) {
        this.h.clear();
        this.h.addAll(list.stream().filter(eVar -> {
            return eVar.d().equals(this.f);
        }).filter(eVar2 -> {
            return ((Boolean) f().map(eVar2 -> {
                return Boolean.valueOf(!eVar2.a().equals(eVar2.a()));
            }).orElse(true)).booleanValue();
        }).toList());
        d();
    }

    public void d() {
        if (FMLEnvironment.dist.isDedicatedServer()) {
            ServerLevel serverLevel = this.level;
            if (serverLevel instanceof ServerLevel) {
                PacketDistributor.sendToPlayersTrackingChunk(serverLevel, new ChunkPos(this.worldPosition), new mctech.q.d.n(this.worldPosition, new ArrayList(this.h)), new CustomPacketPayload[0]);
            }
        }
    }

    public void e() {
        if (this.level == null || this.b == null) {
            return;
        }
        mctech.blockentities.f.e eVar = new mctech.blockentities.f.e(this.f, this.g, this.level.dimension(), this.worldPosition, this.b);
        if (this.i != null) {
            mctech.blockentities.f.g gVarA = mctech.blockentities.f.g.a();
            gVarA.b(this.i);
            gVarA.a(eVar);
        } else {
            mctech.blockentities.f.g.a().a(eVar);
        }
        this.i = eVar;
        setChanged();
    }

    public Optional<mctech.blockentities.f.e> f() {
        return Optional.ofNullable(this.i);
    }

    public List<mctech.blockentities.f.e> g() {
        return this.h;
    }

    public void a(String str, String str2) {
        String str3 = this.f;
        this.f = str;
        this.g = str2;
        e();
        c();
        setChanged();
        if (this.level != null && (this.level instanceof ServerLevel)) {
            mctech.blockentities.f.g.a().e(str3).forEach(eVar -> {
                if (eVar.c().equals(this.worldPosition)) {
                    return;
                }
                BlockEntity blockEntity = this.level.getBlockEntity(eVar.c());
                if (blockEntity instanceof p) {
                    ((p) blockEntity).c();
                }
            });
            mctech.blockentities.f.g.a().e(str).forEach(eVar2 -> {
                if (eVar2.c().equals(this.worldPosition)) {
                    return;
                }
                BlockEntity blockEntity = this.level.getBlockEntity(eVar2.c());
                if (blockEntity instanceof p) {
                    ((p) blockEntity).c();
                }
            });
        }
    }

    @Override // mctech.m.a.d
    public S createContainer(Player player, InteractionHand interactionHand, Direction direction, int i) {
        return new C0150j(this, player, i);
    }

    @Override // mctech.blockentities.q
    public void onLoaded() {
        super.onLoaded();
        if (isSimulating()) {
            e();
            c();
        }
    }

    @Override // mctech.blockentities.q, mctech.api.network.tile.INetworkClientEventListener
    public void onClientDataReceived(Player player, int i, int i2) {
    }

    @Override // mctech.api.features.IWrenchableTile
    public boolean canSetFacing(Direction direction) {
        return direction != getFacing();
    }

    @Override // mctech.api.features.IWrenchableTile
    public boolean canRemoveBlock(Player player) {
        return true;
    }

    @Override // mctech.api.features.IWrenchableTile
    public double getDropRate(Player player) {
        return 0.75d;
    }

    @Override // mctech.api.tiles.readers.IEUStorage
    public int getStoredEU() {
        return this.c;
    }

    @Override // mctech.api.tiles.readers.IEUStorage
    public int getMaxEU() {
        return this.d;
    }

    public boolean a(int i) {
        return this.c >= i;
    }

    public void b(int i) {
        this.c -= i;
        updateNetworkField(this, "energyStored");
    }

    public int h() {
        return this.e;
    }

    @Override // mctech.api.tiles.readers.IEUStorage
    public int getTier() {
        return 2;
    }

    @Override // mctech.api.energy.tile.IEnergyAcceptor
    public boolean canAcceptEnergy(IEnergyEmitter iEnergyEmitter, Direction direction) {
        return true;
    }

    @Override // mctech.api.energy.tile.IEnergySink
    public int getSinkTier() {
        return 2;
    }
}
