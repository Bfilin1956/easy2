package mctech.m.b;

import java.util.EnumSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Supplier;
import mctech.MCTech;
import mctech.api.tiles.ICustomContainer;
import mctech.components.AbstractC0115i;
import mctech.components.C0123q;
import mctech.components.a.C0093f;
import mctech.components.a.C0095h;
import mctech.components.a.C0097j;
import mctech.components.a.InterfaceC0102o;
import mctech.utils.math.geometry.Vec2i;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/C.class */
public class C extends AbstractC0115i<mctech.blockentities.c.a.b> implements ICustomContainer {
    private static final ResourceLocation a = MCTech.loc("textures/gui/components/blocked.png");
    private static final InterfaceC0102o b;
    private static final int c = 38;
    private static final int d = 46;
    private static final int e = 82;
    private static final int f = 46;
    private static final int g = 146;
    private static final int h = 28;
    private static final int i = 18;

    static {
        MachineTier machineTier = MachineTier.T5;
        Objects.requireNonNull(machineTier);
        b = machineTier::ordinal;
    }

    public C(mctech.blockentities.c.a.b bVar, Player player, int i2) {
        super(bVar, player, i2);
        for (int i3 = 0; i3 < 2; i3++) {
            for (int i4 = 0; i4 < 2; i4++) {
                addSlot(new mctech.m.g.g(bVar, (i3 * 2) + i4, c + (i4 * 18), 46 + (i3 * 18), itemStack -> {
                    return itemStack.is(ItemTags.SAPLINGS);
                }));
            }
        }
        addSlot(a(bVar, 4, e, 46));
        for (int i5 = 0; i5 < 3; i5++) {
            for (int i6 = 0; i6 < 3; i6++) {
                addSlot(mctech.m.g.g.d(bVar, 5 + (i5 * 3) + i6, g + (i6 * 18), h + (i5 * 18)));
            }
        }
        List<Integer> listB = bVar.getInventoryManager().b(mctech.m.e.k.c);
        for (int i7 = 0; i7 < listB.size(); i7++) {
            addSlot(new mctech.m.g.z(bVar, listB.get(i7).intValue(), aI.f, 19 + (i7 * 19)));
        }
        addPlayerInventoryAt(player.getInventory(), 35, 111);
        getComponents().clear();
        addComponent(new mctech.components.a.u(bVar, b).a(EnumSet.allOf(mctech.components.a.u.a.class)).a(() -> {
            return 160;
        }).d("gui.mctech.info.button"));
        addComponent(new C0097j(this, b).d("gui.mctech.filter.button"));
        addComponent(new mctech.components.a.H(bVar, b).d("gui.mctech.inventory.button"));
        addComponent(new C0093f(78, 87, bVar, b));
        addComponent(new C0095h(112, 94, bVar, b));
        addComponent(new mctech.components.b.a(bVar, 161, 91));
        a(e, 46, () -> {
            return Boolean.valueOf(!bVar.c());
        });
    }

    private mctech.m.g.g a(final mctech.blockentities.c.a.b bVar, int i2, int i3, int i4) {
        return new mctech.m.g.g(this, bVar, i2, i3, i4, itemStack -> {
            return itemStack.is(Items.BONE_MEAL);
        }) { // from class: mctech.m.b.C.1
            public boolean isActive() {
                return bVar.c();
            }

            @Override // mctech.m.g.g
            public boolean mayPlace(ItemStack itemStack2) {
                return isActive() && super.mayPlace(itemStack2);
            }
        };
    }

    private void a(int i2, int i3, Supplier<Boolean> supplier) {
        addComponent(new C0123q(this, a, new mctech.utils.math.geometry.b(i2 - 2, i3 - 2, 20, 20), new Vec2i(20, 20), Vec2i.ZERO, supplier) { // from class: mctech.m.b.C.2
            @Override // mctech.components.C0123q, mctech.m.d.a.a
            protected void a(Set<mctech.m.d.a.a.EnumC0027a> set) {
                set.add(mctech.m.d.a.a.EnumC0027a.DRAW_BACKGROUND);
            }
        });
    }

    @Override // mctech.components.ContainerComponent
    @OnlyIn(Dist.CLIENT)
    public void onGuiLoaded(@NotNull mctech.m.d.b bVar) {
        bVar.c(1);
        bVar.c(2);
        bVar.e(246);
        bVar.f(193);
    }

    @Override // mctech.components.ContainerComponent
    @OnlyIn(Dist.CLIENT)
    public ResourceLocation getTexture() {
        return MCTech.loc("textures/gui/container/gui_farming_station.png");
    }
}
