package mctech.api;

import it.unimi.dsi.fastutil.objects.ObjectLists;
import java.nio.file.Path;
import java.util.List;
import mctech.config.utils.Helpers;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/SimpleConfigProxy.class */
public class SimpleConfigProxy implements IConfigProxy {
    Path path;

    public SimpleConfigProxy(Path path) {
        this.path = path;
    }

    @Override // mctech.api.IConfigProxy
    public boolean isDynamicProxy() {
        return false;
    }

    @Override // mctech.api.IConfigProxy
    public List<Path> getBasePaths() {
        return ObjectLists.singleton(this.path);
    }

    @Override // mctech.api.IConfigProxy
    public List<SimpleTarget> getPotentialConfigs() {
        return ObjectLists.singleton(new SimpleTarget(this.path, Helpers.firstLetterUppercase(this.path.getFileName().toString())));
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/SimpleConfigProxy$SimpleTarget.class */
    public static class SimpleTarget implements IConfigProxy.IPotentialTarget {
        Path folder;
        String name;

        public SimpleTarget(Path path, String str) {
            this.folder = path;
            this.name = str;
        }

        @Override // mctech.api.IConfigProxy.IPotentialTarget
        public Path getFolder() {
            return this.folder;
        }

        @Override // mctech.api.IConfigProxy.IPotentialTarget
        public String getName() {
            return this.name;
        }
    }
}
