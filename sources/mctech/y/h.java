package mctech.y;

import com.mojang.datafixers.util.Pair;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.MissingPaletteEntryException;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientPlayerNetworkEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.RenderLevelStageEvent;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/y/h.class */
@EventBusSubscriber
public class h {
    private static e a = new e();
    private static boolean b = false;
    private static ChunkPos c = null;
    private static final List<Block> d = List.of(Blocks.AIR, Blocks.BEDROCK, Blocks.STONE, Blocks.GRASS_BLOCK, Blocks.DIRT);
    private static final Set<Pair<BlockPos, a>> e = Collections.synchronizedSet(new HashSet());
    private static b f = null;

    public static void a(e eVar) {
        a = eVar;
        a(true);
    }

    public static void a() {
        e.clear();
        a = new e();
    }

    public static boolean b() {
        return a.b();
    }

    public static int c() {
        if (b()) {
            return a.a() / 16;
        }
        return 0;
    }

    public static boolean a(BlockState blockState) {
        return b() && a.a(blockState);
    }

    public static e d() {
        return a;
    }

    private static boolean e() {
        if (Minecraft.getInstance().player == null || !b()) {
            return false;
        }
        ChunkPos chunkPosChunkPosition = Minecraft.getInstance().player.chunkPosition();
        return (c != null && chunkPosChunkPosition.x == c.x && chunkPosChunkPosition.z == c.z) ? false : true;
    }

    private static void f() {
        c = Minecraft.getInstance().player.chunkPosition();
    }

    private static synchronized void a(boolean z) {
        if (b()) {
            if ((z || e()) && !b) {
                f();
                Util.backgroundExecutor().execute(() -> {
                    b = true;
                    Set<Pair<BlockPos, a>> setG = g();
                    e.clear();
                    e.addAll(setG);
                    b = false;
                });
            }
        }
    }

    private static Set<Pair<BlockPos, a>> g() {
        ClientLevel clientLevel = Minecraft.getInstance().level;
        LocalPlayer localPlayer = Minecraft.getInstance().player;
        if (clientLevel == null || localPlayer == null || !b()) {
            return new HashSet();
        }
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        int iC = c() / 2;
        int i = localPlayer.chunkPosition().x;
        int i2 = localPlayer.chunkPosition().z;
        e eVarD = d();
        for (int i3 = i - iC; i3 <= i + iC; i3++) {
            int i4 = i3 << 4;
            for (int i5 = i2 - iC; i5 <= i2 + iC; i5++) {
                int i6 = i5 << 4;
                for (int i7 = i4; i7 < i4 + 16; i7++) {
                    for (int i8 = i6; i8 < i6 + 16; i8++) {
                        for (int minBuildHeight = clientLevel.getMinBuildHeight(); minBuildHeight < clientLevel.getMaxBuildHeight(); minBuildHeight++) {
                            try {
                                BlockPos blockPos = new BlockPos(i7, minBuildHeight, i8);
                                BlockState blockState = clientLevel.getBlockState(blockPos);
                                if (!d.contains(blockState.getBlock())) {
                                    eVarD.b(blockState).ifPresent(aVar -> {
                                        hashSet.add(new Pair(blockPos, aVar));
                                        hashSet2.add(blockPos);
                                    });
                                }
                            } catch (MissingPaletteEntryException e2) {
                            }
                        }
                    }
                }
            }
        }
        f = new b(clientLevel, hashSet2);
        return hashSet;
    }

    @SubscribeEvent
    public static void a(ClientTickEvent.Post post) {
        if (!a.b()) {
            return;
        }
        a(false);
    }

    @SubscribeEvent
    public static void a(ClientPlayerNetworkEvent.LoggingOut loggingOut) {
        a();
    }

    @SubscribeEvent
    public static void a(ClientPlayerNetworkEvent.LoggingIn loggingIn) {
        a();
    }

    @SubscribeEvent
    public static void a(RenderLevelStageEvent renderLevelStageEvent) {
        ClientLevel clientLevel;
        Entity entity;
        if (renderLevelStageEvent.getStage() != RenderLevelStageEvent.Stage.AFTER_TRANSLUCENT_BLOCKS || !b() || e.isEmpty() || (clientLevel = Minecraft.getInstance().level) == null || f == null || (entity = Minecraft.getInstance().cameraEntity) == null) {
            return;
        }
        MultiBufferSource.BufferSource bufferSource = Minecraft.getInstance().renderBuffers().bufferSource();
        e.forEach(pair -> {
            BlockPos blockPos = (BlockPos) pair.getFirst();
            if (Math.sqrt(entity.distanceToSqr(Vec3.atCenterOf(blockPos))) <= a.a() / 2.0f) {
                BlockState blockState = clientLevel.getBlockState(blockPos);
                a aVar = (a) pair.getSecond();
                switch (aVar.c()) {
                    case TEXTURED:
                        d.a(renderLevelStageEvent.getPoseStack(), bufferSource, f, blockPos, blockState);
                        break;
                    case COLORED:
                        d.a(renderLevelStageEvent.getPoseStack(), bufferSource, f, blockPos, blockState, aVar.d(), aVar.f());
                        break;
                }
            }
        });
        bufferSource.endBatch();
    }
}
