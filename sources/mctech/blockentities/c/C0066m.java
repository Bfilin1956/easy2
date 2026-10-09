package mctech.blockentities.c;

import java.util.Optional;
import mctech.api.features.ITileActivityProvider;
import mctech.api.features.IWrenchableTile;
import mctech.api.network.buffer.NetworkInfo;
import mctech.api.tiles.IElectrolyzerProvider;
import mctech.api.tiles.readers.IEUStorage;
import mctech.api.util.DirectionList;
import mctech.api.util.ILocation;
import mctech.init.MCTechRecipes;
import mctech.m.b.C0165y;
import mctech.u.C0189q;
import net.mcskill.msregistry.core.IMachineTier;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: mctech.blockentities.c.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/c/m.class */
public class C0066m extends mctech.blockentities.i implements ITileActivityProvider, IWrenchableTile, IEUStorage, ILocation, mctech.m.a.k, IMachineTier {

    @NetworkInfo(fieldName = "energy")
    public int a;

    @NetworkInfo(fieldName = "maxEnergy")
    public int b;
    IElectrolyzerProvider c;
    C0189q d;
    mctech.d.d<IElectrolyzerProvider> e;
    public static final int f = 0;
    public static final int g = 1;
    public static final int h = 2;

    public C0066m(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState, 3);
        this.a = 0;
        this.b = 0;
        this.e = new mctech.d.e(this, DirectionList.ALL, IElectrolyzerProvider.class);
        addGuiFields(this);
        addCaches(this.e);
        addComparator(new mctech.blocks.base.a.a.a.a.b("eu_storage", mctech.blocks.base.a.a.d.e, this));
        this.inventoryManager.a().a(mctech.m.g.y.a(mctech.m.e.k.q, 0).a(itemStack -> {
            return a(itemStack, 0, true);
        })).a(mctech.m.g.y.a(mctech.m.e.k.r, 1).a(itemStack2 -> {
            return a(itemStack2, 1, false);
        })).a(mctech.m.g.y.d(2)).i();
    }

    @Override // mctech.m.a.d
    public mctech.m.b.S createContainer(Player player, InteractionHand interactionHand, Direction direction, int i) {
        return new C0165y(this, player, i);
    }

    @Override // mctech.api.tiles.readers.IEUStorage
    public int getMaxEU() {
        return this.b;
    }

    @Override // mctech.api.tiles.readers.IEUStorage
    public int getStoredEU() {
        return this.a;
    }

    @Override // mctech.api.tiles.readers.IEUStorage
    public int getTier() {
        return 1;
    }

    public boolean a(ItemStack itemStack, int i, boolean z) {
        if (!((ItemStack) this.inventory.get(i)).isEmpty()) {
            return mctech.utils.c.h.d((ItemStack) this.inventory.get(i), itemStack);
        }
        return a(itemStack, z).isPresent();
    }

    public Optional<RecipeHolder<C0189q>> a(ItemStack itemStack, boolean z) {
        return this.level.getRecipeManager().getRecipeFor((RecipeType) MCTechRecipes.ELECTROLYZER.get(), new C0189q.a(itemStack, 2.147483647E9d, z), this.level);
    }

    public IElectrolyzerProvider a() {
        if (this.e.e()) {
            return null;
        }
        return this.e.b(this.e.c().getDefaultFacing());
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
        return 0.8d;
    }

    @NotNull
    public MachineTier machineTier() {
        return MachineTier.T2;
    }
}
