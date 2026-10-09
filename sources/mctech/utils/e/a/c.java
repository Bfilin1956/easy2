package mctech.utils.e.a;

import java.util.List;
import java.util.function.Supplier;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/e/a/c.class */
public class c extends a {
    public c(String str, Object... objArr) {
        super(str, objArr);
    }

    public c(Component component) {
        super(component);
    }

    public c(Supplier<Component> supplier) {
        super(supplier);
    }

    @Override // mctech.utils.e.a.a, mctech.utils.e.a.d
    @OnlyIn(Dist.CLIENT)
    public void a(ItemStack itemStack, BlockGetter blockGetter, List<Component> list, TooltipFlag tooltipFlag) {
        if (mctech.s.d.a().c()) {
            super.a(itemStack, blockGetter, list, tooltipFlag);
        }
    }
}
