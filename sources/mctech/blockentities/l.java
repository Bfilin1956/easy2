package mctech.blockentities;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import mctech.api.features.IXPMachine;
import mctech.api.items.IUpgradeItem;
import mctech.api.network.buffer.NetworkInfo;
import mctech.api.tiles.IMachine;
import mctech.api.tiles.IRecipeMachine;
import mctech.api.tiles.readers.IProgressMachine;
import mctech.processing.ProcessingBlock;
import net.mcskill.msregistry.core.IMachineTier;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/l.class */
public abstract class l<I extends RecipeInput, R extends Recipe<I>> extends k implements IXPMachine, IMachine, IRecipeMachine, IProgressMachine, mctech.m.a.k, mctech.processing.e.a<I, R, l<I, R>>, IMachineTier {
    private final MachineTier e;

    @NetworkInfo(fieldName = "processingBlockHolder")
    protected mctech.processing.e<I, R, l<I, R>> a;
    protected List<ProcessingBlock<I, R, l<I, R>>> b;
    protected boolean c;
    protected boolean d;

    protected abstract void b();

    protected abstract void c();

    public l(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState, int i, int i2, int i3, int i4) {
        super(blockEntityType, blockPos, blockState, 0, 0, i, i2, i3, i4);
        this.e = blockState.getValue(MachineTier.PROPERTY);
        this.a = new mctech.processing.e<>(this);
        this.b = new ArrayList();
        this.c = true;
        this.d = true;
        c();
        b();
        addNetworkFields(this);
    }

    @Override // mctech.blockentities.k
    protected void createInvCaches() {
        this.inOut = this.inventoryManager.g();
    }

    @Override // mctech.api.tiles.IMachine
    public EnumSet<IUpgradeItem.UpgradeType> getSupportedUpgradeTypes() {
        return defaultUpgrades(machineTier());
    }

    @Override // mctech.api.tiles.IInputMachine
    public int getValidRoom(ItemStack itemStack) {
        return ((Integer) this.inventory.stream().filter(itemStack2 -> {
            return mctech.utils.c.h.d(itemStack, itemStack2);
        }).map(mctech.utils.c.h::b).filter(num -> {
            return num.intValue() > 0;
        }).findAny().orElse(0)).intValue();
    }

    @Override // mctech.api.tiles.readers.IProgressMachine
    public float getProgress() {
        return getProgressSlot(0);
    }

    @Override // mctech.api.tiles.readers.IProgressMachine
    public float getMaxProgress() {
        return getMaxProgressSlot(0);
    }

    @Override // mctech.api.tiles.readers.IProgressMachine
    public int getSlots() {
        return this.b.size();
    }

    @Override // mctech.api.tiles.readers.IProgressMachine
    public float getProgressSlot(int i) {
        ProcessingBlock<I, R, l<I, R>> processingBlock = this.b.get(i);
        if (!processingBlock.canOperate()) {
            return 0.0f;
        }
        if (this.upgradeHandler.f(processingBlock.getOperationLength())) {
            return 1.0f;
        }
        return processingBlock.getProgress();
    }

    @Override // mctech.api.tiles.readers.IProgressMachine
    public float getMaxProgressSlot(int i) {
        ProcessingBlock<I, R, l<I, R>> processingBlock = this.b.get(i);
        if (!processingBlock.canOperate()) {
            return 0.0f;
        }
        if (this.upgradeHandler.f(processingBlock.getOperationLength())) {
            return 1.0f;
        }
        return processingBlock.getOperationLength();
    }

    @Override // mctech.blockentities.k, mctech.api.tiles.IMachineInfo
    public int getEnergyPerTick() {
        if (this.d) {
            return (int) this.b.stream().filter(processingBlock -> {
                return processingBlock.getEnergyConsumption() > 0;
            }).mapToInt((v0) -> {
                return v0.getEnergyConsumption();
            }).average().orElse(0.0d);
        }
        return this.upgradeHandler.b();
    }

    @Override // mctech.api.tiles.IMachineInfo
    public int getOperationTime() {
        if (this.c) {
            return this.b.stream().mapToInt((v0) -> {
                return v0.getOperationLength();
            }).max().orElse(this.upgradeHandler.c());
        }
        return this.upgradeHandler.c();
    }

    @NotNull
    public MachineTier machineTier() {
        return this.e;
    }

    @Override // mctech.blockentities.q
    public boolean shouldBlockUpdateEnableTick() {
        return true;
    }

    @Override // mctech.processing.e.a
    public ProcessingBlock<I, R, l<I, R>> a(int i) {
        return this.b.get(i);
    }

    @Override // mctech.processing.e.a
    public int a() {
        return this.b.size();
    }

    @Override // mctech.api.tiles.IRecipeMachine
    public RecipeType<R> getRecipeType() {
        return null;
    }
}
