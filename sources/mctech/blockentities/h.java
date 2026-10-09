package mctech.blockentities;

import java.util.EnumSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;
import mctech.api.features.IInventoryMachine;
import mctech.api.features.IWrenchableTile;
import mctech.api.heat.IHeatingMachine;
import mctech.api.items.IUpgradeItem;
import mctech.api.network.buffer.NetworkInfo;
import mctech.api.tiles.readers.IProgressMachine;
import mctech.api.util.DirectionList;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.items.IItemHandler;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/h.class */
public abstract class h<Input extends RecipeInput, R extends Recipe<Input>> extends i implements IInventoryMachine, IWrenchableTile, IHeatingMachine, IProgressMachine, mctech.m.a.k {

    @NetworkInfo(fieldName = "heatLevel")
    public int a;

    @NetworkInfo(fieldName = "maxHeatLevel")
    public int b;
    public int c;
    public int d;

    @NetworkInfo(fieldName = "progress")
    public float e;

    @NetworkInfo(fieldName = "maxProgress")
    public float f;

    @NetworkInfo(fieldName = "isHeating")
    public boolean g;

    @NetworkInfo(fieldName = "isProcessing")
    public boolean h;

    @NetworkInfo(fieldName = "isOverheating")
    public boolean i;
    protected mctech.m.e.j<h<Input, R>> j;
    protected mctech.d.d<IItemHandler> k;
    protected mctech.m.a.g[] l;
    private ResourceLocation m;

    protected abstract void a();

    protected abstract int b();

    protected abstract float c();

    public abstract void a(ItemStack itemStack);

    public abstract void b(ItemStack itemStack);

    public abstract void d();

    public abstract void e();

    public abstract boolean f();

    public abstract boolean g();

    public abstract void b(RecipeHolder<R> recipeHolder);

    public abstract boolean c(ItemStack itemStack);

    public abstract boolean d(ItemStack itemStack);

    public abstract int e(ItemStack itemStack);

    public abstract void l();

    public abstract void m();

    public abstract RecipeType<R> getRecipeType();

    public abstract Input s();

    public h(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState, int i) {
        super(blockEntityType, blockPos, blockState, i);
        this.k = new mctech.d.b(this, DirectionList.ALL, Capabilities.ItemHandler.BLOCK);
        this.j = new mctech.m.e.j<>(this);
        addCaches(this.k);
        addGuiFields(this);
        addNetworkFields(this);
        addComparator(new mctech.blocks.base.a.a.a.a.f("progress", mctech.blocks.base.a.a.d.m, this));
        addComparator(new mctech.blocks.base.a.a.a.a.f("heat", mctech.blocks.base.a.a.d.g, this));
        addComparator(mctech.blocks.base.a.a.a.a.c.a("active", mctech.blocks.base.a.a.d.k, this));
        addComparator(new mctech.blocks.base.a.a.a.a.c("heating", mctech.blocks.base.a.a.d.h, this::isHeating, 0, 15));
        addComparator(new mctech.blocks.base.a.a.a.a.c("overheating", mctech.blocks.base.a.a.d.i, this::isOverheating, 0, 15));
        a(this.j);
        this.j.i();
    }

    public void a(mctech.m.e.j<h<Input, R>> jVar) {
    }

    @Override // mctech.api.tiles.IMachine
    public IItemHandler getConnectedInventory(Direction direction) {
        if (getInventoryHandler().e(direction)) {
            return this.k.b(direction);
        }
        return null;
    }

    @Override // mctech.api.features.IInventoryMachine
    public mctech.m.a.g getInputInventory() {
        if (this.l == null) {
            a();
        }
        return this.l[0];
    }

    @Override // mctech.api.features.IInventoryMachine
    public mctech.m.a.g getOutputInventory() {
        if (this.l == null) {
            a();
        }
        return this.l[1];
    }

    @Override // mctech.api.tiles.IMachine
    public EnumSet<IUpgradeItem.UpgradeType> getSupportedUpgradeTypes() {
        return EnumSet.noneOf(IUpgradeItem.UpgradeType.class);
    }

