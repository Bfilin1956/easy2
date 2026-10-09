package mctech.g.c.b;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import mctech.MCTech;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ModelEvent;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/c/b/c.class */
@EventBusSubscriber({Dist.CLIENT})
public class c {
    private static final List<ModelResourceLocation> k = new ArrayList();
    private static final Map<ModelResourceLocation, BakedModel> l = new HashMap();
    public static final ModelResourceLocation a = a("block/conduit_connector");
    public static final ModelResourceLocation b = a("block/conduit_facade_overlay");
    public static final ModelResourceLocation c = a("block/conduit_connection");
    public static final ModelResourceLocation d = a("block/conduit_core");
    public static final ModelResourceLocation e = a("block/box/1x1x1");
    public static final ModelResourceLocation f = a("block/conduit_connection_box");
    public static final ModelResourceLocation g = a("block/io/input");
    public static final ModelResourceLocation h = a("block/io/in_out");
    public static final ModelResourceLocation i = a("block/io/output");
    public static final ModelResourceLocation j = a("block/io/redstone");

    private static ModelResourceLocation a(String str) {
        ModelResourceLocation modelResourceLocationStandalone = ModelResourceLocation.standalone(MCTech.loc(str));
        k.add(modelResourceLocationStandalone);
        return modelResourceLocationStandalone;
    }

    public static BakedModel a(ModelResourceLocation modelResourceLocation) {
        return l.get(modelResourceLocation);
    }

    @SubscribeEvent
    public static void a(ModelEvent.RegisterAdditional registerAdditional) {
        Iterator<ModelResourceLocation> it = k.iterator();
        while (it.hasNext()) {
            registerAdditional.register(it.next());
        }
        mctech.g.c.b.c.a.a();
        Set<ModelResourceLocation> setB = mctech.g.c.b.c.a.b();
        Objects.requireNonNull(registerAdditional);
        setB.forEach(registerAdditional::register);
    }

    @SubscribeEvent
    public static void a(ModelEvent.BakingCompleted bakingCompleted) {
        for (ModelResourceLocation modelResourceLocation : k) {
            l.put(modelResourceLocation, (BakedModel) bakingCompleted.getModels().get(modelResourceLocation));
        }
    }
}
