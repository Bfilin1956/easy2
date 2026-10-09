package mctech.blockentities.b;

import java.util.Objects;
import java.util.Set;
import mctech.api.energy.tile.IEnergySource;
import mctech.api.energy.tile.IMultiEnergySource;
import mctech.api.features.ITileActivityProvider;
import mctech.api.features.IWrenchableTile;
import mctech.api.network.buffer.NetworkInfo;
import mctech.api.tiles.readers.IEUProducer;
import mctech.blockentities.c.C0074u;
import mctech.m.b.C0147g;
import mctech.m.b.S;
import net.mcskill.msregistry.core.IMachineTier;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/b/a.class */
public abstract class a extends mctech.blockentities.g implements IEnergySource, IMultiEnergySource, ITileActivityProvider, IWrenchableTile, IEUProducer, mctech.m.a.k, IMachineTier {
    int h;
    public int i;

    @NetworkInfo(fieldName = "lowerProduction")
    protected int j;
    protected int k;

    @NetworkInfo(fieldName = "maxOutput")
    int l;

    @NetworkInfo(fieldName = "day")
    boolean m;
    int n;
    int o;
    protected int p;

    @NetworkInfo(fieldName = "isTransformator")
    public boolean q;
    public boolean r;

    @NetworkInfo(fieldName = "basicMaxOutput")
    public int s;

    @NetworkInfo(fieldName = "cMaxStorage")
    public int t;

    @NetworkInfo(fieldName = "packetCount")
    public int u;

    @NetworkInfo(fieldName = "energyPacket")
    public int v;
    protected boolean w;
    protected Set<Direction> x;
    private boolean y;

    public a(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState, int i2) {
        super(blockEntityType, blockPos, blockState, i2);
        this.m = true;
        this.p = 0;
        this.q = false;
        this.r = false;
        this.t = 1;
        this.u = 1;
        this.v = 32;
        this.w = false;
        this.y = false;
        this.i = 1;
        this.e = 0;
        this.h = 127;
        this.d = 32;
        this.n = 32;
        this.o = 32;
        this.j = 0;
        this.c = 32;
        this.l = 32;
        this.s = 32;
        this.k = 8;
        addComparator(mctech.blocks.base.a.a.a.a.c.a("active", mctech.blocks.base.a.a.d.k, this));
        this.x = Set.of(Direction.DOWN);
        addGuiFields(this);
    }

    @Override // mctech.api.energy.tile.IEnergyEmitter
    public boolean canEmitEnergy(Direction direction) {
        return super.canEmitEnergy(direction);
    }

    @Override // mctech.blockentities.i, mctech.m.e.e
    public boolean allowsUI() {
        return false;
    }

    @Override // mctech.api.energy.tile.IMultiEnergySource
    public boolean hasMultiplePackets() {
        return true;
    }

    @Override // mctech.api.energy.tile.IMultiEnergySource
    public int getPacketCount() {
        return this.u;
    }

    @Override // mctech.api.features.redstone.IComparable
    public boolean isAllowingUI() {
        return false;
    }

    @Override // mctech.m.a.d
    public S createContainer(Player player, InteractionHand interactionHand, Direction direction, int i2) {
        return new C0147g(this, player, i2);
    }

    @Override // mctech.blockentities.g, mctech.api.energy.tile.IEnergySource
    public int getMaxEnergyOutput() {
        return this.l;
    }

    @Override // mctech.blockentities.g
    public boolean e() {
        if (l()) {
            if (m()) {
                this.b += this.d;
                return true;
            }
            this.b += this.j;
            return true;
        }
        return false;
    }

    protected int j() {
        return this.k;
    }

    public void a(int i2) {
        this.b -= i2;
    }

    public int k() {
        if (l()) {
            if (this.m) {
                return this.d;
            }
            return this.j;
        }
        return 0;
    }

    public boolean l() {
        return getLevel().canSeeSkyFromBelowWater(getPosition().above()) && getLevel().dimensionType().hasSkyLight();
    }

    public boolean m() {
        return a((Level) Objects.requireNonNull(this.level), getPosition().above());
    }

    public static boolean a(@NotNull Level level, BlockPos blockPos) {
        if (level.isDay()) {
            return ((Biome) level.getBiome(blockPos).value()).getPrecipitationAt(blockPos) == Biome.Precipitation.NONE || !(level.isRaining() || level.isThundering());
        }
        return false;
    }

    public boolean n() {
        return this.m;
    }

    @Override // mctech.blockentities.g, mctech.api.features.IWrenchableTile
    public double getDropRate(Player player) {
        return 1.0d;
    }

    @Override // mctech.api.tiles.readers.IEUProducer
    public float getEUProduction() {
        if (m()) {
            return Math.clamp(this.b, 0, this.d);
        }
        return Math.clamp(this.b, 0, this.j);
    }

    @Override // mctech.blockentities.g, mctech.api.tiles.readers.IEUStorage
    public int getStoredEU() {
        if (k() >= this.t) {
            return this.t;
        }
        return super.getStoredEU();
    }

    @Override // mctech.blockentities.g, mctech.api.energy.tile.IEnergySource
    public int getProvidedEnergy() {
        return Math.clamp(this.b, 0, this.l);
    }

    @Override // mctech.blockentities.g, mctech.api.tiles.readers.IEUStorage
    public int getMaxEU() {
        return this.t;
    }

    @Override // mctech.blockentities.g
    protected void f() {
    }

    @Override // mctech.blockentities.g
    public boolean c() {
        return false;
    }

