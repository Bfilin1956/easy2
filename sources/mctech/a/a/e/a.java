package mctech.a.a.e;

import appeng.api.networking.IGridNode;
import appeng.menu.guisync.GuiSync;
import appeng.menu.implementations.MenuTypeBuilder;
import appeng.menu.implementations.UpgradeableMenu;
import com.glodblock.github.extendedae.common.me.wireless.WirelessStatus;
import mctech.MCTech;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.MenuType;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/a/a/e/a.class */
public class a extends UpgradeableMenu<mctech.a.a.a.a> {
    public static final MenuType<a> a = MenuTypeBuilder.create(a::new, mctech.a.a.a.a.class).buildUnregistered(MCTech.loc("wireless_connector_ex"));

    @GuiSync(7)
    public double b;

    @GuiSync(8)
    public int c;

    @GuiSync(9)
    public int d;

    @GuiSync(10)
    public long e;

    @GuiSync(11)
    public WirelessStatus f;

    public a(int i, Inventory inventory, mctech.a.a.a.a aVar) {
        super(a, i, inventory, aVar);
        this.f = WirelessStatus.REMOTE_ERROR;
    }

    public void broadcastChanges() {
        this.b = ((mctech.a.a.a.a) getHost()).c();
        IGridNode node = ((mctech.a.a.a.a) getHost()).getMainNode().getNode();
        if (node != null) {
            this.c = node.getUsedChannels();
            this.d = node.getMaxChannels();
        } else {
            this.c = 0;
            this.d = 0;
        }
        BlockPos blockPosD = ((mctech.a.a.a.a) getHost()).d();
        if (blockPosD == null) {
            this.e = 0L;
            this.f = ((mctech.a.a.a.a) getHost()).getFrequency() == 0 ? WirelessStatus.UNCONNECTED : WirelessStatus.REMOTE_ERROR;
        } else {
            this.e = blockPosD.asLong();
            this.f = WirelessStatus.WORKING;
        }
        if (!((mctech.a.a.a.a) getHost()).getMainNode().isPowered() && this.f == WirelessStatus.WORKING) {
            this.f = WirelessStatus.NO_POWER;
        }
        super.broadcastChanges();
    }
}
