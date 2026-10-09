package mctech.m.b;

import appeng.core.definitions.AEItems;
import mctech.api.tiles.ICustomContainer;
import mctech.api.util.ILocation;
import mctech.components.AbstractC0115i;
import mctech.components.C0110d;
import mctech.components.a.C0091d;
import mctech.components.a.C0097j;
import mctech.components.a.C0101n;
import mctech.components.a.InterfaceC0102o;
import mctech.utils.math.geometry.Vec2i;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ClickType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: mctech.m.b.aa, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/aa.class */
public class C0128aa extends AbstractC0115i<mctech.blockentities.c.G> implements ICustomContainer {
    private final mctech.components.a.E a;
    private final mctech.components.a.R<?> b;

    public C0128aa(mctech.blockentities.c.G g, Player player, int i) {
        super(g, player, i);
        addSlot(new mctech.a.b.e.a(g.d(), 0, 180, 47));
        addSlot(new mctech.a.b.e.a(g.d(), 1, 81, 27));
        addSlot(new mctech.a.b.e.a(g.d(), 2, 100, 27));
        addSlot(new mctech.a.b.e.a(g.d(), 3, 119, 27));
        addSlot(new mctech.a.b.e.a(g.d(), 4, 138, 27));
        addSlot(new mctech.a.b.e.a(g.d(), 5, 81, 46));
        addSlot(new mctech.a.b.e.a(g.d(), 6, 100, 46));
        addSlot(new mctech.a.b.e.a(g.d(), 7, 119, 46));
        addSlot(new mctech.a.b.e.a(g.d(), 8, 138, 46));
        addSlot(new mctech.a.b.e.a(g.d(), 9, 81, 65));
        addSlot(new mctech.a.b.e.a(g.d(), 10, 100, 65));
        addSlot(new mctech.a.b.e.a(g.d(), 11, 119, 65));
        addSlot(new mctech.a.b.e.a(g.d(), 12, 138, 65));
        addSlot(new mctech.a.b.e.a(g.d(), 13, 25, 90));
        addSlot(new mctech.a.b.e.a(g.d(), 14, 48, 90));
        addSlot(new mctech.a.b.e.a(g.d(), 15, 71, 90));
        addSlot(new mctech.a.b.e.a(g.d(), 16, 94, 90));
        addSlot(new mctech.a.b.e.a(g.d(), 17, 117, 90));
        addSlot(new mctech.a.b.e.a(g.d(), 19, 140, 90));
        addSlot(new mctech.a.b.e.a(g.d(), 19, 163, 90));
        addSlot(new mctech.a.b.e.a(g.d(), 20, 186, 90));
        addSlot(new mctech.m.g.g(g.e(), 0, 54, 114, itemStack -> {
            return itemStack.is(AEItems.BLANK_PATTERN.holder());
        }));
        addSlot(new mctech.m.g.g(g.e(), 1, 158, 114, mctech.m.c.r.c));
        addPlayerInventoryAt(player.getInventory(), 34, 145);
        InterfaceC0102o interfaceC0102o = () -> {
            return 5;
        };
        this.a = new mctech.components.a.E((ILocation) getHolder());
        addComponent(new C0110d(C0101n.f.a(), new mctech.utils.math.geometry.b(48, 4, 132, 11), new Vec2i(132, 11), new Vec2i(83, 0)).a(false));
        addComponent(new C0110d(mctech.a.b.b.f.ASSEMBLY_STATION.b(), new mctech.utils.math.geometry.b(17, 21, 194, 90), new Vec2i(194, 90), new Vec2i(0, 0)));
        addComponent(new C0097j(this, 1, 17, interfaceC0102o));
        mctech.components.a.R<?> rA = new mctech.components.a.R(C0101n.f, 76, 117, 56, 9, new Vec2i(0, 29), new Vec2i(0, 38), new Vec2i(0, 20)).c(false).c("Закодировать шаблон").a((mctech.components.a.R.d<mctech.components.a.R<?>>) r -> {
            if (!((mctech.blockentities.c.G) getHolder()).b()) {
                ((mctech.blockentities.c.G) getHolder()).sendToServer(0, 0);
            }
        });
        this.b = rA;
        addComponent(rA);
        addComponent(this.a);
        addComponent(new C0091d(32, 23, 0, ((mctech.blockentities.c.G) getHolder()).d, interfaceC0102o));
        addComponent(new C0091d(55, 23, 1, ((mctech.blockentities.c.G) getHolder()).e, interfaceC0102o));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a() {
        this.b.a(((mctech.blockentities.c.G) getHolder()).b() ? new Vec2i(0, 101) : new Vec2i(0, 29)).b(8L, r -> {
            if (((mctech.blockentities.c.G) getHolder()).b()) {
                ((mctech.blockentities.c.G) getHolder()).a();
                this.b.a(new Vec2i(0, 29));
            }
        });
    }

    public void doClick(int i, int i2, @NotNull ClickType clickType, @NotNull Player player) {
        if (i >= 0) {
            if ((clickType == ClickType.CLONE || i2 == 2) && (getSlot(i) instanceof mctech.a.b.e.a)) {
                this.a.a(getSlot(i));
                return;
            } else if (i2 == 1 && (getSlot(i) instanceof mctech.a.b.e.a)) {
                getSlot(i).set(ItemStack.EMPTY);
                this.a.h();
                return;
            }
        }
        super.doClick(i, i2, clickType, player);
    }

    @Override // mctech.m.b.S
    public boolean canDragTo(Slot slot) {
        if (slot instanceof mctech.a.b.e.a) {
            return false;
        }
        return super.canDragTo(slot);
    }

    @Override // mctech.m.b.S
    @NotNull
    public ItemStack quickMoveStack(@NotNull Player player, int i) {
        if (getSlot(i) instanceof mctech.a.b.e.a) {
            return ItemStack.EMPTY;
        }
        return super.quickMoveStack(player, i);
    }

    public boolean canTakeItemForPickAll(@NotNull ItemStack itemStack, @NotNull Slot slot) {
        if (slot instanceof mctech.a.b.e.a) {
            return false;
        }
        return super.canTakeItemForPickAll(itemStack, slot);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // mctech.components.ContainerComponent
    public ResourceLocation getTexture() {
        return ((mctech.blockentities.c.G) getHolder()).c();
    }

    @Override // mctech.components.ContainerComponent
    @OnlyIn(Dist.CLIENT)
    public void onGuiLoaded(mctech.m.d.b bVar) {
        bVar.c(1);
        bVar.c(2);
        bVar.c(4);
        bVar.e(218);
        bVar.f(227);
    }
}
