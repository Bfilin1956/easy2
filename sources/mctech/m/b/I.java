package mctech.m.b;

import java.util.EnumSet;
import java.util.Objects;
import mctech.MCTech;
import mctech.blockentities.c.C0072s;
import mctech.components.AbstractC0115i;
import mctech.components.a.C0093f;
import mctech.components.a.C0097j;
import mctech.components.a.InterfaceC0102o;
import mctech.init.MCTechItems;
import mctech.utils.math.geometry.Vec2i;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/I.class */
public class I extends AbstractC0115i<C0072s> {
    private static final InterfaceC0102o a;

    static {
        MachineTier machineTier = MachineTier.T6;
        Objects.requireNonNull(machineTier);
        a = machineTier::ordinal;
    }

    public I(C0072s c0072s, Player player, int i) {
        super(c0072s, player, i);
        addSlot(new mctech.m.g.g(c0072s, C0072s.a[0], 27, 36, itemStack -> {
            return itemStack.is((Item) MCTechItems.GENETIC_MATERIAL.get());
        }));
        addSlot(new mctech.m.g.g(c0072s, C0072s.a[1], 45, 36, itemStack2 -> {
            return itemStack2.is((Item) MCTechItems.GENETIC_MATERIAL.get());
        }));
        addSlot(new mctech.m.g.g(c0072s, C0072s.b[0], 27, 60, itemStack3 -> {
            return itemStack3.is((Item) MCTechItems.EMPTY_VIAL.get());
        }));
        addSlot(new mctech.m.g.g(c0072s, C0072s.b[1], 45, 60, itemStack4 -> {
            return itemStack4.is((Item) MCTechItems.EMPTY_VIAL.get());
        }));
        int i2 = 0;
        for (int i3 = 0; i3 < 3; i3++) {
            for (int i4 = 0; i4 < 4; i4++) {
                int i5 = i2;
                i2++;
                addSlot(new mctech.m.g.r(c0072s, C0072s.c[i5], 133 + (i4 * 18), 30 + (i3 * 18)));
            }
        }
        addPlayerInventoryAt(player.getInventory(), 35, 111);
        getComponents().clear();
        addComponent(new mctech.components.b.o(new mctech.utils.math.geometry.b(73, 48, 46, 15), c0072s, new Vec2i(0, 241), false));
        addComponent(new C0093f(78, 87, c0072s, a));
        addComponent(new mctech.components.a.u(c0072s, a).a(EnumSet.allOf(mctech.components.a.u.a.class)).a(() -> {
            return 160;
        }).d("gui.mctech.info.button"));
        addComponent(new C0097j(this, a).d("gui.mctech.filter.button"));
        addComponent(new mctech.components.a.H(c0072s, a).d("gui.mctech.inventory.button"));
    }

    @Override // mctech.components.ContainerComponent
    @OnlyIn(Dist.CLIENT)
    public void onGuiLoaded(@NotNull mctech.m.d.b bVar) {
        bVar.c(1);
        bVar.c(2);
        bVar.e(aI.f);
        bVar.f(193);
    }

    @Override // mctech.components.ContainerComponent
    @OnlyIn(Dist.CLIENT)
    public ResourceLocation getTexture() {
        return ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "textures/gui/container/gui_genetic_sequentor.png");
    }
}
