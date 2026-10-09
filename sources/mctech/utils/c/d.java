package mctech.utils.c;

import java.util.Optional;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModList;
import net.neoforged.fml.ModLoadingContext;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/c/d.class */
public class d {
    private ModContainer a;

    public void a(String str) {
        Optional modContainerById = ModList.get().getModContainerById(str);
        if (!modContainerById.isPresent() || ModLoadingContext.get().getActiveNamespace().equals(str)) {
            return;
        }
        if (this.a != null) {
            throw new IllegalStateException("Cache already set");
        }
        ModLoadingContext modLoadingContext = ModLoadingContext.get();
        this.a = modLoadingContext.getActiveContainer();
        modLoadingContext.setActiveContainer((ModContainer) modContainerById.orElse(null));
    }

    public void a() {
        if (this.a == null) {
            return;
        }
        ModLoadingContext.get().setActiveContainer(this.a);
        this.a = null;
    }
}
