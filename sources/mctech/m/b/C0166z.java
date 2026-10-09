package mctech.m.b;

import java.util.EnumSet;
import java.util.List;
import java.util.Objects;
import mctech.api.tiles.ICustomContainer;
import mctech.api.tiles.readers.IProgressMachine;
import mctech.blockentities.c.C0067n;
import mctech.components.AbstractC0115i;
import mctech.components.a.C0093f;
import mctech.components.a.C0096i;
import mctech.components.a.C0097j;
import mctech.components.a.C0101n;
import mctech.init.MCTechLang;
import mctech.integration.emi.plugin.base.EmiMachineRegistry;
import mctech.utils.math.geometry.Vec2i;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: renamed from: mctech.m.b.z, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/z.class */
public class C0166z extends AbstractC0115i<C0067n> implements ICustomContainer {
    public C0166z(C0067n c0067n, Player player, int i) {
        super(c0067n, player, i);
        MachineTier machineTier = c0067n.machineTier();
        switch (AnonymousClass2.a[machineTier.ordinal()]) {
            case 1:
            case 2:
                a(c0067n, 0, 114, 23);
                break;
            case 3:
                a(c0067n, 0, 91, 23);
                a(c0067n, 1, 137, 23);
                break;
            case 4:
                a(c0067n, 0, 91, 23);
                a(c0067n, 1, 114, 23);
                a(c0067n, 2, 137, 23);
                break;
            case 5:
                a(c0067n, 0, 68, 23);
                a(c0067n, 1, 91, 23);
                a(c0067n, 2, 114, 23);
                a(c0067n, 3, 137, 23);
                a(c0067n, 4, 160, 23);
                break;
            case 6:
                a(c0067n, 0, 22, 23);
                a(c0067n, 1, 45, 23);
                a(c0067n, 2, 68, 23);
                a(c0067n, 3, 91, 23);
                a(c0067n, 4, 114, 23);
                a(c0067n, 5, 137, 23);
                a(c0067n, 6, 160, 23);
                a(c0067n, 7, 183, 23);
                a(c0067n, 8, 206, 23);
                break;
        }
        addPlayerInventoryAt(player.getInventory(), 42, mctech.o.i.e);
        List<Integer> listB = c0067n.getInventoryManager().b(mctech.m.e.k.c);
        for (int i2 = 0; i2 < listB.size(); i2++) {
            addSlot(new mctech.m.g.z(c0067n, listB.get(i2).intValue(), 234, 19 + (i2 * 19)));
        }
        Objects.requireNonNull(machineTier);
        addComponent(new C0093f(85, 145, c0067n, machineTier::ordinal));
        Objects.requireNonNull(machineTier);
        addComponent(new C0097j(this, machineTier::ordinal));
        Objects.requireNonNull(machineTier);
        addComponent(new mctech.components.a.H(c0067n, machineTier::ordinal).d("gui.mctech.inventory.button"));
        Objects.requireNonNull(machineTier);
        addComponent(new mctech.components.a.u(c0067n, machineTier::ordinal).a(EnumSet.of(mctech.components.a.u.a.ENERGY_INPUT, mctech.components.a.u.a.ENERGY_STORAGE, mctech.components.a.u.a.OPERATION_TIME, mctech.components.a.u.a.OPERATION_COST)).b((Component) MCTechLang.TOOLTIP_INFO_BUTTON));
    }

    /* JADX INFO: renamed from: mctech.m.b.z$2, reason: invalid class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/z$2.class */
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

    private void a(final C0067n c0067n, final int i, int i2, int i3) {
        int i4 = i * 5;
        addSlot(new mctech.m.g.g(c0067n, i4, i2, i3, new mctech.m.c.m(c0067n)));
        addSlot(new mctech.m.g.g(c0067n, i4 + 1, i2, i3 + 23, new mctech.m.c.m(c0067n)));
        addSlot(new mctech.m.g.g(c0067n, i4 + 2, i2, i3 + 46, new mctech.m.c.m(c0067n)));
        addSlot(new mctech.m.g.g(c0067n, i4 + 3, i2, i3 + 70, new mctech.m.c.a.d(c0067n)));
        addSlot(new mctech.m.g.g(c0067n, i4 + 4, i2, i3 + 102, mctech.m.c.r.c));
        addComponent(new mctech.components.b.o(i2 - 3, i3 + 65, 22, 34, new IProgressMachine(this) { // from class: mctech.m.b.z.1
            @Override // mctech.api.tiles.readers.IProgressMachine
            public float getProgress() {
                return c0067n.getProgressSlot(i);
            }

            @Override // mctech.api.tiles.readers.IProgressMachine
            public float getMaxProgress() {
                return c0067n.getMaxProgressSlot(i);
            }
        }, 173, 30, true).a(false).c(true).a(C0101n.a.a()));
        addComponent(new C0096i(C0101n.a, i2 + 3, i3 + 89, 10, 10, C0101n.a.v, C0101n.a.v, () -> {
            return c0067n.machineTier().ordinal();
        }, () -> {
            EmiMachineRegistry.displayRecipes((C0067n) getHolder());
        }).b(new Vec2i(163, 30)).d("gui.mctech.wiki.show.craft").a(m -> {
            EmiMachineRegistry.displayRecipes(c0067n);
        }).b((Component) MCTechLang.TOOLTIP_SHOW_RECIPES).g(2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // mctech.components.ContainerComponent
    public ResourceLocation getTexture() {
        return mctech.m.a.a(this, ((C0067n) getHolder()).machineTier(), "electronic_plant");
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
