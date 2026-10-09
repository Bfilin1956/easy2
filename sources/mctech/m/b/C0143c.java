package mctech.m.b;

import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;
import mctech.blockentities.c.C0054a;
import mctech.components.AbstractC0115i;
import mctech.components.a.C0093f;
import mctech.components.a.C0095h;
import mctech.components.a.C0096i;
import mctech.components.a.C0097j;
import mctech.init.MCTechLang;
import mctech.integration.emi.plugin.base.EmiMachineRegistry;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;

/* JADX INFO: renamed from: mctech.m.b.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/c.class */
public class C0143c extends AbstractC0115i<C0054a> {
    public C0143c(C0054a c0054a, Player player, int i) {
        super(c0054a, player, i);
        this.addedPreviewer = true;
        MachineTier machineTier = c0054a.machineTier();
        switch (AnonymousClass1.a[machineTier.ordinal()]) {
            case 1:
            case 2:
                a(c0054a, 0, 68, 41);
                addPlayerInventoryAt(player.getInventory(), 35, 111);
                Objects.requireNonNull(machineTier);
                addComponent(new C0093f(78, 79, c0054a, machineTier::ordinal));
                Objects.requireNonNull(machineTier);
                addComponent(new C0095h(112, 87, c0054a, machineTier::ordinal));
                Objects.requireNonNull(machineTier);
                addComponent(new mctech.components.a.u(c0054a, machineTier::ordinal).a(mctech.components.a.u.a));
                Objects.requireNonNull(machineTier);
                addComponent(new mctech.components.a.H(c0054a, machineTier::ordinal));
                Objects.requireNonNull(machineTier);
                addComponent(new C0097j(this, machineTier::ordinal));
                break;
            case 3:
                a(c0054a, 0, 68, 29);
                a(c0054a, 1, 68, 53);
                addPlayerInventoryAt(player.getInventory(), 35, 111);
                Objects.requireNonNull(machineTier);
                addComponent(new C0093f(78, 79, c0054a, machineTier::ordinal));
                Objects.requireNonNull(machineTier);
                addComponent(new C0095h(112, 87, c0054a, machineTier::ordinal));
                Objects.requireNonNull(machineTier);
                addComponent(new mctech.components.a.u(c0054a, machineTier::ordinal).a(mctech.components.a.u.a));
                Objects.requireNonNull(machineTier);
                addComponent(new mctech.components.a.H(c0054a, machineTier::ordinal));
                Objects.requireNonNull(machineTier);
                addComponent(new C0097j(this, machineTier::ordinal));
                break;
            case 4:
                a(c0054a, 0, 68, 29);
                a(c0054a, 1, 68, 52);
                a(c0054a, 2, 68, 75);
                addPlayerInventoryAt(player.getInventory(), 35, 133);
                Objects.requireNonNull(machineTier);
                addComponent(new C0093f(78, 101, c0054a, machineTier::ordinal));
                Objects.requireNonNull(machineTier);
                addComponent(new C0095h(112, 109, c0054a, machineTier::ordinal));
                Objects.requireNonNull(machineTier);
                addComponent(new mctech.components.a.u(c0054a, machineTier::ordinal).a(mctech.components.a.u.a));
                Objects.requireNonNull(machineTier);
                addComponent(new mctech.components.a.H(c0054a, machineTier::ordinal));
                Objects.requireNonNull(machineTier);
                addComponent(new C0097j(this, machineTier::ordinal));
                break;
            case 5:
                a(c0054a, 0, 23, 29);
                a(c0054a, 1, 127, 29);
                a(c0054a, 2, 23, 52);
                a(c0054a, 3, 127, 52);
                a(c0054a, 4, 75, 75);
                addPlayerInventoryAt(player.getInventory(), 42, 133);
                Objects.requireNonNull(machineTier);
                addComponent(new C0093f(85, 101, c0054a, machineTier::ordinal));
                Objects.requireNonNull(machineTier);
                addComponent(new C0095h(119, 109, c0054a, machineTier::ordinal));
                Objects.requireNonNull(machineTier);
                addComponent(new mctech.components.a.u(c0054a, machineTier::ordinal).a(mctech.components.a.u.a));
                Objects.requireNonNull(machineTier);
                addComponent(new mctech.components.a.H(c0054a, machineTier::ordinal));
                Objects.requireNonNull(machineTier);
                addComponent(new C0097j(this, machineTier::ordinal));
                break;
            case 6:
                a(c0054a, 0, 23, 29);
                a(c0054a, 1, 127, 29);
                a(c0054a, 2, 23, 52);
                a(c0054a, 3, 127, 52);
                a(c0054a, 4, 23, 75);
                a(c0054a, 5, 127, 75);
                a(c0054a, 6, 23, 98);
                a(c0054a, 7, 127, 98);
                a(c0054a, 8, 75, 121);
                addPlayerInventoryAt(player.getInventory(), 42, 173);
                Objects.requireNonNull(machineTier);
                addComponent(new C0093f(85, 147, c0054a, machineTier::ordinal));
                Objects.requireNonNull(machineTier);
                addComponent(new C0095h(119, 155, c0054a, machineTier::ordinal));
                Objects.requireNonNull(machineTier);
                addComponent(new mctech.components.a.u(c0054a, machineTier::ordinal).a(mctech.components.a.u.a));
                Objects.requireNonNull(machineTier);
                addComponent(new mctech.components.a.H(c0054a, machineTier::ordinal));
                Objects.requireNonNull(machineTier);
                addComponent(new C0097j(this, machineTier::ordinal));
                break;
        }
        List<Integer> listB = c0054a.getInventoryManager().b(mctech.m.e.k.c);
        for (int i2 = 0; i2 < listB.size(); i2++) {
            addSlot(new mctech.m.g.z(c0054a, listB.get(i2).intValue(), machineTier.isAtLeast(MachineTier.T6) ? 234 : aI.f, 19 + (i2 * 19)));
        }
    }

