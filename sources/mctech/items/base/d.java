package mctech.items.base;

import java.util.List;
import javax.annotation.Nonnull;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/base/d.class */
public class d extends Item {

    @Nonnull
    private final mctech.modules.e<?> a;
    private final int b;

    public d(@Nonnull mctech.modules.e<?> eVar, int i, @Nonnull Item.Properties properties) {
        super(properties.stacksTo(1));
        this.a = eVar;
        this.b = i;
    }

    public void appendHoverText(ItemStack itemStack, Item.TooltipContext tooltipContext, List<Component> list, TooltipFlag tooltipFlag) {
        this.a.a(this, itemStack, tooltipContext.level(), list, tooltipFlag);
    }

    @Nonnull
    public mctech.modules.e<?> a() {
        return this.a;
    }

    public int b() {
        return this.b;
    }
}
