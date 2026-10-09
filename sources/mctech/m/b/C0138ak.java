package mctech.m.b;

import java.util.EnumSet;
import java.util.List;
import java.util.Objects;
import mctech.api.tiles.ICustomContainer;
import mctech.api.tiles.readers.IProgressMachine;
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

/* JADX INFO: renamed from: mctech.m.b.ak, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/ak.class */
public class C0138ak extends AbstractC0115i<mctech.blockentities.c.P> implements ICustomContainer {
    public C0138ak(mctech.blockentities.c.P p, Player player, int i) {
        super(p, player, i);
        MachineTier machineTier = p.machineTier();
        switch (AnonymousClass2.a[machineTier.ordinal()]) {
            case 1:
            case 2:
                a(p, 0, 114, 32);
                break;
            case 3:
                a(p, 0, 91, 32);
                a(p, 1, 137, 32);
                break;
            case 4:
                a(p, 0, 91, 32);
                a(p, 1, 114, 32);
                a(p, 2, 137, 32);
                break;
            case 5:
                a(p, 0, 68, 32);
                a(p, 1, 91, 32);
                a(p, 2, 114, 32);
                a(p, 3, 137, 32);
                a(p, 4, 160, 32);
                break;
            case 6:
                a(p, 0, 22, 32);
                a(p, 1, 45, 32);
                a(p, 2, 68, 32);
                a(p, 3, 91, 32);
                a(p, 4, 114, 32);
                a(p, 5, 137, 32);
                a(p, 6, 160, 32);
                a(p, 7, 183, 32);
                a(p, 8, 206, 32);
                break;
        }
        addPlayerInventoryAt(player.getInventory(), 42, 129);
        List<Integer> listB = p.getInventoryManager().b(mctech.m.e.k.c);
        for (int i2 = 0; i2 < listB.size(); i2++) {
            addSlot(new mctech.m.g.z(p, listB.get(i2).intValue(), 234, 19 + (i2 * 19)));
        }
        if (machineTier.isAtLeast(MachineTier.T4)) {
            Objects.requireNonNull(p);
            addComponent(new C0089b(p::b).a(p2 -> {
                p.a();
            }).b((Component) Component.empty().append(MCTechLang.TOOLTIP_AUTO_SORT).append(Component.empty().append(MCTechLang.GUI_YES).withStyle(ChatFormatting.GREEN))).a((Component) Component.empty().append(MCTechLang.TOOLTIP_AUTO_SORT).append(Component.empty().append(MCTechLang.GUI_NO).withStyle(ChatFormatting.RED))));
        }
        Objects.requireNonNull(machineTier);
        addComponent(new C0093f(85, 98, p, machineTier::ordinal));
        Objects.requireNonNull(machineTier);
        addComponent(new C0095h(119, 106, p, machineTier::ordinal));
        Objects.requireNonNull(machineTier);
        addComponent(new C0097j(this, machineTier::ordinal));
        Objects.requireNonNull(machineTier);
        addComponent(new mctech.components.a.H(p, machineTier::ordinal).d("gui.mctech.inventory.button"));
        Objects.requireNonNull(machineTier);
        addComponent(new mctech.components.a.u(p, machineTier::ordinal).a(EnumSet.of(mctech.components.a.u.a.ENERGY_INPUT, mctech.components.a.u.a.ENERGY_STORAGE, mctech.components.a.u.a.OPERATION_TIME, mctech.components.a.u.a.OPERATION_COST)).b((Component) MCTechLang.TOOLTIP_INFO_BUTTON));
    }

    /* JADX INFO: renamed from: mctech.m.b.ak$2, reason: invalid class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/ak$2.class */
    static /* synthetic */ class AnonymousClass2 {
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

    private void a(final mctech.blockentities.c.P p, final int i, int i2, int i3) {
        addSlot(new mctech.m.g.g(p, i * 2, i2, i3, new mctech.m.c.m(p)));
        addSlot(new mctech.m.g.g(p, (i * 2) + 1, i2, i3 + 42, mctech.m.c.r.c));
        addComponent(new mctech.components.b.o(i2 - 3, i3 - 3, 22, 41, new IProgressMachine(this) { // from class: mctech.m.b.ak.1
            @Override // mctech.api.tiles.readers.IProgressMachine
            public float getProgress() {
                return p.getProgressSlot(i);
            }

            @Override // mctech.api.tiles.readers.IProgressMachine
            public float getMaxProgress() {
                return p.getMaxProgressSlot(i);
            }
        }, 195, 32, true, true).a(C0101n.a.a()));
        addComponent(new C0096i(i2 + 1, i3 + 21, () -> {
            EmiMachineRegistry.displayRecipes((mctech.blockentities.c.P) getHolder());
        }).b((Component) MCTechLang.TOOLTIP_SHOW_RECIPES));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // mctech.components.ContainerComponent
    public ResourceLocation getTexture() {
        return mctech.m.a.a(this, ((mctech.blockentities.c.P) getHolder()).machineTier(), "rare_extractor");
    }

    @Override // mctech.components.ContainerComponent
    @OnlyIn(Dist.CLIENT)
    public void onGuiLoaded(mctech.m.d.b bVar) {
        bVar.c(1);
        bVar.c(2);
        bVar.e(255);
        bVar.f(211);
    }
}
