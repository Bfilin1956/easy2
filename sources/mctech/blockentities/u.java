package mctech.blockentities;

import it.unimi.dsi.fastutil.objects.ObjectList;
import java.util.Iterator;
import java.util.List;
import mctech.MCTech;
import mctech.api.energy.tile.IEnergyAcceptor;
import mctech.api.energy.tile.IEnergySource;
import mctech.api.energy.tile.IEnergyTile;
import mctech.api.energy.tile.IMultiEnergyTile;
import mctech.api.reactor.IReactorChamber;
import mctech.api.tiles.readers.IEUProducer;
import mctech.api.util.DirectionList;
import mctech.energy.EnergyNetworks;
import mctech.init.MCTechFluids;
import mctech.init.MCTechTiles;
import net.mcskill.msregistry.core.IMachineTier;
import net.mcskill.msregistry.core.MachineTier;
import net.mcskill.msregistry.registry.holder.LFluid;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.fluids.FluidType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/u.class */
public class u extends m implements IEnergySource, IMultiEnergyTile, IEUProducer, IMachineTier {
    boolean t;
    private int w;
    private boolean x;
    protected MachineTier u;
    protected LFluid<FluidType> v;

    public u(BlockPos blockPos, BlockState blockState) {
        this(blockPos, blockState, blockState.getValue(MachineTier.PROPERTY));
    }

    public u(BlockPos blockPos, BlockState blockState, MachineTier machineTier) {
        super((BlockEntityType) MCTechTiles.NUCLEAR_REACTOR.get(), blockPos, blockState, b(machineTier), c(machineTier));
        this.w = 1;
        this.x = true;
        this.v = a(machineTier);
        this.t = false;
        this.u = machineTier;
    }

    @Override // mctech.blockentities.m
    public void a() {
        super.a();
        this.c.setValidator(fluidStack -> {
            return (this.v == null || fluidStack.isEmpty() || !fluidStack.is((FluidType) this.v.get())) ? false : true;
        });
    }

    @Override // mctech.api.energy.tile.IEnergyEmitter
    public boolean canEmitEnergy(IEnergyAcceptor iEnergyAcceptor, Direction direction) {
        return true;
    }

    @Override // mctech.api.energy.tile.IEnergySource
    public int getSourceTier() {
        return EnergyNetworks.getTierFromPower(getProvidedEnergy());
    }

    @Override // mctech.api.energy.tile.IEnergySource
    public int getMaxEnergyOutput() {
        return Integer.MAX_VALUE;
    }

    @Override // mctech.api.energy.tile.IEnergySource
    public int getProvidedEnergy() {
        int i = (int) (this.f * MCTech.CONFIG.reactorOutput.get());
        if (i <= 0 || (!isRemoved() && h())) {
            return i;
        }
        return 0;
    }

    private boolean h() {
        if (this.level == null) {
            return false;
        }
        int i = this.w;
        this.w = i + 1;
        if (i % 10 == 0) {
            this.x = this.level.isLoaded(getBlockPos());
            this.w = 1;
        }
        return this.x;
    }

    @Override // mctech.api.tiles.readers.IEUProducer
    public float getEUProduction() {
        return getProvidedEnergy();
    }

    @Override // mctech.api.energy.tile.IMultiEnergyTile
    public List<IEnergyTile> getTiles() {
        ObjectList objectListI = mctech.utils.a.b.i();
        objectListI.add(this);
        Iterator<Direction> it = DirectionList.ALL.iterator();
        while (it.hasNext()) {
            IEnergyTile neighborTile = DirectionList.getNeighborTile(this, it.next());
            if ((neighborTile instanceof IReactorChamber) && (neighborTile instanceof IEnergyTile)) {
                objectListI.add(neighborTile);
            }
        }
        return objectListI;
    }

    @Override // mctech.blockentities.q, mctech.api.features.IWrenchableTile
    public void setFacing(Direction direction) {
    }

    @NotNull
    public MachineTier machineTier() {
        return this.u;
    }

    @Nullable
    private static LFluid<FluidType> a(MachineTier machineTier) {
        return MCTechFluids.LIQUID_COOLANT;
    }

    /* JADX INFO: renamed from: mctech.blockentities.u$1, reason: invalid class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/u$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[MachineTier.values().length];

        static {
            try {
                a[MachineTier.T1.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[MachineTier.T2.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[MachineTier.T3.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    private static int b(MachineTier machineTier) {
        switch (AnonymousClass1.a[machineTier.ordinal()]) {
            case 1:
                return 10000;
            case 2:
                return 15000;
            case 3:
                return 22500;
            default:
                return 0;
        }
    }

    private static int c(MachineTier machineTier) {
        switch (AnonymousClass1.a[machineTier.ordinal()]) {
            case 1:
                return 54;
            case 2:
                return 60;
            case 3:
                return 66;
            default:
                return 0;
        }
    }
}
