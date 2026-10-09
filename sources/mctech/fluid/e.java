package mctech.fluid;

import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import mctech.api.network.buffer.INetworkDataBuffer;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.IFluidTank;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/fluid/e.class */
public class e implements INetworkDataBuffer, IFluidTank, IFluidHandler {
    int b;
    int c;
    List<Consumer<e>> a = mctech.utils.a.b.i();
    Object2ObjectMap<Fluid, FluidStack> d = mctech.utils.a.b.f();
    List<Fluid> e = mctech.utils.a.b.i();

    public e(int i) {
        this.b = i;
    }

    public void a(Consumer<e> consumer) {
        this.a.add(consumer);
    }

    public void a() {
        Iterator<Consumer<e>> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().accept(this);
        }
    }

    public CompoundTag a(HolderLookup.Provider provider, CompoundTag compoundTag) {
        ListTag listTag = new ListTag();
        ObjectIterator it = this.d.values().iterator();
        while (it.hasNext()) {
            FluidStack fluidStack = (FluidStack) it.next();
            if (!fluidStack.isEmpty()) {
                listTag.add(fluidStack.save(provider));
            }
        }
        compoundTag.put("fluids", listTag);
        compoundTag.putInt("stored", this.c);
        return compoundTag;
    }

    public void b(HolderLookup.Provider provider, CompoundTag compoundTag) {
        this.c = compoundTag.getInt("stored");
        Iterator it = mctech.utils.a.h.a(compoundTag.getList("fluids", 10), CompoundTag.class).iterator();
        while (it.hasNext()) {
            FluidStack optional = FluidStack.parseOptional(provider, (CompoundTag) it.next());
            if (!optional.isEmpty()) {
                this.e.add(optional.getFluid());
                this.d.put(optional.getFluid(), optional);
            }
        }
    }

    @Override // mctech.api.network.buffer.INetworkDataBuffer
    public void write(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        registryFriendlyByteBuf.writeInt(this.c);
        registryFriendlyByteBuf.writeShort((short) this.d.size());
        ObjectIterator it = this.d.values().iterator();
        while (it.hasNext()) {
            FluidStack.STREAM_CODEC.encode(registryFriendlyByteBuf, (FluidStack) it.next());
        }
    }

    @Override // mctech.api.network.buffer.INetworkDataBuffer
    public void read(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        this.c = registryFriendlyByteBuf.readInt();
        this.d.clear();
        this.e.clear();
        short s = registryFriendlyByteBuf.readShort();
        for (int i = 0; i < s; i++) {
            FluidStack fluidStack = (FluidStack) FluidStack.STREAM_CODEC.decode(registryFriendlyByteBuf);
            if (!fluidStack.isEmpty()) {
                this.e.add(fluidStack.getFluid());
                this.d.put(fluidStack.getFluid(), fluidStack);
            }
        }
    }

    public int getTanks() {
        return Math.max(1, this.e.size());
    }

    public FluidStack getFluidInTank(int i) {
        return i >= this.e.size() ? FluidStack.EMPTY : (FluidStack) this.d.get(this.e.get(i));
    }

    public int getTankCapacity(int i) {
        return this.b;
    }

    public boolean isFluidValid(int i, FluidStack fluidStack) {
        return true;
    }

    public int fill(FluidStack fluidStack, IFluidHandler.FluidAction fluidAction) {
        if (fluidStack.isEmpty() || this.b - this.c <= 0) {
            return 0;
        }
        if (fluidAction.simulate()) {
            return Math.min(this.b - this.c, fluidStack.getAmount());
        }
        FluidStack fluidStackCopy = (FluidStack) this.d.getOrDefault(fluidStack.getFluid(), FluidStack.EMPTY);
        if (fluidStackCopy.isEmpty()) {
            fluidStackCopy = fluidStack.copy();
            this.d.put(fluidStackCopy.getFluid(), fluidStackCopy);
            this.e.add(fluidStackCopy.getFluid());
            fluidStackCopy.setAmount(0);
        }
        int iMin = Math.min(fluidStack.getAmount(), this.b - this.c);
        fluidStackCopy.grow(iMin);
        this.c += iMin;
        a();
        return iMin;
    }

    public FluidStack drain(FluidStack fluidStack, IFluidHandler.FluidAction fluidAction) {
        if (this.c <= 0 || fluidStack.isEmpty()) {
            return FluidStack.EMPTY;
        }
        FluidStack fluidStack2 = (FluidStack) this.d.getOrDefault(fluidStack.getFluid(), FluidStack.EMPTY);
        if (fluidStack2.isEmpty()) {
            return FluidStack.EMPTY;
        }
        FluidStack fluidStack3 = new FluidStack(fluidStack2.getFluid(), Math.min(fluidStack2.getAmount(), fluidStack.getAmount()));
        if (fluidAction.execute()) {
            fluidStack2.shrink(fluidStack3.getAmount());
            if (fluidStack2.getAmount() <= 0) {
                this.e.remove(fluidStack.getFluid());
                this.d.get(fluidStack.getFluid());
            }
            this.c -= fluidStack3.getAmount();
            a();
        }
        return fluidStack3;
    }

    public FluidStack drain(int i, IFluidHandler.FluidAction fluidAction) {
        if (i <= 0 || this.c <= 0) {
            return FluidStack.EMPTY;
        }
        FluidStack fluidStack = (FluidStack) this.d.get(this.e.get(0));
        FluidStack fluidStack2 = new FluidStack(fluidStack.getFluid(), Math.min(fluidStack.getAmount(), i));
        if (fluidAction.execute()) {
            fluidStack.shrink(fluidStack2.getAmount());
            if (fluidStack.getAmount() <= 0) {
                this.e.remove(fluidStack2.getFluid());
                this.d.get(fluidStack2.getFluid());
            }
            this.c -= fluidStack2.getAmount();
            a();
        }
        return fluidStack2;
    }

    public FluidStack getFluid() {
        return this.e.isEmpty() ? FluidStack.EMPTY : (FluidStack) this.d.get(this.e.get(0));
    }

    public int getFluidAmount() {
        return this.c;
    }

    public int getCapacity() {
        return this.b;
    }

    public boolean isFluidValid(FluidStack fluidStack) {
        return true;
    }
}
