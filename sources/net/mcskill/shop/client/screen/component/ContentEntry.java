package net.mcskill.shop.client.screen.component;

import gg.essential.elementa.UIComponent;
import gg.essential.elementa.constraints.ColorConstraint;
import gg.essential.elementa.constraints.RadiusConstraint;
import gg.essential.elementa.state.BasicState;
import gg.essential.elementa.state.ExtensionsKt;
import gg.essential.elementa.state.State;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.mcskill.core.client.screen.MSPalette;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ContentEntry.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/component/ContentEntry.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0013\b&\u0018\u00002\u00020\u0001B'\b\u0007\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0004\b\u0007\u0010\bB\u001b\b\u0017\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\u000bR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR$\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00048F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\n\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00068G@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lnet/mcskill/shop/client/screen/component/ContentEntry;", "Lgg/essential/elementa/UIComponent;", "titleState", "Lgg/essential/elementa/state/State;", "", "radiusState", "", "<init>", "(Lgg/essential/elementa/state/State;Lgg/essential/elementa/state/State;)V", "name", "radius", "(Ljava/lang/String;F)V", "getTitleState", "()Lgg/essential/elementa/state/State;", "getRadiusState", "value", "title", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "getRadiusStated", "()F", "setRadius", "(F)V", "MSShop"})
public abstract class ContentEntry extends UIComponent {

    @NotNull
    private final State<String> titleState;

    @NotNull
    private final State<Float> radiusState;

    public /* synthetic */ ContentEntry(State state, State state2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((State<String>) state, (State<Float>) ((i & 2) != 0 ? (State) new BasicState(Float.valueOf(9.0f)) : state2));
    }

    @NotNull
    public final State<String> getTitleState() {
        return this.titleState;
    }

    @NotNull
    public final State<Float> getRadiusState() {
        return this.radiusState;
    }

    @JvmOverloads
    public ContentEntry(@NotNull State<String> state, @NotNull State<Float> state2) {
        Intrinsics.checkNotNullParameter(state, "titleState");
        Intrinsics.checkNotNullParameter(state2, "radiusState");
        this.titleState = state;
        this.radiusState = state2;
        setRadius((RadiusConstraint) ExtensionsKt.dp$default(this.radiusState, false, false, 3, (Object) null));
        setColor((ColorConstraint) ExtensionsKt.toConstraint(MSPalette.INSTANCE.getSidebar()));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ContentEntry(@NotNull State<String> state) {
        this(state, (State) null, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(state, "titleState");
    }

    @NotNull
    public final String getTitle() {
        return (String) this.titleState.get();
    }

    public final void setTitle(@NotNull String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.titleState.set(value);
    }

    @JvmName(name = "getRadiusStated")
    public final float getRadiusStated() {
        return ((Number) this.radiusState.get()).floatValue();
    }

    public final void setRadius(float value) {
        this.radiusState.set(Float.valueOf(value));
    }

    public /* synthetic */ ContentEntry(String str, float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? 9.0f : f);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ContentEntry(@NotNull String name, float radius) {
        this((State<String>) new BasicState(name), (State<Float>) new BasicState(Float.valueOf(radius)));
        Intrinsics.checkNotNullParameter(name, "name");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ContentEntry(@NotNull String name) {
        this(name, 0.0f, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(name, "name");
    }
}
