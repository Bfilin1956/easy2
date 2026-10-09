package mctech.g.e;

import mctech.MCTech;
import net.neoforged.neoforge.client.model.generators.CustomLoaderBuilder;
import net.neoforged.neoforge.client.model.generators.ModelBuilder;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/e/c.class */
public class c<T extends ModelBuilder<T>> extends CustomLoaderBuilder<T> {
    public static <T extends ModelBuilder<T>> c<T> a(T t, ExistingFileHelper existingFileHelper) {
        return new c<>(t, existingFileHelper);
    }

    protected c(T t, ExistingFileHelper existingFileHelper) {
        super(MCTech.loc("conduit"), t, existingFileHelper, false);
    }
}
