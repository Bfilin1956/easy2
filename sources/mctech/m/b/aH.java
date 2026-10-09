package mctech.m.b;

import mctech.utils.math.geometry.Vec2i;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/aH.class */
public class aH extends P<mctech.m.f.q> {
    public static final Vec2i b = new Vec2i(0, -11);

    public aH(mctech.m.f.q qVar, Player player, int i, int i2) {
        super(qVar, player, i, i2);
        int iF = qVar.f();
        int iE = qVar.e();
        for (int i3 = 0; i3 < qVar.getSlotCount(); i3++) {
            addSlot(new mctech.m.g.g(qVar, i3, iE + (18 * (i3 % iF)), 18 + (18 * (i3 / iF)), qVar.g()));
        }
        Vec2i vec2iH = qVar.h();
        addPlayerInventoryWithOffset(player.getInventory(), vec2iH.getX(), vec2iH.getY());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // mctech.components.ContainerComponent
    public ResourceLocation getTexture() {
        return ((mctech.m.f.q) getHolder()).d();
    }

    @Override // mctech.components.ContainerComponent
    public Vec2i getPreviewButtonOffset() {
        return b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // mctech.components.ContainerComponent
    @OnlyIn(Dist.CLIENT)
    public void onGuiLoaded(mctech.m.d.b bVar) {
        Vec2i vec2iH = ((mctech.m.f.q) getHolder()).h();
        bVar.d(vec2iH.getX(), vec2iH.getY());
    }
}
