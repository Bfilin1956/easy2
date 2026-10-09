package mctech.m.b;

import mctech.MCTech;
import mctech.components.C0112f;
import mctech.components.ContainerComponent;
import mctech.components.a.C0093f;
import mctech.components.a.C0095h;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;

/* JADX INFO: renamed from: mctech.m.b.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/j.class */
public class C0150j extends ContainerComponent<mctech.blockentities.p> {
    public C0150j(mctech.blockentities.p pVar, Player player, int i) {
        super(pVar, player, i);
        addHiddenPlayerInventory(player.getInventory());
        mctech.components.a.J j = new mctech.components.a.J(pVar);
        addComponent(new C0112f(j, pVar));
        if (pVar.b(player)) {
            addComponent(j);
        }
        addComponent(new C0095h(114, 178, pVar, () -> {
            return 5;
        }));
        addComponent(new C0093f(80, 170, pVar, () -> {
            return 5;
        }));
    }

    @Override // mctech.components.ContainerComponent
    public ResourceLocation getTexture() {
        return MCTech.loc("textures/gui/container/gui_base_teleporter.png");
    }

    @Override // mctech.components.ContainerComponent
    public void onGuiLoaded(mctech.m.d.b bVar) {
        bVar.c(1);
        bVar.c(2);
        bVar.e(223, 197);
    }
}
