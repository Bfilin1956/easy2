package net.mcskill.shop.client.listener;

import gg.essential.universal.UKeyboard;
import gg.essential.universal.UScreen;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.mcskill.shop.client.screen.SelectionType;
import net.mcskill.shop.client.screen.ShopScreen;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.InputEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: InputEventListener.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/listener/InputEventListener.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Lnet/mcskill/shop/client/listener/InputEventListener;", "", "<init>", "()V", "onKeyInput", "", "event", "Lnet/neoforged/neoforge/client/event/InputEvent$Key;", "MSShop"})
public final class InputEventListener {
    @SubscribeEvent
    public final void onKeyInput(@NotNull InputEvent.Key event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (UScreen.Companion.getCurrentScreen() == null) {
            if (!UKeyboard.isKeyDown(UKeyboard.KEY_F4)) {
                if (UKeyboard.isKeyDown(UKeyboard.KEY_F6)) {
                    ShopScreen.INSTANCE.openWith(SelectionType.CASES);
                    return;
                }
                return;
            }
            ShopScreen.Companion.openWith$default(ShopScreen.INSTANCE, null, 1, null);
        }
    }
}
