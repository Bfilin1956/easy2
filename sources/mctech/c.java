package mctech;

import com.mojang.blaze3d.platform.InputConstants;
import javax.annotation.Nonnull;
import mctech.init.MCTechMenus;
import mctech.w.n;
import net.minecraft.client.KeyMapping;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.client.event.InputEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.client.settings.KeyConflictContext;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.network.PacketDistributor;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/c.class */
@OnlyIn(Dist.CLIENT)
public class c {
    private static final KeyMapping a = new KeyMapping("key.mctech.open_equipment", KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM, 75, "keyCategory.mctech");

    public c(@Nonnull IEventBus iEventBus) {
        iEventBus.addListener(this::a);
        iEventBus.addListener(this::a);
        NeoForge.EVENT_BUS.addListener(this::a);
    }

    private void a(RegisterMenuScreensEvent registerMenuScreensEvent) {
        registerMenuScreensEvent.register(MCTechMenus.ARMOR_EQUIPMENT_MENU.get(), mctech.w.b::new);
        registerMenuScreensEvent.register(MCTechMenus.SINGULAR_ARMOR_MENU.get(), n::new);
    }

    private void a(@Nonnull RegisterKeyMappingsEvent registerKeyMappingsEvent) {
        registerKeyMappingsEvent.register(a);
    }

    private void a(@Nonnull InputEvent.Key key) {
        if (a.consumeClick()) {
            PacketDistributor.sendToServer(mctech.q.d.b.b, new CustomPacketPayload[0]);
        }
    }
}
