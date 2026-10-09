package mctech.api;

import java.nio.file.Path;
import java.util.List;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/IConfigProxy.class */
public interface IConfigProxy {

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/IConfigProxy$IPotentialTarget.class */
    public interface IPotentialTarget {
        Path getFolder();

        String getName();
    }

    List<Path> getBasePaths();

    List<? extends IPotentialTarget> getPotentialConfigs();

    boolean isDynamicProxy();
}
