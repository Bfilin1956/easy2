package mctech.m.b;

import java.util.EnumSet;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;
import mctech.api.tiles.ICustomContainer;
import mctech.blockentities.c.C0071r;
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
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/F.class */
public class F extends AbstractC0115i<C0071r> implements ICustomContainer {
    public F(C0071r c0071r, Player player, int i) {
        super(c0071r, player, i);
        MachineTier machineTier = c0071r.machineTier();
        switch (AnonymousClass1.a[machineTier.ordinal()]) {
            case 1:
            case 2:
            case 3:
                if (machineTier.isAtLeast(MachineTier.T4)) {
                    addSlot(new mctech.m.g.g(c0071r, 0, 68, 29, new mctech.m.c.m(c0071r)));
                    addSlot(mctech.m.g.g.d(c0071r, 1, 146, 29));
                    addSlot(new mctech.m.g.g(c0071r, 2, 68, 53, new mctech.m.c.m(c0071r)));
                    addSlot(mctech.m.g.g.d(c0071r, 3, 146, 53));
                } else {
                    addSlot(new mctech.m.g.g(c0071r, 0, 68, 41, new mctech.m.c.m(c0071r)));
                    addSlot(mctech.m.g.g.d(c0071r, 1, 146, 41));
                }
                addPlayerInventoryAt(player.getInventory(), 35, 111);
                break;
            case 4:
                addSlot(new mctech.m.g.g(c0071r, 0, 68, 29, new mctech.m.c.m(c0071r)));
                addSlot(mctech.m.g.g.d(c0071r, 1, 146, 29));
                addSlot(new mctech.m.g.g(c0071r, 2, 68, 52, new mctech.m.c.m(c0071r)));
                addSlot(mctech.m.g.g.d(c0071r, 3, 146, 52));
                addSlot(new mctech.m.g.g(c0071r, 4, 68, 75, new mctech.m.c.m(c0071r)));
                addSlot(mctech.m.g.g.d(c0071r, 5, 146, 75));
                addPlayerInventoryAt(player.getInventory(), 35, 133);
                break;
        }
        List<Integer> listB = c0071r.getInventoryManager().b(mctech.m.e.k.c);
        for (int i2 = 0; i2 < listB.size(); i2++) {
            addSlot(new mctech.m.g.z(c0071r, listB.get(i2).intValue(), aI.f, 19 + (i2 * 19)));
        }
        getComponents().clear();
        switch (AnonymousClass1.a[machineTier.ordinal()]) {
            case 1:
            case 2:
            case 3:
                if (machineTier.isAtLeast(MachineTier.T4)) {
                    a(106, 30, 0, machineTier);
                    a(106, 54, 1, machineTier);
                    a(106, 30);
                    a(106, 54);
                } else {
                    a(106, 42, 0, machineTier);
                    a(106, 42);
                }
                break;
            case 4:
                a(106, 30, 0, machineTier);
                a(106, 53, 1, machineTier);
                a(106, 76, 2, machineTier);
                a(106, 30);
                a(106, 53);
                a(106, 76);
                break;
        }
        int i3 = machineTier == MachineTier.T5 ? 101 : 79;
        Objects.requireNonNull(machineTier);
        addComponent(new C0093f(78, i3, c0071r, machineTier::ordinal));
        int i4 = machineTier == MachineTier.T5 ? 109 : 87;
        Objects.requireNonNull(machineTier);
        addComponent(new C0095h(113, i4, c0071r, machineTier::ordinal));
        Objects.requireNonNull(machineTier);
        addComponent(new C0097j(this, machineTier::ordinal));
        Objects.requireNonNull(machineTier);
        addComponent(new mctech.components.a.H(c0071r, machineTier::ordinal).d("gui.mctech.inventory.button"));
        Objects.requireNonNull(machineTier);
        addComponent(new mctech.components.a.u(c0071r, machineTier::ordinal).a(EnumSet.of(mctech.components.a.u.a.ENERGY_INPUT, mctech.components.a.u.a.ENERGY_STORAGE, mctech.components.a.u.a.OPERATION_TIME, mctech.components.a.u.a.OPERATION_COST)).b((Component) MCTechLang.TOOLTIP_INFO_BUTTON));
    }

    /* JADX INFO: renamed from: mctech.m.b.F$1, reason: invalid class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/F$1.class */
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
        }
    }

    private void a(int i, int i2) {
        addComponent(new C0096i(i + 2, i2 - 2, () -> {
            EmiMachineRegistry.displayRecipes((C0071r) getHolder());
        }).b((Component) MCTechLang.TOOLTIP_SHOW_RECIPES).a(-90.0f));
    }

    private void a(int i, int i2, int i3, MachineTier machineTier) {
        Supplier supplier = () -> {
            return Integer.valueOf((int) ((C0071r) this.gui).getProgressSlot(i3));
        };
        Supplier supplier2 = () -> {
            return Integer.valueOf((int) ((C0071r) this.gui).getMaxProgressSlot(i3));
        };
        Objects.requireNonNull(machineTier);
        addComponent(new mctech.components.a.N(i + 2, i2 - 2, supplier, supplier2, machineTier::ordinal).a(-90.0f));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // mctech.components.ContainerComponent
    public ResourceLocation getTexture() {
        return mctech.m.a.a(this, ((C0071r) getHolder()).machineTier(), "former");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // mctech.components.ContainerComponent
    @OnlyIn(Dist.CLIENT)
    public void onGuiLoaded(mctech.m.d.b bVar) {
        bVar.c(1);
        bVar.c(2);
        bVar.e(237);
        bVar.f(((C0071r) getHolder()).machineTier() == MachineTier.T5 ? 214 : 193);
    }
}
