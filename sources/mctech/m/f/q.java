package mctech.m.f;

import mctech.m.b.S;
import mctech.m.b.aH;
import mctech.utils.math.geometry.Vec2i;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/f/q.class */
public abstract class q extends j {
    mctech.items.e.j.a a;

    public q(Player player, mctech.m.a.e eVar, ItemStack itemStack, Slot slot, mctech.items.e.j.a aVar) {
        super(player, eVar, itemStack, slot);
        this.a = aVar;
    }

    public static q a(Player player, mctech.m.a.e eVar, ItemStack itemStack, Slot slot, final mctech.items.e.j.a aVar) {
        return new q(player, eVar, itemStack, slot, aVar) { // from class: mctech.m.f.q.1
            @Override // mctech.m.f.j, mctech.m.a.g
            public int getSlotCount() {
                return aVar.b();
            }
        };
    }

    @Override // mctech.m.a.d
    public S createContainer(Player player, InteractionHand interactionHand, Direction direction, int i) {
        return new aH(this, player, b(), i);
    }

    @Override // mctech.m.f.j
    public void b(CompoundTag compoundTag) {
        super.b(compoundTag);
        mctech.utils.c.e.c(compoundTag, mctech.items.e.j.a, mctech.utils.c.h.a(this.f, mctech.m.c.r.p, mctech.m.c.r.q, mctech.m.c.r.l), 0);
    }

    public ResourceLocation d() {
        return this.a.g();
    }

    public int e() {
        return this.a.f();
    }

    public int f() {
        return this.a.c();
    }

    public mctech.m.c.g g() {
        return this.a.h();
    }

    public Vec2i h() {
        return this.a.e();
    }
}
