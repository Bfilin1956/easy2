package mctech.utils.e.a;

import java.util.List;
import java.util.function.Supplier;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/e/a/a.class */
public class a implements d {
    protected Component a;
    protected Supplier<Component> b;

    public a(String str, Object... objArr) {
        this.a = c(str, objArr).withStyle(ChatFormatting.GRAY);
    }

    public a(Component component) {
        this.a = component.copy().withStyle(ChatFormatting.GRAY);
    }

    public a(Supplier<Component> supplier) {
        this.b = supplier;
    }

    @Override // mctech.utils.e.a.d
    @OnlyIn(Dist.CLIENT)
    public void a(ItemStack itemStack, BlockGetter blockGetter, List<Component> list, TooltipFlag tooltipFlag) {
        list.add(this.b != null ? this.b.get() : this.a);
    }
}
