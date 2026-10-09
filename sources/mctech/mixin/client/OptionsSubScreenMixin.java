package mctech.mixin.client;

import net.minecraft.client.gui.components.OptionsList;
import net.minecraft.client.gui.screens.options.OptionsSubScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/mixin/client/OptionsSubScreenMixin.class */
@Mixin(value = {OptionsSubScreen.class}, remap = false)
public interface OptionsSubScreenMixin {
    @Accessor("list")
    OptionsList getOptionList();
}
