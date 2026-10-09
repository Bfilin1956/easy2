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
import mctech.utils.math.geometry.Vec2i;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: renamed from: mctech.m.b.q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/q.class */
public class C0157q extends AbstractC0115i<mctech.processing.a> implements ICustomContainer {
    public C0157q(mctech.processing.a aVar, Player player, int i) {
        super(aVar, player, i);
        MachineTier machineTier = aVar.machineTier();
        switch (AnonymousClass3.a[machineTier.ordinal()]) {
            case 1:
            case 2:
                a(aVar, 0, 92, 40);
                Objects.requireNonNull(machineTier);
                addComponent(new C0093f(85, 78, aVar, machineTier::ordinal));
                Objects.requireNonNull(machineTier);
                addComponent(new C0095h(119, 86, aVar, machineTier::ordinal));
                addPlayerInventoryAt(player.getInventory(), 42, 110);
                break;
            case 3:
                a(aVar, 0, 92, 27);
                a(aVar, 1, 92, 53);
                Objects.requireNonNull(machineTier);
                addComponent(new C0093f(85, 78, aVar, machineTier::ordinal));
                Objects.requireNonNull(machineTier);
                addComponent(new C0095h(119, 86, aVar, machineTier::ordinal));
                addPlayerInventoryAt(player.getInventory(), 42, 110);
                break;
            case 4:
                a(aVar, 0, 92, 27);
                a(aVar, 1, 92, 53);
                a(aVar, 2, 92, 79);
                Objects.requireNonNull(machineTier);
                addComponent(new C0093f(85, 103, aVar, machineTier::ordinal));
                Objects.requireNonNull(machineTier);
                addComponent(new C0095h(119, 111, aVar, machineTier::ordinal));
                addPlayerInventoryAt(player.getInventory(), 42, 135);
                break;
            case 5:
                b(aVar, 0, 62, 27);
                b(aVar, 1, 88, 27);
                b(aVar, 2, 114, 27);
                b(aVar, 3, 140, 27);
                b(aVar, 4, mctech.o.i.e, 27);
                Objects.requireNonNull(machineTier);
                addComponent(new C0093f(85, 95, aVar, machineTier::ordinal));
                Objects.requireNonNull(machineTier);
                addComponent(new C0095h(119, 103, aVar, machineTier::ordinal));
                addPlayerInventoryAt(player.getInventory(), 42, 127);
                break;
            case 6:
                b(aVar, 0, 22, 27);
                b(aVar, 1, 45, 27);
                b(aVar, 2, 68, 27);
                b(aVar, 3, 91, 27);
                b(aVar, 4, 114, 27);
                b(aVar, 5, 137, 27);
                b(aVar, 6, 160, 27);
                b(aVar, 7, 183, 27);
                b(aVar, 8, 206, 27);
                Objects.requireNonNull(machineTier);
                addComponent(new C0093f(85, 95, aVar, machineTier::ordinal));
                Objects.requireNonNull(machineTier);
                addComponent(new C0095h(119, 103, aVar, machineTier::ordinal));
                addPlayerInventoryAt(player.getInventory(), 42, 127);
                break;
        }
        if (machineTier.isAtLeast(MachineTier.T3)) {
            List<Integer> listB = aVar.getInventoryManager().b(mctech.m.e.k.c);
            for (int i2 = 0; i2 < listB.size(); i2++) {
                addSlot(new mctech.m.g.z(aVar, listB.get(i2).intValue(), 234, 19 + (i2 * 19)));
            }
        }
        if (machineTier.isAtLeast(MachineTier.T5)) {
            Objects.requireNonNull(aVar);
            addComponent(new C0089b(aVar::d).a(p -> {
                aVar.sendToServer(0, 0);
            }).b((Component) Component.empty().append(MCTechLang.TOOLTIP_AUTO_SORT).append(Component.empty().append(MCTechLang.GUI_YES).withStyle(ChatFormatting.GREEN))).a((Component) Component.empty().append(MCTechLang.TOOLTIP_AUTO_SORT).append(Component.empty().append(MCTechLang.GUI_NO).withStyle(ChatFormatting.RED))));
        }
        Objects.requireNonNull(machineTier);
        addComponent(new C0097j(this, machineTier::ordinal));
        Objects.requireNonNull(machineTier);
        addComponent(new mctech.components.a.H(aVar, machineTier::ordinal).d("gui.mctech.inventory.button"));
        Objects.requireNonNull(machineTier);
        addComponent(new mctech.components.a.u(aVar, machineTier::ordinal).a(EnumSet.of(mctech.components.a.u.a.ENERGY_INPUT, mctech.components.a.u.a.ENERGY_STORAGE, mctech.components.a.u.a.OPERATION_TIME, mctech.components.a.u.a.OPERATION_COST)).b((Component) MCTechLang.TOOLTIP_INFO_BUTTON));
    }

