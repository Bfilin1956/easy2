package mctech.m.b;

import java.util.EnumSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Supplier;
import mctech.MCTech;
import mctech.api.tiles.ICustomContainer;
import mctech.blockentities.c.C0074u;
import mctech.components.AbstractC0115i;
import mctech.components.C0123q;
import mctech.components.a.C0089b;
import mctech.components.a.C0093f;
import mctech.components.a.C0095h;
import mctech.components.a.C0096i;
import mctech.components.a.C0097j;
import mctech.components.a.C0099l;
import mctech.components.a.InterfaceC0102o;
import mctech.init.MCTechLang;
import mctech.integration.emi.plugin.base.EmiMachineRegistry;
import mctech.utils.math.geometry.Vec2i;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/L.class */
public class L extends AbstractC0115i<C0074u> implements ICustomContainer {
    private static final int b = 43;
    private static final int c = 64;
    private static final int d = 108;
    private static final InterfaceC0102o f;
    private static final int[] a = {86, 109, 132, 155, 178, 201};
    private static final ResourceLocation e = MCTech.loc("textures/gui/components/blocked.png");

    static {
        MachineTier machineTier = MachineTier.T4;
        Objects.requireNonNull(machineTier);
        f = machineTier::ordinal;
    }

    public L(C0074u c0074u, Player player, int i) {
        super(c0074u, player, i);
        for (int i2 = 0; i2 < 6; i2++) {
            a(c0074u, i2);
        }
        List<Integer> listB = c0074u.getInventoryManager().b(mctech.m.e.k.c);
        for (int i3 = 0; i3 < listB.size(); i3++) {
            addSlot(new mctech.m.g.z(c0074u, listB.get(i3).intValue(), 234, 19 + (i3 * 19)));
        }
        addPlayerInventoryAt(player.getInventory(), 42, 170);
        getComponents().clear();
        for (int i4 = 0; i4 < 6; i4++) {
            b(c0074u, i4);
        }
        addComponent(new C0099l(c0074u, 24, 52, 0, c0074u.p, f).a((Component) MCTechLang.GUI_FLUID_LAVA).a());
        addComponent(new C0099l(c0074u, 46, 52, 1, c0074u.q, f).a((Component) MCTechLang.GUI_FLUID_MOLTEN_GLASS).a());
        Objects.requireNonNull(c0074u);
        addComponent(new mctech.components.a.O(85, 136, c0074u::b, () -> {
            return 100;
        }, f).a(() -> {
            return mctech.g.d.e.h.a(MCTechLang.TOOLTIP_HEAT_LEVEL, Integer.valueOf(c0074u.b()), 100);
        }));
        addComponent(new C0093f(85, 146, c0074u, f));
        addComponent(new C0095h(119, 153, c0074u, f));
        addComponent(new mctech.components.a.u(c0074u, f).a(EnumSet.of(mctech.components.a.u.a.ENERGY_INPUT, mctech.components.a.u.a.ENERGY_STORAGE, mctech.components.a.u.a.OPERATION_TIME, mctech.components.a.u.a.OPERATION_COST)).b((Component) MCTechLang.TOOLTIP_INFO_BUTTON));
        addComponent(new C0097j(this, f));
        Objects.requireNonNull(c0074u);
        addComponent(new C0089b(c0074u::e).a(p -> {
            c0074u.sendToServer(0, 0);
        }).b((Component) Component.empty().append(MCTechLang.TOOLTIP_AUTO_SORT).append(Component.empty().append(MCTechLang.GUI_YES).withStyle(ChatFormatting.GREEN))).a((Component) Component.empty().append(MCTechLang.TOOLTIP_AUTO_SORT).append(Component.empty().append(MCTechLang.GUI_NO).withStyle(ChatFormatting.RED))));
        for (int i5 = 0; i5 < 6; i5++) {
            int i6 = i5;
            a(a[i5], b, () -> {
                return Boolean.valueOf(!c0074u.d(i6));
            });
            a(a[i5], 64, () -> {
                return Boolean.valueOf(!c0074u.d(i6));
            });
            a(a[i5], d, () -> {
                return Boolean.valueOf(!c0074u.d(i6));
            });
        }
    }

    private void a(int i, int i2, Supplier<Boolean> supplier) {
        addComponent(new C0123q(this, e, new mctech.utils.math.geometry.b(i - 2, i2 - 2, 20, 20), new Vec2i(20, 20), Vec2i.ZERO, supplier) { // from class: mctech.m.b.L.1
            @Override // mctech.components.C0123q, mctech.m.d.a.a
            protected void a(Set<mctech.m.d.a.a.EnumC0027a> set) {
                set.add(mctech.m.d.a.a.EnumC0027a.DRAW_BACKGROUND);
            }
        });
    }

    private void a(final C0074u c0074u, final int i) {
        int i2 = a[i];
        mctech.m.c.e eVar = new mctech.m.c.e(c0074u, 0, c0074u.a(i));
        mctech.m.c.e eVar2 = new mctech.m.c.e(c0074u, 1, c0074u.b(i));
        addSlot(new mctech.m.g.g(this, c0074u, c0074u.a(i), i2, b, eVar) { // from class: mctech.m.b.L.2
            public boolean isActive() {
                return c0074u.d(i);
            }

            @Override // mctech.m.g.g
            public boolean mayPlace(ItemStack itemStack) {
                return isActive() && super.mayPlace(itemStack);
            }

            public boolean mayPickup(@NotNull Player player) {
                return isActive() && super.mayPickup(player);
            }
        });
        addSlot(new mctech.m.g.g(this, c0074u, c0074u.b(i), i2, 64, eVar2) { // from class: mctech.m.b.L.3
            public boolean isActive() {
                return c0074u.d(i);
            }

            @Override // mctech.m.g.g
            public boolean mayPlace(ItemStack itemStack) {
                return isActive() && super.mayPlace(itemStack);
            }

            public boolean mayPickup(@NotNull Player player) {
                return isActive() && super.mayPickup(player);
            }
        });
        addSlot(new mctech.m.g.r(this, c0074u, c0074u.c(i), i2, d) { // from class: mctech.m.b.L.4
            public boolean isActive() {
                return c0074u.d(i);
            }

            public boolean mayPickup(@NotNull Player player) {
                return isActive() && super.mayPickup(player);
            }
        });
    }

    private void b(C0074u c0074u, int i) {
        int i2 = a[i];
        addComponent(new mctech.components.a.N(i2 + 1, 86, () -> {
            return Integer.valueOf((int) c0074u.getProgressSlot(i));
        }, () -> {
            return Integer.valueOf((int) c0074u.getMaxProgressSlot(i));
        }, f));
        addComponent(new C0096i(i2 + 1, 87, () -> {
            EmiMachineRegistry.displayRecipes((C0074u) getHolder());
        }).b((Component) MCTechLang.TOOLTIP_SHOW_RECIPES));
    }

    @Override // mctech.components.ContainerComponent
    public ResourceLocation getTexture() {
        return MCTech.loc("textures/gui/container/gui_glass_furnace.png");
    }

    @Override // mctech.components.ContainerComponent
    @OnlyIn(Dist.CLIENT)
    public void onGuiLoaded(mctech.m.d.b bVar) {
        bVar.c(1);
        bVar.c(2);
        bVar.e(252);
        bVar.f(254);
    }
}
