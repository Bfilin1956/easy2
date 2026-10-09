package mctech.m.b;

import java.util.EnumSet;
import java.util.Objects;
import mctech.MCTech;
import mctech.blockentities.c.C0068o;
import mctech.components.AbstractC0115i;
import mctech.components.a.C0097j;
import mctech.components.a.C0099l;
import mctech.components.a.C0101n;
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

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/A.class */
public class A extends AbstractC0115i<C0068o> {
    private static final C0101n a = new C0101n(MCTech.loc("textures/gui/container/gui_experience_extractor.png"), mctech.utils.c.h.i, mctech.utils.c.h.i);
    private static final InterfaceC0102o b;

    static {
        MachineTier machineTier = MachineTier.T6;
        Objects.requireNonNull(machineTier);
        b = machineTier::ordinal;
    }

    public A(C0068o c0068o, Player player, int i) {
        super(c0068o, player, i);
        addSlot(new mctech.m.g.g(c0068o, 0, 37, 79, itemStack -> {
            return itemStack.is((Item) MCTechItems.DNA_SAMPLE.get());
        }));
        addSlot(new mctech.m.g.g(c0068o, 1, 169, 79, new mctech.utils.o(c0068o.e).a(true)));
        addSlot(new mctech.m.g.g(c0068o, 2, 187, 79, mctech.m.c.r.c));
        addPlayerInventoryAt(player.getInventory(), 35, 111);
        getComponents().clear();
        addComponent(new C0099l(c0068o, 106, 24, 0, c0068o.e, b).a((Component) Component.translatable("gui.mctech.experience_extractor.xp_tank")).a());
        addComponent(new mctech.components.a.R(a, 80, 88, 70, 12, new Vec2i(0, 244), new Vec2i(70, 244), new Vec2i(140, 244)).c(false).a(r -> {
            c0068o.sendToServer(0, 0);
        }).d("gui.mctech.experience_extractor.extract_xp"));
        addComponent(new mctech.components.a.u(c0068o, b).a(EnumSet.allOf(mctech.components.a.u.a.class)).a(() -> {
            return 160;
        }).d("gui.mctech.info.button"));
        addComponent(new C0097j(this, b).d("gui.mctech.filter.button"));
        addComponent(new mctech.components.a.H(c0068o, b).d("gui.mctech.inventory.button"));
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
        return a.a();
    }
}
