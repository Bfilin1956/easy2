package mctech.fluid;

import java.util.function.Consumer;
import java.util.function.Predicate;
import mctech.api.network.tile.INetworkFieldProvider;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/fluid/h.class */
public class h<Machine extends BlockEntity & INetworkFieldProvider> extends g implements c {
    private boolean a;
    private boolean c;

    public h(int i) {
        super(i);
        this.a = false;
        this.c = false;
    }

    public h(int i, Predicate<FluidStack> predicate) {
        super(i, predicate);
        this.a = false;
        this.c = false;
    }

    public h<Machine> a(boolean z) {
        this.a = z;
        return this;
    }

    public h<Machine> b(boolean z) {
        this.c = z;
        return this;
    }

    public h<Machine> a(Machine machine, Runnable runnable) {
        return this;
    }

    @Override // mctech.fluid.g
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public h<Machine> a(Consumer<g> consumer) {
        return (h) super.a(consumer);
    }

    public void a() {
        setFluid(FluidStack.EMPTY);
        onContentsChanged();
    }

    public int fill(@NotNull FluidStack fluidStack, @NotNull IFluidHandler.FluidAction fluidAction) {
        if (this.c) {
            return 0;
        }
        return super.fill(fluidStack, fluidAction);
    }

    @Override // mctech.fluid.c
    public int a(@NotNull FluidStack fluidStack, @NotNull IFluidHandler.FluidAction fluidAction) {
        return super.fill(fluidStack, fluidAction);
    }

    @Override // mctech.fluid.g
    @NotNull
    public FluidStack drain(int i, IFluidHandler.FluidAction fluidAction) {
        return this.a ? FluidStack.EMPTY : super.drain(i, fluidAction);
    }

    @Override // mctech.fluid.c
    @NotNull
    public FluidStack a(int i, IFluidHandler.FluidAction fluidAction) {
        return super.drain(i, fluidAction);
    }

    @NotNull
    public FluidStack drain(@NotNull FluidStack fluidStack, @NotNull IFluidHandler.FluidAction fluidAction) {
        return this.a ? FluidStack.EMPTY : super.drain(fluidStack, fluidAction);
    }

    public h<Machine> a(@NotNull mctech.m.e.e eVar, @NotNull Direction direction) {
        return a(eVar, direction, false);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    public h<Machine> a(@NotNull mctech.m.e.e eVar, @NotNull Direction direction, boolean z) throws MatchException {
        switch (eVar.getInventoryHandler().d(direction)) {
            case DISABLED:
                return null;
            case IMPORT:
                if (z) {
                    return this;
                }
                return null;
            case BOTH:
            case EXPORT:
                return this;
            default:
                throw new MatchException((String) null, (Throwable) null);
        }
    }
}
