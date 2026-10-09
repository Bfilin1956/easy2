package mctech.m.b;

import java.util.EnumSet;
import java.util.List;
import java.util.Objects;
import mctech.api.tiles.ICustomContainer;
import mctech.api.tiles.readers.IProgressMachine;
import mctech.components.AbstractC0115i;
import mctech.components.a.C0093f;
import mctech.components.a.C0095h;
import mctech.components.a.C0097j;
import mctech.components.a.C0099l;
import mctech.init.MCTechItems;
import mctech.init.MCTechLang;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/U.class */
public class U extends AbstractC0115i<mctech.blockentities.c.B> implements ICustomContainer {
    public U(final mctech.blockentities.c.B b, Player player, int i) {
        super(b, player, i);
        MachineTier machineTier = b.machineTier();
        switch (AnonymousClass2.a[machineTier.ordinal()]) {
            case 1:
                addSlot(new mctech.m.g.g(b, 0, 78, 43, new mctech.m.c.m(b)));
                addSlot(mctech.m.g.g.d(b, 1, 132, 43));
                break;
            case 2:
            case 3:
                addSlot(new mctech.m.g.g(b, 0, 78, 31, new mctech.m.c.m(b)));
                addSlot(new mctech.m.g.g(b, 1, 78, 55, itemStack -> {
                    return itemStack.is(MCTechItems.SCRAPBOX);
                }));
                addSlot(mctech.m.g.g.d(b, 2, 132, 43));
                break;
        }
        addPlayerInventoryAt(player.getInventory(), 35, 111);
        List<Integer> listB = b.getInventoryManager().b(mctech.m.e.k.c);
        for (int i2 = 0; i2 < listB.size(); i2++) {
            addSlot(new mctech.m.g.z(b, listB.get(i2).intValue(), aI.f, 20 + (i2 * 19)));
        }
        getComponents().clear();
        if (machineTier.isAtLeast(MachineTier.T6)) {
            addComponent(new mctech.components.b.o(75, 52, 22, 22, new IProgressMachine(this) { // from class: mctech.m.b.U.1
                @Override // mctech.api.tiles.readers.IProgressMachine
                public float getProgress() {
                    return b.a();
                }

                @Override // mctech.api.tiles.readers.IProgressMachine
                public float getMaxProgress() {
                    return b.b();
                }
            }, 0, 234).b(() -> {
                return "";
            }));
        }
        if (machineTier == MachineTier.T7) {
            mctech.fluid.h<?> hVar = b.a;
            Objects.requireNonNull(machineTier);
            addComponent(new C0099l(b, 183, 29, 0, hVar, machineTier::ordinal).a().a(true));
        }
        Objects.requireNonNull(machineTier);
        addComponent(new C0093f(76, 83, b, machineTier::ordinal));
        Objects.requireNonNull(machineTier);
        addComponent(new C0095h(110, 91, b, machineTier::ordinal));
        Objects.requireNonNull(machineTier);
        addComponent(new C0097j(this, machineTier::ordinal));
        Objects.requireNonNull(machineTier);
        addComponent(new mctech.components.a.H(b, machineTier::ordinal).d("gui.mctech.inventory.button"));
        Objects.requireNonNull(machineTier);
        addComponent(new mctech.components.a.u(b, machineTier::ordinal).a(EnumSet.of(mctech.components.a.u.a.ENERGY_INPUT, mctech.components.a.u.a.ENERGY_STORAGE)).b((Component) MCTechLang.TOOLTIP_INFO_BUTTON));
    }

    /* JADX INFO: renamed from: mctech.m.b.U$2, reason: invalid class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/U$2.class */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] a = new int[MachineTier.values().length];

        static {
            try {
                a[MachineTier.T5.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[MachineTier.T6.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[MachineTier.T7.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // mctech.components.ContainerComponent
    public ResourceLocation getTexture() {
        return mctech.m.a.a(this, ((mctech.blockentities.c.B) getHolder()).machineTier(), "mass_fabricator");
    }

    @Override // mctech.components.ContainerComponent
    @OnlyIn(Dist.CLIENT)
    public void onGuiLoaded(mctech.m.d.b bVar) {
        bVar.c(1);
        bVar.c(2);
        bVar.e(246);
        bVar.f(192);
    }
}
