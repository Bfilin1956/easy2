package mctech.blockentities.b;

import mctech.MCTech;
import mctech.api.energy.tile.IEnergyAcceptor;
import mctech.api.energy.tile.IEnergySource;
import mctech.api.features.ITileActivityProvider;
import mctech.api.features.IWrenchableTile;
import mctech.api.tiles.readers.IEUProducer;
import mctech.api.util.DirectionList;
import mctech.config.ConfigEntry;
import mctech.m.b.S;
import mctech.m.b.au;
import mctech.m.g.y;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/b/i.class */
public class i extends mctech.blockentities.i implements IEnergySource, ITileActivityProvider, IWrenchableTile, IEUProducer, mctech.m.a.k {
    boolean a;
    int b;
    int c;
    public int d;
    public boolean e;

    public i(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState, 1);
        this.a = false;
        this.b = 0;
        this.e = false;
        this.c = a().get();
        this.d = 1;
        this.inventoryManager.a().a(y.c(0).a(DirectionList.HORIZONTAL).a(mctech.m.c.a.c.a).b(mctech.m.c.a.c.b)).i();
        addComparator(mctech.blocks.base.a.a.a.a.c.a("active", mctech.blocks.base.a.a.d.k, this));
    }

    public ConfigEntry.IntValue a() {
        return MCTech.CONFIG.solarPanel;
    }

    @Override // mctech.api.tiles.readers.IEUProducer
    public float getEUProduction() {
        if (isActive()) {
            return this.c;
        }
        return 0.0f;
    }

    @Override // mctech.blockentities.i, mctech.m.a.g
    public void setStackInSlot(int i, ItemStack itemStack) {
        super.setStackInSlot(i, itemStack);
        if (isSimulating() && i == 0) {
            this.e = !itemStack.isEmpty();
        }
    }

    @Override // mctech.m.a.d
    public S createContainer(Player player, InteractionHand interactionHand, Direction direction, int i) {
        return new au(this, player, i);
    }

    @Override // mctech.api.energy.tile.IEnergyEmitter
    public boolean canEmitEnergy(IEnergyAcceptor iEnergyAcceptor, Direction direction) {
        return true;
    }

    @Override // mctech.api.energy.tile.IEnergySource
    public int getSourceTier() {
        return this.d;
    }

    @Override // mctech.api.energy.tile.IEnergySource
    public int getMaxEnergyOutput() {
        return this.c;
    }

    @Override // mctech.api.energy.tile.IEnergySource
    public int getProvidedEnergy() {
        if (isActive()) {
            return this.b;
        }
        return 0;
    }

    @Override // mctech.api.features.IWrenchableTile
    public boolean canSetFacing(Direction direction) {
        return direction != getFacing() && direction.getAxis().isHorizontal();
    }

    @Override // mctech.api.features.IWrenchableTile
    public boolean canRemoveBlock(Player player) {
        return true;
    }

    @Override // mctech.api.features.IWrenchableTile
    public double getDropRate(Player player) {
        return 0.8d;
    }

    public static boolean a(Level level, BlockPos blockPos) {
        if (level.dimensionType().hasSkyLight() && level.isDay() && level.canSeeSkyFromBelowWater(blockPos)) {
            return ((Biome) level.getBiome(blockPos).value()).hasPrecipitation() || !(level.isRaining() || level.isThundering());
        }
        return false;
    }
}
