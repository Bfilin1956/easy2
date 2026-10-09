package mctech.g.c;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.ParticleEngine;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.TextureSheetParticle;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/c/a.class */
public class a extends TextureSheetParticle {
    private final BlockPos a;
    private final float b;
    private final float c;

    public a(ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6, BlockPos blockPos, ResourceLocation resourceLocation) {
        super(clientLevel, d, d2, d3, d4, d5, d6);
        this.a = blockPos;
        setSprite(Minecraft.getInstance().getModelManager().getAtlas(InventoryMenu.BLOCK_ATLAS).getSprite(resourceLocation));
        this.gravity = 1.0f;
        this.rCol = 0.6f;
        this.gCol = 0.6f;
        this.bCol = 0.6f;
        this.quadSize /= 2.0f;
        this.b = this.random.nextFloat() * 3.0f;
        this.c = this.random.nextFloat() * 3.0f;
    }

    @NotNull
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.TERRAIN_SHEET;
    }

    protected float getU0() {
        return this.sprite.getU((this.b + 1.0f) / 4.0f);
    }

    protected float getU1() {
        return this.sprite.getU(this.b / 4.0f);
    }

    protected float getV0() {
        return this.sprite.getV(this.c / 4.0f);
    }

    protected float getV1() {
        return this.sprite.getV((this.c + 1.0f) / 4.0f);
    }

    public int getLightColor(float f) {
        int lightColor = super.getLightColor(f);
        return (lightColor == 0 && this.level.hasChunkAt(this.a)) ? LevelRenderer.getLightColor(this.level, this.a) : lightColor;
    }

    public static void a(BlockPos blockPos, BlockState blockState, mctech.g.a.a<?, ?> aVar) {
        ClientLevel clientLevel = Minecraft.getInstance().level;
        if (clientLevel == null) {
            return;
        }
        ParticleEngine particleEngine = Minecraft.getInstance().particleEngine;
        blockState.getShape(clientLevel, blockPos).forAllBoxes((d, d2, d3, d4, d5, d6) -> {
            double dMin = Math.min(1.0d, d4 - d);
            double dMin2 = Math.min(1.0d, d5 - d2);
            double dMin3 = Math.min(1.0d, d6 - d3);
            int iMax = Math.max(2, Mth.ceil(dMin / 0.25d));
            int iMax2 = Math.max(2, Mth.ceil(dMin2 / 0.25d));
            int iMax3 = Math.max(2, Mth.ceil(dMin3 / 0.25d));
            for (int i = 0; i < iMax; i++) {
                for (int i2 = 0; i2 < iMax2; i2++) {
                    for (int i3 = 0; i3 < iMax3; i3++) {
                        double d = (((double) i) + 0.5d) / ((double) iMax);
                        double d2 = (((double) i2) + 0.5d) / ((double) iMax2);
                        double d3 = (((double) i3) + 0.5d) / ((double) iMax3);
                        particleEngine.add(new a(clientLevel, ((double) blockPos.getX()) + (d * dMin) + d, ((double) blockPos.getY()) + (d2 * dMin2) + d2, ((double) blockPos.getZ()) + (d3 * dMin3) + d3, d - 0.5d, d2 - 0.5d, d3 - 0.5d, blockPos, aVar.a()));
                    }
                }
            }
        });
    }

    public static void a(BlockPos blockPos, BlockState blockState, mctech.g.a.a<?, ?> aVar, Direction direction) {
        ClientLevel clientLevel = Minecraft.getInstance().level;
        if (clientLevel == null) {
            return;
        }
        ParticleEngine particleEngine = Minecraft.getInstance().particleEngine;
        double size = 1.0d / ((double) mctech.g.d.a.e.a.toAabbs().size());
        int x = blockPos.getX();
        int y = blockPos.getY();
        int z = blockPos.getZ();
        AABB aabbBounds = blockState.getShape(clientLevel, blockPos).bounds();
        double dNextDouble = ((double) x) + (clientLevel.getRandom().nextDouble() * ((aabbBounds.maxX - aabbBounds.minX) - 0.20000000298023224d)) + 0.10000000149011612d + aabbBounds.minX;
        double dNextDouble2 = ((double) y) + (clientLevel.getRandom().nextDouble() * ((aabbBounds.maxY - aabbBounds.minY) - 0.20000000298023224d)) + 0.10000000149011612d + aabbBounds.minY;
        double dNextDouble3 = ((double) z) + (clientLevel.getRandom().nextDouble() * ((aabbBounds.maxZ - aabbBounds.minZ) - 0.20000000298023224d)) + 0.10000000149011612d + aabbBounds.minZ;
        if (direction == Direction.DOWN) {
            dNextDouble2 = (((double) y) + aabbBounds.minY) - 0.10000000149011612d;
        }
        if (direction == Direction.UP) {
            dNextDouble2 = ((double) y) + aabbBounds.maxY + 0.10000000149011612d;
        }
        if (direction == Direction.NORTH) {
            dNextDouble3 = (((double) z) + aabbBounds.minZ) - 0.10000000149011612d;
        }
        if (direction == Direction.SOUTH) {
            dNextDouble3 = ((double) z) + aabbBounds.maxZ + 0.10000000149011612d;
        }
        if (direction == Direction.WEST) {
            dNextDouble = (((double) x) + aabbBounds.minX) - 0.10000000149011612d;
        }
        if (direction == Direction.EAST) {
            dNextDouble = ((double) x) + aabbBounds.maxX + 0.10000000149011612d;
        }
        particleEngine.add(new a(clientLevel, dNextDouble, dNextDouble2, dNextDouble3, 0.0d, 0.0d, 0.0d, blockPos, aVar.a()).setPower(0.2f).scale(0.6f));
    }
}
