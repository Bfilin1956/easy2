package mctech.blockentities.c;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.stream.IntStream;
import mctech.api.items.IUpgradeItem;
import mctech.api.network.buffer.NetworkInfo;
import mctech.api.util.DirectionList;
import mctech.blockentities.BasicMachineTileEntity;
import mctech.m.b.C0163w;
import net.mcskill.msregistry.core.MachineTier;
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
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: mctech.blockentities.c.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/c/k.class */
public class C0064k extends BasicMachineTileEntity {
    NonNullList<ItemStack> a;
    private static final int b = 9;
    private static final int c = 9;

    @NetworkInfo(fieldName = "multiProgress")
    private final float[] d;

    @NetworkInfo(fieldName = "multiMaxProgress")
    private final float[] e;

    @NetworkInfo(fieldName = "recipeEnergy")
    private final int[] f;

    @NetworkInfo(fieldName = "sortingEnabled")
    private boolean g;

    public C0064k(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState, 18, 4, mctech.h.a.b.j.a, 200, mctech.h.a.b.j.b, mctech.h.a.b.j.c);
        this.a = NonNullList.withSize(9, ItemStack.EMPTY);
        this.inventoryManager = new mctech.m.e.j<>(this, 4);
        this.inventoryManager.a(new mctech.m.g.y(mctech.m.e.k.g, IntStream.range(0, 9).toArray()).a(DirectionList.ALL).a(mctech.m.e.a.IMPORT).a(new mctech.m.c.m(this)));
        this.inventoryManager.a(new mctech.m.g.y(mctech.m.e.k.l, IntStream.range(9, 18).toArray()).a(DirectionList.ALL).a(mctech.m.e.a.EXPORT).a(mctech.m.c.r.c));
        this.d = new float[9];
        this.e = new float[9];
        this.f = new int[9];
        this.inventoryManager.a(this);
        this.inventoryManager.i();
        Arrays.fill(this.d, 0.0f);
        Arrays.fill(this.e, 1.0f);
        addNetworkFields(this);
        addGuiFields(this);
    }

    @NotNull
    public MachineTier machineTier() {
        return MachineTier.T6;
    }

    @Override // mctech.api.tiles.IRecipeMachine
    public <I extends RecipeInput, T extends Recipe<I>> RecipeType<T> getRecipeType() {
        return (RecipeType) mctech.u.E.m.get();
    }

    @Override // mctech.blockentities.BasicMachineTileEntity, mctech.m.a.d
    public mctech.m.b.S createContainer(Player player, InteractionHand interactionHand, Direction direction, int i) {
        return new C0163w(this, player, i);
    }

    @Override // mctech.api.features.redstone.IComparable
    public boolean isAllowingUI() {
        return false;
    }

    @Override // mctech.blockentities.i, mctech.m.e.e
    public boolean allowsUI() {
        return false;
    }

    @Override // mctech.blockentities.q, mctech.api.network.tile.INetworkClientEventListener
    public void onClientDataReceived(Player player, int i, int i2) {
    }

    @Override // mctech.blockentities.BasicMachineTileEntity, mctech.api.tiles.IMachine
    public EnumSet<IUpgradeItem.UpgradeType> getSupportedUpgradeTypes() {
        return EnumSet.of(IUpgradeItem.UpgradeType.SPEED_MOD, IUpgradeItem.UpgradeType.ENERGY_MOD, IUpgradeItem.UpgradeType.SPEED_MOD_COMPOSITE, IUpgradeItem.UpgradeType.SPEED_MOD_NANO, IUpgradeItem.UpgradeType.SPEED_MOD_QUANT, IUpgradeItem.UpgradeType.SPEED_MOD_TITAN, IUpgradeItem.UpgradeType.SPEED_MOD_RUBIDIUM, IUpgradeItem.UpgradeType.COMPLEX_HANDLER_MOD, IUpgradeItem.UpgradeType.AUDIO_MOD, IUpgradeItem.UpgradeType.ADMIN_MOD, IUpgradeItem.UpgradeType.TRANSFORMER_MOD);
    }

    @Override // mctech.api.tiles.readers.IProgressMachine
    public int getSlots() {
        return 9;
    }

    @Override // mctech.api.tiles.readers.IProgressMachine
    public float getProgressSlot(int i) {
        return this.d[i];
    }

    @Override // mctech.api.tiles.readers.IProgressMachine
    public float getMaxProgressSlot(int i) {
        return this.e[i];
    }

    public boolean a() {
        return this.g;
    }

    @Override // mctech.blockentities.BasicMachineTileEntity, mctech.api.tiles.readers.IProgressMachine
    public float getProgress() {
        return (float) IntStream.range(0, 9).mapToDouble(i -> {
            return this.d[i];
        }).average().orElse(0.0d);
    }

    @Override // mctech.blockentities.BasicMachineTileEntity, mctech.api.tiles.readers.IProgressMachine
    public float getMaxProgress() {
        return (float) IntStream.range(0, 9).mapToDouble(i -> {
            return this.e[i];
        }).average().orElse(0.0d);
    }
}
