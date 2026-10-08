package net.mcskill.shop.client.screen.tab;

import gg.essential.elementa.UIComponent;
import gg.essential.elementa.components.UIContainer;
import gg.essential.elementa.components.Window;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import net.mcskill.shop.client.screen.component.Context;
import net.mcskill.shop.client.screen.component.RadioGroup;
import net.mcskill.shop.client.screen.modal.Modal;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: TabContainer.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/tab/TabContainer.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u000fH\u0016J\u0006\u0010\u0018\u001a\u00020\u0014R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0019"}, d2 = {"Lnet/mcskill/shop/client/screen/tab/TabContainer;", "Lgg/essential/elementa/components/UIContainer;", "Lnet/mcskill/shop/client/screen/component/Context;", "Lnet/mcskill/shop/client/screen/component/RadioGroup;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "buttonTab", "Lgg/essential/elementa/UIComponent;", "getButtonTab", "()Lgg/essential/elementa/UIComponent;", "isCurrent", "", "()Z", "setCurrent", "(Z)V", "select", "", "deselect", "closeContext", "instantly", "closeModals", "MSShop"})
@SourceDebugExtension({"SMAP\nTabContainer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TabContainer.kt\nnet/mcskill/shop/client/screen/tab/TabContainer\n+ 2 UIComponent.kt\ngg/essential/elementa/UIComponent\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,31:1\n263#2:32\n1863#3,2:33\n*S KotlinDebug\n*F\n+ 1 TabContainer.kt\nnet/mcskill/shop/client/screen/tab/TabContainer\n*L\n29#1:32\n29#1:33,2\n*E\n"})
public abstract class TabContainer extends UIContainer implements Context, RadioGroup {
    private boolean isCurrent;

    @NotNull
    public abstract String getName();

    @NotNull
    /* JADX INFO: renamed from: getButtonTab */
    public abstract UIComponent mo90getButtonTab();

    public final boolean isCurrent() {
        return this.isCurrent;
    }

    public final void setCurrent(boolean z) {
        this.isCurrent = z;
    }

    @Override // net.mcskill.shop.client.screen.component.RadioGroup
    public void select() {
        closeModals();
        this.isCurrent = true;
    }

    @Override // net.mcskill.shop.client.screen.component.RadioGroup
    public void deselect() {
        this.isCurrent = false;
    }

    @Override // net.mcskill.shop.client.screen.component.Context
    public void closeContext(boolean instantly) {
    }

    public final void closeModals() {
        UIComponent this_$iv = Window.Companion.of((UIComponent) this);
        Iterable $this$forEach$iv = this_$iv.childrenOfType(Modal.class);
        for (Object element$iv : $this$forEach$iv) {
            Modal p0 = (Modal) element$iv;
            p0.close();
        }
    }
}
