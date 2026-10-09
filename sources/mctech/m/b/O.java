package mctech.m.b;

import java.util.EnumSet;
import mctech.blockentities.c.C0077x;
import mctech.components.AbstractC0115i;
import mctech.components.a.C0093f;
import mctech.components.a.C0096i;
import mctech.components.a.C0097j;
import mctech.integration.emi.plugin.core.EMIPlugin;
import mctech.m.g.C0167a;
import mctech.utils.math.geometry.Vec2i;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/O.class */
public class O extends AbstractC0115i<C0077x> implements mctech.o.f {
    public O(final C0077x c0077x, Player player, int i) {
        super(c0077x, player, i);
        c0077x.getLevel();
        addSlot(new mctech.m.g.g(c0077x, C0077x.f[0], 29, 36, itemStack -> {
            return true;
        }));
        for (int i2 = 1; i2 < C0077x.f.length; i2++) {
            addSlot(new mctech.m.g.w(c0077x, C0077x.f[i2], 71 + (((i2 - 1) % 3) * 22), 25 + (((i2 - 1) / 3) * 22)));
        }
        addSlot(new mctech.m.g.r(c0077x, 7, 157, 36));
        int i3 = 0;
        for (int i4 : C0077x.h) {
            addSlot(new C0167a(c0077x, i4, 189, 17 + (i3 * 17)).a((ResourceLocation) null));
            i3++;
        }
        addPlayerInventoryWithOffset(player.getInventory(), 13, 11);
        getComponents().clear();
        addComponent(new mctech.components.b.o(new mctech.utils.math.geometry.b(134, 36, 20, 16), c0077x, new Vec2i(13, 182), false));
        addComponent(new C0093f(57, 73, c0077x, b().e()).a(true).b(() -> {
            return new Vec2i(89, 5);
        }));
        addComponent(new mctech.components.a.u(c0077x, 3, 17, b().e()).a(EnumSet.allOf(mctech.components.a.u.a.class)).a(() -> {
            return 160;
        }).d("gui.mctech.info.button").c(false));
        addComponent(new C0097j(this, 3, 28, b().e()).d("gui.mctech.filter.button").c(false));
        addComponent(new mctech.components.a.H(c0077x, 3, 39, b().e()).d("gui.mctech.inventory.button").c(false));
        addComponent(new C0096i(137, 35, new C0096i.a(this) { // from class: mctech.m.b.O.1
            @Override // mctech.components.a.C0096i.a
            public void openCategory() {
                EMIPlugin.showTypes(c0077x);
            }

            @Override // mctech.components.a.C0096i.a
            public boolean a() {
                return true;
            }
        }).a(-90.0f).d("jei.tooltip.show.recipes"));
    }

    @Override // mctech.components.ContainerComponent
    @OnlyIn(Dist.CLIENT)
    public void onGuiLoaded(@NotNull mctech.m.d.b bVar) {
        bVar.e(208, 177);
        bVar.c(3);
    }

    @Override // mctech.components.ContainerComponent
    @OnlyIn(Dist.CLIENT)
    public ResourceLocation getTexture() {
        return mctech.m.a.a(this, b().a(), "industrial_forge");
    }

    @Override // mctech.o.f
    @NotNull
    public mctech.i.a b() {
        return mctech.i.a.COMPOSITE;
    }
}
