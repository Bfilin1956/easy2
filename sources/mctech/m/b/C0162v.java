package mctech.m.b;

import java.util.EnumSet;
import java.util.List;
import java.util.Objects;
import mctech.api.tiles.ICustomContainer;
import mctech.blockentities.c.C0063j;
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

/* JADX INFO: renamed from: mctech.m.b.v, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/v.class */
public class C0162v extends AbstractC0115i<C0063j> implements ICustomContainer {
    public C0162v(C0063j c0063j, Player player, int i) {
        super(c0063j, player, i);
        MachineTier machineTier = c0063j.machineTier();
        switch (AnonymousClass1.a[machineTier.ordinal()]) {
            case 1:
            case 2:
                a(c0063j, 0, 114, 32);
                break;
            case 3:
                a(c0063j, 0, 91, 32);
                a(c0063j, 1, 137, 32);
                break;
            case 4:
                a(c0063j, 0, 91, 32);
                a(c0063j, 1, 114, 32);
                a(c0063j, 2, 137, 32);
                break;
            case 5:
                a(c0063j, 0, 68, 32);
                a(c0063j, 1, 91, 32);
                a(c0063j, 2, 114, 32);
                a(c0063j, 3, 137, 32);
                a(c0063j, 4, 160, 32);
                break;
            case 6:
                a(c0063j, 0, 22, 32);
                a(c0063j, 1, 45, 32);
                a(c0063j, 2, 68, 32);
                a(c0063j, 3, 91, 32);
                a(c0063j, 4, 114, 32);
                a(c0063j, 5, 137, 32);
                a(c0063j, 6, 160, 32);
                a(c0063j, 7, 183, 32);
                a(c0063j, 8, 206, 32);
                break;
        }
        addPlayerInventoryAt(player.getInventory(), 42, mctech.o.i.e);
        List<Integer> listB = c0063j.getInventoryManager().b(mctech.m.e.k.c);
        for (int i2 = 0; i2 < listB.size(); i2++) {
            addSlot(new mctech.m.g.z(c0063j, listB.get(i2).intValue(), 234, 19 + (i2 * 19)));
        }
        if (machineTier.isAtLeast(MachineTier.T4)) {
            Objects.requireNonNull(c0063j);
            addComponent(new C0089b(c0063j::a).a(p -> {
                c0063j.b();
            }).b((Component) Component.empty().append(MCTechLang.TOOLTIP_AUTO_SORT).append(Component.empty().append(MCTechLang.GUI_YES).withStyle(ChatFormatting.GREEN))).a((Component) Component.empty().append(MCTechLang.TOOLTIP_AUTO_SORT).append(Component.empty().append(MCTechLang.GUI_NO).withStyle(ChatFormatting.RED))));
        }
        Objects.requireNonNull(machineTier);
        addComponent(new C0093f(85, 135, c0063j, machineTier::ordinal));
        Objects.requireNonNull(machineTier);
        addComponent(new C0095h(119, 143, c0063j, machineTier::ordinal));
        Objects.requireNonNull(machineTier);
        addComponent(new C0097j(this, machineTier::ordinal));
        Objects.requireNonNull(machineTier);
        addComponent(new mctech.components.a.H(c0063j, machineTier::ordinal).d("gui.mctech.inventory.button"));
        Objects.requireNonNull(machineTier);
        addComponent(new mctech.components.a.u(c0063j, machineTier::ordinal).a(EnumSet.of(mctech.components.a.u.a.ENERGY_INPUT, mctech.components.a.u.a.ENERGY_STORAGE, mctech.components.a.u.a.OPERATION_TIME, mctech.components.a.u.a.OPERATION_COST)).b((Component) MCTechLang.TOOLTIP_INFO_BUTTON));
    }

    /* JADX INFO: renamed from: mctech.m.b.v$1, reason: invalid class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/v$1.class */
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

    private void a(C0063j c0063j, int i, int i2, int i3) {
        addSlot(new mctech.m.g.g(c0063j, i * 3, i2, i3, new mctech.m.c.m(c0063j)));
        addSlot(new mctech.m.g.g(c0063j, (i * 3) + 1, i2, i3 + 37, new mctech.m.c.a.b(c0063j)));
        addSlot(new mctech.m.g.g(c0063j, (i * 3) + 2, i2, i3 + 79, mctech.m.c.r.c));
        addComponent(new mctech.components.b.o(i2 - 3, i3 + 21, 22, 54, c0063j, 217, 19).b(true).c(true).a(i).a(C0101n.a.a()));
        addComponent(new C0096i(i2 + 1, i3 + 58, () -> {
            EmiMachineRegistry.displayRecipes((C0063j) getHolder());
        }).b((Component) MCTechLang.TOOLTIP_SHOW_RECIPES));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // mctech.components.ContainerComponent
    public ResourceLocation getTexture() {
        return mctech.m.a.a(this, ((C0063j) getHolder()).machineTier(), "crystal_synth");
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
