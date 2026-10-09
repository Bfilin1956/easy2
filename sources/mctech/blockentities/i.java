package mctech.blockentities;

import java.util.List;
import javax.annotation.Nullable;
import mctech.MCTech;
import mctech.api.features.IDropProvider;
import mctech.api.network.buffer.NetworkInfo;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.client.model.data.ModelData;
import net.neoforged.neoforge.client.model.data.ModelProperty;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import net.neoforged.neoforge.items.IItemHandler;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/i.class */
public abstract class i extends q implements IDropProvider, mctech.m.a.g, mctech.m.e.d, mctech.m.e.e {
    public static final ModelProperty<mctech.m.e.d> IO_CONFIG_PROPERTY = new ModelProperty<>();
    private ModelData modelData;
    private boolean shouldRenderAccessRules;
    public NonNullList<ItemStack> inventory;
    public int inventorySize;

    @NetworkInfo(fieldName = "handler")
    private mctech.m.e.i handler;
    protected mctech.m.e.j<?> inventoryManager;

    public i(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        this(blockEntityType, blockPos, blockState, 0);
    }

    public i(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState, int i) {
        super(blockEntityType, blockPos, blockState);
        this.modelData = ModelData.EMPTY;
        this.shouldRenderAccessRules = false;
        this.inventorySize = i;
        this.inventory = NonNullList.withSize(i, ItemStack.EMPTY);
        this.handler = new mctech.m.e.i(this);
        this.inventoryManager = new mctech.m.e.j<>(this);
        addGuiFields(this);
        this.handler.c();
        if (this.inventorySize > 0) {
            addComparator(new mctech.blocks.base.a.a.a.a.e("slots", mctech.blocks.base.a.a.d.b, this, true));
            addComparator(new mctech.blocks.base.a.a.a.a.e("items", mctech.blocks.base.a.a.d.a, this, false));
            addComparator(new mctech.blocks.base.a.a.a.a.a("dir_slots", mctech.blocks.base.a.a.d.d, this, true));
            addComparator(new mctech.blocks.base.a.a.a.a.a("dir_items", mctech.blocks.base.a.a.d.c, this, false));
        }
    }

    @NotNull
    public ModelData getModelData() {
        return renderAccessRules() ? this.modelData : ModelData.EMPTY;
    }

    @Override // mctech.m.e.d
    @NotNull
    public mctech.m.e.a getAccess(@NotNull Direction direction) {
        return getInventoryHandler().d(direction);
    }

    @Override // mctech.m.e.d
    public boolean renderAccessRules() {
        return this.shouldRenderAccessRules;
    }

    @Override // mctech.m.e.d
    public void renderAccessRules(boolean z) {
        this.shouldRenderAccessRules = z;
        if (FMLEnvironment.dist.isClient()) {
            sendToServer(32702, z ? 1 : 0);
        }
        notifyInventoryHandlerChanged();
    }

    public void setSlotCount(int i) {
        this.inventorySize = i;
        this.inventory = NonNullList.withSize(i, ItemStack.EMPTY);
    }

    public void updateInventory(NonNullList<ItemStack> nonNullList) {
        this.inventory = nonNullList;
    }

    @Override // mctech.m.e.f
    public mctech.m.e.j<?> getInventoryManager() {
        return this.inventoryManager;
    }

    @Override // mctech.m.e.e
    public mctech.m.e.i getInventoryHandler() {
        return this.handler;
    }

    @Override // mctech.m.e.e
    public void setInventoryHandler(mctech.m.e.i iVar) {
        this.handler = iVar;
    }

    public boolean allowsUI() {
        return true;
    }

    @Nullable
    public IItemHandler getItemHandler(@Nullable Direction direction) {
        return this.handler.c(direction);
    }

    @Nullable
    public IFluidHandler getFluidHandler(@Nullable Direction direction) {
        return null;
    }

    public IItemHandler getInternalInventory() {
        IItemHandler itemHandler = getItemHandler(null);
        return itemHandler == null ? mctech.m.e.c.a : itemHandler;
    }

    public void addDrops(List<ItemStack> list) {
        for (int i = 0; i < this.inventorySize; i++) {
            ItemStack itemStack = (ItemStack) this.inventory.get(i);
            if (!itemStack.isEmpty()) {
                list.add(itemStack);
            }
        }
    }

    @Override // mctech.blockentities.q
    public void onUnloaded(boolean z) {
        this.handler.b();
        this.inventoryManager.b();
        super.onUnloaded(z);
    }

