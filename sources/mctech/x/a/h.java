package mctech.x.a;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.world.level.block.entity.BlockEntity;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/x/a/h.class */
public final class h extends f<BlockEntity> {
    public static final h a = new h(i.a);

    h(i iVar) {
        super(iVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mctech.x.a.f
    public boolean a(BlockEntity blockEntity) {
        return blockEntity.isRemoved();
    }

    @Override // mctech.x.a.f
    protected void a(float f) {
        Minecraft.getInstance().getMainRenderTarget().bindWrite(false);
        RenderSystem.disableCull();
        RenderSystem.enableDepthTest();
    }

    @Override // mctech.x.a.f
    protected void b(float f) {
        RenderSystem.enableCull();
        RenderSystem.disableDepthTest();
    }
}
