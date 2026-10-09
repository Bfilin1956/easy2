package mctech.m.b;

import java.util.EnumSet;
import java.util.Objects;
import java.util.function.Supplier;
import mctech.api.tiles.ICustomContainer;
import mctech.blockentities.c.C0061h;
import mctech.components.AbstractC0115i;
import mctech.components.a.C0093f;
import mctech.components.a.C0095h;
import mctech.components.a.C0097j;
import mctech.components.a.C0099l;
import mctech.init.MCTechLang;
import mctech.utils.math.geometry.Vec2i;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: renamed from: mctech.m.b.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/p.class */
public class C0156p extends AbstractC0115i<C0061h> implements ICustomContainer {
    public Vec2i a;

    public C0156p(C0061h c0061h, Player player, int i) {
        int[] iArr;
        super(c0061h, player, i);
        this.a = new Vec2i(238, 186);
        MachineTier machineTier = c0061h.machineTier();
        int i2 = mctech.h.a.c.c.get(machineTier).k;
        at atVar = new at(this, new mctech.utils.math.geometry.b(61, 24, 108, 36), i2, 0);
        at atVar2 = new at(this, new mctech.utils.math.geometry.b(aI.f, 15, 16, 73), c0061h.upgradeSlots, i2);
        switch (AnonymousClass2.a[machineTier.ordinal()]) {
            case 1:
                iArr = new int[]{0, 1};
                break;
            case 2:
                iArr = new int[]{0, 4};
                break;
            case 3:
                iArr = new int[]{6, 2};
                break;
            case 4:
                iArr = new int[]{6, 6};
                break;
            default:
                iArr = new int[0];
                break;
        }
        atVar.a(iArr, (i3, i4, i5) -> {
            return mctech.m.g.g.d((mctech.m.a.g) this.gui, i3, i4, i5);
        });
        switch (AnonymousClass2.a[machineTier.ordinal()]) {
            case 2:
            case 3:
            case 4:
                atVar2.a(new int[]{1, 1, 1, 1}, 3, (i6, i7, i8) -> {
                    return new mctech.r.a.e(this, (C0061h) this.gui, i6, i7, i8) { // from class: mctech.m.b.p.1
                        @Override // mctech.r.a.e, mctech.m.a.j
                        public int o() {
                            return 16;
                        }
                    };
                });
                break;
        }
        addPlayerInventoryWithOffset(player.getInventory(), 27, 20);
        getComponents().clear();
        mctech.fluid.h<?> hVar = c0061h.a;
        Objects.requireNonNull(machineTier);
        addComponent(new C0099l(c0061h, 30, 25, 0, hVar, machineTier::ordinal).a((Component) MCTechLang.GUI_FLUID_WATER));
        mctech.fluid.h<?> hVar2 = c0061h.b;
        Objects.requireNonNull(machineTier);
        addComponent(new C0099l(c0061h, 182, 25, 1, hVar2, machineTier::ordinal).a((Component) MCTechLang.GUI_FLUID_LAVA));
        Objects.requireNonNull(machineTier);
        addComponent(new C0093f(78, 77, c0061h, machineTier::ordinal));
        Objects.requireNonNull(machineTier);
        addComponent(new C0095h(112, 85, c0061h, machineTier::ordinal));
        Objects.requireNonNull(machineTier);
        addComponent(new C0097j(this, machineTier::ordinal));
        Objects.requireNonNull(machineTier);
        addComponent(new mctech.components.a.H(c0061h, machineTier::ordinal).d("gui.mctech.inventory.button"));
        Objects.requireNonNull(machineTier);
        addComponent(new mctech.components.a.u(c0061h, machineTier::ordinal).a(EnumSet.of(mctech.components.a.u.a.ENERGY_INPUT, mctech.components.a.u.a.ENERGY_STORAGE, mctech.components.a.u.a.OPERATION_TIME, mctech.components.a.u.a.OPERATION_COST)).b((Component) MCTechLang.TOOLTIP_INFO_BUTTON));
    }

    /* JADX INFO: renamed from: mctech.m.b.p$2, reason: invalid class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/p$2.class */
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
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // mctech.components.ContainerComponent
    public ResourceLocation getTexture() {
        return mctech.m.a.a(this, ((C0061h) getHolder()).machineTier(), (Supplier<String>) () -> {
            return "cobblestone_generator";
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
