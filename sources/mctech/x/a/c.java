package mctech.x.a;

import com.mojang.blaze3d.pipeline.RenderTarget;
import com.mojang.blaze3d.pipeline.TextureTarget;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.VertexBuffer;
import net.minecraft.client.Minecraft;
import net.minecraft.server.packs.resources.ResourceProvider;
import net.minecraft.world.level.block.entity.BlockEntity;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/x/a/c.class */
public final class c extends f<BlockEntity> {
    public static final c a = new c(i.a);
    private mctech.x.b.a b;
    private RenderTarget c;

    c(i iVar) {
        super(iVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mctech.x.a.f
    public boolean a(BlockEntity blockEntity) {
        return blockEntity.isRemoved();
    }

    public void a() {
        this.c.clear(Minecraft.ON_OSX);
        Minecraft minecraft = Minecraft.getInstance();
        RenderTarget mainRenderTarget = minecraft.getMainRenderTarget();
        mainRenderTarget.bindWrite(false);
        mctech.x.a.a(mainRenderTarget, this.c, minecraft.getWindow().getWidth(), minecraft.getWindow().getHeight());
        mainRenderTarget.bindWrite(false);
    }

    @Override // mctech.x.a.f
    protected void a(float f) {
        this.c.bindWrite(true);
        RenderSystem.disableCull();
        RenderSystem.enableDepthTest();
    }

    @Override // mctech.x.a.f
    protected void b(float f) {
        Minecraft.getInstance().getMainRenderTarget().bindWrite(false);
        RenderSystem.enableCull();
        RenderSystem.disableDepthTest();
        VertexBuffer.unbind();
        this.b.a(this.c, 0.8f);
    }

    public void a(ResourceProvider resourceProvider) {
        Minecraft minecraft = Minecraft.getInstance();
        int width = minecraft.getWindow().getWidth();
        int height = minecraft.getWindow().getHeight();
        if (this.b != null) {
            this.b.close();
        }
        if (this.c != null) {
            this.c.destroyBuffers();
        }
        this.b = new mctech.x.b.a(8);
        this.c = new TextureTarget(width, height, true, Minecraft.ON_OSX);
        this.c.setClearColor(0.0f, 0.0f, 0.0f, 0.0f);
    }

    public void a(int i, int i2) {
        if (this.b != null) {
            this.b.a(i, i2);
        }
        if (this.c != null) {
            this.c.unbindRead();
            this.c.unbindWrite();
            this.c.resize(i, i2, Minecraft.ON_OSX);
        }
    }

    public RenderTarget b() {
        return this.c;
    }
}
