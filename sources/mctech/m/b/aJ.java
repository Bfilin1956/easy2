package mctech.m.b;

import java.util.Objects;
import java.util.function.Supplier;
import mctech.components.ContainerComponent;
import mctech.components.a.C0093f;
import mctech.components.a.C0095h;
import mctech.components.a.C0097j;
import mctech.components.a.InterfaceC0102o;
import mctech.utils.math.geometry.Vec2i;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/aJ.class */
public class aJ extends ContainerComponent<mctech.blockentities.c.af> {
    public aJ(mctech.blockentities.c.af afVar, Player player, int i) {
        super(afVar, player, i);
        Objects.requireNonNull(afVar);
        addSlot(new mctech.m.g.g(afVar, 0, 67, 35, afVar::a));
        Objects.requireNonNull(afVar);
        addSlot(new mctech.m.g.g(afVar, 1, 105, 65, afVar::b));
        addSlot(mctech.m.g.g.d(afVar, 2, 165, 50));
        addPlayerInventoryAt(player.getInventory(), 42, 123);
        getComponents().clear();
        InterfaceC0102o interfaceC0102o = () -> {
            return 3;
        };
        addComponent(new mctech.components.b.o(126, 41, 34, 34, afVar, 6, 222).a(true).a(() -> {
            return 0;
        }));
        mctech.components.b.o oVarA = new mctech.components.b.o(88, 38, 20, 10, afVar, 40, 234).a(true).a(() -> {
            return 1;
        });
        Objects.requireNonNull(afVar);
        Supplier<Float> supplier = afVar::getSubProgress;
        Objects.requireNonNull(afVar);
        addComponent(oVarA.a(supplier, afVar::getMaxSubProgress));
        addComponent(new C0093f(85, 91, afVar, interfaceC0102o));
        addComponent(new C0095h(119, 99, afVar, interfaceC0102o));
        addComponent(new C0097j(this, interfaceC0102o));
        addComponent(new mctech.components.a.u(afVar, interfaceC0102o).a(mctech.components.a.u.a));
        addComponent(new mctech.components.Q(new mctech.utils.math.geometry.b(110, 26, 6, 34), afVar, new Vec2i(0, 222)));
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
        bVar.f(204);
    }

    @Override // mctech.components.ContainerComponent
    public Vec2i getFilterGuiSize() {
        return new Vec2i(122, 132);
    }

    @Override // mctech.components.ContainerComponent
    public Vec2i getFilterScrollOffset() {
        return new Vec2i(-2, -2);
    }

    @Override // mctech.components.ContainerComponent
    public Vec2i getFilterItemsOffset() {
        return new Vec2i(3, -2);
    }

    @Override // mctech.components.ContainerComponent
    public Vec2i getInfoGuiSize() {
        return new Vec2i(198, 51);
    }
}
