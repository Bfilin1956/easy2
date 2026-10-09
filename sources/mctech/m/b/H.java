package mctech.m.b;

import java.util.EnumSet;
import java.util.List;
import java.util.Objects;
import mctech.api.tiles.ICustomContainer;
import mctech.components.AbstractC0115i;
import mctech.components.a.C0089b;
import mctech.components.a.C0093f;
import mctech.components.a.C0095h;
import mctech.components.a.C0096i;
import mctech.components.a.C0097j;
import mctech.init.MCTechLang;
import mctech.integration.emi.plugin.base.EmiMachineRegistry;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/H.class */
public class H extends AbstractC0115i<mctech.processing.c> implements ICustomContainer {
    public H(mctech.processing.c cVar, Player player, int i) {
        super(cVar, player, i);
        MachineTier machineTier = cVar.machineTier();
        switch (AnonymousClass1.a[machineTier.ordinal()]) {
            case 1:
            case 2:
                a(cVar, 0, 92, 40);
                Objects.requireNonNull(machineTier);
                addComponent(new C0093f(85, 78, cVar, machineTier::ordinal));
                Objects.requireNonNull(machineTier);
                addComponent(new C0095h(119, 86, cVar, machineTier::ordinal));
                addPlayerInventoryAt(player.getInventory(), 42, 110);
                break;
            case 3:
                a(cVar, 0, 92, 27);
                a(cVar, 1, 92, 53);
                Objects.requireNonNull(machineTier);
                addComponent(new C0093f(85, 78, cVar, machineTier::ordinal));
                Objects.requireNonNull(machineTier);
                addComponent(new C0095h(119, 86, cVar, machineTier::ordinal));
                addPlayerInventoryAt(player.getInventory(), 42, 110);
                break;
            case 4:
                a(cVar, 0, 92, 27);
                a(cVar, 1, 92, 53);
                a(cVar, 2, 92, 79);
                Objects.requireNonNull(machineTier);
                addComponent(new C0093f(85, 103, cVar, machineTier::ordinal));
                Objects.requireNonNull(machineTier);
                addComponent(new C0095h(119, 111, cVar, machineTier::ordinal));
                addPlayerInventoryAt(player.getInventory(), 42, 135);
                break;
            case 5:
                b(cVar, 0, 62, 27);
                b(cVar, 1, 88, 27);
                b(cVar, 2, 114, 27);
                b(cVar, 3, 140, 27);
                b(cVar, 4, mctech.o.i.e, 27);
                Objects.requireNonNull(machineTier);
                addComponent(new C0093f(85, 95, cVar, machineTier::ordinal));
                Objects.requireNonNull(machineTier);
                addComponent(new C0095h(119, 103, cVar, machineTier::ordinal));
                addPlayerInventoryAt(player.getInventory(), 42, 127);
                break;
            case 6:
                b(cVar, 0, 22, 27);
                b(cVar, 1, 45, 27);
                b(cVar, 2, 68, 27);
                b(cVar, 3, 91, 27);
                b(cVar, 4, 114, 27);
                b(cVar, 5, 137, 27);
                b(cVar, 6, 160, 27);
                b(cVar, 7, 183, 27);
                b(cVar, 8, 206, 27);
                Objects.requireNonNull(machineTier);
                addComponent(new C0093f(85, 95, cVar, machineTier::ordinal));
                Objects.requireNonNull(machineTier);
                addComponent(new C0095h(119, 103, cVar, machineTier::ordinal));
                addPlayerInventoryAt(player.getInventory(), 42, 127);
                break;
        }
        if (machineTier.isAtLeast(MachineTier.T3)) {
            List<Integer> listB = cVar.getInventoryManager().b(mctech.m.e.k.c);
            for (int i2 = 0; i2 < listB.size(); i2++) {
                addSlot(new mctech.m.g.z(cVar, listB.get(i2).intValue(), 234, 19 + (i2 * 19)));
            }
        }
        if (machineTier.isAtLeast(MachineTier.T5)) {
            Objects.requireNonNull(cVar);
            addComponent(new C0089b(cVar::d).a(p -> {
                cVar.sendToServer(0, 0);
            }).b((Component) Component.empty().append(MCTechLang.TOOLTIP_AUTO_SORT).append(Component.empty().append(MCTechLang.GUI_YES).withStyle(ChatFormatting.GREEN))).a((Component) Component.empty().append(MCTechLang.TOOLTIP_AUTO_SORT).append(Component.empty().append(MCTechLang.GUI_NO).withStyle(ChatFormatting.RED))));
        }
        Objects.requireNonNull(machineTier);
        addComponent(new C0097j(this, machineTier::ordinal));
        Objects.requireNonNull(machineTier);
        addComponent(new mctech.components.a.H(cVar, machineTier::ordinal).d("gui.mctech.inventory.button"));
        Objects.requireNonNull(machineTier);
        addComponent(new mctech.components.a.u(cVar, machineTier::ordinal).a(EnumSet.of(mctech.components.a.u.a.ENERGY_INPUT, mctech.components.a.u.a.ENERGY_STORAGE, mctech.components.a.u.a.OPERATION_TIME, mctech.components.a.u.a.OPERATION_COST)).b((Component) MCTechLang.TOOLTIP_INFO_BUTTON));
    }

