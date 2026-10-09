package mctech.j;

import com.mojang.blaze3d.vertex.VertexConsumer;
import it.unimi.dsi.fastutil.ints.IntIterator;
import it.unimi.dsi.fastutil.ints.IntLinkedOpenHashSet;
import it.unimi.dsi.fastutil.ints.IntSet;
import java.util.AbstractMap;
import java.util.Map;
import java.util.UUID;
import mctech.mixin.client.PlayerControllerMixin;
import mctech.v.x;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.border.WorldBorder;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.RenderHighlightEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/j/g.class */
public class g {
    public static final g a = new g();
    Map<UUID, Map.Entry<BlockPos, Direction>> b = mctech.utils.a.b.e();
    IntSet c = new IntLinkedOpenHashSet();
    IntSet d = new IntLinkedOpenHashSet();

    @SubscribeEvent
    public void a(PlayerEvent.BreakSpeed breakSpeed) {
        ItemStack mainHandItem = breakSpeed.getEntity().getMainHandItem();
        if (breakSpeed.getPosition().isPresent()) {
            mctech.items.base.a.b item = mainHandItem.getItem();
            if (item instanceof mctech.items.base.a.b) {
                mctech.items.base.a.b bVar = item;
                if (!bVar.a(mainHandItem) || !bVar.b(mainHandItem)) {
                }
            }
        }
    }

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public void a(PlayerInteractEvent.LeftClickBlock leftClickBlock) {
        if (leftClickBlock.getSide().isServer()) {
            return;
        }
        this.b.put(leftClickBlock.getEntity().getUUID(), new AbstractMap.SimpleEntry(leftClickBlock.getPos(), leftClickBlock.getFace()));
    }

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public void a(PlayerTickEvent.Post post) {
        if (post.getEntity() != null && !post.getEntity().level().isClientSide()) {
            return;
        }
        PlayerControllerMixin playerControllerMixin = Minecraft.getInstance().gameMode;
        LevelRenderer levelRenderer = Minecraft.getInstance().levelRenderer;
        if (!playerControllerMixin.isDestroying()) {
            this.b.remove(post.getEntity().getUUID());
            if (this.c.size() > 0) {
                IntIterator it = this.c.iterator();
                while (it.hasNext()) {
                    levelRenderer.destroyBlockProgress(((Integer) it.next()).intValue(), BlockPos.ZERO, -1);
                }
                this.c.clear();
                return;
            }
            return;
        }
        Map.Entry<BlockPos, Direction> entry = this.b.get(post.getEntity().getUUID());
        if (entry == null) {
            return;
        }
        ItemStack mainHandItem = post.getEntity().getMainHandItem();
        mctech.items.base.a.b item = mainHandItem.getItem();
        if (item instanceof mctech.items.base.a.b) {
            mctech.items.base.a.b bVar = item;
            if (!bVar.a(mainHandItem) || !bVar.b(mainHandItem)) {
                return;
            }
            this.d.addAll(this.c);
            this.c.clear();
            int destroyProgress = ((int) (playerControllerMixin.getDestroyProgress() * 10.0f)) - 1;
            for (BlockPos blockPos : mctech.utils.a.f.a(bVar.a(mainHandItem, post.getEntity(), entry.getKey(), entry.getValue()))) {
                int iAbs = Math.abs(blockPos.equals(entry.getKey()) ? post.getEntity().getId() : blockPos.hashCode());
                levelRenderer.destroyBlockProgress(iAbs, blockPos.immutable(), destroyProgress);
                this.c.add(iAbs);
            }
            this.d.removeAll(this.c);
            if (this.d.size() > 0) {
                IntIterator it2 = this.d.iterator();
                while (it2.hasNext()) {
                    levelRenderer.destroyBlockProgress(((Integer) it2.next()).intValue(), BlockPos.ZERO, -1);
                }
                this.d.clear();
            }
        }
    }

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public void a(RenderHighlightEvent.Block block) {
        Player player = Minecraft.getInstance().player;
        if (player == null) {
            return;
        }
        ItemStack mainHandItem = player.getMainHandItem();
        mctech.items.base.a.b item = mainHandItem.getItem();
        if (item instanceof mctech.items.base.a.b) {
            mctech.items.base.a.b bVar = item;
            if (!bVar.a(mainHandItem) || !bVar.b(mainHandItem)) {
                return;
            }
            WorldBorder worldBorder = player.level().getWorldBorder();
            Vec3 position = block.getCamera().getPosition();
            BlockHitResult target = block.getTarget();
            VertexConsumer buffer = block.getMultiBufferSource().getBuffer(RenderType.lines());
            int i = 0;
            for (BlockPos blockPos : mctech.utils.a.f.a(bVar.a(mainHandItem, player, target.getBlockPos(), target.getDirection()))) {
                BlockState blockState = player.level().getBlockState(blockPos);
                if (!blockState.isAir() && blockState.getDestroySpeed(player.level(), blockPos) != -1.0f && worldBorder.isWithinBounds(blockPos)) {
                    x.a(block.getPoseStack(), buffer, (Entity) player, position.x(), position.y(), position.z(), blockPos, blockState);
                    i++;
                }
            }
            if (i > 0) {
                block.setCanceled(true);
            }
        }
    }
}
