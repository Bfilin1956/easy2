package mctech.v.f;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Transformation;
import it.unimi.dsi.fastutil.objects.Object2ObjectLinkedOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import mctech.api.events.RetextureEvent;
import mctech.v.u;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.BlockModelShaper;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.ItemOverrides;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.model.data.ModelData;
import org.joml.Quaternionf;
import org.joml.Vector3f;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/f/c.class */
@OnlyIn(Dist.CLIENT)
public class c extends mctech.v.f.a {
    static final float f = 0.468625f;
    static final float g = 0.531375f;
    static final Transformation h = new Transformation(new Vector3f(-0.25f, 0.0f, 0.0f), (Quaternionf) null, (Vector3f) null, (Quaternionf) null);
    static final Vector3f[] i = {new Vector3f(), new Vector3f(1.0f, 0.25f, 0.0f), new Vector3f(0.75f, 1.25f, 0.0f), new Vector3f(-0.25f, 1.0f, 0.0f)};
    static final Object2ObjectLinkedOpenHashMap<b, List<BakedQuad>> j = new Object2ObjectLinkedOpenHashMap<>();
    final BakedModel n;
    public List<BakedQuad> m = new ArrayList();
    List<BakedQuad> k = mctech.utils.a.b.i();
    b l = null;

    public c(BakedModel bakedModel) {
        this.n = bakedModel;
    }

    @Override // mctech.v.f.a
    public void a() {
        this.m.addAll(this.k);
        j.clear();
    }

    public BakedModel applyTransform(ItemDisplayContext itemDisplayContext, PoseStack poseStack, boolean z) {
        this.n.getTransforms().getTransform(itemDisplayContext).apply(z, poseStack);
        return super.applyTransform(itemDisplayContext, poseStack, z);
    }

    @Override // mctech.v.f.a
    public boolean isGui3d() {
        return false;
    }

    @Override // mctech.v.f.a
    public List<BakedQuad> getQuads(BlockState blockState, Direction direction, RandomSource randomSource, ModelData modelData, RenderType renderType) {
        if (this.k.isEmpty()) {
            Iterator it = this.n.getQuads(blockState, direction, randomSource, modelData, renderType).iterator();
            while (it.hasNext()) {
                this.k.add((BakedQuad) it.next());
            }
        }
        return direction == null ? this.m : mctech.v.f.a.c();
    }

    @Override // mctech.v.f.a
    public ItemOverrides getOverrides() {
        return a.a;
    }

    public void a(ItemStack itemStack) {
        RetextureEvent.TextureContainer textureContainerB = mctech.items.e.a.i.b(itemStack);
        if (textureContainerB == null && this.l != null) {
            this.m.clear();
            this.m.addAll(this.k);
            this.l = null;
            return;
        }
        if (textureContainerB != null) {
            b bVar = new b(textureContainerB);
            if (bVar.equals(this.l)) {
                return;
            }
            List<BakedQuad> listA = (List) j.getAndMoveToLast(bVar);
            if (listA == null) {
                listA = bVar.a(this);
                j.putAndMoveToLast(bVar, listA);
                if (j.size() > 500) {
                    j.removeFirst();
                }
            }
            this.m.clear();
            this.m.addAll(this.k);
            this.m.addAll(listA);
            this.l = bVar;
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/f/c$a.class */
    public static class a extends ItemOverrides {
        public static final a a = new a();

        public BakedModel resolve(BakedModel bakedModel, ItemStack itemStack, ClientLevel clientLevel, LivingEntity livingEntity, int i) {
            if (bakedModel instanceof c) {
                c cVar = (c) bakedModel;
                if (!cVar.k.isEmpty()) {
                    cVar.a(itemStack);
                }
            }
            return bakedModel;
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/f/c$b.class */
    public static class b {
        BlockState a;
        Direction b;
        RetextureEvent.Rotation[] c;

        public b(RetextureEvent.TextureContainer textureContainer) {
            this.a = textureContainer.getState();
            this.b = textureContainer.getSide();
            this.c = textureContainer.getRotations();
        }

        public int hashCode() {
            return Objects.hash(this.a, this.b, Integer.valueOf(Arrays.hashCode(this.c)));
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return bVar.a.equals(this.a) && bVar.b == this.b && Arrays.equals(bVar.c, this.c);
        }

        public List<BakedQuad> a(mctech.v.f.a aVar) {
            BlockModelShaper blockModelShaper = Minecraft.getInstance().getBlockRenderer().getBlockModelShaper();
            BakedModel blockModel = blockModelShaper.getBlockModel(this.a);
            if (blockModel == blockModelShaper.getModelManager().getMissingModel()) {
                return mctech.utils.a.b.i();
            }
            ObjectList objectListI = mctech.utils.a.b.i();
            int i = 0;
            for (BakedQuad bakedQuad : blockModel.getQuads(this.a, this.b, RandomSource.create(this.a.getSeed(BlockPos.ZERO)), ModelData.EMPTY, (RenderType) null)) {
                Transformation transformation = new Transformation(c.i[this.c[i].getIndex()], (Quaternionf) null, (Vector3f) null, (Quaternionf) null);
                objectListI.add(u.a(u.a(transformation.compose(c.h), 6.0f, 2.0f, 14.0f, 10.0f, c.f, bakedQuad.getSprite(), Direction.NORTH, -1, -1), bakedQuad.isTinted() ? i : -1));
                objectListI.add(u.a(u.a(transformation.compose(c.h), 6.0f, 2.0f, 14.0f, 10.0f, c.g, bakedQuad.getSprite(), Direction.SOUTH, -1, -1), bakedQuad.isTinted() ? i : -1));
                i++;
            }
            return objectListI;
        }
    }
}
