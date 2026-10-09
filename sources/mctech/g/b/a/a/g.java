package mctech.g.b.a.a;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Supplier;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.fluids.FluidStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/b/a/a/g.class */
public abstract class g implements m {
    private FluidStack a = FluidStack.EMPTY;

    public abstract FluidStack b();

    public abstract void a(FluidStack fluidStack);

    public static g a() {
        return new g() { // from class: mctech.g.b.a.a.g.1
            private FluidStack a = FluidStack.EMPTY;

            @Override // mctech.g.b.a.a.g
            public FluidStack b() {
                return this.a;
            }

            @Override // mctech.g.b.a.a.g
            public void a(FluidStack fluidStack) {
                this.a = fluidStack;
            }
        };
    }

    public static g a(final Supplier<FluidStack> supplier, final Consumer<FluidStack> consumer) {
        return new g() { // from class: mctech.g.b.a.a.g.2
            @Override // mctech.g.b.a.a.g
            public FluidStack b() {
                return (FluidStack) supplier.get();
            }

            @Override // mctech.g.b.a.a.g
            public void a(FluidStack fluidStack) {
                consumer.accept(fluidStack);
            }
        };
    }

    public static g a(final Supplier<FluidStack> supplier) {
        return new g() { // from class: mctech.g.b.a.a.g.3
            @Override // mctech.g.b.a.a.g
            public FluidStack b() {
                return (FluidStack) supplier.get();
            }

            @Override // mctech.g.b.a.a.g
            public void a(FluidStack fluidStack) {
                throw new UnsupportedOperationException("Attempt to set a read-only sync slot.");
            }
        };
    }

    @Override // mctech.g.b.a.a.m
    public m.a c() {
        FluidStack fluidStackB = b();
        if (Objects.equals(fluidStackB, this.a)) {
            return m.a.NONE;
        }
        m.a aVar = fluidStackB.getFluid().isSame(this.a.getFluid()) ? m.a.PARTIAL : m.a.FULL;
        this.a = fluidStackB.copy();
        return aVar;
    }

    @Override // mctech.g.b.a.a.m
    public mctech.g.b.a.a.a.l a(Level level, m.a aVar) {
        if (aVar == m.a.PARTIAL) {
            return new mctech.g.b.a.a.a.e(b().getAmount());
        }
        return new mctech.g.b.a.a.a.d(b());
    }

    @Override // mctech.g.b.a.a.m
    public void a(Level level, mctech.g.b.a.a.a.l lVar) {
        if (lVar instanceof mctech.g.b.a.a.a.e) {
            a(b().copyWithAmount(((mctech.g.b.a.a.a.e) lVar).b()));
        } else if (lVar instanceof mctech.g.b.a.a.a.d) {
            a(((mctech.g.b.a.a.a.d) lVar).b());
        }
    }
}
