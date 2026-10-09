package mctech.m.b;

import java.util.EnumSet;
import mctech.blockentities.c.C0076w;
import mctech.components.AbstractC0115i;
import mctech.components.a.C0093f;
import mctech.components.a.C0097j;
import mctech.utils.math.geometry.Vec2i;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/N.class */
public class N extends AbstractC0115i<C0076w> implements mctech.o.f {
    public N(C0076w c0076w, Player player, int i) {
        super(c0076w, player, i);
        addSlot(new mctech.m.g.g(c0076w, 0, 57, 82, C0076w::a));
        addSlot(new mctech.m.g.g(c0076w, 1, 81, 82, C0076w::b));
        addSlot(new mctech.m.g.g(c0076w, 2, 129, 82, C0076w::c));
        for (int i2 = 0; i2 < 2; i2++) {
            addSlot(new mctech.m.g.j(c0076w, 3 + i2, 189, 17 + (i2 * 17)).a((ResourceLocation) null));
        }
        addPlayerInventoryWithOffset(player.getInventory(), 13, 71);
        getComponents().clear();
        addComponent(new C0093f(42, 133, c0076w, b().e()).a(false).b(() -> {
            return new Vec2i(118, 5);
        }));
        addComponent(new mctech.components.a.u(c0076w, 3, 17, b().e()).a(EnumSet.of(mctech.components.a.u.a.ENERGY_INPUT, mctech.components.a.u.a.ENERGY_STORAGE)).a(() -> {
            return 160;
        }).d("gui.mctech.info.button").c(false));
        addComponent(new C0097j(this, 3, 28, b().e()).d("gui.mctech.filter.button").c(false));
        addComponent(new mctech.components.a.H(c0076w, 3, 39, b().e()).d("gui.mctech.inventory.button").c(false));
        addComponent(new mctech.components.t(new mctech.utils.math.geometry.b(19, 26, 164, 42)));
        addComponent(new mctech.components.I(new Vec2i(116, 109), c0076w));
        addComponent(new mctech.components.s(c0076w, new mctech.utils.math.geometry.b(42, 101, 70, 32)));
    }

    @Override // mctech.components.ContainerComponent
    @OnlyIn(Dist.CLIENT)
    public void onGuiLoaded(@NotNull mctech.m.d.b bVar) {
        bVar.e(208, 237);
        bVar.c(3);
    }

    @Override // mctech.components.ContainerComponent
    @OnlyIn(Dist.CLIENT)
    public ResourceLocation getTexture() {
        return mctech.m.a.a(this, MachineTier.T4);
    }

    @Override // mctech.o.f
    @NotNull
    public mctech.i.a b() {
        return mctech.i.a.COMPOSITE;
    }
}
