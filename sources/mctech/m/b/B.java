package mctech.m.b;

import java.util.EnumSet;
import java.util.List;
import java.util.Objects;
import mctech.api.tiles.ICustomContainer;
import mctech.api.tiles.readers.IProgressMachine;
import mctech.components.AbstractC0115i;
import mctech.components.a.C0089b;
import mctech.components.a.C0093f;
import mctech.components.a.C0095h;
import mctech.components.a.C0096i;
import mctech.components.a.C0097j;
import mctech.components.a.C0101n;
import mctech.init.MCTechLang;
import mctech.integration.emi.plugin.base.EmiMachineRegistry;
import mctech.utils.math.geometry.Vec2i;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.ChatFormatting;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/B.class */
public class B extends AbstractC0115i<mctech.processing.b> implements ICustomContainer {
    public B(mctech.processing.b bVar, Player player, int i) {
        super(bVar, player, i);
        MachineTier machineTier = bVar.machineTier();
        switch (AnonymousClass5.a[machineTier.ordinal()]) {
            case 1:
            case 2:
                a(bVar, 0, 92, 40);
                Objects.requireNonNull(machineTier);
                addComponent(new C0093f(85, 78, bVar, machineTier::ordinal));
                Objects.requireNonNull(machineTier);
                addComponent(new C0095h(119, 86, bVar, machineTier::ordinal));
                addPlayerInventoryAt(player.getInventory(), 42, 110);
                break;
            case 3:
                a(bVar, 0, 92, 27);
                a(bVar, 1, 92, 53);
                Objects.requireNonNull(machineTier);
                addComponent(new C0093f(85, 78, bVar, machineTier::ordinal));
                Objects.requireNonNull(machineTier);
                addComponent(new C0095h(119, 86, bVar, machineTier::ordinal));
                addPlayerInventoryAt(player.getInventory(), 42, 110);
                break;
            case 4:
                a(bVar, 0, 92, 27);
                a(bVar, 1, 92, 53);
                a(bVar, 2, 92, 79);
                Objects.requireNonNull(machineTier);
                addComponent(new C0093f(85, 103, bVar, machineTier::ordinal));
                Objects.requireNonNull(machineTier);
                addComponent(new C0095h(119, 111, bVar, machineTier::ordinal));
                addPlayerInventoryAt(player.getInventory(), 42, 135);
                break;
            case 5:
                b(bVar, 0, 62, 27);
                b(bVar, 1, 88, 27);
                b(bVar, 2, 114, 27);
                b(bVar, 3, 140, 27);
                b(bVar, 4, mctech.o.i.e, 27);
                Objects.requireNonNull(machineTier);
                addComponent(new C0093f(85, 95, bVar, machineTier::ordinal));
                Objects.requireNonNull(machineTier);
                addComponent(new C0095h(119, 103, bVar, machineTier::ordinal));
                addPlayerInventoryAt(player.getInventory(), 42, 127);
                break;
            case 6:
                b(bVar, 0, 22, 27);
                b(bVar, 1, 45, 27);
                b(bVar, 2, 68, 27);
                b(bVar, 3, 91, 27);
                b(bVar, 4, 114, 27);
                b(bVar, 5, 137, 27);
                b(bVar, 6, 160, 27);
                b(bVar, 7, 183, 27);
                b(bVar, 8, 206, 27);
                Objects.requireNonNull(machineTier);
                addComponent(new C0093f(85, 95, bVar, machineTier::ordinal));
                Objects.requireNonNull(machineTier);
                addComponent(new C0095h(119, 103, bVar, machineTier::ordinal));
                addPlayerInventoryAt(player.getInventory(), 42, 127);
                break;
        }
        if (machineTier.isAtLeast(MachineTier.T3)) {
            List<Integer> listB = bVar.getInventoryManager().b(mctech.m.e.k.c);
            for (int i2 = 0; i2 < listB.size(); i2++) {
                addSlot(new mctech.m.g.z(bVar, listB.get(i2).intValue(), 234, 19 + (i2 * 19)));
            }
        }
        if (machineTier.isAtLeast(MachineTier.T5)) {
            Objects.requireNonNull(bVar);
            addComponent(new C0089b(bVar::d).a(p -> {
                bVar.sendToServer(0, 0);
            }).b((Component) Component.empty().append(MCTechLang.TOOLTIP_AUTO_SORT).append(Component.empty().append(MCTechLang.GUI_YES).withStyle(ChatFormatting.GREEN))).a((Component) Component.empty().append(MCTechLang.TOOLTIP_AUTO_SORT).append(Component.empty().append(MCTechLang.GUI_NO).withStyle(ChatFormatting.RED))));
        }
        Objects.requireNonNull(machineTier);
        addComponent(new C0097j(this, machineTier::ordinal));
        Objects.requireNonNull(machineTier);
        addComponent(new mctech.components.a.H(bVar, machineTier::ordinal).d("gui.mctech.inventory.button"));
        Objects.requireNonNull(machineTier);
        addComponent(new mctech.components.a.u(bVar, machineTier::ordinal).a(EnumSet.of(mctech.components.a.u.a.ENERGY_INPUT, mctech.components.a.u.a.ENERGY_STORAGE, mctech.components.a.u.a.OPERATION_TIME, mctech.components.a.u.a.OPERATION_COST)).b((Component) MCTechLang.TOOLTIP_INFO_BUTTON));
    }

