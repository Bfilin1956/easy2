package mctech;

import com.mojang.blaze3d.platform.InputConstants;
import java.util.Set;
import java.util.UUID;
import mctech.api.items.armor.IEnergyShieldArmor;
import mctech.init.MCTechTiles;
import mctech.m.b.S;
import mctech.v.q;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.ResourceManagerReloadListener;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.InputEvent;
import net.neoforged.neoforge.client.event.RegisterClientTooltipComponentFactoriesEvent;
import net.neoforged.neoforge.client.event.RenderLivingEvent;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import net.neoforged.neoforge.client.model.data.ModelData;
import net.neoforged.neoforge.common.NeoForge;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/i.class */
@OnlyIn(Dist.CLIENT)
public class i extends h implements ResourceManagerReloadListener {
    Minecraft b = Minecraft.getInstance();
    Set<Class<? extends LivingEntity>> c = mctech.utils.a.b.g();
    int d;

    @Override // mctech.h
    public void a() {
        super.a();
        IEventBus eventBus = ModLoadingContext.get().getActiveContainer().getEventBus();
        eventBus.register(q.a);
        eventBus.addListener(this::a);
        NeoForge.EVENT_BUS.register(mctech.v.j.b.a);
        NeoForge.EVENT_BUS.register(mctech.v.j.c.a);
        mctech.v.j.b.a.a();
    }

    @SubscribeEvent
    public void a(InputEvent.Key key) {
        long window = this.b.getWindow().getWindow();
        if (this.d <= 0 && InputConstants.isKeyDown(window, 292) && InputConstants.isKeyDown(window, 82) && this.b.screen == null) {
            this.b.player.displayClientMessage(Component.literal("[Debug]: ").withStyle(new ChatFormatting[]{ChatFormatting.YELLOW, ChatFormatting.BOLD}).append(Component.literal("Reloading MCTechC Wikis").setStyle(Style.EMPTY.withColor(ChatFormatting.WHITE).withBold(false))), false);
            this.b.getLanguageManager().onResourceManagerReload(this.b.getResourceManager());
            this.d = 5;
        }
    }

    @SubscribeEvent
    public void a(ClientTickEvent.Post post) {
        if (this.d > 0) {
            this.d--;
            if (this.d <= 0) {
                this.b.getLanguageManager().onResourceManagerReload(this.b.getResourceManager());
                onResourceManagerReload(null);
                this.b.player.displayClientMessage(Component.literal("[Debug]: ").withStyle(new ChatFormatting[]{ChatFormatting.YELLOW, ChatFormatting.BOLD}).append(Component.literal("Reloaded MCTechC Wikis").setStyle(Style.EMPTY.withColor(ChatFormatting.WHITE).withBold(false))), false);
            }
        }
    }

    private void a(RegisterClientTooltipComponentFactoriesEvent registerClientTooltipComponentFactoriesEvent) {
        registerClientTooltipComponentFactoriesEvent.register(mctech.v.i.b.C0049b.class, (v1) -> {
            return new mctech.v.i.a(v1);
        });
        registerClientTooltipComponentFactoriesEvent.register(mctech.v.i.b.a.class, (v1) -> {
            return new mctech.v.i.a(v1);
        });
    }

    @Override // mctech.h
    public void b() {
        super.b();
        BlockEntityRenderers.register((BlockEntityType) MCTechTiles.VENDING_MACHINE.get(), mctech.v.h.a::new);
    }

    public void onResourceManagerReload(ResourceManager resourceManager) {
        if (this.b.level != null) {
        }
    }

    @SubscribeEvent
    public void a(RenderLivingEvent.Pre<LivingEntity, EntityModel<LivingEntity>> pre) {
        LivingEntity entity = pre.getEntity();
        if ((entity instanceof Player) && IEnergyShieldArmor.addsEnergyShieldEffect(entity)) {
            entity.hurtTime = -entity.hurtTime;
        }
    }

    @SubscribeEvent
    public void a(RenderLivingEvent.Post<LivingEntity, EntityModel<LivingEntity>> post) {
        LivingEntity entity = post.getEntity();
        if (entity.hurtTime < 0) {
            entity.hurtTime = -entity.hurtTime;
        }
    }

    @Override // mctech.h
    public boolean a(Player player, mctech.m.a.c cVar, int i) {
        try {
            S sA = cVar.a(player, i);
            if (sA == null) {
                return false;
            }
            player.containerMenu = sA;
            Screen screenA = cVar.a(player, sA);
            if (screenA == null) {
                return false;
            }
            mctech.s.d.a().g = cVar;
            this.b.setScreen(screenA);
            return true;
        } catch (Exception e) {
            MCTech.LOGGER.catching(e);
            return false;
        }
    }

    @Override // mctech.h
    public boolean a(Player player, InteractionHand interactionHand, Direction direction, mctech.m.a.d dVar, int i) {
        try {
            S sCreateContainer = dVar.createContainer(player, interactionHand, direction, i);
            if (sCreateContainer == null) {
                return false;
            }
            player.containerMenu = sCreateContainer;
            Screen screenA = dVar.a(player, interactionHand, direction, sCreateContainer);
            if (screenA == null) {
                return false;
            }
            this.b.setScreen(screenA);
            return true;
        } catch (Exception e) {
            MCTech.LOGGER.catching(e);
            return false;
        }
    }

    @Override // mctech.h
    public Player e() {
        return this.b.player;
    }

    @Override // mctech.h
    public boolean a(UUID uuid) {
        return uuid.equals(this.b.player.getUUID()) && this.b.player.hasPermissions(1);
    }

    @Override // mctech.h
    public RecipeManager f() {
        return this.b.player.connection.getRecipeManager();
    }

    @Override // mctech.h
    public Level a(ResourceKey<Level> resourceKey) {
        if (resourceKey != this.b.level.dimension()) {
            return null;
        }
        return this.b.level;
    }

    @Override // mctech.h
    public void a(BlockPos blockPos) {
        this.b.levelRenderer.setBlocksDirty(blockPos.getX(), blockPos.getY(), blockPos.getZ(), blockPos.getX(), blockPos.getY(), blockPos.getZ());
    }

    @Override // mctech.h
    public ModelData a(Block block) {
        return null;
    }

    @Override // mctech.h
    public boolean m() {
        return this.b.level != null;
    }

    @Override // mctech.h
    public Registry<Biome> a(Level level) {
        if (level instanceof ServerLevel) {
            return ((ServerLevel) level).registryAccess().registryOrThrow(Registries.BIOME);
        }
        if (level instanceof ClientLevel) {
            return ((ClientLevel) level).registryAccess().registryOrThrow(Registries.BIOME);
        }
        return null;
    }

    @Override // mctech.h
    public IClientItemExtensions j() {
        return null;
    }
}
