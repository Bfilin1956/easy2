package mctech.m.b;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;
import java.util.function.Supplier;
import mctech.MCTech;
import mctech.api.tiles.ICustomContainer;
import mctech.components.AbstractC0115i;
import mctech.components.C0123q;
import mctech.components.a.C0097j;
import mctech.components.a.InterfaceC0102o;
import mctech.init.MCTechLang;
import mctech.utils.math.geometry.Vec2i;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/aI.class */
public class aI extends AbstractC0115i<mctech.blockentities.c.ae> implements ICustomContainer {
    public static final int a = 34;
    public static final int b = 26;
    public static final int c = 18;
    public static final int d = 9;
    public static final int e = 4;
    public static final int f = 220;
    public static final int g = 19;
    public static final int h = 19;
    private static final ResourceLocation i = MCTech.loc("textures/gui/components/blocked.png");
    private static final InterfaceC0102o j;

    static {
        MachineTier machineTier = MachineTier.T8;
        Objects.requireNonNull(machineTier);
        j = machineTier::ordinal;
    }

    public aI(mctech.blockentities.c.ae aeVar, Player player, int i2) {
        super(aeVar, player, i2);
        for (int i3 = 0; i3 < 4; i3++) {
            for (int i4 = 0; i4 < 9; i4++) {
                addSlot(a(aeVar, (i3 * 9) + i4, 34 + (i4 * 18), 26 + (i3 * 18)));
            }
        }
        for (int i5 = 0; i5 < 3; i5++) {
            addSlot(b(aeVar, 36 + i5, f, 19 + (i5 * 19)));
        }
        addPlayerInventoryAt(player.getInventory(), 35, 111);
        getComponents().clear();
        addComponent(new mctech.components.a.u(aeVar, j).a(EnumSet.of(mctech.components.a.u.a.ENERGY_INPUT, mctech.components.a.u.a.ENERGY_STORAGE, mctech.components.a.u.a.OPERATION_TIME, mctech.components.a.u.a.OPERATION_COST)).b((Component) MCTechLang.TOOLTIP_INFO_BUTTON));
        addComponent(new C0097j(this, j));
        for (int i6 = 0; i6 < 36; i6++) {
            int i7 = i6;
            a(34 + ((i6 % 9) * 18), 26 + ((i6 / 9) * 18), () -> {
                return Boolean.valueOf(!aeVar.a(i7));
            });
        }
    }

    private mctech.m.g.g a(final mctech.blockentities.c.ae aeVar, final int i2, int i3, int i4) {
        return new mctech.m.g.g(this, aeVar, i2, i3, i4, aeVar.e()) { // from class: mctech.m.b.aI.1
            public boolean isActive() {
                return aeVar.a(i2);
            }

            @Override // mctech.m.g.g
            public boolean mayPlace(ItemStack itemStack) {
                return isActive() && super.mayPlace(itemStack);
            }
        };
    }

    private mctech.m.g.g b(mctech.blockentities.c.ae aeVar, int i2, int i3, int i4) {
        return new mctech.m.g.g(this, aeVar, i2, i3, i4, aeVar.f()) { // from class: mctech.m.b.aI.2
            @Override // mctech.m.g.x
            public int getMaxStackSize() {
                return 1;
            }
        };
    }

    private void a(int i2, int i3, Supplier<Boolean> supplier) {
        addComponent(new C0123q(this, i, new mctech.utils.math.geometry.b(i2 - 2, i3 - 2, 20, 20), new Vec2i(20, 20), Vec2i.ZERO, supplier) { // from class: mctech.m.b.aI.3
            @Override // mctech.components.C0123q, mctech.m.d.a.a
            protected void a(Set<mctech.m.d.a.a.EnumC0027a> set) {
                set.add(mctech.m.d.a.a.EnumC0027a.DRAW_BACKGROUND);
            }
        });
    }

    @Override // mctech.components.ContainerComponent
    public ResourceLocation getTexture() {
        return MCTech.loc("textures/gui/container/gui_transformation_assembler.png");
    }

    @Override // mctech.components.ContainerComponent
    @OnlyIn(Dist.CLIENT)
    public void onGuiLoaded(mctech.m.d.b bVar) {
        bVar.c(1);
        bVar.c(2);
        bVar.e(244);
        bVar.f(192);
    }
}
