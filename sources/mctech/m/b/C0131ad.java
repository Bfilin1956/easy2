package mctech.m.b;

import appeng.core.definitions.AEItems;
import mctech.api.tiles.ICustomContainer;
import mctech.api.util.ILocation;
import mctech.components.AbstractC0115i;
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

/* JADX INFO: renamed from: mctech.m.b.ad, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/ad.class */
public class C0131ad extends AbstractC0115i<mctech.blockentities.c.J> implements ICustomContainer {
    private final mctech.components.a.E a;
    private final mctech.components.a.R<?> b;

    public C0131ad(mctech.blockentities.c.J j, Player player, int i) {
        super(j, player, i);
        addSlot(new mctech.a.b.e.a(j.d(), 0, 86, 40, Integer.MAX_VALUE));
        addSlot(new mctech.a.b.e.a(j.d(), 1, 128, 40, Integer.MAX_VALUE));
        addSlot(new mctech.m.g.g(j.e(), 0, 55, 80, itemStack -> {
            return itemStack.is(AEItems.BLANK_PATTERN.holder());
        }));
        addSlot(new mctech.m.g.g(j.e(), 1, 159, 80, mctech.m.c.r.c));
        addPlayerInventoryAt(player.getInventory(), 35, 111);
        this.a = new mctech.components.a.E((ILocation) getHolder());
        mctech.components.a.R<?> rA = new mctech.components.a.R(C0101n.f, 77, 83, 56, 9, new Vec2i(0, 29), new Vec2i(0, 38), new Vec2i(0, 20)).c(false).c("Закодировать шаблон").a((mctech.components.a.R.d<mctech.components.a.R<?>>) r -> {
            if (!((mctech.blockentities.c.J) getHolder()).b()) {
                ((mctech.blockentities.c.J) getHolder()).sendToServer(0, 0);
            }
        });
        this.b = rA;
        addComponent(rA);
        addComponent(this.a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a() {
        this.b.a(((mctech.blockentities.c.J) getHolder()).b() ? new Vec2i(0, 101) : new Vec2i(0, 29)).b(8L, r -> {
            if (((mctech.blockentities.c.J) getHolder()).b()) {
                ((mctech.blockentities.c.J) getHolder()).a();
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
        return ((mctech.blockentities.c.J) getHolder()).c();
    }

    @Override // mctech.components.ContainerComponent
    @OnlyIn(Dist.CLIENT)
    public void onGuiLoaded(mctech.m.d.b bVar) {
        bVar.c(1);
        bVar.c(2);
        bVar.c(4);
        bVar.e(226);
        bVar.f(192);
    }
}
