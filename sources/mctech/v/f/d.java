package mctech.v.f;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.RenderType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/f/d.class */
@OnlyIn(Dist.CLIENT)
public class d extends Model {
    ModelPart a;
    ModelPart b;

    public d() {
        super(RenderType::entitySolid);
        MeshDefinition meshDefinitionA = a();
        this.a = meshDefinitionA.getRoot().getChild("chest").bake(64, 64);
        this.b = meshDefinitionA.getRoot().getChild("door").bake(64, 64);
    }

    private static MeshDefinition a() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition root = meshDefinition.getRoot();
        PartDefinition partDefinitionAddOrReplaceChild = root.addOrReplaceChild("chest", CubeListBuilder.create(), PartPose.ZERO);
        PartDefinition partDefinitionAddOrReplaceChild2 = root.addOrReplaceChild("door", CubeListBuilder.create(), PartPose.ZERO);
        partDefinitionAddOrReplaceChild.addOrReplaceChild("Right-Wall", CubeListBuilder.create().mirror().addBox(0.0f, 0.0f, 0.0f, 14.0f, 16.0f, 1.0f), PartPose.offsetAndRotation(1.0f, 0.0f, 15.0f, 0.0f, 1.570796f, 0.0f));
        partDefinitionAddOrReplaceChild.addOrReplaceChild("Left-Wall", CubeListBuilder.create().mirror().addBox(0.0f, 0.0f, 0.0f, 14.0f, 16.0f, 1.0f), PartPose.offsetAndRotation(15.0f, 0.0f, 1.0f, 0.0f, -1.570796f, 0.0f));
        partDefinitionAddOrReplaceChild.addOrReplaceChild("Back-Wall", CubeListBuilder.create().texOffs(1, 1).mirror().addBox(1.0f, 1.0f, 0.0f, 12.0f, 14.0f, 1.0f), PartPose.offsetAndRotation(15.0f, 0.0f, 15.0f, 0.0f, 3.141593f, 0.0f));
        partDefinitionAddOrReplaceChild.addOrReplaceChild("Up-Wall", CubeListBuilder.create().texOffs(1, 17).mirror().addBox(1.0f, 0.0f, 0.0f, 12.0f, 14.0f, 1.0f), PartPose.offsetAndRotation(1.0f, 0.0f, 15.0f, -1.570796f, 0.0f, 0.0f));
        partDefinitionAddOrReplaceChild.addOrReplaceChild("Down-Wall", CubeListBuilder.create().texOffs(1, 17).mirror().addBox(1.0f, 0.0f, 0.0f, 12.0f, 14.0f, 1.0f), PartPose.offsetAndRotation(15.0f, 15.0f, 1.0f, -1.570796f, 3.141593f, 0.0f));
        partDefinitionAddOrReplaceChild2.addOrReplaceChild("door", CubeListBuilder.create().texOffs(30, 0).mirror().addBox(0.0f, 0.0f, 0.0f, 12.0f, 14.0f, 1.0f), PartPose.offset(0.0f, 0.0f, 0.0f));
        return meshDefinition;
    }

    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int i, int i2, int i3) {
        this.a.render(poseStack, vertexConsumer, i, i2, i3);
        this.b.render(poseStack, vertexConsumer, i, i2, i3);
    }

    public void a(PoseStack poseStack, VertexConsumer vertexConsumer, int i, int i2, float f) {
        this.a.render(poseStack, vertexConsumer, i, i2);
        this.b.yRot = f;
        this.b.x = 2.0f;
        this.b.y = 1.0f;
        this.b.z = 2.0f;
        this.b.render(poseStack, vertexConsumer, i, i2);
    }
}