    /* JADX INFO: renamed from: mctech.m.b.H$1, reason: invalid class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/H$1.class */
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

    private void a(mctech.processing.c cVar, int i, int i2, int i3) {
        addSlot(new mctech.m.g.g(cVar, i * 2, i2, i3, new mctech.m.c.m(cVar)));
        addSlot(new mctech.m.g.B(cVar, (i * 2) + 1, i2 + 44, i3));
        addComponent(new mctech.components.a.N(i2 + 22, i3, () -> {
            return Integer.valueOf((int) cVar.getProgressSlot(i));
        }, () -> {
            return Integer.valueOf((int) cVar.getMaxProgressSlot(i));
        }, () -> {
            return cVar.machineTier().ordinal();
        }).a(-90.0f));
        addComponent(new C0096i(i2 + 23, i3, () -> {
            EmiMachineRegistry.displayRecipes("smelting");
        }).a(-90.0f).g(2));
    }

    private void b(mctech.processing.c cVar, int i, int i2, int i3) {
        addSlot(new mctech.m.g.g(cVar, i * 2, i2, i3, new mctech.m.c.m(cVar)));
        addSlot(new mctech.m.g.B(cVar, (i * 2) + 1, i2, i3 + 44));
        addComponent(new mctech.components.a.N(i2 + 1, i3 + 21, () -> {
            return Integer.valueOf((int) cVar.getProgressSlot(i));
        }, () -> {
            return Integer.valueOf((int) cVar.getMaxProgressSlot(i));
        }, () -> {
            return cVar.machineTier().ordinal();
        }));
        addComponent(new C0096i(i2 + 1, i3 + 21, () -> {
            EmiMachineRegistry.displayRecipes("smelting");
        }).g(2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // mctech.components.ContainerComponent
    public ResourceLocation getTexture() {
        return mctech.m.a.a(this, ((mctech.processing.c) getHolder()).machineTier(), "furnace");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // mctech.components.ContainerComponent
    @OnlyIn(Dist.CLIENT)
    public void onGuiLoaded(mctech.m.d.b bVar) {
        bVar.c(1);
        bVar.c(2);
        bVar.e(252);
        switch (AnonymousClass1.a[((mctech.processing.c) getHolder()).machineTier().ordinal()]) {
            case 1:
            case 2:
            case 3:
                bVar.f(192);
                break;
            case 4:
                bVar.f(215);
                break;
            case 5:
            case 6:
                bVar.f(mctech.g.c.a.d.e);
                break;
        }
    }
}
