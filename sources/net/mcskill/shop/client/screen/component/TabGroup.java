package net.mcskill.shop.client.screen.component;

import gg.essential.elementa.UIComponent;
import gg.essential.elementa.components.UIContainer;
import gg.essential.elementa.dsl.ComponentsKt;
import gg.essential.elementa.events.UIClickEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.mcskill.shop.client.screen.tab.TabContainer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TabGroup.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/component/TabGroup.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J)\u0010\f\u001a\u00020\r\"\b\b\u0000\u0010\u000e*\u00020\u00072\u0017\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u00020\r0\u0010¢\u0006\u0002\b\u0011J\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0007J\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0007J\b\u0010\u0015\u001a\u00020\rH\u0016J\u000e\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0018J\u0010\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001c"}, d2 = {"Lnet/mcskill/shop/client/screen/component/TabGroup;", "Lgg/essential/elementa/components/UIContainer;", "Lnet/mcskill/shop/client/screen/component/Context;", "<init>", "()V", "tabs", "", "Lnet/mcskill/shop/client/screen/tab/TabContainer;", "value", "currentTab", "getCurrentTab", "()Lnet/mcskill/shop/client/screen/tab/TabContainer;", "updateTab", "", "T", "update", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "attachCurrent", "tab", "attachTab", "afterInitialization", "selectTab", "name", "", "closeContext", "instantly", "", "MSShop"})
@SourceDebugExtension({"SMAP\nTabGroup.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TabGroup.kt\nnet/mcskill/shop/client/screen/component/TabGroup\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,53:1\n1#2:54\n1863#3,2:55\n230#3,2:57\n*S KotlinDebug\n*F\n+ 1 TabGroup.kt\nnet/mcskill/shop/client/screen/component/TabGroup\n*L\n32#1:55,2\n42#1:57,2\n*E\n"})
public final class TabGroup extends UIContainer implements Context {

    @NotNull
    private final List<TabContainer> tabs = new ArrayList();

    @Nullable
    private TabContainer currentTab;

    @Nullable
    public final TabContainer getCurrentTab() {
        return this.currentTab;
    }

    public final <T extends TabContainer> void updateTab(@NotNull Function1<? super T, Unit> update) {
        Intrinsics.checkNotNullParameter(update, "update");
        TabContainer tabContainer = this.currentTab;
        TabContainer tabContainer2 = tabContainer instanceof TabContainer ? tabContainer : null;
        if (tabContainer2 != null) {
            update.invoke(tabContainer2);
        }
    }

    @NotNull
    public final TabGroup attachCurrent(@NotNull TabContainer tab) {
        Intrinsics.checkNotNullParameter(tab, "tab");
        TabGroup $this$attachCurrent_u24lambda_u240 = this;
        $this$attachCurrent_u24lambda_u240.tabs.add(tab);
        if ($this$attachCurrent_u24lambda_u240.currentTab == null) {
            $this$attachCurrent_u24lambda_u240.currentTab = tab;
            tab.select();
        }
        return this;
    }

    @NotNull
    public final TabGroup attachTab(@NotNull TabContainer tab) {
        Intrinsics.checkNotNullParameter(tab, "tab");
        TabGroup $this$attachTab_u24lambda_u241 = this;
        $this$attachTab_u24lambda_u241.tabs.add(tab);
        UIComponent.hide$default((UIComponent) tab, false, 1, (Object) null);
        return this;
    }

    public void afterInitialization() {
        super.afterInitialization();
        Iterable $this$forEach$iv = this.tabs;
        for (Object element$iv : $this$forEach$iv) {
            TabContainer tab = (TabContainer) element$iv;
            ComponentsKt.childOf(tab.mo90getButtonTab().onMouseClick((v2, v3) -> {
                return afterInitialization$lambda$3$lambda$2(r1, r2, v2, v3);
            }), (UIComponent) this);
        }
    }

    private static final Unit afterInitialization$lambda$3$lambda$2(TabContainer $tab, TabGroup this$0, UIComponent $this$onMouseClick, UIClickEvent it) {
        Intrinsics.checkNotNullParameter($this$onMouseClick, "$this$onMouseClick");
        Intrinsics.checkNotNullParameter(it, "it");
        String name = $tab.getName();
        TabContainer tabContainer = this$0.currentTab;
        if (!Intrinsics.areEqual(name, tabContainer != null ? tabContainer.getName() : null)) {
            this$0.selectTab($tab.getName());
        }
        return Unit.INSTANCE;
    }

    public final void selectTab(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        Iterable $this$first$iv = this.tabs;
        for (Object element$iv : $this$first$iv) {
            TabContainer it = (TabContainer) element$iv;
            if (Intrinsics.areEqual(it.getName(), name)) {
                UIComponent uIComponent = (TabContainer) element$iv;
                closeContext(true);
                TabContainer tabContainer = this.currentTab;
                if (tabContainer != null) {
                    tabContainer.deselect();
                }
                UIComponent uIComponent2 = this.currentTab;
                if (uIComponent2 != null) {
                    UIComponent.hide$default(uIComponent2, false, 1, (Object) null);
                }
                UIComponent.unhide$default(uIComponent, false, 1, (Object) null);
                this.currentTab = uIComponent;
                return;
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    @Override // net.mcskill.shop.client.screen.component.Context
    public void closeContext(boolean instantly) {
        TabContainer tabContainer = this.currentTab;
        if (tabContainer != null) {
            tabContainer.closeContext(instantly);
        }
    }
}
