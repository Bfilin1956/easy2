package mctech.blockentities.c;

import appeng.core.definitions.AEBlocks;
import appeng.core.definitions.AEItems;
import java.util.EnumSet;
import mctech.api.items.IUpgradeItem;
import mctech.api.network.buffer.NetworkInfo;
import mctech.api.util.DirectionList;
import mctech.init.MCTechRecipes;
import mctech.init.MCTechTiles;
import mctech.m.b.C0161u;
import mctech.u.C0186n;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.ItemHandlerHelper;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: mctech.blockentities.c.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/c/i.class */
public class C0062i extends mctech.blockentities.b implements mctech.m.a.k {
    private boolean l;

    @NetworkInfo(fieldName = "progress")
    public float a;

    @NetworkInfo(fieldName = "progressMax")
    public float b;
    protected C0186n c;
    protected C0186n d;
    protected boolean e;
    public static final int h = 4;
    public static final int i = 5;
    public static final int[] f = {0, 1, 2, 3};
    public static final int[] g = {0, 1, 2, 3, 4};
    public static final int[] j = {6, 7, 8, 9};
    public static final EnumSet<IUpgradeItem.UpgradeType> k = EnumSet.of(IUpgradeItem.UpgradeType.SPEED_MOD, IUpgradeItem.UpgradeType.SPEED_MOD_COMPOSITE, IUpgradeItem.UpgradeType.SPEED_MOD_NANO, IUpgradeItem.UpgradeType.SPEED_MOD_QUANT, IUpgradeItem.UpgradeType.SPEED_MOD_TITAN, IUpgradeItem.UpgradeType.SPEED_MOD_RUBIDIUM, IUpgradeItem.UpgradeType.COMPLEX_HANDLER_MOD, IUpgradeItem.UpgradeType.ENERGY_MOD, IUpgradeItem.UpgradeType.AUDIO_MOD, IUpgradeItem.UpgradeType.ADMIN_MOD, IUpgradeItem.UpgradeType.TRANSFORMER_MOD);

    public C0062i(BlockPos blockPos, BlockState blockState) {
        super(MCTechTiles.CRYSTAL_GROWTH_CHAMBER.get(), blockPos, blockState, 6, 4);
        this.l = true;
        this.b = 400.0f;
        this.inventoryManager = new mctech.m.e.j<>(this, 4);
        this.inventoryManager.a(new mctech.m.g.y(mctech.m.e.k.g, 0, 1, 2, 3, 4).a(DirectionList.ALL).a(mctech.m.e.a.IMPORT).a((i2, itemStack) -> {
            if (i2 == 4 && this.level.getRecipeManager().getRecipeFor(MCTechRecipes.type("crystal_growth_chamber"), new SingleRecipeInput(itemStack), this.level).isPresent()) {
                return true;
            }
            return a(itemStack);
        }));
        this.inventoryManager.a(new mctech.m.g.y(mctech.m.e.k.l, 5).a(DirectionList.ALL).a(mctech.m.e.a.EXPORT).a(mctech.m.c.r.c));
        this.inventoryManager.a(this);
        this.inventoryManager.i();
        addGuiFields(this);
    }

    public static boolean a(@NotNull ItemStack itemStack) {
        return itemStack.getItem() == AEBlocks.GROWTH_ACCELERATOR.asItem();
    }

    @Override // mctech.blockentities.b
    protected void updateAutoExportSlotsState() {
        this.l = ((ItemStack) this.inventory.get(5)).isEmpty();
    }

    @Override // mctech.blockentities.i, mctech.m.e.e
    public boolean allowsUI() {
        return false;
    }

    @Override // mctech.api.features.redstone.IComparable
    public boolean isAllowingUI() {
        return false;
    }

    @Override // mctech.blockentities.b
    protected void createInvCaches() {
        this.inOut = this.inventoryManager.g();
    }

    @Override // mctech.blockentities.b
    protected boolean isNeedExport() {
        return !this.l;
    }

    @Override // mctech.m.a.d
    public mctech.m.b.S createContainer(Player player, InteractionHand interactionHand, Direction direction, int i2) {
        return new C0161u(this, player, i2);
    }

    private void b() {
        ItemStack stackInSlot = getStackInSlot(5);
        if (stackInSlot.isEmpty()) {
            return;
        }
        for (Direction direction : this.invCache.c()) {
            IItemHandler iItemHandlerB = this.invCache.b(direction);
            if (iItemHandlerB != null && getInventoryHandler().d(direction).d()) {
                ItemStack itemStackInsertItem = ItemHandlerHelper.insertItem(iItemHandlerB, stackInSlot, false);
                if (itemStackInsertItem.getCount() != stackInSlot.getCount()) {
                    setStackInSlot(5, itemStackInsertItem);
                    updateAutoExportSlotsState();
                }
            }
        }
    }

    public void a() {
        for (int iC = this.c.c(); iC > 0; iC -= 64) {
            b(AEItems.CERTUS_QUARTZ_CRYSTAL.stack(Math.min(64, iC)));
        }
        onRecipeProcessed(this.c);
        if (!this.outputs.isEmpty()) {
            addItemsToInventory();
        }
    }

    protected void b(ItemStack itemStack) {
        this.outputs.add(new mctech.u.c.f(itemStack, 5));
    }

    protected boolean a(boolean z) {
        return (z || this.a > 0.0f || isNeedExport()) ? false : true;
    }

    protected void b(boolean z) {
    }

    private boolean c() {
        for (int i2 : f) {
            if (((ItemStack) this.inventory.get(i2)).getItem() != AEBlocks.GROWTH_ACCELERATOR.asItem()) {
                return true;
            }
        }
        return false;
    }

    @Override // mctech.blockentities.b, mctech.api.recipes.ingridients.queue.IInputter
    public void addItemIntoSlot(int i2, ItemStack itemStack) {
        super.addItemIntoSlot(i2, itemStack);
        if (isAutoExport() && i2 == 5) {
            this.l = itemStack.isEmpty();
        }
    }

    @Override // mctech.blockentities.i, mctech.m.a.g
    public void setStackInSlot(int i2, ItemStack itemStack) {
        super.setStackInSlot(i2, itemStack);
    }

    private void a(int i2, ItemStack itemStack, ItemStack itemStack2) {
    }

    @Override // mctech.api.tiles.IInputMachine
    public int getValidRoom(ItemStack itemStack) {
        return 0;
    }

    @Override // mctech.blockentities.b, mctech.blockentities.s
    public boolean isAutoSort() {
        return false;
    }

    @Override // mctech.blockentities.b, mctech.api.tiles.IMachine
    public EnumSet<IUpgradeItem.UpgradeType> getSupportedUpgradeTypes() {
        return k;
    }

    @Override // mctech.api.tiles.IRecipeMachine
    public <I extends RecipeInput, T extends Recipe<I>> RecipeType<T> getRecipeType() {
        return MCTechRecipes.type("crystal_growth_chamber");
    }

    @Override // mctech.api.tiles.readers.IProgressMachine
    public float getProgress() {
        return this.a;
    }

    @Override // mctech.api.tiles.readers.IProgressMachine
    public float getMaxProgress() {
        return this.b;
    }
}
