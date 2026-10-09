package mctech.blockentities.c;

import java.util.Optional;
import mctech.api.features.ITileActivityProvider;
import mctech.api.network.buffer.NetworkInfo;
import mctech.api.tiles.readers.IProgressMachine;
import mctech.api.tiles.readers.ISubProgressMachine;
import mctech.init.MCTechRecipes;
import mctech.m.b.aJ;
import mctech.u.C0191s;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/c/af.class */
public class af extends mctech.blockentities.e implements ITileActivityProvider, IProgressMachine, ISubProgressMachine, mctech.m.a.k {

    @NetworkInfo(fieldName = "mainProgress")
    public int a;

    @NetworkInfo(fieldName = "secondaryProgress")
    public int b;

    @NetworkInfo(fieldName = "storedType")
    public ResourceLocation c;

    @NetworkInfo(fieldName = "storedPoints")
    public int d;

    @NetworkInfo(fieldName = "color")
    public int e;
    protected mctech.u.aa f;

    public af(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState, 3, mctech.q.c.c, C0074u.e);
        this.inventoryManager.a().a(mctech.m.g.y.g(0).a(this::a)).a(mctech.m.g.y.f(1).a(this::b)).a(mctech.m.g.y.d(2)).i();
        addGuiFields(this);
        addComparator(new mctech.blocks.base.a.a.a.a.f("progress", mctech.blocks.base.a.a.d.m, this));
        addComparator(new mctech.blocks.base.a.a.a.a.h("sub_progress", mctech.blocks.base.a.a.d.n, this));
    }

    @Override // mctech.blockentities.e
    public boolean supportsNotify() {
        return false;
    }

    @Override // mctech.m.a.d
    public mctech.m.b.S createContainer(Player player, InteractionHand interactionHand, Direction direction, int i) {
        return new aJ(this, player, i);
    }

    public boolean a() {
        ItemStack itemStack = (ItemStack) this.inventory.get(0);
        ItemStack itemStack2 = (ItemStack) this.inventory.get(2);
        if (this.c == null || this.d <= 0) {
            this.f = null;
            return false;
        }
        if (this.f != null && !this.f.assemble(new mctech.u.aa.a(itemStack, this.c), this.level.registryAccess()).isEmpty()) {
            return true;
        }
        mctech.u.aa.a aVar = new mctech.u.aa.a(itemStack, this.c);
        Optional recipeFor = this.level.getRecipeManager().getRecipeFor((RecipeType) MCTechRecipes.URANIUM_ENRICHER.get(), aVar, this.level);
        if (recipeFor.isEmpty()) {
            this.f = null;
            return false;
        }
        this.f = (mctech.u.aa) ((RecipeHolder) recipeFor.get()).value();
        if (itemStack2.isEmpty() || mctech.utils.c.h.b(this.f.assemble(aVar, this.level.registryAccess()), itemStack2)) {
            return true;
        }
        this.f = null;
        return false;
    }

    public Optional<RecipeHolder<C0191s>> b() {
        return this.level.getRecipeManager().getRecipeFor((RecipeType) MCTechRecipes.ENRICHER_MATERIAL.get(), new C0191s.a((ItemStack) this.inventory.get(1), this.c), this.level);
    }

    public boolean a(ItemStack itemStack) {
        return this.level.getRecipeManager().getRecipeFor((RecipeType) MCTechRecipes.URANIUM_ENRICHER.get(), new mctech.u.aa.a(itemStack, this.c), this.level).isPresent();
    }

    public boolean b(ItemStack itemStack) {
        return this.level.getRecipeManager().getRecipeFor((RecipeType) MCTechRecipes.ENRICHER_MATERIAL.get(), new C0191s.a(itemStack, this.c), this.level).isPresent();
    }

    @Override // mctech.api.tiles.readers.ISubProgressMachine
    public float getSubProgress() {
        return this.b;
    }

    @Override // mctech.api.tiles.readers.ISubProgressMachine
    public float getMaxSubProgress() {
        return 100.0f;
    }

    @Override // mctech.api.tiles.readers.IProgressMachine
    public float getProgress() {
        return this.a;
    }

    @Override // mctech.api.tiles.readers.IProgressMachine
    public float getMaxProgress() {
        return 1000.0f;
    }

    public int c() {
        return this.d;
    }

    public int d() {
        return 1000;
    }

    public int e() {
        return this.e;
    }
}
