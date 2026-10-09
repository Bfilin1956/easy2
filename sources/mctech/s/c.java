package mctech.s;

import com.mojang.blaze3d.platform.InputConstants;
import com.mojang.blaze3d.platform.Window;
import mctech.MCTech;
import mctech.blockentities.c.C0074u;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.client.Options;
import net.minecraft.client.gui.screens.ChatScreen;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.settings.IKeyConflictContext;
import net.neoforged.neoforge.client.settings.KeyConflictContext;
import net.neoforged.neoforge.network.PacketDistributor;
import org.lwjgl.glfw.GLFW;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/s/c.class */
@OnlyIn(Dist.CLIENT)
public class c extends b {
    public KeyMapping a;
    public KeyMapping b;
    public KeyMapping c;
    public KeyMapping d;
    public KeyMapping e;
    public KeyMapping f;
    public KeyMapping g;
    private KeyMapping[] l;
    Minecraft h;
    Window i;
    boolean j;
    int k = 0;

    @Override // mctech.s.b
    public void b() {
        this.a = new KeyMapping("key.mctech.alt", 342, "key.mctech.keys");
        this.b = new KeyMapping("key.mctech.boost", 341, "key.mctech.keys");
        this.c = new KeyMapping("key.mctech.fly", 70, "key.mctech.keys");
        this.d = new KeyMapping("key.mctech.mode", 77, "key.mctech.keys");
        this.e = new KeyMapping("key.mctech.inv", 67, "key.mctech.keys");
        this.f = new KeyMapping("key.mctech.hud", 88, "key.mctech.keys");
        this.g = new KeyMapping("key.mctech.toggle", 86, "key.mctech.keys");
        ModLoadingContext.get().getActiveContainer().getEventBus().addListener(this::a);
        this.h = Minecraft.getInstance();
        if (this.h != null) {
            this.i = this.h.getWindow();
            Options options = this.h.options;
            this.l = new KeyMapping[]{this.a, this.b, this.c, this.d, this.e, this.f, this.g, options.keyJump, options.keyUp};
        }
        this.j = true;
    }

    public void a(RegisterKeyMappingsEvent registerKeyMappingsEvent) {
        registerKeyMappingsEvent.register(this.a);
        registerKeyMappingsEvent.register(this.b);
        registerKeyMappingsEvent.register(this.c);
        registerKeyMappingsEvent.register(this.d);
        registerKeyMappingsEvent.register(this.e);
        registerKeyMappingsEvent.register(this.f);
        registerKeyMappingsEvent.register(this.g);
    }

    @Override // mctech.s.b
    public MutableComponent a(a aVar) {
        switch (aVar.a()) {
            case 0:
                return this.a.getTranslatedKeyMessage();
            case 1:
                return this.b.getTranslatedKeyMessage();
            case 2:
                return this.c.getTranslatedKeyMessage();
            case 3:
                return this.d.getTranslatedKeyMessage();
            case 4:
                return this.e.getTranslatedKeyMessage();
            case 5:
                return this.f.getTranslatedKeyMessage();
            case 6:
                return this.g.getTranslatedKeyMessage();
            case 7:
                return this.h.options.keyJump.getTranslatedKeyMessage();
            case 8:
                return this.h.options.keyUp.getTranslatedKeyMessage();
            case 9:
                return this.h.options.keyDown.getTranslatedKeyMessage();
            case C0074u.j /* 10 */:
                return this.h.options.keyShift.getTranslatedKeyMessage();
            case 11:
                return this.h.options.keyUse.getTranslatedKeyMessage();
            default:
                return super.a(aVar);
        }
    }

    @Override // mctech.s.b
    public int b(a aVar) {
        switch (aVar.a()) {
            case 0:
                return this.a.getKey().getValue();
            case 1:
                return this.b.getKey().getValue();
            case 2:
                return this.c.getKey().getValue();
            case 3:
                return this.d.getKey().getValue();
            case 4:
                return this.e.getKey().getValue();
            case 5:
                return this.f.getKey().getValue();
            case 6:
                return this.g.getKey().getValue();
            case 7:
                return this.h.options.keyJump.getKey().getValue();
            case 8:
                return this.h.options.keyUp.getKey().getValue();
            case 9:
                return this.h.options.keyDown.getKey().getValue();
            case C0074u.j /* 10 */:
                return this.h.options.keyShift.getKey().getValue();
            case 11:
                return this.h.options.keyUse.getKey().getValue();
            default:
                return -1;
        }
    }

    @Override // mctech.s.b
    public void a() {
        int i = 0;
        if ((this.h.screen == null || this.j) && !(this.h.screen instanceof ChatScreen)) {
            for (int i2 = 0; i2 < this.l.length; i2++) {
                i |= a(this.l[i2]) ? 1 << i2 : 0;
            }
        }
        int i3 = i | ((this.h.screen != null ? 1 : 0) << 31);
        if (i3 != this.k) {
            Player playerE = MCTech.PLATFORM.e();
            if (playerE != null) {
                PacketDistributor.sendToServer(new mctech.q.d.d.a.C0036a(i3), new CustomPacketPayload[0]);
                a(playerE, i3);
            }
            this.k = i3;
        }
    }

    @Override // mctech.s.b
    public void a(Player player, int i) {
        super.a(player, i);
        if (player == MCTech.PLATFORM.e()) {
            d.a().a(i);
        }
    }

    public boolean a(KeyMapping keyMapping) {
        IKeyConflictContext keyConflictContext = keyMapping.getKeyConflictContext();
        keyMapping.setKeyConflictContext(this.j ? KeyConflictContext.UNIVERSAL : KeyConflictContext.IN_GAME);
        boolean z = b(keyMapping) && keyMapping.isConflictContextAndModifierActive();
        keyMapping.setKeyConflictContext(keyConflictContext);
        return z;
    }

    private boolean b(KeyMapping keyMapping) {
        if (keyMapping.isUnbound()) {
            return false;
        }
        InputConstants.Key key = keyMapping.getKey();
        if (key.getType() == InputConstants.Type.MOUSE) {
            return GLFW.glfwGetMouseButton(this.i.getWindow(), key.getValue()) == 1;
        }
        return InputConstants.isKeyDown(this.i.getWindow(), key.getValue());
    }
}
