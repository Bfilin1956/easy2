package mctech.u;

import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.crafting.FluidIngredient;

/* JADX INFO: renamed from: mctech.u.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/g.class */
public abstract class AbstractC0179g extends AbstractC0180h {
    private final int a;
    private final ItemStack b;
    private final ItemStack c;
    private final ItemStack d;
    private final FluidIngredient e;
    private final FluidStack f;
    private final int g;

    public AbstractC0179g(Ingredient ingredient, int i, ItemStack itemStack, ItemStack itemStack2, ItemStack itemStack3, double d, int i2, FluidIngredient fluidIngredient, int i3, FluidStack fluidStack) {
        super(ingredient, itemStack, d, 0.0f, i2, false);
        this.a = i;
        this.b = itemStack;
        this.c = itemStack2;
        this.d = itemStack3;
        this.e = fluidIngredient;
        this.g = i3;
        this.f = fluidStack;
    }

    public AbstractC0179g(Ingredient ingredient, int i, ItemStack itemStack, double d, int i2, FluidIngredient fluidIngredient, int i3, FluidStack fluidStack) {
        this(ingredient, i, itemStack, ItemStack.EMPTY, ItemStack.EMPTY, d, i2, fluidIngredient, i3, fluidStack);
    }

    public AbstractC0179g(Ingredient ingredient, int i, ItemStack itemStack, ItemStack itemStack2, double d, int i2, FluidIngredient fluidIngredient, int i3) {
        this(ingredient, i, itemStack, itemStack2, ItemStack.EMPTY, d, i2, fluidIngredient, i3, null);
    }

    public AbstractC0179g(Ingredient ingredient, int i, ItemStack itemStack, double d, int i2, FluidIngredient fluidIngredient, int i3) {
        this(ingredient, i, itemStack, ItemStack.EMPTY, ItemStack.EMPTY, d, i2, fluidIngredient, i3, null);
    }

    public AbstractC0179g(Ingredient ingredient, int i, ItemStack itemStack, ItemStack itemStack2, ItemStack itemStack3, double d, int i2) {
        this(ingredient, i, itemStack, itemStack2, itemStack3, d, i2, null, 0, null);
    }

    public AbstractC0179g(Ingredient ingredient, int i, ItemStack itemStack, ItemStack itemStack2, double d, int i2) {
        this(ingredient, i, itemStack, itemStack2, ItemStack.EMPTY, d, i2, null, 0, null);
    }

    public AbstractC0179g(Ingredient ingredient, int i, ItemStack itemStack, double d, int i2) {
        this(ingredient, i, itemStack, ItemStack.EMPTY, ItemStack.EMPTY, d, i2, null, 0, null);
    }

    @Override // mctech.u.AbstractC0180h
    public int a() {
        return this.a;
    }

    @Override // mctech.u.AbstractC0180h
    public boolean matches(RecipeInput recipeInput, Level level) {
        return recipeInput.getItem(0).getCount() >= this.a && super.matches(recipeInput, level);
    }

    @Override // mctech.u.AbstractC0180h
    public ItemStack assemble(RecipeInput recipeInput, HolderLookup.Provider provider) {
        return ItemStack.EMPTY;
    }

    public ItemStack[] a(RecipeInput recipeInput) {
        return recipeInput.getItem(0).getCount() >= this.a ? new ItemStack[]{this.b.copy(), this.c.copy(), this.d.copy()} : new ItemStack[]{ItemStack.EMPTY};
    }

    public ItemStack b() {
        return this.b;
    }

    public ItemStack c() {
        return this.c;
    }

    public ItemStack d() {
        return this.d;
    }

    public FluidIngredient e() {
        return this.e;
    }

    public FluidStack f() {
        return this.f;
    }

    public int g() {
        return this.g;
    }
}
