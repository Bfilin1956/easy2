package mctech.m.b;

import appeng.core.definitions.AEItems;
import mctech.api.tiles.ICustomContainer;
import mctech.api.util.ILocation;
import mctech.components.AbstractC0115i;
import mctech.components.a.C0097j;
import mctech.components.a.C0101n;
import mctech.utils.math.geometry.Vec2i;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ClickType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: mctech.m.b.ac, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/ac.class */
public class C0130ac extends AbstractC0115i<mctech.blockentities.c.I> implements ICustomContainer {
    private final mctech.components.a.E a;
    private final mctech.components.a.R<?> b;

    public C0130ac(mctech.blockentities.c.I i, Player player, int i2) {
        super(i, player, i2);
        for (int i3 = 0; i3 < 7; i3++) {
            for (int i4 = 0; i4 < 7; i4++) {
                addSlot(new mctech.a.b.e.a(i.d(), (i4 * 7) + i3, 57 + (i3 * 18), 24 + (i4 * 18)));
            }
        }
        addSlot(new mctech.a.b.e.a(i.d(), 49, 204, 79));
        addSlot(new mctech.m.g.g(i.e(), 0, 27, 48, itemStack -> {
            return itemStack.is(AEItems.BLANK_PATTERN.holder());
        }));
        addSlot(new mctech.m.g.g(i.e(), 1, 27, 106, mctech.m.c.r.c));
        addPlayerInventoryAt(player.getInventory(), 41, mctech.o.i.e);
        this.a = new mctech.components.a.E((ILocation) getHolder(), 185, 143);
        this.b = new mctech.components.a.R(C0101n.g, 25, 78, 20, 17, new Vec2i(20, 47), new Vec2i(0, 65), new Vec2i(0, 47)).c(false).c("Закодировать шаблон").a(r -> {
            if (!((mctech.blockentities.c.I) getHolder()).b()) {
                ((mctech.blockentities.c.I) getHolder()).sendToServer(0, 0);
            }
        });
        addComponent(new C0097j(this, 0, 31, () -> {
            return 3;
        }));
        addComponent(this.b);
        addComponent(this.a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a() {
        this.b.a(((mctech.blockentities.c.I) getHolder()).b() ? new Vec2i(0, 83) : new Vec2i(0, 65)).b(8L, r -> {
            if (((mctech.blockentities.c.I) getHolder()).b()) {
                ((mctech.blockentities.c.I) getHolder()).a();
                this.b.a(new Vec2i(0, 65));
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
        return ((mctech.blockentities.c.I) getHolder()).c();
    }

    @Override // mctech.components.ContainerComponent
    @OnlyIn(Dist.CLIENT)
    public void onGuiLoaded(mctech.m.d.b bVar) {
        bVar.c(1);
        bVar.c(2);
        bVar.c(4);
        bVar.e(233);
        bVar.f(248);
    }
}
