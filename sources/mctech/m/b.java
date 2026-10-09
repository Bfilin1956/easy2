package mctech.m;

import java.util.List;
import java.util.function.BiPredicate;
import mctech.init.MCTechDataComponent;
import mctech.m.a.e;
import mctech.m.a.i;
import mctech.m.g.x;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b.class */
public final class b {
    public static final b a = new b();
    List<BiPredicate<AbstractContainerMenu, Slot>> b = mctech.utils.a.b.i();

    private b() {
        a(new C0026b());
    }

    public void a(BiPredicate<AbstractContainerMenu, Slot> biPredicate) {
        this.b.add(biPredicate);
    }

    public boolean a(AbstractContainerMenu abstractContainerMenu, Slot slot) {
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            if (this.b.get(i).test(abstractContainerMenu, slot)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b$a.class */
    public static class a implements BiPredicate<AbstractContainerMenu, Slot> {
        Class<? extends AbstractContainerMenu> a;

        public a(Class<? extends AbstractContainerMenu> cls) {
            this.a = cls;
        }

        @Override // java.util.function.BiPredicate
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean test(AbstractContainerMenu abstractContainerMenu, Slot slot) {
            return this.a.isInstance(abstractContainerMenu);
        }
    }

    /* JADX INFO: renamed from: mctech.m.b$b, reason: collision with other inner class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b$b.class */
    static class C0026b implements BiPredicate<AbstractContainerMenu, Slot> {
        C0026b() {
        }

        @Override // java.util.function.BiPredicate
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean test(AbstractContainerMenu abstractContainerMenu, Slot slot) {
            if ((slot instanceof x) && (((x) slot).f() instanceof i)) {
                return true;
            }
            ItemStack item = slot.getItem();
            return (item.getItem() instanceof e) && item.has(MCTechDataComponent.GUI_ID);
        }
    }
}
