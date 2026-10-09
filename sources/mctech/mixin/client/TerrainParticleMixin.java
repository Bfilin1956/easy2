package mctech.mixin.client;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import mctech.MCTech;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.TerrainParticle;
import net.minecraft.client.particle.TextureSheetParticle;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.client.model.data.ModelData;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/mixin/client/TerrainParticleMixin.class */
@Mixin({TerrainParticle.class})
public class TerrainParticleMixin {
    @Inject(method = {"<init>(Lnet/minecraft/client/multiplayer/ClientLevel;DDDDDDLnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/core/BlockPos;)V"}, at = {@At("RETURN")}, remap = false)
    private void initParticles(ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6, BlockState blockState, BlockPos blockPos, CallbackInfo callbackInfo) {
        TerrainParticle terrainParticle = (TerrainParticle) this;
        BakedModel blockModel = Minecraft.getInstance().getBlockRenderer().getBlockModelShaper().getBlockModel(blockState);
        BlockEntity blockEntity = clientLevel.getBlockEntity(blockPos);
        if (blockEntity != null) {
            callSetSprite(blockModel.getParticleIcon(blockEntity.getModelData()), terrainParticle);
        } else {
            callSetSprite(blockModel.getParticleIcon(ModelData.EMPTY), terrainParticle);
        }
    }

    @Unique
    private void callSetSprite(@NotNull TextureAtlasSprite textureAtlasSprite, TerrainParticle terrainParticle) {
        try {
            Method declaredMethod = TextureSheetParticle.class.getDeclaredMethod("setSprite", TextureAtlasSprite.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(terrainParticle, textureAtlasSprite);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            MCTech.LOGGER.warn("Cannot set sprite for terrain particle at {} cause: {}", terrainParticle.getPos().toString(), e);
        }
    }
}