    @Override // mctech.api.tiles.readers.IFuelStorage
    public int getMaxFuel() {
        return 0;
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/b/a$j.class */
    public static class j extends a {
        public j(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
            super(blockEntityType, blockPos, blockState, 6);
            this.e = 0;
            this.i = 0;
            this.d = 1;
            this.j = 0;
            this.c = 1;
            this.l = 1;
            this.s = 1;
            this.n = 1;
            this.o = 1;
            this.k = 0;
            this.v = this.l;
        }

        @NotNull
        public MachineTier machineTier() {
            return MachineTier.T1;
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/b/a$i.class */
    public static class i extends a {
        public i(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
            super(blockEntityType, blockPos, blockState, 6);
            this.e = 0;
            this.i = 0;
            this.d = 8;
            this.j = 0;
            this.c = 8;
            this.l = 8;
            this.s = 8;
            this.n = 8;
            this.o = 8;
            this.k = 0;
            this.v = this.l;
        }

        @NotNull
        public MachineTier machineTier() {
            return MachineTier.T2;
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/b/a$b.class */
    public static class b extends a {
        public b(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
            super(blockEntityType, blockPos, blockState, 6);
            this.i = 1;
            this.e = 0;
            this.h = 127;
            this.d = 32;
            this.n = 32;
            this.o = 32;
            this.j = 0;
            this.c = 32;
            this.l = 32;
            this.s = 32;
            this.k = 8;
        }

        @NotNull
        public MachineTier machineTier() {
            return MachineTier.T3;
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/b/a$d.class */
    public static class d extends a {
        public d(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
            super(blockEntityType, blockPos, blockState, 6);
            this.e = 0;
            this.i = 1;
            this.d = 128;
            this.j = 0;
            this.c = 128;
            this.l = 128;
            this.s = 128;
            this.n = 128;
            this.o = 128;
            this.v = this.l;
            this.k = 32;
        }

        @NotNull
        public MachineTier machineTier() {
            return MachineTier.NONE;
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/b/a$f.class */
    public static class f extends a {
        public f(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
            super(blockEntityType, blockPos, blockState, 6);
            this.e = 0;
            this.i = 2;
            this.d = mctech.q.c.c;
            this.j = 0;
            this.c = mctech.q.c.c;
            this.l = mctech.q.c.c;
            this.s = mctech.q.c.c;
            this.n = mctech.q.c.c;
            this.o = mctech.q.c.c;
            this.v = this.l;
            this.k = 128;
        }

        @NotNull
        public MachineTier machineTier() {
            return MachineTier.NONE;
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/b/a$c.class */
    public static class c extends a {
        public c(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
            super(blockEntityType, blockPos, blockState, 6);
            this.e = 0;
            this.i = 2;
            this.d = 2048;
            this.j = 0;
            this.c = 2048;
            this.l = 2048;
            this.s = 2048;
            this.n = 2048;
            this.o = 2048;
            this.v = this.l;
            this.k = mctech.q.c.c;
        }

        @NotNull
        public MachineTier machineTier() {
            return MachineTier.T4;
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/b/a$e.class */
    public static class e extends a {
        public e(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
            super(blockEntityType, blockPos, blockState, 6);
            this.e = 0;
            this.i = 3;
            this.d = 4096;
            this.j = 0;
            this.c = 4096;
            this.l = 4096;
            this.s = 4096;
            this.n = 4096;
            this.o = 4096;
            this.v = this.l;
            this.k = 1024;
        }

        @NotNull
        public MachineTier machineTier() {
            return MachineTier.T5;
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/b/a$g.class */
    public static class g extends a {
        public g(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
            super(blockEntityType, blockPos, blockState, 6);
            this.e = 0;
            this.i = 3;
            this.d = mctech.q.c.a;
            this.j = 0;
            this.c = mctech.q.c.a;
            this.l = mctech.q.c.a;
            this.s = mctech.q.c.a;
            this.n = mctech.q.c.a;
            this.o = mctech.q.c.a;
            this.v = this.l;
            this.k = 2048;
        }

        @NotNull
        public MachineTier machineTier() {
            return MachineTier.T6;
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/b/a$h.class */
    public static class h extends a {
        public h(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
            super(blockEntityType, blockPos, blockState, 6);
            this.e = 0;
            this.i = 4;
            this.d = C0074u.o;
            this.j = 0;
            this.c = C0074u.o;
            this.l = C0074u.o;
            this.s = C0074u.o;
            this.n = C0074u.o;
            this.o = C0074u.o;
            this.v = this.l;
            this.k = 4096;
        }

        @NotNull
        public MachineTier machineTier() {
            return MachineTier.T7;
        }
    }

    /* JADX INFO: renamed from: mctech.blockentities.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/b/a$a.class */
    public static class C0001a extends a {
        public C0001a(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
            super(blockEntityType, blockPos, blockState, 6);
            this.e = 0;
            this.i = 5;
            this.d = 32768;
            this.j = 0;
            this.c = 32768;
            this.l = 32768;
            this.s = 32768;
            this.n = 32768;
            this.o = 32768;
            this.k = C0074u.o;
            this.v = this.l;
            this.p = mctech.q.c.a;
        }

        @NotNull
        public MachineTier machineTier() {
            return MachineTier.T8;
        }
    }

    public void o() {
        this.r = true;
    }

    public void p() {
        this.q = true;
    }

    public void b(int i2) {
        this.c = this.o * i2;
    }

    public void a(float f2) {
        this.d = (int) (this.n * f2);
    }

    public void b(float f2) {
        if (this.y) {
            this.j = (int) (this.n * f2);
        }
    }
}
