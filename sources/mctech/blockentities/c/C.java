package mctech.blockentities.c;

import mctech.api.features.ITileActivityProvider;
import mctech.api.network.buffer.NetworkInfo;
import mctech.api.tiles.IRecipeMachine;
import mctech.api.tiles.readers.IProgressMachine;
import mctech.init.MCTechRecipes;
import mctech.init.MCTechTiles;
import net.mcskill.msregistry.core.IMachineTier;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/c/C.class */
public class C extends mctech.blockentities.e implements ITileActivityProvider, IRecipeMachine, IProgressMachine, mctech.m.a.k, IMachineTier {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 0;
    private final MachineTier d;

    @NetworkInfo(fieldName = "itemProgress")
    private long e;

    @NetworkInfo(fieldName = "requiredItem")
    private int f;

    @NetworkInfo(fieldName = "requiredEnergy")
    private int g;

    @NetworkInfo(fieldName = "displayStack")
    private ItemStack h;

    public C(BlockPos blockPos, BlockState blockState) {
        this((BlockEntityType) MCTechTiles.MATRIX_CONVERTER.get(), blockPos, blockState, mctech.h.a.c.A);
    }

    public C(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState, mctech.h.a.c.f fVar) {
        super(blockEntityType, blockPos, blockState, 0, fVar.c, fVar.a);
        this.h = ItemStack.EMPTY;
        this.d = blockState.getValue(MachineTier.PROPERTY);
        this.inventoryManager = new mctech.m.e.j(this).a(mctech.m.g.y.f(0).a(new mctech.m.c.m(this))).a(mctech.m.g.y.d(1));
        this.inventoryManager.i();
        addNetworkFields(this);
        addGuiFields(this);
    }

    @Override // mctech.blockentities.q
    public boolean shouldBlockUpdateEnableTick() {
        return true;
    }

    @Override // mctech.blockentities.e
    public boolean supportsNotify() {
        return false;
    }

    public long a() {
        return this.e;
    }

    public int b() {
        return this.f;
    }

    public int c() {
        return this.g;
    }

    public ItemStack d() {
        return this.h;
    }

    public long e() {
        return Math.max(0L, ((long) this.f) - this.e);
    }

    public float f() {
        if (this.f <= 0) {
            return 0.0f;
        }
        return Math.min(100.0f, (this.e * 100.0f) / this.f);
    }

    @Override // mctech.api.tiles.readers.IProgressMachine
    public float getProgress() {
        return this.e;
    }

    @Override // mctech.api.tiles.readers.IProgressMachine
    public float getMaxProgress() {
        return Math.max(1, this.f);
    }

    @Override // mctech.api.tiles.IInputMachine
    public int getValidRoom(ItemStack itemStack) {
        return 0;
    }

    @Override // mctech.m.a.d
    public mctech.m.b.S createContainer(Player player, InteractionHand interactionHand, Direction direction, int i) {
        return new mctech.m.b.V(this, player, i);
    }

    @Override // mctech.api.tiles.IRecipeMachine
    public <I extends RecipeInput, T extends Recipe<I>> RecipeType<T> getRecipeType() {
        return MCTechRecipes.type(mctech.i.i.MATRIX_CONVERTER);
    }

    @Override // mctech.api.tiles.IRecipeMachine
    public float getProgressPerTick() {
        return 1.0f;
    }

    @NotNull
    public MachineTier machineTier() {
        return this.d;
    }
}
