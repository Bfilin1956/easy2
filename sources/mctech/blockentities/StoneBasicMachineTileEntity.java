package mctech.blockentities;

import java.util.Optional;
import mctech.MCTech;
import mctech.api.features.IWrenchableTile;
import mctech.api.features.IXPMachine;
import mctech.api.network.buffer.NetworkInfo;
import mctech.api.tiles.IRecipeMachine;
import mctech.api.tiles.readers.IFuelStorage;
import mctech.api.tiles.readers.IProgressMachine;
import mctech.m.b.C0152l;
import mctech.m.b.S;
import mctech.m.g.y;
import mctech.u.AbstractC0180h;
import mctech.utils.math.geometry.Vec2i;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/StoneBasicMachineTileEntity.class */
public abstract class StoneBasicMachineTileEntity extends i implements IWrenchableTile, IXPMachine, IRecipeMachine, IFuelStorage, IProgressMachine, mctech.m.a.k {

    @NetworkInfo(fieldName = "fuel")
    public float fuel;

    @NetworkInfo(fieldName = "maxFuel")
    public int maxFuel;

    @NetworkInfo(fieldName = "progress")
    public float progress;

    @NetworkInfo(fieldName = "maxProgress")
    public float maxProgress;

    @NetworkInfo(fieldName = "fuelConsumption")
    public float fuelConsumption;

    @NetworkInfo(fieldName = "isProcessing")
    public boolean isProcessing;
    int defaultMaxProgress;
    protected mctech.m.e.j<StoneBasicMachineTileEntity> inventoryManager;

    public StoneBasicMachineTileEntity(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState, int i) {
        super(blockEntityType, blockPos, blockState, 3);
        this.fuel = 0.0f;
        this.maxFuel = 0;
        this.progress = 0.0f;
        this.maxProgress = 400.0f;
        this.fuelConsumption = 1.0f;
        this.isProcessing = false;
        this.inventoryManager = new mctech.m.e.j<>(this);
        this.inventoryManager.a(y.a(0));
        this.inventoryManager.a(y.f(0).a(new mctech.m.c.m(this)));
        this.inventoryManager.a(y.d(0));
        this.inventoryManager.i();
        addGuiFields(this);
        addNetworkFields(this);
        this.defaultMaxProgress = i;
        this.maxProgress = i;
        addComparator(new mctech.blocks.base.a.a.a.a.f("progress", mctech.blocks.base.a.a.d.m, this));
        addComparator(mctech.blocks.base.a.a.a.a.c.a("active", mctech.blocks.base.a.a.d.k, this));
        addComparator(new mctech.blocks.base.a.a.a.a.d("fuel", mctech.blocks.base.a.a.d.f, this));
    }

    public mctech.utils.math.geometry.b getProgressPosition() {
        return mctech.utils.math.geometry.b.a;
    }

    public Vec2i getProgressOffset() {
        return Vec2i.EMPTY;
    }

    public Vec2i getFuelSlotPosition() {
        return Vec2i.EMPTY;
    }

    public Vec2i getFuelActivityPosition() {
        return Vec2i.EMPTY;
    }

    public int getFuel(ItemStack itemStack) {
        return itemStack.getBurnTime(RecipeType.SMELTING);
    }

    public ResourceLocation getTexture() {
        MCTech.LOGGER.error(String.format("Class %s was not override gui texture location!", getClass().getSimpleName()));
        return null;
    }

    public boolean allowsLavaFuel() {
        return true;
    }

    protected ResourceLocation getFuelBurnSound() {
        return SoundEvents.FURNACE_FIRE_CRACKLE.getLocation();
    }

    protected ResourceLocation getWorkingSound() {
        return null;
    }

    protected boolean consumeContainers() {
        return false;
    }

    @Override // mctech.api.tiles.readers.IProgressMachine
    public float getProgress() {
        return this.progress;
    }

    @Override // mctech.api.tiles.readers.IProgressMachine
    public float getMaxProgress() {
        return this.maxProgress;
    }

    @Override // mctech.api.tiles.readers.IFuelStorage
    public int getFuel() {
        return (int) this.fuel;
    }

    @Override // mctech.api.tiles.readers.IFuelStorage
    public int getMaxFuel() {
        return this.maxFuel;
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
        return 1.0d;
    }

    @Override // mctech.api.features.IWrenchableTile
    public boolean isHarvestWrenchRequired(Player player) {
        return false;
    }

    @Override // mctech.api.tiles.IInputMachine
    public int getValidRoom(ItemStack itemStack) {
        if (getRecipeFor(itemStack).isEmpty()) {
            return 0;
        }
        if (((ItemStack) this.inventory.get(1)).isEmpty()) {
            return itemStack.getMaxStackSize();
        }
        ItemStack itemStack2 = (ItemStack) this.inventory.get(1);
        if (mctech.utils.c.h.d(itemStack2, itemStack)) {
            return mctech.utils.c.h.b(itemStack2);
        }
        return 0;
    }

    public Optional<RecipeHolder<Recipe<RecipeInput>>> getRecipeFor(ItemStack itemStack) {
        return this.level.getRecipeManager().getRecipeFor(getRecipeType(), getRecipeInput(itemStack), this.level);
    }

    public RecipeInput getRecipeInput(ItemStack itemStack) {
        return isVanilla() ? new SingleRecipeInput(itemStack) : new AbstractC0180h.a(itemStack, true);
    }

    public boolean isVanilla() {
        return false;
    }

    @Override // mctech.m.a.d
    public S createContainer(Player player, InteractionHand interactionHand, Direction direction, int i) {
        return new C0152l(this, player, i);
    }
}
