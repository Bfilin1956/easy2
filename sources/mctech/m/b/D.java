package mctech.m.b;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;
import java.util.function.Supplier;
import mctech.MCTech;
import mctech.api.tiles.ICustomContainer;
import mctech.blockentities.c.C0069p;
import mctech.components.AbstractC0115i;
import mctech.components.C0122p;
import mctech.components.a.C0089b;
import mctech.components.a.C0095h;
import mctech.components.a.C0097j;
import mctech.components.a.C0099l;
import mctech.init.MCTechLang;
import mctech.utils.math.geometry.Vec2i;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.common.Tags;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/D.class */
public class D extends AbstractC0115i<C0069p> implements ICustomContainer {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public Vec2i d;
    private mctech.utils.math.geometry.b e;
    private mctech.utils.math.geometry.b f;
    private mctech.utils.math.geometry.b g;
    private final mctech.components.a.u<C0069p> h;

    public D(C0069p c0069p, Player player, int i) {
        super(c0069p, player, i);
        MachineTier machineTier = c0069p.machineTier();
        mctech.i.c cVarG = c0069p.g();
        this.d = new Vec2i(238, 186);
        Objects.requireNonNull(machineTier);
        this.h = (mctech.components.a.u) new mctech.components.a.u(c0069p, machineTier::ordinal).a(EnumSet.of(mctech.components.a.u.a.ENERGY_INPUT, mctech.components.a.u.a.ENERGY_STORAGE, mctech.components.a.u.a.OPERATION_TIME, mctech.components.a.u.a.OPERATION_COST)).b((Component) MCTechLang.TOOLTIP_INFO_BUTTON);
        switch (c0069p.g()) {
            case WATER:
                this.e = new mctech.utils.math.geometry.b(79, 73, 73, 6);
                this.f = new mctech.utils.math.geometry.b(114, 81, 5, 7);
                this.g = new mctech.utils.math.geometry.b(46, 27, 19, 60);
                break;
            case LAVA:
                this.e = new mctech.utils.math.geometry.b(117, 75, 73, 6);
                this.f = new mctech.utils.math.geometry.b(152, 83, 5, 7);
                this.g = new mctech.utils.math.geometry.b(92, 27, 19, 60);
                break;
        }
        a(c0069p.getInventoryHandler(), cVarG, machineTier);
        addPlayerInventoryWithOffset(player.getInventory(), 27, 20);
        getComponents().clear();
        addComponent(new C0099l(this.g.a(), this.g.b(), c0069p.a, () -> {
            return c0069p.machineTier().ordinal();
        }));
        addComponent(new mctech.components.b.c(this.e, c0069p, new Vec2i(32, 250), false));
        addComponent(new C0095h(this.f.a(), this.f.b(), c0069p, () -> {
            return c0069p.machineTier().ordinal();
        }));
        Objects.requireNonNull(machineTier);
        addComponent(new C0097j(this, machineTier::ordinal));
        Objects.requireNonNull(machineTier);
        addComponent(new mctech.components.a.H(c0069p, machineTier::ordinal).d("gui.mctech.inventory.button"));
        addComponent(new C0122p(MCTech.loc(String.format("textures/gui/components/gui_%s_error_notification.png", cVarG.c)), new mctech.utils.math.geometry.b(0, -16, this.d.getX(), 0), new Vec2i(176, 92), Vec2i.ZERO, () -> {
            return Boolean.valueOf((cVarG != mctech.i.c.WATER || c0069p.c() || this.h.b()) ? false : true);
        }));
        addComponent(this.h);
        if (c0069p.a(true).length > 1) {
            Objects.requireNonNull(c0069p);
            addComponent(new C0089b(c0069p::b).a(p -> {
                c0069p.a();
            }).b((Component) Component.empty().append(MCTechLang.TOOLTIP_AUTO_SORT).append(Component.empty().append(MCTechLang.GUI_YES).withStyle(ChatFormatting.GREEN))).a((Component) Component.empty().append(MCTechLang.TOOLTIP_AUTO_SORT).append(Component.empty().append(MCTechLang.GUI_NO).withStyle(ChatFormatting.RED))));
        }
    }

    private void a(Vec2i vec2i, mctech.m.c.g gVar, int i) {
        addSlot(new mctech.m.g.g((mctech.m.a.g) this.gui, i, vec2i.getX(), vec2i.getY(), gVar));
    }

