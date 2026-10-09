package mctech.fluid;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import javax.annotation.Nonnull;
import mctech.api.network.buffer.INetworkDataBuffer;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import net.neoforged.neoforge.fluids.capability.templates.FluidTank;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/fluid/g.class */
public class g extends FluidTank implements INetworkDataBuffer {
    List<Consumer<g>> b;

    public g(int i) {
        this(i, fluidStack -> {
            return true;
        });
    }

    public g(int i, Predicate<FluidStack> predicate) {
        super(i, predicate);
    }

    public g a(Consumer<g> consumer) {
        if (this.b == null) {
            this.b = mctech.utils.a.b.i();
        }
        this.b.add(consumer);
        return this;
    }

    public g b(Consumer<g> consumer) {
        if (this.b.remove(consumer) && this.b.isEmpty()) {
            this.b = null;
        }
        return this;
    }

    protected void onContentsChanged() {
        if (this.b != null) {
            int size = this.b.size();
            for (int i = 0; i < size; i++) {
                this.b.get(i).accept(this);
            }
        }
    }

    @Nonnull
    public FluidStack drain(int i, IFluidHandler.FluidAction fluidAction) {
        int amount = i;
        if (this.fluid.getAmount() < amount) {
            amount = this.fluid.getAmount();
        }
        FluidStack fluidStack = new FluidStack(this.fluid.getFluid(), amount);
        if (fluidAction.execute() && amount > 0) {
            this.fluid.shrink(amount);
            onContentsChanged();
        }
        return fluidStack;
    }

    public FluidTank readFromNBT(HolderLookup.Provider provider, CompoundTag compoundTag) {
        setFluid(FluidStack.parseOptional(provider, compoundTag));
        return this;
    }

    public CompoundTag writeToNBT(HolderLookup.Provider provider, CompoundTag compoundTag) {
        if (this.fluid.isEmpty()) {
            return new CompoundTag();
        }
        return this.fluid.save(provider);
    }

    @Override // mctech.api.network.buffer.INetworkDataBuffer
    public void write(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        registryFriendlyByteBuf.writeBoolean(this.fluid.isEmpty());
        registryFriendlyByteBuf.writeInt(this.capacity);
        if (this.fluid.isEmpty()) {
            return;
        }
        FluidStack.STREAM_CODEC.encode(registryFriendlyByteBuf, this.fluid);
    }

    @Override // mctech.api.network.buffer.INetworkDataBuffer
    public void read(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        if (registryFriendlyByteBuf.readBoolean()) {
            setFluid(FluidStack.EMPTY);
            this.capacity = registryFriendlyByteBuf.readInt();
        } else {
            this.capacity = registryFriendlyByteBuf.readInt();
            setFluid((FluidStack) FluidStack.STREAM_CODEC.decode(registryFriendlyByteBuf));
        }
    }
}
