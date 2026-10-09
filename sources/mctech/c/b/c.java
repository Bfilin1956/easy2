package mctech.c.b;

import mctech.MCTech;
import mctech.api.items.electric.ElectricItem;
import mctech.c.g;
import mctech.init.MCTechSounds;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/c/b/c.class */
public class c implements d {
    Player a;
    byte b = 0;
    g c;
    Item d;

    public c(Player player, Item item) {
        this.a = player;
        this.d = item;
    }

    @Override // mctech.c.b.d
    public void a() {
        if (this.b == 0) {
            ItemStack mainHandItem = this.a.getMainHandItem();
            if (mainHandItem.is(this.d) && a(mainHandItem)) {
                this.b = (byte) 1;
                this.c = MCTech.AUDIO.a(this.a, MCTechSounds.TOOL_CHAINSAW_IDLE, mctech.c.b.a.ITEM, 1.0f, true, false);
                if (this.c != null) {
                    this.c.i();
                    return;
                }
                return;
            }
            ItemStack offhandItem = this.a.getOffhandItem();
            if (offhandItem.is(this.d) && a(offhandItem)) {
                this.b = (byte) 2;
                this.c = MCTech.AUDIO.a(this.a, MCTechSounds.TOOL_CHAINSAW_IDLE, mctech.c.b.a.ITEM, 1.0f, true, false);
                if (this.c != null) {
                    this.c.i();
                    return;
                }
                return;
            }
            return;
        }
        ItemStack itemInHand = this.a.getItemInHand(this.b == 1 ? InteractionHand.MAIN_HAND : InteractionHand.OFF_HAND);
        if (!itemInHand.is(this.d) || !a(itemInHand)) {
            this.b = (byte) 0;
            if (this.c != null) {
                this.c.l();
                this.c = null;
            }
            MCTech.AUDIO.a(this.a, MCTechSounds.TOOL_CHAINSAW_STOP, mctech.c.b.a.ITEM, 1.0f, 1.0f);
        }
        if (this.c != null && !this.c.a()) {
            this.c = null;
            this.b = (byte) 0;
        }
    }

    @Override // mctech.c.b.d
    public boolean a(Level level) {
        return this.a.getCommandSenderWorld() == level && this.a.isAlive();
    }

    private boolean a(ItemStack itemStack) {
        return ElectricItem.MANAGER.getCharge(itemStack) > 0;
    }
}
