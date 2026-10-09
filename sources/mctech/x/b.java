package mctech.x;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.VertexFormat;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import mctech.MCTech;
import mctech.x.a.c;
import net.minecraft.client.renderer.ShaderInstance;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceProvider;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterShadersEvent;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/x/b.class */
@EventBusSubscriber(modid = MCTech.MODID, value = {Dist.CLIENT})
public class b {
    private static final List<C0052b> e = new ArrayList();
    public static final C0052b a = a(MCTech.loc("bloom_blit"), DefaultVertexFormat.POSITION_TEX_COLOR);
    public static final C0052b b = a(MCTech.loc("bloom/down_sample"), DefaultVertexFormat.POSITION_TEX_COLOR);
    public static final C0052b c = a(MCTech.loc("bloom/up_sample"), DefaultVertexFormat.POSITION_TEX_COLOR);
    public static final C0052b d = a(MCTech.loc("bloom/post"), DefaultVertexFormat.POSITION_TEX_COLOR);

    @SubscribeEvent
    public static void a(RegisterShadersEvent registerShadersEvent) throws IOException {
        ResourceProvider resourceProvider = registerShadersEvent.getResourceProvider();
        for (C0052b c0052b : e) {
            ShaderInstance shaderInstance = new ShaderInstance(resourceProvider, c0052b.b(), c0052b.a());
            Objects.requireNonNull(c0052b);
            registerShadersEvent.registerShader(shaderInstance, c0052b::a);
        }
        a.a(registerShadersEvent);
        c.a.a(resourceProvider);
    }

    public static void a(int i, int i2) {
        c.a.a(i, i2);
    }

    private static C0052b a(ResourceLocation resourceLocation, VertexFormat vertexFormat) {
        C0052b c0052b = new C0052b(resourceLocation, vertexFormat);
        e.add(c0052b);
        return c0052b;
    }

    /* JADX INFO: renamed from: mctech.x.b$b, reason: collision with other inner class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/x/b$b.class */
    public static class C0052b {
        private final ResourceLocation a;
        private final VertexFormat b;
        private ShaderInstance c = null;

        public C0052b(ResourceLocation resourceLocation, VertexFormat vertexFormat) {
            this.a = resourceLocation;
            this.b = vertexFormat;
        }

        public void a(ShaderInstance shaderInstance) {
            this.c = shaderInstance;
        }

        public VertexFormat a() {
            return this.b;
        }

        public ResourceLocation b() {
            return this.a;
        }

        public ShaderInstance c() {
            if (this.c == null) {
                throw new IllegalStateException("Shader instance has not been created");
            }
            return this.c;
        }

        public ShaderInstance d() {
            RenderSystem.setShader(this::c);
            return c();
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/x/b$a.class */
    public static final class a {
        private static mctech.x.a.b a;

        public static mctech.x.a.b a() {
            return a;
        }

        private static void a(RegisterShadersEvent registerShadersEvent) throws IOException {
            registerShadersEvent.registerShader(new mctech.x.a.b(registerShadersEvent.getResourceProvider(), MCTech.loc("batch/glow"), DefaultVertexFormat.POSITION_TEX_COLOR_NORMAL), shaderInstance -> {
                a = (mctech.x.a.b) shaderInstance;
            });
        }
    }
}
