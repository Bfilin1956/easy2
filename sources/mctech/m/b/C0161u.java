package mctech.m.b;

import java.util.EnumSet;
import mctech.blockentities.c.C0062i;
import mctech.components.AbstractC0115i;
import mctech.components.C0109c;
import mctech.components.C0114h;
import mctech.components.a.C0093f;
import mctech.components.a.C0097j;
import mctech.init.MCTechRecipes;
import mctech.m.g.C0167a;
import mctech.utils.math.geometry.Vec2i;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: mctech.m.b.u, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/u.class */
public class C0161u extends AbstractC0115i<C0062i> implements mctech.o.f {
    public C0161u(C0062i c0062i, Player player, int i) {
        super(c0062i, player, i);
        for (int i2 : C0062i.f) {
            addSlot(new mctech.m.g.g(c0062i, i2, i2 / 2 == 0 ? 42 : 143, i2 % 2 == 0 ? 26 : 52, C0062i::a));
        }
        Level level = c0062i.getLevel();
        addSlot(new mctech.m.g.v(c0062i, 4, 85, 31, itemStack -> {
            return level.getRecipeManager().getRecipeFor(MCTechRecipes.type("crystal_growth_chamber"), new SingleRecipeInput(itemStack), level).isPresent();
        }));
        addSlot(mctech.m.g.g.d(c0062i, 5, 93, 90));
        int i3 = 0;
        for (int i4 : C0062i.j) {
            addSlot(new C0167a(c0062i, i4, 189, 17 + (i3 * 17)).a((ResourceLocation) null));
            i3++;
        }
        addPlayerInventoryWithOffset(player.getInventory(), 13, 52);
        getComponents().clear();
        for (int i5 : C0062i.f) {
            addComponent(new C0114h((i5 / 2 == 0 ? 42 : 143) - 9, (i5 % 2 == 0 ? 26 : 52) - 1, c0062i, i5));
        }
        addComponent(new C0109c(c0062i, 0, new mctech.utils.math.geometry.b(93, 66, 16, 20), new Vec2i(13, 223), true));
        addComponent(new C0093f(42, 114, c0062i, b().e()).a(false).b(() -> {
            return new Vec2i(118, 5);
        }));
        addComponent(new mctech.components.a.u(c0062i, 3, 17, b().e()).a(EnumSet.allOf(mctech.components.a.u.a.class)).a(() -> {
            return 160;
        }).d("gui.mctech.info.button").c(false));
        addComponent(new C0097j(this, 3, 28, b().e()).d("gui.mctech.filter.button").c(false));
        addComponent(new mctech.components.a.H(c0062i, 3, 39, b().e()).d("gui.mctech.inventory.button").c(false));
    }

    @Override // mctech.components.ContainerComponent
    @OnlyIn(Dist.CLIENT)
    public void onGuiLoaded(@NotNull mctech.m.d.b bVar) {
        bVar.e(208, 218);
        bVar.c(3);
    }

    @Override // mctech.components.ContainerComponent
    @OnlyIn(Dist.CLIENT)
    public ResourceLocation getTexture() {
        return mctech.m.a.a(this, b().a(), "crystal_growth_chamber");
    }

    @Override // mctech.o.f
    @NotNull
    public mctech.i.a b() {
        return mctech.i.a.COMPOSITE;
    }
}
