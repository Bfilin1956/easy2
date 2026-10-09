package mctech.p.b.a;

import java.util.List;
import javax.annotation.Nullable;
import mctech.MCTech;
import mctech.api.features.IDropProvider;
import mctech.api.network.buffer.NetworkInfo;
import mctech.m.a.g;
import mctech.m.e.i;
import mctech.m.e.j;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import net.neoforged.neoforge.items.IItemHandler;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/p/b/a/c.class */
public class c extends e implements IDropProvider, g, mctech.m.e.e {
    public NonNullList<ItemStack> i;
    public int j;

    @NetworkInfo(fieldName = "handler")
    private i a;
    protected j<?> k;

    public c(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        this(blockEntityType, blockPos, blockState, 0);
    }

    public c(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState, int i) {
        super(blockEntityType, blockPos, blockState);
        this.j = i;
        this.i = NonNullList.withSize(i, ItemStack.EMPTY);
        this.a = new i(this);
        this.k = new j<>(this);
        this.a.c();
        addNetworkFields(this);
    }

    @Override // mctech.m.a.g
    public void setSlotCount(int i) {
        this.j = i;
    }

    @Override // mctech.m.a.g
    public void updateInventory(NonNullList<ItemStack> nonNullList) {
        this.i = nonNullList;
    }

    @Override // mctech.m.e.f
    public j<?> getInventoryManager() {
        return this.k;
    }

    @Override // mctech.m.e.e
    public i getInventoryHandler() {
        return this.a;
    }

    @Override // mctech.m.e.e
    public void setInventoryHandler(i iVar) {
        this.a = iVar;
    }

    @Override // mctech.m.a.g
    public int getSlotCount() {
        return this.j;
    }

    @Override // mctech.m.a.g
    public ItemStack getStackInSlot(int i) {
        if (i >= this.i.size()) {
            return ItemStack.EMPTY;
        }
        return (ItemStack) this.i.get(i);
    }

    @Override // mctech.m.a.g
    public void setStackInSlot(int i, ItemStack itemStack) {
        this.i.set(i, itemStack);
        if (itemStack.getCount() > getMaxStackSize(i)) {
            itemStack.setCount(getMaxStackSize(i));
        }
        setChanged();
    }

    @Override // mctech.m.a.g
    public int getMaxStackSize(int i) {
        return 64;
    }

    @Override // mctech.m.a.g
    public boolean canInsert(int i, ItemStack itemStack) {
        mctech.m.e.a.a aVarB = this.a.b(i);
        return aVarB == null || aVarB.matches(i, itemStack);
    }

    @Override // mctech.m.a.g
    public boolean canExtract(int i, ItemStack itemStack) {
        return true;
    }

    @Override // mctech.m.e.e
    public boolean allowsUI() {
        return true;
    }

    @Nullable
    public IItemHandler a(@Nullable Direction direction) {
        return this.a.c(direction);
    }

    @Nullable
    public IFluidHandler b(@Nullable Direction direction) {
        return null;
    }

    @Override // mctech.api.features.IDropProvider
    public void addDrops(List<ItemStack> list) {
        for (int i = 0; i < this.j; i++) {
            ItemStack itemStack = (ItemStack) this.i.get(i);
            if (!itemStack.isEmpty()) {
                list.add(itemStack);
            }
        }
    }

    @Override // mctech.p.b.a.e
    public void b(boolean z) {
        this.a.b();
        this.k.b();
        super.b(z);
    }

    @Override // mctech.p.b.a.e, mctech.p.b.b
    protected void loadAdditional(@NotNull CompoundTag compoundTag, HolderLookup.Provider provider) {
        super.loadAdditional(compoundTag, provider);
        this.a.b(provider, compoundTag.getCompound("handler"));
        ContainerHelper.loadAllItems(compoundTag, this.i, provider);
    }

    @Override // mctech.p.b.a.e, mctech.p.b.b
    protected void saveAdditional(@NotNull CompoundTag compoundTag, HolderLookup.Provider provider) {
        super.saveAdditional(compoundTag, provider);
        mctech.utils.c.e.a(compoundTag, "handler", this.a.a(provider, new CompoundTag()));
        ContainerHelper.saveAllItems(compoundTag, this.i, provider);
    }

    @Override // mctech.p.b.b
    public void handleUpdateTag(@NotNull CompoundTag compoundTag, HolderLookup.Provider provider) {
        super.handleUpdateTag(compoundTag, provider);
        MCTech.NETWORKING.handleInitialChange(this, compoundTag);
    }
}
