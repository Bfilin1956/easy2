package mctech.blockentities.c;

import java.util.stream.IntStream;
import mctech.api.features.IWrenchableTile;
import mctech.api.network.buffer.NetworkInfo;
import mctech.api.tiles.readers.IProgressMachine;
import mctech.init.MCTechTiles;
import mctech.m.b.ar;
import net.mcskill.msregistry.core.IMachineTier;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/c/U.class */
public class U extends mctech.blockentities.i implements IWrenchableTile, IProgressMachine, mctech.m.a.k, IMachineTier {
    private static final int a = 1;
    private final MachineTier b;
    private final int c;

    @NetworkInfo(fieldName = "progress")
    private int d;

    public U(BlockPos blockPos, BlockState blockState) {
        this((BlockEntityType) MCTechTiles.SINGULARITY_COLLECTOR.get(), blockPos, blockState);
    }

    public U(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState, 1);
        this.b = blockState.getValue(MachineTier.PROPERTY);
        this.c = a(this.b);
        this.inventoryManager = new mctech.m.e.j<>(this);
        this.inventoryManager.a(mctech.m.g.y.d(IntStream.range(0, 1).toArray()));
        this.inventoryManager.i();
        addNetworkFields(this);
    }

    /* JADX INFO: renamed from: mctech.blockentities.c.U$1, reason: invalid class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/c/U$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[MachineTier.values().length];

        static {
            try {
                a[MachineTier.T3.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[MachineTier.T4.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[MachineTier.T5.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[MachineTier.T6.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                a[MachineTier.T7.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    private static int a(MachineTier machineTier) {
        switch (AnonymousClass1.a[machineTier.ordinal()]) {
            case 1:
                return 1200;
            case 2:
                return 2400;
            case 3:
                return 4800;
            case 4:
                return 9600;
            case 5:
                return 19200;
            default:
                throw new IllegalStateException("Unsupported Singularity Collector tier: " + String.valueOf(machineTier));
        }
    }

    @Override // mctech.api.tiles.readers.IProgressMachine
    public float getProgress() {
        return this.d;
    }

    @Override // mctech.api.tiles.readers.IProgressMachine
    public float getMaxProgress() {
        return this.c;
    }

    @Override // mctech.m.a.d
    public mctech.m.b.S createContainer(Player player, InteractionHand interactionHand, Direction direction, int i) {
        return new ar(this, player, i);
    }

    @NotNull
    public MachineTier machineTier() {
        return this.b;
    }

    @Override // mctech.api.features.IWrenchableTile
    public boolean canSetFacing(Direction direction) {
        return getFacing() != direction;
    }

    @Override // mctech.api.features.IWrenchableTile
    public boolean canRemoveBlock(Player player) {
        return true;
    }

    @Override // mctech.api.features.IWrenchableTile
    public double getDropRate(Player player) {
        return 0.8d;
    }
}
