package mctech.e;

import java.util.Objects;
import mctech.init.MCTechDataComponent;
import mctech.items.g;
import mctech.items.v;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemContainerContents;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/e/c.class */
public class c extends mctech.items.base.b {
    private final v d;
    private final g e;
    private boolean f;

    public c(@NotNull ItemStack itemStack, @NotNull v vVar) {
        super(itemStack, vVar);
        this.d = vVar;
        this.e = new g(itemStack, MCTechDataComponent.BLADE.get(), 1);
        this.f = ((Boolean) Objects.requireNonNullElse((Boolean) itemStack.get(MCTechDataComponent.ACTIVATED), false)).booleanValue();
    }

    public void a(boolean z) {
        this.f = z;
        this.a.set(MCTechDataComponent.ACTIVATED, Boolean.valueOf(z));
    }

    public boolean a() {
        return this.f;
    }

    @Override // mctech.items.base.b
    @NotNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public v e() {
        return this.d;
    }

    public g c() {
        return this.e;
    }

    @NotNull
    public static ItemStack a(@NotNull ItemStack itemStack) {
        ItemContainerContents itemContainerContents = (ItemContainerContents) itemStack.get(MCTechDataComponent.BLADE);
        if (itemContainerContents == null || itemContainerContents.getSlots() <= 0) {
            return ItemStack.EMPTY;
        }
        return itemContainerContents.getStackInSlot(0);
    }

    public static boolean b(@NotNull ItemStack itemStack) {
        return ((Boolean) Objects.requireNonNullElse((Boolean) itemStack.get(MCTechDataComponent.ACTIVATED), false)).booleanValue();
    }
}