    @Override // mctech.api.tiles.IMachine
    public int getAvailableEnergy() {
        return 0;
    }

    @Override // mctech.api.tiles.IMachine
    public boolean isMachineWorking() {
        return isHeating();
    }

    @Override // mctech.api.tiles.IMachine
    public void setRedstoneSensitive(boolean z) {
    }

    @Override // mctech.api.tiles.IMachine
    public boolean isRedstoneSensitive() {
        return false;
    }

    @Override // mctech.blockentities.q
    public boolean shouldBlockUpdateEnableTick() {
        return true;
    }

    public boolean a(RecipeHolder<R> recipeHolder) {
        return true;
    }

    protected List<ItemStack> h() {
        return StreamSupport.intStream(getInventoryHandler().a(mctech.m.e.k.n).spliterator(), false).mapToObj(this::getStackInSlot).filter(itemStack -> {
            return !itemStack.isEmpty();
        }).toList();
    }

    protected List<ItemStack> i() {
        return StreamSupport.intStream(getInventoryHandler().a(mctech.m.e.k.o).spliterator(), false).mapToObj(this::getStackInSlot).filter(itemStack -> {
            return !itemStack.isEmpty();
        }).toList();
    }

    protected boolean j() {
        return h().stream().anyMatch(this::c);
    }

    protected boolean k() {
        return i().stream().anyMatch(this::d);
    }

    public boolean a(int i) {
        return c(getStackInSlot(i));
    }

    public boolean b(int i) {
        return d(getStackInSlot(i));
    }

    public void c(int i) {
        this.a = Math.max(0, this.a - i);
    }

    public void d(int i) {
        this.a = Math.min(this.d, this.a + i);
    }

    public void n() {
        this.e += 1.0f;
    }

    public void e(int i) {
        this.e = Math.max(0.0f, this.e - i);
    }

    public void o() {
        this.e = 0.0f;
    }

    private void a(String... strArr) {
    }

    protected void a(boolean z) {
        this.g = z;
        a("isHeating");
    }

    protected void b(boolean z) {
        this.i = z;
        a("isOverheating");
        if (z) {
            l();
        }
    }

    protected void c(boolean z) {
        this.h = z;
        a("isProcessing");
    }

    @Override // mctech.api.tiles.readers.IProgressMachine
    public float getProgress() {
        return this.e;
    }

    @Override // mctech.api.tiles.readers.IProgressMachine
    public float getMaxProgress() {
        return this.f;
    }

    @Override // mctech.api.features.IWrenchableTile
    public boolean canSetFacing(Direction direction) {
        return direction != getFacing() && direction.getAxis().isHorizontal();
    }

    @Override // mctech.blockentities.q, mctech.api.features.IWrenchableTile
    public void setFacing(Direction direction) {
    }

    @Override // mctech.api.features.IWrenchableTile
    public boolean canRemoveBlock(Player player) {
        return true;
    }

    @Override // mctech.api.features.IWrenchableTile
    public double getDropRate(Player player) {
        return 1.0d;
    }

    @Override // mctech.api.features.IWrenchableTile
    public boolean isHarvestWrenchRequired(Player player) {
        return false;
    }

    @Override // mctech.api.heat.IHeatingMachine
    public boolean isHeating() {
        return this.g;
    }

    @Override // mctech.api.heat.IHeatingMachine
    public boolean isOverheating() {
        return this.i;
    }

    @Override // mctech.api.heat.IHeatStorage
    public int heatLevel() {
        return this.a;
    }

    @Override // mctech.api.heat.IHeatStorage
    public int maxHeatLevel() {
        return this.b;
    }

    @Override // mctech.api.heat.IHeatStorage
    public int overheatLevel() {
        return this.c;
    }

    @Override // mctech.api.heat.IHeatStorage
    public int explosionLevel() {
        return this.d;
    }

    public int p() {
        return maxHeatLevel();
    }

    public int q() {
        return p();
    }

    public final Optional<RecipeHolder<R>> r() {
        return this.level == null ? Optional.empty() : this.level.getRecipeManager().getRecipeFor(getRecipeType(), s(), this.level);
    }
}
