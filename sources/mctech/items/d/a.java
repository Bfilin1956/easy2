package mctech.items.d;

import java.util.List;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/d/a.class */
public class a extends mctech.items.base.i {
    private final b a;

    public a(b bVar) {
        super(new mctech.items.base.o().c(bVar.b()).a(1));
        this.a = bVar;
    }

    public b a() {
        return this.a;
    }

    public int b() {
        return this.a.a();
    }

    public boolean isEnchantable(@NotNull ItemStack itemStack) {
        return false;
    }

    public boolean isBarVisible(@NotNull ItemStack itemStack) {
        return true;
    }

    public void appendHoverText(@NotNull ItemStack itemStack, @NotNull Item.TooltipContext tooltipContext, @NotNull List<Component> list, @NotNull TooltipFlag tooltipFlag) {
        super.appendHoverText(itemStack, tooltipContext, list, tooltipFlag);
        list.add(mctech.g.d.e.h.a(Component.literal(String.format("EU/t: %s", Integer.valueOf(b()))), new Object[0]));
        list.add(mctech.g.d.e.h.a(Component.literal(String.format("Время (4 слота): %s мин", Integer.valueOf(this.a.b() / 1200))), new Object[0]));
    }
}
