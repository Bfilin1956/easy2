package mctech.m.b;

import java.util.EnumSet;
import java.util.List;
import mctech.api.tiles.ICustomContainer;
import mctech.components.AbstractC0115i;
import mctech.components.a.C0093f;
import mctech.components.a.C0095h;
import mctech.components.a.C0097j;
import mctech.components.a.C0099l;
import mctech.init.MCTechLang;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: renamed from: mctech.m.b.af, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/af.class */
public class C0133af extends AbstractC0115i<mctech.blockentities.c.L> implements ICustomContainer {
    public C0133af(mctech.blockentities.c.L l, Player player, int i) {
        super(l, player, i);
        addSlot(new mctech.m.g.g(l, 0, 112, 43, mctech.m.c.r.c));
        List<Integer> listB = l.getInventoryManager().b(mctech.m.e.k.c);
        for (int i2 = 0; i2 < listB.size(); i2++) {
            addSlot(new mctech.m.g.z(l, listB.get(i2).intValue(), 234, 19 + (i2 * 19)));
        }
        addPlayerInventoryAt(player.getInventory(), 42, 110);
        addComponent(new C0093f(85, 78, l, () -> {
            return l.machineTier().ordinal();
        }));
        addComponent(new C0095h(119, 86, l, () -> {
            return l.machineTier().ordinal();
        }));
        addComponent(new C0099l(l, 203, 20, 0, l.d(), () -> {
            return l.machineTier().ordinal();
        }));
        addComponent(new C0097j(this, () -> {
            return l.machineTier().ordinal();
        }));
        addComponent(new mctech.components.a.H(l, () -> {
            return l.machineTier().ordinal();
        }).d("gui.mctech.inventory.button"));
        addComponent(new mctech.components.a.u(l, () -> {
            return l.machineTier().ordinal();
        }).a(EnumSet.of(mctech.components.a.u.a.ENERGY_INPUT, mctech.components.a.u.a.ENERGY_STORAGE, mctech.components.a.u.a.OPERATION_TIME, mctech.components.a.u.a.OPERATION_COST)).b((Component) MCTechLang.TOOLTIP_INFO_BUTTON));
        addComponent(new mctech.components.B(l));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // mctech.components.ContainerComponent
    public ResourceLocation getTexture() {
        return mctech.m.a.a(this, ((mctech.blockentities.c.L) getHolder()).machineTier());
    }

    @Override // mctech.components.ContainerComponent
    @OnlyIn(Dist.CLIENT)
    public void onGuiLoaded(mctech.m.d.b bVar) {
        bVar.c(1);
        bVar.c(2);
        bVar.e(252);
        bVar.f(192);
    }
}
