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
import mctech.components.a.C0101n;
import mctech.init.MCTechLang;
import mctech.integration.emi.plugin.base.EmiMachineRegistry;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/W.class */
public class W extends AbstractC0115i<mctech.blockentities.c.D> implements ICustomContainer {
    public W(mctech.blockentities.c.D d, Player player, int i) {
        super(d, player, i);
        MachineTier machineTier = d.machineTier();
        switch (AnonymousClass1.a[machineTier.ordinal()]) {
            case 1:
            case 2:
                a(d, 0, 114, 32);
                break;
            case 3:
                a(d, 0, 91, 32);
                a(d, 1, 137, 32);
                break;
            case 4:
                a(d, 0, 91, 32);
                a(d, 1, 114, 32);
                a(d, 2, 137, 32);
                break;
            case 5:
                a(d, 0, 68, 32);
                a(d, 1, 91, 32);
                a(d, 2, 114, 32);
                a(d, 3, 137, 32);
                a(d, 4, 160, 32);
                break;
            case 6:
                a(d, 0, 22, 32);
                a(d, 1, 45, 32);
                a(d, 2, 68, 32);
                a(d, 3, 91, 32);
                a(d, 4, 114, 32);
                a(d, 5, 137, 32);
                a(d, 6, 160, 32);
                a(d, 7, 183, 32);
                a(d, 8, 206, 32);
                break;
        }
        addPlayerInventoryAt(player.getInventory(), 42, mctech.o.i.e);
        List<Integer> listB = d.getInventoryManager().b(mctech.m.e.k.c);
        for (int i2 = 0; i2 < listB.size(); i2++) {
            addSlot(new mctech.m.g.z(d, listB.get(i2).intValue(), 234, 19 + (i2 * 19)));
        }
        if (machineTier.isAtLeast(MachineTier.T4)) {
            Objects.requireNonNull(d);
            addComponent(new C0089b(d::a).a(p -> {
                d.b();
            }).b((Component) Component.empty().append(MCTechLang.TOOLTIP_AUTO_SORT).append(Component.empty().append(MCTechLang.GUI_YES).withStyle(ChatFormatting.GREEN))).a((Component) Component.empty().append(MCTechLang.TOOLTIP_AUTO_SORT).append(Component.empty().append(MCTechLang.GUI_NO).withStyle(ChatFormatting.RED))));
        }
        Objects.requireNonNull(machineTier);
        addComponent(new C0093f(85, 135, d, machineTier::ordinal));
        Objects.requireNonNull(machineTier);
        addComponent(new C0095h(119, 143, d, machineTier::ordinal));
        Objects.requireNonNull(machineTier);
        addComponent(new C0097j(this, machineTier::ordinal));
        Objects.requireNonNull(machineTier);
        addComponent(new mctech.components.a.H(d, machineTier::ordinal).d("gui.mctech.inventory.button"));
        Objects.requireNonNull(machineTier);
        addComponent(new mctech.components.a.u(d, machineTier::ordinal).a(EnumSet.of(mctech.components.a.u.a.ENERGY_INPUT, mctech.components.a.u.a.ENERGY_STORAGE, mctech.components.a.u.a.OPERATION_TIME, mctech.components.a.u.a.OPERATION_COST)).b((Component) MCTechLang.TOOLTIP_INFO_BUTTON));
    }

    /* JADX INFO: renamed from: mctech.m.b.W$1, reason: invalid class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/W$1.class */
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

    private void a(mctech.blockentities.c.D d, int i, int i2, int i3) {
        addSlot(new mctech.m.g.g(d, i * 3, i2, i3, new mctech.m.c.m(d)));
        addSlot(new mctech.m.g.g(d, (i * 3) + 1, i2, i3 + 37, new mctech.m.c.a.h(d)));
        addSlot(new mctech.m.g.g(d, (i * 3) + 2, i2, i3 + 79, mctech.m.c.r.c));
        addComponent(new mctech.components.b.o(i2 - 3, i3 + 21, 22, 54, d, 217, 19).b(true).c(true).a(i).a(C0101n.a.a()));
        addComponent(new C0096i(i2 + 1, i3 + 58, () -> {
            EmiMachineRegistry.displayRecipes((mctech.blockentities.c.D) getHolder());
        }).b((Component) MCTechLang.TOOLTIP_SHOW_RECIPES));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // mctech.components.ContainerComponent
    public ResourceLocation getTexture() {
        return mctech.m.a.a(this, ((mctech.blockentities.c.D) getHolder()).machineTier(), "metal_former");
    }

    @Override // mctech.components.ContainerComponent
    @OnlyIn(Dist.CLIENT)
    public void onGuiLoaded(mctech.m.d.b bVar) {
        bVar.c(1);
        bVar.c(2);
        bVar.e(255);
        bVar.f(255);
    }
}
