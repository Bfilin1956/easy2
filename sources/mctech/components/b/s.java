package mctech.components.b;

import java.util.Set;
import mctech.api.tiles.ISortMachine;
import mctech.components.ContainerComponent;
import mctech.utils.math.geometry.Vec2i;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.network.PacketDistributor;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/b/s.class */
public class s extends mctech.m.d.a.a {
    private ContainerComponent<?> a;

    public s(ContainerComponent<?> containerComponent, Vec2i vec2i) {
        super(new mctech.utils.math.geometry.b(vec2i.getX(), vec2i.getY(), 10, 10));
        this.a = containerComponent;
    }

    @Override // mctech.m.d.a.a
    protected void a(Set<mctech.m.d.a.a.EnumC0027a> set) {
        set.add(mctech.m.d.a.a.EnumC0027a.GUI_INIT);
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(mctech.m.d.b bVar) {
        super.a(bVar);
        Object holder = this.a.getHolder();
        if (!(holder instanceof ISortMachine)) {
            return;
        }
        ISortMachine iSortMachine = (ISortMachine) holder;
        int iA = 5 + this.o.a();
        int iB = 16 + this.o.b();
        ResourceLocation atlasTexture = null;
        Vec2i sortButtonTextureOffset = Vec2i.ZERO;
        if (this.a != null) {
            sortButtonTextureOffset = this.a.getSortButtonTextureOffset();
            atlasTexture = this.a.getAtlasTexture();
        }
        bVar.addRenderableWidget(new r(bVar.getGuiLeft() + iA, bVar.getGuiTop() + iB, 10, 10, iSortMachine.getSorter(), button -> {
            PacketDistributor.sendToServer(new mctech.q.d.a.a.C0034a(((BlockEntity) this.a.getHolder()).getBlockPos(), 150, 0), new CustomPacketPayload[0]);
        }, atlasTexture, sortButtonTextureOffset));
    }
}