    /* JADX INFO: renamed from: mctech.m.b.c$1, reason: invalid class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/c$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[MachineTier.values().length];

        static {
            try {
                a[MachineTier.T2.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[MachineTier.T3.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[MachineTier.T4.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[MachineTier.T5.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                a[MachineTier.T6.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                a[MachineTier.T7.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    @Override // mctech.components.ContainerComponent
    public void onGuiLoaded(mctech.m.d.b bVar) {
        bVar.c(1);
        bVar.c(2);
        switch (AnonymousClass1.a[((C0054a) this.gui).machineTier().ordinal()]) {
            case 1:
                bVar.e(aI.f, 193);
                break;
            case 2:
            case 3:
                bVar.e(238, 193);
                break;
            case 4:
                bVar.e(238, 215);
                break;
            case 5:
                bVar.e(252, 215);
                break;
            case 6:
                bVar.e(252, 254);
                break;
        }
    }

    private void a(C0054a c0054a, int i, int i2, int i3) {
        addSlot(new mctech.m.g.g(c0054a, i * 3, i2, i3, new mctech.m.c.m(c0054a)));
        addSlot(new mctech.m.g.g(c0054a, (i * 3) + 1, i2 + 36, i3, new mctech.m.c.m(c0054a)));
        addSlot(new mctech.m.g.B(c0054a, (i * 3) + 2, i2 + 78, i3));
        Supplier supplier = () -> {
            return Integer.valueOf((int) c0054a.getProgressSlot(i));
        };
        Supplier supplier2 = () -> {
            return Integer.valueOf((int) c0054a.getMaxProgressSlot(i));
        };
        MachineTier machineTier = c0054a.machineTier();
        Objects.requireNonNull(machineTier);
        addComponent(new mctech.components.a.N(i2 + 58, i3, supplier, supplier2, machineTier::ordinal).a(-90.0f));
        a(i2 + 56, i3 + 2);
    }

    private void a(int i, int i2) {
        addComponent(new C0096i(i + 2, i2 - 2, () -> {
            EmiMachineRegistry.displayRecipes((C0054a) getHolder());
        }).b((Component) MCTechLang.TOOLTIP_SHOW_RECIPES).a(-90.0f));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // mctech.components.ContainerComponent
    public ResourceLocation getTexture() {
        return mctech.m.a.a(this, ((C0054a) getHolder()).machineTier(), "alloy_smelter");
    }
}
