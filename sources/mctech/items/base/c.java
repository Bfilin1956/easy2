package mctech.items.base;

import net.mcskill.msregistry.core.IMachineTier;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/base/c.class */
public class c extends BlockItem implements IMachineTier {
    private final MachineTier a;

    public c(mctech.blocks.base.blocks.a aVar, Item.Properties properties) {
        super(aVar, properties);
        this.a = aVar.a();
    }

    @NotNull
    public MachineTier machineTier() {
        return this.a;
    }
}