    /* JADX INFO: renamed from: mctech.m.b.B$5, reason: invalid class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/B$5.class */
    static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] a = new int[MachineTier.values().length];

        static {
            try {
                a[MachineTier.T2.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[MachineTier.T3.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[MachineTier.T4.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[MachineTier.T5.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                a[MachineTier.T6.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                a[MachineTier.T7.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    private void a(final mctech.processing.b bVar, final int i, int i2, int i3) {
        addSlot(new mctech.m.g.g(bVar, i * 2, i2, i3, new mctech.m.c.m<mctech.processing.b>(this, bVar) { // from class: mctech.m.b.B.1
            @Override // mctech.m.c.m, mctech.m.c.g
            public boolean matches(ItemStack itemStack) {
                if (itemStack.isEmpty()) {
                    return false;
                }
                return BuiltInRegistries.ITEM.getKey(itemStack.getItem()).getPath().matches("bee_cage") || super.matches(itemStack);
            }
        }));
        addSlot(new mctech.m.g.B(bVar, (i * 2) + 1, i2 + 44, i3));
        addComponent(new mctech.components.b.o(i2 + 21, i3 + 1, 20, 14, new IProgressMachine(this) { // from class: mctech.m.b.B.2
            @Override // mctech.api.tiles.readers.IProgressMachine
            public float getProgress() {
                return bVar.getProgressSlot(i);
            }

            @Override // mctech.api.tiles.readers.IProgressMachine
            public float getMaxProgress() {
                return bVar.getMaxProgressSlot(i);
            }
        }, bVar.machineTier().ordinal() * 20, 14).a(C0101n.i.a()).b(false));
        addComponent(new C0096i(C0101n.i, i2 + 21, i3 + 1, 20, 14, () -> {
            EmiMachineRegistry.displayRecipes("extractor");
        }).b(new Vec2i(aI.f, 14)).g(2));
    }

    private void b(final mctech.processing.b bVar, final int i, int i2, int i3) {
        addSlot(new mctech.m.g.g(bVar, i * 2, i2, i3, new mctech.m.c.m<mctech.processing.b>(this, bVar) { // from class: mctech.m.b.B.3
            @Override // mctech.m.c.m, mctech.m.c.g
            public boolean matches(ItemStack itemStack) {
                if (itemStack.isEmpty()) {
                    return false;
                }
                return BuiltInRegistries.ITEM.getKey(itemStack.getItem()).getPath().matches("bee_cage") || super.matches(itemStack);
            }
        }));
        addSlot(new mctech.m.g.B(bVar, (i * 2) + 1, i2, i3 + 44));
        addComponent(new mctech.components.b.o(i2 - 2, i3 + 23, 20, 14, new IProgressMachine(this) { // from class: mctech.m.b.B.4
            @Override // mctech.api.tiles.readers.IProgressMachine
            public float getProgress() {
                return bVar.getProgressSlot(i);
            }

            @Override // mctech.api.tiles.readers.IProgressMachine
            public float getMaxProgress() {
                return bVar.getMaxProgressSlot(i);
            }
        }, bVar.machineTier().ordinal() * 20, 14).a(C0101n.i.a()).b(false).c(90));
        addComponent(new C0096i(C0101n.i, i2 - 2, i3 + 23, 20, 14, () -> {
            EmiMachineRegistry.displayRecipes("extractor");
        }).b(new Vec2i(aI.f, 14)).a(90.0f).g(2));
    }

    private void a(int i, int i2) {
        addComponent(new C0096i(i + 2, i2 - 2, () -> {
            EmiMachineRegistry.displayRecipes((mctech.processing.b) getHolder());
        }).b((Component) MCTechLang.TOOLTIP_SHOW_RECIPES).a(-90.0f));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // mctech.components.ContainerComponent
    public ResourceLocation getTexture() {
        return mctech.m.a.a(this, ((mctech.processing.b) getHolder()).machineTier(), "extractor");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // mctech.components.ContainerComponent
    @OnlyIn(Dist.CLIENT)
    public void onGuiLoaded(mctech.m.d.b bVar) {
        bVar.c(1);
        bVar.c(2);
        bVar.e(252);
        switch (AnonymousClass5.a[((mctech.processing.b) getHolder()).machineTier().ordinal()]) {
            case 1:
            case 2:
            case 3:
                bVar.f(192);
                break;
            case 4:
                bVar.f(215);
                break;
            case 5:
            case 6:
                bVar.f(mctech.g.c.a.d.e);
                break;
        }
    }
}
