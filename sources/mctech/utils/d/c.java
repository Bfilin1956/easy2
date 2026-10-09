package mctech.utils.d;

import it.unimi.dsi.fastutil.objects.ObjectList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import mctech.MCTech;
import mctech.api.addons.IModule;
import mctech.api.addons.MCTechPlugin;
import mctech.config.ConfigEntry;
import mctech.config.ConfigSection;
import mctech.config.impl.ReloadMode;
import net.neoforged.fml.ModList;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforgespi.language.ModFileScanData;
import org.objectweb.asm.Type;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/d/c.class */
public class c {
    Map<String, IModule> a = mctech.utils.a.b.e();

    public void a(int i, ConfigSection configSection) {
        for (a aVar : a()) {
            IModule iModuleA = aVar.a();
            int iRequiredAPIVersion = aVar.b().requiredAPIVersion();
            if (iRequiredAPIVersion == 0 || iRequiredAPIVersion <= i) {
                if (iModuleA.canLoad(FMLEnvironment.dist) && ((ConfigEntry.BoolValue) configSection.addBool(aVar.b().id(), true).setRequiredReload(ReloadMode.GAME)).get()) {
                    this.a.put(aVar.b().id(), aVar.a());
                    aVar.a().loadConfigs();
                }
            }
        }
    }

    public void a(Consumer<IModule> consumer) {
        this.a.values().forEach(consumer);
    }

    public IModule a(String str) {
        return this.a.get(str);
    }

    private List<a> a() {
        Type type = Type.getType(MCTechPlugin.class);
        ObjectList objectListI = mctech.utils.a.b.i();
        Iterator it = ModList.get().getAllScanData().iterator();
        while (it.hasNext()) {
            for (ModFileScanData.AnnotationData annotationData : ((ModFileScanData) it.next()).getAnnotations()) {
                if (annotationData.annotationType().equals(type)) {
                    try {
                        Class<?> cls = Class.forName(annotationData.memberName());
                        if (cls != null) {
                            MCTechPlugin mCTechPlugin = (MCTechPlugin) cls.getAnnotation(MCTechPlugin.class);
                            MCTech.LOGGER.info("Loading Plugin: [name=" + mCTechPlugin.name() + ", version=" + mCTechPlugin.version());
                            IModule iModule = (IModule) cls.newInstance();
                            if (iModule != null) {
                                objectListI.add(new a(mCTechPlugin, iModule));
                            }
                        }
                    } catch (Exception e) {
                    }
                }
            }
        }
        return objectListI;
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/d/c$a.class */
    static class a {
        MCTechPlugin a;
        IModule b;

        public a(MCTechPlugin mCTechPlugin, IModule iModule) {
            this.a = mCTechPlugin;
            this.b = iModule;
        }

        public IModule a() {
            return this.b;
        }

        public MCTechPlugin b() {
            return this.a;
        }
    }
}
