package mctech.m.b;

import java.util.Objects;
import java.util.function.Supplier;
import mctech.api.tiles.ICustomContainer;
import mctech.components.AbstractC0115i;
import mctech.utils.math.geometry.Vec2i;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/ar.class */
public class ar extends AbstractC0115i<mctech.blockentities.c.U> implements ICustomContainer {
    public ar(mctech.blockentities.c.U u, Player player, int i) {
        super(u, player, i);
        MachineTier machineTier = u.machineTier();
        addSlot(new mctech.m.g.v(this, u, 0, 103, 40, mctech.m.c.r.c) { // from class: mctech.m.b.ar.1
            @Override // mctech.m.g.v, mctech.m.a.j
            public int o() {
                return 22;
            }
        });
        addPlayerInventoryAt(player.getInventory(), 35, 111);
        getComponents().clear();
        Objects.requireNonNull(machineTier);
        addComponent(new mctech.components.a.H(u, machineTier::ordinal).d("gui.mctech.inventory.button"));
        Supplier supplier = () -> {
            return Integer.valueOf((int) u.getProgress());
        };
        Supplier supplier2 = () -> {
            return Integer.valueOf((int) u.getMaxProgress());
        };
        Objects.requireNonNull(machineTier);
        addComponent(new mctech.components.a.O(79, 84, supplier, supplier2, machineTier::ordinal).b(() -> {
            return new Vec2i(72, 5);
        }));
        addComponent(new mctech.components.a.w(new mctech.utils.math.geometry.b(115, 92, 0, 0), 0.5f, () -> {
            return Math.round((100.0f * u.getProgress()) / Math.max(1.0f, u.getMaxProgress())) + "%";
        }));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // mctech.components.ContainerComponent
    public ResourceLocation getTexture() {
        return mctech.m.a.a(this, ((mctech.blockentities.c.U) getHolder()).machineTier(), "singularity_collector");
    }

    @Override // mctech.components.ContainerComponent
    @OnlyIn(Dist.CLIENT)
    public void onGuiLoaded(mctech.m.d.b bVar) {
        bVar.c(1);
        bVar.c(2);
        bVar.e(aI.f);
        bVar.f(193);
    }
}
