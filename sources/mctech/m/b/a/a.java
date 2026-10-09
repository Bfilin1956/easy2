package mctech.m.b.a;

import java.util.List;
import mctech.blockentities.c.C0057d;
import mctech.m.g.x;
import net.minecraft.core.NonNullList;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.RecipeCraftingHolder;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingInput;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.CommonHooks;
import net.neoforged.neoforge.event.EventHooks;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/a/a.class */
public class a extends x implements RecipeCraftingHolder {
    private final C0057d a;
    private final b b;

    @Nullable
    private RecipeHolder<?> c;

    @NotNull
    private final Player i;
    private int j;

    public a(C0057d c0057d, int i, int i2, int i3, b bVar, @NotNull Player player) {
        super(c0057d, i, i2, i3);
        this.b = bVar;
        this.a = c0057d;
        this.i = player;
    }

    public boolean mayPlace(@NotNull ItemStack itemStack) {
        return false;
    }

    @Override // mctech.m.g.x
    public ItemStack remove(int i) {
        return super.remove(i);
    }

    protected void onQuickCraft(@NotNull ItemStack itemStack, int i) {
        this.j += i;
        checkTakeAchievements(itemStack);
    }

    protected void checkTakeAchievements(@NotNull ItemStack itemStack) {
        if (this.j > 0) {
            itemStack.onCraftedBy(this.i.level(), this.i, this.j);
            EventHooks.firePlayerCraftingEvent(this.i, itemStack, this.b);
        }
        awardUsedRecipes(this.i, this.b.getItems());
        this.j = 0;
    }

    public void onTake(@NotNull Player player, @NotNull ItemStack itemStack) {
        this.j += itemStack.getCount();
        checkTakeAchievements(itemStack);
        List<ItemStack> items = this.b.getItems();
        NonNullList nonNullListWithSize = NonNullList.withSize(this.b.a(), ItemStack.EMPTY);
        for (int i = 0; i < this.b.a(); i++) {
            nonNullListWithSize.set(i, items.get(i));
        }
        CraftingInput.Positioned positionedAsPositionedCraftInput = this.b.asPositionedCraftInput();
        CommonHooks.setCraftingPlayer(player);
        NonNullList<ItemStack> nonNullListA = a(positionedAsPositionedCraftInput.input(), player.level());
        CommonHooks.setCraftingPlayer((Player) null);
        for (int i2 = 0; i2 < this.b.getHeight(); i2++) {
            for (int i3 = 0; i3 < this.b.getWidth(); i3++) {
                int height = (i2 * this.b.getHeight()) + i3;
                int pVar = ((i2 - positionedAsPositionedCraftInput.top()) * this.b.getWidth()) + (i3 - positionedAsPositionedCraftInput.left());
                this.b.a(height, 1, false);
                if (pVar >= 0 && pVar < nonNullListA.size()) {
                    ItemStack itemStack2 = (ItemStack) nonNullListA.get(pVar);
                    if (!itemStack2.isEmpty()) {
                        if (this.b.getItem(height).isEmpty()) {
                            this.b.setItem(height, itemStack2);
                        } else if (!player.getInventory().add(itemStack2)) {
                            player.drop(itemStack2, false);
                        }
                    }
                }
            }
        }
        super.onTake(player, itemStack);
    }

    protected NonNullList<ItemStack> a(CraftingInput craftingInput, Level level) {
        return (NonNullList) level.getRecipeManager().getRecipeFor(RecipeType.CRAFTING, craftingInput, level).map(recipeHolder -> {
            return recipeHolder.value().getRemainingItems(craftingInput);
        }).orElse(NonNullList.withSize(this.b.a(), ItemStack.EMPTY));
    }

    public void setRecipeUsed(@Nullable RecipeHolder<?> recipeHolder) {
        this.c = recipeHolder;
    }

    @Nullable
    public RecipeHolder<?> getRecipeUsed() {
        return this.c;
    }
}
