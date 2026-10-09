package mctech.blockentities;

import java.util.EnumSet;
import java.util.Optional;
import mctech.MCTech;
import mctech.api.features.IXPMachine;
import mctech.api.items.IUpgradeItem;
import mctech.api.network.buffer.NetworkInfo;
import mctech.api.tiles.IRecipeMachine;
import mctech.api.tiles.readers.IProgressMachine;
import mctech.m.b.C0151k;
import mctech.m.b.S;
import mctech.m.g.y;
import mctech.u.AbstractC0180h;
import mctech.utils.math.geometry.Vec2i;
import net.mcskill.msregistry.core.IMachineTier;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/BasicMachineTileEntity.class */
public abstract class BasicMachineTileEntity extends k implements IXPMachine, IRecipeMachine, IProgressMachine, mctech.m.a.k, IMachineTier {
    private static final EnumSet<IUpgradeItem.UpgradeType> TYPES = EnumSet.of(IUpgradeItem.UpgradeType.SPEED_MOD, IUpgradeItem.UpgradeType.ENERGY_MOD, IUpgradeItem.UpgradeType.AUDIO_MOD, IUpgradeItem.UpgradeType.ADMIN_MOD);
    public static final EnumSet<IUpgradeItem.UpgradeType> BASIC_MACHINE_UPGRADES = EnumSet.allOf(IUpgradeItem.UpgradeType.class);

    @NetworkInfo(fieldName = "progress")
    public float progress;

    @NetworkInfo(fieldName = "recipeOperation")
    public int recipeOperation;

    @NetworkInfo(fieldName = "recipeEnergy")
    public int recipeEnergy;

    public BasicMachineTileEntity(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState, int i, int i2, int i3, int i4) {
        this(blockEntityType, blockPos, blockState, i, 4, i2, i3, i2 * i3, i4);
    }

    public BasicMachineTileEntity(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState, int i, int i2, int i3, int i4, int i5) {
        this(blockEntityType, blockPos, blockState, i, i2, i3, i4, i3 * i4, i5);
    }

    public BasicMachineTileEntity(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState, int i, int i2, int i3, int i4, int i5, int i6) {
        super(blockEntityType, blockPos, blockState, i, i2, i3, i4, i5, i6);
        this.progress = 0.0f;
        this.redstoneSensitive = false;
        this.recipeOperation = i4;
        this.recipeEnergy = i3;
        setFuelSlot(0);
        this.inventoryManager = new mctech.m.e.j(this, i2).a(y.b(0)).a(y.f(1).a(new mctech.m.c.a.g(this))).a(y.d(2)).a(this);
        this.inventoryManager.i();
        addGuiFields(this);
        addNetworkFields(this);
        addComparator(new mctech.blocks.base.a.a.a.a.f("progress", mctech.blocks.base.a.a.d.m, this));
        addComparator(mctech.blocks.base.a.a.a.a.c.a("active", mctech.blocks.base.a.a.d.k, this));
    }

    public mctech.utils.math.geometry.b getProgressPosition() {
        return mctech.utils.math.geometry.b.a;
    }

    public Vec2i getProgressOffset() {
        return Vec2i.EMPTY;
    }

    public ResourceLocation getTexture() {
        MCTech.LOGGER.error(String.format("Class %s was not override gui texture location!", getClass().getSimpleName()));
        return null;
    }

    @Override // mctech.m.a.d
    public S createContainer(Player player, InteractionHand interactionHand, Direction direction, int i) {
        return new C0151k(this, player, i);
    }

    @Override // mctech.api.tiles.IMachine
    public EnumSet<IUpgradeItem.UpgradeType> getSupportedUpgradeTypes() {
        return TYPES;
    }

    @Override // mctech.api.tiles.readers.IProgressMachine
    public float getProgress() {
        return this.progress;
    }

    @Override // mctech.api.tiles.readers.IProgressMachine
    public float getMaxProgress() {
        return this.recipeOperation;
    }

    @Override // mctech.blockentities.k, mctech.api.tiles.IMachineInfo
    public int getEnergyPerTick() {
        return this.recipeEnergy;
    }

    @Override // mctech.blockentities.k
    protected void createInvCaches() {
        this.inOut = this.inventoryManager.g();
    }

    protected boolean isSpeedMachine() {
        return false;
    }

    @Override // mctech.api.tiles.IMachineInfo
    public int getOperationTime() {
        if (this.recipeOperation > 0) {
            return (int) (this.recipeOperation / this.upgradeHandler.a());
        }
        return 0;
    }

    @Override // mctech.api.tiles.IRecipeMachine
    public float getProgressPerTick() {
        return this.upgradeHandler.a();
    }

    public Optional<RecipeHolder<Recipe<RecipeInput>>> getRecipeFor(ItemStack itemStack) {
        return this.level.getRecipeManager().getRecipeFor(getRecipeType(), getRecipeInput(itemStack), this.level);
    }

    public RecipeInput getRecipeInput(ItemStack itemStack) {
        return isVanilla() ? new SingleRecipeInput(itemStack) : new AbstractC0180h.a(itemStack, false);
    }

    public boolean isVanilla() {
        return false;
    }

    @Override // mctech.api.tiles.IInputMachine
    public int getValidRoom(ItemStack itemStack) {
        return ((Integer) this.inventory.stream().filter(itemStack2 -> {
            return mctech.utils.c.h.d(itemStack, itemStack2);
        }).map(mctech.utils.c.h::b).filter(num -> {
            return num.intValue() > 0;
        }).findAny().orElse(Integer.valueOf(getRecipeFor(itemStack).isPresent() ? itemStack.getCount() : 0))).intValue();
    }

    public boolean canInsertSlot(int i, ItemStack itemStack) {
        if (getRecipeFor(itemStack).isEmpty()) {
            return false;
        }
        ItemStack stackInSlot = getStackInSlot(i);
        return stackInSlot.isEmpty() || mctech.utils.c.h.d(stackInSlot, itemStack);
    }

    protected void onSlotChanged(int i, ItemStack itemStack, ItemStack itemStack2) {
        if (i == 1 && !mctech.utils.c.h.d(itemStack, itemStack2)) {
            if (this.progress > 0.0f) {
            }
            this.progress = 0.0f;
        }
    }

    protected k.a isRecipeStillValid(int i, RecipeType<Recipe<?>> recipeType) {
        return k.a.IGNORE;
    }

    protected InteractionResult canFillRecipeIntoOutputs(int i, Recipe<?> recipe) {
        return InteractionResult.FAIL;
    }

    protected boolean isOperating() {
        return isActive();
    }
}
