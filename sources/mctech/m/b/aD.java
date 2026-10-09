package mctech.m.b;

import java.util.EnumSet;
import java.util.List;
import java.util.Objects;
import mctech.MCTech;
import mctech.components.AbstractC0115i;
import mctech.components.a.C0093f;
import mctech.components.a.C0096i;
import mctech.components.a.C0097j;
import mctech.components.a.InterfaceC0102o;
import mctech.init.MCTechItems;
import mctech.init.MCTechLang;
import mctech.integration.emi.plugin.base.EmiMachineRegistry;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/aD.class */
public class aD extends AbstractC0115i<mctech.blockentities.c.ad> {
    private static final InterfaceC0102o a;

    static {
        MachineTier machineTier = MachineTier.T6;
        Objects.requireNonNull(machineTier);
        a = machineTier::ordinal;
    }

    public aD(mctech.blockentities.c.ad adVar, Player player, int i) {
        super(adVar, player, i);
        List<Integer> listB = adVar.getInventoryManager().b(mctech.m.e.k.g);
        for (int i2 = 0; i2 < listB.size(); i2++) {
            addSlot(new mctech.m.g.g(adVar, listB.get(i2).intValue(), 33 + (i2 * 23), 46, itemStack -> {
                return itemStack.is((Item) MCTechItems.DNA_SAMPLE.get());
            }));
        }
        int i3 = 0;
        for (int i4 = 0; i4 < 3; i4++) {
            for (int i5 = 0; i5 < 3; i5++) {
                int i6 = i3;
                i3++;
                addSlot(new mctech.m.g.r(adVar, mctech.blockentities.c.ad.b[i6], 131 + (i5 * 18), 28 + (i4 * 18)));
            }
        }
        addPlayerInventoryAt(player.getInventory(), 35, 111);
        getComponents().clear();
        addComponent(new mctech.components.a.N(107, 47, () -> {
            return Integer.valueOf((int) adVar.getProgress());
        }, () -> {
            return Integer.valueOf((int) adVar.getMaxProgress());
        }, a).a(-90.0f));
        addComponent(new C0096i(107, 47, () -> {
            EmiMachineRegistry.displayRecipes((mctech.blockentities.c.ad) getHolder());
        }).b((Component) MCTechLang.TOOLTIP_SHOW_RECIPES).a(-90.0f));
        addComponent(new mctech.components.b.o(31, 26, 68, 58, adVar, 0, 198, true, true));
        addComponent(new C0093f(78, 87, adVar, a));
        addComponent(new mctech.components.a.u(adVar, a).a(EnumSet.allOf(mctech.components.a.u.a.class)).a(() -> {
            return 160;
        }).d("gui.mctech.info.button"));
        addComponent(new C0097j(this, a).d("gui.mctech.filter.button"));
        addComponent(new mctech.components.a.H(adVar, a).d("gui.mctech.inventory.button"));
    }

    @Override // mctech.components.ContainerComponent
    @OnlyIn(Dist.CLIENT)
    public void onGuiLoaded(@NotNull mctech.m.d.b bVar) {
        bVar.c(1);
        bVar.c(2);
        bVar.e(aI.f);
        bVar.f(193);
    }

    @Override // mctech.components.ContainerComponent
    @OnlyIn(Dist.CLIENT)
    public ResourceLocation getTexture() {
        return MCTech.loc("textures/gui/container/gui_synthetic_printer.png");
    }
}