    /* JADX INFO: renamed from: mctech.m.b.q$3, reason: invalid class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/q$3.class */
    static /* synthetic */ class AnonymousClass3 {
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

    private void a(final mctech.processing.a aVar, final int i, int i2, int i3) {
        addSlot(new mctech.m.g.g(aVar, i * 2, i2, i3, new mctech.m.c.m(aVar)));
        addSlot(new mctech.m.g.B(aVar, (i * 2) + 1, i2 + 44, i3));
        addComponent(new mctech.components.b.o(i2 + 21, i3 + 1, 18, 14, new IProgressMachine(this) { // from class: mctech.m.b.q.1
            @Override // mctech.api.tiles.readers.IProgressMachine
            public float getProgress() {
                return aVar.getProgressSlot(i);
            }

            @Override // mctech.api.tiles.readers.IProgressMachine
            public float getMaxProgress() {
                return aVar.getMaxProgressSlot(i);
            }
        }, aVar.machineTier().ordinal() * 18, 0).a(C0101n.i.a()).b(false));
        addComponent(new C0096i(C0101n.i, i2 + 21, i3 + 1, 18, 14, () -> {
            EmiMachineRegistry.displayRecipes((mctech.processing.a) getHolder());
        }).b(new Vec2i(198, 0)).g(2));
    }

    private void b(final mctech.processing.a aVar, final int i, int i2, int i3) {
        addSlot(new mctech.m.g.g(aVar, i * 2, i2, i3, new mctech.m.c.m(aVar)));
        addSlot(new mctech.m.g.B(aVar, (i * 2) + 1, i2, i3 + 44));
        addComponent(new mctech.components.b.o(i2 - 1, i3 + 23, 18, 14, new IProgressMachine(this) { // from class: mctech.m.b.q.2
            @Override // mctech.api.tiles.readers.IProgressMachine
            public float getProgress() {
                return aVar.getProgressSlot(i);
            }

            @Override // mctech.api.tiles.readers.IProgressMachine
            public float getMaxProgress() {
                return aVar.getMaxProgressSlot(i);
            }
        }, aVar.machineTier().ordinal() * 18, 0).a(C0101n.i.a()).b(false).c(90));
        addComponent(new C0096i(C0101n.i, i2 - 1, i3 + 23, 18, 14, () -> {
            EmiMachineRegistry.displayRecipes((mctech.processing.a) getHolder());
        }).b(new Vec2i(198, 0)).a(90.0f).g(2));
    }

    private void a(int i, int i2) {
        addComponent(new C0096i(i + 2, i2 - 2, () -> {
            EmiMachineRegistry.displayRecipes((mctech.processing.a) getHolder());
        }).b((Component) MCTechLang.TOOLTIP_SHOW_RECIPES).a(-90.0f));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // mctech.components.ContainerComponent
    public ResourceLocation getTexture() {
        return mctech.m.a.a(this, ((mctech.processing.a) getHolder()).machineTier(), "compressor");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // mctech.components.ContainerComponent
    @OnlyIn(Dist.CLIENT)
    public void onGuiLoaded(mctech.m.d.b bVar) {
        bVar.c(1);
        bVar.c(2);
        bVar.e(252);
        switch (AnonymousClass3.a[((mctech.processing.a) getHolder()).machineTier().ordinal()]) {
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
