package mctech.blockentities.c;

import java.util.Arrays;
import java.util.EnumSet;
import mctech.api.items.IUpgradeItem;
import mctech.api.network.buffer.NetworkInfo;
import mctech.api.tiles.IMachine;
import mctech.blockentities.BasicMachineTileEntity;
import mctech.init.MCTechRecipes;
import mctech.init.MCTechTiles;
import mctech.m.b.C0166z;
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

/* JADX INFO: renamed from: mctech.blockentities.c.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/c/n.class */
public class C0067n extends BasicMachineTileEntity implements IMachine, IMachineTier {
    private final MachineTier a;

    @NetworkInfo(fieldName = "p")
    private final float[] b;

    public C0067n(BlockPos blockPos, BlockState blockState) {
        this((BlockEntityType) MCTechTiles.ELECTRONIC_PLANT.get(), blockPos, blockState, mctech.h.a.c.t.get(blockState.getValue(MachineTier.PROPERTY)));
    }

    public C0067n(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState, mctech.h.a.c.n nVar) {
        super(blockEntityType, blockPos, blockState, nVar.a * 5, nVar.f, nVar.d, nVar.e, nVar.c, nVar.b);
        this.a = blockState.getValue(MachineTier.PROPERTY);
        this.inventoryManager = new mctech.m.e.j<>(this, nVar.f);
        for (int i = 0; i < nVar.a; i++) {
            int i2 = i * 5;
            this.inventoryManager.a(mctech.m.g.y.f(i2).a(new mctech.m.c.m(this)));
            this.inventoryManager.a(mctech.m.g.y.f(i2 + 1).a(new mctech.m.c.m(this)));
            this.inventoryManager.a(mctech.m.g.y.f(i2 + 2).a(new mctech.m.c.m(this)));
            this.inventoryManager.a(mctech.m.g.y.f(i2 + 3).a(new mctech.m.c.a.d(this)));
            this.inventoryManager.a(mctech.m.g.y.d(i2 + 4));
        }
        if (this.a.isAtLeast(MachineTier.T3)) {
            this.inventoryManager.a(this);
        }
        this.inventoryManager.i();
        this.b = new float[nVar.a];
        Arrays.fill(this.b, 0.0f);
        addNetworkFields(this);
    }

    @NotNull
    public BlockEntityType<?> getType() {
        return (BlockEntityType) MCTechTiles.ELECTRONIC_PLANT.get();
    }

    @Override // mctech.blockentities.BasicMachineTileEntity, mctech.api.tiles.IMachine
    public EnumSet<IUpgradeItem.UpgradeType> getSupportedUpgradeTypes() {
        return defaultUpgrades(machineTier());
    }

    @Override // mctech.blockentities.BasicMachineTileEntity, mctech.api.tiles.IInputMachine
    public int getValidRoom(ItemStack itemStack) {
        return ((Integer) this.inventory.stream().filter(itemStack2 -> {
            return mctech.utils.c.h.d(itemStack, itemStack2);
        }).map(mctech.utils.c.h::b).filter(num -> {
            return num.intValue() > 0;
        }).findAny().orElse(0)).intValue();
    }

    @Override // mctech.api.tiles.readers.IProgressMachine
    public int getSlots() {
        return this.b.length;
    }

    @Override // mctech.blockentities.BasicMachineTileEntity, mctech.api.tiles.readers.IProgressMachine
    public float getProgress() {
        return getProgressSlot(0);
    }

    @Override // mctech.blockentities.BasicMachineTileEntity, mctech.api.tiles.readers.IProgressMachine
    public float getMaxProgress() {
        return getMaxProgressSlot(0);
    }

    @Override // mctech.api.tiles.readers.IProgressMachine
    public float getProgressSlot(int i) {
        if (isOperating()) {
            return this.b[i];
        }
        return 0.0f;
    }

    @Override // mctech.api.tiles.readers.IProgressMachine
    public float getMaxProgressSlot(int i) {
        return this.upgradeHandler.c();
    }

    @Override // mctech.blockentities.BasicMachineTileEntity, mctech.blockentities.k, mctech.api.tiles.IMachineInfo
    public int getEnergyPerTick() {
        return this.upgradeHandler.b();
    }

    @Override // mctech.blockentities.BasicMachineTileEntity, mctech.api.tiles.IMachineInfo
    public int getOperationTime() {
        return this.upgradeHandler.c();
    }

    @Override // mctech.blockentities.BasicMachineTileEntity, mctech.m.a.d
    public mctech.m.b.S createContainer(Player player, InteractionHand interactionHand, Direction direction, int i) {
        return new C0166z(this, player, i);
    }

    @Override // mctech.api.tiles.IRecipeMachine
    public <I extends RecipeInput, T extends Recipe<I>> RecipeType<T> getRecipeType() {
        return MCTechRecipes.type("electronic_plant");
    }

    @NotNull
    public MachineTier machineTier() {
        return this.a;
    }

    @Override // mctech.blockentities.q
    public boolean shouldBlockUpdateEnableTick() {
        return true;
    }
}