    private void a(Vec2i vec2i, int i) {
        addSlot(new mctech.r.a.e(this, (C0069p) this.gui, i, vec2i.getX(), vec2i.getY()) { // from class: mctech.m.b.D.1
            @Override // mctech.r.a.e, mctech.m.a.j
            public int o() {
                return 16;
            }
        });
    }

    private void a(@NotNull mctech.m.e.i iVar, @NotNull mctech.i.c cVar, @NotNull MachineTier machineTier) {
        int i;
        int i2;
        Vec2i vec2i;
        switch (cVar) {
            case WATER:
                a(new Vec2i(168, 27), mctech.m.c.f.a, 0);
                a(new Vec2i(168, 71), mctech.m.c.r.c, 1);
                for (int i3 = 0; i3 < ((C0069p) this.gui).upgradeSlots; i3++) {
                    a(new Vec2i(aI.f, 16 + (i3 * 19)), (machineTier == MachineTier.T1 ? 3 : 2) + i3);
                }
                break;
            case LAVA:
                a(new Vec2i(50, 27), mctech.m.c.f.a, 0);
                a(new Vec2i(50, 71), mctech.m.c.r.c, 1);
                switch (AnonymousClass2.b[machineTier.ordinal()]) {
                    case 1:
                    case 2:
                    case 3:
                        i = 1;
                        break;
                    case 4:
                        i = 3;
                        break;
                    case 5:
                        i = 6;
                        break;
                    default:
                        i = 0;
                        break;
                }
                int i4 = i;
                int i5 = 0;
                while (i5 < i4) {
                    switch (AnonymousClass2.b[machineTier.ordinal()]) {
                        case 1:
                        case 2:
                        case 3:
                            vec2i = new Vec2i(146, 27);
                            break;
                        case 4:
                            vec2i = new Vec2i(128 + (i5 * 16) + (i5 * 2), 27);
                            break;
                        case 5:
                            vec2i = new Vec2i(128 + (i5 * 16) + (i5 * 2), i5 >= 3 ? 45 : 27);
                            break;
                        default:
                            vec2i = new Vec2i();
                            break;
                    }
                    Vec2i vec2i2 = vec2i;
                    if (machineTier == MachineTier.T5 && i5 >= 3) {
                        vec2i2.setX(128 + ((i5 - 3) * 16) + ((i5 - 3) * 2));
                    }
                    a(vec2i2, new mctech.utils.E(Set.of(Tags.Items.STONES, Tags.Items.COBBLESTONES)), (machineTier == MachineTier.T1 ? 3 : 2) + i5);
                    i5++;
                }
                for (int i6 = 0; i6 < ((C0069p) this.gui).upgradeSlots; i6++) {
                    Vec2i vec2i3 = new Vec2i(aI.f, 16 + (i6 * 19));
                    switch (AnonymousClass2.b[machineTier.ordinal()]) {
                        case 1:
                            i2 = 3 + i4 + i6;
                            break;
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            i2 = 2 + i4 + i6;
                            break;
                        default:
                            i2 = 0;
                            break;
                    }
                    a(vec2i3, i2);
                }
                break;
        }
    }

    /* JADX INFO: renamed from: mctech.m.b.D$2, reason: invalid class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/D$2.class */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] b = new int[MachineTier.values().length];

        static {
            try {
                b[MachineTier.T1.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                b[MachineTier.T2.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                b[MachineTier.T3.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                b[MachineTier.T4.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                b[MachineTier.T5.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            a = new int[mctech.i.c.values().length];
            try {
                a[mctech.i.c.WATER.ordinal()] = 1;
            } catch (NoSuchFieldError e6) {
            }
            try {
                a[mctech.i.c.LAVA.ordinal()] = 2;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // mctech.components.ContainerComponent
    public ResourceLocation getTexture() {
        return mctech.m.a.a(this, ((C0069p) getHolder()).machineTier(), (Supplier<String>) () -> {
            return String.format("%s_generator", ((C0069p) getHolder()).g().c);
        });
    }

    @Override // mctech.components.ContainerComponent
    @OnlyIn(Dist.CLIENT)
    public void onGuiLoaded(mctech.m.d.b bVar) {
        bVar.c(1);
        bVar.c(2);
        bVar.e(this.d.getX());
        bVar.f(this.d.getY());
    }

    @Override // mctech.api.tiles.ICustomContainer
    public Vec2i getFilterButtonCords() {
        return new Vec2i(-4, 28);
    }
}
