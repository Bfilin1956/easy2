package mctech.v.i;

import java.util.List;
import net.minecraft.world.inventory.tooltip.TooltipComponent;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.fluids.FluidStack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/i/b.class */
public class b<T> implements TooltipComponent {

    @NotNull
    private final List<T> a;

    private b(@NotNull List<T> list) {
        this.a = list;
    }

    public List<T> a() {
        return this.a;
    }

    /* JADX INFO: renamed from: mctech.v.i.b$b, reason: collision with other inner class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/i/b$b.class */
    public static class C0049b extends b<ItemStack> {
        public C0049b(List<ItemStack> list) {
            super(list);
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/i/b$a.class */
    public static class a extends b<FluidStack> {
        public a(List<FluidStack> list) {
            super(list);
        }
    }
}
