package mctech.m.b;

import java.util.EnumSet;
import java.util.Objects;
import java.util.function.Supplier;
import mctech.api.tiles.ICustomContainer;
import mctech.components.AbstractC0115i;
import mctech.components.C0120n;
import mctech.components.a.C0092e;
import mctech.components.a.C0093f;
import mctech.components.a.C0095h;
import mctech.components.a.C0096i;
import mctech.components.a.C0097j;
import mctech.components.a.C0099l;
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

/* JADX INFO: renamed from: mctech.m.b.ae, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/ae.class */
public class C0132ae extends AbstractC0115i<mctech.blockentities.c.K> implements ICustomContainer {
    public Vec2i a;

    public C0132ae(mctech.blockentities.c.K k, Player player, int i) {
        super(k, player, i);
        this.a = new Vec2i(238, 193);
        MachineTier machineTier = k.machineTier();
        int i2 = mctech.h.a.c.d.get(machineTier).e;
        switch (AnonymousClass5.a[machineTier.ordinal()]) {
            case 1:
                addSlot(new mctech.m.g.g(k, 0, 48, 43, new mctech.m.c.a.g(k)));
                break;
            case 2:
                addSlot(new mctech.m.g.g(k, 0, 48, 43, new mctech.m.c.a.g(k)));
                addSlot(new mctech.m.g.g(k, 1, 75, 43, new mctech.m.c.a.g(k)));
                break;
            case 3:
                addSlot(new mctech.m.g.g(k, 0, 48, 43, new mctech.m.c.a.g(k)));
                addSlot(new mctech.m.g.g(k, 1, 75, 43, new mctech.m.c.a.g(k)));
                addSlot(new mctech.m.g.g(k, 2, 102, 43, new mctech.m.c.a.g(k)));
                break;
        }
        addSlot(new mctech.m.g.g(k, i2, 172, 30, mctech.m.c.f.a));
        addSlot(new mctech.m.g.g(k, i2 + 1, 172, 76, mctech.m.c.r.c));
        addSlot(new mctech.r.a.e(this, k, i2 + 2, aI.f, 19) { // from class: mctech.m.b.ae.1
            @Override // mctech.r.a.e, mctech.m.a.j
            public int o() {
                return 16;
            }
        });
        addSlot(new mctech.r.a.e(this, k, i2 + 3, aI.f, 38) { // from class: mctech.m.b.ae.2
            @Override // mctech.r.a.e, mctech.m.a.j
            public int o() {
                return 16;
            }
        });
        addSlot(new mctech.r.a.e(this, k, i2 + 4, aI.f, 57) { // from class: mctech.m.b.ae.3
            @Override // mctech.r.a.e, mctech.m.a.j
            public int o() {
                return 16;
            }
        });
        addSlot(new mctech.r.a.e(this, k, i2 + 5, aI.f, 76) { // from class: mctech.m.b.ae.4
            @Override // mctech.r.a.e, mctech.m.a.j
            public int o() {
                return 16;
            }
        });
        addPlayerInventoryWithOffset(player.getInventory(), 27, 27);
        getComponents().clear();
        Objects.requireNonNull(machineTier);
        addComponent(new C0093f(46, 77, k, machineTier::ordinal));
        Objects.requireNonNull(machineTier);
        addComponent(new C0095h(80, 85, k, machineTier::ordinal));
        Objects.requireNonNull(machineTier);
        addComponent(new C0097j(this, machineTier::ordinal));
        Objects.requireNonNull(machineTier);
        addComponent(new mctech.components.a.H(k, machineTier::ordinal).d("gui.mctech.inventory.button"));
        Objects.requireNonNull(machineTier);
        addComponent(new mctech.components.a.u(k, machineTier::ordinal).a(EnumSet.of(mctech.components.a.u.a.ENERGY_INPUT, mctech.components.a.u.a.ENERGY_STORAGE, mctech.components.a.u.a.OPERATION_TIME, mctech.components.a.u.a.OPERATION_COST)).b((Component) MCTechLang.TOOLTIP_INFO_BUTTON));
        Objects.requireNonNull(machineTier);
        addComponent(new C0092e(156, 84, machineTier::ordinal).c(false).b((Component) MCTechLang.TOOLTIP_CLEAR_CONTENT).a(m -> {
            k.b();
        }));
        mctech.fluid.h<?> hVar = k.a;
        Objects.requireNonNull(machineTier);
        addComponent(new C0099l(145, 31, hVar, machineTier::ordinal));
        addComponent(new C0096i(173, 53, () -> {
            EmiMachineRegistry.displayRecipes((mctech.blockentities.c.K) getHolder());
        }).b((Component) MCTechLang.TOOLTIP_SHOW_RECIPES));
        addComponent(new C0120n(new mctech.utils.math.geometry.b(173, 53, 14, 17), k, new Vec2i(C0101n.q.getX() * machineTier.ordinal(), 179), true, true).a(C0101n.a.a()));
    }

    /* JADX INFO: renamed from: mctech.m.b.ae$5, reason: invalid class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/ae$5.class */
    static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] a = new int[MachineTier.values().length];

        static {
            try {
                a[MachineTier.T4.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[MachineTier.T6.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[MachineTier.T8.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // mctech.components.ContainerComponent
    public ResourceLocation getTexture() {
        return mctech.m.a.a(this, ((mctech.blockentities.c.K) getHolder()).machineTier(), (Supplier<String>) () -> {
            return "plasma_generator";
        });
    }

    @Override // mctech.components.ContainerComponent
    @OnlyIn(Dist.CLIENT)
    public void onGuiLoaded(mctech.m.d.b bVar) {
        bVar.c(1);
        bVar.c(2);
        bVar.e(this.a.getX());
        bVar.f(this.a.getY());
    }
}
