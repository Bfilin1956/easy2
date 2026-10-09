package mctech.v.f;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.RenderType;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/f/e.class */
public class e extends Model {
    ModelPart a;
    ModelPart b;

    public e(int i) {
        super(RenderType::entityCutout);
        MeshDefinition meshDefinitionA = a((i * 8) + 2);
        this.a = meshDefinitionA.getRoot().getChild("shaft").bake(64, 128);
        this.b = meshDefinitionA.getRoot().getChild("blade").bake(64, 128);
    }

    private static MeshDefinition a(int i) {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition root = meshDefinition.getRoot();
        PartDefinition partDefinitionAddOrReplaceChild = root.addOrReplaceChild("shaft", CubeListBuilder.create(), PartPose.ZERO);
        PartDefinition partDefinitionAddOrReplaceChild2 = root.addOrReplaceChild("blade", CubeListBuilder.create(), PartPose.ZERO);
        partDefinitionAddOrReplaceChild.addOrReplaceChild("shaft", CubeListBuilder.create().texOffs(29, 0).addBox(0.0f, -2.0f, -2.0f, 10.0f, 4.0f, 4.0f), PartPose.offset(-14.0f, 0.0f, 0.0f));
        partDefinitionAddOrReplaceChild2.addOrReplaceChild("wing", CubeListBuilder.create().texOffs(48, 14).addBox(-2.0f, 2.0f, -2.0f, 4.0f, i + 12.0f, 4.0f), PartPose.offset(-12.0f, 0.0f, 0.0f));
        partDefinitionAddOrReplaceChild2.addOrReplaceChild("fan", CubeListBuilder.create().addBox(-1.0f, 14.0f, -18.0f, 2.0f, i, 16.0f), PartPose.offset(-12.0f, 0.0f, 0.0f));
        return meshDefinition;
    }

    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int i, int i2, int i3) {
        this.a.render(poseStack, vertexConsumer, i, i2, i3);
        for (int i4 = 0; i4 < 4; i4++) {
            poseStack.mulPose(Axis.XP.rotationDegrees((360 / 4) * i4));
            this.b.render(poseStack, vertexConsumer, i, i2, i3);
        }
    }
}
