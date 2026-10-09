package mctech.x.a;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.MeshData;
import com.mojang.blaze3d.vertex.VertexBuffer;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import mctech.MCTech;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.server.packs.resources.PreparableReloadListener;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.util.profiling.ProfilerFiller;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterClientReloadListenersEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/x/a/i.class */
@OnlyIn(Dist.CLIENT)
@EventBusSubscriber(value = {Dist.CLIENT}, modid = MCTech.MODID)
public class i implements PreparableReloadListener {
    public static final i a = new i();
    private boolean c = false;
    private final Map<ModelResourceLocation, VertexBuffer> b = new Object2ObjectOpenHashMap();

    public void a(@NotNull ModelResourceLocation modelResourceLocation, @NotNull MeshData meshData) {
        if (!RenderSystem.isOnRenderThread()) {
            RenderSystem.recordRenderCall(() -> {
                a(modelResourceLocation, meshData, VertexBuffer.Usage.DYNAMIC);
            });
        } else {
            a(modelResourceLocation, meshData, VertexBuffer.Usage.DYNAMIC);
        }
    }

    private void a(@NotNull ModelResourceLocation modelResourceLocation, @NotNull MeshData meshData, VertexBuffer.Usage usage) {
        if (this.b.containsKey(modelResourceLocation)) {
            this.b.get(modelResourceLocation).close();
        }
        VertexBuffer vertexBuffer = new VertexBuffer(usage);
        vertexBuffer.bind();
        vertexBuffer.upload(meshData);
        VertexBuffer.unbind();
        this.b.put(modelResourceLocation, vertexBuffer);
    }

    public void b(@NotNull ModelResourceLocation modelResourceLocation, @NotNull MeshData meshData) {
        if (!RenderSystem.isOnRenderThread()) {
            RenderSystem.recordRenderCall(() -> {
                c(modelResourceLocation, meshData);
            });
        } else {
            c(modelResourceLocation, meshData);
        }
    }

    private void c(@NotNull ModelResourceLocation modelResourceLocation, @NotNull MeshData meshData) {
        if (this.b.containsKey(modelResourceLocation)) {
            this.b.get(modelResourceLocation).close();
        }
        VertexBuffer vertexBuffer = new VertexBuffer(VertexBuffer.Usage.STATIC);
        vertexBuffer.bind();
        vertexBuffer.upload(meshData);
        VertexBuffer.unbind();
        this.b.put(modelResourceLocation, vertexBuffer);
    }

    public void a() {
        if (this.c) {
            d();
            this.c = false;
        }
    }

    @Nullable
    public VertexBuffer a(@NotNull ModelResourceLocation modelResourceLocation) {
        return this.b.get(modelResourceLocation);
    }

    public void b() {
        Iterator<VertexBuffer> it = this.b.values().iterator();
        while (it.hasNext()) {
            it.next().close();
        }
        this.b.clear();
    }

    public boolean b(ModelResourceLocation modelResourceLocation) {
        return this.b.containsKey(modelResourceLocation);
    }

    @NotNull
    public CompletableFuture<Void> reload(@NotNull PreparableReloadListener.PreparationBarrier preparationBarrier, @NotNull ResourceManager resourceManager, @NotNull ProfilerFiller profilerFiller, @NotNull ProfilerFiller profilerFiller2, @NotNull Executor executor, @NotNull Executor executor2) {
        c();
        return CompletableFuture.completedFuture(null);
    }

    public void c() {
        this.c = true;
    }

    @SubscribeEvent
    private static void a(RegisterClientReloadListenersEvent registerClientReloadListenersEvent) {
        a.c();
    }

    private void d() {
        b();
        e.a();
    }
}
