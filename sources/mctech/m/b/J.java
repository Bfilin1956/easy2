package mctech.m.b;

import java.util.EnumSet;
import java.util.Objects;
import mctech.MCTech;
import mctech.blockentities.c.C0073t;
import mctech.components.AbstractC0115i;
import mctech.components.C0124r;
import mctech.components.a.C0093f;
import mctech.components.a.C0097j;
import mctech.components.a.C0099l;
import mctech.components.a.InterfaceC0102o;
import mctech.init.MCTechItems;
import mctech.utils.math.geometry.Vec2i;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/J.class */
public class J extends AbstractC0115i<C0073t> {
    private static final InterfaceC0102o a;

    static {
        MachineTier machineTier = MachineTier.T6;
        Objects.requireNonNull(machineTier);
        a = machineTier::ordinal;
    }

    public J(C0073t c0073t, Player player, int i) {
        super(c0073t, player, i);
        addSlot(new mctech.m.g.g(c0073t, 1, 70, 34, itemStack -> {
            return mctech.k.c.b(c0073t.getLevel(), itemStack).isPresent();
        }));
        addSlot(new mctech.m.g.g(c0073t, 0, 70, 61, itemStack2 -> {
            return itemStack2.is((Item) MCTechItems.DNA_SAMPLE.get());
        }));
        addSlot(new mctech.m.g.r(c0073t, 2, 143, 61));
        addPlayerInventoryAt(player.getInventory(), 35, 111);
        getComponents().clear();
        addComponent(new mctech.components.b.o(new mctech.utils.math.geometry.b(99, 62, 37, 15), c0073t, new Vec2i(37, 241), false));
        addComponent(new C0093f(78, 87, c0073t, a));
        addComponent(new C0099l(c0073t, 26, 26, 0, c0073t.i, a).a((Component) Component.translatable("gui.mctech.genetic_stabilizer.xp_tank")).a());
        addComponent(new C0124r(c0073t, this));
        addComponent(new mctech.components.a.u(c0073t, a).a(EnumSet.allOf(mctech.components.a.u.a.class)).a(() -> {
            return 160;
        }).d("gui.mctech.info.button"));
        addComponent(new C0097j(this, a).d("gui.mctech.filter.button"));
        addComponent(new mctech.components.a.H(c0073t, a).d("gui.mctech.inventory.button"));
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
        return ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "textures/gui/container/gui_genetic_stabilizer.png");
    }
}