    @Override // mctech.m.a.g
    public int getSlotCount() {
        return this.inventorySize;
    }

    @Override // mctech.m.a.g
    public ItemStack getStackInSlot(int i) {
        if (i >= this.inventory.size()) {
            MCTech.LOGGER.error(String.format("Trying to access slot at index %s, but there is only %s slots in invetory of %s available, return EMPTY!", Integer.valueOf(i), Integer.valueOf(this.inventory.size()), getClass().getSimpleName()));
            return ItemStack.EMPTY;
        }
        return (ItemStack) this.inventory.get(i);
    }

    public void setStackInSlot(int i, ItemStack itemStack) {
        this.inventory.set(i, itemStack);
        if (itemStack.getCount() > getMaxStackSize(i)) {
            itemStack.setCount(getMaxStackSize(i));
        }
        setChanged();
    }

    @Override // mctech.m.a.g
    public void setStackInSlotSilent(int i, ItemStack itemStack) {
        if (i < 0 || i >= this.inventory.size()) {
            return;
        }
        this.inventory.set(i, itemStack);
        if (!itemStack.isEmpty() && itemStack.getCount() > getMaxStackSize(i)) {
            itemStack.setCount(getMaxStackSize(i));
        }
    }

    @Override // mctech.m.a.g
    public void markInventoryChanged() {
        setChanged();
    }

    public int getMaxStackSize(int i) {
        return this.inventoryManager.d(i);
    }

    public boolean canInsert(int i, ItemStack itemStack) {
        mctech.m.e.a.a aVarB = this.handler.b(i);
        return aVarB == null || aVarB.matches(i, itemStack);
    }

    public boolean canExtract(int i, ItemStack itemStack) {
        return true;
    }

    protected void setOrGrow(int i, ItemStack itemStack, boolean z) {
        ItemStack itemStack2 = (ItemStack) this.inventory.get(i);
        if (itemStack2.isEmpty()) {
            this.inventory.set(i, itemStack);
        } else if (!z || mctech.utils.c.h.d(itemStack2, itemStack)) {
            itemStack2.setCount(Mth.clamp(itemStack.getCount() + itemStack2.getCount(), 0, getMaxStackSize(i)));
        }
    }

    protected boolean canPlace(int i, ItemStack itemStack) {
        ItemStack itemStack2 = (ItemStack) this.inventory.get(i);
        if (itemStack2.isEmpty()) {
            return true;
        }
        return mctech.utils.c.h.d(itemStack2, itemStack) && getMaxStackSize(i) - itemStack2.getCount() >= itemStack.getCount();
    }

    protected boolean transferStack(int i, int i2) {
        int maxStackSize;
        if (((ItemStack) this.inventory.get(i)).isEmpty()) {
            return false;
        }
        if (((ItemStack) this.inventory.get(i2)).isEmpty()) {
            this.inventory.set(i2, (ItemStack) this.inventory.get(i));
            this.inventory.set(i, ItemStack.EMPTY);
            return true;
        }
        if (mctech.utils.c.h.d((ItemStack) this.inventory.get(i2), (ItemStack) this.inventory.get(i)) && (maxStackSize = getMaxStackSize(i2) - ((ItemStack) this.inventory.get(i2)).getCount()) > 0) {
            if (maxStackSize >= ((ItemStack) this.inventory.get(i)).getCount()) {
                ((ItemStack) this.inventory.get(i2)).grow(((ItemStack) this.inventory.get(i)).getCount());
                this.inventory.set(i, ItemStack.EMPTY);
                return true;
            }
            ((ItemStack) this.inventory.get(i2)).grow(maxStackSize);
            ((ItemStack) this.inventory.get(i)).shrink(maxStackSize);
            return true;
        }
        return false;
    }

    @Override // mctech.blockentities.q
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return super.getUpdatePacket();
    }

    public void handleUpdateTag(CompoundTag compoundTag, HolderLookup.Provider provider) {
        super.handleUpdateTag(compoundTag, provider);
        MCTech.NETWORKING.handleInitialChange(this, compoundTag);
        notifyInventoryHandlerChanged();
    }

    private void notifyInventoryHandlerChanged() {
        if (renderAccessRules()) {
            this.modelData = this.modelData.derive().with(IO_CONFIG_PROPERTY, this).build();
            requestModelDataUpdate();
        }
    }
}
