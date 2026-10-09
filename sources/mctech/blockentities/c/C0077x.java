package mctech.blockentities.c;

import java.util.EnumSet;
import mctech.api.items.IUpgradeItem;
import mctech.api.network.buffer.NetworkInfo;
import mctech.init.MCTechRecipes;
import mctech.init.MCTechTiles;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.extensions.IBlockEntityExtension;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.ItemHandlerHelper;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;

/* JADX INFO: renamed from: mctech.blockentities.c.x, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/c/x.class */
public class C0077x extends mctech.blockentities.b implements mctech.a.b.a.a, mctech.m.a.k, IBlockEntityExtension, GeoBlockEntity {
    private final AnimatableInstanceCache j;
    private boolean k;

    @NetworkInfo(fieldName = "progress")
    public float a;

    @NetworkInfo(fieldName = "progressMax")
    public float b;
    protected mctech.u.B c;
    protected mctech.u.B d;
    protected boolean e;
    public static final int g = 7;
    private int l;
    private static final String m = "controller";
    public static final int[] f = {0, 1, 2, 3, 4, 5, 6};
    public static final int[] h = {8, 9, 10, 11};
    private static final String n = "closing";
    private static final RawAnimation r = RawAnimation.begin().thenPlay(n);
    private static final String o = "opening";
    private static final String p = "opened";
    private static final RawAnimation s = RawAnimation.begin().thenPlay(o).thenPlayAndHold(p);
    private static final String q = "crafting";
    private static final RawAnimation t = RawAnimation.begin().thenPlay(q);
    private static final RawAnimation u = RawAnimation.begin().thenPlay(p);
    public static final EnumSet<IUpgradeItem.UpgradeType> i = EnumSet.of(IUpgradeItem.UpgradeType.SPEED_MOD, IUpgradeItem.UpgradeType.SPEED_MOD_COMPOSITE, IUpgradeItem.UpgradeType.SPEED_MOD_NANO, IUpgradeItem.UpgradeType.SPEED_MOD_QUANT, IUpgradeItem.UpgradeType.SPEED_MOD_TITAN, IUpgradeItem.UpgradeType.SPEED_MOD_RUBIDIUM, IUpgradeItem.UpgradeType.COMPLEX_HANDLER_MOD, IUpgradeItem.UpgradeType.ENERGY_MOD, IUpgradeItem.UpgradeType.AUDIO_MOD, IUpgradeItem.UpgradeType.ADMIN_MOD, IUpgradeItem.UpgradeType.TRANSFORMER_MOD);

    public C0077x(BlockPos blockPos, BlockState blockState) {
        super((BlockEntityType) MCTechTiles.INDUSTRIAL_FORGE.get(), blockPos, blockState, f.length + 1, h.length);
        this.j = GeckoLibUtil.createInstanceCache(this);
        this.k = true;
        this.l = 0;
        this.inventoryManager.a().a(h.length).a(mctech.m.g.y.f(f).a(new mctech.m.c.m(this))).a(mctech.m.g.y.d(7)).a(this).i();
        addGuiFields(this);
    }

    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController(this, m, 1, animationState -> {
            return PlayState.CONTINUE;
        }).triggerableAnim(n, r).triggerableAnim(o, s).triggerableAnim(q, t).triggerableAnim(p, u));
    }

    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.j;
    }

    @Override // mctech.blockentities.b, mctech.api.tiles.IMachine
    public EnumSet<IUpgradeItem.UpgradeType> getSupportedUpgradeTypes() {
        return i;
    }

    @Override // mctech.m.a.d
    public mctech.m.b.S createContainer(Player player, InteractionHand interactionHand, Direction direction, int i2) {
        this.l++;
        if (!isActive() && this.l == 1) {
            triggerAnim(m, o);
        }
        return new mctech.m.b.O(this, player, i2);
    }

    @Override // mctech.m.a.d
    public void a_(Player player) {
        this.l = Math.max(0, this.l - 1);
        if (!isActive() && this.l == 0) {
            triggerAnim(m, n);
        }
        super.a_(player);
    }

    @Override // mctech.blockentities.q
    public boolean setActive(boolean z) {
        if (isActive() != z) {
            if (z) {
                triggerAnim(m, q);
            } else if (this.l > 0) {
                triggerAnim(m, p);
            } else {
                triggerAnim(m, n);
            }
        }
        return super.setActive(z);
    }

    private boolean b(ItemStack itemStack) {
        return true;
    }

    @Override // mctech.blockentities.b
    protected void updateAutoExportSlotsState() {
        this.k = ((ItemStack) this.inventory.get(7)).isEmpty();
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
        this.inOut = new mctech.m.a.g[2];
        this.inOut[0] = new mctech.m.f.k(this, f);
        this.inOut[1] = new mctech.m.f.k(this, 7).a();
    }

    @Override // mctech.blockentities.b
    protected boolean isNeedExport() {
        return !this.k;
    }

    private void b() {
        ItemStack stackInSlot = getStackInSlot(7);
        if (stackInSlot.isEmpty()) {
            return;
        }
        for (Direction direction : this.invCache.c()) {
            IItemHandler iItemHandlerB = this.invCache.b(direction);
            if (iItemHandlerB != null && getInventoryHandler().d(direction).d()) {
                ItemStack itemStackInsertItem = ItemHandlerHelper.insertItem(iItemHandlerB, stackInSlot, false);
                if (itemStackInsertItem.isEmpty() || itemStackInsertItem.getCount() != stackInSlot.getCount()) {
                    setStackInSlot(7, itemStackInsertItem);
                    updateAutoExportSlotsState();
                    return;
                }
            }
        }
    }

    protected void a(ItemStack itemStack) {
        this.outputs.add(new mctech.u.c.f(itemStack, 7));
    }

    protected boolean a(boolean z) {
        return (z || this.a > 0.0f || isNeedExport()) ? false : true;
    }

    protected void b(boolean z) {
    }

    private mctech.u.B.a c() {
        NonNullList nonNullListWithSize = NonNullList.withSize(f.length, ItemStack.EMPTY);
        for (int i2 : f) {
            nonNullListWithSize.set(i2, getStackInSlot(i2));
        }
        return new mctech.u.B.a(nonNullListWithSize);
    }

    @Override // mctech.blockentities.b, mctech.api.recipes.ingridients.queue.IInputter
    public void addItemIntoSlot(int i2, ItemStack itemStack) {
        super.addItemIntoSlot(i2, itemStack);
        if (isAutoExport() && i2 == 7) {
            this.k = itemStack.isEmpty();
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

    @Override // mctech.api.tiles.readers.IProgressMachine
    public float getProgress() {
        return this.a;
    }

    @Override // mctech.api.tiles.readers.IProgressMachine
    public float getMaxProgress() {
        return this.b;
    }

    @Override // mctech.api.tiles.IRecipeMachine
    public <I extends RecipeInput, T extends Recipe<I>> RecipeType<T> getRecipeType() {
        return MCTechRecipes.type("industrial_forge");
    }
}
