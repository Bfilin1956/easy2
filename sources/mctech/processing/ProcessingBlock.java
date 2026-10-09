package mctech.processing;

import mctech.api.network.buffer.INetworkDataBuffer;
import mctech.api.network.tile.INetworkFieldProvider;
import mctech.blockentities.k;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeInput;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/processing/ProcessingBlock.class */
public class ProcessingBlock<RI extends RecipeInput, R extends Recipe<RI>, BE extends k & INetworkFieldProvider> implements INetworkDataBuffer {
    private final int index;
    private float progress;
    private int operationLength;
    private int energyConsumption;
    private boolean isOperating;
    private boolean canOperate;

    public ProcessingBlock(BE be, int i) {
        this.index = i;
        this.energyConsumption = 0;
    }

    public ProcessingBlock(BE be, int i, int i2) {
        this.index = i;
        this.energyConsumption = i2;
    }

    public float getProgress() {
        return this.progress;
    }

    public int getEnergyConsumption() {
        return this.energyConsumption;
    }

    public int getOperationLength() {
        return this.operationLength;
    }

    public int getIndex() {
        return this.index;
    }

    @Override // mctech.api.network.buffer.INetworkDataBuffer
    public void read(RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        this.progress = registryFriendlyByteBuf.readFloat();
        this.operationLength = registryFriendlyByteBuf.readInt();
        this.energyConsumption = registryFriendlyByteBuf.readInt();
        this.isOperating = registryFriendlyByteBuf.readBoolean();
        this.canOperate = registryFriendlyByteBuf.readBoolean();
    }

    @Override // mctech.api.network.buffer.INetworkDataBuffer
    public void write(RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        registryFriendlyByteBuf.writeFloat(this.progress);
        registryFriendlyByteBuf.writeInt(this.operationLength);
        registryFriendlyByteBuf.writeInt(this.energyConsumption);
        registryFriendlyByteBuf.writeBoolean(this.isOperating);
        registryFriendlyByteBuf.writeBoolean(this.canOperate);
    }

    public void load(CompoundTag compoundTag, HolderLookup.Provider provider) {
        this.progress = compoundTag.getFloat("progress");
        this.operationLength = compoundTag.getInt("operationLength");
        this.energyConsumption = compoundTag.getInt("energyConsumption");
    }

    public void save(CompoundTag compoundTag, HolderLookup.Provider provider) {
        compoundTag.putFloat("progress", this.progress);
        compoundTag.putInt("operationLength", this.operationLength);
        compoundTag.putInt("energyConsumption", this.energyConsumption);
    }

    public boolean isOperating() {
        return this.isOperating;
    }

    public boolean canOperate() {
        return this.canOperate;
    }
}
