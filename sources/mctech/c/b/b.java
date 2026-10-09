package mctech.c.b;

import mctech.MCTech;
import mctech.c.g;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/c/b/b.class */
public class b implements d {
    Player a;
    InteractionHand b;
    g c;

    public b(Player player) {
        this.a = player;
    }

    @Override // mctech.c.b.d
    public void a() {
        boolean zIsUsingItem = this.a.isUsingItem();
        if (zIsUsingItem == (this.b == null)) {
            if (!zIsUsingItem) {
                this.b = null;
                if (this.c != null) {
                    this.c.l();
                    this.c = null;
                    return;
                }
                return;
            }
            this.a.getUsedItemHand();
            this.b = this.a.getUsedItemHand();
            if (this.c != null) {
                this.c.l();
                this.c = null;
            }
            ItemStack itemInHand = this.a.getItemInHand(this.b);
            mctech.items.base.a.e item = itemInHand.getItem();
            if (item instanceof mctech.items.base.a.e) {
                mctech.items.base.a.e eVar = item;
                if (!eVar.a(itemInHand)) {
                    return;
                }
                this.c = MCTech.AUDIO.a(this.a, eVar.b(itemInHand), mctech.c.b.a.ITEM, 4.0f, true, true);
                if (this.c != null) {
                    this.c.i();
                }
            }
        }
    }

    @Override // mctech.c.b.d
    public boolean a(Level level) {
        return this.a.isAlive() && this.a.getCommandSenderWorld() == level;
    }
}
