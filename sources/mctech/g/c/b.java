package mctech.g.c;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.ParticleEngine;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.neoforged.neoforge.client.extensions.common.IClientBlockExtensions;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/c/b.class */
public class b implements IClientBlockExtensions {
    public static final b a = new b();

    private b() {
    }

    public boolean addHitEffects(@NotNull BlockState blockState, @NotNull Level level, @NotNull HitResult hitResult, @NotNull ParticleEngine particleEngine) {
        if (!(hitResult instanceof BlockHitResult)) {
            return false;
        }
        BlockHitResult blockHitResult = (BlockHitResult) hitResult;
        BlockEntity blockEntity = level.getBlockEntity(blockHitResult.getBlockPos());
        if (blockEntity instanceof mctech.g.d.a.a.b) {
            mctech.g.d.a.a.b bVar = (mctech.g.d.a.a.b) blockEntity;
            if (bVar.e() && mctech.g.c.b.b.a.a()) {
                return false;
            }
            Holder<mctech.g.a.a<?, ?>> holderB = bVar.j().b(blockHitResult.getBlockPos(), hitResult);
            if (holderB != null) {
                a.a(blockHitResult.getBlockPos(), blockState, (mctech.g.a.a) holderB.value(), blockHitResult.getDirection());
                return true;
            }
            return true;
        }
        return false;
    }

    public boolean addDestroyEffects(@NotNull BlockState blockState, Level level, @NotNull BlockPos blockPos, @NotNull ParticleEngine particleEngine) {
        mctech.g.a.c blockEntity = level.getBlockEntity(blockPos);
        if (blockEntity instanceof mctech.g.a.c) {
            return (blockEntity.e() && mctech.g.c.b.b.a.a()) ? false : true;
        }
        return false;
    }

    public boolean playBreakSound(@NotNull BlockState blockState, Level level, @NotNull BlockPos blockPos) {
        BlockEntity blockEntity = level.getBlockEntity(blockPos);
        if (blockEntity instanceof mctech.g.d.a.a.b) {
            mctech.g.d.a.a.b bVar = (mctech.g.d.a.a.b) blockEntity;
            LocalPlayer localPlayer = Minecraft.getInstance().player;
            SoundType soundType = blockState.getSoundType(level, blockPos, localPlayer);
            if (bVar.e()) {
                Block blockF = bVar.f();
                if (mctech.g.c.b.b.a.a()) {
                    soundType = blockF.getSoundType(blockF.defaultBlockState(), level, blockPos, localPlayer);
                }
            }
            level.playSound(localPlayer, blockPos, soundType.getBreakSound(), SoundSource.BLOCKS, (soundType.getVolume() + 1.0f) / 2.0f, soundType.getPitch() * 0.8f);
            return true;
        }
        return false;
    }
}
