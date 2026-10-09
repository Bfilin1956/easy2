package mctech.m.b;

import java.util.Objects;
import mctech.MCTech;
import mctech.api.tiles.ICustomContainer;
import mctech.components.AbstractC0115i;
import mctech.components.a.C0094g;
import mctech.components.a.C0097j;
import mctech.components.a.C0099l;
import mctech.components.a.InterfaceC0102o;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/aF.class */
public class aF extends AbstractC0115i<mctech.blockentities.v> implements ICustomContainer {
    private static final InterfaceC0102o a;

    static {
        MachineTier machineTier = MachineTier.T8;
        Objects.requireNonNull(machineTier);
        a = machineTier::ordinal;
    }

    public aF(mctech.blockentities.v vVar, Player player, int i) {
        super(vVar, player, i);
        for (int i2 = 0; i2 < 4; i2++) {
            int i3 = i2;
            addSlot(new mctech.m.g.g(vVar, i2, 63 + (i2 * 35), 87, itemStack -> {
                return vVar.a(i3, itemStack);
            }));
        }
        addPlayerInventoryAt(player.getInventory(), 43, 148);
        getComponents().clear();
        addComponent(new C0099l(vVar, 22, 28, 0, vVar.b, a).c(true).a((Component) Component.literal("Бак для трития")));
        addComponent(new C0099l(vVar, 206, 28, 1, vVar.c, a).c(true).a((Component) Component.literal("Бак для дейтерия")));
        addComponent(new mctech.components.O(vVar, 58, 61, 130, 18));
        addComponent(new C0094g(42, 115, 162, vVar, () -> {
            return 1;
        }));
        addComponent(new C0097j(this, a));
        addComponent(new mctech.components.a.H(vVar, a).d("gui.mctech.inventory.button"));
    }

    @Override // mctech.components.ContainerComponent
    public ResourceLocation getTexture() {
        return MCTech.loc("textures/gui/container/gui_termonuclar_reactor.png");
    }

    @Override // mctech.components.ContainerComponent
    @OnlyIn(Dist.CLIENT)
    public void onGuiLoaded(mctech.m.d.b bVar) {
        bVar.c(1);
        bVar.c(2);
        bVar.e(mctech.utils.c.h.i);
        bVar.f(mctech.utils.c.h.i);
    }
}
