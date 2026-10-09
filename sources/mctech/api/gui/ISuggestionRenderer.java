package mctech.api.gui;

import com.mojang.blaze3d.vertex.PoseStack;
import it.unimi.dsi.fastutil.objects.Object2ObjectMaps;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import java.util.Map;
import net.minecraft.network.chat.Component;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/gui/ISuggestionRenderer.class */
public interface ISuggestionRenderer {
    Component renderSuggestion(PoseStack poseStack, String str, int i, int i2);

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/gui/ISuggestionRenderer$Registry.class */
    public static class Registry {
        private static final Map<Class<?>, ISuggestionRenderer> REGISTRY = Object2ObjectMaps.synchronize(new Object2ObjectOpenHashMap());

        public static void register(Class<?> cls, ISuggestionRenderer iSuggestionRenderer) {
            REGISTRY.putIfAbsent(cls, iSuggestionRenderer);
        }

        public static ISuggestionRenderer getRendererForType(Class<?> cls) {
            return REGISTRY.get(cls);
        }

        public static ISuggestionRenderer getRendererForType(Object obj) {
            if (obj == null) {
                return null;
            }
            return getRendererForType(obj instanceof Class ? obj : obj.getClass());
        }
    }
}
