package mctech.m.b;

import java.util.EnumSet;
import java.util.function.Supplier;
import mctech.api.energy.IEnergyCrystal;
import mctech.api.tiles.ICustomContainer;
import mctech.components.AbstractC0115i;
import mctech.components.a.C0094g;
import mctech.components.a.C0097j;
import mctech.components.a.InterfaceC0102o;
import mctech.init.MCTechLang;
import mctech.utils.math.geometry.Vec2i;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: renamed from: mctech.m.b.ag, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/ag.class */
public class C0134ag extends AbstractC0115i<mctech.blockentities.b.e> implements ICustomContainer {
    public C0134ag(mctech.blockentities.b.e eVar, Player player, int i) {
        super(eVar, player, i);
        InterfaceC0102o interfaceC0102o = () -> {
            return eVar.machineTier().ordinal();
        };
        addSlot(new mctech.m.g.g(eVar, 0, 183, 60, mctech.m.c.r.c));
        addSlot(new mctech.m.g.g(eVar, 1, 183, 28, itemStack -> {
            return mctech.m.c.a.c.f.matches(itemStack) || (itemStack.getItem() instanceof IEnergyCrystal);
        }));
        getComponents().clear();
        addPlayerInventoryAt(player.getInventory(), 39, 108);
        addComponent(new C0094g(27, 25, 136, eVar, () -> {
            return 3;
        }));
        addComponent(new C0097j(this, interfaceC0102o));
        addComponent(new mctech.components.a.H(eVar, interfaceC0102o).d("gui.mctech.inventory.button"));
        addComponent(new mctech.components.a.u(eVar, interfaceC0102o).a(EnumSet.of(mctech.components.a.u.a.GENERATOR_INFO)).b(new Supplier<Vec2i>(this) { // from class: mctech.m.b.ag.1
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Vec2i get() {
                return new Vec2i(8, 0);
            }
        }).b((Component) MCTechLang.TOOLTIP_INFO_BUTTON));
        addComponent(new mctech.components.C(eVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // mctech.components.ContainerComponent
    public ResourceLocation getTexture() {
        return mctech.m.a.a(this, ((mctech.blockentities.b.e) getHolder()).machineTier());
    }

    @Override // mctech.components.ContainerComponent
    @OnlyIn(Dist.CLIENT)
    public void onGuiLoaded(mctech.m.d.b bVar) {
        bVar.c(1);
        bVar.c(2);
        bVar.e(mctech.g.c.a.d.d);
        bVar.f(190);
    }
}
