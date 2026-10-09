package mctech.blockentities;

import mctech.api.energy.tile.IEnergyAcceptor;
import mctech.api.energy.tile.IEnergySource;
import mctech.api.features.ITileActivityProvider;
import mctech.api.features.IWrenchableTile;
import mctech.api.network.buffer.NetworkInfo;
import mctech.api.tiles.readers.IEUProducer;
import mctech.api.tiles.readers.IEUStorage;
import mctech.api.tiles.readers.IFuelStorage;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/g.class */
public abstract class g extends i implements IEnergySource, ITileActivityProvider, IWrenchableTile, IEUProducer, IEUStorage, IFuelStorage, mctech.m.a.k {

    @NetworkInfo(fieldName = "fuel")
    public int a;

    @NetworkInfo(fieldName = "storage")
    public int b;
    public int c;

    @NetworkInfo(fieldName = "production")
    public int d;
    public int e;
    int f;
    boolean g;

    public g(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState, int i) {
        super(blockEntityType, blockPos, blockState, i);
        this.a = 0;
        this.b = 0;
        this.e = 1;
        this.f = 0;
        this.g = false;
        addGuiFields(this);
        addComparator(new mctech.blocks.base.a.a.a.a.b("eu_storage", mctech.blocks.base.a.a.d.e, this));
        addComparator(new mctech.blocks.base.a.a.a.a.d("fuel", mctech.blocks.base.a.a.d.f, this));
    }

    public ResourceLocation a() {
        return null;
    }

    public int getStoredEU() {
        return this.b;
    }

    public int getMaxEU() {
        return this.c;
    }

    @Override // mctech.api.tiles.readers.IEUStorage
    public int getTier() {
        return this.e;
    }

    public int getFuel() {
        return this.a;
    }

    protected boolean b() {
        return isActive();
    }

    @Override // mctech.api.energy.tile.IEnergyEmitter
    public boolean canEmitEnergy(IEnergyAcceptor iEnergyAcceptor, Direction direction) {
        return true;
    }

    @Override // mctech.api.energy.tile.IEnergySource
    public int getSourceTier() {
        return this.e;
    }

    public int getMaxEnergyOutput() {
        return this.d;
    }

    public int getProvidedEnergy() {
        return Math.min(this.b, this.d);
    }

    public boolean c() {
        return this.a <= 0 && this.b + this.d <= this.c;
    }

    public boolean d() {
        return this.a > 0 && this.b + this.d <= this.c;
    }

    public boolean e() {
        return false;
    }

    protected void f() {
        this.a--;
    }

    @Override // mctech.blockentities.i, mctech.m.a.g
    public void setStackInSlot(int i, ItemStack itemStack) {
        super.setStackInSlot(i, itemStack);
        if (isSimulating() && i == 0) {
            this.g = !itemStack.isEmpty();
        }
    }

    public boolean g() {
        return false;
    }

    public boolean h() {
        return false;
    }

    public int i() {
        return 120;
    }

    @Override // mctech.api.features.IWrenchableTile
    public boolean canRemoveBlock(Player player) {
        return true;
    }

    public double getDropRate(Player player) {
        return 0.85d - (0.05d * ((double) this.e));
    }

    @Override // mctech.api.features.IWrenchableTile
    public boolean canSetFacing(Direction direction) {
        return direction.getAxis().isHorizontal() && direction != getFacing();
    }
}
