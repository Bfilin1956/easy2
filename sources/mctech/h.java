package mctech;

import java.nio.file.Path;
import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;
import mctech.api.items.ItemRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.fml.loading.FMLPaths;
import net.neoforged.fml.util.thread.EffectiveSide;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import net.neoforged.neoforge.client.model.data.ModelData;
import net.neoforged.neoforge.server.ServerLifecycleHooks;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/h.class */
public class h {
    List<ResourceLocation> a = mctech.utils.a.b.i();

    public void a() {
    }

    public void b() {
        a(Blocks.OBSIDIAN, 60.0f);
        a(Blocks.ENCHANTING_TABLE, 60.0f);
        a(Blocks.ENDER_CHEST, 60.0f);
        a(Blocks.ANVIL, 60.0f);
        a(Blocks.CHIPPED_ANVIL, 60.0f);
        a(Blocks.DAMAGED_ANVIL, 60.0f);
        a(Blocks.WATER, 30.0f);
        a(Blocks.LAVA, 30.0f);
        ItemRegistries.registerMetalArmor((itemStack, player, equipmentSlot) -> {
            return true;
        }, Items.NETHERITE_BOOTS, Items.IRON_BOOTS, Items.GOLDEN_BOOTS);
    }

    public void c() {
    }

    public void d() {
    }

    public void a(String str) {
        MCTech.LOGGER.error(str);
        ServerLifecycleHooks.handleExit(0);
    }

    public Player e() {
        return null;
    }

    public RecipeManager f() {
        return ServerLifecycleHooks.getCurrentServer().getRecipeManager();
    }

    public Registry<Biome> a(Level level) {
        Registry<Biome> registryRegistryOrThrow;
        if (level instanceof ServerLevel) {
            registryRegistryOrThrow = ((ServerLevel) level).registryAccess().registryOrThrow(Registries.BIOME);
        } else {
            registryRegistryOrThrow = null;
        }
        return registryRegistryOrThrow;
    }

    public final BlockEntity a(ResourceKey<Level> resourceKey, BlockPos blockPos, boolean z) {
        Level levelA = a(resourceKey);
        if (levelA == null || (z && !levelA.hasChunk(blockPos.getX() >> 4, blockPos.getZ() >> 4))) {
            return null;
        }
        return levelA.getBlockEntity(blockPos);
    }

    public final Entity a(ResourceKey<Level> resourceKey, int i) {
        Level levelA = a(resourceKey);
        if (levelA == null) {
            return null;
        }
        return levelA.getEntity(i);
    }

    public boolean a(UUID uuid) {
        ServerPlayer player = i().getPlayerList().getPlayer(uuid);
        return player != null && i().getProfilePermissions(player.getGameProfile()) >= i().getOperatorUserPermissionLevel();
    }

    public boolean g() {
        return EffectiveSide.get().isServer();
    }

    public boolean h() {
        return EffectiveSide.get().isClient();
    }

    public Level a(ResourceKey<Level> resourceKey) {
        MinecraftServer currentServer = ServerLifecycleHooks.getCurrentServer();
        if (currentServer == null || resourceKey == null) {
            return null;
        }
        return currentServer.getLevel(resourceKey);
    }

    public MinecraftServer i() {
        return ServerLifecycleHooks.getCurrentServer();
    }

    public IClientItemExtensions j() {
        return IClientItemExtensions.DEFAULT;
    }

    public boolean a(Player player, mctech.m.a.c cVar, int i) {
        return false;
    }

    public boolean a(Player player, InteractionHand interactionHand, Direction direction, mctech.m.a.d dVar) {
        return false;
    }

    public boolean a(Player player, InteractionHand interactionHand, Direction direction, mctech.m.a.d dVar, int i) {
        return false;
    }

    public void a(BlockPos blockPos) {
    }

    public Path k() {
        return FMLPaths.CONFIGDIR.get();
    }

    public ModelData a(Block block) {
        return ModelData.EMPTY;
    }

    public void a(Player player) {
        player.resetStat(Stats.CUSTOM.get(Stats.TIME_SINCE_REST));
    }

    public void a(ResourceLocation resourceLocation) {
        this.a.add(resourceLocation);
    }

    public void a(Consumer<ResourceLocation> consumer) {
        this.a.forEach(consumer);
    }

    public void a(Block block, float f) {
    }

    public boolean l() {
        return i().isPvpAllowed();
    }

    public boolean m() {
        return false;
    }
}
