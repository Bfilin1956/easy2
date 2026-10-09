package mctech.m.b;

import java.util.EnumSet;
import java.util.List;
import mctech.MCTech;
import mctech.api.tiles.ICustomContainer;
import mctech.blockentities.c.C0057d;
import mctech.components.AbstractC0115i;
import mctech.components.a.C0092e;
import mctech.components.a.C0093f;
import mctech.components.a.C0095h;
import mctech.components.a.C0096i;
import mctech.components.a.C0097j;
import mctech.components.a.C0099l;
import mctech.components.a.InterfaceC0102o;
import mctech.init.MCTechLang;
import mctech.integration.emi.plugin.base.EmiMachineRegistry;
import mctech.utils.math.geometry.Vec2i;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: mctech.m.b.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/h.class */
public class C0148h extends AbstractC0115i<C0057d> implements ICustomContainer {
    public C0148h(final C0057d c0057d, Player player, int i) {
        super(c0057d, player, i);
        mctech.m.c.m mVar = new mctech.m.c.m(c0057d);
        C0158r c0158r = new C0158r();
        addSlot(new mctech.m.g.g(c0057d, 0, 196, 49, mctech.m.c.r.c));
        addSlot(new mctech.m.g.g(c0057d, 1, 81, 28, mVar));
        addSlot(new mctech.m.g.g(c0057d, 2, 118, 31, mVar));
        addSlot(new mctech.m.g.g(c0057d, 3, 137, 31, mVar));
        addSlot(new mctech.m.g.g(c0057d, 4, 156, 31, mVar));
        addSlot(new mctech.m.g.g(c0057d, 5, 81, 50, mVar));
        addSlot(new mctech.m.g.g(c0057d, 6, 118, 50, mVar));
        addSlot(new mctech.m.g.g(c0057d, 7, 137, 50, mVar));
        addSlot(new mctech.m.g.g(c0057d, 8, 156, 50, mVar));
        addSlot(new mctech.m.g.g(c0057d, 9, 81, 72, mVar));
        addSlot(new mctech.m.g.g(c0057d, 10, 118, 69, mVar));
        addSlot(new mctech.m.g.g(c0057d, 11, 137, 69, mVar));
        addSlot(new mctech.m.g.g(c0057d, 12, 156, 69, mVar));
        addSlot(new mctech.m.g.g(c0057d, 13, 35, 105, c0158r));
        addSlot(new mctech.m.g.g(c0057d, 14, 58, 105, c0158r));
        addSlot(new mctech.m.g.g(c0057d, 15, 81, 105, c0158r));
        addSlot(new mctech.m.g.g(c0057d, 16, 104, 105, c0158r));
        addSlot(new mctech.m.g.g(c0057d, 17, 127, 105, c0158r));
        addSlot(new mctech.m.g.g(c0057d, 19, 150, 105, c0158r));
        addSlot(new mctech.m.g.g(c0057d, 19, 173, 105, c0158r));
        addSlot(new mctech.m.g.g(c0057d, 20, 196, 105, c0158r));
        InterfaceC0102o interfaceC0102o = () -> {
            return 5;
        };
        getComponents().clear();
        addPlayerInventoryWithOffset(player.getInventory(), 35, 77);
        addComponent(new C0093f(87, 129, c0057d, interfaceC0102o));
        addComponent(new C0095h(120, 137, c0057d, interfaceC0102o));
        addComponent(new C0096i(179, 47, () -> {
            EmiMachineRegistry.displayRecipes((C0057d) getHolder());
        }).a(-90.0f).b((Component) MCTechLang.TOOLTIP_SHOW_RECIPES));
        ResourceLocation resourceLocationLoc = MCTech.loc(String.format("textures/gui/emi/%s_emi.png", mctech.i.i.ASSEMBLY_STATION.getSerializedName()));
        addComponent(new mctech.components.M(new mctech.utils.math.geometry.b(43, 90, 162, 12), resourceLocationLoc, new Vec2i(0, 244), true, new mctech.components.M.a(this) { // from class: mctech.m.b.h.1
            @Override // mctech.components.M.a
            public float a() {
                float progress = c0057d.getProgress();
                if (progress <= c0057d.getMaxProgress() / 2.0f) {
                    return progress;
                }
                return 100.0f;
            }

            @Override // mctech.components.M.a
            public float b() {
                return c0057d.getMaxProgress() / 2.0f;
            }
        }));
        addComponent(new mctech.components.M(new mctech.utils.math.geometry.b(43, 35, 73, 58), resourceLocationLoc, new Vec2i(0, 164), false, new mctech.components.M.a(this) { // from class: mctech.m.b.h.2
            @Override // mctech.components.M.a
            public float a() {
                float progress = c0057d.getProgress();
                if (progress <= c0057d.getMaxProgress() / 2.0f) {
                    return progress;
                }
                return 100.0f;
            }

            @Override // mctech.components.M.a
            public float b() {
                return c0057d.getMaxProgress() / 2.0f;
            }
        }));
        addComponent(new mctech.components.M(new mctech.utils.math.geometry.b(177, 49, 17, 14), getTexture(), new Vec2i(0, 242), false, new mctech.components.M.a(this) { // from class: mctech.m.b.h.3
            @Override // mctech.components.M.a
            public float a() {
                float progress = c0057d.getProgress();
                float maxProgress = c0057d.getMaxProgress();
                float f = (progress - (maxProgress / 2.0f)) / (maxProgress / 2.0f);
                if (progress >= maxProgress / 2.0f) {
                    return b() * f;
                }
                return 0.0f;
            }

            @Override // mctech.components.M.a
            public float b() {
                return c0057d.getMaxProgress() / 2.0f;
            }
        }));
        addComponent(new C0092e(45, 80, interfaceC0102o).c(false).b((Component) MCTechLang.TOOLTIP_CLEAR_CONTENT).a(m -> {
            c0057d.a(0);
        }));
        addComponent(new C0092e(68, 80, interfaceC0102o).c(false).b((Component) MCTechLang.TOOLTIP_CLEAR_CONTENT).a(m2 -> {
            c0057d.a(1);
        }));
        addComponent(new C0099l(c0057d, 35, 28, 0, c0057d.b, interfaceC0102o));
        addComponent(new C0099l(c0057d, 58, 28, 1, c0057d.c, interfaceC0102o));
        addComponent(new C0097j(this, interfaceC0102o));
        addComponent(new mctech.components.a.H(c0057d, interfaceC0102o).d("gui.mctech.inventory.button"));
        addComponent(new mctech.components.a.u(c0057d, interfaceC0102o).a(EnumSet.of(mctech.components.a.u.a.ENERGY_INPUT, mctech.components.a.u.a.ENERGY_STORAGE, mctech.components.a.u.a.OPERATION_TIME, mctech.components.a.u.a.OPERATION_COST)).b((Component) MCTechLang.TOOLTIP_INFO_BUTTON));
    }

    public void initializeContents(int i, @NotNull List<ItemStack> list, @NotNull ItemStack itemStack) {
        ((C0057d) this.gui).d = true;
        super.initializeContents(i, list, itemStack);
        ((C0057d) this.gui).d = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // mctech.components.ContainerComponent
    public ResourceLocation getTexture() {
        return mctech.m.a.a(this, ((C0057d) getHolder()).machineTier());
    }

    @Override // mctech.components.ContainerComponent
    @OnlyIn(Dist.CLIENT)
    public void onGuiLoaded(mctech.m.d.b bVar) {
        bVar.c(1);
        bVar.c(2);
        bVar.e(237);
        bVar.f(243);
    }
}
