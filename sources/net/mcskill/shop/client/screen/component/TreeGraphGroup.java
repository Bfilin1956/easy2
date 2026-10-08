package net.mcskill.shop.client.screen.component;

import gg.essential.elementa.UIComponent;
import gg.essential.elementa.UIConstraints;
import gg.essential.elementa.constraints.ChildBasedMaxSizeConstraint;
import gg.essential.elementa.constraints.FillConstraint;
import gg.essential.elementa.dsl.ComponentsKt;
import gg.essential.elementa.dsl.ConstraintsKt;
import gg.essential.elementa.dsl.UtilitiesKt;
import gg.essential.elementa.state.ExtensionsKt;
import gg.essential.elementa.utils.LineUtils;
import gg.essential.universal.UMatrixStack;
import java.awt.Color;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import net.mcskill.core.client.screen.MSPalette;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: TreeGraphGroup.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/component/TreeGraphGroup.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u000e\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lnet/mcskill/shop/client/screen/component/TreeGraphGroup;", "Lgg/essential/elementa/UIComponent;", "name", "", "<init>", "(Ljava/lang/String;)V", "rootNode", "Lnet/mcskill/shop/client/screen/component/RootNode;", "getRootNode", "()Lnet/mcskill/shop/client/screen/component/RootNode;", "rootNode$delegate", "Lkotlin/properties/ReadWriteProperty;", "draw", "", "matrixStack", "Lgg/essential/universal/UMatrixStack;", "appendNode", "node", "Lnet/mcskill/shop/client/screen/component/ChildNode;", "MSShop"})
@SourceDebugExtension({"SMAP\nTreeGraphGroup.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TreeGraphGroup.kt\nnet/mcskill/shop/client/screen/component/TreeGraphGroup\n+ 2 components.kt\ngg/essential/elementa/dsl/ComponentsKt\n+ 3 UIComponent.kt\ngg/essential/elementa/UIComponent\n*L\n1#1,111:1\n10#2,3:112\n263#3:115\n*S KotlinDebug\n*F\n+ 1 TreeGraphGroup.kt\nnet/mcskill/shop/client/screen/component/TreeGraphGroup\n*L\n23#1:112,3\n32#1:115\n*E\n"})
public final class TreeGraphGroup extends UIComponent {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(TreeGraphGroup.class, "rootNode", "getRootNode()Lnet/mcskill/shop/client/screen/component/RootNode;", 0))};

    /* JADX INFO: renamed from: rootNode$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty rootNode;

    public TreeGraphGroup(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        UIComponent $this$constrain$iv = new RootNode(name);
        UIConstraints $this$rootNode_delegate_u24lambda_u240 = $this$constrain$iv.getConstraints();
        $this$rootNode_delegate_u24lambda_u240.setWidth(new FillConstraint(false));
        $this$rootNode_delegate_u24lambda_u240.setHeight(ConstraintsKt.coerceAtLeast(new ChildBasedMaxSizeConstraint(), UtilitiesKt.getDp((Number) 40)));
        $this$rootNode_delegate_u24lambda_u240.setColor(ExtensionsKt.toConstraint(MSPalette.INSTANCE.getWhiteA1()));
        this.rootNode = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv, this), this, $$delegatedProperties[0]);
    }

    private final RootNode getRootNode() {
        return (RootNode) this.rootNode.getValue(this, $$delegatedProperties[0]);
    }

    public void draw(@NotNull UMatrixStack matrixStack) {
        Intrinsics.checkNotNullParameter(matrixStack, "matrixStack");
        beforeDrawCompat(matrixStack);
        TreeGraphGroup this_$iv = this;
        List<ChildNode> nodes = this_$iv.childrenOfType(ChildNode.class);
        if (!nodes.isEmpty()) {
            ChildNode last = (ChildNode) CollectionsKt.last(nodes);
            LineUtils.drawLine(matrixStack, Float.valueOf(getRootNode().getCircle().getLeft() + (getRootNode().getCircle().getWidth() / 2)), Float.valueOf(getRootNode().getCircle().getTop() + (getRootNode().getCircle().getHeight() / 2)), Float.valueOf(getRootNode().getCircle().getLeft() + (getRootNode().getCircle().getWidth() / 2)), Float.valueOf(last.getArrow().getTop() + (last.getArrow().getHeight() / 2)), (Color) MSPalette.INSTANCE.getOrange().get(), 1.0f);
            for (ChildNode node : nodes) {
                LineUtils.drawLine(matrixStack, Float.valueOf(getRootNode().getCircle().getLeft() + (getRootNode().getCircle().getWidth() / 2)), Float.valueOf(node.getArrow().getTop() + (node.getArrow().getHeight() / 2)), Float.valueOf(node.getArrow().getLeft() + (node.getArrow().getWidth() / 2) + 1.2f), Float.valueOf(node.getArrow().getTop() + (node.getArrow().getHeight() / 2)), (Color) MSPalette.INSTANCE.getOrange().get(), 1.0f);
            }
        }
        super.draw(matrixStack);
    }

    public final void appendNode(@NotNull ChildNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        ComponentsKt.childOf((UIComponent) node, this);
    }
}
