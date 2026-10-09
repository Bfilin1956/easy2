package mctech.m.b;

import java.util.function.BooleanSupplier;
import mctech.MCTech;
import mctech.m.a.d;
import mctech.utils.math.geometry.Vec2i;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;

/* JADX INFO: renamed from: mctech.m.b.t, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/t.class */
public abstract class AbstractC0160t<T extends mctech.m.a.d> extends S {
    protected T gui;
    private Player player;
    protected boolean curioAdded;
    public boolean cosmeticCurio;
    protected boolean addingCurio;
    private Vec2i curioPos;
    private int scrollOffset;

    public AbstractC0160t(T t, Player player, int i) {
        super(i);
        this.cosmeticCurio = false;
        this.addingCurio = false;
        this.gui = t;
        this.player = player;
    }

    public boolean stillValid(Player player) {
        return this.gui.c(player);
    }

    public void removed(Player player) {
        this.gui.a_(player);
        super.removed(player);
    }

    public T getHolder() {
        return this.gui;
    }

    public Player getPlayer() {
        return this.player;
    }

    protected void addCurioSlots() {
        addCurioSlots(new Vec2i());
    }

    protected void addCurioSlots(Vec2i vec2i) {
        addCurioSlots(new Vec2i(), vec2i);
    }

    protected void addCurioSlots(Vec2i vec2i, Vec2i vec2i2) {
        if (MCTech.CURIO_PLUGIN == null) {
            return;
        }
        this.curioPos = vec2i;
        this.addingCurio = true;
        this.curioAdded = MCTech.CURIO_PLUGIN.a(this, this.player, vec2i, vec2i2, 0, false);
        this.addingCurio = false;
    }

    public void addCurioSlots(Slot slot) {
        if (MCTech.CURIO_PLUGIN == null || !this.addingCurio) {
            return;
        }
        addSlot(slot);
    }

    public void setCurioOffset(int i) {
        if (!this.curioAdded || this.scrollOffset == i) {
            return;
        }
        this.scrollOffset = i;
        this.cosmeticCurio = false;
        this.addingCurio = true;
        MCTech.CURIO_PLUGIN.a(this, this.player, this.curioPos, new Vec2i(0, 0), i, true);
        this.addingCurio = false;
    }

    protected void addInternalSlots(Inventory inventory) {
    }

    public void addHiddenPlayerInventory(Inventory inventory) {
        addInternalSlots(inventory);
        for (int i = 0; i < 36; i++) {
            addSlot(new mctech.m.g.k(inventory, i));
        }
    }

    public void addLockablePlayerInventory(Inventory inventory, BooleanSupplier booleanSupplier) {
        addInternalSlots(inventory);
        for (int i = 0; i < 3; i++) {
            for (int i2 = 0; i2 < 9; i2++) {
                addSlot(new mctech.m.g.p(inventory, i2 + (i * 9) + 9, 8 + (i2 * 18), 84 + (i * 18), booleanSupplier));
            }
        }
        for (int i3 = 0; i3 < 9; i3++) {
            addSlot(new mctech.m.g.p(inventory, i3, 8 + (i3 * 18), 142, booleanSupplier));
        }
    }

    public void addLockablePlayerInventoryWithOffset(Inventory inventory, int i, int i2, BooleanSupplier booleanSupplier) {
        addInternalSlots(inventory);
        for (int i3 = 0; i3 < 3; i3++) {
            for (int i4 = 0; i4 < 9; i4++) {
                addSlot(new mctech.m.g.p(inventory, i4 + (i3 * 9) + 9, i + 8 + (i4 * 18), i2 + 84 + (i3 * 18), booleanSupplier));
            }
        }
        for (int i5 = 0; i5 < 9; i5++) {
            addSlot(new mctech.m.g.p(inventory, i5, i + 8 + (i5 * 18), 142 + i2, booleanSupplier));
        }
    }

    public void addPlayerInventory(Inventory inventory) {
        addInternalSlots(inventory);
        for (int i = 0; i < 3; i++) {
            for (int i2 = 0; i2 < 9; i2++) {
                addSlot(new Slot(inventory, i2 + (i * 9) + 9, 8 + (i2 * 18), 84 + (i * 18)));
            }
        }
        for (int i3 = 0; i3 < 9; i3++) {
            addSlot(new Slot(inventory, i3, 8 + (i3 * 18), 142));
        }
    }

    public void addPlayerInventoryWithOffset(Inventory inventory, int i, int i2) {
        addInternalSlots(inventory);
        for (int i3 = 0; i3 < 3; i3++) {
            for (int i4 = 0; i4 < 9; i4++) {
                addSlot(new Slot(inventory, i4 + (i3 * 9) + 9, i + 8 + (i4 * 18), i2 + 84 + (i3 * 18)));
            }
        }
        for (int i5 = 0; i5 < 9; i5++) {
            addSlot(new Slot(inventory, i5, i + 8 + (i5 * 18), 142 + i2));
        }
    }

    public void addPlayerInventoryAt(Inventory inventory, int i, int i2) {
        addInternalSlots(inventory);
        for (int i3 = 0; i3 < 3; i3++) {
            for (int i4 = 0; i4 < 9; i4++) {
                addSlot(new Slot(inventory, i4 + (i3 * 9) + 9, i + (i4 * 18), i2 + (i3 * 18)));
            }
        }
        for (int i5 = 0; i5 < 9; i5++) {
            addSlot(new Slot(inventory, i5, i + (i5 * 18), 58 + i2));
        }
    }
}
