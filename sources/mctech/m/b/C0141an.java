package mctech.m.b;

import mctech.components.AbstractC0115i;
import mctech.components.a.C0093f;
import mctech.components.a.C0095h;
import mctech.components.a.C0097j;
import mctech.components.a.C0099l;
import mctech.components.a.InterfaceC0102o;
import mctech.init.MCTechRecipes;
import mctech.utils.math.geometry.Vec2i;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: renamed from: mctech.m.b.an, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/an.class */
public class C0141an extends AbstractC0115i<mctech.blockentities.c.S> {
    public C0141an(mctech.blockentities.c.S s, Player player, int i) {
        super(s, player, i);
        addSlot(new mctech.m.g.g(s, 0, -999, -999, mctech.m.c.r.c));
        addSlot(new mctech.m.g.g(s, 1, 103, 50, itemStack -> {
            return s.getLevel().getRecipeManager().getAllRecipesFor((RecipeType) MCTechRecipes.REFINERY.get()).stream().anyMatch(recipeHolder -> {
                return ((mctech.u.W) recipeHolder.value()).d().test(itemStack);
            });
        }));
        for (int i2 = 0; i2 < 3; i2++) {
            addSlot(new mctech.m.g.B(s, 2 + i2, 147, 29 + (i2 * 21)));
        }
        for (int i3 = 0; i3 < 4; i3++) {
            addSlot(new mctech.m.g.z(s, 5 + i3, 234, 19 + (i3 * 19)));
        }
        addPlayerInventoryAt(player.getInventory(), 42, 130);
        getComponents().clear();
        InterfaceC0102o interfaceC0102o = () -> {
            return 3;
        };
        addComponent(new C0093f(85, 98, s, interfaceC0102o));
        addComponent(new C0095h(119, 106, s, interfaceC0102o));
        addComponent(new C0099l(s, 54, 28, 0, s.b, interfaceC0102o).a().a((Component) Component.translatable("gui.mctech.tank.first")));
        addComponent(new C0099l(s, 77, 28, 1, s.c, interfaceC0102o).a().a((Component) Component.translatable("gui.mctech.tank.second")));
        addComponent(new C0099l(s, 172, 28, 2, s.d, interfaceC0102o).a().a(true));
        addComponent(new mctech.components.b.o(new mctech.utils.math.geometry.b(124, 51, 18, 14), s, new Vec2i(0, 242)).a(true));
        addComponent(new C0097j(this, interfaceC0102o));
        addComponent(new mctech.components.a.H(s, interfaceC0102o).d("gui.mctech.inventory.button"));
        addComponent(new mctech.components.a.u(s, interfaceC0102o).a(mctech.components.a.u.a));
    }

    @Override // mctech.components.ContainerComponent
    public ResourceLocation getTexture() {
        return mctech.m.a.a(this, MachineTier.T4);
    }

    @Override // mctech.components.ContainerComponent
    @OnlyIn(Dist.CLIENT)
    public void onGuiLoaded(mctech.m.d.b bVar) {
        bVar.c(1);
        bVar.c(2);
        bVar.e(mctech.utils.c.h.i);
        bVar.f(213);
    }

    @Override // mctech.components.AbstractC0115i, mctech.components.ContainerComponent
    public Vec2i getFilterGuiSize() {
        return new Vec2i(122, 132);
    }

    @Override // mctech.components.AbstractC0115i, mctech.components.ContainerComponent
    public Vec2i getFilterScrollOffset() {
        return new Vec2i(-2, -2);
    }

    @Override // mctech.components.AbstractC0115i, mctech.components.ContainerComponent
    public Vec2i getFilterItemsOffset() {
        return new Vec2i(3, -2);
    }

    @Override // mctech.components.AbstractC0115i, mctech.components.ContainerComponent
    public Vec2i getInfoGuiSize() {
        return new Vec2i(198, 51);
    }
}
