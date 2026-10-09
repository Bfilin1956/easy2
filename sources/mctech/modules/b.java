package mctech.modules;

import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import mctech.modules.config.Multiplier;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/modules/b.class */
public class b extends a<Multiplier> {
    public b(@Nonnull ResourceLocation resourceLocation, boolean z) {
        super(resourceLocation, Multiplier.JSON_SERIALIZER, z);
    }

    @Override // mctech.modules.e
    public void a(@Nonnull mctech.items.base.d dVar, @Nonnull ItemStack itemStack, @Nullable Level level, @Nonnull List<Component> list, @Nonnull TooltipFlag tooltipFlag) {
        list.add(Component.literal(String.valueOf(ChatFormatting.GOLD) + "Экономия: " + String.valueOf(ChatFormatting.YELLOW) + ((int) (((Multiplier) h.a().a(this, dVar.b())).multiplier() * 100.0f)) + "%"));
    }
}
