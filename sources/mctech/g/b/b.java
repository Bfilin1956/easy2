package mctech.g.b;

import java.util.ArrayList;
import java.util.List;
import mctech.g.b.a.a.a.l;
import mctech.g.b.a.a.k;
import mctech.g.b.a.a.m;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.network.PacketDistributor;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/b/b.class */
public abstract class b extends AbstractContainerMenu {
    private final Inventory b;
    protected static final int a = 36;
    private static final EquipmentSlot[] c = {EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET};
    private final List<m> d;
    private final List<m> e;

    protected b(@Nullable MenuType<?> menuType, int i, Inventory inventory) {
        super(menuType, i);
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.b = inventory;
    }

    protected Inventory a() {
        return this.b;
    }

    protected void a(int i, int i2) {
        b(i, i2);
        c(i, i2 + 58);
    }

    protected void b(int i, int i2) {
        for (int i3 = 0; i3 < 3; i3++) {
            for (int i4 = 0; i4 < 9; i4++) {
                addSlot(a(a(), i4 + (i3 * 9) + 9, i + (i4 * 18), i2 + (i3 * 18)));
            }
        }
    }

    protected void c(int i, int i2) {
        for (int i3 = 0; i3 < 9; i3++) {
            addSlot(a(a(), i3, i + (i3 * 18), i2));
        }
    }

    protected Slot a(Inventory inventory, int i, int i2, int i3) {
        return new Slot(inventory, i, i2, i3);
    }

    protected <T extends m> T a(T t) {
        this.d.add(t);
        return t;
    }

    protected <T extends m> T b(T t) {
        this.d.add(t);
        this.e.add(t);
        return t;
    }

    protected <T extends mctech.g.b.a.a.d> T a(T t) {
        this.d.addAll(t.a());
        this.e.addAll(t.b());
        return t;
    }

    protected void c(m mVar) {
        if (!this.e.contains(mVar)) {
            throw new IllegalArgumentException("This slot is not client updatable!");
        }
        if (this.b.player instanceof LocalPlayer) {
            short sIndexOf = (short) this.e.indexOf(mVar);
            if (mVar.c() != m.a.NONE) {
                PacketDistributor.sendToServer(new k(this.containerId, sIndexOf, mVar.a(this.b.player.level(), m.a.FULL)), new CustomPacketPayload[0]);
            }
        }
    }

    public void a(short s, l lVar) {
        if (s >= 0 && s < this.d.size()) {
            this.d.get(s).a(this.b.player.level(), lVar);
        }
    }

    public void b(short s, l lVar) {
        if (s >= 0 && s < this.e.size()) {
            this.e.get(s).a(this.b.player.level(), lVar);
        }
    }

    public void broadcastChanges() {
        super.broadcastChanges();
        ServerPlayer serverPlayer = this.b.player;
        if (serverPlayer instanceof ServerPlayer) {
            ServerPlayer serverPlayer2 = serverPlayer;
            ArrayList arrayList = new ArrayList();
            Level level = serverPlayer2.level();
            short s = 0;
            while (true) {
                short s2 = s;
                if (s2 >= this.d.size()) {
                    break;
                }
                m mVar = this.d.get(s2);
                if (mVar.c() != m.a.NONE) {
                    arrayList.add(new mctech.g.b.a.a.c.a(s2, mVar.a(level, m.a.FULL)));
                }
                s = (short) (s2 + 1);
            }
            if (!arrayList.isEmpty()) {
                PacketDistributor.sendToPlayer(serverPlayer2, new mctech.g.b.a.a.c(this.containerId, arrayList), new CustomPacketPayload[0]);
            }
        }
    }

    public void sendAllDataToRemote() {
        super.sendAllDataToRemote();
        ServerPlayer serverPlayer = this.b.player;
        if (serverPlayer instanceof ServerPlayer) {
            ServerPlayer serverPlayer2 = serverPlayer;
            ArrayList arrayList = new ArrayList();
            Level level = serverPlayer2.level();
            short s = 0;
            while (true) {
                short s2 = s;
                if (s2 >= this.d.size()) {
                    break;
                }
                m mVar = this.d.get(s2);
                mVar.c();
                arrayList.add(new mctech.g.b.a.a.c.a(s2, mVar.a(level, m.a.FULL)));
                s = (short) (s2 + 1);
            }
            if (!arrayList.isEmpty()) {
                PacketDistributor.sendToPlayer(serverPlayer2, new mctech.g.b.a.a.c(this.containerId, arrayList), new CustomPacketPayload[0]);
            }
        }
    }
}
