package mctech.blockentities.c;

import java.util.EnumSet;
import java.util.Iterator;
import java.util.Optional;
import mctech.api.features.IInventoryMachine;
import mctech.api.items.IFuelableItem;
import mctech.api.items.IRepairable;
import mctech.api.items.IUpgradeItem;
import mctech.api.items.armor.IFoamSupplier;
import mctech.api.network.buffer.NetworkInfo;
import mctech.api.util.DirectionList;
import mctech.init.MCTechItems;
import mctech.init.MCTechRecipes;
import mctech.m.b.C0153m;
import mctech.u.AbstractC0180h;
import mctech.u.C0181i;
import mctech.u.C0182j;
import net.mcskill.msregistry.core.IMachineTier;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: mctech.blockentities.c.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/c/f.class */
public class C0059f extends mctech.blockentities.k implements IInventoryMachine, mctech.m.a.k, IMachineTier {

    @NetworkInfo(fieldName = "progress")
    public int a;
    public int b;
    public int c;
    public int d;

    public C0059f(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState, 5, 4, 1, 400, 3200, 32);
        this.a = 0;
        this.b = 0;
        this.c = 0;
        this.d = 1;
        setFuelSlot(0);
        this.inventoryManager = new mctech.m.e.j(this, 4).a(mctech.m.g.y.b(0)).a(new mctech.m.g.y(mctech.m.e.k.i, 1).a(DirectionList.ALL).a(mctech.m.e.a.IMPORT).a((i, itemStack) -> {
            return itemStack.is(MCTechItems.TIN_CAN) || a(itemStack, 1);
        })).a(mctech.m.g.y.f(2).a((i2, itemStack2) -> {
            return c(itemStack2) > 0 || a(itemStack2, 0);
        })).a(mctech.m.g.y.d(3)).a(mctech.m.g.y.e(4)).a(this);
        this.inventoryManager.i();
        addGuiFields(this);
        addComparator(new mctech.blocks.base.a.a.a.a.f("progress", mctech.blocks.base.a.a.d.m, this));
        addComparator(mctech.blocks.base.a.a.a.a.c.a("active", mctech.blocks.base.a.a.d.k, this));
    }

    @Override // mctech.blockentities.k, mctech.blockentities.e
    public boolean supportsNotify() {
        return true;
    }

    @Override // mctech.m.a.d
    public mctech.m.b.S createContainer(Player player, InteractionHand interactionHand, Direction direction, int i) {
        return new C0153m(this, player, i);
    }

    @Override // mctech.blockentities.k
    protected void createInvCaches() {
        mctech.m.a.g[] gVarArr = new mctech.m.a.g[2];
        this.inOut = gVarArr;
        gVarArr[0] = new mctech.m.f.k(this, 1, 2);
        this.inOut[1] = new mctech.m.f.k(this, 3, 4).a();
    }

    @Override // mctech.api.tiles.readers.IProgressMachine
    public float getProgress() {
        return this.a;
    }

    @Override // mctech.api.tiles.readers.IProgressMachine
    public float getMaxProgress() {
        switch (a((ItemStack) this.inventory.get(1))) {
            case 1:
                return c((ItemStack) this.inventory.get(2)) * 50;
            case 2:
                return 600.0f;
            case 3:
                return 50.0f;
            case 4:
                return 50.0f;
            case 5:
                return 50.0f;
            default:
                return 0.0f;
        }
    }

    public int a(ItemStack itemStack) {
        if (itemStack.isEmpty()) {
            return 0;
        }
        IFuelableItem item = itemStack.getItem();
        if (item == MCTechItems.TIN_CAN.get()) {
            return 1;
        }
        if ((item instanceof IFuelableItem) && item.canFuel(itemStack)) {
            return 2;
        }
        if (item instanceof IFoamSupplier) {
            return 3;
        }
        if (item instanceof IRepairable) {
            return 4;
        }
        if (!a(ItemStack.EMPTY, itemStack).isEmpty()) {
            return 5;
        }
        return 0;
    }

    private Optional<C0181i> a(ItemStack itemStack, ItemStack itemStack2) {
        C0181i.a aVar = new C0181i.a(itemStack, itemStack2);
        for (RecipeHolder recipeHolder : getLevel().getRecipeManager().getAllRecipesFor((RecipeType) MCTechRecipes.CANNER_FILL.get())) {
            if (((C0181i) recipeHolder.value()).matches(aVar, this.level)) {
                return Optional.of((C0181i) recipeHolder.value());
            }
        }
        return Optional.empty();
    }

    public int b(ItemStack itemStack) {
        if (itemStack.isEmpty()) {
            return 0;
        }
        return 0;
    }

    public int c(ItemStack itemStack) {
        FoodProperties foodProperties = itemStack.getFoodProperties((LivingEntity) null);
        if (foodProperties != null) {
            return Math.max(1, Mth.ceil(((double) foodProperties.nutrition()) / 2.0d));
        }
        return itemStack.getItem() == Items.CAKE ? 6 : 0;
    }

    public ItemStack a(int i) {
        if (i <= 0) {
            return ItemStack.EMPTY;
        }
        AbstractC0180h.a aVar = new AbstractC0180h.a((ItemStack) this.inventory.get(2), false);
        Optional recipeFor = getLevel().getRecipeManager().getRecipeFor((RecipeType) MCTechRecipes.CANNER_FOOD.get(), aVar, this.level);
        if (recipeFor.isEmpty()) {
            return new ItemStack((ItemLike) MCTechItems.TIN_CAN_FILLED.get(), i);
        }
        return ((C0182j) ((RecipeHolder) recipeFor.get()).value()).assemble(aVar, this.level.registryAccess());
    }

    public boolean b(int i) {
        ItemStack itemStackA = a(i);
        if (itemStackA.isEmpty()) {
            return false;
        }
        ItemStack itemStack = (ItemStack) this.inventory.get(3);
        return (itemStack.isEmpty() || mctech.utils.c.h.b(itemStack, itemStackA)) && d(itemStack);
    }

    public boolean c(int i) {
        return ((ItemStack) this.inventory.get(1)).getCount() >= i;
    }

    public boolean d(ItemStack itemStack) {
        if (!itemStack.hasCraftingRemainingItem()) {
            return true;
        }
        ItemStack craftingRemainingItem = itemStack.getCraftingRemainingItem();
        ItemStack itemStack2 = (ItemStack) this.inventory.get(4);
        return itemStack2.isEmpty() || mctech.utils.c.h.b(itemStack2, craftingRemainingItem);
    }

    public int a(ItemStack itemStack, boolean z) {
        if (itemStack.isEmpty()) {
            return 0;
        }
        if (((ItemStack) this.inventory.get(1)).isEmpty()) {
            if (a(itemStack) > 0) {
                return itemStack.getMaxStackSize();
            }
            return 0;
        }
        if (mctech.utils.c.h.d((ItemStack) this.inventory.get(1), itemStack) || (z && a(itemStack) > 0)) {
            return mctech.utils.c.h.b((ItemStack) this.inventory.get(1));
        }
        return 0;
    }

    public boolean e(ItemStack itemStack) {
        switch (a((ItemStack) this.inventory.get(1))) {
            case 1:
                return c(itemStack) > 0;
            case 2:
                return b(itemStack) > 0;
            case 3:
            case 4:
            default:
                return c(itemStack) > 0 || b(itemStack) > 0;
            case 5:
                return !a(itemStack, (ItemStack) this.inventory.get(1)).isEmpty();
        }
    }

    public boolean a(ItemStack itemStack, int i) {
        if (this.level == null) {
            return false;
        }
        Iterator it = this.level.getRecipeManager().getAllRecipesFor((RecipeType) MCTechRecipes.CANNER_FILL.get()).iterator();
        while (it.hasNext()) {
            NonNullList<Ingredient> ingredients = ((C0181i) ((RecipeHolder) it.next()).value()).getIngredients();
            if (i < 0 || i >= ingredients.size()) {
                return false;
            }
            if (((Ingredient) ingredients.get(i)).test(itemStack)) {
                return true;
            }
        }
        return false;
    }

    @Override // mctech.api.tiles.IInputMachine
    public int getValidRoom(ItemStack itemStack) {
        int iIntValue = itemStack.isEmpty() ? 0 : ((Integer) this.inventory.stream().filter(itemStack2 -> {
            return mctech.utils.c.h.d(itemStack2, itemStack);
        }).map(mctech.utils.c.h::b).filter(num -> {
            return num.intValue() > 0;
        }).findAny().orElse(0)).intValue();
        if (c(itemStack) > 0 && getStackInSlot(1).isEmpty()) {
            return itemStack.getMaxStackSize();
        }
        if (iIntValue == 0 && this.level != null) {
            Iterator it = this.level.getRecipeManager().getAllRecipesFor((RecipeType) MCTechRecipes.CANNER_FILL.get()).iterator();
            while (it.hasNext()) {
                if (((C0181i) ((RecipeHolder) it.next()).value()).getIngredients().stream().anyMatch(ingredient -> {
                    return ingredient.test(itemStack);
                })) {
                    ItemStack stackInSlot = c(itemStack) > 0 || itemStack.is(MCTechItems.TIN_CAN) ? getStackInSlot(2) : getStackInSlot(1);
                    if (ItemStack.isSameItemSameComponents(stackInSlot, itemStack)) {
                        return stackInSlot.getMaxStackSize() - stackInSlot.getCount();
                    }
                    if (stackInSlot.isEmpty()) {
                        return itemStack.getMaxStackSize();
                    }
                    return 0;
                }
            }
        }
        return iIntValue;
    }

    @Override // mctech.api.tiles.IMachine
    public EnumSet<IUpgradeItem.UpgradeType> getSupportedUpgradeTypes() {
        return EnumSet.of(IUpgradeItem.UpgradeType.SPEED_MOD, IUpgradeItem.UpgradeType.SPEED_MOD_COMPOSITE, IUpgradeItem.UpgradeType.SPEED_MOD_NANO, IUpgradeItem.UpgradeType.SPEED_MOD_QUANT, IUpgradeItem.UpgradeType.SPEED_MOD_TITAN, IUpgradeItem.UpgradeType.SPEED_MOD_RUBIDIUM, IUpgradeItem.UpgradeType.COMPLEX_HANDLER_MOD, IUpgradeItem.UpgradeType.ENERGY_MOD, IUpgradeItem.UpgradeType.AUDIO_MOD, IUpgradeItem.UpgradeType.ADMIN_MOD, IUpgradeItem.UpgradeType.TRANSFORMER_MOD);
    }

    @NotNull
    public MachineTier machineTier() {
        return MachineTier.T3;
    }
}
