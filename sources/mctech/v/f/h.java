package mctech.v.f;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import java.util.Iterator;
import javax.annotation.Nonnull;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/f/h.class */
@OnlyIn(Dist.CLIENT)
public final class h {
    public static void a(PoseStack poseStack, @Nonnull MultiBufferSource multiBufferSource, @Nonnull BakedModel bakedModel, int i) {
        RandomSource randomSourceCreate = RandomSource.create();
        VertexConsumer buffer = multiBufferSource.getBuffer(Sheets.translucentItemSheet());
        for (Direction direction : Direction.values()) {
            randomSourceCreate.setSeed(42L);
            Iterator it = bakedModel.getQuads((BlockState) null, direction, randomSourceCreate).iterator();
            while (it.hasNext()) {
                buffer.putBulkData(poseStack.last(), (BakedQuad) it.next(), 1.0f, 1.0f, 1.0f, 1.0f, i, OverlayTexture.NO_OVERLAY);
            }
        }
        randomSourceCreate.setSeed(42L);
        Iterator it2 = bakedModel.getQuads((BlockState) null, (Direction) null, randomSourceCreate).iterator();
        while (it2.hasNext()) {
            buffer.putBulkData(poseStack.last(), (BakedQuad) it2.next(), 1.0f, 1.0f, 1.0f, 1.0f, i, OverlayTexture.NO_OVERLAY);
        }
    }
}
