package mctech.mixin.kubejs;

import dev.latvian.mods.kubejs.event.EventHandler;
import dev.latvian.mods.kubejs.event.EventHandlerContainer;
import dev.latvian.mods.kubejs.event.EventResult;
import dev.latvian.mods.kubejs.event.KubeEvent;
import dev.latvian.mods.kubejs.script.ConsoleJS;
import dev.latvian.mods.kubejs.script.ConsoleLine;
import java.util.Iterator;
import mctech.MCTech;
import net.neoforged.fml.loading.FMLEnvironment;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/mixin/kubejs/EventHandlerContainerMixin.class */
@Mixin({EventHandlerContainer.class})
public class EventHandlerContainerMixin {

    @Shadow(remap = false)
    @Final
    public String source;

    @Shadow(remap = false)
    @Final
    public int line;

    @Inject(method = {"handle"}, at = {@At(value = "INVOKE", target = "Ldev/latvian/mods/kubejs/script/ConsoleJS;error(Ljava/lang/String;Ljava/lang/Throwable;)Ldev/latvian/mods/kubejs/script/ConsoleLine;")}, remap = false, cancellable = true)
    private void handle(ConsoleJS consoleJS, EventHandler eventHandler, KubeEvent kubeEvent, CallbackInfoReturnable<EventResult> callbackInfoReturnable) {
        MCTech.LOGGER.error("Error while processing {} at #{}", this.source, Integer.valueOf(this.line));
        if (!consoleJS.errors.isEmpty()) {
            MCTech.LOGGER.error("Trace: ");
            Iterator it = consoleJS.errors.iterator();
            while (it.hasNext()) {
                MCTech.LOGGER.error("    {}", ((ConsoleLine) it.next()).message);
            }
        }
        if (!FMLEnvironment.production) {
            callbackInfoReturnable.setReturnValue(EventResult.PASS);
        }
    }
}
